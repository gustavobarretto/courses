print('{:=^30}'.format(' DESAFIO Nº 50 '))
print('Desenvolva um programa que leia seis números inteiros e mostre a soma apenas daqueles que forem pares.'
      '\nSe o valor digitado for ímpar, desconsidere-o.')
s = 0
for l in range(1, 7):
    n = int(input('Digite o {}º número: '.format(l)))
    if n % 2 == 0:
        s += n
print('A soma dos números pares dos 6 números indicados é igual a {}.'.format(s))