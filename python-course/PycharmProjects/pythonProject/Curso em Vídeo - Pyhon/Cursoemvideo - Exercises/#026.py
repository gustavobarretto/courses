title = 'DESAFIO Nº 026'
print('{:^30}'.format(title))
print('Faça um programa que leia uma frase pelo teclado e mostre:\n1 - Quantas vezes aparece a letra A.\n2 - Em que posição ela aparece a primeira vez.\n3 - Em que posição ela aparece a última vez.')
frase = str(input('Digite uma frase qualquer a seguir: ')).strip()
a = (frase.upper().find('A'))
b = (frase.upper().rfind('A'))
print('Existem {} letras A nesta frase'.format(frase.upper().count('A')))
print('Ela foi pela primeira vez encontrada na posição {}, e;\n'
      'ela aparece pela última vez na posição {}.'.format((a+1), (b+1)))
