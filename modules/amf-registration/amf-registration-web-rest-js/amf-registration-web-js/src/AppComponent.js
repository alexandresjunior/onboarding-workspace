import React from 'react';
import ReactDOM from 'react-dom';
import RegistrationForm from "./components/RegistrationForm";

export default class extends React.Component {
	render() {
		return (
			<div className="container">
				<RegistrationForm />
			</div>
		);
	}	
}