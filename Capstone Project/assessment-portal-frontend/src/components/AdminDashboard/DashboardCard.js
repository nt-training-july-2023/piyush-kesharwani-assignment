import React from "react";
import { useNavigate } from "react-router-dom";

const DashboardCard = ({ title, link , description }) => {
  const navigate = useNavigate();

  const handleCardClick = () => {
    if (link) {
      navigate(link);
    }
  };

  return (
    <div className="dashboard-card" onClick={handleCardClick}>
      <h3>{title}</h3>
      {description && <p className="card-description">{description}</p>}
    </div>
  );
};

export default DashboardCard;
