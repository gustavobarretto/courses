print(f'{" DESAFIO Nº 080 ":=^95}')
print('Crie um programa onde o usuário possa digitar cinco valores numéricos e cadastre-os em uma lista,'
      '\njá na posição correta de inserção (sem usar o sort()). No final, mostre a lista ordenada na tela.')

from time import sleep


lista = []
while True:
    n = input('Digite um valor: ')
    if n.isnumeric() == True:
        n = int(n)
        lista.append(n)
        print(f'O valor {n} foi adicionado na posição 0')
        break
    else:
        print('Valor digitado incorreto. Tente novamente. ', end='')

while True:
    for c, v in enumerate(lista):
        while True:
            n = input('Digite um valor: ')
            if n.isnumeric() == True:
                n = int(n)
                break

            else:
                print('Valor digitado incorreto. Tente novamente. ', end='')

        if n >= v:
            lista.insert(c+1, n)
            print(f'O valor {n} foi inserido na posição {c+1}')
        if n < v:
            lista.insert(c-1, n)
            print(f'O valor {n} foi inserido na posição {c-1}')

        if len(lista) == 5:
            break
    if len(lista) == 5:
        break

    break


print(lista)