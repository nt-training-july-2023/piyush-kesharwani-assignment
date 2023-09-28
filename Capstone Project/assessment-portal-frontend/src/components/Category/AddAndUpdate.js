import React, { useState, useEffect } from 'react';
import { useNavigate, useParams,Link } from 'react-router-dom';
import categoryService from '../../Services/categoryService';
import './styles.css';
import Error from '../Error';
import Swal from 'sweetalert2';

const AddAndUpdate = () => {
  const [categoryName, setCategoryName] = useState('');
  const [description, setDescription] = useState('');
  const [error, setError] = useState('')
  const navigate = useNavigate();
  const { id } = useParams();

  const validateForm = () =>{
    if(categoryName===''||description==='') {
      setError("*All fields are required.");
      return false;
    }
    return true;
  }

  const saveCategory = (e) => {
    e.preventDefault();
    if(validateForm()){
    const category = { categoryName, description };
    if(id){
      categoryService.updateCategory(id,category).then((response)=>{
        console.log(response.data);
        Swal.fire({
          title: "Success",
          text: "Category Updated successfully",
          icon: "success",
          timer: 2000,
          showConfirmButton: false
        })
        navigate('/category/all');
      }).catch(error=>{
        const submitError =error.response.data.message
            Swal.fire({
              title: "Error",
              text: `${submitError}`,
              icon: "error",
              confirmButtonText:"Retry",
              confirmButtonColor:"red"
            });
      });
    }
    else{
    categoryService
      .addCategory(category)
      .then((response) => {
        console.log(response.data);
        navigate('/category/all');
      })
      .catch((error) => {
        console.log(error);
      });
    }
  }
  };

  useEffect(() => {
    categoryService
      .getCategoryById(id)
      .then((response) => {
        setCategoryName(response.data.categoryName);
        setDescription(response.data.description);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  const title = () => {
    if (id) {
      return <h2 className='title'>Update Category</h2>;
    } else {
      return <h2 className='title'>Add Category</h2>;
    }
  };
  
  const role = localStorage.getItem('role');
  if (role !== 'admin') {
    return (
      <Error/>
    );
  }
  return (
    <div className='container'>
      <div className='card'>
        {title()}
        <div className='card-body'>
          <form>
            <div className='form-group'>
              <label className='form-label' htmlFor='categoryName'>
                Name:
              </label>
              <input
                type='text'
                placeholder='Enter Category name'
                id='categoryName'
                className='form-control'
                value={categoryName || ''}
                onChange={(e) => setCategoryName(e.target.value)}
              />
            </div>
            <div className='form-group'>
              <label className='form-label' htmlFor='description'>
                Description:
              </label>
              <input
                type='text'
                placeholder='Enter description'
                id='description'
                className='form-control'
                value={description || ''}
                onChange={(e) => setDescription(e.target.value)}
              />
            </div>
            <span style={{color: "red"}}>{error}</span>
            <button className='btn-primary' onClick={(e) => saveCategory(e)}>
              Submit
            </button>
            <Link to = "/category/all">
               <button className='btn-primary'>Cancel</button>
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddAndUpdate;
