title = 'DESAFIO Nº 038'
print('{:^30}'.format(title))
print('Escreva um programa que leia dois números inteiros e compare-os, mostrando na tela a seguinte mensagem:'
      '\n- O primeiro valor é maior.'
      '\n- O segundo valor é maior.'
      '\n- Não existe valor maior, os dois são iguais.')
n1 = int(input('Escolha o primeiro número: '))
n2 = int(input('Escolha o segundo número: '))

if n1 > n2:
    print('O primeiro número, de valor {}, é maior que o segundo, de valor {}.'.format(n1, n2))
elif n2 > n1:
    print('O segundo número, de valor {}, é maior que o primeiro, de valor {}.'.format(n2, n1))
else:
    print('Os números {} e {} são iguais.'.format(n1, n2))