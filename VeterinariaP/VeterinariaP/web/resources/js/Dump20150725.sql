CREATE DATABASE  IF NOT EXISTS `db_petclub` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_petclub`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: db_petclub
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acceso` (
  `idoacceso` int(11) NOT NULL AUTO_INCREMENT,
  `idopcion` int(11) NOT NULL,
  `idTipo_Empleado` int(11) NOT NULL,
  `estado_acc` int(11) DEFAULT NULL,
  PRIMARY KEY (`idoacceso`),
  KEY `fk_Menu_has_Tipo_Empleado_Tipo_Empleado1_idx` (`idTipo_Empleado`),
  KEY `fk_Menu_has_Tipo_Empleado_Menu1_idx` (`idopcion`),
  CONSTRAINT `fk_Menu_has_Tipo_Empleado_Menu1` FOREIGN KEY (`idopcion`) REFERENCES `opcion` (`idopcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Menu_has_Tipo_Empleado_Tipo_Empleado1` FOREIGN KEY (`idTipo_Empleado`) REFERENCES `tipo_empleado` (`idTipo_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asociado`
--

DROP TABLE IF EXISTS `asociado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asociado` (
  `idAsociado` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) DEFAULT NULL,
  `ape_pat` varchar(45) DEFAULT NULL,
  `ape_mat` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `telef` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `direcc` varchar(150) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `idDistrito` int(11) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `ruc` char(11) DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `linea_asccredito` int(11) DEFAULT NULL,
  `estado_asc` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAsociado`),
  KEY `fk_Asociado_Distrito_idx` (`idDistrito`),
  CONSTRAINT `fk_Asociado_Distrito` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asociado`
--

LOCK TABLES `asociado` WRITE;
/*!40000 ALTER TABLE `asociado` DISABLE KEYS */;
INSERT INTO `asociado` VALUES (1,'ALBERTO','SANCHEZ','PEREZ','MASCULINO','2015-07-02','2586639','87156974','JR SUAREZ  NRO 145','SANCHEZZ@HOTMAIL.COM',1,'NDAxMTk1ODk=','12457845564','40119589',NULL,NULL,1),(2,'SABINA','LAZARO','QUISPE','FEMENINO','2015-07-09','1258669','98569874','MI CASA','QUISPE@HOTMAIL.COM',6,'NTQ3ODU2MTI=','21457898654','54785612',NULL,NULL,1);
/*!40000 ALTER TABLE `asociado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria`
--

DROP TABLE IF EXISTS `auditoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auditoria` (
  `idAuditoria` int(11) NOT NULL AUTO_INCREMENT,
  `fechaLogin` datetime DEFAULT NULL,
  `fechaLogout` datetime DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `tiempo` varchar(45) DEFAULT NULL,
  `idSede` int(11) NOT NULL,
  `estado_aud` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAuditoria`),
  KEY `fk_Auditoria_Sede1_idx` (`idSede`),
  CONSTRAINT `fk_Auditoria_Sede1` FOREIGN KEY (`idSede`) REFERENCES `sede` (`idSede`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria`
--

LOCK TABLES `auditoria` WRITE;
/*!40000 ALTER TABLE `auditoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cat` varchar(45) DEFAULT NULL,
  `estado_cat` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita_medica`
--

DROP TABLE IF EXISTS `cita_medica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cita_medica` (
  `idCita_medica` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` datetime DEFAULT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado_cita` varchar(45) DEFAULT NULL,
  `idMascota` int(11) NOT NULL,
  `idAsociado` int(11) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `estado_cit` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCita_medica`),
  KEY `fk_Cita_medica_Mascota1_idx` (`idMascota`),
  KEY `fk_Cita_medica_Empleado` (`idEmpleado`),
  KEY `fk_ID_ASOCIADO` (`idAsociado`),
  CONSTRAINT `fk_Cita_medica_Empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_medica_Mascota1` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ID_ASOCIADO` FOREIGN KEY (`idAsociado`) REFERENCES `asociado` (`idAsociado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita_medica`
--

LOCK TABLES `cita_medica` WRITE;
/*!40000 ALTER TABLE `cita_medica` DISABLE KEYS */;
INSERT INTO `cita_medica` VALUES (1,'2015-07-25 08:30:00','2015-07-25 09:00:00','CITA MEDICA','1',1,1,2,1),(2,'2015-07-25 09:00:00','2015-07-25 09:30:00','CITA MEDICA','1',2,2,2,1);
/*!40000 ALTER TABLE `cita_medica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita_servicio`
--

DROP TABLE IF EXISTS `cita_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cita_servicio` (
  `idCita_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `idDisponibilidad_s` int(11) NOT NULL,
  `idMascota` int(11) NOT NULL,
  `idSede` int(11) NOT NULL,
  `fecha_cita_s` date DEFAULT NULL,
  `obs_cita_s` varchar(45) DEFAULT NULL,
  `estado_cita_s` varchar(45) DEFAULT NULL,
  `estado_cts` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCita_servicio`),
  KEY `fk_Cita_servicio_Sede1_idx` (`idSede`),
  KEY `fk_Cita_servicio_Mascota1_idx` (`idMascota`),
  KEY `fk_Cita_servicio_Disponibilidad_S1_idx` (`idDisponibilidad_s`),
  CONSTRAINT `fk_Cita_servicio_Sede1` FOREIGN KEY (`idSede`) REFERENCES `sede` (`idSede`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_servicio_Mascota1` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_servicio_Disponibilidad_S1` FOREIGN KEY (`idDisponibilidad_s`) REFERENCES `disponibilidad_s` (`idDisponibilidad_s`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita_servicio`
--

LOCK TABLES `cita_servicio` WRITE;
/*!40000 ALTER TABLE `cita_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobante_pago`
--

DROP TABLE IF EXISTS `comprobante_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobante_pago` (
  `idComprobante_pago` int(11) NOT NULL AUTO_INCREMENT,
  `idIGV` int(11) NOT NULL,
  `idAsociado` int(11) NOT NULL,
  `fecha_comp` datetime DEFAULT NULL,
  `estado_com` int(11) DEFAULT NULL,
  PRIMARY KEY (`idComprobante_pago`),
  KEY `fk_Comprobante_pago_Asociado1_idx` (`idAsociado`),
  KEY `fk_Comprobante_pago_IGV1_idx` (`idIGV`),
  CONSTRAINT `fk_Comprobante_pago_Asociado1` FOREIGN KEY (`idAsociado`) REFERENCES `asociado` (`idAsociado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comprobante_pago_IGV1` FOREIGN KEY (`idIGV`) REFERENCES `igv` (`idIGV`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante_pago`
--

LOCK TABLES `comprobante_pago` WRITE;
/*!40000 ALTER TABLE `comprobante_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprobante_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_comprobante_pago`
--

DROP TABLE IF EXISTS `detalle_comprobante_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_comprobante_pago` (
  `idDetalle_Comprobante` int(11) NOT NULL AUTO_INCREMENT,
  `idComprobante_pago` int(11) NOT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `estado_dep` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDetalle_Comprobante`),
  KEY `fk_Producto_has_Comprobante_pago_Comprobante_pago1_idx` (`idComprobante_pago`),
  KEY `fk_Producto_has_Comprobante_pago_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_Producto_has_Comprobante_pago_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Comprobante_pago_Comprobante_pago1` FOREIGN KEY (`idComprobante_pago`) REFERENCES `comprobante_pago` (`idComprobante_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_comprobante_pago`
--

LOCK TABLES `detalle_comprobante_pago` WRITE;
/*!40000 ALTER TABLE `detalle_comprobante_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_comprobante_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_factura` (
  `IdDetalle_Factura` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `idFactura_prov` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `estado_detf` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdDetalle_Factura`),
  KEY `fk_Producto_has_Factura_Proveedor_Factura_Proveedor1_idx` (`idFactura_prov`),
  KEY `fk_Producto_has_Factura_Proveedor_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_Producto_has_Factura_Proveedor_Factura_Proveedor1` FOREIGN KEY (`idFactura_prov`) REFERENCES `factura_proveedor` (`idFactura_prov`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Factura_Proveedor_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_factura`
--

LOCK TABLES `detalle_factura` WRITE;
/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pago`
--

DROP TABLE IF EXISTS `detalle_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_pago` (
  `idDetalle_Pago` int(11) NOT NULL AUTO_INCREMENT,
  `idFactura_prov` int(11) NOT NULL,
  `tipo_pago` varchar(45) DEFAULT NULL,
  `numero_docl` varchar(45) DEFAULT NULL,
  `fecha_pago` varchar(45) DEFAULT NULL,
  `monto_pagado` varchar(45) DEFAULT NULL,
  `Detalle_Pagocol` varchar(45) DEFAULT NULL,
  `estado_detp` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDetalle_Pago`),
  KEY `fk_Detalle_Pago_Pago_Proveedor1` (`idFactura_prov`),
  CONSTRAINT `fk_Detalle_Pago_Pago_Proveedor1` FOREIGN KEY (`idFactura_prov`) REFERENCES `pago_proveedor` (`idFactura_prov`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pago`
--

LOCK TABLES `detalle_pago` WRITE;
/*!40000 ALTER TABLE `detalle_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_sede_producto`
--

DROP TABLE IF EXISTS `detalle_sede_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_sede_producto` (
  `idDetalle_Sede_Producto` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `estado_dsp` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDetalle_Sede_Producto`),
  KEY `fk_Sede_has_Producto_Producto1_idx` (`idProducto`),
  KEY `fk_Sede_has_Producto_Sede1_idx` (`idSede`),
  CONSTRAINT `fk_Sede_has_Producto_Sede1` FOREIGN KEY (`idSede`) REFERENCES `sede` (`idSede`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sede_has_Producto_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_sede_producto`
--

LOCK TABLES `detalle_sede_producto` WRITE;
/*!40000 ALTER TABLE `detalle_sede_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_sede_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnostico` (
  `idDiagnostico` int(11) NOT NULL AUTO_INCREMENT,
  `idHistoria_Clinica` int(11) NOT NULL,
  `idCita_medica` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `peso` varchar(45) DEFAULT NULL,
  `talla` varchar(45) DEFAULT NULL,
  `atendido_por` varchar(45) DEFAULT NULL,
  `mucosas` varchar(45) DEFAULT NULL,
  `motivo` varchar(45) DEFAULT NULL,
  `examen_cli` varchar(45) DEFAULT NULL,
  `diagnostico` varchar(45) DEFAULT NULL,
  `analisis_solicitados` varchar(45) DEFAULT NULL,
  `tratamiento` varchar(45) DEFAULT NULL,
  `proxima_cita` varchar(45) DEFAULT NULL,
  `estado_dia` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDiagnostico`),
  KEY `fk_Diagnostico_Historia_Clinica1_idx` (`idHistoria_Clinica`),
  KEY `fk_Diagnostico_Cita_medica1_idx` (`idCita_medica`),
  CONSTRAINT `fk_Diagnostico_Historia_Clinica1` FOREIGN KEY (`idHistoria_Clinica`) REFERENCES `historia_clinica` (`idHistoria_Clinica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Diagnostico_Cita_medica1` FOREIGN KEY (`idCita_medica`) REFERENCES `cita_medica` (`idCita_medica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostico_vacuna`
--

DROP TABLE IF EXISTS `diagnostico_vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnostico_vacuna` (
  `idDiagnostico_Vacuna` int(11) NOT NULL AUTO_INCREMENT,
  `idHistoria_Clinica` int(11) NOT NULL,
  `idDiagnostico` int(11) NOT NULL,
  `idVacuna` int(11) NOT NULL,
  `estado_dvac` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDiagnostico_Vacuna`),
  KEY `fk_Diagnostico_has_Vacuna_Vacuna1_idx` (`idVacuna`),
  KEY `fk_Diagnostico_has_Vacuna_Diagnostico1_idx` (`idHistoria_Clinica`),
  KEY `fk_Diagnostico_has_idDiagnostico1` (`idDiagnostico`),
  CONSTRAINT `fk_Diagnostico_has_Vacuna_Diagnostico1` FOREIGN KEY (`idHistoria_Clinica`) REFERENCES `historia_clinica` (`idHistoria_Clinica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Diagnostico_has_Vacuna_Vacuna1` FOREIGN KEY (`idVacuna`) REFERENCES `vacuna` (`idVacuna`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Diagnostico_has_idDiagnostico1` FOREIGN KEY (`idDiagnostico`) REFERENCES `diagnostico` (`idDiagnostico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico_vacuna`
--

LOCK TABLES `diagnostico_vacuna` WRITE;
/*!40000 ALTER TABLE `diagnostico_vacuna` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnostico_vacuna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disponibilidad_m`
--

DROP TABLE IF EXISTS `disponibilidad_m`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disponibilidad_m` (
  `idDisponibilidad_m` int(11) NOT NULL AUTO_INCREMENT,
  `idSede` int(11) NOT NULL,
  `fecha_disp_m` varchar(45) DEFAULT NULL,
  `hora_disp_m` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `estado_dim` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDisponibilidad_m`),
  KEY `fk_Disponibilidad_M_Sede1_idx` (`idSede`),
  CONSTRAINT `fk_Disponibilidad_M_Sede1` FOREIGN KEY (`idSede`) REFERENCES `sede` (`idSede`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disponibilidad_m`
--

LOCK TABLES `disponibilidad_m` WRITE;
/*!40000 ALTER TABLE `disponibilidad_m` DISABLE KEYS */;
/*!40000 ALTER TABLE `disponibilidad_m` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disponibilidad_s`
--

DROP TABLE IF EXISTS `disponibilidad_s`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disponibilidad_s` (
  `idDisponibilidad_s` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_disp_s` varchar(45) DEFAULT NULL,
  `hora_disp_s` varchar(45) DEFAULT NULL,
  `idProducto` int(11) NOT NULL,
  `estado_dip` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDisponibilidad_s`),
  KEY `fk_Disponibilidad_S_Producto1_idx` (`idProducto`),
  CONSTRAINT `fk_Disponibilidad_S_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disponibilidad_s`
--

LOCK TABLES `disponibilidad_s` WRITE;
/*!40000 ALTER TABLE `disponibilidad_s` DISABLE KEYS */;
/*!40000 ALTER TABLE `disponibilidad_s` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `idDistrito` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado_dis` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES (1,'Ate',NULL),(2,'Barranco',NULL),(3,'Breña',NULL),(4,'Comas',NULL),(5,'Chorrillos',NULL),(6,'El Agustino',NULL),(7,'Jesús María',NULL),(8,'La Molina',NULL),(9,'La Victoria',NULL),(10,'Lince',NULL),(11,'Magdalena del Mar',NULL),(12,'Miraflores',NULL),(13,'Pueblo Libre',NULL),(14,'Puente Piedra',NULL),(15,'Rimac',NULL),(16,'San Isidro',NULL),(17,'Independencia',NULL),(18,'San Juan de Miraflores',NULL),(19,'San Luis',NULL),(20,'San Martin de Porres',NULL),(21,'San Miguel',NULL),(22,'Santiago de Surco',NULL),(23,'Surquillo',NULL),(24,'Villa María del Triunfo',NULL),(25,'San Juan de Lurigancho',NULL),(26,'Santa Rosa',NULL),(27,'Los Olivos',NULL),(28,'San Borja',NULL),(29,'Villa El Savador',NULL),(30,'Santa Anita',NULL);
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `dni` char(8) NOT NULL,
  `nom_emp` varchar(45) DEFAULT NULL,
  `ape_pat_emp` varchar(45) DEFAULT NULL,
  `ape_mat_emp` varchar(45) DEFAULT NULL,
  `fecha_ing_emp` date DEFAULT NULL,
  `estado_emp` int(11) DEFAULT NULL,
  `email_emp` varchar(45) DEFAULT NULL,
  `genero_emp` varchar(45) DEFAULT NULL,
  `fecha_naci_emp` date DEFAULT NULL,
  `idHorario` int(11) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `idTipo_Empleado` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_Empleado_Horario1_idx` (`idHorario`),
  KEY `fk_Empleado_TipoEmple1` (`idTipo_Empleado`),
  CONSTRAINT `fk_Empleado_Horario1` FOREIGN KEY (`idHorario`) REFERENCES `horario` (`idHorario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_TipoEmple1` FOREIGN KEY (`idTipo_Empleado`) REFERENCES `tipo_empleado` (`idTipo_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'40119577','RICHARD','CHIPANA','AVENDAÑO','2015-04-01',1,'sonidochipana@hotmail.com','MASCULINO','1900-07-13',1,'MTIzNDU2',1),(2,'40119578','ALICIA','CHIPANA','AVENDAÑO','2015-07-09',1,'sonido@hotmail.com','FEMENINO','2015-07-01',1,'NDAxMTk1Nzg=',2),(3,'40119571','JUAN','LOPEZ','PERALTA','2015-07-09',1,'sonido@hotmail.com','MASCULINO','2015-07-01',1,'NDAxMTk1NzE=',2),(4,'40119572','PEDRO','LOA','LOA','2015-07-09',1,'sonido@hotmail.com','MASCULINO','2015-07-01',1,'NDAxMTk1NzI=',2);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especie`
--

DROP TABLE IF EXISTS `especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especie` (
  `idEspecie` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado_esp` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEspecie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especie`
--

LOCK TABLES `especie` WRITE;
/*!40000 ALTER TABLE `especie` DISABLE KEYS */;
/*!40000 ALTER TABLE `especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura_proveedor`
--

DROP TABLE IF EXISTS `factura_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_proveedor` (
  `idFactura_prov` int(11) NOT NULL AUTO_INCREMENT,
  `idProveedor` int(11) NOT NULL,
  `tipo_pago_fact` varchar(45) DEFAULT NULL,
  `fecha_fact` date DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL,
  `total_fact` decimal(10,0) DEFAULT NULL,
  `estado_fact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFactura_prov`),
  KEY `fk_Factura_Proveedor_Proveedor1_idx` (`idProveedor`),
  CONSTRAINT `fk_Factura_Proveedor_Proveedor1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura_proveedor`
--

LOCK TABLES `factura_proveedor` WRITE;
/*!40000 ALTER TABLE `factura_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia_clinica`
--

DROP TABLE IF EXISTS `historia_clinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historia_clinica` (
  `idHistoria_Clinica` int(11) NOT NULL AUTO_INCREMENT,
  `idMascota` int(11) NOT NULL,
  `fecha_reg` date DEFAULT NULL,
  `peso` varchar(45) DEFAULT NULL,
  `talla` varchar(45) DEFAULT NULL,
  `mucosas` varchar(45) DEFAULT NULL,
  `anamnesis` varchar(45) DEFAULT NULL,
  `otroconsultorio` int(11) DEFAULT NULL,
  `tratamiento` varchar(45) DEFAULT NULL,
  `estado_his` int(11) DEFAULT NULL,
  PRIMARY KEY (`idHistoria_Clinica`),
  KEY `fk_Historia_Clinica_Mascota1_idx` (`idMascota`),
  CONSTRAINT `fk_Historia_Clinica_Mascota1` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia_clinica`
--

LOCK TABLES `historia_clinica` WRITE;
/*!40000 ALTER TABLE `historia_clinica` DISABLE KEYS */;
/*!40000 ALTER TABLE `historia_clinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia_clinica_has_vacuna`
--

DROP TABLE IF EXISTS `historia_clinica_has_vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historia_clinica_has_vacuna` (
  `IdHistoria_Clinica_has_Vacuna` int(11) NOT NULL AUTO_INCREMENT,
  `idHistoria_Clinica` int(11) NOT NULL,
  `idVacuna` int(11) NOT NULL,
  `estado_hvac` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdHistoria_Clinica_has_Vacuna`),
  KEY `fk_Historia_Clinica_has_Vacuna_Vacuna1_idx` (`idVacuna`),
  KEY `fk_Historia_Clinica_has_Vacuna_Historia_Clinica1_idx` (`idHistoria_Clinica`),
  CONSTRAINT `fk_Historia_Clinica_has_Vacuna_Historia_Clinica1` FOREIGN KEY (`idHistoria_Clinica`) REFERENCES `historia_clinica` (`idHistoria_Clinica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historia_Clinica_has_Vacuna_Vacuna1` FOREIGN KEY (`idVacuna`) REFERENCES `vacuna` (`idVacuna`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia_clinica_has_vacuna`
--

LOCK TABLES `historia_clinica_has_vacuna` WRITE;
/*!40000 ALTER TABLE `historia_clinica_has_vacuna` DISABLE KEYS */;
/*!40000 ALTER TABLE `historia_clinica_has_vacuna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(50) DEFAULT NULL,
  `estado_hor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (1,'MAÑANA',1),(2,'TARDE',1),(3,'NOCHE',1);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `igv`
--

DROP TABLE IF EXISTS `igv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `igv` (
  `idIGV` int(11) NOT NULL AUTO_INCREMENT,
  `porcentaje` varchar(45) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `estado_igv` int(11) DEFAULT NULL,
  PRIMARY KEY (`idIGV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igv`
--

LOCK TABLES `igv` WRITE;
/*!40000 ALTER TABLE `igv` DISABLE KEYS */;
/*!40000 ALTER TABLE `igv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mascota` (
  `idMascota` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `ruta` varchar(50) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `fecha_ing` date DEFAULT NULL,
  `sexo` int(11) DEFAULT NULL,
  `castrado` int(11) DEFAULT NULL,
  `deceso` int(11) DEFAULT NULL,
  `idAsociado` int(11) NOT NULL,
  `idRaza` int(11) DEFAULT NULL,
  `idPelaje` int(11) DEFAULT NULL,
  `estado_mas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMascota`),
  KEY `fk_Mascota_Asociado1_idx` (`idAsociado`),
  KEY `fk_Mascota_Raza1_idx` (`idRaza`),
  KEY `fk_Mascota_Pelaje1_idx` (`idPelaje`),
  CONSTRAINT `fk_Mascota_Asociado1` FOREIGN KEY (`idAsociado`) REFERENCES `asociado` (`idAsociado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mascota_Raza1` FOREIGN KEY (`idRaza`) REFERENCES `raza` (`idRaza`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mascota_Pelaje1` FOREIGN KEY (`idPelaje`) REFERENCES `pelaje` (`idPelaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (1,'GRINGA','Rch_60f2894.JPG','2014-12-22','2015-07-25',1,0,NULL,1,NULL,1,NULL),(2,'RUFO','Rch_80ca753.JPG','2015-01-20','2015-07-25',1,0,NULL,2,NULL,1,NULL);
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `Codigo_Menu` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `tipo` enum('S','T') DEFAULT NULL,
  `idTipo_Empleado` int(11) NOT NULL,
  `codigoSubMenu` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`Codigo_Menu`),
  KEY `fk_idTipo_Empleado` (`idTipo_Empleado`),
  KEY `fk_codigoSubMenu` (`codigoSubMenu`),
  CONSTRAINT `fk_idTipo_Empleado` FOREIGN KEY (`idTipo_Empleado`) REFERENCES `tipo_empleado` (`idTipo_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_codigoSubMenu` FOREIGN KEY (`codigoSubMenu`) REFERENCES `menu` (`Codigo_Menu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcion`
--

DROP TABLE IF EXISTS `opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcion` (
  `idopcion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL,
  `estado_opc` int(11) DEFAULT NULL,
  PRIMARY KEY (`idopcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcion`
--

LOCK TABLES `opcion` WRITE;
/*!40000 ALTER TABLE `opcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago_pendiente`
--

DROP TABLE IF EXISTS `pago_pendiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago_pendiente` (
  `idPago_pendiente` int(11) NOT NULL AUTO_INCREMENT,
  `idComprobante_pago` int(11) NOT NULL,
  `fecha_pago` datetime DEFAULT NULL,
  `fecha_nueva` datetime DEFAULT NULL,
  `monto_total_pagar` decimal(10,0) DEFAULT NULL,
  `estado_pap` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPago_pendiente`),
  KEY `fk_Pago_pendiente_Comprobante_pago1_idx` (`idComprobante_pago`),
  CONSTRAINT `fk_Pago_pendiente_Comprobante_pago1` FOREIGN KEY (`idComprobante_pago`) REFERENCES `comprobante_pago` (`idComprobante_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_pendiente`
--

LOCK TABLES `pago_pendiente` WRITE;
/*!40000 ALTER TABLE `pago_pendiente` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago_pendiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago_proveedor`
--

DROP TABLE IF EXISTS `pago_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago_proveedor` (
  `idPago_Proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `idFactura_prov` int(11) NOT NULL,
  `monto_actual_pago` varchar(45) DEFAULT NULL,
  `estado_pagp` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPago_Proveedor`),
  KEY `fk_Pago_Proveedor_Factura_Proveedor1_idx` (`idFactura_prov`),
  CONSTRAINT `fk_Pago_Proveedor_Factura_Proveedor1` FOREIGN KEY (`idFactura_prov`) REFERENCES `factura_proveedor` (`idFactura_prov`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_proveedor`
--

LOCK TABLES `pago_proveedor` WRITE;
/*!40000 ALTER TABLE `pago_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelaje`
--

DROP TABLE IF EXISTS `pelaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pelaje` (
  `idPelaje` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado_pel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPelaje`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelaje`
--

LOCK TABLES `pelaje` WRITE;
/*!40000 ALTER TABLE `pelaje` DISABLE KEYS */;
INSERT INTO `pelaje` VALUES (1,'Canino',1),(2,'Felino',1);
/*!40000 ALTER TABLE `pelaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `idpermiso` int(11) NOT NULL AUTO_INCREMENT,
  `idTipo_Empleado` int(11) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `estado_per` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpermiso`),
  KEY `fk_Tipo_Empleado_has_Empleado_Empleado1_idx` (`idEmpleado`),
  KEY `fk_Tipo_Empleado_has_Empleado_Tipo_Empleado1_idx` (`idTipo_Empleado`),
  CONSTRAINT `fk_Tipo_Empleado_has_Empleado_Tipo_Empleado1` FOREIGN KEY (`idTipo_Empleado`) REFERENCES `tipo_empleado` (`idTipo_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tipo_Empleado_has_Empleado_Empleado1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio_uni` decimal(12,2) DEFAULT NULL,
  `idCategoria` int(11) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  `estado_pro` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_Producto_Categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_Producto_Categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `ruc_prov` varchar(45) DEFAULT NULL,
  `nombre_prov` varchar(45) DEFAULT NULL,
  `telef_prov` varchar(45) DEFAULT NULL,
  `direcc_prov` varchar(45) DEFAULT NULL,
  `correo_prov` varchar(45) DEFAULT NULL,
  `num_cuenta` varchar(45) DEFAULT NULL,
  `Distrito_idDistrito` int(11) NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `estado_pro` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`),
  KEY `fk_Proveedor_Distrito1_idx` (`Distrito_idDistrito`),
  CONSTRAINT `fk_Proveedor_Distrito1` FOREIGN KEY (`Distrito_idDistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raza`
--

DROP TABLE IF EXISTS `raza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `raza` (
  `idRaza` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `idEspecie` int(11) NOT NULL,
  `estado_raz` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRaza`),
  KEY `fk_Raza_Especie1_idx` (`idEspecie`),
  CONSTRAINT `fk_Raza_Especie1` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raza`
--

LOCK TABLES `raza` WRITE;
/*!40000 ALTER TABLE `raza` DISABLE KEYS */;
/*!40000 ALTER TABLE `raza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sede`
--

DROP TABLE IF EXISTS `sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sede` (
  `idSede` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `idDistrito` int(11) NOT NULL,
  `estado_sed` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSede`),
  KEY `fk_Sede_Distrito1_idx` (`idDistrito`),
  CONSTRAINT `fk_Sede_Distrito1` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sede`
--

LOCK TABLES `sede` WRITE;
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cambio`
--

DROP TABLE IF EXISTS `tipo_cambio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_cambio` (
  `idTipo_Cambio` int(11) NOT NULL AUTO_INCREMENT,
  `valor_compra` varchar(45) DEFAULT NULL,
  `valor_venta` varchar(45) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `estado_tip` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Cambio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cambio`
--

LOCK TABLES `tipo_cambio` WRITE;
/*!40000 ALTER TABLE `tipo_cambio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_cambio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_empleado`
--

DROP TABLE IF EXISTS `tipo_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_empleado` (
  `idTipo_Empleado` int(11) NOT NULL AUTO_INCREMENT,
  `descrip_tipo_emp` varchar(45) DEFAULT NULL,
  `obs_tipo_emp` varchar(45) DEFAULT NULL,
  `estado_tie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipo_Empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_empleado`
--

LOCK TABLES `tipo_empleado` WRITE;
/*!40000 ALTER TABLE `tipo_empleado` DISABLE KEYS */;
INSERT INTO `tipo_empleado` VALUES (1,'ADMINISTRADOR','',1),(2,'MEDICO','',1),(3,'RECEPCIONNISTA','',1),(4,'ENCARGADO ALMACEN','',1),(5,'CAJERO','',1);
/*!40000 ALTER TABLE `tipo_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_medida`
--

DROP TABLE IF EXISTS `unidad_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_medida` (
  `idUnidad_medida` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `estado_uni` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUnidad_medida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_medida`
--

LOCK TABLES `unidad_medida` WRITE;
/*!40000 ALTER TABLE `unidad_medida` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidad_medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacuna`
--

DROP TABLE IF EXISTS `vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacuna` (
  `idVacuna` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(70) DEFAULT NULL,
  `estado_vac` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacuna`
--

LOCK TABLES `vacuna` WRITE;
/*!40000 ALTER TABLE `vacuna` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacuna` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-25 13:40:59
