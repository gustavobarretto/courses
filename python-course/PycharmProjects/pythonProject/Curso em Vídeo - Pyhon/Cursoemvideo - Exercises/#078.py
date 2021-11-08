print(f'{" DESAFIO Nº 078 ":=^30}')
print('Faça um programa que leia 5 valores numéricos e guarde-os em uma lista.'
      '\nNo final, mostre qual foi o maior valor e o menor valor digitado e as suas'
      '\nrespectivas posições na lista.')
lista = []
maior = menor = posiçãoma = posiçãome = 0

while True:
    n = input('Digite um valor: ')
    if n.isnumeric() == True:
        lista.append(n)
        if len(lista) == 1:
            maior = n
            menor = n
        if n > maior:
            maior = n
            posiçãoma = lista.index(n)
        if n < menor:
            menor = n
            posiçãome = lista.index(n)
        if len(lista) == 5:
            break
    else:
        print('Digite mais um número ou valor incorreto.')

print(f'O maior número é o {maior} e está na posição {posiçãoma};'
      f'\nO menor número é o {menor} e está na posição {posiçãome}.'
      f'\n{lista}.')