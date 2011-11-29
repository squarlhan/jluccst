/*
Navicat MySQL Data Transfer

Source Server         : aa
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : wushuichang

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2011-11-29 20:48:45
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
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

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
INSERT INTO `backward` VALUES ('137', '', '', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=339 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
INSERT INTO `backwardandreason` VALUES ('333', '136', '二沉池水', '0', '停留时间短', '增加二沉池污水停留时间');
INSERT INTO `backwardandreason` VALUES ('334', '136', '中和处理', '0', '不完全', '加强预处理');
INSERT INTO `backwardandreason` VALUES ('335', '137', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('336', '137', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('337', '137', '碱液管', '0', '堵塞', '及时清通，必要时短管清通');
INSERT INTO `backwardandreason` VALUES ('338', '137', '仪表指示', '0', '不准', '用PH试纸实测');

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
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandresult
-- ----------------------------
INSERT INTO `backwardandresult` VALUES ('112', '127', '生化池系列2 (3号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('113', '128', '生化池系列2 (3号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('114', '129', '生化池系列2 (3号生化池)水量', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('115', '130', '染料厂酸水溶解氧', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('116', '131', '染料厂酸水COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('117', '132', '生化池系列2 (3号生化池)SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('118', '133', '电石厂有机水COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('119', '134', '生化池系列1 (1号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('120', '135', '生化池系列1 (2号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('121', '136', '1、2、4系列排江出口线SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('122', '137', '生化池系列1 (1号生化池)PH', '0', '过高', null);

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
) ENGINE=MyISAM AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdata
-- ----------------------------
INSERT INTO `dcsdata` VALUES ('86', '2系列生化池', '班次', '0');
INSERT INTO `dcsdata` VALUES ('87', '2系列生化池', '3号生化池COD', '0.2');
INSERT INTO `dcsdata` VALUES ('105', '1系列生化池', '班次', '0');
INSERT INTO `dcsdata` VALUES ('106', '1系列生化池', '1号生化池PH', '10');

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
) ENGINE=InnoDB AUTO_INCREMENT=1400 DEFAULT CHARSET=utf8;

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
INSERT INTO `dcsdscrib` VALUES ('1372', '染料厂酸水', 'COD', '0', '染料厂酸水COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1373', '电石厂有机水', 'COD', '0', '电石厂有机水COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1374', '1系列生化池', '1号生化池PH', '6', '生化池系列1 (1号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1375', '1系列生化池', '1号生化池COD', '0', '生化池系列1 (1号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1376', '1系列生化池', '1号生化池COD', '0', '生化池系列1 (1号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1378', '1系列生化池', '1号生化池COD', '0', '生化池系列1 (1号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1379', '1系列生化池', '1号生化池碱度', '8', '生化池系列1 (1号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1380', '1系列生化池', '1号生化池BOD5', '2', '生化池系列1 (1号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1381', '1系列生化池', '1号生化池SS', '100', '生化池系列1 (1号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1382', '1系列生化池', '1号生化池NH3-N', '0', '生化池系列1 (1号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1383', '1系列生化池', '1号生化池硝态氮', '100', '生化池系列1 (1号生化池)硝态氮', '500');
INSERT INTO `dcsdscrib` VALUES ('1384', '1系列生化池', '1号生化池溶解氧', '0', '生化池系列1 (1号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1385', '1系列生化池', '1号生化池风量', '0', '生化池系列1 (1号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1386', '1系列生化池', '1号生化池NO-N', '0', '生化池系列1 (1号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1387', '1系列生化池', '1号生化池水量', '100', '生化池系列1 (1号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1388', '1系列生化池', '2号生化池水量', '100', '生化池系列1 (2号生化池)水量', '500');
INSERT INTO `dcsdscrib` VALUES ('1389', '1系列生化池', '2号生化池PH', '6', '生化池系列1 (2号生化池)PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1390', '1系列生化池', '2号生化池COD', '0', '生化池系列1 (2号生化池)COD', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1391', '1系列生化池', '2号生化池碱度', '8', '生化池系列1 (2号生化池)碱度', '14');
INSERT INTO `dcsdscrib` VALUES ('1392', '1系列生化池', '2号生化池BOD5', '2', '生化池系列1 (2号生化池)BOD5', '4');
INSERT INTO `dcsdscrib` VALUES ('1393', '1系列生化池', '2号生化池SS', '100', '生化池系列1 (2号生化池)SS', '500');
INSERT INTO `dcsdscrib` VALUES ('1394', '1系列生化池', '2号生化池NH3-N', '0', '生化池系列1 (2号生化池)NH3-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1395', '1系列生化池', '2号生化池硝态氮', '100', '生化池系列1 (2号生化池)硝态氮', '500');
INSERT INTO `dcsdscrib` VALUES ('1396', '1系列生化池', '2号生化池溶解氧', '0', '生化池系列1 (2号生化池)溶解氧', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1397', '1系列生化池', '2号生化池风量', '0', '生化池系列1 (2号生化池)风量', '50');
INSERT INTO `dcsdscrib` VALUES ('1398', '1系列生化池', '2号生化池NO-N', '0', '生化池系列1 (2号生化池)NO-N', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1399', '1、2、4系列排江出口线', '出口SS', '0', '1、2、4系列排江出口线SS', '10');

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
) ENGINE=MyISAM AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

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
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75158BF39A42C930` (`name`),
  KEY `FK75158BF36D246B41` (`name`),
  KEY `FK75158BF323A4A4F1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_advice
-- ----------------------------
INSERT INTO `dss_advice` VALUES ('64', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('65', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('66', 'w85.AIRA802', '12.0', '现象：1、2、4系列排江出口线SS过高   原因：二沉池水停留时间短  建议：增加二沉池污水停留时间', '1111.23', '20111124', '二沉池水停留时间短', null);
INSERT INTO `dss_advice` VALUES ('67', 'w85.AIRA802', '12.0', '现象：1、2、4系列排江出口线SS过高   原因：中和处理不完全  建议：加强预处理', '1111.23', '20111124', '中和处理不完全', null);
INSERT INTO `dss_advice` VALUES ('58', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('59', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('60', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('61', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('54', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('55', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('56', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('57', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('63', null, null, '一切正常', null, null, null, null);
INSERT INTO `dss_advice` VALUES ('62', null, null, '一切正常', null, null, null, null);

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
  KEY `FKA84AB4F99A42C930` (`name`),
  KEY `FKA84AB4F96D246B41` (`name`),
  KEY `FKA84AB4F923A4A4F1` (`name`),
  CONSTRAINT `FKA84AB4F923A4A4F1` FOREIGN KEY (`name`) REFERENCES `init_predict` (`Id`),
  CONSTRAINT `FKA84AB4F96D246B41` FOREIGN KEY (`name`) REFERENCES `initdata` (`id`),
  CONSTRAINT `FKA84AB4F99A42C930` FOREIGN KEY (`name`) REFERENCES `exceldata` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

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
  `Id` varchar(36) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `name` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of init_predict
-- ----------------------------
INSERT INTO `init_predict` VALUES ('9999', '正常', null);
INSERT INTO `init_predict` VALUES ('w3.COD', '电石厂有机水.COD', null);
INSERT INTO `init_predict` VALUES ('w61.TIR203', '2系列生化池.3号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA101', '进水提升泵房(462A).462A进水提升泵房COD', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA102', '进水提升泵房(462A).462A进水提升泵房NH3-N', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA107', '进水提升泵房(462A).462A.进水提升泵房PH', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA108', '进水提升泵房(462A).462A进水提升泵房SS', null);
INSERT INTO `init_predict` VALUES ('w62.LDISA102', '进水提升泵房(462A).2#粗格栅前后液位差', null);
INSERT INTO `init_predict` VALUES ('w62.LDISA103', '进水提升泵房(462A).3#粗格栅前后液位差', null);
INSERT INTO `init_predict` VALUES ('w62.LDISA104', '进水提升泵房(462A).泵室液位', null);
INSERT INTO `init_predict` VALUES ('w62.LISA104', '进水提升泵房(462A).462A吸水池液位', null);
INSERT INTO `init_predict` VALUES ('w62.P1STATUS', '进水提升泵房(462A).1#潜水排污泵', null);
INSERT INTO `init_predict` VALUES ('w62.P2STATUS', '进水提升泵房(462A).2#潜水排污泵', null);
INSERT INTO `init_predict` VALUES ('w62.P3STATU', '进水提升泵房(462A).3#潜水排污泵', null);
INSERT INTO `init_predict` VALUES ('w62.P4STATUS', '进水提升泵房(462A).4#潜水排污泵', null);
INSERT INTO `init_predict` VALUES ('w62.P5STATUS', '进水提升泵房(462A).5#潜水排污泵', null);
INSERT INTO `init_predict` VALUES ('w6216.LDISA101', '进水提升泵房(462A).1#粗格栅前后液位差', null);
INSERT INTO `init_predict` VALUES ('w63.FRQ101', '巴氏计量槽（499）.水量', null);
INSERT INTO `init_predict` VALUES ('w63.LDISA106', '巴氏计量槽（499）.巴氏计量槽前液位', null);
INSERT INTO `init_predict` VALUES ('w63.LDISA107', '巴氏计量槽（499）.巴氏计量槽后液位', null);
INSERT INTO `init_predict` VALUES ('w65.M4881', '沉沙刮沙池(488).M488-1#刮沙机', null);
INSERT INTO `init_predict` VALUES ('w65.M4882', '沉沙刮沙池(488).M488-2#刮沙机', null);
INSERT INTO `init_predict` VALUES ('w65.M4883', '沉沙刮沙池(488).M488-3#刮沙机', null);
INSERT INTO `init_predict` VALUES ('w65.M4884', '沉沙刮沙池(488).M488-3#刮沙机', null);
INSERT INTO `init_predict` VALUES ('w66.M4891S', '初沉池(489B).M489-1#周边传动刮泥机', null);
INSERT INTO `init_predict` VALUES ('w66.M4892S', '初沉池(489B).M489-2#周边传动刮泥机', null);
INSERT INTO `init_predict` VALUES ('w66.M4893S', '初沉池(489B).M489-3#周边传动刮泥机', null);
INSERT INTO `init_predict` VALUES ('w67.LIA115', '事故池(489).事故池液位', null);
INSERT INTO `init_predict` VALUES ('w68.FRQ102', '14B生活水.水量', null);
INSERT INTO `init_predict` VALUES ('w69.LIA114', '老水解酸化池.老水解酸化池液位', null);
INSERT INTO `init_predict` VALUES ('w70.LIA115', '新水解酸化池.新水解酸化池液位', null);
INSERT INTO `init_predict` VALUES ('w71.FRQ103', '污泥池(V466).P466-1-2泵出口干管流量', null);
INSERT INTO `init_predict` VALUES ('w71.FRQ104', '污泥池(V466).P466-3-4泵出口干管流量', null);
INSERT INTO `init_predict` VALUES ('w71.LISA119', '污泥泵房(466).V466污泥池前液位', null);
INSERT INTO `init_predict` VALUES ('w73.FI106', '脱水装置(495).P495A-1流量', null);
INSERT INTO `init_predict` VALUES ('w73.FI107', '脱水装置(495).P495A-2流量', null);
INSERT INTO `init_predict` VALUES ('w73.FI108', '脱水装置(495).P495A-3流量', null);
INSERT INTO `init_predict` VALUES ('w73.FI109', '脱水装置(495).P495A-4流量', null);
INSERT INTO `init_predict` VALUES ('w73.FI110', '脱水装置(495).P495A-5流量', null);
INSERT INTO `init_predict` VALUES ('w73.FI111', '脱水装置(495).P495A-6流量', null);
INSERT INTO `init_predict` VALUES ('w73.LISA122', '脱水装置(495).V495A-5液位', null);
INSERT INTO `init_predict` VALUES ('w73.LISA123', '脱水装置(495).药剂池V495-3液位', null);
INSERT INTO `init_predict` VALUES ('w73.LISA124', '脱水装置(495).药剂池V495-4液位', null);
INSERT INTO `init_predict` VALUES ('w73.R4951', '脱水装置(495).1#带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4952', '脱水装置(495).2#带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4953', '脱水装置(495).3#带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4954', '脱水装置(495).4#带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4955', '脱水装置(495).5#带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA103', '中间提升泵房(462B).462B吸水池COD', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA104', '中间提升泵房(462B).462B吸水池NH3-N', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA105', '中间提升泵房(462B).462B吸水池SS', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA106', '中间提升泵房(462B).462B吸水池PH', null);
INSERT INTO `init_predict` VALUES ('w74.AIRC207', '2系列生化池.3号生化池2段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w74.AIRC211', '2系列生化池.3号生化池3段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w74.AIRC215', '2系列生化池.3号生化池5段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w74.LIA116', '中间提升泵房(462B).462B泵房吸水池液位', null);
INSERT INTO `init_predict` VALUES ('w74.LIA117', '中间提升泵房(462B).V462B-3高位水池液位', null);
INSERT INTO `init_predict` VALUES ('w75.AIR229', '一系列生化池.1号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w75.AIR230', '一系列生化池.2号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC205', '一系列生化池.1号生化池2段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC206', '一系列生化池.2号生化池2段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC209', '一系列生化池.1号生化池3段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC210', '一系列生化池.2号生化池3段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC213', '一系列生化池.1号生化池5段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC214', '一系列生化池.2号生化池5段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w75.FR601A', '一系列生化池.1#鼓风机分量', null);
INSERT INTO `init_predict` VALUES ('w75.TIR201', '一系列生化池.1号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w75.TIR202', '一系列生化池.2号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w76.AIR231', '2系列生化池.3号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w76.AIR232', '2系列生化池.4号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w76.AIR234', '3系列生化池.6号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC208', '2系列生化池.4号生化池2段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC212', '2系列生化池.4号生化池3段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC216', '2系列生化池.4号生化池5段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w76.FR601B', '2系列生化池.2#鼓风机分量', null);
INSERT INTO `init_predict` VALUES ('w76.TIR204', '2系列生化池.4号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w77.AIR201', '3系列生化池.5号生化池A段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w77.AIR202', '3系列生化池.6号生化池A段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w77.AIR233', '3系列生化池.5号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC217', '3系列生化池.5号生化池2段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC218', '3系列生化池.号生化池2段溶解氧DO6', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC221', '3系列生化池.5号生化池4段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC222', '3系列生化池.6号生化池4段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC225', '3系列生化池.5号生化池6段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC226', '3系列生化池.6号生化池6段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w77.FR601C', '3系列生化池.3#鼓风机分量', null);
INSERT INTO `init_predict` VALUES ('w77.TIR205', '3系列生化池.5号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w77.TIR206', '3系列生化池.6号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w78.AIR203', '4系列生化池.7号生化池A段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.AIR204', '4系列生化池.8号生化池A段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.AIR235', '4系列生化池.7号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w78.AIR236', '4系列生化池.8号生化池PH', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC219', '4系列生化池.7号生化池2段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC220', '4系列生化池.8号生化池2段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC223', '4系列生化池.7号生化池4段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC224', '4系列生化池.8号生化池4段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC227', '4系列生化池.7号生化池6段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC228', '4系列生化池.8号生化池6段溶解氧DO', null);
INSERT INTO `init_predict` VALUES ('w78.FR601B', '4系列生化池.4#鼓风机分量', null);
INSERT INTO `init_predict` VALUES ('w78.TIR207', '4系列生化池.7号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w78.TIR208', '4系列生化池.8号生化池温度', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA801', '1、2、4系列排江出口线.出口PH', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA802', '1、2、4系列排江出口线.出口SS', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA803', '1、2、4系列排江出口线.出口COD', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA804', '1、2、4系列排江出口线.出口NH3-N', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA805', '1、2、4系列排江出口线.出口DO', null);
INSERT INTO `init_predict` VALUES ('w86.FRCQ201', '1系列465回流泵房.1系列465-1回流泵房回流量', null);
INSERT INTO `init_predict` VALUES ('w86.FRCQ202', '1系列465回流泵房.2系列465-2回流泵房回流量', null);
INSERT INTO `init_predict` VALUES ('w86.FRCQ203', '1系列465回流泵房.1系列465回流泵房剩余量', null);
INSERT INTO `init_predict` VALUES ('w86.LISA201', '1系列465回流泵房.465吸泥池液位', null);
INSERT INTO `init_predict` VALUES ('w87.FRCQ204', '2系列465A回流泵房.2系列465A回流泵房回流量', null);
INSERT INTO `init_predict` VALUES ('w87.FRCQ205', '2系列465A回流泵房.2系列465A回流泵房剩余量', null);
INSERT INTO `init_predict` VALUES ('w87.LISA202', '2系列465A回流泵房.465A吸泥池液位', null);
INSERT INTO `init_predict` VALUES ('w88.FRCQ206', '3系列465B回流泵房.3系列465B回流泵房回流量', null);
INSERT INTO `init_predict` VALUES ('w88.FRCQ207', '3系列465B回流泵房.3系列465B回流泵房剩余量', null);
INSERT INTO `init_predict` VALUES ('w88.LISA204', '3系列465B回流泵房.465B吸泥池液位', null);

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
  KEY `FK5036F6089A42C930` (`name`),
  KEY `FK5036F6086D246B41` (`name`),
  KEY `FK5036F60823A4A4F1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_dss
-- ----------------------------
INSERT INTO `pre_dss` VALUES ('w85.AIRA802', '12', '1111.23', '20111124', '5');
INSERT INTO `pre_dss` VALUES ('w85.AIRA802', '9', '1111.22', '20111125', '6');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', '2', '8', '8', '8', '8', '8', '8');
INSERT INTO `user` VALUES ('123', '3', '123', '张晓明', '123', '123', '123', '123');
INSERT INTO `user` VALUES ('1', '4', 'squalhan', '1', '1', 'squalhan@gmail.com', '6161170', '1');

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
