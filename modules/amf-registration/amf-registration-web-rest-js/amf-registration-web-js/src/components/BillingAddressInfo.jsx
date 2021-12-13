import React from "react";

function BillingAddressInfo({errors, validateFields}) {
    return (
        <>
            <div className="sheet-header">
                <h2 className="sheet-title">Billing Address</h2>
            </div>
            <div className="sheet-section">
                <div className="form-group-autofit">
                    <div className="form-group-item">
                        <label>Address 1</label>
                        <input
                            className="form-control"
                            id="address1"
                            type="text"
                            required={true}
                            error={!errors.billingAddress.isValid}
                            helperText={errors.billingAddress.text}
                            onBlur={ validateFields }
                        />
                    </div>
                    <div className="form-group-item">
                        <label>Address 2</label>
                        <input
                            className="form-control"
                            id="address2"
                            type="text"
                            error={!errors.billingAddress.isValid}
                            helperText={errors.billingAddress.text}
                            onBlur={ validateFields }
                        />
                    </div>
                </div>

                <div className="form-group-autofit">
                    <div className="form-group-item">
                        <label>City</label>
                        <input
                            className="form-control"
                            id="city"
                            type="text"
                            required={true}
                            error={!errors.city.isValid}
                            helperText={errors.city.text}
                            onBlur={ validateFields }
                        />
                    </div>
                    <div className="form-group-item">
                        <label>State</label>
                        <input
                            className="form-control"
                            id="state"
                            type="text"
                            required={true}
                        />
                    </div>
                    <div className="form-group-item">
                        <label>Zip Code</label>
                        <input
                            className="form-control"
                            id="zipCode"
                            type="text"
                            required={true}
                            error={!errors.zipCode.isValid}
                            helperText={errors.zipCode.text}
                            onBlur={ validateFields }
                        />
                    </div>
                </div>
            </div>
        </>
    );
}

export default BillingAddressInfo;