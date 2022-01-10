<%@ include file="/init.jsp" %>
<%@include file="error.jsp"%>


<portlet:actionURL name="<%= RegistrationPortletKeys.REGISTRATION_MVC_COMMAND_NAME %>" var="registerAccountURL">
	<portlet:param name="redirect" value="/home"/>
</portlet:actionURL>

<%
	String sessionId = ParamUtil.getString(request, "sessionId");
%>
<div class="container-fluid-1280">
	<c:choose>
		<c:when test="<%= sessionId != null %>">
			<aui:row>
				<h1>
					<b><liferay-ui:message key="amf.registration.logged.user"/></b>
				</h1>
			</aui:row>
		</c:when>
		<c:otherwise>
			<aui:row>
				<h1>
					<b><liferay-ui:message key="amf.registration.caption"/></b>
				</h1>
			</aui:row>

			<aui:form action="<%= registerAccountURL %>" method="post" name="fm">
				<aui:input name="accountId" field="accountId" type="hidden"/>
				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="Basic Info">
						<aui:row>
							<aui:col width="50">
								<aui:input name="firstName" type="text" required="true">
									<aui:validator name="alphanum" errorMessage="error.field-first-name-alphanum"/>
									<aui:validator name="maxLength" errorMessage="error.field-first-name-length">50</aui:validator>
								</aui:input>
							</aui:col>
							<aui:col width="50">
								<aui:input name="lastName" type="text" required="true">
									<aui:validator name="alphanum" errorMessage="error.field-last-name-alphanum"/>
									<aui:validator name="maxLength" errorMessage="error.field-last-name-length">50</aui:validator>
								</aui:input>
							</aui:col>
						</aui:row>

						<aui:row>
							<aui:col width="50">
								<aui:input name="emailAddress" type="email" required="true">
									<aui:validator name="email" errorMessage="error.field-email-alphanum"/>
									<aui:validator name="maxLength" errorMessage="error.field-email-length">255</aui:validator>
								</aui:input>
							</aui:col>
							<aui:col width="50">
								<aui:input name="userName" type="text" required="true">
									<aui:validator name="alphanum" errorMessage="error.field-user-name-alphanum"/>
									<aui:validator name="minLength" errorMessage="error.field-user-name-minLength">4</aui:validator>
									<aui:validator name="maxLength" errorMessage="error.field-user-name-maxLength">16</aui:validator>
									<aui:validator name="custom" errorMessage="error.field-duplicate-username"/>
								</aui:input>
							</aui:col>
						</aui:row>

						<aui:row>
							<aui:col width="50">
								<aui:select name="genre" label="Genre" required="true">
									<aui:option value="male">Male</aui:option>
									<aui:option value="female">Female</aui:option>
								</aui:select>
							</aui:col>
							<aui:col width="50">
								<aui:input name="birthday" type="date" required="true">
									<aui:validator name="date" errorMessage="error.field-birth-date"/>
								</aui:input>
							</aui:col>
						</aui:row>

						<aui:row>
							<aui:col width="50">
								<aui:input name="password" type="password">
									<aui:validator name="required" errorMessage="error.field-password"/>
									<aui:validator name="minLength" errorMessage="error.field-password">6</aui:validator>
								</aui:input>
							</aui:col>
							<aui:col width="50">
								<aui:input name="confirmPassword" type="password">
									<aui:validator name="required" errorMessage="error.field-password-confirmation"/>
								</aui:input>
							</aui:col>
						</aui:row>
					</aui:fieldset>
				</aui:fieldset-group>

				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="Phone">
						<aui:row>
							<aui:col width="50">
								<aui:input name="homePhone" type="tel" required="false">
									<aui:validator name="digits" errorMessage="error.field-phone"/>
									<aui:validator name="minLength" errorMessage="error.field-phone">10</aui:validator>
									<aui:validator name="maxLength" errorMessage="error.field-phone">10</aui:validator>
								</aui:input>
							</aui:col>
							<aui:col width="50">
								<aui:input name="mobilePhone" type="tel" required="false">
									<aui:validator name="digits" errorMessage="error.field-phone"/>
									<aui:validator name="minLength" errorMessage="error.field-phone">10</aui:validator>
									<aui:validator name="maxLength" errorMessage="error.field-phone">10</aui:validator>
								</aui:input>
							</aui:col>
						</aui:row>
					</aui:fieldset>
				</aui:fieldset-group>

				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="Billing Address">
						<aui:row>
							<aui:col width="50">
								<aui:input name="address1" type="text" required="true">
									<aui:validator name="alphanum" errorMessage="error.field-address-alphanum"/>
									<aui:validator name="maxLength" errorMessage="error.field-address-length">255</aui:validator>
								</aui:input>
							</aui:col>
							<aui:col width="50">
								<aui:input name="address2" type="text" required="false">
									<aui:validator name="alphanum" errorMessage="error.field-address-alphanum"/>
									<aui:validator name="maxLength" errorMessage="error.field-address-length">255</aui:validator>
								</aui:input>
							</aui:col>
						</aui:row>

						<aui:row>
							<aui:col span="4">
								<aui:input name="city" type="text" required="true">
									<aui:validator name="alphanum" errorMessage="error.field-city-alphanum"/>
									<aui:validator name="maxLength" errorMessage="error.field-city-length">255</aui:validator>
								</aui:input>
							</aui:col>
							<aui:col span="4">
								<aui:select label="State:" name="state" required="false" onclick="choice(event)" />
							</aui:col>
							<aui:col span="4">
								<aui:input name="zipCode" type="text" label="Zip Code" required="true">
									<aui:validator name="digits" errorMessage="error.field-zipCode"/>
									<aui:validator name="minLength" errorMessage="error.field-zipCode">5</aui:validator>
									<aui:validator name="maxLength" errorMessage="error.field-zipCode">5</aui:validator>
								</aui:input>
							</aui:col>
						</aui:row>
					</aui:fieldset>
				</aui:fieldset-group>

				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="Misc.">
						<aui:row>
							<aui:col width="100">
								<aui:select name="securityQuestion" label="Security Question" required="true">
									<aui:option value="What is your mother's maiden name?"
												label="What is your mother's maiden name?"/>
									<aui:option value="What is the make of your first car?"
												label="What is the make of your first car?"/>
									<aui:option value="What is your high school mascot?"
												label="What is your high school mascot?"/>
									<aui:option value="Who is your favorite actor?"
												label="Who is your favorite actor?"/>
								</aui:select>
							</aui:col>
						</aui:row>

						<aui:row>
							<aui:col width="100">
								<aui:input name="answer" type="text" required="true">
									<aui:validator name="alphanum" errorMessage="error.field-answer-alphanum"/>
									<aui:validator name="maxLength" errorMessage="error.field-answer-length">255</aui:validator>
								</aui:input>
							</aui:col>
						</aui:row>
					</aui:fieldset>
				</aui:fieldset-group>

				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="Terms of Use">
						<aui:input name="termsOfUse"
								   label="amf.registration.terms-of-use"
								   type="checkbox"
								   required="true"/>
					</aui:fieldset>
					<aui:fieldset label="Read Terms of Use">
							<aui:button onclick="modal()" value="Read Terms of Use" />
					</aui:fieldset>
				</aui:fieldset-group>

				<portlet:renderURL var="homeURL">
					<portlet:param name="mvcPath" value="/home.jsp"/>
				</portlet:renderURL>

				<aui:button-row>
					<aui:button cssClass="btn-lg" name="saveButton" primary="true" type="submit" value="Register" />
					<aui:button cssClass="btn-lg" href="#" name="cancelButton" type="cancel" value="Cancel" onClick="<%=homeURL.toString()%>"/>
				</aui:button-row>
			</aui:form>
		</c:otherwise>
	</c:choose>

	<%@ include file="/META-INF/resources/touContent.jsp" %>
	<aui:script>
		var touContent = document.getElementById("tou-content").innerHTML;
		function modal () {
		Liferay.Util.openModal(
		{
		title:"Terms of Use", bodyHTML: touContent
		}); }
	</aui:script>

	<!--State script-->
	<aui:script use="liferay-dynamic-select">
		new Liferay.DynamicSelect(
		[
		{
		select: '<portlet:namespace />country',
		selectData: Liferay.Address.getCountries,
		selectDesc: 'a3',
		selectId: 'countryId',
		selectVal: '21531'
		},
		{
		select: '<portlet:namespace />state',
		selectData: Liferay.Address.getRegions,
		selectDesc: 'name',
		selectId: 'name',
		selectVal: '&lt; regionId &gt;'
		}
		]
		);
	</aui:script>

	<!--State Change script-->
	<aui:script>
		const choice = (event) => {
		if (event.target.value === "0") {
		alert("Please select some state!");
		}
		}
	</aui:script>
</div>