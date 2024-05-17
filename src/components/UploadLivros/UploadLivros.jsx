import React, { Component } from "react";
import './UploadLivros.css';

class UploadLivros extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedFile: null,
            nome: "",
            anoFabricacao: "",
            titulo: "",
            autor: "",
            anos: this.gerarAnos()
        };
    }

    fileSelectedHandler = event => {
        this.setState({
            selectedFile: event.target.files[0]
        });
    };

    handleChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    fileUploadHandler = () => {
        // Aqui você pode adicionar lógica para enviar o arquivo e os dados do livro para um servidor
        console.log("Nome do livro:", this.state.nome);
        console.log("Ano de Fabricação:", this.state.anoFabricacao);
        console.log("Título:", this.state.titulo);
        console.log("Autor:", this.state.autor);
        console.log("Foto:", this.state.selectedFile);
        // Limpa os campos após o envio
        this.setState({
            selectedFile: null,
            nome: "",
            anoFabricacao: "",
            titulo: "",
            autor: ""
        });
    };

    gerarAnos = () => {
        const anos = [];
        const anoAtual = new Date().getFullYear();
        for (let ano = 1900; ano <= anoAtual; ano++) {
            anos.push(ano);
        }
        return anos;
    };

    render() {
        return (
            <div className="header">
                <div className="header__principal">
                    <ul className="form__login" >
                        <li><a href="/">Inicio</a></li>
                        <li><a href="Formulario">Formulario</a></li>
                        <li><a href="/LoginUser">Login Usuario</a></li>
                    </ul>
                </div>
                <section className="form__cadastro">
                    <label className="nome__livro">
                        Título do Livro:
                        <input type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label className="titulo__livro">
                        Autor do Livro   :
                        <input type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label className="autor__livro">
                        Valor do Livro :
                        <input type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label className="autor__livro">
                        Categoria :
                        <input type="text" onChange={this.handleChange} />
                    </label>
                    <br />
                    <label className="ano__livro">
                        Ano de Fabricação:
                        <select name="anoFabricacao" onChange={this.handleChange}>
                            <option value="">Selecione o Ano</option>
                            {this.state.anos.map(ano => (
                                <option key={ano} value={ano}>{ano}</option>
                            ))}
                        </select>
                    </label>
                    <br />
                    <button className="button__upload" onClick={this.fileUploadHandler}>Cadastrar Livro</button>
                    <input className="button__upload" type="file" onChange={this.fileSelectedHandler} />
                </section>
            </div>
        );
    }
}

export default UploadLivros;
