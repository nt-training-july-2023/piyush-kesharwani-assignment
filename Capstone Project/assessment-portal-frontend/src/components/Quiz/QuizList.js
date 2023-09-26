import React, { useEffect, useState } from "react";
import quizService from "../../Services/quizService";
import "./QuizList.css";
import Swal from "sweetalert2";
import { Link, useNavigate } from "react-router-dom";

const QuizList = () => {
  const [quiz, setQuiz] = useState([]);
  const [valid, setValid] = useState("")
  const navigate = useNavigate();
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
      getQuiz();
    } else {
      navigate("/"); 
    }
  }, [isLoggedIn, navigate]);

  const handleOpenQuiz = (quizId) => {
    Swal.fire({
      icon: 'info',
      title: `<div style="color:red">"You are about to begin the test!"</div>`,
      html: `  <div style="text-align: left;">
      <h2>Instructions</h2>
      1. Once you begin the test, you cannot exit without clicking the submit button.<br>
      2. Leaving the test without submitting will result in your progress and results not being saved.<br>
      3. Do not refresh the page while taking the test.<br>
      4. Avoid using the back button during the test.<br>
    </div>`,
      showCancelButton: true,
      confirmButtonText: "Yes, I am Ready",
      cancelButtonText: "Cancel"
    }).then((confirmButton) => {
      if (confirmButton.isConfirmed) {
        navigate(`/quiz/${quizId}/test`)
      }
    });
  }

  const getQuiz = () => {
    quizService
      .getAllQuiz()
      .then((response) => {
        setQuiz(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

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
        getQuiz();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="quiz-container">
      <div className="quiz-title">
        <h2>List of Quizzes</h2>
      </div>
      {(isLoggedIn === "true") && (
        <>
      {role === "admin" && (
            <>
              <button className="btn-add" onClick={() => navigate("/adminDashboard")}>Dashboard</button>
              <button className="btn-add" onClick={() => navigate("/quiz/all/addQuiz")}>Add Quiz</button>
            </>
          )}
      <div className="quiz-card-container">
        {quiz.map((qz) => (
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
                <Link to={`/quiz/${qz.quizId}/question`}><button className="view-btn" >View Question</button></Link>
                <button className="btn-delete" onClick={()=>deleteQuiz(qz.quizId)}>Delete</button>
              </div>
              ) : (
                <div className="button-container">
                {/* <Link to={`/quiz/${qz.quizId}/test`}><button className="btn-update">Take Test</button></Link> */}
                <button className="btn-update" onClick={()=>{handleOpenQuiz(qz.quizId)}}>Take Test</button>
                <button className="btn-delete" onClick={()=>navigate("/category/all")}>Cancel</button>
              </div>
              )}
            </div>
          </div>
        ))}
      </div>
      </>
      )}
    </div>
      
  );
};

export default QuizList;
