
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dentistoffice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dentistoffice` DEFAULT CHARACTER SET utf8mb3 ;
USE `dentistoffice` ;


DROP TABLE IF EXISTS dentists;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS appointments;

-- -----------------------------------------------------
-- Table `dentistoffice`.`dentists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentistoffice`.`dentists` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `registration` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `registration_unique` (`registration` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mercadofresco`.`localities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentistoffice`.`patients` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `identity_registration` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `registration_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `identity_registration_unique` UNIQUE (`identity_registration`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mercadofresco`.`carries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentistoffice`.`appointments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `consult_date` DATETIME NOT NULL,
  `dentist_id` INT(11) NOT NULL,
  `patient_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dentist1_idx` (`dentist_id` ASC) VISIBLE,
  CONSTRAINT `fk_dentist1`
    FOREIGN KEY (`dentist_id`)
    REFERENCES `dentistoffice`.`dentists` (`id`),
  INDEX `fk_patient1_idx` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `dentistoffice`.`patients` (`id`)

)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

INSERT INTO `dentists` VALUES
(1,'Gustavo','Barretto','CPX-1235'),
(2, 'Silas', 'Medeiros', 'CPX-3241'),
(3,'Fernando','Collor','CPX-0009'),
(4, 'Fernando', 'Henrique', 'CPX-9201'),
(5, 'Luís', 'Inácio', 'CPX-8761');

INSERT INTO `patients` VALUES
(1,'813.313.99','Eduardo', 'de Araújo','2008-11-11 13:23:44'),
(2,'980.912.11','Jair Messias', 'Bolsonaro','2021-10-09 12:13:04'),
(3,'091.918.84','Dilma', 'Roussef', '2015-03-01 09:03:11'),
(4,'122.414.02','Jucelino', 'Kubitschek','2019-01-25 20:00:00'),
(5,'877.234.28','Itamar', 'Franco','2017-06-06 13:15:00');

INSERT INTO `appointments` VALUES
(1,'2020-08-08 09:00:00', 1, 1),
(2,'2021-11-09 09:30:00', 2, 2),
(3,'2021-04-15 10:00:00', 3, 3),
(4,'2020-06-03 10:30:00', 4, 4),
(5,'2021-09-12 11:00:00', 5, 5);
