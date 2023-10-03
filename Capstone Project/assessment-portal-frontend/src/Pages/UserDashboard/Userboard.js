import React from "react";
import "./UserDashboard.css";
import DashboardCard from "../../Component/Card component/DashboardCard";
import Sidebar from "../../Component/Sidebar component/Sidebar";
import Error from "../../Component/Error component/Error";


const UserDashboard = () => {
  const role = localStorage.getItem("role");
  if (role !== "user") {
    return <Error/>;
  }
  return (
    <div className="user-dashboard">
      <Sidebar dashboardType={"user"}/>
      <div className="dashboard-content">
        <DashboardCard
          title="Categories"
          link="/category/all"
          description="Test your knowledge with our Trivia Quiz! This quiz covers a wide range of topics of Technology.
        Challenge yourself and see how well-rounded your knowledge is. Have fun and learn something new!"
          className="User-dashboard-card"
       />
        <DashboardCard
          title="Quizzes"
          link="/quiz/all"
          description="Test your knowledge with our Trivia Quiz! This quiz covers a wide range of topics of Technology.
         Challenge yourself and see how well-rounded your knowledge is. Have fun and learn something new!"
         className="User-dashboard-card"
        />
        <DashboardCard
          title="Results"
          link="/results"
          description="Congratulations to the top scorers of our Quiz! 
        Check out their impressive results and get inspired to improve your own knowledge and skills. Keep challenging yourself!"
          className="User-dashboard-card"
        />
      </div>
    </div>
  );
};

export default UserDashboard;
