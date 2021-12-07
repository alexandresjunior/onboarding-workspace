import React from "react";

function BasicInfo() {
    return (
        <>
            <div className="sheet sheet-lg">
                <div className="sheet-header">
                    <h2 className="sheet-title">Basic Info.</h2>
                </div>
                <div className="sheet-section">
                    <div className="form-group-autofit">
                        <div className="form-group-item">
                            <label>First Name</label>
                            <input
                                className="form-control"
                                id="firstName"
                                type="text"
                                required={true}
                            />
                        </div>
                        <div className="form-group-item">
                            <label>Last Name</label>
                            <input
                                className="form-control"
                                id="lastName"
                                type="text"
                                required={true}
                            />
                        </div>
                    </div>

                    <div className="form-group-autofit">
                        <div className="form-group-item">
                            <label>Email</label>
                            <input
                                className="form-control"
                                id="email"
                                type="email"
                                required={true}
                            />
                        </div>
                        <div className="form-group-item">
                            <label>Username</label>
                            <input
                                className="form-control"
                                id="username"
                                type="text"
                                required={true}
                            />
                        </div>
                    </div>
                    <div className="form-group-autofit">
                        <div className="form-group-item">
                            <label>Gender</label>
                            <select className="form-control" id="gender" name="genre" required={true}>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </div>
                        <div className="form-group-item">
                            <label>Birthday</label>
                            <input
                                className="form-control"
                                id="birthday"
                                type="date"
                                required={true}
                            />
                        </div>
                    </div>
                    <div className="form-group-autofit">
                        <div className="form-group-item">
                            <label>Password</label>
                            <input
                                className="form-control"
                                id="password"
                                type="password"
                                required={true}
                            />
                        </div>
                        <div className="form-group-item">
                            <label>Confirm password</label>
                            <input
                                className="form-control"
                                id="confirmPassword"
                                type="password"
                                required={true}
                            />
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default BasicInfo;