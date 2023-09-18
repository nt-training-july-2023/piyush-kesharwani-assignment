import React, { useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import quizService from '../../Services/quizService';

const AddUpdateQuestion = () => {

    const [questionName, setquestionName] = useState("");
    const [options, setOptions] = useState({
        optionOne :"",
        optionTwo : "",
        optionThree :"",
        optionFour : "",
    });
    const [answer, setAnswer] = useState("");
    const [selectedQuiz, setSelectedQuiz] = useState();    
    const [quiz, setQuiz] = useState(null);
    const [quizzes, setQuizzes] = useState([]);
    const [errors, setErrors] = useState('');
    const navigate = useNavigate();
    const {id} = useParams();
    
    useEffect(() => {
        getAllQuizzes();
      }, []);

    const getAllQuizzes =()=>{
        quizService.getAllQuiz.then((response)=>{
          setQuizzes(response.data);
          console.log(response.data);
        }).catch((error)=>{
          console.log(error);
        })
      }
  return (
    <div>AddUpdateQuestion</div>
  )
}

export default AddUpdateQuestion