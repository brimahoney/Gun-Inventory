CREATE DATABASE IF NOT EXISTS `firearms_inventory`;
USE `firearms_inventory`;

DROP TABLE IF EXISTS `firearms`;
CREATE TABLE `firearms` (
  `serial_number` varchar(30) NOT NULL,
  `model` varchar(45) DEFAULT NULL,
  `make` varchar(45) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `caliber` varchar(10) DEFAULT NULL,
  `date_purchased` date DEFAULT NULL,
  `notes` text DEFAULT NULL,
  PRIMARY KEY(`serial_number`));

DROP TABLE IF EXISTS `firearm_images`;
CREATE TABLE `firearm_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `serial_number` varchar(30) NOT NULL,
  `image` blob DEFAULT NULL,
  FOREIGN KEY fk_fir(serial_number)
  REFERENCES firearms(serial_number)
  ON DELETE CASCADE
);
