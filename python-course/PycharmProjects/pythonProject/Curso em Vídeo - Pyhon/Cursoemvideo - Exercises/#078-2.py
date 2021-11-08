print(f'{" DESAFIO Nº 078 ":=^30}')
print('Faça um programa que leia 5 valores numéricos e guarde-os em uma lista.'
      '\nNo final, mostre qual foi o valor maior e o menor valor digitado e as suas'
      '\nrespectivas posições na lista.')
lista = []
maior = menor = 0

while True:
    n = input('Digite um valor: ')
    if n.isnumeric() == True:
        lista.append(n)
        if len(lista) == 1:
            maior = n
            menor = n
        if n > maior:
            maior = n
        if n < menor:
            menor = n
        if len(lista) == 5:
            break
    else:
        print('Digite mais um número ou valor incorreto.')

print(f'\nA lista digitada foi: {lista}')
print(f'O maior número é o {maior} e está nas posições ', end='')
for c, v in enumerate(lista):
    if v == maior:
        print(f'{c}...', end='')
print(f'\nO menor número é o {menor} e está nas posições ', end='')
for c, v in enumerate(lista):
    if v == menor:
        print(f'{c}...', end='')

