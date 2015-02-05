package net.izfe.liferay.agenda.portlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.FacetedSearcher;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.ScopeFacet;
import com.liferay.portal.kernel.search.facet.config.FacetConfiguration;
import com.liferay.portal.kernel.search.facet.config.FacetConfigurationUtil;
import com.liferay.portal.kernel.search.facet.util.FacetFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AgendaPortlet
 */
public class AgendaPortlet extends MVCPortlet {

	Log _log = LogFactoryUtil.getLog(this.getClass());
	ThemeDisplay themeDisplay;
	
	public static final int DEFAULT_DELTA = 10;
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences portletPreferences =renderRequest.getPreferences();
		long selectedStructure = GetterUtil.getLong(portletPreferences.getValue("selectedStructure", "0"));
		String eventDateFieldName = portletPreferences.getValue("eventDateFieldName", "");
		if(selectedStructure==0 || eventDateFieldName.equals("")){
			//SessionErrors.add(renderRequest, "no-conf");
			viewTemplate="/html/agenda/edit.jsp";
			return;
		}
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
		
		String searchConfiguration =  defaultFacetConfig();
		Integer deltaPref = Integer.parseInt(portletPreferences.getValue("delta", String.valueOf(DEFAULT_DELTA)));
		
		//Search String
		String searchString = composeSearchString(selectedStructure, eventDateFieldName, themeDisplay.getLocale());
		_log.debug("Search String : " + searchString);
		searchContext.setKeywords(searchString);
		
		//Sort
		searchContext.setSorts(composeSort(selectedStructure, eventDateFieldName, themeDisplay.getLocale()));
		
		int page = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, deltaPref);
		
		searchContext.setStart(delta * (page-1));
		searchContext.setEnd(delta * (page));
		
		Facet scopeFacet = new ScopeFacet(searchContext);
		scopeFacet.setStatic(true);
		searchContext.addFacet(scopeFacet);
		
		List<FacetConfiguration> facetConfigurations = FacetConfigurationUtil.load(searchConfiguration);
		for (FacetConfiguration facetConfiguration : facetConfigurations) {
			Facet facet;
			try {
				facet = FacetFactoryUtil.create(searchContext, facetConfiguration);
				searchContext.addFacet(facet);
			} catch (Exception e) {
				_log.error("Error creating facet", e);
			}
		}
		
		try {
			Indexer indexer = FacetedSearcher.getInstance();
			
			Hits hits = indexer.search(searchContext);
			renderRequest.setAttribute("hits", hits);
			_log.debug("Hits: " + hits.getLength());
			
		} catch (SearchException e) {
			_log.error("Error performing search.", e);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	private String defaultFacetConfig(){
		StringBundler sb = new StringBundler(6);

		sb.append("{facets: [");
		sb.append("{ displayStyle: 'asset_entries', static: false, weight: 1.5, order: 'OrderValueAsc', data: { values: ['com.liferay.portlet.journal.model.JournalArticle'], frequencyThreshold: 0 }, className: 'com.liferay.portal.kernel.search.facet.AssetEntriesFacet', label: 'asset-type', fieldName: 'entryClassName'},");
		sb.append("]}");
		return  sb.toString();
	}
	
	private Sort composeSort(long structureId, String eventDateFieldName, Locale locale){
		
		return new Sort("ddm/" + structureId + "/" + eventDateFieldName +  "_" + locale.toString(), Sort.STRING_TYPE,  false);
		
	}
	
	private String composeSearchString(long structureId, String eventDateFieldName, Locale locale){
		return "+( +(ddm/" + structureId + "/" + eventDateFieldName +  "_" + locale.toString() + ":[" + getTodayString() + " TO " + getFarFutureString() + "]) +(classTypeId:" + structureId + "))";
	}
	
	private String getTodayString(){
		Date now = new Date();
		Calendar gc = new GregorianCalendar();
		gc.setTime(now);
		return String.valueOf(gc.get(Calendar.YEAR)) + String.format("%02d",gc.get(Calendar.MONTH) +1) + String.format("%02d",gc.get(Calendar.DAY_OF_MONTH)) + "000000";
	}
	
	private String getFarFutureString(){
		Date now = new Date();
		Calendar gc = new GregorianCalendar();
		gc.setTime(now);
		gc.add(Calendar.YEAR, 100);
		return String.valueOf(gc.get(Calendar.YEAR)) + String.format("%02d",gc.get(Calendar.MONTH) +1) + String.format("%02d",gc.get(Calendar.DAY_OF_MONTH)) + "000000";
	}

}
