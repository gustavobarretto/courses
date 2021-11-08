title = ' DESAFIO Nº 075 '
print(f'{title:=^30}')
print('Desenvolva um programa que leia quatro valores pelo teclado e guarde-os em uma tupla.'
      '\nNo final, mostre:'
      '\nA) Quantas vezes apareceu o valor 9.'
      '\nB) Em que posição foi digitado o primeiro valor 3.'
      '\nC) Quais foram os números pares.')
contagem = 0
lista = pares = ()
while True:
    n = tuple(input('Digite um valor: '))
    lista += n

    if int(lista[contagem]) % 2 == 0:
        pares += n

    contagem += 1
    if contagem == 4:
        break


print(f'O número 9 apareceu {lista.count("9")} vezes.')
if 3 in lista:
    print('O número 3 foi digitado na {}a posição.'.format((lista.index('3')) + 1))
else:
    print('O número 3 não foi digitado em nenhuma posição.')
print(f'Os valores pares digitados são {pares}.')