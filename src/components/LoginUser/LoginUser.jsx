import React, { Component } from "react";

import './LoginUser.css';

class LoginUser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: ""
        };
    }

    handleUsernameChange = (event) => {
        this.setState({ username: event.target.value });
    }

    handlePasswordChange = (event) => {
        this.setState({ password: event.target.value });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        // Aqui você pode adicionar lógica para enviar os dados de login para um servidor
        console.log("Username:", this.state.username);
        console.log("Password:", this.state.password);
        // Limpa os campos após o envio
        this.setState({ username: "", password: "" });
    }

    render() {
        return (
            <div>
                <header className="login-user">
                    <div className="menu__user">
                        <ul className="header__user" >
                            <li><a className="login__user" href="/">Inicio</a></li>
                            <li><a children="livros__user" href="/LivrosUsados">Cadastro de livros</a></li>
                        </ul>
                    </div>
                </header>
                <div className="form__user">
                    <section className="formulario__user">
                        <form className="form-principal" onSubmit={this.handleSubmit}>
                            <label className="username-input">
                                Nome Completo:
                                <input type="text" value={this.state.username} onChange={this.handleUsernameChange} />
                            </label>
                            <br />
                            <label className="password-input">
                                Senha:
                                <input type="password" value={this.state.password} onChange={this.handlePasswordChange} />
                            </label>
                            <br />
                            <button className="login-submit" type="submit">Login</button>
                        </form>
                    </section>
                </div>
            </div>
        );
    }
}

export default LoginUser;
