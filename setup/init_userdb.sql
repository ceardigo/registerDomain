-- Create table `user`
CREATE TABLE `user`
(
 `id_user`              int NOT NULL AUTO_INCREMENT,
 `name`                 varchar(255) NOT NULL ,
 `email`                varchar(255) NOT NULL ,
 `password`             varchar(255) NOT NULL ,
 `login_number`         int NOT NULL ,
 `date_user_created`    timestamp NOT NULL ,
 `date_user_updated`    timestamp,

PRIMARY KEY (`id_user`)
);

-- Create table `address`
CREATE TABLE `address`
(
 `id_address`           int NOT NULL AUTO_INCREMENT,
 `id_user`              int NOT NULL,
 `street`               varchar(255) NOT NULL ,
 `city`                 varchar(255) NOT NULL ,
 `state`                varchar(255) NOT NULL ,
 `zip_code`             varchar(255) NOT NULL ,
 `country`              varchar(255) NOT NULL ,
 `description`          varchar(255) NOT NULL,
 `status`               enum('ACTIVE','DELETED'),
 `date_address_created` timestamp NOT NULL ,
 `date_address_updated` timestamp,
 
PRIMARY KEY (`id_address`),
FOREIGN KEY `id_user` (`id_user`) REFERENCES `user` (`id_user`)
);

-- Create a stored procedure to return all users and respective address
DELIMITER #
CREATE PROCEDURE findAllUsers()
BEGIN
    SELECT `USER`.`id_user`, `USER`.`name`, `USER`.`email`, `USER`.`password`, `USER`.`login_number`, `USER`.`date_user_created`, `USER`.`date_user_updated`,
           `ADDRESS`.`id_address`, `ADDRESS`.`street`, `ADDRESS`.`city`, `ADDRESS`.`state`, `ADDRESS`.`zip_code`, `ADDRESS`.`country`, `ADDRESS`.`description`, 
           `ADDRESS`.`status`, `ADDRESS`.`date_address_created`, `ADDRESS`.`date_address_updated`
    FROM user as USER
    INNER JOIN address as ADDRESS
    WHERE `USER`.`id_user` = `ADDRESS`.`id_user`;
END #

-- Create some records for table `user`
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (1, 'User Name one', 'user1@user.com', 'pwd1', 0, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (2, 'User Name two', 'user2@user.com', 'pwd2', 2, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (3, 'User Name three', 'user3@user.com', 'pwd3', 3, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (4, 'User Name four', 'user4@user.com', 'pwd4', 4, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (5, 'User Name five', 'user5@user.com', 'pwd5', 5, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (6, 'User Name six', 'user6@user.com', 'pwd6', 6, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (7, 'User Name seven', 'user7@user.com', 'pwd7', 7, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (8, 'User Name eight', 'user8@user.com', 'pwd8', 8, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (9, 'User Name nine', 'user9@user.com', 'pwd9', 0, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (10, 'User Name ten', 'user10@user.com', 'pwd10', 123, now(), null);
INSERT INTO `user` (`id_user`, `name`, `email`, `password`, `login_number`, `date_user_created`, `date_user_updated`) values (11, 'User Name eleven', 'user11@user.com', 'pwd11', 33, now(), null);

-- Create some records for table `address`
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (1, 1, '3 Westend Lane', 'Rochester', 'New York', '14609', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (2, 1, '68 Hallows Lane', 'Yakima', 'Washington', '98907', 'United States', 'Comercial', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (3, 2, '41 Petterle Way', 'Washington', 'District of Columbia', '20215', 'United States', 'Comercial', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (4, 2, '62 8th Parkway', 'Evansville', 'Indiana', '47725', 'United States', 'House', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (5, 2, '62814 Buhler Trail', 'Trenton', 'New Jersey', '08619', 'United States', 'Work', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (6, 3, '0 Crowley Drive', 'Shawnee Mission', 'Kansas', '66225', 'United States', 'Comercial', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (7, 3, '1 Buhler Lane', 'Washington', 'District of Columbia', '20580', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (8, 4, '58 Londonderry Place', 'Miami Beach', 'Florida', '33141', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (9, 4, '0 Prentice Road', 'Atlanta', 'Georgia', '31106', 'United States', 'Comercial', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (10, 5, '3745 4th Street', 'Fort Wayne', 'Indiana', '46896', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (11, 5, '8531 East Parkway', 'Las Vegas', 'Nevada', '89145', 'United States', 'Home', 'DELETED', now(), now());
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (12, 6, '704 Weeping Birch Street', 'Savannah', 'Georgia', '31416', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (13, 6, '989 Susan Road', 'Knoxville', 'Tennessee', '37939', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (14, 7, '3 Farwell Hill', 'Scottsdale', 'Arizona', '85271', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (15, 7, '80114 2nd Point', 'Houston', 'Texas', '77201', 'United States', 'Home', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (16, 8, '2 Schmedeman Hill', 'Waco', 'Texas', '76711', 'United States', 'Comercial', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (17, 9, '566 Morning Point', 'Columbia', 'South Carolina', '29215', 'United States', 'Home', 'DELETED', now(), now());
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (18, 10, '474 Carberry Pass', 'Peoria', 'Illinois', '61605', 'United States', 'Home', 'DELETED', now(), now());
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (19, 11, '99 Miller Park', 'Decatur', 'Georgia', '30033', 'United States', 'Comercial1', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (20, 11, '0304 Little Fleur Center', 'Ventura', 'California', '93005', 'United States', 'Comercial2', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (21, 11, '53143 Grasskamp Place', 'Fort Worth', 'Texas', '76147', 'United States', 'Comercial3', 'DELETED', now(), now());
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (22, 11, '670 Rowland Trail', 'Saint Petersburg', 'Florida', '33742', 'United States', 'Parents', 'DELETED', now(), now());
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (23, 11, '5451 Hagan Street', 'Washington', 'District of Columbia', '20414', 'United States', 'Old', 'ACTIVE', now(), null);
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (24, 11, '51502 Schlimgen Avenue', 'Lancaster', 'California', '93584', 'United States', 'Secret', 'DELETED', now(), now());
INSERT INTO `address` (`id_address`, `id_user`, `street`, `city`, `state`, `zip_code`, `country`, `description`, `status`, `date_address_created`, `date_address_updated`) values (25, 11, '4482 Independence Point', 'Lafayette', 'Indiana', '47905', 'United States', 'New secret', 'ACTIVE', now(), null);
