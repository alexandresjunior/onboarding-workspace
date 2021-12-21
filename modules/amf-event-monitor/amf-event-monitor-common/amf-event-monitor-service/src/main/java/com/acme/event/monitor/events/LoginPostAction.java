package com.acme.event.monitor.events;

import com.acme.event.monitor.service.EventService;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(
	immediate = true, property = "key=login.events.post",
	service = LifecycleAction.class
)
public class LoginPostAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		try {
			_eventService.addEvent(
				serviceContext.getScopeGroupId(), "Login", "0.0.0.0",
				serviceContext);
		}
		catch (PortalException portalException) {
			portalException.printStackTrace();
		}
	}

	@Reference
	private EventService _eventService;

}