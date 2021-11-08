title = ' DESAFIO Nº 071 '
print(f'{title:=^30}')
print('Crie um programa que simule o funcionamento de um caixa eletrônico.'
      '\nNo início, pergunte ao usuário qual será o valor a ser sacado (número inteiro)'
      '\ne o programa vai informar quantas cédulas de cada valor serão entregues.'
      '\nOBS: Considere que o caixa possui cédulas de R$50, R$20, R$10 e R$1.')

print('{:=^30}'.format(''))
print('{:^30}'.format(' MENU DO CAIXA ELETRÔNICO '))
print('{:=^30}'.format(''))
ced50 = ced20 = ced10 = ced1 = resto = 0
while True:
    while True:
        valor = input('Informe o valor que deseja sacar: R$ ')
        if valor[0].isnumeric() == True:
            valor = int(valor)
            break
    if valor // 50 >= 0:
        ced50 = valor // 50
        resto50 = valor - (50 * ced50)

        if resto50 // 20 >= 0:
            ced20 = resto50 // 20
            resto20 = resto50 - (20 * ced20)

            if resto20 // 10 >= 0:
                ced10 = resto20 // 10
                resto10 = resto20 - (10 * ced10)
    ced1 = resto10 // 1
    break

print(f'Total de cédulas de 50: {ced50}'
      f'\nTotal de cédulas de 20: {ced20}'
      f'\nTotal de cédulas de 10: {ced10}'
      f'\nTotal de cédulas de 1: {ced1}')


