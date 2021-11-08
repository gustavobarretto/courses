title = 'DESAFIO Nº 10'
print('{:^30}'.format(title))
print('Neste desafio, você deve informar quantos dinheiros você tem na carteira em reais, para saber quantos dólares você consegue comprar, considerando a cotação de R$ 3.27 em 2017.')
d = float(input('Quantos de dinheiro você tem na carteira: '))
print('Você poderá comprar o equivalente a U${:.2f}.'.format(d/3.27))
