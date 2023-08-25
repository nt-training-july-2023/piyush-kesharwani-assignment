import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import categoryService from "../../Services/categoryService";

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
    <div className="container">
      <h2 className="text-center">List of Category</h2>
      <Link to="/category/all/addCategory" className="btn btn-primary mb-2">
        Add Category
      </Link>
      <table className="table table-bordered ">
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
              <td>
                <Link
                  className="btn btn-info"
                  to={`/category/all/edit-category/${ct.categoryId}`}
                >
                  Update
                </Link>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteCategories(ct.categoryId)}
                  style={{ marginLeft: "10px" }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default CategoryList;
