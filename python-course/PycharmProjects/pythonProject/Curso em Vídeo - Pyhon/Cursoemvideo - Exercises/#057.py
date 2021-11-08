print('{:=^30}'.format(' DESAFIO Nº 057 '))
print('Faça um programa que leia o sexo de uma pessoa, mas só aceite os valores M ou F.'
      '\nCaso esteja errado, peça a digitação novamente até ter um valor correto.')
s = str(input('Informe o sexo da pessoa [M/F]: ')).upper()[0]
while s != 'M' and s != 'F':
    print('Indicação incorreta, escolha novamente.')
    s = str(input('Informe o sexo da pessoa [M/F]: ')).upper()[0]

print('O sexo selecionado foi {}.'.format(s))
