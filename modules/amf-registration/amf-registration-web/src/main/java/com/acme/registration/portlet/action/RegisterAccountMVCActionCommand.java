package com.acme.registration.portlet.action;

import com.acme.registration.constants.RegistrationPortletKeys;
import com.acme.registration.exception.RegistrationException;
import com.acme.registration.model.Account;
import com.acme.registration.service.AccountLocalService;
import com.acme.registration.validation.RegistrationValidation;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
		"mvc.command.name=" + RegistrationPortletKeys.REGISTRATION_MVC_COMMAND_NAME
	},
	service = MVCActionCommand.class
)
public class RegisterAccountMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Account.class.getName(), actionRequest);

		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String email = ParamUtil.getString(actionRequest, "emailAddress");
		String userName = ParamUtil.getString(actionRequest, "userName");
		String genre = ParamUtil.getString(actionRequest, "genre");
		Date birthday = new SimpleDateFormat(
			"yyyy-mm-dd"
		).parse(
			ParamUtil.getString(actionRequest, "birthday")
		);
		String password = ParamUtil.getString(actionRequest, "password");
		String confirmPassword = ParamUtil.getString(
			actionRequest, "confirmPassword");
		String homePhone = ParamUtil.getString(actionRequest, "homePhone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String zipCode = ParamUtil.getString(actionRequest, "zipCode");
		String securityQuestion = ParamUtil.getString(
			actionRequest, "securityQuestion");
		String answer = ParamUtil.getString(actionRequest, "answer");
		boolean termsOfUse = ParamUtil.getBoolean(actionRequest, "termsOfUse");

		try {
			if (_areRegistrationInputsValid(
					firstName, lastName, email, userName, birthday, password,
					confirmPassword, homePhone, mobilePhone, address1, address2,
					city, zipCode, answer, termsOfUse)) {

				User user = _createLiferayUser(
					firstName, lastName, email, userName, genre, birthday,
					password, confirmPassword, termsOfUse, serviceContext);

				_createAccount(
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
					user.getUserId(), firstName, lastName, email, userName,
					genre, birthday, password, confirmPassword, homePhone,
					mobilePhone, address1, address2, city, state, zipCode,
					securityQuestion, answer, termsOfUse);
			}
		}
		catch (RegistrationException registrationException) {
			_log.info(
				"RegistrationException: " + registrationException.getMessage());
			SessionErrors.add(
				actionRequest, registrationException.getMessage());
		}

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		sendRedirect(actionRequest, actionResponse, redirect);
	}

	private boolean _areRegistrationInputsValid(
			String firstName, String lastName, String email, String userName,
			Date birthday, String password, String confirmPassword,
			String homePhone, String mobilePhone, String address1,
			String address2, String city, String zipCode, String answer,
			boolean termsOfUse)
		throws RegistrationException {

		return RegistrationValidation.isFirstOrLastNameValid(firstName) &&
			   RegistrationValidation.isFirstOrLastNameValid(lastName) &&
			   RegistrationValidation.isEmailAddressValid(email) &&
			   RegistrationValidation.isUserNameValid(userName) &&
			   RegistrationValidation.isAtLeastThirtheenYearsOld(birthday) &&
			   RegistrationValidation.isPasswordValid(password) &&
			   RegistrationValidation.doPasswordMatch(
				   password, confirmPassword) &&
			   RegistrationValidation.isPhoneNumberValid(homePhone) &&
			   RegistrationValidation.isPhoneNumberValid(mobilePhone) &&
			   RegistrationValidation.isAddressValid(address1) &&
			   RegistrationValidation.isAddressValid(address2) &&
			   RegistrationValidation.isCityValid(city) &&
			   RegistrationValidation.isZipCodeValid(zipCode) &&
			   RegistrationValidation.isAnswerValid(answer) &&
			   RegistrationValidation.isTermsOfUseChecked(termsOfUse);
	}

	private Account _createAccount(
		long companyId, long groupId, long userId, String firstName,
		String lastName, String email, String userName, String genre,
		Date birthday, String password, String confirmPassword,
		String homePhone, String mobilePhone, String address1, String address2,
		String city, String state, String zipCode, String securityQuestion,
		String answer, boolean termsOfUse) {

		Account account = _accountLocalService.createAccount(
			_counterLocalService.increment());

		account.setCompanyId(companyId);
		account.setGroupId(groupId);
		account.setUserId(userId);

		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setEmailAddress(email);
		account.setUserName(userName);
		account.setGenre(genre);
		account.setBirthday(birthday);
		account.setPassword(password);
		account.setConfirmPassword(confirmPassword);

		account.setHomePhone(homePhone);
		account.setMobilePhone(mobilePhone);

		account.setAddress1(address1);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(state);
		account.setZipCode(zipCode);

		account.setSecurityQuestion(securityQuestion);
		account.setAnswer(answer);

		account.setTermsOfUse(termsOfUse);

		_accountLocalService.updateAccount(account);

		return account;
	}

	private User _createLiferayUser(
			String firstName, String lastName, String email, String userName,
			String genre, Date birthday, String password,
			String confirmPassword, boolean termsOfUse,
			ServiceContext serviceContext)
		throws PortalException {

		User liferayUser = _userLocalService.addUser(
				_userLocalService.getDefaultUserId(_portal.getDefaultCompanyId()), // creatorUserId
				_portal.getDefaultCompanyId(), // companyId
				false, // autoPassword
				password, // password1
				confirmPassword, // password2
				false, // autoScreenName
				userName, // screenName
				email, // emailAddress
				LocaleUtil.getDefault(), // locale
				firstName, // firstName
				null, // middleName
				lastName, // lastName
				0, // prefixId
				0, // suffixId
				genre.equalsIgnoreCase("male"), // male
				birthday.getMonth(), // birthdayMonth
				birthday.getDay(), // birthdayDay
				birthday.getYear(), // birthdayYear
				null, // jobTitle
				null, // groupIds
				null, // organizationIds
				null, // roleIds
				null, // userGroupIds
				false, // sendEmail
				serviceContext); // serviceContext

		liferayUser.setAgreedToTermsOfUse(termsOfUse);

		_userLocalService.updateUser(liferayUser);

		Role userRole = _roleLocalService.fetchRole(
			_portal.getDefaultCompanyId(), "User");

		_roleLocalService.addUserRole(liferayUser.getUserId(), userRole);

		return liferayUser;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		RegisterAccountMVCActionCommand.class);

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserLocalService _userLocalService;

}