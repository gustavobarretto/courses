title = 'DESAFIO EXTRA Nº 13'
print('{:^30}'.format(title))
print('Neste desafio, você informará o preço de um produto. O produto poderá ser pago à vista com 15% de desconto. Caso seja parcelado, poderá parcelar em até 3 vezes sem juros no preço original ou com 8% mais caro que o valor original')
p = float(input('Informe o valor do produto: R$ '))
fc = int(input('Informe o número de quantas parcelas deseja comprar. Se à vista, digite 1, para uma parcela: '))

if fc == 1:
    print('Você comprará o produto a R${:.2f}.'.format(p*0.90))
elif fc < 4:
    print('Você comprará o produto por {} parcelas de R${:.2f}, totalizando R${:.2f}.'.format(fc, p/fc, p))
else:
    print('Você comprará o produto por {} parcelas de R${:.2f}, totalizando R${:.2f}.'.format(fc, p*1.08/fc, p*1.08))

