title = 'DESAFIO Nº 035'
print('{:^30}'.format(title))
print('Desenvolva um programa que leia o comprimento de três retas e diga ao usuáiro se elas podem ou não formar um triângulo.')
r1 = float(input('Informe o comprimento da primeira reta: '))
r2 = float(input('Informe o comprimento da segunda reta: '))
r3 = float(input('Informe o comprimento da terceira reta: '))

if r1 < r2 + r3 and r2 < r1 + r3 and r3 < r1 + r2:
    print('O comprimento das retas informadas podem formar um triângulo.')
else:
    print('O comprimento das retas informadas não podem formar um triãngulo.')
