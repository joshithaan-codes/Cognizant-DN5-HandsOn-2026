import React, { Component } from "react";
import Greeting from "./Greeting";
import LoginButton from "./LoginButton";
import LogoutButton from "./LogoutButton";

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isLoggedIn: false
        };
    }

    loginClick = () => {
        this.setState({
            isLoggedIn: true
        });
    };

    logoutClick = () => {
        this.setState({
            isLoggedIn: false
        });
    };

    render() {

        let button;

        if (this.state.isLoggedIn) {
            button = (
                <LogoutButton
                    onClick={this.logoutClick}
                />
            );
        } else {
            button = (
                <LoginButton
                    onClick={this.loginClick}
                />
            );
        }

        return (
            <div style={{ padding: "50px" }}>

                <Greeting
                    isLoggedIn={this.state.isLoggedIn}
                />

                <br />

                {button}

            </div>
        );
    }
}

export default App;