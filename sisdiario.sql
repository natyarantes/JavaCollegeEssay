SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `sisdiario` ;
USE `sisdiario` ;

-- -----------------------------------------------------
-- Table `sisdiario`.`ALUNO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sisdiario`.`ALUNO` (
  `Matricula` VARCHAR(11) NOT NULL ,
  `Nome` VARCHAR(45) NULL DEFAULT NULL ,
  `Endereco` VARCHAR(45) NULL DEFAULT NULL ,
  `Telefone` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`Matricula`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisdiario`.`Avaliacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sisdiario`.`Avaliacao` (
  `idAvaliacao` INT(11) NOT NULL AUTO_INCREMENT ,
  `ValorNota` INT(11) NULL DEFAULT NULL ,
  `idAluno` VARCHAR(11) NULL DEFAULT NULL ,
  `idTipoNota` INT(11) NULL DEFAULT NULL ,
  `nomeTurma` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idAvaliacao`) ,
  INDEX `Matricula_idx` (`idAluno` ASC) ,
  INDEX `idTipoNota_idx` (`idTipoNota` ASC) ,
  CONSTRAINT `Matricula`
    FOREIGN KEY (`idAluno` )
    REFERENCES `sisdiario`.`aluno` (`Matricula` ),
  CONSTRAINT `idTipoNota`
    FOREIGN KEY (`idTipoNota` )
    REFERENCES `sisdiario`.`notas` (`idNotas` ))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisdiario`.`Notas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sisdiario`.`Notas` (
  `idNotas` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipoNota` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`idNotas`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisdiario`.`Professor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sisdiario`.`Professor` (
  `Matricula` VARCHAR(11) NOT NULL ,
  `Nome` VARCHAR(45) NULL DEFAULT NULL ,
  `Endereco` VARCHAR(45) NULL DEFAULT NULL ,
  `Telefone` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`Matricula`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisdiario`.`Turma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sisdiario`.`Turma` (
  `idTurma` INT(11) NOT NULL AUTO_INCREMENT ,
  `Aluno_Matricula` VARCHAR(11) NOT NULL ,
  `Professor_Matricula` VARCHAR(11) NOT NULL ,
  `nomeTurma` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idTurma`) ,
  INDEX `fk_Turma_Aluno_idx` (`Aluno_Matricula` ASC) ,
  INDEX `fk_Turma_Professor1_idx` (`Professor_Matricula` ASC) ,
  CONSTRAINT `fk_Turma_Aluno`
    FOREIGN KEY (`Aluno_Matricula` )
    REFERENCES `sisdiario`.`aluno` (`Matricula` ),
  CONSTRAINT `fk_Turma_Professor1`
    FOREIGN KEY (`Professor_Matricula` )
    REFERENCES `sisdiario`.`professor` (`Matricula` ))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;

USE `sisdiario` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
