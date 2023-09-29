import React, {useState ,useEffect} from "react";
import categoryService from "../../Services/categoryService";
import quizService from "../../Services/quizService";
import { Link, useNavigate, useParams } from 'react-router-dom';
import Swal from 'sweetalert2';
import './AddUpdateQuiz.css';
import Error from "../Error";

const AddUpdateQuiz = () => {
  const [quizName, setQuizName] = useState("");
  const [quizDescription, setQuizDescription] = useState("");
  const [time, setTime] = useState(0);
  const [selectedCategory, setSelectedCategory] = useState();    
  const [category, setCategory] = useState(null);
  const [categories, setCategories] = useState([]);
  const [errors, setErrors] = useState('')
  const navigate = useNavigate();
  const {id} = useParams();

  useEffect(() => {
    getAllCategories();
  }, []);

  const getAllCategories =()=>{
    categoryService.getAll().then((response)=>{
      setCategories(response.data);
    }).catch((error)=>{
      console.log(error);
    })
  }
  const handleCategoryChange=(event)=>{
    const categoryId = event.target.value;
    categoryService.getCategoryById(categoryId).then(
      response => {
        // console.log(response.data)
        const catObject = response.data;
        setCategory(catObject);
      }
    ).catch((error) => {
      console.log(error);
    })
    setSelectedCategory(categoryId);
}

const validateForm =() =>{
    if(quizName==='' || quizDescription==='' || time===0 || selectedCategory===''){
      setErrors('*all the fields are mandatory')
      return true;
    }
    return false
  }
const saveQuiz=(e)=>{
    e.preventDefault();
    if(!validateForm()){
      const quiz = {quizName, quizDescription, category, time};
      if(id){
        quizService.updateQuiz(id, quiz).then((response)=>{
          console.log(response.data);
          Swal.fire({
            title: "Success",
            text: "qUIZ updated successfully",
            icon: "success",
            timer:2000,
            showConfirmButton: false,
          });
          navigate("/quiz/all")
        }).catch(error => {
            console.log(error);
            const submitError =error.response.data
            Swal.fire({
              title: "Error",
              text: `${submitError}`,
              icon: "error",
              confirmButtonText:"Retry",
              confirmButtonColor:"red"
            });
        });
      }
      else{
        quizService.addQuiz(quiz).then((response)=>{
          console.log(response.data);
          Swal.fire({
            title: "Success",
            text: "Quiz added successfully",
            icon: "success",
            timer:2000,
            showConfirmButton: false,
          });
          navigate("/quiz/all")
        }).catch(error =>{
          const submitError =error.response.data
          Swal.fire({
            title: "Error",
            text: `${submitError}`,
            icon: "error",
            confirmButtonText:"Retry",
            confirmButtonColor:"red"
          });
          console.log(error);
        })
      }
    }
  }
 
  useEffect(()=>{
    if(id){
      quizService.getQuizById(id).then((response)=>{
          setQuizName(response.data.quizName)
          setQuizDescription(response.data.quizDescription)
          setTime(response.data.time);
          setCategory(response.data.category);
          setSelectedCategory(response.data.category.categoryId);
      }).catch(error => {
        console.log(error)
      })
    }
  },[id])

  const title =() =>{
    if(id) {
      return <h2 style={{textAlign:'center'}}>UPDATE QUIZ</h2>
    }else{
      return <h2 style={{textAlign:'center'}}>ADD QUIZ</h2>
    }
  }
  
  const role = localStorage.getItem('role');
  if (role !== 'admin') {
    return (
      <Error/>
    );
  }

  return (
    <div className="quiz-form-container">
      <div className="quiz-card">
        {title()}
        <div className="quiz-card-body">
          <form>
            <div className="form-group">
              <label className="form-label" htmlFor="quizName">
                Quiz Name:
              </label>
              <input
                type="text"
                placeholder="Enter Quiz name"
                id="quizName"
                className="form-control"
                value={quizName}
                onChange={(e) => {setQuizName(e.target.value); setErrors('');}}
              />
            </div>
            <div className="form-group">
              <label className="form-label" htmlFor="quizDescription">
                Description:
              </label>
              <input
                type="text"
                placeholder="Enter Description"
                id="quizDescription"
                className="form-control"
                value={quizDescription}
                onChange={(e) => {setQuizDescription(e.target.value); setErrors('');}}
              />
            </div>
            <div className="form-group">
              <label className="form-label" htmlFor="Time">
                Set Timer:
              </label>
              <input
                type="number"
                placeholder="Set Time"
                id="Time"
                className="form-control"
                value={time}
                onChange={(e) => {setTime(e.target.value); setErrors('');}}
              />
            </div>
            <div className="form-group">
              <label className="form-label" htmlFor="category-select">Category:</label>
              <select
                id="category-select"
                value={selectedCategory}
                onChange={handleCategoryChange}
              >
                <option value="">--Select a category--</option>
                {categories.map((category) => (
                  <option key={category.categoryId} value={category.categoryId}>
                    {category.categoryName}
                  </option>
                ))}
              </select> 
            </div>
            <span style={{color : "red"}}>{errors}</span>
            <div>
            <button onClick={(e)=>saveQuiz(e)}  className='cat-button'>
              Submit
            </button>
            <Link to="/quiz/all">
              <button>Cancel</button>
            </Link>
          </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddUpdateQuiz;
