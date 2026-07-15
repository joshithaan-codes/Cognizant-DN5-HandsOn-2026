import React, { Component } from "react";
import "./App.css";

class App extends Component {

  constructor() {
    super();

    this.state = {
      counter: 0,
      amount: "",
      currency: ""
    };
  }

  increment = () => {
    this.setState({
      counter: this.state.counter + 1
    });
  };

  decrement = () => {
    this.setState({
      counter: this.state.counter - 1
    });
  };

  sayHello = () => {
    alert("Hello! Have a nice day!");
  };

  increase = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  onPress = () => {
    alert("I was clicked");
  };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const euro = (this.state.amount / 90).toFixed(2);

    alert(
      `Converting Rs. ${this.state.amount} to Euro is €${euro}`
    );
  };

  render() {
    return (
      <div style={{ padding: "20px" }}>

        <h2>{this.state.counter}</h2>

        <button onClick={this.increase}>Increment</button>

        <br /><br />

        <button onClick={this.decrement}>Decrement</button>

        <br /><br />

        <button onClick={() => this.sayWelcome("Welcome")}>
          Say Welcome
        </button>

        <br /><br />

        <button onClick={this.onPress}>
          Click on me
        </button>

        <br /><br /><br />

        <h1 style={{ color: "green" }}>
          Currency Convertor!!!
        </h1>

        <form onSubmit={this.handleSubmit}>

          <label>Amount</label>

          <br />

          <input
            type="number"
            name="amount"
            value={this.state.amount}
            onChange={this.handleChange}
          />

          <br /><br />

          <label>Currency</label>

          <br />

          <input
            type="text"
            name="currency"
            value={this.state.currency}
            onChange={this.handleChange}
          />

          <br /><br />

          <button type="submit">
            Submit
          </button>

        </form>

      </div>
    );
  }
}

export default App;