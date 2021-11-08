title = ' DESAFIO Nº 49 '
print('{:=^30}'.format(title))
print('Neste desafio, você deverá aplicar uma taboada.')
n = int(input('Digite um número para você saber sua tabela na taboada: '))
print('=' * 12)
for t in range(1, 11):
    print('{} x {} = {}'.format(n, t, n*t))
print('=' * 12)