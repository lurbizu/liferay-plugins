<%@page import="java.util.HashMap"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@include file="/html/init.jsp"%>

<%
	
	String keywords = ParamUtil
			.getString(renderRequest, "keywords", "");
	Hits hits = (Hits) renderRequest.getAttribute("hits");
	
	String assetLinkBehavior = portletPreferences.getValue("assetLinkBehavior", "");
	String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", StringPool.BLANK));
	long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), scopeGroupId);
	long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, displayStyle);
	
	Map<String, Object> contextObjects = new HashMap<String, Object>();
	contextObjects.put("assetLinkBehavior", assetLinkBehavior);
%>

<%if (hits != null) {
	if(portletDisplayDDMTemplateId > 0){
		
		List<AssetEntry> results = new ArrayList<AssetEntry>();
		for (Document document : hits.getDocs()) {
			String className = GetterUtil.getString(
				document.get(Field.ENTRY_CLASS_NAME));
			long classPK = GetterUtil.getLong(
			document.get(Field.ENTRY_CLASS_PK));
			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
					className, classPK);
		
				results.add(assetEntry);
			}
			catch (Exception e) {
			}
		}
	%>
        <%= PortletDisplayTemplateUtil.renderDDMTemplate(pageContext, portletDisplayDDMTemplateId, results, contextObjects) %>
	<%}else{ %>
		<liferay-ui:search-container>
			<liferay-ui:search-container-results results="<%=hits.toList()%>"
				total="<%=hits.getLength()%>" />
				<liferay-ui:search-container-row
					className="com.liferay.portal.kernel.search.Document"
					escapedModel="<%= false %>"
					keyProperty="UID"
					modelVar="document"
					stringKey="<%= true %>">
		
					<div class="item_resultado">
				
					<%
					String entryClassName = document.get(Field.ENTRY_CLASS_NAME);
					String entryClassPK = document.get(Field.ENTRY_CLASS_PK);
					JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getJournalArticleResource(Long.valueOf(entryClassPK));
					JournalArticle article = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), articleResource.getArticleId());
					%>
					<%=JournalArticleLocalServiceUtil
										.getArticleContent(
												themeDisplay.getScopeGroupId(),
												article.getArticleId(), "view",
												themeDisplay.getLocale().toString(),
												themeDisplay)%>
		
				</div>
		
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	<%}%>
<%}%>
