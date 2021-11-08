import { Component } from 'react';

export default class Produtos extends Component {
  constructor() {
    super();

    const listaInicial = [
      {
        id: 1,
        imgProduto: "https://static.paodeacucar.com/img/uploads/1/828/528828.jpg",
        nomeProduto: "Feijão"
      },
      {
        id: 2,
        imgProduto: "https://static.paodeacucar.com/img/uploads/1/828/528828.jpg",
        nomeProduto: "Arroz"
      },
      {
        id: 3,
        imgProduto: "https://static.paodeacucar.com/img/uploads/1/828/528828.jpg",
        nomeProduto: "Tomate"
      },
      {
        id: 4,
        imgProduto: "https://static.paodeacucar.com/img/uploads/1/828/528828.jpg",
        nomeProduto: "Alface"
      },
      {
        id: 5,
        imgProduto: "https://static.paodeacucar.com/img/uploads/1/828/528828.jpg",
        nomeProduto: "Lima"
      },
      {
        id: 6,
        imgProduto: "https://static.paodeacucar.com/img/uploads/1/828/528828.jpg",
        nomeProduto: "Polenta"
      },
      {
        id: 7,
        imgProduto: "https://static.paodeacucar.com/img/uploads/1/828/528828.jpg",
        nomeProduto: "Leite moça"
      }
    ]

    this.state = {
      listagemDeProdutos: listaInicial,
      listaPadrão: listaInicial
    }

  }

  restaurarLista = () => {
    return this.setState( {
      listagemDeProdutos: this.state.listaPadrão
    })
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
        <button onClick={this.restaurarLista}>Restaurar Lista</button>
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