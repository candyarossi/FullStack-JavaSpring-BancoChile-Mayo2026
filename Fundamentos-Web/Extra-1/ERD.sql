-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema basePrueba
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `basePrueba` DEFAULT CHARACTER SET utf8 ;
USE `basePrueba` ;

-- -----------------------------------------------------
-- Table `basePrueba`.`duenos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basePrueba`.`duenos` (
  `id_dueno` INT NOT NULL AUTO_INCREMENT,
  `nombre_completo` VARCHAR(80) NOT NULL,
  `direccion` VARCHAR(80) NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `contacto_alternativo` VARCHAR(20) NULL,
  PRIMARY KEY (`id_dueno`)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basePrueba`.`mascotas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basePrueba`.`mascotas` (
  `id_mascota` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `especie` VARCHAR(15) NOT NULL,
  `edad` INT NULL,
  `peso` FLOAT NULL,
  `altura` FLOAT NULL,
  `fecha_nacimiento` DATE NULL,
  `duenos_id_dueno` INT NOT NULL,

  PRIMARY KEY (`id_mascota`),

  INDEX `fk_mascotas_duenos_idx` (`duenos_id_dueno` ASC) VISIBLE,

  CONSTRAINT `fk_mascotas_duenos`
    FOREIGN KEY (`duenos_id_dueno`)
    REFERENCES `basePrueba`.`duenos` (`id_dueno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basePrueba`.`citas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basePrueba`.`citas` (
  `id_cita` INT NOT NULL AUTO_INCREMENT,
  `horario` TIME NOT NULL,
  `fecha` DATE NOT NULL,
  `box_atencion` INT NULL,
  `motivo` VARCHAR(45) NOT NULL,
  `mascotas_id_mascota` INT NOT NULL,

  PRIMARY KEY (`id_cita`),

  INDEX `fk_citas_mascotas1_idx` (`mascotas_id_mascota` ASC) VISIBLE,

  CONSTRAINT `fk_citas_mascotas1`
    FOREIGN KEY (`mascotas_id_mascota`)
    REFERENCES `basePrueba`.`mascotas` (`id_mascota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;