CREATE SCHEMA IF NOT EXISTS `shop_tutorial_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `shop_tutorial_db` ;

-- -----------------------------------------------------
-- Table `shop_tutorial_db`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_tutorial_db`.`products` (
  `PRODUCT_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(255) NULL,
  `PRICE` DOUBLE NULL,
  `DATE_ADDED` DATETIME NULL,
  PRIMARY KEY (`PRODUCT_ID`));

-- -----------------------------------------------------
-- Table `shop_tutorial_db`.`reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_tutorial_db`.`reviews` (
  `REVIEW_ID` INT NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` INT NOT NULL,
  `REVIEW` TEXT NOT NULL,
  `REVIEW_DATE` DATETIME NULL,
  PRIMARY KEY (`REVIEW_ID`));


-- -----------------------------------------------------
-- Data for table `shop_tutorial_db`.`products`
-- -----------------------------------------------------
INSERT INTO `shop_tutorial_db`.`products` (`PRODUCT_ID`, `NAME`, `PRICE`, `DATE_ADDED`) VALUES (1, 'Silverton Blacktop XD', 2500, now());
INSERT INTO `shop_tutorial_db`.`products` (`PRODUCT_ID`, `NAME`, `PRICE`, `DATE_ADDED`) VALUES (2, '4K Fluid 24\'\' Display Monitor', 300, now());


-- -----------------------------------------------------
-- Data for table `shop_tutorial_db`.`reviews`
-- -----------------------------------------------------
INSERT INTO `shop_tutorial_db`.`reviews` (`REVIEW_ID`, `PRODUCT_ID`, `REVIEW`, `REVIEW_DATE`) VALUES (1, 2, '4K Fluid is untrademarked or rather not certain kind of a monitor that can offer you as the developer as smooth vision of your workspace. No struggles indeed', now());
INSERT INTO `shop_tutorial_db`.`reviews` (`REVIEW_ID`, `PRODUCT_ID`, `REVIEW`, `REVIEW_DATE`) VALUES (2, 1, 'Ever seen a silver black object? Say no more! The Silverton Blacktop XD has got the feature you are just looking for', now());
INSERT INTO `shop_tutorial_db`.`reviews` (`REVIEW_ID`, `PRODUCT_ID`, `REVIEW`, `REVIEW_DATE`) VALUES (3, 2, 'The fluid vision is all I wanted in terms of displays requirements. I can recommend', now());
