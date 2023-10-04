import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import questionService from "../../Services/questionService";
import Swal from "sweetalert2";
import "./QuestionList.css";
import quizService from "../../Services/quizService";
import Button from "../../Component/Button component/Button";
import Input from "../../Component/Input component/Input";
import Error from "../../Component/Error component/Error";

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

  const getQuizById = () => {
    quizService
      .getQuizById(id)
      .then((response) => {
        setQuizName(response.data.quizName);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const getQuestionByQuiz = () => {
    quizService
      .getAllQuestionByQuiz(id)
      .then((response) => {
        setQuestions(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const getAllQuestion = () => {
    questionService
      .getAll()
      .then((response) => {
        setQuestions(response.data);
      })
      .catch((error) => {
        console.error(error);
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
            console.error(error);
          });
      }
    });
  };

  const userRole = localStorage.getItem('role');
  if (userRole !== 'admin') {
    return (
      <Error/>
    );
  }

  return (
    <div className="question-wrapper">
      <div className="question-container">
        <div className="question-sidebar-column"></div>
        <div className="question-column">
          <div className="question-main-card">
            <div className="question-card-header-main">
              {id ? <h2 className="question-h2">QUIZ : {quizName}</h2> : <h2>List Of Question</h2>}
              <center>
                <Button
                  className="add-question-button"
                  onClick={() => navigate("/quiz/all")}
                  children="Quiz List"
                ></Button>
                {id ? (
                  <Link
                    to={`/quiz/${id}/addQuestion`}
                  >
                   <Button  className="add-question-button"
                   children="Add"></Button>
                  </Link>
                ) : (
                  <Link
                    to={"/question/all/addQuestion"}
                  >
                    <Button  className="add-question-button"
                   children="Add"></Button>
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
                            <h4>
                              {++index + ". "}
                              {question.questionName}
                            </h4>
                            <Input
                              type="radio"
                              name={`option${index}`}
                              value="optionOne"
                            />
                            {question.options.optionOne}
                            <br />
                            <Input
                              type="radio"
                              name={`option${index}`}
                              value="optionTwo"
                            />
                            {question.options.optionTwo}
                            <br />

                            <Input
                              type="radio"
                              name={`option${index}`}
                              value="optionThree"
                            />
                            {question.options.optionThree}

                            <br />

                            <Input
                              type="radio"
                              name={`option${index}`}
                              value="optionFour"
                            />
                            {question.options.optionFour}
                          </form>
                          <p>
                            <strong>Correct Option:</strong> {question.answer}
                          </p>
                          <p>Category: {question.quiz.category.categoryName}</p>
                        </div>
                        <div className="question-card-footer">
                          {id ? (
                            <Link
                              to={`/quiz/${id}/edit-question/${question.questionId}`}
                            >
                              <Button className="button-update-question" 
                              children="Update"></Button>
                            </Link>
                          ) : (
                            <Link
                              to={`/question/all/edit-question/${question.questionId}`}
                            >
                             <Button className="button-update-question" 
                              children="Update"></Button>
                            </Link>
                          )}
                          <Button
                            className="button-delete-question"
                            onClick={() => deleteQuiz(question.questionId)}
                            children="Delete"
                          ></Button>
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
