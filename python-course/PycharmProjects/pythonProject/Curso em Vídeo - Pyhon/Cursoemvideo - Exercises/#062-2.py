print('{:=^30}'.format(' DESAFIO Nº 62 '))
print('Melhore o DESAFIO 061, perguntando se ele quer mostrar mais alguns termos.'
      '\nO programa encerra quando ele disser que quer mostrar 0 termos.')
ptermo = int(input('Informe o primeiro termo: '))
razao = int(input('Informe a razão: '))

termos = 10
ntermos = 1
contagem = 0

while termos != 0:
    while ntermos < termos:
        print(' {} ->'.format(ptermo), end='')
        ptermo += razao
        ntermos += 1
        if ntermos == termos:
            print(' {} ->'.format(ptermo), end='')
            print(' FIM ', end='')
            termos = int(input('\nInforme quantos termos a mais você quer verificar: '))
            ntermos = 1
            contagem += termos
else:
    print('Programa encerrado!')
    print('Além dos 10 termos iniciais, foram solicitados mais {} termos.'.format(contagem))







