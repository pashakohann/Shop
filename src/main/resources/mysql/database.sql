
CREATE  DATABASE `shop` CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';
USE shop;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 COLLATE= 'utf8mb4_unicode_ci'  CHARSET='utf8mb4';

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(45) NOT NULL,
  `password` varchar(65) NOT NULL,
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role_id` int NOT NULL DEFAULT '2',
  KEY `id_idx` (`id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';


CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `telephone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `flat` int DEFAULT NULL,
  `amount` decimal(8,1) unsigned zerofill NOT NULL DEFAULT '0000000.0',
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `users_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';

CREATE TABLE `brands` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';

CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';

CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(65) NOT NULL,
  `cost` decimal(8,1) NOT NULL,
  `category_id` int NOT NULL,
  `brand_id` int NOT NULL,
  `photo_link` varchar(90) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `products_categories_idx` (`id`,`category_id`),
  KEY `products_categories_idx1` (`category_id`),
  KEY `brand_id_idx` (`brand_id`),
  CONSTRAINT `brands_id` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `products_categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';

CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_cost` decimal(10,1) NOT NULL DEFAULT '0.0',
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id_idx` (`account_id`),
  CONSTRAINT `account_id` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';

CREATE TABLE `orders_products` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id_idx` (`product_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB CHARACTER SET = 'utf8mb4'  COLLATE = 'utf8mb4_unicode_ci';




