import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import quizService from "../../Services/quizService";
import resultService from "../../Services/resultService";
import Swal from "sweetalert2";
import Button from "../../Component/Button component/Button";
import Input from "../../Component/Input component/Input";

const UserTest = () => {
  const [questions, setQuestions] = useState([]);
  const [totalMarks, setTotalMarks] = useState(0);
  const [totalQuestion, setTotalQuestion] = useState(0);
  const [obtainedMarks, setObtainedMarks] = useState(0);
  const [quizName, setQuizName] = useState();
  const [timeinSeconds, setTimeinSeconds] = useState(0);
  const [attemptedQuestion, setAttemptedQuestion] = useState(0);
  const [submitted, setSubmitted] = useState(false);
  const [selectedAnswers, setSelectedAnswers] = useState({});
  const [categoryName, setCategoryName] = useState();
  const currentDate = new Date();
  const dateTime = `${currentDate.getDate()}-${
    currentDate.getMonth() + 1
  }-${currentDate.getFullYear()} ${currentDate.getHours()}:${currentDate.getMinutes()}:${currentDate.getSeconds()}`;
  const userName = localStorage.getItem("userName");
  const userEmail = localStorage.getItem("email");
  const { quizId } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    getQuestionByQuiz();
    getQuizById();
  }, [obtainedMarks, attemptedQuestion]);

  useEffect(() => {
    const handleCountdown = () => {
      if (timeinSeconds > 0) {
        setTimeinSeconds((prevTime) => prevTime - 1);
      } else {
        handleSubmit();
      }
    };
    const countdownInterval = setInterval(handleCountdown, 1000);
    return () => clearInterval(countdownInterval);
  }, [timeinSeconds]);

  const formattedTime = new Date(timeinSeconds * 1000)
    .toISOString()
    .substr(11, 8);

  const getQuizById = () => {
    quizService
      .getQuizById(quizId)
      .then((response) => {
        setQuizName(response.data.quizName);
        const timer = response.data.time;
        const timerinSecond = timer * 60;
        setTimeinSeconds(timerinSecond);
        setCategoryName(response.data.category.categoryName);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const getQuestionByQuiz = () => {
    quizService
      .getAllQuestionByQuiz(quizId)
      .then((response) => {
        setQuestions(response.data);
        setTotalMarks(response.data.length);
        setTotalQuestion(response.data.length);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleOptionChange = (questionId, selectedOption, correctAnswer) => {
    if (!submitted) {
      setSelectedAnswers((prevSelectedAnswers) => ({
        ...prevSelectedAnswers,
        [questionId]: selectedOption,
      }));
    }
  };
  const handleSubmit = (e) => {
    if (e) {
      e.preventDefault();
    }
    setSubmitted(true);
    let score = 0;
    for (const question of questions) {
      const questionId = question.questionId;
      if (selectedAnswers[questionId] === question.answer) {
        score += 1;
      }
    }
    setObtainedMarks(score);
    setAttemptedQuestion(Object.keys(selectedAnswers).length);

    const result = {
      totalMarks,
      obtainedMarks: score,
      userEmail,
      userName,
      dateTime,
      quizName,
      categoryName,
      attemptedQuestion: Object.keys(selectedAnswers).length,
      totalQuestion,
    };
    resultService.saveResult(result).then((response) => {
      Swal.fire({
        title: "Test Submitted",
        text: "Test Submitted successfully",
        icon: "success",
        timer: 2000,
        showConfirmButton: false
      })
      navigate("/userDashboard");
    });
  };

  return (
    <div className="question-wrapper">
      <div className="question-container">
        <div className="question-sidebar-column"></div>
        <div className="question-column">
          <div className="question-main-card">
            <div className="question-card-header-main">
              <h2>Test : {quizName}</h2>
              <h2>Time Remaining: {formattedTime}</h2>
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
                            <h3>{question.questionName}</h3>
                            {Object.values(question.options).map(
                              (optionValue, optionIndex) => (
                                <p
                                  key={optionIndex}
                                  className="question-card-text"
                                >
                                  {optionIndex + 1}:
                                  <Input
                                    type="radio"
                                    name={`options-${question.questionId}`}
                                    value={optionValue}
                                    onChange={() =>
                                      handleOptionChange(
                                        question.questionId,
                                        optionValue,
                                        question.answer
                                      )
                                    }
                                    checked={
                                      selectedAnswers[question.questionId] ===
                                      optionValue
                                    }
                                    disabled={submitted}
                                  />
                                  {optionValue}
                                </p>
                              )
                            )}
                          </form>
                        </div>
                      </div>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
            <div>
              <Button
                onClick={handleSubmit}
                disabled={submitted}
                children="Submit Answers"
              >
                
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserTest;
