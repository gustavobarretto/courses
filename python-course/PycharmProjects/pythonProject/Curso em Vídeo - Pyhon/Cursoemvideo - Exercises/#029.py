title = 'DESAFIO Nº 029'
print('{:^30}'.format(title))
print('Escreva um programa que leia a velocidade de um carro.\nSe ele ultrapassar 80Km/h, mostre uma mensagem dizendo que ele foi multado.\nA multa vai custar R$ 7,00 por cada Km acima do limite.')
v = float(input('Informe a velocidade do veículo: '))
print('Analisando a velocidade indicada do veículo...')
from time import sleep
sleep(3)
if v > 80:
    print('O carro está acima da velocidade, a multa será um total de R$ {:.2f}.'.format((v-80)*7))
else:
    print('O carro está na velocidade indicada.')