title = ' DESAFIO Nº 072 '
print(f'{title:=^30}')
print('Crie um programa que tenha uma tupla totalmente preenchida com uma contagem por extensão, de zero até vinte.'
      '\nSeu programa deverá ler um número pelo teclado (entre 0 e 20) e mostrá-lo por extenso.')
extenso = ('ZERO', 'UM', 'DOIS', 'TRÊS', 'QUATRO',
           'CINCO', 'SEIS', 'SETE', 'OITO', 'NOVE',
           'DEZ', 'ONZE', 'DOZE', 'TREZE', 'QUATORZE',
           'QUINZE', 'DEZESSEIS', 'DEZESSETE', 'DEZOITO',
           'DEZENOVE', 'VINTE')
while True:
    while True:
        número = input('Digite um número entre 0 e 20, que ele será dito por extenso: ')
        if número.isnumeric() == True:
            número = int(número)
            if número < 21:
                break
        print('Tente novamente. ', end='')

    print(f'O número digitado foi {extenso[número]}.')
    while True:
        resposta = input('Gostaria de digitar um novo numéro? [S/N]: ').upper().strip()
        if resposta[0] == 'S' or resposta[0] == 'N':
            break
    if resposta == 'N':
        break
print('Programa encerrado!')

