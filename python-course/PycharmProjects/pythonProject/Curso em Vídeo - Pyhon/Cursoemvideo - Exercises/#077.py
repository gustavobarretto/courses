title = ' DESAFIO Nº 077 '
print(f'{title:=^30}')
print('Crie um programa que tenha uma tupla com várias palavras (não usar acentos).'
      '\nDepois disso, você deve mostrar, para cada palavra, quais são suas vogais.')
lista = ('OLHAR', 'PERCEBER', 'DIZER', 'OUVIR', 'FALAR', 'RESPEITAR', 'CONTINUAR', 'PERSISTIR', 'BUSCAR', 'DESISTIR', 'TENCIONAR')

contagem = contagemletras = 0
vogais = ()

while True:

    nome = lista[contagem]
    if nome[contagemletras] in 'AaEeIiOoUu':
        vogais += tuple(nome[contagemletras])

    contagemletras += 1

    if len(nome) == contagemletras:
        print(f'A palavra {lista[contagem]} contém as vogais {vogais}')
        contagem += 1
        contagemletras = 0
        vogais = ()


    if len(lista) == contagem:
        break