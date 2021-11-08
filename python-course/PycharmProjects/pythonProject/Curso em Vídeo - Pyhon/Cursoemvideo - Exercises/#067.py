title = ' DESAFIO Nº 067 '
print(f'{title:=^30}')
print('Faça um programa que mostre a tabuada de vários números, um de cada vez, para cada valor digitado pelo o usuário.'
      '\nO programa será interrompido quando o número solicitado for negativo.')

número = 0

while True:
    número = int(input('Digite o número a ser apresentado pela tabuada: '))
    if número < 0:
        break
    print('{:=^30}'.format(' RESULTADOS '))
    for tabuada in range(1, 11, 1):
        resultado = número * tabuada
        print(f'{número} x {tabuada} = {resultado}')
    print('{:=^30}'.format(''))
print('Programa encerrado!')