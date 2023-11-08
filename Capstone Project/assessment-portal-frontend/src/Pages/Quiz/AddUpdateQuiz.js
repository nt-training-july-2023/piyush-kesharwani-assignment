import React, {useState ,useEffect} from "react";
import categoryService from "../../Services/categoryService";
import quizService from "../../Services/quizService";
import { Link, useNavigate, useParams } from 'react-router-dom';
import Swal from 'sweetalert2';
import './AddUpdateQuiz.css';
import Input from "../../Component/Input component/Input";
import Button from "../../Component/Button component/Button";
import { Label } from "../../Component/Label component/Label";
import Error from "../../Component/Error component/Error";
import { ValidationError } from "../../Component/ValidationError/Validation";

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
        const catObject = response.data;
        setCategory(catObject);
      }
    ).catch((error) => {
      console.log(error);
    })
    setSelectedCategory(categoryId);
}

const validateForm =() =>{
    if(quizName==='' || quizDescription==='' || (!time || time<=0) || category===null){
      setErrors('*all the fields are mandatory')
      return true;
    }
    return false
  }
const saveQuiz=(e)=>{
    e.preventDefault();
    const trimmedQuizName = quizName.trim()
    const trimmedDescription = quizDescription.trim()

    if(!validateForm()){
      const quiz = {quizName:trimmedQuizName,
        quizDescription: trimmedDescription,
        category,
        time };

      if(id){
        quizService.updateQuiz(id, quiz).then((response)=>{
          Swal.fire({
            title: "Success",
            text: "QUIZ updated successfully",
            icon: "success",
            timer:2000,
            showConfirmButton: false,
          });
          navigate("/quiz/all")
        }).catch(error => {
             console.log(error.response)
            const submitError =error.response.data.message
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
          const submitError =error.response.data.message
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
              <Label className="form-label" htmlFor="quizName"
                children = "Quiz Name:">
              </Label>
              <Input
                type="text"
                placeholder="Enter Quiz name"
                id="quizName"
                className="form-control"
                value={quizName}
                onChange={(e) => {setQuizName(e.target.value); setErrors('');}}
              />
            </div>
            <div className="form-group">
              <Label className="form-label" htmlFor="quizDescription"
                children = "Description:">
              </Label>
              <Input
                type="text"
                placeholder="Enter Description"
                id="quizDescription"
                className="form-control"
                value={quizDescription}
                onChange={(e) => {setQuizDescription(e.target.value); setErrors('');}}
              />
            </div>
            <div className="form-group">
              <Label className="form-label" htmlFor="Time"
                children = "Set Timer:">
              </Label>
              <Input
                type="number"
                placeholder="Set Time"
                id="Time"
                className="form-control"
                value={time}
                onChange={(e) => {setTime(e.target.value); setErrors('');}}
              />
            </div>
            <div className="form-group">
              <Label className="form-label" htmlFor="category-select"
                children="Category:">
                </Label>
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
            <ValidationError errorMessage={errors}/>
            <div>
            <Button onClick={(e)=>saveQuiz(e)}  className='cat-button'>
              Submit
            </Button>
            <Link to="/quiz/all">
              <Button className="quiz-cancel">Cancel</Button>
            </Link>
          </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddUpdateQuiz;
