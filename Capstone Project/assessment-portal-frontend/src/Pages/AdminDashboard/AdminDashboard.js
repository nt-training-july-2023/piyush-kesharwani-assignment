import React, { useEffect, useState } from "react";
// import Sidebar from "./Sidebar";
import "./AdminDashboard.css";
import { useNavigate } from "react-router-dom";
import DashboardCard from "../../Component/Card component/DashboardCard";
import Sidebar from "../../Component/Sidebar component/Sidebar";

const AdminDashboard = () => {
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
    window.history.pushState(null, "", "/adminDashboard");
    window.addEventListener("popstate", () => {
      window.history.pushState(null, "", "/adminDashboard");
    });
  }, []);

  return (
    <>
      {valid === "true" && IsLoggedIn === "true" ? (
        <div className="admin-dashboard">
          <Sidebar dashboardType={"admin"}/>
          <div className="dashboard-content">
            <DashboardCard
              title="Manage Categories"
              link="/category/all"
              description="Admins can efficiently manage the categories in our system.
               Add new categories to expand our offerings, 
               update existing ones to keep information current, 
               and delete categories that are no longer relevant."
              className="dashboard-card"
            />
            <DashboardCard
              title="Manage Quizzes"
              link="/quiz/all"
              description="Admins can easily add, update, and delete quizzes. 
              Add new quizzes to expand our collection, update existing ones to keep content fresh, 
              and delete quizzes that are no longer needed."
              className="dashboard-card"
            />
            <DashboardCard
              title="Manage Results"
              link="/results"
              description="Admins can view all user quiz results effortlessly. 
              Gain insights into top scorers, track progress, 
              and inspire users to keep challenging themselves, all in just a few clicks."
              className="dashboard-card"
            />
          </div>
        </div>
      ) : (
        navigate("/error-page")
      )}
    </>
  );
};

export default AdminDashboard;
