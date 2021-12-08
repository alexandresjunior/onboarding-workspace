import React from 'react';
import ReactDOM from 'react-dom';
import RegistrationForm from "./components/RegistrationForm";

export default class extends React.Component {
	render() {
		return (
			<div className="container">
				<div className='text-center'>
					<h1 className='font-weight-normal mb-3'>
						{Liferay.Language.get('amf.registration.caption')}
					</h1>
				</div>
				<RegistrationForm />
			</div>
		);
	}	
}