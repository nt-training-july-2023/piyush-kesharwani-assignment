import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import questionService from "../../Services/questionService";
import quizService from "../../Services/quizService";
import resultService from "../../Services/resultService";

const UserTest = () => {
  const [questions, setQuestions] = useState([]);
  const [totalMarks, setTotalMarks] = useState(0);
  const [totalQuestion , setTotalQuestion] = useState(0);
  const [obtainedMarks, setObtainedMarks] = useState(0);
  const [quizName, setQuizName] = useState();
  const [time, setTime] = useState(0);
  const [remainingTime , setRemainingTime] = useState(0);
  const [attemptedQuestion, setAttemptedQuestion] = useState(0);
  const [submitted, setSubmitted] = useState(false);
  const [selectedAnswers, setSelectedAnswers] = useState({});
  const [categoryName, setCategoryName] = useState();
  const dateTime = "12/07/23";
  const userName = localStorage.getItem("userName");
  const userEmail = localStorage.getItem("email");
  const { quizId } = useParams();

  useEffect(() => {
    getQuestionByQuiz();
    getQuizById();
    console.log(obtainedMarks);
    console.log(attemptedQuestion);
  }, [obtainedMarks, attemptedQuestion]);
 
  useEffect(() => {       
    setRemainingTime(time*60);
    const timer = setInterval(() => {
        setRemainingTime((prevTime) => {
            if (prevTime > 0) {
                return prevTime - 1;
            } else {
                
                handleSubmit();
                clearInterval(timer);
                return 0;
            }
        });
    }, 1000); 

    return () => clearInterval(timer); 
}, [time]);

  const getQuizById = () => {
    quizService
      .getQuizById(quizId)
      .then((response) => {
        setQuizName(response.data.quizName);
        setTime(response.data.time);
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
        console.log(response.data);
        console.log("Length",response.data.length);
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
    e.preventDefault();
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
      totalMarks ,obtainedMarks:score , userEmail, userName ,dateTime , quizName, categoryName,
      attemptedQuestion :Object.keys(selectedAnswers).length , totalQuestion
    }
    resultService.saveResult(result).then((response)=>{
      console.log(response.data);
    })
  };

  return (
    <div className="question-wrapper">
      <div className="question-container">
        <div className="question-sidebar-column"></div>
        <div className="question-column">
          <div className="question-main-card">
            <div className="question-card-header-main">
              <h2>Test : {quizName}</h2>
              <h2>Time Remaining: {Math.floor(remainingTime / 60)}:{remainingTime % 60}</h2>
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
                                  <input
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
              <button
                onClick={handleSubmit}
                style={{
                  backgroundColor: "blue",
                  color: "white",
                }}
                disabled={submitted}
              >
                Submit Answers
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>

    // <div>
    //   <h2>Test: {quizName}</h2>
    //   {showResults ? (
    //     <div>
    //       <h3>Results:</h3>
    //       <p>Total Questions: {calculateTotalMarks()}</p>
    //       <p>Attempted Questions: {calculateObtainedMarks().attemptedQuestions}</p>
    //       <p>Obtained Marks: {calculateObtainedMarks().obtainedMarks}</p>
    //     </div>
    //   ) : (
    //     <div>
    //       <ul>
    //         {questions.map((question) => (
    //           <li key={question.questionId}>
    //             <h4>{question.questionName}</h4>
    //             <form>
    //               {Object.keys(question.options).map((optionKey) => (
    //                 <label key={optionKey}>
    //                   <input
    //                     type="radio"
    //                     name={`question_${question.questionId}`}
    //                     value={optionKey}
    //                     onChange={() =>
    //                       handleAnswerSelect(question.questionId, optionKey)
    //                     }
    //                     checked={userAnswers[question.questionId] === optionKey}
    //                   />
    //                   {question.options[optionKey]}
    //                 </label>
    //               ))}
    //             </form>
    //           </li>
    //         ))}
    //       </ul>
    //       <button onClick={handleSubmit}>Submit</button>
    //     </div>
    //   )}
    // </div>
  );
};

export default UserTest;
