print('{:=^30}'.format(' DESAFIO Nº 060 '))
print('Faça um programa que leia um número qualquer e mostre o seu fatorial.')
n = int(input('Informe o número: '))
f = 1
print('Calculando o fatorial de {}! = '.format(n), end='')
from time import sleep
sleep(3)
while n > 0:
    print('{}'.format(n), end='')
    print(' x ' if n > 1 else ' = ', end='')
    f *= n
    n -= 1
print('{}'.format(f), end='')