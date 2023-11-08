import React, { useState, useEffect } from "react";
import resultService from "../../Services/resultService";
import "./Result.css";
import Error from "../../Component/Error component/Error";
import NoDataPage from "../../Component/NoDataFound/NoDataPage";
import Navbar from "../../Component/Navbar component/Navbar";
import Input from "../../Component/Input component/Input";

const Result = () => {
  // const [results, setResults] = useState([]);
  // const [role, setRole] = useState(localStorage.getItem("role"));
  // const [userEmail, setUserEmail] = useState(localStorage.getItem("email"));
  // const [searchQuery, setSearchQuery] = useState('');

  // useEffect(() => {
  //   setRole(localStorage.getItem("role"));
  //   setUserEmail(localStorage.getItem("email"));
  //   getResults();
  // }, [userEmail]);

  // const getResults = () => {
  //   if (role === "user") {
  //     resultService
  //       .findByEmailId(userEmail)
  //       .then((response) => {
  //         const filteredResults = filterResults(response.data);
  //         setResults(filteredResults);
  //       })
  //       .catch((error) => {
  //         console.error(error);
  //       });
  //   } else {
  //     resultService.getAll().then((response) => {  
  //     const filteredResults = filterResults(response.data);
  //         setResults(filteredResults);
  //     });
  //   }
  // };

  // const filterResults = (data) => {
  //   return data.filter((result) => {
  //     return (
  //       result.userName.toLowerCase().includes(searchQuery.toLowerCase()) ||
  //       result.userEmail.toLowerCase().includes(searchQuery.toLowerCase()) ||
  //       result.categoryName.toLowerCase().includes(searchQuery.toLowerCase()) ||
  //       result.dateTime.toLowerCase().includes(searchQuery.toLowerCase()) ||
  //       result.quizName.toLowerCase().includes(searchQuery.toLowerCase())
  //     );
  //   });
  // };

  // const handleSearchChange = (event) => {
  //   setSearchQuery(event.target.value);
  // };

  const role = localStorage.getItem('role');
  const userEmail = localStorage.getItem('email');
  const [results, setResults] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  
  useEffect(() => {
    loadReports();
  }, [userEmail, searchQuery]);
  
  const loadReports = async () => {
    try {
      let response;
      if (role === 'user') {
        response = await resultService.findByEmailId(userEmail);
      } else {
        response = await resultService.getAll();
      }
      const data = response.data;
  
      data.sort((a, b) => {
        const dateA = new Date(a.dateTime).getTime();
        const dateB = new Date(b.dateTime).getTime();
        return dateB - dateA;
      });
  
      const filteredReports = data.filter((report) =>
        report.userName.toLowerCase().includes(searchQuery.toLowerCase()) ||
        report.userEmail.toLowerCase().includes(searchQuery.toLowerCase()) ||
        report.quizName.toLowerCase().includes(searchQuery.toLowerCase()) ||
        report.dateTime.toLowerCase().includes(searchQuery.toLowerCase())
      );
  
      setResults(filteredReports);
  
    } catch (error) {
      console.error('Error fetching questions:', error);
    }
  };
  
  const handleSearchChange = (event) => {
    setSearchQuery(event.target.value);
  };

  return (
    <div>
      <Navbar />
      {role === "admin" || role === "user" ? (
        <>
          <div className="result-container">
            <h2>RESULTS</h2>
            <div className="search-bar-container">
            <Input
              type="text"
              placeholder="Search results"
              value={searchQuery}
              onChange={handleSearchChange}
              className="search-bar"
            />
          </div>
            {results.length === 0 ? (
              <NoDataPage />
            ) : (
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
                      <td className="result-data">
                        {result.attemptedQuestion}
                      </td>
                      <td className="result-data">{result.totalMarks}</td>
                      <td className="result-data">{result.obtainedMarks}</td>

                      <td className="result-data">{result.dateTime}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            )}
          </div>
        </>
      ) : (
        <Error />
      )}
    </div>
  );
};

export default Result;
