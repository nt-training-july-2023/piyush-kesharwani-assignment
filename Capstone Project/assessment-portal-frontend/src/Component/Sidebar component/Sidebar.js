import React from "react";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";
import "./Sidebar.css";

const Sidebar = ({ dashboardType }) => {
  const navigate = useNavigate();

  const handleLogoutConfirmation = () => {
    Swal.fire({
      text: "Confirm Logout?",
      icon: "warning",
      showCancelButton: true,
      showConfirmButton: true,
    }).then((result) => {
      if (result.isConfirmed) {
        loggedOut();
      }
    });
  };

  const loggedOut = () => {
    navigate("/");
    Swal.fire({
      text: "You've successfully logged out!",
      icon: "success",
      timer: 2000,
      showConfirmButton: false,
    });
    localStorage.removeItem("IsLoggedIn");
    localStorage.removeItem("role");
    localStorage.removeItem("email");
    localStorage.removeItem("userName");
    navigate("/");
  };

  return (
    <div className="sidebar">
      <h1>
        {dashboardType === "admin" ? "Admin Dashboard" : "User Dashboard"}
      </h1>
      <ul className="nav-links">
        <li>
          <Link to="/category/all">&#x1F4C1; Categories</Link>
        </li>
        <li>
          <Link to="/quiz/all">&#x1F4C3; Quizzes</Link>
        </li>
        {dashboardType === "admin" ? (
          <li>
            <Link to="/question/all">&#x2753; Questions</Link>
          </li>
        ) : (
          <></>
        )}
        <li>
          <Link to="/results">&#x1F4CB; Results</Link>
        </li>
        <li>
          <button className="quiz-cancel" onClick={handleLogoutConfirmation}>Logout</button>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;
