-- MySQL Script generated by MySQL Workbench
-- Ter 05 Jun 2018 02:16:45 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CuelharBank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CuelharBank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CuelharBank` DEFAULT CHARACTER SET utf8 ;
USE `CuelharBank` ;

-- -----------------------------------------------------
-- Table `CuelharBank`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(45) NOT NULL,
  `cpfCliente` INT(11) NOT NULL,
  `telefoneCliente` INT(11) NOT NULL,
  `enderecoCliente` VARCHAR(45) NOT NULL,
  `dtNascimentoCliente` DATE NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idCliente_UNIQUE` (`idCliente` ASC),
  UNIQUE INDEX `cpfCliente_UNIQUE` (`cpfCliente` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`TipoConta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`TipoConta` (
  `idTipoConta` INT NOT NULL AUTO_INCREMENT,
  `TipoConta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoConta`),
  UNIQUE INDEX `idTipoConta_UNIQUE` (`idTipoConta` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`Agencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Agencia` (
  `idAgencia` INT NOT NULL AUTO_INCREMENT,
  `enderecoAgencia` VARCHAR(45) NOT NULL,
  `telefoneAgencia` INT(11) NOT NULL,
  PRIMARY KEY (`idAgencia`),
  UNIQUE INDEX `idAgencia_UNIQUE` (`idAgencia` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Conta` (
  `numeroConta` INT NOT NULL,
  `senhaConta` INT(8) NOT NULL,
  `dtAberturaConta` DATE NOT NULL,
  `saldoConta` DOUBLE NOT NULL,
  `numeroToken` VARCHAR(45) NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `TipoConta_idTipoConta` INT NOT NULL,
  `Agencia_idAgencia` INT NOT NULL,
  PRIMARY KEY (`numeroConta`),
  UNIQUE INDEX `numeroConta_UNIQUE` (`numeroConta` ASC),
  INDEX `fk_Conta_Cliente_idx` (`Cliente_idCliente` ASC),
  INDEX `fk_Conta_TipoConta1_idx` (`TipoConta_idTipoConta` ASC),
  INDEX `fk_Conta_Agencia1_idx` (`Agencia_idAgencia` ASC),
  CONSTRAINT `fk_Conta_Cliente`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `CuelharBank`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conta_TipoConta1`
    FOREIGN KEY (`TipoConta_idTipoConta`)
    REFERENCES `CuelharBank`.`TipoConta` (`idTipoConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Conta_Agencia1`
    FOREIGN KEY (`Agencia_idAgencia`)
    REFERENCES `CuelharBank`.`Agencia` (`idAgencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`TipoTransacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`TipoTransacao` (
  `idtipoTransacao` INT NOT NULL,
  `identificacaoTipoTransacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipoTransacao`),
  UNIQUE INDEX `identificacaoTipoTransacao_UNIQUE` (`identificacaoTipoTransacao` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`Transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Transacao` (
  `idTransacao` INT NOT NULL AUTO_INCREMENT,
  `identificacaoTransacao` VARCHAR(45) NULL,
  `valorTransacao` DOUBLE NOT NULL,
  `dtTransacao` TIMESTAMP NOT NULL,
  `cpfBeneficiadoTransferencia` VARCHAR(45) NULL,
  `Conta_numeroConta` INT NOT NULL,
  `TipoTransacao_idtipoTransacao` INT NOT NULL,
  PRIMARY KEY (`idTransacao`),
  UNIQUE INDEX `idTransacao_UNIQUE` (`idTransacao` ASC),
  INDEX `fk_Transacao_Conta1_idx` (`Conta_numeroConta` ASC),
  INDEX `fk_Transacao_TipoTransacao1_idx` (`TipoTransacao_idtipoTransacao` ASC),
  CONSTRAINT `fk_Transacao_Conta1`
    FOREIGN KEY (`Conta_numeroConta`)
    REFERENCES `CuelharBank`.`Conta` (`numeroConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transacao_TipoTransacao1`
    FOREIGN KEY (`TipoTransacao_idtipoTransacao`)
    REFERENCES `CuelharBank`.`TipoTransacao` (`idtipoTransacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;