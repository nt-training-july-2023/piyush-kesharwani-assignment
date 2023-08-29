import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import categoryService from "../../Services/categoryService";
import "./CategoryList.css";

const CategoryList = () => {
  const [category, setCategory] = useState([]);

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
    <div className="cat-container">
      <h2 className="text-center">List of Category</h2>
      <table className="table">
        <thead>
          <tr>
            <th>S No</th>
            <th>Name</th>
            <th>Description</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {category.map((ct) => (
            <tr key={ct.categoryId}>
              <td> {ct.categoryId} </td>
              <td> {ct.categoryName} </td>
              <td> {ct.description} </td>
              <td className="btn-group">
                <Link
                  className="btn btn-info"
                  to={`/category/all/edit-category/${ct.categoryId}`}
                >
                  Update
                </Link>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteCategories(ct.categoryId)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="button-group">
        <button className="btn btn-primary btn-sm">Add Category</button>
      </div>
    </div>
  );
};

export default CategoryList;
