title = 'DESAFIO Nº 020'
print('{:^30}'.format(title))
print('O mesmo professor do desafio anterior quer sortear a ordem de apresentação de trabalhos dos alunos.\nFaça um programa que leia o nome dos quatro alunos e mostre a ordem sorteada.')
n1 = input('Informe o nome do primeiro aluno: ')
n2 = input('Informe o nome do segundo aluno: ')
n3 = input('Informe o nome do terceiro aluno: ')
n4 = input('Informe o nome do quarto aluno: ')
s = (n1, n2, n3, n4)
from random import sample
print('A sequência de alunos é {}'.format(sample(s, 4)))
