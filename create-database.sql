CREATE SCHEMA `buchhaltung` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
CREATE USER 'buchhaltung'@'%' IDENTIFIED BY 'password'
GRANT ALL PRIVILEGES ON 'buchhaltung'.* TO 'buchhaltung'@'%';
FLUSH PRIVILEGES;

CREATE TABLE `buchhaltung`.`ctrl_accounts` ( 
	`uid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT , 
	`account_number` VARCHAR(50) NOT NULL , 
	`account_type` VARCHAR(10) NOT NULL , 
	`account_subtype` VARCHAR(10) NOT NULL , 
	`name` VARCHAR(100) NOT NULL , 
	`description` VARCHAR(200) NOT NULL , 
	`active` INT(1) UNSIGNED NOT NULL , 
	`balance` DECIMAL(10,2) NOT NULL , 
	
	PRIMARY KEY (`uid`)
) ENGINE = InnoDB COMMENT = 'Accounts'; 

CREATE TABLE `buchhaltung`.`ctrl_postings` (
	`uid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT , 
	`posting_number` VARCHAR(64) NOT NULL , 
	`posting_type` VARCHAR(10) NOT NULL , 
	`source` VARCHAR(50) NOT NULL , 
	`source_ref` VARCHAR(50) NOT NULL , 
	`creation_time` DATETIME NOT NULL , 
	`fiscal_year` INT(6) UNSIGNED NOT NULL , 
	`description` TEXT NOT NULL , 
	
	PRIMARY KEY (`uid`)
) ENGINE = InnoDB COMMENT = 'posting main records';
	
CREATE TABLE `buchhaltung`.`ctrl_account_postings` (
	`uid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
	`posting_uid` INT(10) UNSIGNED NOT NULL , 
	`account_uid` INT(10) UNSIGNED NOT NULL , 
	`posting_type` VARCHAR(10) NOT NULL , 
	`amount` DECIMAL(10,2) UNSIGNED NOT NULL , 
	
	PRIMARY KEY (`uid`)
) ENGINE = InnoDB COMMENT = 'postings in an account'; 



	
	
	