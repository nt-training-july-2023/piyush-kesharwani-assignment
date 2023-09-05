import React from "react";
import Sidebar from "./Sidebar";
import DashboardCard from "./DashboardCard";
import "./AdminDashboard.css";
// import { useNavigate } from "react-router-dom";

const AdminDashboard = () => {
  // const navigate = useNavigate();

  // const [valid, setvalid] = useState("");
  // const result = localStorage.getItem("role");

  return (
    <div className="admin-dashboard">
      <Sidebar />
      <div className="dashboard-content">
        <DashboardCard title="Categories" link="/category/all" />
        <DashboardCard title="Quizzes" link="/admin/quizzes" />
        <DashboardCard title="Results" link="/admin/results" />
      </div>
    </div>
  );
};

export default AdminDashboard;
