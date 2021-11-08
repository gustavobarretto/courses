title = 'DESAFIO Nº 042'
print('{:^30}'.format(title))
print('Refaça o DESAFIO 035 dos triângulos, acrescentando o recurso de mostrar'
      '\nque tipo de triângulo será formado:'
      '\n- Equilátero: todos os lados iguais.'
      '\n- Isóceles: dois lados iguais.'
      '\n- Escaleno: todos os lados diferentes.')
r1 = float(input('Indique o primeiro comprimento: '))
r2 = float(input('Indique o segundo comprimento: '))
r3 = float(input('Indique o terceiro comprimento: '))

if r1 < r2 + r3 and r2 < r1 + r3 and r3 < r1 + r2:
    if r1 == r2 == r3:
        print('É possível fazer um triângulo equilátero, pois todos os lados são iguais.')

    elif r1 == r2 or r2 == r3 or r1 == r3:
        print('É possível fazer um triângulo isóceles, pois dois lados são iguais.')
    else:
        print('É possível fazer um triângulo escaleno, pois todos os lados são diferentes.')
else:
    print('Não é possível fazer um triângulo com essas medidas.')