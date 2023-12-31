import axios from 'axios'

const Category_BASE_API_URL = "http://localhost:8080/category";

class categoryService{
    getAll(){
        return axios.get(Category_BASE_API_URL + "/all");
    }

    addCategory(Category){
        return axios.post(Category_BASE_API_URL + "/addCategory" ,Category);
    }

    getCategoryById(id){
        return axios.get(Category_BASE_API_URL + "/getCategory/" + id);
    }

    updateCategory(id, Category){
        return axios.put(Category_BASE_API_URL + "/update/" + id,Category);
    }

    deleteCategory(id){
        return axios.delete(Category_BASE_API_URL + "/delete/" + id);
    }
    getQuizzesByCategory(id){
        return axios.get(Category_BASE_API_URL + "/" + id + "/quizzes");
    }
    
}
export default new categoryService();