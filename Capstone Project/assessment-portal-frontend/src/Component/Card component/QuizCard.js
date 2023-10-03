import React from "react";
import { Link } from "react-router-dom";
import Button from "../../Component/Button component/Button";

const QuizCard = ({ quiz, onDelete, onOpenQuiz, isAdmin }) => {
  return (
    <div className="card">
      <div className="card-body">
        <h5 className="card-title">{quiz.quizName}</h5>
        <p className="card-text">{quiz.quizDescription}</p>
        <p className="card-text">Quiz Timer: {quiz.time}</p>
        <div className="card-text">
          {quiz.category ? (
            <div>
              <h4>Category: {quiz.category.categoryName}</h4>
              <p>{quiz.category.Description}</p>
            </div>
          ) : (
            <p>No category available</p>
          )}
        </div>
        <div className="button-container">
          {isAdmin ? (
            <>
              <Link to={`/quiz/all/edit-quiz/${quiz.quizId}`}>
                <Button className="btn-update">Update</Button>
              </Link>
              <Link to={`/quiz/${quiz.quizId}/question`}>
                <Button className="view-btn">View Question</Button>
              </Link>
              <Button className="btn-delete" onClick={() => onDelete(quiz.quizId)}>
                Delete
              </Button>
            </>
          ) : (
            <>
              <Button className="btn-update" onClick={() => onOpenQuiz(quiz.quizId)}>
                Take Test
              </Button>
              <Button className="btn-delete" onClick={() => alert("Cancel button clicked")}>
                Cancel
              </Button>
            </>
          )}
        </div>
      </div>
    </div>
  );
};

export default QuizCard;