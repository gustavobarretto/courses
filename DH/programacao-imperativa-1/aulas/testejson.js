let funcionarioJson = '{"Nome": "Francisco", "idade": 28, "Vacinado": true, "Filhos": ["Mariazinha", "Francisquinho"]}'

let funcionarioConvertido = JSON.parse(funcionarioJson)
console.log(funcionarioConvertido)
console.log(funcionarioJson)

let funcionarioOb = JSON.stringify(funcionarioJson)
console.log(funcionarioOb)