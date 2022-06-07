CREATE DATABASE dhemprestimos;
USE dhemprestimos;

--
-- Table structure for table `cuotas`
--

DROP TABLE IF EXISTS `parcelas`;

CREATE TABLE `parcelas` (
  `idparcelas` int(11) NOT NULL,
  `idemprestimo` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `importe` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idparcelas`,`idemprestimo`)
) ;

--
-- Dumping data for table `cuotas`
--


INSERT INTO `parcelas` VALUES (1,1,'2020-01-01',2000.00),(2,1,'2020-01-31',2000.00),(3,1,'2020-03-02',2000.00),(4,1,'2020-03-31',2000.00),(5,1,'2020-04-30',2000.00);


--
-- Table structure for table `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;

CREATE TABLE `emprestimo` (
  `idEmprestimo` int(11) NOT NULL AUTO_INCREMENT,
  `IdCliente` int(11) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Importe` decimal(10,2) DEFAULT NULL,
  `qtdParcelas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmprestimo`)
);

--
-- Dumping data for table `emprestimo`
--


INSERT INTO `emprestimo` VALUES (1,1,'2020-01-01',10000.00,5);


--
-- Table structure for table `scoring`
--

DROP TABLE IF EXISTS `scoring`;

CREATE TABLE `scoring` (
  `idScoring` int(11) NOT NULL,
  `Risco` varchar(45) DEFAULT NULL,
  `MaxImporte` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idScoring`)
) ;

--
-- Dumping data for table `scoring`
--


INSERT INTO `scoring` VALUES (1,'inicial',10000.00),(2,'alto',30000.00),(3,'medio',100000.00),(4,'baixo',500000.00);


--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `idclientes` int(11) NOT NULL AUTO_INCREMENT,
  `rg` varchar(10) DEFAULT NULL,
  `sobrenome` varchar(45) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `Scoring_idScoring` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idclientes`,`Scoring_idScoring`),
  KEY `fk_clientes_Scoring_idx` (`Scoring_idScoring`),
  CONSTRAINT `fk_clientes_Scoring` FOREIGN KEY (`Scoring_idScoring`) REFERENCES `scoring` (`idScoring`)
);

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` VALUES (1,'101','Gomez','Alberto','1976-01-01',1);
