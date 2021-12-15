create table AMF_Event (
	eventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventType VARCHAR(75) null,
	dateTime VARCHAR(75) null,
	ipAddress VARCHAR(75) null
);