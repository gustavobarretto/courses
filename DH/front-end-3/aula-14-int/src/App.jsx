
import './App.css';
import axios from 'axios';
import { Formik, Field, Form } from 'formik';
import Swal from 'sweetalert2';
import React, { Component } from 'react';


export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      endereco: {}
      }
    };

    handleSubmit = async ({ cep }) => {
      try {
        const response = await axios.get(`http://viacep.com.br/ws/${cep}/json/`);
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
        <>
            <main className="container d-flex flex-column justify-content-center align-items-center">
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
                </Form>
              </Formik>
              {this.state.endereco.cep && (
                <div className="container d-flex flex-column gap-3 col-6">
                <h5>Rua: </h5>
                <p>{this.state.endereco.logradouro}</p>
                <h5>Bairro:</h5>
                <p>{this.state.endereco.bairro}</p>
                <h5>Localidade: </h5>
                <p>{this.state.endereco.localidade}</p>
                <h5>UF: </h5>
                <p>{this.state.endereco.uf}</p>
                </div>
              )}
            </main>
        </>
      )
    }


  }

