n1 = float(input('Digite a nota da N1:'))
aps = float(input('Digite a nota a APS:'))
a5 = float(input('Digite a nota da A2:'))
n2 = aps + a5
media = n1*0.4+n2*0.6
if media >= 6:
    print(f'Parabéns, você foi aprovado com média %.1f.' % media)
else:
    print(f'Infelizmente, você terá que fazer prova substitutiva, pois sua média foi %.1f' % media)
    a5 = float((6-0.4*n1-aps*0.6)/0.6)
    print('Você precisa de %.1f para passar' % a5)
