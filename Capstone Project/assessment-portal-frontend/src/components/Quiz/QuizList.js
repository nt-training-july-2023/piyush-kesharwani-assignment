import React, { useEffect, useState } from "react";
import quizService from "../../Services/quizService";
import "./QuizList.css";
import Swal from "sweetalert2";
import { Link } from "react-router-dom";

const QuizList = () => {
  const [quiz, setQuiz] = useState([]);

  useEffect(() => {
    getQuiz();
  }, []);

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
      <Link to="/quiz/all/addQuiz"><button className="btn-add">Add Quiz</button></Link>
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
              <div className="button-container">
                <Link to={`/quiz/all/edit-quiz/${qz.quizId}`}><button className="btn-update" >Update</button></Link>
                <button className="btn-delete" onClick={()=>deleteQuiz(qz.quizId)}>Delete</button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default QuizList;
