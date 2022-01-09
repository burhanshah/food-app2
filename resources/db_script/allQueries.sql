drop database if exists `food_db`;
create database if not exists `food_db`;

USE `food_db`;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `food_db` DEFAULT CHARACTER SET latin1 ;

CREATE TABLE IF NOT EXISTS `food_db`.`food_item` (
  `idfood` INT(11) NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(45) NOT NULL,
  `food_category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idfood`),
  UNIQUE INDEX `idmenu_UNIQUE` (`idfood` ASC) VISIBLE,
  UNIQUE INDEX `item_name_UNIQUE` (`item_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `food_db`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`iduser`, `username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `food_db`.`restaurant` (
  `idrestaurant` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rating` FLOAT(11) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idrestaurant`, `name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `food_db`.`menu` (
  `idmenu` INT(11) NOT NULL AUTO_INCREMENT,
  `price` FLOAT(11) NOT NULL,
  `food_item_idfood` INT(11) NOT NULL,
  `restaurant_idrestaurant` INT(11) NOT NULL,
  PRIMARY KEY (`idmenu`),
  INDEX `fk_menu_food_item1_idx` (`food_item_idfood` ASC) VISIBLE,
  INDEX `fk_menu_restaurant1_idx` (`restaurant_idrestaurant` ASC) VISIBLE,
  CONSTRAINT `fk_menu_food_item1`
    FOREIGN KEY (`food_item_idfood`)
    REFERENCES `food_db`.`food_item` (`idfood`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_restaurant1`
    FOREIGN KEY (`restaurant_idrestaurant`)
    REFERENCES `food_db`.`restaurant` (`idrestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `food_db`.`owner` (
  `idowner` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NOT NULL,
  `restaurant_idrestaurant` INT(11) NOT NULL,
  PRIMARY KEY (`idowner`, `restaurant_idrestaurant`),
  INDEX `fk_owner_restaurant1_idx` (`restaurant_idrestaurant` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_owner_restaurant1`
    FOREIGN KEY (`restaurant_idrestaurant`)
    REFERENCES `food_db`.`restaurant` (`idrestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `food_db`.`order` (
  `idorder` INT(11) NOT NULL AUTO_INCREMENT,
  `user_iduser` INT(11) NOT NULL,
  `delivery_address` VARCHAR(100) NOT NULL,
  `order_time` DATETIME NULL DEFAULT NULL,
  `restaurant_idrestaurant` INT(11) NOT NULL,
  `offers_idoffers` INT(11) NOT NULL,
  PRIMARY KEY (`idorder`, `user_iduser`, `restaurant_idrestaurant`, `offers_idoffers`),
  INDEX `fk_order_user1_idx` (`user_iduser` ASC) VISIBLE,
  INDEX `fk_order_restaurant1_idx` (`restaurant_idrestaurant` ASC) VISIBLE,
  INDEX `fk_order_offers1_idx` (`offers_idoffers` ASC) VISIBLE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `food_db`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_restaurant1`
    FOREIGN KEY (`restaurant_idrestaurant`)
    REFERENCES `food_db`.`restaurant` (`idrestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_offers1`
    FOREIGN KEY (`offers_idoffers`)
    REFERENCES `food_db`.`offers` (`idoffers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `food_db`.`order_items` (
  `idoder_items` INT(11) NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(45) NULL DEFAULT NULL,
  `item_price` FLOAT(11) NULL DEFAULT NULL,
  `item_category` VARCHAR(45) NULL DEFAULT NULL,
  `order_idorder` INT(11) NOT NULL,
  `order_user_iduser` INT(11) NOT NULL,
  `order_restaurant_idrestaurant` INT(11) NOT NULL,
  PRIMARY KEY (`idoder_items`, `order_idorder`, `order_user_iduser`, `order_restaurant_idrestaurant`),
  INDEX `fk_order_items_order1_idx` (`order_idorder` ASC, `order_user_iduser` ASC, `order_restaurant_idrestaurant` ASC) VISIBLE,
  CONSTRAINT `fk_order_items_order1`
    FOREIGN KEY (`order_idorder` , `order_user_iduser` , `order_restaurant_idrestaurant`)
    REFERENCES `food_db`.`order` (`idorder` , `user_iduser` , `restaurant_idrestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `food_db`.`offers` (
  `idoffers` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `discount` INT(11) NULL DEFAULT NULL,
  `restaurant_idrestaurant` INT(11) NOT NULL,
  PRIMARY KEY (`idoffers`, `restaurant_idrestaurant`, `code`),
  INDEX `fk_offers_restaurant1_idx` (`restaurant_idrestaurant` ASC) VISIBLE,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  CONSTRAINT `fk_offers_restaurant1`
    FOREIGN KEY (`restaurant_idrestaurant`)
    REFERENCES `food_db`.`restaurant` (`idrestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;