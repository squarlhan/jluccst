/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50157
Source Host           : localhost:3306
Source Database       : wushuichang

Target Server Type    : MYSQL
Target Server Version : 50157
File Encoding         : 65001

Date: 2011-11-19 14:59:10
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
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=315 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandreason
-- ----------------------------
INSERT INTO `backwardandreason` VALUES ('1', '16', '中和站', '0', '控制不好', '增加测试PH频次，向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('3', '18', '中和站', '0', '控制不好', '测试PH频次增加，向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('4', '19', '进水', '0', '有油渣', '向生产科汇报，经允许后提高稳流池水位，油渣从14H线超越');
INSERT INTO `backwardandreason` VALUES ('7', '22', '空气量', '0', '分配不均', '向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('8', '22', '曝气头', '0', '堵塞', '向车间工艺工程师');
INSERT INTO `backwardandreason` VALUES ('9', '23', '排泥', '0', '不好', '检查排泥系统有无堵塞，加大排泥量');
INSERT INTO `backwardandreason` VALUES ('10', '23', '进水SS', '0', '含有不易沉降物质', '与生产科协商，加大水解酸化系统絮凝剂投加量');
INSERT INTO `backwardandreason` VALUES ('11', '23', '进水SS', '0', '负荷过高', '向生产科汇报');
INSERT INTO `backwardandreason` VALUES ('12', '24', '三个初沉池', '0', '配水不均', '调节配水，向三个初沉池重新分配水量');
INSERT INTO `backwardandreason` VALUES ('13', '24', '三个初沉池', '0', '排泥时间分配不合理', '调节三个初沉池排泥时间。适当延长出水SS浓度高的初沉池排泥时间，至恢复正常为止');
INSERT INTO `backwardandreason` VALUES ('14', '24', '三个初沉池', '0', '存在排泥不畅现象', '检查三个初沉池排泥管线及排泥阀，有堵塞的及时向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('15', '25', '进泥', '0', '负荷过大', '降低浓缩池进泥量');
INSERT INTO `backwardandreason` VALUES ('16', '25', '脱水设备', '0', '拿泥与进泥量不平衡', '增大进泥负荷，增加进泥负荷，增加脱水污泥量');
INSERT INTO `backwardandreason` VALUES ('17', '25', '进泥', '0', '浓缩性能不好，污泥不沉降', '向车间工艺工程师汇报，降低浓缩池进泥负荷，延长污泥浓缩时间');
INSERT INTO `backwardandreason` VALUES ('18', '26', '投料', '0', '过量', '适当关小混合罐的进泥，进药阀门');
INSERT INTO `backwardandreason` VALUES ('19', '26', '冲洗效果', '0', '不好', '将冲洗水喷头拆下清洗');
INSERT INTO `backwardandreason` VALUES ('20', '26', '滤带', '0', '张紧压力过大', '适当降低张力，调整张紧压');
INSERT INTO `backwardandreason` VALUES ('21', '26', '泥质', '0', '变化或含油', '精心调节');
INSERT INTO `backwardandreason` VALUES ('22', '27', '冲洗', '0', '不彻底', '加大水压，清洗冲水孔');
INSERT INTO `backwardandreason` VALUES ('23', '28', '絮凝', '0', '不好', '调节絮凝剂投加量，至絮凝效果满足生产要求为止，向车间工艺工程师汇报');
INSERT INTO `backwardandreason` VALUES ('24', '28', '滤带', '0', '冲洗不好', '增加冲洗水水阀，加大冲洗水压力和水量，即使清理冲水孔');
INSERT INTO `backwardandreason` VALUES ('25', '28', '滤带', '0', '张紧度不适宜', '调节滤带张紧压力，至满足生产要求为止');
INSERT INTO `backwardandreason` VALUES ('26', '29', '滤带', '0', '张紧压力小', '增大滤带张紧压力，至适宜为止');
INSERT INTO `backwardandreason` VALUES ('27', '29', '滤带', '0', '冲洗效果不好', '增加冲洗水量和提高冲洗水压，即使清通冲洗水管及喷嘴');
INSERT INTO `backwardandreason` VALUES ('28', '29', '带速', '0', '过大', '适当降低带速');
INSERT INTO `backwardandreason` VALUES ('29', '30', '相对速度', '0', '不适宜', '调整相对速度');
INSERT INTO `backwardandreason` VALUES ('30', '30', '转鼓速度', '0', '不适宜', '调整转鼓速度');
INSERT INTO `backwardandreason` VALUES ('31', '30', '液位', '0', '不合适', '调整液位');
INSERT INTO `backwardandreason` VALUES ('32', '30', '污泥泵流量', '0', '不适宜', '调整污泥泵流量');
INSERT INTO `backwardandreason` VALUES ('33', '30', '浓度', '0', '不适宜', '调整浓度');
INSERT INTO `backwardandreason` VALUES ('34', '30', '药泵流量', '0', '不适宜', '调整药泵流量');
INSERT INTO `backwardandreason` VALUES ('35', '30', '絮凝剂质量', '0', '有问题', '分析絮凝剂质量');
INSERT INTO `backwardandreason` VALUES ('36', '30', '干泥箱被塞满', '0', '主固体继续从转鼓上排出', '清理干泥箱');
INSERT INTO `backwardandreason` VALUES ('37', '30', '皮带打滑所以相对速度变低', '0', '引起分离固体的不充分排料', '调整相对速度');
INSERT INTO `backwardandreason` VALUES ('38', '31', '絮凝剂的质量', '0', '有问题', '分析絮凝剂质量');
INSERT INTO `backwardandreason` VALUES ('39', '31', '加入量', '0', '不合适', '调整药量');
INSERT INTO `backwardandreason` VALUES ('40', '32', '进泥泵', '0', '堵塞', '处理泥泵');
INSERT INTO `backwardandreason` VALUES ('41', '32', '进泥', '0', '浓度太低', '提高污泥浓度');
INSERT INTO `backwardandreason` VALUES ('42', '32', '相对速度', '0', '小', '检查弹性环，是否剪断，检查皮带是否松，固体是否与螺旋一起转动，螺旋输送器是否塞满，干泥出口箱堵塞');
INSERT INTO `backwardandreason` VALUES ('43', '33', '润滑油', '0', '缺少', '加油至正常位置');
INSERT INTO `backwardandreason` VALUES ('44', '33', '润滑油', '0', '变质或乳化', '更换润滑油');
INSERT INTO `backwardandreason` VALUES ('45', '33', '振动增大', '0', '引起轴间隙变化', '查明原因，解体检修，消除故障，保证机组运行平稳');
INSERT INTO `backwardandreason` VALUES ('46', '34', '安全销', '0', '断裂', '处理更换安全销');
INSERT INTO `backwardandreason` VALUES ('48', '36', '有大块固体', '0', '卡住梳齿', '按停车步骤停机机械格栅机，清除杂物');
INSERT INTO `backwardandreason` VALUES ('49', '36', '传动轴轴承', '0', '损坏', '按停车步骤停机格栅机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('52', '38', '轴端卡环', '0', '丢失', '按停车步骤停机机械格栅机，及时安装卡环');
INSERT INTO `backwardandreason` VALUES ('53', '38', '耙齿上', '0', '堆挂杂物', '按停车步骤停机格栅机，清除杂物');
INSERT INTO `backwardandreason` VALUES ('54', '38', '运行中有大块障碍物', '0', '卡阻', '按停车步骤停机格栅机，检查，排除故障');
INSERT INTO `backwardandreason` VALUES ('55', '39', '中心轴承或轮轴承', '0', '缺油', '加注润滑油');
INSERT INTO `backwardandreason` VALUES ('56', '39', '胶轮或轮到损坏', '0', '导流筒变形，拉杆碰撞', '按停车步骤停下刮泥机，通知电工切断电源，同时通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('57', '40', '脚轮轴承', '0', '失效', '按停车步骤停下刮泥机，通知电工切断电源，同时通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('58', '40', '水下刮板拉杆', '0', '开裂', '按停车步骤停下刮泥机。通知电工切断电源，同时通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('59', '41', '刮板', '0', '磨损，腐蚀变薄', '按停机步骤停下刮砂机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('60', '42', '刮板', '0', '磨损，腐蚀变薄', '按停车步骤停下刮砂机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('61', '43', '开口销或销轴', '0', '损坏', '按停车步骤停下刮砂机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('62', '43', '链节', '0', '断裂', '按停车步骤停下刮砂机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('63', '44', '刮砂', '0', '负荷大', '按停车步骤停下刮砂机，若是沙量过高，影响刮砂机负荷，适当调小该廊道进水阀和加大该廊道通风阀，若是设备问题，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('64', '45', '水下沉砂', '0', '过多', '按停车步骤停下刮砂机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('65', '45', '水下从动链轮', '0', '失效', '按停车步骤停下刮砂机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('66', '46', '管路，叶轮', '0', '被堵', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('67', '46', '耐磨圈', '0', '磨损严重', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('68', '46', '叶轮', '0', '脱落或损坏', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('69', '46', '泵', '0', '脱离滑道倾倒于池中', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('70', '47', '管路，叶轮', '0', '被堵', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('71', '47', '耐磨圈', '0', '磨损严重', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('72', '47', '叶轮', '0', '脱落或损坏', '按开车步骤起动备用泵停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('73', '47', '泵', '0', '脱离滑道，倾倒于池中', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('74', '48', '叶轮', '0', '损坏', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('75', '48', '叶轮', '0', '动不平衡', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('76', '48', '轴承', '0', '损坏', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('77', '49', '工作电压', '0', '过低', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('78', '49', '叶轮', '0', '缠绕杂物', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('79', '49', '轴承', '0', '损坏', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('80', '49', '止回阀', '0', '损坏，开启不到位', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('81', '50', '工作电压', '0', '过低', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('82', '50', '叶轮', '0', '缠绕杂物', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('83', '50', '轴承', '0', '损坏', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('84', '50', '止回阀', '0', '损坏，开启不到位', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('85', '51', '水泵侧机封', '0', '故障', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('86', '52', '电机侧机封', '0', '缺陷', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('87', '52', '堵头', '0', '松动进水', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('88', '52', '“o”型圈', '0', '失效进水', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('89', '53', '进线密封盖', '0', '没压紧', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('90', '53', '电缆', '0', '损坏', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('91', '54', '泵内或吸入管道内', '0', '存有空气', '按开车步骤起动备用泵，停运行泵，排出空气');
INSERT INTO `backwardandreason` VALUES ('92', '54', '管道阀门或叶轮', '0', '堵塞', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('93', '54', '叶轮、密封圈、油封', '0', '磨损严重或损坏', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('94', '54', '管路', '0', '干泥淤堵', '按步骤停动行泵，检查阀门管线堵塞情况');
INSERT INTO `backwardandreason` VALUES ('95', '55', '泵内', '0', '无介质', '按停车步骤停运行泵，调整污泥池液位使其在控制范围之内，然后按开车步骤起动运行泵');
INSERT INTO `backwardandreason` VALUES ('96', '55', '出口阀门', '0', '堵塞', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('97', '55', '出口阀门', '0', '未开', '打开出口阀');
INSERT INTO `backwardandreason` VALUES ('98', '55', '叶轮', '0', '内有杂物缠绕', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('99', '56', '润滑油', '0', '不足或油中有杂质', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('100', '56', '轴封', '0', '过紧', '略微松动填料压盖');
INSERT INTO `backwardandreason` VALUES ('101', '56', '轴承', '0', '损坏', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('102', '56', '轴承', '0', '间隙不当', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('103', '56', '泵轴和电机轴', '0', '不同心', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('104', '57', '轴承', '0', '损坏', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('105', '57', '转轴', '0', '弯曲', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('106', '57', '叶轮', '0', '损坏或动不平衡', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('107', '57', '泵壳内', '0', '有大块杂物', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('108', '57', '地脚螺栓', '0', '松动', '紧固地脚螺栓');
INSERT INTO `backwardandreason` VALUES ('109', '57', '泵内', '0', '无物料输送', '停运行泵，检查处理');
INSERT INTO `backwardandreason` VALUES ('110', '58', '转子，定子', '0', '配合过紧', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('111', '58', '泵内', '0', '有异物卡住', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('112', '58', '沉淀泥', '0', '塞满泵内', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('113', '58', '出口管路', '0', '堵塞', '按开车步骤起动备用泵，停运行泵，清理出口管路');
INSERT INTO `backwardandreason` VALUES ('114', '59', '泵', '0', '旋向错误', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('115', '59', '吸入管或泵轴封', '0', '泄漏', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('116', '59', '吸入阀', '0', '开度不够', '开大吸入阀');
INSERT INTO `backwardandreason` VALUES ('117', '59', '泵内工作部件', '0', '磨损严重', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('118', '60', '泵', '0', '旋向错误', '按开车步骤起动备用泵，停运行泵，通知电工');
INSERT INTO `backwardandreason` VALUES ('119', '60', '吸入管或泵轴封', '0', '泄漏', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('120', '60', '吸入阀', '0', '开度不够', '开大吸入阀');
INSERT INTO `backwardandreason` VALUES ('121', '60', '泵内工作部件', '0', '磨损严重', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('122', '61', '转子，定子', '0', '磨损', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('123', '61', '吸入管', '0', '进气或堵塞', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('124', '62', '泵轴和电机轴', '0', '不同心，轴承损坏', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('125', '62', '介质内', '0', '有大块杂物', '按开车步骤起动备用泵，停运行泵，处理');
INSERT INTO `backwardandreason` VALUES ('126', '63', '流量', '0', '负荷过大', '适当关小出口阀门，降低流量');
INSERT INTO `backwardandreason` VALUES ('127', '63', '润滑油', '0', '缺油或油质不合格', '按开车步骤起动备用泵，停运行泵，注油');
INSERT INTO `backwardandreason` VALUES ('128', '64', '自动调偏', '0', '失灵', '按开车步骤起动备用泵，停运行泵，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('129', '64', '张紧气缸', '0', '压力不平衡', '调节两侧张紧气缸压缩空气控制开关，调整张紧气缸压力至平衡');
INSERT INTO `backwardandreason` VALUES ('130', '64', '滤带', '0', '进泥厚薄不均', '通过清理带式压榨过滤机进泥口污泥流道，使布泥均匀');
INSERT INTO `backwardandreason` VALUES ('131', '64', '调偏滚', '0', '不动作', '按开车步骤开备机，停运行机，注油，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('132', '64', '气缸', '0', '供气压力不足', '减少带式压榨过滤机运行台数，保持各气缸压力平衡，与厂调联系，提高压缩空气压力');
INSERT INTO `backwardandreason` VALUES ('133', '65', '连接', '0', '不好', '按开车步骤开备机，停运行机，组织人员重新连接好');
INSERT INTO `backwardandreason` VALUES ('134', '65', '经常', '0', '跑偏', '按开车步骤开备机，停运行机，对调偏装置进行检修或更换，使调偏装置灵活好用');
INSERT INTO `backwardandreason` VALUES ('135', '65', '异物', '0', '刮带', '按开车步骤开备机，停运行机，细致检查清除异物');
INSERT INTO `backwardandreason` VALUES ('136', '66', '滚子轴承', '0', '缺油或损坏', '按开车步骤开备机，停运行机，加润滑油至油盒充满或更换轴承');
INSERT INTO `backwardandreason` VALUES ('137', '66', '紧固螺栓', '0', '松动', '重新紧固');
INSERT INTO `backwardandreason` VALUES ('138', '67', '滚轮', '0', '位置偏斜', '按停车步骤停皮带机，调整滚轮至正常');
INSERT INTO `backwardandreason` VALUES ('139', '67', '滚筒', '0', '粘泥', '按停车步骤停皮带机，清泥');
INSERT INTO `backwardandreason` VALUES ('140', '68', '皮带', '0', '张紧力不够', '调整张紧螺栓');
INSERT INTO `backwardandreason` VALUES ('141', '68', '滚轮', '0', '外皮磨损严重', '按停车步骤停皮带机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('142', '68', '皮带机', '0', '负荷过大', '调整负荷');
INSERT INTO `backwardandreason` VALUES ('143', '69', '轴承', '0', '缺油', '按停车步骤停皮带机，加油');
INSERT INTO `backwardandreason` VALUES ('144', '69', '轴承', '0', '损坏', '按停车步骤停皮带机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('145', '70', '轴承座上的轴承', '0', '急速磨损', '按紧急停车步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('146', '70', '机罩装置，传送，箱体等部件', '0', '损坏', '按紧急停车步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('147', '70', '旋转部件', '0', '过度疲劳弯曲', '按紧急停车步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('149', '72', '污泥在螺旋与转鼓之间', '0', '堆积', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('150', '72', '设备内腔（停机时）', '0', '冲洗不彻底', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('151', '72', '干泥箱内的刮泥板松脱', '0', '滤液调节板松动', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('152', '72', '烧结在螺旋上的碳化钨瓦片', '0', '松脱', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('153', '73', '螺旋', '0', '磨损', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('154', '73', '轴承（螺旋止推轴轴承和轴承座内轴承）', '0', '损坏', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('155', '73', '槽轴内', '0', '间隙过大', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('156', '73', '减震块', '0', '损坏', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('157', '73', '顺流进料管的紧固螺栓松动', '0', '滤液回流管不均匀堵塞', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('158', '73', '静止面', '0', '损坏或清洗不干净', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('159', '73', '定心器', '0', '损坏或清洗不干净', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('160', '73', '两静止面', '0', '粘结在一起', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('161', '73', '部件', '0', '变形或损坏', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('162', '73', '轴承座', '0', '太紧', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('163', '73', '螺旋的紧固螺丝', '0', '太紧', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('164', '73', '液位调节版', '0', '调节不好', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('165', '73', '第二电机', '0', '没有校准好', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('166', '73', '传动皮带', '0', '拉得不紧', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('167', '74', '绝对速度', '0', '下降', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('168', '74', '轴承座内的轴承', '0', '磨损', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('169', '75', '主机罩', '0', '有问题', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('170', '75', '干泥排出箱', '0', '有问题', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('171', '75', '传送', '0', '有问题', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('172', '75', '变频器', '0', '有问题', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('173', '75', '减振块', '0', '损坏或者磨损', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('174', '76', '润滑油脂', '0', '过量', '经过几个小时后，轴承座就会冷却到他的正常温度。按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('175', '76', '润滑油脂', '0', '缺油', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('176', '77', '高扭矩工作', '0', '时间过长', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('177', '77', '偏心轴', '0', '过量油脂聚集', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('178', '77', '油脂，润滑油', '0', '油位不正确，太多或不足', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('179', '77', '油脂，润滑油', '0', '类型不对', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('180', '77', '减速器', '0', '过早损坏', '用手盘动偏心轴，检查是否转动自如，按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('182', '79', '转鼓', '0', '速度加速', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('183', '79', '物料排出扭矩', '0', '增加', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('184', '79', '轴承座上轴承', '0', '损坏', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('185', '79', '滤液出口堵塞', '0', '滤液升起进入螺旋', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('186', '80', '干泥排泄箱塞满干泥', '0', '固体腐蚀布料器', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('187', '80', '固体渗入机架内', '0', '磨蚀转鼓或CYCLO环', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('188', '80', '随滤液排出的固体颗粒在转鼓法兰和滤液箱之间的窄小通道上', '0', '干结', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('189', '80', '污泥（在进料管和螺旋输送器外壳之间）', '0', '干结', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('190', '80', '在进料轴承座端支撑转鼓的两螺栓', '0', '没有完全松开', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('191', '80', 'HP螺旋', '0', '最初流量太大', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('192', '81', '机械扭矩限制器', '0', '异常', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('193', '81', '电子扭矩限制器', '0', '异常', '按紧急停机步骤停机，通知车间机械工程师');
INSERT INTO `backwardandreason` VALUES ('194', '82', '相对速度', '0', '不合适', '调整相对速度');
INSERT INTO `backwardandreason` VALUES ('195', '82', '转鼓速度', '0', '不合适', '调整转鼓速度');
INSERT INTO `backwardandreason` VALUES ('196', '82', '液位', '0', '不合适', '调整液位');
INSERT INTO `backwardandreason` VALUES ('197', '82', '污泥泵流量', '0', '不合适', '调整污泥泵流量');
INSERT INTO `backwardandreason` VALUES ('198', '82', '浓度', '0', '不合适', '调整浓度');
INSERT INTO `backwardandreason` VALUES ('199', '82', '药泵流量', '0', '不合适', '调整药泵流量');
INSERT INTO `backwardandreason` VALUES ('200', '82', '絮凝剂质量', '0', '有问题', '分析絮凝剂质量');
INSERT INTO `backwardandreason` VALUES ('201', '82', '皮带打滑引起相对速度变低', '0', '引起分离固体的不充分排料', '调整相对速度');
INSERT INTO `backwardandreason` VALUES ('202', '83', '絮凝剂的质量', '0', '有问题', '分析絮凝剂质量');
INSERT INTO `backwardandreason` VALUES ('203', '83', '加入量', '0', '需要调整', '调整药量');
INSERT INTO `backwardandreason` VALUES ('204', '84', '进泥泵', '0', '堵塞', '处理泥泵');
INSERT INTO `backwardandreason` VALUES ('205', '84', '进泥', '0', '浓度太低', '提高污泥浓度');
INSERT INTO `backwardandreason` VALUES ('206', '84', '相对速度', '0', '小', '检查弹性环，是否剪断，检查皮带是否松动，固体是否与螺旋一起转动，螺旋输送器是否塞满，干泥出口箱堵塞');
INSERT INTO `backwardandreason` VALUES ('207', '85', '泵体和吸入管内', '0', '未灌水或灌水不足', '检查阀底是否漏水并重新向泵内灌水');
INSERT INTO `backwardandreason` VALUES ('208', '85', '进水管接头处', '0', '漏气', '检查漏气部位，设法排出');
INSERT INTO `backwardandreason` VALUES ('209', '85', '底阀', '0', '没有打开', '打开底阀');
INSERT INTO `backwardandreason` VALUES ('210', '85', '进水管', '0', '阻力太大', '清除管路和叶轮堵塞物');
INSERT INTO `backwardandreason` VALUES ('211', '85', '进、出水管', '0', '阻力太大', '清洗或重新设计管路');
INSERT INTO `backwardandreason` VALUES ('212', '85', '转向', '0', '相反', '调整电机的转向');
INSERT INTO `backwardandreason` VALUES ('213', '85', '吸水高度', '0', '太高', '降低吸水高度');
INSERT INTO `backwardandreason` VALUES ('214', '86', '泵体和吸入管路', '0', '未灌水或灌水不足', '检查阀底是否漏水并重新向泵内灌水');
INSERT INTO `backwardandreason` VALUES ('215', '86', '进水管接头处', '0', '漏水', '检查漏气部位，设法排除');
INSERT INTO `backwardandreason` VALUES ('216', '86', '底阀', '0', '没有打开', '打开底阀');
INSERT INTO `backwardandreason` VALUES ('217', '86', '进水管路', '0', '阻力太大', '清除管路和叶轮阻塞物');
INSERT INTO `backwardandreason` VALUES ('218', '86', '进、出水管路', '0', '阻力太大', '清洗或重新设计管路');
INSERT INTO `backwardandreason` VALUES ('219', '86', '转向', '0', '相反', '调整电机的转向');
INSERT INTO `backwardandreason` VALUES ('220', '86', '吸水高度', '0', '太高', '降低吸水高度');
INSERT INTO `backwardandreason` VALUES ('221', '87', '工作电压', '0', '太低', '调整工作电压');
INSERT INTO `backwardandreason` VALUES ('222', '87', '电机', '0', '缺相运行', '检查导线连接情况');
INSERT INTO `backwardandreason` VALUES ('223', '87', '运行工况', '0', '偏离额定工况太大', '调节运行工况');
INSERT INTO `backwardandreason` VALUES ('224', '88', '润滑油脂', '0', '过多或过少', '根据实际情况增减润滑油脂');
INSERT INTO `backwardandreason` VALUES ('225', '88', '轴承', '0', '损坏', '更换');
INSERT INTO `backwardandreason` VALUES ('226', '88', '泵轴', '0', '弯曲', '更换');
INSERT INTO `backwardandreason` VALUES ('227', '89', '泵', '0', '发生气蚀', '调节出水闸阀，使之在限定的性能范围内运行');
INSERT INTO `backwardandreason` VALUES ('228', '89', '叶轮', '0', '局部损坏', '更换');
INSERT INTO `backwardandreason` VALUES ('229', '89', '泵内部', '0', '磨损太多', '更换磨损部件');
INSERT INTO `backwardandreason` VALUES ('230', '89', '轴承', '0', '损坏', '更换');
INSERT INTO `backwardandreason` VALUES ('231', '89', '吸水量', '0', '不足', '正进水池充足水量');
INSERT INTO `backwardandreason` VALUES ('232', '90', '连接螺钉', '0', '松动', '拧紧螺钉');
INSERT INTO `backwardandreason` VALUES ('233', '90', '密封垫', '0', '磨损', '更换密封垫');
INSERT INTO `backwardandreason` VALUES ('234', '91', '提泥管', '0', '堵塞', '人工或通空气疏通');
INSERT INTO `backwardandreason` VALUES ('235', '92', '连接螺栓', '0', '松动', '紧固螺栓');
INSERT INTO `backwardandreason` VALUES ('236', '92', '轴承', '0', '缺油或磨损', '加油或更换');
INSERT INTO `backwardandreason` VALUES ('237', '92', '胶轮', '0', '损坏', '更换胶轮');
INSERT INTO `backwardandreason` VALUES ('238', '93', '链条', '0', '垂度过大或磨损严重', '调整或更换链条');
INSERT INTO `backwardandreason` VALUES ('239', '93', '胶轮', '0', '损坏', '更换胶轮');
INSERT INTO `backwardandreason` VALUES ('240', '93', '池台走台', '0', '结冰打滑', '清理冰雪');
INSERT INTO `backwardandreason` VALUES ('241', '94', '链条', '0', '垂度过大或磨损严重', '调整或更换链条');
INSERT INTO `backwardandreason` VALUES ('242', '94', '胶轮', '0', '损坏', '更换胶轮');
INSERT INTO `backwardandreason` VALUES ('243', '94', '池台走台', '0', '结冰打滑', '清理冰雪');
INSERT INTO `backwardandreason` VALUES ('244', '95', '电流', '0', '过流', '启动备用泵');
INSERT INTO `backwardandreason` VALUES ('245', '95', '离心泵', '0', '停电', '启动备用泵');
INSERT INTO `backwardandreason` VALUES ('246', '95', '设备', '0', '故障', '启动备用泵');
INSERT INTO `backwardandreason` VALUES ('247', '96', '池内液位过低', '0', '泵体和吸入管内没有注满水', '提高液位，将泵内注满水');
INSERT INTO `backwardandreason` VALUES ('248', '96', '泵或吸入管内', '0', '存气或漏气', '排气及消除漏气处，重新灌泵');
INSERT INTO `backwardandreason` VALUES ('249', '96', '填料泵', '0', '漏气', '压紧或更换填料');
INSERT INTO `backwardandreason` VALUES ('250', '96', '泵的转向', '0', '反向', '改变转向');
INSERT INTO `backwardandreason` VALUES ('251', '97', '叶轮', '0', '磨损', '更换叶轮');
INSERT INTO `backwardandreason` VALUES ('252', '97', '进出口管道', '0', '堵塞', '清除杂物');
INSERT INTO `backwardandreason` VALUES ('253', '97', '叶轮口环', '0', '磨损过大', '更换口环');
INSERT INTO `backwardandreason` VALUES ('254', '98', '填料', '0', '压得过紧', '调整填料压盖');
INSERT INTO `backwardandreason` VALUES ('255', '98', '转动部分与固定部分', '0', '发生摩擦', '检查原因，消除机械摩擦');
INSERT INTO `backwardandreason` VALUES ('256', '99', '润滑油脂', '0', '过多或过少', '更具实际情况增加或减少润滑油脂');
INSERT INTO `backwardandreason` VALUES ('257', '99', '轴承', '0', '有缺陷', '更换轴承');
INSERT INTO `backwardandreason` VALUES ('258', '99', '轴承', '0', '压得过紧', '调整');
INSERT INTO `backwardandreason` VALUES ('259', '99', '电机轴与泵轴不同心', '0', '或泵轴弯曲', '校正两轴的同心度或更换泵轴');
INSERT INTO `backwardandreason` VALUES ('260', '100', '泵', '0', '发生气蚀', '调节出水阀使之在规定范围内运行');
INSERT INTO `backwardandreason` VALUES ('261', '100', '叶轮', '0', '不平衡', '重做叶轮平衡');
INSERT INTO `backwardandreason` VALUES ('262', '100', '泵内部件', '0', '磨损严重', '更换磨损部件');
INSERT INTO `backwardandreason` VALUES ('263', '100', '轴承', '0', '损坏', '更换轴承');
INSERT INTO `backwardandreason` VALUES ('264', '100', '电机轴与泵轴', '0', '不在一中心线上', '找同心度');
INSERT INTO `backwardandreason` VALUES ('265', '100', '基础螺栓', '0', '松动', '紧固基础螺栓');
INSERT INTO `backwardandreason` VALUES ('266', '101', '轴承', '0', '磨损', '更换');
INSERT INTO `backwardandreason` VALUES ('267', '101', '轴套', '0', '表面粗糙', '更换');
INSERT INTO `backwardandreason` VALUES ('268', '101', '填料压盖', '0', '没压紧', '压紧填料压盖');
INSERT INTO `backwardandreason` VALUES ('269', '101', '填料', '0', '磨损', '更换填料');
INSERT INTO `backwardandreason` VALUES ('270', '101', '冷却油', '0', '不足', '注冷却油');
INSERT INTO `backwardandreason` VALUES ('271', '102', '转子', '0', '不平衡', '重做平衡');
INSERT INTO `backwardandreason` VALUES ('272', '102', '转子叶轮内', '0', '积垢', '清除积垢后做平衡');
INSERT INTO `backwardandreason` VALUES ('273', '102', '动静叶轮', '0', '变形或腐蚀', '停机检查有关间隙，并处理');
INSERT INTO `backwardandreason` VALUES ('274', '102', '叶轮', '0', '变形或腐蚀', '修理或更换');
INSERT INTO `backwardandreason` VALUES ('275', '102', '对中', '0', '不良', '重新对中');
INSERT INTO `backwardandreason` VALUES ('276', '102', '润滑油温', '0', '太低', '加热润滑油或减少冷却水进水量');
INSERT INTO `backwardandreason` VALUES ('277', '102', '地脚螺栓', '0', '松动', '紧固');
INSERT INTO `backwardandreason` VALUES ('278', '102', '鼓风机', '0', '喘振', '调整符合');
INSERT INTO `backwardandreason` VALUES ('279', '102', '增速大小齿轮', '0', '间隙过大', '重新调整');
INSERT INTO `backwardandreason` VALUES ('280', '103', '油路阻塞', '0', '给油不足', '畅通油路');
INSERT INTO `backwardandreason` VALUES ('281', '103', '油冷却器', '0', '堵塞', '清洗油冷却器');
INSERT INTO `backwardandreason` VALUES ('282', '103', '滑动轴承', '0', '间隙过小', '调整间隙');
INSERT INTO `backwardandreason` VALUES ('283', '103', '油中', '0', '混有水分', '消除漏水并更换润滑油');
INSERT INTO `backwardandreason` VALUES ('284', '104', '轴承', '0', '间隙过大或损坏', '修理或更换');
INSERT INTO `backwardandreason` VALUES ('285', '104', '动静部分', '0', '相擦', '检查修理');
INSERT INTO `backwardandreason` VALUES ('286', '104', '异物', '0', '进入', '消除异物');
INSERT INTO `backwardandreason` VALUES ('287', '105', '油位低，油泵', '0', '吸不上油', '不必停机，按三级过滤要求，从加油口处补加油使其达到规定的油位');
INSERT INTO `backwardandreason` VALUES ('288', '105', '油泵安全阀', '0', '失灵，使油泵压出的油流回机身，压力下降', '停机检修油泵安全阀');
INSERT INTO `backwardandreason` VALUES ('289', '105', '吸油管', '0', '漏气', '停机检查接头');
INSERT INTO `backwardandreason` VALUES ('290', '105', '油泵过滤网', '0', '堵塞', '停机清洗过滤网');
INSERT INTO `backwardandreason` VALUES ('291', '106', '活塞环垫', '0', '间隙不当而卡紧于槽内，失去作用', '停机检修');
INSERT INTO `backwardandreason` VALUES ('292', '106', '活塞环', '0', '损坏', '停机更换活塞环');
INSERT INTO `backwardandreason` VALUES ('293', '106', '气阀', '0', '漏气', '停机修理气阀');
INSERT INTO `backwardandreason` VALUES ('294', '107', '气阀', '0', '有漏气现象', '停机检修气阀');
INSERT INTO `backwardandreason` VALUES ('295', '107', '活塞环', '0', '损坏', '停机更换');
INSERT INTO `backwardandreason` VALUES ('296', '108', '二级进气阀', '0', '漏气或损坏', '停机检修二级气阀');
INSERT INTO `backwardandreason` VALUES ('297', '109', '一级吸，排气阀', '0', '漏气或损坏', '停机检修一级气阀');
INSERT INTO `backwardandreason` VALUES ('298', '110', '二级排气阀', '0', '漏气或损坏', '停机检修气阀');
INSERT INTO `backwardandreason` VALUES ('299', '111', '7#8#泵', '0', '突然停车', '先关闭臭氧池出口阀门，再停管道泵');
INSERT INTO `backwardandreason` VALUES ('300', '112', '提供的气体压力', '0', '小于0.5kg', '检查空压机是否工作正常');
INSERT INTO `backwardandreason` VALUES ('301', '112', '进气管线', '0', '堵塞', '停车检修');
INSERT INTO `backwardandreason` VALUES ('302', '112', '进气管线', '0', '泄漏', '停车检修');
INSERT INTO `backwardandreason` VALUES ('303', '112', '空压机', '0', '不能正常工作', '停车检修');
INSERT INTO `backwardandreason` VALUES ('304', '113', '提供的气体压力', '0', '大于2kg', '检查空压机是否工作正常');
INSERT INTO `backwardandreason` VALUES ('305', '113', '进气管线', '0', '堵塞', '停车检修');
INSERT INTO `backwardandreason` VALUES ('306', '113', '进气管线', '0', '泄漏', '停车检修');
INSERT INTO `backwardandreason` VALUES ('307', '113', '空压机', '0', '不能正常工作', '停车检修');
INSERT INTO `backwardandreason` VALUES ('308', '114', '提供的水压力', '0', '小于0.5kg', '检查管网是否停水，如未停，打开管道加压泵');
INSERT INTO `backwardandreason` VALUES ('309', '114', '进水管线', '0', '堵塞', '停车检修');
INSERT INTO `backwardandreason` VALUES ('310', '114', '进水管线', '0', '泄漏', '停车检修');
INSERT INTO `backwardandreason` VALUES ('311', '115', '高压变压器TR1', '0', '故障', '联系厂家处理');
INSERT INTO `backwardandreason` VALUES ('312', '115', '控制电路', '0', '故障', '联系厂家处理');
INSERT INTO `backwardandreason` VALUES ('313', '115', '电路电流', '0', '故障', '联系厂家处理');
INSERT INTO `backwardandreason` VALUES ('314', '115', 'IGBT', '0', '故障', '联系厂家处理');

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
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandresult
-- ----------------------------
INSERT INTO `backwardandresult` VALUES ('1', '16', '进水', '0', 'PH小于6', null);
INSERT INTO `backwardandresult` VALUES ('3', '18', '进水', '0', 'PH大于9', null);
INSERT INTO `backwardandresult` VALUES ('4', '19', '粗格栅间', '0', '有油渣', null);
INSERT INTO `backwardandresult` VALUES ('7', '22', '沉砂池', '0', '曝气不均', null);
INSERT INTO `backwardandresult` VALUES ('8', '23', '初沉池', '0', '出水带泥', null);
INSERT INTO `backwardandresult` VALUES ('9', '24', '三个初沉池', '0', '出水SS浓度差异较大', null);
INSERT INTO `backwardandresult` VALUES ('10', '25', '浓缩池', '0', '翻泥', null);
INSERT INTO `backwardandresult` VALUES ('11', '26', '带式压榨过滤机', '0', '滤带两旁跑泥', null);
INSERT INTO `backwardandresult` VALUES ('12', '27', '带式压榨过滤机', '0', '滤带过滤不好', null);
INSERT INTO `backwardandresult` VALUES ('13', '28', '带式压榨过滤机', '0', '脱水效果不好', null);
INSERT INTO `backwardandresult` VALUES ('14', '29', '带式压榨过滤机', '0', '泥饼含水率过高', null);
INSERT INTO `backwardandresult` VALUES ('15', '30', '离心机', '0', '滤液澄清度差', null);
INSERT INTO `backwardandresult` VALUES ('16', '31', '离心机', '0', '污泥含水率高', null);
INSERT INTO `backwardandresult` VALUES ('17', '32', '离心机', '0', '固体排料很差', null);
INSERT INTO `backwardandresult` VALUES ('18', '33', '格栅机', '0', '减速机发热', null);
INSERT INTO `backwardandresult` VALUES ('19', '34', '格栅机', '0', '电机转动，其他部件不动', null);
INSERT INTO `backwardandresult` VALUES ('21', '36', '机械格栅机', '0', '安全销断', null);
INSERT INTO `backwardandresult` VALUES ('23', '38', '格栅机', '0', '耙齿振动大', null);
INSERT INTO `backwardandresult` VALUES ('24', '39', '刮泥机', '0', '异常声响振动', null);
INSERT INTO `backwardandresult` VALUES ('25', '40', '刮泥机', '0', '安全销断裂', null);
INSERT INTO `backwardandresult` VALUES ('26', '41', '刮砂机', '0', '刮板弯曲', null);
INSERT INTO `backwardandresult` VALUES ('27', '42', '刮砂轨道', '0', '变形，磨损变薄', null);
INSERT INTO `backwardandresult` VALUES ('28', '43', '刮砂机', '0', '链节脱节', null);
INSERT INTO `backwardandresult` VALUES ('29', '44', '刮砂机', '0', '电机过载', null);
INSERT INTO `backwardandresult` VALUES ('30', '45', '刮砂机', '0', '主动链轮轴支撑轴承盒过力损坏', null);
INSERT INTO `backwardandresult` VALUES ('31', '46', '潜水排污泵', '0', '流量不足', null);
INSERT INTO `backwardandresult` VALUES ('32', '47', '潜水排污泵', '0', '不出水', null);
INSERT INTO `backwardandresult` VALUES ('33', '48', '潜水排污泵', '0', '运行不稳定', null);
INSERT INTO `backwardandresult` VALUES ('34', '49', '潜水排污泵', '0', '电流过大', null);
INSERT INTO `backwardandresult` VALUES ('35', '50', '潜水排污泵', '0', '超温保护动作', null);
INSERT INTO `backwardandresult` VALUES ('36', '51', '潜水排污泵油室', '0', '进水指示灯亮', null);
INSERT INTO `backwardandresult` VALUES ('37', '52', '潜水排污泵', '0', '渗漏保护动作', null);
INSERT INTO `backwardandresult` VALUES ('38', '53', '潜水排污泵接线盒', '0', '  探头发信号', null);
INSERT INTO `backwardandresult` VALUES ('39', '54', '潜水排污泵', '0', '泵流量不足', null);
INSERT INTO `backwardandresult` VALUES ('40', '55', '潜水排污泵', '0', '泵体过热', null);
INSERT INTO `backwardandresult` VALUES ('41', '56', '潜水排污泵', '0', '泵轴承过热', null);
INSERT INTO `backwardandresult` VALUES ('42', '57', '潜水排污泵', '0', '泵异常声响振动', null);
INSERT INTO `backwardandresult` VALUES ('43', '58', '螺杆泵', '0', '泵不能启动', null);
INSERT INTO `backwardandresult` VALUES ('44', '59', '螺杆泵', '0', '泵吸不上液体', null);
INSERT INTO `backwardandresult` VALUES ('45', '60', '螺杆泵', '0', '流量不足', null);
INSERT INTO `backwardandresult` VALUES ('46', '61', '螺杆泵', '0', '运转不稳定', null);
INSERT INTO `backwardandresult` VALUES ('47', '62', '螺杆泵', '0', '噪音和振动', null);
INSERT INTO `backwardandresult` VALUES ('48', '63', '螺杆泵', '0', '电机，设备过热', null);
INSERT INTO `backwardandresult` VALUES ('49', '64', '带式压榨过滤机', '0', '滤带跑偏', null);
INSERT INTO `backwardandresult` VALUES ('50', '65', '带式压榨过滤机', '0', '滤带撕裂', null);
INSERT INTO `backwardandresult` VALUES ('51', '66', '带式压榨过滤机', '0', '异常声响或振动', null);
INSERT INTO `backwardandresult` VALUES ('52', '67', '皮带输送机', '0', '皮带跑偏', null);
INSERT INTO `backwardandresult` VALUES ('53', '68', '皮带输送机', '0', '皮带打滑', null);
INSERT INTO `backwardandresult` VALUES ('54', '69', '皮带输送机', '0', '轴承温度过高或振动', null);
INSERT INTO `backwardandresult` VALUES ('55', '70', '离心机', '0', '振动加剧', null);
INSERT INTO `backwardandresult` VALUES ('57', '72', '离心机', '0', '突然振动', null);
INSERT INTO `backwardandresult` VALUES ('58', '73', '离心机', '0', '逐渐地振动', null);
INSERT INTO `backwardandresult` VALUES ('59', '74', '离心机', '0', '有噪音', null);
INSERT INTO `backwardandresult` VALUES ('60', '75', '离心机', '0', '螺栓松动', null);
INSERT INTO `backwardandresult` VALUES ('61', '76', '离心机', '0', '轴承座过热', null);
INSERT INTO `backwardandresult` VALUES ('62', '77', '离心机', '0', '减速器过热', null);
INSERT INTO `backwardandresult` VALUES ('64', '79', '离心机', '0', '电机过载', null);
INSERT INTO `backwardandresult` VALUES ('65', '80', '离心机', '0', '螺旋转动不自如', null);
INSERT INTO `backwardandresult` VALUES ('66', '81', '离心机', '0', '扭矩异常', null);
INSERT INTO `backwardandresult` VALUES ('67', '82', '离心机', '0', '滤液澄清度差', null);
INSERT INTO `backwardandresult` VALUES ('68', '83', '离心机', '0', '污泥含水率高', null);
INSERT INTO `backwardandresult` VALUES ('69', '84', '离心机', '0', '固体排料很差', null);
INSERT INTO `backwardandresult` VALUES ('70', '85', '排污泵', '0', '不出水', null);
INSERT INTO `backwardandresult` VALUES ('71', '86', '排污泵', '0', '流量不足', null);
INSERT INTO `backwardandresult` VALUES ('72', '87', '排污泵', '0', '电机超载', null);
INSERT INTO `backwardandresult` VALUES ('73', '88', '排污泵', '0', '轴承温度过高', null);
INSERT INTO `backwardandresult` VALUES ('74', '89', '排污泵', '0', '运行不平稳', null);
INSERT INTO `backwardandresult` VALUES ('75', '90', '排污泵', '0', '泄漏', null);
INSERT INTO `backwardandresult` VALUES ('76', '91', '提泥阀', '0', '不好用', null);
INSERT INTO `backwardandresult` VALUES ('77', '92', '提泥阀', '0', '异常声音或振动', null);
INSERT INTO `backwardandresult` VALUES ('78', '93', '提泥阀', '0', '运行不平稳', null);
INSERT INTO `backwardandresult` VALUES ('79', '94', '提泥阀', '0', '原地不动', null);
INSERT INTO `backwardandresult` VALUES ('80', '95', '离心泵', '0', '突然停泵', null);
INSERT INTO `backwardandresult` VALUES ('81', '96', '离心泵', '0', '泵不出水', null);
INSERT INTO `backwardandresult` VALUES ('82', '97', '离心泵', '0', '流量不足', null);
INSERT INTO `backwardandresult` VALUES ('83', '98', '离心泵', '0', '功率过大', null);
INSERT INTO `backwardandresult` VALUES ('84', '99', '离心泵', '0', '轴承过热', null);
INSERT INTO `backwardandresult` VALUES ('85', '100', '离心泵', '0', '泵运行不稳定', null);
INSERT INTO `backwardandresult` VALUES ('86', '101', '轴封', '0', '泄露过多', null);
INSERT INTO `backwardandresult` VALUES ('87', '102', '鼓风机', '0', '轴承振动', null);
INSERT INTO `backwardandresult` VALUES ('88', '103', '鼓风机', '0', '轴承发热', null);
INSERT INTO `backwardandresult` VALUES ('89', '104', '鼓风机', '0', '噪音大', null);
INSERT INTO `backwardandresult` VALUES ('90', '105', '空压机', '0', '油压降低', null);
INSERT INTO `backwardandresult` VALUES ('91', '106', '空压机', '0', '排气量显著降低', null);
INSERT INTO `backwardandresult` VALUES ('92', '107', '空压机', '0', '排气温度过高', null);
INSERT INTO `backwardandresult` VALUES ('93', '108', '空压机', '0', '一级排气压力高', null);
INSERT INTO `backwardandresult` VALUES ('94', '109', '空压机', '0', '一级排气压力低', null);
INSERT INTO `backwardandresult` VALUES ('95', '110', '空压机', '0', '二级排气压力达不到规定值', null);
INSERT INTO `backwardandresult` VALUES ('96', '111', '臭氧机', '0', '消防水池冒水', null);
INSERT INTO `backwardandresult` VALUES ('97', '112', '臭氧机', '0', '进水压力过低', null);
INSERT INTO `backwardandresult` VALUES ('98', '113', '臭氧机', '0', '进气压力过高', null);
INSERT INTO `backwardandresult` VALUES ('99', '114', '臭氧机', '0', '水压过低', null);
INSERT INTO `backwardandresult` VALUES ('100', '115', '臭氧机', '0', '臭氧发生器电路故障', null);

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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdata
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
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=1332 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcsdscrib
-- ----------------------------
INSERT INTO `dcsdscrib` VALUES ('1083', '490  5号生化池', 'ITEM1', '0', '生化池A段溶解氧DO', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1084', '490  6号生化池', 'ITEM2', '0', '生化池A段溶解氧DO', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1085', '490  7号生化池', 'ITEM3', '0', '生化池A段溶解氧DO', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1086', '490  8号生化池', 'ITEM4', '0', '生化池A段溶解氧DO', '0.5');
INSERT INTO `dcsdscrib` VALUES ('1087', '490  1号生化池', 'ITEM5', '6', '生化池PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1088', '490  3号生化池', 'ITEM7', '6', '生化池PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1089', '490  4号生化池', 'ITEM8', '6', '生化池PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1090', '490  5号生化池', 'ITEM9', '6', '生化池PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1091', '490  6号生化池', 'ITEM10', '6', '生化池PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1092', '490  7号生化池', 'ITEM11', '6', '生化池PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1093', '490  8号生化池', 'ITEM12', '6', '生化池PH', '9');
INSERT INTO `dcsdscrib` VALUES ('1094', '462A进水提升泵房', 'ITEM13', '0', '进水提升泵NH3-N', '200');
INSERT INTO `dcsdscrib` VALUES ('1095', '462B中间提升泵房', 'ITEM14', '0', '中间提升泵吸水池COD', '500');
INSERT INTO `dcsdscrib` VALUES ('1096', '462B中间提升泵房', 'ITEM15', '0', '中间提升泵吸水池NH3-N', '200');
INSERT INTO `dcsdscrib` VALUES ('1097', '462B中间提升泵房', 'ITEM16', '0', '中间提升泵吸水池SS', '300');
INSERT INTO `dcsdscrib` VALUES ('1098', '462B中间提升泵房', 'ITEM17', '0', '中间提升泵吸水池PH', '10');
INSERT INTO `dcsdscrib` VALUES ('1099', '462A进水提升泵房', 'ITEM18', '0', '进水提升泵PH', '10');
INSERT INTO `dcsdscrib` VALUES ('1100', '入江排污口', 'ITEM19', '0', '出口PH', '10');
INSERT INTO `dcsdscrib` VALUES ('1101', '入江排污口', 'ITEM20', '0', '出口SS', '300');
INSERT INTO `dcsdscrib` VALUES ('1102', '入江排污口', 'ITEM21', '0', '出口COD', '50');
INSERT INTO `dcsdscrib` VALUES ('1103', '入江排污口', 'ITEM22', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1104', '入江排污口', 'ITEM23', '0', '出口DO', '10000');
INSERT INTO `dcsdscrib` VALUES ('1105', '入江排污口', 'ITEM24', '0', '出口NH3-N', '500');
INSERT INTO `dcsdscrib` VALUES ('1106', '入江排污口', 'ITEM25', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1107', '入江排污口', 'ITEM26', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1108', '入江排污口', 'ITEM27', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1109', '490  1号生化池', 'ITEM28', '2', '生化池2段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1110', '490  2号生化池', 'ITEM29', '2', '生化池2段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1111', '490  3号生化池', 'ITEM30', '2', '生化池2段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1112', '490  4号生化池', 'ITEM31', '2', '生化池2段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1113', '490  1号生化池', 'ITEM32', '2', '生化池3段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1114', '490  2号生化池', 'ITEM33', '2', '生化池3段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1115', '490  3号生化池', 'ITEM34', '2', '生化池3段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1116', '490  4号生化池', 'ITEM35', '2', '生化池3段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1117', '490  1号生化池', 'ITEM36', '2', '生化池5段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1118', '490  2号生化池', 'ITEM36', '2', '生化池5段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1119', '490  3号生化池', 'ITEM38', '2', '生化池5段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1120', '490  4号生化池', 'ITEM39', '2', '生化池5段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1121', '490  5号生化池', 'ITEM40', '2', '生化池4段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1122', '490  6号生化池', 'ITEM41', '2', '生化池4段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1123', '490  7号生化池', 'ITEM42', '2', '生化池4段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1124', '490  8号生化池', 'ITEM43', '2', '生化池4段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1125', '490  5号生化池', 'ITEM44', '2', '生化池6段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1126', '490  6号生化池', 'ITEM45', '2', '生化池6段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1127', '490  7号生化池', 'ITEM46', '2', '生化池6段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1128', '490  8号生化池', 'ITEM47', '2', '生化池6段溶解氧DO', '4');
INSERT INTO `dcsdscrib` VALUES ('1129', '污泥脱水离心式污泥泵', 'ITEM48', '0', 'P495A-1流量', '1000000');
INSERT INTO `dcsdscrib` VALUES ('1130', '污泥脱水离心式污泥泵', 'ITEM49', '0', 'P495A-2流量', '1000000');
INSERT INTO `dcsdscrib` VALUES ('1131', '污泥脱水离心式污泥泵', 'ITEM50', '0', 'P495A-3流量', '1000000');
INSERT INTO `dcsdscrib` VALUES ('1132', '污泥脱水离心式污泥泵', 'ITEM51', '0', 'P495A-4流量', '1000000');
INSERT INTO `dcsdscrib` VALUES ('1133', '污泥脱水离心式污泥泵', 'ITEM52', '0', 'P495A-5流量', '1000000');
INSERT INTO `dcsdscrib` VALUES ('1134', '污泥脱水离心式污泥泵', 'ITEM53', '0', 'P495A-6流量', '1000000');
INSERT INTO `dcsdscrib` VALUES ('1135', null, 'ITEM54', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1136', null, 'ITEM55', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1137', null, 'ITEM56', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1138', null, 'ITEM57', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1139', null, 'ITEM58', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1140', null, 'ITEM59', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1141', null, 'ITEM60', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1142', null, 'ITEM61', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1143', null, 'ITEM62', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1144', null, 'ITEM63', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1145', null, 'ITEM64', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1146', null, 'ITEM65', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1147', null, 'ITEM66', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1148', null, 'ITEM67', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1149', null, 'ITEM68', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1150', null, 'ITEM69', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1151', null, 'ITEM70', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1152', null, 'ITEM71', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1153', null, 'ITEM72', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1154', null, 'ITEM73', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1155', null, 'ITEM74', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1156', null, 'ITEM75', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1157', null, 'ITEM76', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1158', null, 'ITEM77', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1159', null, 'ITEM78', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1160', null, 'ITEM79', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1161', null, 'ITEM80', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1162', null, 'ITEM81', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1163', null, 'ITEM82', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1164', null, 'ITEM83', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1165', null, 'ITEM84', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1166', null, 'ITEM85', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1167', null, 'ITEM86', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1168', null, 'ITEM87', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1169', null, 'ITEM88', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1170', null, 'ITEM89', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1171', null, 'ITEM90', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1172', null, 'ITEM91', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1173', null, 'ITEM92', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1174', null, 'ITEM93', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1175', null, 'ITEM94', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1176', null, 'ITEM95', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1177', null, 'ITEM96', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1178', null, 'ITEM97', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1179', null, 'ITEM98', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1180', null, 'ITEM99', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1181', 'C-281鼓风机房  1#鼓风机', 'ITEM100', '0', '鼓风机分量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1182', 'C-282鼓风机房  2#鼓风机', 'ITEM101', '0', '鼓风机分量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1183', 'C-283鼓风机房  3#鼓风机', 'ITEM102', '0', '鼓风机分量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1184', 'C-284鼓风机房  4#鼓风机', 'ITEM103', '0', '鼓风机分量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1185', '465回流泵', 'ITEM104', '0', '回流泵回流量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1186', '465回流泵', 'ITEM105', '0', '回流泵剩余量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1187', '465A回流泵房', 'ITEM106', '0', '回流泵回流量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1188', '465A回流泵房', 'ITEM107', '0', '回流泵剩余量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1189', '465B回流泵房', 'ITEM108', '0', '回流泵回流量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1190', '465B回流泵房', 'ITEM109', '0', '回流泵剩余量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1191', '499巴氏计量槽', 'ITEM110', '0', '巴氏计量槽流量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1192', '14b主线', 'ITEM111', '0', '主线流量', '6000');
INSERT INTO `dcsdscrib` VALUES ('1193', '466-1  P466-1~4泵', 'ITEM112', '0', '出口干管流量', '100');
INSERT INTO `dcsdscrib` VALUES ('1194', '466-2  P466-1~4泵', 'ITEM113', '0', '泵出口干管流量', '100');
INSERT INTO `dcsdscrib` VALUES ('1195', '495A-1-2', 'ITEM114', '0', '清水泵出口干管流量', '100');
INSERT INTO `dcsdscrib` VALUES ('1196', '465回流泵  3#泵', 'ITEM115', '0', '出口管回流污泥量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1197', '428加压泵', 'ITEM116', '0', '生活给水量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1198', '428加压泵', 'ITEM117', '0', '工业给水量', '10000');
INSERT INTO `dcsdscrib` VALUES ('1199', null, 'ITEM118', '0', '鼓风机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1200', null, 'ITEM119', '0', '加药岗位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1201', null, 'ITEM120', '0', '鼓风机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1202', null, 'ITEM121', '0', '鼓风机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1203', null, 'ITEM122', '0', '鼓风机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1204', null, 'ITEM123', '0', '鼓风机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1205', null, 'ITEM124', '0', '锅炉房', '10000');
INSERT INTO `dcsdscrib` VALUES ('1206', null, 'ITEM125', '0', '锅炉房', '10000');
INSERT INTO `dcsdscrib` VALUES ('1207', null, 'ITEM126', '0', '锅炉房', '10000');
INSERT INTO `dcsdscrib` VALUES ('1208', null, 'ITEM127', '0', '锅炉房', '10000');
INSERT INTO `dcsdscrib` VALUES ('1209', null, 'ITEM128', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1210', '1#粗格栅', 'ITEM129', '0', '前后液位差', '0.15');
INSERT INTO `dcsdscrib` VALUES ('1211', '2#粗格栅', 'ITEM130', '0', '前后液位差', '0.15');
INSERT INTO `dcsdscrib` VALUES ('1212', '3#粗格栅', 'ITEM131', '0', '前后液位差', '0.15');
INSERT INTO `dcsdscrib` VALUES ('1213', null, 'ITEM132', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1214', null, 'ITEM133', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1215', null, 'ITEM134', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1216', null, 'ITEM135', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1217', 'M414-1~5加药间', 'ITEM136', '0', '溶药池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1218', '水解酸化池  1#', 'ITEM137', '4.5', '水解酸化池', '5.5');
INSERT INTO `dcsdscrib` VALUES ('1219', '水解酸化池  2#', 'ITEM138', '4.5', '水解酸化池', '5.5');
INSERT INTO `dcsdscrib` VALUES ('1220', '462B泵房', 'ITEM139', '0', '吸水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1221', 'V462B-3', 'ITEM140', '0', '高位水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1222', '465吸泥池', 'ITEM141', '0', '吸泥池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1223', null, 'ITEM142', '0', '生活水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1224', null, 'ITEM143', '0', '生产水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1225', null, 'ITEM144', '0', '地沟液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1226', null, 'ITEM145', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1227', null, 'ITEM146', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1228', null, 'ITEM147', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1229', '499巴氏计量槽', 'ITEM148', '0', '巴氏计量槽前', '10000');
INSERT INTO `dcsdscrib` VALUES ('1230', '499巴氏计量槽', 'ITEM149', '0', '巴氏计量槽后', '10000');
INSERT INTO `dcsdscrib` VALUES ('1231', 'V495A-3药剂池', 'ITEM150', '0', '药剂池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1232', 'V495A-4药剂池', 'ITEM151', '0', '药剂池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1233', '462A泵房吸水池', 'ITEM152', '2', '吸水池液位', '3.6');
INSERT INTO `dcsdscrib` VALUES ('1234', null, 'ITEM153', '0.2', '水解酸化池', '5.5');
INSERT INTO `dcsdscrib` VALUES ('1235', '462B中间提升泵房', 'ITEM154', '0', '吸水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1236', '462B中间提升泵房', 'ITEM155', '0', '高位水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1237', '462B中间提升泵房', 'ITEM156', '0', '地面污水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1238', '466泵房  V466污泥池', 'ITEM157', '0', '污泥池前液位', '5');
INSERT INTO `dcsdscrib` VALUES ('1239', 'P495A-15', 'ITEM158', '0', '污泥脱水间地沟液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1240', '465吸泥池', 'ITEM159', '0', '吸泥池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1241', '465A吸泥池', 'ITEM160', '0', '吸泥池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1242', '465A吸泥池', 'ITEM161', '0', '地面污水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1243', '465B吸泥池', 'ITEM162', '0', '吸泥池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1244', '465B吸泥池', 'ITEM163', '0', '地面污水池液位', '10000');
INSERT INTO `dcsdscrib` VALUES ('1245', 'M488刮沙机  M488-1#', 'ITEM164', '0', '刮沙机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1246', 'M488刮沙机  M488-2#', 'ITEM165', '0', '刮沙机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1247', 'M488刮沙机  M488-3#', 'ITEM166', '0', '刮沙机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1248', 'M488刮沙机  M488-4#', 'ITEM167', '0', '刮沙机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1249', 'M489-1#周边传动刮泥机', 'ITEM168', '0', '周边传动刮泥机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1250', 'M489-1#周边传动刮泥机', 'ITEM169', '0', '周边传动刮泥机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1251', 'M489-2#周边传动刮泥机', 'ITEM170', '0', '周边传动刮泥机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1252', 'M489-2#周边传动刮泥机', 'ITEM171', '0', '周边传动刮泥机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1253', 'M489-3#周边传动刮泥机', 'ITEM172', '0', '周边传动刮泥机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1254', 'M489-3#周边传动刮泥机', 'ITEM173', '0', '周边传动刮泥机', '10000');
INSERT INTO `dcsdscrib` VALUES ('1255', '1#潜水排污泵', 'ITEM174', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1256', '1#潜水排污泵', 'ITEM175', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1257', '2#潜水排污泵', 'ITEM176', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1258', '2#潜水排污泵', 'ITEM177', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1259', '3#潜水排污泵', 'ITEM178', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1260', '3#潜水排污泵', 'ITEM179', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1261', '4#潜水排污泵', 'ITEM180', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1262', '4#潜水排污泵', 'ITEM181', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1263', '5#潜水排污泵', 'ITEM182', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1264', '5#潜水排污泵', 'ITEM183', '0', '潜水排污泵', '10000');
INSERT INTO `dcsdscrib` VALUES ('1265', 'P495A1-2', 'ITEM184', '0', '泵出口干管压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1266', '加药间', 'ITEM185', '0', '生化处理车间加药间', '10000');
INSERT INTO `dcsdscrib` VALUES ('1267', 'C281鼓风机房  1#鼓风机', 'ITEM186', '0', '鼓风机前压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1268', 'C281鼓风机房  2#鼓风机', 'ITEM187', '0', '鼓风机前压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1269', 'C281鼓风机房  3#鼓风机', 'ITEM188', '0', '鼓风机前压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1270', 'C281鼓风机房  4#鼓风机', 'ITEM189', '0', '鼓风机前压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1271', 'C281鼓风机房  1#鼓风机', 'ITEM190', '0', '鼓风机后压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1272', 'C281鼓风机房  2#鼓风机', 'ITEM191', '0', '鼓风机后压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1273', 'C281鼓风机房  3#鼓风机', 'ITEM192', '0', '鼓风机后压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1274', 'C281鼓风机房  4#鼓风机', 'ITEM193', '0', '鼓风机后压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1275', 'C281鼓风机房', 'ITEM194', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1276', 'C281鼓风机房', 'ITEM195', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1277', 'C281鼓风机房', 'ITEM196', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1278', '428加压泵房', 'ITEM197', '0', '生活给水压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1279', '428加压泵房', 'ITEM198', '0', '工业给水压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1280', '测空压站来空气', 'ITEM199', '0', '干管压力', '10000');
INSERT INTO `dcsdscrib` VALUES ('1281', null, 'ITEM200', '0', '', '10000');
INSERT INTO `dcsdscrib` VALUES ('1282', '1#带式压榨过滤机', 'ITEM201', '0', '带式压榨过滤机状态', '10000');
INSERT INTO `dcsdscrib` VALUES ('1283', '2#带式压榨过滤机', 'ITEM202', '0', '带式压榨过滤机状态', '10000');
INSERT INTO `dcsdscrib` VALUES ('1284', '3#带式压榨过滤机', 'ITEM203', '0', '带式压榨过滤机状态', '10000');
INSERT INTO `dcsdscrib` VALUES ('1285', '4#带式压榨过滤机', 'ITEM204', '0', '带式压榨过滤机状态', '10000');
INSERT INTO `dcsdscrib` VALUES ('1286', '5#带式压榨过滤机', 'ITEM205', '0', '带式压榨过滤机状态', '10000');
INSERT INTO `dcsdscrib` VALUES ('1287', '462B中间提升泵房  462B高位水池', 'ITEM206', '0', '高位水池温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1288', 'C281鼓风机房  1#增速机', 'ITEM207', '0', '增速机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1289', 'C281鼓风机房  2#增速机', 'ITEM208', '0', '增速机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1290', 'C281鼓风机房  3#增速机', 'ITEM209', '0', '增速机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1291', 'C281鼓风机房  4#增速机', 'ITEM210', '0', '增速机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1292', 'C281鼓风机房  1#电机', 'ITEM211', '0', '电机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1293', 'C281鼓风机房  2#电机', 'ITEM212', '0', '电机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1294', 'C281鼓风机房  3#电机', 'ITEM213', '0', '电机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1295', 'C281鼓风机房  4#电机', 'ITEM214', '0', '电机轴承温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1296', 'C281鼓风机房  1#电机', 'ITEM215', '0', '电机定子温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1297', 'C281鼓风机房  2#电机', 'ITEM216', '0', '电机定子温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1298', 'C281鼓风机房  3#电机', 'ITEM217', '0', '电机定子温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1299', 'C281鼓风机房  4#电机', 'ITEM218', '0', '电机定子温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1300', 'C281鼓风机房  1#鼓风机', 'ITEM219', '0', '鼓风机出口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1301', 'C281鼓风机房  2#鼓风机', 'ITEM220', '0', '鼓风机出口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1302', 'C281鼓风机房  3#鼓风机', 'ITEM221', '0', '鼓风机出口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1303', 'C281鼓风机房  4#鼓风机', 'ITEM222', '0', '鼓风机出口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1304', 'C281鼓风机房  1#鼓风机', 'ITEM223', '0', '鼓风机入口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1305', 'C281鼓风机房  2#鼓风机', 'ITEM224', '0', '鼓风机入口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1306', 'C281鼓风机房  3#鼓风机', 'ITEM225', '0', '鼓风机入口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1307', 'C281鼓风机房  4#鼓风机', 'ITEM226', '0', '鼓风机入口管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1308', 'C281鼓风机房  1#鼓风机', 'ITEM227', '0', '鼓风机润滑油管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1309', 'C281鼓风机房  2#鼓风机', 'ITEM228', '0', '鼓风机润滑油管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1310', 'C281鼓风机房  3#鼓风机', 'ITEM229', '0', '鼓风机润滑油管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1311', 'C281鼓风机房  4#鼓风机', 'ITEM230', '0', '鼓风机润滑油管温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1312', 'C281鼓风机房  1#鼓风机', 'ITEM231', '0', '鼓风机冷却回水温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1313', 'C281鼓风机房  2#鼓风机', 'ITEM232', '0', '鼓风机冷却回水温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1314', 'C281鼓风机房  3#鼓风机', 'ITEM233', '0', '鼓风机冷却回水温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1315', 'C281鼓风机房  4#鼓风机', 'ITEM234', '0', '鼓风机冷却回水温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1316', 'C281鼓风机房', 'ITEM235', '0', 'V-452-1冷却水池温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1317', 'C281鼓风机房', 'ITEM236', '0', 'V-452-2冷却水池温度', '10000');
INSERT INTO `dcsdscrib` VALUES ('1318', 'C281鼓风机房', 'ITEM237', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1319', 'C281鼓风机房', 'ITEM238', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1320', 'C281鼓风机房', 'ITEM239', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1321', 'C281鼓风机房', 'ITEM240', '0', null, '10000');
INSERT INTO `dcsdscrib` VALUES ('1322', '490  1号生化池', 'ITEM241', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1323', '490  2号生化池', 'ITEM242', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1324', '490  3号生化池', 'ITEM243', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1325', '490  4号生化池', 'ITEM244', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1326', '490  5号生化池', 'ITEM245', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1327', '490  6号生化池', 'ITEM246', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1328', '490  7号生化池', 'ITEM247', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1329', '490  8号生化池', 'ITEM248', '15', '生化池温度', '35');
INSERT INTO `dcsdscrib` VALUES ('1331', '490  2号生化池', 'ITEM 6', '6', '生化池PH', '9');

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dcshistory
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dss_advice
-- ----------------------------

-- ----------------------------
-- Table structure for `errorlog`
-- ----------------------------
DROP TABLE IF EXISTS `errorlog`;
CREATE TABLE `errorlog` (
  `id` int(10) NOT NULL,
  `seqno` varchar(255) DEFAULT NULL,
  `equip` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `error` varchar(255) DEFAULT NULL,
  `sugg` varchar(1000) DEFAULT NULL,
  `level` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of errorlog
-- ----------------------------

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
  PRIMARY KEY (`seqno`,`simu_time`,`name`)
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
INSERT INTO `user` VALUES (null, '1', '王晓明', '1', '1', 'squarlhan@163.com', '13074347302', '000001');
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
