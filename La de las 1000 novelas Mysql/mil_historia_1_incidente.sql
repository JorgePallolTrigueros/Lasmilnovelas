-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mil_historia_1
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente` (
  `id` bigint NOT NULL,
  `descripcion` varchar(450) DEFAULT NULL,
  `descripcion_g` varchar(550) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `orden` int DEFAULT NULL,
  `url` varchar(450) DEFAULT NULL,
  `id_historia` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk31hg3wivhsnvwqdx6mvanend` (`id_historia`),
  CONSTRAINT `FKk31hg3wivhsnvwqdx6mvanend` FOREIGN KEY (`id_historia`) REFERENCES `historia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
INSERT INTO `incidente` VALUES (1,NULL,NULL,'El marco y la Barandilla ',1,'inci\\2.png',14),(2,NULL,NULL,'El ascensor sube y baja',5,'inci\\3.png',14),(3,NULL,NULL,'La piscina y el despacho',1,'inci\\4.png',12),(4,NULL,NULL,'El jardin de los sumos',1,'inci\\5.png',6),(5,NULL,NULL,'El baño de los sumos',3,'inci\\6.png',6),(6,NULL,NULL,'El camerino de la estrella',66,'inci\\7.png',14),(7,NULL,NULL,'las rejas',2,'inci\\8.png',12),(8,NULL,NULL,'En el baño del avion',4,'inci\\9.png',6),(9,NULL,NULL,'En el cine fonfesion',1,'inci\\10.png',9),(10,NULL,NULL,'Piscina semipublica',177,'inci\\11.png',14),(11,NULL,NULL,'Establo con cerdo y todo',2,'inci\\12.png',9),(12,NULL,NULL,'un taller de coches',155,'inci\\13.png',14),(13,NULL,NULL,'Cocina industrial',16,'inci\\14.png',6),(14,NULL,NULL,'Noria',2,'inci\\15.png',7),(15,NULL,NULL,'Teleferico',22,'inci\\16.png',7),(16,NULL,NULL,'El Secuestro de Abela Kay',222,'inci\\17.png',14);
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 16:50:50
