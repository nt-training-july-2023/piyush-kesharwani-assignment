import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import Swal from 'sweetalert2';

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const IsLoggedIn = localStorage.getItem("IsLoggedIn");

  const validateForm = () => {
    if (!email || !password) {
      setErrorMessage("Please enter both email and password.");
      return false;
    }
    setErrorMessage(""); // Clear error message if validation passes
    return true;
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      try {
        const response = await axios.post(
          "http://localhost:8080/candidate/login",
          {
            email,
            password,
          }
        );
        Swal.fire({
          title: "Success",
          text: "Login Successful",
          icon: "success",
          timer:2000,
          showConfirmButton:false
        });
        console.log(response.data);
        if (response.data && response.data.status === "true") {
          if (response.data.role === "admin") {
            navigate("/AdminDashboard");
          } else if (response.data.role === "user") {
            navigate("/UserDashboard");
          }
        } else {
          setErrorMessage("Login failed. " + response.data.message);
        }
        localStorage.setItem("IsLoggedIn",true);
        localStorage.setItem("role",response.data.role)
        localStorage.setItem('email' , response.data.email);
        localStorage.setItem('userName' , response.data.userName);


      } catch (error) {
        setErrorMessage("Wrong Credentials");
        const submitError = error.response.data.message;
        Swal.fire({
          title: "Error",
          text: `${submitError}`,
          icon: "error",
          confirmButtonText: "Retry",
          confirmButtonColor:"red"
        });
        setEmail('');
        setPassword('');
        console.error("Login failed:", error);
      }
    }
  };

  const handleRegisterClick = () => {
    navigate("/Register");
  };

  return (
    <div className="login-container">
      <form className="portal-form" onSubmit={handleLogin}>
        <div className="portal-form-content">
          <div>
            <h2 className="text-center"><b>Login</b></h2>
          </div>
          {errorMessage && <div className="custom-error">{errorMessage}</div>}
          <div className="form-group">
            <input
              type="email"
              className="form-control"
              id="exampleInputEmail1"
              aria-describedby="emailHelp"
              placeholder="Enter email"
              onChange={(e) => {
                setEmail(e.target.value);
                setErrorMessage("");
              }}
              value={email}
            />
          </div>
          <div className="form-group my-3">
            <input
              type="password"
              className="form-control"
              id="exampleInputPassword1"
              placeholder="Password"
              onChange={(e) => {
                setPassword(e.target.value);
                setErrorMessage("");
              }}
              value={password}
            />
          </div>
          <button type="submit" className="btn btn-primary my-3">
            Login
          </button>
          <div className="register-link">
            Not a member?{" "}
            <span
              className="link-primary"
              style={{ cursor: "pointer" }}
              onClick={handleRegisterClick}
            >
              Register here
            </span>
          </div>
        </div>
      </form>
    </div>
  );
};

export default Login;
