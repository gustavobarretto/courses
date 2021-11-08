from math import floor
title = 'DESAFIO Nº 016'
print('{:^30}'.format(title))
n = float(input('Digite um número real para que possamos informar na tela a sua porção inteira: '))
print('Você escolheu o número real {}, de modo que sua porção inteira é {}.'.format(n, floor(n)))