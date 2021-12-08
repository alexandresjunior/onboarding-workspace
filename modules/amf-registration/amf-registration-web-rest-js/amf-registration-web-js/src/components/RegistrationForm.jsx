import React from "react";
import BasicInfo from "./BasicInfo";
import PhoneInfo from "./PhoneInfo";
import BillingAddressInfo from "./BillingAddressInfo";
import MiscInfo from "./MiscInfo";
import TermsOfUse from "./TermsOfUse";

function RegistrationForm() {
    return (
        <form action="#">
            <div className="sheet sheet-lg">
                <BasicInfo />
                <PhoneInfo />
                <BillingAddressInfo />
                <MiscInfo />
                <TermsOfUse />

                <div className="sheet-footer sheet-footer-btn-block-sm-down">
                    <div className="btn-group">
                        <div className="btn-group-item">
                            <button className="btn btn-primary" type="button">Register</button>
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

export default RegistrationForm;