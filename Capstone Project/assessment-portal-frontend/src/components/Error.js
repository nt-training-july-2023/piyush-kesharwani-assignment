import React, { useEffect, useState} from 'react'
import { useNavigate } from 'react-router-dom';

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
    <div>
      <h1>Unauthorized Access</h1>
      <button onClick = {handleNavigate}>
        GO BACK!
      </button>
    </div>
  )
}

export default Error