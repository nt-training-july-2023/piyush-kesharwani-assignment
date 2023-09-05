import React from "react";
import { useNavigate } from "react-router-dom";

const DashboardCard = ({ title, link }) => {
  const navigate = useNavigate();

  const handleCardClick = () => {
    if (link) {
      navigate(link);
    }
  };

  return (
    <div className="dashboard-card" onClick={handleCardClick}>
      <h3>{title}</h3>
      {/* Add content specific to each card */}
    </div>
  );
};

export default DashboardCard;
