import axios from "axios";

const quiz_BASE_API_URL = "http://localhost:8080/quiz";

class quizService{

    getAllQuiz(){
        return axios.get(quiz_BASE_API_URL + "/all");
    }

    addQuiz(Quiz){
        return axios.post(quiz_BASE_API_URL + "/addQuiz" , Quiz);
    }
    
    getQuizById(id){
        return axios.get(quiz_BASE_API_URL + "/getQuiz/" + id);
    }

    updateQuiz(id,Quiz){
       return axios.put(quiz_BASE_API_URL + "/update/" + id , Quiz);
    }

    deleteQuiz(id){
        return axios.delete(quiz_BASE_API_URL + "/delete/" + id);
    }

}
export default new quizService();