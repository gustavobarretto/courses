print('{:=^30}'.format(' DESAFIO Nº 0 63 '))
print('Escreva um programa que leia um número n inteiro qualquer e'
      '\ne mostre na tela os n primeiros elementos de uma Sequência de Fibonacci.')

n = int(input('Escolha o número: '))
sequencia = int(input('Escolha a sequência de números a aparecer: '))

y = n - 1
print('A sequência ')
for c in range(0, sequencia, 1):
    r = n + y
    print(r, end= ' ')
    y = n
    n = r

