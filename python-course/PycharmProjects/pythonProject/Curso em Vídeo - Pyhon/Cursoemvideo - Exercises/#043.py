title = 'DESAFIO Nº 043'
print('{:^30}'.format(title))
print('Desenvolva uma lógica que leia o peso e a altura de uma pessoa,'
      '\ncalcule seu IMC e moestre seu status, de acordo com a tabela abaixo:'
      '\n- Abaixo de 18.5: ABAIXO DO PESO'
      '\n- Entre 18.5 E 25: PESO IDEAL'
      '\n- 25 até 30: SOBREPESO'
      '\n- 30 até 40: OBESIDADE'
      '\n- Acima de 40: OBESIDADE MÓRBIDA')
p = float(input('Digite o peso da pessoa: '))
a = float(input('Digite a altura da pessoa: '))

if a > 100:
    imc = float(p / ((a / 100) * (a / 100)))
    if imc < 18.5:
        print('Você está com a massa corporal {:.2f}, de modo que está abaixo do peso.'.format(imc))
    elif 18 <= imc < 25:
        print('Você está com a massa corporal {:.2f}, de modo que está no peso ideal.'.format(imc))
    elif 25 <= imc < 30:
        print('Você está com massa corporal {:.2f}, de modo que está com sobrepeso.'.format(imc))
    elif 30 <= imc < 40:
        print('Você está com massa corporal {:.2f}, de modo que está com obesidade.'.format(imc))
    else:
        print('Você está com massa corporal {:.2f}, de modo que está com obesidade mórbida.'.format(imc))

else:
    imc = p / (a * a)
    if imc < 18.5:
        print('Você está com a massa corporal {:.2f}, de modo que está abaixo do peso.'.format(imc))
    elif 18.5 <= imc < 25:
        print('Você está com a massa corporal {:.2f}, de modo que está no peso ideal.'.format(imc))
    elif 25 <= imc < 30:
        print('Você está com massa corporal {:.2f}, de modo que está com sobrepeso.'.format(imc))
    elif 30 <= imc < 40:
        print('Você está com massa corporal {:.2f}, de modo que está com obesidade.'.format(imc))
    else:
        print('Você está com massa corporal {:.2f}, de modo que está com obesidade mórbida.'.format(imc))