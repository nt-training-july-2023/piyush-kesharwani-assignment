import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import Swal from "sweetalert2";
import Button from "../../Component/Button component/Button";
import Input from "../../Component/Input component/Input";
import { useEffect } from "react";
import candidateService from "../../Services/candidateService";

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
    setErrorMessage("");
    return true;
  };

  useEffect(() => {
    const isLoggedIn = localStorage.getItem("IsLoggedIn");
    const userRole = localStorage.getItem("role");

    if (isLoggedIn === "true") {
      if (userRole === "admin") {
        navigate("/adminDashboard");
      } else if (userRole === "user") {
        navigate("/userDashboard");
      }
    }
  }, [navigate]);

  const handleLogin = async (e) => {
    e.preventDefault();
    if (validateForm()) {
        const candidate = {email , password}
        candidateService.login(candidate).then((response) => {
          Swal.fire({
              title: "Success",
              text: "Login Successful",
              icon: "success",
              timer: 2000,
              showConfirmButton: false,
            });
          if (response.data.role === "admin") {
            navigate("/AdminDashboard");
          } else if (response.data.role === "user") {
            navigate("/UserDashboard");
          }
        localStorage.setItem("IsLoggedIn", true);
        localStorage.setItem("role", response.data.role);
        localStorage.setItem("email", response.data.email);
        localStorage.setItem("userName", response.data.userName);
      }).catch ((error) => { 
        if (error.response.data) {
          const submitError = error.response.data.message;
          setErrorMessage("Wrong Credentials");
          Swal.fire({
            title: "Error",
            text: `${submitError}`,
            icon: "error",
            confirmButtonText: "Retry",
            confirmButtonColor: "red",
          });
        } else {
          Swal.fire({
            title: "Login Failed",
            text: "Server is currently unavailable .Please try again later",
            icon: "error",
          });
        }
        setEmail("");
        setPassword("");
      })
    }
  };

  const handleRegisterClick = () => {
    navigate("/Register");
  };

  return (
    <div>
    <div className="login-container">
      <form className="portal-form" onSubmit={handleLogin}>
        <div className="portal-form-content">
          <div>
            <h2 className="text-center">
              <b>Login</b>
            </h2>
          </div>
          <div className="form-group">
            <Input
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
            <Input
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
          {errorMessage && <div className="custom-error">{errorMessage}</div>}
          <Button
            type="submit"
            className="btn btn-primary my-3"
            children=" Login"
          ></Button>
          <div className="register-link">
            Not a member?{" "}
            <span className="link-primary" onClick={handleRegisterClick}>
              Register here
            </span>
          </div>
        </div>
      </form>
      </div>
      </div>
  );
};

export default Login;
