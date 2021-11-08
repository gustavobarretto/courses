USE musimundos_v2;
-- 1. Liste todos os nomes de todos os artistas ordenados de forma crescente;
SELECT artistas.nome FROM artistas ORDER BY artistas.nome;
-- 2. Quais são os generos musicais existentes?
SELECT generos.nome FROM generos GROUP BY generos.nome ORDER BY generos.nome;
SELECT DISTINCT generos.nome FROM generos ORDER BY generos.nome;
-- 3. Mostre todos os compositores que criaram alguma cancao
SELECT DISTINCT cancoes.compositor FROM cancoes;
SELECT cancoes.compositor FROM cancoes GROUP BY cancoes.compositor;

-- 4. Mostre a lista dos empregados que foram contratados a partir de 2005
SELECT * FROM empregados WHERE data_contratacao > '2004-12-31';

-- 5. Liste todos os países que têm faturas com valor superior a 1.000
SELECT DISTINCT faturas.pais_cobranca FROM faturas WHERE valor_total > 1.000;

SELECT pais_cobranca, SUM(valor_total) AS soma_faturas 
FROM faturas
GROUP BY pais_cobranca;

-- 6. Quantas cancoes foram compostas por AC/DC?
SELECT cancoes.compositor, COUNT(cancoes.compositor) AS composicoes FROM cancoes WHERE cancoes.compositor LIKE 'AC/DC';

-- 7. Mostre as 10 primeiras cidades que tem faturas com valor superior a 100 reais.
SELECT DISTINCT faturas.cidade_cobranca, faturas.valor_total FROM faturas WHERE valor_total > 1 LIMIT 10;

SELECT cidade_cobranca, SUM(valor_total) AS soma_faturas FROM faturas GROUP BY cidade_cobranca ORDER BY soma_faturas DESC LIMIT 10;
SELECT DISTINCT cidade_cobranca, SUM(valor_total) AS soma FROM faturas WHERE SUM(valor_total) > 100 ORDER BY soma DESC LIMIT 10;

-- 1 Na tabela clientes selecione os campos nome e sobrenome e concatene(função concat) 
-- eles para que formarem o nome completo do cliente. Relacione cada cliente com a cidade 
-- de cobrança que consta na tabela faturas. Precisamos apenas uma ocorrência distinta de 
-- cada cliente.
SELECT DISTINCT(CONCAT(clientes.nome, ' ', clientes.sobrenome)) AS Nome, faturas.cidade_cobranca AS Cidade FROM clientes INNER JOIN faturas ON clientes.id = faturas.id_cliente;

-- 2 Na tabela cancoes selecione o nome da canção e relacionado com a tabela tipos_de_arquivos,
-- selecione também o nome do tipo do arquivo. Inclua na sua seleção também as canções que não 
-- tem tipo de arquivo. Ordene pelo id da canção de forma decrescente limitado a 4000 registros.
SELECT cancoes.nome, tipos_de_arquivo.nome FROM cancoes INNER JOIN tipos_de_arquivo ON cancoes.id_tipo_de_arquivo = tipos_de_arquivo.id ORDER BY cancoes.id DESC LIMIT 4000;

-- 3 Em nosso banco de dados, cada fatura é composta por várias músicas adquiridas pelos 
-- clientes. Selecione da tabela faturas o id do cliente e a data da fatura. Usando também 
-- a tabela intermediária itens_da_faturas selecione também o nome de cada musica adquirida
-- ou seja, na tabela canções o campo nome. Ordene tudo pelo id do cliente de forma decrescente.
SELECT faturas.id_cliente, faturas.data_fatura, itens_da_faturas.id_cancao, cancoes.nome FROM cancoes INNER JOIN itens_da_faturas ON cancoes.id = itens_da_faturas.id_cancao INNER JOIN faturas ON itens_da_faturas.id_fatura = faturas.id;

-- 4 - Um artista tem albuns, que por sua vez tem cancões. Selecione o nome do artista da 
-- tabela artistas, selecione os nomes dos albuns deste artista (tabela intermediária albuns)
-- e também o nome das canções deste artista contidas nos albuns (tabela cancoes). Ordene os 
-- resultados pelo nome do artista de forma decrescente.
SELECT artistas.nome AS Artista, albuns.titulo AS Álbum, cancoes.nome AS Canções FROM artistas INNER JOIN albuns ON albuns.id_artista = artistas.id INNER JOIN cancoes ON cancoes.id_album = albuns.id ORDER BY artistas.nome DESC;

-- 5 -- Selecione o nome dos gêneros(table generos), o nome das canções deste gênero (table cancoes)
-- e o tipo de arquivo de cada canção (tipos_de_arquivo). Selecione inclusive as musicas que o tipo 
-- de arquivo é nulo. Ordene tudo isso pelo nome do gênero de forma decrescente. clientes.
SELECT generos.nome AS Gêneros, cancoes.nome AS Canções, tipos_de_arquivo.nome AS 'Tipo de Arquivo' FROM generos INNER JOIN cancoes ON generos.id = cancoes.id_genero LEFT JOIN tipos_de_arquivo ON cancoes.id_tipo_de_arquivo = tipos_de_arquivo.id ORDER BY generos.nome DESC;



