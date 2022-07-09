-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: dhvacinacion
-- ------------------------------------------------------
-- Server version	8.0.22


CREATE SCHEMA IF NOT EXISTS dhvacinacao;
USE dhvacinacao;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `centrovacinacao`
--

DROP TABLE IF EXISTS `centrovacinacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centrovacinacao` (
  `id` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Endereco` varchar(100) DEFAULT NULL,
  `cidade_id` int NOT NULL,
  `esPrincipal` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_CentroVacinacao_Cidade1` (`Cidade_id`),
  CONSTRAINT `fk_CentroVacinacao_Cidade1` FOREIGN KEY (`Cidade_id`) REFERENCES `cidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centrovacinacao`
--

LOCK TABLES `centrovacinacao` WRITE;
/*!40000 ALTER TABLE `centrovacinacao` DISABLE KEYS */;
INSERT INTO `centrovacinacao` VALUES (1,'Centro Buenos Aires	','	Calle Centro Buenos Aires 1234	',2,_binary ''),(2,'Centro Sao Paulo	','	Calle Centro Sao Paulo 7890	',1,_binary ''),(3,'Centro Bogota	','	Calle Centro Bogota 5678	',5,_binary ''),(4,'Centro 2 Buenos Aires','Calle Centro 2 Buenos Aires 987',2,_binary '\0'),(5,'Centro 2 Sao Paulo	','Calle Centro 2 Sao Paulo 564',1,_binary '\0'),(6,'Centro 2 Bogota','Calle Centro Bogota 343',5,_binary '\0');
/*!40000 ALTER TABLE `centrovacinacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centrovacinacao_has_lote`
--

DROP TABLE IF EXISTS `centrovacinacao_has_lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centrovacinacao_has_lote` (
  `centrovacinacao_id` int NOT NULL,
  `Lote_idLote` int NOT NULL,
  `qtd` varchar(45) DEFAULT NULL,
  `dataEnvio` datetime DEFAULT NULL,
  `dataRecebido` datetime DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_centrovacinacao_has_Lote_Lote1_idx` (`Lote_idLote`),
  KEY `fk_centrovacinacao_has_Lote_centrovacinacao1_idx` (`centrovacinacao_id`),
  CONSTRAINT `fk_centrovacinacao_has_Lote_centrovacinacao1` FOREIGN KEY (`centrovacinacao_id`) REFERENCES `centrovacinacao` (`id`),
  CONSTRAINT `fk_centrovacinacao_has_Lote_Lote1` FOREIGN KEY (`Lote_idLote`) REFERENCES `lote` (`idLote`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centrovacinacao_has_lote`
--

LOCK TABLES `centrovacinacao_has_lote` WRITE;
/*!40000 ALTER TABLE `centrovacinacao_has_lote` DISABLE KEYS */;
INSERT INTO `centrovacinacao_has_lote` VALUES (1,1,'35','2022-03-26 00:45:40','2022-03-26 00:45:40',1),(2,1,'35','2022-03-26 00:45:48','2022-03-26 00:45:48',2),(3,1,'30','2022-03-26 00:45:51','2022-03-26 00:45:51',3);
/*!40000 ALTER TABLE `centrovacinacao_has_lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificado`
--

DROP TABLE IF EXISTS `certificado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idPessoa` int DEFAULT NULL,
  `numero_doses` tinyint DEFAULT NULL,
  `certificado` varchar(1000) DEFAULT NULL,
  `dataCriacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificado`
--

LOCK TABLES `certificado` WRITE;
/*!40000 ALTER TABLE `certificado` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `id` int NOT NULL,
  `Pais_idPais` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cidade_Pais_idx` (`Pais_idPais`),
  CONSTRAINT `fk_cidade_Pais` FOREIGN KEY (`Pais_idPais`) REFERENCES `pais` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,3,'São Paulo'),(2,1,'Buenos Aires'),(3,3,'Río de Janeiro'),(4,8,'Lima'),(5,5,'Bogotá'),(6,4,'Santiago de Chile'),(7,3,'Belo Horizonte'),(8,3,'Porto Alegre'),(9,5,'Medellín'),(10,3,'Brasilia'),(11,3,'Recife'),(12,10,'Caracas'),(13,3,'Fortaleza'),(14,3,'Salvador'),(15,3,'Curitiba'),(16,3,'Campinas'),(17,7,'Guayaquil'),(18,5,'Cali'),(19,7,'Quito'),(20,10,'Maracaibo'),(21,3,'Goiânia'),(22,6,'San José'),(23,3,'Belém'),(24,3,'Manaus'),(25,2,'Santa Cruz'),(26,5,'Barranquilla'),(27,2,'La Paz'),(28,10,'Valencia'),(29,9,'Montevideo'),(30,3,'Vitória'),(31,3,'Santos'),(32,1,'Córdoba'),(33,3,'São Luís'),(34,10,'Maracay'),(35,3,'Natal'),(36,1,'Rosario'),(37,2,'Cochabamba'),(38,10,'Barquisimeto'),(39,5,'Bucaramanga'),(40,5,'Cartagena'),(41,3,'João Pessoa'),(42,8,'Arequipa'),(43,3,'Maceió'),(44,1,'Mendoza'),(45,3,'Teresina'),(46,1,'Tucumán'),(47,4,'Valparaíso'),(48,3,'Florianópolis'),(49,5,'Cúcuta');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doses`
--

DROP TABLE IF EXISTS `doses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doses` (
  `iddoses` int NOT NULL,
  `Vacina_idVacina` int NOT NULL,
  PRIMARY KEY (`iddoses`),
  KEY `fk_doses_Vacina1_idx` (`Vacina_idVacina`),
  CONSTRAINT `fk_doses_Vacina1` FOREIGN KEY (`Vacina_idVacina`) REFERENCES `vacina` (`idvacina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doses`
--

LOCK TABLES `doses` WRITE;
/*!40000 ALTER TABLE `doses` DISABLE KEYS */;
INSERT INTO `doses` VALUES (1,1);
/*!40000 ALTER TABLE `doses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidade` (
  `id` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidade`
--

LOCK TABLES `especialidade` WRITE;
/*!40000 ALTER TABLE `especialidade` DISABLE KEYS */;
INSERT INTO `especialidade` VALUES (1,'Alergología'),(2,'Anestesiología'),(3,'Angiología'),(4,'Cardiología'),(5,'Endocrinología'),(6,'Estomatología'),(7,'Farmacología Clínica'),(8,'Gastroenterología'),(9,'Genética'),(10,'Geriatría'),(11,'Hematología'),(12,'Hepatología'),(13,'Infectología'),(14,'Medicina aeroespacial'),(15,'Medicina del deporte'),(16,'Medicina familiar y comunitaria'),(17,'Medicina física y rehabilitación'),(18,'Medicina forense'),(19,'Medicina intensiva'),(20,'Medicina interna'),(21,'Medicina preventiva y salud pública'),(22,'Medicina del trabajo'),(23,'Nefrología'),(24,'Neumología'),(25,'Neurología'),(26,'Nutriología'),(27,'Oncología médica'),(28,'Oncología radioterápica'),(29,'Pediatría'),(30,'Psiquiatría'),(31,'Reumatología'),(32,'Toxicología');
/*!40000 ALTER TABLE `especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialista`
--

DROP TABLE IF EXISTS `especialista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialista` (
  `id` int NOT NULL,
  `especialidade_id` int NOT NULL,
  `Pessoa_idPessoa` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Especialista_especialidade1_idx` (`especialidade_id`),
  KEY `fk_Especialista_Pessoa1_idx` (`Pessoa_idPessoa`),
  CONSTRAINT `fk_Especialista_especialidade1` FOREIGN KEY (`especialidade_id`) REFERENCES `especialidade` (`id`),
  CONSTRAINT `fk_Especialista_Pessoa1` FOREIGN KEY (`Pessoa_idPessoa`) REFERENCES `Pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialista`
--

LOCK TABLES `especialista` WRITE;
/*!40000 ALTER TABLE `especialista` DISABLE KEYS */;
/*!40000 ALTER TABLE `especialista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialistaposto`
--

DROP TABLE IF EXISTS `especialistaposto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialistaposto` (
  `Especialista_id` int NOT NULL,
  `Posto_id` int NOT NULL,
  `Desde` datetime DEFAULT NULL,
  `Ate` datetime DEFAULT NULL,
  `Especialista_has_Postocolo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Especialista_id`,`Posto_id`),
  KEY `fk_Especialista_has_Posto_Posto1_idx` (`Posto_id`),
  KEY `fk_Especialista_has_Posto_Especialista1_idx` (`Especialista_id`),
  CONSTRAINT `fk_Especialista_has_Posto_Especialista1` FOREIGN KEY (`Especialista_id`) REFERENCES `especialista` (`id`),
  CONSTRAINT `fk_Especialista_has_Posto_Posto1` FOREIGN KEY (`Posto_id`) REFERENCES `Posto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialistaposto`
--

LOCK TABLES `especialistaposto` WRITE;
/*!40000 ALTER TABLE `especialistaposto` DISABLE KEYS */;
/*!40000 ALTER TABLE `especialistaposto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `idLote` int NOT NULL,
  `qtd` varchar(45) DEFAULT NULL,
  `doses_iddoses` int NOT NULL,
  PRIMARY KEY (`idLote`),
  KEY `fk_Lote_doses1_idx` (`doses_iddoses`),
  CONSTRAINT `fk_Lote_doses1` FOREIGN KEY (`doses_iddoses`) REFERENCES `doses` (`iddoses`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1,'100',1);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `id` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Argentina'),(2,'Bolivia'),(3,'Brasil'),(4,'Chile'),(5,'Colombia'),(6,'Costa Rica'),(7,'Ecuador'),(8,'Peru'),(9,'Uruguay'),(10,'Venezuela');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patologia`
--

DROP TABLE IF EXISTS `patologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patologia` (
  `id` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patologia`
--

LOCK TABLES `patologia` WRITE;
/*!40000 ALTER TABLE `patologia` DISABLE KEYS */;
INSERT INTO `patologia` VALUES (1,'Fiebre'),(2,'Fiebre Amarilla'),(3,'Cataratas'),(4,'Caries Dental'),(5,'Asma'),(6,'Artritis');
/*!40000 ALTER TABLE `patologia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pessoa`
--

DROP TABLE IF EXISTS `Pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pessoa` (
  `id` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Sobrenome` varchar(45) DEFAULT NULL,
  `cidade_idcidade` int NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `NumeroDocumento` varchar(45) DEFAULT NULL,
  `TipoDocumento_id` int NOT NULL,
  `dosesSolicitadas` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_Pessoa_cidade1_idx` (`cidade_idcidade`),
  KEY `fk_Pessoa_TipoDocumento1_idx` (`TipoDocumento_id`),
  CONSTRAINT `fk_Pessoa_cidade1` FOREIGN KEY (`cidade_idcidade`) REFERENCES `cidade` (`id`),
  CONSTRAINT `fk_Pessoa_TipoDocumento1` FOREIGN KEY (`TipoDocumento_id`) REFERENCES `tipodocumento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pessoa`
--

LOCK TABLES `Pessoa` WRITE;
/*!40000 ALTER TABLE `Pessoa` DISABLE KEYS */;
INSERT INTO `Pessoa` VALUES (1,'	Alberto	','	Gonzalez	',2,'1998-05-27','81767591',1,2),(2,'	Lio 	','	Perez	',1,'1999-09-27','33357129',2,2),(3,'	Juan	','	Martinez	',5,'1966-03-18','39437316',3,2),(4,'	Maria	','	Ramirez	',2,'1968-10-05','81589681',1,1),(5,'	Juana	','	Ferreira	',1,'1978-01-12','36710108',2,2),(6,'	Noelia	','	Gonzalez	',5,'1972-04-28','51480072',3,2),(7,'	Lucia	','	Perez	',2,'1986-11-25','41113770',1,1),(8,'	Florencia	','	Martinez	',1,'1973-09-08','37593499',2,1),(9,'	Lourdes	','	Ramirez	',5,'1983-11-07','49541237',3,1),(10,'	Agustina	','	Ferreira	',2,'1996-07-14','40011123',1,2),(11,'	Pedro	','	Perez	',1,'1976-10-23','99307857',2,2),(12,'	Lucas	','	Martinez	',5,'1987-12-25','29085056',3,2),(13,'	Ariel	','	Ramirez	',2,'1986-01-02','82857674',1,2),(14,'	Veronica	','	Ferreira	',1,'1991-03-15','24560217',2,1);
/*!40000 ALTER TABLE `Pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pessoapatologia`
--

DROP TABLE IF EXISTS `Pessoapatologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pessoapatologia` (
  `Pessoa_id` int NOT NULL,
  `Patologia_id` int NOT NULL,
  PRIMARY KEY (`Pessoa_id`,`Patologia_id`),
  KEY `fk_Pessoa_has_Patologia_Patologia1_idx` (`Patologia_id`),
  KEY `fk_Pessoa_has_Patologia_Pessoa1_idx` (`Pessoa_id`),
  CONSTRAINT `fk_Pessoa_has_Patologia_Patologia1` FOREIGN KEY (`Patologia_id`) REFERENCES `patologia` (`id`),
  CONSTRAINT `fk_Pessoa_has_Patologia_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `Pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pessoapatologia`
--

LOCK TABLES `Pessoapatologia` WRITE;
/*!40000 ALTER TABLE `Pessoapatologia` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pessoapatologia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Posto`
--

DROP TABLE IF EXISTS `Posto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Posto` (
  `id` int NOT NULL,
  `centrovacinacao_id` int NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Postos_centrovacinacao1_idx` (`centrovacinacao_id`),
  CONSTRAINT `fk_Postos_centrovacinacao1` FOREIGN KEY (`centrovacinacao_id`) REFERENCES `centrovacinacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Posto`
--

LOCK TABLES `Posto` WRITE;
/*!40000 ALTER TABLE `Posto` DISABLE KEYS */;
INSERT INTO `Posto` VALUES (1,4,'Posto 1'),(2,4,'Posto 2'),(3,4,'Posto 3'),(6,5,'Posto 1'),(7,5,'Posto 2'),(8,5,'Posto 3'),(9,6,'Posto 1'),(10,6,'Posto 2'),(11,6,'Posto 3');
/*!40000 ALTER TABLE `Posto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template`
--

DROP TABLE IF EXISTS `template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `template` (
  `id` tinyint NOT NULL,
  `template` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template`
--

LOCK TABLES `template` WRITE;
/*!40000 ALTER TABLE `template` DISABLE KEYS */;
INSERT INTO `template` VALUES (1,'Nome: {{Nome}}\nSobrenome: {{Sobrenome}}\nData aplicacao: {{data}}\ndoses: {{nrdoses}}');
/*!40000 ALTER TABLE `template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodocumento` (
  `id` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumento`
--

LOCK TABLES `tipodocumento` WRITE;
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` VALUES (1,'CI'),(2,'DNI'),(3,'Pasaporte');
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `id` int NOT NULL,
  `Pessoa_id` int NOT NULL,
  `Posto_id` int NOT NULL,
  `DiaHora` datetime DEFAULT NULL,
  `doses_iddoses` int NOT NULL,
  `dosesAplicada` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fk_Turno_Pessoa1_idx` (`Pessoa_id`),
  KEY `fk_Turno_Posto1_idx` (`Posto_id`),
  KEY `fk_Turno_doses1_idx` (`doses_iddoses`),
  CONSTRAINT `fk_Turno_doses1` FOREIGN KEY (`doses_iddoses`) REFERENCES `doses` (`iddoses`),
  CONSTRAINT `fk_Turno_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `Pessoa` (`id`),
  CONSTRAINT `fk_Turno_Posto1` FOREIGN KEY (`Posto_id`) REFERENCES `Posto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,1,1,'2022-03-26 05:39:53',1,_binary ''),(2,2,1,'2022-03-26 05:39:53',1,_binary ''),(3,3,1,'2022-03-26 05:39:53',1,_binary ''),(4,1,1,'2022-03-26 05:54:13',1,_binary '');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina` (
  `idvacina` int NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `qtdMaximadoses` tinyint DEFAULT NULL,
  `qtdMaximaDiasEntredoses` tinyint DEFAULT NULL,
  PRIMARY KEY (`idvacina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` VALUES (1,'vacina 1','vacina 1',3,90);
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vi_qtdturnoporcidade`
--

DROP TABLE IF EXISTS `vi_qtdturnoporcidade`;
/*!50001 DROP VIEW IF EXISTS `vi_qtdturnoporcidade`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vi_qtdturnoporcidade` AS SELECT 
 1 AS `id_cidade`,
 1 AS `qtdTurno`,
 1 AS `qtddosesAplicadas`,
 1 AS `qtddosesSolicitadas`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vi_lotesemdistribuicaoporpais`
--

DROP TABLE IF EXISTS `vi_lotesemdistribuicaoporpais`;
/*!50001 DROP VIEW IF EXISTS `vi_lotesemdistribuicaoporpais`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vi_lotesemdistribuicaoporpais` AS SELECT 
 1 AS `IdPais`,
 1 AS `IdLote`,
 1 AS `qtd`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vi_paiscentrovacinacao`
--

DROP TABLE IF EXISTS `vi_paiscentrovacinacao`;
/*!50001 DROP VIEW IF EXISTS `vi_paiscentrovacinacao`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vi_paiscentrovacinacao` AS SELECT 
 1 AS `Idcidade`,
 1 AS `Nomecidade`,
 1 AS `IdPais`,
 1 AS `IdCentro`,
 1 AS `NomeCentro`,
 1 AS `EnderecoCentro`,
 1 AS `esPrincipalCentro`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vi_Pessoadosesaplicadas`
--

DROP TABLE IF EXISTS `vi_Pessoadosesaplicadas`;
/*!50001 DROP VIEW IF EXISTS `vi_Pessoadosesaplicadas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vi_Pessoadosesaplicadas` AS SELECT 
 1 AS `idPessoa`,
 1 AS `Nome`,
 1 AS `Sobrenome`,
 1 AS `id`,
 1 AS `Pessoa_id`,
 1 AS `Posto_id`,
 1 AS `DiaHora`,
 1 AS `doses_iddoses`,
 1 AS `dosesAplicada`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'dhvacinacion'
--

--
-- Dumping routines for database 'dhvacinacion'
--
/*!50003 DROP FUNCTION IF EXISTS `udf_qtddosesAplicadasPorPessoa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `udf_qtddosesAplicadasPorPessoa`(id_Pessoa INT) RETURNS tinyint
    DETERMINISTIC
BEGIN  

DECLARE resultado TINYINT; 

SET resultado = (select count(*) FROM turno t WHERE t.Pessoa_id = id_Pessoa and t.dosesAplicada = 1 );

RETURN resultado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `udf_qtddosesSolicitadasPorPessoa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `udf_qtddosesSolicitadasPorPessoa`(id_Pessoa INT) RETURNS tinyint
    DETERMINISTIC
BEGIN  

DECLARE resultado TINYINT; 

SET resultado = (select dosesSolicitadas FROM Pessoa p WHERE p.id = id_Pessoa  );

RETURN resultado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `udf_qtdPessoasParavacinarsePorcidade` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `udf_qtdPessoasParavacinarsePorcidade`(pi_idcidade INT) RETURNS int
    DETERMINISTIC
BEGIN 
DECLARE resultado INT DEFAULT 0;

SELECT qtddosesSolicitadas - qtddosesAplicadas
INTO resultado
FROM vi_qtdTurnoPorcidade 
WHERE id_cidade = pi_idcidade ;

RETURN resultado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `udf_qtdTurnoPorPessoa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `udf_qtdTurnoPorPessoa`(id_Pessoa INT) RETURNS tinyint
    DETERMINISTIC
BEGIN  

DECLARE resultado TINYINT; 

SET resultado = (select count(*) FROM turno t WHERE t.Pessoa_id = id_Pessoa  );

RETURN resultado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_centrovacinacaoLote_Agregar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_centrovacinacaoLote_Agregar`(pi_centrovacinacao INT,pi_id_lote INT, pi_qtd_vacinas INT ,pi_dataInicio DATE, pi_dataFim DATE)
BEGIN

INSERT INTO centrovacinacao_has_lote(centrovacinacao_Id,Lote_idLote, qtd, dataEnvio, dataRecebido)
VALUES(pi_centrovacinacao,pi_id_lote,pi_qtd_vacinas,pi_dataInicio, pi_dataFim);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_Certificado_Insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_Certificado_Insertar`(pi_idPessoa int, pi_numero_doses tinyint ,pi_certificado VARCHAR(1000))
BEGIN

INSERT INTO certificado(idPessoa, numero_doses, certificado, dataCriacao) VALUES (pi_idPessoa, pi_numero_doses, pi_certificado, now());

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vi_qtdturnoporcidade`
--

/*!50001 DROP VIEW IF EXISTS `vi_qtdturnoporcidade`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vi_qtdturnoporcidade` AS select `c`.`id` AS `id_cidade`,sum(`udf_qtdTurnoPorPessoa`(`p`.`id`)) AS `qtdTurno`,sum(`udf_qtddosesAplicadasPorPessoa`(`p`.`id`)) AS `qtddosesAplicadas`,sum(`udf_qtddosesSolicitadasPorPessoa`(`p`.`id`)) AS `qtddosesSolicitadas` from (`Pessoa` `p` join `cidade` `c` on((`p`.`cidade_idcidade` = `c`.`id`))) group by `c`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vi_lotesemdistribuicaoporpais`
--

/*!50001 DROP VIEW IF EXISTS `vi_lotesemdistribuicaoporpais`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vi_lotesemdistribuicaoporpais` AS select `c`.`Pais_idPais` AS `IdPais`,`cvhl`.`Lote_idLote` AS `IdLote`,(sum((case when (`cv`.`esPrincipal` = 1) then `cvhl`.`qtd` else 0 end)) - sum((case when (`cv`.`esPrincipal` = 0) then `cvhl`.`qtd` else 0 end))) AS `qtd` from ((`centrovacinacao` `cv` join `cidade` `c` on((`cv`.`cidade_id` = `c`.`id`))) join `centrovacinacao_has_lote` `cvhl` on((`cvhl`.`centrovacinacao_id` = `cv`.`id`))) group by `c`.`Pais_idPais`,`cvhl`.`Lote_idLote` having ((sum((case when (`cv`.`esPrincipal` = 1) then `cvhl`.`qtd` else 0 end)) - sum((case when (`cv`.`esPrincipal` = 0) then `cvhl`.`qtd` else 0 end))) > 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vi_paiscentrovacinacao`
--

/*!50001 DROP VIEW IF EXISTS `vi_paiscentrovacinacao`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vi_paiscentrovacinacao` AS select `c`.`id` AS `Idcidade`,`c`.`Nome` AS `Nomecidade`,`c`.`Pais_idPais` AS `IdPais`,`cv`.`id` AS `IdCentro`,`cv`.`Nome` AS `NomeCentro`,`cv`.`Endereco` AS `EnderecoCentro`,`cv`.`esPrincipal` AS `esPrincipalCentro` from (`centrovacinacao` `cv` join `cidade` `c` on((`cv`.`cidade_id` = `c`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vi_Pessoadosesaplicadas`
--

/*!50001 DROP VIEW IF EXISTS `vi_Pessoadosesaplicadas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vi_Pessoadosesaplicadas` AS select `p`.`id` AS `idPessoa`,`p`.`Nome` AS `Nome`,`p`.`Sobrenome` AS `Sobrenome`,`t`.`id` AS `id`,`t`.`Pessoa_id` AS `Pessoa_id`,`t`.`Posto_id` AS `Posto_id`,`t`.`DiaHora` AS `DiaHora`,`t`.`doses_iddoses` AS `doses_iddoses`,`t`.`dosesAplicada` AS `dosesAplicada` from ((`turno` `t` join `Pessoa` `p` on((`t`.`Pessoa_id` = `p`.`id`))) join `doses` `d` on((`t`.`doses_iddoses` = `d`.`iddoses`))) where (`t`.`dosesAplicada` = true) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-30  0:48:05
