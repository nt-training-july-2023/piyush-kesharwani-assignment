import React, { useEffect, useState } from "react";
import { Link , useParams , useNavigate} from "react-router-dom";
import categoryService from '../../Services/categoryService';
import quizService from "../../Services/quizService";
import Swal from "sweetalert2";
import './QuizzesByCategory.css';
import Button from "../../Component/Button component/Button";

const QuizzesByCategory = () => {

 const [quizzes, setquizzes] = useState([]);
 const [categoryName, setCategoryName] = useState('');
 const [valid, setValid] = useState("")
 const navigate = useNavigate();
 const { id } = useParams();

 const isLoggedIn = localStorage.getItem("IsLoggedIn");
  const role = localStorage.getItem("role");

  useEffect(() => {
    if (role === "admin") {
      setValid("true");
    } else {
      setValid("false");
    }
  }, [role]);

  useEffect(() => {
    if (isLoggedIn !== null) {
      getAllQuiz();
    } else {
      navigate("/"); 
    }
  }, [isLoggedIn, navigate]);
 

 const getAllQuiz = ()=>{
    categoryService.getQuizzesByCategory(id).then((response)=>{
        setquizzes(response.data)
        setCategoryName(response.data[0].category.categoryName)
    }).catch((error) => {
        console.log(error);
      });
 }

 const deleteQuiz = (quizId) => {
    quizService
      .deleteQuiz(quizId)
      .then(() => {
        Swal.fire({
          title: "Success",
          text: "Quiz deleted successfully",
          icon: "success",
          timer: 2000,
          showConfirmButton: false
        });
        getAllQuiz()
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <h1 className="quiz-cat-title">{categoryName} Quizzes </h1>
         <div className="quizCat-card-container">
         {(isLoggedIn === "true") && (
        <>
        {quizzes.map((qz) => (
          <div key={qz.quizId} className="card">
            <div className="card-body">
              <h5 className="card-title">{qz.quizName}</h5>
              <p className="card-text">{qz.quizDescription}</p>
              <p className="card-text">Quiz Timer: {qz.time}</p>
              <div className="card-text">
                {qz.category ? (
                  <div>
                    <h4>Category: {qz.category.categoryName}</h4>
                    <p>{qz.category.Description}</p>
                  </div>
                ) : (
                  <p>No category available</p>
                )}
              </div>
              {valid === "true" && isLoggedIn === "true" ? (
              <div className="button-container">
                <Link to={`/quiz/all/edit-quiz/${qz.quizId}`}><button className="btn-update" >Update</button></Link>
                <Button className="btn-delete" onClick={()=>deleteQuiz(qz.quizId)} children="Delete"></Button>
              </div>
              ) : (
                <div className="button-container">
                <Button className="btn-update" onClick={"/"} children="Take Test"></Button>
                <Button className="btn-delete" onClick={()=>navigate("/category/all")} children="Cancel"></Button>
              </div>
              )}
            </div>
          </div>
        ))}
        </>
         )}
      </div>
    </div>
  )
}

export default QuizzesByCategory