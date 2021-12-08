import { GET, POST } from 'common-react-components';

export const checkAccountExists = async (value) => {
    return GET(
        `/o/account-registration/account-exists/${value}?p_auth=${ Liferay.authToken }`
    );
};

export const registerAccount = async (values) => {
    return POST(
        `/o/account-registration/add-account?p_auth=${ Liferay.authToken }`,
        values
    );
}