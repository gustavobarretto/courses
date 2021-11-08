print(f'{" DESAFIO Nº 079 ":=^30}')
print('Crie um progrma onde o usuário possa digitar vários valores'
      '\nnúmericos e cadastre-os em uma lista. Caso o número já exista'
      '\nlá dentro, ele não será adicionado. No final, serão exibidos'
      '\ntodos os valores únicos digitados, em ordem crescente.')

lista = []
resposta = 'a'
while True:
    n = input('Digite um valor numérico qualquer: ')
    if n.isnumeric() == True:
        if int(n) not in lista:
            n = int(n)
            lista.append(n)
            print(f'O valor {n} foi adicionado à lista com sucesso!')
        else:
            print(f'O valor {n} já foi digitado à lista e não pode ser adicionado novamente.')
        while True:
            resposta = input('Deseja digitar mais algum número? [S/N]').strip().upper()
            if len(resposta) == 1 and type(resposta) == str:
                break
            else:
                print('Resposta não reconhecida. Tente novamente. ', end='')
    else:
        print('Valor digitado incorreto. Tente novamente. ', end='')
    if resposta[0] == 'N':
        break
lista.sort()
print(f'Os números digitados foram, em ordem crescente {lista}')