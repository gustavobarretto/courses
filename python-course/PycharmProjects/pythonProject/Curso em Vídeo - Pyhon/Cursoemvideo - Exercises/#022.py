title = 'DESAFIO Nº 022'
print('{:^30}'.format(title))
print('Crie um programa que leia o nome completo de uma pessoa e mostre:\n1 - O nome com todas as letras maiúsculas.\n2 - O nome com todas as minúsculas.\n3 - Quantas letras ao todo (sem considerar os espaços).\n4 - Quantas letras tem o primeiro nome.')
nome = input('Digite o nome completo desta pessoa: ').strip()
print(nome.upper())
print(nome.lower())
blank = int(nome.count(' '))
total = int(len(nome))
print('Existem um total de {} letras'.format(total-blank))
div = nome.split()
print('O primeiro nome têm {} letras'.format(len(div[0])))
