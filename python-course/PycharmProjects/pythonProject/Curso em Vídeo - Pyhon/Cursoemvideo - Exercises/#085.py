print(f'{" DESAFIO Nº 085 ":=^30}')
print('Crie um programa onde o usuário possa digitar \033[34msete valores númericos\033[m'
      '\ne cadastre-os em uma \033[33mlista única\033[m que mantenha separados os valores'
      '\n\033[34mpares\033[m e \033[34mímpares\033[m. No final, mostre os valores pares e ímpares em ordem \033[33mcrescente\033[m.')

lista = [[], []]
for c in range(7):
    while True:
        n = input(f'Digite o {c+1}º número: ')
        if n.isnumeric() == True:
            n = int(n)
            print('Número adicionado')
            break
        else:
            print('Algo deu errado. Tente digitar apenas números. ', end='')

    if n % 2 == 0:
        lista[0].append(n)
        lista[0].sort()

    else:
        lista[1].append(n)
        lista[1].sort()

print(f'Os números digitados foram {lista}.')
print(f'Os números pares são {lista[0]} e os ímpares {lista[1]}')



