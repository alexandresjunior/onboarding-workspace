import React, {useContext, useEffect, useState} from "react";
import BasicInfo from "./BasicInfo";
import PhoneInfo from "./PhoneInfo";
import BillingAddressInfo from "./BillingAddressInfo";
import MiscInfo from "./MiscInfo";
import TermsOfUse from "./TermsOfUse";
import { getSample } from "../services/getSample";
import { registerAccount } from "../services/registerAccount";
import RegistrationValidation from "../contexts/RegistrationValidation";
import useErrors from "../hooks/useErrors";

const RegistrationForm = () => {
    const isLoggedIn = Liferay.ThemeDisplay.isSignedIn();

    if (isLoggedIn) {
        const [sample, setSample] = useState([]);

        useEffect(() => {
            getSample(`sample`, setSample);
        },[]);

        return (
            <div className='text-center'>
                <h1 className='font-weight-normal mb-3'>
                    { Liferay.Language.get('amf.registration.logged.user') + sample.email }
                </h1>
            </div>
        )
    }

    const validation = useContext(RegistrationValidation);
    const [errors, validateFields, areFieldsValid] = useErrors(validation);

    return (
        <>
            <div className='text-center'>
                <h1 className='font-weight-normal mb-3'>
                    { Liferay.Language.get('amf.registration.caption') }
                </h1>
            </div>
            <form onSubmit={ (event) => {
                if (areFieldsValid()) {
                    registerAccount()
                }}
            }>
                <div className="sheet sheet-lg">
                    <BasicInfo errors={errors} validate={validateFields} />
                    <PhoneInfo errors={errors} validate={validateFields} />
                    <BillingAddressInfo errors={errors} validate={validateFields} />
                    <MiscInfo errors={errors} validate={validateFields} />
                    <TermsOfUse errors={errors} validate={validateFields} />

                    <div className="sheet-footer sheet-footer-btn-block-sm-down">
                        <div className="btn-group">
                            <div className="btn-group-item">
                                <button className="btn btn-primary" type="submit">Register</button>
                            </div>
                            <div className="btn-group-item">
                                <button className="btn btn-secondary" type="button">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </>
    );
}

export default RegistrationForm;