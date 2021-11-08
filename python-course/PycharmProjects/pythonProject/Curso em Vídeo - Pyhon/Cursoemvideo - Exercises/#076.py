title = ' DESAFIO Nº 076 '
print(f'{title:=^30}')
print('Crie um programa que tenha uma tupla única com nomes de produtos e seus respectivos preços, na sequência.'
      '\nNo final, mostre uma listagem de preços, organizando os dados de forma tabular.')

lista = ('Processador i3', 399.99, 'Placa de Vídeo GFORCE', 2699.99,
         'Monitor 144hz', 1799.99, 'Mouse Super Light LOGITECH', 799.99,
         'Teclado Mecânico', 899.99, 'Mousepad SPEED', 49.99,
         'Memória RAM 4GB', 399.99, 'Memória RAM 8GB',
         699.99, 'SSD 512GB', 599.99, 'SSD 256GB', 399.99)
print('=' * 50)
print('{:^50}'.format('LISTAGEM DE PREÇOS INFORMÁTICA'))
print('=' * 50)
contagem = 0
while True:
    print(f'{lista[contagem]:.<30} R$ {lista[contagem +1]}')
    contagem += 2

    if contagem >= len(lista):
        break