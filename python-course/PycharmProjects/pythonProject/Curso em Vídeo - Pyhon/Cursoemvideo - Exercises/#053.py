print('{:=^30}'.format(' DESAFIO Nº 053 '))
print('Crie um programa que leia uma frase qualquer e diga se ela é um PALÍNDROMO, desconsiderando os espaços.')
f = input('Digite a frase: ').upper().strip()


s = len(f)
print('Existem {} letras em {}.'.format(s, f))


import time

calc = 0
veracidade = 0
for l in range(s, 0, -1):
    time.sleep(1)
    if l <= s:
        calc += 1
        t = s - calc
        print(f[s-calc])
        if f[t] == f[calc-1]:
            print('A palavra {} é igual a {}. {}.'.format(f[t], f[calc-1], (f[t] == f[calc-1])))
            veracidade += 1
        else:
            print('Não se trata de um palíndromo. {}'.format(f[t] == f[calc-1]))

time.sleep(1)
print('Há {} letras iguais, portanto: '.format(veracidade))

if veracidade == s:
    print('Esta palavra é um palíndromo.')
else:
    print('Esta palavra não é um palíndromo.')




