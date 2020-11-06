DROP DATABASE IF EXISTS `forum`;
CREATE DATABASE IF NOT EXISTS `forum`;
USE `forum`;

CREATE TABLE IF NOT EXISTS `forum`.`role` (
    `roleId` INT NOT NULL AUTO_INCREMENT,
    `role` varchar(50),
    PRIMARY KEY (`roleId`)
    );

CREATE TABLE IF NOT EXISTS `forum`.`user` (
    `userId` INT NOT NULL unique AUTO_INCREMENT,
    `firstName` varchar(45) NULL,
    `lastName`  varchar(45) NULL,
    `login` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `roleId` INT NOT NULL,
    PRIMARY KEY (`userId`),
    FOREIGN KEY (`roleId`) 
    REFERENCES `role`(`roleId`) ON DELETE CASCADE
    );
    
CREATE TABLE IF NOT EXISTS `forum`.`topic` (
    `topicId` INT NOT NULL unique AUTO_INCREMENT,
    `name`  varchar(255),
    PRIMARY KEY (`topicId`)
);

CREATE TABLE IF NOT EXISTS `forum`.`theme` (
    `themeId` INT NOT NULL unique AUTO_INCREMENT,
	`name`  varchar(255),
    `description` varchar(255),
    `topicId` INT NOT NULL,
    PRIMARY KEY (`themeId`),
    FOREIGN KEY (`topicId`) 
    REFERENCES `topic`(`topicId`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `forum`.`themeStatistic` (
    `statisticId` INT NOT NULL AUTO_INCREMENT,
    `date` date NULL,
    `themeId` int not null,
    `userId` INT NOT NULL,
    PRIMARY KEY (`statisticId`),
    FOREIGN KEY (`themeId`) 
    REFERENCES `theme`(`themeId`) ON DELETE CASCADE,
    FOREIGN KEY (`userId`)
    REFERENCES `user`(`userId`) ON DELETE CASCADE
  );
  
CREATE TABLE IF NOT EXISTS  `forum`.`message` (
	`messageId` INT NOT NULL unique AUTO_INCREMENT,
	`description` VARCHAR(255) NULL,
    `correct`  boolean default '0',
	`themeId` INT NOT NULL,
	PRIMARY KEY (`messageId`),
	FOREIGN KEY (`themeId`)
    REFERENCES `theme` (`themeId`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `forum`.`statistic` (
    `statisticId` INT NOT NULL AUTO_INCREMENT,
    `date` date NULL,
    `messageId` INT NOT NULL,
    `userId` INT NOT NULL,
    PRIMARY KEY (`statisticId`),
    FOREIGN KEY (`messageId`) 
    REFERENCES `message`(`messageId`) ON DELETE CASCADE,
    FOREIGN KEY (`userId`)
    REFERENCES `user`(`userId`) ON DELETE CASCADE
  );
  
  CREATE TABLE IF NOT EXISTS  `forum`.`news` (
	`newsId` INT NOT NULL unique AUTO_INCREMENT,
	`description` VARCHAR(255) NULL,
    `correct`  boolean default '0',
	PRIMARY KEY (`newsId`)
);

CREATE TABLE IF NOT EXISTS `forum`.`newsStatistic` (
    `statisticId` INT NOT NULL AUTO_INCREMENT,
    `date` date NULL,
    `newsId` int not null,
    `userId` INT NOT NULL,
    PRIMARY KEY (`statisticId`),
    FOREIGN KEY (`newsId`) 
    REFERENCES `news`(`newsId`) ON DELETE CASCADE,
    FOREIGN KEY (`userId`)
    REFERENCES `user`(`userId`) ON DELETE CASCADE
);

INSERT INTO `forum`.`role` (`roleId`, `role`) VALUES ('1', 'ADMIN');
INSERT INTO `forum`.`role` (`roleId`, `role`) VALUES ('2', 'USER');



