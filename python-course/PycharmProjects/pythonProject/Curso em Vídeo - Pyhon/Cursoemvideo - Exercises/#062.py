print('{:=^30}'.format(' DESAFIO Nº 62 '))
print('Melhore o DESAFIO 061, perguntando se ele quer mostrar mais alguns termos.'
      '\nO programa encerra quando ele disser que quer mostrar 0 termos.')

termos = 1
while termos != 0:
    ptermo = int(input('Informe o primeiro termo da razão: '))
    razao = int(input('Informe a razão: '))
    termos = int(input('Informe a quantidade de termos: '))
    progressao = ptermo
    razaofinal = ptermo + ((termos - 1) * razao)
    while progressao < razaofinal:
        print(progressao, end=' ')
        progressao += razao

    else:
        print(progressao)
else:
    print('\nAnálise de progressão aritmética encerrada.')