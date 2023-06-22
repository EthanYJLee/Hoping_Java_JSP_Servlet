-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: camping
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `acomment`
--

DROP TABLE IF EXISTS `acomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acomment` (
  `acSeq` int NOT NULL AUTO_INCREMENT,
  `acTitle` varchar(20) NOT NULL,
  `acContent` text NOT NULL,
  `acTime` datetime NOT NULL,
  `acMtime` datetime DEFAULT NULL,
  `acDtime` datetime DEFAULT NULL,
  `ask_aSeq` int NOT NULL,
  `host_hSeq` int NOT NULL,
  PRIMARY KEY (`acSeq`,`ask_aSeq`,`host_hSeq`),
  UNIQUE KEY `acSeq_UNIQUE` (`acSeq`),
  KEY `fk_acomment_ask1_idx` (`ask_aSeq`),
  KEY `fk_acomment_host1_idx` (`host_hSeq`),
  CONSTRAINT `fk_acomment_ask1` FOREIGN KEY (`ask_aSeq`) REFERENCES `ask` (`aSeq`),
  CONSTRAINT `fk_acomment_host1` FOREIGN KEY (`host_hSeq`) REFERENCES `host` (`hSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acomment`
--

LOCK TABLES `acomment` WRITE;
/*!40000 ALTER TABLE `acomment` DISABLE KEYS */;
INSERT INTO `acomment` VALUES (1,'바베큐 장비 대여 문의답변','무료로 대여 가능합니다','2022-11-09 23:50:19',NULL,NULL,2,1),(2,'테스트용질문이요','그런건 좀 알아서 하세요 ...','2022-11-15 04:32:22',NULL,NULL,3,31);
/*!40000 ALTER TABLE `acomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ask`
--

DROP TABLE IF EXISTS `ask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ask` (
  `aSeq` int NOT NULL AUTO_INCREMENT,
  `aCId` varchar(20) NOT NULL,
  `aTitle` varchar(20) NOT NULL,
  `aContent` text NOT NULL,
  `aTime` datetime NOT NULL,
  `aMtime` datetime DEFAULT NULL,
  `aDtime` datetime DEFAULT NULL,
  `aRegSeq` int NOT NULL,
  PRIMARY KEY (`aSeq`),
  UNIQUE KEY `aSeq_UNIQUE` (`aSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ask`
--

LOCK TABLES `ask` WRITE;
/*!40000 ALTER TABLE `ask` DISABLE KEYS */;
INSERT INTO `ask` VALUES (1,'pisal','추가인원문의','인원 추가시 1인당 추가되는 금액이 궁금해요','2022-11-09 20:30:12',NULL,NULL,1),(2,'kevininthewood','바베큐 장비 빌릴 수 있나요?','제곧내','2022-11-09 21:11:40',NULL,NULL,2),(3,'pisal','테스트용질문이요','커멘트가 text로 되어있어서 많이 올라가겠군요','2022-11-12 01:10:51',NULL,NULL,1),(4,'test','gdxg','gdggx','2022-11-12 16:54:47',NULL,NULL,1),(5,'test','문의가 있습니다 ','문의요','2022-11-12 16:56:46',NULL,NULL,7),(6,'test','문의요','123','2022-11-13 11:07:55',NULL,NULL,2),(7,'pisal','123','','2022-11-13 12:05:35',NULL,NULL,8),(8,'pisal','re test','123','2022-11-13 12:06:32',NULL,NULL,9),(9,'pisal','123','123','2022-11-13 12:06:52',NULL,NULL,10),(10,'test','test1','123','2022-11-13 13:05:04',NULL,NULL,2),(11,'test','123','123','2022-11-13 13:15:47',NULL,NULL,23);
/*!40000 ALTER TABLE `ask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `boSeq` int NOT NULL AUTO_INCREMENT,
  `boPrice` int NOT NULL,
  `boDate` date DEFAULT NULL,
  `boCheckindate` date DEFAULT NULL,
  `boGroup` int DEFAULT NULL,
  `boCount` int DEFAULT NULL,
  `boCanceldate` date DEFAULT NULL,
  `pay_cid` varchar(20) NOT NULL,
  `pay_room_roSeq` int NOT NULL,
  `pay_room_regcamp_regSeq` int NOT NULL,
  `pay_room_regcamp_host_hSeq` int NOT NULL,
  `pay_client_cId` varchar(20) NOT NULL,
  PRIMARY KEY (`boSeq`,`pay_cid`,`pay_room_roSeq`,`pay_room_regcamp_regSeq`,`pay_room_regcamp_host_hSeq`,`pay_client_cId`),
  UNIQUE KEY `boSeq_UNIQUE` (`boSeq`),
  KEY `fk_book_pay1_idx` (`pay_cid`,`pay_room_roSeq`,`pay_room_regcamp_regSeq`,`pay_room_regcamp_host_hSeq`,`pay_client_cId`),
  CONSTRAINT `fk_book_pay1` FOREIGN KEY (`pay_cid`, `pay_room_roSeq`, `pay_room_regcamp_regSeq`, `pay_room_regcamp_host_hSeq`, `pay_client_cId`) REFERENCES `pay` (`cid`, `room_roSeq`, `room_regcamp_regSeq`, `room_regcamp_host_hSeq`, `client_cId`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (17,80000,'2022-11-11','2022-11-11',17,3,NULL,'asdf',13,1,1,'kevininthewood'),(24,80000,'2022-11-12','2022-11-04',24,3,NULL,'asdfg',13,1,1,'test'),(25,0,'2022-11-12','2022-11-03',25,3,NULL,'asdfg',13,1,1,'test'),(26,0,'2022-11-12','2022-11-04',25,3,NULL,'asdfg',13,1,1,'test'),(27,0,'2022-11-12','2022-11-05',25,3,NULL,'asdfg',13,1,1,'test'),(28,0,'2022-11-12','2022-11-06',25,3,NULL,'asdfg',13,1,1,'test'),(29,0,'2022-11-12','2022-11-07',25,3,NULL,'asdfg',13,1,1,'test'),(30,0,'2022-11-12','2022-11-08',25,3,NULL,'asdfg',13,1,1,'test'),(31,0,'2022-11-12','2022-11-09',25,3,NULL,'asdfg',13,1,1,'test'),(32,0,'2022-11-12','2022-11-10',25,3,NULL,'asdfg',13,1,1,'test'),(33,0,'2022-11-12','2022-11-11',25,3,NULL,'asdfg',13,1,1,'test'),(34,0,'2022-11-12','2022-11-12',25,3,NULL,'asdfg',13,1,1,'test'),(35,0,'2022-11-13','2022-11-03',35,3,NULL,'asdfg',13,1,1,'test'),(36,0,'2022-11-13','2022-11-03',36,3,NULL,'asdfg',13,1,1,'test'),(37,0,'2022-11-13','2022-11-04',37,3,NULL,'asdfg',13,1,1,'test'),(42,0,'2022-11-13','2022-11-02',42,3,NULL,'asdfg',13,1,1,'test'),(43,0,'2022-11-13','2022-11-03',42,3,NULL,'asdfg',13,1,1,'test'),(44,0,'2022-11-13','2022-11-04',42,3,NULL,'asdfg',13,1,1,'test'),(45,0,'2022-11-13','2022-12-01',45,3,NULL,'asdfg',13,1,1,'test'),(46,0,'2022-11-13','2022-12-02',45,3,NULL,'asdfg',13,1,1,'test'),(47,0,'2022-11-13','2022-12-03',45,3,NULL,'asdfg',13,1,1,'test'),(48,0,'2022-11-13','2022-12-04',45,3,NULL,'asdfg',13,1,1,'test'),(50,150000,'2022-11-14','2022-11-26',50,3,NULL,'GKB9test11',9,1,1,'test'),(51,150000,'2022-11-14','2022-11-27',50,3,NULL,'GKB9test11',9,1,1,'test'),(52,150000,'2022-11-14','2022-11-28',50,3,NULL,'GKB9test11',9,1,1,'test'),(53,150000,'2022-11-14','2022-11-29',50,3,NULL,'GKB9test11',9,1,1,'test'),(54,150000,'2022-11-14','2022-11-30',50,3,NULL,'GKB9test11',9,1,1,'test'),(55,150000,'2022-11-14','2022-12-01',50,3,NULL,'GKB9test11',9,1,1,'test'),(56,150000,'2022-11-14','2022-11-24',56,3,NULL,'LWE9test11',9,1,1,'test'),(57,150000,'2022-11-14','2022-11-25',56,3,NULL,'LWE9test11',9,1,1,'test'),(58,150000,'2022-11-14','2022-11-26',56,3,NULL,'LWE9test11',9,1,1,'test'),(59,150000,'2022-11-14','2022-11-24',59,3,NULL,'UNV9test11',9,1,1,'test'),(60,150000,'2022-11-14','2022-11-25',59,3,NULL,'UNV9test11',9,1,1,'test'),(61,150000,'2022-11-14','2022-11-26',59,3,NULL,'UNV9test11',9,1,1,'test'),(62,150000,'2022-11-14','2022-11-25',62,3,NULL,'LDE10pisal11',10,1,1,'pisal'),(63,150000,'2022-11-14','2022-11-26',62,3,NULL,'LDE10pisal11',10,1,1,'pisal'),(64,150000,'2022-11-14','2022-11-27',62,3,NULL,'LDE10pisal11',10,1,1,'pisal'),(65,150000,'2022-11-14','2022-11-25',65,3,NULL,'ARQ8pisal11',8,1,1,'pisal'),(66,150000,'2022-11-14','2022-11-26',65,3,NULL,'ARQ8pisal11',8,1,1,'pisal'),(67,150000,'2022-11-14','2022-11-27',65,3,NULL,'ARQ8pisal11',8,1,1,'pisal'),(68,150000,'2022-11-14','2022-11-30',68,3,NULL,'XEC11test11',11,1,1,'test'),(69,150000,'2022-11-14','2022-12-01',68,3,NULL,'XEC11test11',11,1,1,'test'),(70,150000,'2022-11-14','2022-12-02',68,3,NULL,'XEC11test11',11,1,1,'test'),(71,200000,'2022-11-14','2022-11-01',71,3,NULL,'WOD12test11',12,1,1,'test'),(72,200000,'2022-11-14','2022-11-02',71,3,NULL,'WOD12test11',12,1,1,'test'),(73,200000,'2022-11-14','2022-11-03',71,3,NULL,'WOD12test11',12,1,1,'test'),(74,200000,'2022-11-14','2022-11-04',71,3,NULL,'WOD12test11',12,1,1,'test'),(75,200000,'2022-11-14','2022-11-05',71,3,NULL,'WOD12test11',12,1,1,'test'),(76,200000,'2022-11-14','2022-11-06',71,3,NULL,'WOD12test11',12,1,1,'test'),(77,200000,'2022-11-14','2022-11-07',71,3,NULL,'WOD12test11',12,1,1,'test'),(78,200000,'2022-11-14','2022-11-08',71,3,NULL,'WOD12test11',12,1,1,'test'),(79,200000,'2022-11-14','2022-11-09',71,3,NULL,'WOD12test11',12,1,1,'test'),(80,200000,'2022-11-14','2022-11-10',71,3,NULL,'WOD12test11',12,1,1,'test'),(81,200000,'2022-11-14','2022-11-11',71,3,NULL,'WOD12test11',12,1,1,'test'),(82,200000,'2022-11-14','2022-11-12',71,3,NULL,'WOD12test11',12,1,1,'test'),(83,200000,'2022-11-14','2022-11-13',71,3,NULL,'WOD12test11',12,1,1,'test'),(84,200000,'2022-11-14','2022-11-14',71,3,NULL,'WOD12test11',12,1,1,'test'),(85,200000,'2022-11-14','2022-11-15',71,3,NULL,'WOD12test11',12,1,1,'test'),(86,200000,'2022-11-14','2022-11-16',71,3,NULL,'WOD12test11',12,1,1,'test'),(87,200000,'2022-11-14','2022-11-17',71,3,NULL,'WOD12test11',12,1,1,'test'),(88,200000,'2022-11-14','2022-11-18',71,3,NULL,'WOD12test11',12,1,1,'test'),(89,200000,'2022-11-14','2022-11-19',71,3,NULL,'WOD12test11',12,1,1,'test'),(90,200000,'2022-11-14','2022-11-20',71,3,NULL,'WOD12test11',12,1,1,'test'),(91,200000,'2022-11-14','2022-11-21',71,3,NULL,'WOD12test11',12,1,1,'test'),(92,200000,'2022-11-14','2022-11-22',71,3,NULL,'WOD12test11',12,1,1,'test'),(93,200000,'2022-11-14','2022-11-23',71,3,NULL,'WOD12test11',12,1,1,'test'),(94,200000,'2022-11-14','2022-11-24',71,3,NULL,'WOD12test11',12,1,1,'test'),(95,200000,'2022-11-14','2022-11-25',71,3,NULL,'WOD12test11',12,1,1,'test'),(96,200000,'2022-11-14','2022-11-26',71,3,NULL,'WOD12test11',12,1,1,'test'),(97,200000,'2022-11-14','2022-11-27',71,3,NULL,'WOD12test11',12,1,1,'test'),(98,200000,'2022-11-14','2022-11-28',71,3,NULL,'WOD12test11',12,1,1,'test'),(99,200000,'2022-11-14','2022-11-29',71,3,NULL,'WOD12test11',12,1,1,'test'),(100,200000,'2022-11-14','2022-11-30',71,3,NULL,'WOD12test11',12,1,1,'test'),(101,200000,'2022-11-14','2022-12-01',71,3,NULL,'WOD12test11',12,1,1,'test'),(102,150000,'2022-11-14','2022-11-21',102,3,NULL,'DWN11test11',11,1,1,'test'),(103,150000,'2022-11-14','2022-11-22',102,3,NULL,'DWN11test11',11,1,1,'test'),(104,150000,'2022-11-14','2022-11-23',102,3,NULL,'DWN11test11',11,1,1,'test'),(105,150000,'2022-11-14','2022-11-24',102,3,NULL,'DWN11test11',11,1,1,'test'),(106,150000,'2022-11-14','2022-11-25',102,3,NULL,'DWN11test11',11,1,1,'test'),(107,150000,'2022-11-14','2022-11-26',102,3,NULL,'DWN11test11',11,1,1,'test'),(108,150000,'2022-11-14','2022-11-27',102,3,NULL,'DWN11test11',11,1,1,'test'),(109,150000,'2022-11-14','2022-11-28',102,3,NULL,'DWN11test11',11,1,1,'test'),(110,150000,'2022-11-14','2022-11-29',102,3,NULL,'DWN11test11',11,1,1,'test'),(124,300000,'2022-11-15','2022-11-03',124,3,NULL,'XLQ39test27',39,2,7,'test'),(125,300000,'2022-11-15','2022-11-04',124,3,NULL,'XLQ39test27',39,2,7,'test'),(126,300000,'2022-11-15','2022-11-05',124,3,NULL,'XLQ39test27',39,2,7,'test'),(127,300000,'2022-11-15','2022-11-06',124,3,NULL,'XLQ39test27',39,2,7,'test'),(128,300000,'2022-11-15','2022-11-07',124,3,NULL,'XLQ39test27',39,2,7,'test'),(129,300000,'2022-11-15','2022-11-08',124,3,NULL,'XLQ39test27',39,2,7,'test'),(130,300000,'2022-11-15','2022-11-09',124,3,NULL,'XLQ39test27',39,2,7,'test'),(131,300000,'2022-11-15','2022-11-10',124,3,NULL,'XLQ39test27',39,2,7,'test'),(132,300000,'2022-11-15','2022-11-11',124,3,NULL,'XLQ39test27',39,2,7,'test'),(133,150000,'2022-11-15','2022-11-02',133,3,NULL,'AKX9test11',9,1,1,'test'),(134,150000,'2022-11-15','2022-11-03',133,3,NULL,'AKX9test11',9,1,1,'test'),(135,150000,'2022-11-15','2022-11-04',133,3,NULL,'AKX9test11',9,1,1,'test'),(136,150000,'2022-11-15','2022-11-05',133,3,NULL,'AKX9test11',9,1,1,'test'),(137,150000,'2022-11-15','2022-11-06',133,3,NULL,'AKX9test11',9,1,1,'test'),(138,150000,'2022-11-15','2022-11-07',133,3,NULL,'AKX9test11',9,1,1,'test'),(139,150000,'2022-11-15','2022-11-08',133,3,NULL,'AKX9test11',9,1,1,'test'),(140,150000,'2022-11-15','2022-11-09',133,3,NULL,'AKX9test11',9,1,1,'test'),(141,150000,'2022-11-15','2022-11-10',133,3,NULL,'AKX9test11',9,1,1,'test'),(142,150000,'2022-11-15','2022-11-04',142,3,NULL,'FYU10test11',10,1,1,'test'),(143,150000,'2022-11-15','2022-11-05',142,3,NULL,'FYU10test11',10,1,1,'test'),(144,150000,'2022-11-15','2022-11-06',142,3,NULL,'FYU10test11',10,1,1,'test'),(145,150000,'2022-11-15','2022-11-07',142,3,NULL,'FYU10test11',10,1,1,'test'),(146,150000,'2022-11-15','2022-11-08',142,3,NULL,'FYU10test11',10,1,1,'test'),(147,150000,'2022-11-15','2022-11-09',142,3,NULL,'FYU10test11',10,1,1,'test'),(148,150000,'2022-11-15','2022-11-10',142,3,NULL,'FYU10test11',10,1,1,'test'),(149,150000,'2022-11-15','2022-11-11',142,3,NULL,'FYU10test11',10,1,1,'test'),(150,150000,'2022-11-15','2022-11-12',142,3,NULL,'FYU10test11',10,1,1,'test'),(151,150000,'2022-11-15','2022-11-13',142,3,NULL,'FYU10test11',10,1,1,'test'),(152,150000,'2022-11-15','2022-11-14',142,3,NULL,'FYU10test11',10,1,1,'test'),(153,150000,'2022-11-15','2022-11-15',142,3,NULL,'FYU10test11',10,1,1,'test'),(154,150000,'2022-11-15','2022-11-16',142,3,NULL,'FYU10test11',10,1,1,'test'),(155,150000,'2022-11-15','2022-11-17',142,3,NULL,'FYU10test11',10,1,1,'test'),(156,150000,'2022-11-15','2022-11-18',142,3,NULL,'FYU10test11',10,1,1,'test');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `booklist`
--

DROP TABLE IF EXISTS `booklist`;
/*!50001 DROP VIEW IF EXISTS `booklist`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `booklist` AS SELECT 
 1 AS `boSeq`,
 1 AS `boPrice`,
 1 AS `boGroup`,
 1 AS `regName`,
 1 AS `pay_client_cId`,
 1 AS `total`,
 1 AS `boDate`,
 1 AS `roNum`,
 1 AS `pay_room_regcamp_regSeq`,
 1 AS `checkin`,
 1 AS `checkout`,
 1 AS `boCount`,
 1 AS `pay_room_regcamp_host_hSeq`,
 1 AS `pay_room_roSeq`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `bprch`
--

DROP TABLE IF EXISTS `bprch`;
/*!50001 DROP VIEW IF EXISTS `bprch`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `bprch` AS SELECT 
 1 AS `boSeq`,
 1 AS `boPrice`,
 1 AS `boDate`,
 1 AS `boCheckindate`,
 1 AS `boGroup`,
 1 AS `boCount`,
 1 AS `boCanceldate`,
 1 AS `pay_cid`,
 1 AS `pay_room_roSeq`,
 1 AS `pay_room_regcamp_regSeq`,
 1 AS `pay_room_regcamp_host_hSeq`,
 1 AS `pay_client_cId`,
 1 AS `cid`,
 1 AS `partner_order_id`,
 1 AS `partner_user_id`,
 1 AS `item_name`,
 1 AS `quantity`,
 1 AS `total_amount`,
 1 AS `tax_free_amount`,
 1 AS `room_roSeq`,
 1 AS `room_regcamp_regSeq`,
 1 AS `room_regcamp_host_hSeq`,
 1 AS `client_cId`,
 1 AS `roSeq`,
 1 AS `roNum`,
 1 AS `roPrice`,
 1 AS `roMax`,
 1 AS `roOccupied`,
 1 AS `roDate`,
 1 AS `roMdate`,
 1 AS `roDdate`,
 1 AS `regcamp_regSeq`,
 1 AS `regcamp_host_hSeq`,
 1 AS `regSeq`,
 1 AS `regTel`,
 1 AS `regCategory`,
 1 AS `regDetailaddress`,
 1 AS `regName`,
 1 AS `regDate`,
 1 AS `regMdate`,
 1 AS `regDdate`,
 1 AS `regSummary`,
 1 AS `regImage1`,
 1 AS `regImage2`,
 1 AS `regImage3`,
 1 AS `regImage4`,
 1 AS `host_hSeq`,
 1 AS `hSeq`,
 1 AS `hId`,
 1 AS `hDate`,
 1 AS `hMdate`,
 1 AS `hDdate`,
 1 AS `hSummary`,
 1 AS `hImage`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `camp`
--

DROP TABLE IF EXISTS `camp`;
/*!50001 DROP VIEW IF EXISTS `camp`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `camp` AS SELECT 
 1 AS `regSeq`,
 1 AS `regTel`,
 1 AS `regCategory`,
 1 AS `regDetailaddress`,
 1 AS `regName`,
 1 AS `regDate`,
 1 AS `regMdate`,
 1 AS `regDdate`,
 1 AS `regSummary`,
 1 AS `regImage1`,
 1 AS `regImage2`,
 1 AS `regImage3`,
 1 AS `regImage4`,
 1 AS `host_hSeq`,
 1 AS `roSeq`,
 1 AS `roNum`,
 1 AS `roPrice`,
 1 AS `roMax`,
 1 AS `roOccupied`,
 1 AS `roDate`,
 1 AS `roMdate`,
 1 AS `roDdate`,
 1 AS `regcamp_regSeq`,
 1 AS `regcamp_host_hSeq`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `ch`
--

DROP TABLE IF EXISTS `ch`;
/*!50001 DROP VIEW IF EXISTS `ch`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ch` AS SELECT 
 1 AS `regSeq`,
 1 AS `regTel`,
 1 AS `regCategory`,
 1 AS `regDetailaddress`,
 1 AS `regName`,
 1 AS `regDate`,
 1 AS `regMdate`,
 1 AS `regDdate`,
 1 AS `regSummary`,
 1 AS `regImage1`,
 1 AS `regImage2`,
 1 AS `regImage3`,
 1 AS `regImage4`,
 1 AS `host_hSeq`,
 1 AS `hSeq`,
 1 AS `hId`,
 1 AS `hDate`,
 1 AS `hMdate`,
 1 AS `hDdate`,
 1 AS `hSummary`,
 1 AS `hImage`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `checkdate2`
--

DROP TABLE IF EXISTS `checkdate2`;
/*!50001 DROP VIEW IF EXISTS `checkdate2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `checkdate2` AS SELECT 
 1 AS `roSeq`,
 1 AS `roNum`,
 1 AS `roPrice`,
 1 AS `roMax`,
 1 AS `roOccupied`,
 1 AS `roDate`,
 1 AS `roMdate`,
 1 AS `roDdate`,
 1 AS `regcamp_regSeq`,
 1 AS `regcamp_host_hSeq`,
 1 AS `regSeq`,
 1 AS `regTel`,
 1 AS `regCategory`,
 1 AS `regDetailaddress`,
 1 AS `regName`,
 1 AS `regDate`,
 1 AS `regMdate`,
 1 AS `regDdate`,
 1 AS `regSummary`,
 1 AS `regImage1`,
 1 AS `regImage2`,
 1 AS `regImage3`,
 1 AS `regImage4`,
 1 AS `host_hSeq`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `cId` varchar(20) NOT NULL,
  `cPw` varchar(20) DEFAULT NULL,
  `cName` varchar(20) DEFAULT NULL,
  `cPhone` varchar(20) DEFAULT NULL,
  `cEmail` varchar(45) DEFAULT NULL,
  `cDate` date DEFAULT NULL,
  `cMdate` date DEFAULT NULL,
  `cDdate` date DEFAULT NULL,
  `cImage` varchar(100) DEFAULT NULL,
  `zonecode` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `buildingName` varchar(45) DEFAULT NULL,
  `detailAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cId`),
  UNIQUE KEY `cId_UNIQUE` (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('acalderhead81','iecSwENSm','Calderhead','748-696-4840','dcalderhead81@naver.com','2020-04-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('acalrow45','7Vo4IrZxn','Calrow','472-844-7326','ncalrow45@scribd.com','2021-07-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('aclucas1x','KgysP8','Clucas','936-775-4660','mclucas1x@upenn.edu','2020-07-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('acomini2a','r1iZXUcBrqk','Comini','357-505-3276','qcomini2a@blog.com','2021-04-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('acrouchf','Zj9KWQ','Crouch','537-569-0800','lcrouchf@nbcnews.com','2018-04-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('adevonport4z','cn1kXmPukfE9','Devonport','645-473-3197','ldevonport4z@nytimes.com','2021-04-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('aganniclifft19','15LZCGouw','Ganniclifft','587-417-6167','bganniclifft19@comsenz.com','2019-06-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ahead4w','0ucKFT9Xv3s','Head','726-977-3525','shead4w@bluehost.com','2021-10-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ajeggo4d','j3ZdVHoX2uJ','Jeggo','170-463-0597','ajeggo4d@squarespace.com','2021-06-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ajepp4s','zwR4IMF23f','Jepp','651-419-9033','tjepp4s@merriam-webster.com','2020-12-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('alefley11','sU2Dt3HYq6ze','Lefley','340-411-4905','ulefley11@sina.com.cn','2018-03-17',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('alpha','qwez3','알파','010-1235-2313','alpha@daum.net','2016-01-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('amartinuzzi8b','fsYlFXRm4','Martinuzzi','797-709-2625','amartinuzzi8b@blinklist.com','2021-04-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('amatisse4r','qF1CNO','Matisse','670-860-7870','jmatisse4r@soup.io','2018-02-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('apoyntz4u','ibETA6S','Poyntz','697-352-7645','rpoyntz4u@unesco.org','2021-01-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('arennebach37','1bNb88xSKB2','Rennebach','588-293-3801','srennebach37@topsy.com','2021-08-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('asparyn','ISDLlHII','Spary','991-614-3894','hsparyn@rediff.com','2021-05-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('astubbings2l','qcg22Ri0wRx','Stubbings','611-545-6236','gstubbings2l@amazon.com','2021-10-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('atointon2u','M9nVa3GX','Tointon','345-463-7250','gtointon2u@rediff.com','2019-02-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bbirtwistle4v','HtXGOG','Birtwistle','683-838-0434','sbirtwistle4v@youtu.be','2021-07-29',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bboggon2v','5uye6QAG','Boggon','112-835-2373','iboggon2v@ask.com','2019-10-17',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bdeortega3o','u9dTIzBQt','De Ortega','709-591-7491','tdeortega3o@yahoo.co.jp','2021-03-29',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('beta','g5tdf','베타','010-6351-1474','beta@gmail.com','2016-02-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bjeanel8','PVZxdiwGik4d','Jeanel','227-346-3747','tjeanel8@tamu.edu','2018-03-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bleaney1c','xyURU51LpCaO','Leaney','471-485-6405','sleaney1c@unesco.org','2018-07-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bmillson29','tPmn9vNn','Millson','596-942-9993','cmillson29@livejournal.com','2018-05-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bpuig1','Y2FYwlhU','Puig','662-206-8727','apuig1@is.gd','2017-03-31',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('brickeard4t','iJ5lcy','Rickeard','377-561-1395','grickeard4t@smugmug.com','2021-03-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('brodders2t','26xioR','Rodders','645-422-3363','grodders2t@hp.com','2021-03-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('bvergine2b','wcmKiHxJkaj','Vergine','630-739-3758','nvergine2b@a8.net','2020-01-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('byungjun323','dfkjlasdjf2',NULL,NULL,NULL,'2016-11-21',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cathy','0dklfe',NULL,NULL,NULL,'2016-10-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cbarriball54','tkOHk2t66xUy','Barriball','154-365-7610','wbarriball54@netlog.com','2018-07-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cbriddock3t','izUVFcr','Briddock','295-453-9548','mbriddock3t@scientificamerican.com','2017-08-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cgoodinge22','gW65FgSCZr4','Goodinge','481-378-9985','agoodinge22@nasa.gov','2017-03-21',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('chairman','djfj3',NULL,NULL,NULL,'2016-09-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cjendrich2w','VyxqSS','Jendrich','929-885-2798','ajendrich2w@ft.com','2020-01-21',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('clisa','EIliRyQwltc','Lis','543-556-2925','alisa@japanpost.jp','2021-01-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cmacian4','XttSfpO','MacIan','447-211-6669','gmacian4@newyorker.com','2020-06-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cmcgibbon28','Gyb2AgFEEekL','McGibbon','835-795-9230','rmcgibbon28@army.mil','2019-10-31',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cmcquirter25','x0FVfCZqK','McQuirter','613-938-9094','omcquirter25@cargocollective.com','2017-09-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('coneil13','dK3bJIr8zcm','Oneil','339-447-6690','doneil13@drupal.org','2018-08-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cpilmer17','7OkjV2ro','Pilmer','298-603-6498','opilmer17@last.fm','2018-08-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cplus','dfsadf23',NULL,NULL,NULL,'2016-04-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cplusplus','dsf42',NULL,NULL,NULL,'2016-04-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cpollen15','MOtlz8C','Pollen','413-566-0139','apollen15@dropbox.com','2021-09-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cridger21','FV5L5gcJ','Ridger','605-566-6460','bridger21@statcounter.com','2018-02-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('crodden1d','bUNTDfnBg7U','Rodden','232-328-5340','nrodden1d@ihg.com','2017-06-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('crooksby1j','Y0ZQoO3V5Qq','Rooksby','726-481-0251','mrooksby1j@weebly.com','2021-07-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cshade32','cfqdKWYVE','Shade','162-559-0318','bshade32@zdnet.com','2020-11-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cshop','dfsdf23',NULL,NULL,NULL,'2016-03-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('csmidmoreu','t67pZB','Smidmore','248-206-0329','esmidmoreu@vk.com','2017-02-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cstockoe4h','snOicS4I3Ulw','Stockoe','280-889-9386','bstockoe4h@devhub.com','2018-01-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('cswancock2k','mf74GMp','Swancock','378-540-7997','fswancock2k@sciencedaily.com','2017-04-28',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dabys34','Y1nyX460','Abys','668-493-5528','babys34@ftc.gov','2017-07-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dalvares80','pwP9JDkf','Alvares','331-176-5052','balvares80@oaic.gov.au','2021-09-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dangerous','akdfjl23',NULL,NULL,NULL,'2016-07-10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dantonietti38','nyX5COO','Antonietti','147-453-7030','gantonietti38@cpanel.net','2018-04-17',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dart','2fdsf1',NULL,NULL,NULL,'2016-02-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dbirtonshaw2r','wyIUCqJS6vZ','Birtonshaw','523-203-1023','wbirtonshaw2r@addtoany.com','2018-02-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ddevereu2j','xLeZo2660Eo','Devereu','809-246-1249','adevereu2j@unesco.org','2017-05-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dgeldard33','bhmhpe','Geldard','457-418-1580','egeldard33@cpanel.net','2017-05-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dgodbehere3m','hieGKTQWA6q','Godbehere','515-412-0799','agodbehere3m@wikia.com','2021-07-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dhawkex','9BhwYTkpo1','Hawke','270-982-4224','bhawkex@t-online.de','2021-04-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dison','1239dk',NULL,NULL,NULL,'2016-10-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dissacoff14','339MhX','Issacoff','747-166-0423','bissacoff14@discuz.net','2021-12-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dkidde88','SxdEF8nn3Wt','Kidde','761-257-4545','bkidde88@privacy.gov.au','2018-03-10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dkupka4e','knNbqQsVYR','Kupka','536-939-4689','rkupka4e@issuu.com','2021-12-31',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dlfadfsd','fd32',NULL,NULL,NULL,'2016-02-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dlung57','ydctkwcL31lg','Lung','969-237-0279','hlung57@miibeian.gov.cn','2019-08-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dmacgeaney3j','OxonObyz','Mac Geaney','161-434-3373','cmacgeaney3j@bloomberg.com','2021-08-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('doyoulikecoffee','123123123',NULL,NULL,NULL,'2016-09-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('drutt2d','Zm1KLX2h3e','Rutt','880-758-8153','trutt2d@wsj.com','2017-06-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('dstockman35','P3dnx8w','Stockman','312-465-1736','cstockman35@wp.com','2017-01-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('eblissitt2n','ludQeTmOeqNZ','Blissitt','939-656-5661','sblissitt2n@hp.com','2017-10-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ebrasener2o','lMFThUWxm','Brasener','884-952-4003','cbrasener2o@jalbum.net','2018-08-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ecarey9','Akpabl','Carey','288-146-3740','ccarey9@soundcloud.com','2017-06-17',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('eeeles41','DykkD9','Eeles','460-108-9549','seeles41@constantcontact.com','2017-10-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('egianettio','iWjMhnkev','Gianetti','355-544-6285','kgianettio@opera.com','2020-11-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('egoldie3y','wC8ULdA','Goldie','518-819-8516','cgoldie3y@parallels.com','2020-08-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('enotman49','tSpkelxwde0M','Notman','288-437-8975','knotman49@blog.com','2018-05-27',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('fadamovsky2q','Nns3s7b4','Adamovsky','837-286-3247','ladamovsky2q@state.gov','2021-10-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('fbrearton4g','LxLRjaUx','Brearton','986-905-2572','bbrearton4g@mail.ru','2021-12-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('fbreckwell2m','XvBlrfSrd','Breckwell','479-493-1040','abreckwell2m@tumblr.com','2021-08-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('fciccotti7','YdgZToro1g','Ciccotti','529-606-0475','cciccotti7@uiuc.edu','2017-09-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('fdikels2','qGgMPar','Dikels','615-427-6055','ldikels2@barnesandnoble.com','2018-10-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('fghione83','h16sA1P5','Ghione','426-175-5897','aghione83@answers.com','2018-07-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('flingwoodi','n1WCTw','Lingwood','784-228-7249','rlingwoodi@icio.us','2018-11-27',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('flower321','df32','dfhosk','010-3243-1231','fsfsdfsadf@gmial.com','2016-12-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gcattrell1f','Vawu1bL','Cattrell','971-686-5239','ncattrell1f@so-net.ne.jp','2018-06-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gdielhenn3c','6azsANTp','Dielhenn','204-746-4846','kdielhenn3c@hatena.ne.jp','2018-09-21',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gfolomkin1y','AujfQE4P','Folomkin','994-787-1518','tfolomkin1y@about.me','2017-04-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ghitzke6','a1Bct6O','Hitzke','691-786-0078','jhitzke6@google.it','2020-11-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('glocks1w','HUtLPdgD','Locks','917-490-5189','elocks1w@reference.com','2019-11-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gmaleck4p','lPJO4I','Maleck','564-474-5777','nmaleck4p@jalbum.net','2020-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gmozzetti4c','S8Ukdpr4bh','Mozzetti','812-157-5828','amozzetti4c@reverbnation.com','2020-06-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gotocamping','tgj5y','대혁','010-1603-4055','shallwecamping@gmail.com','2016-02-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('greedman2i','ZR5P4VYtn','Reedman','673-338-2930','areedman2i@tinyurl.com','2019-12-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('grid','fmaf23','afsd','010-0298-9232','dfjdlkf@mgial.com','2016-07-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('groom89','5rSmYn','Room','186-168-7475','sroom89@woothemes.com','2019-06-17',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gshirleyh','hvkguG','Shirley','928-829-3898','wshirleyh@uol.com.br','2017-07-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gshowers4l','NsnHxZ','Showers','704-257-6245','eshowers4l@pcworld.com','2018-02-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gsolly12','FH1yEbAVlKH','Solly','572-251-1451','dsolly12@yellowbook.com','2021-11-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('gvonasek3g','racdleN','Vonasek','557-681-4578','pvonasek3g@issuu.com','2017-07-21',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hamberger','32dlfj4','fasdf','010-2323-1282','afasdf@gmialk.com','2016-06-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hana3321','k31;l23','sdfsdfa','010-3827-2812','fsfds@gmail.com','2016-11-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hariporter','akf;asdlf1','sdfsdf','010-4383-2932','asdfasfd@gmail.com','2016-08-29',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hdellatorre1b','HjgIsWS','Dellatorre','459-134-9835','adellatorre1b@umn.edu','2021-04-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hgoodrum4o','uhqCFhsWrHSr','Goodrum','522-594-0292','dgoodrum4o@furl.net','2021-03-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hkless2z','z9hqcrb33HDf','Kless','675-339-0768','pkless2z@furl.net','2020-03-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hnunns3i','1NgNaydq','Nunns','747-777-5169','wnunns3i@blogtalkradio.com','2021-07-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hojun','fok4','fdskfsad','010-0293-2033','fklasdfja@naver.com','2016-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('htriplet56','UoG8s2MiLUQe','Triplet','224-247-2318','etriplet56@marketwatch.com','2020-01-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('hyetts3n','BesdCK9','Yetts','673-164-0148','myetts3n@marriott.com','2019-02-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('igrieve30','mqFBdl8nX','Grieve','656-415-7770','dgrieve30@ucsd.edu','2017-11-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ilovecamp','1234','Ethan','010-1111-2222','camplife@gmaiil.com','2015-02-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ilovesea','dkfjald32','Python','010-3424-1233','fkfasf!@ngdfds.com','2016-06-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ivinab','VhEJLyFt','Vina','660-744-3037','jvinab@paginegialle.it','2020-11-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('iwestwater4k','GZZZBwp5fH','Westwater','978-647-3389','rwestwater4k@jimdo.com','2017-09-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jcaliforniak','IxvqkFhP','California','310-108-7925','fcaliforniak@skyrock.com','2020-11-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jdelgardoy','nRoxPDElwqIa','Delgardo','853-730-3730','mdelgardoy@histats.com','2021-08-17',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jdrohuns','yVr4mblj','Drohun','893-704-0345','ndrohuns@friendfeed.com','2017-12-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jhallen36','0vPmfA','Hallen','960-659-9273','challen36@army.mil','2021-01-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jlawlie3b','ujal5kLl0r','Lawlie','824-100-1873','clawlie3b@house.gov','2017-04-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jleavryw','DFVy78','Leavry','219-958-4263','cleavryw@psu.edu','2020-01-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jmatusov2s','4NzgQcLyg','Matusov','367-479-3067','bmatusov2s@issuu.com','2020-02-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('joller3s','QsJAzIBRr4','Oller','640-581-8035','loller3s@163.com','2019-06-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jpeckham40','JP7yOc','Peckham','364-581-8917','jpeckham40@adobe.com','2021-01-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jpontain3h','P9blpnuLFX','Pontain','968-979-6340','dpontain3h@wordpress.org','2019-07-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jride44','8oQ23tM','Ride','904-238-9433','gride44@cloudflare.com','2018-05-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('jseeman31','0v2akNTfLtB','Seeman','238-739-8998','sseeman31@edublogs.org','2021-12-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('juhyun','1324','이호식','010-8756-7438','dlghtlr@dlghtlr.com','2015-11-30',NULL,NULL,NULL,'','','','test'),('kbaynom4n','dCBRPNG99G6f','Baynom','430-902-1778','gbaynom4n@virginia.edu','2021-05-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kbemand3q','djlq1QARjSJ','Bemand','550-445-8626','lbemand3q@cmu.edu','2020-09-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kciccotti3k','YvwAW6rL','Ciccotti','393-454-6230','tciccotti3k@dmoz.org','2018-12-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kcroydon2e','mZvvZT2xV','Croydon','362-470-4228','dcroydon2e@webs.com','2021-07-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kevininthewood','9999','Kevin','010-1234-5678','kevincamp@gmail.com','2015-03-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kfitzroy43','MqjpgdyPIoIM','Fitzroy','831-949-1470','mfitzroy43@flickr.com','2021-11-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kitty','fjaskdfl5','flsadfl;','010-2093-0382','sdkfjskf@nave.rcom','2016-10-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('kkenen39','bqMDXk7FVY','Kenen','704-388-9680','mkenen39@cornell.edu','2021-05-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ksacase42','QqHfg2H9M0','Sacase','697-651-5808','dsacase42@myspace.com','2020-08-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('latheis4a','s7xLgJQPY','Atheis','493-186-1170','katheis4a@facebook.com','2020-03-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('lcresser23','sXcceOf5','Cresser','936-247-4242','wcresser23@washington.edu','2021-03-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('lelms47','p0pDe8qMzow7','Elms','729-545-2373','felms47@paypal.com','2019-02-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('lfibbens4y','jIBmdfZx5jP','Fibbens','185-373-7016','vfibbens4y@list-manage.com','2018-02-27',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('lgoundrill4m','aYGmecPLKki','Goundrill','340-153-6430','cgoundrill4m@geocities.jp','2020-02-28',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('lmatlock0','QRWr8CucmYA','Matlock','143-562-3799','mmatlock0@google.fr','2020-01-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('loveorange','24edf','서진','010-1275-2319','ateorange@naver.com','2016-02-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('lthuillier3f','fA0ZLSjN2u','Thuillier','217-452-6712','kthuillier3f@msn.com','2021-01-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mbasley84','RwTZTZ3a','Basley','971-598-2482','obasley84@tiny.cc','2019-02-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mbebbingtone','HcinA8CbcAFh','Bebbington','843-299-4395','cbebbingtone@timesonline.co.uk','2019-06-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mbursnollc','V1uSr9bVM24','Bursnoll','732-175-0462','bbursnollc@eventbrite.com','2018-08-30',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mdewsbury2p','2Tul0qt9','Dewsbury','998-964-4106','edewsbury2p@1und1.de','2021-08-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mgarthland16','M3atdxS9kjO','Garthland','970-615-5933','bgarthland16@chron.com','2017-03-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mgaul27','hs8jOERW5','Gaul','126-193-4726','ngaul27@prweb.com','2017-08-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mgoldsack3x','MUvRdKR1B','Goldsack','979-997-9691','wgoldsack3x@smugmug.com','2021-12-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mgrinston18','rQlH7FAN1j','Grinston','564-433-6826','dgrinston18@theglobeandmail.com','2020-01-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mina','fdfd2ee','미나','010-1232-6735','lovemina@daum.net','2016-01-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mineboom','123htg','boom','010-3232-3154','kdlfjs@naver.com','2016-05-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('minksterd','K1TNgm8XY8A','Inkster','652-731-1628','rinksterd@sakura.ne.jp','2021-04-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mjakubovsky46','2nqz2bo','Jakubovsky','440-996-1299','sjakubovsky46@mtv.com','2019-09-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mnaton3r','9vqXFMQ','Naton','811-164-9745','bnaton3r@rakuten.co.jp','2020-08-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mouse','asdf,323','mouse','010-2323-5454','kfsdfksdf@nadfksdf.com','2016-10-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mrijkeseis1a','PNzlKKw','Rijkeseis','291-418-4684','krijkeseis1a@google.it','2018-09-27',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('mtalks10','LKO1UOvs1I4','Talks','441-507-8290','atalks10@hao123.com','2017-10-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('nduesberrym','LdownwOxJz','Duesberry','138-235-9122','bduesberrym@yellowbook.com','2020-12-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('nhubery3d','9SuCWZZQ','Hubery','209-496-3924','khubery3d@chronoengine.com','2020-12-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('njorck2f','kzl9XFKm9Qq9','Jorck','806-820-1379','cjorck2f@gov.uk','2019-07-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('nmedley50','ENorAwsCa','Medley','575-651-9995','dmedley50@nsw.gov.au','2017-07-03',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('obeddin48','lh31tcg','Beddin','446-553-0378','wbeddin48@dell.com','2020-02-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ohessr','ff72Ht','Hess','276-517-8590','ahessr@hhs.gov','2018-02-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('orogge3e','k4W8r1JC','Rogge','836-244-1946','arogge3e@blog.com','2019-11-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('otrottz','yNQ2r3','Trott','720-434-6283','btrottz@google.nl','2019-04-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('parrundale1g','L0Zn1c','Arrundale','789-285-5136','larrundale1g@ft.com','2017-11-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('pellerington2h','cZqLdks','Ellerington','743-590-5376','nellerington2h@google.co.uk','2018-11-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('pisal','5678','홍피살','010-3333-4444','pisal@naver.com','2015-06-02','2022-11-10',NULL,NULL,NULL,NULL,NULL,NULL),('pmckeowon1i','FuZ8Kq46H','McKeowon','906-607-8765','cmckeowon1i@who.int','2020-03-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('posttomom','adfmalsfmd32','pskfmaom','010-1232-3231','jfkslf@naver.com','2016-08-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('python','dfdf23','pyhotn','010-2345-6454','jfksdjf@gmai.com','2016-03-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('q1w2e3','dfwd113','dlfkd','010-5934-1342','jfksljf@idfmdk.com','2016-02-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rcockcroft3v','dG4EgKX','Cockcroft','468-453-3014','icockcroft3v@yellowpages.com','2020-02-14',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rdinan2g','30hKGB','Dinan','448-973-6175','bdinan2g@imdb.com','2020-08-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('readbook','fdjkalf3','f3dsa','010-1231-1232','kfjksdfj@naver.com','2016-08-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rfellnee85','5zIYtqGv','Fellnee','384-277-8155','ffellnee85@cdbaby.com','2018-02-21',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rfitzalan53','6U8K4KCTLf','FitzAlan','693-127-1124','ffitzalan53@google.de','2017-11-10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rgillimgham3a','SoIczA','Gillimgham','431-359-5643','jgillimgham3a@unesco.org','2018-12-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rgreenham8a','afNJmP','Greenham','828-800-3067','bgreenham8a@furl.net','2017-05-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rmerryweather51','I4VN2fx','Merryweather','659-951-7594','gmerryweather51@baidu.com','2021-04-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rsnoding24','DbgG4c577','Snoding','670-134-0043','msnoding24@wikia.com','2019-04-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('rtravers3w','7DbB4SA2gFjq','Travers','602-492-7160','etravers3w@freewebs.com','2021-03-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sanfossi4b','tzWDjiXBl','Anfossi','315-124-8302','sanfossi4b@studiopress.com','2018-06-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sanghyuk','a321s','상혁','010-5453-2332','sanghyuk332@naver.com','2016-01-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sbernaciakv','pLrlvsNjLb9','Bernaciak','196-339-3840','cbernaciakv@youtu.be','2020-01-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('scannl','HxamYwCx','Cann','244-322-0207','hcannl@homestead.com','2019-07-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('schieco3u','IVP5Z5I0','Chieco','428-723-8744','gchieco3u@redcross.org','2021-02-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sdreger4x','1CYlTqg1uQLE','Dreger','261-810-6428','tdreger4x@jimdo.com','2021-08-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sgoodwillj','hpX1ESYAg','Goodwill','169-537-8659','sgoodwillj@wunderground.com','2018-03-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('slaurie3p','8Pvz2CYb','Laurie','550-151-9472','klaurie3p@theatlantic.com','2017-10-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sorritt4q','qchnQOA','Orritt','550-373-9253','horritt4q@businessweek.com','2020-06-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('sratnage1h','JZly7r4Zv','Ratnage','364-523-2500','wratnage1h@cam.ac.uk','2021-08-24',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ssallier1z','vBT6eOhom','Sallier','991-619-3535','hsallier1z@nature.com','2021-11-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('szappel1k','xUVb2H','Zappel','597-963-7462','nzappel1k@techcrunch.com','2021-02-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tcoldham5','TIaj5V','Coldham','594-827-1426','mcoldham5@xrea.com','2018-08-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tcorston3z','Blo64PPHE','Corston','531-857-8732','scorston3z@odnoklassniki.ru','2021-05-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tdevorill20','TlQK0lV4d','Devorill','147-960-5379','cdevorill20@free.fr','2021-04-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tdowrey3','AZMVgrOZwsZ','Dowrey','524-865-1895','bdowrey3@gnu.org','2017-02-19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('test','11111','이호식','010-1111-1111','dlghtlr@dlghtlr.com','2015-01-23',NULL,NULL,NULL,'','','','test'),('tjdgur','dkfldj','성준','010-1234-1234','fkj4jkfd@yahoo.com','2016-05-29',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tlainton2c','aclcSNnw4','Lainton','525-588-8802','elainton2c@oakley.com','2019-11-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('treiling2x','751A6giwJ','Reiling','677-716-7794','areiling2x@bloglovin.com','2019-04-13',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('trowlson2y','ORLqvq','Rowlson','993-557-5626','jrowlson2y@creativecommons.org','2017-02-23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tspaxman3l','vXFD7qToE5','Spaxman','701-678-6833','cspaxman3l@cdbaby.com','2021-09-17',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tsugden86','P5xh3oMT','Sugden','280-733-5741','rsugden86@youtu.be','2020-01-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('tvigurs55','aT26LfFz','Vigurs','609-536-0628','gvigurs55@unc.edu','2018-08-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('vmeasures87','l54UclPyY6','Measures','248-393-9521','smeasures87@mtv.com','2020-08-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('vprichet4f','AqqFQmlH','Prichet','322-703-6636','cprichet4f@pagesperso-orange.fr','2017-12-15',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('wackroydq','vFcv88s0P','Ackroyd','628-365-6532','mackroydq@ox.ac.uk','2019-05-27',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('wchilcottp','f4WKCj1z','Chilcott','928-771-4451','achilcottp@example.com','2018-06-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('wjellemant','jTVGCq','Jelleman','237-329-5808','wjellemant@sitemeter.com','2020-11-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('wknappitt26','tNHCnqw','Knappitt','147-213-4856','pknappitt26@mapquest.com','2017-11-11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('woneile4j','ZJnMfTG','Oneile','374-344-8076','eoneile4j@gov.uk','2017-05-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('xhammerstone4i','I0aiIvTM7','Hammerstone','992-845-3125','mhammerstone4i@nps.gov','2019-02-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('yejin','1111','예진','010-1209-0353','yejin@gmail.com','2015-09-02','2022-11-13',NULL,NULL,'1111','3','3','3'),('zlavender52','uMxt3hayqUbf','Lavender','650-550-6054','klavender52@privacy.gov.au','2020-07-25',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility` (
  `fIndex` int NOT NULL AUTO_INCREMENT,
  `fName` varchar(45) NOT NULL,
  `regcamp_regSeq` int NOT NULL,
  `regcamp_host_hSeq` int NOT NULL,
  PRIMARY KEY (`fIndex`,`regcamp_regSeq`,`regcamp_host_hSeq`),
  UNIQUE KEY `fSeq_UNIQUE` (`fIndex`),
  KEY `fk_facility_regcamp1_idx` (`regcamp_regSeq`,`regcamp_host_hSeq`),
  CONSTRAINT `fk_facility_regcamp1` FOREIGN KEY (`regcamp_regSeq`, `regcamp_host_hSeq`) REFERENCES `regcamp` (`regSeq`, `host_hSeq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host`
--

DROP TABLE IF EXISTS `host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `host` (
  `hSeq` int NOT NULL AUTO_INCREMENT,
  `hId` varchar(20) NOT NULL,
  `hDate` date NOT NULL,
  `hMdate` date DEFAULT NULL,
  `hDdate` date DEFAULT NULL,
  `hSummary` text,
  `hImage` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`hSeq`),
  UNIQUE KEY `hSeq_UNIQUE` (`hSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES (1,'ilovecamp','2018-03-21',NULL,NULL,'캠핑장주인',NULL),(7,'bootcamp','2019-09-08',NULL,NULL,'IT취업은 부트캠프! 부트캠프에서 꿈을 이루세요!',NULL),(8,'No1camp','2018-04-20',NULL,NULL,'국내 넘버원을 넘어 온리원으로!',NULL),(9,'BestCamp','2019-12-29',NULL,NULL,'최고의 캠핑장은 바로 여기! 베스트캠프에서 꿈과 희망을!',NULL),(10,'hansungcamp','2020-02-12',NULL,NULL,'한성그룹의 캠핑장 입니다',NULL),(11,'samsungcamp','2020-02-28',NULL,NULL,'삼성그룹 캠핑장 입니다',NULL),(12,'lgcamp','2020-03-12',NULL,NULL,'엘지그룹 캠핑장 입니다',NULL),(13,'gmhocamp','2020-03-29',NULL,NULL,'금호그룹 캠핑장 입니다',NULL),(14,'starbuckcamp','2020-04-01',NULL,NULL,'스타벅스 캠핑장 입니다',NULL),(15,'coffeebeancamp','2020-04-30',NULL,NULL,'커피빈 캠핑장 입니다',NULL),(16,'yanggucamp','2020-05-19',NULL,NULL,'',NULL),(17,'gwangjucamp','2020-05-23',NULL,NULL,'',NULL),(18,'seoulcamp','2020-06-22',NULL,NULL,'',NULL),(19,'yangyangcamp','2020-06-30',NULL,NULL,'',NULL),(20,'sokchocamp','2020-07-04',NULL,NULL,'',NULL),(21,'dajeoncamp','2020-07-12',NULL,NULL,'',NULL),(22,'sunchuncamp','2020-07-28',NULL,NULL,'',NULL),(23,'gwangyangcamp','2020-09-04',NULL,NULL,'',NULL),(24,'incheoncamp','2021-02-12',NULL,NULL,'',NULL),(25,'dabudocamp','2021-02-28',NULL,NULL,'',NULL),(26,'kyunggicamp','2021-04-21',NULL,NULL,'123',NULL),(27,'gwangwoncamp','2021-05-30',NULL,NULL,'',NULL),(28,'wolsancamp','2021-08-19',NULL,NULL,'',NULL),(29,'test19','2022-04-14',NULL,NULL,'test1',NULL),(30,'test20','2022-11-14',NULL,NULL,'123',NULL),(31,'test','2022-11-15',NULL,NULL,'안녕하세요\r\n초보 캠핑장 주인 입니다\r\n잘부탁 드려요 ^^*',NULL);
/*!40000 ALTER TABLE `host` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyword`
--

DROP TABLE IF EXISTS `keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keyword` (
  `kIndex` int NOT NULL AUTO_INCREMENT,
  `kName` varchar(20) NOT NULL,
  `regcamp_regSeq` int NOT NULL,
  `regcamp_host_hSeq` int NOT NULL,
  PRIMARY KEY (`kIndex`,`regcamp_regSeq`,`regcamp_host_hSeq`),
  UNIQUE KEY `kIndex_UNIQUE` (`kIndex`),
  KEY `fk_keyword_regcamp1_idx` (`regcamp_regSeq`,`regcamp_host_hSeq`),
  CONSTRAINT `fk_keyword_regcamp1` FOREIGN KEY (`regcamp_regSeq`, `regcamp_host_hSeq`) REFERENCES `regcamp` (`regSeq`, `host_hSeq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyword`
--

LOCK TABLES `keyword` WRITE;
/*!40000 ALTER TABLE `keyword` DISABLE KEYS */;
/*!40000 ALTER TABLE `keyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `pagecount`
--

DROP TABLE IF EXISTS `pagecount`;
/*!50001 DROP VIEW IF EXISTS `pagecount`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pagecount` AS SELECT 
 1 AS `count(*)`,
 1 AS `pay_room_regcamp_host_hSeq`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pay`
--

DROP TABLE IF EXISTS `pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay` (
  `cid` varchar(20) NOT NULL,
  `partner_order_id` int DEFAULT NULL,
  `partner_user_id` varchar(20) DEFAULT NULL,
  `item_name` varchar(20) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `total_amount` int DEFAULT NULL,
  `tax_free_amount` int DEFAULT NULL,
  `room_roSeq` int NOT NULL,
  `room_regcamp_regSeq` int NOT NULL,
  `room_regcamp_host_hSeq` int NOT NULL,
  `client_cId` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`,`room_roSeq`,`room_regcamp_regSeq`,`room_regcamp_host_hSeq`,`client_cId`),
  KEY `fk_pay_room1_idx` (`room_roSeq`,`room_regcamp_regSeq`,`room_regcamp_host_hSeq`),
  KEY `fk_pay_client1_idx` (`client_cId`),
  CONSTRAINT `fk_pay_client1` FOREIGN KEY (`client_cId`) REFERENCES `client` (`cId`),
  CONSTRAINT `fk_pay_room1` FOREIGN KEY (`room_roSeq`, `room_regcamp_regSeq`, `room_regcamp_host_hSeq`) REFERENCES `room` (`roSeq`, `regcamp_regSeq`, `regcamp_host_hSeq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay`
--

LOCK TABLES `pay` WRITE;
/*!40000 ALTER TABLE `pay` DISABLE KEYS */;
INSERT INTO `pay` VALUES ('AKX9test11',NULL,NULL,NULL,NULL,NULL,NULL,9,1,1,'test'),('ARQ8pisal11',NULL,NULL,NULL,NULL,NULL,NULL,8,1,1,'pisal'),('as',NULL,NULL,NULL,1,80000,NULL,13,1,1,'kevininthewood'),('asd',NULL,NULL,NULL,1,80000,NULL,13,1,1,'kevininthewood'),('asdf',NULL,NULL,NULL,1,80000,NULL,13,1,1,'kevininthewood'),('asdfg',NULL,NULL,NULL,1,230000,NULL,13,1,1,'test'),('CSQ41test27',NULL,NULL,NULL,NULL,NULL,NULL,41,2,7,'test'),('d',NULL,NULL,NULL,1,80000,NULL,13,1,1,'pisal'),('DWN11test11',NULL,NULL,NULL,NULL,NULL,NULL,11,1,1,'test'),('e',NULL,NULL,NULL,1,200000,NULL,12,1,1,'pisal'),('er',NULL,NULL,NULL,1,80000,NULL,13,1,1,'kevininthewood'),('f',NULL,NULL,NULL,1,80000,NULL,13,1,1,'pisal'),('FVK8test11',NULL,NULL,NULL,NULL,NULL,NULL,8,1,1,'test'),('FYU10test11',NULL,NULL,NULL,NULL,NULL,NULL,10,1,1,'test'),('GKB9test11',NULL,NULL,NULL,NULL,NULL,NULL,9,1,1,'test'),('GWP53test38',NULL,NULL,NULL,NULL,NULL,NULL,53,3,8,'test'),('JXL8test11',NULL,NULL,NULL,NULL,NULL,NULL,8,1,1,'test'),('KXI14test27',NULL,NULL,NULL,NULL,NULL,NULL,14,2,7,'test'),('LDE10pisal11',NULL,NULL,NULL,NULL,NULL,NULL,10,1,1,'pisal'),('LWE9test11',NULL,NULL,NULL,NULL,NULL,NULL,9,1,1,'test'),('OPD8test11',NULL,NULL,NULL,NULL,NULL,NULL,8,1,1,'test'),('PCU8test11',NULL,NULL,NULL,NULL,NULL,NULL,8,1,1,'test'),('PEW8test11',NULL,NULL,NULL,NULL,NULL,NULL,8,1,1,'test'),('qw',NULL,NULL,NULL,1,80000,NULL,13,1,1,'kevininthewood'),('UNV9test11',NULL,NULL,NULL,NULL,NULL,NULL,9,1,1,'test'),('URD82test169',NULL,NULL,NULL,NULL,NULL,NULL,82,16,9,'test'),('we',NULL,NULL,NULL,1,80000,NULL,13,1,1,'kevininthewood'),('WMB101test169',NULL,NULL,NULL,NULL,NULL,NULL,101,16,9,'test'),('WOD12test11',NULL,NULL,NULL,NULL,NULL,NULL,12,1,1,'test'),('XEC11test11',NULL,NULL,NULL,NULL,NULL,NULL,11,1,1,'test'),('XLQ39test27',NULL,NULL,NULL,NULL,NULL,NULL,39,2,7,'test'),('YGO41test27',NULL,NULL,NULL,NULL,NULL,NULL,41,2,7,'test');
/*!40000 ALTER TABLE `pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcomment`
--

DROP TABLE IF EXISTS `pcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pcomment` (
  `pcSeq` int NOT NULL AUTO_INCREMENT,
  `pcTitle` varchar(20) NOT NULL,
  `pcContent` text NOT NULL,
  `pcTime` datetime NOT NULL,
  `pcMtime` datetime DEFAULT NULL,
  `pcDtime` datetime DEFAULT NULL,
  `pcLevel` int NOT NULL,
  `pcGroup` int NOT NULL,
  `client_cId` varchar(20) NOT NULL,
  `post_poSeq` int NOT NULL,
  PRIMARY KEY (`pcSeq`,`client_cId`,`post_poSeq`),
  UNIQUE KEY `pcSeq_UNIQUE` (`pcSeq`),
  KEY `fk_pcomment_client_idx` (`client_cId`),
  KEY `fk_pcomment_post1_idx` (`post_poSeq`),
  CONSTRAINT `fk_pcomment_client` FOREIGN KEY (`client_cId`) REFERENCES `client` (`cId`),
  CONSTRAINT `fk_pcomment_post1` FOREIGN KEY (`post_poSeq`) REFERENCES `post` (`poSeq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcomment`
--

LOCK TABLES `pcomment` WRITE;
/*!40000 ALTER TABLE `pcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `poSeq` int NOT NULL AUTO_INCREMENT,
  `poCId` varchar(20) NOT NULL,
  `poContent` text NOT NULL,
  `poTime` datetime NOT NULL,
  `poMtime` datetime DEFAULT NULL,
  `poDtime` datetime DEFAULT NULL,
  PRIMARY KEY (`poSeq`),
  UNIQUE KEY `poSeq_UNIQUE` (`poSeq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `prch`
--

DROP TABLE IF EXISTS `prch`;
/*!50001 DROP VIEW IF EXISTS `prch`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prch` AS SELECT 
 1 AS `cid`,
 1 AS `partner_order_id`,
 1 AS `partner_user_id`,
 1 AS `item_name`,
 1 AS `quantity`,
 1 AS `total_amount`,
 1 AS `tax_free_amount`,
 1 AS `room_roSeq`,
 1 AS `room_regcamp_regSeq`,
 1 AS `room_regcamp_host_hSeq`,
 1 AS `client_cId`,
 1 AS `roSeq`,
 1 AS `roNum`,
 1 AS `roPrice`,
 1 AS `roMax`,
 1 AS `roOccupied`,
 1 AS `roDate`,
 1 AS `roMdate`,
 1 AS `roDdate`,
 1 AS `regcamp_regSeq`,
 1 AS `regcamp_host_hSeq`,
 1 AS `regSeq`,
 1 AS `regTel`,
 1 AS `regCategory`,
 1 AS `regDetailaddress`,
 1 AS `regName`,
 1 AS `regDate`,
 1 AS `regMdate`,
 1 AS `regDdate`,
 1 AS `regSummary`,
 1 AS `regImage1`,
 1 AS `regImage2`,
 1 AS `regImage3`,
 1 AS `regImage4`,
 1 AS `host_hSeq`,
 1 AS `hSeq`,
 1 AS `hId`,
 1 AS `hDate`,
 1 AS `hMdate`,
 1 AS `hDdate`,
 1 AS `hSummary`,
 1 AS `hImage`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `rb_outtable`
--

DROP TABLE IF EXISTS `rb_outtable`;
/*!50001 DROP VIEW IF EXISTS `rb_outtable`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `rb_outtable` AS SELECT 
 1 AS `roSeq`,
 1 AS `roNum`,
 1 AS `roPrice`,
 1 AS `roMax`,
 1 AS `roOccupied`,
 1 AS `roDate`,
 1 AS `roMdate`,
 1 AS `roDdate`,
 1 AS `regcamp_regSeq`,
 1 AS `regcamp_host_hSeq`,
 1 AS `boSeq`,
 1 AS `boPrice`,
 1 AS `boDate`,
 1 AS `boCheckindate`,
 1 AS `boGroup`,
 1 AS `boCount`,
 1 AS `boCanceldate`,
 1 AS `pay_cid`,
 1 AS `pay_room_roSeq`,
 1 AS `pay_room_regcamp_regSeq`,
 1 AS `pay_room_regcamp_host_hSeq`,
 1 AS `pay_client_cId`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `rch`
--

DROP TABLE IF EXISTS `rch`;
/*!50001 DROP VIEW IF EXISTS `rch`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `rch` AS SELECT 
 1 AS `roSeq`,
 1 AS `roNum`,
 1 AS `roPrice`,
 1 AS `roMax`,
 1 AS `roOccupied`,
 1 AS `roDate`,
 1 AS `roMdate`,
 1 AS `roDdate`,
 1 AS `regcamp_regSeq`,
 1 AS `regcamp_host_hSeq`,
 1 AS `regSeq`,
 1 AS `regTel`,
 1 AS `regCategory`,
 1 AS `regDetailaddress`,
 1 AS `regName`,
 1 AS `regDate`,
 1 AS `regMdate`,
 1 AS `regDdate`,
 1 AS `regSummary`,
 1 AS `regImage1`,
 1 AS `regImage2`,
 1 AS `regImage3`,
 1 AS `regImage4`,
 1 AS `host_hSeq`,
 1 AS `hSeq`,
 1 AS `hId`,
 1 AS `hDate`,
 1 AS `hMdate`,
 1 AS `hDdate`,
 1 AS `hSummary`,
 1 AS `hImage`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `rcomment`
--

DROP TABLE IF EXISTS `rcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rcomment` (
  `rcSeq` int NOT NULL AUTO_INCREMENT,
  `rcContent` text NOT NULL,
  `rcTime` datetime NOT NULL,
  `rcMtime` datetime DEFAULT NULL,
  `rcDtime` datetime DEFAULT NULL,
  `rcLevel` int NOT NULL DEFAULT '0',
  `rcGroup` int DEFAULT NULL,
  `client_cId` varchar(20) NOT NULL,
  `review_rvSeq` int NOT NULL,
  `review_regcamp_regSeq` int NOT NULL,
  `review_regcamp_host_hSeq` int NOT NULL,
  PRIMARY KEY (`rcSeq`,`client_cId`,`review_rvSeq`,`review_regcamp_regSeq`,`review_regcamp_host_hSeq`),
  UNIQUE KEY `rcSeq_UNIQUE` (`rcSeq`),
  KEY `fk_rcomment_client1_idx` (`client_cId`),
  KEY `fk_rcomment_review1_idx` (`review_rvSeq`,`review_regcamp_regSeq`,`review_regcamp_host_hSeq`),
  CONSTRAINT `fk_rcomment_client1` FOREIGN KEY (`client_cId`) REFERENCES `client` (`cId`),
  CONSTRAINT `fk_rcomment_review1` FOREIGN KEY (`review_rvSeq`, `review_regcamp_regSeq`, `review_regcamp_host_hSeq`) REFERENCES `review` (`rvSeq`, `regcamp_regSeq`, `regcamp_host_hSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rcomment`
--

LOCK TABLES `rcomment` WRITE;
/*!40000 ALTER TABLE `rcomment` DISABLE KEYS */;
INSERT INTO `rcomment` VALUES (2,'ㄳㄳ','2022-11-07 16:24:57',NULL,NULL,0,2,'pisal',1,1,1),(11,'thx~','2022-11-07 17:09:33',NULL,NULL,0,11,'kevininthewood',2,1,1),(12,'ㄳㄳㄳㄳ','2022-11-07 18:15:39',NULL,NULL,0,12,'pisal',1,1,1),(14,'감사합니다 더욱더 청결하고 친절하게 운영하겠습니다 다음에 또 오세요 ^^','2022-11-10 15:08:17',NULL,NULL,0,14,'pisal',1,1,1),(15,'감사합니다 더욱더 청결하고 친절하게 운영하겠습니다 다음에 또 오세요 ^^','2022-11-10 15:10:27',NULL,NULL,0,15,'pisal',1,1,1),(16,'1\r\n','2022-11-10 15:10:48',NULL,NULL,0,16,'pisal',1,1,1),(17,'1\r\n','2022-11-10 15:10:49',NULL,NULL,0,17,'pisal',1,1,1),(18,'1\r\n','2022-11-10 15:10:50',NULL,NULL,0,18,'pisal',1,1,1),(19,'1\r\n','2022-11-10 15:10:51',NULL,NULL,0,19,'pisal',1,1,1),(20,'1\r\n','2022-11-10 15:10:52',NULL,NULL,0,20,'pisal',1,1,1),(21,'1\r\n','2022-11-10 15:10:53',NULL,NULL,0,21,'pisal',1,1,1),(22,'','2022-11-10 15:11:15',NULL,NULL,0,22,'pisal',1,1,1);
/*!40000 ALTER TABLE `rcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regcamp`
--

DROP TABLE IF EXISTS `regcamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regcamp` (
  `regSeq` int NOT NULL AUTO_INCREMENT,
  `regTel` varchar(20) DEFAULT NULL,
  `regCategory` varchar(45) NOT NULL,
  `regDetailaddress` varchar(45) NOT NULL,
  `regName` varchar(20) NOT NULL,
  `regDate` date NOT NULL,
  `regMdate` date DEFAULT NULL,
  `regDdate` date DEFAULT NULL,
  `regSummary` text,
  `regImage1` varchar(100) DEFAULT 'defaultimage.png',
  `regImage2` varchar(100) DEFAULT 'defaultimage.png',
  `regImage3` varchar(100) DEFAULT 'defaultimage.png',
  `regImage4` varchar(100) DEFAULT 'defaultimage.png',
  `host_hSeq` int NOT NULL,
  PRIMARY KEY (`regSeq`,`host_hSeq`),
  UNIQUE KEY `reSeq_UNIQUE` (`regSeq`),
  KEY `fk_regcamp_host1_idx` (`host_hSeq`),
  CONSTRAINT `fk_regcamp_host1` FOREIGN KEY (`host_hSeq`) REFERENCES `host` (`hSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regcamp`
--

LOCK TABLES `regcamp` WRITE;
/*!40000 ALTER TABLE `regcamp` DISABLE KEYS */;
INSERT INTO `regcamp` VALUES (1,'02-123-4567','깔끔','인천광역시 강화군 화도면 해안남로 1484','강화 캠핑장','2021-05-05',NULL,NULL,'강화 캠핑장 입니다','a.jpg','c.jpg','e.jpg','1.png',1),(2,'031-111-2222','안락','충남 당진시 석문면 난지도리 650','난지 캠핑장','2022-01-01',NULL,NULL,'난지도 유일 캠핑장! 저희 난지캠핑장은 충남 난지도의 유일무이한 캠핑장으로 사람의 손길이 별로 닿지 않은 국내 청정지역의 섬에서 자연의 맑은 공기와 시원한 바닷바람을 맞으며 캠핑을 즐길 수 있는 곳입니다. 도비도항을 통해서 소난지항에서 오시거나 난지도항으로 오시면 여러분들을 기다리고 있는 난지캠핑장이 있습니다. 와서 행복하고 좋은 추억 쌓아가세요','b.jpg','d.jpg','f.jpg','2.jpeg',7),(3,'02-123-4567','깔끔','강원도 속초','부트캠핑장','2021-05-05',NULL,NULL,'속초캠핑장입니다','g.png','h.jpg','i.jpeg','3.jpg',8),(16,'010-8756-7438','편~안','강원 속초시 울산바위길 9-17 1층','호식스캠프','2022-11-04',NULL,NULL,'호식스 캠핑장에 오신것을 환영합니다 ','n.jpeg','a.jpg','j.jpeg','4.jpeg',9),(17,'010-3231-1232','쇼킹','경북 울릉군 울릉읍 사동리 62-3','원피스캠프','1995-12-23',NULL,NULL,'신세계에서 찾아봐라','o.jpeg','b.jpg','k.jpeg','5.jpeg',11),(18,'101-1332-1232','놀러와~','전북 군산시 회현면 월연리 150-1','에브리바디컴온요캠프','2018-02-27',NULL,NULL,'아무나 와서 놀다 가세요~','p.png','k.jpeg','l.jpeg','6.jpeg',10),(19,'02-3122-3243','도심, 편의시설','서울 동작구 동작동 316-1','한강No.1 Camping','2017-04-21',NULL,NULL,'한강 최고의 캠핑장 입니다. 남녀노소 누구나 편하게 즐기다 가십쇼','n.jpeg','c.jpg','m.jpeg','7.jpeg',12),(20,'912-3231-2121','주택','주소 글씨가 깨져서 수동으로 db 교체','캠핑테스트1','2022-11-14',NULL,NULL,'캠핑테스트1','j.jpeg','https://ddooddoo.com/images/games/spacing/intro.png','https://ddooddoo.com/images/games/spacing/intro.png','defaultimage.png',13),(21,'123','주택','주소 글씨가 깨져서 수동으로 db 교체','캠핑테스트2','2022-11-14',NULL,NULL,'캠핑테스트2','b.jpg','defaultimage.png','defaultimage.png','defaultimage.png',14),(22,'123','별채','글씨 꺠짐 ㅠㅠ','캠핑테스트3','2022-11-14',NULL,NULL,'캠핑테스트3','m.jpeg','defaultimage.png','defaultimage.png','defaultimage.png',15),(23,'test계정 캠핑장','독특한 숙소','test계정 캠핑장','test계정 캠핑장','2022-11-15',NULL,NULL,'ㅅㄷㄴㅅ','defaultimage.png','defaultimage.png','defaultimage.png','defaultimage.png',31);
/*!40000 ALTER TABLE `regcamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `rvSeq` int NOT NULL AUTO_INCREMENT,
  `rvCId` varchar(20) NOT NULL,
  `rvCName` varchar(20) NOT NULL,
  `rvTitle` varchar(20) NOT NULL,
  `rvContent` text NOT NULL,
  `rvStar` int NOT NULL,
  `rvTime` datetime NOT NULL,
  `rvMtime` datetime DEFAULT NULL,
  `rvDtime` datetime DEFAULT NULL,
  `regcamp_regSeq` int NOT NULL,
  `regcamp_host_hSeq` int NOT NULL,
  PRIMARY KEY (`rvSeq`,`regcamp_regSeq`,`regcamp_host_hSeq`),
  UNIQUE KEY `rvSeq_UNIQUE` (`rvSeq`),
  KEY `fk_review_regcamp1_idx` (`regcamp_regSeq`,`regcamp_host_hSeq`),
  CONSTRAINT `fk_review_regcamp1` FOREIGN KEY (`regcamp_regSeq`, `regcamp_host_hSeq`) REFERENCES `regcamp` (`regSeq`, `host_hSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'pisal','홍피살','잘놀다가요','시설이 깔끔하고 사장님이 친절해요',5,'2021-08-07 00:00:00',NULL,NULL,1,1),(2,'kevininthewood','Kevin','Enjoyed it','facility was perfect',5,'2020-05-05 00:00:00',NULL,NULL,1,1),(3,'test','1234','123','123',3,'2022-11-13 13:22:07',NULL,NULL,3,1),(4,'test','1234','123','123',3,'2022-11-13 13:26:26',NULL,NULL,3,1),(5,'pisal','d','123','123',3,'2022-11-14 01:12:14',NULL,NULL,1,1),(6,'pisal','홍피살','부트캠핑장 후기요~','아따 좋구먼~',5,'2022-11-14 01:12:42',NULL,NULL,3,1),(7,'pisal','홍피살','한강No.1 Camping 후기','국숛',5,'2022-11-14 01:13:15',NULL,NULL,19,7),(8,'pisal','홍피살','후기테스트요~','~',5,'2022-11-14 01:20:38',NULL,NULL,18,10),(9,'pisal','홍피살','ㅅㄷㄴㅅ','ㅅㄷㄴㅅ',4,'2022-11-14 01:23:24',NULL,NULL,1,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `roSeq` int NOT NULL AUTO_INCREMENT,
  `roNum` int NOT NULL,
  `roPrice` int NOT NULL,
  `roMax` int NOT NULL,
  `roOccupied` int NOT NULL DEFAULT '0',
  `roDate` date DEFAULT NULL,
  `roMdate` date DEFAULT NULL,
  `roDdate` date DEFAULT NULL,
  `regcamp_regSeq` int NOT NULL,
  `regcamp_host_hSeq` int NOT NULL,
  PRIMARY KEY (`roSeq`,`regcamp_regSeq`,`regcamp_host_hSeq`),
  KEY `fk_room_regcamp1_idx` (`regcamp_regSeq`,`regcamp_host_hSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (8,1,150000,4,0,'2022-11-08',NULL,NULL,1,1),(9,2,150000,4,0,'2022-11-08',NULL,NULL,1,1),(10,3,150000,4,0,'2022-11-08',NULL,NULL,1,1),(11,4,150000,4,0,'2022-11-08',NULL,NULL,1,1),(12,5,200000,4,0,'2022-11-08',NULL,NULL,1,1),(13,6,80000,2,0,'2022-11-08',NULL,NULL,1,1),(14,1,150000,4,0,'2022-11-09',NULL,NULL,2,7),(15,2,150000,4,0,'2022-11-09',NULL,NULL,2,7),(16,3,150000,4,0,'2022-11-09',NULL,NULL,2,7),(17,4,150000,4,0,'2022-11-09',NULL,NULL,2,7),(18,5,150000,4,0,'2022-11-09',NULL,NULL,2,7),(19,6,150000,4,0,'2022-11-09',NULL,NULL,2,7),(20,7,150000,4,0,'2022-11-09',NULL,NULL,2,7),(21,8,200000,6,0,'2022-11-09',NULL,NULL,2,7),(22,9,200000,6,0,'2022-11-09',NULL,NULL,2,7),(23,10,200000,6,0,'2022-11-09',NULL,NULL,2,7),(24,11,200000,6,0,'2022-11-09',NULL,NULL,2,7),(25,12,200000,6,0,'2022-11-09',NULL,NULL,2,7),(26,13,200000,6,0,'2022-11-09',NULL,NULL,2,7),(27,14,200000,6,0,'2022-11-09',NULL,NULL,2,7),(28,15,200000,6,0,'2022-11-09',NULL,NULL,2,7),(29,16,200000,6,0,'2022-11-09',NULL,NULL,2,7),(30,17,120000,3,0,'2022-11-09',NULL,NULL,2,7),(31,18,120000,3,0,'2022-11-09',NULL,NULL,2,7),(32,19,120000,3,0,'2022-11-09',NULL,NULL,2,7),(33,20,120000,3,0,'2022-11-09',NULL,NULL,2,7),(34,21,120000,3,0,'2022-11-09',NULL,NULL,2,7),(35,22,120000,3,0,'2022-11-09',NULL,NULL,2,7),(36,23,300000,10,0,'2022-11-09',NULL,NULL,2,7),(37,24,300000,10,0,'2022-11-09',NULL,NULL,2,7),(38,25,300000,10,0,'2022-11-09',NULL,NULL,2,7),(39,26,300000,10,0,'2022-11-09',NULL,NULL,2,7),(40,27,300000,10,0,'2022-11-09',NULL,NULL,2,7),(41,28,300000,10,0,'2022-11-09',NULL,NULL,2,7),(42,29,300000,10,0,'2022-11-09',NULL,NULL,2,7),(43,30,300000,10,0,'2022-11-09',NULL,NULL,2,7),(44,31,300000,10,0,'2022-11-09',NULL,NULL,2,7),(45,1,100000,2,0,'2022-11-09',NULL,NULL,3,8),(46,2,100000,2,0,'2022-11-09',NULL,NULL,3,8),(47,3,100000,2,0,'2022-11-09',NULL,NULL,3,8),(48,4,100000,2,0,'2022-11-09',NULL,NULL,3,8),(49,5,100000,2,0,'2022-11-09',NULL,NULL,3,8),(50,6,100000,2,0,'2022-11-09',NULL,NULL,3,8),(51,7,100000,2,0,'2022-11-09',NULL,NULL,3,8),(52,8,100000,2,0,'2022-11-09',NULL,NULL,3,8),(53,9,100000,2,0,'2022-11-09',NULL,NULL,3,8),(54,10,100000,2,0,'2022-11-09',NULL,NULL,3,8),(55,11,140000,4,0,'2022-11-09',NULL,NULL,3,8),(56,12,140000,4,0,'2022-11-09',NULL,NULL,3,8),(57,13,140000,4,0,'2022-11-09',NULL,NULL,3,8),(58,14,140000,4,0,'2022-11-09',NULL,NULL,3,8),(59,15,140000,4,0,'2022-11-09',NULL,NULL,3,8),(60,16,140000,4,0,'2022-11-09',NULL,NULL,3,8),(61,17,140000,4,0,'2022-11-09',NULL,NULL,3,8),(62,18,140000,4,0,'2022-11-09',NULL,NULL,3,8),(63,19,140000,4,0,'2022-11-09',NULL,NULL,3,8),(64,20,140000,4,0,'2022-11-09',NULL,NULL,3,8),(65,21,180000,6,0,'2022-11-09',NULL,NULL,3,8),(66,21,180000,6,0,'2022-11-09',NULL,NULL,3,8),(67,22,180000,6,0,'2022-11-09',NULL,NULL,3,8),(68,23,180000,6,0,'2022-11-09',NULL,NULL,3,8),(69,24,180000,6,0,'2022-11-09',NULL,NULL,3,8),(70,25,180000,6,0,'2022-11-09',NULL,NULL,3,8),(71,26,180000,6,0,'2022-11-09',NULL,NULL,3,8),(72,27,180000,6,0,'2022-11-09',NULL,NULL,3,8),(73,28,180000,6,0,'2022-11-09',NULL,NULL,3,8),(74,29,180000,6,0,'2022-11-09',NULL,NULL,3,8),(75,30,180000,6,0,'2022-11-09',NULL,NULL,3,8),(76,32,220000,8,0,'2022-11-09',NULL,NULL,3,8),(77,33,220000,8,0,'2022-11-09',NULL,NULL,3,8),(78,34,220000,8,0,'2022-11-09',NULL,NULL,3,8),(79,35,220000,8,0,'2022-11-09',NULL,NULL,3,8),(80,36,220000,8,0,'2022-11-09',NULL,NULL,3,8),(81,1,170000,5,0,'2022-11-10',NULL,NULL,16,9),(82,2,170000,5,0,'2022-11-10',NULL,NULL,16,9),(83,3,170000,5,0,'2022-11-10',NULL,NULL,16,9),(84,4,170000,5,0,'2022-11-10',NULL,NULL,16,9),(85,5,170000,5,0,'2022-11-10',NULL,NULL,16,9),(86,6,170000,5,0,'2022-11-10',NULL,NULL,16,9),(87,7,170000,5,0,'2022-11-10',NULL,NULL,16,9),(88,8,170000,5,0,'2022-11-10',NULL,NULL,16,9),(89,9,220000,9,0,'2022-11-10',NULL,NULL,16,9),(90,10,220000,9,0,'2022-11-10',NULL,NULL,16,9),(91,11,220000,9,0,'2022-11-10',NULL,NULL,16,9),(92,12,220000,9,0,'2022-11-10',NULL,NULL,16,9),(93,13,220000,9,0,'2022-11-10',NULL,NULL,16,9),(94,14,220000,9,0,'2022-11-10',NULL,NULL,16,9),(95,15,220000,9,0,'2022-11-10',NULL,NULL,16,9),(96,16,220000,9,0,'2022-11-10',NULL,NULL,16,9),(97,17,220000,9,0,'2022-11-10',NULL,NULL,16,9),(98,18,220000,9,0,'2022-11-10',NULL,NULL,16,9),(99,19,220000,9,0,'2022-11-10',NULL,NULL,16,9),(100,20,220000,9,0,'2022-11-10',NULL,NULL,16,9),(101,21,300000,15,0,'2022-11-10',NULL,NULL,16,9),(102,22,300000,15,0,'2022-11-10',NULL,NULL,16,9),(103,23,300000,15,0,'2022-11-10',NULL,NULL,16,9),(104,24,300000,15,0,'2022-11-10',NULL,NULL,16,9),(105,25,300000,15,0,'2022-11-10',NULL,NULL,16,9);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `test1`
--

DROP TABLE IF EXISTS `test1`;
/*!50001 DROP VIEW IF EXISTS `test1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `test1` AS SELECT 
 1 AS `regSeq`,
 1 AS `regName`,
 1 AS `regCategory`,
 1 AS `roNum`,
 1 AS `roPrice`,
 1 AS `boCheckindate`,
 1 AS `boCheckoutdate`,
 1 AS `boGroup`,
 1 AS `days`,
 1 AS `client_cId`,
 1 AS `regImage2`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `viewbooking`
--

DROP TABLE IF EXISTS `viewbooking`;
/*!50001 DROP VIEW IF EXISTS `viewbooking`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `viewbooking` AS SELECT 
 1 AS `boSeq`,
 1 AS `roPrice`,
 1 AS `boGroup`,
 1 AS `regName`,
 1 AS `regCategory`,
 1 AS `client_cId`,
 1 AS `total`,
 1 AS `boDate`,
 1 AS `roNum`,
 1 AS `regSeq`,
 1 AS `boCheckindate`,
 1 AS `boCheckoutdate`,
 1 AS `days`,
 1 AS `pay_room_regcamp_host_hSeq`,
 1 AS `pay_room_roSeq`,
 1 AS `regImage2`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `wish`
--

DROP TABLE IF EXISTS `wish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wish` (
  `wSeq` int NOT NULL AUTO_INCREMENT,
  `wDate` date NOT NULL,
  `client_cId` varchar(20) NOT NULL,
  `regcamp_regSeq` int NOT NULL,
  `regcamp_host_hSeq` int NOT NULL,
  PRIMARY KEY (`wSeq`,`client_cId`,`regcamp_regSeq`,`regcamp_host_hSeq`),
  UNIQUE KEY `wSeq_UNIQUE` (`wSeq`),
  KEY `fk_wish_client1_idx` (`client_cId`),
  KEY `fk_wish_regcamp1_idx` (`regcamp_regSeq`,`regcamp_host_hSeq`),
  CONSTRAINT `fk_wish_client1` FOREIGN KEY (`client_cId`) REFERENCES `client` (`cId`),
  CONSTRAINT `fk_wish_regcamp1` FOREIGN KEY (`regcamp_regSeq`, `regcamp_host_hSeq`) REFERENCES `regcamp` (`regSeq`, `host_hSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wish`
--

LOCK TABLES `wish` WRITE;
/*!40000 ALTER TABLE `wish` DISABLE KEYS */;
INSERT INTO `wish` VALUES (1,'2022-11-14','test',1,1),(2,'2022-11-14','test',1,1),(3,'2022-11-14','test',1,1),(4,'2022-11-14','test',1,5);
/*!40000 ALTER TABLE `wish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `booklist`
--

/*!50001 DROP VIEW IF EXISTS `booklist`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `booklist` AS select `b`.`boSeq` AS `boSeq`,`b`.`boPrice` AS `boPrice`,`b`.`boGroup` AS `boGroup`,`rc`.`regName` AS `regName`,`b`.`pay_client_cId` AS `pay_client_cId`,(`b`.`boPrice` * `b`.`boCount`) AS `total`,`b`.`boDate` AS `boDate`,`r`.`roNum` AS `roNum`,`b`.`pay_room_regcamp_regSeq` AS `pay_room_regcamp_regSeq`,min(`b`.`boCheckindate`) AS `checkin`,max(`b`.`boCheckindate`) AS `checkout`,`b`.`boCount` AS `boCount`,`b`.`pay_room_regcamp_host_hSeq` AS `pay_room_regcamp_host_hSeq`,`b`.`pay_room_roSeq` AS `pay_room_roSeq` from ((((`book` `b` join `pay` `p`) join `room` `r`) join `client` `c`) join `regcamp` `rc`) where ((`b`.`pay_cid` = `p`.`cid`) and (`b`.`pay_room_roSeq` = `r`.`roSeq`) and (`b`.`pay_room_regcamp_regSeq` = `p`.`room_regcamp_regSeq`) and (`b`.`pay_room_regcamp_regSeq` = `rc`.`regSeq`) and (`b`.`pay_room_regcamp_host_hSeq` = `p`.`room_regcamp_host_hSeq`) and (`b`.`pay_client_cId` = `c`.`cId`)) group by `b`.`boGroup`,`b`.`pay_client_cId`,`b`.`boSeq`,`r`.`roNum` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `bprch`
--

/*!50001 DROP VIEW IF EXISTS `bprch`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `bprch` AS select `book`.`boSeq` AS `boSeq`,`book`.`boPrice` AS `boPrice`,`book`.`boDate` AS `boDate`,`book`.`boCheckindate` AS `boCheckindate`,`book`.`boGroup` AS `boGroup`,`book`.`boCount` AS `boCount`,`book`.`boCanceldate` AS `boCanceldate`,`book`.`pay_cid` AS `pay_cid`,`book`.`pay_room_roSeq` AS `pay_room_roSeq`,`book`.`pay_room_regcamp_regSeq` AS `pay_room_regcamp_regSeq`,`book`.`pay_room_regcamp_host_hSeq` AS `pay_room_regcamp_host_hSeq`,`book`.`pay_client_cId` AS `pay_client_cId`,`prch`.`cid` AS `cid`,`prch`.`partner_order_id` AS `partner_order_id`,`prch`.`partner_user_id` AS `partner_user_id`,`prch`.`item_name` AS `item_name`,`prch`.`quantity` AS `quantity`,`prch`.`total_amount` AS `total_amount`,`prch`.`tax_free_amount` AS `tax_free_amount`,`prch`.`room_roSeq` AS `room_roSeq`,`prch`.`room_regcamp_regSeq` AS `room_regcamp_regSeq`,`prch`.`room_regcamp_host_hSeq` AS `room_regcamp_host_hSeq`,`prch`.`client_cId` AS `client_cId`,`prch`.`roSeq` AS `roSeq`,`prch`.`roNum` AS `roNum`,`prch`.`roPrice` AS `roPrice`,`prch`.`roMax` AS `roMax`,`prch`.`roOccupied` AS `roOccupied`,`prch`.`roDate` AS `roDate`,`prch`.`roMdate` AS `roMdate`,`prch`.`roDdate` AS `roDdate`,`prch`.`regcamp_regSeq` AS `regcamp_regSeq`,`prch`.`regcamp_host_hSeq` AS `regcamp_host_hSeq`,`prch`.`regSeq` AS `regSeq`,`prch`.`regTel` AS `regTel`,`prch`.`regCategory` AS `regCategory`,`prch`.`regDetailaddress` AS `regDetailaddress`,`prch`.`regName` AS `regName`,`prch`.`regDate` AS `regDate`,`prch`.`regMdate` AS `regMdate`,`prch`.`regDdate` AS `regDdate`,`prch`.`regSummary` AS `regSummary`,`prch`.`regImage1` AS `regImage1`,`prch`.`regImage2` AS `regImage2`,`prch`.`regImage3` AS `regImage3`,`prch`.`regImage4` AS `regImage4`,`prch`.`host_hSeq` AS `host_hSeq`,`prch`.`hSeq` AS `hSeq`,`prch`.`hId` AS `hId`,`prch`.`hDate` AS `hDate`,`prch`.`hMdate` AS `hMdate`,`prch`.`hDdate` AS `hDdate`,`prch`.`hSummary` AS `hSummary`,`prch`.`hImage` AS `hImage` from (`book` join `prch` on(((`book`.`pay_cid` = `prch`.`cid`) and (`book`.`pay_room_roSeq` = `prch`.`room_roSeq`) and (`book`.`pay_room_regcamp_regSeq` = `prch`.`room_regcamp_regSeq`) and (`book`.`pay_room_regcamp_host_hSeq` = `prch`.`room_regcamp_host_hSeq`) and (`book`.`pay_client_cId` = `prch`.`client_cId`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `camp`
--

/*!50001 DROP VIEW IF EXISTS `camp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `camp` AS select `c`.`regSeq` AS `regSeq`,`c`.`regTel` AS `regTel`,`c`.`regCategory` AS `regCategory`,`c`.`regDetailaddress` AS `regDetailaddress`,`c`.`regName` AS `regName`,`c`.`regDate` AS `regDate`,`c`.`regMdate` AS `regMdate`,`c`.`regDdate` AS `regDdate`,`c`.`regSummary` AS `regSummary`,`c`.`regImage1` AS `regImage1`,`c`.`regImage2` AS `regImage2`,`c`.`regImage3` AS `regImage3`,`c`.`regImage4` AS `regImage4`,`c`.`host_hSeq` AS `host_hSeq`,`r`.`roSeq` AS `roSeq`,`r`.`roNum` AS `roNum`,`r`.`roPrice` AS `roPrice`,`r`.`roMax` AS `roMax`,`r`.`roOccupied` AS `roOccupied`,`r`.`roDate` AS `roDate`,`r`.`roMdate` AS `roMdate`,`r`.`roDdate` AS `roDdate`,`r`.`regcamp_regSeq` AS `regcamp_regSeq`,`r`.`regcamp_host_hSeq` AS `regcamp_host_hSeq` from (`regcamp` `c` join `room` `r` on((`c`.`regSeq` = `r`.`regcamp_regSeq`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ch`
--

/*!50001 DROP VIEW IF EXISTS `ch`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ch` AS select `regcamp`.`regSeq` AS `regSeq`,`regcamp`.`regTel` AS `regTel`,`regcamp`.`regCategory` AS `regCategory`,`regcamp`.`regDetailaddress` AS `regDetailaddress`,`regcamp`.`regName` AS `regName`,`regcamp`.`regDate` AS `regDate`,`regcamp`.`regMdate` AS `regMdate`,`regcamp`.`regDdate` AS `regDdate`,`regcamp`.`regSummary` AS `regSummary`,`regcamp`.`regImage1` AS `regImage1`,`regcamp`.`regImage2` AS `regImage2`,`regcamp`.`regImage3` AS `regImage3`,`regcamp`.`regImage4` AS `regImage4`,`regcamp`.`host_hSeq` AS `host_hSeq`,`host`.`hSeq` AS `hSeq`,`host`.`hId` AS `hId`,`host`.`hDate` AS `hDate`,`host`.`hMdate` AS `hMdate`,`host`.`hDdate` AS `hDdate`,`host`.`hSummary` AS `hSummary`,`host`.`hImage` AS `hImage` from (`regcamp` join `host` on((`regcamp`.`host_hSeq` = `host`.`hSeq`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `checkdate2`
--

/*!50001 DROP VIEW IF EXISTS `checkdate2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `checkdate2` AS select `room`.`roSeq` AS `roSeq`,`room`.`roNum` AS `roNum`,`room`.`roPrice` AS `roPrice`,`room`.`roMax` AS `roMax`,`room`.`roOccupied` AS `roOccupied`,`room`.`roDate` AS `roDate`,`room`.`roMdate` AS `roMdate`,`room`.`roDdate` AS `roDdate`,`room`.`regcamp_regSeq` AS `regcamp_regSeq`,`room`.`regcamp_host_hSeq` AS `regcamp_host_hSeq`,`regcamp`.`regSeq` AS `regSeq`,`regcamp`.`regTel` AS `regTel`,`regcamp`.`regCategory` AS `regCategory`,`regcamp`.`regDetailaddress` AS `regDetailaddress`,`regcamp`.`regName` AS `regName`,`regcamp`.`regDate` AS `regDate`,`regcamp`.`regMdate` AS `regMdate`,`regcamp`.`regDdate` AS `regDdate`,`regcamp`.`regSummary` AS `regSummary`,`regcamp`.`regImage1` AS `regImage1`,`regcamp`.`regImage2` AS `regImage2`,`regcamp`.`regImage3` AS `regImage3`,`regcamp`.`regImage4` AS `regImage4`,`regcamp`.`host_hSeq` AS `host_hSeq` from (`room` join `regcamp` on(((`room`.`regcamp_regSeq` = `regcamp`.`regSeq`) and (`room`.`regcamp_host_hSeq` = `regcamp`.`host_hSeq`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pagecount`
--

/*!50001 DROP VIEW IF EXISTS `pagecount`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pagecount` AS select count(0) AS `count(*)`,`booklist`.`pay_room_regcamp_host_hSeq` AS `pay_room_regcamp_host_hSeq` from `booklist` group by `booklist`.`boGroup`,`booklist`.`regName`,`booklist`.`pay_client_cId`,`booklist`.`total`,`booklist`.`boDate`,`booklist`.`roNum`,`booklist`.`boCount`,`booklist`.`pay_room_regcamp_host_hSeq` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prch`
--

/*!50001 DROP VIEW IF EXISTS `prch`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prch` AS select `pay`.`cid` AS `cid`,`pay`.`partner_order_id` AS `partner_order_id`,`pay`.`partner_user_id` AS `partner_user_id`,`pay`.`item_name` AS `item_name`,`pay`.`quantity` AS `quantity`,`pay`.`total_amount` AS `total_amount`,`pay`.`tax_free_amount` AS `tax_free_amount`,`pay`.`room_roSeq` AS `room_roSeq`,`pay`.`room_regcamp_regSeq` AS `room_regcamp_regSeq`,`pay`.`room_regcamp_host_hSeq` AS `room_regcamp_host_hSeq`,`pay`.`client_cId` AS `client_cId`,`rch`.`roSeq` AS `roSeq`,`rch`.`roNum` AS `roNum`,`rch`.`roPrice` AS `roPrice`,`rch`.`roMax` AS `roMax`,`rch`.`roOccupied` AS `roOccupied`,`rch`.`roDate` AS `roDate`,`rch`.`roMdate` AS `roMdate`,`rch`.`roDdate` AS `roDdate`,`rch`.`regcamp_regSeq` AS `regcamp_regSeq`,`rch`.`regcamp_host_hSeq` AS `regcamp_host_hSeq`,`rch`.`regSeq` AS `regSeq`,`rch`.`regTel` AS `regTel`,`rch`.`regCategory` AS `regCategory`,`rch`.`regDetailaddress` AS `regDetailaddress`,`rch`.`regName` AS `regName`,`rch`.`regDate` AS `regDate`,`rch`.`regMdate` AS `regMdate`,`rch`.`regDdate` AS `regDdate`,`rch`.`regSummary` AS `regSummary`,`rch`.`regImage1` AS `regImage1`,`rch`.`regImage2` AS `regImage2`,`rch`.`regImage3` AS `regImage3`,`rch`.`regImage4` AS `regImage4`,`rch`.`host_hSeq` AS `host_hSeq`,`rch`.`hSeq` AS `hSeq`,`rch`.`hId` AS `hId`,`rch`.`hDate` AS `hDate`,`rch`.`hMdate` AS `hMdate`,`rch`.`hDdate` AS `hDdate`,`rch`.`hSummary` AS `hSummary`,`rch`.`hImage` AS `hImage` from (`pay` join `rch` on(((`pay`.`room_roSeq` = `rch`.`roSeq`) and (`pay`.`room_regcamp_regSeq` = `rch`.`regcamp_regSeq`) and (`pay`.`room_regcamp_host_hSeq` = `rch`.`regcamp_host_hSeq`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rb_outtable`
--

/*!50001 DROP VIEW IF EXISTS `rb_outtable`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rb_outtable` AS select `R`.`roSeq` AS `roSeq`,`R`.`roNum` AS `roNum`,`R`.`roPrice` AS `roPrice`,`R`.`roMax` AS `roMax`,`R`.`roOccupied` AS `roOccupied`,`R`.`roDate` AS `roDate`,`R`.`roMdate` AS `roMdate`,`R`.`roDdate` AS `roDdate`,`R`.`regcamp_regSeq` AS `regcamp_regSeq`,`R`.`regcamp_host_hSeq` AS `regcamp_host_hSeq`,`B`.`boSeq` AS `boSeq`,`B`.`boPrice` AS `boPrice`,`B`.`boDate` AS `boDate`,`B`.`boCheckindate` AS `boCheckindate`,`B`.`boGroup` AS `boGroup`,`B`.`boCount` AS `boCount`,`B`.`boCanceldate` AS `boCanceldate`,`B`.`pay_cid` AS `pay_cid`,`B`.`pay_room_roSeq` AS `pay_room_roSeq`,`B`.`pay_room_regcamp_regSeq` AS `pay_room_regcamp_regSeq`,`B`.`pay_room_regcamp_host_hSeq` AS `pay_room_regcamp_host_hSeq`,`B`.`pay_client_cId` AS `pay_client_cId` from (`room` `R` left join `book` `B` on((`R`.`roSeq` = `B`.`pay_room_roSeq`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rch`
--

/*!50001 DROP VIEW IF EXISTS `rch`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rch` AS select `room`.`roSeq` AS `roSeq`,`room`.`roNum` AS `roNum`,`room`.`roPrice` AS `roPrice`,`room`.`roMax` AS `roMax`,`room`.`roOccupied` AS `roOccupied`,`room`.`roDate` AS `roDate`,`room`.`roMdate` AS `roMdate`,`room`.`roDdate` AS `roDdate`,`room`.`regcamp_regSeq` AS `regcamp_regSeq`,`room`.`regcamp_host_hSeq` AS `regcamp_host_hSeq`,`ch`.`regSeq` AS `regSeq`,`ch`.`regTel` AS `regTel`,`ch`.`regCategory` AS `regCategory`,`ch`.`regDetailaddress` AS `regDetailaddress`,`ch`.`regName` AS `regName`,`ch`.`regDate` AS `regDate`,`ch`.`regMdate` AS `regMdate`,`ch`.`regDdate` AS `regDdate`,`ch`.`regSummary` AS `regSummary`,`ch`.`regImage1` AS `regImage1`,`ch`.`regImage2` AS `regImage2`,`ch`.`regImage3` AS `regImage3`,`ch`.`regImage4` AS `regImage4`,`ch`.`host_hSeq` AS `host_hSeq`,`ch`.`hSeq` AS `hSeq`,`ch`.`hId` AS `hId`,`ch`.`hDate` AS `hDate`,`ch`.`hMdate` AS `hMdate`,`ch`.`hDdate` AS `hDdate`,`ch`.`hSummary` AS `hSummary`,`ch`.`hImage` AS `hImage` from (`room` join `ch` on(((`room`.`regcamp_regSeq` = `ch`.`regSeq`) and (`room`.`regcamp_host_hSeq` = `ch`.`host_hSeq`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `test1`
--

/*!50001 DROP VIEW IF EXISTS `test1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `test1` AS select `bprch`.`regSeq` AS `regSeq`,`bprch`.`regName` AS `regName`,`bprch`.`regCategory` AS `regCategory`,`bprch`.`roNum` AS `roNum`,`bprch`.`roPrice` AS `roPrice`,`bprch`.`boCheckindate` AS `boCheckindate`,(`bprch`.`boCheckindate` + interval (max(`bprch`.`boSeq`) - `bprch`.`boGroup`) day) AS `boCheckoutdate`,`bprch`.`boGroup` AS `boGroup`,((max(`bprch`.`boSeq`) - `bprch`.`boGroup`) + 1) AS `days`,`bprch`.`client_cId` AS `client_cId`,`bprch`.`regImage2` AS `regImage2` from `bprch` where ((`bprch`.`boCheckindate` > now()) and (`bprch`.`client_cId` = 'test')) group by `bprch`.`boGroup` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `viewbooking`
--

/*!50001 DROP VIEW IF EXISTS `viewbooking`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewbooking` AS select `b`.`boSeq` AS `boSeq`,`b`.`boPrice` AS `roPrice`,`b`.`boGroup` AS `boGroup`,`rc`.`regName` AS `regName`,`rc`.`regCategory` AS `regCategory`,`b`.`pay_client_cId` AS `client_cId`,(`b`.`boPrice` * `b`.`boCount`) AS `total`,`b`.`boDate` AS `boDate`,`r`.`roNum` AS `roNum`,`b`.`pay_room_regcamp_regSeq` AS `regSeq`,min(`b`.`boCheckindate`) AS `boCheckindate`,max(`b`.`boCheckindate`) AS `boCheckoutdate`,`b`.`boCount` AS `days`,`b`.`pay_room_regcamp_host_hSeq` AS `pay_room_regcamp_host_hSeq`,`b`.`pay_room_roSeq` AS `pay_room_roSeq`,`rc`.`regImage2` AS `regImage2` from ((((`book` `b` join `pay` `p`) join `room` `r`) join `client` `c`) join `regcamp` `rc`) where ((`b`.`pay_cid` = `p`.`cid`) and (`b`.`pay_room_roSeq` = `r`.`roSeq`) and (`b`.`pay_room_regcamp_regSeq` = `p`.`room_regcamp_regSeq`) and (`b`.`pay_room_regcamp_regSeq` = `rc`.`regSeq`) and (`b`.`pay_room_regcamp_host_hSeq` = `p`.`room_regcamp_host_hSeq`) and (`b`.`pay_client_cId` = `c`.`cId`)) group by `b`.`boGroup`,`b`.`pay_client_cId`,`b`.`boSeq`,`r`.`roNum` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-15  5:23:27
