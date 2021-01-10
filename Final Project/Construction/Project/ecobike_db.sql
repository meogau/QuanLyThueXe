-- Adminer 4.7.7 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

USE `ecobike_db`;


DROP TABLE IF EXISTS `parking`;
CREATE TABLE `parking` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Address` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Capacity` int(11) NOT NULL,
  `Image` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `parking` (`Id`, `Name`, `Address`, `Capacity`, `Image`) VALUES
(1,	'Parking01',	'01 Đại Cồ Việt, Hai Bà Trưng, Hà Nội',	100,	'http://149.28.211.53/images/bike_parking.jpg'),
(2,	'Parking02',	'207 Giải Phóng, Hai Bà Trưng, Hà Nội',	50,	'http://149.28.211.53/images/bike_parking.jpg'),
(3,	'Parking03',	'55 Giải Phóng, Hai Bà Trưng, Hà Nội',	50,	'http://149.28.211.53/images/bike_parking.jpg'),
(4,	'Parking04',	'01 Tôn Thất Tùng, Đống Đa, Hà Nội',	50,	'http://149.28.211.53/images/bike_parking.jpg'),
(5,	'Parking05',	'58 Lê Văn Hiến, Từ Liêm, Hà Nội',	50,	'http://149.28.211.53/images/bike_parking.jpg');


DROP TABLE IF EXISTS `electricbike`;
CREATE TABLE `electricbike` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ParkingId` int(11) NOT NULL,
  `BikeCode` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Status` int(11) NOT NULL,
  `Description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `Battery` float NOT NULL,
  `Value` float NOT NULL,
  `Image` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `electricbike` (`Id`, `ParkingId`, `BikeCode`, `Name`, `Status`, `Description`, `Battery`, `Value`, `Image`) VALUES
(1,	1,	'11',	'BikeQIQ_01_01',	1,	'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',	99,	700000,	'http://149.28.211.53/images/bike.jpg'),
(2,	1,	'12',	'BikeQIQ_01_02',	0,	'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',	99,	700000,	'http://149.28.211.53/images/bike.jpg'),
(3,	1,	'13',	'BikeQIQ_01_03',	0,	'Xe đạp QIQ cũng là loại xe đạp điện, có bàn đạp trợ lực. Theo cảm giác trải nghiệm của cá nhân, xe QIQ có vẻ hợp với người lớn hơn vì xe khá cao và không có chỗ thêm cho trẻ con.',	99,	700000,	'http://149.28.211.53/images/bike.jpg'),
(4,	2,	'21',	'BikeMBI_02_01',	0,	'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',	99,	700000,	'http://149.28.211.53/images/bike_MBI.jpg'),
(5,	2,	'22',	'BikeMBI_02_02',	0,	'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',	99,	700000,	'http://149.28.211.53/images/bike_MBI.jpg'),
(6,	2,	'23',	'BikeMBI_02_03',	0,	'Xe đạp MBI là loại xe đạp điện, có thể chạy tối đa 30km/h, sử dụng bộ tích điện không xả khói thân thiện với môi trường. Xe áp dụng cho 1 người lái, có thể chở thêm trẻ em đứng phía trước hoặc ngồi ghế sau. Nói chung xe khá thân thiện áp dụng được với cả người lớn lẫn với khách du lịch gia đình.',	99,	700000,	'http://149.28.211.53/images/bike_MBI.jpg');



DROP TABLE IF EXISTS `standbike`;
CREATE TABLE `standbike` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ParkingId` int(11) NOT NULL,
  `BikeCode` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Status` int(11) NOT NULL,
  `Description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `Value` float NOT NULL,
  `Image` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `standbike` (`Id`, `ParkingId`, `BikeCode`, `Name`, `Status`, `Description`, `Value`, `Image`) VALUES
(101,	1,	's11',	'Bike_01_01',	0,	'Xe đạp đơn',	400000,	'http://149.28.211.53/images/bike_s.jpg'),
(102,	1,	's12',	'Bike_01_02',	0,	'Xe đạp đơn',	400000,	'http://149.28.211.53/images/bike_s.jpg'),
(103,	1,	's13',	'Bike_01_03',	0,	'Xe đạp đơn',	400000,	'http://149.28.211.53/images/bike_s.jpg'),
(104,	2,	's21',	'Bike_02_01',	0,	'Xe đạp đơn',	400000,	'http://149.28.211.53/images/bike_s.jpg'),
(105,	2,	's22',	'Bike_02_02',	0,	'Xe đạp đơn',	400000,	'http://149.28.211.53/images/bike_s.jpg'),
(106,	2,	's23',	'Bike_02_03',	0,	'Xe đạp đơn',	400000,	'http://149.28.211.53/images/bike_s.jpg');



DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Status` int(11) NOT NULL DEFAULT '0',
  `CardNumber` varchar(20) CHARACTER SET utf8 NOT NULL,
  `CardHolder` varchar(50) CHARACTER SET utf8 NOT NULL,
  `SecurityCode` varchar(10) CHARACTER SET utf8 NOT NULL,
  `IssuingBank` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ExpirationDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `card` (`Id`, `Status`, `CardNumber`, `CardHolder`, `SecurityCode`, `IssuingBank`, `ExpirationDate`) VALUES
(1,	0,	'118609_group16_2020',	'Group 16',	'601',	NULL,	'1125');

DROP TABLE IF EXISTS `rental`;
CREATE TABLE `rental` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BikeId` int(11) NOT NULL,
  `CardId` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `StartTime` timestamp(6) NULL DEFAULT NULL,
  `EndTime` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `rental` (`Id`, `BikeId`, `CardId`, `Status`, `StartTime`, `EndTime`) VALUES
(4,	1,	1,	1,	'2020-12-23 10:00:43.868000',	NULL),
(5,	1,	1,	1,	'2020-12-23 10:05:59.466000',	NULL);

DROP TABLE IF EXISTS `bikerentalpause`;
CREATE TABLE `bikerentalpause` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `RentalId` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `StartTime` datetime NOT NULL,
  `EndTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CardId` int(11) NOT NULL,
  `command` varchar(45) NOT NULL,
  `Amount` float DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `transaction` (`Id`, `CardId`, `command`, `Amount`) VALUES
(1,	1,	'pay',	18);

-- 2021-01-10 03:49:12