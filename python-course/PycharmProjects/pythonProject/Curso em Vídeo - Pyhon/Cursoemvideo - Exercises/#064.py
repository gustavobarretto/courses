print('{:=^30}'.format(' DESAFIO Nº 064 '))
print('Crie um programa que leia vários números inteiros pelo teclado. O programa só vai parar quando o usuário'
      '\ndigitar o valor  999, que é a condição de parada. No final, mostre quantos números foram digitados'
      '\ne qual foi a soma entre eles (desconsiderando o flag).')

s = v = 0
n = int(input('Digite um número: '))
while n != 999:
    s += n
    v += 1
    n = int(input('Digite um número: '))
else:
    print('A soma dos valores digitados é de {}, e foram digitados {} números.'.format(s, v))
    print('Programa encerrado!')

