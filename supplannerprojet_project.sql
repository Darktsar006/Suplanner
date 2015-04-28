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
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `idproject` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `project_completion` int(11) NOT NULL DEFAULT '0',
  `number_of_employe` int(11) NOT NULL DEFAULT '0',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author` varchar(45) NOT NULL,
  PRIMARY KEY (`idproject`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'ceio',456,6,'2014-05-13 20:04:11','2014-05-13 20:04:11','bioz'),(2,'toto',40,3,'2014-05-13 20:04:13','2014-05-13 20:04:13','Oumar'),(3,'toto',40,3,'2014-05-13 20:04:55','2014-05-13 20:04:55','Oumar'),(4,'toto',40,3,'2014-05-13 20:05:00','2014-05-13 20:05:00','Oumar'),(5,'toto',40,3,'2014-05-13 20:05:02','2014-05-13 20:05:02','Oumar'),(6,'cza',4,4,'2014-05-14 19:39:30','2014-05-14 19:39:30','cez'),(7,'zbai',4,4,'2014-05-14 19:42:24','2014-05-14 19:42:24','bcuzoa'),(8,'bceiuz',17,17,'2014-05-14 19:59:48','2014-05-14 19:59:48','bceo'),(9,'bvido',18,18,'2014-05-14 20:00:39','2014-05-14 20:00:39','vbeio'),(10,'veior',66,5,'2014-05-14 20:02:26','2014-05-14 20:02:26','vbore'),(11,'hvioez',56,5,'2014-05-14 21:08:41','2014-05-14 21:08:41','beuo');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
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
