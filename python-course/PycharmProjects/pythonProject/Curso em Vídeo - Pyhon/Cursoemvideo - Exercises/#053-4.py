print('{:=^30}'.format(' DESAFIO Nº 053 '))
print('Crie um programa que leia uma frase qualquer e diga se ela é um PALÍNDROMO, desconsiderando os espaços.')
frase = str(input('Digite a frase para verificarmos se é um palíndromo: ')).upper().strip().split()
frasej = ''.join(frase)
frasei = ''

for letra in range(len(frasej) - 1, -1, -1):
    frasei += frasej[letra]

if frasei == frasej:
    print('Temos um palíndromo.')
else:
    print('Não temos um palíndromo.')