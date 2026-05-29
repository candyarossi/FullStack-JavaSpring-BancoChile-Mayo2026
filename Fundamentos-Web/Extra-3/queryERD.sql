-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gestionbiblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gestionbiblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gestionbiblioteca` DEFAULT CHARACTER SET utf8 ;
USE `gestionbiblioteca` ;

-- -----------------------------------------------------
-- Table `gestionbiblioteca`.`libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionbiblioteca`.`libros` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(80) NOT NULL,
  `autor` VARCHAR(80) NOT NULL,
  `editorial` VARCHAR(45) NULL,
  `stock` INT NOT NULL,
  `fecha_lanzamiento` DATE NULL,
  `genero` VARCHAR(45) NULL,
  PRIMARY KEY (`id_libro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionbiblioteca`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionbiblioteca`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `direccion` VARCHAR(80) NULL,
  `email` VARCHAR(45) NOT NULL,
  `fecha_registro` DATE NULL DEFAULT (CURRENT_DATE),
  `estado` VARCHAR(20) NULL DEFAULT 'Activo',
  `socio` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionbiblioteca`.`prestamos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionbiblioteca`.`prestamos` (
  `id_prestamo` INT NOT NULL AUTO_INCREMENT,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  `estado` VARCHAR(20) NULL DEFAULT 'Activo',
  `libros_id_libro` INT NOT NULL,
  `clientes_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_prestamo`, `libros_id_libro`, `clientes_id_cliente`),
  INDEX `fk_prestamos_libros1_idx` (`libros_id_libro` ASC) VISIBLE,
  INDEX `fk_prestamos_clientes1_idx` (`clientes_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_prestamos_libros1`
    FOREIGN KEY (`libros_id_libro`)
    REFERENCES `gestionbiblioteca`.`libros` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamos_clientes1`
    FOREIGN KEY (`clientes_id_cliente`)
    REFERENCES `gestionbiblioteca`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
