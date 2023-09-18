import React, { useEffect, useState } from "react";
import Sidebar from "./Sidebar";
import DashboardCard from "./DashboardCard";
import "./AdminDashboard.css";
import { useNavigate } from "react-router-dom";

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
          <Sidebar />
          <div className="dashboard-content">
            <DashboardCard
              title="Categories"
              link="/category/all"
              description="Test your knowledge on a wide range of topics in our Technology category. 
        Challenge yourself with questions that cover a diverse array of subjects and expand your horizons."
            />
            <DashboardCard
              title="Quizzes"
              link="/quiz/all"
              description="Test your knowledge with our Trivia Quiz! This quiz covers a wide range of topics of Technology.
         Challenge yourself and see how well-rounded your knowledge is. Have fun and learn something new!"
            />
            <DashboardCard
              title="Results"
              link="/admin/results"
              description="Congratulations to the top scorers of our Quiz! 
        Check out their impressive results and get inspired to improve your own knowledge and skills. Keep challenging yourself!"
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
