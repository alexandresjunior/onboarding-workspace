import React from "react";
import BasicInfo from "./BasicInfo";
import PhoneInfo from "./PhoneInfo";
import BillingAddressInfo from "./BillingAddressInfo";
import MiscInfo from "./MiscInfo";
import TermsOfUse from "./TermsOfUse";
import { registerAccount } from "../services/accountRegistration";

function RegistrationForm() {
    return (
        <form onSubmit={ onSubmit }>
            <div className="sheet sheet-lg">
                <BasicInfo />
                <PhoneInfo />
                <BillingAddressInfo />
                <MiscInfo />
                <TermsOfUse />

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
    );
}

const onSubmit = async (values) => {
    await registerAccount(values);
};

export default RegistrationForm;