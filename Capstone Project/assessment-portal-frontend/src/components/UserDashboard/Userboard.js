import React from "react";
import Sidebar from "./Sidebar";
import DashboardCard from "./DashboardCard";
import "./UserDashboard.css";
// import {} from "react-router-dom";

const UserDashboard = () => {
  return (
    <div className="user-dashboard">
      <Sidebar />
      <div className="dashboard-content">
        <DashboardCard title="Categories" link="/category/all" />
        <DashboardCard title="Quizzes" />
        <DashboardCard title="Results" />
      </div>
    </div>
  );
};

export default UserDashboard;
