print(f'{" DESAFIO Nº 084 ":=^30}')
print('Faça um programa que leia nome e peso de várias pessoas, guardando tudo em uma lista.'
      '\nNo final, mostre:'
      '\nA) Quantas pessoas foram cadastradas.'
      '\nB) Uma listagem com as pessoas mais pesadas.'
      '\nC) Uma listagem com as pessoas mais leves.')

pessoas = []
pessoa = []
contagem = maiorpeso = menorpeso = 0

while True:
    nome = input('Digite o nome da pessoa: ').strip()
    print('Nome adicionado.')
    while True:
        peso = float(input('Digite o peso da pessoa: '))
        if peso.isnumeric() == True:
            print('Peso adicionado.')
            break
        else:
            print('Há algo de errado no que digitou. Tente novamente, com apenas números. ', end='')

    if maiorpeso == 0 and menorpeso == 0:
        maiorpeso = peso
        menorpeso = peso

    if peso > maiorpeso:
        maiorpeso = peso
    elif peso < menorpeso:
        menorpeso = peso

    pessoa.append(nome)
    pessoa.append(peso)
    contagem += 1
    pessoas.append(pessoa[:])
    pessoa.clear()

    while True:
        resposta = input('Gostaria de registrar mais uma pessoa? [S/N]: ').strip().upper()[0]
        if resposta == 'S' or resposta == 'N':
            break
        else:
            print(f'Você digitou algo errado. Tente digitar S ou N. ', end='')

    if resposta == 'N':
        break

print(f'Foram cadastradas {contagem} pessoas.')
print(f'O maior peso foi {maiorpeso:.2f}. Esse peso é pertencente a: ', end='')
for c in pessoas:
    if c[1] == maiorpeso:
        print(f' >{c[0]}< ', end='')
print(f'\nO menor peso foi {menorpeso:.2f}. Esse peso é pertencente a: ', end='')
for c in pessoas:
    if c[1] == menorpeso:
        print(f' >{c[0]}< ', end='')




