import React, { Component } from 'react';
import { Formik, Form, Field } from 'formik';
import Swal from 'sweetalert2';
import './style.scss';

export default class Formulario extends Component {
  
  handleSubmit = ({ nome, telefone, email}) => {
    if(!!nome || !!telefone || !!email)  
      Swal.fire({
        title: 'Formulário devidamente preenchido!',
        icon: 'sucess',
        text: nome + ', seu email ' +
              email + ' e seu telefone de nº ' +
              telefone + ' foram enviados com sucesso!'
      })
    else
      Swal.fire({
        title: 'Aconteceu um erro',
        icon: 'error',
        text: 'Ih rapaz'
      })
  }


  render() {
    return (
      <Formik initialValues={{ nome: '', telefone: '', email: '' }} onSubmit={this.handleSubmit}>
        <div className="col-3 text-center container col-sm-4 col-md-4">
            <Form className="d-flex-column justify-content-center py-4">
              <Field placeholder="Insira seu nome" type="text" name="nome" id="nome" className="form-control" />
              <Field placeholder="Insira seu telefone" type="number" name="telefone" id="telefone" className="form-control" />
              <Field placeholder="Insira seu e-mail" type="email" name="email" id="email" className="form-control" />
              <button className="btn btn-primary px-4 my-4 col-6" type="submit">Enviar</button>
            </Form>
        </div>
      </Formik>
    );
  }
};