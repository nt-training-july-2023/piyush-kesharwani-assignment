import React, { useState } from "react";
import axios from "axios";
import { useNavigate} from 'react-router-dom';
import "./Login.css";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/candidate/login",
        {
          email,
          password,
        });
      console.log("Login successful!", response.data);
    } catch (error) {
      console.error("Login failed:", error);
    }
  };

  const Register =()=>{
       navigate('/Register')
  }

  return (
    <div className="Portal-container">
      <form className="portal-form" onSubmit={handleLogin}>
        <div className="portal-form-content">
            <div>
                <h2 className="text-center">Login</h2>
            </div>
          <div className="form-group">
            <label htmlFor="exampleInputEmail1">Email address</label>
            <input
              type="email"
              className="form-control"
              id="exampleInputEmail1"
              aria-describedby="emailHelp"
              placeholder="Enter email"
              onChange={(e) => setEmail(e.target.value)}
              value={email}
              required
            />
          </div>
          <div className="form-group my-3">
            <label htmlFor="exampleInputPassword1">Password</label>
            <input
              type="password"
              className="form-control"
              id="exampleInputPassword1"
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
              value={password}
              required
            />
          </div>
          <button type="submit" className="btn btn-primary my-3">
            Login
          </button>
          <div className="register-link">
            Not a member ?<span className="link-primary" style={{cursor:"pointer"}} onClick={Register}>  Register here</span>
          </div>
        </div>
      </form>
    </div>
  );
}

export default Login;
