title = 'DESAFIO Nº 6'
print('{:^30}'.format(title))
print('Neste desafio, deverá ser escolhido um número para que seja informado o seu dobro, seu triplo e sua raiz quadrada.')
n = int(input('Digite um número: '))
print('O dobro do número escolhido é {}. \nO triplo do número escolhido é {}. \nE a raiz quadrada dele é {}'.format(n*2, n*3, pow(n, 1/2)))
