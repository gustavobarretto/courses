import math
title = 'DESAFIO Nº 018'
print('{:^30}'.format(title))
print('Nesse desafio, será lido qualquer ângulo e o programa mostrará o valor do seno, cosseno e tangente deste ângulo.')
a = float(input('Digite o valor do ângulo: '))
sen = math.sin(math.radians(a))
cos = math.cos(math.radians(a))
tan = math.tan(math.radians(a))
print('O valor do seno deste ângulo é {:.2f}, cosseno é {:.2f} e da tangente é {:.2f}.'.format(sen, cos, tan))
