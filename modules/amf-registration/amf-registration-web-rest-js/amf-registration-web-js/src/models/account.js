import { accountExists } from "../services/accountExists";

const REGEX_NUMERIC = /^\d+$/;
const REGEX_ALPHANUMERIC = /^[0-9a-zA-Z]+$/;
const REGEX_VALID_EMAIL_ADDRESS = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
const REGEX_PASSWORD = /^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{6,}$/;

function validateFirstName(firstName) {
    if (!firstName.value.match(REGEX_ALPHANUMERIC)) {
        return { isValid: false, text: Liferay.Language.get('error.field-first-name-alphanum') };
    } else if (firstName.length >= 50) {
        return { isValid: false, text: Liferay.Language.get('error.field-first-name-length') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateLastName(lastName) {
    if (!lastName.value.match(REGEX_ALPHANUMERIC)) {
        return { isValid: false, text: Liferay.Language.get('error.field-last-name-alphanum') };
    } else if (lastName.length >= 50) {
        return { isValid: false, text: Liferay.Language.get('error.field-last-name-length') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateEmailAddress(email) {
    if (!email.value.match(REGEX_VALID_EMAIL_ADDRESS)) {
        return { isValid: false, text: Liferay.Language.get('error.field-email-alphanum') };
    } else if (email.length >= 255) {
        return { isValid: false, text: Liferay.Language.get('error.field-email-length') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateUserName(userName) {
    if (!userName.value.match(REGEX_ALPHANUMERIC)) {
        return { isValid: false, text: Liferay.Language.get('error.field-user-name-alphanum') };
    } else if (userName.length < 4) {
        return { isValid: false, text: Liferay.Language.get('error.field-user-name-minLength') };
    } else if (userName.length > 16) {
        return { isValid: false, text: Liferay.Language.get('error.field-user-name-maxLength') };
    } else if (accountExists) {
        return { isValid: false, text: Liferay.Language.get('error.field-duplicate-username') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateBirthday(birthday) {
    if (_calculateAge(birthday) < 13) {
        return { isValid: false, text: Liferay.Language.get('error.field-birth-date') };
    } else {
        return { isValid: true, text: "" };
    }
}

function _calculateAge(birthday) {
    const ageDifMs = Date.now() - birthday.getTime();
    const ageDate = new Date(ageDifMs);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
}

function validatePassword(password) {
    if (!password.value.match(REGEX_PASSWORD)) {
        return { isValid: false, text: Liferay.Language.get('error.field-password') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateConfirmPassword(password1, password2) {
    if (password1 !== password2) {
        return { isValid: false, text: Liferay.Language.get('error.field-password-confirmation') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validatePhoneNumber(phoneNumber) {
    if (phoneNumber.value.length !== 10) {
        return { isValid: false, text: Liferay.Language.get('error.field-phone') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateBillingAddress(address) {
    if (!address.value.match(REGEX_ALPHANUMERIC)) {
        return { isValid: false, text: Liferay.Language.get('error.field-address-alphanum') };
    } else if (address.length >= 255) {
        return { isValid: false, text: Liferay.Language.get('error.field-address-length') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateCity(city) {
    if (!city.value.match(REGEX_ALPHANUMERIC)) {
        return { isValid: false, text: Liferay.Language.get('error.field-city-alphanum') };
    } else if (city.length >= 255) {
        return { isValid: false, text: Liferay.Language.get('error.field-city-length') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateZipCode(zipCode) {
    if (!zipCode.match(REGEX_NUMERIC) || zipCode.value.length !== 5) {
        return { isValid: false, text: Liferay.Language.get('error.field-zipCode') };
    } else {
        return { isValid: true, text: "" };
    }
}

function validateAnswer(answer) {
    if (!answer.value.match(REGEX_ALPHANUMERIC)) {
        return { isValid: false, text: Liferay.Language.get('error.field-answer-alphanum') };
    } else if (answer.length >= 255) {
        return { isValid: false, text: Liferay.Language.get('error.field-answer-length') };
    } else {
        return { isValid: true, text: "" };
    }
}

export { validateFirstName, validateLastName, validateEmailAddress, validateUserName,
    validateBirthday, validatePassword, validateConfirmPassword, validatePhoneNumber,
    validateBillingAddress, validateCity, validateZipCode, validateAnswer };