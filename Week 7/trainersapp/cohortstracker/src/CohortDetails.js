import React from 'react';

function CohortDetails(props) {
  return (
    <div>
      <h3>{props.cohortCode}</h3>
      <p><b>Technology:</b> {props.technology}</p>
      <p><b>Start Date:</b> {props.startDate}</p>
      <p><b>Current Status:</b> {props.currentStatus}</p>
      <p><b>Coach:</b> {props.coachName}</p>
      <p><b>Trainer:</b> {props.trainerName}</p>
    </div>
  );
}

export default CohortDetails;