title = ' DESAFIO Nº 068 '
print(f'{title:=^30}')
print('Faça um programa que jogue par ou ímpar com o computador.'
      '\nO jogo só será interrompido quando o jogador PERDER, mostrando o total de vitórias'
      '\nconsecutivas que ele conquistou no final do jogo.')

from random import randint
número = resultado = computador = vitórias = 0
while True:
    escolha = str(input('Escolha se você quer PAR ou ÍMPAR: ').strip().upper()[0])
    número = int(input('Escolha o número que você quer jogar [0 a 10]: '))
    computador = randint(0, 10)
    resultado = número + computador
    if número < 11 and número >= 0:
        if escolha == 'P' and resultado % 2 == 0:
            vitórias += 1
            print(f'Você ganhou! Meus parabéns! O computador escolheu {computador} e você {número}, totalizando {resultado}, que é par!.')
        if escolha == 'P' and resultado % 2 != 0:
            print(f'Você perdeu! O computador escolheu {computador} e você {número}, totalizando {resultado}, que é par!')
            break
        if escolha == 'I' and resultado % 2 == 0:
            print(f'Você perdeu! O computador escolheu {computador} e você {número}, totalizando {resultado}, que é ímpar!')
            break
        if escolha == 'I' and resultado % 2 != 0:
            vitórias += 1
            print(f'Você ganhou! Meus parabéns! O computador escolheu {computador} e você {número}, totalizando {resultado}, que é impar!.')
    else:
        print('Você escolheu um número maior que 10. Tente novamente.')
print(f'Você teve um total de {vitórias} vitória(s) consecutiva(s).')





