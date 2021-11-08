title = ' DESAFIO Nº 069 '
print(f'{title:=^30}')
print('Crie um programa que leia a idade e o sexo de várias pessoas.'
      '\nA cada pessoa cadastrada, o programa deverá perguntar se o'
      '\nusuário quer ou não continuar. No final, mostre:'
      '\nA) Quantas pessoas tem mais de 18 anos.'
      '\nB) Quantos homens foram cadastrados.'
      '\nC) Quantas mulheres tem menos de 20 anos.')

print('{:=^30}'.format(' MENU DE CADASTRO '))
contagem = maior18 = homens = menor20 = 0

while True:
    contagem += 1
    print(f'Abrindo o {contagem}º cadastro: ')
    while True:
        idade = input('Informe a idade da pessoa: ')
        if idade.isnumeric() == True:
            break
    while True:
        sexo = input('Informe o sexo da pessoa [M/F]: ').upper().strip()[0]
        if sexo == 'F' or sexo == 'M':
            break
    while True:
        resposta = input('Gostaria de realizar novo cadastro? [S/N]: ').upper().strip()[0]
        if resposta == 'N' or resposta == 'S':
            break
    if idade > 18:
        maior18 += 1
    if sexo == 'M':
        homens += 1
    if idade < 20 and sexo == 'F':
        menor20 += 1

    if resposta == 'S':
        print('{:=^30}'.format(' CADASTRO REALIZADO '))
    if resposta == 'N':
        print(' CADASTRO ENCERRADO! ')
        break

print(f'Existem {maior18} pessoas com mais de 18 anos cadastradas.')
print(f'Existem {homens} homens cadastrados.')
print(f'Existem {menor20} mulheres com menos de 20 anos cadastradas.')