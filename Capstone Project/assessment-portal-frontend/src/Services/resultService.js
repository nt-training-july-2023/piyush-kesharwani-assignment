import axios from 'axios'

const Result_BASE_API_URL = "http://localhost:8080/result";

class resultService{

    saveResult(Result){
        return axios.post(Result_BASE_API_URL + "/addResult" , Result);
    }

    getAll(){
        return axios.get(Result_BASE_API_URL + "/all");
    }

    findByEmailId(email){
        return axios.get(Result_BASE_API_URL + "/" + email);
    }
}

export default new resultService();