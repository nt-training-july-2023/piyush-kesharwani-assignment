import React from 'react'

export const ValidationError = ({errorMessage,id}) => {
  return (
    <span className="custom-error" id={id}>{errorMessage}</span>
  )
}