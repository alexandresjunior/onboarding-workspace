import api from "../api/index";
import 'regenerator-runtime/runtime';

export const accountExists = async () => {
    try {
        const response = await api.get(`account-exists`);
        if (response.data.length !== 0) {
            return true;
        }
    } catch (error) {
        console.error("Error in accountExists" + error);
    }
}