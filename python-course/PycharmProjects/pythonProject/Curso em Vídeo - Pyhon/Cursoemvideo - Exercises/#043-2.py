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
print('{:.2f}'.format(p))
print('{:.2f}'.format(a))

if a > 100:
    imc = (p / (a / 100 * a / 100))
    if imc < 18.5:
        print('Sua massa corporal é de {:.2f}, portanto, está abaixo do peso.'.format(imc))
    elif 18.5 < imc < 25:
        print('Sua massa corporal é de {:.2f}, portanto, está no peso ideal.'.format(imc))

    print('Massa corporal: {:.2f}'.format(imc))
#if imc < 18.5:
#    print('Sua massa corporal é de {:.2f}, portanto, está abaixo do peso.'.format(imc))
