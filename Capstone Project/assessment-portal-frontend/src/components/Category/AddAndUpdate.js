import React, { useState, useEffect } from 'react';
import { useNavigate, useParams,Link } from 'react-router-dom';
import categoryService from '../../Services/categoryService';
import './styles.css';

const AddAndUpdate = () => {
  // const [categoryId, setCategoryId] = useState();
  const [categoryName, setCategoryName] = useState('');
  const [description, setDescription] = useState('');
  const navigate = useNavigate();
  const { id } = useParams();

  const saveCategory = (e) => {
    e.preventDefault();

    const category = { categoryName, description };
    if(id){
      categoryService.updateCategory(id,category).then((response)=>{
        console.log(response.data);
        navigate('/category/all');
      }).catch(error=>{
        console.log(error);
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
  };

  useEffect(() => {
    categoryService
      .getCategoryById(id)
      .then((response) => {
        // setCategoryId(response.data.categoryId);
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

  return (
    <div className='container'>
      <div className='card'>
        {title()}
        <div className='card-body'>
          <form>
            {/* <div className='form-group'>
              <label className='form-label' htmlFor='categoryId'>
                Category ID:
              </label>
              <input
                type='number'
                placeholder='Enter category Id'
                id='categoryId'
                className='form-control'
                value={categoryId || ''}
                onChange={(e) => setCategoryId(e.target.value)}
              />
            </div> */}
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
