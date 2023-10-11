import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import Swal from "sweetalert2";
import Button from "../../Component/Button component/Button";
import Input from "../../Component/Input component/Input";
import { useEffect } from "react";
import candidateService from "../../Services/candidateService";

const Register = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const emailRegex = /^[a-zA-Z0-9.]+@nucleusTeq\.com$/;
  const passwordRegex =
    /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.* ).{8,16}$/;
  const phoneRegex = /^[0-9]{10}$/;

  useEffect(() => {
      const isLoggedIn = localStorage.getItem('IsLoggedIn');
      const userRole = localStorage.getItem('role');

      if (isLoggedIn === 'true') {
          if (userRole === 'admin') {
              navigate('/adminDashboard');
          } else{
              navigate('/userDashboard');
          }
      }
  }, [navigate]);

  const validateForm = () => {
    if (firstName === "" || lastName === "") {
      setErrorMessage("Please fill in all required fields.");
      return false;
    }

    if (!emailRegex.test(email)) {
      setErrorMessage("enter a valid email");
      return false;
    }
    

    if (!passwordRegex.test(password)) {
      setErrorMessage(
        "Password must contain one digit from 1 to 9, one lowercase letter, one uppercase letter, one special character, no space, and it must be 8-16 characters long."
      );
      return false;
    }

    if (!phoneRegex.test(phoneNumber)) {
      setErrorMessage("Enter a valid phone number.");
      return false;
    }
    setErrorMessage(""); 
    return true;
  };

  const handleRegisterClick = async (event) => {
    event.preventDefault();
    if (validateForm()) {
      const candidate = {firstName, lastName, phoneNumber, email, password}
      candidateService.register(candidate).then((response) => {
        Swal.fire({
          title: "Success",
          text: "User registered successfully",
          icon: "success",
          timer:2000,
          showConfirmButton:false
        });
        if(response.status===201){
          navigate("/")
        }
        setSuccessMessage("Registration successful. Please log in.");
        setErrorMessage("");
      }).catch ((error) => { 
        if (error.response.data) {
          const submitError=error.response.data.message;
          Swal.fire({
            title: "Error",
            text: `${submitError}`,
            icon: "error",
            confirmButtonText: "Retry",
            confirmButtonColor:"red"
          });
        } else {
          Swal.fire({
            title: "Login Failed",
            text: "Server is currently unavailable .Please try again later",
            icon: "error",
          });
        }
      })
    }
  };

  const redirectToLogin = () => {
    navigate("/");
  };

  return (
    <div className="register-container">
      <div className="portal-form-container">
        <form className="portal-form" onSubmit={handleRegisterClick}>
          <div className="portal-form-content">
            <h3 className="text-center"><b>Sign Up</b></h3>
            {successMessage && (
          <div className="custom-message success">{successMessage}</div>
            )}
            {errorMessage && (
              <div className="custom-message error">{errorMessage}</div>
            )}

            <div className="form-group mt-3">
              <Input
                type="text"
                id="firstName"
                className="form-control mt-1"
                onChange={(e) => setFirstName(e.target.value)}
                value={firstName}
                placeholder="Enter your first name"
              />
              {errorMessage && !firstName && (
                <div className="custom-error">
                  Please enter your First name.
                </div>
              )}
            </div>
            <div className="form-group mt-3">
              <Input
                type="text"
                id="lastName"
                className="form-control mt-1"
                onChange={(e) => setLastName(e.target.value)}
                value={lastName}
                placeholder="Enter your last name"
              />
              {errorMessage && !lastName && (
                <div className="custom-error">Please enter your Last name.</div>
              )}
            </div>
            <div className="form-group mt-3">
              <Input
                type="tel"
                id="phoneNumber"
                className="form-control mt-1"
                onChange={(e) => setPhoneNumber(e.target.value)}
                value={phoneNumber}
                placeholder="Enter your phone number"
              />
              {errorMessage && !phoneNumber && (
                <div className="custom-error">
                  Please enter your phone number.
                </div>
              )}
              {errorMessage && phoneNumber && !phoneRegex.test(phoneNumber) && (
                <div className="custom-error">
                  Please provide a valid 10-digit phone number.
                </div>
              )}
            </div>
            <div className="form-group mt-3">
              <Input
                type="email"
                id="email"
                className="form-control mt-1"
                onChange={(e) => setEmail(e.target.value)}
                value={email}
                placeholder="Enter your email"
              />
              {errorMessage && !email && (
                <div className="custom-error">
                  Please enter your email address.
                </div>
              )}
              {errorMessage && email && !emailRegex.test(email) && (
                <div className="custom-error">
                  email should be end with @nucleusTeq.com.
                </div>
              )}
            </div>
            <div className="form-group mt-3">
              <Input
                type="password"
                id="password"
                className="form-control mt-1"
                onChange={(e) => setPassword(e.target.value)}
                value={password}
                placeholder="Enter your password"
              />
              {errorMessage && !password && (
                <div className="custom-error">Please enter a password.</div>
              )}
              {errorMessage && password && !passwordRegex.test(password) && (
                <div className="custom-error">
                  Password must contain one digit from 1 to 9, one lowercase
                  letter, one uppercase letter, one special character, no space,
                  and it must be 8-16 characters long.
                </div>
              )}
            </div>
            <div className="d-grid gap-2 mt-3">
              <Button className="btn btn-primary" children="Submit"></Button>
            </div>
            <div className="text-center my-3">
              Already registered?{" "}
              <span
                className="link-primary"
                style={{ cursor: "pointer" }}
                onClick={redirectToLogin}
              >
                Login
              </span>
            </div>
          </div>
        </form>
      </div>
    </div>
    
  );
};

export default Register;
