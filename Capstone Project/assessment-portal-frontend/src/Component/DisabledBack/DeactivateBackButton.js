import React, { useEffect } from "react";
import { useLocation, useParams } from "react-router-dom";

const DeactivateBackButton = () => {
  const location = useLocation();
  const { quizId } = useParams();

  useEffect(() => {
    const handlePopstate = () => {
      console.log("Back Button Pressed!");
      window.history.pushState(null, "", window.location.href);
    };

    if (
      location.pathname === `/quiz/${quizId}/test` || 
      location.pathname === "/error-page" ||
      location.pathname === "/adminDashboard" ||
      location.pathname === "/userDashboard"
    ) {
      window.history.pushState(null, "", window.location.href);
      window.addEventListener("popstate", handlePopstate);

      return () => {
        window.removeEventListener("popstate", handlePopstate);
      };
    }
  }, [location.pathname, quizId]);

  return null; 
};

export default DeactivateBackButton;
