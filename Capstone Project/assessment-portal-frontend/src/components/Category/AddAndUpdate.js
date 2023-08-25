import React, { useState ,useEffect} from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import categoryService from '../../Services/categoryService'


const AddAndUpdate = () => {
    
    const [categoryId, setcategoryId] = useState()
    const [categoryName,setcategoryName] = useState('')
    const [description, setdescription] = useState('')
    const navigate = useNavigate();
    const {id} = useParams();

    const saveCategory = (e)=>{
        e.preventDefault();  // inorder to prevent the refresh of page
        
        const category = {categoryId ,categoryName , description};
        
        categoryService.addCategory(category).then((response) =>{
            console.log(response.data);
            navigate("/category/all")
    
           }).catch(error =>{
             console.log(error);
           })
    }

    useEffect(() => {
       categoryService.getCategoryById(id).then((response) => {
         setcategoryId(response.data.categoryId)
          setcategoryName(response.data.categoryName)
          setdescription(response.data.description)
       }).catch(error => {
          console.log(error)
       })
    }, [])
    

  const title = ()=>{
      if(id){
         return <h2 className='text-center'>Update Category</h2>
      }
      else{
         return <h2 className='text-center'>Add Category</h2>
      }
  }

  return (
    <div className='container'>
       <div className='row'>
          <div className='card col-md-6 offset-md-3 offset-md-3'>
              {/* <h2 className='text-center'>Add Book</h2> */}
              {title()}
           <div className='card-body'>
            <form>
            <div className='form-group mb-2'>
                    <label className='form-label'>Category ID :</label>
                    <input 
                       type='number'
                       placeholder='enter category Id'
                       name='categoryId'
                       className='form-control'
                       value={categoryId || ''}
                       onChange={(e)=>setcategoryId(e.target.value)}
                    >
                    </input>
                </div>
                <div className='form-group mb-2'>
                    <label className='form-label'> Name :</label>
                    {/* {name !== '' && <p>Your name is {name}.</p>} */}
                    <input 
                       type='text'
                       placeholder='enter Category name'
                       name='name'
                       className='form-control'
                       value={categoryName || ''}
                       onChange={(e)=>setcategoryName(e.target.value)}
                    >
                    </input>
                </div>
                <div className='form-group mb-2'>
                    <label className='form-label'>Description :</label>
                    {/* {authorName !== '' && <p>Your name is {authorName}.</p>} */}
                    <input 
                       type='text'
                       placeholder='enter description'
                       name='description'
                       className='form-control'
                       value={description || ''}
                       onChange={(e)=>setdescription(e.target.value)}
                    >
                    </input>
                </div>
                <button className='btn btn-primary' onClick={(e)=>saveCategory(e)}>Submit</button>
            </form>
           </div>
          </div>
       </div>
    </div>
  )
}

export default AddAndUpdate