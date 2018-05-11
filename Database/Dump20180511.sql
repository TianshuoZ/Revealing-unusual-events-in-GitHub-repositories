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
  `commit_date` varchar(255) DEFAULT NULL,
  `unusual_eventc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commit_id`),
  KEY `repository_id_idx` (`repository_idc`),
  KEY `unusual_eventc_idx` (`unusual_eventc`),
  CONSTRAINT `repository_id` FOREIGN KEY (`repository_idc`) REFERENCES `user_repository` (`repository_id`) ON DELETE NO ACTION ON UPDATE SET NULL,
  CONSTRAINT `unusual_eventc` FOREIGN KEY (`unusual_eventc`) REFERENCES `unusual_event` (`unusual_event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commit`
--

LOCK TABLES `commit` WRITE;
/*!40000 ALTER TABLE `commit` DISABLE KEYS */;
INSERT INTO `commit` VALUES ('1','5','1','0','0','2','2018-04-05','1'),('2','10','1','1','0','0','2018-04-06','1'),('3','0','1','0','2','0','2018-05-06',NULL),('4','3','2','0','0','20','2018-05-08',NULL);
/*!40000 ALTER TABLE `commit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commit_comment`
--

DROP TABLE IF EXISTS `commit_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commit_comment` (
  `commit_comment_id` varchar(255) NOT NULL,
  `comment_date` varchar(255) DEFAULT NULL,
  `commit_id_f` varchar(255) NOT NULL,
  PRIMARY KEY (`commit_comment_id`),
  KEY `commit_id_idx` (`commit_id_f`),
  CONSTRAINT `commit_id` FOREIGN KEY (`commit_id_f`) REFERENCES `commit` (`commit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commit_comment`
--

LOCK TABLES `commit_comment` WRITE;
/*!40000 ALTER TABLE `commit_comment` DISABLE KEYS */;
INSERT INTO `commit_comment` VALUES ('1','2018-04-04','1'),('2','2018-04-05','1'),('3','2018-04-06','2'),('4','2018-05-01','2');
/*!40000 ALTER TABLE `commit_comment` ENABLE KEYS */;
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
  `issue_date` varchar(255) DEFAULT NULL,
  `unusual_eventi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `repository_id_idx` (`repository_idi`),
  KEY `unusual_eventi_idx` (`unusual_eventi`),
  CONSTRAINT `repository_idi` FOREIGN KEY (`repository_idi`) REFERENCES `user_repository` (`repository_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `unusual_eventi` FOREIGN KEY (`unusual_eventi`) REFERENCES `unusual_event` (`unusual_event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES ('1','5','1','a','d','2018-04-06','1');
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_comment`
--

DROP TABLE IF EXISTS `issue_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue_comment` (
  `issue_comment_id` varchar(255) NOT NULL,
  `comment_date` varchar(255) DEFAULT NULL,
  `issue_id_f` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`issue_comment_id`),
  KEY `issue_id_idx` (`issue_id_f`),
  CONSTRAINT `issue_id` FOREIGN KEY (`issue_id_f`) REFERENCES `issue` (`issue_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_comment`
--

LOCK TABLES `issue_comment` WRITE;
/*!40000 ALTER TABLE `issue_comment` DISABLE KEYS */;
INSERT INTO `issue_comment` VALUES ('1','2018-04-04','1'),('2','2018-04-05','1'),('3','2018-04-06','1');
/*!40000 ALTER TABLE `issue_comment` ENABLE KEYS */;
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
  `pull_request_date` varchar(255) DEFAULT NULL,
  `unusual_eventp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pull_request_id`),
  KEY `repository_id_idx` (`repository_idp`),
  KEY `unusual_eventp_idx` (`unusual_eventp`),
  CONSTRAINT `repository_idp` FOREIGN KEY (`repository_idp`) REFERENCES `user_repository` (`repository_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `unusual_eventp` FOREIGN KEY (`unusual_eventp`) REFERENCES `unusual_event` (`unusual_event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pull_request`
--

LOCK TABLES `pull_request` WRITE;
/*!40000 ALTER TABLE `pull_request` DISABLE KEYS */;
INSERT INTO `pull_request` VALUES ('1','20','1','ad','asdf','2018-05-06','1'),('2','10','1','df','ewe','2018-04-08','1');
/*!40000 ALTER TABLE `pull_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pull_request_comment`
--

DROP TABLE IF EXISTS `pull_request_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pull_request_comment` (
  `pull_request_comment_id` varchar(255) NOT NULL,
  `comment_date` varchar(255) DEFAULT NULL,
  `pull_request_id_f` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pull_request_comment_id`),
  KEY `pull_request_id_f_idx` (`pull_request_id_f`),
  CONSTRAINT `pull_request_id_f` FOREIGN KEY (`pull_request_id_f`) REFERENCES `pull_request` (`pull_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pull_request_comment`
--

LOCK TABLES `pull_request_comment` WRITE;
/*!40000 ALTER TABLE `pull_request_comment` DISABLE KEYS */;
INSERT INTO `pull_request_comment` VALUES ('1','2018-04-08','1'),('2','2015-08-31','1');
/*!40000 ALTER TABLE `pull_request_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unusual_event`
--

DROP TABLE IF EXISTS `unusual_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unusual_event` (
  `unusual_event_id` varchar(255) NOT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  `happened_date` varchar(255) DEFAULT NULL,
  `vote` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`unusual_event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unusual_event`
--

LOCK TABLES `unusual_event` WRITE;
/*!40000 ALTER TABLE `unusual_event` DISABLE KEYS */;
INSERT INTO `unusual_event` VALUES ('1','commit','comment number','more than 5 comment','2018-04-04','up','1'),('2','issue','comment number','more than 5 comments','2018-05-11','up','1'),('3','commit','lines of code added','more than 200 LOC are added','2018-04-22',NULL,'1'),('4','pull request','comment number','more than 5 comments','2018-03-02',NULL,'1'),('5','commit','lines of code deleted','more than 50 LOC are deleted','2018-05-12',NULL,'2');
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
INSERT INTO `user` VALUES ('1','TianshuoZhang','O_o','2'),('2','JiexinLi','T_T','3'),('3','XiyuZhang','0.0','3'),('4','Jack','= =','1');
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

-- Dump completed on 2018-05-11 14:40:25
