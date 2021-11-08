title = 'DESAFIO Nº 040'
print('{:^30}'.format(title))
print('Crie um programa que leia duas notas de um aluno e calcule sua média,'
      '\nmostrando uma mensagem no final, de acordo com a média atingida:'
      '\n- Média abaixo de 5.0: REPROVADO'
      '\n- Média entre 5.0 e 6.9: RECUPERAÇÃO'
      '\n- Média 7.0 ou superior: APROVADO')
n1 = float(input('Informe a primeira nota do aluno: '))
n2 = float(input('Informe a segunda nota do aluno: '))
media = (n1 + n2) / 2

if media < 5.0:
    print('Sua média foi {:.1f}, por isso, está reprovado.'.format(media))
elif 5.0 <= media < 7:
    print('Sua média foi {:.1f}, por isso, está na recuperação.'.format(media))
else:
    print('Sua média foi {:.1f}, por isso, está APROVADO! Meus PARABÉNS!'.format(media))