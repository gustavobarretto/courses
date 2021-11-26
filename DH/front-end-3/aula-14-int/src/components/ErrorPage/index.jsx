import React, { useState, useEffect } from 'react'
import Home from '../Home';

const ErrorPage = () => {

    const [counter, setCounter] = useState(5);

    useEffect(() => {
        setInterval( () => {
            setCounter(counter - 1);
        }, 1000)

    }, [counter])

    

    
    
    return ( 
        <>
            <div className="container d-flex flex-column align-items-center justify-content-center">
                <h1>{counter}</h1>
                <img className="img-fluid" onChange={counter == 0 ? onClick() : ''} src="https://ogimg.infoglobo.com.br/in/16212941-e4b-147/FT1086A/2015052089260.jpg" alt="" />
            </div>
        </>
     );
}
 
export default ErrorPage;