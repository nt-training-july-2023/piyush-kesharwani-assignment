import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "./AdminDashboard.css";

const Sidebar = () => {
  const navigate = useNavigate();
  const loggedOut = ()=> {
    localStorage.removeItem("IsLoggedIn");
    localStorage.removeItem("role");
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
          <Link to="/admin/results">Results</Link>
        </li>
        <li>
        <button onClick={loggedOut}>Logout</button>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;
