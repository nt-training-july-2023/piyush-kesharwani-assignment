import React from 'react';
import { useState } from 'react';
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import './Login.css';

const Register = () => {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [phoneNumber, setPhoneNumber] = useState();
    const [email, setEmail ] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate(); 

    const handleRegisterClick =async(event)=>{
        event.preventDefault();

        try{
            const response = await axios.post('http://localhost:8080/candidate/register', { firstName, lastName, phoneNumber, email, password });
            console.log(response.data);
        }catch(error){
            console.error(error.response ? error.response.data: 'An error occurred');
        } 
    }

    const redirectToLogin = () => { 
        navigate('/')
      }

  return (
    <div className="Portal-container">
    <form className="portal-form"  onSubmit={handleRegisterClick}>
      <div className="portal-form-content">
        <h3 className="text-center">Sign Up</h3>
        
        <div className="form-group mt-3">
          <label>First Name</label>
          <input
            type="text"
            className="form-control mt-1"
            onChange={(e) => setFirstName(e.target.value)}
            value={firstName}
            required
          />
        </div>
        <div className="form-group mt-3">
          <label>Last Name</label>
          <input
            type="text"
            className="form-control mt-1"
            onChange={(e) => setLastName(e.target.value)}
            value={lastName}
            required
          />
        </div>
        <div className="form-group mt-3">
          <label>Phone Number</label>
          <input
            type="tel"
            className="form-control mt-1"
            onChange={(e) => setPhoneNumber(e.target.value)}
            value={phoneNumber || ''}
            required
          />
        </div>
        <div className="form-group mt-3">
          <label>Email address</label>
          <input
            type="email"
            className="form-control mt-1"
            onChange={(e) => setEmail(e.target.value)}
            value={email}
            required
          />
        </div>
        <div className="form-group mt-3">
          <label>Password</label>
          <input
            type="password"
            className="form-control mt-1"
            onChange={(e) => setPassword(e.target.value)}
            value={password}
            required
          />
        </div>
        <div className="d-grid gap-2 mt-3">
          <button className="btn btn-primary">
            Submit
          </button>
        </div>
        <div className="text-center my-3">
          Already registered?{" "}
          <span className="link-primary" style={{cursor:"pointer"}} onClick={redirectToLogin}>
            Login
          </span>
        </div>
        
      </div>
    </form>
  </div>
  )
}

export default Register