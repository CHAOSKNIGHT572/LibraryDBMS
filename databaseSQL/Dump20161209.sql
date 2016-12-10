CREATE DATABASE  IF NOT EXISTS `cs631` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cs631`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cs631
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(45) NOT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `doc_id` int(11) NOT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`doc_id`),
  CONSTRAINT `book_document_id` FOREIGN KEY (`doc_id`) REFERENCES `document` (`doc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bor_transaction`
--

DROP TABLE IF EXISTS `bor_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bor_transaction` (
  `borrow_id` int(11) NOT NULL AUTO_INCREMENT,
  `copy_no` int(11) NOT NULL,
  `doc_id` int(11) NOT NULL,
  `lib_id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  `borrow_date_time` datetime DEFAULT NULL,
  `return_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`borrow_id`),
  KEY `borrow_copy_copy_idx` (`copy_no`,`doc_id`,`lib_id`),
  KEY `borrow_reader_id_idx` (`reader_id`),
  CONSTRAINT `borrow_copy_copy` FOREIGN KEY (`copy_no`, `doc_id`, `lib_id`) REFERENCES `copy` (`copy_no`, `doc_id`, `lib_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `borrow_reader_id` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`reader_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `lib_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`lib_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `copy`
--

DROP TABLE IF EXISTS `copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copy` (
  `copy_no` int(11) NOT NULL AUTO_INCREMENT,
  `doc_id` int(11) NOT NULL,
  `lib_id` int(11) NOT NULL,
  `position` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`copy_no`,`doc_id`,`lib_id`),
  KEY `copy_branch_id_idx` (`lib_id`),
  KEY `copy_document_id_idx` (`doc_id`),
  CONSTRAINT `copy_branch_id` FOREIGN KEY (`lib_id`) REFERENCES `branch` (`lib_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `copy_document_id` FOREIGN KEY (`doc_id`) REFERENCES `document` (`doc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `descriptor`
--

DROP TABLE IF EXISTS `descriptor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descriptor` (
  `doc_id` int(11) NOT NULL,
  `descriptor_value` varchar(45) NOT NULL,
  PRIMARY KEY (`doc_id`,`descriptor_value`),
  KEY `descriptor_document_id_idx` (`doc_id`),
  CONSTRAINT `descriptor_document_id` FOREIGN KEY (`doc_id`) REFERENCES `document` (`doc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `doc_id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `pub_id` int(11) NOT NULL,
  `pub_date` date DEFAULT NULL,
  PRIMARY KEY (`doc_id`),
  KEY `document_publisher_id_idx` (`pub_id`),
  CONSTRAINT `document_publisher_id` FOREIGN KEY (`pub_id`) REFERENCES `publisher` (`pub_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `guest_editor`
--

DROP TABLE IF EXISTS `guest_editor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest_editor` (
  `doc_id` int(11) NOT NULL,
  `issue_no` int(11) NOT NULL,
  `guest_name` varchar(45) NOT NULL,
  PRIMARY KEY (`doc_id`,`issue_no`,`guest_name`),
  KEY `guest_issue_issue_idx` (`doc_id`,`issue_no`),
  CONSTRAINT `guest_issue_issue` FOREIGN KEY (`doc_id`, `issue_no`) REFERENCES `journal_issue` (`doc_id`, `issue_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `journal_issue`
--

DROP TABLE IF EXISTS `journal_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journal_issue` (
  `doc_id` int(11) NOT NULL,
  `issue_no` int(11) NOT NULL,
  `scope` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`doc_id`,`issue_no`),
  CONSTRAINT `issue_document_id` FOREIGN KEY (`doc_id`) REFERENCES `document` (`doc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `journal_volume`
--

DROP TABLE IF EXISTS `journal_volume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journal_volume` (
  `doc_id` int(11) NOT NULL,
  `jv_editor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`doc_id`),
  CONSTRAINT `volume_document_id` FOREIGN KEY (`doc_id`) REFERENCES `document` (`doc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proceedings`
--

DROP TABLE IF EXISTS `proceedings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proceedings` (
  `doc_id` int(11) NOT NULL,
  `cp_date` date NOT NULL,
  `cp_location` varchar(45) NOT NULL,
  `cp_editor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`doc_id`),
  CONSTRAINT `proceeding_document_id` FOREIGN KEY (`doc_id`) REFERENCES `document` (`doc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisher` (
  `pub_id` int(11) NOT NULL,
  `pub_name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reader` (
  `reader_id` int(11) NOT NULL AUTO_INCREMENT,
  `reader_name` varchar(45) NOT NULL,
  `type` int(11) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `reserve_id` int(11) NOT NULL,
  `copy_no` int(11) DEFAULT NULL,
  `doc_id` int(11) NOT NULL,
  `lib_id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  `res_date_time` datetime NOT NULL,
  PRIMARY KEY (`reserve_id`),
  KEY `reservation_copy_copy_idx` (`copy_no`,`doc_id`,`lib_id`),
  KEY `reservation_reader_id_idx` (`reader_id`),
  CONSTRAINT `reservation_copy_copy` FOREIGN KEY (`copy_no`, `doc_id`, `lib_id`) REFERENCES `copy` (`copy_no`, `doc_id`, `lib_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reservation_reader_id` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`reader_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `writes`
--

DROP TABLE IF EXISTS `writes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `writes` (
  `doc_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`doc_id`,`author_id`),
  KEY `writes_author_id_idx` (`author_id`),
  CONSTRAINT `writes_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `writes_document_id` FOREIGN KEY (`doc_id`) REFERENCES `document` (`doc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-09 11:29:36
