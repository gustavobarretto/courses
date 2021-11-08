title = 'DESAFIO Nº 032'
print('{:^32}'.format(title))
print('Faça um programa que leia um ano e mostre se ele é BISSEXTO.')
a = int(input('Informe o ano: '))

if a % 4 == 0:
    if a % 100 == 0:
        if a % 400 == 0:
            print('O ano {} é bissexto.'.format(a))
        else:
            print('O ano {} não é bissexto.'.format(a))
    else:
        print('O ano {} é bissexto.'.format(a))

else:
    print('O ano {} não é bissexto.'.format(a))