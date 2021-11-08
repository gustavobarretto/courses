title = 'DESAFIO Nº 025'
print('{:^30}'.format(title))
print('Crie um programa que leia o nome de uma pessoa e diga se ela tem SILVA no nome.')
n = str(input('Digite o nome da pessoa: ')).strip().upper()

if 'SILVA' in n:
    print('Esse nome tem Silva.')

else:
    print('Esse nome não tem Silva.')
