import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import categoryService from "../../Services/categoryService";
import "./CategoryList.css";

const CategoryList = () => {
  const [category, setCategory] = useState([]);

  const role = localStorage.getItem("role");

  useEffect(() => {
    getCategory();
  }, []);

  const getCategory = () => {
    categoryService
      .getAll()
      .then((response) => {
        setCategory(response.data); // Make sure response.data is an array
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteCategories = (categoryId) => {
    categoryService
      .deleteCategory(categoryId)
      .then((response) => {
        getCategory();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="category-container">
      <h2 className="category-title">List of Categories</h2>
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
          {category.map((ct,index) => (
            <tr key={index}>
              <td> {++index} </td>
              <td> {ct.categoryName} </td>
              <td> {ct.description} </td>
              <td className="category-actions">
                <Link
                  className="category-update-btn"
                  to={`/category/all/edit-category/${ct.categoryId}`}
                >
                  Update
                </Link>
                <button
                  className="category-delete-btn"
                  onClick={() => deleteCategories(ct.categoryId)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="category-button-group">
        <Link className="category-add-btn" to="/category/all/addCategory" >Add Category</Link>
        {(role==="user") ? (
        <Link className="category-add-btn" to="/userDashboard" >Cancel</Link> ):
        (
        <Link className="category-add-btn" to="/adminDashboard" >Cancel</Link> )}

      </div> 
    </div>
  );
};

export default CategoryList;
