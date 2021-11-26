import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom';

const ErrorPage = () => {

    const navigation = useNavigate();
    
    const [counter, setCounter] = useState(5);

    useEffect(() => {
        setInterval( () => {
            if(counter == 0) {
                navigation("/");
            }
            setCounter(counter - 1);
        }, 1000)

    }, [counter]) 

    
    return ( 
        <>
            <div className="container d-flex flex-column align-items-center justify-content-center">
                <h1>Redirecionando em: </h1>
                <h2>{counter}</h2>
                <img className="img-fluid" src="https://ogimg.infoglobo.com.br/in/16212941-e4b-147/FT1086A/2015052089260.jpg" alt="" />
            </div>
        </>
     );
}
 
export default ErrorPage;