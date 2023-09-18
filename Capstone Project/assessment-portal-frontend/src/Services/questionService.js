import axios from 'axios'

const Question_BASE_API_URL = "http://localhost:8080/question";

class questionService{

    addQuestion(Question){
        return axios.post(Question_BASE_API_URL + "/add" , Question);
    }

    getAll(){
        return axios.get(Question_BASE_API_URL + "/all");
    }

    getQuestionById(id){
        return axios.get(Question_BASE_API_URL + "/" + id);
    }

    updateQuestion(id,Question){
        return axios.put(Question_BASE_API_URL + "/update/" + id , Question);
    }

    deleteQuestion(id){
        return axios.delete(Question_BASE_API_URL + "/" + id);
    }
}
export default new questionService();