print(f'{" DESAFIO Nº 086 "}')
print('Crie um programa que crie uma \033[33mmatriz\033[m de dimensão'
      '\n\033[34mdimensão 3x3\033[m e preencha com os valores lidos'
      '\npelo teclado. No final, mostre a \033[33mmatriz\033[m na tela, com a formatação correta.')

lista = []
contagem = linha = coluna = 0
while True:
    n = int(input(f'Digite um número para preencher a matriz [{linha}, {coluna}]: '))
    contagem += 1
    coluna += 1
    lista.append(n)

    if coluna == 3:
        linha += 1
        coluna = 0

    if contagem == 9:
        break

maiorvalor = somapares = somacoluna = 0
print('=' * 30)
for c in range(0, 9):
    if c < 3:
        print(f'[ {lista[c]} ]', end='')
        if lista[c] % 2 == 0:
            somapares += lista[c]
        if c == 2:
            somacoluna += lista[c]
    if 2 < c < 6:
        if maiorvalor == 0:
            maiorvalor = lista[c]
        if lista[c] > maiorvalor:
            maiorvalor = lista[c]

        if c == 3:
            print('\n', end='')
        print(f'[ {lista[c]} ]', end='')
        if lista[c] % 2 == 0:
            somapares += lista[c]
        if c == 5:
            somacoluna += lista[c]
    if 5 < c < 9:
        if c == 6:
            print('\n', end='')
        print(f'[ {lista[c]} ]', end='')
        if lista[c] % 2 == 0:
            somapares += lista[c]
        if c == 8:
            somacoluna += lista[c]
print('\n')
print('=' * 30)
print(f'\nA soma de todos os valores pares digitados é {somapares}.'
      f'\nA soma dos valores da terceira coluna é {somacoluna}.'
      f'\nO maior valor da segunda linha é {maiorvalor}.')


