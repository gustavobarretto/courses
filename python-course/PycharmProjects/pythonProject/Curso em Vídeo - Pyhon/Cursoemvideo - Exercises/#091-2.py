print(f'{" NÚMERO DOS DADOS ":=^30}')
jogadoresDados = dict()
listaDados = list()
listaOrdem = list()
nomePrimeiroColocado = 4
nomeSegundoColocado = 2
nomeTerceiroColocado = 1
nomeQuartoColocado = contagem = 0

from random import randint
from time import sleep
for c in range(1, 5):
    jogadoresDados[f'jogador{c}'] = randint(1, 6)
    
for k, v in jogadoresDados.items():
    print(f'O {k} tirou o dado {v}')
    listaDados.append(v)
    listaOrdem.append(v)
    listaDados.sort()

print(f'{" RANKING ":=^30}')
for k, v in jogadoresDados.items():
    if listaDados[3] == v:
       primeiroColocado = v
       if k != nomeSegundoColocado != nomeTerceiroColocado != nomeQuartoColocado:
           nomePrimeiroColocado = k
               
    if listaDados[2] == v:
        segundoColocado = v
        if k != nomePrimeiroColocado != nomeTerceiroColocado != nomeQuartoColocado:
            nomeSegundoColocado = k
        
    if listaDados[1] == v:
        terceiroColocado = v
        if k !=  nomeQuartoColocado != nomePrimeiroColocado != nomeSegundoColocado:
            nomeTerceiroColocado = k
        
    if listaDados[0] == v:
        quartoColocado = v
        if k != nomePrimeiroColocado != nomeSegundoColocado != nomePrimeiroColocado:
            nomeQuartoColocado = k


print(f'O primeiro colocado tirou {primeiroColocado} no dado e é o {nomePrimeiroColocado}')
print(f'O segundo colocado tirou {segundoColocado} no dado e é o {nomeSegundoColocado}')
print(f'O terceiro colocado tirou {terceiroColocado} no dado e é o {nomeTerceiroColocado}')
print(f'O quarto colocado tirou {quartoColocado} no dado e é o {nomeQuartoColocado}')
        
        



print(jogadoresDados)
print(listaDados)
print(listaOrdem)