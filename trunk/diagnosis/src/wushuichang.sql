/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : wushuichang

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2011-12-23 08:36:14
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

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
  `cf_reason` float(10,0) DEFAULT '1',
  `verb` varchar(255) DEFAULT NULL,
  `sugg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFBA61E58DB7478BC` (`bid`),
  CONSTRAINT `FKFBA61E58DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=369 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
INSERT INTO `backwardandreason` VALUES ('40', '16', '酸水的流量', '0', '增大', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('41', '16', '酸水的酸度', '0', '增加', '增加碱液投加量');
INSERT INTO `backwardandreason` VALUES ('42', '16', '碱液管线', '0', '堵塞', '及时清通，必要时断管逐渐清通');
INSERT INTO `backwardandreason` VALUES ('43', '16', '碱液碱度', '0', '低', '增加两台碱液泵运行');
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
) ENGINE=MyISAM AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdata
-- ----------------------------
INSERT INTO `dcsdata` VALUES ('109', '电石厂有机水', '班次', '0', null);
INSERT INTO `dcsdata` VALUES ('110', '电石厂有机水', 'COD', '1', '3');
INSERT INTO `dcsdata` VALUES ('120', '1系列生化池', '班次', '0', null);
INSERT INTO `dcsdata` VALUES ('117', '染料厂酸水', '班次', '0', null);
INSERT INTO `dcsdata` VALUES ('118', '染料厂酸水', 'COD', '1', '1');
INSERT INTO `dcsdata` VALUES ('121', '1系列生化池', '1号生化池PH', '12', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=1402 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdscrib
-- ----------------------------
INSERT INTO `dcsdscrib` VALUES ('1083', '2系列生化池 ', '3号生化池PH', '6', '生化池系列2(3号生化池)PH', '9', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1084', '2系列生化池 ', '3号生化池COD', '0', '生化池系列2(3号生化池)COD', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1332', '2系列生化池 ', '3号生化池碱度', '8', '生化池系列2(3号生化池)碱度', '14', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1333', '2系列生化池 ', '3号生化池BOD5', '2', '生化池系列2(3号生化池)BOD5', '4', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1334', '2系列生化池', '3号生化池SS', '100', '生化池系列2(3号生化池)SS', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1361', '2系列生化池', '4号生化池COD', '0', '生化池系列2(4号生化池)COD', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1362', '2系列生化池', '4号生化池碱度', '8', '生化池系列2(4号生化池)碱度', '14', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1363', '2系列生化池', '3号生化池BOD5', '2', '生化池系列2(4号生化池)BOD5', '4', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1364', '2系列生化池', '3号生化池SS', '100', '生化池系列2(4号生化池)SS', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1365', '2系列生化池', '4号生化池NH3-N', '0', '生化池系列2(4号生化池)NH3-N', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1366', '2系列生化池', '4号生化池硝态氮', '0', '生化池系列2(4号生化池)硝态氮', '50', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1367', '2系列生化池', '4号生化池溶解氧', '0', '生化池系列2(4号生化池)溶解氧', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1368', '2系列生化池', '4号生化池风量', '0', '生化池系列2(4号生化池)风量', '50', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1369', '2系列生化池', '4号生化池NO-N', '0', '生化池系列2(4号生化池)NO-N', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1370', '2系列生化池', '4号生化池水量', '100', '生化池系列2(4号生化池)水量', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1371', '2系列生化池', '4号生化池PH', '6', '生化池系列2(4号生化池)PH', '9', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1372', '染料厂酸水', 'COD', '0', '染料厂酸水COD', '0.5', '0', '0', '2', '5');
INSERT INTO `dcsdscrib` VALUES ('1373', '电石厂有机水', 'COD', '0', '电石厂有机水COD', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1374', '1系列生化池', '1号生化池PH', '6', '生化池系列1(1号生化池)PH', '9', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1375', '1系列生化池', '1号生化池COD', '0', '生化池系列1(1号生化池)COD', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1379', '1系列生化池', '1号生化池碱度', '8', '生化池系列1(1号生化池)碱度', '14', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1380', '1系列生化池', '1号生化池BOD5', '2', '生化池系列1(1号生化池)BOD5', '4', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1381', '1系列生化池', '1号生化池SS', '100', '生化池系列1(1号生化池)SS', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1382', '1系列生化池', '1号生化池NH3-N', '0', '生化池系列1(1号生化池)NH3-N', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1383', '1系列生化池', '1号生化池硝态氮', '100', '生化池系列1(1号生化池)硝态氮', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1384', '1系列生化池', '1号生化池溶解氧', '0', '生化池系列1(1号生化池)溶解氧', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1385', '1系列生化池', '1号生化池风量', '0', '生化池系列1(1号生化池)风量', '50', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1386', '1系列生化池', '1号生化池NO-N', '0', '生化池系列1(1号生化池)NO-N', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1387', '1系列生化池', '1号生化池水量', '100', '生化池系列1(1号生化池)水量', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1388', '1系列生化池', '2号生化池水量', '100', '生化池系列1(2号生化池)水量', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1389', '1系列生化池', '2号生化池PH', '6', '生化池系列1(2号生化池)PH', '9', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1390', '1系列生化池', '2号生化池COD', '0', '生化池系列1(2号生化池)COD', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1391', '1系列生化池', '2号生化池碱度', '8', '生化池系列1(2号生化池)碱度', '14', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1392', '1系列生化池', '2号生化池BOD5', '2', '生化池系列1(2号生化池)BOD5', '4', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1393', '1系列生化池', '2号生化池SS', '100', '生化池系列1(2号生化池)SS', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1394', '1系列生化池', '2号生化池NH3-N', '0', '生化池系列1(2号生化池)NH3-N', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1395', '1系列生化池', '2号生化池硝态氮', '100', '生化池系列1(2号生化池)硝态氮', '500', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1396', '1系列生化池', '2号生化池溶解氧', '0', '生化池系列1 (2号生化池)溶解氧', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1397', '1系列生化池', '2号生化池风量', '0', '生化池系列1 (2号生化池)风量', '50', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1398', '1系列生化池', '2号生化池NO-N', '0', '生化池系列1 (2号生化池)NO-N', '0.5', '0', '0', '0', '0');
INSERT INTO `dcsdscrib` VALUES ('1401', '2系列生化池', '3号生化池温度', '5', '电石厂有机水溶解氧', '2', '0', '0', '0', '0');

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
) ENGINE=MyISAM AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

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
INSERT INTO `dcshistory` VALUES ('106', '电石厂有机水', '班次', '2011-12-19 20:43:43', '0');
INSERT INTO `dcshistory` VALUES ('107', '电石厂有机水', 'COD', '2011-12-19 20:43:16', '1');
INSERT INTO `dcshistory` VALUES ('108', '染料厂酸水', '班次', '2011-12-19 20:45:00', '0');
INSERT INTO `dcshistory` VALUES ('109', '染料厂酸水', 'COD', '2011-12-19 20:44:57', '1');
INSERT INTO `dcshistory` VALUES ('110', '染料厂酸水', '班次', '2011-12-19 20:45:21', '0');
INSERT INTO `dcshistory` VALUES ('111', '染料厂酸水', 'COD', '2011-12-19 20:45:21', '3');
INSERT INTO `dcshistory` VALUES ('112', '染料厂酸水', '班次', '2011-12-19 20:47:47', '0');
INSERT INTO `dcshistory` VALUES ('113', '染料厂酸水', 'COD', '2011-12-19 20:47:47', '6');
INSERT INTO `dcshistory` VALUES ('114', '染料厂酸水', '班次', '2011-12-19 21:15:35', '0');
INSERT INTO `dcshistory` VALUES ('115', '染料厂酸水', 'COD', '2011-12-19 21:15:34', '1');
INSERT INTO `dcshistory` VALUES ('116', '1系列生化池', '班次', '2011-12-22 12:55:00', '0');
INSERT INTO `dcshistory` VALUES ('117', '1系列生化池', '班次', '2011-12-22 12:55:52', '0');
INSERT INTO `dcshistory` VALUES ('118', '1系列生化池', '1号生化池PH', '2011-12-22', '12');

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
) ENGINE=MyISAM AUTO_INCREMENT=877 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_advice
-- ----------------------------
INSERT INTO `dss_advice` VALUES ('876', 'w76.TIR203', '37.00377', '报警现象： 电石厂有机水溶解氧过高', '           32.560000', '20111218123004', '', '5');

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
) ENGINE=MyISAM AUTO_INCREMENT=810 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of errorlog
-- ----------------------------
INSERT INTO `errorlog` VALUES ('20', '2系列生化池', '3号生化池PH', '4', '2011-11-27 15:04:02', '2', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;', '过低');
INSERT INTO `errorlog` VALUES ('21', '2系列生化池', '3号生化池PH', '3', '2011-11-27 15:06:13', '111', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;', '过高');
INSERT INTO `errorlog` VALUES ('22', '2系列生化池', '3号生化池PH', '5', '2011-11-27 15:10:07', '22', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;', '过高');
INSERT INTO `errorlog` VALUES ('23', '2系列生化池', '3号生化池PH', '6', '2011-11-27 19:16:12', '213234324', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;', '过高');
INSERT INTO `errorlog` VALUES ('24', '2系列生化池', '3号生化池PH', '7', '2011-11-27 19:16:33', '1212121', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;', '过高');
INSERT INTO `errorlog` VALUES ('26', '2系列生化池', '3号生化池PH', '8', '2011-11-27 19:36:21', '32432', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;', '过高');
INSERT INTO `errorlog` VALUES ('27', '2系列生化池', '3号生化池PH', '9', '2011-11-27 19:45:44', '1111', '中和站控制不好;', '增加测试PH频次，向车间工艺工程师汇报;', '过高');
INSERT INTO `errorlog` VALUES ('28', '2系列生化池', '3号生化池SS', '2', '2011-11-27 19:54:38', '13221342', '进水池控制不好;', '维修;', '过高');
INSERT INTO `errorlog` VALUES ('39', '1系列生化池', '1号生化池PH', '1', '2011-11-28 11:33:26', '11111', '中和池处理不好;', '维修;', '过高');
INSERT INTO `errorlog` VALUES ('40', '1系列生化池', '2号生化池PH', '4', '2011-11-28 11:34:51', '11111', '中和池处理不好;', '维修;', '过高');
INSERT INTO `errorlog` VALUES ('41', '1系列生化池', '1号生化池PH', '5', '2011-11-28 22:17:11', '10', '中和池处理不好;酸水的流量增大;酸水的酸度增加;碱液管堵塞;仪表指示不准;', '维修;增加碱液投加量;增加碱液投加量;及时清通，必要时短管清通;用PH试纸实测;', '过高');
INSERT INTO `errorlog` VALUES ('42', '排江出口线', '出口NH3-N', '6', '2011-12-11 15:53:22', '3', '11;22;33;电石渣加的太多;中和错误;', '1;2;3;减少电石渣投放量;立即上报;', '过高');
INSERT INTO `errorlog` VALUES ('43', '染料厂酸水', 'COD', '10', '2011-12-19 21:15:35', '1', null, null, '过高');
INSERT INTO `errorlog` VALUES ('44', '排江出口线', '出口水量', '3', '2011-12-11 15:53:22', '333', '11;22;33;电石渣加的太多;中和错误;', '1;2;3;减少电石渣投放量;立即上报', '过高');
INSERT INTO `errorlog` VALUES ('45', '1系列生化池', '1号生化池PH', '9', '2011-12-22 12:55:52', '12', ';', '调整进水PH值，加酸（这种情况很少出现，目前工厂没有加酸装置）;', '过高');

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
INSERT INTO `init_predict` VALUES ('w1.BOD5', '染料厂酸水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w1.COD', '染料厂酸水.COD', '');
INSERT INTO `init_predict` VALUES ('w1.NH3N', '染料厂酸水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w1.PH', '染料厂酸水.PH', '');
INSERT INTO `init_predict` VALUES ('w1.Q', '染料厂酸水.流量', '');
INSERT INTO `init_predict` VALUES ('w1.SS', '染料厂酸水.SS', '');
INSERT INTO `init_predict` VALUES ('w10.BOD5', '铁运489沉淀池出水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w10.COD', '铁运489沉淀池出水.COD', '');
INSERT INTO `init_predict` VALUES ('w10.NH3N', '铁运489沉淀池出水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w10.PH', '铁运489沉淀池出水.PH', '');
INSERT INTO `init_predict` VALUES ('w10.Q', '铁运489沉淀池出水.流量', '');
INSERT INTO `init_predict` VALUES ('w10.SS', '铁运489沉淀池出水.SS', '');
INSERT INTO `init_predict` VALUES ('w11.BOD5', '含氮废水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w11.COD', '含氮废水.COD', '');
INSERT INTO `init_predict` VALUES ('w11.NH3N', '含氮废水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w11.PH', '含氮废水.PH', '');
INSERT INTO `init_predict` VALUES ('w11.Q', '含氮废水.流量', '');
INSERT INTO `init_predict` VALUES ('w11.SS', '含氮废水.SS', '');
INSERT INTO `init_predict` VALUES ('w12.BOD5', '103厂碱水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w12.COD', '103厂碱水.COD', '');
INSERT INTO `init_predict` VALUES ('w12.NH3N', '103厂碱水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w12.PH', '103厂碱水.PH', '');
INSERT INTO `init_predict` VALUES ('w12.Q', '103厂碱水.流量', '');
INSERT INTO `init_predict` VALUES ('w12.SS', '103厂碱水.SS', '');
INSERT INTO `init_predict` VALUES ('w13.BOD5', '化肥厂丁辛醇.BOD5', '');
INSERT INTO `init_predict` VALUES ('w13.COD', '化肥厂丁辛醇.COD', '');
INSERT INTO `init_predict` VALUES ('w13.NH3N', '化肥厂丁辛醇.NH3N', '');
INSERT INTO `init_predict` VALUES ('w13.PH', '化肥厂丁辛醇.PH', '');
INSERT INTO `init_predict` VALUES ('w13.Q', '化肥厂丁辛醇.流量', '');
INSERT INTO `init_predict` VALUES ('w13.SS', '化肥厂丁辛醇.SS', '');
INSERT INTO `init_predict` VALUES ('w14.BOD5', '丙烯腈废水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w14.COD', '丙烯腈废水.COD', '');
INSERT INTO `init_predict` VALUES ('w14.NH3N', '丙烯腈废水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w14.PH', '丙烯腈废水.PH', '');
INSERT INTO `init_predict` VALUES ('w14.Q', '丙烯腈废水.流量', '');
INSERT INTO `init_predict` VALUES ('w14.SS', '丙烯腈废水.SS', '');
INSERT INTO `init_predict` VALUES ('w15.BOD5', '合成树脂厂有机水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w15.COD', '合成树脂厂有机水.COD', '');
INSERT INTO `init_predict` VALUES ('w15.NH3N', '合成树脂厂有机水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w15.PH', '合成树脂厂有机水.PH', '');
INSERT INTO `init_predict` VALUES ('w15.Q', '合成树脂厂有机水.流量', '');
INSERT INTO `init_predict` VALUES ('w15.SS', '合成树脂厂有机水.SS', '');
INSERT INTO `init_predict` VALUES ('w16.BOD5', '龙潭区生活水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w16.COD', '龙潭区生活水.COD', '');
INSERT INTO `init_predict` VALUES ('w16.NH3N', '龙潭区生活水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w16.PH', '龙潭区生活水.PH', '');
INSERT INTO `init_predict` VALUES ('w16.Q', '龙潭区生活水.流量', '');
INSERT INTO `init_predict` VALUES ('w16.SS', '龙潭区生活水.SS', '');
INSERT INTO `init_predict` VALUES ('w2.BOD5', '电石厂酸水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w2.COD', '电石厂酸水.COD', '');
INSERT INTO `init_predict` VALUES ('w2.NH3N', '电石厂酸水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w2.PH', '电石厂酸水.PH', '');
INSERT INTO `init_predict` VALUES ('w2.Q', '电石厂酸水.流量', '');
INSERT INTO `init_predict` VALUES ('w2.SS', '电石厂酸水.SS', '');
INSERT INTO `init_predict` VALUES ('w3.BOD5', '电石厂有机水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w3.COD', '电石厂有机水.COD', '');
INSERT INTO `init_predict` VALUES ('w3.NH3N', '电石厂有机水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w3.PH', '电石厂有机水.PH', '');
INSERT INTO `init_predict` VALUES ('w3.Q', '电石厂有机水.流量', '');
INSERT INTO `init_predict` VALUES ('w3.SS', '电石厂有机水.SS', '');
INSERT INTO `init_predict` VALUES ('w4.BOD5', '电石厂有机水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w4.COD', '有机合成厂有机水.COD', '');
INSERT INTO `init_predict` VALUES ('w4.NH3N', '有机合成厂有机水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w4.PH', '有机合成厂有机水.PH', '');
INSERT INTO `init_predict` VALUES ('w4.Q', '有机合成厂有机水.流量', '');
INSERT INTO `init_predict` VALUES ('w4.SS', '有机合成厂有机水.SS', '');
INSERT INTO `init_predict` VALUES ('w5.BOD5', '炼油厂有机水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w5.COD', '炼油厂有机水.COD', '');
INSERT INTO `init_predict` VALUES ('w5.NH3N', '炼油厂有机水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w5.PH', '炼油厂有机水.PH', '');
INSERT INTO `init_predict` VALUES ('w5.Q', '炼油厂有机水.流量', '');
INSERT INTO `init_predict` VALUES ('w5.SS', '炼油厂有机水.SS', '');
INSERT INTO `init_predict` VALUES ('w6.BOD5', '精细化工厂废水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w6.COD', '精细化工厂废水.COD', '');
INSERT INTO `init_predict` VALUES ('w6.NH3N', '精细化工厂废水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w6.PH', '精细化工厂废水.PH', '');
INSERT INTO `init_predict` VALUES ('w6.Q', '精细化工厂废水.流量', '');
INSERT INTO `init_predict` VALUES ('w6.SS', '精细化工厂废水.SS', '');
INSERT INTO `init_predict` VALUES ('w62.AIRA101', '进水提升泵房(462A).462A进水提升泵房COD', '1');
INSERT INTO `init_predict` VALUES ('w62.AIRA102', '进水提升泵房(462A).462A进水提升泵房NH3-N', '1');
INSERT INTO `init_predict` VALUES ('w62.AIRA107', '进水提升泵房(462A).462A.进水提升泵房PH', '1');
INSERT INTO `init_predict` VALUES ('w62.AIRA108', '进水提升泵房(462A).462A进水提升泵房SS', '0');
INSERT INTO `init_predict` VALUES ('w62.LDISA101', '进水提升泵房(462A).1#粗格栅前后液位差', '1');
INSERT INTO `init_predict` VALUES ('w62.LDISA102', '进水提升泵房(462A).2#粗格栅前后液位差', '1');
INSERT INTO `init_predict` VALUES ('w62.LDISA103', '进水提升泵房(462A).3#粗格栅前后液位差', '1');
INSERT INTO `init_predict` VALUES ('w62.LISA104', '进水提升泵房(462A).462A吸水池液位', '1');
INSERT INTO `init_predict` VALUES ('w62.P1STATUS', '进水提升泵房(462A).1#潜水排污泵状态', '1');
INSERT INTO `init_predict` VALUES ('w62.P2STATUS', '进水提升泵房(462A).2#潜水排污泵状态', '1');
INSERT INTO `init_predict` VALUES ('w62.P3STATUS', '进水提升泵房(462A).3#潜水排污泵状态', '1');
INSERT INTO `init_predict` VALUES ('w62.P4STATUS', '进水提升泵房(462A).4#潜水排污泵状态', '1');
INSERT INTO `init_predict` VALUES ('w62.P5STATUS5', '进水提升泵房(462A).5#潜水排污泵状态', '1');
INSERT INTO `init_predict` VALUES ('w63.FRQ101', '巴氏计量槽(499).水量', '1');
INSERT INTO `init_predict` VALUES ('w63.LIR106', '巴氏计量槽(499).巴氏计量槽前液位', '1');
INSERT INTO `init_predict` VALUES ('w63.LIR107', '巴氏计量槽(499).巴氏计量槽后液位', '1');
INSERT INTO `init_predict` VALUES ('w65.M4881', '沉沙刮沙池(488).M488-1#刮沙机', '0');
INSERT INTO `init_predict` VALUES ('w65.M4882', '沉沙刮沙池(488).M488-2#刮沙机', '0');
INSERT INTO `init_predict` VALUES ('w65.M4883', '沉沙刮沙池(488).M488-3#刮沙机', '0');
INSERT INTO `init_predict` VALUES ('w65.M4884', '沉沙刮沙池(488).M488-3#刮沙机', '0');
INSERT INTO `init_predict` VALUES ('w66.M4891S', '初沉池(489B).M489-1#周边传动刮泥机', '0');
INSERT INTO `init_predict` VALUES ('w66.M4892S', '初沉池(489B).M489-2#周边传动刮泥机', '0');
INSERT INTO `init_predict` VALUES ('w66.M4893S', '初沉池(489B).M489-3#周边传动刮泥机', '0');
INSERT INTO `init_predict` VALUES ('w69.LIA114', '老水解酸化池.老水解酸化池液位', '1');
INSERT INTO `init_predict` VALUES ('w7.BOD5', '乙二醇废水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w7.COD', '乙二醇废水.COD', '');
INSERT INTO `init_predict` VALUES ('w7.NH3N', '乙二醇废水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w7.PH', '乙二醇废水.PH', '');
INSERT INTO `init_predict` VALUES ('w7.Q', '乙二醇废水.流量', '');
INSERT INTO `init_predict` VALUES ('w7.SS', '乙二醇废水.SS', '');
INSERT INTO `init_predict` VALUES ('w70.LIA115', '新水解酸化池.新水解酸化池液位', '1');
INSERT INTO `init_predict` VALUES ('w71.FRQ103', '污泥池(V466).P466-1-2泵出口干管流量', '');
INSERT INTO `init_predict` VALUES ('w71.FRQ104', '污泥池(V466).P466-3-4泵出口干管流量', '');
INSERT INTO `init_predict` VALUES ('w71.LISA119', '污泥泵房(466).V466污泥池前液位', '');
INSERT INTO `init_predict` VALUES ('w73.FI106', '脱水装置(495).P495A-1流量', '');
INSERT INTO `init_predict` VALUES ('w73.FI107', '脱水装置(495).P495A-2流量', '');
INSERT INTO `init_predict` VALUES ('w73.FI108', '脱水装置(495).P495A-3流量', '');
INSERT INTO `init_predict` VALUES ('w73.FI109', '脱水装置(495).P495A-4流量', '');
INSERT INTO `init_predict` VALUES ('w73.FI110', '脱水装置(495).P495A-5流量', '');
INSERT INTO `init_predict` VALUES ('w73.FI111', '脱水装置(495).P495A-6流量', '');
INSERT INTO `init_predict` VALUES ('w73.LISA122', '脱水装置(495).V495A-5液位', '');
INSERT INTO `init_predict` VALUES ('w73.LISA123', '脱水装置(495).药剂池V495-3液位', '');
INSERT INTO `init_predict` VALUES ('w73.LISA124', '脱水装置(495).药剂池V495-4液位', '');
INSERT INTO `init_predict` VALUES ('w73.R4951', '脱水装置(495).1#带式压榨过滤机状态', '');
INSERT INTO `init_predict` VALUES ('w73.R4952', '脱水装置(495).2#带式压榨过滤机状态', '');
INSERT INTO `init_predict` VALUES ('w73.R4953', '脱水装置(495).3#带式压榨过滤机状态', '');
INSERT INTO `init_predict` VALUES ('w73.R4954', '脱水装置(495).4#带式压榨过滤机状态', '');
INSERT INTO `init_predict` VALUES ('w73.R4955', '脱水装置(495).5#带式压榨过滤机状态', '');
INSERT INTO `init_predict` VALUES ('w74.AIRA103', '中间提升泵房(462B).462B吸水池COD', '1');
INSERT INTO `init_predict` VALUES ('w74.AIRA104', '中间提升泵房(462B).462B吸水池NH3-N', '1');
INSERT INTO `init_predict` VALUES ('w74.AIRA105', '中间提升泵房(462B).462B吸水池SS', '0');
INSERT INTO `init_predict` VALUES ('w74.AIRA106', '中间提升泵房(462B).462B吸水池PH', '0');
INSERT INTO `init_predict` VALUES ('w74.LIS117', '中间提升泵房(462B).V462B-3高位水池液位', '1');
INSERT INTO `init_predict` VALUES ('w74.LISA116', '中间提升泵房(462B).462B泵房吸水池液位', '1');
INSERT INTO `init_predict` VALUES ('w74.LISA118', '中间提升泵房(462B).药剂池液位', '3');
INSERT INTO `init_predict` VALUES ('w74.P462B-10', '中间提升泵房(462B).药剂泵状态', '3');
INSERT INTO `init_predict` VALUES ('w74.P462B-9', '中间提升泵房(462B).药剂泵状态', '3');
INSERT INTO `init_predict` VALUES ('w75.AIR209', '1系列生化池.1号生化池3段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w75.AIR210', '1系列生化池.2号生化池3段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w75.AIR229', '1系列生化池.1号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w75.AIR230', '1系列生化池.2号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w75.AIRC205', '1系列生化池.1号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w75.AIRC206', '1系列生化池.2号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w75.AIRC213', '1系列生化池.1号生化池5段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w75.AIRC214', '1系列生化池.2号生化池5段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w75.FR601A', '1系列生化池.1#鼓风机分量', '0');
INSERT INTO `init_predict` VALUES ('w75.TIR201', '1系列生化池.1号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w75.TIR202', '1系列生化池.2号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w76.AIR211', '2系列生化池.3号生化池3段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w76.AIR212', '2系列生化池.4号生化池3段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w76.AIR231', '2系列生化池.3号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w76.AIR232', '2系列生化池.4号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w76.AIRC207', '2系列生化池.3号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w76.AIRC208', '2系列生化池.4号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w76.AIRC215', '2系列生化池.3号生化池5段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w76.AIRC216', '2系列生化池.4号生化池5段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w76.FR601B', '2系列生化池.2#鼓风机分量', '0');
INSERT INTO `init_predict` VALUES ('w76.TIR203', '2系列生化池.3号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w76.TIR204', '2系列生化池.4号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w77.AIR201', '3系列生化池.5号生化池A段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.AIR202', '3系列生化池.6号生化池A段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.AIR233', '3系列生化池.5号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w77.AIR234', '3系列生化池.6号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w77.AIRC217', '3系列生化池.5号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.AIRC218', '3系列生化池.6号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.AIRC221', '3系列生化池.5号生化池4段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.AIRC222', '3系列生化池.6号生化池4段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.AIRC225', '3系列生化池.5号生化池6段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.AIRC226', '3系列生化池.6号生化池6段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w77.FR601C', '3系列生化池.3#鼓风机分量', '0');
INSERT INTO `init_predict` VALUES ('w77.TIR205', '3系列生化池.5号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w77.TIR206', '3系列生化池.6号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w78.AIR203', '4系列生化池.7号生化池A段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.AIR204', '4系列生化池.8号生化池A段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.AIR235', '4系列生化池.7号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w78.AIR236', '4系列生化池.8号生化池PH', '1');
INSERT INTO `init_predict` VALUES ('w78.AIRC219', '4系列生化池.7号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.AIRC220', '4系列生化池.8号生化池2段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.AIRC223', '4系列生化池.7号生化池4段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.AIRC224', '4系列生化池.8号生化池4段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.AIRC227', '4系列生化池.7号生化池6段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.AIRC228', '4系列生化池.8号生化池6段溶解氧DO', '1');
INSERT INTO `init_predict` VALUES ('w78.FR601B', '4系列生化池.4#鼓风机分量', '0');
INSERT INTO `init_predict` VALUES ('w78.TIR207', '4系列生化池.7号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w78.TIR208', '4系列生化池.8号生化池温度', '1');
INSERT INTO `init_predict` VALUES ('w8.BOD5', '环氧乙烷废水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w8.COD', '环氧乙烷废水.COD', '');
INSERT INTO `init_predict` VALUES ('w8.NH3N', '环氧乙烷废水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w8.PH', '环氧乙烷废水.PH', '');
INSERT INTO `init_predict` VALUES ('w8.Q', '环氧乙烷废水.流量', '');
INSERT INTO `init_predict` VALUES ('w8.SS', '环氧乙烷废水.SS', '');
INSERT INTO `init_predict` VALUES ('w83.LIR803', '接触氧化池.1-3号池浓度', '3');
INSERT INTO `init_predict` VALUES ('w83.LIR804', '接触氧化池.4-5号池浓度', '3');
INSERT INTO `init_predict` VALUES ('w85.AIRA801', '排江出口线.出口PH', '1');
INSERT INTO `init_predict` VALUES ('w85.AIRA802', '排江出口线.出口SS', '1');
INSERT INTO `init_predict` VALUES ('w85.AIRA803', '排江出口线.出口COD', '1');
INSERT INTO `init_predict` VALUES ('w85.AIRA804', '排江出口线.出口NH3-N', '1');
INSERT INTO `init_predict` VALUES ('w85.AIRA805', '排江出口线.出口DO', '0');
INSERT INTO `init_predict` VALUES ('w86.FRCQ201', '1系列465回流泵房.回流泵房回流490A3量', '1');
INSERT INTO `init_predict` VALUES ('w86.FRCQ202', '1系列465回流泵房.回流泵房回流490A4量', '1');
INSERT INTO `init_predict` VALUES ('w86.FRQ203', '1系列465回流泵房.回流泵房回流467量', '1');
INSERT INTO `init_predict` VALUES ('w86.LIA201', '1系列465回流泵房.465吸泥池液位', '1');
INSERT INTO `init_predict` VALUES ('w87.FRCQ204', '2系列465A回流泵房.2系列465A回流泵房回流量', '?');
INSERT INTO `init_predict` VALUES ('w87.FRQ205', '2系列465A回流泵房.2系列465A回流泵房剩余量', '?');
INSERT INTO `init_predict` VALUES ('w87.LISA202', '2系列465A回流泵房.465A吸泥池液位', '1');
INSERT INTO `init_predict` VALUES ('w88.FRCQ206', '3系列465B回流泵房.3系列465B回流泵房回流量', '?');
INSERT INTO `init_predict` VALUES ('w88.FRQ207', '3系列465B回流泵房.3系列465B回流泵房剩余量', '?');
INSERT INTO `init_predict` VALUES ('w88.LISA203', '3系列465B回流泵房.465B吸泥池液位', '1');
INSERT INTO `init_predict` VALUES ('w9.BOD5', '农药厂有机水.BOD5', '');
INSERT INTO `init_predict` VALUES ('w9.COD', '农药厂有机水.COD', '');
INSERT INTO `init_predict` VALUES ('w9.NH3N', '农药厂有机水.NH3N', '');
INSERT INTO `init_predict` VALUES ('w9.PH', '农药厂有机水.PH', '');
INSERT INTO `init_predict` VALUES ('w9.Q', '农药厂有机水.流量', '');
INSERT INTO `init_predict` VALUES ('w9.SS', '农药厂有机水.SS', '');
INSERT INTO `init_predict` VALUES ('WW14A.BOD5', '14A生活水.BOD5', '');
INSERT INTO `init_predict` VALUES ('WW14A.COD', '14A生活水.COD', '');
INSERT INTO `init_predict` VALUES ('WW14A.NH3N', '14A生活水.NH3N', '');
INSERT INTO `init_predict` VALUES ('WW14A.PH', '14A生活水.PH', '');
INSERT INTO `init_predict` VALUES ('WW14A.Q', '14A生活水.流量', '');
INSERT INTO `init_predict` VALUES ('WW14A.SS', '14A生活水.SS', '');
INSERT INTO `init_predict` VALUES ('WW14B.BOD5', '14B生活水.BOD5', '');
INSERT INTO `init_predict` VALUES ('WW14B.COD', '14B生活水.COD', '');
INSERT INTO `init_predict` VALUES ('WW14B.NH3N', '14B生活水.NH3N', '');
INSERT INTO `init_predict` VALUES ('WW14B.PH', '14B生活水.PH', '');
INSERT INTO `init_predict` VALUES ('WW14B.Q', '14B生活水.流量', '');
INSERT INTO `init_predict` VALUES ('WW14B.SS', '14B生活水.SS', '');

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
INSERT INTO `pre_dss` VALUES ('w77.AIR201', '3.3191227E-5                                                    ', '           32.560000', '20111218123004', '1');
INSERT INTO `pre_dss` VALUES ('w77.AIR202', '3.3191227E-5                                                    ', '           32.560000', '20111218123004', '2');
INSERT INTO `pre_dss` VALUES ('w78.AIR203', '3.3191824E-5                                                    ', '           32.560000', '20111218123004', '3');
INSERT INTO `pre_dss` VALUES ('w78.AIR204', '3.3191824E-5                                                    ', '           32.560000', '20111218123004', '4');
INSERT INTO `pre_dss` VALUES ('w86.FRCQ201', '1000.00006                                                      ', '           32.560000', '20111218123004', '5');
INSERT INTO `pre_dss` VALUES ('w86.FRCQ202', '1000.00006                                                      ', '           32.560000', '20111218123004', '6');
INSERT INTO `pre_dss` VALUES ('w86.FRCQ203', '17.412443                                                       ', '           32.560000', '20111218123004', '7');
INSERT INTO `pre_dss` VALUES ('w74.AIRC209', '2.9839602                                                       ', '           32.560000', '20111218123004', '8');
INSERT INTO `pre_dss` VALUES ('w74.AIRC210', '2.9864662                                                       ', '           32.560000', '20111218123004', '9');
INSERT INTO `pre_dss` VALUES ('w76.AIRC211', '2.984558                                                        ', '           32.560000', '20111218123004', '10');
INSERT INTO `pre_dss` VALUES ('w76.AIRC212', '2.984558                                                        ', '           32.560000', '20111218123004', '11');
INSERT INTO `pre_dss` VALUES ('w75.AIRC213', '3.006699                                                        ', '           32.560000', '20111218123004', '12');
INSERT INTO `pre_dss` VALUES ('w75.AIRC214', '2.9999924                                                       ', '           32.560000', '20111218123004', '13');
INSERT INTO `pre_dss` VALUES ('w77.AIRC215', '3.0067298                                                       ', '           32.560000', '20111218123004', '14');
INSERT INTO `pre_dss` VALUES ('w76.AIRC216', '2.9999926                                                       ', '           32.560000', '20111218123004', '15');
INSERT INTO `pre_dss` VALUES ('w78.AIRC223', '2.9836466                                                       ', '           32.560000', '20111218123004', '16');
INSERT INTO `pre_dss` VALUES ('w77.AIRC221', '2.9990299                                                       ', '           32.560000', '20111218123004', '17');
INSERT INTO `pre_dss` VALUES ('w77.AIRC222', '2.9990299                                                       ', '           32.560000', '20111218123004', '18');
INSERT INTO `pre_dss` VALUES ('w78.AIRC224', '2.9836466                                                       ', '           32.560000', '20111218123004', '19');
INSERT INTO `pre_dss` VALUES ('w77.AIRC225', '2.9999986                                                       ', '           32.560000', '20111218123004', '20');
INSERT INTO `pre_dss` VALUES ('w77.AIRC226', '2.9999986                                                       ', '           32.560000', '20111218123004', '21');
INSERT INTO `pre_dss` VALUES ('w78.AIRC227', '2.9875658                                                       ', '           32.560000', '20111218123004', '22');
INSERT INTO `pre_dss` VALUES ('w78.AIRC228', '2.9875658                                                       ', '           32.560000', '20111218123004', '23');
INSERT INTO `pre_dss` VALUES ('w76.AIRC205', '2.89104                                                         ', '           32.560000', '20111218123004', '24');
INSERT INTO `pre_dss` VALUES ('w76.AIRC206', '3.000001                                                        ', '           32.560000', '20111218123004', '25');
INSERT INTO `pre_dss` VALUES ('w75.AIRC207', '2.935247                                                        ', '           32.560000', '20111218123004', '26');
INSERT INTO `pre_dss` VALUES ('w75.AIRC208', '2.935247                                                        ', '           32.560000', '20111218123004', '27');
INSERT INTO `pre_dss` VALUES ('w77.AIRC217', '2.876394                                                        ', '           32.560000', '20111218123004', '28');
INSERT INTO `pre_dss` VALUES ('w77.AIRC218', '2.876394                                                        ', '           32.560000', '20111218123004', '29');
INSERT INTO `pre_dss` VALUES ('w78.AIRC219', '2.876436                                                        ', '           32.560000', '20111218123004', '30');
INSERT INTO `pre_dss` VALUES ('w78.AIRC220', '2.876436                                                        ', '           32.560000', '20111218123004', '31');
INSERT INTO `pre_dss` VALUES ('w87.FRCQ204', '1501.2117                                                       ', '           32.560000', '20111218123004', '32');
INSERT INTO `pre_dss` VALUES ('w88.FRCQ206', '1500.0767                                                       ', '           32.560000', '20111218123004', '33');
INSERT INTO `pre_dss` VALUES ('FI101', '525.00037                                                       ', '           32.560000', '20111218123004', '34');
INSERT INTO `pre_dss` VALUES ('FI103', '221.00035                                                       ', '           32.560000', '20111218123004', '35');
INSERT INTO `pre_dss` VALUES ('w62.LDISA101', '0.0                                                             ', '           32.560000', '20111218123004', '36');
INSERT INTO `pre_dss` VALUES ('w62.LDISA102', '0.0                                                             ', '           32.560000', '20111218123004', '37');
INSERT INTO `pre_dss` VALUES ('w62.LDISA103', '0.0                                                             ', '           32.560000', '20111218123004', '38');
INSERT INTO `pre_dss` VALUES ('w62.LISA104', '3.9999905                                                       ', '           32.560000', '20111218123004', '39');
INSERT INTO `pre_dss` VALUES ('w62.AIRA101', '529.8328                                                        ', '           32.560000', '20111218123004', '40');
INSERT INTO `pre_dss` VALUES ('w62.AIRA102', '12.061142                                                       ', '           32.560000', '20111218123004', '41');
INSERT INTO `pre_dss` VALUES ('LDIR105', '0.0                                                             ', '           32.560000', '20111218123004', '42');
INSERT INTO `pre_dss` VALUES ('LI2101', '3.2904353E-9                                                    ', '           32.560000', '20111218123004', '43');
INSERT INTO `pre_dss` VALUES ('LIR106', '6.9999967                                                       ', '           32.560000', '20111218123004', '44');
INSERT INTO `pre_dss` VALUES ('LIR107', '6.9999967                                                       ', '           32.560000', '20111218123004', '45');
INSERT INTO `pre_dss` VALUES ('FR101', '3068.1118                                                       ', '           32.560000', '20111218123004', '46');
INSERT INTO `pre_dss` VALUES ('w63.FRQ101', '2425424.0                                                       ', '           32.560000', '20111218123004', '47');
INSERT INTO `pre_dss` VALUES ('LDISA108', '0.0                                                             ', '           32.560000', '20111218123004', '48');
INSERT INTO `pre_dss` VALUES ('LDISA109', '0.0                                                             ', '           32.560000', '20111218123004', '49');
INSERT INTO `pre_dss` VALUES ('LDISA110', '0.0                                                             ', '           32.560000', '20111218123004', '50');
INSERT INTO `pre_dss` VALUES ('LDISA111', '0.0                                                             ', '           32.560000', '20111218123004', '51');
INSERT INTO `pre_dss` VALUES ('LDISA112', '0.0                                                             ', '           32.560000', '20111218123004', '52');
INSERT INTO `pre_dss` VALUES ('LIA113', '50.0                                                            ', '           32.560000', '20111218123004', '53');
INSERT INTO `pre_dss` VALUES ('w69.LIA114', '6.8999996                                                       ', '           32.560000', '20111218123004', '54');
INSERT INTO `pre_dss` VALUES ('LISA115', '5.2                                                             ', '           32.560000', '20111218123004', '55');
INSERT INTO `pre_dss` VALUES ('LISA116', '1.5000001                                                       ', '           32.560000', '20111218123004', '56');
INSERT INTO `pre_dss` VALUES ('w74.AIRA103', '443.24112                                                       ', '           32.560000', '20111218123004', '57');
INSERT INTO `pre_dss` VALUES ('w74.AIRA104', '19.471039                                                       ', '           32.560000', '20111218123004', '58');
INSERT INTO `pre_dss` VALUES ('AIR105', '119.87818                                                       ', '           32.560000', '20111218123004', '59');
INSERT INTO `pre_dss` VALUES ('w74.AIRA106', '7.0                                                             ', '           32.560000', '20111218123004', '60');
INSERT INTO `pre_dss` VALUES ('w76.LIA117', '3.9999998                                                       ', '           32.560000', '20111218123004', '61');
INSERT INTO `pre_dss` VALUES ('LISA118', '1.5                                                             ', '           32.560000', '20111218123004', '62');
INSERT INTO `pre_dss` VALUES ('w71.LISA119', '4.3000255                                                       ', '           32.560000', '20111218123004', '63');
INSERT INTO `pre_dss` VALUES ('LISA120', '4.3000255                                                       ', '           32.560000', '20111218123004', '64');
INSERT INTO `pre_dss` VALUES ('LISA121', '0.0                                                             ', '           32.560000', '20111218123004', '65');
INSERT INTO `pre_dss` VALUES ('w73.LISA122', '0.0                                                             ', '           32.560000', '20111218123004', '66');
INSERT INTO `pre_dss` VALUES ('w73.LISA123', '0.0                                                             ', '           32.560000', '20111218123004', '67');
INSERT INTO `pre_dss` VALUES ('w73.LISA124', '0.0                                                             ', '           32.560000', '20111218123004', '68');
INSERT INTO `pre_dss` VALUES ('LISA125', '0.0                                                             ', '           32.560000', '20111218123004', '69');
INSERT INTO `pre_dss` VALUES ('w73.FI106', '36.34194                                                        ', '           32.560000', '20111218123004', '70');
INSERT INTO `pre_dss` VALUES ('w73.FI107', '36.34194                                                        ', '           32.560000', '20111218123004', '71');
INSERT INTO `pre_dss` VALUES ('w73.FI108', '36.34194                                                        ', '           32.560000', '20111218123004', '72');
INSERT INTO `pre_dss` VALUES ('w73.FI109', '36.34194                                                        ', '           32.560000', '20111218123004', '73');
INSERT INTO `pre_dss` VALUES ('w73.FI110', '36.34194                                                        ', '           32.560000', '20111218123004', '74');
INSERT INTO `pre_dss` VALUES ('w73.FI111', '36.34194                                                        ', '           32.560000', '20111218123004', '75');
INSERT INTO `pre_dss` VALUES ('FRQ102', '1.0668949E7                                                     ', '           32.560000', '20111218123004', '76');
INSERT INTO `pre_dss` VALUES ('FR102', '1368.6163                                                       ', '           32.560000', '20111218123004', '77');
INSERT INTO `pre_dss` VALUES ('FR103', '109.04428                                                       ', '           32.560000', '20111218123004', '78');
INSERT INTO `pre_dss` VALUES ('w71.FRQ103', '551239.8                                                        ', '           32.560000', '20111218123004', '79');
INSERT INTO `pre_dss` VALUES ('FR104', '109.04428                                                       ', '           32.560000', '20111218123004', '80');
INSERT INTO `pre_dss` VALUES ('w71.FRQ104', '551241.75                                                       ', '           32.560000', '20111218123004', '81');
INSERT INTO `pre_dss` VALUES ('FR105', '0.0                                                             ', '           32.560000', '20111218123004', '82');
INSERT INTO `pre_dss` VALUES ('FRQ105', '0.0                                                             ', '           32.560000', '20111218123004', '83');
INSERT INTO `pre_dss` VALUES ('w62.AIRA107', '7.0                                                             ', '           32.560000', '20111218123004', '84');
INSERT INTO `pre_dss` VALUES ('TIA101', '25.0                                                            ', '           32.560000', '20111218123004', '85');
INSERT INTO `pre_dss` VALUES ('PI101', '0.2                                                             ', '           32.560000', '20111218123004', '86');
INSERT INTO `pre_dss` VALUES ('PIA102', '0.4                                                             ', '           32.560000', '20111218123004', '87');
INSERT INTO `pre_dss` VALUES ('PISA103', '0.0                                                             ', '           32.560000', '20111218123004', '88');
INSERT INTO `pre_dss` VALUES ('w75.AIR229', '7.0                                                             ', '           32.560000', '20111218123004', '89');
INSERT INTO `pre_dss` VALUES ('w76.AIR230', '7.0                                                             ', '           32.560000', '20111218123004', '90');
INSERT INTO `pre_dss` VALUES ('w75.AIR231', '7.0                                                             ', '           32.560000', '20111218123004', '91');
INSERT INTO `pre_dss` VALUES ('w75.AIR232', '7.0                                                             ', '           32.560000', '20111218123004', '92');
INSERT INTO `pre_dss` VALUES ('w77.AIR233', '7.0                                                             ', '           32.560000', '20111218123004', '93');
INSERT INTO `pre_dss` VALUES ('w75.AIR234', '7.0                                                             ', '           32.560000', '20111218123004', '94');
INSERT INTO `pre_dss` VALUES ('w78.AIR235', '7.0                                                             ', '           32.560000', '20111218123004', '95');
INSERT INTO `pre_dss` VALUES ('TI102', '37.14617                                                        ', '           32.560000', '20111218123004', '96');
INSERT INTO `pre_dss` VALUES ('w75.TIR201', '37.003956                                                       ', '           32.560000', '20111218123004', '97');
INSERT INTO `pre_dss` VALUES ('w75.TIR202', '36.997948                                                       ', '           32.560000', '20111218123004', '98');
INSERT INTO `pre_dss` VALUES ('w76.TIR203', '37.00377                                                        ', '           32.560000', '20111218123004', '99');
INSERT INTO `pre_dss` VALUES ('w76.TIR204', '37.004818                                                       ', '           32.560000', '20111218123004', '100');
INSERT INTO `pre_dss` VALUES ('w77.TIR205', '37.030212                                                       ', '           32.560000', '20111218123004', '101');
INSERT INTO `pre_dss` VALUES ('w77.TIR206', '37.030212                                                       ', '           32.560000', '20111218123004', '102');
INSERT INTO `pre_dss` VALUES ('w78.TIR207', '37.029568                                                       ', '           32.560000', '20111218123004', '103');
INSERT INTO `pre_dss` VALUES ('w78.TIR208', '37.029568                                                       ', '           32.560000', '20111218123004', '104');
INSERT INTO `pre_dss` VALUES ('LIA201', '2.5500157                                                       ', '           32.560000', '20111218123004', '105');
INSERT INTO `pre_dss` VALUES ('w87.LISA202', '0.077204034                                                     ', '           32.560000', '20111218123004', '106');
INSERT INTO `pre_dss` VALUES ('LISA203', '0.07714989                                                      ', '           32.560000', '20111218123004', '107');
INSERT INTO `pre_dss` VALUES ('FRQ201', '1450216.2                                                       ', '           32.560000', '20111218123004', '108');
INSERT INTO `pre_dss` VALUES ('FRQ202', '1450216.2                                                       ', '           32.560000', '20111218123004', '109');
INSERT INTO `pre_dss` VALUES ('FR203', '17.412443                                                       ', '           32.560000', '20111218123004', '110');
INSERT INTO `pre_dss` VALUES ('FRQ203', '87057.17                                                        ', '           32.560000', '20111218123004', '111');
INSERT INTO `pre_dss` VALUES ('FRQ204', '903036.06                                                       ', '           32.560000', '20111218123004', '112');
INSERT INTO `pre_dss` VALUES ('FR205', '13.115805                                                       ', '           32.560000', '20111218123004', '113');
INSERT INTO `pre_dss` VALUES ('FRQ205', '69841.86                                                        ', '           32.560000', '20111218123004', '114');
INSERT INTO `pre_dss` VALUES ('FRQ206', '922364.56                                                       ', '           32.560000', '20111218123004', '115');
INSERT INTO `pre_dss` VALUES ('FR207', '13.089564                                                       ', '           32.560000', '20111218123004', '116');
INSERT INTO `pre_dss` VALUES ('FRQ207', '69827.93                                                        ', '           32.560000', '20111218123004', '117');
INSERT INTO `pre_dss` VALUES ('LIR803', '50.000214                                                       ', '           32.560000', '20111218123004', '118');
INSERT INTO `pre_dss` VALUES ('LIR804', '50.000214                                                       ', '           32.560000', '20111218123004', '119');
INSERT INTO `pre_dss` VALUES ('w85.AIRA801', '7.0                                                             ', '           32.560000', '20111218123004', '120');
INSERT INTO `pre_dss` VALUES ('w85.AIRA802', '36.37202                                                        ', '           32.560000', '20111218123004', '121');
INSERT INTO `pre_dss` VALUES ('w85.AIRA803', '70.380936                                                       ', '           32.560000', '20111218123004', '122');
INSERT INTO `pre_dss` VALUES ('w85.AIRA804', '3.4734836                                                       ', '           32.560000', '20111218123004', '123');
INSERT INTO `pre_dss` VALUES ('PI501', '0.0                                                             ', '           32.560000', '20111218123004', '124');
INSERT INTO `pre_dss` VALUES ('FR501', '13.165882                                                       ', '           32.560000', '20111218123004', '125');
INSERT INTO `pre_dss` VALUES ('FRQ501', '103394.125                                                      ', '           32.560000', '20111218123004', '126');

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
