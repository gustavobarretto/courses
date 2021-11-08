print('{:=^30}'.format(' DESAFIO Nº 056'))
print('Desenvolva um programa que leia o nome, idade e sexo de 4 pessoas. No final do programa, mostre:'
      '\n- A média de idade do grupo.'
      '\n- Qual é o nome do homem mais velho.'
      '\n- Quantas mulheres têm menos de vinte anos.')

media = 0
mulheres20 = 0
mih = 0


for c in range(4):
    nome = str(input('Digite o nome {}a da pessoa: '.format(c+1))).upper().strip()
    idade = int(input('Digite a idade da {}a pessoa: '.format(c+1)))
    sexo = str(input('Digite o sexo da {}a pessoa, escolhendo M para masculino ou F para feminino: '.format(c+1))).upper().strip()

    print('==== {}a PESSOA ===='.format(c+1))
    print('NOME: {}'.format(nome))
    print('IDADE: {}'.format(idade))
    print('SEXO: {}'.format(sexo))
    print('{:=^20}'.format(''))


    media += idade

    if sexo == 'F' and idade < 20:
        mulheres20 += 1

    elif sexo == 'M' and idade > mih:
        mih = idade
        div = nome.split()
        nid = div[0]


print('A média de idades é {:.1f}.'.format(media/(c+1)))
print('Existem {} mulheres com menos de 20 anos.'.format(mulheres20))
print('{} é o homem mais velho, pois tem {} anos.'.format(nid, mih))
