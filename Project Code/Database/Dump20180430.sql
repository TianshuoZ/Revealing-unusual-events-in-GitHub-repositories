-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: unusualevent.ceavlaksvttu.ap-southeast-2.rds.amazonaws.com    Database: mysqlDB
-- ------------------------------------------------------
-- Server version	5.6.39-log

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
-- Table structure for table `commit`
--

DROP TABLE IF EXISTS `commit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commit` (
  `commit_id` varchar(255) NOT NULL,
  `comment_number` varchar(255) DEFAULT NULL,
  `repository_idc` varchar(255) DEFAULT NULL,
  `file_change` varchar(255) DEFAULT NULL,
  `lines_added` varchar(255) DEFAULT NULL,
  `lines_deleted` varchar(255) DEFAULT NULL,
  `lines_modified` varchar(255) DEFAULT NULL,
  `commit_date` date DEFAULT NULL,
  PRIMARY KEY (`commit_id`),
  KEY `repository_id_idx` (`repository_idc`),
  CONSTRAINT `repository_id` FOREIGN KEY (`repository_idc`) REFERENCES `user_repository` (`repository_id`) ON DELETE NO ACTION ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commit`
--

LOCK TABLES `commit` WRITE;
/*!40000 ALTER TABLE `commit` DISABLE KEYS */;
INSERT INTO `commit` VALUES ('1','5','1','0','0','2',NULL,'2018-04-05'),('2','10','1','1','0','0',NULL,'2018-04-06'),('3','0','1','0','2','0',NULL,'2018-05-06'),('4','3','2','0','0','20',NULL,'2018-05-08');
/*!40000 ALTER TABLE `commit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_name`
--

DROP TABLE IF EXISTS `event_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_name` (
  `event_name_id` varchar(255) NOT NULL,
  `event_artifact` varchar(255) NOT NULL,
  `event_name` varchar(255) NOT NULL,
  PRIMARY KEY (`event_name_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_name`
--

LOCK TABLES `event_name` WRITE;
/*!40000 ALTER TABLE `event_name` DISABLE KEYS */;
INSERT INTO `event_name` VALUES ('1','commits','number of LOC modified'),('2','pull requests','number of comments'),('3','issues','days between open and closed'),('4','issues','number of comments for label'),('5','commits','number of LOC deleted'),('6','commits','number of LOC added');
/*!40000 ALTER TABLE `event_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feedback_id` varchar(255) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `feedback_date` varchar(255) DEFAULT NULL,
  `unusual_event_id` varchar(255) NOT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `unusual_event_id_idx` (`unusual_event_id`),
  CONSTRAINT `unusual_event_id` FOREIGN KEY (`unusual_event_id`) REFERENCES `unusual_event` (`unusual_event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES ('1','Good','2018-05-04','1'),('2','Bad','2018-05-01','1');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue` (
  `issue_id` varchar(255) NOT NULL,
  `comment_number` varchar(255) DEFAULT NULL,
  `repository_idi` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `issue_label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `repository_id_idx` (`repository_idi`),
  CONSTRAINT `repository_idi` FOREIGN KEY (`repository_idi`) REFERENCES `user_repository` (`repository_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES ('1','5','1','a','d','2018-04-06',NULL);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_history`
--

DROP TABLE IF EXISTS `issue_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue_history` (
  `issue_history_id` varchar(255) NOT NULL,
  `issue_status` tinyint(4) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `issue_id_f` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`issue_history_id`),
  KEY `issue_idf_idx` (`issue_id_f`),
  CONSTRAINT `issue_id_f` FOREIGN KEY (`issue_id_f`) REFERENCES `issue` (`issue_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_history`
--

LOCK TABLES `issue_history` WRITE;
/*!40000 ALTER TABLE `issue_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `issue_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pull_request`
--

DROP TABLE IF EXISTS `pull_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pull_request` (
  `pull_request_id` varchar(255) NOT NULL,
  `comment_number` varchar(255) DEFAULT NULL,
  `repository_idp` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `pull_request_date` date DEFAULT NULL,
  PRIMARY KEY (`pull_request_id`),
  KEY `repository_id_idx` (`repository_idp`),
  CONSTRAINT `repository_idp` FOREIGN KEY (`repository_idp`) REFERENCES `user_repository` (`repository_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pull_request`
--

LOCK TABLES `pull_request` WRITE;
/*!40000 ALTER TABLE `pull_request` DISABLE KEYS */;
INSERT INTO `pull_request` VALUES ('1','20','1','ad','asdf','2018-05-06'),('2','10','1','df','ewe','2018-04-08');
/*!40000 ALTER TABLE `pull_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unusual_event`
--

DROP TABLE IF EXISTS `unusual_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unusual_event` (
  `unusual_event_id` varchar(255) NOT NULL,
  `event_name_idf` varchar(255) NOT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  `happened_date` date DEFAULT NULL,
  `user_idf` varchar(255) NOT NULL,
  `repository_idf` varchar(255) DEFAULT NULL,
  `issue_idf` varchar(255) DEFAULT NULL,
  `commit_idf` varchar(255) DEFAULT NULL,
  `pull_request_idf` varchar(255) DEFAULT NULL,
  `up_number` int(11) DEFAULT NULL,
  `down_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`unusual_event_id`),
  KEY `commit_idf_idx` (`commit_idf`),
  KEY `issue_idf_idx` (`issue_idf`),
  KEY `pull_request_idf_idx` (`pull_request_idf`),
  KEY `user_idf_idx` (`user_idf`),
  KEY `event_name_idf_idx` (`event_name_idf`),
  KEY `repository_idf_idx` (`repository_idf`),
  CONSTRAINT `commit_idf` FOREIGN KEY (`commit_idf`) REFERENCES `commit` (`commit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `event_name_idf` FOREIGN KEY (`event_name_idf`) REFERENCES `event_name` (`event_name_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `issue_idf` FOREIGN KEY (`issue_idf`) REFERENCES `issue` (`issue_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pull_request_idf` FOREIGN KEY (`pull_request_idf`) REFERENCES `pull_request` (`pull_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `repository_idf` FOREIGN KEY (`repository_idf`) REFERENCES `user_repository` (`repository_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_idf` FOREIGN KEY (`user_idf`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unusual_event`
--

LOCK TABLES `unusual_event` WRITE;
/*!40000 ALTER TABLE `unusual_event` DISABLE KEYS */;
INSERT INTO `unusual_event` VALUES ('1','2','20 comments','2018-05-06','1','1',NULL,NULL,'1',5,3),('2','2','15 comments','2018-05-11','1','2',NULL,NULL,NULL,21,2),('3','3','2 days between opened and closed','2018-04-22','1','1',NULL,NULL,NULL,0,1),('4','2','28 comments','2018-03-02','1','2',NULL,NULL,NULL,6,2),('5','4','8 comments','2018-05-12','2','3',NULL,NULL,NULL,32,3);
/*!40000 ALTER TABLE `unusual_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_avatar` varchar(1000) DEFAULT NULL,
  `repository_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','TianshuoZhang','https://avatars1.githubusercontent.com/u/37031376?v=4','2'),('2','JiexinLi','T_T','3'),('3','XiyuZhang','0.0','3'),('4','Jack','= =','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_repository`
--

DROP TABLE IF EXISTS `user_repository`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_repository` (
  `repository_id` varchar(255) NOT NULL,
  `repository_name` varchar(255) DEFAULT NULL,
  `commit_number` varchar(255) DEFAULT NULL,
  `pull_request_number` varchar(255) DEFAULT NULL,
  `issue_number` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  `creat_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`repository_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_repository`
--

LOCK TABLES `user_repository` WRITE;
/*!40000 ALTER TABLE `user_repository` DISABLE KEYS */;
INSERT INTO `user_repository` VALUES ('1','unusual_event','5','5','5','3','2018-03-04'),('2','robot','0','0','0','1','2018-02-04'),('3','people','2','4','2','1','2018-03-15'),('4','water','4','0','12','2','2017-05-25'),('5','paper','23','15','2','2','2018-03-01'),('6','bed','2','20','2','2','2016-04-04'),('7','sofa','13','35','24','3','2015-03-04'),('8','food','24','1','2','3','2013-03-04'),('9','door','14','0','24','4','2012-03-04');
/*!40000 ALTER TABLE `user_repository` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-12 20:58:32
