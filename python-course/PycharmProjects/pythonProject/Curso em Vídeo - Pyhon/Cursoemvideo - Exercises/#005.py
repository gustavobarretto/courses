title = 'DESAFIO Nº5'
print('{:^30}'.format(title))
print('Neste desafio, deve ser escolhido um número para que seja informado seu antecessor e seu sucessor.')
n = int(input('Digite um número: '))
print('Seu antecessor é {}. \n E seu sucessor é {}.'.format(n-1, n+1))
