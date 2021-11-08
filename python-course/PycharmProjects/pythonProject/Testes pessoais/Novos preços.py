title = 'ATUALIZAÇÃO DE PREÇOS'
print('{:^30}'.format(title))
while True:
    p = float(input('Informe o novo preço de custo: R$ '))
    print('Preço de custo \033[1;4;7mR$ {}\033[m.\nPreço 1: R$ {:.3f}\nPreço 2: R$ {:.3f}\nPreço 3: R$ {:.3f}'.format(p, p*3.136, p*2.483, p*2.007))


