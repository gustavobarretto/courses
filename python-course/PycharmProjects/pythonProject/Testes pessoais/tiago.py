v = float(input('Quantos reais você quer investir em anúncios?: R$ '))

click = ((v *30) * 12)/100
comp = (click * 3)/20
compvisu = comp * 40
visu = compvisu
total = (v * 30)

print('Foram geradas {:.0f} visualizações, {:.0f} cliques e {:.0f} compartilhamentos, de modo que geram {:.0f} novas visualizações'.format(v * 30, click, comp, compvisu))

for i in range(3):
    click = (visu * 12) / 100
    comp = (click * 3) / 20
    visu = comp * 40
    total += visu
    print(f"{visu:.2f}")

visualizacoestotais = total + compvisu
print('De R$ {:.2f} de investimento inicial, é possível ser gerado um total de {:.2f} visualizações de anúncios.'.format(v, visualizacoestotais))