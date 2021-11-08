print(f'{" DESAFIO Nº 083 ":=^30}')
print('Crie um progrma onde o usuário digite uma expressão qualquer que use parênteses.'
      '\nSeu aplicativo deverá anasilar se a expressão passada está com os parêntes abertos e fechados na ordem correta.')

expressão = input('Digite a expressão: ')
lista = []
contagem = 0
while True:
    lista.append(expressão[contagem])
    contagem += 1
    if len(expressão) == contagem:
        break

print(lista.index('('))
print(lista)
if lista.count('(') == lista.count(')'):
    númeroesq = expressão.count('(')
    númeroedir = expressão.count(')')
    while True:
        local = lista.index('(')
        if lista.index(')') < local:
            print('Esta equação é inválida, pois os parênteses estão invertidos em algum lugar.')
        else:
            if


    print('Essa expressão é válida!')
else:
    print('Essa expressão é inválida!')
