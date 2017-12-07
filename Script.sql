-- MySQL Workbench Synchronization
-- Generated: 2017-11-30 22:05
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: laion

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `srs` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `srs`.`Usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(14) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NULL DEFAULT NULL,
  `departamento` VARCHAR(45) NOT NULL,
  `funcao` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `srs`.`Reserva` (
  `idReserva` INT(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` INT(11) NOT NULL,
  `idSala` INT(11) NOT NULL,
  `dataReserva` DATE NOT NULL,
  PRIMARY KEY (`idReserva`),
  INDEX `idusuario_idx` (`idUsuario` ASC),
  INDEX `idSala_idx` (`idSala` ASC),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  UNIQUE INDEX `idSala_UNIQUE` (`idSala` ASC),
  CONSTRAINT `idUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `srs`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idSala`
    FOREIGN KEY (`idSala`)
    REFERENCES `srs`.`Sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `srs`.`Sala` (
  `idSala` INT(11) NOT NULL AUTO_INCREMENT,
  `tipoSala` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `local` VARCHAR(45) NOT NULL,
  `estadoConservacao` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idSala`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `srs`.`HistoricoReservas` (
  `idHistoricoReserva` INT(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` INT(11) NOT NULL,
  `idSala` INT(11) NOT NULL,
  `dataReserva` DATE NOT NULL,
  `estadoConservacao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idHistoricoReserva`),
  INDEX `idUsuarioHistorico_idx` (`idUsuario` ASC),
  INDEX `idSalaHistorico_idx` (`idSala` ASC),
  CONSTRAINT `idUsuarioHistorico`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `srs`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idSalaHistorico`
    FOREIGN KEY (`idSala`)
    REFERENCES `srs`.`Sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
