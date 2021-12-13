import React from "react";

function PhoneInfo({errors, validateFields}) {
    return (
        <>
            <div className="sheet-header">
                <h2 className="sheet-title">Phone</h2>
            </div>
            <div className="sheet-section">
                <div className="form-group-autofit">
                    <div className="form-group-item">
                        <label>Home Phone</label>
                        <input
                            className="form-control"
                            id="homePhone"
                            type="number"
                            error={!errors.homePhoneNumber.isValid}
                            helperText={errors.homePhoneNumber.text}
                            onBlur={ validateFields }
                        />
                    </div>
                    <div className="form-group-item">
                        <label>Mobile Phone</label>
                        <input
                            className="form-control"
                            id="mobilePhone"
                            type="number"
                            error={!errors.mobilePhoneNumber.isValid}
                            helperText={errors.mobilePhoneNumber.text}
                            onBlur={ validateFields }
                        />
                    </div>
                </div>
            </div>
        </>
    );
}

export default PhoneInfo;