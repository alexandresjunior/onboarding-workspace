import React from "react";

function MiscInfo() {
    return (
        <>
            <div className="sheet-header">
                <h2 className="sheet-title">Misc.</h2>
            </div>
            <div className="sheet-section">
                <div className="form-group-autofit">
                    <div className="form-group-item">
                        <label>Security Question</label>
                        <select className="form-control" id="securityQuestion" name="securityQuestion" required={true}>
                            <option value="What is your mother's maiden name?"
                                    label="What is your mother's maiden name?"/>
                            <option value="What is the make of your first car?"
                                    label="What is the make of your first car?"/>
                            <option value="What is your high school mascot?"
                                    label="What is your high school mascot?"/>
                            <option value="Who is your favorite actor?"
                                    label="Who is your favorite actor?"/>
                        </select>
                    </div>
                </div>

                <div className="form-group-autofit">
                    <div className="form-group-item">
                        <label>Answer</label>
                        <input
                            className="form-control"
                            id="answer"
                            type="text"
                            required={true}
                        />
                    </div>
                </div>
            </div>
        </>
    );
}

export default MiscInfo;