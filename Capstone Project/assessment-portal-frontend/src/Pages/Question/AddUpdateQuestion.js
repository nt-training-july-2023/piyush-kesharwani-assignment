import React, { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import quizService from "../../Services/quizService";
import questionService from "../../Services/questionService";
import "./AddUpdateQuestion.css";
import Swal from "sweetalert2";
import Button from "../../Component/Button component/Button";
import Input from "../../Component/Input component/Input";
import { Label } from "../../Component/Label component/Label";
import { ValidationError } from "../../Component/ValidationError/Validation";

const AddUpdateQuestion = () => {
  const [questionName, setquestionName] = useState("");
  const [options, setOptions] = useState({
    optionOne: "",
    optionTwo: "",
    optionThree: "",
    optionFour: "",
  });
  const [answer, setAnswer] = useState("");
  const [selectedQuiz, setSelectedQuiz] = useState("");
  const [quiz, setQuiz] = useState(null);
  const [quizzes, setQuizzes] = useState([]);
  const [errors, setErrors] = useState('');
  const [allFieldsFilled, setAllFieldsFilled] = useState(false);
  const navigate = useNavigate();
  const { id } = useParams();  
  const {quizId, questionId} = useParams();

  useEffect(() => {
    if(id){
      getQuizById();
    } else{
    getAllQuizzes();
    }
  }, []);

  const getQuizById = () =>{
    quizService.getQuizById(id).then(response =>{
      setQuiz(response.data);
    }).catch((error) =>{
      console.error(error);
    })
  }

  const getAllQuizzes = () => {
    quizService
      .getAllQuiz()
      .then((response) => {
        setQuizzes(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const handleQuizChange = (event) => {
    const quizId = event.target.value;
    quizService
      .getQuizById(quizId)
      .then((response) => {
        const quizObject = response.data;
        setQuiz(quizObject);
      })
      .catch((error) => {
        console.error(error);
      });
    setSelectedQuiz(quizId);
  };

  const handleQuestionFieldChange = (field, value) => {
    const isDuplicate = Object.values(options).some(
      (option) => option.trim() === value.trim() && option.trim() !== ""
    );
  
    if (isDuplicate) {
      setErrors("Each option must have a unique value.");
    } else {
      setErrors("");
    }
    setOptions((prevOptions) => ({
      ...prevOptions,
      [field]: value,
    }));
    const areAllfieldsFilled = Object.values(options).every(
      (option) => option.trim() !== ""
    );
    setAllFieldsFilled(areAllfieldsFilled);
  };


  const validateForm = () => {
    if (
      questionName === "" ||
      options.optionOne === "" ||
      options.optionTwo === "" ||
      options.optionThree === "" ||
      options.optionFour === "" ||
      answer === ""
    ) {
      setErrors("*All the fields are mandatory");
      return true;
    }
    setErrors("");
    return false;
  };

  const saveQuestion = (e) => {
    e.preventDefault();
    if(!validateForm()){
    const payload = {
      quiz: quiz,
      questionName: questionName,
      options: {
        optionOne: options.optionOne,
        optionTwo: options.optionTwo,
        optionThree: options.optionThree,
        optionFour: options.optionFour,
      },
      answer: answer,
    
    };
    

    if (quizId) {
      questionService
        .updateQuestion(questionId, payload)
        .then((response) => {
          Swal.fire({
            icon: "success",
            title: "Question Updated",
            text: "The question has been updated successfully!",
          });
          navigate("/question/all");
        })
        .catch((error) => {
          console.error(error);
        });
    }
    else if (questionId) {
      questionService
        .updateQuestion(questionId, payload)
        .then((response) => {
          Swal.fire({
            icon: "success",
            title: "Question Updated",
            text: "The question has been updated successfully!",
          });
          navigate("/question/all");
        })
        .catch((error) => {
          console.error(error);
        });
    } 
    else {
      questionService
        .addQuestion(payload)
        .then(() => {
          Swal.fire({
            icon: "success",
            title: "Question Added",
            text: "The question has been added successfully!",
          });
          navigate(`/quiz/${id}/question`);
        })
        .catch((error) => {
          console.error(error);
        });
    }
    }

  };

  useEffect(() => {
    if (questionId) {
      questionService
        .getQuestionById(questionId)
        .then((response) => {
          setSelectedQuiz(response.data.quiz.quizId);
          setquestionName(response.data.questionName);
          setOptions({
            optionOne: response.data.options.optionOne,
            optionTwo: response.data.options.optionTwo,
            optionThree: response.data.options.optionThree,
            optionFour: response.data.options.optionFour,
          });
          setAnswer(response.data.answer);
          setQuiz(response.data.quiz);
          const areOptionsFilled = Object.values(response.data.options).every(
            (options) => options.trim() !== ""
          );
          setAllFieldsFilled(areOptionsFilled);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [questionId]);

  return (
    <div className="outer-container">
    <div className="question-form-container">
      <h2 className="question-form-header">
        {questionId ? "Edit Question" : "Add Question"}
      </h2>
      <form onSubmit={saveQuestion}>
        <div className="question-form-group">
          <Label htmlFor="quizSelect" className="question-form-label"
           children ="Select Quiz">
          </Label>
          {id ? (
            <Input
            type="text"
            value= {quiz ? quiz.quizName : "not available"}
            readOnly
            />
          ):(
          <select
            id="quizSelect"
            className="question-form-control"
            value={selectedQuiz}
            onChange={(e) => handleQuizChange(e)}
          >
            <option value="" disabled>Select a quiz</option>
            {quizzes.map((quiz) => (
              <option key={quiz.quizId} value={quiz.quizId}>
                {quiz.quizName}
              </option>
            ))}
          </select>
          )}
        </div>

        <div className="question-form-group">
          <Label htmlFor="questionText" className="question-form-label"
            children = "Question Name">
          </Label>
          <Input
            type="text"
            className="question-form-control"
            id="questionText"
            value={questionName}
            onChange={(e) => setquestionName(e.target.value)}
          />
        </div>

        <div className="question-form-group">
          <Label htmlFor="optionOne" className="question-form-label"
            children = "Option One">
          </Label>
          <Input
            type="text"
            className="question-form-control"
            id="optionOne"
            value={options.optionOne}
            onChange={(e) =>
              handleQuestionFieldChange("optionOne", e.target.value)
            }
          />
        </div>

        <div className="question-form-group">
          <Label htmlFor="optionTwo" className="question-form-label"
            children = "Option Two">
          </Label>
          <Input
            type="text"
            className="question-form-control"
            id="optionTwo"
            value={options.optionTwo}
            onChange={(e) =>
              handleQuestionFieldChange("optionTwo", e.target.value)
            }
          />
        </div>

        <div className="question-form-group">
          <Label htmlFor="optionThree" className="question-form-label"
            children = "Option Three">
          </Label>
          <Input
            type="text"
            className="question-form-control"
            id="optionThree"
            value={options.optionThree}
            onChange={(e) =>
              handleQuestionFieldChange("optionThree", e.target.value)
            }
          />
        </div>

        <div className="question-form-group">
          <Label htmlFor="optionFour" className="question-form-label"
            children = "Option Four">
          </Label>
          <Input
            type="text"
            className="question-form-control"
            id="optionFour"
            value={options.optionFour}
            onChange={(e) =>
              handleQuestionFieldChange("optionFour", e.target.value)
            }
          />
        </div>

        <div className="question-form-group">
          <Label htmlFor="answer"  className="question-form-label"
          children="Correct Answer"></Label>
          <select
            id="answer"
            className="question-form-control"
            value={answer}
            onChange={(e) => setAnswer(e.target.value)}
          >
            <option value="" disabled>
              -- Select an Option --
            </option>
            <option value={options.optionOne}>{options.optionOne}</option>
            <option value={options.optionTwo}>{options.optionTwo}</option>
            <option value={options.optionThree}>{options.optionThree}</option>
            <option value={options.optionFour}>{options.optionFour}</option>
          </select>
        </div>
       <ValidationError errorMessage={errors}/>
        <div>
          <Button className="cat-button" children="Submit"></Button>
          <Link to="/question/all">
            <Button className="quiz-cancel" children="Cancel"></Button>
          </Link>
        </div>
      </form>
    </div>
    </div>
  );
};

export default AddUpdateQuestion;
