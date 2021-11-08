lanche = ('hamburguer', 'suco', 'pizza', 'pudim', 'batata frita') # () - tuplas / [] - listas / {} - dicionário
# Tuplas são imutáveis.
# lanche[1] = 'Refrigerante' - Isso dará erro: TypeError: 'tuple' object does not support item assignment

for cont in range(0, len(lanche)):
    print(f'Eu vou comer {lanche[cont]} na posição {cont}')

for comida in enumerate(lanche):
    print(f'Eu vou comer {comida}')

print('Comi pra caramba!')

print('')