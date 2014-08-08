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
  CONSTRAINT `asistenciaEstudiante` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `asistenciaClase` FOREIGN KEY (`idclase`) REFERENCES `clase` (`idclase`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `estudianteAyudantia` FOREIGN KEY (`idEstudiante`) REFERENCES `estudiante` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ayudanteAyudantia` FOREIGN KEY (`idayudantia`) REFERENCES `ayudantia` (`idayudantia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayudante`
--

LOCK TABLES `ayudante` WRITE;
/*!40000 ALTER TABLE `ayudante` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayudantia`
--

LOCK TABLES `ayudantia` WRITE;
/*!40000 ALTER TABLE `ayudantia` DISABLE KEYS */;
INSERT INTO `ayudantia` VALUES (1,'Estructrura de Datos','Academica',1);
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
  `requisitos` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `vigentedesde` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `vigentehasta` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `idsupervisor` int(11) NOT NULL,
  `tipodeayudantia` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idayudantiasofertadas`),
  KEY `idsuprvisor_idx` (`idsupervisor`),
  CONSTRAINT `ofertadasSupervisor` FOREIGN KEY (`idsupervisor`) REFERENCES `supervisor` (`idsupervisor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayudantiasofertadas`
--

LOCK TABLES `ayudantiasofertadas` WRITE;
/*!40000 ALTER TABLE `ayudantiasofertadas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ayudantiasofertadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camposcuestionario`
--

DROP TABLE IF EXISTS `camposcuestionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camposcuestionario` (
  `idcamposcuestionario` int(11) NOT NULL AUTO_INCREMENT,
  `idvalordesempeno` int(11) NOT NULL,
  PRIMARY KEY (`idcamposcuestionario`),
  KEY `idvalordeldesempeno_idx` (`idvalordesempeno`),
  CONSTRAINT `camposDesepeno` FOREIGN KEY (`idvalordesempeno`) REFERENCES `valordeldesempeno` (`idvalordeldesempeno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camposcuestionario`
--

LOCK TABLES `camposcuestionario` WRITE;
/*!40000 ALTER TABLE `camposcuestionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `camposcuestionario` ENABLE KEYS */;
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
  PRIMARY KEY (`idclase`),
  KEY `idayudantia_idx` (`idayudantia`),
  CONSTRAINT `claseAyudantia` FOREIGN KEY (`idayudantia`) REFERENCES `ayudantia` (`idayudantia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
INSERT INTO `clase` VALUES (1,'2014-07-30 18:30:00','2014-07-30 19:30:00','Grafos y Arboles',1,'2014-07-30','');
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuestionario`
--

DROP TABLE IF EXISTS `cuestionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuestionario` (
  `idcuestionario` int(11) NOT NULL AUTO_INCREMENT,
  `tipocuestionario` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `idcamposcuestionario` int(11) NOT NULL,
  PRIMARY KEY (`idcuestionario`),
  KEY `idcamposcuestionario_idx` (`idcamposcuestionario`),
  CONSTRAINT `cuestionarioCampos` FOREIGN KEY (`idcamposcuestionario`) REFERENCES `camposcuestionario` (`idcamposcuestionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuestionario`
--

LOCK TABLES `cuestionario` WRITE;
/*!40000 ALTER TABLE `cuestionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuestionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curriculum`
--

DROP TABLE IF EXISTS `curriculum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curriculum` (
  `idcurriculum` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `archivo` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcurriculum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curriculum`
--

LOCK TABLES `curriculum` WRITE;
/*!40000 ALTER TABLE `curriculum` DISABLE KEYS */;
/*!40000 ALTER TABLE `curriculum` ENABLE KEYS */;
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
  `idcurriculum` int(11) NOT NULL,
  `idcuestionario` int(11) NOT NULL,
  `admin` bit(1) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUsuario`),
  KEY `idcurriculum_idx` (`idcurriculum`),
  KEY `idcuestionario_idx` (`idcuestionario`),
  CONSTRAINT `estudianteCuestionario` FOREIGN KEY (`idcuestionario`) REFERENCES `cuestionario` (`idcuestionario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `estudianteCurriculum` FOREIGN KEY (`idcurriculum`) REFERENCES `curriculum` (`idcurriculum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
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
  `idcuestionario` int(11) DEFAULT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`idsupervisor`),
  KEY `supervisorCuestionario_idx` (`idcuestionario`),
  CONSTRAINT `supervisorCuestionario` FOREIGN KEY (`idcuestionario`) REFERENCES `cuestionario` (`idcuestionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor`
--

LOCK TABLES `supervisor` WRITE;
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
INSERT INTO `supervisor` VALUES (1,'Sixto','Garcia','912456378','sgarcia',NULL,''),(34,'Liliana ','Ramos','0921886743','ljramos@espol.edu.ec',NULL,'');
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;
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
  PRIMARY KEY (`idvalordeldesempeno`)
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

-- Dump completed on 2014-08-07 23:01:36
