/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : jingshuichang

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2011-10-28 15:26:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `jid` varchar(16) NOT NULL,
  `dept` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '王晓明', '1', '1', 'squarlhan@163.com', '13074347302', '000001', null);

-- ----------------------------
-- Table structure for `backward`
-- ----------------------------
DROP TABLE IF EXISTS `backward`;
CREATE TABLE `backward` (
  `bid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `count` int(10) NOT NULL DEFAULT '0',
  `priror` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backward
-- ----------------------------
INSERT INTO `backward` VALUES ('5', '1', '1', '0', '0');

-- ----------------------------
-- Table structure for `backwardandreason`
-- ----------------------------
DROP TABLE IF EXISTS `backwardandreason`;
CREATE TABLE `backwardandreason` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bid` int(10) NOT NULL,
  `nouns_id` int(10) NOT NULL,
  `cf_reason` float(10,0) NOT NULL DEFAULT '1',
  `verb_id` int(10) DEFAULT NULL,
  `sid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFBA61E58DB7478BC` (`bid`),
  KEY `FKFBA61E582AF5CBE` (`nouns_id`),
  KEY `FKFBA61E588586E736` (`verb_id`),
  KEY `FKFBA61E5847112FAE` (`sid`),
  CONSTRAINT `FKFBA61E5847112FAE` FOREIGN KEY (`sid`) REFERENCES `suggestion` (`sid`),
  CONSTRAINT `FKFBA61E582AF5CBE` FOREIGN KEY (`nouns_id`) REFERENCES `nouns` (`nouns_id`),
  CONSTRAINT `FKFBA61E588586E736` FOREIGN KEY (`verb_id`) REFERENCES `verb` (`verb_id`),
  CONSTRAINT `FKFBA61E58DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backwardandreason
-- ----------------------------
INSERT INTO `backwardandreason` VALUES ('4', '5', '14', '1', '16', '4');
INSERT INTO `backwardandreason` VALUES ('5', '5', '15', '1', '16', '5');

-- ----------------------------
-- Table structure for `backwardandresult`
-- ----------------------------
DROP TABLE IF EXISTS `backwardandresult`;
CREATE TABLE `backwardandresult` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bid` int(10) NOT NULL,
  `nouns_id` int(10) NOT NULL,
  `cf_result` float(10,0) NOT NULL DEFAULT '1',
  `verb_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFBAE5431DB7478BC` (`bid`),
  KEY `FKFBAE54312AF5CBE` (`nouns_id`),
  KEY `FKFBAE54318586E736` (`verb_id`),
  CONSTRAINT `FKFBAE54318586E736` FOREIGN KEY (`verb_id`) REFERENCES `verb` (`verb_id`),
  CONSTRAINT `FKFBAE54312AF5CBE` FOREIGN KEY (`nouns_id`) REFERENCES `nouns` (`nouns_id`),
  CONSTRAINT `FKFBAE5431DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandresult
-- ----------------------------
INSERT INTO `backwardandresult` VALUES ('4', '5', '16', '1', '17');

-- ----------------------------
-- Table structure for `forward`
-- ----------------------------
DROP TABLE IF EXISTS `forward`;
CREATE TABLE `forward` (
  `fid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `count` int(10) NOT NULL DEFAULT '0',
  `priror` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forward
-- ----------------------------

-- ----------------------------
-- Table structure for `forwardandreason`
-- ----------------------------
DROP TABLE IF EXISTS `forwardandreason`;
CREATE TABLE `forwardandreason` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fid` int(10) NOT NULL,
  `nouns_id` int(10) NOT NULL,
  `cf_reason` float(10,0) NOT NULL DEFAULT '1',
  `verb_id` int(10) DEFAULT NULL,
  `sid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC8D1F9F62D39836A` (`fid`),
  KEY `FKC8D1F9F62AF5CBE` (`nouns_id`),
  KEY `FKC8D1F9F68586E736` (`verb_id`),
  KEY `FKC8D1F9F647112FAE` (`sid`),
  CONSTRAINT `FKC8D1F9F647112FAE` FOREIGN KEY (`sid`) REFERENCES `suggestion` (`sid`),
  CONSTRAINT `FKC8D1F9F62AF5CBE` FOREIGN KEY (`nouns_id`) REFERENCES `nouns` (`nouns_id`),
  CONSTRAINT `FKC8D1F9F62D39836A` FOREIGN KEY (`fid`) REFERENCES `forward` (`fid`),
  CONSTRAINT `FKC8D1F9F68586E736` FOREIGN KEY (`verb_id`) REFERENCES `verb` (`verb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of forwardandreason
-- ----------------------------

-- ----------------------------
-- Table structure for `forwardandresult`
-- ----------------------------
DROP TABLE IF EXISTS `forwardandresult`;
CREATE TABLE `forwardandresult` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fid` int(10) NOT NULL,
  `nouns_id` int(10) NOT NULL,
  `cf_result` float(10,0) NOT NULL DEFAULT '1',
  `verb_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC8DA2FCF2D39836A` (`fid`),
  KEY `FKC8DA2FCF2AF5CBE` (`nouns_id`),
  KEY `FKC8DA2FCF8586E736` (`verb_id`),
  CONSTRAINT `FKC8DA2FCF8586E736` FOREIGN KEY (`verb_id`) REFERENCES `verb` (`verb_id`),
  CONSTRAINT `FKC8DA2FCF2AF5CBE` FOREIGN KEY (`nouns_id`) REFERENCES `nouns` (`nouns_id`),
  CONSTRAINT `FKC8DA2FCF2D39836A` FOREIGN KEY (`fid`) REFERENCES `forward` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of forwardandresult
-- ----------------------------

-- ----------------------------
-- Table structure for `nouns`
-- ----------------------------
DROP TABLE IF EXISTS `nouns`;
CREATE TABLE `nouns` (
  `nouns_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nouns_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of nouns
-- ----------------------------
INSERT INTO `nouns` VALUES ('14', '1', '1');
INSERT INTO `nouns` VALUES ('15', '2', '2');
INSERT INTO `nouns` VALUES ('16', '3', '3');

-- ----------------------------
-- Table structure for `suggestion`
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `memo` varchar(100) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO `suggestion` VALUES ('4', '1', '1');
INSERT INTO `suggestion` VALUES ('5', '2', '2');
INSERT INTO `suggestion` VALUES ('6', '3', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `dept` varchar(255) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `jid` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (null, '1', '王晓明', '1', '1', 'squarlhan@163.com', '13074347302', '000001');

-- ----------------------------
-- Table structure for `verb`
-- ----------------------------
DROP TABLE IF EXISTS `verb`;
CREATE TABLE `verb` (
  `verb_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `memo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`verb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verb
-- ----------------------------
INSERT INTO `verb` VALUES ('16', '1', '1');
INSERT INTO `verb` VALUES ('17', '2', '2');
