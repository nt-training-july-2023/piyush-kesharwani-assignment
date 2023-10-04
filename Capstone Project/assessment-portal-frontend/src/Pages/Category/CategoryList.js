import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import categoryService from "../../Services/categoryService";
import "./CategoryList.css";
import Swal from "sweetalert2";
import Button from "../../Component/Button component/Button";

const CategoryList = () => {
  const [categories, setCategories] = useState([]);
  const [valid, setValid] = useState("");
  const navigate = useNavigate();

  const isLoggedIn = localStorage.getItem("IsLoggedIn");
  const role = localStorage.getItem("role");

  useEffect(() => {
    if (role === "admin") {
      setValid("true");
    } else {
      setValid("false");
    }
  }, [role]);

  useEffect(() => {
    if (isLoggedIn !== null) {
      getCategory();
    } else {
      navigate("/");
    }
  }, [isLoggedIn, navigate]);

  const getCategory = () => {
    categoryService
      .getAll()
      .then((response) => {
        setCategories(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const deleteCategory = (categoryId) => {
    categoryService
      .deleteCategory(categoryId)
      .then(() => {
        Swal.fire({
          title: "Success",
          text: "Category deleted successfully",
          icon: "success",
          timer: 2000,
          showConfirmButton: false,
        });
        getCategory();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div className="category-container">
      <h2 className="category-title">List of Categories</h2>
      {isLoggedIn === "true" && (
        <table className="category-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Description</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {categories.map((category, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{category.categoryName}</td>
                <td>{category.description}</td>
                {valid === "true" && isLoggedIn === "true" ? (
                  <td className="category-actions">
                    <Link to={`/category/${category.categoryId}/quizzes`}>
                      <Button
                        className="category-update-btn"
                        children="Quizzes"
                      ></Button>
                    </Link>
                    <Link
                      to={`/category/all/edit-category/${category.categoryId}`}
                    >
                      <Button
                        className="category-update-btn"
                        children="Update"
                      ></Button>
                    </Link>
                    <Button
                      className="category-delete-btn"
                      onClick={() =>
                        Swal.fire({
                          title: "Warning",
                          text: "Delete Category",
                          icon: "warning",
                          confirmButtonText: "Delete",
                          confirmButtonColor: "red",
                          showCancelButton: true,
                        }).then((result) => {
                          if (result.isConfirmed) {
                            deleteCategory(category.categoryId);
                          }
                        })
                      }
                      children="Delete"
                    ></Button>
                  </td>
                ) : (
                  <td>
                    <Button
                      className="category-update-btn"
                      onClick={() =>
                        navigate(`/category/${category.categoryId}/quizzes`)
                      }
                      children="Quizzes"
                    ></Button>
                  </td>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      )}
      <div className="category-button-group">
        {role === "user" ? (
          <Link to="/userDashboard">
            <Button className="category-delete-btn" children="Cancel"></Button>
          </Link>
        ) : (
          <>
            <Link to="/category/all/addCategory">
              <Button
                className="category-update-btn"
                children="Add"
              ></Button>
            </Link>
            <Link to="/adminDashboard">
              <Button className="category-delete-btn" children="Cancel"></Button>
            </Link>
          </>
        )}
      </div>
    </div>
  );
};

export default CategoryList;
