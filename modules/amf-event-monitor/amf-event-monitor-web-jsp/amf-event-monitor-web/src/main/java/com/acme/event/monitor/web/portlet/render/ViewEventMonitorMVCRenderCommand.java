package com.acme.event.monitor.web.portlet.render;

import com.acme.event.monitor.service.EventLocalService;
import com.acme.event.monitor.web.constants.EventMonitorPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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

        addEventMonitorListAttributes(renderRequest);

//        renderRequest.setAttribute(
//                "eventPermission", _eventMonitorPermission);

        return "/eventMonitor.jsp";
    }

    private void addEventMonitorListAttributes(RenderRequest renderRequest) {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        PermissionChecker permissionChecker =
                themeDisplay.getPermissionChecker();

        renderRequest.setAttribute("permissionChecker", permissionChecker);

//		List<Event> events = _eventLocalService.getEvents(0, EventLocalServiceUtil.getEventsCount());
//
//		renderRequest.setAttribute("events", events);
    }

//    @Reference
//    protected EventMonitorPermission _eventMonitorPermission;

    @Reference
    protected EventLocalService _eventLocalService;

    @Reference
    private Portal _portal;

}
