print(f'{" DESAFIO Nº 082 ":=^30}')
print('Crie um programa que vai ler vários números e colocar em uma lista.'
      '\nDepois disso, crie duas listas extras que vão conter apenas os '
      '\nvalores pares e os valores ímpares digitados, respectivamente.'
      '\nAo final, mostre o conteúdo das três listas geradas.')

lista = []
listapar = []
listaimpar = []

contagem = 0
resposta = ''
while True:
    n = input('Digite um número: ')
    if n.isnumeric() == True:
        n = int(n)
        lista.append(n)
        print(f'Número {n} adicionado à lista!')
        while True:
            resposta = input('Deseja digitar um novo número? [S/N]: ').upper().strip()
            if type(resposta) == str and resposta == 'S' or resposta == 'N':
                break
            else:
                print(f'O valor {resposta} não é legível. Tente novamente. ', end='')
    else:
        print(f'O valor {n} digitado é incorreto e não pode ser adicionado. Tente novamente. ', end='')

    if resposta == 'N':
        break

while True:
    if len(lista) == contagem:
        break

    if lista[contagem] % 2 == 0:
        listapar.append(lista[contagem])
        contagem += 1
    else:
        listaimpar.append(lista[contagem])
        contagem += 1


print(f'Os valores digitados são a lista {lista}.'
      f'\nOs valores ímpares estão na lista {listaimpar}.'
      f'\nOs valores pares estão na lista {listapar}.')



