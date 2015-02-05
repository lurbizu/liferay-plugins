<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.template.TemplateHandler"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>
<%@include file="/html/init.jsp"%>

<%
List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getStructureEntries(themeDisplay.getScopeGroupId());
long selectedStructure = GetterUtil.getLong(portletPreferences.getValue("selectedStructure", "0"));
String eventDateFieldName = portletPreferences.getValue("eventDateFieldName", "");
String eventListTitle= portletPreferences.getValue("eventListTitle", "");
int delta = GetterUtil.getInteger(portletPreferences.getValue("delta", ""), AgendaPortlet.DEFAULT_DELTA);
String assetLinkBehavior = portletPreferences.getValue("assetLinkBehavior", "");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD %>" type="hidden" value="<%=Constants.UPDATE %>" />
	
	<aui:select name="preferences--selectedStructure--">
		<aui:option></aui:option>
		<%for(DDMStructure ddmStructure : ddmStructures){ %>
			<aui:option value="<%=ddmStructure.getStructureId() %>" selected="<%=selectedStructure==ddmStructure.getStructureId()%>">
				<%=ddmStructure.getName(themeDisplay.getLocale()) %>
			</aui:option>
		<%} %>
	</aui:select>
	
	<aui:input name="preferences--eventDateFieldName--" value="<%=eventDateFieldName%>"/>	
	
	<aui:input helpMessage="number-of-items-to-display-help" label="number-of-items-to-display" name="preferences--delta--" type="text" value="<%=delta%>">
		<aui:validator name="digits" />
	</aui:input>
	
	<aui:select cssClass="hidden-field asset-link-behavior" name="preferences--assetLinkBehavior--">
		<aui:option label="show-full-content" selected='<%= assetLinkBehavior.equals("showFullContent") %>' value="showFullContent" />
		<aui:option label="view-in-context" selected='<%= assetLinkBehavior.equals("viewInPortlet") %>' value="viewInPortlet" />
	</aui:select>

	<aui:fieldset>
        <div class="display-template">
            <%
            TemplateHandler templateHandler = TemplateHandlerRegistryUtil.getTemplateHandler(AssetEntry.class.getName());
            String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", ""));
            %>
            <liferay-ui:ddm-template-selector
                classNameId="<%= PortalUtil.getClassNameId(templateHandler.getClassName()) %>"
                displayStyle="<%= displayStyle %>"
                displayStyleGroupId="<%= themeDisplay.getScopeGroupId()%>"
                refreshURL="<%= PortalUtil.getCurrentURL(request) %>"
                showEmptyOption="<%= true %>"
            />
        </div>
    </aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

