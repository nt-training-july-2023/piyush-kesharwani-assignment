import React, { useState , useEffect} from 'react'
import resultService from '../../Services/resultService';
import "./Result.css";
import Error from '../../Component/Error component/Error';

const Result = () => {
    const [results, setResults] = useState([])
    const [role, setRole] = useState(localStorage.getItem('role'));
    const [userEmail, setUserEmail] = useState(localStorage.getItem('email'));

    useEffect(() => {
        setRole(localStorage.getItem('role'));
        setUserEmail(localStorage.getItem('email'));
        getResults();
      }, [userEmail])

      const getResults = () =>{
        if (role==='user') {
        resultService.findByEmailId(userEmail).then((response)=>{
            setResults(response.data);
        }).catch((error) => {
            console.error(error);
          })
        } else{
            resultService.getAll().then((response)=>{
                setResults(response.data);
            })
        }
      }

  return (
    <>
    {(role === 'admin' || role === 'user') ? (<>
    <div className="result-container">
    <h2>Result Page</h2>
    <table className="result-table">
      <thead>
        <tr>
          <th className="result-header">Email</th>
          <th className="result-header">Name</th>
          <th className="result-header">Quiz Name</th>
          <th className="result-header">Category Name</th>
          <th className="result-header">Total Questions</th>
          <th className="result-header">Attempted Questions</th>
          <th className="result-header">Total Marks</th>
          <th className="result-header">Obtained Marks</th>
          <th className="result-header">Date and Time</th>
        </tr>
      </thead>
      <tbody>
        {results.map((result, index) => (
          <tr key={index}>
            <td className="result-data">{result.userEmail}</td>
            <td className="result-data">{result.userName}</td>
            <td className="result-data">{result.quizName}</td>
            <td className="result-data">{result.categoryName}</td>
            <td className="result-data">{result.totalQuestion}</td>
            <td className="result-data">{result.attemptedQuestion}</td>
            <td className="result-data">{result.totalMarks}</td>
            <td className="result-data">{result.obtainedMarks}</td>
           
            <td className="result-data">
              {result.dateTime}
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
  </>) :(<Error/>)}
  </>
  )
}

export default Result