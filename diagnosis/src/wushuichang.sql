/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : wushuichang

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2012-01-09 16:17:33
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
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backward
-- ----------------------------
INSERT INTO `backward` VALUES ('4', '生化池系列1(1号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('5', '生化池系列1(1号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('6', '生化池系列1(2号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('7', '生化池系列1(2号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('8', '生化池系列2(3号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('9', '生化池系列2(3号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('10', '生化池系列2(4号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('11', '生化池系列2(4号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('12', '生化池系列3(5号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('13', '生化池系列3(6号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('14', '生化池系列4(7号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('15', '生化池系列4(8号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('16', '生化池系列3(5号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('17', '生化池系列3(6号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('18', '生化池系列4(7号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('19', '生化池系列4(8号生化池)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('20', '生化池系列1(1号生化池)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('21', '生化池系列1(2号生化池)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('22', '生化池系列2(3号生化池)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('23', '生化池系列2(4号生化池)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('24', '生化池系列3(5号生化池)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('25', '生化池系列3(6号生化池)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('26', '生化池系列4(7号生化池)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('27', '生化池系列4(8号生化池)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('28', '生化池系列1(1号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('29', '生化池系列1(2号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('30', '生化池系列2(3号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('31', '生化池系列2(4号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('32', '生化池系列3(5号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('33', '生化池系列3(6号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('34', '生化池系列4(7号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('35', '生化池系列4(8号生化池)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('36', '生化池系列1(1号生化池)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('37', '生化池系列1(2号生化池)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('38', '生化池系列2(3号生化池)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('39', '生化池系列2(4号生化池)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('40', '生化池系列3(5号生化池)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('41', '生化池系列3(6号生化池)', 'A段溶解氧过高', '0', '0');
INSERT INTO `backward` VALUES ('42', '生化池系列4(7号生化池)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('43', '生化池系列4(8号生化池)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('46', '排江出口线', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('47', '排江出口线', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('48', '排江出口线', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('49', '排江出口线', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('50', '排江出口线', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('51', '稳流池(477)进水', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('52', '稳流池(477)进水', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('53', '稳流池(477)进水', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('54', '稳流池(477)进水', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('55', '稳流池(477)进水', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('56', '稳流池(477)进水', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('65', '初沉池(489B)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('66', '初沉池(489B)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('67', '初沉池(489B)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('68', '初沉池(489B)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('69', '初沉池(489B)', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('70', '初沉池(489B)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('71', '事故池(489)', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('72', '事故池(489)', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('73', '事故池(489)', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('74', '事故池(489)', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('75', '事故池(489)', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('76', '事故池(489)', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('77', '老水解酸化池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('78', '老水解酸化池', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('79', '新水解酸化池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('80', '新水解酸化池', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('81', '老水解酸化池', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('82', '新水解酸化池', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('83', '老水解酸化池', '碱度过高', '0', '0');
INSERT INTO `backward` VALUES ('84', '新水解酸化池', '碱度过高', '0', '0');
INSERT INTO `backward` VALUES ('85', '新水解酸化池', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('86', '老水解酸化池', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('87', '新水解酸化池', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('88', '老水解酸化池', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('89', '1系列二沉池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('91', '1系列二沉池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('92', '1系列二沉池', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('93', '1系列二沉池', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('94', '1系列二沉池', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('95', '1系列二沉池', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('96', '1系列二沉池', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('97', '2系列二沉池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('98', '2系列二沉池', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('99', '2系列二沉池', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('100', '2系列二沉池', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('101', '2系列二沉池', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('102', '3系列二沉池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('103', '3系列二沉池', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('104', '3系列二沉池', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('105', '3系列二沉池', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('106', '3系列二沉池', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('107', '3系列二沉池', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('108', '4系列二沉池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('109', '4系列二沉池', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('110', '4系列二沉池', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('111', '4系列二沉池', 'BOD5过高', '0', '0');
INSERT INTO `backward` VALUES ('112', '4系列二沉池', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('113', '4系列二沉池', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('114', '接触氧化池', 'PH过低', '0', '0');
INSERT INTO `backward` VALUES ('115', '接触氧化池', 'PH过高', '0', '0');
INSERT INTO `backward` VALUES ('116', '接触氧化池', 'COD过高', '0', '0');
INSERT INTO `backward` VALUES ('117', '接触氧化池', 'SS过高', '0', '0');
INSERT INTO `backward` VALUES ('119', '接触氧化池', 'NH3-N过高', '0', '0');
INSERT INTO `backward` VALUES ('120', '接触氧化池', 'BOD5过高', '0', '0');

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
  `nouns` varchar(255) DEFAULT NULL,
  `cf_reason` double DEFAULT '1',
  `verb` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFBA61E58DB7478BC` (`bid`),
  CONSTRAINT `FKFBA61E58DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=587 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandreason
-- ----------------------------
INSERT INTO `backwardandreason` VALUES ('4', '4', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('5', '4', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('6', '4', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('7', '4', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('8', '4', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('9', '4', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('10', '4', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('11', '5', '', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('12', '6', '', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('13', '7', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('14', '7', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('15', '7', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('16', '7', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('17', '7', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('18', '7', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('19', '7', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('20', '8', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('21', '8', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('22', '8', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('23', '8', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('24', '8', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('25', '8', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('26', '8', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('27', '9', '', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('28', '10', '', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('29', '11', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('30', '11', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('31', '11', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('32', '11', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('33', '11', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('34', '11', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('35', '11', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('36', '12', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('37', '13', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('38', '14', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('39', '15', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('44', '16', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('45', '16', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('46', '16', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('47', '17', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('48', '17', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('49', '17', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('50', '17', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('51', '17', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('52', '17', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('53', '17', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('54', '18', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('55', '18', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('56', '18', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('57', '18', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('58', '18', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('59', '18', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('60', '18', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('61', '19', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('62', '19', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('63', '19', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('64', '19', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('65', '19', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('66', '19', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('67', '19', '', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('68', '20', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('69', '20', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('70', '20', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('71', '20', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('72', '20', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('73', '21', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('74', '21', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('75', '21', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('76', '21', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('77', '21', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('78', '22', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('79', '22', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('80', '22', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('81', '22', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('82', '22', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('83', '23', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('84', '23', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('85', '23', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('86', '23', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('87', '23', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('88', '24', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('89', '24', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('90', '24', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('91', '24', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('92', '24', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('93', '25', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('94', '25', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('95', '25', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('96', '25', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('97', '25', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('98', '26', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('99', '26', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('100', '26', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('101', '26', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('102', '26', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('103', '27', '进水有机物浓度', '0', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('104', '27', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('105', '27', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('106', '27', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('107', '27', '水质冲击', '0', '有毒物质进入', '检查进水');
INSERT INTO `backwardandreason` VALUES ('108', '28', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('109', '28', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('110', '28', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('111', '28', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('112', '28', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('113', '28', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('114', '29', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('115', '29', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('116', '29', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('117', '29', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('118', '29', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('119', '29', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('120', '30', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('121', '30', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('122', '30', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('123', '30', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('124', '30', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('125', '30', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('126', '31', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('127', '31', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('128', '31', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('129', '31', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('130', '31', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('131', '31', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('132', '32', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('133', '32', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('134', '32', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('135', '32', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('136', '32', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('137', '32', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('138', '33', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('139', '33', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('140', '33', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('141', '33', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('142', '33', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('143', '33', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('144', '34', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('145', '34', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('146', '34', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('147', '34', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('148', '34', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('149', '34', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('150', '35', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('151', '35', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('152', '35', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('153', '35', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('154', '35', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('155', '35', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('156', '36', '', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('157', '36', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('158', '36', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('159', '36', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('160', '36', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('161', '36', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('162', '36', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('163', '36', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('164', '36', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('165', '37', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('166', '37', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('167', '37', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('168', '37', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('169', '37', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('170', '37', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('171', '37', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('172', '37', '水温', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('173', '37', '', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('174', '38', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('175', '38', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('176', '38', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('177', '38', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('178', '38', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('179', '38', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('180', '38', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('181', '38', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('182', '38', '', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('183', '39', '消解机进水进料量', '0', '消解机进水进料量	调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('184', '39', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('185', '39', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('186', '39', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('187', '39', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('188', '39', 'COD', '0', '高', '降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('189', '39', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('190', '39', '', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('191', '40', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('192', '40', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('193', '40', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('194', '40', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('195', '40', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('196', '40', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('197', '40', 'COD', '0', '高', '降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('198', '40', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('199', '40', '', '0', '增加碱液投加量，或查找消解设备是否出现故障', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('200', '41', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('201', '41', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('202', '41', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('203', '41', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('204', '41', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('205', '41', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('206', '41', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('207', '41', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('208', '41', '', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('209', '42', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('210', '42', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('211', '42', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('212', '42', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('213', '42', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('214', '42', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('215', '42', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('216', '42', '水温', '0', '降低进水浓度，', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('217', '42', '进水碱度', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('218', '43', '进水碱度', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('219', '43', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('220', '43', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('221', '43', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('222', '43', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('223', '43', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('224', '43', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('225', '43', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('226', '43', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('239', '46', '低于最低值', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('240', '46', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('241', '46', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('242', '46', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('243', '46', '碱液碱度', '0', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('244', '46', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('245', '46', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('246', '47', '高于最高值', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('247', '48', '值', '0', '高', '加絮凝剂，脱色剂');
INSERT INTO `backwardandreason` VALUES ('248', '49', '进水有机物浓度', '0', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('249', '49', '水解酸化效果', '0', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('250', '49', '生活污水量', '0', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('251', '49', '污泥浓度', '0', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('252', '49', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('253', '49', 'DO', '0', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('254', '50', '进水碱度', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('255', '50', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('256', '50', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('257', '50', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('258', '50', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('259', '50', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('260', '50', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('261', '50', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('262', '50', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('263', '51', '低于最低值', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('264', '51', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('265', '51', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('266', '51', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('267', '51', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('268', '52', '高于最高值', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('269', '53', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('270', '53', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('271', '53', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('272', '53', '重油量', '0', '多', '沉淀池处理或者进入事故池存');
INSERT INTO `backwardandreason` VALUES ('273', '54', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('274', '54', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('275', '54', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('276', '54', '重油量', '0', '多', '沉淀池处理或者进入事故池存');
INSERT INTO `backwardandreason` VALUES ('277', '54', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('278', '54', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('279', '55', '含泥量', '0', '大', '加强初沉池管理');
INSERT INTO `backwardandreason` VALUES ('280', '55', '排泥', '0', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('281', '56', '进水碱度', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('282', '56', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('283', '56', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('284', '56', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('285', '56', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('286', '56', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('287', '56', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('288', '56', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('289', '56', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('314', '65', '低于最低值', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('315', '65', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('316', '65', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('317', '65', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('318', '65', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('319', '66', '高于最高值', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('320', '67', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('321', '67', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('322', '67', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('323', '67', '重油量', '0', '多', '沉淀池处理或者进入事故池存');
INSERT INTO `backwardandreason` VALUES ('324', '68', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('325', '68', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('326', '68', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('327', '68', '重油量', '0', '多', '沉淀池处理或者进入事故池存');
INSERT INTO `backwardandreason` VALUES ('328', '68', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('329', '68', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('330', '69', '含泥量', '0', '大', '加强初沉池管理');
INSERT INTO `backwardandreason` VALUES ('331', '69', '排泥', '0', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('332', '70', '进水碱度', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('333', '70', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('334', '70', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('335', '70', '消解效果', '0', '不到位', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('336', '70', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('337', '70', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('338', '70', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('339', '70', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('340', '70', 'COD', '0', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('341', '70', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('342', '71', '低于最低值', '0', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('343', '71', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('344', '71', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('345', '71', '仪表指示', '0', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('346', '71', 'PH指示表', '0', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('347', '72', '高于最高值', '0', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('348', '73', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('349', '73', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('350', '73', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('351', '73', '重油量', '0', '多', '沉淀池处理或者进入事故池存');
INSERT INTO `backwardandreason` VALUES ('352', '74', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('353', '74', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('354', '74', '污泥沉降性、絮凝性差', '0', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('355', '74', '重油量', '0', '多', '沉淀池处理或者进入事故池存');
INSERT INTO `backwardandreason` VALUES ('356', '74', '含泥量', '0', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('357', '74', '含油量', '0', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('358', '75', '控制液位', '0', '大', '加强初沉池管理');
INSERT INTO `backwardandreason` VALUES ('359', '75', '排泥', '0', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('360', '76', '进水碱度', '0', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('361', '76', '消解机进水进料量', '0', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('362', '76', '生石灰质量', '0', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('363', '76', '消解效果', '0', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('364', '76', '消解机进口', '0', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('365', '76', '消解用水量', '0', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('366', '76', 'DO', '0', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('367', '76', 'COD', '0', '高', '降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('368', '76', '水温', '0', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('369', '77', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('370', '77', '酸水的流量', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('371', '77', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('372', '77', '仪表指示', '1', '不准', '用PH试纸是测');
INSERT INTO `backwardandreason` VALUES ('373', '77', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('374', '78', '', '1', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('375', '79', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('376', '79', '酸水的流量', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('377', '79', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('378', '79', '仪表指示', '1', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('379', '79', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('380', '80', '', '1', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('381', '81', '含泥量', '1', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('382', '81', '含油量', '1', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('383', '81', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('384', '82', '含泥量', '1', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('385', '82', '含油量', '1', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('386', '82', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('387', '83', '含量', '1', '高', '加石灰的投加量');
INSERT INTO `backwardandreason` VALUES ('388', '84', '含量', '1', '高', '加石灰的投加量');
INSERT INTO `backwardandreason` VALUES ('389', '85', '含泥量', '1', '高', '加强初沉池排泥');
INSERT INTO `backwardandreason` VALUES ('390', '85', '含油量', '1', '大', '控制液位');
INSERT INTO `backwardandreason` VALUES ('391', '85', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('392', '85', '重油量', '1', '多', '沉淀池处理或者进入事故池存');
INSERT INTO `backwardandreason` VALUES ('393', '86', '含泥量', '1', '大', '加强初沉池管理');
INSERT INTO `backwardandreason` VALUES ('394', '86', '排泥', '1', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('395', '87', '含泥量', '1', '大', '加强初沉池管理');
INSERT INTO `backwardandreason` VALUES ('396', '87', '排泥', '1', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('397', '88', '进水碱度', '1', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('398', '88', '消解机进水进料量', '1', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('399', '88', '生石灰质量', '1', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('400', '88', '消解效果', '1', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('401', '88', '消解机进口', '1', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('402', '88', '消解用水量', '1', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('403', '88', 'DO', '1', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('404', '88', 'COD', '1', '高', '降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('405', '88', '水温', '1', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('406', '88', '水量', '1', '大', '控制排水');
INSERT INTO `backwardandreason` VALUES ('407', '89', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('408', '89', '酸水的流量', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('409', '89', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('410', '89', '仪表指示', '1', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('411', '89', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('413', '91', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('414', '91', '酸水的流量', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('415', '91', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('416', '91', '碱液管线', '1', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('417', '91', '碱液碱度', '1', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('418', '91', '仪表指示', '1', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('419', '91', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('420', '92', '', '1', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('421', '93', '进水有机物浓度', '1', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('422', '93', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('423', '93', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('424', '93', '', '1', '', '加消泡剂，脱色剂');
INSERT INTO `backwardandreason` VALUES ('425', '94', '加消泡剂，脱色剂', '1', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('426', '94', '水解酸化效果', '1', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('427', '94', '生活污水量', '1', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('428', '94', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('429', '94', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('430', '94', 'DO', '1', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('431', '95', '污泥沉降性、絮凝性差', '1', '污泥膨胀', '降低进水浓度、增加污泥回流比， 增加生化池o段的曝气量；提高进水pH值，提高水温；');
INSERT INTO `backwardandreason` VALUES ('432', '95', '', '1', '污泥解体', '控制进水指标；调整曝气量；');
INSERT INTO `backwardandreason` VALUES ('433', '95', '', '1', '污泥上浮', '及时排泥；增加曝气池末端溶解氧');
INSERT INTO `backwardandreason` VALUES ('434', '95', '', '1', '污泥中毒', '控制进水');
INSERT INTO `backwardandreason` VALUES ('435', '95', '', '1', '泡沫', '工业水喷淋');
INSERT INTO `backwardandreason` VALUES ('436', '95', '排泥', '1', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('437', '96', '进水碱度', '1', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('438', '96', '消解机进水进料量', '1', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('439', '96', '生石灰质量', '1', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('440', '96', '消解效果', '1', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('441', '96', '消解机进口', '1', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('442', '96', '消解用水量', '1', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('443', '96', 'DO', '1', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('444', '96', 'COD', '1', '高', '降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('445', '96', '水温', '1', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('446', '97', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('447', '97', '酸水的流量', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('448', '97', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('449', '97', '碱液管线', '1', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('450', '97', '碱液碱度', '1', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('451', '97', '仪表指示', '1', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('452', '97', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('453', '98', '进水有机物浓度', '1', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('454', '98', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('455', '98', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('456', '98', '', '1', '', '加消泡剂，脱色剂');
INSERT INTO `backwardandreason` VALUES ('457', '99', '进水有机物浓度', '1', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('458', '99', '水解酸化效果', '1', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('459', '99', '生活污水量', '1', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('460', '99', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('461', '99', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('462', '99', 'DO', '1', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('463', '100', '污泥沉降性、絮凝性差', '1', '污泥膨胀', '降低进水浓度、增加污泥回流比， 增加生化池o段的曝气量；提高进水pH值，提高水温');
INSERT INTO `backwardandreason` VALUES ('464', '100', '', '1', '污泥解体', '控制进水指标；调整曝气量');
INSERT INTO `backwardandreason` VALUES ('465', '100', '', '1', '污泥上浮', '及时排泥；增加曝气池末端溶解氧');
INSERT INTO `backwardandreason` VALUES ('466', '100', '', '1', '污泥中毒', '控制进水');
INSERT INTO `backwardandreason` VALUES ('467', '100', '', '1', '泡沫', '工业水喷淋');
INSERT INTO `backwardandreason` VALUES ('468', '100', '排泥', '1', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('469', '101', '进水碱度', '1', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('470', '101', '消解机进水进料量', '1', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('471', '101', '生石灰质量', '1', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('472', '101', '消解效果', '1', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('473', '101', '消解效果', '1', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('474', '101', '消解机进口', '1', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('475', '101', '消解用水量', '1', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('476', '101', 'DO', '1', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('477', '101', 'COD', '1', '高', '降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('478', '101', '水温', '1', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('479', '102', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('480', '102', '酸水的流量', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('481', '102', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('482', '102', '碱液管线', '1', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('483', '102', '碱液碱度', '1', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('484', '102', '仪表指示', '1', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('485', '102', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('486', '103', '', '1', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('487', '104', '进水有机物浓度', '1', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('488', '104', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('489', '104', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('490', '104', '', '1', '', '加消泡剂，脱色剂');
INSERT INTO `backwardandreason` VALUES ('491', '105', '进水有机物浓度', '1', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('492', '105', '水解酸化效果', '1', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('493', '105', '生活污水量', '1', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('494', '105', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('495', '105', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('496', '105', 'DO', '1', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('497', '106', '污泥沉降性、絮凝性差', '1', '污泥膨胀', '降低进水浓度、增加污泥回流比， 增加生化池o段的曝气量；提高进水pH值，提高水温；');
INSERT INTO `backwardandreason` VALUES ('498', '106', '', '1', '污泥解体', '控制进水指标；调整曝气量；');
INSERT INTO `backwardandreason` VALUES ('499', '106', '', '1', '污泥上浮', '及时排泥；增加曝气池末端溶解氧');
INSERT INTO `backwardandreason` VALUES ('500', '106', '', '1', '污泥中毒', '控制进水');
INSERT INTO `backwardandreason` VALUES ('501', '106', '', '1', '泡沫', '工业水喷淋');
INSERT INTO `backwardandreason` VALUES ('502', '106', '排泥', '1', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('503', '107', '进水碱度', '1', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('504', '107', '消解机进水进料量', '1', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('505', '107', '生石灰质量', '1', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('506', '107', '消解效果', '1', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('507', '107', '消解机进口', '1', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('508', '107', '消解用水量', '1', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('509', '107', 'DO', '1', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('510', '107', 'COD', '1', '高', '降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('511', '107', '水温', '1', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('512', '108', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('513', '108', '酸水的流量', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('514', '108', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('515', '108', '碱液管线', '1', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('516', '108', '碱液碱度', '1', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('517', '108', '仪表指示', '1', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('518', '108', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('519', '109', '', '1', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('520', '110', '进水有机物浓度', '1', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('521', '110', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('522', '110', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('523', '110', '', '1', '', '加消泡剂，脱色剂');
INSERT INTO `backwardandreason` VALUES ('524', '111', '进水有机物浓度', '1', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('525', '111', '水解酸化效果', '1', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('526', '111', '生活污水量', '1', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('527', '111', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('528', '111', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('529', '111', 'DO', '1', '不足', '增加曝气量');
INSERT INTO `backwardandreason` VALUES ('530', '112', '污泥沉降性、絮凝性差', '1', '污泥膨胀', '降低进水浓度、增加污泥回流比， 增加生化池o段的曝气量；提高进水pH值，提高水温；');
INSERT INTO `backwardandreason` VALUES ('531', '112', '', '1', '污泥解体', '控制进水指标；调整曝气量');
INSERT INTO `backwardandreason` VALUES ('532', '112', '', '1', '污泥上浮', '及时排泥；增加曝气池末端溶解氧');
INSERT INTO `backwardandreason` VALUES ('533', '112', '', '1', '污泥中毒', '控制进水');
INSERT INTO `backwardandreason` VALUES ('534', '112', '', '1', '泡沫', '工业水喷淋');
INSERT INTO `backwardandreason` VALUES ('535', '112', '排泥', '1', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('536', '113', '进水碱度', '1', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('537', '113', '消解机进水进料量', '1', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('538', '113', '生石灰质量', '1', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('539', '113', '消解效果', '1', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('540', '113', '消解机进口', '1', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('541', '113', '消解用水量', '1', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('542', '113', 'DO', '1', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('543', '113', 'COD', '1', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('544', '113', '水温', '1', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('545', '114', '提高进水水温', '1', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('546', '114', '酸水的酸度', '1', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('547', '114', '碱液管线', '1', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('548', '114', '碱液碱度', '1', '低', '增加两台碱液泵运行');
INSERT INTO `backwardandreason` VALUES ('549', '114', '仪表指示', '1', '不准', '用PH试纸实测');
INSERT INTO `backwardandreason` VALUES ('550', '114', 'PH指示表', '1', '损坏', '找仪表人员处理，恢复正常');
INSERT INTO `backwardandreason` VALUES ('551', '114', '', '1', '', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障');
INSERT INTO `backwardandreason` VALUES ('552', '115', '', '1', '', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）');
INSERT INTO `backwardandreason` VALUES ('553', '116', '进水有机物浓度', '1', '高', '调整降低进水浓度');
INSERT INTO `backwardandreason` VALUES ('554', '116', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('555', '116', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('556', '116', '悬浮物', '1', '多', '调整空气量，通过排泥把浮物去掉');
INSERT INTO `backwardandreason` VALUES ('557', '117', '污泥沉降性、絮凝性差', '1', '污泥膨胀', '降低进水浓度、增加污泥回流比， 增加生化池o段的曝气量；提高进水pH值，提高水温；');
INSERT INTO `backwardandreason` VALUES ('558', '117', '污泥沉降性、絮凝性差', '1', '污泥解体', '控制进水指标；调整曝气量；');
INSERT INTO `backwardandreason` VALUES ('559', '117', '污泥沉降性、絮凝性差', '1', '污泥上浮', '及时排泥；增加曝气池末端溶解氧');
INSERT INTO `backwardandreason` VALUES ('560', '117', '污泥沉降性、絮凝性差', '1', '污泥中毒', '控制进水');
INSERT INTO `backwardandreason` VALUES ('561', '117', '污泥沉降性、絮凝性差', '1', '泡沫', '工业水喷淋');
INSERT INTO `backwardandreason` VALUES ('562', '117', '排泥', '1', '不及时', '加大排泥量');
INSERT INTO `backwardandreason` VALUES ('572', '119', '进水碱度', '1', '低', '增加碱液投加量，或查找消解设备是否出现故障');
INSERT INTO `backwardandreason` VALUES ('573', '119', '消解机进水进料量', '1', '调解', '1、根据石灰的质量，调整石灰和水的最佳配比量  2、调整喷淋水最佳 流量，保证石灰渣不跑浆，使石灰彻底消解  3、提升碱液时要充分搅拌，防止碱液沉淀');
INSERT INTO `backwardandreason` VALUES ('574', '119', '生石灰质量', '1', '不好', '保证入库生石灰质量');
INSERT INTO `backwardandreason` VALUES ('575', '119', '消解效果', '1', '不到位', '调整合适水量加料量和反应温度');
INSERT INTO `backwardandreason` VALUES ('576', '119', '消解机进口', '1', '堵塞', '用工具清理进料口');
INSERT INTO `backwardandreason` VALUES ('577', '119', '消解用水量', '1', '不足', '与调度室联系，保证用水量');
INSERT INTO `backwardandreason` VALUES ('578', '119', 'DO', '1', '低', '加大曝气量');
INSERT INTO `backwardandreason` VALUES ('579', '119', 'COD', '1', '高', '降低进水浓度，');
INSERT INTO `backwardandreason` VALUES ('580', '119', '水温', '1', '低', '提高进水水温');
INSERT INTO `backwardandreason` VALUES ('581', '120', '进水有机物浓度', '1', '高', '调整进水浓度');
INSERT INTO `backwardandreason` VALUES ('582', '120', '水解酸化效果', '1', '差', '检查填料挂膜情况，控制进水浓度');
INSERT INTO `backwardandreason` VALUES ('583', '120', '生活污水量', '1', '少', '提高生活污水比例');
INSERT INTO `backwardandreason` VALUES ('584', '120', '污泥浓度', '1', '低', '增加回流比');
INSERT INTO `backwardandreason` VALUES ('585', '120', '污泥沉降性、絮凝性差', '1', '差', '降低进水浓度；增加曝气量；提高水温；提高进水pH值');
INSERT INTO `backwardandreason` VALUES ('586', '120', 'DO', '1', '不足', '增加曝气量');

-- ----------------------------
-- Table structure for `backwardandresult`
-- ----------------------------
DROP TABLE IF EXISTS `backwardandresult`;
CREATE TABLE `backwardandresult` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bid` int(10) NOT NULL,
  `nouns` varchar(255) NOT NULL,
  `cf_result` float NOT NULL DEFAULT '1',
  `verb` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFBAE5431DB7478BC` (`bid`),
  CONSTRAINT `FKFBAE5431DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandresult
-- ----------------------------
INSERT INTO `backwardandresult` VALUES ('4', '4', '生化池系列1(1号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('5', '5', '生化池系列1(1号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('6', '6', '生化池系列1(2号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('7', '7', '生化池系列1(2号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('8', '8', '生化池系列2(3号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('9', '9', '生化池系列2(3号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('10', '10', '生化池系列2(4号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('11', '11', '生化池系列2(4号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('12', '12', '生化池系列3(5号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('13', '13', '生化池系列3(6号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('14', '14', '生化池系列4(7号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('15', '15', '生化池系列4(8号生化池)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('16', '16', '生化池系列3(5号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('17', '17', '生化池系列3(6号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('18', '18', '生化池系列4(7号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('19', '19', '生化池系列4(8号生化池)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('20', '20', '生化池系列1(1号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('21', '21', '生化池系列1(2号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('22', '22', '生化池系列2(3号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('23', '23', '生化池系列2(4号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('24', '24', '生化池系列3(5号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('25', '25', '生化池系列3(6号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('26', '26', '生化池系列4(7号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('27', '27', '生化池系列4(8号生化池)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('28', '28', '生化池系列1(1号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('29', '29', '生化池系列1(2号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('30', '30', '生化池系列2(3号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('31', '31', '生化池系列2(4号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('32', '32', '生化池系列3(5号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('33', '33', '生化池系列3(6号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('34', '34', '生化池系列4(7号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('35', '35', '生化池系列4(8号生化池)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('36', '36', '生化池系列1(1号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('37', '37', '生化池系列1(2号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('38', '38', '生化池系列2(3号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('39', '39', '生化池系列2(4号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('40', '40', '生化池系列3(5号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('41', '41', '生化池系列3(6号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('42', '42', '生化池系列4(7号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('43', '43', '生化池系列4(8号生化池)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('46', '46', '排江出口线PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('47', '47', '排江出口线PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('48', '48', '排江出口线COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('49', '49', '排江出口线BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('50', '50', '排江出口线NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('51', '51', '稳流池(477)进水PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('52', '52', '稳流池(477)进水PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('53', '53', '稳流池(477)进水COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('54', '54', '稳流池(477)进水BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('55', '55', '稳流池(477)进水SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('56', '56', '稳流池(477)进水NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('65', '65', '初沉池(489B)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('66', '66', '初沉池(489B)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('67', '67', '初沉池(489B)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('68', '68', '初沉池(489B)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('69', '69', '初沉池(489B)SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('70', '70', '初沉池(489B)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('71', '71', '事故池(489)PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('72', '72', '事故池(489)PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('73', '73', '事故池(489)COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('74', '74', '事故池(489)BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('75', '75', '事故池(489)SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('76', '76', '事故池(489)NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('77', '77', '老水解酸化池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('78', '78', '老水解酸化池PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('79', '79', '新水解酸化池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('80', '80', '新水解酸化池PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('81', '81', '老水解酸化池COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('82', '82', '新水解酸化池COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('83', '83', '老水解酸化池碱度', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('84', '84', '新水解酸化池碱度', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('85', '85', '新水解酸化池BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('86', '86', '老水解酸化池SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('87', '87', '新水解酸化池SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('88', '88', '老水解酸化池NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('89', '89', '1系列二沉池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('91', '91', '1系列二沉池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('92', '92', '1系列二沉池PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('93', '93', '1系列二沉池COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('94', '94', '1系列二沉池BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('95', '95', '1系列二沉池SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('96', '96', '1系列二沉池NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('97', '97', '2系列二沉池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('98', '98', '2系列二沉池COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('99', '99', '2系列二沉池BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('100', '100', '2系列二沉池SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('101', '101', '2系列二沉池NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('102', '102', '3系列二沉池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('103', '103', '3系列二沉池PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('104', '104', '3系列二沉池COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('105', '105', '3系列二沉池BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('106', '106', '3系列二沉池SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('107', '107', '3系列二沉池NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('108', '108', '4系列二沉池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('109', '109', '4系列二沉池PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('110', '110', '4系列二沉池COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('111', '111', '4系列二沉池BOD5', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('112', '112', '4系列二沉池SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('113', '113', '4系列二沉池NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('114', '114', '接触氧化池PH', '0', '过低', null);
INSERT INTO `backwardandresult` VALUES ('115', '115', '接触氧化池PH', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('116', '116', '接触氧化池COD', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('117', '117', '接触氧化池SS', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('119', '119', '接触氧化池NH3-N', '0', '过高', null);
INSERT INTO `backwardandresult` VALUES ('120', '120', '接触氧化池BOD5', '0', '过高', null);

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
  `isok` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdata
-- ----------------------------
INSERT INTO `dcsdata` VALUES ('6', '生化池系列1(1号生化池)', 'COD', '10', '3');
INSERT INTO `dcsdata` VALUES ('11', '生化池系列1(1号生化池)', '班次', '0', null);
INSERT INTO `dcsdata` VALUES ('7', '生化池系列2(3号生化池)', '班次', '0', null);
INSERT INTO `dcsdata` VALUES ('8', '生化池系列2(3号生化池)', 'PH', '10', '3');
INSERT INTO `dcsdata` VALUES ('12', '生化池系列1(1号生化池)', '鼓风机风量', '30', '3');
INSERT INTO `dcsdata` VALUES ('13', '生化池系列4(7号生化池)', '班次', '0', null);
INSERT INTO `dcsdata` VALUES ('14', '生化池系列4(8号生化池)', 'PH', '9.6', '0');

-- ----------------------------
-- Table structure for `dcsdataindex`
-- ----------------------------
DROP TABLE IF EXISTS `dcsdataindex`;
CREATE TABLE `dcsdataindex` (
  `seqno` varchar(20) NOT NULL DEFAULT '',
  `update_date` char(10) DEFAULT NULL,
  `update_time` char(8) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdataindex
-- ----------------------------

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
  `lower1` double NOT NULL,
  `lower2` double NOT NULL,
  `upper1` double NOT NULL,
  `upper2` double NOT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=1492 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdscrib
-- ----------------------------
INSERT INTO `dcsdscrib` VALUES ('1412', '稳流池(477)进水', 'PH', '6', '稳流池(477)进水PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1413', '稳流池(477)进水', 'COD', '0', '稳流池(477)进水COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1414', '稳流池(477)进水', 'COD', '0', '稳流池(477)进水COD', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1415', '稳流池(477)进水', 'SS', '0', '稳流池(477)进水SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1416', '稳流池(477)进水', 'NH3-N', '0', '稳流池(477)进水NH3-N', '15', '0', '0', '20', '50');
INSERT INTO `dcsdscrib` VALUES ('1417', '初沉池(489B)', 'PH', '6', '初沉池(489B)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1418', '初沉池(489B)', 'COD', '0', '初沉池(489B)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1419', '初沉池(489B)', 'BOD5', '0', '初沉池(489B)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1420', '初沉池(489B)', 'SS', '0', '初沉池(489B)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1421', '初沉池(489B)', 'NH3-N', '0', '初沉池(489B)NH3-N', '15', '0', '0', '20', '50');
INSERT INTO `dcsdscrib` VALUES ('1422', '事故池(489)', 'PH', '6', '事故池(489)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1423', '事故池(489)', 'COD', '0', '事故池(489)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1424', '事故池(489)', 'BOD5', '0', '事故池(489)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1425', '事故池(489)', 'SS', '0', '事故池(489)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1426', '事故池(489)', 'NH3-N', '0', '事故池(489)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1427', '老水解酸化池 ', 'A段溶解氧', '6', '老水解酸化池 A段溶解氧', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1428', '老水解酸化池 ', 'COD', '0', '老水解酸化池 COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1429', '老水解酸化池 ', 'BOD5', '0', '老水解酸化池 BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1430', '老水解酸化池 ', 'SS', '0', '老水解酸化池 SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1431', '老水解酸化池 ', 'NH3-N', '0', '老水解酸化池 NH3-N', '15', '0', '0', '20', '50');
INSERT INTO `dcsdscrib` VALUES ('1432', '新水解酸化池 ', 'PH', '6', '新水解酸化池 PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1433', '新水解酸化池 ', 'COD', '0', '新水解酸化池 COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1434', '新水解酸化池 ', 'BOD5', '0', '新水解酸化池 BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1435', '新水解酸化池 ', 'SS', '0', '新水解酸化池 SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1436', '新水解酸化池 ', 'NH3-N', '0', '新水解酸化池 NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1437', '生化池系列1(1号生化池)', 'PH', '6', '生化池系列1(1号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1438', '生化池系列1(1号生化池)', 'COD', '0', '生化池系列1(1号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1439', '生化池系列1(1号生化池)', 'BOD5', '0', '生化池系列1(1号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1440', '生化池系列1(1号生化池)', 'SS', '0', '生化池系列1(1号生化池)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1441', '生化池系列1(1号生化池)', 'NH3-N', '0', '生化池系列1(1号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1442', '生化池系列1(2号生化池)', 'PH', '6', '生化池系列1(2号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1443', '生化池系列1(2号生化池)', 'COD', '0', '生化池系列1(2号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1444', '生化池系列1(2号生化池)', 'BOD5', '0', '生化池系列1(2号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1445', '生化池系列1(2号生化池)', 'SS', '0', '生化池系列1(2号生化池)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1446', '生化池系列1(2号生化池)', 'NH3-N', '0', '生化池系列1(2号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1447', '生化池系列2(3号生化池)', 'PH', '6', '生化池系列2(3号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1448', '生化池系列2(3号生化池)', 'PH', '6', '生化池系列2(3号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1449', '生化池系列2(3号生化池)', 'COD', '0', '生化池系列2(3号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1450', '生化池系列2(3号生化池)', 'BOD5', '0', '生化池系列2(3号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1451', '生化池系列2(3号生化池)', 'SS', '0', '生化池系列2(3号生化池)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1452', '生化池系列2(3号生化池)', 'NH3-N', '0', '生化池系列2(3号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1453', '生化池系列2(4号生化池)', 'PH', '6', '生化池系列2(4号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1454', '生化池系列2(4号生化池)', 'COD', '0', '生化池系列2(4号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1455', '生化池系列2(4号生化池)', 'BOD5', '0', '生化池系列2(4号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1456', '生化池系列2(4号生化池)', 'SS', '0', '生化池系列2(4号生化池)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1457', '生化池系列2(4号生化池)', 'NH3-N', '0', '生化池系列2(4号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1458', '生化池系列3(5号生化池)', 'PH', '6', '生化池系列3(5号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1459', '生化池系列3(5号生化池)', 'COD', '0', '生化池系列3(5号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1460', '生化池系列3(5号生化池)', 'BOD5', '0', '生化池系列3(5号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1461', '生化池系列3(5号生化池)', 'SS', '0', '生化池系列3(5号生化池)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1462', '生化池系列3(5号生化池)', 'NH3-N', '0', '生化池系列3(5号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1463', '生化池系列3(6号生化池)', 'PH', '6', '生化池系列3(6号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1464', '生化池系列3(6号生化池)', 'COD', '0', '生化池系列3(6号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1465', '生化池系列3(6号生化池)', 'BOD5', '0', '生化池系列3(6号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1466', '生化池系列3(6号生化池)', 'SS', '0', '生化池系列3(6号生化池)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1467', '生化池系列3(6号生化池)', 'NH3-N', '0', '生化池系列3(6号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1468', '生化池系列4(7号生化池)', 'PH', '6', '生化池系列4(7号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1469', '生化池系列4(7号生化池)', 'COD', '0', '生化池系列4(7号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1470', '生化池系列4(7号生化池)', 'BOD5', '0', '生化池系列4(7号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1471', '生化池系列4(7号生化池)', 'NH3-N', '0', '生化池系列4(7号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1472', '生化池系列4(8号生化池)', 'PH', '6', '生化池系列4(8号生化池)PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1473', '生化池系列4(8号生化池)', 'COD', '0', '生化池系列4(8号生化池)COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1474', '生化池系列4(8号生化池)', 'BOD5', '0', '生化池系列4(8号生化池)BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1475', '生化池系列4(8号生化池)', 'SS', '0', '生化池系列4(8号生化池)SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1476', '生化池系列4(8号生化池)', 'NH3-N', '0', '生化池系列4(8号生化池)NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1477', '接触氧化池 ', 'PH', '6', '接触氧化池 PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1478', '接触氧化池 ', 'COD', '0', '接触氧化池 COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1479', '接触氧化池 ', 'BOD5', '0', '接触氧化池 BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1480', '接触氧化池 ', 'SS', '0', '接触氧化池 SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1481', '接触氧化池 ', 'NH3-N', '0', '接触氧化池 NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1482', '排江出口线', 'PH', '6', '排江出口线PH', '9', '4', '2', '11', '13');
INSERT INTO `dcsdscrib` VALUES ('1483', '排江出口线', 'COD', '0', '排江出口线COD', '120', '0', '0', '150', '180');
INSERT INTO `dcsdscrib` VALUES ('1484', '排江出口线', 'BOD5', '0', '排江出口线BOD5', '30', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1485', '排江出口线', 'SS', '0', '排江出口线SS', '70', '0', '0', '100', '130');
INSERT INTO `dcsdscrib` VALUES ('1486', '排江出口线', 'NH3-N', '0', '排江出口线NH3-N', '15', '0', '0', '50', '100');
INSERT INTO `dcsdscrib` VALUES ('1491', '生化池系列4(7号生化池)', '4段溶解氧', '1', '生化池系列4(7号生化池)4段溶解氧', '2', '0.2', '0', '2.2', '3');

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
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcshistory
-- ----------------------------
INSERT INTO `dcshistory` VALUES ('1', '生化池系列1(1号生化池)', '班次', '2012-01-07 23:11:33', '0');
INSERT INTO `dcshistory` VALUES ('2', '生化池系列1(1号生化池)', '鼓风机风量', '2012-01-07', '60');
INSERT INTO `dcshistory` VALUES ('3', '生化池系列1(1号生化池)', '班次', '2012-01-07 23:14:03', '0');
INSERT INTO `dcshistory` VALUES ('4', '生化池系列1(1号生化池)', 'PH', '2012-01-07', '2');
INSERT INTO `dcshistory` VALUES ('5', '生化池系列1(1号生化池)', '班次', '2012-01-07 23:16:58', '0');
INSERT INTO `dcshistory` VALUES ('6', '生化池系列1(1号生化池)', 'COD', '2012-01-07', '10');
INSERT INTO `dcshistory` VALUES ('7', '生化池系列2(3号生化池)', '班次', '2012-01-07 23:19:42', '0');
INSERT INTO `dcshistory` VALUES ('8', '生化池系列2(3号生化池)', 'PH', '2012-01-07', '10');
INSERT INTO `dcshistory` VALUES ('9', '生化池系列1(1号生化池)', '班次', '2012-01-07 23:27:22', '0');
INSERT INTO `dcshistory` VALUES ('10', '生化池系列1(1号生化池)', '鼓风机风量', '2012-01-07', '60');
INSERT INTO `dcshistory` VALUES ('11', '生化池系列1(1号生化池)', '班次', '2012-01-07 23:27:41', '0');
INSERT INTO `dcshistory` VALUES ('12', '生化池系列1(1号生化池)', '鼓风机风量', '2012-01-07', '30');
INSERT INTO `dcshistory` VALUES ('13', '生化池系列4(7号生化池)', '班次', '2012-01-07 23:53:34', '0');
INSERT INTO `dcshistory` VALUES ('14', '生化池系列4(8号生化池)', 'PH', '2012-01-07', '9.6');

-- ----------------------------
-- Table structure for `dcs_data`
-- ----------------------------
DROP TABLE IF EXISTS `dcs_data`;
CREATE TABLE `dcs_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `isok` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcs_data
-- ----------------------------

-- ----------------------------
-- Table structure for `dcs_history`
-- ----------------------------
DROP TABLE IF EXISTS `dcs_history`;
CREATE TABLE `dcs_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `seqno` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcs_history
-- ----------------------------

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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_advice
-- ----------------------------
INSERT INTO `dss_advice` VALUES ('2', null, null, '一切正常', '22.660000', null, null, null);

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
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_history
-- ----------------------------
INSERT INTO `dss_history` VALUES ('1', '', '5', '20111218123004', '           32.560000', '', '37.00377', 'w76.TIR203');

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
  `wrong` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of errorlog
-- ----------------------------
INSERT INTO `errorlog` VALUES ('1', '生化池系列1(1号生化池)', '鼓风机风量', '5', '2012-01-07 23:11:33', '60', null, null, '过高');
INSERT INTO `errorlog` VALUES ('2', '生化池系列1(1号生化池)', 'PH', '8', '2012-01-07 23:14:03', '2', '酸水的流量增大;酸水的酸度增加;碱液管线堵塞;碱液碱度低;仪表指示不准;PH指示表损坏;;', '增加碱液投加量;增加碱液投加量;及时清通，必要时断管逐渐清通;增加两台碱液泵运行;用PH试纸实测;找仪表人员处理，恢复正常;调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障;', '过低');
INSERT INTO `errorlog` VALUES ('3', '生化池系列1(1号生化池)', 'COD', '12', '2012-01-07 23:16:58', '10', '进水有机物浓度高;污泥浓度低;污泥沉降性、絮凝性差差;DO不足;水质冲击有毒物质进入;', '调整降低进水浓度;增加回流比;降低进水浓度；增加曝气量；提高水温；提高进水pH值;增加曝气量;检查进水;', '过高');
INSERT INTO `errorlog` VALUES ('4', '生化池系列2(3号生化池)', 'PH', '9', '2012-01-07 23:19:42', '10', ';', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）;', '过高');
INSERT INTO `errorlog` VALUES ('5', '生化池系列1(1号生化池)', '鼓风机风量', '5', '2012-01-07 23:27:22', '60', null, null, '过高');
INSERT INTO `errorlog` VALUES ('6', '生化池系列4(8号生化池)', 'PH', '7', '2012-01-07 23:53:34', '9.6', ';', '调整进水PH值，增加碱液投加量，查找碱液投加装置是否出现故障;', '过高');

-- ----------------------------
-- Table structure for `error_log`
-- ----------------------------
DROP TABLE IF EXISTS `error_log`;
CREATE TABLE `error_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `error` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `wrong` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of error_log
-- ----------------------------

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
  `id` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of init_predict
-- ----------------------------
INSERT INTO `init_predict` VALUES ('w1.BOD5', '染料厂酸水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w1.COD', '染料厂酸水.COD', null);
INSERT INTO `init_predict` VALUES ('w1.NH3-N', '染料厂酸水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w1.PH', '染料厂酸水.PH', null);
INSERT INTO `init_predict` VALUES ('w1.Q', '染料厂酸水.水量', null);
INSERT INTO `init_predict` VALUES ('w1.SS', '染料厂酸水.SS', null);
INSERT INTO `init_predict` VALUES ('w10.BOD5', '铁运489沉淀池出水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w10.COD', '铁运489沉淀池出水.COD', null);
INSERT INTO `init_predict` VALUES ('w10.NH3-N', '铁运489沉淀池出水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w10.PH', '铁运489沉淀池出水.PH', null);
INSERT INTO `init_predict` VALUES ('w10.Q', '铁运489沉淀池出水.水量', null);
INSERT INTO `init_predict` VALUES ('w10.SS', '铁运489沉淀池出水.SS', null);
INSERT INTO `init_predict` VALUES ('w11.BOD5', '含氮废水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w11.COD', '含氮废水.COD', null);
INSERT INTO `init_predict` VALUES ('w11.NH3-N', '含氮废水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w11.PH', '含氮废水.PH', null);
INSERT INTO `init_predict` VALUES ('w11.Q', '含氮废水.水量', null);
INSERT INTO `init_predict` VALUES ('w11.SS', '含氮废水.SS', null);
INSERT INTO `init_predict` VALUES ('w12.BOD5', '103厂碱水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w12.COD', '103厂碱水.COD', null);
INSERT INTO `init_predict` VALUES ('w12.NH3-N', '103厂碱水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w12.PH', '103厂碱水.PH', null);
INSERT INTO `init_predict` VALUES ('w12.Q', '103厂碱水.水量', null);
INSERT INTO `init_predict` VALUES ('w12.SS', '103厂碱水.SS', null);
INSERT INTO `init_predict` VALUES ('w13.BOD5', '化肥厂丁辛醇.BOD5', null);
INSERT INTO `init_predict` VALUES ('w13.COD', '化肥厂丁辛醇.COD', null);
INSERT INTO `init_predict` VALUES ('w13.NH3-N', '化肥厂丁辛醇.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w13.PH', '化肥厂丁辛醇.PH', null);
INSERT INTO `init_predict` VALUES ('w13.Q', '化肥厂丁辛醇.水量', null);
INSERT INTO `init_predict` VALUES ('w13.SS', '化肥厂丁辛醇.SS', null);
INSERT INTO `init_predict` VALUES ('w14.BOD5', '丙烯腈废水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w14.COD', '丙烯腈废水.COD', null);
INSERT INTO `init_predict` VALUES ('w14.NH3-N', '丙烯腈废水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w14.PH', '丙烯腈废水.PH', null);
INSERT INTO `init_predict` VALUES ('w14.Q', '丙烯腈废水.水量', null);
INSERT INTO `init_predict` VALUES ('w14.SS', '丙烯腈废水.SS', null);
INSERT INTO `init_predict` VALUES ('w15.BOD5', '合成树脂厂有机水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w15.COD', '合成树脂厂有机水.COD', null);
INSERT INTO `init_predict` VALUES ('w15.NH3-N', '合成树脂厂有机水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w15.PH', '合成树脂厂有机水.PH', null);
INSERT INTO `init_predict` VALUES ('w15.Q', '合成树脂厂有机水.水量', null);
INSERT INTO `init_predict` VALUES ('w15.SS', '合成树脂厂有机水.SS', null);
INSERT INTO `init_predict` VALUES ('w16.BOD5', '龙潭区生活水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w16.COD', '龙潭区生活水.COD', null);
INSERT INTO `init_predict` VALUES ('w16.NH3-N', '龙潭区生活水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w16.PH', '龙潭区生活水.PH', null);
INSERT INTO `init_predict` VALUES ('w16.Q', '龙潭区生活水.水量', null);
INSERT INTO `init_predict` VALUES ('w16.SS', '龙潭区生活水.SS', null);
INSERT INTO `init_predict` VALUES ('w2.BOD5', '电石厂酸水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w2.COD', '电石厂酸水.COD', null);
INSERT INTO `init_predict` VALUES ('w2.NH3-N', '电石厂酸水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w2.PH', '电石厂酸水.PH', null);
INSERT INTO `init_predict` VALUES ('w2.Q', '电石厂酸水.水量', null);
INSERT INTO `init_predict` VALUES ('w2.SS', '电石厂酸水.SS', null);
INSERT INTO `init_predict` VALUES ('w3.BOD5', '电石厂有机水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w3.COD', '电石厂有机水.COD', null);
INSERT INTO `init_predict` VALUES ('w3.NH3-N', '电石厂有机水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w3.PH', '电石厂有机水.PH', null);
INSERT INTO `init_predict` VALUES ('w3.Q', '电石厂有机水.水量', null);
INSERT INTO `init_predict` VALUES ('w3.SS', '电石厂有机水.SS', null);
INSERT INTO `init_predict` VALUES ('w4.BOD5', '有机合成厂有机水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w4.COD', '有机合成厂有机水.COD', null);
INSERT INTO `init_predict` VALUES ('w4.NH3-N', '有机合成厂有机水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w4.PH', '有机合成厂有机水.PH', null);
INSERT INTO `init_predict` VALUES ('w4.Q', '有机合成厂有机水.水量', null);
INSERT INTO `init_predict` VALUES ('w4.SS', '有机合成厂有机水.SS', null);
INSERT INTO `init_predict` VALUES ('w5.BOD5', '炼油厂有机水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w5.COD', '炼油厂有机水.COD', null);
INSERT INTO `init_predict` VALUES ('w5.NH3-N', '炼油厂有机水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w5.PH', '炼油厂有机水.PH', null);
INSERT INTO `init_predict` VALUES ('w5.Q', '炼油厂有机水.水量', null);
INSERT INTO `init_predict` VALUES ('w5.SS', '炼油厂有机水.SS', null);
INSERT INTO `init_predict` VALUES ('w6.BOD5', '精细化工厂废水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w6.COD', '精细化工厂废水.COD', null);
INSERT INTO `init_predict` VALUES ('w6.NH3-N', '精细化工厂废水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w6.PH', '精细化工厂废水.PH', null);
INSERT INTO `init_predict` VALUES ('w6.Q', '精细化工厂废水.水量', null);
INSERT INTO `init_predict` VALUES ('w6.SS', '精细化工厂废水.SS', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA101', '进水提升泵房(462A).COD', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA102', '进水提升泵房(462A).NH3-N', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA107', '进水提升泵房(462A).PH', null);
INSERT INTO `init_predict` VALUES ('w62.AIRA108', '进水提升泵房(462A).SS', null);
INSERT INTO `init_predict` VALUES ('w62.LDISA101', '进水提升泵房(462A).1号粗格栅前后液位差', null);
INSERT INTO `init_predict` VALUES ('w62.LDISA102', '进水提升泵房(462A).2号粗格栅前后液位差', null);
INSERT INTO `init_predict` VALUES ('w62.LDISA103', '进水提升泵房(462A).3号粗格栅前后液位差', null);
INSERT INTO `init_predict` VALUES ('w62.LISA104', '进水提升泵房(462A).液位', null);
INSERT INTO `init_predict` VALUES ('w62.P1STATUS', '进水提升泵房(462A).1号潜水排污泵状态', null);
INSERT INTO `init_predict` VALUES ('w62.P2STATUS', '进水提升泵房(462A).2号潜水排污泵状态', null);
INSERT INTO `init_predict` VALUES ('w62.P3STATUS', '进水提升泵房(462A).3号潜水排污泵状态', null);
INSERT INTO `init_predict` VALUES ('w62.P4STATUS', '进水提升泵房(462A).4号潜水排污泵状态', null);
INSERT INTO `init_predict` VALUES ('w62.P5STATUS5', '进水提升泵房(462A).5号潜水排污泵状态', null);
INSERT INTO `init_predict` VALUES ('w63.FR101', '巴氏计量槽(499).水量', null);
INSERT INTO `init_predict` VALUES ('w63.LIR106', '巴氏计量槽(499).前液位', null);
INSERT INTO `init_predict` VALUES ('w63.LIR107', '巴氏计量槽(499).后液位', null);
INSERT INTO `init_predict` VALUES ('w65.M4881', '沉沙刮沙池(488).M488-1号刮沙机', null);
INSERT INTO `init_predict` VALUES ('w65.M4882', '沉沙刮沙池(488).M488-2号刮沙机', null);
INSERT INTO `init_predict` VALUES ('w65.M4883', '沉沙刮沙池(488).M488-3号刮沙机', null);
INSERT INTO `init_predict` VALUES ('w65.M4884', '沉沙刮沙池(488).M488-4号刮沙机', null);
INSERT INTO `init_predict` VALUES ('w66.M4891S', '初沉池(489B).M489-1号周边传动刮泥机', null);
INSERT INTO `init_predict` VALUES ('w66.M4892S', '初沉池(489B).M489-2号周边传动刮泥机', null);
INSERT INTO `init_predict` VALUES ('w66.M4893S', '初沉池(489B).M489-3号周边传动刮泥机', null);
INSERT INTO `init_predict` VALUES ('w69.LIA114', '老水解酸化池.液位', null);
INSERT INTO `init_predict` VALUES ('w7.BOD5', '乙二醇废水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w7.COD', '乙二醇废水.COD', null);
INSERT INTO `init_predict` VALUES ('w7.NH3-N', '乙二醇废水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w7.PH', '乙二醇废水.PH', null);
INSERT INTO `init_predict` VALUES ('w7.Q', '乙二醇废水.水量', null);
INSERT INTO `init_predict` VALUES ('w7.SS', '乙二醇废水.SS', null);
INSERT INTO `init_predict` VALUES ('w70.LIA115', '新水解酸化池.液位', null);
INSERT INTO `init_predict` VALUES ('w71.FRQ103', '污泥泵房(466).P466-1-2泵出口干管流量', null);
INSERT INTO `init_predict` VALUES ('w71.FRQ104', '污泥泵房(466).P466-3-4泵出口干管流量', null);
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
INSERT INTO `init_predict` VALUES ('w73.R4951', '脱水装置(495).1号带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4952', '脱水装置(495).2号带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4953', '脱水装置(495).3号带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4954', '脱水装置(495).4号带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w73.R4955', '脱水装置(495).5号带式压榨过滤机状态', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA103', '中间提升泵房(462B).COD', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA104', '中间提升泵房(462B).NH3-N', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA105', '中间提升泵房(462B).SS', null);
INSERT INTO `init_predict` VALUES ('w74.AIRA106', '中间提升泵房(462B).PH', null);
INSERT INTO `init_predict` VALUES ('w74.LIS117', '中间提升泵房(462B).V462B-3高位水池液位', null);
INSERT INTO `init_predict` VALUES ('w74.LISA116', '中间提升泵房(462B).吸水池液位', null);
INSERT INTO `init_predict` VALUES ('w74.LISA118', '中间提升泵房(462B).药剂池液位', null);
INSERT INTO `init_predict` VALUES ('w74.P462B-10', '中间提升泵房(462B).药剂泵状态', null);
INSERT INTO `init_predict` VALUES ('w74.P462B-9', '中间提升泵房(462B).药剂泵状态', null);
INSERT INTO `init_predict` VALUES ('w75.AIR209', '生化池系列1(1号生化池).3段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w75.AIR210', '生化池系列1(2号生化池).3段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w75.AIR229', '生化池系列1(1号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w75.AIR230', '生化池系列1(2号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC205', '生化池系列1(1号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC206', '生化池系列1(2号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC213', '生化池系列1(1号生化池).5段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w75.AIRC214', '生化池系列1(2号生化池).5段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w75.FR601A', '生化池系列1(1号生化池).鼓风机风量', null);
INSERT INTO `init_predict` VALUES ('w75.TIR201', '生化池系列1(1号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w75.TIR202', '生化池系列1(2号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w76.AIR231', '生化池系列2(3号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w76.AIR232', '生化池系列2(4号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC207', '生化池系列2(3号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC208', '生化池系列2(4号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC211', '生化池系列2(3号生化池).3段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC212', '生化池系列2(4号生化池).3段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC215', '生化池系列2(3号生化池).5段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w76.AIRC216', '生化池系列2(4号生化池).5段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w76.FR601B', '生化池系列2(3号生化池).鼓风机分量', null);
INSERT INTO `init_predict` VALUES ('w76.TIR203', '生化池系列2(3号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w76.TIR204', '生化池系列2(4号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w77.AIR201', '生化池系列3(5号生化池).A段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.AIR202', '生化池系列3(6号生化池).A段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.AIR233', '生化池系列3(5号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w77.AIR234', '生化池系列3(6号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC217', '生化池系列3(5号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC218', '生化池系列3(6号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC221', '生化池系列3(5号生化池).4段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC222', '生化池系列3(6号生化池).4段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC225', '生化池系列3(5号生化池).6段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.AIRC226', '生化池系列3(6号生化池).6段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w77.FR601C', '生化池系列3(5号生化池).鼓风机分量', null);
INSERT INTO `init_predict` VALUES ('w77.TIR205', '生化池系列3(5号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w77.TIR206', '生化池系列3(6号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w78.AIR203', '生化池系列4(7号生化池).A段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.AIR204', '生化池系列4(8号生化池).A段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.AIR235', '生化池系列4(7号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w78.AIR236', '生化池系列4(8号生化池).PH', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC219', '生化池系列4(7号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC220', '生化池系列4(8号生化池).2段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC223', '生化池系列4(7号生化池).4段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC224', '生化池系列4(8号生化池).4段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC227', '生化池系列4(7号生化池).6段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.AIRC228', '生化池系列4(8号生化池).6段溶解氧', null);
INSERT INTO `init_predict` VALUES ('w78.FR601B', '生化池系列4(7号生化池).鼓风机分量', null);
INSERT INTO `init_predict` VALUES ('w78.TIR207', '生化池系列4(7号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w78.TIR208', '生化池系列4(8号生化池).温度', null);
INSERT INTO `init_predict` VALUES ('w8.BOD5', '环氧乙烷废水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w8.COD', '环氧乙烷废水.COD', null);
INSERT INTO `init_predict` VALUES ('w8.NH3-N', '环氧乙烷废水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w8.PH', '环氧乙烷废水.PH', null);
INSERT INTO `init_predict` VALUES ('w8.Q', '环氧乙烷废水.水量', null);
INSERT INTO `init_predict` VALUES ('w8.SS', '环氧乙烷废水.SS', null);
INSERT INTO `init_predict` VALUES ('w83.BOD5\r\nw83.COD\r\nw83.NH3-N\r\nw83.PH\r\nw83.Q\r\nw83.SS\r\nw83.BOD5', '接触氧化池.BOD5', null);
INSERT INTO `init_predict` VALUES ('w83.COD', '接触氧化池.COD', null);
INSERT INTO `init_predict` VALUES ('w83.LIR803', '接触氧化池.1-3号池浓度', null);
INSERT INTO `init_predict` VALUES ('w83.LIR804', '接触氧化池.4-5号池浓度', null);
INSERT INTO `init_predict` VALUES ('w83.NH3-N', '接触氧化池.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w83.PH', '接触氧化池.PH', null);
INSERT INTO `init_predict` VALUES ('w83.Q', '接触氧化池.水量', null);
INSERT INTO `init_predict` VALUES ('w83.SS', '接触氧化池.SS', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA801', '排江出口线.PH', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA802', '排江出口线.SS', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA803', '排江出口线.COD', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA804', '排江出口线.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w85.AIRA805', '排江出口线.DO', null);
INSERT INTO `init_predict` VALUES ('w86.FRCQ201', '1系列465回流泵房.回流490A3量', null);
INSERT INTO `init_predict` VALUES ('w86.FRCQ202', '1系列465回流泵房.回流490A4量', null);
INSERT INTO `init_predict` VALUES ('w86.FRQ203', '1系列465回流泵房.剩余量', null);
INSERT INTO `init_predict` VALUES ('w86.LIA201', '1系列465回流泵房.吸泥池液位', null);
INSERT INTO `init_predict` VALUES ('w87.FRCQ204', '2系列465A回流泵房.回流量', null);
INSERT INTO `init_predict` VALUES ('w87.FRQ205', '2系列465A回流泵房.剩余量', null);
INSERT INTO `init_predict` VALUES ('w87.LISA202', '2系列465A回流泵房.吸泥池液位', null);
INSERT INTO `init_predict` VALUES ('w88.FRCQ206', '3系列465B回流泵房.回流量', null);
INSERT INTO `init_predict` VALUES ('w88.FRQ207', '3系列465B回流泵房.剩余量', null);
INSERT INTO `init_predict` VALUES ('w88.LISA203', '3系列465B回流泵房.吸泥池液位', null);
INSERT INTO `init_predict` VALUES ('w9.BOD5', '农药厂有机水.BOD5', null);
INSERT INTO `init_predict` VALUES ('w9.COD', '农药厂有机水.COD', null);
INSERT INTO `init_predict` VALUES ('w9.NH3-N', '农药厂有机水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('w9.PH', '农药厂有机水.PH', null);
INSERT INTO `init_predict` VALUES ('w9.Q', '农药厂有机水.水量', null);
INSERT INTO `init_predict` VALUES ('w9.SS', '农药厂有机水.SS', null);
INSERT INTO `init_predict` VALUES ('WW14A.BOD5', '14A生活水.BOD5', null);
INSERT INTO `init_predict` VALUES ('WW14A.COD', '14A生活水.COD', null);
INSERT INTO `init_predict` VALUES ('WW14A.NH3-N', '14A生活水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('WW14A.PH', '14A生活水.PH', null);
INSERT INTO `init_predict` VALUES ('WW14A.Q', '14A生活水.水量', null);
INSERT INTO `init_predict` VALUES ('WW14A.SS', '14A生活水.SS', null);
INSERT INTO `init_predict` VALUES ('WW14B.BOD5', '14B生活水.BOD5', null);
INSERT INTO `init_predict` VALUES ('WW14B.COD', '14B生活水.COD', null);
INSERT INTO `init_predict` VALUES ('WW14B.NH3-N', '14B生活水.NH3-N', null);
INSERT INTO `init_predict` VALUES ('WW14B.PH', '14B生活水.PH', null);
INSERT INTO `init_predict` VALUES ('WW14B.Q', '14B生活水.水量', null);
INSERT INTO `init_predict` VALUES ('WW14B.SS', '14B生活水.SS', null);

-- ----------------------------
-- Table structure for `itemdefinition`
-- ----------------------------
DROP TABLE IF EXISTS `itemdefinition`;
CREATE TABLE `itemdefinition` (
  `name` varchar(48) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  `unit` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemdefinition
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
-- Table structure for `motodcsdata`
-- ----------------------------
DROP TABLE IF EXISTS `motodcsdata`;
CREATE TABLE `motodcsdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `isok` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of motodcsdata
-- ----------------------------

-- ----------------------------
-- Table structure for `motodcshistory`
-- ----------------------------
DROP TABLE IF EXISTS `motodcshistory`;
CREATE TABLE `motodcshistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `seqno` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of motodcshistory
-- ----------------------------

-- ----------------------------
-- Table structure for `motoerrorlog`
-- ----------------------------
DROP TABLE IF EXISTS `motoerrorlog`;
CREATE TABLE `motoerrorlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment` varchar(255) DEFAULT NULL,
  `error` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `wrong` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of motoerrorlog
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
INSERT INTO `pre_dss` VALUES ('w77.AIR201', '3.35265E-5                                                      ', '           22.660000', '20120109133156', '1');
INSERT INTO `pre_dss` VALUES ('w77.AIR202', '3.35265E-5                                                      ', '           22.660000', '20120109133156', '2');
INSERT INTO `pre_dss` VALUES ('w78.AIR203', '3.3528646E-5                                                    ', '           22.660000', '20120109133156', '3');
INSERT INTO `pre_dss` VALUES ('w78.AIR204', '3.3528646E-5                                                    ', '           22.660000', '20120109133156', '4');
INSERT INTO `pre_dss` VALUES ('w86.FRCQ201', '1000.00006                                                      ', '           22.660000', '20120109133156', '5');
INSERT INTO `pre_dss` VALUES ('w86.FRCQ202', '1000.00006                                                      ', '           22.660000', '20120109133156', '6');
INSERT INTO `pre_dss` VALUES ('FRCQ203', '17.411297                                                       ', '           22.660000', '20120109133156', '7');
INSERT INTO `pre_dss` VALUES ('AIRC209', '2.9839644                                                       ', '           22.660000', '20120109133156', '8');
INSERT INTO `pre_dss` VALUES ('AIRC210', '2.9864707                                                       ', '           22.660000', '20120109133156', '9');
INSERT INTO `pre_dss` VALUES ('w76.AIRC211', '2.9845626                                                       ', '           22.660000', '20120109133156', '10');
INSERT INTO `pre_dss` VALUES ('w76.AIRC212', '2.9845626                                                       ', '           22.660000', '20120109133156', '11');
INSERT INTO `pre_dss` VALUES ('w75.AIRC213', '3.0067062                                                       ', '           22.660000', '20120109133156', '12');
INSERT INTO `pre_dss` VALUES ('w75.AIRC214', '2.9999928                                                       ', '           22.660000', '20120109133156', '13');
INSERT INTO `pre_dss` VALUES ('w76.AIRC215', '3.0067372                                                       ', '           22.660000', '20120109133156', '14');
INSERT INTO `pre_dss` VALUES ('w76.AIRC216', '2.9999926                                                       ', '           22.660000', '20120109133156', '15');
INSERT INTO `pre_dss` VALUES ('w78.AIRC223', '2.9836617                                                       ', '           22.660000', '20120109133156', '16');
INSERT INTO `pre_dss` VALUES ('w77.AIRC221', '2.999065                                                        ', '           22.660000', '20120109133156', '17');
INSERT INTO `pre_dss` VALUES ('w77.AIRC222', '2.999065                                                        ', '           22.660000', '20120109133156', '18');
INSERT INTO `pre_dss` VALUES ('w78.AIRC224', '2.9836617                                                       ', '           22.660000', '20120109133156', '19');
INSERT INTO `pre_dss` VALUES ('w77.AIRC225', '3.00001                                                         ', '           22.660000', '20120109133156', '20');
INSERT INTO `pre_dss` VALUES ('w77.AIRC226', '3.00001                                                         ', '           22.660000', '20120109133156', '21');
INSERT INTO `pre_dss` VALUES ('w78.AIRC227', '2.9875789                                                       ', '           22.660000', '20120109133156', '22');
INSERT INTO `pre_dss` VALUES ('w78.AIRC228', '2.9875789                                                       ', '           22.660000', '20120109133156', '23');
INSERT INTO `pre_dss` VALUES ('w75.AIRC205', '2.8910334                                                       ', '           22.660000', '20120109133156', '24');
INSERT INTO `pre_dss` VALUES ('w75.AIRC206', '2.9999957                                                       ', '           22.660000', '20120109133156', '25');
INSERT INTO `pre_dss` VALUES ('w76.AIRC207', '2.935241                                                        ', '           22.660000', '20120109133156', '26');
INSERT INTO `pre_dss` VALUES ('w76.AIRC208', '2.935241                                                        ', '           22.660000', '20120109133156', '27');
INSERT INTO `pre_dss` VALUES ('w77.AIRC217', '2.876425                                                        ', '           22.660000', '20120109133156', '28');
INSERT INTO `pre_dss` VALUES ('w77.AIRC218', '2.876425                                                        ', '           22.660000', '20120109133156', '29');
INSERT INTO `pre_dss` VALUES ('w78.AIRC219', '2.8764348                                                       ', '           22.660000', '20120109133156', '30');
INSERT INTO `pre_dss` VALUES ('w78.AIRC220', '2.8764348                                                       ', '           22.660000', '20120109133156', '31');
INSERT INTO `pre_dss` VALUES ('w87.FRCQ204', '1497.2356                                                       ', '           22.660000', '20120109133156', '32');
INSERT INTO `pre_dss` VALUES ('w88.FRCQ206', '1497.2734                                                       ', '           22.660000', '20120109133156', '33');
INSERT INTO `pre_dss` VALUES ('FI101', '525.00037                                                       ', '           22.660000', '20120109133156', '34');
INSERT INTO `pre_dss` VALUES ('FI103', '221.00035                                                       ', '           22.660000', '20120109133156', '35');
INSERT INTO `pre_dss` VALUES ('w62.LDISA101', '0.0                                                             ', '           22.660000', '20120109133156', '36');
INSERT INTO `pre_dss` VALUES ('w62.LDISA102', '0.0                                                             ', '           22.660000', '20120109133156', '37');
INSERT INTO `pre_dss` VALUES ('w62.LDISA103', '0.0                                                             ', '           22.660000', '20120109133156', '38');
INSERT INTO `pre_dss` VALUES ('w62.LISA104', '4.000001                                                        ', '           22.660000', '20120109133156', '39');
INSERT INTO `pre_dss` VALUES ('w62.AIRA101', '529.8328                                                        ', '           22.660000', '20120109133156', '40');
INSERT INTO `pre_dss` VALUES ('w62.AIRA102', '12.061142                                                       ', '           22.660000', '20120109133156', '41');
INSERT INTO `pre_dss` VALUES ('LDIR105', '0.0                                                             ', '           22.660000', '20120109133156', '42');
INSERT INTO `pre_dss` VALUES ('LI2101', '3.2904326E-9                                                    ', '           22.660000', '20120109133156', '43');
INSERT INTO `pre_dss` VALUES ('w63.LIR106', '7.0                                                             ', '           22.660000', '20120109133156', '44');
INSERT INTO `pre_dss` VALUES ('w63.LIR107', '7.0                                                             ', '           22.660000', '20120109133156', '45');
INSERT INTO `pre_dss` VALUES ('w63.FR101', '3067.9314                                                       ', '           22.660000', '20120109133156', '46');
INSERT INTO `pre_dss` VALUES ('FRQ101', '2394228.5                                                       ', '           22.660000', '20120109133156', '47');
INSERT INTO `pre_dss` VALUES ('LDISA108', '0.0                                                             ', '           22.660000', '20120109133156', '48');
INSERT INTO `pre_dss` VALUES ('LDISA109', '0.0                                                             ', '           22.660000', '20120109133156', '49');
INSERT INTO `pre_dss` VALUES ('LDISA110', '0.0                                                             ', '           22.660000', '20120109133156', '50');
INSERT INTO `pre_dss` VALUES ('LDISA111', '0.0                                                             ', '           22.660000', '20120109133156', '51');
INSERT INTO `pre_dss` VALUES ('LDISA112', '0.0                                                             ', '           22.660000', '20120109133156', '52');
INSERT INTO `pre_dss` VALUES ('LIA113', '50.0                                                            ', '           22.660000', '20120109133156', '53');
INSERT INTO `pre_dss` VALUES ('w69.LIA114', '6.9                                                             ', '           22.660000', '20120109133156', '54');
INSERT INTO `pre_dss` VALUES ('LISA115', '5.2000003                                                       ', '           22.660000', '20120109133156', '55');
INSERT INTO `pre_dss` VALUES ('w74.LISA116', '1.5                                                             ', '           22.660000', '20120109133156', '56');
INSERT INTO `pre_dss` VALUES ('w74.AIRA103', '443.24115                                                       ', '           22.660000', '20120109133156', '57');
INSERT INTO `pre_dss` VALUES ('w74.AIRA104', '19.471037                                                       ', '           22.660000', '20120109133156', '58');
INSERT INTO `pre_dss` VALUES ('AIR105', '119.87819                                                       ', '           22.660000', '20120109133156', '59');
INSERT INTO `pre_dss` VALUES ('w74.AIRA106', '7.0                                                             ', '           22.660000', '20120109133156', '60');
INSERT INTO `pre_dss` VALUES ('LIA117', '4.0                                                             ', '           22.660000', '20120109133156', '61');
INSERT INTO `pre_dss` VALUES ('w74.LISA118', '1.5                                                             ', '           22.660000', '20120109133156', '62');
INSERT INTO `pre_dss` VALUES ('w71.LISA119', '4.299991                                                        ', '           22.660000', '20120109133156', '63');
INSERT INTO `pre_dss` VALUES ('LISA120', '4.299991                                                        ', '           22.660000', '20120109133156', '64');
INSERT INTO `pre_dss` VALUES ('LISA121', '0.0                                                             ', '           22.660000', '20120109133156', '65');
INSERT INTO `pre_dss` VALUES ('w73.LISA122', '0.0                                                             ', '           22.660000', '20120109133156', '66');
INSERT INTO `pre_dss` VALUES ('w73.LISA123', '0.0                                                             ', '           22.660000', '20120109133156', '67');
INSERT INTO `pre_dss` VALUES ('w73.LISA124', '0.0                                                             ', '           22.660000', '20120109133156', '68');
INSERT INTO `pre_dss` VALUES ('LISA125', '0.0                                                             ', '           22.660000', '20120109133156', '69');
INSERT INTO `pre_dss` VALUES ('w73.FI106', '36.237938                                                       ', '           22.660000', '20120109133156', '70');
INSERT INTO `pre_dss` VALUES ('w73.FI107', '36.237938                                                       ', '           22.660000', '20120109133156', '71');
INSERT INTO `pre_dss` VALUES ('w73.FI108', '36.237938                                                       ', '           22.660000', '20120109133156', '72');
INSERT INTO `pre_dss` VALUES ('w73.FI109', '36.237938                                                       ', '           22.660000', '20120109133156', '73');
INSERT INTO `pre_dss` VALUES ('w73.FI110', '36.237938                                                       ', '           22.660000', '20120109133156', '74');
INSERT INTO `pre_dss` VALUES ('w73.FI111', '36.237938                                                       ', '           22.660000', '20120109133156', '75');
INSERT INTO `pre_dss` VALUES ('FRQ102', '1.0651123E7                                                     ', '           22.660000', '20120109133156', '76');
INSERT INTO `pre_dss` VALUES ('FR102', '1368.6163                                                       ', '           22.660000', '20120109133156', '77');
INSERT INTO `pre_dss` VALUES ('FR103', '108.76379                                                       ', '           22.660000', '20120109133156', '78');
INSERT INTO `pre_dss` VALUES ('w71.FRQ103', '550125.7                                                        ', '           22.660000', '20120109133156', '79');
INSERT INTO `pre_dss` VALUES ('FR104', '108.76379                                                       ', '           22.660000', '20120109133156', '80');
INSERT INTO `pre_dss` VALUES ('w71.FRQ104', '550127.6                                                        ', '           22.660000', '20120109133156', '81');
INSERT INTO `pre_dss` VALUES ('FR105', '0.0                                                             ', '           22.660000', '20120109133156', '82');
INSERT INTO `pre_dss` VALUES ('FRQ105', '0.0                                                             ', '           22.660000', '20120109133156', '83');
INSERT INTO `pre_dss` VALUES ('w62.AIRA107', '7.0                                                             ', '           22.660000', '20120109133156', '84');
INSERT INTO `pre_dss` VALUES ('TIA101', '25.0                                                            ', '           22.660000', '20120109133156', '85');
INSERT INTO `pre_dss` VALUES ('PI101', '0.2                                                             ', '           22.660000', '20120109133156', '86');
INSERT INTO `pre_dss` VALUES ('PIA102', '0.4                                                             ', '           22.660000', '20120109133156', '87');
INSERT INTO `pre_dss` VALUES ('PISA103', '0.0                                                             ', '           22.660000', '20120109133156', '88');
INSERT INTO `pre_dss` VALUES ('w75.AIR229', '7.0                                                             ', '           22.660000', '20120109133156', '89');
INSERT INTO `pre_dss` VALUES ('w75.AIR230', '7.0                                                             ', '           22.660000', '20120109133156', '90');
INSERT INTO `pre_dss` VALUES ('w76.AIR231', '7.0                                                             ', '           22.660000', '20120109133156', '91');
INSERT INTO `pre_dss` VALUES ('w76.AIR232', '7.0                                                             ', '           22.660000', '20120109133156', '92');
INSERT INTO `pre_dss` VALUES ('w77.AIR233', '7.0                                                             ', '           22.660000', '20120109133156', '93');
INSERT INTO `pre_dss` VALUES ('w77.AIR234', '7.0                                                             ', '           22.660000', '20120109133156', '94');
INSERT INTO `pre_dss` VALUES ('w78.AIR235', '7.0                                                             ', '           22.660000', '20120109133156', '95');
INSERT INTO `pre_dss` VALUES ('TI102', '37.14617                                                        ', '           22.660000', '20120109133156', '96');
INSERT INTO `pre_dss` VALUES ('w75.TIR201', '37.003952                                                       ', '           22.660000', '20120109133156', '97');
INSERT INTO `pre_dss` VALUES ('w75.TIR202', '36.997948                                                       ', '           22.660000', '20120109133156', '98');
INSERT INTO `pre_dss` VALUES ('w76.TIR203', '37.00377                                                        ', '           22.660000', '20120109133156', '99');
INSERT INTO `pre_dss` VALUES ('w76.TIR204', '37.004818                                                       ', '           22.660000', '20120109133156', '100');
INSERT INTO `pre_dss` VALUES ('w77.TIR205', '37.03022                                                        ', '           22.660000', '20120109133156', '101');
INSERT INTO `pre_dss` VALUES ('w77.TIR206', '37.03022                                                        ', '           22.660000', '20120109133156', '102');
INSERT INTO `pre_dss` VALUES ('w78.TIR207', '37.02957                                                        ', '           22.660000', '20120109133156', '103');
INSERT INTO `pre_dss` VALUES ('w78.TIR208', '37.02957                                                        ', '           22.660000', '20120109133156', '104');
INSERT INTO `pre_dss` VALUES ('w86.LIA201', '2.5499969                                                       ', '           22.660000', '20120109133156', '105');
INSERT INTO `pre_dss` VALUES ('w87.LISA202', '0.07699811                                                      ', '           22.660000', '20120109133156', '106');
INSERT INTO `pre_dss` VALUES ('w88.LISA203', '0.0770004                                                       ', '           22.660000', '20120109133156', '107');
INSERT INTO `pre_dss` VALUES ('FRQ201', '1440189.1                                                       ', '           22.660000', '20120109133156', '108');
INSERT INTO `pre_dss` VALUES ('FRQ202', '1440189.1                                                       ', '           22.660000', '20120109133156', '109');
INSERT INTO `pre_dss` VALUES ('FR203', '17.411297                                                       ', '           22.660000', '20120109133156', '110');
INSERT INTO `pre_dss` VALUES ('w86.FRQ203', '86917.91                                                        ', '           22.660000', '20120109133156', '111');
INSERT INTO `pre_dss` VALUES ('FRQ204', '887995.4                                                        ', '           22.660000', '20120109133156', '112');
INSERT INTO `pre_dss` VALUES ('FR205', '13.03844                                                        ', '           22.660000', '20120109133156', '113');
INSERT INTO `pre_dss` VALUES ('w87.FRQ205', '69702.59                                                        ', '           22.660000', '20120109133156', '114');
INSERT INTO `pre_dss` VALUES ('FRQ206', '907323.9                                                        ', '           22.660000', '20120109133156', '115');
INSERT INTO `pre_dss` VALUES ('FR207', '13.056068                                                       ', '           22.660000', '20120109133156', '116');
INSERT INTO `pre_dss` VALUES ('w88.FRQ207', '69688.664                                                       ', '           22.660000', '20120109133156', '117');
INSERT INTO `pre_dss` VALUES ('w83.LIR803', '50.00017                                                        ', '           22.660000', '20120109133156', '118');
INSERT INTO `pre_dss` VALUES ('w83.LIR804', '50.00017                                                        ', '           22.660000', '20120109133156', '119');
INSERT INTO `pre_dss` VALUES ('w85.AIRA801', '7.0                                                             ', '           22.660000', '20120109133156', '120');
INSERT INTO `pre_dss` VALUES ('w85.AIRA802', '36.35987                                                        ', '           22.660000', '20120109133156', '121');
INSERT INTO `pre_dss` VALUES ('w85.AIRA803', '70.36264                                                        ', '           22.660000', '20120109133156', '122');
INSERT INTO `pre_dss` VALUES ('w85.AIRA804', '3.473392                                                        ', '           22.660000', '20120109133156', '123');
INSERT INTO `pre_dss` VALUES ('PI501', '0.0                                                             ', '           22.660000', '20120109133156', '124');
INSERT INTO `pre_dss` VALUES ('FR501', '13.165741                                                       ', '           22.660000', '20120109133156', '125');
INSERT INTO `pre_dss` VALUES ('FRQ501', '103254.86                                                       ', '           22.660000', '20120109133156', '126');

-- ----------------------------
-- Table structure for `pre_history`
-- ----------------------------
DROP TABLE IF EXISTS `pre_history`;
CREATE TABLE `pre_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seqno` varchar(255) DEFAULT NULL,
  `simu_time` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK92FB92D823A4A4F1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_history
-- ----------------------------
INSERT INTO `pre_history` VALUES ('1', '20111218123004', '           32.560000', '3.3191227E-5                                                    ', 'w77.AIR201');
INSERT INTO `pre_history` VALUES ('2', '20111218123004', '           32.560000', '3.3191227E-5                                                    ', 'w77.AIR202');
INSERT INTO `pre_history` VALUES ('3', '20111218123004', '           32.560000', '3.3191824E-5                                                    ', 'w78.AIR203');
INSERT INTO `pre_history` VALUES ('4', '20111218123004', '           32.560000', '3.3191824E-5                                                    ', 'w78.AIR204');
INSERT INTO `pre_history` VALUES ('5', '20111218123004', '           32.560000', '1000.00006                                                      ', 'w86.FRCQ201');
INSERT INTO `pre_history` VALUES ('6', '20111218123004', '           32.560000', '1000.00006                                                      ', 'w86.FRCQ202');
INSERT INTO `pre_history` VALUES ('7', '20111218123004', '           32.560000', '2.984558                                                        ', 'w76.AIRC211');
INSERT INTO `pre_history` VALUES ('8', '20111218123004', '           32.560000', '2.984558                                                        ', 'w76.AIRC212');
INSERT INTO `pre_history` VALUES ('9', '20111218123004', '           32.560000', '3.006699                                                        ', 'w75.AIRC213');
INSERT INTO `pre_history` VALUES ('10', '20111218123004', '           32.560000', '2.9999924                                                       ', 'w75.AIRC214');
INSERT INTO `pre_history` VALUES ('11', '20111218123004', '           32.560000', '2.9999926                                                       ', 'w76.AIRC216');
INSERT INTO `pre_history` VALUES ('12', '20111218123004', '           32.560000', '2.9836466                                                       ', 'w78.AIRC223');
INSERT INTO `pre_history` VALUES ('13', '20111218123004', '           32.560000', '2.9990299                                                       ', 'w77.AIRC221');
INSERT INTO `pre_history` VALUES ('14', '20111218123004', '           32.560000', '2.9990299                                                       ', 'w77.AIRC222');
INSERT INTO `pre_history` VALUES ('15', '20111218123004', '           32.560000', '2.9836466                                                       ', 'w78.AIRC224');
INSERT INTO `pre_history` VALUES ('16', '20111218123004', '           32.560000', '2.9999986                                                       ', 'w77.AIRC225');
INSERT INTO `pre_history` VALUES ('17', '20111218123004', '           32.560000', '2.9999986                                                       ', 'w77.AIRC226');
INSERT INTO `pre_history` VALUES ('18', '20111218123004', '           32.560000', '2.9875658                                                       ', 'w78.AIRC227');
INSERT INTO `pre_history` VALUES ('19', '20111218123004', '           32.560000', '2.9875658                                                       ', 'w78.AIRC228');
INSERT INTO `pre_history` VALUES ('20', '20111218123004', '           32.560000', '2.876394                                                        ', 'w77.AIRC217');
INSERT INTO `pre_history` VALUES ('21', '20111218123004', '           32.560000', '2.876394                                                        ', 'w77.AIRC218');
INSERT INTO `pre_history` VALUES ('22', '20111218123004', '           32.560000', '2.876436                                                        ', 'w78.AIRC219');
INSERT INTO `pre_history` VALUES ('23', '20111218123004', '           32.560000', '2.876436                                                        ', 'w78.AIRC220');
INSERT INTO `pre_history` VALUES ('24', '20111218123004', '           32.560000', '1501.2117                                                       ', 'w87.FRCQ204');
INSERT INTO `pre_history` VALUES ('25', '20111218123004', '           32.560000', '1500.0767                                                       ', 'w88.FRCQ206');
INSERT INTO `pre_history` VALUES ('26', '20111218123004', '           32.560000', '0.0                                                             ', 'w62.LDISA101');
INSERT INTO `pre_history` VALUES ('27', '20111218123004', '           32.560000', '0.0                                                             ', 'w62.LDISA102');
INSERT INTO `pre_history` VALUES ('28', '20111218123004', '           32.560000', '0.0                                                             ', 'w62.LDISA103');
INSERT INTO `pre_history` VALUES ('29', '20111218123004', '           32.560000', '3.9999905                                                       ', 'w62.LISA104');
INSERT INTO `pre_history` VALUES ('30', '20111218123004', '           32.560000', '529.8328                                                        ', 'w62.AIRA101');
INSERT INTO `pre_history` VALUES ('31', '20111218123004', '           32.560000', '12.061142                                                       ', 'w62.AIRA102');
INSERT INTO `pre_history` VALUES ('32', '20111218123004', '           32.560000', '2425424.0                                                       ', 'w63.FRQ101');
INSERT INTO `pre_history` VALUES ('33', '20111218123004', '           32.560000', '6.8999996                                                       ', 'w69.LIA114');
INSERT INTO `pre_history` VALUES ('34', '20111218123004', '           32.560000', '443.24112                                                       ', 'w74.AIRA103');
INSERT INTO `pre_history` VALUES ('35', '20111218123004', '           32.560000', '19.471039                                                       ', 'w74.AIRA104');
INSERT INTO `pre_history` VALUES ('36', '20111218123004', '           32.560000', '7.0                                                             ', 'w74.AIRA106');
INSERT INTO `pre_history` VALUES ('37', '20111218123004', '           32.560000', '4.3000255                                                       ', 'w71.LISA119');
INSERT INTO `pre_history` VALUES ('38', '20111218123004', '           32.560000', '0.0                                                             ', 'w73.LISA122');
INSERT INTO `pre_history` VALUES ('39', '20111218123004', '           32.560000', '0.0                                                             ', 'w73.LISA123');
INSERT INTO `pre_history` VALUES ('40', '20111218123004', '           32.560000', '0.0                                                             ', 'w73.LISA124');
INSERT INTO `pre_history` VALUES ('41', '20111218123004', '           32.560000', '36.34194                                                        ', 'w73.FI106');
INSERT INTO `pre_history` VALUES ('42', '20111218123004', '           32.560000', '36.34194                                                        ', 'w73.FI107');
INSERT INTO `pre_history` VALUES ('43', '20111218123004', '           32.560000', '36.34194                                                        ', 'w73.FI108');
INSERT INTO `pre_history` VALUES ('44', '20111218123004', '           32.560000', '36.34194                                                        ', 'w73.FI109');
INSERT INTO `pre_history` VALUES ('45', '20111218123004', '           32.560000', '36.34194                                                        ', 'w73.FI110');
INSERT INTO `pre_history` VALUES ('46', '20111218123004', '           32.560000', '36.34194                                                        ', 'w73.FI111');
INSERT INTO `pre_history` VALUES ('47', '20111218123004', '           32.560000', '551239.8                                                        ', 'w71.FRQ103');
INSERT INTO `pre_history` VALUES ('48', '20111218123004', '           32.560000', '551241.75                                                       ', 'w71.FRQ104');
INSERT INTO `pre_history` VALUES ('49', '20111218123004', '           32.560000', '7.0                                                             ', 'w62.AIRA107');
INSERT INTO `pre_history` VALUES ('50', '20111218123004', '           32.560000', '7.0                                                             ', 'w75.AIR229');
INSERT INTO `pre_history` VALUES ('51', '20111218123004', '           32.560000', '7.0                                                             ', 'w77.AIR233');
INSERT INTO `pre_history` VALUES ('52', '20111218123004', '           32.560000', '7.0                                                             ', 'w78.AIR235');
INSERT INTO `pre_history` VALUES ('53', '20111218123004', '           32.560000', '37.003956                                                       ', 'w75.TIR201');
INSERT INTO `pre_history` VALUES ('54', '20111218123004', '           32.560000', '36.997948                                                       ', 'w75.TIR202');
INSERT INTO `pre_history` VALUES ('55', '20111218123004', '           32.560000', '37.00377                                                        ', 'w76.TIR203');
INSERT INTO `pre_history` VALUES ('56', '20111218123004', '           32.560000', '37.004818                                                       ', 'w76.TIR204');
INSERT INTO `pre_history` VALUES ('57', '20111218123004', '           32.560000', '37.030212                                                       ', 'w77.TIR205');
INSERT INTO `pre_history` VALUES ('58', '20111218123004', '           32.560000', '37.030212                                                       ', 'w77.TIR206');
INSERT INTO `pre_history` VALUES ('59', '20111218123004', '           32.560000', '37.029568                                                       ', 'w78.TIR207');
INSERT INTO `pre_history` VALUES ('60', '20111218123004', '           32.560000', '37.029568                                                       ', 'w78.TIR208');
INSERT INTO `pre_history` VALUES ('61', '20111218123004', '           32.560000', '0.077204034                                                     ', 'w87.LISA202');
INSERT INTO `pre_history` VALUES ('62', '20111218123004', '           32.560000', '7.0                                                             ', 'w85.AIRA801');
INSERT INTO `pre_history` VALUES ('63', '20111218123004', '           32.560000', '36.37202                                                        ', 'w85.AIRA802');
INSERT INTO `pre_history` VALUES ('64', '20111218123004', '           32.560000', '70.380936                                                       ', 'w85.AIRA803');
INSERT INTO `pre_history` VALUES ('65', '20111218123004', '           32.560000', '3.4734836                                                       ', 'w85.AIRA804');
INSERT INTO `pre_history` VALUES ('66', '20120109133156', '           22.660000', '3.35265E-5                                                      ', 'w77.AIR201');
INSERT INTO `pre_history` VALUES ('67', '20120109133156', '           22.660000', '3.35265E-5                                                      ', 'w77.AIR202');
INSERT INTO `pre_history` VALUES ('68', '20120109133156', '           22.660000', '3.3528646E-5                                                    ', 'w78.AIR203');
INSERT INTO `pre_history` VALUES ('69', '20120109133156', '           22.660000', '3.3528646E-5                                                    ', 'w78.AIR204');
INSERT INTO `pre_history` VALUES ('70', '20120109133156', '           22.660000', '1000.00006                                                      ', 'w86.FRCQ201');
INSERT INTO `pre_history` VALUES ('71', '20120109133156', '           22.660000', '1000.00006                                                      ', 'w86.FRCQ202');
INSERT INTO `pre_history` VALUES ('72', '20120109133156', '           22.660000', '2.9845626                                                       ', 'w76.AIRC211');
INSERT INTO `pre_history` VALUES ('73', '20120109133156', '           22.660000', '2.9845626                                                       ', 'w76.AIRC212');
INSERT INTO `pre_history` VALUES ('74', '20120109133156', '           22.660000', '3.0067062                                                       ', 'w75.AIRC213');
INSERT INTO `pre_history` VALUES ('75', '20120109133156', '           22.660000', '2.9999928                                                       ', 'w75.AIRC214');
INSERT INTO `pre_history` VALUES ('76', '20120109133156', '           22.660000', '3.0067372                                                       ', 'w76.AIRC215');
INSERT INTO `pre_history` VALUES ('77', '20120109133156', '           22.660000', '2.9999926                                                       ', 'w76.AIRC216');
INSERT INTO `pre_history` VALUES ('78', '20120109133156', '           22.660000', '2.9836617                                                       ', 'w78.AIRC223');
INSERT INTO `pre_history` VALUES ('79', '20120109133156', '           22.660000', '2.999065                                                        ', 'w77.AIRC221');
INSERT INTO `pre_history` VALUES ('80', '20120109133156', '           22.660000', '2.999065                                                        ', 'w77.AIRC222');
INSERT INTO `pre_history` VALUES ('81', '20120109133156', '           22.660000', '2.9836617                                                       ', 'w78.AIRC224');
INSERT INTO `pre_history` VALUES ('82', '20120109133156', '           22.660000', '3.00001                                                         ', 'w77.AIRC225');
INSERT INTO `pre_history` VALUES ('83', '20120109133156', '           22.660000', '3.00001                                                         ', 'w77.AIRC226');
INSERT INTO `pre_history` VALUES ('84', '20120109133156', '           22.660000', '2.9875789                                                       ', 'w78.AIRC227');
INSERT INTO `pre_history` VALUES ('85', '20120109133156', '           22.660000', '2.9875789                                                       ', 'w78.AIRC228');
INSERT INTO `pre_history` VALUES ('86', '20120109133156', '           22.660000', '2.8910334                                                       ', 'w75.AIRC205');
INSERT INTO `pre_history` VALUES ('87', '20120109133156', '           22.660000', '2.9999957                                                       ', 'w75.AIRC206');
INSERT INTO `pre_history` VALUES ('88', '20120109133156', '           22.660000', '2.935241                                                        ', 'w76.AIRC207');
INSERT INTO `pre_history` VALUES ('89', '20120109133156', '           22.660000', '2.935241                                                        ', 'w76.AIRC208');
INSERT INTO `pre_history` VALUES ('90', '20120109133156', '           22.660000', '2.876425                                                        ', 'w77.AIRC217');
INSERT INTO `pre_history` VALUES ('91', '20120109133156', '           22.660000', '2.876425                                                        ', 'w77.AIRC218');
INSERT INTO `pre_history` VALUES ('92', '20120109133156', '           22.660000', '2.8764348                                                       ', 'w78.AIRC219');
INSERT INTO `pre_history` VALUES ('93', '20120109133156', '           22.660000', '2.8764348                                                       ', 'w78.AIRC220');
INSERT INTO `pre_history` VALUES ('94', '20120109133156', '           22.660000', '1497.2356                                                       ', 'w87.FRCQ204');
INSERT INTO `pre_history` VALUES ('95', '20120109133156', '           22.660000', '1497.2734                                                       ', 'w88.FRCQ206');
INSERT INTO `pre_history` VALUES ('96', '20120109133156', '           22.660000', '0.0                                                             ', 'w62.LDISA101');
INSERT INTO `pre_history` VALUES ('97', '20120109133156', '           22.660000', '0.0                                                             ', 'w62.LDISA102');
INSERT INTO `pre_history` VALUES ('98', '20120109133156', '           22.660000', '0.0                                                             ', 'w62.LDISA103');
INSERT INTO `pre_history` VALUES ('99', '20120109133156', '           22.660000', '4.000001                                                        ', 'w62.LISA104');
INSERT INTO `pre_history` VALUES ('100', '20120109133156', '           22.660000', '529.8328                                                        ', 'w62.AIRA101');
INSERT INTO `pre_history` VALUES ('101', '20120109133156', '           22.660000', '12.061142                                                       ', 'w62.AIRA102');
INSERT INTO `pre_history` VALUES ('102', '20120109133156', '           22.660000', '7.0                                                             ', 'w63.LIR106');
INSERT INTO `pre_history` VALUES ('103', '20120109133156', '           22.660000', '7.0                                                             ', 'w63.LIR107');
INSERT INTO `pre_history` VALUES ('104', '20120109133156', '           22.660000', '3067.9314                                                       ', 'w63.FR101');
INSERT INTO `pre_history` VALUES ('105', '20120109133156', '           22.660000', '6.9                                                             ', 'w69.LIA114');
INSERT INTO `pre_history` VALUES ('106', '20120109133156', '           22.660000', '1.5                                                             ', 'w74.LISA116');
INSERT INTO `pre_history` VALUES ('107', '20120109133156', '           22.660000', '443.24115                                                       ', 'w74.AIRA103');
INSERT INTO `pre_history` VALUES ('108', '20120109133156', '           22.660000', '19.471037                                                       ', 'w74.AIRA104');
INSERT INTO `pre_history` VALUES ('109', '20120109133156', '           22.660000', '7.0                                                             ', 'w74.AIRA106');
INSERT INTO `pre_history` VALUES ('110', '20120109133156', '           22.660000', '1.5                                                             ', 'w74.LISA118');
INSERT INTO `pre_history` VALUES ('111', '20120109133156', '           22.660000', '4.299991                                                        ', 'w71.LISA119');
INSERT INTO `pre_history` VALUES ('112', '20120109133156', '           22.660000', '0.0                                                             ', 'w73.LISA122');
INSERT INTO `pre_history` VALUES ('113', '20120109133156', '           22.660000', '0.0                                                             ', 'w73.LISA123');
INSERT INTO `pre_history` VALUES ('114', '20120109133156', '           22.660000', '0.0                                                             ', 'w73.LISA124');
INSERT INTO `pre_history` VALUES ('115', '20120109133156', '           22.660000', '36.237938                                                       ', 'w73.FI106');
INSERT INTO `pre_history` VALUES ('116', '20120109133156', '           22.660000', '36.237938                                                       ', 'w73.FI107');
INSERT INTO `pre_history` VALUES ('117', '20120109133156', '           22.660000', '36.237938                                                       ', 'w73.FI108');
INSERT INTO `pre_history` VALUES ('118', '20120109133156', '           22.660000', '36.237938                                                       ', 'w73.FI109');
INSERT INTO `pre_history` VALUES ('119', '20120109133156', '           22.660000', '36.237938                                                       ', 'w73.FI110');
INSERT INTO `pre_history` VALUES ('120', '20120109133156', '           22.660000', '36.237938                                                       ', 'w73.FI111');
INSERT INTO `pre_history` VALUES ('121', '20120109133156', '           22.660000', '550125.7                                                        ', 'w71.FRQ103');
INSERT INTO `pre_history` VALUES ('122', '20120109133156', '           22.660000', '550127.6                                                        ', 'w71.FRQ104');
INSERT INTO `pre_history` VALUES ('123', '20120109133156', '           22.660000', '7.0                                                             ', 'w62.AIRA107');
INSERT INTO `pre_history` VALUES ('124', '20120109133156', '           22.660000', '7.0                                                             ', 'w75.AIR229');
INSERT INTO `pre_history` VALUES ('125', '20120109133156', '           22.660000', '7.0                                                             ', 'w75.AIR230');
INSERT INTO `pre_history` VALUES ('126', '20120109133156', '           22.660000', '7.0                                                             ', 'w76.AIR231');
INSERT INTO `pre_history` VALUES ('127', '20120109133156', '           22.660000', '7.0                                                             ', 'w76.AIR232');
INSERT INTO `pre_history` VALUES ('128', '20120109133156', '           22.660000', '7.0                                                             ', 'w77.AIR233');
INSERT INTO `pre_history` VALUES ('129', '20120109133156', '           22.660000', '7.0                                                             ', 'w77.AIR234');
INSERT INTO `pre_history` VALUES ('130', '20120109133156', '           22.660000', '7.0                                                             ', 'w78.AIR235');
INSERT INTO `pre_history` VALUES ('131', '20120109133156', '           22.660000', '37.003952                                                       ', 'w75.TIR201');
INSERT INTO `pre_history` VALUES ('132', '20120109133156', '           22.660000', '36.997948                                                       ', 'w75.TIR202');
INSERT INTO `pre_history` VALUES ('133', '20120109133156', '           22.660000', '37.00377                                                        ', 'w76.TIR203');
INSERT INTO `pre_history` VALUES ('134', '20120109133156', '           22.660000', '37.004818                                                       ', 'w76.TIR204');
INSERT INTO `pre_history` VALUES ('135', '20120109133156', '           22.660000', '37.03022                                                        ', 'w77.TIR205');
INSERT INTO `pre_history` VALUES ('136', '20120109133156', '           22.660000', '37.03022                                                        ', 'w77.TIR206');
INSERT INTO `pre_history` VALUES ('137', '20120109133156', '           22.660000', '37.02957                                                        ', 'w78.TIR207');
INSERT INTO `pre_history` VALUES ('138', '20120109133156', '           22.660000', '37.02957                                                        ', 'w78.TIR208');
INSERT INTO `pre_history` VALUES ('139', '20120109133156', '           22.660000', '2.5499969                                                       ', 'w86.LIA201');
INSERT INTO `pre_history` VALUES ('140', '20120109133156', '           22.660000', '0.07699811                                                      ', 'w87.LISA202');
INSERT INTO `pre_history` VALUES ('141', '20120109133156', '           22.660000', '0.0770004                                                       ', 'w88.LISA203');
INSERT INTO `pre_history` VALUES ('142', '20120109133156', '           22.660000', '86917.91                                                        ', 'w86.FRQ203');
INSERT INTO `pre_history` VALUES ('143', '20120109133156', '           22.660000', '69702.59                                                        ', 'w87.FRQ205');
INSERT INTO `pre_history` VALUES ('144', '20120109133156', '           22.660000', '69688.664                                                       ', 'w88.FRQ207');
INSERT INTO `pre_history` VALUES ('145', '20120109133156', '           22.660000', '50.00017                                                        ', 'w83.LIR803');
INSERT INTO `pre_history` VALUES ('146', '20120109133156', '           22.660000', '50.00017                                                        ', 'w83.LIR804');
INSERT INTO `pre_history` VALUES ('147', '20120109133156', '           22.660000', '7.0                                                             ', 'w85.AIRA801');
INSERT INTO `pre_history` VALUES ('148', '20120109133156', '           22.660000', '36.35987                                                        ', 'w85.AIRA802');
INSERT INTO `pre_history` VALUES ('149', '20120109133156', '           22.660000', '70.36264                                                        ', 'w85.AIRA803');
INSERT INTO `pre_history` VALUES ('150', '20120109133156', '           22.660000', '3.473392                                                        ', 'w85.AIRA804');

-- ----------------------------
-- Table structure for `temp_init_predict`
-- ----------------------------
DROP TABLE IF EXISTS `temp_init_predict`;
CREATE TABLE `temp_init_predict` (
  `nameid` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Id` varchar(36) NOT NULL DEFAULT ',',
  `name` varchar(36) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`nameid`,`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temp_init_predict
-- ----------------------------
INSERT INTO `temp_init_predict` VALUES ('w1.', 'BOD5', '染料厂酸水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w1.', 'COD', '染料厂酸水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w1.', 'NH3N', '染料厂酸水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w1.', 'PH', '染料厂酸水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w1.', 'Q', '染料厂酸水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w1.', 'SS', '染料厂酸水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w10.', 'BOD5', '铁运489沉淀池出水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w10.', 'COD', '铁运489沉淀池出水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w10.', 'NH3N', '铁运489沉淀池出水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w10.', 'PH', '铁运489沉淀池出水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w10.', 'Q', '铁运489沉淀池出水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w10.', 'SS', '铁运489沉淀池出水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w11.', 'BOD5', '含氮废水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w11.', 'COD', '含氮废水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w11.', 'NH3N', '含氮废水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w11.', 'PH', '含氮废水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w11.', 'Q', '含氮废水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w11.', 'SS', '含氮废水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w12.', 'BOD5', '103厂碱水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w12.', 'COD', '103厂碱水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w12.', 'NH3N', '103厂碱水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w12.', 'PH', '103厂碱水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w12.', 'Q', '103厂碱水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w12.', 'SS', '103厂碱水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w13.', 'BOD5', '化肥厂丁辛醇.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w13.', 'COD', '化肥厂丁辛醇.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w13.', 'NH3N', '化肥厂丁辛醇.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w13.', 'PH', '化肥厂丁辛醇.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w13.', 'Q', '化肥厂丁辛醇.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w13.', 'SS', '化肥厂丁辛醇.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w14.', 'BOD5', '丙烯腈废水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w14.', 'COD', '丙烯腈废水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w14.', 'NH3N', '丙烯腈废水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w14.', 'PH', '丙烯腈废水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w14.', 'Q', '丙烯腈废水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w14.', 'SS', '丙烯腈废水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w15.', 'BOD5', '合成树脂厂有机水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w15.', 'COD', '合成树脂厂有机水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w15.', 'NH3N', '合成树脂厂有机水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w15.', 'PH', '合成树脂厂有机水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w15.', 'Q', '合成树脂厂有机水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w15.', 'SS', '合成树脂厂有机水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w16.', 'BOD5', '龙潭区生活水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w16.', 'COD', '龙潭区生活水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w16.', 'NH3N', '龙潭区生活水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w16.', 'PH', '龙潭区生活水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w16.', 'Q', '龙潭区生活水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w16.', 'SS', '龙潭区生活水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w2.', 'BOD5', '电石厂酸水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w2.', 'COD', '电石厂酸水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w2.', 'NH3N', '电石厂酸水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w2.', 'PH', '电石厂酸水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w2.', 'Q', '电石厂酸水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w2.', 'SS', '电石厂酸水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w3.', 'BOD5', '电石厂有机水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w3.', 'COD', '电石厂有机水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w3.', 'NH3N', '电石厂有机水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w3.', 'PH', '电石厂有机水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w3.', 'Q', '电石厂有机水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w3.', 'SS', '电石厂有机水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w4.', 'BOD5', '电石厂有机水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w4.', 'COD', '有机合成厂有机水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w4.', 'NH3N', '有机合成厂有机水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w4.', 'PH', '有机合成厂有机水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w4.', 'Q', '有机合成厂有机水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w4.', 'SS', '有机合成厂有机水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w5.', 'BOD5', '炼油厂有机水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w5.', 'COD', '炼油厂有机水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w5.', 'NH3N', '炼油厂有机水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w5.', 'PH', '炼油厂有机水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w5.', 'Q', '炼油厂有机水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w5.', 'SS', '炼油厂有机水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w6.', 'BOD5', '精细化工厂废水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w6.', 'COD', '精细化工厂废水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w6.', 'NH3N', '精细化工厂废水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w6.', 'PH', '精细化工厂废水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w6.', 'Q', '精细化工厂废水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w6.', 'SS', '精细化工厂废水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'AIRA101', '进水提升泵房(462A).462A进水提升泵房COD', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'AIRA102', '进水提升泵房(462A).462A进水提升泵房NH3-N', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'AIRA107', '进水提升泵房(462A).462A.进水提升泵房PH', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'AIRA108', '进水提升泵房(462A).462A进水提升泵房SS', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'LDISA101', '进水提升泵房(462A).2#粗格栅前后液位差', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'LDISA102', '进水提升泵房(462A).3#粗格栅前后液位差', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'LDISA103', '进水提升泵房(462A).泵室液位', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'LDISA104', '进水提升泵房(462A).462A吸水池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'LISA104', '进水提升泵房(462A).1#潜水排污泵', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'P1STATUS', '进水提升泵房(462A).2#潜水排污泵', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'P2STATUS', '进水提升泵房(462A).3#潜水排污泵', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'P3STATU', '进水提升泵房(462A).4#潜水排污泵', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'P4STATUS', '进水提升泵房(462A).5#潜水排污泵', null);
INSERT INTO `temp_init_predict` VALUES ('w62.', 'P5STATUS', '进水提升泵房(462A).1#粗格栅前后液位差', null);
INSERT INTO `temp_init_predict` VALUES ('w63.', 'FRQ101', '巴氏计量槽(499).水量', null);
INSERT INTO `temp_init_predict` VALUES ('w63.', 'LDISA106', '巴氏计量槽(499).巴氏计量槽前液位', null);
INSERT INTO `temp_init_predict` VALUES ('w63.', 'LDISA107', '巴氏计量槽(499).巴氏计量槽后液位', null);
INSERT INTO `temp_init_predict` VALUES ('w65.', 'M4881', '沉沙刮沙池(488).M488-1#刮沙机', null);
INSERT INTO `temp_init_predict` VALUES ('w65.', 'M4882', '沉沙刮沙池(488).M488-2#刮沙机', null);
INSERT INTO `temp_init_predict` VALUES ('w65.', 'M4883', '沉沙刮沙池(488).M488-3#刮沙机', null);
INSERT INTO `temp_init_predict` VALUES ('w65.', 'M4884', '沉沙刮沙池(488).M488-3#刮沙机', null);
INSERT INTO `temp_init_predict` VALUES ('w66.', 'M4891S', '初沉池(489B).M489-1#周边传动刮泥机', null);
INSERT INTO `temp_init_predict` VALUES ('w66.', 'M4892S', '初沉池(489B).M489-2#周边传动刮泥机', null);
INSERT INTO `temp_init_predict` VALUES ('w66.', 'M4893S', '初沉池(489B).M489-3#周边传动刮泥机', null);
INSERT INTO `temp_init_predict` VALUES ('w67.', 'LIA115', '事故池(489).事故池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w69.', 'LIA114', '老水解酸化池.老水解酸化池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w7.', 'BOD5', '乙二醇废水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w7.', 'COD', '乙二醇废水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w7.', 'NH3N', '乙二醇废水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w7.', 'PH', '乙二醇废水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w7.', 'Q', '乙二醇废水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w7.', 'SS', '乙二醇废水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w70.', 'LIA115', '新水解酸化池.新水解酸化池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w71.', 'FRQ103', '污泥池(V466).P466-1-2泵出口干管流量', null);
INSERT INTO `temp_init_predict` VALUES ('w71.', 'FRQ104', '污泥池(V466).P466-3-4泵出口干管流量', null);
INSERT INTO `temp_init_predict` VALUES ('w71.', 'LISA119', '污泥泵房(466).V466污泥池前液位', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'FI106', '脱水装置(495).P495A-1流量', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'FI107', '脱水装置(495).P495A-2流量', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'FI108', '脱水装置(495).P495A-3流量', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'FI109', '脱水装置(495).P495A-4流量', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'FI110', '脱水装置(495).P495A-5流量', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'FI111', '脱水装置(495).P495A-6流量', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'LISA122', '脱水装置(495).V495A-5液位', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'LISA123', '脱水装置(495).药剂池V495-3液位', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'LISA124', '脱水装置(495).药剂池V495-4液位', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'R4951', '脱水装置(495).1#带式压榨过滤机状态', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'R4952', '脱水装置(495).2#带式压榨过滤机状态', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'R4953', '脱水装置(495).3#带式压榨过滤机状态', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'R4954', '脱水装置(495).4#带式压榨过滤机状态', null);
INSERT INTO `temp_init_predict` VALUES ('w73.', 'R4955', '脱水装置(495).5#带式压榨过滤机状态', null);
INSERT INTO `temp_init_predict` VALUES ('w74.', 'AIRA103', '中间提升泵房(462B).462B吸水池COD', null);
INSERT INTO `temp_init_predict` VALUES ('w74.', 'AIRA104', '中间提升泵房(462B).462B吸水池NH3-N', null);
INSERT INTO `temp_init_predict` VALUES ('w74.', 'AIRA105', '中间提升泵房(462B).462B吸水池SS', null);
INSERT INTO `temp_init_predict` VALUES ('w74.', 'AIRA106', '中间提升泵房(462B).462B吸水池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w74.', 'AIRC209', '中间提升泵房(462B).462B泵房吸水池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w74.', 'AIRC210', '中间提升泵房(462B).V462B-3高位水池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIR229', '1系列生化池.2号生化池3段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIR231', '1系列生化池.1号生化池5段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIR232', '1系列生化池.2号生化池5段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIR234', '1系列生化池.1#鼓风机分量', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIRC207', '1系列生化池.1号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIRC208', '1系列生化池.2号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIRC213', '1系列生化池.1号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'AIRC214', '1系列生化池.2号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'FR601A', '1系列生化池.1号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'TIR201', '1系列生化池.2号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w75.', 'TIR202', '1系列生化池.1号生化池3段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'AIR230', '2系列生化池.3号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'AIRC205', '2系列生化池.3号生化池3段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'AIRC206', '2系列生化池.3号生化池5段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'AIRC211', '2系列生化池.3号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'AIRC212', '2系列生化池.4号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'AIRC216', '2系列生化池.4号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'FR601B', '2系列生化池.4号生化池3段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'LIA116', '2系列生化池.4号生化池5段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'LIA117', '2系列生化池.2#鼓风机分量', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'TIR203', '2系列生化池.3号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w76.', 'TIR204', '2系列生化池.4号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIR201', '3系列生化池.5号生化池A段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIR202', '3系列生化池.6号生化池A段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIR233', '3系列生化池.5号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIRC215', '3系列生化池.6号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIRC217', '3系列生化池.5号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIRC218', '3系列生化池.6号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIRC221', '3系列生化池.5号生化池4段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIRC222', '3系列生化池.6号生化池4段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIRC225', '3系列生化池.5号生化池6段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'AIRC226', '3系列生化池.6号生化池6段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'FR601C', '3系列生化池.3#鼓风机分量', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'TIR205', '3系列生化池.5号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w77.', 'TIR206', '3系列生化池.6号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIR203', '4系列生化池.7号生化池A段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIR204', '4系列生化池.8号生化池A段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIR235', '4系列生化池.7号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIR236', '4系列生化池.8号生化池PH', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIRC219', '4系列生化池.7号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIRC220', '4系列生化池.8号生化池2段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIRC223', '4系列生化池.7号生化池4段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIRC224', '4系列生化池.8号生化池4段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIRC227', '4系列生化池.7号生化池6段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'AIRC228', '4系列生化池.8号生化池6段溶解氧DO', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'FR601B', '4系列生化池.4#鼓风机分量', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'TIR207', '4系列生化池.7号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w78.', 'TIR208', '4系列生化池.8号生化池温度', null);
INSERT INTO `temp_init_predict` VALUES ('w8.', 'BOD5', '环氧乙烷废水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w8.', 'COD', '环氧乙烷废水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w8.', 'NH3N', '环氧乙烷废水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w8.', 'PH', '环氧乙烷废水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w8.', 'Q', '环氧乙烷废水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w8.', 'SS', '环氧乙烷废水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('w85.', 'AIRA801', '排江出口线.出口PH', null);
INSERT INTO `temp_init_predict` VALUES ('w85.', 'AIRA802', '排江出口线.出口SS', null);
INSERT INTO `temp_init_predict` VALUES ('w85.', 'AIRA803', '排江出口线.出口COD', null);
INSERT INTO `temp_init_predict` VALUES ('w85.', 'AIRA804', '排江出口线.出口NH3-N', null);
INSERT INTO `temp_init_predict` VALUES ('w85.', 'AIRA805', '排江出口线.出口DO', null);
INSERT INTO `temp_init_predict` VALUES ('w86.', 'FRCQ201', '1系列465回流泵房.1系列465-1回流泵房回流量', null);
INSERT INTO `temp_init_predict` VALUES ('w86.', 'FRCQ202', '1系列465回流泵房.2系列465-2回流泵房回流量', null);
INSERT INTO `temp_init_predict` VALUES ('w86.', 'FRCQ203', '1系列465回流泵房.1系列465回流泵房剩余量', null);
INSERT INTO `temp_init_predict` VALUES ('w86.', 'LISA201', '1系列465回流泵房.465吸泥池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w87.', 'FRCQ204', '2系列465A回流泵房.2系列465A回流泵房回流量', null);
INSERT INTO `temp_init_predict` VALUES ('w87.', 'FRCQ205', '2系列465A回流泵房.2系列465A回流泵房剩余量', null);
INSERT INTO `temp_init_predict` VALUES ('w87.', 'LISA202', '2系列465A回流泵房.465A吸泥池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w88.', 'FRCQ206', '3系列465B回流泵房.3系列465B回流泵房回流量', null);
INSERT INTO `temp_init_predict` VALUES ('w88.', 'FRCQ207', '3系列465B回流泵房.3系列465B回流泵房剩余量', null);
INSERT INTO `temp_init_predict` VALUES ('w88.', 'LISA204', '3系列465B回流泵房.465B吸泥池液位', null);
INSERT INTO `temp_init_predict` VALUES ('w9.', 'BOD5', '农药厂有机水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('w9.', 'COD', '农药厂有机水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('w9.', 'NH3N', '农药厂有机水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('w9.', 'PH', '农药厂有机水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('w9.', 'Q', '农药厂有机水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('w9.', 'SS', '农药厂有机水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('WW14A.', 'BOD5', '14A生活水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('WW14A.', 'COD', '14A生活水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('WW14A.', 'NH3N', '14A生活水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('WW14A.', 'PH', '14A生活水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('WW14A.', 'Q', '14A生活水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('WW14A.', 'SS', '14A生活水.SS', null);
INSERT INTO `temp_init_predict` VALUES ('WW14B.', 'BOD5', '14B生活水.BOD5', null);
INSERT INTO `temp_init_predict` VALUES ('WW14B.', 'COD', '14B生活水.COD', null);
INSERT INTO `temp_init_predict` VALUES ('WW14B.', 'NH3N', '14B生活水.NH3N', null);
INSERT INTO `temp_init_predict` VALUES ('WW14B.', 'PH', '14B生活水.PH', null);
INSERT INTO `temp_init_predict` VALUES ('WW14B.', 'Q', '14B生活水.流量', null);
INSERT INTO `temp_init_predict` VALUES ('WW14B.', 'SS', '14B生活水.SS', null);

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
-- Table structure for `treeunit`
-- ----------------------------
DROP TABLE IF EXISTS `treeunit`;
CREATE TABLE `treeunit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `child` varchar(255) DEFAULT NULL,
  `father` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treeunit
-- ----------------------------
INSERT INTO `treeunit` VALUES ('1', '1、2系列465回流泵房', '生化处理');
INSERT INTO `treeunit` VALUES ('2', '103厂碱水', '点源');
INSERT INTO `treeunit` VALUES ('3', '14a', '生活水处理');
INSERT INTO `treeunit` VALUES ('4', '14b', '生活水处理');
INSERT INTO `treeunit` VALUES ('5', '14B生活水', '预处理');
INSERT INTO `treeunit` VALUES ('6', '1系列二沉池', '生化处理');
INSERT INTO `treeunit` VALUES ('7', '2系列二沉池', '生化处理');
INSERT INTO `treeunit` VALUES ('8', '3系列465A回流泵房', '生化处理');
INSERT INTO `treeunit` VALUES ('9', '3系列465B回流泵房', '生化处理');
INSERT INTO `treeunit` VALUES ('10', '3系列二沉池', '生化处理');
INSERT INTO `treeunit` VALUES ('11', '4系列二沉池', '生化处理');
INSERT INTO `treeunit` VALUES ('12', '巴氏计量槽(499)', '预处理');
INSERT INTO `treeunit` VALUES ('13', '丙烯腈废水', '点源');
INSERT INTO `treeunit` VALUES ('14', '沉沙刮沙池(488)', '预处理');
INSERT INTO `treeunit` VALUES ('15', '初沉池(489B)', '预处理');
INSERT INTO `treeunit` VALUES ('16', '除色池(414)', '预处理');
INSERT INTO `treeunit` VALUES ('17', '电石厂酸水', '中和处理');
INSERT INTO `treeunit` VALUES ('18', '电石厂有机水', '点源');
INSERT INTO `treeunit` VALUES ('19', '含氮废水', '点源');
INSERT INTO `treeunit` VALUES ('20', '合成树脂厂有机水', '点源');
INSERT INTO `treeunit` VALUES ('21', '化肥厂丁辛醇', '点源');
INSERT INTO `treeunit` VALUES ('22', '环氧乙烷废水', '点源');
INSERT INTO `treeunit` VALUES ('23', '接触氧化池', '生化处理');
INSERT INTO `treeunit` VALUES ('24', '进水提升泵房(462A)', '预处理');
INSERT INTO `treeunit` VALUES ('25', '精细化工厂废水', '点源');
INSERT INTO `treeunit` VALUES ('26', '老水解酸化池', '预处理');
INSERT INTO `treeunit` VALUES ('27', '炼油厂有机水', '点源');
INSERT INTO `treeunit` VALUES ('28', '龙潭区生活水', '点源');
INSERT INTO `treeunit` VALUES ('29', '农药厂有机水', '点源');
INSERT INTO `treeunit` VALUES ('30', '浓缩池(491)', '预处理');
INSERT INTO `treeunit` VALUES ('31', '排江出口线', '生化处理');
INSERT INTO `treeunit` VALUES ('32', '染料厂酸水', '中和处理');
INSERT INTO `treeunit` VALUES ('33', '生化池系列1(1号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('34', '生化池系列1(2号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('35', '生化池系列2(3号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('36', '生化池系列2(4号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('37', '生化池系列3(5号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('38', '生化池系列3(6号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('39', '生化池系列4(7号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('40', '生化池系列4(8号生化池)', '生化处理');
INSERT INTO `treeunit` VALUES ('41', '事故池(489)', '预处理');
INSERT INTO `treeunit` VALUES ('42', '铁运489沉淀池出水', '中和处理');
INSERT INTO `treeunit` VALUES ('43', '脱水装置(495)', '预处理');
INSERT INTO `treeunit` VALUES ('44', '稳流池(477)进水', '预处理');
INSERT INTO `treeunit` VALUES ('45', '污泥泵房(466)', '预处理');
INSERT INTO `treeunit` VALUES ('46', '新水解酸化池', '预处理');
INSERT INTO `treeunit` VALUES ('47', '乙二醇废水', '点源');
INSERT INTO `treeunit` VALUES ('48', '有机合成厂有机水', '点源');
INSERT INTO `treeunit` VALUES ('49', '中间提升泵房(462B)', '生化处理');

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
