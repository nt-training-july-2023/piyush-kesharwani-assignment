import axios from 'axios'

const Candidate_BASE_API_URL = "http://localhost:8080/candidate";

class candidateService{
    login(candidate){
        return axios.post(Candidate_BASE_API_URL + "/login", candidate)
    }

    register(candidate){
        return axios.post(Candidate_BASE_API_URL + "/register"  , candidate)
    }

    getAll(){
       return axios.get(Candidate_BASE_API_URL + "/all")
    }
}
export default new candidateService();