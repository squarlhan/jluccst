/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : wushuichang

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2011-12-13 16:47:37
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
  `name` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `count` int(10) DEFAULT '0',
  `priror` int(10) DEFAULT '0',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;

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
INSERT INTO `backward` VALUES ('130', '', '', '0', '0');
INSERT INTO `backward` VALUES ('131', '', '', '0', '0');
INSERT INTO `backward` VALUES ('132', '', '', '0', '0');
INSERT INTO `backward` VALUES ('133', '', '', '0', '0');
INSERT INTO `backward` VALUES ('134', '', '', '0', '0');
INSERT INTO `backward` VALUES ('135', '', '', '0', '0');
INSERT INTO `backward` VALUES ('136', '', '', '0', '0');
INSERT INTO `backward` VALUES ('142', '电石厂有机水', '溶解氧过高', '0', '0');
INSERT INTO `backward` VALUES ('143', '排江出口线', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('144', '生化池系列4(8号生化池)', '溶解氧过高', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=357 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandreason
-- ----------------------------
INSERT INTO `backwardandreason` VALUES ('324', '127', '中和站', '0', '控制不好', '增加测试PH频次，向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('325', '128', '中和站', '0', '控制不好', '增加测试PH频次，向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('326', '129', '液位', '0', '不合适', '调整液位');
INSERT INTO `backwardandreason` VALUES ('327', '130', '好氧生物', '0', '不足', '增加污泥池污泥量');
INSERT INTO `backwardandreason` VALUES ('328', '131', '厌氧生物', '0', '多', '减少污泥量');
INSERT INTO `backwardandreason` VALUES ('329', '132', '进水池', '0', '控制不好', '维修');
INSERT INTO `backwardandreason` VALUES ('330', '133', 'XX池', '0', '控制不好', '维修');
INSERT INTO `backwardandreason` VALUES ('331', '134', '中和池', '0', '处理不好', '维修');
INSERT INTO `backwardandreason` VALUES ('332', '135', '中和池', '0', '处理不好', '维修');
INSERT INTO `backwardandreason` VALUES ('333', '136', '你好', '0', '你好', '你好222');
INSERT INTO `backwardandreason` VALUES ('343', '136', '1', '0', '1', '1');
INSERT INTO `backwardandreason` VALUES ('344', '136', '2', '0', '2', '2');
INSERT INTO `backwardandreason` VALUES ('345', '136', '3', '0', '3', '4');
INSERT INTO `backwardandreason` VALUES ('347', '136', '5', '0', '5', '5');
INSERT INTO `backwardandreason` VALUES ('348', '136', '4', '0', '4', '4');
INSERT INTO `backwardandreason` VALUES ('349', '16', '1', '0', '1', '1');
INSERT INTO `backwardandreason` VALUES ('350', '16', '2', '0', '2', '2');
INSERT INTO `backwardandreason` VALUES ('351', '16', '3', '0', '3', '3');
INSERT INTO `backwardandreason` VALUES ('353', '142', '4', '0', '4', '4');
INSERT INTO `backwardandreason` VALUES ('354', '143', '电石渣', '0', '加的太多', '减少电石渣投放量');
INSERT INTO `backwardandreason` VALUES ('355', '143', '中和', '0', '错误', '立即上报');
INSERT INTO `backwardandreason` VALUES ('356', '144', 'op', '0', 'p', 'p');

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
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandresult
-- ----------------------------
INSERT INTO `backwardandresult` VALUES ('112', '127', '生化池系列2(3号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('113', '128', '生化池系列2(3号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('114', '129', '生化池系列2(3号生化池)水量', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('115', '130', '染料厂酸水溶解氧', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('116', '131', '染料厂酸水COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('117', '132', '生化池系列2(3号生化池)SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('118', '133', '电石厂有机水COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('119', '134', '生化池系列1(1号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('120', '135', '生化池系列1(2号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('121', '136', '排江出口线SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('127', '142', '电石厂有机水溶解氧', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('128', '143', '排江出口线NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('129', '144', '生化池系列4(8号生化池)溶解氧', '0', '过高', null);

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
  `isok` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdata
-- ----------------------------
INSERT INTO `dcsdata` VALUES ('86', '2系列生化池', '班次', '0', '\0');
INSERT INTO `dcsdata` VALUES ('87', '2系列生化池', '3号生化池COD', '0.2', '\0');
INSERT INTO `dcsdata` VALUES ('105', '1系列生化池', '班次', '0', '\0');
INSERT INTO `dcsdata` VALUES ('106', '1系列生化池', '1号生化池PH', '10', '\0');
INSERT INTO `dcsdata` VALUES ('107', '排江出口线', '班次', '0', '\0');
INSERT INTO `dcsdata` VALUES ('108', '排江出口线', '出口NH3-N', '3', '\0');

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
) ENGINE=InnoDB AUTO_INCREMENT=1404 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdscrib
-- ----------------------------
INSERT INTO `dcsdscrib` VALUES ('1083', '2系列生化池', '3号生化池PH', '6', '生化池系列2(3号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1084', '2系列生化池', '3号生化池COD', '0', '生化池系列2(3号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1332', '2系列生化池', '3号生化池碱度', '8', '生化池系列2(3号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1333', '2系列生化池', '3号生化池BOD5', '2', '生化池系列2(3号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1334', '2系列生化池', '3号生化池SS', '100', '生化池系列2(3号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1335', '2系列生化池', '3号生化池NH3-N', '0', '生化池系列2(3号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1336', '2系列生化池', '3号生化池硝态氮', '100', '生化池系列2(3号生化池)硝态氮', '500');
INSERT INTO `dcsdscrib` VALUES ('1337', '2系列生化池', '3号生化池溶解氧', '0', '生化池系列2(3号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1338', '2系列生化池', '3号生化池风量', '0', '生化池系列2(3号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1339', '2系列生化池', '3号生化池NO-N', '0', '生化池系列2(3号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1340', '2系列生化池', '3号生化池水量', '100', '生化池系列2(3号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1361', '2系列生化池', '4号生化池COD', '0', '生化池系列2(4号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1362', '2系列生化池', '4号生化池碱度', '8', '生化池系列2(4号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1363', '2系列生化池', '3号生化池BOD5', '2', '生化池系列2(4号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1364', '2系列生化池', '3号生化池SS', '100', '生化池系列2(4号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1365', '2系列生化池', '4号生化池NH3-N', '0', '生化池系列2(4号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1366', '2系列生化池', '4号生化池硝态氮', '0', '生化池系列2(4号生化池)硝态氮', '50');
INSERT INTO `dcsdscrib` VALUES ('1367', '2系列生化池', '4号生化池溶解氧', '0', '生化池系列2(4号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1368', '2系列生化池', '4号生化池风量', '0', '生化池系列2(4号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1369', '2系列生化池', '4号生化池NO-N', '0', '生化池系列2(4号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1370', '2系列生化池', '4号生化池水量', '100', '生化池系列2(4号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1371', '2系列生化池', '4号生化池PH', '6', '生化池系列2(4号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1372', '染料厂酸水', 'COD', '0', '染料厂酸水COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1373', '电石厂有机水', 'COD', '0', '电石厂有机水COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1374', '1系列生化池', '1号生化池PH', '6', '生化池系列1(1号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1375', '1系列生化池', '1号生化池COD', '0', '生化池系列1(1号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1376', '1系列生化池', '1号生化池COD', '0', '生化池系列1(1号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1378', '1系列生化池', '1号生化池COD', '0', '生化池系列1(1号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1379', '1系列生化池', '1号生化池碱度', '8', '生化池系列1(1号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1380', '1系列生化池', '1号生化池BOD5', '2', '生化池系列1(1号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1381', '1系列生化池', '1号生化池SS', '100', '生化池系列1(1号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1382', '1系列生化池', '1号生化池NH3-N', '0', '生化池系列1(1号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1383', '1系列生化池', '1号生化池硝态氮', '100', '生化池系列1(1号生化池)硝态氮', '500');
INSERT INTO `dcsdscrib` VALUES ('1384', '1系列生化池', '1号生化池溶解氧', '0', '生化池系列1(1号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1385', '1系列生化池', '1号生化池风量', '0', '生化池系列1(1号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1386', '1系列生化池', '1号生化池NO-N', '0', '生化池系列1(1号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1387', '1系列生化池', '1号生化池水量', '100', '生化池系列1(1号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1388', '1系列生化池', '2号生化池水量', '100', '生化池系列1(2号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1389', '1系列生化池', '2号生化池PH', '6', '生化池系列1(2号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1390', '1系列生化池', '2号生化池COD', '0', '生化池系列1(2号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1391', '1系列生化池', '2号生化池碱度', '8', '生化池系列1(2号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1392', '1系列生化池', '2号生化池BOD5', '2', '生化池系列1(2号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1393', '1系列生化池', '2号生化池SS', '100', '生化池系列1(2号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1394', '1系列生化池', '2号生化池NH3-N', '0', '生化池系列1(2号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1395', '1系列生化池', '2号生化池硝态氮', '100', '生化池系列1(2号生化池)硝态氮', '500');
INSERT INTO `dcsdscrib` VALUES ('1396', '1系列生化池', '2号生化池溶解氧', '0', '生化池系列1(2号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1397', '1系列生化池', '2号生化池风量', '0', '生化池系列1(2号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1398', '1系列生化池', '2号生化池NO-N', '0', '生化池系列1(2号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1399', '排江出口线', '出口SS', '0', '排江出口线SS', '10');
INSERT INTO `dcsdscrib` VALUES ('1400', '排江出口线', '出口COD', '70', '排江出口线COD', '120');
INSERT INTO `dcsdscrib` VALUES ('1402', '一系列生化池', '1号生化池PH', '6', '生化池系列1(1号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1403', '排江出口线', '出口NH3-N', '1', '排江出口线NH3-N', '2');

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
) ENGINE=MyISAM AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

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
INSERT INTO `dcshistory` VALUES ('56', '1系列生化池', '班次', '2011-11-27 19:15:30', '0');
INSERT INTO `dcshistory` VALUES ('57', '1系列生化池', '1号生化池PH', '2011-11-27 19:15:30', '12121212');
INSERT INTO `dcshistory` VALUES ('58', '2系列生化池', '班次', '2011-11-27 19:16:12', '0');
INSERT INTO `dcshistory` VALUES ('59', '2系列生化池', '3号生化池PH', '2011-11-27 19:16:12', '213234324');
INSERT INTO `dcshistory` VALUES ('60', '2系列生化池', '班次', '2011-11-27 19:16:33', '0');
INSERT INTO `dcshistory` VALUES ('61', '2系列生化池', '3号生化池PH', '2011-11-27 19:16:33', '1212121');
INSERT INTO `dcshistory` VALUES ('62', '1系列生化池', '班次', '2011-11-27 19:31:55', '0');
INSERT INTO `dcshistory` VALUES ('63', '2系列生化池', '班次', '2011-11-27 19:33:52', '0');
INSERT INTO `dcshistory` VALUES ('64', '2系列生化池', '3号生化池COD', '2011-11-27 19:33:52', '12121212');
INSERT INTO `dcshistory` VALUES ('65', '2系列生化池', '班次', '2011-11-27 19:36:21', '0');
INSERT INTO `dcshistory` VALUES ('66', '2系列生化池', '3号生化池PH', '2011-11-27 19:36:21', '32432');
INSERT INTO `dcshistory` VALUES ('67', '2系列生化池', '班次', '2011-11-27 19:45:44', '0');
INSERT INTO `dcshistory` VALUES ('68', '2系列生化池', '3号生化池PH', '2011-11-27 19:45:44', '1111');
INSERT INTO `dcshistory` VALUES ('69', '1系列生化池', '班次', '2011-11-27 19:46:32', '0');
INSERT INTO `dcshistory` VALUES ('70', '2系列生化池', '班次', '2011-11-27 19:54:38', '0');
INSERT INTO `dcshistory` VALUES ('71', '2系列生化池', '3号生化池SS', '2011-11-27 19:54:38', '13221342');
INSERT INTO `dcshistory` VALUES ('72', '1系列生化池', '班次', '2011-11-27 20:09:51', '0');
INSERT INTO `dcshistory` VALUES ('73', '2系列生化池', '班次', '2011-11-27 20:10:07', '0');
INSERT INTO `dcshistory` VALUES ('74', '2系列生化池', '3号生化池COD', '2011-11-27 20:10:07', '432423432');
INSERT INTO `dcshistory` VALUES ('75', '2系列生化池', '班次', '2011-11-27 20:12:47', '0');
INSERT INTO `dcshistory` VALUES ('76', '2系列生化池', '3号生化池碱度', '2011-11-27 20:12:47', '2311324');
INSERT INTO `dcshistory` VALUES ('77', '2系列生化池', '班次', '2011-11-27 20:14:15', '0');
INSERT INTO `dcshistory` VALUES ('78', '2系列生化池', '3号生化池COD', '2011-11-27 20:14:15', '243424');
INSERT INTO `dcshistory` VALUES ('79', '2系列生化池', '班次', '2011-11-27 20:16:08', '0');
INSERT INTO `dcshistory` VALUES ('80', '2系列生化池', '3号生化池COD', '2011-11-27 20:16:08', '243424');
INSERT INTO `dcshistory` VALUES ('81', '1系列生化池', '班次', '2011-11-27 23:52:35', '0');
INSERT INTO `dcshistory` VALUES ('82', '1系列生化池', '1号生化池PH', '2011-11-27 23:52:35', '11111');
INSERT INTO `dcshistory` VALUES ('83', '2系列生化池', '班次', '2011-11-27 23:53:32', '0');
INSERT INTO `dcshistory` VALUES ('84', '2系列生化池', '3号生化池COD', '2011-11-27 23:53:32', '0.2');
INSERT INTO `dcshistory` VALUES ('85', '1系列生化池', '班次', '2011-11-27 23:55:09', '0');
INSERT INTO `dcshistory` VALUES ('86', '1系列生化池', '1号生化池PH', '2011-11-27 23:55:09', '7');
INSERT INTO `dcshistory` VALUES ('87', '1系列生化池', '班次', '2011-11-28 10:55:17', '0');
INSERT INTO `dcshistory` VALUES ('88', '1系列生化池', '1号生化池SS', '2011-11-28 10:55:17', '1111');
INSERT INTO `dcshistory` VALUES ('89', '1系列生化池', '班次', '2011-11-28 10:56:32', '0');
INSERT INTO `dcshistory` VALUES ('90', '1系列生化池', '1号生化池SS', '2011-11-28 10:56:32', '1111');
INSERT INTO `dcshistory` VALUES ('91', '1系列生化池', '班次', '2011-11-28 10:57:15', '0');
INSERT INTO `dcshistory` VALUES ('92', '1系列生化池', '1号生化池SS', '2011-11-28 10:57:15', '1111');
INSERT INTO `dcshistory` VALUES ('93', '1系列生化池', '班次', '2011-11-28 10:57:37', '0');
INSERT INTO `dcshistory` VALUES ('94', '1系列生化池', '1号生化池SS', '2011-11-28 10:57:37', '1111');
INSERT INTO `dcshistory` VALUES ('95', '1系列生化池', '班次', '2011-11-28 11:29:27', '0');
INSERT INTO `dcshistory` VALUES ('96', '1系列生化池', '1号生化池PH', '2011-11-28 11:29:27', '121212');
INSERT INTO `dcshistory` VALUES ('97', '1系列生化池', '班次', '2011-11-28 11:33:26', '0');
INSERT INTO `dcshistory` VALUES ('98', '1系列生化池', '1号生化池PH', '2011-11-28 11:33:26', '11111');
INSERT INTO `dcshistory` VALUES ('99', '1系列生化池', '班次', '2011-11-28 11:34:51', '0');
INSERT INTO `dcshistory` VALUES ('100', '1系列生化池', '2号生化池PH', '2011-11-28 11:34:51', '11111');
INSERT INTO `dcshistory` VALUES ('101', '1系列生化池', '班次', '2011-11-28 13:41:55', '0');
INSERT INTO `dcshistory` VALUES ('102', '1系列生化池', '班次', '2011-11-28 22:17:11', '0');
INSERT INTO `dcshistory` VALUES ('103', '1系列生化池', '1号生化池PH', '2011-11-28 22:17:11', '10');
INSERT INTO `dcshistory` VALUES ('104', '排江出口线', '班次', '2011-12-11 15:53:22', '0');
INSERT INTO `dcshistory` VALUES ('105', '排江出口线', '出口NH3-N', '2011-12-11 15:53:22', '3');

-- ----------------------------
-- Table structure for `dss_advice`
-- ----------------------------
DROP TABLE IF EXISTS `dss_advice`;
CREATE TABLE `dss_advice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) DEFAULT '9999',
  `value` varchar(20) DEFAULT NULL,
  `sugg` varchar(1000) DEFAULT NULL,
  `simu_time` varchar(20) DEFAULT NULL,
  `seqno` varchar(20) DEFAULT NULL,
  `error` varchar(200) DEFAULT NULL,
  `level` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75158BF323A4A4F1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=866 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_advice
-- ----------------------------
INSERT INTO `dss_advice` VALUES ('864', 'w85.AIRA802', '38.52968', '排江出口线SS过高 : 你好222;1;2;4;5;4;', '          910.647778', '20080102125013', '你好你好;11;22;33;55;44;', '2');
INSERT INTO `dss_advice` VALUES ('865', 'w85.AIRA804', '3.5872424', '排江出口线NH3-N过高 : 减少电石渣投放量;立即上报;', '          910.647778', '20080102125013', '电石渣加的太多;中和错误;', '3');

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
  PRIMARY KEY (`id`),
  KEY `FKA84AB4F923A4A4F1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=799 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_history
-- ----------------------------
INSERT INTO `dss_history` VALUES ('1', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('2', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('3', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('4', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('5', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('6', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('7', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('8', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('9', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('10', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('11', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('12', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('13', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('14', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('15', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('16', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('17', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('18', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('19', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('20', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('21', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('22', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('23', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('24', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('25', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('26', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('27', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('28', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('29', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('30', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('31', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('32', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('33', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('34', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('35', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('36', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('37', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('38', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('39', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('40', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('41', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('42', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('43', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('44', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('45', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('46', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('47', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('48', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('49', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('50', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('51', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('52', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('53', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('54', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('55', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('56', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('57', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('58', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('59', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('60', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('61', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('62', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('63', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('64', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('65', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('66', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('67', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('68', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('69', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('70', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('71', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('72', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('73', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('74', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('75', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('76', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('77', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('78', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('79', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('80', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('81', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('82', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('83', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('84', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('85', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('86', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('87', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('88', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('89', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('90', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('91', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('92', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('93', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('94', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('95', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('96', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('97', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('98', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('99', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('100', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('101', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('102', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('103', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('104', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('105', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('106', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('107', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('108', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('109', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('110', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('111', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('112', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('113', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('114', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('115', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('116', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('117', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('118', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('119', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('120', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('121', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('122', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('123', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('124', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('125', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('126', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('127', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('128', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('129', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('130', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('131', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('132', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('133', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('134', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('135', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('136', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('137', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('138', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('139', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('140', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('141', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('142', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('143', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('144', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('145', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('146', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('147', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('148', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('149', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('150', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('151', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('152', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('153', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('154', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('155', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('156', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('157', '生化池低;', '过高', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('158', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('159', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('160', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('161', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('162', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('163', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('164', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('165', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('166', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('167', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('168', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('169', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('170', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('171', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('172', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('173', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('174', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('175', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('176', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('177', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('178', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('179', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('180', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('181', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('182', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('183', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('184', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('185', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('186', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('187', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('188', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('189', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('190', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('191', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('192', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('193', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('194', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('195', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('196', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('197', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('198', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('199', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('200', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('201', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('202', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('203', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('204', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('205', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('206', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('207', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('208', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('209', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('210', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('211', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('212', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('213', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('214', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('215', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('216', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('217', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('218', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('219', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('220', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('221', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('222', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('223', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('224', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('225', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('226', '二沉池水停留时间短;中和处理不完全;', '2', '20111124', '1111.24', '增加二沉池污水停留时间;加强预处理;', '12', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('227', '生化池低;', '4', '20111125', '1111.24', '加大风力;', '200', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('228', null, '0', '20080102125013', '          910.647778', null, '0.000039344006', 'w77.AIR202');
INSERT INTO `dss_history` VALUES ('229', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('230', null, '0', '20080102125013', '          910.647778', null, '0.000039298677', 'w78.AIR204');
INSERT INTO `dss_history` VALUES ('231', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('232', null, '0', '20080102125013', '          910.647778', null, '7', 'w75.AIR229');
INSERT INTO `dss_history` VALUES ('233', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('234', null, '0', '20080102125013', '          910.647778', null, '7', 'w77.AIR233');
INSERT INTO `dss_history` VALUES ('235', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('236', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR235');
INSERT INTO `dss_history` VALUES ('237', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('238', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR236');
INSERT INTO `dss_history` VALUES ('239', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('240', null, '4', '20080102125013', '          910.647778', null, '568.9976', 'w62.AIRA101');
INSERT INTO `dss_history` VALUES ('241', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('242', null, '3', '20080102125013', '          910.647778', null, '11.966514', 'w62.AIRA102');
INSERT INTO `dss_history` VALUES ('243', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('244', null, '4', '20080102125013', '          910.647778', null, '428.31717', 'w74.AIRA103');
INSERT INTO `dss_history` VALUES ('245', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('246', null, '3', '20080102125013', '          910.647778', null, '19.333183', 'w74.AIRA104');
INSERT INTO `dss_history` VALUES ('247', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('248', null, '0', '20080102125013', '          910.647778', null, '7', 'w74.AIRA106');
INSERT INTO `dss_history` VALUES ('249', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('250', null, '0', '20080102125013', '          910.647778', null, '7', 'w62.AIRA107');
INSERT INTO `dss_history` VALUES ('251', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('252', null, '0', '20080102125013', '          910.647778', null, '7', 'w85.AIRA801');
INSERT INTO `dss_history` VALUES ('253', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('254', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('255', '', '4', '20080102125013', '          910.647778', '', '73.48623', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('256', null, '3', '20080102125013', '          910.647778', null, '3.5872424', 'w85.AIRA804');
INSERT INTO `dss_history` VALUES ('257', null, '0', '20080102125013', '          910.647778', null, '2.9837673', 'w76.AIRC212');
INSERT INTO `dss_history` VALUES ('258', null, '0', '20080102125013', '          910.647778', null, '3.0058374', 'w75.AIRC213');
INSERT INTO `dss_history` VALUES ('259', null, '0', '20080102125013', '          910.647778', null, '2.9999352', 'w75.AIRC214');
INSERT INTO `dss_history` VALUES ('260', null, '0', '20080102125013', '          910.647778', null, '2.9998307', 'w76.AIRC216');
INSERT INTO `dss_history` VALUES ('261', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC217');
INSERT INTO `dss_history` VALUES ('262', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC218');
INSERT INTO `dss_history` VALUES ('263', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC219');
INSERT INTO `dss_history` VALUES ('264', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC220');
INSERT INTO `dss_history` VALUES ('265', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC221');
INSERT INTO `dss_history` VALUES ('266', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC222');
INSERT INTO `dss_history` VALUES ('267', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC223');
INSERT INTO `dss_history` VALUES ('268', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC224');
INSERT INTO `dss_history` VALUES ('269', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC225');
INSERT INTO `dss_history` VALUES ('270', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC226');
INSERT INTO `dss_history` VALUES ('271', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC227');
INSERT INTO `dss_history` VALUES ('272', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC228');
INSERT INTO `dss_history` VALUES ('273', null, '0', '20080102125013', '          910.647778', null, '0.000039344006', 'w77.AIR202');
INSERT INTO `dss_history` VALUES ('274', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('275', null, '0', '20080102125013', '          910.647778', null, '0.000039298677', 'w78.AIR204');
INSERT INTO `dss_history` VALUES ('276', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('277', null, '0', '20080102125013', '          910.647778', null, '7', 'w75.AIR229');
INSERT INTO `dss_history` VALUES ('278', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('279', null, '0', '20080102125013', '          910.647778', null, '7', 'w77.AIR233');
INSERT INTO `dss_history` VALUES ('280', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('281', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR235');
INSERT INTO `dss_history` VALUES ('282', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('283', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR236');
INSERT INTO `dss_history` VALUES ('284', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('285', null, '4', '20080102125013', '          910.647778', null, '568.9976', 'w62.AIRA101');
INSERT INTO `dss_history` VALUES ('286', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('287', null, '3', '20080102125013', '          910.647778', null, '11.966514', 'w62.AIRA102');
INSERT INTO `dss_history` VALUES ('288', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('289', null, '4', '20080102125013', '          910.647778', null, '428.31717', 'w74.AIRA103');
INSERT INTO `dss_history` VALUES ('290', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('291', null, '3', '20080102125013', '          910.647778', null, '19.333183', 'w74.AIRA104');
INSERT INTO `dss_history` VALUES ('292', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('293', null, '0', '20080102125013', '          910.647778', null, '7', 'w74.AIRA106');
INSERT INTO `dss_history` VALUES ('294', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('295', null, '0', '20080102125013', '          910.647778', null, '7', 'w62.AIRA107');
INSERT INTO `dss_history` VALUES ('296', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('297', null, '0', '20080102125013', '          910.647778', null, '7', 'w85.AIRA801');
INSERT INTO `dss_history` VALUES ('298', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('299', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('300', '', '4', '20080102125013', '          910.647778', '', '73.48623', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('301', null, '3', '20080102125013', '          910.647778', null, '3.5872424', 'w85.AIRA804');
INSERT INTO `dss_history` VALUES ('302', null, '0', '20080102125013', '          910.647778', null, '2.9837673', 'w76.AIRC212');
INSERT INTO `dss_history` VALUES ('303', null, '0', '20080102125013', '          910.647778', null, '3.0058374', 'w75.AIRC213');
INSERT INTO `dss_history` VALUES ('304', null, '0', '20080102125013', '          910.647778', null, '2.9999352', 'w75.AIRC214');
INSERT INTO `dss_history` VALUES ('305', null, '0', '20080102125013', '          910.647778', null, '2.9998307', 'w76.AIRC216');
INSERT INTO `dss_history` VALUES ('306', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC217');
INSERT INTO `dss_history` VALUES ('307', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC218');
INSERT INTO `dss_history` VALUES ('308', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC219');
INSERT INTO `dss_history` VALUES ('309', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC220');
INSERT INTO `dss_history` VALUES ('310', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC221');
INSERT INTO `dss_history` VALUES ('311', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC222');
INSERT INTO `dss_history` VALUES ('312', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC223');
INSERT INTO `dss_history` VALUES ('313', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC224');
INSERT INTO `dss_history` VALUES ('314', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC225');
INSERT INTO `dss_history` VALUES ('315', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC226');
INSERT INTO `dss_history` VALUES ('316', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC227');
INSERT INTO `dss_history` VALUES ('317', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC228');
INSERT INTO `dss_history` VALUES ('318', null, '0', '20080102125013', '          910.647778', null, '0.000039344006', 'w77.AIR202');
INSERT INTO `dss_history` VALUES ('319', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('320', null, '0', '20080102125013', '          910.647778', null, '0.000039298677', 'w78.AIR204');
INSERT INTO `dss_history` VALUES ('321', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('322', null, '0', '20080102125013', '          910.647778', null, '7', 'w75.AIR229');
INSERT INTO `dss_history` VALUES ('323', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('324', null, '0', '20080102125013', '          910.647778', null, '7', 'w77.AIR233');
INSERT INTO `dss_history` VALUES ('325', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('326', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR235');
INSERT INTO `dss_history` VALUES ('327', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('328', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR236');
INSERT INTO `dss_history` VALUES ('329', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('330', null, '4', '20080102125013', '          910.647778', null, '568.9976', 'w62.AIRA101');
INSERT INTO `dss_history` VALUES ('331', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('332', null, '3', '20080102125013', '          910.647778', null, '11.966514', 'w62.AIRA102');
INSERT INTO `dss_history` VALUES ('333', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('334', null, '4', '20080102125013', '          910.647778', null, '428.31717', 'w74.AIRA103');
INSERT INTO `dss_history` VALUES ('335', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('336', null, '3', '20080102125013', '          910.647778', null, '19.333183', 'w74.AIRA104');
INSERT INTO `dss_history` VALUES ('337', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('338', null, '0', '20080102125013', '          910.647778', null, '7', 'w74.AIRA106');
INSERT INTO `dss_history` VALUES ('339', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('340', null, '0', '20080102125013', '          910.647778', null, '7', 'w62.AIRA107');
INSERT INTO `dss_history` VALUES ('341', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('342', null, '0', '20080102125013', '          910.647778', null, '7', 'w85.AIRA801');
INSERT INTO `dss_history` VALUES ('343', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('344', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('345', '', '4', '20080102125013', '          910.647778', '', '73.48623', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('346', null, '3', '20080102125013', '          910.647778', null, '3.5872424', 'w85.AIRA804');
INSERT INTO `dss_history` VALUES ('347', null, '0', '20080102125013', '          910.647778', null, '2.9837673', 'w76.AIRC212');
INSERT INTO `dss_history` VALUES ('348', null, '0', '20080102125013', '          910.647778', null, '3.0058374', 'w75.AIRC213');
INSERT INTO `dss_history` VALUES ('349', null, '0', '20080102125013', '          910.647778', null, '2.9999352', 'w75.AIRC214');
INSERT INTO `dss_history` VALUES ('350', null, '0', '20080102125013', '          910.647778', null, '2.9998307', 'w76.AIRC216');
INSERT INTO `dss_history` VALUES ('351', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC217');
INSERT INTO `dss_history` VALUES ('352', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC218');
INSERT INTO `dss_history` VALUES ('353', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC219');
INSERT INTO `dss_history` VALUES ('354', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC220');
INSERT INTO `dss_history` VALUES ('355', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC221');
INSERT INTO `dss_history` VALUES ('356', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC222');
INSERT INTO `dss_history` VALUES ('357', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC223');
INSERT INTO `dss_history` VALUES ('358', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC224');
INSERT INTO `dss_history` VALUES ('359', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC225');
INSERT INTO `dss_history` VALUES ('360', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC226');
INSERT INTO `dss_history` VALUES ('361', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC227');
INSERT INTO `dss_history` VALUES ('362', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC228');
INSERT INTO `dss_history` VALUES ('363', null, '0', '20080102125013', '          910.647778', null, '0.000039344006', 'w77.AIR202');
INSERT INTO `dss_history` VALUES ('364', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('365', null, '0', '20080102125013', '          910.647778', null, '0.000039298677', 'w78.AIR204');
INSERT INTO `dss_history` VALUES ('366', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('367', null, '0', '20080102125013', '          910.647778', null, '7', 'w75.AIR229');
INSERT INTO `dss_history` VALUES ('368', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('369', null, '0', '20080102125013', '          910.647778', null, '7', 'w77.AIR233');
INSERT INTO `dss_history` VALUES ('370', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('371', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR235');
INSERT INTO `dss_history` VALUES ('372', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('373', null, '0', '20080102125013', '          910.647778', null, '7', 'w78.AIR236');
INSERT INTO `dss_history` VALUES ('374', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('375', null, '4', '20080102125013', '          910.647778', null, '568.9976', 'w62.AIRA101');
INSERT INTO `dss_history` VALUES ('376', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('377', null, '3', '20080102125013', '          910.647778', null, '11.966514', 'w62.AIRA102');
INSERT INTO `dss_history` VALUES ('378', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('379', null, '4', '20080102125013', '          910.647778', null, '428.31717', 'w74.AIRA103');
INSERT INTO `dss_history` VALUES ('380', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('381', null, '3', '20080102125013', '          910.647778', null, '19.333183', 'w74.AIRA104');
INSERT INTO `dss_history` VALUES ('382', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('383', null, '0', '20080102125013', '          910.647778', null, '7', 'w74.AIRA106');
INSERT INTO `dss_history` VALUES ('384', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('385', null, '0', '20080102125013', '          910.647778', null, '7', 'w62.AIRA107');
INSERT INTO `dss_history` VALUES ('386', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('387', null, '0', '20080102125013', '          910.647778', null, '7', 'w85.AIRA801');
INSERT INTO `dss_history` VALUES ('388', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('389', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('390', '', '4', '20080102125013', '          910.647778', '', '73.48623', 'w85.AIRA803');
INSERT INTO `dss_history` VALUES ('391', null, '3', '20080102125013', '          910.647778', null, '3.5872424', 'w85.AIRA804');
INSERT INTO `dss_history` VALUES ('392', null, '0', '20080102125013', '          910.647778', null, '2.9837673', 'w76.AIRC212');
INSERT INTO `dss_history` VALUES ('393', null, '0', '20080102125013', '          910.647778', null, '3.0058374', 'w75.AIRC213');
INSERT INTO `dss_history` VALUES ('394', null, '0', '20080102125013', '          910.647778', null, '2.9999352', 'w75.AIRC214');
INSERT INTO `dss_history` VALUES ('395', null, '0', '20080102125013', '          910.647778', null, '2.9998307', 'w76.AIRC216');
INSERT INTO `dss_history` VALUES ('396', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC217');
INSERT INTO `dss_history` VALUES ('397', null, '0', '20080102125013', '          910.647778', null, '2.8586338', 'w77.AIRC218');
INSERT INTO `dss_history` VALUES ('398', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC219');
INSERT INTO `dss_history` VALUES ('399', null, '0', '20080102125013', '          910.647778', null, '2.860854', 'w78.AIRC220');
INSERT INTO `dss_history` VALUES ('400', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC221');
INSERT INTO `dss_history` VALUES ('401', null, '0', '20080102125013', '          910.647778', null, '2.9922142', 'w77.AIRC222');
INSERT INTO `dss_history` VALUES ('402', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC223');
INSERT INTO `dss_history` VALUES ('403', null, '0', '20080102125013', '          910.647778', null, '2.9841905', 'w78.AIRC224');
INSERT INTO `dss_history` VALUES ('404', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC225');
INSERT INTO `dss_history` VALUES ('405', null, '0', '20080102125013', '          910.647778', null, '2.9967136', 'w77.AIRC226');
INSERT INTO `dss_history` VALUES ('406', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC227');
INSERT INTO `dss_history` VALUES ('407', null, '0', '20080102125013', '          910.647778', null, '2.985795', 'w78.AIRC228');
INSERT INTO `dss_history` VALUES ('408', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('409', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('410', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('411', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('412', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('413', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('414', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('415', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('416', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('417', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('418', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('419', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('420', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('421', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('422', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('423', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('424', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('425', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('426', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('427', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('428', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('429', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('430', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('431', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('432', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('433', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('434', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('435', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('436', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('437', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('438', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('439', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('440', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('441', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('442', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('443', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('444', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('445', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('446', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('447', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('448', null, null, null, null, '一切正常', null, null);
INSERT INTO `dss_history` VALUES ('449', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('450', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('451', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('452', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('453', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('454', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('455', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('456', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('457', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('458', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('459', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('460', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('461', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('462', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('463', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('464', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('465', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('466', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('467', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('468', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('469', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('470', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('471', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('472', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('473', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('474', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('475', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('476', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('477', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('478', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('479', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('480', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('481', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('482', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('483', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('484', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('485', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('486', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('487', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('488', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('489', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('490', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('491', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('492', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('493', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('494', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('495', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('496', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('497', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('498', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('499', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('500', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('501', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('502', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('503', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('504', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('505', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('506', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('507', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('508', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('509', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('510', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('511', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('512', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('513', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('514', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('515', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('516', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('517', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('518', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('519', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('520', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('521', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('522', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('523', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('524', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('525', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('526', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('527', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('528', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('529', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('530', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('531', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('532', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('533', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('534', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('535', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('536', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('537', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('538', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('539', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('540', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('541', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('542', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('543', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('544', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('545', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('546', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('547', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('548', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('549', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('550', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('551', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('552', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('553', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('554', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('555', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('556', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('557', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('558', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('559', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('560', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('561', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('562', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('563', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('564', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('565', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('566', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('567', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('568', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('569', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('570', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('571', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('572', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('573', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('574', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('575', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('576', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('577', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('578', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('579', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('580', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('581', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('582', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('583', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('584', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('585', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('586', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('587', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('588', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('589', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('590', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('591', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('592', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('593', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('594', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('595', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('596', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('597', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('598', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('599', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('600', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('601', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('602', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('603', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('604', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('605', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('606', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('607', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('608', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('609', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('610', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('611', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('612', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('613', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('614', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('615', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('616', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('617', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('618', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('619', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('620', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('621', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('622', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('623', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('624', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('625', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('626', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('627', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('628', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('629', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('630', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('631', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('632', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('633', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('634', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('635', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('636', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('637', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('638', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('639', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('640', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('641', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('642', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('643', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('644', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('645', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('646', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('647', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('648', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('649', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('650', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('651', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('652', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('653', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('654', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('655', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('656', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('657', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('658', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('659', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('660', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('661', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('662', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('663', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('664', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('665', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('666', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('667', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('668', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('669', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('670', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('671', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('672', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('673', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('674', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('675', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('676', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('677', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('678', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('679', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('680', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('681', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('682', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('683', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('684', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('685', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('686', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('687', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('688', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('689', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('690', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('691', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('692', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('693', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('694', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('695', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('696', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('697', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('698', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('699', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('700', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('701', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('702', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('703', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('704', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('705', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('706', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('707', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('708', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('709', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('710', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('711', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('712', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('713', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('714', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('715', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('716', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('717', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('718', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('719', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('720', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('721', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('722', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('723', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('724', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('725', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('726', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('727', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('728', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('729', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('730', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('731', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('732', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('733', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('734', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('735', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('736', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('737', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('738', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('739', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('740', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('741', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('742', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('743', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('744', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('745', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('746', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('747', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('748', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('749', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('750', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('751', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('752', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('753', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('754', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('755', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('756', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('757', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('758', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('759', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('760', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('761', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('762', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('763', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('764', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('765', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('766', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('767', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('768', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('769', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('770', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('771', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('772', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('773', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('774', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('775', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('776', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('777', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('778', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('779', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('780', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('781', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('782', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('783', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('784', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('785', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('786', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('787', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('788', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('789', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('790', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('791', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('792', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('793', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('794', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('795', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('796', '二沉池水停留时间短;中和处理不完全;', '2', '20080102125013', '          910.647778', '增加二沉池污水停留时间;加强预处理;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('797', '你好你好;11;22;33;55;44;', '2', '20080102125013', '          910.647778', '你好222;1;2;4;5;4;', '38.52968', 'w85.AIRA802');
INSERT INTO `dss_history` VALUES ('798', '电石渣加的太多;中和错误;', '3', '20080102125013', '          910.647778', '减少电石渣投放量;立即上报;', '3.5872424', 'w85.AIRA804');

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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of errorlog
-- ----------------------------
INSERT INTO `errorlog` VALUES ('20', '2系列生化池', '3号生化池PH', '过低', '2011-11-27 15:04:02', '2', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('21', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 15:06:13', '111', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('22', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 15:10:07', '22', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('23', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 19:16:12', '213234324', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('24', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 19:16:33', '1212121', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('26', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 19:36:21', '32432', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('27', '2系列生化池', '3号生化池PH', '过高', '2011-11-27 19:45:44', '1111', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;');
INSERT INTO `errorlog` VALUES ('28', '2系列生化池', '3号生化池SS', '过高', '2011-11-27 19:54:38', '13221342', '进水池控制不好;', '维修;');
INSERT INTO `errorlog` VALUES ('39', '1系列生化池', '1号生化池PH', '过高', '2011-11-28 11:33:26', '11111', '中和池处理不好;', '维修;');
INSERT INTO `errorlog` VALUES ('40', '1系列生化池', '2号生化池PH', '过高', '2011-11-28 11:34:51', '11111', '中和池处理不好;', '维修;');
INSERT INTO `errorlog` VALUES ('41', '1系列生化池', '1号生化池PH', '过高', '2011-11-28 22:17:11', '10', '中和池处理不好;酸水的流量增大;酸水的酸度增加;碱液管堵塞;仪表指示不准;', '维修;增加碱液投加量;增加碱液投加量;及时清通，必要时短管清通;用PH试纸实测;');
INSERT INTO `errorlog` VALUES ('42', '排江出口线', '出口NH3-N', '过高', '2011-12-11 15:53:22', '3', '11;22;33;电石渣加的太多;中和错误;', '1;2;3;减少电石渣投放量;立即上报;');

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
-- Table structure for `initdata`
-- ----------------------------
DROP TABLE IF EXISTS `initdata`;
CREATE TABLE `initdata` (
  `id` varchar(36) NOT NULL,
  `name` varchar(36) DEFAULT NULL,
  `value` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of initdata
-- ----------------------------
INSERT INTO `initdata` VALUES ('FINAL.COD', '出口水质.COD', '71');
INSERT INTO `initdata` VALUES ('FINAL.NH3-N', '出口水质.NH3-N', '0');
INSERT INTO `initdata` VALUES ('FINAL.PH', '出口水质.PH', '6');
INSERT INTO `initdata` VALUES ('FINAL.SS', '出口水质.SS', '29');
INSERT INTO `initdata` VALUES ('w1.COD', '染料厂酸水.COD', '500.0');
INSERT INTO `initdata` VALUES ('w1.Q', '染料厂酸水.流量', '531.0');
INSERT INTO `initdata` VALUES ('w10.COD', '铁运489沉淀池出水.COD', '924.0');
INSERT INTO `initdata` VALUES ('w10.Q', '铁运489沉淀池出水.流量', '1.0');
INSERT INTO `initdata` VALUES ('w11.Q', '含氮废水.流量', '100.0');
INSERT INTO `initdata` VALUES ('w12.Q', '103厂碱水.流量', '0.0');
INSERT INTO `initdata` VALUES ('w13.COD', '化肥厂丁辛醇废水.COD', '2510.0');
INSERT INTO `initdata` VALUES ('w13.Q', '化肥厂丁辛醇废水.流量', '95.0');
INSERT INTO `initdata` VALUES ('w14.COD', '丙烯腈厂废水.COD', '212.0');
INSERT INTO `initdata` VALUES ('w14.Q', '丙烯腈厂废水.流量', '200.0');
INSERT INTO `initdata` VALUES ('w15.COD', '合成树脂厂废水.COD', '492.5');
INSERT INTO `initdata` VALUES ('w15.Q', '合成树脂厂废水.流量', '190.0');
INSERT INTO `initdata` VALUES ('w16.Q', '龙潭区生活污水.流量', '1342.0');
INSERT INTO `initdata` VALUES ('w2.COD', '电石厂酸水.COD', '1735.0');
INSERT INTO `initdata` VALUES ('w2.Q', '电石厂酸水.流量', '206.0');
INSERT INTO `initdata` VALUES ('w3.COD', '电石厂有机水.COD', '1595.0');
INSERT INTO `initdata` VALUES ('w3.Q', '电石厂有机水.流量', '155.0');
INSERT INTO `initdata` VALUES ('w4.COD', '有机合成厂有机废水.COD', '366.0');
INSERT INTO `initdata` VALUES ('w4.Q', '有机合成厂有机废水.流量', '646.0');
INSERT INTO `initdata` VALUES ('w5.COD', '炼油厂有机废水.COD', '260.5');
INSERT INTO `initdata` VALUES ('w5.Q', '炼油厂有机废水.流量', '1010.0');
INSERT INTO `initdata` VALUES ('w6.COD', '精细化学品厂废水.COD', '622.5');
INSERT INTO `initdata` VALUES ('w6.Q', '精细化学品厂废水.流量', '71.0');
INSERT INTO `initdata` VALUES ('w7.COD', '乙二醇废水.COD', '532');
INSERT INTO `initdata` VALUES ('w7.Q', '乙二醇废水.流量', '40.0');
INSERT INTO `initdata` VALUES ('w8.COD', '环氧乙烷废水.COD', '195');
INSERT INTO `initdata` VALUES ('w8.Q', '环氧乙烷废水.流量', '50.0');
INSERT INTO `initdata` VALUES ('w9.COD', '农药厂废水.COD', '0.0');
INSERT INTO `initdata` VALUES ('w9.Q', '农药厂废水.流量', '0.0');
INSERT INTO `initdata` VALUES ('ws.COD', '2系列生化池.3号生化池COD', '22');
INSERT INTO `initdata` VALUES ('WW14A.COD', '14#A.COD', '582');
INSERT INTO `initdata` VALUES ('WW14A.NH3-N', '14#A.NH3-N', '10');
INSERT INTO `initdata` VALUES ('WW14A.PH', '14#A.PH', '7');
INSERT INTO `initdata` VALUES ('WW14A.Q', '14#A.流量', '3795.0');
INSERT INTO `initdata` VALUES ('WW14A.SS', '14#A.SS', '179');
INSERT INTO `initdata` VALUES ('WW14B.COD', '14#B.COD', '257');
INSERT INTO `initdata` VALUES ('WW14B.NH3-N', '14#B.NH3-N', '33');
INSERT INTO `initdata` VALUES ('WW14B.PH', '14#B.PH', '7');
INSERT INTO `initdata` VALUES ('WW14B.Q', '14#B.流量', '1442.0');
INSERT INTO `initdata` VALUES ('WW14B.SS', '14#B.SS', '175');

-- ----------------------------
-- Table structure for `init_predict`
-- ----------------------------
DROP TABLE IF EXISTS `init_predict`;
CREATE TABLE `init_predict` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `name` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of init_predict
-- ----------------------------
INSERT INTO `init_predict` VALUES ('9999', '正常');
INSERT INTO `init_predict` VALUES ('w3.COD', '电石厂有机水.COD');
INSERT INTO `init_predict` VALUES ('w61.TIR203', '2系列生化池.3号生化池温度');
INSERT INTO `init_predict` VALUES ('w62.AIRA101', '进水提升泵房(462A).462A进水提升泵房COD');
INSERT INTO `init_predict` VALUES ('w62.AIRA102', '进水提升泵房(462A).462A进水提升泵房NH3-N');
INSERT INTO `init_predict` VALUES ('w62.AIRA107', '进水提升泵房(462A).462A.进水提升泵房PH');
INSERT INTO `init_predict` VALUES ('w62.AIRA108', '进水提升泵房(462A).462A进水提升泵房SS');
INSERT INTO `init_predict` VALUES ('w62.LDISA102', '进水提升泵房(462A).2#粗格栅前后液位差');
INSERT INTO `init_predict` VALUES ('w62.LDISA103', '进水提升泵房(462A).3#粗格栅前后液位差');
INSERT INTO `init_predict` VALUES ('w62.LDISA104', '进水提升泵房(462A).泵室液位');
INSERT INTO `init_predict` VALUES ('w62.LISA104', '进水提升泵房(462A).462A吸水池液位');
INSERT INTO `init_predict` VALUES ('w62.P1STATUS', '进水提升泵房(462A).1#潜水排污泵');
INSERT INTO `init_predict` VALUES ('w62.P2STATUS', '进水提升泵房(462A).2#潜水排污泵');
INSERT INTO `init_predict` VALUES ('w62.P3STATU', '进水提升泵房(462A).3#潜水排污泵');
INSERT INTO `init_predict` VALUES ('w62.P4STATUS', '进水提升泵房(462A).4#潜水排污泵');
INSERT INTO `init_predict` VALUES ('w62.P5STATUS', '进水提升泵房(462A).5#潜水排污泵');
INSERT INTO `init_predict` VALUES ('w6216.LDISA101', '进水提升泵房(462A).1#粗格栅前后液位差');
INSERT INTO `init_predict` VALUES ('w63.FRQ101', '巴氏计量槽（499）.水量');
INSERT INTO `init_predict` VALUES ('w63.LDISA106', '巴氏计量槽（499）.巴氏计量槽前液位');
INSERT INTO `init_predict` VALUES ('w63.LDISA107', '巴氏计量槽（499）.巴氏计量槽后液位');
INSERT INTO `init_predict` VALUES ('w65.M4881', '沉沙刮沙池(488).M488-1#刮沙机');
INSERT INTO `init_predict` VALUES ('w65.M4882', '沉沙刮沙池(488).M488-2#刮沙机');
INSERT INTO `init_predict` VALUES ('w65.M4883', '沉沙刮沙池(488).M488-3#刮沙机');
INSERT INTO `init_predict` VALUES ('w65.M4884', '沉沙刮沙池(488).M488-3#刮沙机');
INSERT INTO `init_predict` VALUES ('w66.M4891S', '初沉池(489B).M489-1#周边传动刮泥机');
INSERT INTO `init_predict` VALUES ('w66.M4892S', '初沉池(489B).M489-2#周边传动刮泥机');
INSERT INTO `init_predict` VALUES ('w66.M4893S', '初沉池(489B).M489-3#周边传动刮泥机');
INSERT INTO `init_predict` VALUES ('w67.LIA115', '事故池(489).事故池液位');
INSERT INTO `init_predict` VALUES ('w68.FRQ102', '14B生活水.水量');
INSERT INTO `init_predict` VALUES ('w69.LIA114', '老水解酸化池.老水解酸化池液位');
INSERT INTO `init_predict` VALUES ('w70.LIA115', '新水解酸化池.新水解酸化池液位');
INSERT INTO `init_predict` VALUES ('w71.FRQ103', '污泥池(V466).P466-1-2泵出口干管流量');
INSERT INTO `init_predict` VALUES ('w71.FRQ104', '污泥池(V466).P466-3-4泵出口干管流量');
INSERT INTO `init_predict` VALUES ('w71.LISA119', '污泥泵房(466).V466污泥池前液位');
INSERT INTO `init_predict` VALUES ('w73.FI106', '脱水装置(495).P495A-1流量');
INSERT INTO `init_predict` VALUES ('w73.FI107', '脱水装置(495).P495A-2流量');
INSERT INTO `init_predict` VALUES ('w73.FI108', '脱水装置(495).P495A-3流量');
INSERT INTO `init_predict` VALUES ('w73.FI109', '脱水装置(495).P495A-4流量');
INSERT INTO `init_predict` VALUES ('w73.FI110', '脱水装置(495).P495A-5流量');
INSERT INTO `init_predict` VALUES ('w73.FI111', '脱水装置(495).P495A-6流量');
INSERT INTO `init_predict` VALUES ('w73.LISA122', '脱水装置(495).V495A-5液位');
INSERT INTO `init_predict` VALUES ('w73.LISA123', '脱水装置(495).药剂池V495-3液位');
INSERT INTO `init_predict` VALUES ('w73.LISA124', '脱水装置(495).药剂池V495-4液位');
INSERT INTO `init_predict` VALUES ('w73.R4951', '脱水装置(495).1#带式压榨过滤机状态');
INSERT INTO `init_predict` VALUES ('w73.R4952', '脱水装置(495).2#带式压榨过滤机状态');
INSERT INTO `init_predict` VALUES ('w73.R4953', '脱水装置(495).3#带式压榨过滤机状态');
INSERT INTO `init_predict` VALUES ('w73.R4954', '脱水装置(495).4#带式压榨过滤机状态');
INSERT INTO `init_predict` VALUES ('w73.R4955', '脱水装置(495).5#带式压榨过滤机状态');
INSERT INTO `init_predict` VALUES ('w74.AIRA103', '中间提升泵房(462B).462B吸水池COD');
INSERT INTO `init_predict` VALUES ('w74.AIRA104', '中间提升泵房(462B).462B吸水池NH3-N');
INSERT INTO `init_predict` VALUES ('w74.AIRA105', '中间提升泵房(462B).462B吸水池SS');
INSERT INTO `init_predict` VALUES ('w74.AIRA106', '中间提升泵房(462B).462B吸水池PH');
INSERT INTO `init_predict` VALUES ('w74.AIRC207', '2系列生化池.3号生化池2段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w74.AIRC211', '2系列生化池.3号生化池3段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w74.AIRC215', '2系列生化池.3号生化池5段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w74.LIA116', '中间提升泵房(462B).462B泵房吸水池液位');
INSERT INTO `init_predict` VALUES ('w74.LIA117', '中间提升泵房(462B).V462B-3高位水池液位');
INSERT INTO `init_predict` VALUES ('w75.AIR229', '一系列生化池.1号生化池PH');
INSERT INTO `init_predict` VALUES ('w75.AIR230', '一系列生化池.2号生化池PH');
INSERT INTO `init_predict` VALUES ('w75.AIRC205', '一系列生化池.1号生化池2段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w75.AIRC206', '一系列生化池.2号生化池2段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w75.AIRC209', '一系列生化池.1号生化池3段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w75.AIRC210', '一系列生化池.2号生化池3段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w75.AIRC213', '一系列生化池.1号生化池5段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w75.AIRC214', '一系列生化池.2号生化池5段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w75.FR601A', '一系列生化池.1#鼓风机分量');
INSERT INTO `init_predict` VALUES ('w75.TIR201', '一系列生化池.1号生化池温度');
INSERT INTO `init_predict` VALUES ('w75.TIR202', '一系列生化池.2号生化池温度');
INSERT INTO `init_predict` VALUES ('w76.AIR231', '2系列生化池.3号生化池PH');
INSERT INTO `init_predict` VALUES ('w76.AIR232', '2系列生化池.4号生化池PH');
INSERT INTO `init_predict` VALUES ('w76.AIR234', '3系列生化池.6号生化池PH');
INSERT INTO `init_predict` VALUES ('w76.AIRC208', '2系列生化池.4号生化池2段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w76.AIRC212', '2系列生化池.4号生化池3段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w76.AIRC216', '2系列生化池.4号生化池5段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w76.FR601B', '2系列生化池.2#鼓风机分量');
INSERT INTO `init_predict` VALUES ('w76.TIR204', '2系列生化池.4号生化池温度');
INSERT INTO `init_predict` VALUES ('w77.AIR201', '3系列生化池.5号生化池A段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w77.AIR202', '3系列生化池.6号生化池A段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w77.AIR233', '3系列生化池.5号生化池PH');
INSERT INTO `init_predict` VALUES ('w77.AIRC217', '3系列生化池.5号生化池2段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w77.AIRC218', '3系列生化池.号生化池2段溶解氧DO6');
INSERT INTO `init_predict` VALUES ('w77.AIRC221', '3系列生化池.5号生化池4段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w77.AIRC222', '3系列生化池.6号生化池4段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w77.AIRC225', '3系列生化池.5号生化池6段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w77.AIRC226', '3系列生化池.6号生化池6段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w77.FR601C', '3系列生化池.3#鼓风机分量');
INSERT INTO `init_predict` VALUES ('w77.TIR205', '3系列生化池.5号生化池温度');
INSERT INTO `init_predict` VALUES ('w77.TIR206', '3系列生化池.6号生化池温度');
INSERT INTO `init_predict` VALUES ('w78.AIR203', '4系列生化池.7号生化池A段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.AIR204', '4系列生化池.8号生化池A段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.AIR235', '4系列生化池.7号生化池PH');
INSERT INTO `init_predict` VALUES ('w78.AIR236', '4系列生化池.8号生化池PH');
INSERT INTO `init_predict` VALUES ('w78.AIRC219', '4系列生化池.7号生化池2段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.AIRC220', '4系列生化池.8号生化池2段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.AIRC223', '4系列生化池.7号生化池4段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.AIRC224', '4系列生化池.8号生化池4段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.AIRC227', '4系列生化池.7号生化池6段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.AIRC228', '4系列生化池.8号生化池6段溶解氧DO');
INSERT INTO `init_predict` VALUES ('w78.FR601B', '4系列生化池.4#鼓风机分量');
INSERT INTO `init_predict` VALUES ('w78.TIR207', '4系列生化池.7号生化池温度');
INSERT INTO `init_predict` VALUES ('w78.TIR208', '4系列生化池.8号生化池温度');
INSERT INTO `init_predict` VALUES ('w85.AIRA801', '排江出口线.出口PH');
INSERT INTO `init_predict` VALUES ('w85.AIRA802', '排江出口线.出口SS');
INSERT INTO `init_predict` VALUES ('w85.AIRA803', '排江出口线.出口COD');
INSERT INTO `init_predict` VALUES ('w85.AIRA804', '排江出口线.出口NH3-N');
INSERT INTO `init_predict` VALUES ('w85.AIRA805', '排江出口线.出口DO');
INSERT INTO `init_predict` VALUES ('w86.FRCQ201', '1系列465回流泵房.1系列465-1回流泵房回流量');
INSERT INTO `init_predict` VALUES ('w86.FRCQ202', '1系列465回流泵房.2系列465-2回流泵房回流量');
INSERT INTO `init_predict` VALUES ('w86.FRCQ203', '1系列465回流泵房.1系列465回流泵房剩余量');
INSERT INTO `init_predict` VALUES ('w86.LISA201', '1系列465回流泵房.465吸泥池液位');
INSERT INTO `init_predict` VALUES ('w87.FRCQ204', '2系列465A回流泵房.2系列465A回流泵房回流量');
INSERT INTO `init_predict` VALUES ('w87.FRCQ205', '2系列465A回流泵房.2系列465A回流泵房剩余量');
INSERT INTO `init_predict` VALUES ('w87.LISA202', '2系列465A回流泵房.465A吸泥池液位');
INSERT INTO `init_predict` VALUES ('w88.FRCQ206', '3系列465B回流泵房.3系列465B回流泵房回流量');
INSERT INTO `init_predict` VALUES ('w88.FRCQ207', '3系列465B回流泵房.3系列465B回流泵房剩余量');
INSERT INTO `init_predict` VALUES ('w88.LISA204', '3系列465B回流泵房.465B吸泥池液位');

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FK5036F60823A4A4F1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=274000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_dss
-- ----------------------------
INSERT INTO `pre_dss` VALUES ('w77.AIR202', '3.9344006E-5', '          910.647778', '20080102125013', '273950');
INSERT INTO `pre_dss` VALUES ('w78.AIR204', '3.9298677E-5', '          910.647778', '20080102125013', '273952');
INSERT INTO `pre_dss` VALUES ('w75.AIR229', '7.0', '          910.647778', '20080102125013', '273957');
INSERT INTO `pre_dss` VALUES ('w77.AIR233', '7.0', '          910.647778', '20080102125013', '273961');
INSERT INTO `pre_dss` VALUES ('w78.AIR235', '7.0', '          910.647778', '20080102125013', '273963');
INSERT INTO `pre_dss` VALUES ('w78.AIR236', '7.0', '          910.647778', '20080102125013', '273964');
INSERT INTO `pre_dss` VALUES ('w62.AIRA101', '568.9976', '          910.647778', '20080102125013', '273965');
INSERT INTO `pre_dss` VALUES ('w62.AIRA102', '11.966514', '          910.647778', '20080102125013', '273966');
INSERT INTO `pre_dss` VALUES ('w74.AIRA103', '428.31717', '          910.647778', '20080102125013', '273967');
INSERT INTO `pre_dss` VALUES ('w74.AIRA104', '19.333183', '          910.647778', '20080102125013', '273968');
INSERT INTO `pre_dss` VALUES ('w74.AIRA106', '7.0', '          910.647778', '20080102125013', '273969');
INSERT INTO `pre_dss` VALUES ('w62.AIRA107', '7.0', '          910.647778', '20080102125013', '273970');
INSERT INTO `pre_dss` VALUES ('w85.AIRA801', '7.0', '          910.647778', '20080102125013', '273971');
INSERT INTO `pre_dss` VALUES ('w85.AIRA802', '38.52968', '          910.647778', '20080102125013', '273972');
INSERT INTO `pre_dss` VALUES ('w85.AIRA803', '73.48623', '          910.647778', '20080102125013', '273973');
INSERT INTO `pre_dss` VALUES ('w85.AIRA804', '3.5872424', '          910.647778', '20080102125013', '273974');
INSERT INTO `pre_dss` VALUES ('w76.AIRC212', '2.9837673', '          910.647778', '20080102125013', '273982');
INSERT INTO `pre_dss` VALUES ('w75.AIRC213', '3.0058374', '          910.647778', '20080102125013', '273983');
INSERT INTO `pre_dss` VALUES ('w75.AIRC214', '2.9999352', '          910.647778', '20080102125013', '273984');
INSERT INTO `pre_dss` VALUES ('w76.AIRC216', '2.9998307', '          910.647778', '20080102125013', '273986');
INSERT INTO `pre_dss` VALUES ('w77.AIRC217', '2.8586338', '          910.647778', '20080102125013', '273987');
INSERT INTO `pre_dss` VALUES ('w77.AIRC218', '2.8586338', '          910.647778', '20080102125013', '273988');
INSERT INTO `pre_dss` VALUES ('w78.AIRC219', '2.860854', '          910.647778', '20080102125013', '273989');
INSERT INTO `pre_dss` VALUES ('w78.AIRC220', '2.860854', '          910.647778', '20080102125013', '273990');
INSERT INTO `pre_dss` VALUES ('w77.AIRC221', '2.9922142', '          910.647778', '20080102125013', '273991');
INSERT INTO `pre_dss` VALUES ('w77.AIRC222', '2.9922142', '          910.647778', '20080102125013', '273992');
INSERT INTO `pre_dss` VALUES ('w78.AIRC223', '2.9841905', '          910.647778', '20080102125013', '273993');
INSERT INTO `pre_dss` VALUES ('w78.AIRC224', '2.9841905', '          910.647778', '20080102125013', '273994');
INSERT INTO `pre_dss` VALUES ('w77.AIRC225', '2.9967136', '          910.647778', '20080102125013', '273995');
INSERT INTO `pre_dss` VALUES ('w77.AIRC226', '2.9967136', '          910.647778', '20080102125013', '273996');
INSERT INTO `pre_dss` VALUES ('w78.AIRC227', '2.985795', '          910.647778', '20080102125013', '273997');
INSERT INTO `pre_dss` VALUES ('w78.AIRC228', '2.985795', '          910.647778', '20080102125013', '273998');

-- ----------------------------
-- Table structure for `temp_init_predict`
-- ----------------------------
DROP TABLE IF EXISTS `temp_init_predict`;
CREATE TABLE `temp_init_predict` (
  `nameid` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Id` varchar(36) NOT NULL DEFAULT ',',
  `name` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temp_init_predict
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
  `isadmin` bit(1) DEFAULT NULL,
  `isprof` bit(1) DEFAULT NULL,
  `isuser` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', '2', '8', '8', '8', '8', '8', '8', '', '', '');
INSERT INTO `user` VALUES ('123', '3', '123', '张晓明', '123', '123', '123', '123', '', '\0', '');
INSERT INTO `user` VALUES ('1', '4', 'squalhan', '1', '1', 'squalhan@gmail.com', '6161170', '1', null, null, null);

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
