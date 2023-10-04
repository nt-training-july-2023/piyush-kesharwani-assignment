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
  localStorage.setItem("dateTime", dateTime);
  const { quizId } = useParams();
  const navigate = useNavigate();
  const role = localStorage.getItem("role");

  useEffect(() => {
    const prevCount = parseInt(localStorage.getItem("reloadAttempts")) || 0;
    const newCount = prevCount + 1;
    localStorage.setItem("reloadAttempts", newCount.toString());

    if (
      localStorage.getItem("reloadAttempts") >= 3 &&
      localStorage.getItem("reloadAttempts") <= 6
    ) {
      Swal.fire({
        title: "If you refresh the page, the test will be submitted",
        showDenyButton: true,
        confirmButtonText: "Submit Test",
        denyButtonText: "Cancel",
        customClass: {
          actions: "my-actions",
          cancelButton: "order-1 right-gap",
          confirmButton: "order-2",
          denyButton: "order-3",
        },
      }).then((result) => {
        if (result.isConfirmed) {
          handleSubmit();
          console.log("Submitted successfully");
        }
      });
    } else if (localStorage.getItem("reloadAttempts") > 6) {
      handleSubmit();
      console.log("Submitted successfully");
    }
  }, []);

  useEffect(() => {
    const storedSelectedAnswers = localStorage.getItem("selectedAnswers");
    if (storedSelectedAnswers) {
      setSelectedAnswers(JSON.parse(storedSelectedAnswers));
    }
    const storedTimer = localStorage.getItem("timerinSecond");
    if (storedTimer) {
      const timerinSecond = parseInt(storedTimer);
      setTimeinSeconds(timerinSecond);
    }
    getQuestionByQuiz();
    getQuizById();
  }, []);

  useEffect(() => {
    if (role === "user") {
      const handleCountdown = () => {
        if (timeinSeconds > 0) {
          setTimeinSeconds((prevTime) => prevTime - 1);
          localStorage.setItem("timerinSecond", (timeinSeconds - 1).toString());
        } else {
          handleSubmit();
        }
      };
      const countdownInterval = setInterval(handleCountdown, 1000);
      return () => clearInterval(countdownInterval);
    }
  }, [timeinSeconds]);

  const formattedTime = new Date(timeinSeconds * 1000)
    .toISOString()
    .substr(11, 8);

  const getQuizById = () => {
    const storedTimer = localStorage.getItem("timerinSecond");
    quizService
      .getQuizById(quizId)
      .then((response) => {
        localStorage.setItem("quizName", response.data.quizName);
        localStorage.setItem(
          "categoryName",
          response.data.category.categoryName
        );
        setQuizName(response.data.quizName);
        setCategoryName(response.data.category.categoryName);
        const timer = response.data.time;
        const timerinSecond = timer * 60;
        if (!storedTimer) {
          setTimeinSeconds(timerinSecond);
          localStorage.setItem("timerinSecond", timerinSecond.toString());
        }
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const getQuestionByQuiz = () => {
    quizService
      .getAllQuestionByQuiz(quizId)
      .then((response) => {
        setQuestions(response.data);
        setTotalMarks(response.data.length);
        setTotalQuestion(response.data.length);
        localStorage.setItem("totalMarks", response.data.length);
        localStorage.setItem("totalQuestion", response.data.length);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const handleOptionChange = (questionId, selectedOption, correctAnswer) => {
    // if (!submitted) {
    //   setSelectedAnswers((prevSelectedAnswers) => ({
    //     ...prevSelectedAnswers,
    //     [questionId]: selectedOption,
    //   }));

    //   localStorage.setItem("selectedAnswers", JSON.stringify({
    //     ...selectedAnswers,
    //     [questionId]: selectedOption,
    //   }));
    // }
    if (!submitted) {
      setSelectedAnswers((prevSelectedAnswers) => {
        const updatedSelectedAnswers = {
          ...prevSelectedAnswers,
          [questionId]: selectedOption,
        };

        localStorage.setItem(
          "selectedAnswers",
          JSON.stringify(updatedSelectedAnswers)
        );

        calculateMarks(updatedSelectedAnswers);

        return updatedSelectedAnswers;
      });
    }
  };

  const calculateMarks = (updatedSelectedAnswers) => {
    let score = 0;
    for (const question of questions) {
      const questionId = question.questionId;
      if (updatedSelectedAnswers[questionId] === question.answer) {
        score += 1;
      }
    }
    setObtainedMarks(score);
    setAttemptedQuestion(Object.keys(updatedSelectedAnswers).length);
    localStorage.setItem("obtainedMarks", score);
    localStorage.setItem(
      "attemptedQuestion",
      Object.keys(updatedSelectedAnswers).length
    );
  };

  const handleSubmit = (e) => {
    if (e) {
      e.preventDefault();
    }
    setSubmitted(true);

    const result = {
      totalMarks: localStorage.getItem("totalMarks"),
      obtainedMarks: localStorage.getItem("obtainedMarks"),
      userEmail: localStorage.getItem("email"),
      userName: localStorage.getItem("userName"),
      dateTime: localStorage.getItem("dateTime"),
      quizName: localStorage.getItem("quizName"),
      categoryName: localStorage.getItem("categoryName"),
      attemptedQuestion: localStorage.getItem("attemptedQuestion"),
      totalQuestion: localStorage.getItem("totalQuestion"),
    };
    resultService.saveResult(result).then((response) => {
      Swal.fire({
        title: "Test Submitted",
        text: "Test Submitted successfully",
        icon: "success",
        timer: 2000,
        showConfirmButton: false,
      });
      localStorage.removeItem("timerinSecond");
      localStorage.removeItem("selectedAnswers");
      localStorage.removeItem("totalMarks");
      localStorage.removeItem("obtainedMarks");
      localStorage.removeItem("dateTime");
      localStorage.removeItem("quizName");
      localStorage.removeItem("categoryName");
      localStorage.removeItem("attemptedQuestion");
      localStorage.removeItem("totalQuestion");
      localStorage.removeItem("reloadAttempts");
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
                      <div className="question-card" key={index}>
                        <div className="question-card-header">
                          <h3>{question.quiz.quizName}</h3>
                        </div>
                        <div className="question-card-body">
                          <form>
                            <h3>
                              {++index} : {question.questionName}
                            </h3>
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
                className="button-update-question"
                onClick={handleSubmit}
                disabled={submitted}
                children="Submit Answers"
              ></Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserTest;
