import React from "react";
import "./UserDashboard.css";
import { useNavigate } from "react-router-dom";

const DashboardCard = ({ title , link , description}) => {
  const navigate = useNavigate();
  
  const handleCard = () => {
    if(link){
    navigate(link);
    }
  };

  return (
    <div className="User-dashboard-card" onClick={handleCard}>
      <h3>{title}</h3>
      {description && <p className="card-description">{description}</p>}
    </div>
  );
};

export default DashboardCard;
