-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dmu
-- ------------------------------------------------------
-- Server version	5.5.62-log

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
-- Table structure for table `dmu_authentication`
--

DROP TABLE IF EXISTS `dmu_authentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_authentication` (
  `SR_NO` int(11) NOT NULL,
  `AUTHENTICATION_TYPE` varchar(10) NOT NULL,
  `USER_NAME` varchar(200) DEFAULT NULL,
  `PASSWORD` varchar(200) DEFAULT NULL,
  `DOMAIN_NAME` varchar(200) DEFAULT NULL,
  `KERBEROS_HOST_REALM` varchar(200) DEFAULT NULL,
  `KERBEROS_HOST_FQDN` varchar(200) DEFAULT NULL,
  `KERBEROS_SERVICE_NAME` varchar(200) DEFAULT NULL,
  `SSL_KEYSTORE_PATH` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SR_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_authentication`
--

LOCK TABLES `dmu_authentication` WRITE;
/*!40000 ALTER TABLE `dmu_authentication` DISABLE KEYS */;
INSERT INTO `dmu_authentication` VALUES (1,'UNSCRD',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `dmu_authentication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmu_basket_temp`
--

DROP TABLE IF EXISTS `dmu_basket_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_basket_temp` (
  `USER_ID` varchar(20) NOT NULL,
  `SR_NO` int(11) NOT NULL,
  `SCHEMA_NAME` varchar(100) NOT NULL,
  `TABLE_NAME` varchar(100) NOT NULL,
  `FILTER_CONDITION` varchar(500) DEFAULT NULL,
  `TARGET_S3_BUCKET` varchar(500) DEFAULT NULL,
  `INCREMENTAL_FLAG` varchar(1) DEFAULT NULL,
  `INCREMENTAL_CLMN` varchar(100) DEFAULT NULL,
  `LABEL_NAME` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_basket_temp`
--

LOCK TABLES `dmu_basket_temp` WRITE;
/*!40000 ALTER TABLE `dmu_basket_temp` DISABLE KEYS */;
INSERT INTO `dmu_basket_temp` VALUES ('Admin',1,'retaildb','categories','','dmutestbucket/categories','N','','Admin-2019-09-13 11:21:02'),('Admin',2,'retaildb','customers','','dmutestbucket/customers','N','','Admin-2019-09-13 11:21:02'),('Admin',3,'retaildb','departments','','dmutestbucket/departments','N','','Admin-2019-09-13 11:21:02'),('Admin',4,'retaildb','order_items','','dmutestbucket/order_items','N','','Admin-2019-09-13 11:21:02'),('Admin',5,'retaildb','orders','','dmutestbucket/orders','N','','Admin-2019-09-13 11:21:02'),('Admin',6,'retaildb','products','','dmutestbucket/products','N','','Admin-2019-09-13 11:26:03');
/*!40000 ALTER TABLE `dmu_basket_temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmu_hdfs`
--

DROP TABLE IF EXISTS `dmu_hdfs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_hdfs` (
  `SR_NO` int(11) NOT NULL,
  `CONNECTION_TYPE` varchar(10) NOT NULL,
  `HIVE_HOST_NAME` varchar(200) DEFAULT NULL,
  `HIVE_PORT_NMBR` bigint(20) DEFAULT NULL,
  `IMPALA_HOST_NAME` varchar(200) DEFAULT NULL,
  `IMPALA_PORT_NMBR` bigint(20) DEFAULT NULL,
  `SQL_WH_DIR` varchar(200) DEFAULT NULL,
  `HIVE_MS_URI` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SR_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_hdfs`
--

LOCK TABLES `dmu_hdfs` WRITE;
/*!40000 ALTER TABLE `dmu_hdfs` DISABLE KEYS */;
INSERT INTO `dmu_hdfs` VALUES (1,'HIVE','18.216.202.239',10000,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `dmu_hdfs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmu_history_dtl`
--

DROP TABLE IF EXISTS `dmu_history_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_history_dtl` (
  `REQUEST_NO` varchar(100) NOT NULL,
  `SR_NO` int(11) NOT NULL,
  `SCHEMA_NAME` varchar(100) NOT NULL,
  `TABLE_NAME` varchar(100) NOT NULL,
  `FILTER_CONDITION` varchar(500) DEFAULT NULL,
  `TARGET_S3_BUCKET` varchar(500) DEFAULT NULL,
  `INCREMENTAL_FLAG` varchar(1) DEFAULT NULL,
  `INCREMENTAL_CLMN` varchar(100) DEFAULT NULL,
  `STATUS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`REQUEST_NO`,`SR_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_history_dtl`
--

LOCK TABLES `dmu_history_dtl` WRITE;
/*!40000 ALTER TABLE `dmu_history_dtl` DISABLE KEYS */;
INSERT INTO `dmu_history_dtl` VALUES ('Admin-2019-09-11 11:22:42',1,'retaildb','categories','','dmutestbucket/categories','N','','Success'),('Admin-2019-09-11 11:22:42',2,'retaildb','customers','','dmutestbucket/customers','N','','Success'),('Admin-2019-09-11 11:22:42',3,'retaildb','departments','','dmutestbucket/departments','N','','Success'),('Admin-2019-09-11 11:22:42',4,'retaildb','order_items','','dmutestbucket/order_items','N','','Success'),('Admin-2019-09-11 11:22:42',5,'retaildb','orders','','dmutestbucket/orders','N','','Success'),('Admin-2019-09-11 11:22:42',7,'retaildb','products','','dmutestbucket/products','N','','Success'),('Admin-2019-09-11 11:57:03',7,'retaildb','products','','dmutestbucket/products','N','','Success'),('Admin-2019-09-12 01:29:33',3,'retaildb','departments','','dmutestbucket/departments','N','','Success'),('retaildb-12-11-2019',1,'retaildb','categories','','dmutestbucket/categories','N','','Success'),('retaildb-12-11-2019',6,'retaildb','products','','dmutestbucket/products','N','','Success');
/*!40000 ALTER TABLE `dmu_history_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmu_history_main`
--

DROP TABLE IF EXISTS `dmu_history_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_history_main` (
  `REQUEST_NO` varchar(100) NOT NULL,
  `USER_ID` varchar(20) NOT NULL,
  `REQUESTED_TIME` datetime NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  `REQUEST_TYPE` varchar(100) DEFAULT NULL,
  `SCRIPT_GEN_CMPLT_TIME` datetime DEFAULT NULL,
  `EXCTN_CMPLT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`REQUEST_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_history_main`
--

LOCK TABLES `dmu_history_main` WRITE;
/*!40000 ALTER TABLE `dmu_history_main` DISABLE KEYS */;
INSERT INTO `dmu_history_main` VALUES ('Admin-2019-09-11 11:22:42','Admin','2019-09-12 03:23:40','Completed','HDFS to S3',NULL,NULL),('Admin-2019-09-11 11:57:03','Admin','2019-09-12 03:57:53','Completed','HDFS to S3',NULL,NULL),('Admin-2019-09-12 01:29:33','Admin','2019-09-12 17:30:28','Completed','null',NULL,NULL),('retaildb-12-11-2019','Admin','2019-09-12 17:30:28','Completed','null',NULL,NULL);
/*!40000 ALTER TABLE `dmu_history_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmu_roles`
--

DROP TABLE IF EXISTS `dmu_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_roles` (
  `ROLE_ID` varchar(50) NOT NULL,
  `ROLE_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_roles`
--

LOCK TABLES `dmu_roles` WRITE;
/*!40000 ALTER TABLE `dmu_roles` DISABLE KEYS */;
INSERT INTO `dmu_roles` VALUES ('Admin','administrator role'),('DMU_USER','user role to submit copy requests');
/*!40000 ALTER TABLE `dmu_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmu_s3`
--

DROP TABLE IF EXISTS `dmu_s3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_s3` (
  `SR_NO` int(11) NOT NULL,
  `CREDENTIAL_STRG_TYPE` varchar(10) NOT NULL,
  `AWS_ACCESS_ID` varchar(200) DEFAULT NULL,
  `AWS_SECRET_KEY` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SR_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_s3`
--

LOCK TABLES `dmu_s3` WRITE;
/*!40000 ALTER TABLE `dmu_s3` DISABLE KEYS */;
INSERT INTO `dmu_s3` VALUES (1,'Indirect','AKIAV6TWR75UDVMMTRBL','c+vIXS5gttqGq5OD52EAxenSE2Fg+JgCv4UJd7nC');
/*!40000 ALTER TABLE `dmu_s3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmu_users`
--

DROP TABLE IF EXISTS `dmu_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmu_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ROLE` varchar(50) DEFAULT NULL,
  `EMAIL_ID` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `createdby` varchar(45) DEFAULT NULL,
  `updatedby` varchar(45) DEFAULT NULL,
  `updateddate` varchar(45) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `isnew` varchar(255) DEFAULT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmu_users`
--

LOCK TABLES `dmu_users` WRITE;
/*!40000 ALTER TABLE `dmu_users` DISABLE KEYS */;
INSERT INTO `dmu_users` VALUES (1,'Admin','chiranjeevi1212@gmail.com','ZFJ1N1hKa01NQg==',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'chiranjeevi');
/*!40000 ALTER TABLE `dmu_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dmu'
--

--
-- Dumping routines for database 'dmu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-20 11:19:57
