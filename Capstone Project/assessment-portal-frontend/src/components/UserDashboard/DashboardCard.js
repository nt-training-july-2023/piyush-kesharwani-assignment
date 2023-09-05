import React from "react";
import "./UserDashboard.css";
import { useNavigate } from "react-router-dom";

const DashboardCard = ({ title , link}) => {
  const navigate = useNavigate();
  
  const handleCard = () => {
    if(link){
    navigate("/category/all");
    console.log("Card clicked!");
    }
  };

  return (
    <div className="dashboard-card" onClick={handleCard}>
      <h3>{title}</h3>
      {/* Add content specific to each card */}
    </div>
  );
};

export default DashboardCard;
