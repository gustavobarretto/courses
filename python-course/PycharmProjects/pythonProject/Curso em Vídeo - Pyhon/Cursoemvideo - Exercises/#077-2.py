print(f'{" DESAFIO Nº 077 ":=^30}')
print('Crie um programa que tenha uma tupla com várias palavras (não usar acentos).'
      '\nDepois disso, você deve mostrar, para cada palavra, quais são suas vogais.')
lista = ('OLHAR', 'PERCEBER', 'DIZER', 'OUVIR', 'FALAR', 'RESPEITAR', 'CONTINUAR', 'PERSISTIR', 'BUSCAR', 'DESISTIR', 'TENCIONAR')
for p in lista:
    print(f'\nNa palavra {p} temos ', end='')
    for letra in p:
        if letra.lower() in 'aeiou':
            print(letra, end=' ')
