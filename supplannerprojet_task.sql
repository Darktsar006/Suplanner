CREATE DATABASE  IF NOT EXISTS `supplannerprojet` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `supplannerprojet`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: supplannerprojet
-- ------------------------------------------------------
-- Server version	5.6.17-log

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
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `idtask` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `employe_working` int(11) NOT NULL DEFAULT '0',
  `task_completion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idtask`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'cneipz','2014-05-14 13:17:35','2014-05-14 13:17:35',567,67),(2,'Toto','2014-05-14 13:17:36','2014-05-14 13:17:36',0,0),(3,'Oumar','2014-05-14 13:17:39','2014-05-14 13:17:39',567,567),(4,'Toto','2014-05-14 13:17:39','2014-05-14 13:17:39',0,0),(5,'Toto','2014-05-14 13:17:41','2014-05-14 13:17:41',0,0),(6,'Houpii','2014-05-14 13:54:54','2014-05-14 13:54:54',0,0),(7,'Houpii','2014-05-14 13:54:55','2014-05-14 13:54:55',0,0),(8,'Houpii','2014-05-14 13:54:56','2014-05-14 13:54:56',0,0),(9,'Houpii','2014-05-14 13:54:56','2014-05-14 13:54:56',0,0),(10,'Houpii','2014-05-14 13:54:56','2014-05-14 13:54:56',0,0),(11,'Houpii','2014-05-14 13:54:58','2014-05-14 13:54:58',0,0),(12,'cvez','2014-05-14 20:39:29','2014-05-14 20:39:29',6,8);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-14 23:50:20
