title = 'DESAFIO Nº 014'
print('{:^30}'.format(title))
print('Neste desafio, é necessário escrever um conversor de temperatura entre Celsius e Fahrenheit.')
c = float(input('Digite a temperatura em graus celsius: '))
print('Essa temperatura de {:.2f} Cº equivale a {:.2f} Fº.'.format(c, c*1.8+32))