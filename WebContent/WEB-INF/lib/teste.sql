-- MySQL Script generated by MySQL Workbench
-- Sáb 26 Mai 2018 18:21:51 BRT
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
-- Table `CuelharBank`.`Transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Transacao` (
  `idTransacao` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idTransacao`),
  UNIQUE INDEX `idTransacao_UNIQUE` (`idTransacao` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Pagamento` (
  `identificacaoPagamento` VARCHAR(45) NULL,
  `valorPagamento` DOUBLE NOT NULL,
  `dtPagamento` TIMESTAMP NOT NULL,
  `Conta_numeroConta` INT NOT NULL,
  `Conta_Agencia_idAgencia` INT NOT NULL,
  `Transacao_idTransacao` INT NOT NULL,
  INDEX `fk_Pagamento_Conta1_idx` (`Conta_numeroConta` ASC, `Conta_Agencia_idAgencia` ASC),
  INDEX `fk_Pagamento_Transacao1_idx` (`Transacao_idTransacao` ASC),
  PRIMARY KEY (`Transacao_idTransacao`),
  UNIQUE INDEX `Transacao_idTransacao_UNIQUE` (`Transacao_idTransacao` ASC),
  CONSTRAINT `fk_Pagamento_Conta1`
    FOREIGN KEY (`Conta_numeroConta`)
    REFERENCES `CuelharBank`.`Conta` (`numeroConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pagamento_Transacao1`
    FOREIGN KEY (`Transacao_idTransacao`)
    REFERENCES `CuelharBank`.`Transacao` (`idTransacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`Deposito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Deposito` (
  `idDeposito` INT NOT NULL AUTO_INCREMENT,
  `identificacaoDeposito` VARCHAR(45) NULL,
  `valorDeposito` DOUBLE NOT NULL,
  `dtDeposito` TIMESTAMP NOT NULL,
  `Conta_numeroConta` INT NOT NULL,
  `Conta_Agencia_idAgencia` INT NOT NULL,
  `Transacao_idTransacao` INT NOT NULL,
  PRIMARY KEY (`idDeposito`),
  UNIQUE INDEX `idDeposito_UNIQUE` (`idDeposito` ASC),
  INDEX `fk_Deposito_Conta1_idx` (`Conta_numeroConta` ASC, `Conta_Agencia_idAgencia` ASC),
  INDEX `fk_Deposito_Transacao1_idx` (`Transacao_idTransacao` ASC),
  CONSTRAINT `fk_Deposito_Conta1`
    FOREIGN KEY (`Conta_numeroConta`)
    REFERENCES `CuelharBank`.`Conta` (`numeroConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Deposito_Transacao1`
    FOREIGN KEY (`Transacao_idTransacao`)
    REFERENCES `CuelharBank`.`Transacao` (`idTransacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CuelharBank`.`Transferencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CuelharBank`.`Transferencia` (
  `idTransferencia` INT NOT NULL AUTO_INCREMENT,
  `identificacaoTransferecia` VARCHAR(45) NULL,
  `valorTransferencia` DOUBLE NOT NULL,
  `dtTransferencia` TIMESTAMP NOT NULL,
  `cpfBeneficiadoTransferencia` INT(11) NOT NULL,
  `contaBeneficiada` VARCHAR(45) NOT NULL,
  `Conta_numeroConta` INT NOT NULL,
  `Transacao_idTransacao` INT NOT NULL,
  PRIMARY KEY (`idTransferencia`),
  UNIQUE INDEX `idTransferencia_UNIQUE` (`idTransferencia` ASC),
  INDEX `fk_Transferencia_Conta1_idx` (`Conta_numeroConta` ASC),
  INDEX `fk_Transferencia_Transacao1_idx` (`Transacao_idTransacao` ASC),
  CONSTRAINT `fk_Transferencia_Conta1`
    FOREIGN KEY (`Conta_numeroConta`)
    REFERENCES `CuelharBank`.`Conta` (`numeroConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transferencia_Transacao1`
    FOREIGN KEY (`Transacao_idTransacao`)
    REFERENCES `CuelharBank`.`Transacao` (`idTransacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;