print('{:=^30}'.format(' DESAFIO Nº 052 '))
print('Faça um programa que leia um número inteiro e diga se ele é ou não um número primo.')
n = int(input('Digite um número: '))

s = 0
for np in range(1, n+1):
    if n % np == 0:
        s += 1
if s > 2:
    print('\nEste número não é primo.')
elif s == 2:
    print('\nEste número é primo.')
elif s < 2:
    print('\nEste número não é primo.')


## numero = int(input('Digite um número: '))
## qntDivisores = 0
## for divisor in range(1, numero + 1):
##    if numero % divisor == 0:
##        qntDivisores += 1
##        if qntDivisores > 2:
##            break
##if qntDivisores > 2:
##    print('\nEste número não é primo.')
##elif qntDivisores == 2:
##    print('\nEste número é primo.')
##elif qntDivisores < 2:
##    print('\nEste número não é primo.')


