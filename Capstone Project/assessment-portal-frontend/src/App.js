import "./App.css";
import Login from "./components/LoginAndRegisterForm/Login";
import Register from "./components/LoginAndRegisterForm/Register";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from './components/Pages/Dashboard'

import { Navbar } from "./components/Navbar";

function App() {
  return (
    <Router>
      <Navbar/>
      <Routes>
        <Route exact path="/" Component={Login}></Route>
        <Route exact path="/register" Component={Register}></Route>
        <Route exact path="/dashboard" Component={Dashboard}></Route>
      </Routes>
    </Router>
  );
}

export default App;
