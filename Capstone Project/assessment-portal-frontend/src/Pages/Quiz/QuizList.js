import React, { useEffect, useState } from "react";
import quizService from "../../Services/quizService";
import "./QuizList.css";
import Swal from "sweetalert2";
import { useNavigate } from "react-router-dom";
import Button from "../../Component/Button component/Button";
import QuizCard from "../../Component/Card component/QuizCard";

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
      })
      .catch((error) => {
        console.error(error);
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
        console.error(error);
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
              <Button className="btn-add" onClick={() => navigate("/adminDashboard")} children ="Dashboard"></Button>
              <Button className="btn-add" onClick={() => navigate("/quiz/all/addQuiz")} children="Add Quiz"></Button>
            </>
          )}
       <div className="quiz-card-container">
            {quiz.map((qz) => (
              <QuizCard
                key={qz.quizId}
                quiz={qz}
                onDelete={deleteQuiz}
                onOpenQuiz={handleOpenQuiz}
                isAdmin={valid === "true" && isLoggedIn === "true"}
              />
            ))}
          </div>
      </>
      )}
    </div>
      
  );
};

export default QuizList;
