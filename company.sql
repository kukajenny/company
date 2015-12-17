-- MySQL dump 10.13  Distrib 5.6.26, for Win32 (x86)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `chuku`
--

DROP TABLE IF EXISTS `chuku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chuku` (
  `lei` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `num` varchar(225) DEFAULT NULL,
  `price` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL,
  `danhao` varchar(225) DEFAULT NULL,
  `jingshouren` varchar(225) DEFAULT NULL,
  `operator` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuku`
--

LOCK TABLES `chuku` WRITE;
/*!40000 ALTER TABLE `chuku` DISABLE KEYS */;
/*!40000 ALTER TABLE `chuku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `Name` varchar(20) NOT NULL DEFAULT '',
  `position` varchar(225) DEFAULT NULL,
  `tel` varchar(225) DEFAULT NULL,
  `addr` varchar(225) DEFAULT NULL,
  `school` varchar(225) DEFAULT NULL,
  `sex` varchar(225) DEFAULT NULL,
  `born` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fenlei`
--

DROP TABLE IF EXISTS `fenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fenlei` (
  `lei` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fenlei`
--

LOCK TABLES `fenlei` WRITE;
/*!40000 ALTER TABLE `fenlei` DISABLE KEYS */;
/*!40000 ALTER TABLE `fenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `lei` varchar(225) NOT NULL DEFAULT '',
  `name` varchar(225) NOT NULL DEFAULT '',
  `num` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`lei`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kucun`
--

DROP TABLE IF EXISTS `kucun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kucun` (
  `num` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `endtime` varchar(225) DEFAULT NULL,
  `danhao` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL,
  `caigouhao` varchar(225) DEFAULT NULL,
  `jingshouren` varchar(225) DEFAULT NULL,
  `operator` varchar(225) DEFAULT NULL,
  `lei` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kucun`
--

LOCK TABLES `kucun` WRITE;
/*!40000 ALTER TABLE `kucun` DISABLE KEYS */;
/*!40000 ALTER TABLE `kucun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `news` varchar(225) DEFAULT NULL,
  `limite` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES ('管理员abc登入系统','管理员','2015-12-15 15:38:19');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruku_mounth`
--

DROP TABLE IF EXISTS `ruku_mounth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruku_mounth` (
  `money` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruku_mounth`
--

LOCK TABLES `ruku_mounth` WRITE;
/*!40000 ALTER TABLE `ruku_mounth` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruku_mounth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sponsor` (
  `lei` varchar(225) NOT NULL DEFAULT '',
  `name` varchar(225) NOT NULL DEFAULT '',
  `tel` varchar(225) NOT NULL DEFAULT '',
  PRIMARY KEY (`lei`,`name`,`tel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `name` varchar(225) NOT NULL DEFAULT '',
  `password` varchar(225) DEFAULT NULL,
  `limite` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('abc','123456','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiaoshou_day`
--

DROP TABLE IF EXISTS `xiaoshou_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiaoshou_day` (
  `lei` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `money` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiaoshou_day`
--

LOCK TABLES `xiaoshou_day` WRITE;
/*!40000 ALTER TABLE `xiaoshou_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `xiaoshou_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiaoshou_mounth`
--

DROP TABLE IF EXISTS `xiaoshou_mounth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiaoshou_mounth` (
  `money` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiaoshou_mounth`
--

LOCK TABLES `xiaoshou_mounth` WRITE;
/*!40000 ALTER TABLE `xiaoshou_mounth` DISABLE KEYS */;
/*!40000 ALTER TABLE `xiaoshou_mounth` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-15 15:40:45
