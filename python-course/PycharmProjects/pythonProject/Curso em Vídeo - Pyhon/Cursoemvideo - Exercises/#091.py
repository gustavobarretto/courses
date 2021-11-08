print(f'{" DESAFIO Nº 091 ":=^30}')
print(f'Crie um programa onde \033[33m4 jogadores\033[m joguem um \033[34mdado\033[m e tenham resultados \033[34maleatórios\033[m.'
'\nGuarde esses resultados em um \033[33mdicionário\033[m. No final, coloque esse dicionário em \033[33mordem\033[m, sabendo'
'\nque o \033[34mvencedor\033[m tirou o \033[33mmaior número\033[m no dado.')

quartoColocado = terceiroColocado = segundoColocado = primeiroColocado = 0
nomePrimeiroColocado = nomeSegundoColocado = nomeTerceiroColocado = nomeQuartoColocado = ''

print()
from random import randint
from time import sleep
resultados = {'jogador1': '', 'jogador2': '', 'jogador3': '', 'jogador4': ''}
for k, v in resultados.items():
    resultados[k] = randint(1, 6)
print(f'{" NÚMEROS JOGADOS NOS DADOS ":=^30}\n')
for k, v in resultados.items():
    sleep(1)
    print(f'O {k} recebeu o valor {v}')
print(f'{" COLOCAÇÕES ":=^30}\n')

listaNumeros = []
listaOrdem = []

for k, v in resultados.items():
    listaNumeros.append(v)

listaOrdem = listaNumeros[:]
listaNumeros.sort()
contagem = 0
while True:
    if listaNumeros[3] == listaOrdem[contagem]:
        sleep(1)
        print(f'O primeiro colocado tirou {listaNumeros[3]} e é o jogador{contagem+1}')
        if listaNumeros[2] == listaOrdem[contagem]:
            print(f'O segundo colocado tirou {listaNumeros[2]} e é o jogador{contagem+2}')
            if listaNumeros[1] == listaOrdem[contagem]:
                print(f'O terceiro colocado tirou {listaNumeros[1]} e é o jogador{contagem+2}')
                if listaNumeros[0] == listaOrdem[contagem]:
                    print(f'O quarto colocado tirou {listaNumeros[0]} e é o jogador{contagem+3} ')
        contagem = 0
        break
    else:
        contagem += 1

while True:
    if listaNumeros[2] == listaOrdem[contagem]:
        sleep(1)
        print(f'O segundo colocado tirou {listaNumeros[2]} e é o jogador{contagem+1}')
        if listaNumeros[1] == listaOrdem[contagem]:
            print(f'O terceiro colocado tirou {listaNumeros[1]} e é o jogador{contagem+2}')
            if listaNumeros[0] == listaOrdem[contagem]:
                print(f'O quarto colocado tirou {listaNumeros[0]} e é o jogador{contagem+3}')
        contagem = 0 
        break
    else:
        contagem += 1

while True:
    if listaNumeros[1] == listaOrdem[contagem]:
        sleep(1)
        print(f'O terceiro colocado tirou {listaNumeros[1]} e é o jogador{contagem+1}')
        if listaNumeros[0] == listaOrdem[contagem]:
            print(f'O quarto colocado tirou {listaNumeros[0]} e é o jogador{contagem+2}')
        contagem = 0
        break
    else:
        contagem += 1
while True:
    if listaNumeros[0] == listaOrdem[contagem]:
        sleep(1)
        print(f'O quarto colocado tirou {listaNumeros[0]} e é o jogador{contagem+1}')
        contagem = 0
        break
    else:
        contagem += 1