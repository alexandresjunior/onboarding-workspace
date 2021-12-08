import React from "react";

function PhoneInfo() {
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
                        />
                    </div>
                    <div className="form-group-item">
                        <label>Mobile Phone</label>
                        <input
                            className="form-control"
                            id="mobilePhone"
                            type="number"
                        />
                    </div>
                </div>
            </div>
        </>
    );
}

export default PhoneInfo;