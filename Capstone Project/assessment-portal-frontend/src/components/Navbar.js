import React from "react";
import "./Navbar.css";

export const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="container-fluid">
        <a className="navbar-brand" href="/">
          AssessmentPortal
        </a>
        <button
          className="navbar-toggler"
          type="button"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav">
            <li className="nav-item">
              <a className="nav-link active" aria-current="page" href="/">
                Home
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};
