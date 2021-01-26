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
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupon` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `em_id` int DEFAULT NULL,
  `supplier_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `date_create` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Pk_Cou_Employee` (`em_id`),
  CONSTRAINT `Pk_Cou_Employee` FOREIGN KEY (`em_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES ('1',2,'Trống Đồng',2102,'2021-09-08'),('122',2,'xxx',1111111,'2021-01-01'),('c001',2,'iphone',16543,'2021-01-02'),('c002',2,'samsung',30000000,'2021-08-03'),('c003',2,'oppo',15000000,'2021-07-08'),('c004',2,'xxx',45000000,'2021-01-09'),('c005',2,'iphone',30000000,'2021-01-15'),('c006',2,'samsung',6000000,'2021-01-16'),('c007',2,'xiaomi',9000000,'2021-01-22'),('c008',2,'zzz',50000000,'2021-01-24'),('c009',2,'rx',23000000,'2021-01-27'),('C011',2,'ccc',1332222222,'2021-01-26'),('c1',2,'aaa',1222222,'2021-02-28'),('c100',2,'aaa',3234343,'2021-01-29'),('c102',2,'uuu',50000000,'2021-06-26'),('c103',2,'xxx',1000000,'2021-05-26'),('c104',2,'xxx',1666677,'2021-04-26'),('c105',2,'xxx',6660000,'2021-03-26'),('c107',2,'xx',10000000,'2021-12-26'),('c109',2,'xxx',8000000,'2021-11-26'),('c1112',2,'xxxx',1000000,'2021-10-26'),('c33',2,'xxx',1332323232,'2021-05-26'),('pn1',2,'abc',1221,'2021-01-10');
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
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
