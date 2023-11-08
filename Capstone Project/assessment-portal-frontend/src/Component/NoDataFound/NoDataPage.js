import React from 'react';
import "./NoDataPage.css";

const NoDataPage = () => {
  return (
    <div className="no-data">
      <h2 className='custom-heading'>No Data Found</h2>
      <p className='custom-para'>Sorry, there is no data to display.</p>
    </div>
  );
};

export default NoDataPage;
