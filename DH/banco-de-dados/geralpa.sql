CREATE SCHEMA geral;

CREATE TABLE geral.enderecos (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_fornecedor INT,
id_cliente INT,
id_usuario INT,
rua_avenida VARCHAR(50) NULL,
estado VARCHAR(2) NULL,
municipio VARCHAR(50) NULL,
cep VARCHAR(10),
n VARCHAR(10),
complemento VARCHAR(100)
);
-- A criação da FK de fornecedores, clientes e usuários pertencentes à tabela endereços serão feitas após a criação das respectivas tabelas.


CREATE TABLE geral.fornecedores (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
cnpj_cpf VARCHAR(18),
contato VARCHAR(12),
id_endereco INT,
email VARCHAR(50), -- Esse e-mail foi adicionado durante a criação do banco de dados e alterado também no diagrama DEER. Também foi inserido em clientes.
FOREIGN KEY (id_endereco) REFERENCES enderecos(id)
);

CREATE TABLE geral.clientes (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
cnpj_cpf VARCHAR(18),
contato VARCHAR(12),
id_endereco INT,
email VARCHAR(50),
FOREIGN KEY (id_endereco) REFERENCES enderecos(id)
);

CREATE TABLE geral.usuarios (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
senha VARCHAR(20),
contato VARCHAR(12),
email VARCHAR(50),
cargo VARCHAR(50),
funcao VARCHAR(50),
acesso VARCHAR(2),
id_endereco INT,
FOREIGN KEY (id_endereco) REFERENCES enderecos(id)
);

-- Alterar a tabela de endereços e incluir as foreign keys.

ALTER TABLE geral.enderecos
ADD FOREIGN KEY (id_cliente) REFERENCES clientes(id);
ALTER TABLE geral.enderecos
ADD FOREIGN KEY (id_usuario) REFERENCES usuarios(id);
ALTER TABLE geral.enderecos
ADD FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id);

-- Primeiro criar a tabela de compras e vendas para a criação da compra_fornecedor, usuario_compra, venda_cliente, usuario_venda.

CREATE TABLE geral.compras (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
data_compra DATE,
valor_compra DECIMAL(10, 3),
tipo_pagamento VARCHAR(50),
horario_compra TIME);

CREATE TABLE geral.vendas (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
data_venda DATE,
valor_venda DECIMAL(10, 3),
tipo_pagamento VARCHAR(50),
data_recebimento DATE);

-- Criação das tabelas intermediárias N:N

CREATE TABLE geral.compra_fornecedor (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_compra INT NULL,
id_fornecedor INT NULL,
FOREIGN KEY (id_compra) REFERENCES compras(id),
FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id)
);

CREATE TABLE geral.usuario_compra (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_compra INT NULL,
id_usuario INT NULL,
FOREIGN KEY (id_compra) REFERENCES compras(id),
FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE geral.venda_cliente (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_venda INT NULL,
id_cliente INT NULL,
FOREIGN KEY (id_venda) REFERENCES vendas(id),
FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

CREATE TABLE geral.usuario_venda (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_usuario INT NULL,
id_venda INT NULL,
FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
FOREIGN KEY (id_venda) REFERENCES vendas(id)
);

-- Agora será necessário criar a tabela produto para criação das intermediárias compra_produto e venda_produto.

CREATE TABLE geral.produtos (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
descricao VARCHAR(100),
diametro VARCHAR(6),
comprimento VARCHAR(6),
estoque INT
);

CREATE TABLE geral.compra_produto (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_compra INT NULL,
id_produto INT NULL,
FOREIGN KEY (id_compra) REFERENCES compras(id),
FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

CREATE TABLE geral.venda_produto (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_venda INT NULL,
id_produto INT NULL,
FOREIGN KEY (id_venda) REFERENCES vendas(id),
FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

-- Além da criação do banco de dados, o script deve conter:
-- 1) Inserção de dados em uma das tabelas;
INSERT INTO geral.enderecos (rua_avenida, estado, municipio, cep, n, complemento)
VALUES
('Pirajá', 'BA', 'Salvador', '8956356', '173', ''),
('Amazonas', 'BA', 'Salvador', '9836531', 'B', 'Ao lado do supermercado Walmart'),
('Confrades', 'SE', 'Aracaju', '91827312', '453', 'Em frente ao Habibs'),
('Paulista', 'SP', 'São Paulo', '29018321', '1043', ''),
('Miramar', 'AM', 'Manaus', '9827132', '11-B', 'Ao lado da Prefeitura');

INSERT INTO geral.fornecedores (nome, cnpj_cpf, contato, email)
VALUES
('Fábrica Fixador', 20918123000123, 7132450239, 'vendas@fabricafixador.com'),
('Porcas e Acessórios', 2123901000132, 114239020, 'vendas@pea.com.br'),
('Global Abraçadeiras', 201230001320, 2143249899, 'vendas@gabracadeiras.com'),
('Peças e Pregos', 123009000130, 7190239009, 'pecaspregos@gmail.com'),
('Allen e Inox', 20289098091, 719480920, 'comercial@alleneinox.com.br');

INSERT INTO geral.clientes (nome, cnpj_cpf, contato, email)
VALUES
('Consumidor', '', '', ''),
('Fábrica de Calçados', 20102938000123, 71898902032, 'compras@fabricacalcados.com.br'),
('Fábrica de Pneus', 29001293000132, 1140523200, 'compras@fabricapneus.com');

INSERT INTO geral.usuarios (nome, senha, contato, email, cargo, funcao, acesso)
VALUES
('Gustavo', '1234', '9289302', 'gustavo@geral.com', 'Administrador', 'Financeira', 4),
('Yana', '4321', '92839202', 'yana@geral.com', 'Gestora', 'Compras', 3),
('Fellipe', '2314', '92839202', 'fellipe@geral.com', 'Vendas', 'Vendas', 3);

INSERT INTO geral.compras (data_compra, valor_compra, tipo_pagamento, horario_compra)
VALUES
('2021-05-03', 543.22, 'Crédito', '9:32:35'),
('2021-01-30', 1123.33, 'Débito', '11:55:01'),
('2021-02-02', 45, 'Dinheiro', '12:33:59'),
('2020-12-01', 34550.57, 'Depósito', '17:44:00'),
('2020-09-30', 893.23, 'Depósito', '08:11:54');

INSERT INTO geral.vendas (data_venda, valor_venda, tipo_pagamento, data_recebimento)
VALUES
('2021-05-28', 1099.37, 'Crédito', '2021-06-28'),
('2021-03-11', 1123.33, 'Débito', '2021-03-12'),
('2021-03-24', 893.33, 'Dinheiro', '2021-03-24'),
('2021-06-05', 11403.23, 'Débito', '2021-06-06'),
('2021-07-03', 730.33, 'Depósito', '2021-07-03'),
('2021-05-03', 803.11, 'Crédito', '2021-06-03'),
('2020-01-30', 802.11, 'Débito', '2020-02-01'),
('2020-08-02', 9400, 'Dinheiro', '2020-08-02'),
('2020-12-01', 11.33, 'Depósito', '2020-12-01'),
('2020-09-30', 44.13, 'Depósito', '2020-09-30');


INSERT INTO geral.produtos (descricao, diametro, comprimento, estoque)
VALUES
('PARAFUSO SEXTAVADO ACO CARBONO ROSCA TOTAL UNC', '1/2', '2', 1000),
('PARAFUSO SEXTAVADO ACO CARBO ROSCA PARCIAL UNC', '3/4', '2', 893),
('PARAFUSO ALLEN ROSCA PARCIAL MA', '10', '100', 4500),
('PORCA INOX', '3/8', '', 15321),
('BARRA ACO CARBONO', '3/4', '', 130);

-- Aqui será feita a inserção de dados entre as tabelas intermediárias.

USE geral;
INSERT INTO compra_fornecedor (id_compra, id_fornecedor)
VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 4);

INSERT INTO venda_cliente (id_venda, id_cliente)
VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 2),
(7, 2),
(8, 3),
(9, 3),
(10, 3);

INSERT INTO usuario_venda (id_usuario, id_venda)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(2, 8),
(3, 9),
(1, 10);

INSERT INTO usuario_compra (id_usuario, id_compra)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(3, 5);

INSERT INTO venda_produto (id_venda, id_produto)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 5),
(3, 1),
(4, 1),
(5, 2),
(5, 3),
(5, 5),
(6, 5),
(7, 1),
(7, 3),
(8, 4),
(8, 5),
(9, 1),
(9, 2),
(9, 3),
(9, 4),
(9, 5);

INSERT INTO compra_produto (id_compra, id_produto)
VALUES
(1, 3),
(1, 4),
(2, 1),
(3, 2),
(4, 5),
(5, 1),
(5, 2),
(5, 3),
(5, 4),
(5, 5);

-- 2) Atualização de dados em uma das tabelas;
UPDATE usuarios SET nome = 'Eliane' WHERE nome = 'Yana';

-- 3) Exclusão de dados em uma das tabelas;
DELETE FROM enderecos WHERE rua_avenida = 'Pirajá';

-- 4) Seleção de dados em uma das tabelas.
SELECT * FROM produtos;