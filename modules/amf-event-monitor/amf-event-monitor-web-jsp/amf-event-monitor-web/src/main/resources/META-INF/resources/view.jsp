<%@ include file="/init.jsp" %>

<div class="container-fluid-1280 pl-4 pr-4">
	<liferay-ui:tabs
			names="All,Registration,Login"
			param="tabs"
			refresh="<%= false %>"
	>
		<liferay-ui:section>

			<%
				List<Event> allEvents0 = EventLocalServiceUtil.getEvents(0, EventLocalServiceUtil.getEventsCount());
				List<Event> events0 = new ArrayList<>();
				for (int i = 0; i < allEvents0.size(); i++) {
					Event event = allEvents0.get(i);
					if (EventMonitorModelPermission.contains(themeDisplay.getPermissionChecker(), event.getEventId(), EventMonitorConstants.VIEW_ALL_EVENTS) || (event.getUserId() == user.getUserId())) {
						events0.add(event);
					}
				}
			%>

			<liferay-ui:search-container
					emptyResultsMessage="there-are-no-events"
					total="<%= events0.size() %>"
			>
				<liferay-ui:search-container-results
						results="<%= events0 %>"
				/>

				<liferay-ui:search-container-row
						className="com.acme.event.monitor.model.Event"
						modelVar="event"
				>

					<%
						User user2 = UserLocalServiceUtil.getUserById(event.getUserId());
						String screenName = user2.getScreenName();
					%>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getDateTime()) %>"
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value='<%= screenName + " (" + event.getUserId() + ")" %>'
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getIpAddress()) %>"
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getEventType()) %>"
					/>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</liferay-ui:section>

		<liferay-ui:section>

			<%
				List<Event> allEvents1 = EventLocalServiceUtil.getEventsByType("Registration");
				List<Event> events1 = new ArrayList<>();
				for (int i = 0; i < allEvents1.size(); i++) {
					Event event = allEvents1.get(i);
					if (EventMonitorModelPermission.contains(themeDisplay.getPermissionChecker(), event.getEventId(), EventMonitorConstants.VIEW_ALL_EVENTS) || (event.getUserId() == user.getUserId())) {
						events1.add(event);
					}
				}
			%>

			<liferay-ui:search-container
					emptyResultsMessage="there-are-no-events"
					total="<%= events1.size() %>"
			>
				<liferay-ui:search-container-results
						results="<%= events1 %>"
				/>

				<liferay-ui:search-container-row
						className="com.acme.event.monitor.model.Event"
						modelVar="event"
				>

					<%
						User user2 = UserLocalServiceUtil.getUserById(event.getUserId());
						String screenName = user2.getScreenName();
					%>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getDateTime()) %>"
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value='<%= screenName + " (" + event.getUserId() + ")" %>'
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getIpAddress()) %>"
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getEventType()) %>"
					/>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</liferay-ui:section>

		<liferay-ui:section>

			<%
				List<Event> allEvents2 = EventLocalServiceUtil.getEventsByType("Login");
				List<Event> events2 = new ArrayList<>();
				for (int i = 0; i < allEvents2.size(); i++) {
					Event event = allEvents2.get(i);
					if (EventMonitorModelPermission.contains(themeDisplay.getPermissionChecker(), event.getEventId(), EventMonitorConstants.VIEW_ALL_EVENTS) || (event.getUserId() == user.getUserId())) {
						events2.add(event);
					}
				}
			%>

			<liferay-ui:search-container
					emptyResultsMessage="there-are-no-events"
					total="<%= events2.size() %>"
			>
				<liferay-ui:search-container-results
						results="<%= events2 %>"
				/>

				<liferay-ui:search-container-row
						className="com.acme.event.monitor.model.Event"
						modelVar="event"
				>

					<%
						User user2 = UserLocalServiceUtil.getUserById(event.getUserId());
						String screenName = user2.getScreenName();
					%>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getDateTime()) %>"
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value='<%= screenName + " (" + event.getUserId() + ")" %>'
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getIpAddress()) %>"
					/>

					<liferay-ui:search-container-column-text
							cssClass="table-cell-expand table-cell-minw-200 table-title"
							orderable="<%= false %>"
							value="<%= HtmlUtil.escape(event.getEventType()) %>"
					/>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</liferay-ui:section>
	</liferay-ui:tabs>
</div>