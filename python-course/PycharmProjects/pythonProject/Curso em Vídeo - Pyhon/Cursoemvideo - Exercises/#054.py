print('{:=^30}'.format(' DESAFIO Nº 054 '))
print('Crie um programa que leia o ano de nascimento de sete pessoas.\nNo final, mostre quantas pessoas ainda não atingiram a maior idade e quantas já são de maiores.')

import datetime
maior = 0
menor = 0

for lista in range(1, 8):
    n = int(input('Digite o ano de nascimento, em quatro digitos, da {}a pessoa: '.format(lista)))
    idade = datetime.date.today().year - n

    if idade >= 21:
        maior += 1
    else:
        menor +=1

print('Existem {} pessoas maiores de idade e {} menores de idade.'.format(maior, menor))
