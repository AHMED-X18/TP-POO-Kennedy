-- MySQL dump 10.13  Distrib 8.0.41, for Linux (x86_64)
--
-- Host: localhost    Database: POO_1
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.24.04.1

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
-- Table structure for table `ordinateur`
--

DROP TABLE IF EXISTS `ordinateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordinateur` (
  `id_ordi` varchar(20) NOT NULL,
  `marque` varchar(20) DEFAULT NULL,
  `etat` varchar(20) DEFAULT NULL,
  `capacite` float DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `frequence` float DEFAULT NULL,
  PRIMARY KEY (`id_ordi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordinateur`
--

LOCK TABLES `ordinateur` WRITE;
/*!40000 ALTER TABLE `ordinateur` DISABLE KEYS */;
INSERT INTO `ordinateur` VALUES ('O12','Dell','Nouveau',500,100000,6.5),('O20','Lenovo','Nouveau',650,180000,7.5),('O34','Asus','Seconde main',450,160000,6),('O46','HP','Seconde main',800,250000,7.8),('O50','MacBook','Nouveau',650,200000,8);
/*!40000 ALTER TABLE `ordinateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proprietaire`
--

DROP TABLE IF EXISTS `proprietaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proprietaire` (
  `id_proprio` varchar(20) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `quartier` varchar(20) DEFAULT NULL,
  `tel` int DEFAULT NULL,
  PRIMARY KEY (`id_proprio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprietaire`
--

LOCK TABLES `proprietaire` WRITE;
/*!40000 ALTER TABLE `proprietaire` DISABLE KEYS */;
INSERT INTO `proprietaire` VALUES ('P1','Jordan Junior',24,'Obili',678902345),('P2','Nelson T.',18,'Melen',675678902),('P3','Ange Madeleine',20,'Jouvence',656178234),('P4','Joel Lilian',21,'Damas',654632109);
/*!40000 ALTER TABLE `proprietaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telephone`
--

DROP TABLE IF EXISTS `telephone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telephone` (
  `id_tel` varchar(20) NOT NULL,
  `marque` varchar(20) DEFAULT NULL,
  `etat` varchar(20) DEFAULT NULL,
  `capacite` float DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `resolution` float DEFAULT NULL,
  PRIMARY KEY (`id_tel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telephone`
--

LOCK TABLES `telephone` WRITE;
/*!40000 ALTER TABLE `telephone` DISABLE KEYS */;
INSERT INTO `telephone` VALUES ('T14','Iphone','Nouveau',128,150000,32),('T24','Samsung','Nouveau',126,70000,36),('T40','Tecno','Seconde main',126,100000,40),('T43','Pixel','Seconde main',120,50000,30);
/*!40000 ALTER TABLE `telephone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voler`
--

DROP TABLE IF EXISTS `voler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voler` (
  `id_tel` varchar(20) DEFAULT NULL,
  `id_ordi` varchar(20) DEFAULT NULL,
  `id_proprio` varchar(20) DEFAULT NULL,
  KEY `id_tel` (`id_tel`),
  KEY `id_ordi` (`id_ordi`),
  KEY `id_proprio` (`id_proprio`),
  CONSTRAINT `voler_ibfk_1` FOREIGN KEY (`id_tel`) REFERENCES `telephone` (`id_tel`),
  CONSTRAINT `voler_ibfk_2` FOREIGN KEY (`id_ordi`) REFERENCES `ordinateur` (`id_ordi`),
  CONSTRAINT `voler_ibfk_3` FOREIGN KEY (`id_proprio`) REFERENCES `proprietaire` (`id_proprio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voler`
--

LOCK TABLES `voler` WRITE;
/*!40000 ALTER TABLE `voler` DISABLE KEYS */;
INSERT INTO `voler` VALUES ('T14',NULL,'P1'),(NULL,'O12','P2'),('T43','O50','P4');
/*!40000 ALTER TABLE `voler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-09  8:59:23
