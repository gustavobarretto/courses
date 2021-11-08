title = 'DESAFIO Nº 031'
print('{:^30}'.format(title))
print('Desenvolva um programa que pergunte a distância de uma viagem em Km.\nCalcule o preço da passagem, cobrando R$ 0,50, por Km para viagens de até 200Km e R$ 0,45 para viagens mais longas.')
d = float(input('Informe a distância de sua viagem: '))
if d <= 200.00:
    print('O preço de sua viagem será de R$ {:.2f}.'.format(d*0.50))
else:
    print('O preço de sua viagem será de R$ {:.2f}.'.format(d*0.45))