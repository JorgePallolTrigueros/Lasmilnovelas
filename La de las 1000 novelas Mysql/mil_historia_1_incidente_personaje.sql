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
-- Table structure for table `incidente_personaje`
--

DROP TABLE IF EXISTS `incidente_personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente_personaje` (
  `id_incidente` bigint NOT NULL,
  `id_etiquetas` bigint NOT NULL,
  `incidente_personajecol` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`incidente_personajecol`),
  KEY `FKbslmt85r5bg4wijjhpvbe5uxm` (`id_etiquetas`),
  KEY `FK6cy6kdw2kgurxko4axsop96c9` (`id_incidente`),
  CONSTRAINT `FK6cy6kdw2kgurxko4axsop96c9` FOREIGN KEY (`id_incidente`) REFERENCES `incidente` (`id`),
  CONSTRAINT `FKbslmt85r5bg4wijjhpvbe5uxm` FOREIGN KEY (`id_etiquetas`) REFERENCES `personaje` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente_personaje`
--

LOCK TABLES `incidente_personaje` WRITE;
/*!40000 ALTER TABLE `incidente_personaje` DISABLE KEYS */;
INSERT INTO `incidente_personaje` VALUES (1,1000,1),(1,1001,2),(1,1002,3),(6,1001,4),(6,1002,5),(16,1001,6),(16,1002,7),(1,1003,8),(1,1004,9),(14,1057,10),(14,1058,11),(2,1005,12),(2,1006,13),(2,1007,14),(2,1008,15),(2,1009,16),(2,1005,17),(2,1006,18),(2,1007,19),(2,1008,20),(2,1009,21),(3,1010,22),(3,1011,23),(3,1012,24),(3,1013,25),(3,1014,26),(5,1018,27),(5,1019,28),(5,1020,29),(5,1021,30),(5,1022,31),(6,1023,32),(6,1024,33),(6,1025,34),(6,1026,35),(7,1027,36),(7,1028,37),(7,1029,38),(8,1030,39),(8,1031,40),(8,1032,41),(8,1033,42),(9,1034,43),(9,1035,44),(9,1036,45),(10,1037,46),(10,1038,47),(10,1039,48),(10,1041,49),(10,1040,50),(11,1042,51),(11,1043,52),(11,1044,53),(11,1045,54),(11,1046,55),(12,1047,56),(12,1048,57),(12,1049,58),(12,1050,59),(12,1051,60),(13,1052,61),(13,1053,62),(13,1054,63),(13,1055,64),(13,1056,65),(14,1057,66),(14,1058,67),(15,1059,68),(15,1060,69);
/*!40000 ALTER TABLE `incidente_personaje` ENABLE KEYS */;
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
