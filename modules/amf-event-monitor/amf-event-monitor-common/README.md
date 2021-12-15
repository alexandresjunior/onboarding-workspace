Registration Admin Monitor
===================
Summary
-------
Acme Movie Fanatics (AMF) is developing an online community using Liferay Portal for its members.  The second phase of this project is to provide Administrators a way to monitor user registration and login.

Objective
---------
Create a portlet that tracks *registration* and *login* information.  The portlet's content changes depending on the viewing user's permission.

Requirements
------------
### Assumptions
* User's screen name can't be updated as part of the company's policy.

### General Specification
* The portlet should track the following events (*but not limited to these*):
  * Login (regardless of sites)
  * Registration (regardless of sites)
* The following information should be recorded (and possibly *other* metadata):
  * Date-time - the date and time the event occurred
  * Event Type - registration, login, etc.
  * User - the user that performed the event
  * IP Address - the client IP address that generated the event. (Login event only)
    * for **Registration** events, simply use `0.0.0.0`
* The portlet should track events from **all** users.
* The portlet must track **all** login events as well as **all** registration events. (Note that new user creation anywhere in the portal is considered a form of registration to AMF).
* **Permission**: Create a new *model resource* permission that can be configured by admin.  This new permission will allow users that have it to see events from all users.  For users without this new permission, they will only see *their own events*.
* This portlet should **not** be a control panel portlet.

### UI
* Events should be listed with the latest (most recent) first.
* Currently, 3 options should be allowed:
  * View all events (both login and registration)
  * Show only login events.
  * Show only registration events.
    (*You may choose to use tabs, radio buttons, drop-down menu, or another way to allow users to select the desired option.*)
* Event listing should be paginated, with default items per page set to 20.
* The following information should be displayed:
  * Date-time: YYYY-MM-DD HH:MM:SS
  * User Info in the following format: `screenName (userId)`
  * IP Address
  * Event Type: `Registration` or `Login`

### Wireframe
![Figure 1](https://farm3.staticflickr.com/2818/9469225408_c0d9f52ba7_z.jpg)

### Non-Functional Requirements
* Module should following naming conventions found in training material and Liferay code base.
* Portlet must be named ```amf-event-monitor```.
* Module must work in Liferay DXP (preferably the latest SP).

###### Components and Features Used
`Service Builder`, `Finder`, `Portlet`, `Model Resource Permissions`, `Search Container`, `Pagination`, `PostLoginAction`, `Model Listener`