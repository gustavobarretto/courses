title = 'DESAFIO Nº 044'
print('{:^30}'.format(title))
print('Elabore um programa que calcule o valor a ser pago'
      '\npor um produto, considerando o seu preço normal e'
      '\ncondição de pagamento:'
      '\n- à vista dinheiro/cheque: 10% de desconto'
      '\n- à vista no cartão: 5% de desconto'
      '\n- em até 2x no cartão: preço normal'
      '\n- 3x ou mais no cartão: 20% de juros')

print('{:=^30}'.format('LOJA'))
pp = float(input('Digite o preço do produto: R$ '))
print('{:^30}'.format('MENU'))
fp = int(input('FORMA DE PAGAMENTO:'
               '\n1 - À VISTA NO DINHEIRO OU CHEQUE.'
               '\n2 - À VISTA NO CARTÃO.'
               '\n3 - À PRAZO.'
               '\nDigite o número da forma de pagamento: '))

if fp == 1:
      print('Com pagamento à vista no dinheiro e cheque, o valor total do produto é de R$ {:.2f}.'.format(pp*0.90))
elif fp == 2:
      print('Com pagamento à vista no cartão, o valor total do produto é de R$ {:.2f}'.format(pp*0.95))
elif fp == 3:
      np = int(input('Informe o número de parcelas: '))
      if np == 2:
        print('O valor do pagamento dividido em duas vezes é de R$ {:.2f}, sendo cada parcela no valor de R$ {:.2f}.'.format(pp, pp / 2))
      if np == 1:
        print('Com pagamento no cartão em uma única vez, o valor total do produto é de R$ {:.2f}'.format(pp * 0.95))
      else:
        print('Será realizado o pagamento de {} parcelas no valor de R$ {:.2f}, totalizando R$ {:.2f}.'.format(np, (pp*1.2) / np, pp*1.2 ))
else:
    print('OPÇÃO INVÁLIDA de pagamento. Tente novamente!')