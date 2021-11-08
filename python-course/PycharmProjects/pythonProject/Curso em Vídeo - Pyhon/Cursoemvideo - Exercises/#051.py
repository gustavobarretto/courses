print('{:=^30}'.format(' DESAFIO Nº 051 '))
print('Desenvolva um programa que leia o primeiro termo e a razão de uma PA.'
      '\nNo final, mostre os 10 primeiros termos dessa progressão.')

p = int(input('Digite o primeiro termo: '))
r = int(input('Digite a razão: '))
d = p + (10 - 1) * r

print('A sequência desta progressão aritmética é: ')


for pa in range(p, d + r, r):
    print('[{}] '.format(pa), end='')