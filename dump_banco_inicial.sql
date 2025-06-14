-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: contos_machado_de_assis
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `classificacao`
--

DROP TABLE IF EXISTS `classificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classificacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_tipo` (`tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacao`
--

LOCK TABLES `classificacao` WRITE;
/*!40000 ALTER TABLE `classificacao` DISABLE KEYS */;
INSERT INTO `classificacao` VALUES (2,'autoria questionavel'),(4,'conto com caracteristicas de novela'),(5,'conto padrao'),(3,'experimental e dificil classificacao'),(1,'reescritos');
/*!40000 ALTER TABLE `classificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coletanea`
--

DROP TABLE IF EXISTS `coletanea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coletanea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coletanea`
--

LOCK TABLES `coletanea` WRITE;
/*!40000 ALTER TABLE `coletanea` DISABLE KEYS */;
INSERT INTO `coletanea` VALUES (3,'Contos Fluminenses'),(4,'Contos Fluminenses (Vol. 2)'),(1,'Páginas Recolhidas (Ver. 2)'),(2,'Relíquias de Casa Velha (Vol. 2)');
/*!40000 ALTER TABLE `coletanea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conto`
--

DROP TABLE IF EXISTS `conto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `ano_publicacao` date NOT NULL,
  `nmr_palavras` int NOT NULL,
  `idColetanea` int NOT NULL,
  `idPeriodico` int NOT NULL,
  `idClassificacao` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_titulo` (`titulo`),
  KEY `idClassificacao` (`idClassificacao`),
  KEY `idPeriodico` (`idPeriodico`),
  KEY `idColetanea` (`idColetanea`),
  CONSTRAINT `conto_ibfk_1` FOREIGN KEY (`idClassificacao`) REFERENCES `classificacao` (`id`),
  CONSTRAINT `conto_ibfk_2` FOREIGN KEY (`idPeriodico`) REFERENCES `periodico` (`id`),
  CONSTRAINT `conto_ibfk_3` FOREIGN KEY (`idColetanea`) REFERENCES `coletanea` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conto`
--

LOCK TABLES `conto` WRITE;
/*!40000 ALTER TABLE `conto` DISABLE KEYS */;
INSERT INTO `conto` VALUES (1,'Três Tesouros Perdidos','1858-01-01',687,1,1,5),(2,'O País das Quimeras','1862-11-01',5196,2,2,1),(3,'Frei Simão','1864-06-01',2632,3,3,5),(4,'Virginius','1864-07-01',4928,4,3,5),(5,'O Anjo das Donzelas','1864-09-01',6168,3,3,5),(6,'Casada e Viúva','1864-11-01',4817,4,3,5);
/*!40000 ALTER TABLE `conto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodico`
--

DROP TABLE IF EXISTS `periodico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodico`
--

LOCK TABLES `periodico` WRITE;
/*!40000 ALTER TABLE `periodico` DISABLE KEYS */;
INSERT INTO `periodico` VALUES (1,'A Marmota'),(3,'Jornal das Famílias'),(5,'O Cruzeiro'),(2,'O Futuro'),(4,'Semana Ilustrada');
/*!40000 ALTER TABLE `periodico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-14 18:03:05
