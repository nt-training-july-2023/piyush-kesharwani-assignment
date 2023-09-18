import React from "react";
import Sidebar from "./Sidebar";
import DashboardCard from "./DashboardCard";
import "./UserDashboard.css";
import Error from "../Error";
// import {} from "react-router-dom";

const UserDashboard = () => {

  const role = localStorage.getItem('role');
      if (role !== 'user') {
        return (
          <Error/>
        );
      }
  return (
    <div className="user-dashboard">
      <Sidebar />
      <div className="dashboard-content">
        <DashboardCard title="Categories" link="/category/all" />
        <DashboardCard title="Quizzes" link="/quiz/all"/>
        <DashboardCard title="Results" />
      </div>
    </div>
  );
};

export default UserDashboard;
