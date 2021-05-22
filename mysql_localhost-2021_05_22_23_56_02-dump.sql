-- MySQL dump 10.13  Distrib 8.0.23, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: sheremetyevo
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `POWER` int NOT NULL,
  `MAX_FUEL_RESERVE` float NOT NULL,
  `MAX_REAGENT_RESERVE` float NOT NULL,
  `REAGENT_CONSUMPTION` float NOT NULL,
  `FUEL_CONSUMPTION` float NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` (`ID`, `NAME`, `POWER`, `MAX_FUEL_RESERVE`, `MAX_REAGENT_RESERVE`, `REAGENT_CONSUMPTION`, `FUEL_CONSUMPTION`) VALUES (1,'Model1',1,10,10,1.2,1.5),(2,'Model2',2,30,20,2,2);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`ID`, `NAME`, `DESCRIPTION`) VALUES (1,'ROLE_ADMIN','Role for administrator.'),(2,'ROLE_OPERATOR','Role for field operator.'),(3,'ROLE_FIELD_ENGINEER','Role for field engineer.'),(4,'ROLE_SNOWBLOWER_OPERATOR','Role for field snowblower operator.');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `runway`
--

DROP TABLE IF EXISTS `runway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `runway` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `OUTSIDE` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `runway_NAME_uindex` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `runway`
--

LOCK TABLES `runway` WRITE;
/*!40000 ALTER TABLE `runway` DISABLE KEYS */;
INSERT INTO `runway` (`ID`, `NAME`, `OUTSIDE`) VALUES (1,'R1',0),(2,'R2',0),(3,'R3',0),(4,'M12',1);
/*!40000 ALTER TABLE `runway` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `runway_unit`
--

DROP TABLE IF EXISTS `runway_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `runway_unit` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `runway_ID` bigint NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `LATITUDE` float NOT NULL,
  `LONGITUDE` float NOT NULL,
  `ICING` int NOT NULL,
  `SNOW_LEVEL` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_runway_unit_runway1_idx` (`runway_ID`),
  CONSTRAINT `fk_runway_unit_runway1` FOREIGN KEY (`runway_ID`) REFERENCES `runway` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `runway_unit`
--

LOCK TABLES `runway_unit` WRITE;
/*!40000 ALTER TABLE `runway_unit` DISABLE KEYS */;
INSERT INTO `runway_unit` (`ID`, `runway_ID`, `NAME`, `LATITUDE`, `LONGITUDE`, `ICING`, `SNOW_LEVEL`) VALUES (1,1,'1',1,1,0,0),(2,1,'2',1,1,0,0),(3,1,'3',1,1,0,0),(4,1,'4',1,1,0,0),(5,1,'5',1,1,0,0),(6,1,'6',1,1,0,0),(7,1,'7',1,1,0,0),(8,1,'8',1,1,0,0),(9,1,'9',1,1,0,0),(10,1,'10',1,1,0,0),(11,1,'11',1,1,0,0),(12,1,'12',1,1,0,0),(13,1,'13',1,1,0,0),(14,1,'14',1,1,0,0),(15,1,'15',1,1,0,0),(16,1,'16',1,1,0,0),(17,1,'17',1,1,0,0),(18,1,'18',1,1,0,0),(19,1,'19',1,1,0,0),(20,1,'20',1,1,0,0),(21,1,'21',1,1,0,0),(22,1,'22',1,1,0,0),(23,1,'23',1,1,0,0),(24,1,'24',1,1,0,0),(25,1,'25',1,1,0,0),(26,1,'26',1,1,0,0),(27,1,'27',1,1,0,0),(28,1,'28',1,1,0,0),(29,1,'29',1,1,0,0),(30,1,'30',1,1,0,0),(31,1,'31',1,1,0,0),(32,1,'32',1,1,0,0),(33,1,'33',1,1,0,0),(34,1,'34',1,1,0,0),(35,1,'35',1,1,0,0),(36,1,'36',1,1,0,0),(37,1,'37',1,1,0,0),(38,1,'38',1,1,0,0),(39,1,'39',1,1,0,0),(40,1,'40',1,1,0,0),(41,1,'41',1,1,0,0),(42,1,'42',1,1,0,0),(43,1,'43',1,1,0,0),(44,1,'44',1,1,0,0),(45,1,'45',1,1,0,0),(46,1,'46',1,1,0,0),(47,1,'47',1,1,0,0),(48,1,'48',1,1,0,0),(49,1,'49',1,1,0,0),(50,1,'50',1,1,0,0),(51,1,'51',1,1,0,0),(52,1,'52',1,1,0,0),(53,1,'53',1,1,0,0),(54,1,'54',1,1,0,0),(55,1,'55',1,1,0,0),(56,1,'56',1,1,0,0),(57,1,'57',1,1,0,0),(58,1,'58',1,1,0,0),(59,1,'59',1,1,0,0),(60,1,'60',1,1,0,0),(61,1,'61',1,1,0,0),(62,1,'62',1,1,0,0),(63,1,'63',1,1,0,0),(64,1,'64',1,1,0,0),(65,1,'65',1,1,0,0),(66,1,'66',1,1,0,0),(67,1,'67',1,1,0,0),(68,1,'68',1,1,0,0),(69,1,'69',1,1,0,0),(70,1,'70',1,1,0,0),(71,1,'71',1,1,0,0),(72,1,'72',1,1,0,0),(73,1,'73',1,1,0,0),(74,1,'74',1,1,0,0),(75,1,'75',1,1,0,0),(76,1,'76',1,1,0,0),(77,1,'77',1,1,0,0),(78,1,'78',1,1,0,0),(79,1,'79',1,1,0,0),(80,1,'80',1,1,0,0),(81,1,'81',1,1,0,0),(82,1,'82',1,1,0,0),(83,1,'83',1,1,0,0),(84,1,'84',1,1,0,0),(85,1,'85',1,1,0,0),(86,1,'86',1,1,0,0),(87,1,'87',1,1,0,0),(88,1,'88',1,1,0,0),(89,1,'89',1,1,0,0),(90,1,'90',1,1,0,0),(91,1,'91',1,1,0,0),(92,1,'92',1,1,0,0),(93,1,'93',1,1,0,0),(94,1,'94',1,1,0,0),(95,1,'95',1,1,0,0),(96,1,'96',1,1,0,0),(97,1,'97',1,1,0,0),(98,1,'98',1,1,0,0),(99,1,'99',1,1,0,0),(100,1,'100',1,1,0,0),(101,1,'101',1,1,0,0),(102,1,'102',1,1,0,0),(103,1,'103',1,1,0,0),(104,1,'104',1,1,0,0),(105,1,'105',1,1,0,0),(106,1,'106',1,1,0,0),(107,1,'107',1,1,0,0),(108,1,'108',1,1,0,0),(109,1,'109',1,1,0,0),(110,1,'110',1,1,0,0),(111,1,'111',1,1,0,0),(112,1,'112',1,1,0,0),(113,1,'113',1,1,0,0),(114,1,'114',1,1,0,0),(115,1,'115',1,1,0,0),(116,1,'116',1,1,0,0),(117,1,'117',1,1,0,0),(118,1,'118',1,1,0,0),(119,1,'119',1,1,0,0),(120,1,'120',1,1,0,0),(121,1,'121',1,1,0,0),(122,1,'122',1,1,0,0),(123,1,'123',1,1,0,0);
/*!40000 ALTER TABLE `runway_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `runway_unit_neighbor`
--

DROP TABLE IF EXISTS `runway_unit_neighbor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `runway_unit_neighbor` (
  `parent_id` bigint NOT NULL,
  `child_id` bigint NOT NULL,
  PRIMARY KEY (`parent_id`,`child_id`),
  KEY `runway_unit_neighbor_runway_unit_ID_fk_2` (`child_id`),
  CONSTRAINT `runway_unit_neighbor_runway_unit_ID_fk` FOREIGN KEY (`parent_id`) REFERENCES `runway_unit` (`ID`),
  CONSTRAINT `runway_unit_neighbor_runway_unit_ID_fk_2` FOREIGN KEY (`child_id`) REFERENCES `runway_unit` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `runway_unit_neighbor`
--

LOCK TABLES `runway_unit_neighbor` WRITE;
/*!40000 ALTER TABLE `runway_unit_neighbor` DISABLE KEYS */;
INSERT INTO `runway_unit_neighbor` (`parent_id`, `child_id`) VALUES (110,1),(1,2),(2,3),(3,4),(4,5),(5,6),(6,7),(7,8),(8,9),(9,10),(10,11),(11,12),(12,13),(112,13),(13,14),(14,15),(15,16),(16,17),(17,18),(115,18),(18,19),(19,20),(20,21),(21,22),(22,23),(23,24),(24,25),(117,25),(25,26),(26,27),(27,28),(28,29),(29,30),(30,31),(119,31),(31,32),(32,33),(33,34),(34,35),(35,36),(36,37),(121,37),(37,38),(38,39),(39,40),(123,40),(40,41),(41,42),(42,43),(43,44),(44,45),(45,46),(46,47),(47,48),(48,49),(49,50),(50,51),(51,52),(52,53),(53,54),(54,55),(55,56),(55,57),(57,58),(56,59),(59,60),(60,61),(61,62),(62,63),(63,64),(64,65),(65,66),(66,67),(67,68),(68,69),(69,70),(70,71),(71,72),(72,73),(73,74),(74,75),(75,76),(76,77),(77,78),(78,79),(79,80),(80,81),(81,82),(82,83),(83,84),(84,85),(85,86),(86,87),(87,88),(88,89),(89,90),(90,91),(91,92),(92,93),(93,94),(94,95),(95,96),(96,97),(97,98),(98,99),(99,100),(100,101),(101,102),(102,103),(103,104),(104,105),(105,106),(106,107),(107,108),(108,109),(109,110),(96,111),(111,112),(113,112),(93,113),(88,114),(114,115),(84,116),(116,117),(82,118),(118,119),(76,120),(120,121),(70,122),(122,123);
/*!40000 ALTER TABLE `runway_unit_neighbor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_point`
--

DROP TABLE IF EXISTS `service_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_point` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `service_point_NAME_uindex` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_point`
--

LOCK TABLES `service_point` WRITE;
/*!40000 ALTER TABLE `service_point` DISABLE KEYS */;
INSERT INTO `service_point` (`ID`, `NAME`, `DESCRIPTION`) VALUES (1,'Refueling fuel','Refueling fuel des'),(2,'Reagent filling','Reagent filling des');
/*!40000 ALTER TABLE `service_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `INIT_TIME` datetime NOT NULL,
  `APPROXIMATE_FINISH_TIME` datetime NOT NULL,
  `FINISH_TIME` datetime DEFAULT NULL,
  `OPERATOR_ID` bigint NOT NULL,
  `TASK_STATUS_ID` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_task_user1_idx` (`OPERATOR_ID`),
  KEY `fk_task_task_status1_idx` (`TASK_STATUS_ID`),
  CONSTRAINT `fk_task_task_status1` FOREIGN KEY (`TASK_STATUS_ID`) REFERENCES `task_status` (`ID`),
  CONSTRAINT `fk_task_user1` FOREIGN KEY (`OPERATOR_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`ID`, `INIT_TIME`, `APPROXIMATE_FINISH_TIME`, `FINISH_TIME`, `OPERATOR_ID`, `TASK_STATUS_ID`) VALUES (1,'2021-05-22 04:09:29','2021-05-22 04:10:35',NULL,1,1),(2,'2021-05-22 01:49:06','2021-05-22 01:55:06',NULL,1,1),(3,'2021-05-22 01:50:09','2021-05-22 01:56:09',NULL,1,1),(4,'2021-05-22 01:51:31','2021-05-22 01:57:31',NULL,1,1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_status`
--

DROP TABLE IF EXISTS `task_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_status` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_status`
--

LOCK TABLES `task_status` WRITE;
/*!40000 ALTER TABLE `task_status` DISABLE KEYS */;
INSERT INTO `task_status` (`ID`, `NAME`, `DESCRIPTION`) VALUES (1,'Running','R'),(2,'Finished','F');
/*!40000 ALTER TABLE `task_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_unit`
--

DROP TABLE IF EXISTS `task_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_unit` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `TASK_ID` bigint NOT NULL,
  `RUNWAY_UNIT_ID` bigint NOT NULL,
  `TECHNIC_ID` bigint NOT NULL,
  `IS_FINISHED` tinyint NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_task_unit_task1_idx` (`TASK_ID`),
  KEY `fk_task_unit_runway_unit1_idx` (`RUNWAY_UNIT_ID`),
  KEY `fk_task_unit_technic1_idx` (`TECHNIC_ID`),
  CONSTRAINT `fk_task_unit_runway_unit1` FOREIGN KEY (`RUNWAY_UNIT_ID`) REFERENCES `runway_unit` (`ID`),
  CONSTRAINT `fk_task_unit_task1` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`),
  CONSTRAINT `fk_task_unit_technic1` FOREIGN KEY (`TECHNIC_ID`) REFERENCES `technic` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_unit`
--

LOCK TABLES `task_unit` WRITE;
/*!40000 ALTER TABLE `task_unit` DISABLE KEYS */;
INSERT INTO `task_unit` (`ID`, `TASK_ID`, `RUNWAY_UNIT_ID`, `TECHNIC_ID`, `IS_FINISHED`) VALUES (7,1,50,1,0);
/*!40000 ALTER TABLE `task_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technic`
--

DROP TABLE IF EXISTS `technic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technic` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `TYPE_ID` bigint NOT NULL,
  `MODEL_ID` bigint NOT NULL,
  `CURRENT_FUEL_RESERVE` float NOT NULL,
  `CURRENT_REAGENT_RESERVE` float NOT NULL,
  `STATUS_ID` bigint NOT NULL,
  `LATITUDE` float NOT NULL,
  `LONGITUDE` float NOT NULL,
  `LAST_UPDATE` datetime NOT NULL,
  `RUNWAY_UNIT` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_technic_type1_idx` (`TYPE_ID`),
  KEY `fk_technic_model1_idx` (`MODEL_ID`),
  KEY `fk_technic_status1_idx` (`STATUS_ID`),
  KEY `technic_runway_unit_ID_fk` (`RUNWAY_UNIT`),
  CONSTRAINT `fk_technic_model1` FOREIGN KEY (`MODEL_ID`) REFERENCES `model` (`ID`),
  CONSTRAINT `fk_technic_status1` FOREIGN KEY (`STATUS_ID`) REFERENCES `technic_status` (`ID`),
  CONSTRAINT `fk_technic_type1` FOREIGN KEY (`TYPE_ID`) REFERENCES `type` (`ID`),
  CONSTRAINT `technic_runway_unit_ID_fk` FOREIGN KEY (`RUNWAY_UNIT`) REFERENCES `runway_unit` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technic`
--

LOCK TABLES `technic` WRITE;
/*!40000 ALTER TABLE `technic` DISABLE KEYS */;
INSERT INTO `technic` (`ID`, `NAME`, `TYPE_ID`, `MODEL_ID`, `CURRENT_FUEL_RESERVE`, `CURRENT_REAGENT_RESERVE`, `STATUS_ID`, `LATITUDE`, `LONGITUDE`, `LAST_UPDATE`, `RUNWAY_UNIT`) VALUES (1,'Tech 1',1,1,5,2,1,23,23,'2021-05-22 01:41:34',3),(2,'Tech 2',2,2,9,5,1,65,123,'2021-05-22 01:44:01',70);
/*!40000 ALTER TABLE `technic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technic_status`
--

DROP TABLE IF EXISTS `technic_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technic_status` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `technic_status_NAME_uindex` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technic_status`
--

LOCK TABLES `technic_status` WRITE;
/*!40000 ALTER TABLE `technic_status` DISABLE KEYS */;
INSERT INTO `technic_status` (`ID`, `NAME`, `DESCRIPTION`) VALUES (1,'Norma','Norma dis'),(2,'Off','Off dis');
/*!40000 ALTER TABLE `technic_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `type_NAME_uindex` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`ID`, `NAME`, `DESCRIPTION`) VALUES (1,'Type1','Type1 des'),(2,'Type2','Type2 des');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_service_point`
--

DROP TABLE IF EXISTS `unit_service_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_service_point` (
  `RUNWAY_UNIT_ID` bigint NOT NULL,
  `SERVICE_POINT_ID` bigint NOT NULL,
  PRIMARY KEY (`SERVICE_POINT_ID`,`RUNWAY_UNIT_ID`),
  KEY `unit_service_point_runway_unit_ID_fk` (`RUNWAY_UNIT_ID`),
  CONSTRAINT `unit_service_point_runway_unit_ID_fk` FOREIGN KEY (`RUNWAY_UNIT_ID`) REFERENCES `runway_unit` (`ID`),
  CONSTRAINT `unit_service_point_service_point_ID_fk` FOREIGN KEY (`SERVICE_POINT_ID`) REFERENCES `service_point` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_service_point`
--

LOCK TABLES `unit_service_point` WRITE;
/*!40000 ALTER TABLE `unit_service_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `unit_service_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `SURNAME` varchar(255) NOT NULL,
  `PATRONYMIC` varchar(255) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `POST` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`, `LOGIN`, `PASSWORD`, `NAME`, `SURNAME`, `PATRONYMIC`, `PHONE`, `POST`) VALUES (1,'admin','$2y$12$sSQHBS1ymO4e8.440FHr8.xyP0T2l5LpGV1ak30EUlsS7C3PhknAq','Olivia','Milton','Amber','+79053885812','Administrator');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `USER_ID` bigint NOT NULL,
  `ROLE_ID` bigint NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `fk_USER_has_ROLE_ROLE1_idx` (`ROLE_ID`),
  KEY `fk_USER_has_ROLE_USER_idx` (`USER_ID`),
  CONSTRAINT `fk_USER_has_ROLE_ROLE1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `fk_USER_has_ROLE_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`USER_ID`, `ROLE_ID`) VALUES (1,1),(1,2),(1,3),(1,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_technic`
--

DROP TABLE IF EXISTS `user_technic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_technic` (
  `USER_ID` bigint NOT NULL,
  `TECHNIC_ID` bigint NOT NULL,
  PRIMARY KEY (`USER_ID`,`TECHNIC_ID`),
  KEY `fk_user_has_technic_technic1_idx` (`TECHNIC_ID`),
  KEY `fk_user_has_technic_user1_idx` (`USER_ID`),
  CONSTRAINT `fk_user_has_technic_technic1` FOREIGN KEY (`TECHNIC_ID`) REFERENCES `technic` (`ID`),
  CONSTRAINT `fk_user_has_technic_user1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_technic`
--

LOCK TABLES `user_technic` WRITE;
/*!40000 ALTER TABLE `user_technic` DISABLE KEYS */;
INSERT INTO `user_technic` (`USER_ID`, `TECHNIC_ID`) VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `user_technic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-22 23:56:02
