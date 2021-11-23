import React, { Component } from 'react'
import axios from 'axios';
import Swal from 'sweetalert2';
import { Form, Field, Formik } from 'formik';
import { Link } from 'react-router-dom';

export default class BrasilAPI extends Component  {
    constructor(props) {
        super(props);
        this.state = {
          endereco: {}
          }
        };

    handleSubmit = async ({ cep }) => {
        try {
          const response = await axios.get(`https://brasilapi.com.br/api/cep/v1/${cep}`);
          this.setState({ endereco: response.data })
          console.log(response.data)
        } catch (error) {
          Swal.fire( {
            title: 'Erro na busca!',
            icon: 'error',
            text: 'CEP não encontrado!'
  
          })
        }
      }

    render() {

        return ( 
            <div className="container d-flex flex-column justify-content-center align-items-center">
                <h3>Pesquisa de CEP pelo Brasil API:</h3>
                <Formik  onSubmit={this.handleSubmit} initialValues={{cep: ''}}>
                    <Form className="form-group col-4 d-flex flex-column justify-content-center align-items-center">
                      
                      <Field 
                          className="input-cep form-control my-3" 
                          placeholder="Informe o CEP que deseja pesquisar" 
                          required-type="text"
                          name="cep"
                          id="cep"
                      />
                      <button className="btn btn-primary col-6" type="submit">Pesquisar</button>
                      <button className="btn btn-primary col-6 my-3"><Link to="/" style={{textDecoration: "none", color: "white"}}> Voltar</Link></button>
                    </Form>
                  </Formik>
                  {this.state.endereco.cep && (
                    <div className="container d-flex flex-column gap-3 col-6">
                    <h5>Rua: </h5>
                    <p>{this.state.endereco.street}</p>
                    <h5>Bairro:</h5>
                    <p>{this.state.endereco.neighborhood}</p>
                    <h5>Localidade: </h5>
                    <p>{this.state.endereco.city}</p>
                    <h5>UF: </h5>
                    <p>{this.state.endereco.state}</p>
                    </div>
                  )}
            </div>
         );
    }
}
