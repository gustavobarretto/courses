print('{:=^30}'.format(' DESAFIO Nº 61 '))
print('Refaça o DESAFIO 051, lendo o primeiro termo e a razão de uma PA, mostrando os 10 primeiros termos'
      '\n da progressão usando a estrutura while.')

ptermo = int(input('Informe o primeiro termo da razão: '))
razao = int(input('Informe a razão: '))
progressao = ptermo
razaofinal = ptermo + ((10 - 1) * razao)

while progressao < razaofinal:
    print('{} ->'.format(progressao) , end=' ')
    progressao += razao

else:
    print(progressao)


