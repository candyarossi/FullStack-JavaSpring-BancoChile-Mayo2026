-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gestionDeRestaurantes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gestionDeRestaurantes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gestionDeRestaurantes` DEFAULT CHARACTER SET utf8 ;
USE `gestionDeRestaurantes` ;

-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`restaurantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`restaurantes` (
  `id_restaurante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`id_restaurante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`mesas` (
  `id_mesa` INT NOT NULL AUTO_INCREMENT,
  `nro_mesa` INT NOT NULL,
  `capacidad` INT NOT NULL,
  `estado_disponibilidad` TINYINT NULL,
  `restaurantes_id_restaurante` INT NOT NULL,
  PRIMARY KEY (`id_mesa`, `restaurantes_id_restaurante`),
  INDEX `fk_mesas_restaurantes1_idx` (`restaurantes_id_restaurante` ASC) VISIBLE,
  CONSTRAINT `fk_mesas_restaurantes1`
    FOREIGN KEY (`restaurantes_id_restaurante`)
    REFERENCES `gestionDeRestaurantes`.`restaurantes` (`id_restaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`facturas` (
  `id_factura` INT NOT NULL AUTO_INCREMENT,
  `total` FLOAT NOT NULL,
  `metodo_pago` VARCHAR(45) NOT NULL,
  `fecha_pago` DATE NOT NULL,
  PRIMARY KEY (`id_factura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`pedidos` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `clientes_id_cliente` INT NOT NULL,
  `facturas_id_factura` INT NOT NULL,
  PRIMARY KEY (`id_pedido`, `clientes_id_cliente`, `facturas_id_factura`),
  INDEX `fk_pedidos_clientes1_idx` (`clientes_id_cliente` ASC) VISIBLE,
  INDEX `fk_pedidos_facturas1_idx` (`facturas_id_factura` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_clientes1`
    FOREIGN KEY (`clientes_id_cliente`)
    REFERENCES `gestionDeRestaurantes`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_facturas1`
    FOREIGN KEY (`facturas_id_factura`)
    REFERENCES `gestionDeRestaurantes`.`facturas` (`id_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`menus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`menus` (
  `id_menu` INT NOT NULL AUTO_INCREMENT,
  `nombre_articulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`id_menu`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`cocineros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`cocineros` (
  `id_cocinero` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `especialidad` VARCHAR(45) NOT NULL,
  `restaurantes_id_restaurante` INT NOT NULL,
  PRIMARY KEY (`id_cocinero`, `restaurantes_id_restaurante`),
  INDEX `fk_cocineros_restaurantes1_idx` (`restaurantes_id_restaurante` ASC) VISIBLE,
  CONSTRAINT `fk_cocineros_restaurantes1`
    FOREIGN KEY (`restaurantes_id_restaurante`)
    REFERENCES `gestionDeRestaurantes`.`restaurantes` (`id_restaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`ingredientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`ingredientes` (
  `id_ingrediente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `stock` INT NULL,
  PRIMARY KEY (`id_ingrediente`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`preparaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`preparaciones` (
  `id_preparacion` INT NOT NULL AUTO_INCREMENT,
  `cantidad_ingrediente` FLOAT NOT NULL,
  `fecha` DATE NOT NULL,
  `menus_id_menu` INT NOT NULL,
  PRIMARY KEY (`id_preparacion`, `menus_id_menu`),
  INDEX `fk_preparaciones_menus1_idx` (`menus_id_menu` ASC) VISIBLE,
  CONSTRAINT `fk_preparaciones_menus1`
    FOREIGN KEY (`menus_id_menu`)
    REFERENCES `gestionDeRestaurantes`.`menus` (`id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`reservas` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NOT NULL,
  `cantidad_personas` INT NOT NULL,
  `clientes_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_reserva`, `clientes_id_cliente`),
  INDEX `fk_reservas_clientes1_idx` (`clientes_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_reservas_clientes1`
    FOREIGN KEY (`clientes_id_cliente`)
    REFERENCES `gestionDeRestaurantes`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`restaurantes_has_clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`restaurantes_has_clientes` (
  `restaurantes_id_restaurante` INT NOT NULL,
  `clientes_id_cliente` INT NOT NULL,
  PRIMARY KEY (`restaurantes_id_restaurante`, `clientes_id_cliente`),
  INDEX `fk_restaurantes_has_clientes_clientes1_idx` (`clientes_id_cliente` ASC) VISIBLE,
  INDEX `fk_restaurantes_has_clientes_restaurantes_idx` (`restaurantes_id_restaurante` ASC) VISIBLE,
  CONSTRAINT `fk_restaurantes_has_clientes_restaurantes`
    FOREIGN KEY (`restaurantes_id_restaurante`)
    REFERENCES `gestionDeRestaurantes`.`restaurantes` (`id_restaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_restaurantes_has_clientes_clientes1`
    FOREIGN KEY (`clientes_id_cliente`)
    REFERENCES `gestionDeRestaurantes`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`ingredientes_has_preparaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`ingredientes_has_preparaciones` (
  `ingredientes_id_ingrediente` INT NOT NULL,
  `preparaciones_id_preparacion` INT NOT NULL,
  PRIMARY KEY (`ingredientes_id_ingrediente`, `preparaciones_id_preparacion`),
  INDEX `fk_ingredientes_has_preparaciones_preparaciones1_idx` (`preparaciones_id_preparacion` ASC) VISIBLE,
  INDEX `fk_ingredientes_has_preparaciones_ingredientes1_idx` (`ingredientes_id_ingrediente` ASC) VISIBLE,
  CONSTRAINT `fk_ingredientes_has_preparaciones_ingredientes1`
    FOREIGN KEY (`ingredientes_id_ingrediente`)
    REFERENCES `gestionDeRestaurantes`.`ingredientes` (`id_ingrediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingredientes_has_preparaciones_preparaciones1`
    FOREIGN KEY (`preparaciones_id_preparacion`)
    REFERENCES `gestionDeRestaurantes`.`preparaciones` (`id_preparacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`cocineros_has_preparaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`cocineros_has_preparaciones` (
  `cocineros_id_cocinero` INT NOT NULL,
  `cocineros_restaurantes_id_restaurante` INT NOT NULL,
  `preparaciones_id_preparacion` INT NOT NULL,
  `preparaciones_menus_id_menu` INT NOT NULL,
  PRIMARY KEY (`cocineros_id_cocinero`, `cocineros_restaurantes_id_restaurante`, `preparaciones_id_preparacion`, `preparaciones_menus_id_menu`),
  INDEX `fk_cocineros_has_preparaciones_preparaciones1_idx` (`preparaciones_id_preparacion` ASC, `preparaciones_menus_id_menu` ASC) VISIBLE,
  INDEX `fk_cocineros_has_preparaciones_cocineros1_idx` (`cocineros_id_cocinero` ASC, `cocineros_restaurantes_id_restaurante` ASC) VISIBLE,
  CONSTRAINT `fk_cocineros_has_preparaciones_cocineros1`
    FOREIGN KEY (`cocineros_id_cocinero` , `cocineros_restaurantes_id_restaurante`)
    REFERENCES `gestionDeRestaurantes`.`cocineros` (`id_cocinero` , `restaurantes_id_restaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cocineros_has_preparaciones_preparaciones1`
    FOREIGN KEY (`preparaciones_id_preparacion` , `preparaciones_menus_id_menu`)
    REFERENCES `gestionDeRestaurantes`.`preparaciones` (`id_preparacion` , `menus_id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`pedidos_has_menus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`pedidos_has_menus` (
  `pedidos_id_pedido` INT NOT NULL,
  `pedidos_clientes_id_cliente` INT NOT NULL,
  `pedidos_facturas_id_factura` INT NOT NULL,
  `menus_id_menu` INT NOT NULL,
  PRIMARY KEY (`pedidos_id_pedido`, `pedidos_clientes_id_cliente`, `pedidos_facturas_id_factura`, `menus_id_menu`),
  INDEX `fk_pedidos_has_menus_menus1_idx` (`menus_id_menu` ASC) VISIBLE,
  INDEX `fk_pedidos_has_menus_pedidos1_idx` (`pedidos_id_pedido` ASC, `pedidos_clientes_id_cliente` ASC, `pedidos_facturas_id_factura` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_has_menus_pedidos1`
    FOREIGN KEY (`pedidos_id_pedido` , `pedidos_clientes_id_cliente` , `pedidos_facturas_id_factura`)
    REFERENCES `gestionDeRestaurantes`.`pedidos` (`id_pedido` , `clientes_id_cliente` , `facturas_id_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_has_menus_menus1`
    FOREIGN KEY (`menus_id_menu`)
    REFERENCES `gestionDeRestaurantes`.`menus` (`id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestionDeRestaurantes`.`preparaciones_has_pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionDeRestaurantes`.`preparaciones_has_pedidos` (
  `preparaciones_id_preparacion` INT NOT NULL,
  `preparaciones_menus_id_menu` INT NOT NULL,
  `pedidos_id_pedido` INT NOT NULL,
  `pedidos_clientes_id_cliente` INT NOT NULL,
  `pedidos_facturas_id_factura` INT NOT NULL,
  PRIMARY KEY (`preparaciones_id_preparacion`, `preparaciones_menus_id_menu`, `pedidos_id_pedido`, `pedidos_clientes_id_cliente`, `pedidos_facturas_id_factura`),
  INDEX `fk_preparaciones_has_pedidos_pedidos1_idx` (`pedidos_id_pedido` ASC, `pedidos_clientes_id_cliente` ASC, `pedidos_facturas_id_factura` ASC) VISIBLE,
  INDEX `fk_preparaciones_has_pedidos_preparaciones1_idx` (`preparaciones_id_preparacion` ASC, `preparaciones_menus_id_menu` ASC) VISIBLE,
  CONSTRAINT `fk_preparaciones_has_pedidos_preparaciones1`
    FOREIGN KEY (`preparaciones_id_preparacion` , `preparaciones_menus_id_menu`)
    REFERENCES `gestionDeRestaurantes`.`preparaciones` (`id_preparacion` , `menus_id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_preparaciones_has_pedidos_pedidos1`
    FOREIGN KEY (`pedidos_id_pedido` , `pedidos_clientes_id_cliente` , `pedidos_facturas_id_factura`)
    REFERENCES `gestionDeRestaurantes`.`pedidos` (`id_pedido` , `clientes_id_cliente` , `facturas_id_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
