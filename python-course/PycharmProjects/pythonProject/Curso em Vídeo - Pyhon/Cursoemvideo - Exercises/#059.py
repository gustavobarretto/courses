print('{:=^30}'.format(' DESAFIO Nº 059 '))
print('Crie um programa que leia dois valores e mostre um menu na tela:'
      '\n[1] somar'
      '\n[2] multiplicar'
      '\n[3] maior'
      '\n[4] novos números'
      '\n[5] sair do programa'
      '\nSeu programa deverá realizar a operação solicitada em cada caso.')

n1 = int(input('Escolha o primeiro valor: '))
n2 = int(input('Escolha o segundo valor: '))

mp = 0

while mp != 5:
    print('{:=^30}'.format(' MENU DE OPRERAÇÕES '))
    print('[1] SOMA'
          '\n[2] MULTIPLICADOR'
          '\n[3] INFORMA MAIOR NÚMERO'
          '\n[4] ESCOLHA NOVOS NÚMEROS'
          '\n[5] SAIR DO PROGRAMA')
    mp = int(input('Escolha o número indicado no menu: '))
    if mp == 1:
        print('A soma de {} e {} é igual a {}.'.format(n1, n2, n1 + n2))
    elif mp == 2:
        print('A multiplicação de {} e {} é igual a {}.'.format(n1, n2, n1 * n2))
    elif mp == 3:
        if n1 > n2:
            print('O maior número é {}.'.format(n1))
        else:
            print('O maior número é {}'.format(n2))
    elif mp == 4:
        n1 = int(input('Escolha novamente o primeiro valor: '))
        n2 = int(input('Escolha novamente o segundo valor: '))
    else:
        print('Opção inválida. Tente novamente.')

else:
    print('Programa encerrado.')