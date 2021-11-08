title = 'DESAFIO Nº 013'
print('{:^30}'.format(title))
print('Neste desafio, você deverá informar o seu salário, para que possamos mostrar o novo valor, considerando que recebeu 15% de aumento.')
s = float(input('Informe aqui o seu salário atual: R$ '))
print('Considerando os 15% de aumento, você receberá a partir de agora o valor de R$ {:.2f}.'.format(s*1.15))