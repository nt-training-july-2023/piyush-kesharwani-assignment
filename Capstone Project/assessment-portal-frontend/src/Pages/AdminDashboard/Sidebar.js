import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "./AdminDashboard.css";
import Swal from "sweetalert2";

const Sidebar = () => {
  const navigate = useNavigate();

  const handleLogoutConfirmation =() =>{
    Swal.fire({
      text:"Confirm Logout?",
      icon:"warning",
      showCancelButton:true,
      showConfirmButton:true,
    }).then((result)=>{
      if(result.isConfirmed){
        loggedOut();
      }
      });
  }

  const loggedOut = ()=> {
    navigate('/')
    Swal.fire({
      text: "You've successfully logged out!",
      icon: "success",
      timer: 2000,
      showConfirmButton:false
    });
    localStorage.removeItem("IsLoggedIn");
    localStorage.removeItem("role");
    localStorage.removeItem('email');
    localStorage.removeItem('userName');
    navigate('/');
  }
  return (
    <div className="sidebar">
      <h1>Admin Dashboard</h1>
      <ul className="nav-links">
        <li>
          <Link to="/category/all">Categories</Link>
        </li>
        <li>
          <Link to="/quiz/all">Quizzes</Link>
        </li>
        <li>
          <Link to="/question/all">Questions</Link>
        </li>
        <li>
          <Link to="/results">Results</Link>
        </li>
        <li>
        <button onClick={handleLogoutConfirmation}>Logout</button>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;
