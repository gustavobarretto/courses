title = 'DESAFIO Nº 024'
print('{:^30}'.format(title))
print('Crie um programa que leia o nome de uma cidade e diga se ela começa ou não com o nome SANTO.')
city = input('Digite o nome da cidade: ').upper().strip()
if city[:5] == 'SANTO':
    print('O nome da cidade começa com Santo no nome.')
else:
    print('O nome da cidade não começa com Santo no nome.')
