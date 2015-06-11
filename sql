//board table create sql

CREATE TABLE `bitdb`.`BOARD` (
  `BOARD_NO` INT NOT NULL,
  PRIMARY KEY (`BOARD_NO`));

//add columns to the table

ALTER TABLE `bitdb`.`BOARD` 
CHANGE COLUMN `BOARD_NO` `BOARD_TITLE` VARCHAR(45) NOT NULL ,
ADD COLUMN `BOARD_CONTENT` VARCHAR(45) NOT NULL AFTER `BOARD_TITLE`,
ADD COLUMN `BOARD_AUTHOR` VARCHAR(45) NOT NULL AFTER `BOARD_CONTENT`,
ADD COLUMN `BOARD_DATE` VARCHAR(45) NOT NULL AFTER `BOARD_AUTHOR`,
ADD COLUMN `BOARD_VIEW_COUNT` VARCHAR(45) NOT NULL AFTER `BOARD_DATE`,
DROP PRIMARY KEY;

  