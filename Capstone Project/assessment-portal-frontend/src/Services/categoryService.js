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

    updateCategory(id){
        return axios.put(Category_BASE_API_URL + "/update/" + id);
    }

    deleteCategory(id){
        return axios.delete(Category_BASE_API_URL + "/delete/" + id);
    }
    
}
export default new categoryService();