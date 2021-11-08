print(f'{" DESAFIO Nº 080 ":=^95}')
print('Crie um programa onde o usuário possa digitar cinco valores numéricos e cadastre-os em uma lista,'
      '\njá na posição correta de inserção (sem usar o sort()). No final, mostre a lista ordenada na tela.')

from time import sleep

lista = []
contagem = int(0)

while True:
    n = input('Digite um valor: ')
    if n.isnumeric() == True:
        n = int(n)
        lista.append(n)
        break
    else:
        print('Valor digitado incorreto. Tente novamente. ', end='')

while True:
    if len(lista) == 5:
        break

    while True:
        n = input('Digite um valor: ')
        if n.isnumeric() == True:
            n = int(n)
            contagem = 0
            break
        else:
            print('Valor digitado incorreto. Tente novamente. ', end='')
    while True:
        if n >= lista[contagem]:
            if len(lista) == contagem + 1:
                lista.append(n)
                print(f'O valor {n} foi adicionado à última posição.')
                break
            if len(lista) > contagem + 1 and n < lista[contagem + 1]:
                lista.insert(contagem + 1, n)
                print(f'O valor {n} foi adicionado à posição {contagem + 1}')
                break
            if len(lista) > contagem + 1 and n >= lista[contagem + 1]:
                contagem += 1

        if n <= lista[contagem] and contagem == 0:
            lista.insert(0, n)
            print(f'O valor {n} foi adicionado na primeira posição.')
            break

print(lista)
