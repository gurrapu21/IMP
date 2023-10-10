
CREATE TABLE `inventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_number` int NOT NULL,
  `material_id` varchar(255) NOT NULL,
  `reset_qty` bigint NOT NULL,
  `order_quantity` bigint NOT NULL,
  `available_quantity` bigint NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `login` (
  `user_id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ;


CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) Not NULL,
  `local_date` date DEFAULT NULL,
  `local_time` time DEFAULT NULL,
  `location_number` bigint NOT NULL,
  `material_id` varchar(255) NOT NULL,
  `order_quantity` bigint NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ;

CREATE TABLE `rest_inventor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_number` int NOT NULL ,
  `reset_qty` bigint NOT NULL,
  `material_id` varchar(255) DEFAULT NULL,
  `reset_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
  `user_id` varchar(255) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ;


