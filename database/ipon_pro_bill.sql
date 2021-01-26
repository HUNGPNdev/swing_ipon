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
-- Table structure for table `pro_bill`
--

DROP TABLE IF EXISTS `pro_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pro_bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pro_id` int DEFAULT NULL,
  `bill_id` int DEFAULT NULL,
  `count` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Pk_pro_bill_pro` (`pro_id`),
  KEY `Pk_bill_pro_bill` (`bill_id`),
  CONSTRAINT `Pk_bill_pro_bill` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `Pk_pro_bill_pro` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_bill`
--

LOCK TABLES `pro_bill` WRITE;
/*!40000 ALTER TABLE `pro_bill` DISABLE KEYS */;
INSERT INTO `pro_bill` VALUES (1,6,1,1),(3,16,1,1),(4,16,2,2),(5,7,2,1),(7,6,8,1),(10,16,10,1),(13,15,11,2),(14,19,11,1),(15,17,11,1),(16,16,12,1),(20,6,13,1),(21,19,13,1),(22,21,14,1),(26,16,15,1),(29,15,16,1),(31,26,17,1),(32,27,17,1),(33,32,17,1),(34,17,2,1),(35,18,7,1),(37,17,18,1),(38,20,18,1),(39,22,18,1),(40,18,19,1),(41,20,19,1),(42,21,19,1),(43,22,19,1),(44,17,20,1),(45,19,20,2),(46,35,21,1),(47,34,21,1),(48,33,21,1),(49,19,22,2),(50,22,22,1),(51,18,23,1),(52,21,23,1),(53,20,23,1),(54,18,24,1),(55,21,24,1),(56,20,25,2),(57,22,25,1),(58,17,26,1),(59,16,26,1),(60,23,26,1),(61,20,27,1),(62,21,27,1),(63,17,1,1),(64,18,1,2),(65,17,10,2),(66,18,10,1);
/*!40000 ALTER TABLE `pro_bill` ENABLE KEYS */;
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
