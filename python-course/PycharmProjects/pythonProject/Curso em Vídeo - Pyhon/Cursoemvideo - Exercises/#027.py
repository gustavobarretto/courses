title = 'DESAFIO Nº 027'
print('{:^30}'.format(title))
print('Faça um programa que leia o nome completo de uma pessoa, mostrando em seguida o primeiro e o último nome separadamente.')
nome = str(input('Digite seu nome completo: ')).strip()
div = nome.split()
n = len(div)
print('O seu primeiro nome é {}, e o último, {}, ficando {} {} '.format(div[0], div[n-1], div[0], div[n-1]))
