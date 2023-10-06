import React, { useState, useEffect } from 'react';
import { useNavigate, useParams,Link } from 'react-router-dom';
import categoryService from '../../Services/categoryService';
import './styles.css';
import Swal from 'sweetalert2';
import Button from '../../Component/Button component/Button';
import Input from '../../Component/Input component/Input';
import { Label } from '../../Component/Label component/Label';
import Error from '../../Component/Error component/Error';
import { ValidationError } from '../../Component/ValidationError/Validation';

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
        Swal.fire({
          title: "Success",
          text: "Category Added successfully",
          icon: "success",
          timer: 2000,
          showConfirmButton: false
        })
        navigate('/category/all');
      })
      .catch((error) => {
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
  }
  };

  useEffect(() => {
    if(id){
    categoryService
      .getCategoryById(id)
      .then((response) => {
        setCategoryName(response.data.categoryName);
        setDescription(response.data.description);
      })
      .catch((error) => {
        console.error(error);
      });
    }
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
              <Label className='form-label' htmlFor='categoryName'
                children="Name:">
              </Label>
              <Input
                type='text'
                placeholder='Enter Category name'
                id='categoryName'
                className='form-control'
                value={categoryName || ''}
                onChange={(e) => setCategoryName(e.target.value)}
              />
            </div>
            <div className='form-group'>
              <Label className='form-label' htmlFor='description'
                children = "Description:">
              </Label>
              <Input
                type='text'
                placeholder='Enter description'
                id='description'
                className='form-control'
                value={description || ''}
                onChange={(e) => setDescription(e.target.value)}
              />
            </div>
            <ValidationError errorMessage={error}/>
            <Button className='btn-primary' onClick={(e) => saveCategory(e)}
            children="Submit">
            </Button>
            <Link to = "/category/all">
               <Button className='btn-primary' children="Cancel"></Button>
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddAndUpdate;
