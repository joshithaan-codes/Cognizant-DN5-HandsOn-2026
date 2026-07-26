import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      person: null
    };
  }

  async componentDidMount() {
    const response = await fetch("https://api.randomuser.me/");
    const data = await response.json();

    this.setState({
      person: data.results[0]
    });
  }

  render() {
    const { person } = this.state;

    if (!person) {
      return <div>Loading...</div>;
    }

    return (
      <div>
        <h1>Get User</h1>

        <p>
          <b>Name:</b> {person.name.first} {person.name.last}
        </p>

        <img
          src={person.picture.large}
          alt="User"
        />
      </div>
    );
  }
}

export default Getuser;