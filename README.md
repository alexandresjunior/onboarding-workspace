# Onboarding Workspace
Workspace with sample solutions for training purposes using Liferay DXP 7.4

## Custom Registration Portlet using JSP files
```
modules
├── amf-registration
│ ├── amf-registration-api
│ ├── amf-registration-service
│ ├── amf-registration-web
```
* Create `*-api` and `*-service` modules using `service-builder` template;
* Define entities in `service.xml`;
* Run `blade gw buildService` in `/amf-registration-service` directory to generate models and classes;
* Implement logic in `*LocalServiceImpl` and `*ServiceImpl` classes;
* Define backend validation and exceptions, if needed;
* Create `*-web module` module using `mvc-portlet` template;

## Custom Registration Portlet using REST API and React JS
```
modules
├── amf-registration
│ ├── amf-registration-api
│ ├── amf-registration-service
│ ├── amf-registration-web-rest
│ ├── amf-registration-web-js
```
* Create `*-api` and `*-service` modules using `service-builder` template;
* Define entities in `service.xml`;
* Run `blade gw buildService` in `/amf-registration-service` directory to generate models and classes;
* Implement logic in `*LocalServiceImpl` and `*ServiceImpl` classes;
* Define backend validation and exceptions, if needed;
* Create `*-web-rest` module to expose endpoints which will be called by FE layer;
* Run `npm install -g yo generator-liferay-js` to install the Liferay JS Generator;
* Then, run `yo liferay-js` to generate a React based portlet bundle project.

## References
* [Introduction to Portlets](https://help.liferay.com/hc/en-us/articles/360018159431-Introduction-to-Portlets)
* [Introduction to Service Builder](https://help.liferay.com/hc/en-us/articles/360017881932-Introduction-to-Service-Builder-)
* [Using the AlloyUI Validator Tag](https://help.liferay.com/hc/en-us/articles/360018179851-Using-the-AlloyUI-Validator-Tag#available-validation-rules)
* [Using Resources and Permissions](https://help.liferay.com/hc/en-us/articles/360034199332-Using-Resources-and-Permissions) 
* [Developing a React Application](https://help.liferay.com/hc/en-us/articles/360029028051-Developing-a-React-Application)