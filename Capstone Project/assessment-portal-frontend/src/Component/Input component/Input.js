import React from 'react'
const Input = (props) => {
  return (
      <input type={props.type} 
      placeholder={props.placeholder} 
      name={props.name} 
      className={props.className} 
      value={props.value} 
      onChange={props.onChange}
      checked={props.checked}/>
  )
}
export default Input