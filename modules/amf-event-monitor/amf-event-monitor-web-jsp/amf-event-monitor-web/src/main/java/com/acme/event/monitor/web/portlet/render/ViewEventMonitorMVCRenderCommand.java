package com.acme.event.monitor.web.portlet.render;

import com.acme.event.monitor.constants.EventMonitorPortletKeys;
import com.acme.event.monitor.service.EventLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + EventMonitorPortletKeys.EVENT_MONITOR,
		"mvc.command.name=/",
		"mvc.command.name=" + EventMonitorPortletKeys.EVENT_MONITOR_MVC_COMMAND_NAME
	},
	service = MVCRenderCommand.class
)
public class ViewEventMonitorMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		_addEventMonitorListAttributes(renderRequest);

		//        renderRequest.setAttribute(
		//                "eventPermission", _eventMonitorPermission);

		return "/eventMonitor.jsp";
	}

	@Reference
	protected EventLocalService eventLocalService;

	//    @Reference
	//    protected EventMonitorPermission _eventMonitorPermission;

	private void _addEventMonitorListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute(
			"permissionChecker", themeDisplay.getPermissionChecker());

		//		List<Event> events = _eventLocalService.getEvents(0, EventLocalServiceUtil.getEventsCount());
		//
		//		renderRequest.setAttribute("events", events);
	}

	@Reference
	private Portal _portal;

}