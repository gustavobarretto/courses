title = 'DESAFIO Nº 39'
print('{:^30}'.format(title))
print('Faça um programa que leia o ano de nascimento de um jovem e informe, de acordo com sua idade:'
      '\n- Se ele ainda vai se alistar ao serviço militar.'
      '\n- Se é a hora de se alistar.'
      '\n- Se já passou do tempo de alistamento.')
i = int(input('Informe o ano, com quatro dígitos, do nascimento do sujeito: '))

import datetime
d = datetime.date.today().year

if d - i > 18:
    print('Você já passou {} ano(s) do tempo de se alistar, considerando que você tem {} anos no ano de {}.'.format((d - i) - 18, d - i, d))
elif d - i < 18:
    print('Ainda falta(m) {} ano(s) para você se alistar, considerando que você tem {} anos no ano de {}.'.format(18 - (d - i), d - i, d))

else:
    print('Você está no ano de realizar seu alistamento, considerando que você tem {} anos no ano de {}.'.format(d - i, d))