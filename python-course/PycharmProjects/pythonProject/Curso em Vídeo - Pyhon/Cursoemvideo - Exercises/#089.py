print(f'{" DESAFIO Nº 089 ":=^30}')
print('Crie um programa que leia \033[34mnome\033[m e \033[34mduas notas\033[m de vários alunos'
      '\ne guarde tudo em uma \033[33mlista composta\033[m. No final, mostre um \033[34mboletim\033[m'
      '\ncontendo a \033[33mmédia\033[m de cada um e permita que o usuário possa mostrar as \033[34mnotas\033[m'
      '\nde cada aluno individualmente.')

alunos = 1
aluno = []
turma = []
médias = []
while True:
    nome = str(input(f'Insira o nome do {alunos}º aluno: '))
    n1 = float(input('Insira a primeira nota do aluno: '))
    n2 = float(input('Insira a segunda nota do aluno:'))
    aluno.append(nome)
    aluno.append(n1)
    aluno.append(n2)
    turma.append(aluno[:])
    aluno.clear()
    alunos += 1

    while True:
        resposta = input('Deseja cadastrar mais um aluno? [S/N]: ').upper().strip()[0]
        if resposta == 'S' or resposta == 'N':
            break
        else:
            print('Você digitou algo errado. Tente novamente, digitando S ou N. ', end='')

    if resposta == 'N':
        break

while True:
    print('=' * 50)
    print(f'{" LISTA DE ALUNOS ":=^50}')
    print('Digite o número do aluno no menu para saber suas '
          '\nnotas ou SAIR para encerrar o programa.')
    print('=' * 50)
    print(f'{"ALUNO":<34} {"MÉDIA"}')
    for c in range(len(turma)):
        print(f'{c} - {turma[c][0]:<30} {(turma[c][1] + turma[c][2]) / 2:.1f}')

    nota = input('Digite o número respectivo do aluno que você deseja saber as notas: ').upper().strip()
    if nota == 'SAIR':
        print('\nEncerrando o programa!')
        break

    if nota.isnumeric() == True:
        nota = int(nota)
        if nota >= len(turma):
            print('\nEste valor não é vinculado a nenhum aluno. Tente novamente.')
        else:
            print(f'\nO aluno {turma[nota][0]} tirou as notas {turma[nota][1]} e {turma[nota][2]}.')







