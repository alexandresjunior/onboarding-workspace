import {useState} from "react";

function useErrors(validation) {
    const initialState = _createInitialState(validation);

    const [errors, setErrors] = useState(initialState);

    function validateFields(event) {
        const { name, value } = event.target;

        const newState = {...errors};

        newState[name] = validation[name](value);

        setErrors(newState);
    }

    function areFieldsValid() {
        for (let field in errors) {
            if (!errors[field].isValid) {
                return false;
            }
        }
        return true;
    }

    return [errors, validateFields, areFieldsValid];
}

function _createInitialState(validation) {
    const initialState = {};

    for (let field in validation) {
        initialState[field] = { isValid: true, text: ""};
    }

    return initialState;
}

export default useErrors;