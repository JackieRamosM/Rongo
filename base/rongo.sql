CREATE DATABASE  IF NOT EXISTS `rongo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rongo`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: rongo
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencia` (
  `idasistencia` int(11) NOT NULL AUTO_INCREMENT,
  `idclase` int(11) NOT NULL,
  `idestudiante` int(11) NOT NULL,
  PRIMARY KEY (`idasistencia`),
  KEY `estudianteusuario` (`idestudiante`),
  KEY `asistenciaEstudiante_idx` (`idclase`),
  CONSTRAINT `asistenciaClase` FOREIGN KEY (`idclase`) REFERENCES `clase` (`idclase`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `asistenciaEstudiante` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ayudante`
--

DROP TABLE IF EXISTS `ayudante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ayudante` (
  `idayudante` int(11) NOT NULL AUTO_INCREMENT,
  `idayudantia` int(11) NOT NULL,
  `idEstudiante` int(11) NOT NULL,
  `fechaayudante` date DEFAULT NULL,
  `observacion` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idayudante`),
  KEY `ayudanteAyudantia_idx` (`idayudantia`),
  KEY `estudianteAyudantia_idx` (`idEstudiante`),
  CONSTRAINT `ayudanteAyudantia` FOREIGN KEY (`idayudantia`) REFERENCES `ayudantia` (`idayudantia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `estudianteAyudantia` FOREIGN KEY (`idEstudiante`) REFERENCES `estudiante` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayudante`
--

LOCK TABLES `ayudante` WRITE;
/*!40000 ALTER TABLE `ayudante` DISABLE KEYS */;
INSERT INTO `ayudante` VALUES (1,2,1,'2014-08-23','');
/*!40000 ALTER TABLE `ayudante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ayudantia`
--

DROP TABLE IF EXISTS `ayudantia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ayudantia` (
  `idayudantia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipodeayudantia` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `idsupervisor` int(11) NOT NULL,
  PRIMARY KEY (`idayudantia`),
  KEY `idsupervisor_idx` (`idsupervisor`),
  CONSTRAINT `ayudantiaSupervisor` FOREIGN KEY (`idsupervisor`) REFERENCES `supervisor` (`idsupervisor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayudantia`
--

LOCK TABLES `ayudantia` WRITE;
/*!40000 ALTER TABLE `ayudantia` DISABLE KEYS */;
INSERT INTO `ayudantia` VALUES (1,'Estructrura de Datos','Academica',1),(2,'FIEC03053','academica',4);
/*!40000 ALTER TABLE `ayudantia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ayudantiasofertadas`
--

DROP TABLE IF EXISTS `ayudantiasofertadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ayudantiasofertadas` (
  `idayudantiasofertadas` int(11) NOT NULL AUTO_INCREMENT,
  `cargasemanal` int(11) NOT NULL,
  `otrorequisito` varchar(1000) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vigentedesde` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `vigentehasta` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `idsupervisor` int(11) NOT NULL,
  `tipodeayudantia` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombreayudanatia` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estudianteregular` bit(1) DEFAULT NULL,
  `promediomayorcarrera` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idayudantiasofertadas`),
  KEY `idsuprvisor_idx` (`idsupervisor`),
  CONSTRAINT `ofertadasSupervisor` FOREIGN KEY (`idsupervisor`) REFERENCES `supervisor` (`idsupervisor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayudantiasofertadas`
--

LOCK TABLES `ayudantiasofertadas` WRITE;
/*!40000 ALTER TABLE `ayudantiasofertadas` DISABLE KEYS */;
INSERT INTO `ayudantiasofertadas` VALUES (1,5,'Ser estudiante regular\r. Tener promedio académico mayor a la facultad','Ayudantia para Sw II','2014-08-30 05:21:21','2014-08-28 05:00:00',4,'academica','FIEC03053','\0','\0'),(3,5,'Tener conocimiento en aplicaciones web','Ayudantia en ceemp','2014-08-30 05:21:34','2014-08-28 05:00:00',37,'varias','Soporte tecnico en CEEMP','\0','\0');
/*!40000 ALTER TABLE `ayudantiasofertadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clase` (
  `idclase` int(11) NOT NULL AUTO_INCREMENT,
  `horaini` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `horafin` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idayudantia` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `dioclase` bit(1) DEFAULT NULL,
  `idayudante` int(11) NOT NULL,
  PRIMARY KEY (`idclase`),
  KEY `idayudantia_idx` (`idayudantia`),
  KEY `claseAyudante_idx` (`idayudante`),
  CONSTRAINT `claseAyudante` FOREIGN KEY (`idayudante`) REFERENCES `ayudante` (`idayudante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `claseAyudantia` FOREIGN KEY (`idayudantia`) REFERENCES `ayudantia` (`idayudantia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuestionario`
--

DROP TABLE IF EXISTS `cuestionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuestionario` (
  `idevaluacion_desempeno` int(11) NOT NULL,
  `area` varchar(45) DEFAULT NULL,
  `idayudante` int(11) DEFAULT NULL,
  `idsupervisor` int(11) DEFAULT NULL,
  `desde` date DEFAULT NULL,
  `hasta` date DEFAULT NULL,
  `anioacademicodesde` int(11) DEFAULT NULL,
  `anioacademicohasta` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `tipo` int(11) DEFAULT '1',
  PRIMARY KEY (`idevaluacion_desempeno`),
  KEY `idsupervisor_idx` (`idsupervisor`),
  CONSTRAINT `idsupervisor` FOREIGN KEY (`idsupervisor`) REFERENCES `supervisor` (`idsupervisor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuestionario`
--

LOCK TABLES `cuestionario` WRITE;
/*!40000 ALTER TABLE `cuestionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuestionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
  `Usuario` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `skype` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `twitter` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Intereses` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES ('ljramos','jackieramosm','jackieramosm','dormir xD','',1),('dschuldt','dschuldt','denkschuldt','astro','\0',2),('davalbar','davalbar',NULL,'los video juegos','\0',3),('hcarpio','hcarpio','verdecanibal','cantar','\0',4);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hora_asignada`
--

DROP TABLE IF EXISTS `hora_asignada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hora_asignada` (
  `idhora_asignada` int(11) NOT NULL,
  `Dia` int(11) DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  `idevaluacion1` int(11) DEFAULT NULL,
  PRIMARY KEY (`idhora_asignada`),
  KEY `idevaluacion_idx` (`idevaluacion1`),
  CONSTRAINT `idevaluacion1` FOREIGN KEY (`idevaluacion1`) REFERENCES `cuestionario` (`idevaluacion_desempeno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hora_asignada`
--

LOCK TABLES `hora_asignada` WRITE;
/*!40000 ALTER TABLE `hora_asignada` DISABLE KEYS */;
/*!40000 ALTER TABLE `hora_asignada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `iditem` int(11) NOT NULL,
  `tipo` int(11) DEFAULT '0',
  `contenido` varchar(45) DEFAULT NULL,
  `idevaluacion5` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditem`),
  KEY `idevaluacion5_idx` (`idevaluacion5`),
  CONSTRAINT `idevaluacion5` FOREIGN KEY (`idevaluacion5`) REFERENCES `cuestionario` (`idevaluacion_desempeno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postulacion`
--

DROP TABLE IF EXISTS `postulacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postulacion` (
  `idpostulacion` int(11) NOT NULL AUTO_INCREMENT,
  `archivo` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idayudantiaofertada` int(11) DEFAULT NULL,
  `idestudiante` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpostulacion`),
  KEY `postulacionestudiante_idx` (`idayudantiaofertada`),
  KEY `postulacionestudiante_idx1` (`idestudiante`),
  CONSTRAINT `postulacionayudantiaofertada` FOREIGN KEY (`idayudantiaofertada`) REFERENCES `ayudantiasofertadas` (`idayudantiasofertadas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `postulacionestudiante` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postulacion`
--

LOCK TABLES `postulacion` WRITE;
/*!40000 ALTER TABLE `postulacion` DISABLE KEYS */;
INSERT INTO `postulacion` VALUES (2,'pdf1.pdf',1,3),(3,'',1,1),(4,'',1,4),(5,'',3,4);
/*!40000 ALTER TABLE `postulacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supervisor` (
  `idsupervisor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `cedula` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`idsupervisor`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor`
--

LOCK TABLES `supervisor` WRITE;
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
INSERT INTO `supervisor` VALUES (1,'SIXTO ERNESTO','GARCIA AGUILAR','912456378','sgarcia@espol.edu.ec',''),(2,'CARLOS JOSEPH','MERA GOMEZ','0912345678','cjmera@espol.edu.ec',''),(3,'VICTOR MANUEL','ASANZA ARMIJOS','0912345678','vasanza@espol.ed.ec',''),(4,'DENNY KLEVER','SCHULDT VIZUETE','0987456331','dschuldt@espol.edu.ec',''),(5,'da','vid','666666666','davalbar@espol.edu.ec',''),(36,'JAVIER ALEJANDRO','TIBAU','0912345678','jtibau@espol.edu.ec',''),(37,'GUIDO','CAICEDO ROSSI','0978945612','caicedo@espol.edu.ec','');
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoracion`
--

DROP TABLE IF EXISTS `valoracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valoracion` (
  `idvaloracion` int(11) NOT NULL,
  `criterio` int(11) DEFAULT NULL,
  `calificacion` int(11) DEFAULT NULL,
  `observaciones` varchar(45) DEFAULT NULL,
  `idevaluacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idvaloracion`),
  KEY `idevaluacion_idx` (`idevaluacion`),
  CONSTRAINT `idevaluacion` FOREIGN KEY (`idevaluacion`) REFERENCES `cuestionario` (`idevaluacion_desempeno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoracion`
--

LOCK TABLES `valoracion` WRITE;
/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valordeldesempeno`
--

DROP TABLE IF EXISTS `valordeldesempeno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valordeldesempeno` (
  `idvalordeldesempeno` int(11) NOT NULL AUTO_INCREMENT,
  `criterio` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `calificacion` int(11) DEFAULT NULL,
  `observacion` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idevaluacion2` int(11) DEFAULT NULL,
  PRIMARY KEY (`idvalordeldesempeno`),
  KEY `idevaluacion2_idx` (`idevaluacion2`),
  CONSTRAINT `idevaluacion2` FOREIGN KEY (`idevaluacion2`) REFERENCES `cuestionario` (`idevaluacion_desempeno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valordeldesempeno`
--

LOCK TABLES `valordeldesempeno` WRITE;
/*!40000 ALTER TABLE `valordeldesempeno` DISABLE KEYS */;
/*!40000 ALTER TABLE `valordeldesempeno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-30  0:35:33
