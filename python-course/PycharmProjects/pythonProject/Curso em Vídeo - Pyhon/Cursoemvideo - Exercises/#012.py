title = 'DESAFIO Nº 012'
print('{:^30}'.format(title))
print('Neste desafio, você deverá informar o preço do produto e mostrar o seu valor com 5% de desconto na liquidação.')
p = float(input('Informe o valor do produto: R$ '))
print('O produto está custando R${:.2f} durante a liquidição, considerando os 5% de desconto!'.format(p*0.95))
