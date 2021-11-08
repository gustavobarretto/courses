title = 'DESAFIO Nº 045'
print('{:^30}'.format(title))
print('Crie um programa que faça o coputador jogar Jokenpô com você.')
print('{:=^30}'.format('MENU'))
print('Jogo do pedra, papel e tesoura!'
      '\nDigite o número para escolher pedra, papel e tesoura:'
      '\n0 - PEDRA'
      '\n1 - PAPEL'
      '\n2 - TESOURA')
print('O computador está escolhendo a opção dele...')
from time import sleep
sleep(3)

import random
l = ['PEDRA', 'PAPEL', 'TESOURA']
nc = random.choice(l)
print('O computador fez a escolha!')

np = int(input('Agora, digite o número da sua escolha, conforme indicação no menu: '))

if nc == l[np]:
    print('Deu empate, os dois escolheram {}.'.format(l[np]))
elif nc == l[0] and np == 1:
    print('Você ganhou! O computador escolheu {}, enquanto você escolheu {}.'.format(nc, l[1]))
elif nc == l[0] and np == 2:
    print('Você perdeu! O computador escolheu {}, enquanto você escolheu {}.'.format(nc, l[2]))
elif nc == l[1] and np == 0:
    print('Você perdeu! O computador escolheu {}, enquanto você escolheu {}.'.format(nc, l[0]))
elif nc == l[1] and np == 2:
    print('Você ganhou! O computador escolheu {}, enquanto você escolheu {}.'.format(nc, l[2]))
elif nc == l[2] and np == 0:
    print('Você ganhou! O computador escolheu {}, enquanto você escolheu {}.'.format(nc, l[0]))
elif nc == l[2] and np == 1:
    print('Você perdeu! O computador escolheu {}, enquanto você escolheu {}.'.format(nc, l[1]))
