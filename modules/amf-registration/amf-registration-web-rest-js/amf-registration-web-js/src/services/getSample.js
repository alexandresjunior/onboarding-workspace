import api from "../api/index";
import 'regenerator-runtime/runtime';

export const getSample = async (url, setSample) => {
    try {
        const response = await api.get(url);
        setSample(response.data);
    } catch (error) {
        console.error("Error in getSample" + error);
    }
}