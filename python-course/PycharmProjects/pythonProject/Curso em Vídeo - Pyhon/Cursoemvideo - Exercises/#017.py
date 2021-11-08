from math import hypot
title = 'DESAFIO Nº 017'
print('{:^30}'.format(title))
print('Nesse desafio, você informá o cateto e o cateto adjacente de um triângulo retângulo para que informemos o valor de sua hipotenusa.')
c1 = float(input('Informe o comprimento de um dos catetos: '))
c2 = float(input('Informe o comprimento do outro cateto: '))
print('Considerando que um cateto mede {} e outro cateto mede {}, a hipotenusa deste triângulo é {:.2f}.'.format(c1, c2, hypot(c1,c2)))
