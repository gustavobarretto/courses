title = 'DESAFIO Nº 037'
print('{:^30}'.format(title))
print('Escreva um programa que leia um número inteiro qualquer e peça para o usuário escolher qual será a base de conversão:'
      '\n- 1 para binário'
      '\n- 2 para octal'
      '\n- 3 para hexadecimal')
n = int(input('Digite um número para conversão: '))
print('Para converter este número, escolha dentre as opções'
      '\nDigite 1 para conversão binária.'
      '\nDigite 2 para conversão octal.'
      '\nDigite 3 para conversão hexadecimal.')
c = int(input('Digite a conversão desejada: '))


if c == 1:
    print('O valor binário de {} é {}.'.format(n, bin(n)[2:]))
elif c == 2:
    print('O valor octal de {} é {}.'.format(n, oct(n)[2:]))
elif c == 3:
    print('O valor hexadecimal de {} é {}.'.format(n, hex(n)[2:]))
else:
    print('Você não escolheu nenhuma das opções.')