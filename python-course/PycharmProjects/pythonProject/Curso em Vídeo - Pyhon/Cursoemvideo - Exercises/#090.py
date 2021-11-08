print(f'{" DESAFIO Nº 090 ":=^30}')
print(f'Faça um programa que leia o \033[34mnome e média\033[m de um aluno, guardando também'
'\na \033[34msituação\033[m em um \033[33mdicionário\033[m. No final, mostre o conteúdo da estrutura na tela.')
alunos = []
dicionário = {'Nome': '', 'Média': '' , 'Situação': ''}

dicionário['Nome'] = str(input('Digite o nome do aluno: '))
dicionário['Média'] = float(input('Digite a média do aluno: '))
if dicionário['Média'] >= 7:
    dicionário['Situação'] = 'Aprovado'
else:
    dicionário['Situação'] = 'Reprovado'

for k, v in dicionário.items():
    print(f'{k} dele é {v}')