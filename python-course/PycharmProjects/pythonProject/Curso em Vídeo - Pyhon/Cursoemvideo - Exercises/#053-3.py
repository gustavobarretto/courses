print('TESTE')

print('{:=^30}'.format(' DESAFIO Nº 053 '))
print('Crie um programa que leia uma frase qualquer e diga se ela é um PALÍNDROMO, desconsiderando os espaços.')
f = input('Digite a frase: ').upper().strip()
blank = f.count(' ')
print(blank)
subs = f.replace(' ', '')
print(f)
total = len(f)

s = total-blank
print(s)
print('Existem {} letras em {}.'.format(s, f))