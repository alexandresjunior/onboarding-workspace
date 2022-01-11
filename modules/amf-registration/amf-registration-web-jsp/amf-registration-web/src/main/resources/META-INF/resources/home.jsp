<%@ include file="/META-INF/resources/init.jsp" %>

<h1 class="title"><liferay-ui:message key="amf.registration.caption" /></h1>

<c:if test="<%=!themeDisplay.isSignedIn()%>">
    <portlet:renderURL var="addEntryURL">
        <portlet:param name="mvcPath" value="/view.jsp"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button onClick="<%= addEntryURL.toString() %>" value="Sign Up"/>
    </aui:button-row>
</c:if>
