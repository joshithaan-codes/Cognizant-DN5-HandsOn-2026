import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);

    this.state = {
      ename: "",
      complaint: "",
      NumberHolder: 101
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    var msg =
      "Thanks " +
      this.state.ename +
      "\nYour Complaint was Submitted.\nTransaction ID is: " +
      this.state.NumberHolder;

    alert(msg);

    this.setState({
      NumberHolder: this.state.NumberHolder + 1
    });

    event.preventDefault();
  };

  render() {
    return (
      <div>
        <h1>Register your complaints here!!!</h1>

        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name: </label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
            />
          </div>

          <br />

          <div>
            <label>Complaint: </label>
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
            />
          </div>

          <br />

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;