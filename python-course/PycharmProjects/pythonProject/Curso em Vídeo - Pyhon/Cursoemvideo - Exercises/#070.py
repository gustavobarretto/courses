title = ' DESAFIO Nº 070'
print(f'{title:=^30}')
print('Crie um programa que leia o nome e o preço de vários produtos.'
      '\nO programa deverá perguntar se o usuário vai continuar. No final, mostre:'
      '\nA) Qual é o total gasto na compra.'
      '\nB) Quantos produtos custam mais de R$ 1.000'
      '\nC) Qual é o nome do produto mais barato')

contagem = menorproduto = nomeproduto = total = maisde1000 = 0

while True:
    contagem += 1
    while True:
        produto = input('Digite o nome do produto: ').strip().upper()
        if type(produto) == str:
            break
    while True:
        preço = input('Digite o preço do produto: R$')
        if preço[0].isnumeric() == True:
            preço = float(preço)
            break
    if preço > 1000:
        maisde1000 += 1
    if contagem == 1:
        menorproduto = float(preço)
        nomeproduto = produto
    if float(preço) < float(menorproduto):
        menorproduto = float(preço)
        nomeproduto = produto

    total += preço

    while True:
        resposta = input('Deseja inserir mais algum produto na sua lista? [S/N]').strip().upper()
        if resposta == 'S' or resposta == 'N':
            break

    if resposta == 'N':
        break

print(f'O total de compras é no valor de R$ {total:.2f}.')
print(f'É possível identificar {maisde1000} produto(s) acima de R$ 1000.00')
print(f'O produto mais barato é o {nomeproduto}.')