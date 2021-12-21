<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.acme.event.monitor.web.internal.security.permission.resource.EventMonitorModelPermission" %>
<%@ page import="com.acme.event.monitor.web.internal.security.permission.resource.EventMonitorPermission" %>
<%@ page import="com.acme.event.monitor.model.Event" %>
<%@ page import="com.acme.event.monitor.constants.EventMonitorConstants" %>
<%@ page import="com.acme.event.monitor.service.EventLocalServiceUtil" %>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />