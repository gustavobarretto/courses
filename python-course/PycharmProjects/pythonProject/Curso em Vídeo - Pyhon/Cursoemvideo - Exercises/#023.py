title = 'DESAFIO Nº 023'
print('{:^30}'.format(title))
print('Faça um programa que leia um número de 0 a 9999 e mostre na tela cada um dos dígito separados.')
n = (input('Digite um número de 0 a 9999: '))
if n == str('0'):
    print('O número é 0.')

elif len(n) == 1 >= int(1):
    print('Não há milhar, centena ou dezena.\nA unidade é {}'.format(n[0]))

elif len(n) == 2:
    print('Não há milhar ou centena.\nA dezena é {} e a unidade é {}'.format(n[0], n[1]))

elif len(n) == 3:
    print('Não há milhar.\nA centena é {}, a dezena é {} e a unidade é {}'. format(n[0], n[1], n[2]))

elif len(n) == 4:
    print('{} é um milhar.\n{} é uma centena.\n{} é uma dezena.\n{} é uma unidade.'.format(n[0], n[1], n[2], n[3]))
