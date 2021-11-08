title = 'DESAFIO Nº 019'
print('{:^30}'.format(title))
print('Neste desafio, um professor quer sortear um dos seus quatro alunos para apagar o quadro.\nFaça um programa que ajude ele, lendo o nome deles e escrevendo o nome escolhido.')
n1 = input('Informe o nome do primeiro aluno: ')
n2 = input('Informe o nome do segundo aluno: ')
n3 = input('Informe o nome do terceiro aluno: ')
n4 = input('Informe o nome do quarto aluno: ')
sequel = [n1, n2, n3, n4]
from random import choice
print('O aluno escolhido para apagar o quadro é {}.'.format(choice(sequel)))
