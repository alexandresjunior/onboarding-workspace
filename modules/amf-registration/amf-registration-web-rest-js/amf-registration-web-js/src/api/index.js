import axios from 'axios';

const baseUrl = Liferay.ThemeDisplay.getCDNBaseURL();

const api = axios.create({
    baseURL: `${ baseUrl }/o/account-registration/`,
    params: {
        "p_auth": Liferay.authToken
    },
    headers: {
        "Content-Type": "application/json; charset=utf-8"
    }
})

export default api;
