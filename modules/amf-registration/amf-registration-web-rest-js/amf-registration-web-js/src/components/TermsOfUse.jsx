import React from "react";

function TermsOfUse() {
    return (
        <>
            <div className="sheet-header">
                <h2 className="sheet-title">Terms of Use</h2>
            </div>
            <div className="sheet-section">
                <div className="form-group-autofit">
                    <div className="form-group-item">
                        <input type="checkbox" id="termsOfUse" name="termsOfUse" required={true} />
                        <label htmlFor="termsOfUse">{ Liferay.Language.get('amf.registration.terms-of-use') }</label>
                    </div>
                </div>
            </div>
        </>
    );
}

export default TermsOfUse;