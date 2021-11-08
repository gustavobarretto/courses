title = ' DESAFIO Nº 073 '
print(f'{title:=^30}')
print('Crie uma tupla preenchida com os 20 primeiros colocados da Tabela do Campeonato Brasileiro de Futebol, na ordem de colocação,'
      'na ordem de colocação. Despois mostre:'
      '\n a) Apenas os 5 primeiros colocados.'
      '\n b) Os últimos 4 colocados da tabela.'
      '\n c) Uma lista com os times em ordem alfabética.'
      '\n d) Em que posição na tabela está o time da Chapecoense.')
campeonatobrasileiro = ('Flamengo', 'Internacional', 'Atlético-MG', 'São Paulo',
                        'Fluminense', 'Grêmio', 'Palmeiras', 'Santos', 'Athletico-PR',
                        'Bragantino', 'Ceará SC', 'Corinthians', 'Atlético-GO', 'Bahia',
                        'Sport Recife', 'Fortaleza', 'Vasco da Gama', 'Goiás', 'Coritiba',
                        'Botafogo')
while True:
    print('=' * 30)
    print('{:=^30}'.format('BRASILEIRÃO SERIE A'))
    print('=' * 30)
    print('{:^30}'.format('MENU'))
    print('Digite o número para obter as seguintes informações:'
          '\n1 - Os cinco primeiros colocados.'
          '\n2 - Os quatro últimos colocados.'
          '\n3 - A lista em ordem alfabética dos times participantes.'
          '\n4 - Em que posição da tabela está o time da Ceará SC'
          '\n5 - Encerrar o programa.\n')
    while True:
        número = input('Escolha dentre as opções acima: ')
        if número.isnumeric() == True:
            quantidade = len(número)
            número = int(número)
            if número > 0 and número < 6 and quantidade == 1:
                break
        print('Informação incorreta. Digite novamente.')

    if número == 1:
        print(f'\nOs cinco primeiros colocados são {campeonatobrasileiro[:5]}\n')
    if número == 2:
        print(f'\nOs quatro últimos colocados são {campeonatobrasileiro[-4:]}\n')
    if número == 3:
        print(f'\nA lista em ordem alfabética é {sorted(campeonatobrasileiro)}\n')
    if número == 4:
        print(f'\nO Ceará SC está na {campeonatobrasileiro.index("Ceará SC")+1}a posição.\n')
    if número == 5:
        break
print('\nPrograma encerrado!')


