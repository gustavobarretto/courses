print('{:=^30}'.format(' DESAFIO Nº 058 '))
print('Melhore o DESAFIO 028 aonde o computador vai pensar em um número entre 0 e 10.'
      '\nSó que agora o jogador vai tentar adivinhar até acertar, mostrando no final quantos palpites foram necessários para vencer.')

import time
print('\nO computador está escolhendo um número...')
time.sleep(2)

import random
nc = random.randint(0, 10)
print('\nO computador escolheu um número! Tente acertar.')

sp = 1
np = int(input('Escolha um número de 0 a 10: '))
while np != nc:
    sp += 1
    if np > nc:
        print('\nVOCÊ ERROU! Escolheu um número maior do que o escolhido. Tente novamente!')
    elif np < nc:
        print('\nVOCÊ ERROU! Escolheu um número menor do que o escolhido. Tente novamente!')
    np = int(input('Escolha um número de 0 a 10: '))
else:
    print('\nVOCÊ ACERTOU! O número escolhido foi {}, depois de {} tentativas.'.format(nc, sp))
