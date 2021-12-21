const express = require('express');
const { v4: uuidv4 } = require("uuid");

const app = express();

app.use(express.json());

const customers = [];

// cpf - string
// name - string
// id - uuid;
// statment []

app.post("/account", (request, response) => {
    const { cpf, name } = request.body;

    const customerAlreadyExists = customers.some( 
        (constumers) => constumers.cpf === cpf
    );

    if(customerAlreadyExists) {
        return response.status(400).json({ error: "Customer already exists!" });
    }

    customers.push({
        cpf,
        name,
        id: uuidv4(),
        statment: []
    });

    return response.status(201).send()
    
});

app.get("/statement/", (request, response) => {
    const { cpf } = request.headers;

    const customer =  customers.find( customer => customer.cpf === cpf);

    if(!customer) {
        return response.status(400).json({ error: "Customer not found!" }); 
    }


    return response.json(customer.statment);
})

app.listen(3333);

