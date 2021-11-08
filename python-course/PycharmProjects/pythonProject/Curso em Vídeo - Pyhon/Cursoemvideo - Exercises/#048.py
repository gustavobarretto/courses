print('{:=^30}'.format(' DESAFIO Nº 048 '))
print('Faça um programa que a soma entre todos os números ímpares que são múltiplos de três'
      '\ne que se encontram no intervalo de 1 até 500.')
s = 0
ns = 0
for mt in range(1, 500, 3):
    n = mt - 1
    if n % 2 != 0 and n % 3 == 0:
        print(n, end=' ')
        s += n
        ns += 1
print('\nA soma de todos os {} números ímpares múltiplos por 3 é {}.'.format(ns, s))