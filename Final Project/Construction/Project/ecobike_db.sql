CREATE DATABASE  IF NOT EXISTS `ecobike_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ecobike_db`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: ecobike_db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ParkingId` int NOT NULL,
  `BikeCode` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Status` int NOT NULL,
  `Type` int NOT NULL,
  `Description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Battery` float NOT NULL,
  `Value` float NOT NULL,
  `Image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `ParkingId` (`ParkingId`),
  CONSTRAINT `Bike_ibfk_1` FOREIGN KEY (`ParkingId`) REFERENCES `parking` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES (1,1,'11','BikeQIQ_01_01',1,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(2,1,'12','BikeQIQ_01_02',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike1.jpg'),(3,1,'13','BikeQIQ_01_03',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike2.jpg'),(4,1,'14','BikeQIQ_01_04',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(5,1,'15','BikeQIQ_01_05',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(6,2,'21','BikeMBI_02_01',0,3,'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',99,700000,'http://149.28.211.53/images/bike_MBI.jpg'),(7,2,'22','BikeMBI_02_02',0,3,'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',99,700000,'http://149.28.211.53/images/bike_MBI.jpg'),(8,2,'23','BikeMBI_02_03',0,3,'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',99,700000,'http://149.28.211.53/images/bike_MBI.jpg'),(9,2,'24','BikeMBI_02_04',0,3,'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',99,700000,'http://149.28.211.53/images/bike_MBI.jpg'),(10,2,'25','BikeMBI_02_05',0,3,'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',99,700000,'http://149.28.211.53/images/bike_MBI.jpg'),(11,3,'31','BikeQIQ_03_01',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(12,3,'32','BikeQIQ_03_02',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(13,3,'33','BikeQIQ_03_03',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(14,3,'34','BikeQIQ_03_04',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(15,3,'35','BikeQIQ_03_05',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(16,4,'41','BikeQIQ_04_01',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(17,4,'42','BikeQIQ_04_02',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(18,4,'43','BikeQIQ_04_03',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(19,4,'44','BikeQIQ_04_04',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(20,4,'45','BikeQIQ_04_05',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(21,5,'51','BikeQIQ_05_01',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(22,5,'52','BikeQIQ_05_02',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(23,5,'53','BikeQIQ_05_03',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(24,5,'54','BikeQIQ_05_04',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg'),(25,5,'55','BikeQIQ_05_05',0,3,'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',99,700000,'http://149.28.211.53/images/bike.jpg');
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bikerentalpause`
--

DROP TABLE IF EXISTS `bikerentalpause`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bikerentalpause` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `RentalId` int NOT NULL,
  `Status` int NOT NULL,
  `StartTime` datetime NOT NULL,
  `EndTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `RentalId` (`RentalId`),
  CONSTRAINT `BikeRentalPause_ibfk_1` FOREIGN KEY (`RentalId`) REFERENCES `rental` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bikerentalpause`
--

LOCK TABLES `bikerentalpause` WRITE;
/*!40000 ALTER TABLE `bikerentalpause` DISABLE KEYS */;
/*!40000 ALTER TABLE `bikerentalpause` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Status` int NOT NULL DEFAULT '0',
  `CardNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CardHolder` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SecurityCode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IssuingBank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ExpirationDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Capacity` int NOT NULL,
  `Image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking`
--

LOCK TABLES `parking` WRITE;
/*!40000 ALTER TABLE `parking` DISABLE KEYS */;
INSERT INTO `parking` VALUES (1,'Parking01','01 Đại Cồ Việt, Hai Bà Trưng, Hà Nội',100,'http://149.28.211.53/images/bike_parking.jpg'),(2,'Parking02','207 Giải Phóng, Hai Bà Trưng, Hà Nội',50,'http://149.28.211.53/images/bike_parking.jpg'),(3,'Parking03','55 Giải Phóng, Hai Bà Trưng, Hà Nội',50,'http://149.28.211.53/images/bike_parking.jpg'),(4,'Parking04','01 Tôn Thất Tùng, Đống Đa, Hà Nội',50,'http://149.28.211.53/images/bike_parking.jpg'),(5,'Parking05','58 Lê Văn Hiến, Từ Liêm, Hà Nội',50,'http://149.28.211.53/images/bike_parking.jpg');
/*!40000 ALTER TABLE `parking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental`
--

DROP TABLE IF EXISTS `rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `BikeId` int NOT NULL,
  `CardId` int NOT NULL,
  `Status` int NOT NULL,
  `StartTime` timestamp(6) NULL DEFAULT NULL,
  `EndTime` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `BikeId` (`BikeId`),
  KEY `CardId` (`CardId`),
  CONSTRAINT `Rental_ibfk_1` FOREIGN KEY (`BikeId`) REFERENCES `bike` (`Id`),
  CONSTRAINT `Rental_ibfk_2` FOREIGN KEY (`CardId`) REFERENCES `card` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental`
--

LOCK TABLES `rental` WRITE;
/*!40000 ALTER TABLE `rental` DISABLE KEYS */;
/*!40000 ALTER TABLE `rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `CardId` int NOT NULL,
  `command` varchar(45) NOT NULL,
  `Amount` float DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `CardId` (`CardId`),
  CONSTRAINT `Transaction_ibfk_1` FOREIGN KEY (`CardId`) REFERENCES `card` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-24  1:14:39
