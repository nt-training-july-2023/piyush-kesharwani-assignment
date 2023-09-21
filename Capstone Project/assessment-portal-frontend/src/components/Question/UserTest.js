import React, { useState ,useEffect} from 'react'
import { useParams } from 'react-router-dom';
import questionService from '../../Services/questionService';
import quizService from '../../Services/quizService';

const UserTest = () => {
    const [questions, setQuestions] = useState([])
    const [totalMarks, setTotalMarks] = useState();
    const [obtainedMarks, setObtainedMarks] = useState();
    const [userEmail,setUserEmail ] = useState();
    const [userName,setUserName ] = useState();
    const [dateTime,setDateTime ] = useState();
    const [quizName,setQuizName ] = useState();
    const [categoryName,setCategoryName ] = useState();
    const { quizId } = useParams();
       
    useEffect(() => {
       getQuestionByQuiz();
       getQuizById();
    }, [])

    const getQuizById=() =>{
        quizService.getQuizById(quizId).then(response =>{
            setQuizName(response.data.quizName);
            setCategoryName(response.data.category.categoryName);
            // console.log(response.data.category.categoryName);
        }).catch((error) => {
            console.log(error);
        })
    }

    const getQuestionByQuiz = () => {
        quizService
          .getAllQuestionByQuiz(quizId)
          .then((response) => {
            setQuestions(response.data);
          })
          .catch((error) => {
            console.log(error);
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
                            <h4>{question.questionName}</h4>
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
  )
}

export default UserTest