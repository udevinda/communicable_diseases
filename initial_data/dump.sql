-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: communicable_disease
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `disease`
--

DROP TABLE IF EXISTS `disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disease` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `disease_name` varchar(255) NOT NULL,
  `shortcode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disease`
--

LOCK TABLES `disease` WRITE;
/*!40000 ALTER TABLE `disease` DISABLE KEYS */;
INSERT INTO `disease` VALUES (1,'Cholera','CHO'),(2,'Plague','PL'),(3,'Yellow Fever','YF'),(4,'Acute Poliomyclitis','AP'),(5,'Chicken pox','CP'),(6,'Dengue Fever','DF'),(7,'Diptheria','DPT'),(8,'Dysentary','DYS'),(9,'Encephalitis','EN'),(10,'Enteric Fever','EF'),(11,'Food Poisonning','FP'),(12,'Human Rabies','HR'),(13,'Leptospirosis','LE'),(14,'Malaria','MA'),(15,'Measles','ME'),(16,'Meningitis','MEN'),(17,'Mumps','MU'),(18,'Rubella','RU'),(19,'Simple Continued Fever of over 7days or more','SCF'),(20,'Tetanus','TE'),(21,'Neonatal Tetanus','NT'),(22,'Typhus Fever','TF'),(23,'Viral Hepatitis','VH'),(24,'Tuberculosis','TB');
/*!40000 ALTER TABLE `disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_411`
--

DROP TABLE IF EXISTS `form_411`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_411` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `date_of_discharged` date NOT NULL,
  `date_of_hospitalization` date NOT NULL,
  `date_on_set` date NOT NULL,
  `disease_confirmed_date` date NOT NULL,
  `disease_notified_date` date NOT NULL,
  `ethnic_group` int(11) NOT NULL,
  `laboratory_findings` varchar(255) DEFAULT NULL,
  `lattitude` double NOT NULL,
  `longitude` double NOT NULL,
  `moh_area` varchar(255) NOT NULL,
  `name_of_hospital` varchar(255) NOT NULL,
  `outcome` int(11) NOT NULL,
  `patient_address` varchar(255) NOT NULL,
  `patient_name` varchar(255) NOT NULL,
  `patient_movement` varchar(255) DEFAULT NULL,
  `phi_range` varchar(255) NOT NULL,
  `sex` int(11) NOT NULL,
  `where_isolated` int(11) NOT NULL,
  `disease_as_notified_id` bigint(20) DEFAULT NULL,
  `confirmed_disease_id` bigint(20) DEFAULT NULL,
  `workflow_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1C400359B194BC56` (`workflow_id`),
  KEY `FK1C400359F8341A9E` (`confirmed_disease_id`),
  KEY `FK1C400359251200B8` (`disease_as_notified_id`),
  CONSTRAINT `FK1C400359251200B8` FOREIGN KEY (`disease_as_notified_id`) REFERENCES `disease` (`id`),
  CONSTRAINT `FK1C400359B194BC56` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`),
  CONSTRAINT `FK1C400359F8341A9E` FOREIGN KEY (`confirmed_disease_id`) REFERENCES `disease` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_411`
--

LOCK TABLES `form_411` WRITE;
/*!40000 ALTER TABLE `form_411` DISABLE KEYS */;
/*!40000 ALTER TABLE `form_411` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_544`
--

DROP TABLE IF EXISTS `form_544`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_544` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `bht_no` bigint(20) NOT NULL,
  `date_of_admission` date NOT NULL,
  `date_of_onset` date DEFAULT NULL,
  `institute` varchar(255) NOT NULL,
  `nic` varchar(255) NOT NULL,
  `notifier_name` varchar(255) NOT NULL,
  `notifier_status` varchar(255) NOT NULL,
  `patient_home_address` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) NOT NULL,
  `patient_home_phone_no` varchar(255) DEFAULT NULL,
  `peaditiric_patients_gurdian_name` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `system_notified_date` date NOT NULL,
  `ward` varchar(255) NOT NULL,
  `disease_id` bigint(20) DEFAULT NULL,
  `workflow_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nic` (`nic`),
  KEY `FK1C40077AB194BC56` (`workflow_id`),
  KEY `FK1C40077A8D7389BE` (`disease_id`),
  CONSTRAINT `FK1C40077A8D7389BE` FOREIGN KEY (`disease_id`) REFERENCES `disease` (`id`),
  CONSTRAINT `FK1C40077AB194BC56` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_544`
--

LOCK TABLES `form_544` WRITE;
/*!40000 ALTER TABLE `form_544` DISABLE KEYS */;
INSERT INTO `form_544` VALUES (1,4,76393,'2016-12-17','2016-12-10','DGH-Matale','1234','Dr','aaa','164/3, Dasgiriya,Haththotaamuna','Manisha','0713168704','W.N.Bandara',1,'2017-01-05','03',16,1),(2,11,76353,'2016-12-18','2016-12-15','DGH-Matale','2345','Dr','aaa','112. Malkaudadeniya,Alawathugoda','K.M.M. Lochana','0789411243','K.W.M.Nishani',0,'2017-01-05','03',16,2),(3,8,76562,'2016-12-15','2016-12-15','DGH-Matale','456','Dr','a','North matale,School road,Kawudupalalla','Sudarshan','0726407285','K.Joshep',0,'2017-01-02','03',16,3),(4,10,75929,'2016-12-15','2016-12-15','DGH-Matale','789','Dr','aaa','20.B.Kotuwegedara,Matale','R.Disanayake','077522931','D.M.Jayarathne',0,'2017-01-02','03',16,4),(5,1,76873,'2016-12-20','2016-12-20','DGH-Matale','897','Dr','aaa','5/11, Nadun uyana,Aluwihare','P.Rithmika','0789548038','M.K.priyadarshana',1,'2017-01-02','03',16,5),(6,42,78797,'2016-12-28','2016-12-28','DGH-Matale','159','Dr','aaa','93,Dunumadalawa,Madatugama','K.Swarnalatha','0716780647','-',1,'2017-01-02','07',13,6),(7,19,79425,'2016-12-31','2016-12-31','DGH-Matale','-','Dr','aaa','73.A/6, Guralawela,Udathanna road,ukuwela','F.Fazala','0771288723','-',1,'2017-01-02','07',6,7),(9,26,79315,'2016-12-30','2016-12-30','DGH-Matale','489','Dr','aaa','133/1,Guralawela north,Ukuwela','C.D.Karunathilka','0787886184','-',1,'2017-01-02','08',6,9),(10,27,79258,'2016-12-30','2016-12-30','DGH-Matale','258','Dr','aaa','327/H. Hamedia house, Paragahawela,ukuwela','F.Fazara','0662243157','-',1,'2017-01-02','08',6,10),(11,20,79390,'2016-12-31','2016-12-31','DGH-Matale','369','Dr','aaa','107/B,Kahawatta,Ambathanna','M.Abdulla','0812300156','-',0,'2017-01-02','09',6,11),(12,3,79246,'2016-12-30','2016-12-30','DGH-Matale','896','Dr','aaa','38,Kohombiliwela road, Matale','M.S.Bandara','0773587958','M.D.B.Pamunuwa',0,'2017-01-02','04',6,12),(13,10,79247,'2016-12-30','2016-12-30','DGH-Matale','147','Dr','aaa','86/C,Rattota road,Kaludewala,Matale','J.Sachin','0752218482','Ushynthi',0,'2017-01-02','04',6,13),(14,53,79133,'2016-12-31','2016-12-31','DGH-Matale','0000','Dr','Peatient Dead','No.28,Dombagasdeniya, Matale','Mangalika Rodrigo','-','-',1,'2017-01-04','ICU',6,14),(15,30,159,'2017-01-02','2016-12-27','DGH-Matale','00','Dr','-','No.122/2,Eramudugolla,Walawela,matale','Janaka','0777562486','-',0,'2017-01-04','06',6,15),(16,4,253,'2017-01-02','2016-12-29','DGH-Matale','00000','Dr','-','No.82,Wariyapola road,matale','T.Heethika','0725934214','K.Sirobi',1,'2017-01-04','04',6,16),(17,1,77099,'2016-12-20','2016-12-19','DGH-Matale','0','Dr','-','No.7/37, Puranappu place, Kandy road,matale','Shalana','-','Sunil Shantha',0,'2017-01-04','03',16,17),(18,6,318,'2017-01-02','2016-12-30','DGH-Matale','01','Dr','-','No.17,Marukona estate,Elkaduwa road,Ukuwela','W.G.Jeewan','0779737603','W.G. Raja',0,'2017-01-04','04',6,18),(19,14,435,'2017-01-04','2017-01-03','DGH-Matale','001','Dr','-','No.202/5, 7th mile post,Matale road, Akurana','Rukshan','0766431255','-',0,'2017-01-04','09',6,19),(20,49,79427,'2016-12-31','2016-12-26','DGH-Matale','0001','Dr','-','P/190,Hemapola,nalanda','Wijethilka banda','077752781','-',0,'2017-01-04','09',13,20),(21,26,79399,'2016-12-31','2016-12-31','DGH-Matale','0003','Dr','Work in kurunegala hospital','No.47,Purujjala,matale','Dr.Madushantha','0783927578','-',0,'2017-01-04','09',6,21),(22,2,79660,'2016-12-22','2016-12-22','DGH-Matale','22','Dr','aaa','Nugapitiya,Ukuwela','V.Gihansa','0725185570','M.P.Aberathne',1,'2017-01-07','03',16,22),(23,11,77816,'2017-01-23','2016-12-20','DGH-Matale','23','Dr','e','53/2, Dola road,Ukuwela','Hawais','0775354664','I.K.Shahi',1,'2017-01-07','03',16,23),(24,1,77793,'2017-01-23','2016-12-23','DGH-Matale','24','Dr','24','N.192,Malgamdeniya,Alawathugoda','Kishan','-','Sathyawari',0,'2017-01-07','03',16,24),(25,9,483,'2017-01-03','2016-12-29','DGH-Matale','25','Dr','25','8/2,Cercular road,Kaludewala,Matale','B.Ahamed','0752980229','Fathima Nusharath',0,'2017-01-07','03',6,25),(26,15,500,'2017-01-03','2016-12-31','DGH-Matale','26','Dr','a','86/C,Rattota road,Kaludewala,Matale','J.Dhanusika','0773334008','J.Dushynthi',1,'2017-01-08','07',6,26),(27,13,479,'2017-01-03','2017-01-01','DGH-Matale','27','Dr','a','No.125,Kaludewala,Matale','V.Priyanthi','0772391196','M.Krishnakumari',1,'2017-01-08','07',6,27),(28,56,538,'2017-01-03','2017-01-01','DGH-Matale','28','Dr','a','282,Paragahawela,Ukuwela','S.Nihava','-','-',1,'2017-01-08','07',6,28),(29,63,457,'2017-01-03','2017-01-01','DGH-Matale','29','Dr','a','13/3,kohombiliwela,Matale','K.Hirimuthugoda','0662228805','-',1,'2017-01-08','07',6,29),(30,16,573,'2017-01-03','2017-01-02','DGH-Matale','30','Dr','a','No.14,IDH road,Kaludewala,Matale','K.Perera','0776436700','W.G.P.Darshani',1,'2017-01-08','07',6,30),(31,29,50,'2017-01-01','2016-12-29','DGH-Matale','31','Dr','aaa','330/C, Elkaduwa road,Ukuwela','A.R.F.Hasina','0752747009','-',1,'2017-01-08','07',6,31),(32,21,748,'2017-01-04','2017-01-01','DGH-Matale','32','Dr','aaa','52/B,Elkaduwa road,Paragahwela,Ukuwela','B.Dharshani','0767519380','-',1,'2017-01-08','08',6,32),(33,70,79283,'2016-12-31','2016-12-28','DGH-Matale','33','Dr','a','33/18,Lechchimiwatta,Mandandawala, Matale','N.G.Muthumenike','0754673619','-',1,'2017-01-08','08',6,33),(34,3,1228,'2017-01-06','2017-01-01','DGH-Matale','34','Dr','aaa','Gampaha Dispensery,Matale road,Ukuwela','Chathura Thushan','0662244212','D.S.Chathurika',0,'2017-01-08','04',6,34),(35,10,780,'2017-01-04','2017-01-01','DGH-Matale','35','Dr','aaa','50/11,Rattota road,Matale','Pragalya','0662236727','S.Kobika',1,'2017-01-08','04',6,35),(36,4,783,'2017-01-04','2016-12-29','DGH-Matale','36','Dr','aaa','No.03, Warakamura,Ukuwela','Thenuki','0723360743','W.D.G.Kumarasinghe',1,'2017-01-08','04',6,36);
/*!40000 ALTER TABLE `form_544` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_contact`
--

DROP TABLE IF EXISTS `patient_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `date_seen` date NOT NULL,
  `name` varchar(255) NOT NULL,
  `observation` varchar(255) NOT NULL,
  `form_411_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCA55E0E6CF0B355` (`form_411_id`),
  CONSTRAINT `FKCA55E0E6CF0B355` FOREIGN KEY (`form_411_id`) REFERENCES `form_411` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_contact`
--

LOCK TABLES `patient_contact` WRITE;
/*!40000 ALTER TABLE `patient_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow`
--

DROP TABLE IF EXISTS `workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL,
  `form411_id` bigint(20) DEFAULT NULL,
  `form544_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK21BD7BF526C513E` (`form411_id`),
  KEY `FK21BD7BF544CD19E` (`form544_id`),
  CONSTRAINT `FK21BD7BF526C513E` FOREIGN KEY (`form411_id`) REFERENCES `form_411` (`id`),
  CONSTRAINT `FK21BD7BF544CD19E` FOREIGN KEY (`form544_id`) REFERENCES `form_544` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
INSERT INTO `workflow` VALUES (1,0,NULL,1),(2,0,NULL,2),(3,0,NULL,3),(4,0,NULL,4),(5,0,NULL,5),(6,0,NULL,6),(7,0,NULL,7),(9,0,NULL,9),(10,0,NULL,10),(11,0,NULL,11),(12,0,NULL,12),(13,0,NULL,13),(14,0,NULL,14),(15,0,NULL,15),(16,0,NULL,16),(17,0,NULL,17),(18,0,NULL,18),(19,0,NULL,19),(20,0,NULL,20),(21,0,NULL,21),(22,0,NULL,22),(23,0,NULL,23),(24,0,NULL,24),(25,0,NULL,25),(26,0,NULL,26),(27,0,NULL,27),(28,0,NULL,28),(29,0,NULL,29),(30,0,NULL,30),(31,0,NULL,31),(32,0,NULL,32),(33,0,NULL,33),(34,0,NULL,34),(35,0,NULL,35),(36,0,NULL,36);
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-28 14:46:11
