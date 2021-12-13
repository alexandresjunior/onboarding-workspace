import api from "../api/index";
import 'regenerator-runtime/runtime';

export const registerAccount = async () => {
    try {
        await api.post(`add-account`);
    } catch (error) {
        console.error("Error in registerAccount" + error);
    }
}