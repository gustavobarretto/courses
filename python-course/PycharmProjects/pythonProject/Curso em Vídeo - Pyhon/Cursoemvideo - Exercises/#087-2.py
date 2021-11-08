matriz = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
somapares = somalinha = somacoluna = 0
for l in range(0, 3):
    for c in range (0, 3):
        matriz[l][c] = int(input(f'Digite um valor para [{l}, {c}]: '))
print('-=' * 30)
for l in range(0, 3):
    for c in range(0, 3):
        print(f'[ {matriz[l][c]:^5} ]', end='')
        if matriz[l][c] % 2 == 0:
            somapares += matriz[l][c]
        if l == 1:
            if matriz[l][c] > somalinha:
                somalinha = matriz[l][c]
        if c == 2:
            somacoluna += matriz[l][c]
    print()
print('-=' * 30)
print(f'A soma dos valores pares digitados é {somapares}.'
      f'\nO maior valor da terceira linha é {somalinha}.'
      f'\nA soma da terceira coluna é {somacoluna}.')
