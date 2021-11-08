listaNúmeros = [2, 5, 3, 4]
listaOrdem = [0 , 1, 2, 4]

listaOrdem = listaNúmeros[:]
listaNúmeros.sort()

print(listaOrdem)
print(listaNúmeros)
contagem = 0

while True:
    if listaNúmeros[3] == listaOrdem[contagem]:
        print(f'O primeiro colocado tirou {listaNúmeros[3]} e é o jogador{contagem+1}')
        contagem = 0
        break
    else:
        contagem += 1

while True:
    if listaNúmeros[2] == listaOrdem[contagem]:
        print(f'O segundo colocado tirou {listaNúmeros[2]} e é o jogador{contagem+1}')
        contagem = 0 
        break
    else:
        contagem += 1

while True:
    if listaNúmeros[1] == listaOrdem[contagem]:
        print(f'O terceiro colocado tirou {listaNúmeros[1]} e é o jogador{contagem+1}')
        contagem = 0
        break
    else:
        contagem += 1
while True:
    if listaNúmeros[0] == listaOrdem[contagem]:
        print(f'O quarto colocado tirou {listaNúmeros[0]} e é o jogador{contagem+1}')
        contagem = 0
        break
    else:
        contagem += 1
