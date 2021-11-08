title = 'DESAFIO Nº 015'
print('{:^30}'.format(title))
print('Escreva um programa que pergunte a quantidade em km percorridos por um carro alugado e quantidade de dias pelos quais ele foi alugado. Calcule o preço a pagar, sabendo que o carro custa R% 60.00 reais por dia e R$ 0.15 por km rodado.')
km = float(input('Informe a km rodada do seu veículo: '))
d = int(input('Informe o total de dias de utilização do veículo: '))
print('Considerando que foram {:.2f} km rodados em {} dias, você deverá pagar pelo aluguel o valor de R${:.2f}.'.format(km, d, (km*0.15)+(d*60)))