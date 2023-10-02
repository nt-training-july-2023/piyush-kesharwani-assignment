import React from "react";

export const Label = (props) => {
  return (
      <label className={props.className}>{props.children}</label>
  );
};