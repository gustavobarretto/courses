title = 'DESAFIO Nº 028'
print('{:^30}'.format(title))
print('Escreva um programa que faça o computador "pensar" em um número\ninteiro entre 0 e 5 e peça para o usuário\ntentar descobrir qual foi o número escolhido pelo computador.\n'
      'O programa deverá escrever na tela se o usuário venceu ou perdeu.\n')
import random
from time import sleep
print('O computador está escolhendo um número de 0 a 5.')
#list = [0, 1, 2, 3, 4, 5]
#c = int(random.choice(list))
print('Escolhendo um número...')
sleep(3) #SUGESTÃO OFERECIDA EM AULA
c = random.randint(0, 5) #SUGESTÃO OFERECIDA EM AULA
print('Número escolhido!')
a = int(input('Tente acertar o número: '))

if a == c:
    print('Parabéns, você acertou!')
else:
    print('Você errou o número escolhido. O número escolhido foi {}'.format(c))

