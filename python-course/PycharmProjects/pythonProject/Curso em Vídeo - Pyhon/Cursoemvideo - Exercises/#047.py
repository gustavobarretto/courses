print('{:=^30}'.format(' DESAFIO Nº 047 '))
print('Crie um programa que mostre na tela todos os números pares'
      '\nque estão no intervalo entre 1 e 50.')
from time import sleep
print('Apresentando todos os números pares de 1 a 50.')
sleep(1)
for p in range(2, 51, 2):
    print(p, end=' ')
print('\nFIM')