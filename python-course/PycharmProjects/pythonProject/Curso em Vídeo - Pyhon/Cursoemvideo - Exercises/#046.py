print('{:=^30}'.format(' DESAFIO Nº 046 '))
print('Faça um programa que mostre na tela uma contagem regressiva para o estouro de fogos de artifício,'
      '\n indo de 10 até 0, com uma pausa de 1 segundo entre eles.')
import time
print('FAREMOS A CONTAGEM DOS FOGOS DE ARTIFÍCIO: ')
for f in range(10, -1, -1):
    time.sleep(1)
    print('E é {}!'.format(f))
time.sleep(1)
print('FELIZ ANO NOVO!')