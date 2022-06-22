print(f'{" DESAFIO Nº 088 ":=^30}')
print('Faça um programa que ajude um jogador da \033[33mMEGA SENA\033[m a criar \033[34mpalpites\033[m.'
      '\nO programa vai perguntar \033[34mquantos jogos\033[m serão gerados e vai sortear \033[33m6 números\033[m'
      '\n\033[34mentre 1 e 60\033[m para cada jogo, cadastrando tudo em uma \033[33mlista composta\033[m.')

while True:
    n = input('Quantos jogos você quer que o programa gere?: ')
    if n.isnumeric() == True:
        n = int(n)
        break
    else:
        print('Você digitou algo errado. Tente novamente, colocando apenas números.')

jogos = []
jogo = []
from random import randint
for c in range(n):
    while True:
        número = randint(1, 60)
        if número not in jogo:
            jogo.append(número)
        if len(jogo) == 6:
            break

    jogo.sort()
    jogos.append(jogo[:])
    jogo.clear()

from time import sleep
print(f'{" SORTEANDO OS JOGOS ":=^30}')
for c in range(len(jogos)):
    sleep(1)
    print(f'JOGO {c+1}: {jogos[c]}')

