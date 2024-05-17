import React, { useState, useEffect } from 'react';
import './Formulario.css';

function Formulario() {

  const [estados, setEstados] = useState([]);
  const [cidades, setCidades] = useState([]);
  const [estadoSelecionado, setEstadoSelecionado] = useState('');

  useEffect(() => {
    fetch('https://servicodados.ibge.gov.br/api/v1/localidades/estados')
      .then(response => response.json())
      .then(data => {
        const estados = data.map(estado => ({
          value: estado.sigla,
          label: estado.nome
        }));
        setEstados(estados);
      })
      .catch(error => {
        console.error('Erro ao buscar estados:', error);
      });
  }, []);

  useEffect(() => {
    if (estadoSelecionado !== '') {
      fetch(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${estadoSelecionado}/municipios`)
        .then(response => response.json())
        .then(data => {
          const cidades = data.map(cidade => ({
            value: cidade.id,
            label: cidade.nome
          }));
          setCidades(cidades);
        })
        .catch(error => {
          console.error('Erro ao buscar cidades:', error);
        });
    }
  }, [estadoSelecionado]);

  const handleEstadoChange = (event) => {
    setEstadoSelecionado(event.target.value);
  };

  return (
    <div>
      <header className="menu-formulario">
        <ul className="inicio__form">
          <li><a href="/">Inicio</a></li>
          <li><a href="/LoginUser">Login Usuario</a></li>
          <li><a href="/LivrosUsados">Cadastro de livros</a></li>
        </ul>
      </header>

      <section className="formulario">
        <div className="interface"></div>
        <h2 className="titulo">Dados<span> Cadastrais</span></h2>
        <form action="">
          <input type="text" name="" id="" placeholder="Seu Nome Completo:" required />
          <input type="text" name="" id="" placeholder="Seu Email" required />
          <input type="text" name="" id="" placeholder="(11)99999-9999" required />
          <select className="cidades" value={estadoSelecionado} onChange={handleEstadoChange}>
            <option value="">Selecione o estado</option>
            {estados.map(estado => (
              <option key={estado.value} value={estado.value}>{estado.label}</option>
            ))}
          </select>
          <select className="cidades">
            <option value="">Selecione a cidade</option>
            {cidades.map(cidade => (
              <option key={cidade.value} value={cidade.value}>{cidade.label}</option>
            ))}
          </select>
          <textarea name="" id="" placeholder="Sua Mensagem" required></textarea>
          <div className="btn-enviar"><input type="submit" value="Enviar" /></div>
        </form>
      </section>


      <footer>
        <div className="footer">
          <h3>Todos os direitos reservados &copy;2024</h3>
        </div>
      </footer>
    </div>
  );
}

export default Formulario;
