/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : rees

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2012-04-26 21:10:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `device_info`
-- ----------------------------
DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info` (
  `ID` varchar(50) NOT NULL,
  `DEVICE_NUM` varchar(50) DEFAULT NULL,
  `DEVICE_TYPE` varchar(50) DEFAULT NULL,
  `DEVICE_NAME` varchar(200) NOT NULL,
  `DEVICE_MODEL` varchar(200) DEFAULT NULL,
  `DEVICE_FACTORY` varchar(200) DEFAULT NULL,
  `FILE_PATH` varchar(200) DEFAULT NULL,
  `CONTROL_POINT` int(11) DEFAULT '0',
  `SORT_INDEX` int(11) DEFAULT '0',
  `CREATE_TIME` datetime DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DEPT_ID` varchar(50) NOT NULL,
  `GROUP_ID` varchar(50) NOT NULL,
  `CENTER_HEIGHT` decimal(19,2) DEFAULT NULL,
  `DEVICE_TYPE_ID` varchar(255) DEFAULT NULL,
  `POWER` decimal(19,2) DEFAULT NULL,
  `SPEED` decimal(19,2) DEFAULT NULL,
  `DEVICE_TYPE_NAME` varchar(255) DEFAULT NULL,
  `FACTORY_ID` varchar(255) DEFAULT NULL,
  `POINT_NATURAL_VALUE` decimal(19,2) DEFAULT NULL,
  `POINT_WARN_VALUE` decimal(19,2) DEFAULT NULL,
  `WORKSHOP_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_info
-- ----------------------------
INSERT INTO `device_info` VALUES ('402881e4363922bf01363923943b0000', '', '6', '6', '6', '6', '', '6', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `device_info` VALUES ('402881e4363922bf0136392394440001', '6', '6', '6', '6', '6', 'http://6.com', '6', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `device_info` VALUES ('402881e436477c8e0136477e18d20000', '', '6', '6', '6', '6', 'http://6.com', '6', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `device_info` VALUES ('402881e436477c8e0136477e18d20001', '', '6', '6', '6', '6', 'http://6.com', '6', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `device_info` VALUES ('402881e436477c8e01364780a1050002', '4', '4', '4', '4', '4', '', '0', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `device_info` VALUES ('402881e436477c8e01364780a1150003', '4', '4', '4', '4', '4', '', '0', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `device_info` VALUES ('402881f636249bff013624a666eb0000', '33', '33', '33', '3', '3', '3', '3', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `device_info` VALUES ('402881f63628b41a013628c0d4320000', '1', '1', '1', '1', '1', '1', '1', null, null, null, '1', '1', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `device_point_data`
-- ----------------------------
DROP TABLE IF EXISTS `device_point_data`;
CREATE TABLE `device_point_data` (
  `id` varchar(255) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `DATA_INFO` varchar(255) DEFAULT NULL,
  `DATA_YEAR` int(11) DEFAULT NULL,
  `DEVICE_ID` varchar(255) DEFAULT NULL,
  `PARAM_ID` varchar(255) DEFAULT NULL,
  `POINT_ID` varchar(255) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `WEEK_OF_YEAR` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_point_data
-- ----------------------------

-- ----------------------------
-- Table structure for `device_point_info`
-- ----------------------------
DROP TABLE IF EXISTS `device_point_info`;
CREATE TABLE `device_point_info` (
  `ID` varchar(50) NOT NULL,
  `DEVICE_ID` varchar(50) DEFAULT NULL,
  `CONTROL_POINT_NAME` varchar(100) DEFAULT NULL,
  `POSITIONX` int(11) DEFAULT NULL,
  `POSITIONY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_point_info
-- ----------------------------

-- ----------------------------
-- Table structure for `device_point_param`
-- ----------------------------
DROP TABLE IF EXISTS `device_point_param`;
CREATE TABLE `device_point_param` (
  `ID` varchar(50) NOT NULL,
  `POINT_ID` varchar(50) DEFAULT NULL,
  `PAID` varchar(50) NOT NULL,
  `DATA_INFO` varchar(50) NOT NULL,
  `WEEK_OF_YEAR` int(11) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `DEVICE_ID` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `SORT_INDEX` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_point_param
-- ----------------------------
INSERT INTO `device_point_param` VALUES ('1', null, '22', '22', '22', '22', '2012-03-14 20:40:15', null, null, null);
INSERT INTO `device_point_param` VALUES ('23', null, '324', '234', '324', '324324', '2012-03-14 20:41:11', null, null, null);
INSERT INTO `device_point_param` VALUES ('234', null, '234', '32423', '324', '23423', '2012-03-14 20:41:18', null, null, null);
INSERT INTO `device_point_param` VALUES ('23434', null, '234234', '3432', '4234', '234', '2012-03-14 20:41:28', null, null, null);

-- ----------------------------
-- Table structure for `device_type`
-- ----------------------------
DROP TABLE IF EXISTS `device_type`;
CREATE TABLE `device_type` (
  `ID` varchar(50) NOT NULL,
  `DEVICE_TYPE` varchar(200) NOT NULL,
  `CENTER_HEIGHT` int(11) DEFAULT NULL,
  `SPEED` int(11) DEFAULT NULL,
  `POWER` int(11) DEFAULT NULL,
  `POINT_NATURAL_VALUE` decimal(19,2) DEFAULT NULL,
  `POINT_WARN_VALUE` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_type
-- ----------------------------
INSERT INTO `device_type` VALUES ('1', 'aaaa', '2', '2', '2', null, null);
INSERT INTO `device_type` VALUES ('2', '11', '2', '2', '2', null, null);
INSERT INTO `device_type` VALUES ('402881e8366c496101366c4999110000', '1', '1', '1', '1', null, null);
INSERT INTO `device_type` VALUES ('402881e8368291e601368293a92a0000', '22', '22', '22', '22', null, null);

-- ----------------------------
-- Table structure for `forum_issue_info`
-- ----------------------------
DROP TABLE IF EXISTS `forum_issue_info`;
CREATE TABLE `forum_issue_info` (
  `ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ISSUE_NAME` varchar(500) CHARACTER SET utf8 NOT NULL,
  `ISSUE_CONTENT` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `ISSUE_STATUS` int(11) NOT NULL DEFAULT '1',
  `CREATOR` varchar(50) CHARACTER SET utf8 NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `ISSUE_CONTEIT` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ISSUE_ID` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `MESSAGE_CONTENT` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `MESSAGE_TIME` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `PUBLISHER` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `PUBLISHER_DEPT` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ISSUE_ID` (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of forum_issue_info
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_message_info`
-- ----------------------------
DROP TABLE IF EXISTS `forum_message_info`;
CREATE TABLE `forum_message_info` (
  `ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ISSUE_ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `MESSAGE_CONTENT` varchar(500) CHARACTER SET utf8 NOT NULL,
  `PUBLISHER_DEPT` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PUBLISHER` varchar(50) CHARACTER SET utf8 NOT NULL,
  `MESSAGE_TIME` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `MESSAGE_ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of forum_message_info
-- ----------------------------

-- ----------------------------
-- Table structure for `group_company`
-- ----------------------------
DROP TABLE IF EXISTS `group_company`;
CREATE TABLE `group_company` (
  `COMPANY_NAME` varchar(50) DEFAULT NULL,
  `ROOT_ID` varchar(50) DEFAULT NULL,
  `SORT_INDEX` int(4) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `PHONE` varchar(200) DEFAULT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_company
-- ----------------------------
INSERT INTO `group_company` VALUES ('2', null, '99', '2012-03-30 15:45:04', '2', '2', '402881e836628fe2013662908ee60001');

-- ----------------------------
-- Table structure for `group_factory`
-- ----------------------------
DROP TABLE IF EXISTS `group_factory`;
CREATE TABLE `group_factory` (
  `ID` varchar(50) NOT NULL,
  `COMPANY_ID` varchar(50) DEFAULT NULL,
  `FACTORY_NAME` varchar(50) DEFAULT NULL,
  `PHONE` varchar(200) DEFAULT NULL,
  `PRINCIPAL` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `SORT_INDEX` int(4) DEFAULT NULL,
  `PRICIPAL` varchar(255) DEFAULT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(255) DEFAULT NULL,
  `ROLE_NAME` varchar(255) DEFAULT NULL,
  `FACTORY_ID` varchar(255) DEFAULT NULL,
  `WORKSHOP_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_factory
-- ----------------------------

-- ----------------------------
-- Table structure for `group_popedom_role`
-- ----------------------------
DROP TABLE IF EXISTS `group_popedom_role`;
CREATE TABLE `group_popedom_role` (
  `ID` varchar(50) NOT NULL,
  `ROLE_ID` varchar(50) DEFAULT NULL,
  `KEYWORD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_popedom_role
-- ----------------------------

-- ----------------------------
-- Table structure for `group_role`
-- ----------------------------
DROP TABLE IF EXISTS `group_role`;
CREATE TABLE `group_role` (
  `ID` varchar(50) NOT NULL,
  `ROLE_NAME` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `SORT_INDEX` int(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_role
-- ----------------------------

-- ----------------------------
-- Table structure for `group_user`
-- ----------------------------
DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user` (
  `ID` varchar(50) NOT NULL,
  `COMPANY_ID` varchar(50) DEFAULT NULL,
  `FACTORY_ID` varchar(50) DEFAULT NULL,
  `WORKSHOP_ID` varchar(50) DEFAULT NULL,
  `ROLE_ID` varchar(50) DEFAULT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `USERCNAME` varchar(50) DEFAULT NULL,
  `OFFICE_PHONE` varchar(200) DEFAULT NULL,
  `PHONE` varchar(200) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `USER_TYPE` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `SORT_INDEX` int(4) DEFAULT NULL,
  `deleteFlag` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_user
-- ----------------------------
INSERT INTO `group_user` VALUES ('1', null, null, null, null, 'admin', 'b59c67bf196a4758191e42f76670ceba', '超级管理员', null, null, null, '9', '2012-04-03 15:24:33', '0', '0');

-- ----------------------------
-- Table structure for `group_workshop`
-- ----------------------------
DROP TABLE IF EXISTS `group_workshop`;
CREATE TABLE `group_workshop` (
  `ID` varchar(50) NOT NULL,
  `FACTORY_ID` varchar(50) DEFAULT NULL,
  `WORKSHOP_NAME` varchar(50) DEFAULT NULL,
  `PHONE` varchar(200) DEFAULT NULL,
  `PRINCIPAL` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `SORT_INDEX` int(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_workshop
-- ----------------------------

-- ----------------------------
-- Table structure for `notice_info`
-- ----------------------------
DROP TABLE IF EXISTS `notice_info`;
CREATE TABLE `notice_info` (
  `ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `NOTICE_TITLE` varchar(200) CHARACTER SET utf8 NOT NULL,
  `NOTICE_CONTENT` varchar(500) CHARACTER SET utf8 NOT NULL,
  `NOTICE_PUBLISHTIME` datetime NOT NULL,
  `NOTICE_EXPIREDTIME` datetime NOT NULL,
  `PUBLISHER` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PUBLISHER_DEPT` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NOTICE_ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of notice_info
-- ----------------------------

-- ----------------------------
-- Table structure for `notice_read_info`
-- ----------------------------
DROP TABLE IF EXISTS `notice_read_info`;
CREATE TABLE `notice_read_info` (
  `NOTICE_ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `USER_ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`NOTICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of notice_read_info
-- ----------------------------

-- ----------------------------
-- Table structure for `person_report`
-- ----------------------------
DROP TABLE IF EXISTS `person_report`;
CREATE TABLE `person_report` (
  `ID` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '主键',
  `REPORT_TYPE` varchar(50) DEFAULT NULL COMMENT '汇报类型',
  `REPORT_SUBJECT` varchar(50) DEFAULT NULL COMMENT '汇报题目',
  `REPORT_PERSON` varchar(50) DEFAULT NULL,
  `REPORT_DATE` datetime DEFAULT NULL,
  `REPORT_CONTENT` varchar(2000) DEFAULT NULL,
  `TEMPLATE_ID` varchar(50) DEFAULT NULL,
  `REPORT_STATE` int(11) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `DEPT_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person_report
-- ----------------------------

-- ----------------------------
-- Table structure for `report_person`
-- ----------------------------
DROP TABLE IF EXISTS `report_person`;
CREATE TABLE `report_person` (
  `id` varchar(255) NOT NULL,
  `DEPT_ID` varchar(255) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `REPORT_CONTENT` varchar(255) DEFAULT NULL,
  `REPORT_DATE` datetime DEFAULT NULL,
  `REPORT_PERSON` varchar(255) DEFAULT NULL,
  `REPORT_STATE` int(11) DEFAULT NULL,
  `REPORT_SUBJECT` varchar(255) DEFAULT NULL,
  `REPORT_TYPE` varchar(255) DEFAULT NULL,
  `TEMPLATE_ID` varchar(255) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report_person
-- ----------------------------

-- ----------------------------
-- Table structure for `report_template`
-- ----------------------------
DROP TABLE IF EXISTS `report_template`;
CREATE TABLE `report_template` (
  `id` varchar(255) NOT NULL,
  `DEPT_ID` varchar(255) DEFAULT NULL,
  `ISDELETE` int(11) DEFAULT NULL,
  `TEMPLATE_NAME` varchar(255) DEFAULT NULL,
  `TEMPLATE_PATH` varchar(255) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `REPORT_CONTENT` varchar(255) DEFAULT NULL,
  `REPORT_DATE` datetime DEFAULT NULL,
  `REPORT_PERSON` varchar(255) DEFAULT NULL,
  `REPORT_SUBJECT` varchar(255) DEFAULT NULL,
  `REPORT_TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report_template
-- ----------------------------

-- ----------------------------
-- Table structure for `rule_advice_info`
-- ----------------------------
DROP TABLE IF EXISTS `rule_advice_info`;
CREATE TABLE `rule_advice_info` (
  `ADVICE_ID` int(50) NOT NULL AUTO_INCREMENT,
  `ADVICE` varchar(500) DEFAULT NULL,
  `DEVICE_TYPE_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ADVICE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_advice_info
-- ----------------------------
INSERT INTO `rule_advice_info` VALUES ('22', 'fdsf', '2');
INSERT INTO `rule_advice_info` VALUES ('123', '12321', '2');
INSERT INTO `rule_advice_info` VALUES ('125', 'rerrrrrr', '402881e8368291e601368293a92a0000');

-- ----------------------------
-- Table structure for `rule_device_info`
-- ----------------------------
DROP TABLE IF EXISTS `rule_device_info`;
CREATE TABLE `rule_device_info` (
  `DEVICE_ID` int(50) NOT NULL,
  `DEVICE_PARAM` varchar(100) DEFAULT NULL,
  `DEVICE_TYPE_ID` int(50) NOT NULL,
  `DEVICE_VAR` varchar(100) DEFAULT NULL,
  `RESULT_ID` int(11) NOT NULL,
  PRIMARY KEY (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_device_info
-- ----------------------------

-- ----------------------------
-- Table structure for `rule_info`
-- ----------------------------
DROP TABLE IF EXISTS `rule_info`;
CREATE TABLE `rule_info` (
  `ID` int(50) NOT NULL,
  `DEVICE_TYPE_ID` int(50) NOT NULL,
  `RESULT_ID` int(50) NOT NULL,
  `REASON_ID` int(50) NOT NULL,
  `ADVICE_ID` int(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_info
-- ----------------------------

-- ----------------------------
-- Table structure for `rule_reason_info`
-- ----------------------------
DROP TABLE IF EXISTS `rule_reason_info`;
CREATE TABLE `rule_reason_info` (
  `REASON_ID` int(50) NOT NULL AUTO_INCREMENT,
  `REASON` varchar(500) DEFAULT NULL,
  `DEVICE_TYPE_ID` varchar(11) NOT NULL,
  PRIMARY KEY (`REASON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_reason_info
-- ----------------------------

-- ----------------------------
-- Table structure for `rule_result_info`
-- ----------------------------
DROP TABLE IF EXISTS `rule_result_info`;
CREATE TABLE `rule_result_info` (
  `RESULT_ID` int(50) NOT NULL AUTO_INCREMENT,
  `RESULT` varchar(500) DEFAULT NULL,
  `DEVICE_TYPE_ID` varchar(11) NOT NULL,
  PRIMARY KEY (`RESULT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_result_info
-- ----------------------------

-- ----------------------------
-- Table structure for `table1`
-- ----------------------------
DROP TABLE IF EXISTS `table1`;
CREATE TABLE `table1` (
  `id` varchar(255) NOT NULL,
  `Demo_Age` int(11) DEFAULT NULL,
  `Demo_Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table1
-- ----------------------------
INSERT INTO `table1` VALUES ('402881e836d441170136d4417c5f0000', '22', '222');
INSERT INTO `table1` VALUES ('402881e836d441170136d44248df0001', '33', '33');

-- ----------------------------
-- Table structure for `template_report`
-- ----------------------------
DROP TABLE IF EXISTS `template_report`;
CREATE TABLE `template_report` (
  `ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `TEMPLATE_NAME` varchar(200) DEFAULT NULL,
  `TEMPLATE_PATH` varchar(500) DEFAULT NULL,
  `DEPT_ID` varchar(50) NOT NULL,
  `ISDELETE` int(11) DEFAULT NULL COMMENT '0：正常 1：已删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of template_report
-- ----------------------------

-- ----------------------------
-- View structure for `advice_view`
-- ----------------------------
DROP VIEW IF EXISTS `advice_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `advice_view` AS select `rule_advice_info`.`ADVICE_ID` AS `ADVICE_ID`,`rule_advice_info`.`ADVICE` AS `ADVICE`,`rule_advice_info`.`DEVICE_TYPE_ID` AS `DEVICE_TYPE_ID`,`device_type`.`DEVICE_TYPE` AS `DEVICE_TYPE`,`device_type`.`ID` AS `ID` from (`rule_advice_info` join `device_type`) where (`device_type`.`ID` = `rule_advice_info`.`DEVICE_TYPE_ID`);
