title = 'DESAFIO Nº 033'
print('{:^30}'.format(title))
print('Faça um programa que leia três números e mostre qual é o maior e qual é o menor.')
n1 = int(input('Digite o primeiro número: '))
n2 = int(input('Digite o segundo número: '))
n3 = int(input('Digite o terceiro número: '))

if n1 >= n2 and n1 <= n3:
    print('{} é o maior número e {} é o menor número.'.format(n3, n2))
elif n1 <= n2 and n1 >= n3:
    print('{} é o maior número e {} é o menor número.'.format(n2, n3))
elif n2 >= n1 and n2 <= n3:
    print('{} é o maior número e {} é o menor número.'.format(n3, n1))
elif n2 <= n1 and n2 >= n3:
    print('{} é o maior número e {} é o menor número.'.format(n1, n3))
elif n3 >= n2 and n3 <= n1:
    print('{} é o maior número e {} é o menor número.'.format(n1, n2))
elif n3 <= n2 and n3 >= n1:
    print('{} é o maior número e {} é o menor número.'.format(n2, n1))
