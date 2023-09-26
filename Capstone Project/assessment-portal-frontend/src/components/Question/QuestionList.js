import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import questionService from "../../Services/questionService";
import Swal from "sweetalert2";
import "./QuestionList.css";
import quizService from "../../Services/quizService";
// import Error from "../Error";

const QuestionList = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [quizName, setQuizName] = useState([]);
  const [questions, setQuestions] = useState([]);

  useEffect(() => {
    if (id) {
      getQuestionByQuiz();
      getQuizById();
    } else {
      getAllQuestion();
    }
  }, [id]);

  const getQuizById=() =>{
    quizService.getQuizById(id).then(response =>{
        setQuizName(response.data.quizName);
    }).catch((error) => {
        console.log(error);
    })
}

  const getQuestionByQuiz = () => {
    quizService
      .getAllQuestionByQuiz(id)
      .then((response) => {
        setQuestions(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const getAllQuestion = () => {
    questionService
      .getAll()
      .then((response) => {
        setQuestions(response.data);
        // console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const deleteQuiz = (questionId) => {
    Swal.fire({
      title: "Are you sure?",
      text: "You will not be able to recover this question!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085D6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!",
    }).then((result) => {
      if (result.isConfirmed) {
        questionService
          .deleteQuestion(questionId)
          .then(() => {
            Swal.fire("Deleted!", "The question has been deleted.", "success");
            getAllQuestion();
          })
          .catch((error) => {
            console.log(error);
          });
      }
    });
  };

  // const userRole = localStorage.getItem('userRole');
  // if (userRole !== 'admin') {
  //   return (
  //     <Error />
  //   );
  // }

  return (
    <div className="question-wrapper">
      <div className="question-container">
        <div className="question-sidebar-column"></div>
        <div className="question-column">
          <div className="question-main-card">
            <div className="question-card-header-main">
              {id ? (<h2>QUIZ : {quizName}</h2>): (<h2>List Of Question</h2>)}
              <center>
                <button
                  className="add-question-button"
                  onClick={() => navigate("/quiz/all")}
                >
                  Quiz List
                </button>
                {id ? (
                  <Link
                    className="add-question-button"
                    to={`/quiz/${id}/addQuestion`}
                  >
                    Add Question
                  </Link>
                ) : (
                  <Link
                    className="add-question-button"
                    to={"/question/all/addQuestion"}
                  >
                    Add Question
                  </Link>
                )}
              </center>
            </div>
            <div className="question-card-body">
              <div className="question-table-wrapper">
                <table className="question-table">
                  <tbody className="quiz-table-content">
                    {questions.map((question, index) => (
                      <div className="question-card" key={question.questionId}>
                        <div className="question-card-header">
                          <h3>{question.quiz.quizName}</h3>
                        </div>
                        <div className="question-card-body">
                          <form>
                            <h4>{++index + ". "}{question.questionName}</h4>
                            <label>
                              <input
                                type="radio"
                                name={`option${index}`}
                                value="optionOne"
                              />
                              {question.options.optionOne}
                            </label>
                            <br />
                            <label>
                              <input
                                type="radio"
                                name={`option${index}`}
                                value="optionTwo"
                              />
                              {question.options.optionTwo}
                            </label>
                            <br />
                            <label>
                              <input
                                type="radio"
                                name={`option${index}`}
                                value="optionThree"
                              />
                              {question.options.optionThree}
                            </label>
                            <br />
                            <label>
                              <input
                                type="radio"
                                name={`option${index}`}
                                value="optionFour"
                              />
                              {question.options.optionFour}
                            </label>
                          </form>
                          <p>
                            <strong>Correct Option:</strong> {question.answer}
                          </p>
                          <p>Category: {question.quiz.category.categoryName}</p>
                        </div>
                        <div className="question-card-footer">
                          {id ? (<Link
                            className="button-update-question"
                            to={`/quiz/${id}/edit-question/${question.questionId}`}
                          >
                            Update Question
                          </Link>):(<Link
                            className="button-update-question"
                            to={`/question/all/edit-question/${question.questionId}`}
                          >
                            Update Question
                          </Link>)}
                          <button
                            className="button-update-question"
                            onClick={() => deleteQuiz(question.questionId)}
                          >
                            Delete Question
                          </button>
                        </div>
                      </div>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default QuestionList;
