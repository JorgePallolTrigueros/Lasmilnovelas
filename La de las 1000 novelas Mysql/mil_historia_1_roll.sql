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
-- Table structure for table `roll`
--

DROP TABLE IF EXISTS `roll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roll` (
  `id` bigint NOT NULL,
  `descripcion` varchar(4550) DEFAULT NULL,
  `incidente` int DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `url` varchar(550) DEFAULT NULL,
  `id_personaje` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgoydaswkfudmk3qeecyrxc07x` (`id_personaje`),
  CONSTRAINT `FKgoydaswkfudmk3qeecyrxc07x` FOREIGN KEY (`id_personaje`) REFERENCES `personaje` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roll`
--

LOCK TABLES `roll` WRITE;
/*!40000 ALTER TABLE `roll` DISABLE KEYS */;
INSERT INTO `roll` VALUES (1,'Cuando este hombre encontró la casa que era un piso franco de la organización fue con su compañero de instituto que era el informático ántrax dentro de la casa este que era mucho más agresivo que su compañero no reculo el indica a chico nuevo del grupo y a su amigo te esperara cena bajo y que se escondieran y en cuanto vieron aparecer a uno de los agentes le avisaran él se pondría a revolver por toda la habitación lo que más letra abre 11 día no fuera que sus compañeros no pudieran avisarle por la falta de batería del móvil de uno de ellos sino que el tío leñera y se burlara de el dándole el marco de un cuadro no sé si le dolió más la humillación el puño que consiguió derribarlo',1,NULL,'inci\\1\\b.jpg',1001),(2,'No solo era amigo del fran divo sino tambien hania tenido la gran suerte de haver participado en una actuación con el. Por ello cuandoempezó a saber que su amigohabía sido puesto en el punto de mira no solo quiso estar en ekl gran estreno de Aida con el sino ademas de estar coimo gran guardaespaldas \'',6,'1','inci\\6\\b.jpg',1001),(3,'Esperaba el momento en que fuera a verlo a su oficina. Por lo que al saber que havian conseguido atrapar Abela Kay no tardo un momento en decir que lo llevaran a su oficina',16,NULL,'inci\\16\\b.jpg',1001),(4,'guión necesario qué tal como estaba enfadado amigo por las anteriores metidas de pata decidió irse con el nuevo y esperar en la parte de abajo del edificio por si hubiera que haber nuevas complicaciones cuando divisor tío se puso directamente a llamar a su compañero por el busca la mala cobertura y la protección del propio edificio impidió que se pudiera programa para lasaña nervioso al ver cómo el tío salía de la noso sin un rasguño y viendo que rápidamente decidía bajarse por las barandilla este decidió con un salto impresionante subirse encima de la barandilla a esperar a que viniera adversario lo que no esperaba es que viniera otra persona más',1,NULL,'inci\\1\\a.jpg',1002),(5,'No era aficionado a las operas pero si ajustar cuentas y la cuenta con la organización era una que siempre estaba pendiente. Asi que cuando supo que un famoso tenor estaba siendo objetivo y este conocia a su primo de Aitor',6,NULL,'inci\\6\\a.jpg',1002),(6,'Habian secuestrado a uno de los peores de la organización por ello aunque estaba de vacaciones fue a la oficina le tenia muchas ganas',16,NULL,'inci\\16\\a.jpg',1002),(7,'Sin Comerlo ni beberlo el tiop se acerco a su escolta en el palco y los ataco',6,NULL,'null',1024),(8,'Reacciono terriblemente cuando vioo que atavava a sui',6,NULL,'null',1025),(9,'Le encanto la Mision desde el principio',6,NULL,'null',1026),(10,'Le engañaron pensando que seria un fan. No solo eso. Cuando su amigo el empresario se dio cuenta que estaba en peligro',6,NULL,'null',1023),(11,'Reconocio al ver al tio. Su retratop habia estado en el cuaderno de el Angel. Con la señal de Cuidado. El fallo fue decir su nombre. Mientras era el escolta de l divo',6,NULL,'null',15),(12,'El agente',1,NULL,'inci\\1\\f.jpg',1000);
/*!40000 ALTER TABLE `roll` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 16:50:49
