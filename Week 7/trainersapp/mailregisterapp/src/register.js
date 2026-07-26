import React, { Component } from "react";

class Register extends Component {
  constructor(props) {
    super(props);

    this.state = {
      fullName: "",
      email: "",
      password: "",
      errors: {
        fullName: "",
        email: "",
        password: ""
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case "fullName":
        errors.fullName =
          value.length < 5
            ? "Full Name must be 5 characters long!"
            : "";
        break;

      case "email":
        errors.email =
          value.includes("@") && value.includes(".")
            ? ""
            : "Email is not valid!";
        break;

      case "password":
        errors.password =
          value.length < 8
            ? "Password must be 8 characters long!"
            : "";
        break;

      default:
        break;
    }

    this.setState({
      errors,
      [name]: value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const { fullName, email, password, errors } = this.state;

    if (
      fullName.length >= 5 &&
      email.includes("@") &&
      email.includes(".") &&
      password.length >= 8 &&
      errors.fullName === "" &&
      errors.email === "" &&
      errors.password === ""
    ) {
      alert("Valid Form");
    } else {
      if (fullName.length < 5) {
        alert("Full Name must be 5 characters long!");
      } else if (!email.includes("@") || !email.includes(".")) {
        alert("Email is not valid!");
      } else if (password.length < 8) {
        alert("Password must be 8 characters long!");
      }
    }
  };

  render() {
    return (
      <div>
        <h1 style={{ color: "red" }}>Register Here!!!</h1>

        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name: </label>
            <input
              type="text"
              name="fullName"
              onChange={this.handleChange}
            />
          </div>

          <div>
            <label>Email: </label>
            <input
              type="text"
              name="email"
              onChange={this.handleChange}
            />
          </div>

          <div>
            <label>Password: </label>
            <input
              type="password"
              name="password"
              onChange={this.handleChange}
            />
          </div>

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;