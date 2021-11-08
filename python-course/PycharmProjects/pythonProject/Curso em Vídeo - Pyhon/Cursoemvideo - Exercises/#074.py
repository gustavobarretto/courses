title = ' DESAFIO Nº 074 '
print(f'{title:=^30}')
print('Crie um programa que vai gerar cinco números aleatórios e colocar em uma tupla.'
      '\nDepois disso, mostre a listagem de números gerados e também indique o menor e o maior valor que estão na tupla.')
from random import randint

números = randint(10000, 100000)
números = str(números)
tuple(números)
print(f'Os números sorteados foram {tuple(números)}.')
ordem = sorted(tuple(números))
print(f'O menor valor sorteado foi {ordem[0]}'
      f'\nO maior valor sorteado foi {ordem[4]}')
print(f'O maior valor sorteado foi {max(números)}'
      f'\nO menor valor sorteado foi {min(números)}')
