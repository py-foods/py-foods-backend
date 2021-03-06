-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: remotemysql.com    Database: 87Xam2kfai
-- ------------------------------------------------------
-- Server version	8.0.13-4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `parent_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'CTG00001','Ly Giấy','những sản phẩm thuộc loại này được nhập từ mỹ',NULL,1,'0000-00-00 00:00:00','0000-00-00 00:00:00'),(2,'CTG00002','Ly Nhựa','những sản phẩm thuộc loại này được nhập từ mỹ',NULL,1,'0000-00-00 00:00:00','0000-00-00 00:00:00'),(3,'CTG00003','Ly Thủy Tinh','những sản phẩm thuộc loại này được nhập từ mỹ',NULL,1,'2020-04-28 00:00:00','2020-04-28 10:00:00'),(4,'CTG00004','Ly Sứ','những sản phẩm thuộc loại này được nhập từ mỹ',NULL,1,'2020-04-28 00:00:00','2020-04-28 12:00:00');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `firstname` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `lastname` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `birth_date` date DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address1` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address2` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `building` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `credit_card` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `total_price` decimal(10,0) NOT NULL,
  `ship_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `discount` float NOT NULL,
  `size` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `color` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'zalo','digital_wallet',1),(2,'momo','digital_wallet',1),(3,'viectcombank','internet banking',1),(4,'cash on delivery','cod',1);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcndxgax5tc50b52j989rp7dn6` (`product_id`),
  CONSTRAINT `FKbbcbljcbgayk25p0mc3uwsyy6` FOREIGN KEY (`id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKcndxgax5tc50b52j989rp7dn6` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (1,'http://res.cloudinary.com/dathandsome/image/upload/v1584630037/Dat%20Test-1584630024952.png','Dat Test-1584630024952',NULL,NULL,'',1),(2,'http://res.cloudinary.com/dathandsome/image/upload/v1584630043/Dat%20Test-1584630037537.png','Dat Test-1584630037537',NULL,NULL,'',1),(3,'http://res.cloudinary.com/dathandsome/image/upload/v1584630589/Dat%20Test-1584630587348.png','Dat Test-1584630587348',NULL,NULL,'',1),(4,'http://res.cloudinary.com/dathandsome/image/upload/v1584630591/Dat%20Test-1584630589423.png','Dat Test-1584630589423',NULL,NULL,'',2),(5,'http://res.cloudinary.com/dathandsome/image/upload/v1584631280/Dat%20Test-1584631278593.png','Dat Test-1584631278593',NULL,NULL,'',2),(6,'http://res.cloudinary.com/dathandsome/image/upload/v1584631281/Dat%20Test-1584631280574.png','Dat Test-1584631280574',NULL,NULL,'',2);
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL DEFAULT '1',
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `supplier_id` int(11) DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cost_price` decimal(10,2) DEFAULT NULL,
  `size` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `color` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `weight` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `thumbnail` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `currency` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'VND',
  `is_active` tinyint(1) NOT NULL,
  `discount_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sale_percent` int(11) NOT NULL,
  `is_discount` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'P000001','ly nhua','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5000.00,'3x4','vang, cam',12,'0.05',NULL,1,'1',1,NULL,NULL,'VND',1,'percent',0,1),(2,'P000002','ly nhua Australian','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5500.00,'3x4','vang, cam',20,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(3,'P000003','ly nhua Gemany','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5070.00,'3x4','vang, cam',30,'0.05',NULL,4,'1',1,NULL,NULL,'VND',1,'percent',0,1),(4,'P000004','ly nhua Russia','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5003.00,'3x4','vang, cam',12,'0.05',NULL,3,'1',1,NULL,NULL,'VND',1,'percent',0,1),(5,'P000005','ly nhua USA','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,2,10,5200.00,'3x4','vang, cam',11,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(6,'P000006','ly nhua China','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,2,10,6000.00,'3x4','vang, cam',11,'0.05',NULL,3,'1',1,NULL,NULL,'VND',1,'percent',0,1),(7,'P000007','ly nhua Viet Nam','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,2,10,8000.00,'3x4','vang, cam',4,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(8,'P000008','ly nhua Turkey','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,2,10,2000.00,'3x4','vang, cam',5000,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'amount',0,1),(9,'P000009','ly nhua Peru','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5300.00,'3x4','vang, cam',12,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(10,'P000010','ly nhua Brazil','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,6000.00,'3x4','vang, cam',13,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(11,'P000011','ly nhua','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5000.00,'3x4','vang, cam',12,'0.05',NULL,2,'1',1,NULL,NULL,'VND',1,'percent',0,1),(12,'P000012','ly nhua Australian','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5500.00,'3x4','vang, cam',20,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(13,'P000013','ly nhua Gemany','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,1,10,5070.00,'3x4','vang, cam',30,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(14,'P000014','ly nhua Russia','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,3,10,5003.00,'3x4','vang, cam',12,'0.05',NULL,3,'1',1,NULL,NULL,'VND',1,'percent',0,1),(15,'P000015','ly nhua USA','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,3,10,5200.00,'3x4','vang, cam',11,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(16,'P000016','ly nhua China','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,4,10,6000.00,'3x4','vang, cam',11,'0.05',NULL,3,'1',1,NULL,NULL,'VND',1,'percent',0,1),(17,'P000017','ly nhua Viet Nam','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,4,10,8000.00,'3x4','vang, cam',4,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(18,'P000018','ly nhua Turkey','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,4,10,2000.00,'3x4','vang, cam',5000,'0.05',NULL,1,'1',1,NULL,NULL,'VND',1,'amount',0,1),(19,'P000019','ly nhua Peru','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,4,10,5300.00,'3x4','vang, cam',12,'0.05',NULL,5,'1',1,NULL,NULL,'VND',1,'percent',0,1),(20,'P000020','ly nhua Brazil','- Thành phần: Kem sữa tươi, chất rắn sữa, chất nhũ hóa, chất ổn định </br> - Bảo quản: Bảo quản trong ngăn mát tủ lạnh (0 - 5 độ C)',0,3,10,6000.00,'3x4','vang, cam',13,'0.05',NULL,3,'1',1,NULL,NULL,'VND',1,'percent',0,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_bk`
--

DROP TABLE IF EXISTS `product_bk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_bk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount_type` varchar(255) DEFAULT NULL,
  `is_discount` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `sale_percent` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `category_code` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `ranking` int(11) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `supplier_code` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `weigth` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1onsrfub7tpmstil3s7amjw1g` (`discount_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_bk`
--

LOCK TABLES `product_bk` WRITE;
/*!40000 ALTER TABLE `product_bk` DISABLE KEYS */;
INSERT INTO `product_bk` VALUES (1,'2020-03-19 07:00:44','2020-03-19 07:00:44',NULL,'dech biet ghi cai veo gi',NULL,NULL,'Dat Test',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2020-03-19 07:09:51','2020-03-19 07:09:51',NULL,'dech biet ghi cai veo gi',NULL,NULL,'Dat Test',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'2020-03-19 07:21:22','2020-03-19 07:21:22',NULL,'dech biet ghi cai veo gi',NULL,NULL,'Dat Test',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_bk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `payment` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'GMAIL, FACEBOOK, PY_FOODS',
  `session` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hoan.lam','123456','guest','xxxxxxxxxxxxxxxxxxxx',1),(2,'hoan.lam@gmail.com',NULL,'gmail','xxxxxxxxxxxxxxxxxxxx',1),(3,'hoan.lam@facebook.com',NULL,'facebook','xxxxxxxxxxxxxxxxxxx',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-28  2:38:47
