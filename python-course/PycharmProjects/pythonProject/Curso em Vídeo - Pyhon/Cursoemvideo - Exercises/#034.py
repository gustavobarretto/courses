title = 'DESAFIO Nº 034'
print('{:^30}'.format(title))
print('Escreva um programa que pergunte o salário de um funcionário e calcule o valor do seu aumento.\nPara salários superiores a R$ 1.250, calcule um aumento de 10%.\nPara os inferiores, o aumento é de 15%.')
s = float(input('Informe o salário do funcionário: '))
if s <= 1250.00:
    print('O aumento que este funcionário deve receber é de R$ {:.2f}, totalizando R$ {:.2f}.'.format(s*0.15, s*1.15))
else:
    print('O aumento que este funcionário deve receber é de R$ {:.2f}, totalizando R$ {:.2f}.'.format(s*0.10, s*1.10))
