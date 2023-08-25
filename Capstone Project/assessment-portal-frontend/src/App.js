import "./App.css";
import Login from "./components/LoginAndRegisterForm/Login";
import Register from "./components/LoginAndRegisterForm/Register";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import { Navbar } from "./components/Navbar";
import CategoryList from "./components/Category/CategoryList";
import AddAndUpdate from "./components/Category/AddAndUpdate";

function App() {
  return (
    <Router>
      <Navbar/>
      <Routes>
        <Route exact path="/" Component={Login}></Route>
        <Route exact path="/register" Component={Register}></Route>
        <Route exact path="/category/all" Component={CategoryList}></Route>
        <Route exact path="/category/all/edit-category/:id" Component={AddAndUpdate}></Route>
        <Route exact path="/category/all/addCategory" Component={AddAndUpdate}></Route>
      </Routes>
    </Router>
  );
}

export default App;
