/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : rees

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2012-03-07 20:08:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `data_info`
-- ----------------------------
DROP TABLE IF EXISTS `data_info`;
CREATE TABLE `data_info` (
  `DATA_ID` varchar(50) NOT NULL,
  `PAID` varchar(50) NOT NULL,
  `DATA_INFO` varchar(50) NOT NULL,
  `WEEK_OF_YEAR` int(11) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`DATA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_info
-- ----------------------------

-- ----------------------------
-- Table structure for `device_info`
-- ----------------------------
DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info` (
  `ID` varchar(50) NOT NULL,
  `DEVICE _NUM` varchar(50) DEFAULT NULL,
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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_info
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_issue_info`
-- ----------------------------
DROP TABLE IF EXISTS `forum_issue_info`;
CREATE TABLE `forum_issue_info` (
  `ID` varchar(50) NOT NULL,
  `ISSUE_NAME` varchar(500) NOT NULL,
  `ISSUE_CONTENT` varchar(2000) DEFAULT NULL,
  `ISSUE_STATUS` int(11) NOT NULL DEFAULT '1',
  `CREATOR` varchar(50) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
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
  `ID` varchar(50) NOT NULL,
  `ISSUE_ID` varchar(50) NOT NULL,
  `MESSAGE_CONTENT` varchar(500) NOT NULL,
  `PUBLISHER_DEPT` varchar(50) NOT NULL,
  `PUBLISHER` varchar(50) NOT NULL,
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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_user
-- ----------------------------

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
  `ID` varchar(50) NOT NULL,
  `NOTICE_TITLE` varchar(200) NOT NULL,
  `NOTICE_CONTENT` varchar(500) NOT NULL,
  `NOTICE_PUBLISHTIME` datetime NOT NULL,
  `NOTICE_EXPIREDTIME` datetime NOT NULL,
  `PUBLISHER` varchar(50) NOT NULL,
  `PUBLISHER_DEPT` varchar(50) NOT NULL,
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
  `NOTICE_ID` varchar(50) NOT NULL,
  `USER_ID` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of notice_read_info
-- ----------------------------

-- ----------------------------
-- Table structure for `person_report`
-- ----------------------------
DROP TABLE IF EXISTS `person_report`;
CREATE TABLE `person_report` (
  `ID` varchar(50) NOT NULL DEFAULT '' COMMENT '主键',
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
-- Table structure for `point_info`
-- ----------------------------
DROP TABLE IF EXISTS `point_info`;
CREATE TABLE `point_info` (
  `ID` varchar(50) NOT NULL,
  `DEVICE_ID` varchar(50) DEFAULT NULL,
  `CONTROL_POINT_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point_info
-- ----------------------------

-- ----------------------------
-- Table structure for `template_report`
-- ----------------------------
DROP TABLE IF EXISTS `template_report`;
CREATE TABLE `template_report` (
  `ID` varchar(50) NOT NULL,
  `TEMPLATE_NAME` varchar(200) DEFAULT NULL,
  `TEMPLATE_PATH` varchar(500) DEFAULT NULL,
  `DEPT_ID` varchar(50) NOT NULL,
  `ISDELETE` int(11) DEFAULT NULL COMMENT '0：正常 1：已删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of template_report
-- ----------------------------
