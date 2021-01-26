-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: ipon
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cate_id` int DEFAULT NULL,
  `old_count` int DEFAULT NULL,
  `now_count` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `cou_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Pk_cou_pro` (`cou_id`),
  KEY `Pk_pro_cate` (`cate_id`),
  CONSTRAINT `Pk_cou_pro` FOREIGN KEY (`cou_id`) REFERENCES `coupon` (`id`),
  CONSTRAINT `Pk_pro_cate` FOREIGN KEY (`cate_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (6,'Trống Đồng',2,20,9,900,'1'),(7,'Phan gia',3,20,9,210,'1'),(15,'iphon1',2,21,18,221,'pn1'),(16,'samsung	',3,12,3,213,'pn1'),(17,'iphone7',2,100,92,8000000,'c001'),(18,'iphone6',2,122,115,5000000,'c001'),(19,'iphone8',2,30,24,10000000,'c001'),(20,'samsungA10',3,122,116,5000000,'c002'),(21,'samsungA30',3,23,18,10000000,'c002'),(22,'samsungA50',3,67,63,15000000,'c002'),(23,'oppoA7',4,11,10,3000000,'c003'),(24,'oppoA9',4,14,14,10000000,'c003'),(25,'iphoneX',2,23,23,20000000,'c004'),(26,'iphone12',2,32,31,30000000,'c005'),(27,'samsungJ8',3,50,49,6000000,'c006'),(28,'xiaomimi',5,4,4,9000000,'c007'),(29,'iphone12pro',2,2,2,30000000,'c008'),(30,'samsungA80',3,6,6,14000000,'c008'),(31,'xiaomi',5,4,4,16000000,'c008'),(32,'xiaomiE',5,8,7,12000000,'c009'),(33,'iphone5',2,10,9,10000000,'c009'),(34,'iphone',2,1,0,1444444,'c100'),(35,'e',2,1,0,60000,'c1'),(36,'samsung 0',3,12,12,100000,'122'),(37,'iohine12',2,23,23,1000000,'c33'),(38,'iphone4',2,55,55,1444444,'c33'),(39,'iphone',2,6,6,133333333,'C011'),(40,'sámung',3,77,77,1000000000,'c102'),(41,'ippp',2,45,45,10000000,'c103'),(42,'oppo',4,44,44,15555665,'c104'),(43,'ip',2,12,12,20000000,'c105'),(44,'ip',2,4,4,100000000,'c107'),(45,'ip',2,9,9,40000000,'c109'),(46,'ip',2,89,89,5000000,'c1112');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-26 17:14:11
