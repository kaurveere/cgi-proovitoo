import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/films';

export const listFilms = () => {
    return axios.get(REST_API_BASE_URL);
}