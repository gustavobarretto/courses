import React from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

const Home = () => {



    return (
        <>
            <div className="container d-flex flex-column gap-3 align-items-center justify-content-center" style={{height: "100vh"}}>
                <h1>Bem-vindo</h1>
                <h5>Escolha por qual API você gostaria de buscar o CEP:</h5>
                <div className="container d-flex gap-4 align-items-center justify-content-center">
                    <button className="btn btn-primary col-2" ><Link to='/viacep' style={{ textDecoration: "none", color: "white" }}> ViaCEP </Link></button>
                    <button className="btn btn-primary col-2" ><Link to='/brasilapi' style={{ textDecoration: "none", color: "white" }}>BrasilAPI </Link></button>
                </div>
            </div>
        </>
    );
}

export default Home;