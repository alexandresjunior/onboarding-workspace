import React, {useEffect, useState} from "react";
import BasicInfo from "./BasicInfo";
import PhoneInfo from "./PhoneInfo";
import BillingAddressInfo from "./BillingAddressInfo";
import MiscInfo from "./MiscInfo";
import TermsOfUse from "./TermsOfUse";
import { getSample } from "../services/getSample";

const RegistrationForm = () => {
    const isLoggedIn = Liferay.ThemeDisplay.isSignedIn();

    const [sample, setSample] = useState([]);

    useEffect(() => {
        getSample(`sample`, setSample);
    },[]);

    if (isLoggedIn) {
        return (
            <div className='text-center'>
                <h1 className='font-weight-normal mb-3'>
                    { "You're already logged in as " + sample.email }
                </h1>
            </div>
        )
    }

    return (
        <>
            <div className='text-center'>
                <h1 className='font-weight-normal mb-3'>
                    { Liferay.Language.get('amf.registration.caption') }
                </h1>
            </div>
            {/*<form onSubmit={ onSubmit }>*/}
            <form onSubmit="#">
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
        </>
    );
}

export default RegistrationForm;