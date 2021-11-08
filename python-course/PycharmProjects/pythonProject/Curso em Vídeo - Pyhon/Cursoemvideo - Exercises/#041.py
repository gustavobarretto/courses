title = 'DESAFIO Nº 041'
print('{:^30}'.format(title))
print('A Confederação Nacional de Natação precisa de um programa que leia o ano de nascimento'
      '\nde um atleta e mostre sua categoria, de acordo com a idade:'
      '\n- Até 9 anos: MIRIM'
      '\n- Até 14 anos: INFANTIL'
      '\n- Até 19 anos: JUNIOR'
      '\n- Até 25 anos: SENIOR'
      '\n- Acima: MASTER')
age = int(input('Digite o ano de nascimento do atleta: '))
import datetime
i = datetime.date.today().year - age

if i < 10:
    print('Este atleta estará na categoria MIRIM, considerando que ele tem {} anos.'.format(i))
elif i < 15:
    print('Este atleta estará na categoria INFANTIL, considerando que ele tem {} anos.'.format(i))
elif i < 20:
    print('Este atleta estará na categoria JUNIOR, considerando que ele tem {} anos.'.format(i))
elif i <= 25:
    print('Este atleta estará na categoria SENIOR, considerando que ele tem {} anos.'.format(i))
else:
    print('Este atleta estará na categoria MASTER, considerando que ele tem {} anos.'.format(i))