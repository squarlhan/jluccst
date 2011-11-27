/*
Navicat MySQL Data Transfer

Source Server         : aa
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : wushuichang

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2011-11-27 16:17:51
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
INSERT INTO `admin` VALUES ('1', '王晓明', '1', '1', 'squarlhan@163.com', '13074347302', '00010', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backward
-- ----------------------------
INSERT INTO `backward` VALUES ('16', '1-1-1', '预处理单元426A岗位规则1', '0', '0');
INSERT INTO `backward` VALUES ('18', '1-1-2', '预处理单元426A岗位规则2', '0', '0');
INSERT INTO `backward` VALUES ('19', '1-1-3', '预处理单元426A岗位规则3', '0', '0');
INSERT INTO `backward` VALUES ('22', '1-1-4', '预处理单元426A岗位规则4', '0', '0');
INSERT INTO `backward` VALUES ('23', '1-1-5', '预处理单元426A岗位规则5', '0', '0');
INSERT INTO `backward` VALUES ('24', '1-1-6', '预处理单元426A岗位规则6', '0', '0');
INSERT INTO `backward` VALUES ('25', '1-2-1', '预处理单元466岗位规则1', '0', '0');
INSERT INTO `backward` VALUES ('26', '1-2-2', '预处理单元466岗位规则2', '0', '0');
INSERT INTO `backward` VALUES ('27', '1-2-3', '预处理单元466岗位规则3', '0', '0');
INSERT INTO `backward` VALUES ('28', '1-2-4', '预处理单元466岗位规则4', '0', '0');
INSERT INTO `backward` VALUES ('29', '1-2-5', '预处理单元466岗位规则5', '0', '0');
INSERT INTO `backward` VALUES ('30', '1-2-6', '预处理单元466岗位规则6', '0', '0');
INSERT INTO `backward` VALUES ('31', '1-2-7', '预处理单元466岗位规则7', '0', '0');
INSERT INTO `backward` VALUES ('32', '1-2-8', '预处理单元466岗位规则8', '0', '0');
INSERT INTO `backward` VALUES ('33', '格栅机1', '格栅机1', '0', '0');
INSERT INTO `backward` VALUES ('34', '格栅机2', '格栅机2', '0', '0');
INSERT INTO `backward` VALUES ('36', '格栅机3', '格栅机3', '0', '0');
INSERT INTO `backward` VALUES ('38', '格栅机4', '格栅机4', '0', '0');
INSERT INTO `backward` VALUES ('39', '刮泥机1', '刮泥机1', '0', '0');
INSERT INTO `backward` VALUES ('40', '刮泥机2', '刮泥机2', '0', '0');
INSERT INTO `backward` VALUES ('41', '刮砂机1', '刮砂机1', '0', '0');
INSERT INTO `backward` VALUES ('42', '刮砂机2', '刮砂机2', '0', '0');
INSERT INTO `backward` VALUES ('43', '刮砂机3', '刮砂机3', '0', '0');
INSERT INTO `backward` VALUES ('44', '刮砂机4', '刮砂机4', '0', '0');
INSERT INTO `backward` VALUES ('45', '刮砂机5', '刮砂机5', '0', '0');
INSERT INTO `backward` VALUES ('46', '潜水排污泵1', '潜水排污泵1', '0', '0');
INSERT INTO `backward` VALUES ('47', '潜水排污泵2', '潜水排污泵2', '0', '0');
INSERT INTO `backward` VALUES ('48', '潜水排污泵3', '潜水排污泵3', '0', '0');
INSERT INTO `backward` VALUES ('49', '潜水排污泵4', '潜水排污泵4', '0', '0');
INSERT INTO `backward` VALUES ('50', '潜水排污泵5', '潜水排污泵5', '0', '0');
INSERT INTO `backward` VALUES ('51', '潜水排污泵6', '潜水排污泵6', '0', '0');
INSERT INTO `backward` VALUES ('52', '潜水排污泵7', '潜水排污泵7', '0', '0');
INSERT INTO `backward` VALUES ('53', '潜水排污泵8', '潜水排污泵8', '0', '0');
INSERT INTO `backward` VALUES ('54', '潜水排污泵9', '潜水排污泵9', '0', '0');
INSERT INTO `backward` VALUES ('55', '潜水排污泵10', '潜水排污泵10', '0', '0');
INSERT INTO `backward` VALUES ('56', '潜水排污泵11', '潜水排污泵11', '0', '0');
INSERT INTO `backward` VALUES ('57', '潜水排污泵12', '潜水排污泵12', '0', '0');
INSERT INTO `backward` VALUES ('58', '螺杆泵1', '螺杆泵1', '0', '0');
INSERT INTO `backward` VALUES ('59', '螺杆泵2', '螺杆泵2', '0', '0');
INSERT INTO `backward` VALUES ('60', '螺杆泵3', '螺杆泵3', '0', '0');
INSERT INTO `backward` VALUES ('61', '螺杆泵4', '螺杆泵4', '0', '0');
INSERT INTO `backward` VALUES ('62', '螺杆泵5', '螺杆泵5', '0', '0');
INSERT INTO `backward` VALUES ('63', '螺杆泵6', '螺杆泵6', '0', '0');
INSERT INTO `backward` VALUES ('64', '带式压榨过滤机1', '带式压榨过滤机1', '0', '0');
INSERT INTO `backward` VALUES ('65', '带式压榨过滤机2', '带式压榨过滤机2', '0', '0');
INSERT INTO `backward` VALUES ('66', '带式压榨过滤机3', '带式压榨过滤机3', '0', '0');
INSERT INTO `backward` VALUES ('67', '皮带输送机1', '皮带输送机1', '0', '0');
INSERT INTO `backward` VALUES ('68', '皮带输送机2', '皮带输送机2', '0', '0');
INSERT INTO `backward` VALUES ('69', '皮带输送机3', '皮带输送机3', '0', '0');
INSERT INTO `backward` VALUES ('70', '离心机1', '离心机1', '0', '0');
INSERT INTO `backward` VALUES ('72', '离心机2', '离心机2', '0', '0');
INSERT INTO `backward` VALUES ('73', '离心机3', '离心机3', '0', '0');
INSERT INTO `backward` VALUES ('74', '离心机4', '离心机4', '0', '0');
INSERT INTO `backward` VALUES ('75', '离心机5', '离心机5', '0', '0');
INSERT INTO `backward` VALUES ('76', '离心机6', '离心机6', '0', '0');
INSERT INTO `backward` VALUES ('77', '离心机7', '离心机7', '0', '0');
INSERT INTO `backward` VALUES ('79', '离心机8', '离心机8', '0', '0');
INSERT INTO `backward` VALUES ('80', '离心机9', '离心机9', '0', '0');
INSERT INTO `backward` VALUES ('81', '离心机10', '离心机10', '0', '0');
INSERT INTO `backward` VALUES ('82', '离心机11', '离心机11', '0', '0');
INSERT INTO `backward` VALUES ('83', '离心机12', '离心机12', '0', '0');
INSERT INTO `backward` VALUES ('84', '离心机13', '离心机13', '0', '0');
INSERT INTO `backward` VALUES ('85', '排污泵1', '排污泵1', '0', '0');
INSERT INTO `backward` VALUES ('86', '排污泵2', '排污泵2', '0', '0');
INSERT INTO `backward` VALUES ('87', '排污泵3', '排污泵3', '0', '0');
INSERT INTO `backward` VALUES ('88', '排污泵4', '排污泵4', '0', '0');
INSERT INTO `backward` VALUES ('89', '排污泵5', '排污泵5', '0', '0');
INSERT INTO `backward` VALUES ('90', '排污泵6', '排污泵6', '0', '0');
INSERT INTO `backward` VALUES ('91', '生化部分提泥阀1', '生化部分提泥阀1', '0', '0');
INSERT INTO `backward` VALUES ('92', '生化部分提泥阀2', '生化部分提泥阀2', '0', '0');
INSERT INTO `backward` VALUES ('93', '生化部分提泥阀3', '生化部分提泥阀3', '0', '0');
INSERT INTO `backward` VALUES ('94', '生化部分提泥阀4', '生化部分提泥阀4', '0', '0');
INSERT INTO `backward` VALUES ('95', '生化部分离心泵1', '生化部分离心泵1', '0', '0');
INSERT INTO `backward` VALUES ('96', '生化部分离心泵2', '生化部分离心泵2', '0', '0');
INSERT INTO `backward` VALUES ('97', '生化部分离心泵3', '生化部分离心泵3', '0', '0');
INSERT INTO `backward` VALUES ('98', '生化部分离心泵4', '生化部分离心泵4', '0', '0');
INSERT INTO `backward` VALUES ('99', '生化部分离心泵5', '生化部分离心泵5', '0', '0');
INSERT INTO `backward` VALUES ('100', '生化部分离心泵6', '生化部分离心泵6', '0', '0');
INSERT INTO `backward` VALUES ('101', '生化部分离心泵7', '生化部分离心泵7', '0', '0');
INSERT INTO `backward` VALUES ('102', '生化部分鼓风机1', '生化部分鼓风机1', '0', '0');
INSERT INTO `backward` VALUES ('103', '生化部分鼓风机2', '生化部分鼓风机2', '0', '0');
INSERT INTO `backward` VALUES ('104', '生化部分鼓风机3', '生化部分鼓风机3', '0', '0');
INSERT INTO `backward` VALUES ('105', '生化部分空压机1', '生化部分空压机1', '0', '0');
INSERT INTO `backward` VALUES ('106', '生化部分空压机2', '生化部分空压机2', '0', '0');
INSERT INTO `backward` VALUES ('107', '生化部分空压机3', '生化部分空压机3', '0', '0');
INSERT INTO `backward` VALUES ('108', '生化部分空压机4', '生化部分空压机4', '0', '0');
INSERT INTO `backward` VALUES ('109', '生化部分空压机5', '生化部分空压机5', '0', '0');
INSERT INTO `backward` VALUES ('110', '生化部分空压机6', '生化部分空压机6', '0', '0');
INSERT INTO `backward` VALUES ('111', '生化部分臭氧机1', '生化部分臭氧机1', '0', '0');
INSERT INTO `backward` VALUES ('112', '生化部分臭氧机2', '生化部分臭氧机2', '0', '0');
INSERT INTO `backward` VALUES ('113', '生化部分臭氧机3', '生化部分臭氧机3', '0', '0');
INSERT INTO `backward` VALUES ('114', '生化部分臭氧机4', '生化部分臭氧机4', '0', '0');
INSERT INTO `backward` VALUES ('115', '生化部分臭氧机5', '生化部分臭氧机5', '0', '0');
INSERT INTO `backward` VALUES ('116', '生化池', '', '0', '0');
INSERT INTO `backward` VALUES ('117', '', '', '0', '0');
INSERT INTO `backward` VALUES ('118', '', '', '0', '0');
INSERT INTO `backward` VALUES ('119', 'jfhdkj;', 'dsda', '0', '0');
INSERT INTO `backward` VALUES ('120', '生化池', '生化池COD', '0', '0');
INSERT INTO `backward` VALUES ('121', '生化池', '', '0', '0');
INSERT INTO `backward` VALUES ('122', '', '', '0', '0');
INSERT INTO `backward` VALUES ('123', '溶解氧', '', '0', '0');
INSERT INTO `backward` VALUES ('124', '', '', '0', '0');
INSERT INTO `backward` VALUES ('125', '', '', '0', '0');
INSERT INTO `backward` VALUES ('126', '', '', '0', '0');
INSERT INTO `backward` VALUES ('127', '生化池', 'PH', '0', '0');
INSERT INTO `backward` VALUES ('128', '生化池', 'PH', '0', '0');
INSERT INTO `backward` VALUES ('129', '生化池', '水量不足', '0', '0');

-- ----------------------------
-- Table structure for `backwardandlower`
-- ----------------------------
DROP TABLE IF EXISTS `backwardandlower`;
CREATE TABLE `backwardandlower` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB539CC6DDB7478BC` (`bid`),
  KEY `FKB539CC6D96D877EE` (`did`),
  CONSTRAINT `FKB539CC6DDB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backwardandlower
-- ----------------------------

-- ----------------------------
-- Table structure for `backwardandreason`
-- ----------------------------
DROP TABLE IF EXISTS `backwardandreason`;
CREATE TABLE `backwardandreason` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bid` int(10) NOT NULL,
  `nouns` varchar(255) NOT NULL,
  `cf_reason` float(10,0) NOT NULL DEFAULT '1',
  `verb` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFBA61E58DB7478BC` (`bid`),
  CONSTRAINT `FKFBA61E58DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=327 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandreason
-- ----------------------------
INSERT INTO `backwardandreason` VALUES ('324', '127', '中和站', '0', '控制不好', '增加测试PH频次，向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('325', '128', '中和站', '0', '控制不好', '增加测试PH频次，向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('326', '129', '液位', '0', '不合适', '调整液位');

-- ----------------------------
-- Table structure for `backwardandresult`
-- ----------------------------
DROP TABLE IF EXISTS `backwardandresult`;
CREATE TABLE `backwardandresult` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bid` int(10) NOT NULL,
  `nouns` varchar(255) NOT NULL,
  `cf_result` float(10,0) NOT NULL DEFAULT '1',
  `verb` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFBAE5431DB7478BC` (`bid`),
  CONSTRAINT `FKFBAE5431DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandresult
-- ----------------------------
INSERT INTO `backwardandresult` VALUES ('112', '127', '生化池系列2 (3号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('113', '128', '生化池系列2 (3号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('114', '129', '生化池系列2 (3号生化池)水量', '0', '过低', null);

-- ----------------------------
-- Table structure for `backwardandupper`
-- ----------------------------
DROP TABLE IF EXISTS `backwardandupper`;
CREATE TABLE `backwardandupper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB5B8FA0EDB7478BC` (`bid`),
  KEY `FKB5B8FA0E96D877EE` (`did`),
  CONSTRAINT `FKB5B8FA0EDB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backwardandupper
-- ----------------------------

-- ----------------------------
-- Table structure for `dcsdata`
-- ----------------------------
DROP TABLE IF EXISTS `dcsdata`;
CREATE TABLE `dcsdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdata
-- ----------------------------
INSERT INTO `dcsdata` VALUES ('57', '2系列生化池', '班次', '0');
INSERT INTO `dcsdata` VALUES ('58', '2系列生化池', '3号生化池PH', '22');

-- ----------------------------
-- Table structure for `dcsdscrib`
-- ----------------------------
DROP TABLE IF EXISTS `dcsdscrib`;
CREATE TABLE `dcsdscrib` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `eque` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `lower` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `upper` double DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=1372 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdscrib
-- ----------------------------
INSERT INTO `dcsdscrib` VALUES ('1083', '2系列生化池', '3号生化池PH', '6', '生化池系列2 (3号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1084', '2系列生化池', '3号生化池COD', '0', '生化池系列2 (3号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1332', '2系列生化池', '3号生化池碱度', '8', '生化池系列2 (3号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1333', '2系列生化池', '3号生化池BOD5', '2', '生化池系列2 (3号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1334', '2系列生化池', '3号生化池SS', '100', '生化池系列2 (3号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1335', '2系列生化池', '3号生化池NH3-N', '0', '生化池系列2 (3号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1336', '2系列生化池', '3号生化池硝态氮', '100', '生化池系列2 (3号生化池)硝态氮', '500');
INSERT INTO `dcsdscrib` VALUES ('1337', '2系列生化池', '3号生化池溶解氧', '0', '生化池系列2 (3号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1338', '2系列生化池', '3号生化池风量', '0', '生化池系列2 (3号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1339', '2系列生化池', '3号生化池NO-N', '0', '生化池系列2 (3号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1340', '2系列生化池', '3号生化池水量', '100', '生化池系列2 (3号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1361', '2系列生化池', '4号生化池COD', '0', '生化池系列2 (4号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1362', '2系列生化池', '4号生化池碱度', '8', '生化池系列2 (4号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1363', '2系列生化池', '3号生化池BOD5', '2', '生化池系列2 (4号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1364', '2系列生化池', '3号生化池SS', '100', '生化池系列2 (4号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1365', '2系列生化池', '4号生化池NH3-N', '0', '生化池系列2 (4号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1366', '2系列生化池', '4号生化池硝态氮', '0', '生化池系列2 (4号生化池)硝态氮', '50');
INSERT INTO `dcsdscrib` VALUES ('1367', '2系列生化池', '4号生化池溶解氧', '0', '生化池系列2 (4号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1368', '2系列生化池', '4号生化池风量', '0', '生化池系列2 (4号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1369', '2系列生化池', '4号生化池NO-N', '0', '生化池系列2 (4号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1370', '2系列生化池', '4号生化池水量', '100', '生化池系列2 (4号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1371', '2系列生化池', '4号生化池PH', '6', '生化池系列2 (4号生化池)PH', '9');

-- ----------------------------
-- Table structure for `dcshistory`
-- ----------------------------
DROP TABLE IF EXISTS `dcshistory`;
CREATE TABLE `dcshistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `seqno` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcshistory
-- ----------------------------
INSERT INTO `dcshistory` VALUES ('1', '2系列生化池', '3号生化池PH', null, '33');
INSERT INTO `dcshistory` VALUES ('2', '2系列生化池', '4号生化池PH', null, '33');
INSERT INTO `dcshistory` VALUES ('3', '2系列生化池', '3号生化池COD', null, '33');
INSERT INTO `dcshistory` VALUES ('4', '2系列生化池', '3号生化池碱度', null, '33');
INSERT INTO `dcshistory` VALUES ('5', '2系列生化池', '班次', '2011-11-21 00:04:57', '0');
INSERT INTO `dcshistory` VALUES ('6', '2系列生化池', '3号生化池PH', null, '22');
INSERT INTO `dcshistory` VALUES ('7', '2系列生化池', '3号生化池COD', null, '22');
INSERT INTO `dcshistory` VALUES ('8', '2系列生化池', '3号生化池碱度', null, '22');
INSERT INTO `dcshistory` VALUES ('9', '2系列生化池', '3号生化池BOD5', null, '22');
INSERT INTO `dcshistory` VALUES ('10', '2系列生化池', '班次', '2011-11-21 00:17:16', '0');
INSERT INTO `dcshistory` VALUES ('11', '2系列生化池', '3号生化池PH', null, '111');
INSERT INTO `dcshistory` VALUES ('12', '2系列生化池', '3号生化池COD', null, '222');
INSERT INTO `dcshistory` VALUES ('13', '2系列生化池', '3号生化池碱度', null, '111');
INSERT INTO `dcshistory` VALUES ('14', '2系列生化池', '班次', '2011-11-21 00:22:46', '8');
INSERT INTO `dcshistory` VALUES ('15', '2系列生化池', '3号生化池PH', null, '7');
INSERT INTO `dcshistory` VALUES ('16', '2系列生化池', '班次', '2011-11-21 00:48:29', '8');
INSERT INTO `dcshistory` VALUES ('17', '2系列生化池', '3号生化池PH', null, '999');
INSERT INTO `dcshistory` VALUES ('18', '2系列生化池', '班次', '2011-11-21 00:49:30', '8');
INSERT INTO `dcshistory` VALUES ('19', '2系列生化池', '3号生化池PH', null, '111');
INSERT INTO `dcshistory` VALUES ('20', '2系列生化池', '3号生化池溶解氧', null, '999');
INSERT INTO `dcshistory` VALUES ('21', '2系列生化池', '班次', '2011-11-21 01:18:06', '0');
INSERT INTO `dcshistory` VALUES ('22', '2系列生化池', '3号生化池PH', null, '999');
INSERT INTO `dcshistory` VALUES ('23', '2系列生化池', '3号生化池COD', null, '9');
INSERT INTO `dcshistory` VALUES ('24', '2系列生化池', '3号生化池碱度', null, '999');
INSERT INTO `dcshistory` VALUES ('25', '2系列生化池', '3号生化池溶解氧', null, '999');
INSERT INTO `dcshistory` VALUES ('26', '2系列生化池', '班次', '2011-11-21 01:26:30', '0');
INSERT INTO `dcshistory` VALUES ('27', '2系列生化池', '3号生化池溶解氧', null, '22222222');
INSERT INTO `dcshistory` VALUES ('28', '2系列生化池', '班次', '2011-11-21 01:27:07', '0');
INSERT INTO `dcshistory` VALUES ('29', '2系列生化池', '3号生化池PH', null, '333');
INSERT INTO `dcshistory` VALUES ('30', '2系列生化池', '3号生化池碱度', null, '3333');
INSERT INTO `dcshistory` VALUES ('31', '2系列生化池', '3号生化池溶解氧', null, '3333');
INSERT INTO `dcshistory` VALUES ('32', '2系列生化池', '班次', '2011-11-21 01:30:51', '0');
INSERT INTO `dcshistory` VALUES ('33', '2系列生化池', '3号生化池PH', null, '7');
INSERT INTO `dcshistory` VALUES ('34', '2系列生化池', '班次', '2011-11-21 12:57:34', '0');
INSERT INTO `dcshistory` VALUES ('35', '2系列生化池', '3号生化池PH', null, '9999');
INSERT INTO `dcshistory` VALUES ('36', '2系列生化池', '班次', '2011-11-21 12:57:50', '0');
INSERT INTO `dcshistory` VALUES ('37', '2系列生化池', '3号生化池PH', null, '111');
INSERT INTO `dcshistory` VALUES ('38', '2系列生化池', '3号生化池水量', null, '1');
INSERT INTO `dcshistory` VALUES ('39', '2系列生化池', '班次', '2011-11-21 13:04:38', '0');
INSERT INTO `dcshistory` VALUES ('40', '2系列生化池', '3号生化池PH', null, '1');
INSERT INTO `dcshistory` VALUES ('41', '2系列生化池', '3号生化池COD', null, '1');
INSERT INTO `dcshistory` VALUES ('42', '2系列生化池', '3号生化池碱度', null, '1');
INSERT INTO `dcshistory` VALUES ('43', '2系列生化池', '班次', '2011-11-21 13:08:01', '8');
INSERT INTO `dcshistory` VALUES ('44', '2系列生化池', '3号生化池PH', null, '111');
INSERT INTO `dcshistory` VALUES ('45', '2系列生化池', '3号生化池COD', null, '1');
INSERT INTO `dcshistory` VALUES ('46', '2系列生化池', '3号生化池碱度', null, '1');
INSERT INTO `dcshistory` VALUES ('47', '2系列生化池', '班次', '2011-11-21 13:14:12', '0');
INSERT INTO `dcshistory` VALUES ('48', '2系列生化池', '3号生化池PH', null, '7');
INSERT INTO `dcshistory` VALUES ('49', '2系列生化池', '班次', '2011-11-21 13:15:37', '0');
INSERT INTO `dcshistory` VALUES ('50', '2系列生化池', '班次', '2011-11-27 15:04:02', '0');
INSERT INTO `dcshistory` VALUES ('51', '2系列生化池', '3号生化池PH', '2011-11-27 15:04:02', '2');
INSERT INTO `dcshistory` VALUES ('52', '2系列生化池', '班次', '2011-11-27 15:06:13', '0');
INSERT INTO `dcshistory` VALUES ('53', '2系列生化池', '3号生化池PH', '2011-11-27 15:06:13', '111');
INSERT INTO `dcshistory` VALUES ('54', '2系列生化池', '班次', '2011-11-27 15:10:07', '0');
INSERT INTO `dcshistory` VALUES ('55', '2系列生化池', '3号生化池PH', '2011-11-27 15:10:07', '22');

-- ----------------------------
-- Table structure for `dss_advice`
-- ----------------------------
DROP TABLE IF EXISTS `dss_advice`;
CREATE TABLE `dss_advice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) DEFAULT NULL,
  `value` varchar(20) DEFAULT NULL,
  `sugg` varchar(1000) DEFAULT NULL,
  `simu_time` varchar(20) DEFAULT NULL,
  `seqno` varchar(20) DEFAULT NULL,
  `error` varchar(200) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75158BF39A42C930` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_advice
-- ----------------------------

-- ----------------------------
-- Table structure for `dss_history`
-- ----------------------------
DROP TABLE IF EXISTS `dss_history`;
CREATE TABLE `dss_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `error` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `seqno` varchar(255) DEFAULT NULL,
  `simu_time` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

-- ----------------------------
-- Records of dss_history
-- ----------------------------

-- ----------------------------
-- Table structure for `errorlog`
-- ----------------------------
DROP TABLE IF EXISTS `errorlog`;
CREATE TABLE `errorlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `error` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of errorlog
-- ----------------------------
INSERT INTO `errorlog` VALUES ('1', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 00:04:57', '33', null, null);
INSERT INTO `errorlog` VALUES ('2', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 00:17:16', '22', null, null);
INSERT INTO `errorlog` VALUES ('3', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 00:22:46', '111', null, null);
INSERT INTO `errorlog` VALUES ('4', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 00:49:30', '999', null, null);
INSERT INTO `errorlog` VALUES ('5', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 01:18:06', '111', null, null);
INSERT INTO `errorlog` VALUES ('6', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 01:26:29', '999', null, null);
INSERT INTO `errorlog` VALUES ('7', '2系列生化池', '3号生化池COD', '过高', '2011-11-21 01:26:29', '9', null, null);
INSERT INTO `errorlog` VALUES ('8', '2系列生化池', '3号生化池碱度', '过高', '2011-11-21 01:26:29', '999', null, null);
INSERT INTO `errorlog` VALUES ('9', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 01:30:51', '333', null, null);
INSERT INTO `errorlog` VALUES ('10', '2系列生化池', '3号生化池碱度', '过高', '2011-11-21 01:30:51', '3333', null, null);
INSERT INTO `errorlog` VALUES ('11', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 12:57:49', '9999', null, null);
INSERT INTO `errorlog` VALUES ('12', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 13:04:38', '111', null, null);
INSERT INTO `errorlog` VALUES ('13', '2系列生化池', '3号生化池水量', '过低', '2011-11-21 13:04:38', '1', null, null);
INSERT INTO `errorlog` VALUES ('14', '2系列生化池', '3号生化池PH', '过低', '2011-11-21 13:08:01', '1', null, null);
INSERT INTO `errorlog` VALUES ('15', '2系列生化池', '3号生化池COD', '过高', '2011-11-21 13:08:01', '1', null, null);
INSERT INTO `errorlog` VALUES ('16', '2系列生化池', '3号生化池碱度', '过低', '2011-11-21 13:08:01', '1', null, null);
INSERT INTO `errorlog` VALUES ('17', '2系列生化池', '3号生化池PH', '过高', '2011-11-21 13:14:12', '111', null, null);
INSERT INTO `errorlog` VALUES ('18', '2系列生化池', '3号生化池COD', '过高', '2011-11-21 13:14:12', '1', null, null);
INSERT INTO `errorlog` VALUES ('19', '2系列生化池', '3号生化池碱度', '过低', '2011-11-21 13:14:12', '1', null, null);
INSERT INTO `errorlog` VALUES ('20', '2系列生化池', '3号生化池PH', '过低', '2011-11-27 15:04:02', '2', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('21', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 15:06:13', '111', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('22', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 15:10:07', '22', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');

-- ----------------------------
-- Table structure for `exceldata`
-- ----------------------------
DROP TABLE IF EXISTS `exceldata`;
CREATE TABLE `exceldata` (
  `id` varchar(36) NOT NULL,
  `name` varchar(36) DEFAULT NULL,
  `value` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exceldata
-- ----------------------------
INSERT INTO `exceldata` VALUES ('FINAL.COD', '出口水质.COD', '71');
INSERT INTO `exceldata` VALUES ('FINAL.NH3-N', '出口水质.NH3-N', '0');
INSERT INTO `exceldata` VALUES ('FINAL.PH', '出口水质.PH', '6');
INSERT INTO `exceldata` VALUES ('FINAL.SS', '出口水质.SS', '29');
INSERT INTO `exceldata` VALUES ('w1.COD', '染料厂酸水.COD', '500.0');
INSERT INTO `exceldata` VALUES ('w1.Q', '染料厂酸水.流量', '531.0');
INSERT INTO `exceldata` VALUES ('w10.COD', '铁运489沉淀池出水.COD', '924.0');
INSERT INTO `exceldata` VALUES ('w10.Q', '铁运489沉淀池出水.流量', '1.0');
INSERT INTO `exceldata` VALUES ('w11.Q', '含氮废水.流量', '100.0');
INSERT INTO `exceldata` VALUES ('w12.Q', '103厂碱水.流量', '0.0');
INSERT INTO `exceldata` VALUES ('w13.COD', '化肥厂丁辛醇废水.COD', '2510.0');
INSERT INTO `exceldata` VALUES ('w13.Q', '化肥厂丁辛醇废水.流量', '95.0');
INSERT INTO `exceldata` VALUES ('w14.COD', '丙烯腈厂废水.COD', '212.0');
INSERT INTO `exceldata` VALUES ('w14.Q', '丙烯腈厂废水.流量', '200.0');
INSERT INTO `exceldata` VALUES ('w15.COD', '合成树脂厂废水.COD', '492.5');
INSERT INTO `exceldata` VALUES ('w15.Q', '合成树脂厂废水.流量', '190.0');
INSERT INTO `exceldata` VALUES ('w16.Q', '龙潭区生活污水.流量', '1342.0');
INSERT INTO `exceldata` VALUES ('w2.COD', '电石厂酸水.COD', '1735.0');
INSERT INTO `exceldata` VALUES ('w2.Q', '电石厂酸水.流量', '206.0');
INSERT INTO `exceldata` VALUES ('w3.COD', '电石厂有机废水.COD', '1595.0');
INSERT INTO `exceldata` VALUES ('w3.Q', '电石厂有机废水.流量', '155.0');
INSERT INTO `exceldata` VALUES ('w4.COD', '有机合成厂有机废水.COD', '366.0');
INSERT INTO `exceldata` VALUES ('w4.Q', '有机合成厂有机废水.流量', '646.0');
INSERT INTO `exceldata` VALUES ('w5.COD', '炼油厂有机废水.COD', '260.5');
INSERT INTO `exceldata` VALUES ('w5.Q', '炼油厂有机废水.流量', '1010.0');
INSERT INTO `exceldata` VALUES ('w6.COD', '精细化学品厂废水.COD', '622.5');
INSERT INTO `exceldata` VALUES ('w6.Q', '精细化学品厂废水.流量', '71.0');
INSERT INTO `exceldata` VALUES ('w7.COD', '乙二醇废水.COD', '532');
INSERT INTO `exceldata` VALUES ('w7.Q', '乙二醇废水.流量', '40.0');
INSERT INTO `exceldata` VALUES ('w8.COD', '环氧乙烷废水.COD', '195');
INSERT INTO `exceldata` VALUES ('w8.Q', '环氧乙烷废水.流量', '50.0');
INSERT INTO `exceldata` VALUES ('w9.COD', '农药厂废水.COD', '0.0');
INSERT INTO `exceldata` VALUES ('w9.Q', '农药厂废水.流量', '0.0');
INSERT INTO `exceldata` VALUES ('ws.COD', '2系列生化池.3号生化池COD', '22');
INSERT INTO `exceldata` VALUES ('WW14A.COD', '14#A.COD', '582');
INSERT INTO `exceldata` VALUES ('WW14A.NH3-N', '14#A.NH3-N', '10');
INSERT INTO `exceldata` VALUES ('WW14A.PH', '14#A.PH', '7');
INSERT INTO `exceldata` VALUES ('WW14A.Q', '14#A.流量', '3795.0');
INSERT INTO `exceldata` VALUES ('WW14A.SS', '14#A.SS', '179');
INSERT INTO `exceldata` VALUES ('WW14B.COD', '14#B.COD', '257');
INSERT INTO `exceldata` VALUES ('WW14B.NH3-N', '14#B.NH3-N', '33');
INSERT INTO `exceldata` VALUES ('WW14B.PH', '14#B.PH', '7');
INSERT INTO `exceldata` VALUES ('WW14B.Q', '14#B.流量', '1442.0');
INSERT INTO `exceldata` VALUES ('WW14B.SS', '14#B.SS', '175');

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
  `nouns` varchar(255) NOT NULL,
  `cf_reason` float(10,0) NOT NULL DEFAULT '1',
  `verb` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC8D1F9F62D39836A` (`fid`),
  CONSTRAINT `FKC8D1F9F62D39836A` FOREIGN KEY (`fid`) REFERENCES `forward` (`fid`)
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
  `nouns` varchar(255) NOT NULL,
  `cf_result` float(10,0) NOT NULL DEFAULT '1',
  `verb` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC8DA2FCF2D39836A` (`fid`),
  CONSTRAINT `FKC8DA2FCF2D39836A` FOREIGN KEY (`fid`) REFERENCES `forward` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of forwardandresult
-- ----------------------------

-- ----------------------------
-- Table structure for `manualdata`
-- ----------------------------
DROP TABLE IF EXISTS `manualdata`;
CREATE TABLE `manualdata` (
  `name` varchar(36) NOT NULL DEFAULT '',
  `value` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manualdata
-- ----------------------------

-- ----------------------------
-- Table structure for `manualdatahistory`
-- ----------------------------
DROP TABLE IF EXISTS `manualdatahistory`;
CREATE TABLE `manualdatahistory` (
  `name` varchar(36) NOT NULL,
  `seqno` varchar(20) NOT NULL,
  `value` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`name`,`seqno`),
  KEY `R_2` (`seqno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manualdatahistory
-- ----------------------------

-- ----------------------------
-- Table structure for `olddcsdata`
-- ----------------------------
DROP TABLE IF EXISTS `olddcsdata`;
CREATE TABLE `olddcsdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ITEM1` float NOT NULL,
  `ITEM10` float NOT NULL,
  `ITEM100` float NOT NULL,
  `ITEM101` float NOT NULL,
  `ITEM102` float NOT NULL,
  `ITEM103` float NOT NULL,
  `ITEM104` float NOT NULL,
  `ITEM105` float NOT NULL,
  `ITEM106` float NOT NULL,
  `ITEM107` float NOT NULL,
  `ITEM108` float NOT NULL,
  `ITEM109` float NOT NULL,
  `ITEM11` float NOT NULL,
  `ITEM110` float NOT NULL,
  `ITEM111` float NOT NULL,
  `ITEM112` float NOT NULL,
  `ITEM113` float NOT NULL,
  `ITEM114` float NOT NULL,
  `ITEM115` float NOT NULL,
  `ITEM116` float NOT NULL,
  `ITEM117` float NOT NULL,
  `ITEM118` float NOT NULL,
  `ITEM119` float NOT NULL,
  `ITEM12` float NOT NULL,
  `ITEM120` float NOT NULL,
  `ITEM121` float NOT NULL,
  `ITEM122` float NOT NULL,
  `ITEM123` float NOT NULL,
  `ITEM124` float NOT NULL,
  `ITEM125` float NOT NULL,
  `ITEM126` float NOT NULL,
  `ITEM127` float NOT NULL,
  `ITEM128` float NOT NULL,
  `ITEM129` float NOT NULL,
  `ITEM13` float NOT NULL,
  `ITEM130` float NOT NULL,
  `ITEM131` float NOT NULL,
  `ITEM132` float NOT NULL,
  `ITEM133` float NOT NULL,
  `ITEM134` float NOT NULL,
  `ITEM135` float NOT NULL,
  `ITEM136` float NOT NULL,
  `ITEM137` float NOT NULL,
  `ITEM138` float NOT NULL,
  `ITEM139` float NOT NULL,
  `ITEM14` float NOT NULL,
  `ITEM140` float NOT NULL,
  `ITEM141` float NOT NULL,
  `ITEM142` float NOT NULL,
  `ITEM143` float NOT NULL,
  `ITEM144` float NOT NULL,
  `ITEM145` float NOT NULL,
  `ITEM146` float NOT NULL,
  `ITEM147` float NOT NULL,
  `ITEM148` float NOT NULL,
  `ITEM149` float NOT NULL,
  `ITEM15` float NOT NULL,
  `ITEM150` float NOT NULL,
  `ITEM151` float NOT NULL,
  `ITEM152` float NOT NULL,
  `ITEM153` float NOT NULL,
  `ITEM154` float NOT NULL,
  `ITEM155` float NOT NULL,
  `ITEM156` float NOT NULL,
  `ITEM157` float NOT NULL,
  `ITEM158` float NOT NULL,
  `ITEM159` float NOT NULL,
  `ITEM16` float NOT NULL,
  `ITEM160` float NOT NULL,
  `ITEM161` float NOT NULL,
  `ITEM162` float NOT NULL,
  `ITEM163` float NOT NULL,
  `ITEM164` float NOT NULL,
  `ITEM165` float NOT NULL,
  `ITEM166` float NOT NULL,
  `ITEM167` float NOT NULL,
  `ITEM168` float NOT NULL,
  `ITEM169` float NOT NULL,
  `ITEM17` float NOT NULL,
  `ITEM170` float NOT NULL,
  `ITEM171` float NOT NULL,
  `ITEM172` float NOT NULL,
  `ITEM173` float NOT NULL,
  `ITEM174` float NOT NULL,
  `ITEM175` float NOT NULL,
  `ITEM176` float NOT NULL,
  `ITEM177` float NOT NULL,
  `ITEM178` float NOT NULL,
  `ITEM179` float NOT NULL,
  `ITEM18` float NOT NULL,
  `ITEM180` float NOT NULL,
  `ITEM181` float NOT NULL,
  `ITEM182` float NOT NULL,
  `ITEM183` float NOT NULL,
  `ITEM184` float NOT NULL,
  `ITEM185` float NOT NULL,
  `ITEM186` float NOT NULL,
  `ITEM187` float NOT NULL,
  `ITEM188` float NOT NULL,
  `ITEM189` float NOT NULL,
  `ITEM19` float NOT NULL,
  `ITEM190` float NOT NULL,
  `ITEM191` float NOT NULL,
  `ITEM192` float NOT NULL,
  `ITEM193` float NOT NULL,
  `ITEM194` float NOT NULL,
  `ITEM195` float NOT NULL,
  `ITEM196` float NOT NULL,
  `ITEM197` float NOT NULL,
  `ITEM198` float NOT NULL,
  `ITEM199` float NOT NULL,
  `ITEM2` float NOT NULL,
  `ITEM20` float NOT NULL,
  `ITEM200` float NOT NULL,
  `ITEM201` float NOT NULL,
  `ITEM202` float NOT NULL,
  `ITEM203` float NOT NULL,
  `ITEM204` float NOT NULL,
  `ITEM205` float NOT NULL,
  `ITEM206` float NOT NULL,
  `ITEM207` float NOT NULL,
  `ITEM208` float NOT NULL,
  `ITEM209` float NOT NULL,
  `ITEM21` float NOT NULL,
  `ITEM210` float NOT NULL,
  `ITEM211` float NOT NULL,
  `ITEM212` float NOT NULL,
  `ITEM213` float NOT NULL,
  `ITEM214` float NOT NULL,
  `ITEM215` float NOT NULL,
  `ITEM216` float NOT NULL,
  `ITEM217` float NOT NULL,
  `ITEM218` float NOT NULL,
  `ITEM219` float NOT NULL,
  `ITEM22` float NOT NULL,
  `ITEM220` float NOT NULL,
  `ITEM221` float NOT NULL,
  `ITEM222` float NOT NULL,
  `ITEM223` float NOT NULL,
  `ITEM224` float NOT NULL,
  `ITEM225` float NOT NULL,
  `ITEM226` float NOT NULL,
  `ITEM227` float NOT NULL,
  `ITEM228` float NOT NULL,
  `ITEM229` float NOT NULL,
  `ITEM23` float NOT NULL,
  `ITEM230` float NOT NULL,
  `ITEM231` float NOT NULL,
  `ITEM232` float NOT NULL,
  `ITEM233` float NOT NULL,
  `ITEM234` float NOT NULL,
  `ITEM235` float NOT NULL,
  `ITEM236` float NOT NULL,
  `ITEM237` float NOT NULL,
  `ITEM238` float NOT NULL,
  `ITEM239` float NOT NULL,
  `ITEM24` float NOT NULL,
  `ITEM240` float NOT NULL,
  `ITEM241` float NOT NULL,
  `ITEM242` float NOT NULL,
  `ITEM243` float NOT NULL,
  `ITEM244` float NOT NULL,
  `ITEM245` float NOT NULL,
  `ITEM246` float NOT NULL,
  `ITEM247` float NOT NULL,
  `ITEM248` float NOT NULL,
  `ITEM249` float NOT NULL,
  `ITEM25` float NOT NULL,
  `ITEM250` float NOT NULL,
  `ITEM251` float NOT NULL,
  `ITEM252` float NOT NULL,
  `ITEM253` float NOT NULL,
  `ITEM254` float NOT NULL,
  `ITEM255` float NOT NULL,
  `ITEM256` float NOT NULL,
  `ITEM257` float NOT NULL,
  `ITEM258` float NOT NULL,
  `ITEM259` float NOT NULL,
  `ITEM26` float NOT NULL,
  `ITEM260` float NOT NULL,
  `ITEM27` float NOT NULL,
  `ITEM28` float NOT NULL,
  `ITEM29` float NOT NULL,
  `ITEM3` float NOT NULL,
  `ITEM30` float NOT NULL,
  `ITEM31` float NOT NULL,
  `ITEM32` float NOT NULL,
  `ITEM33` float NOT NULL,
  `ITEM34` float NOT NULL,
  `ITEM35` float NOT NULL,
  `ITEM36` float NOT NULL,
  `ITEM37` float NOT NULL,
  `ITEM38` float NOT NULL,
  `ITEM39` float NOT NULL,
  `ITEM4` float NOT NULL,
  `ITEM40` float NOT NULL,
  `ITEM41` float NOT NULL,
  `ITEM42` float NOT NULL,
  `ITEM43` float NOT NULL,
  `ITEM44` float NOT NULL,
  `ITEM45` float NOT NULL,
  `ITEM46` float NOT NULL,
  `ITEM47` float NOT NULL,
  `ITEM48` float NOT NULL,
  `ITEM49` float NOT NULL,
  `ITEM5` float NOT NULL,
  `ITEM50` float NOT NULL,
  `ITEM51` float NOT NULL,
  `ITEM52` float NOT NULL,
  `ITEM53` float NOT NULL,
  `ITEM54` float NOT NULL,
  `ITEM55` float NOT NULL,
  `ITEM56` float NOT NULL,
  `ITEM57` float NOT NULL,
  `ITEM58` float NOT NULL,
  `ITEM59` float NOT NULL,
  `ITEM6` float NOT NULL,
  `ITEM60` float NOT NULL,
  `ITEM61` float NOT NULL,
  `ITEM62` float NOT NULL,
  `ITEM63` float NOT NULL,
  `ITEM64` float NOT NULL,
  `ITEM65` float NOT NULL,
  `ITEM66` float NOT NULL,
  `ITEM67` float NOT NULL,
  `ITEM68` float NOT NULL,
  `ITEM69` float NOT NULL,
  `ITEM7` float NOT NULL,
  `ITEM70` float NOT NULL,
  `ITEM71` float NOT NULL,
  `ITEM72` float NOT NULL,
  `ITEM73` float NOT NULL,
  `ITEM74` float NOT NULL,
  `ITEM75` float NOT NULL,
  `ITEM76` float NOT NULL,
  `ITEM77` float NOT NULL,
  `ITEM78` float NOT NULL,
  `ITEM79` float NOT NULL,
  `ITEM8` float NOT NULL,
  `ITEM80` float NOT NULL,
  `ITEM81` float NOT NULL,
  `ITEM82` float NOT NULL,
  `ITEM83` float NOT NULL,
  `ITEM84` float NOT NULL,
  `ITEM85` float NOT NULL,
  `ITEM86` float NOT NULL,
  `ITEM87` float NOT NULL,
  `ITEM88` float NOT NULL,
  `ITEM89` float NOT NULL,
  `ITEM9` float NOT NULL,
  `ITEM90` float NOT NULL,
  `ITEM91` float NOT NULL,
  `ITEM92` float NOT NULL,
  `ITEM93` float NOT NULL,
  `ITEM94` float NOT NULL,
  `ITEM95` float NOT NULL,
  `ITEM96` float NOT NULL,
  `ITEM97` float NOT NULL,
  `ITEM98` float NOT NULL,
  `ITEM99` float NOT NULL,
  `ORGTIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of olddcsdata
-- ----------------------------

-- ----------------------------
-- Table structure for `pre_dss`
-- ----------------------------
DROP TABLE IF EXISTS `pre_dss`;
CREATE TABLE `pre_dss` (
  `name` varchar(36) NOT NULL,
  `value` varchar(64) DEFAULT NULL,
  `simu_time` varchar(20) NOT NULL,
  `seqno` varchar(20) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`seqno`,`simu_time`,`name`),
  KEY `FK5036F6089A42C930` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_dss
-- ----------------------------

-- ----------------------------
-- Table structure for `testuser`
-- ----------------------------
DROP TABLE IF EXISTS `testuser`;
CREATE TABLE `testuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testuser
-- ----------------------------
INSERT INTO `testuser` VALUES ('1', 'aaa', '12');
INSERT INTO `testuser` VALUES ('2', '44', '44');
INSERT INTO `testuser` VALUES ('3', 'sdf', '234');
INSERT INTO `testuser` VALUES ('4', '234', '234');
INSERT INTO `testuser` VALUES ('5', 'wer', '123');
INSERT INTO `testuser` VALUES ('6', 'wer', '123');
INSERT INTO `testuser` VALUES ('7', 'qqq', 'qqq');
INSERT INTO `testuser` VALUES ('8', 'hhh', '123');
INSERT INTO `testuser` VALUES ('9', 'ghj', '123');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', '2', '8', '8', '8', '8', '8', '8');
INSERT INTO `user` VALUES ('123', '3', '123', '张晓明', '123', '123', '123', '123');

-- ----------------------------
-- Table structure for `wwdcsdata`
-- ----------------------------
DROP TABLE IF EXISTS `wwdcsdata`;
CREATE TABLE `wwdcsdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ITEM1` float NOT NULL,
  `ITEM10` float NOT NULL,
  `ITEM100` float NOT NULL,
  `ITEM101` float NOT NULL,
  `ITEM102` float NOT NULL,
  `ITEM103` float NOT NULL,
  `ITEM104` float NOT NULL,
  `ITEM105` float NOT NULL,
  `ITEM106` float NOT NULL,
  `ITEM107` float NOT NULL,
  `ITEM108` float NOT NULL,
  `ITEM109` float NOT NULL,
  `ITEM11` float NOT NULL,
  `ITEM110` float NOT NULL,
  `ITEM111` float NOT NULL,
  `ITEM112` float NOT NULL,
  `ITEM113` float NOT NULL,
  `ITEM114` float NOT NULL,
  `ITEM115` float NOT NULL,
  `ITEM116` float NOT NULL,
  `ITEM117` float NOT NULL,
  `ITEM118` float NOT NULL,
  `ITEM119` float NOT NULL,
  `ITEM12` float NOT NULL,
  `ITEM120` float NOT NULL,
  `ITEM121` float NOT NULL,
  `ITEM122` float NOT NULL,
  `ITEM123` float NOT NULL,
  `ITEM124` float NOT NULL,
  `ITEM125` float NOT NULL,
  `ITEM126` float NOT NULL,
  `ITEM127` float NOT NULL,
  `ITEM128` float NOT NULL,
  `ITEM129` float NOT NULL,
  `ITEM13` float NOT NULL,
  `ITEM130` float NOT NULL,
  `ITEM131` float NOT NULL,
  `ITEM132` float NOT NULL,
  `ITEM133` float NOT NULL,
  `ITEM134` float NOT NULL,
  `ITEM135` float NOT NULL,
  `ITEM136` float NOT NULL,
  `ITEM137` float NOT NULL,
  `ITEM138` float NOT NULL,
  `ITEM139` float NOT NULL,
  `ITEM14` float NOT NULL,
  `ITEM140` float NOT NULL,
  `ITEM141` float NOT NULL,
  `ITEM142` float NOT NULL,
  `ITEM143` float NOT NULL,
  `ITEM144` float NOT NULL,
  `ITEM145` float NOT NULL,
  `ITEM146` float NOT NULL,
  `ITEM147` float NOT NULL,
  `ITEM148` float NOT NULL,
  `ITEM149` float NOT NULL,
  `ITEM15` float NOT NULL,
  `ITEM150` float NOT NULL,
  `ITEM151` float NOT NULL,
  `ITEM152` float NOT NULL,
  `ITEM153` float NOT NULL,
  `ITEM154` float NOT NULL,
  `ITEM155` float NOT NULL,
  `ITEM156` float NOT NULL,
  `ITEM157` float NOT NULL,
  `ITEM158` float NOT NULL,
  `ITEM159` float NOT NULL,
  `ITEM16` float NOT NULL,
  `ITEM160` float NOT NULL,
  `ITEM161` float NOT NULL,
  `ITEM162` float NOT NULL,
  `ITEM163` float NOT NULL,
  `ITEM164` float NOT NULL,
  `ITEM165` float NOT NULL,
  `ITEM166` float NOT NULL,
  `ITEM167` float NOT NULL,
  `ITEM168` float NOT NULL,
  `ITEM169` float NOT NULL,
  `ITEM17` float NOT NULL,
  `ITEM170` float NOT NULL,
  `ITEM171` float NOT NULL,
  `ITEM172` float NOT NULL,
  `ITEM173` float NOT NULL,
  `ITEM174` float NOT NULL,
  `ITEM175` float NOT NULL,
  `ITEM176` float NOT NULL,
  `ITEM177` float NOT NULL,
  `ITEM178` float NOT NULL,
  `ITEM179` float NOT NULL,
  `ITEM18` float NOT NULL,
  `ITEM180` float NOT NULL,
  `ITEM181` float NOT NULL,
  `ITEM182` float NOT NULL,
  `ITEM183` float NOT NULL,
  `ITEM184` float NOT NULL,
  `ITEM185` float NOT NULL,
  `ITEM186` float NOT NULL,
  `ITEM187` float NOT NULL,
  `ITEM188` float NOT NULL,
  `ITEM189` float NOT NULL,
  `ITEM19` float NOT NULL,
  `ITEM190` float NOT NULL,
  `ITEM191` float NOT NULL,
  `ITEM192` float NOT NULL,
  `ITEM193` float NOT NULL,
  `ITEM194` float NOT NULL,
  `ITEM195` float NOT NULL,
  `ITEM196` float NOT NULL,
  `ITEM197` float NOT NULL,
  `ITEM198` float NOT NULL,
  `ITEM199` float NOT NULL,
  `ITEM2` float NOT NULL,
  `ITEM20` float NOT NULL,
  `ITEM200` float NOT NULL,
  `ITEM201` float NOT NULL,
  `ITEM202` float NOT NULL,
  `ITEM203` float NOT NULL,
  `ITEM204` float NOT NULL,
  `ITEM205` float NOT NULL,
  `ITEM206` float NOT NULL,
  `ITEM207` float NOT NULL,
  `ITEM208` float NOT NULL,
  `ITEM209` float NOT NULL,
  `ITEM21` float NOT NULL,
  `ITEM210` float NOT NULL,
  `ITEM211` float NOT NULL,
  `ITEM212` float NOT NULL,
  `ITEM213` float NOT NULL,
  `ITEM214` float NOT NULL,
  `ITEM215` float NOT NULL,
  `ITEM216` float NOT NULL,
  `ITEM217` float NOT NULL,
  `ITEM218` float NOT NULL,
  `ITEM219` float NOT NULL,
  `ITEM22` float NOT NULL,
  `ITEM220` float NOT NULL,
  `ITEM221` float NOT NULL,
  `ITEM222` float NOT NULL,
  `ITEM223` float NOT NULL,
  `ITEM224` float NOT NULL,
  `ITEM225` float NOT NULL,
  `ITEM226` float NOT NULL,
  `ITEM227` float NOT NULL,
  `ITEM228` float NOT NULL,
  `ITEM229` float NOT NULL,
  `ITEM23` float NOT NULL,
  `ITEM230` float NOT NULL,
  `ITEM231` float NOT NULL,
  `ITEM232` float NOT NULL,
  `ITEM233` float NOT NULL,
  `ITEM234` float NOT NULL,
  `ITEM235` float NOT NULL,
  `ITEM236` float NOT NULL,
  `ITEM237` float NOT NULL,
  `ITEM238` float NOT NULL,
  `ITEM239` float NOT NULL,
  `ITEM24` float NOT NULL,
  `ITEM240` float NOT NULL,
  `ITEM241` float NOT NULL,
  `ITEM242` float NOT NULL,
  `ITEM243` float NOT NULL,
  `ITEM244` float NOT NULL,
  `ITEM245` float NOT NULL,
  `ITEM246` float NOT NULL,
  `ITEM247` float NOT NULL,
  `ITEM248` float NOT NULL,
  `ITEM249` float NOT NULL,
  `ITEM25` float NOT NULL,
  `ITEM250` float NOT NULL,
  `ITEM251` float NOT NULL,
  `ITEM252` float NOT NULL,
  `ITEM253` float NOT NULL,
  `ITEM254` float NOT NULL,
  `ITEM255` float NOT NULL,
  `ITEM256` float NOT NULL,
  `ITEM257` float NOT NULL,
  `ITEM258` float NOT NULL,
  `ITEM259` float NOT NULL,
  `ITEM26` float NOT NULL,
  `ITEM260` float NOT NULL,
  `ITEM27` float NOT NULL,
  `ITEM28` float NOT NULL,
  `ITEM29` float NOT NULL,
  `ITEM3` float NOT NULL,
  `ITEM30` float NOT NULL,
  `ITEM31` float NOT NULL,
  `ITEM32` float NOT NULL,
  `ITEM33` float NOT NULL,
  `ITEM34` float NOT NULL,
  `ITEM35` float NOT NULL,
  `ITEM36` float NOT NULL,
  `ITEM37` float NOT NULL,
  `ITEM38` float NOT NULL,
  `ITEM39` float NOT NULL,
  `ITEM4` float NOT NULL,
  `ITEM40` float NOT NULL,
  `ITEM41` float NOT NULL,
  `ITEM42` float NOT NULL,
  `ITEM43` float NOT NULL,
  `ITEM44` float NOT NULL,
  `ITEM45` float NOT NULL,
  `ITEM46` float NOT NULL,
  `ITEM47` float NOT NULL,
  `ITEM48` float NOT NULL,
  `ITEM49` float NOT NULL,
  `ITEM5` float NOT NULL,
  `ITEM50` float NOT NULL,
  `ITEM51` float NOT NULL,
  `ITEM52` float NOT NULL,
  `ITEM53` float NOT NULL,
  `ITEM54` float NOT NULL,
  `ITEM55` float NOT NULL,
  `ITEM56` float NOT NULL,
  `ITEM57` float NOT NULL,
  `ITEM58` float NOT NULL,
  `ITEM59` float NOT NULL,
  `ITEM6` float NOT NULL,
  `ITEM60` float NOT NULL,
  `ITEM61` float NOT NULL,
  `ITEM62` float NOT NULL,
  `ITEM63` float NOT NULL,
  `ITEM64` float NOT NULL,
  `ITEM65` float NOT NULL,
  `ITEM66` float NOT NULL,
  `ITEM67` float NOT NULL,
  `ITEM68` float NOT NULL,
  `ITEM69` float NOT NULL,
  `ITEM7` float NOT NULL,
  `ITEM70` float NOT NULL,
  `ITEM71` float NOT NULL,
  `ITEM72` float NOT NULL,
  `ITEM73` float NOT NULL,
  `ITEM74` float NOT NULL,
  `ITEM75` float NOT NULL,
  `ITEM76` float NOT NULL,
  `ITEM77` float NOT NULL,
  `ITEM78` float NOT NULL,
  `ITEM79` float NOT NULL,
  `ITEM8` float NOT NULL,
  `ITEM80` float NOT NULL,
  `ITEM81` float NOT NULL,
  `ITEM82` float NOT NULL,
  `ITEM83` float NOT NULL,
  `ITEM84` float NOT NULL,
  `ITEM85` float NOT NULL,
  `ITEM86` float NOT NULL,
  `ITEM87` float NOT NULL,
  `ITEM88` float NOT NULL,
  `ITEM89` float NOT NULL,
  `ITEM9` float NOT NULL,
  `ITEM90` float NOT NULL,
  `ITEM91` float NOT NULL,
  `ITEM92` float NOT NULL,
  `ITEM93` float NOT NULL,
  `ITEM94` float NOT NULL,
  `ITEM95` float NOT NULL,
  `ITEM96` float NOT NULL,
  `ITEM97` float NOT NULL,
  `ITEM98` float NOT NULL,
  `ITEM99` float NOT NULL,
  `ORGTIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wwdcsdata
-- ----------------------------
INSERT INTO `wwdcsdata` VALUES ('1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2011-11-11 16:08:56');
INSERT INTO `wwdcsdata` VALUES ('2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '8', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '6', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '5', '0', '0', '0', '5', '0', '0', '0', '5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2011-11-12 21:17:46');
INSERT INTO `wwdcsdata` VALUES ('3', '0', '0', '0', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2', '2', '0', '0', '2', '2', '0', '0', '2', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2011-11-14 16:12:09');
