title = 'DESAFIO Nº 8'
print('{:^30}'.format(title))
print('Neste desafio, um valor em metros deverá ser convertido em centímetros e milímetros.')
m = float(input('Digite um valor em metros para que ele seja convertido em centímetros e milímetros: '))
print('O valor equivale a {:.2f} centímetros. \nE o valor equivale a {:.2f} milímetros.\nO valor também equivale a {:.2f} quilômetros, {:.2f} hectomêtros, {:.2f} decâmetros e {:.2f} decímetros'.format(m*100, m*1000, m/1000, m/100, m/10, m*10))
