import React from "react";

function TermsOfUse() {
    return (
        <>
            <div className="sheet sheet-lg">
                <div className="sheet-header">
                    <h2 className="sheet-title">Terms of Use</h2>
                </div>
                <div className="sheet-section">
                    <div className="form-group-autofit">
                        <div className="form-group-item">
                            <label>I accept the Terms of Use.</label>
                            <input
                                className="form-control"
                                id="termsOfUse"
                                type="checkbox"
                                name="termsOfUse"
                                required={true}
                            />
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default TermsOfUse;