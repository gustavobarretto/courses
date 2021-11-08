import { Component } from 'react';

export default class Produtos extends Component {
  constructor() {
    super();
    this.state = {
      listagemDeProdutos: (function listandoProdutos() {
          const criandoProduto = (url, nome, key) => {
              return {
                  id: key,
                  imgProduto: url,
                  nomeProduto: nome
              }
          }
          return [
            criandoProduto("https://static.paodeacucar.com/img/uploads/1/828/528828.jpg" , "Feijao", 1),
            criandoProduto("https://static.paodeacucar.com/img/uploads/1/828/528828.jpg" , "Arroz", 2),
            criandoProduto("https://static.paodeacucar.com/img/uploads/1/828/528828.jpg" , "Alface", 3)
          ]
      })(),
    };
  }

  removeProduto = (idProduto) => {
    const listaNovaProdutos = this.state.listagemDeProdutos.filter(({ id }) => {
      return id !== idProduto;
    });

    return this.setState({
        listagemDeProdutos: listaNovaProdutos
    }
    );
  };

  render() {
    return (
      <>
        {/* Incremental */}
        <div className='d-flex flex-wrap flex-column justify-content-center align-items-center py-3 my-4'>
          {this.state.listagemDeProdutos.map(({ id, imgProduto, nomeProduto }) => {
            return (
              <div key={id} onClick={() => this.removeProduto(id)}>
                <h2>{nomeProduto}</h2>
                <img src={imgProduto} alt="" />
              </div>
            );
          })}
        </div>
      </>
    );
  }
}