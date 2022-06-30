# Checkpoint2
## List of commands

```mongosh
use DHVacinas
```

```mongosh
db.paciente.insertMany([{"name": "Gustavo", "age": 28, "domicilio": "Salvador", "uf": "BA", "dtVacina": "20/02/2021", "vacinado": true}, {"name": "Sophia", "age": 26, "domicilio": "São Paulo", "uf": "SP", "dtVacina": "10/04/2021", "vacinado": true}, {"name": "Silas", "age": 20, "domicilio": "Rio de Janeiro", "uf": "RJ", "dtVacina": "", "situacao": false}])
```

```mongosh
db.posto.insertMany([{"unidade": "UPA - Rio Vermelho", "cidade": "Salvador", "uf": "BA", "qtdDoses": 0, "dosesDisponiveis": false}, {"unidade": "UPA - Meninópolis", "cidade": "São Paulo", "uf": "SP", "qtdDoses": 427, "dosesDisponiveis": true}])
```

```mongosh
db.paciente.aggregate(
   [
      {
         $project:
           {
             name: 1,
             vacinado: 1,
             dtVacina: 1,
             message:
               {
                 $cond: { if: { $eq: [ "$vacinado", true ] }, then: "Vacinação completa!", else: "Agendar vacinação" }
               }
           }
      }
   ]
)
```

```mongosh
db.posto.aggregate(
   [
      {
         $project:
           {
             unidade: 1,
             cidade: 1,
             uf: 1,
             message:
               {
                 $cond: { if: { $eq: [ "$dosesDisponiveis", true ] }, then: "Doses atualizadas!", else: "Aguardando distribuição!" }
               }
           }
      }
   ]
)
```
