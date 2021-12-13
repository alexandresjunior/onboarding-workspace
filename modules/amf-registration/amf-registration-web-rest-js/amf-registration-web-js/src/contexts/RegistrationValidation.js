import React from "react";
import { validateFirstName, validateLastName, validateEmailAddress, validateUserName,
    validateBirthday, validatePassword, validateConfirmPassword, validatePhoneNumber,
    validateBillingAddress, validateCity, validateZipCode, validateAnswer
} from "../models/account";

const RegistrationValidation = React.createContext(
    {
        firstName: validateFirstName,
        lastName: validateLastName,
        email: validateEmailAddress,
        userName: validateUserName,
        birthday: validateBirthday,
        password: validatePassword,
        confirmPassword: validateConfirmPassword,
        homePhoneNumber: validatePhoneNumber,
        mobilePhoneNumber: validatePhoneNumber,
        billingAddress: validateBillingAddress,
        city: validateCity,
        zipCode: validateZipCode,
        answer: validateAnswer
    }
);

export default RegistrationValidation;