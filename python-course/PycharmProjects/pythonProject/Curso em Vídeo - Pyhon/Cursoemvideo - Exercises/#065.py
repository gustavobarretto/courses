print('{:=^30}'.format(' DESAFIO Nº 065 '))
print('Crie um programa que leia vários números inteiros pelo teclado.'
      '\nNo final da execução, mostre a média entre todos os valores e qual foi o maior e o menor valores lidos.'
      '\nO programa deve perguntar ao usuário se ele quer ou não continuar a digitar valores.')

m = v = n = maior = menor = 0
r = ''
while r != 'N':
    n = float(input('Digite um valor: '))
    m += n
    v += 1
    if v == 1:
        maior = menor = n
    if n > maior:
        maior = n
    else:
        menor = n
    r = str(input('Deseja digitar um número novamente? [S/N]: ')).upper().strip()[0]
else:
    print('A média dos valores digitados é {:.2f}, sendo o maior {} e o menor {}.'.format(m / v, maior, menor))
    print('Programa encerrado!')