title = ' DESAFIO Nº 066 '
print(f'{title:=^30}')
print('Crie um programa que leia vários números inteiros pelo teclado. O programa só vai parar quando o usuário'
      '\ndigitar o valor  999, que é a condição de parada. No final, mostre quantos números foram digitados e qual foi a soma entre eles'
      '\n(desconsiderando o flag).')

contagem = soma = número = 0
while True:
    número = int(input('Digite um número: '))
    if número == 999:
        break
    soma += número
    contagem += 1
print(f'Foram inseridos números por {contagem} vezes e a soma entre eles deu um total de {soma}.')