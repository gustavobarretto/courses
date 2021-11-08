print('{:=^30}'.format(' DESAFIO Nº 060 '))
print('Faça um programa que leia um número qualquer e mostre o seu fatorial.')

n = int(input('Informe o número: '))

fatorial = n - 1
multiplicacao = n * fatorial

while fatorial != 1:
    fatorial += -1
    multiplicacao *= fatorial

print('\nO fatorial de {} é {}.'.format(n, multiplicacao))
