import React, { useEffect, useState} from 'react'
import { useNavigate } from 'react-router-dom';
import "./Error.css"

const Error = () => {
  const navigate = useNavigate();

  const [valid, setValid] = useState("");
  const result = localStorage.getItem("role");
  const IsLoggedIn = localStorage.getItem("IsLoggedIn");

  useEffect(() => {
    if (result === "admin") {
      setValid("true");
    } else {
      setValid("false");
    }
  },[result]);

  const handleNavigate = () =>{
    if(valid==="true" && IsLoggedIn==="true"){
      navigate('/adminDashboard')
    }
    else if(valid==="false" && IsLoggedIn==="true"){
      navigate("/userDashboard")
    }else{
      navigate("/")
    }
  }

  return (
    <div className='error-page'>
      <h1 className="errorh2">403</h1>
      <h1 className='errorh2'>Unauthorized Access</h1>
      <button onClick = {handleNavigate}>
        GO BACK!
      </button>
    </div>
  )
}

export default Error