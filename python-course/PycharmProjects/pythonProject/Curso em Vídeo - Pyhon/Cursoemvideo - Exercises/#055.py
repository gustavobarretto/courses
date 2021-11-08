print('{:=^30}'.format(' DESAFIO N º055 '))
print('Faça um programa que leia o peso de cinco pessoas. No final, mostre qual foi o maior e o menor peso lidos.')

from time import sleep

maior = float(input('Digite o peso da pessoa em kg: '))

for lista in range(4):
    peso = float(input('Digite o peso da pessoa em kg: '))
    if peso > maior:
        maior = peso
    else:
        menor = peso

print('O maior peso lido foi de {}Kg.'.format(maior))
print('O menor peso lido foi de {}Kg.'.format(menor))
