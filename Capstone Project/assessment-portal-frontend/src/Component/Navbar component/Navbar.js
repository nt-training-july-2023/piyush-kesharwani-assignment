import React, { useEffect, useState } from 'react'
import Swal from 'sweetalert2';
import { FaList, FaQuestion, FaPoll, FaSignOutAlt, FaPenFancy } from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom';
import './Navbar.css'
import Button from '../Button component/Button';
const Navbar = () => {
    const navigate = useNavigate();
    const [valid, setValid] = useState("");
    const result = localStorage.getItem('role');
    const navigateTo = (path) => {
    navigate(path);
  };
  useEffect(() => {
    if(result === 'admin'){
      setValid(true);
    }else{
      setValid(false);
    }
  }, [result]);
  const handleLogout = () => {
    Swal.fire({
      title: 'Confirm Logout',
      text: 'Are you sure you want to log out?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#3085D6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, logout',
    }).then((result) => {
      if (result.isConfirmed) {
        localStorage.removeItem('isLoggedIn');
        localStorage.removeItem('role');
        localStorage.removeItem('email');
        localStorage.removeItem('userName')
        Swal.fire({
          icon: 'success',
          title: 'Logout Successful',
          text: 'You have been successfully logged out.',
          timer: 1000,
          showConfirmButton: false,
        }).then(() => {
          navigate('/');
        });
      }
    });
  };
  return (
    <div>
       <nav className="Navbar">
       {valid === true ?( <Button className="navbar-company-name" onClick={() => navigateTo('/adminDashboard')} >Assessment Portal</Button>):
        ( <Button className="navbar-company-name" onClick={() => navigateTo('/userDashboard')} >Assessment Portal</Button>)}
        <ul className="navbar-list">
        <li>
          <div className="navbar-item" onClick={() => navigateTo('/category/all')}>
            <FaList className="navbar-icon" />
            Category
          </div>
        </li>
        <li>
          <div className="navbar-item" onClick={() => navigateTo('/quiz/all')}>
            <FaQuestion className="navbar-icon" />
            Quiz
          </div>
        </li>
        <li>
            {valid === true && (
                   <div className="navbar-item" onClick={() => navigateTo('/question/all')}>
                   <FaPenFancy className="navbar-icon" />
                   Questions
                 </div>
            )}
        </li>
        <li>
          <div className="navbar-item" onClick={() => navigateTo('/results')}>
            <FaPoll className="navbar-icon" />
            Results
          </div>
        </li>
        <li>
          <div className="navbar-item" onClick={handleLogout}>
            <FaSignOutAlt className="navbar-icon" />
            Logout
          </div>
        </li>
      </ul>
    </nav>
    </div>
  )
}
export default Navbar