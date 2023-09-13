import React,{useEffect, useState} from 'react'
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
    window.history.pushState(null, '', '/adminDashboard');
    window.addEventListener('popstate', () => {
      window.history.pushState(null, '', '/adminDashboard');
    });
  }, []);

  return (
    <>
    {(valid === "true" && IsLoggedIn === "true") ?(
    <div className="admin-dashboard">
      <Sidebar />
      <div className="dashboard-content">
        <DashboardCard title="Categories" link="/category/all" />
        <DashboardCard title="Quizzes" link="/quiz/all" />
        <DashboardCard title="Results" link="/admin/results" />
      </div>
    </div>) : (navigate("/error-page"))}
    </>
  );
};

export default AdminDashboard;
