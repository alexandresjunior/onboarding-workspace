package com.acme.registration.validation;

import com.acme.registration.exception.RegistrationException;
import com.acme.registration.model.Account;
import com.acme.registration.service.AccountLocalServiceUtil;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexandre de Souza Jr.
 */
public class RegistrationValidation {

	public static boolean doPasswordMatch(
		String password, String confirmPassword) {

		return password.equals(confirmPassword);
	}

	public static boolean isAddressValid(String address)
		throws RegistrationException {

		if (!_isAlphanumeric(address)) {
			throw new RegistrationException("Address must be alphanumeric");
		}

		if (address.length() > 255) {
			throw new RegistrationException(
				"Address must have a maximum number of 255 characters");
		}

		return true;
	}

	public static boolean isAnswerValid(String answer)
		throws RegistrationException {

		if (!_isAlphanumeric(answer)) {
			throw new RegistrationException("Answer must be alphanumeric");
		}

		if (answer.length() > 255) {
			throw new RegistrationException(
				"Answer must have a maximum number of 255 characters");
		}

		return true;
	}

	public static boolean isAtLeastThirtheenYearsOld(Date birthday)
		throws RegistrationException {

		Date currentDate = new Date();

		if (birthday.after(currentDate)) {
			throw new RegistrationException(
				"Date of birth cannot be a future date");
		}

		int age = _calculateAge(birthday, currentDate);

		if (age < 13) {
			throw new RegistrationException(
				"You must be 13 years old or above");
		}

		return true;
	}

	public static boolean isCityValid(String city)
		throws RegistrationException {

		if (!_isAlphanumeric(city)) {
			throw new RegistrationException("City must be alphanumeric");
		}

		if (city.length() > 255) {
			throw new RegistrationException(
				"City must have a maximum number of 255 characters");
		}

		return true;
	}

	public static boolean isEmailAddressValid(String email)
		throws RegistrationException {

		Pattern pattern = Pattern.compile(REGEX_VALID_EMAIL_ADDRESS);

		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches()) {
			throw new RegistrationException("Email is not valid");
		}

		if (email.length() > 255) {
			throw new RegistrationException(
				"Email must have a maximum number of 255 characters");
		}

		return true;
	}

	public static boolean isFirstOrLastNameValid(String name)
		throws RegistrationException {

		if (!_isAlphanumeric(name)) {
			throw new RegistrationException("Name must be alphanumeric");
		}

		if (name.length() > 50) {
			throw new RegistrationException(
				"Name must have a maximum number of 50 characters");
		}

		return true;
	}

	public static boolean isPasswordValid(String password) {
		Pattern pattern = Pattern.compile(REGEX_PASSWORD);

		Matcher matcher = pattern.matcher(password);

		return matcher.matches();
	}

	public static boolean isPhoneNumberValid(String phone) {
		return phone.length() <= 10;
	}

	public static boolean isTermsOfUseChecked(boolean termsOfUse) {
		return termsOfUse;
	}

	public static boolean isUserNameValid(String userName)
		throws RegistrationException {

		if (!_isAlphanumeric(userName)) {
			throw new RegistrationException("Username must be alphanumeric");
		}

		if (userName.length() < 4) {
			throw new RegistrationException(
				"Username must have at least 4 characters");
		}

		if (userName.length() > 16) {
			throw new RegistrationException(
				"Username must have a maximum number of 16 characters");
		}

		Account account = AccountLocalServiceUtil.fetchAccountByUserName(
			userName);

		if (account != null) {
			throw new RegistrationException("This username already exists");
		}

		return true;
	}

	public static boolean isZipCodeValid(String zipCode) {
		return zipCode.length() == 5;
	}

	private static int _calculateAge(Date dateOfBirth, Date currentDate) {
		if ((dateOfBirth != null) && (currentDate != null)) {
			LocalDate birth = dateOfBirth.toInstant(
			).atZone(
				ZoneId.systemDefault()
			).toLocalDate();

			LocalDate current = currentDate.toInstant(
			).atZone(
				ZoneId.systemDefault()
			).toLocalDate();

			return Period.between(
				birth, current
			).getYears();
		}

		return 0;
	}

	private static boolean _isAlphanumeric(String name) {
		Pattern pattern = Pattern.compile(REGEX_ALPHANUMERIC);

		Matcher matcher = pattern.matcher(name);

		return matcher.matches();
	}

	private static final String REGEX_ALPHANUMERIC = "^[a-zA-Z0-9]+$";

	private static final String REGEX_PASSWORD =
		"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{6,}$";

	private static final String REGEX_VALID_EMAIL_ADDRESS =
		"^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

}