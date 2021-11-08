title = 'DESAFIO Nº 030'
print('{:^30}'.format(title))
print('Crie um programa que leia um número inteiro e mostre na tela se ele é par ou ímpar.')
n = int(input('Escolha um número: '))
if n % 2 == 0:
    print('Este número é par.')
else:
    print('Este número é ímpar.')