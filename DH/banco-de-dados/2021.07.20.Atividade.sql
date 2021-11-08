use musimundos_v2;

-- 5) Permissões
-- a) Exiba todos os usuários dos bancos de dados

SELECT user FROM mysql.user;

-- b) Crie três usuários, um com o seu primeirio nome e outros dois com nomes fictícios;
CREATE USER 'vitor'@'localhost';
CREATE USER 'sophia'@'localhost';

-- c) Exiba novamente os usuários foram criados
SELECT user FROM mysql.user;

-- d) Conceda todos os privilégios, em todos os bancos e tabelas para o usuário com o seu nome.
GRANT ALL PRIVILEGES ON *.* TO 'gustavo'@'localhost';
SHOW GRANTS FOR 'gustavo'@'localhost';

-- e) Para o segundo usuário criado conceda a permissão de inserir dados em todos os bancos e tabelas
GRANT INSERT ON *.* TO 'vitor'@'localhost';

-- f) Para o terceiro usuário conceda apenas a permissão de selecionar dados da tabela cancoes do banco musimundos_v2;
GRANT SELECT ON musimundos_v2.cancoes TO 'sophia'@'localhost';

-- g) Exiba os privilégios do usuario com seu nome.
SHOW GRANTS FOR 'gustavo'@'localhost';

-- h) Revogue a permissão de atualizar dados (update) do usuário com o seu nome, para todos os bancos de dados e tabelas.
REVOKE UPDATE ON *.* FROM 'gustavo'@'localhost';

-- i) Exiba novamente os privilégios do usuário com seu nome.
SHOW GRANTS FOR 'gustavo'@'localhost';

-- j) Exlua o usuário com o seu nome e exiba novamente os usuários.
DROP USER 'gustavo'@'localhost';
SELECT USER FROM mysql.user;

