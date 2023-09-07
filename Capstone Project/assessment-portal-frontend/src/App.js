import "./App.css";
import Login from "./components/LoginAndRegisterForm/Login";
import Register from "./components/LoginAndRegisterForm/Register";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";

// import { Navbar } from "./components/Navbar";
import CategoryList from "./components/Category/CategoryList";
import AddAndUpdate from "./components/Category/AddAndUpdate";
import UserDashboard from "./components/UserDashboard/Userboard";
import AdminDashboard from "./components/AdminDashboard/AdminDashboard";
import Error from "./components/Error";


function App() {
  return (
    <Router>
      {/* <Navbar/> */}
      <Routes>
        <Route exact path="/" Component={Login}></Route>
        <Route exact path="/register" Component={Register}></Route>
        <Route exact path="/adminDashboard" element={<PrivateRoute Component={AdminDashboard} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/userDashboard" element={<PrivateRoute Component={UserDashboard} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/category/all" element={<PrivateRoute Component={CategoryList} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/category/all/edit-category/:id" element={<PrivateRoute Component={AddAndUpdate} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/category/all/addCategory" element={<PrivateRoute Component={AddAndUpdate} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/error-page" Component={Error}></Route>
      </Routes>
    </Router>
  );
}

const PrivateRoute = ({ Component }) => {
  const isLoggedIn = localStorage.getItem('IsLoggedIn')
  return isLoggedIn ? <Component /> : <Navigate to="/" replace />;
}

export default App;
