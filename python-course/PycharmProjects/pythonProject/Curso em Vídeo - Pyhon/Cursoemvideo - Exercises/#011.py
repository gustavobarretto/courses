title = 'DESAFIO Nº 11'
print('{:^30}'.format(title))
print('Neste desafio, você deverá informar a altura e a largura de uma parede. Nesse caso, será calculada a sua área e será informado quantos litros de tintas serão necessários para pintá-la, considerando que cada lata litro de tinta é capaz de pintar 2m² de parede.')
c = float(input('Informe a altura da parede: '))
l = float(input('Informe a largura da parede: '))
a = c*l
print('A área total de sua parede é de {:.2f}m². \nAssim, serão necessários o equivalente a {:.2f}l de tinta.'.format(a, a/2))
