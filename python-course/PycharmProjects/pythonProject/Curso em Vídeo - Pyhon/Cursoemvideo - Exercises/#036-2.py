title = 'DESAFIO Nº 036'
print('{:^30}'.format(title))
print('Escreva um programa para aprovar o empréstimo bancário para a casa de uma casa. O programa vai perguntar o valor da casa,\no salário do comprador e em quantos anos ele vai pagar.\nCalcule o valor mensal da prestação, sabendo que ela não pode exceder 30% do salário ou então o empréstimo será negado.')
vc = float(input('Informe o valor da imóvel: R$ '))
vs = float(input('Informe o valor do salário: R$ '))
t = int(input('Informe em quantas parcelas você pretende pagar ou digite zero para que o computador calcule para você: '))

while int(t != 0 and vc // t > (vs * 0.3)):
    print('Infelizmente, seu empréstimo não foi aprovado nas parcelas indicadas.')
    t = int(input('Informe em quantas parcelas você pretende pagar ou digite zero para que o computador calcule para você: '))

if t == 0:
    print('Você poderá adquirir esse imóvel em {:.0f} parcelas de R$ {:.2f}.'.format(vc // (vs * 0.3), vs * 0.3))

if t != 0 and vc // t < (vs * 0.3):
    print('Parabéns, você poderá comprar o imóvel em {:.0f} parcelas mensais no valor de R$ {:.2f}.'.format(t, vc // t))
