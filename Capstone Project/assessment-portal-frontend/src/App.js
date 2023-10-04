import "./App.css";
import Login from "./Pages/LoginAndRegisterForm/Login";
import Register from "./Pages/LoginAndRegisterForm/Register";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import CategoryList from "./Pages/Category/CategoryList";
import AddAndUpdate from "./Pages/Category/AddAndUpdate";
import UserDashboard from "./Pages/UserDashboard/Userboard";
import AdminDashboard from "./Pages/AdminDashboard/AdminDashboard";
import QuizList from "./Pages/Quiz/QuizList";
import AddUpdateQuiz from "./Pages/Quiz/AddUpdateQuiz";
import QuizzesByCategory from "./Pages/Category/QuizzesByCategory";
import QuestionList from "./Pages/Question/QuestionList";
import AddUpdateQuestion from "./Pages/Question/AddUpdateQuestion";
import UserTest from "./Pages/Question/UserTest";
import Result from "./Pages/Result/Result";
import Error from "./Component/Error component/Error";



function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" Component={Login}></Route>
        <Route exact path="/register" Component={Register}></Route>
        <Route exact path="/adminDashboard" element={<PrivateRoute Component={AdminDashboard} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/userDashboard" element={<PrivateRoute Component={UserDashboard} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/category/all" element={<PrivateRoute Component={CategoryList} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/category/all/edit-category/:id" element={<PrivateRoute Component={AddAndUpdate} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/category/all/addCategory" element={<PrivateRoute Component={AddAndUpdate} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/category/:id/quizzes" element={<PrivateRoute Component={QuizzesByCategory} isLoggedIn={localStorage.getItem('IsLoggedIn')} />}></Route>
        <Route exact path="/error-page" Component={Error}></Route>
        <Route exact path="/quiz/all" Component={QuizList}></Route>
        <Route exact path="/quiz/all/addQuiz" Component={AddUpdateQuiz}></Route>
        <Route exact path="/quiz/all/edit-quiz/:id" Component={AddUpdateQuiz}></Route>
        <Route exact path="/question/all" Component={QuestionList}></Route>
        <Route exact path="/quiz/:id/question" Component={QuestionList}></Route>
        <Route exact path="/question/all/addQuestion" Component={AddUpdateQuestion}></Route>
        <Route exact path="/quiz/:id/addQuestion" Component={AddUpdateQuestion}></Route>
        <Route exact path="/question/all/edit-question/:questionId" Component={AddUpdateQuestion}></Route>
        <Route exact path="/quiz/:quizId/edit-question/:questionId" Component={AddUpdateQuestion}></Route>
        <Route exact path="/quiz/:quizId/test" Component={UserTest}></Route>
        <Route exact path="/results" Component={Result}></Route>
      </Routes>
    </Router>
  );
}

const PrivateRoute = ({ Component }) => {
  const isLoggedIn = localStorage.getItem('IsLoggedIn')
  return isLoggedIn ? <Component /> : <Navigate to="/" replace />;
}

export default App;
