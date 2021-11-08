print(f'{" DESAFIO Nº 081 ":=^30}')
print('Crie um programa que vai ler vários números e colocar em uma lista.'
      '\nDepois disso, mostre:'
      '\nA) Quantos números foram digitados.'
      '\nB) A lista de valores, ordenada de forma decrescente.'
      '\nC) Se o valor 5 foi digitado e está ou não na lista.')

lista = []
contagem = 0
while True:
    n = input('Digite um número: ')
    if n.isnumeric() == True:
        n = int(n)
        lista.append(n)
        contagem += 1
    else:
        print(f'Valor digitado incorreto. Tente novamente. ', end='')

    while True:
        resposta = input('Gostaria de informar um novo número? [S/N]: ').upper().strip()[0]
        if type(resposta) == str and resposta[0] == 'S' or resposta[0] == 'N':
            break
        else:
            print(f'A resposta "{resposta}" está incorreta. Digite novamente. ', end='')

    if resposta == 'N':
        break


print(f'Foram digitados {contagem} números.')
lista.sort(reverse=True)
print(f'A lista em ordem descrescente é {lista}')
if 5 in lista:
    print(f'O valor 5 foi digitado nesta lista.')
else:
    print('Não há valor 5 nesta lista.')
