print('{:=^30}'.format(' DESAFIO Nº 047 '))
print('Crie um programa que mostre na tela todos os números pares em vermelho'
      '\nque estão no intervalo escolhidos pelo usuário.')
from time import sleep
i = int(input('Informe o número inicial da análise: '))
f = int(input('Informe o número final da análise: '))
print('Apresentando todos os números pares de {} a {} em cores vermelhas.'.format(i, f))
sleep(1)
for p in range(i, f+1):
    if p % 2 == 0:
        print('\033[31m{}\033[m'.format(p), end=' ')
    else:
        print(p, end=' ')

print('\nFIM')