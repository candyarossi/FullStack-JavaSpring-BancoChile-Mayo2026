-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cursos` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_curso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`formatos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`formatos` (
  `id_formato` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_formato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`temas` (
  `id_tema` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tema`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`regiones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`regiones` (
  `id_region` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_region`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`autores` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `cursos_id_curso` INT NOT NULL,
  `regiones_id_region` INT NOT NULL,
  PRIMARY KEY (`id_autor`, `cursos_id_curso`, `regiones_id_region`),
  INDEX `fk_autores_cursos1_idx` (`cursos_id_curso` ASC) VISIBLE,
  INDEX `fk_autores_regiones1_idx` (`regiones_id_region` ASC) VISIBLE,
  CONSTRAINT `fk_autores_cursos1`
    FOREIGN KEY (`cursos_id_curso`)
    REFERENCES `mydb`.`cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autores_regiones1`
    FOREIGN KEY (`regiones_id_region`)
    REFERENCES `mydb`.`regiones` (`id_region`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`idiomas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`idiomas` (
  `id_idioma` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_idioma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cursos_has_formatos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cursos_has_formatos` (
  `cursos_id_curso` INT NOT NULL,
  `formatos_id_formato` INT NOT NULL,
  PRIMARY KEY (`cursos_id_curso`, `formatos_id_formato`),
  INDEX `fk_cursos_has_formatos_formatos1_idx` (`formatos_id_formato` ASC) VISIBLE,
  INDEX `fk_cursos_has_formatos_cursos_idx` (`cursos_id_curso` ASC) VISIBLE,
  CONSTRAINT `fk_cursos_has_formatos_cursos`
    FOREIGN KEY (`cursos_id_curso`)
    REFERENCES `mydb`.`cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursos_has_formatos_formatos1`
    FOREIGN KEY (`formatos_id_formato`)
    REFERENCES `mydb`.`formatos` (`id_formato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cursos_has_temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cursos_has_temas` (
  `cursos_id_curso` INT NOT NULL,
  `temas_id_tema` INT NOT NULL,
  PRIMARY KEY (`cursos_id_curso`, `temas_id_tema`),
  INDEX `fk_cursos_has_temas_temas1_idx` (`temas_id_tema` ASC) VISIBLE,
  INDEX `fk_cursos_has_temas_cursos1_idx` (`cursos_id_curso` ASC) VISIBLE,
  CONSTRAINT `fk_cursos_has_temas_cursos1`
    FOREIGN KEY (`cursos_id_curso`)
    REFERENCES `mydb`.`cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cursos_has_temas_temas1`
    FOREIGN KEY (`temas_id_tema`)
    REFERENCES `mydb`.`temas` (`id_tema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`autores_has_idiomas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`autores_has_idiomas` (
  `autores_id_autor` INT NOT NULL,
  `autores_cursos_id_curso` INT NOT NULL,
  `autores_regiones_id_region` INT NOT NULL,
  `idiomas_id_idioma` INT NOT NULL,
  PRIMARY KEY (`autores_id_autor`, `autores_cursos_id_curso`, `autores_regiones_id_region`, `idiomas_id_idioma`),
  INDEX `fk_autores_has_idiomas_idiomas1_idx` (`idiomas_id_idioma` ASC) VISIBLE,
  INDEX `fk_autores_has_idiomas_autores1_idx` (`autores_id_autor` ASC, `autores_cursos_id_curso` ASC, `autores_regiones_id_region` ASC) VISIBLE,
  CONSTRAINT `fk_autores_has_idiomas_autores1`
    FOREIGN KEY (`autores_id_autor` , `autores_cursos_id_curso` , `autores_regiones_id_region`)
    REFERENCES `mydb`.`autores` (`id_autor` , `cursos_id_curso` , `regiones_id_region`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autores_has_idiomas_idiomas1`
    FOREIGN KEY (`idiomas_id_idioma`)
    REFERENCES `mydb`.`idiomas` (`id_idioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
