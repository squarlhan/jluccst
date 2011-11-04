/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : wushuichang

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2011-11-04 21:47:24
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
  PRIMARY KEY (`id`),
  KEY `FKFBAE5431DB7478BC` (`bid`),
  CONSTRAINT `FKFBAE5431DB7478BC` FOREIGN KEY (`bid`) REFERENCES `backward` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of backwardandresult
-- ----------------------------
INSERT INTO `backwardandresult` VALUES ('1', '16', '进水', '0', 'PH小于6');
INSERT INTO `backwardandresult` VALUES ('3', '18', '进水', '0', 'PH大于9');
INSERT INTO `backwardandresult` VALUES ('4', '19', '粗格栅间', '0', '有油渣');
INSERT INTO `backwardandresult` VALUES ('7', '22', '沉砂池', '0', '曝气不均');
INSERT INTO `backwardandresult` VALUES ('8', '23', '初沉池', '0', '出水带泥');
INSERT INTO `backwardandresult` VALUES ('9', '24', '三个初沉池', '0', '出水SS浓度差异较大');
INSERT INTO `backwardandresult` VALUES ('10', '25', '浓缩池', '0', '翻泥');
INSERT INTO `backwardandresult` VALUES ('11', '26', '带式压榨过滤机', '0', '滤带两旁跑泥');
INSERT INTO `backwardandresult` VALUES ('12', '27', '带式压榨过滤机', '0', '滤带过滤不好');
INSERT INTO `backwardandresult` VALUES ('13', '28', '带式压榨过滤机', '0', '脱水效果不好');
INSERT INTO `backwardandresult` VALUES ('14', '29', '带式压榨过滤机', '0', '泥饼含水率过高');
INSERT INTO `backwardandresult` VALUES ('15', '30', '离心机', '0', '滤液澄清度差');
INSERT INTO `backwardandresult` VALUES ('16', '31', '离心机', '0', '污泥含水率高');
INSERT INTO `backwardandresult` VALUES ('17', '32', '离心机', '0', '固体排料很差');
INSERT INTO `backwardandresult` VALUES ('18', '33', '格栅机', '0', '减速机发热');
INSERT INTO `backwardandresult` VALUES ('19', '34', '格栅机', '0', '电机转动，其他部件不动');
INSERT INTO `backwardandresult` VALUES ('21', '36', '机械格栅机', '0', '安全销断');
INSERT INTO `backwardandresult` VALUES ('23', '38', '格栅机', '0', '耙齿振动大');
INSERT INTO `backwardandresult` VALUES ('24', '39', '刮泥机', '0', '异常声响振动');
INSERT INTO `backwardandresult` VALUES ('25', '40', '刮泥机', '0', '安全销断裂');
INSERT INTO `backwardandresult` VALUES ('26', '41', '刮砂机', '0', '刮板弯曲');
INSERT INTO `backwardandresult` VALUES ('27', '42', '刮砂轨道', '0', '变形，磨损变薄');
INSERT INTO `backwardandresult` VALUES ('28', '43', '刮砂机', '0', '链节脱节');
INSERT INTO `backwardandresult` VALUES ('29', '44', '刮砂机', '0', '电机过载');
INSERT INTO `backwardandresult` VALUES ('30', '45', '刮砂机', '0', '主动链轮轴支撑轴承盒过力损坏');
INSERT INTO `backwardandresult` VALUES ('31', '46', '潜水排污泵', '0', '流量不足');
INSERT INTO `backwardandresult` VALUES ('32', '47', '潜水排污泵', '0', '不出水');
INSERT INTO `backwardandresult` VALUES ('33', '48', '潜水排污泵', '0', '运行不稳定');
INSERT INTO `backwardandresult` VALUES ('34', '49', '潜水排污泵', '0', '电流过大');
INSERT INTO `backwardandresult` VALUES ('35', '50', '潜水排污泵', '0', '超温保护动作');
INSERT INTO `backwardandresult` VALUES ('36', '51', '潜水排污泵油室', '0', '进水指示灯亮');
INSERT INTO `backwardandresult` VALUES ('37', '52', '潜水排污泵', '0', '渗漏保护动作');
INSERT INTO `backwardandresult` VALUES ('38', '53', '潜水排污泵接线盒', '0', '  探头发信号');
INSERT INTO `backwardandresult` VALUES ('39', '54', '潜水排污泵', '0', '泵流量不足');
INSERT INTO `backwardandresult` VALUES ('40', '55', '潜水排污泵', '0', '泵体过热');
INSERT INTO `backwardandresult` VALUES ('41', '56', '潜水排污泵', '0', '泵轴承过热');
INSERT INTO `backwardandresult` VALUES ('42', '57', '潜水排污泵', '0', '泵异常声响振动');
INSERT INTO `backwardandresult` VALUES ('43', '58', '螺杆泵', '0', '泵不能启动');
INSERT INTO `backwardandresult` VALUES ('44', '59', '螺杆泵', '0', '泵吸不上液体');
INSERT INTO `backwardandresult` VALUES ('45', '60', '螺杆泵', '0', '流量不足');
INSERT INTO `backwardandresult` VALUES ('46', '61', '螺杆泵', '0', '运转不稳定');
INSERT INTO `backwardandresult` VALUES ('47', '62', '螺杆泵', '0', '噪音和振动');
INSERT INTO `backwardandresult` VALUES ('48', '63', '螺杆泵', '0', '电机，设备过热');
INSERT INTO `backwardandresult` VALUES ('49', '64', '带式压榨过滤机', '0', '滤带跑偏');
INSERT INTO `backwardandresult` VALUES ('50', '65', '带式压榨过滤机', '0', '滤带撕裂');
INSERT INTO `backwardandresult` VALUES ('51', '66', '带式压榨过滤机', '0', '异常声响或振动');
INSERT INTO `backwardandresult` VALUES ('52', '67', '皮带输送机', '0', '皮带跑偏');
INSERT INTO `backwardandresult` VALUES ('53', '68', '皮带输送机', '0', '皮带打滑');
INSERT INTO `backwardandresult` VALUES ('54', '69', '皮带输送机', '0', '轴承温度过高或振动');
INSERT INTO `backwardandresult` VALUES ('55', '70', '离心机', '0', '振动加剧');
INSERT INTO `backwardandresult` VALUES ('57', '72', '离心机', '0', '突然振动');
INSERT INTO `backwardandresult` VALUES ('58', '73', '离心机', '0', '逐渐地振动');
INSERT INTO `backwardandresult` VALUES ('59', '74', '离心机', '0', '有噪音');
INSERT INTO `backwardandresult` VALUES ('60', '75', '离心机', '0', '螺栓松动');
INSERT INTO `backwardandresult` VALUES ('61', '76', '离心机', '0', '轴承座过热');
INSERT INTO `backwardandresult` VALUES ('62', '77', '离心机', '0', '减速器过热');
INSERT INTO `backwardandresult` VALUES ('64', '79', '离心机', '0', '电机过载');
INSERT INTO `backwardandresult` VALUES ('65', '80', '离心机', '0', '螺旋转动不自如');
INSERT INTO `backwardandresult` VALUES ('66', '81', '离心机', '0', '扭矩异常');
INSERT INTO `backwardandresult` VALUES ('67', '82', '离心机', '0', '滤液澄清度差');
INSERT INTO `backwardandresult` VALUES ('68', '83', '离心机', '0', '污泥含水率高');
INSERT INTO `backwardandresult` VALUES ('69', '84', '离心机', '0', '固体排料很差');
INSERT INTO `backwardandresult` VALUES ('70', '85', '排污泵', '0', '不出水');
INSERT INTO `backwardandresult` VALUES ('71', '86', '排污泵', '0', '流量不足');
INSERT INTO `backwardandresult` VALUES ('72', '87', '排污泵', '0', '电机超载');
INSERT INTO `backwardandresult` VALUES ('73', '88', '排污泵', '0', '轴承温度过高');
INSERT INTO `backwardandresult` VALUES ('74', '89', '排污泵', '0', '运行不平稳');
INSERT INTO `backwardandresult` VALUES ('75', '90', '排污泵', '0', '泄漏');
INSERT INTO `backwardandresult` VALUES ('76', '91', '提泥阀', '0', '不好用');
INSERT INTO `backwardandresult` VALUES ('77', '92', '提泥阀', '0', '异常声音或振动');
INSERT INTO `backwardandresult` VALUES ('78', '93', '提泥阀', '0', '运行不平稳');
INSERT INTO `backwardandresult` VALUES ('79', '94', '提泥阀', '0', '原地不动');
INSERT INTO `backwardandresult` VALUES ('80', '95', '离心泵', '0', '突然停泵');
INSERT INTO `backwardandresult` VALUES ('81', '96', '离心泵', '0', '泵不出水');
INSERT INTO `backwardandresult` VALUES ('82', '97', '离心泵', '0', '流量不足');
INSERT INTO `backwardandresult` VALUES ('83', '98', '离心泵', '0', '功率过大');
INSERT INTO `backwardandresult` VALUES ('84', '99', '离心泵', '0', '轴承过热');
INSERT INTO `backwardandresult` VALUES ('85', '100', '离心泵', '0', '泵运行不稳定');
INSERT INTO `backwardandresult` VALUES ('86', '101', '轴封', '0', '泄露过多');
INSERT INTO `backwardandresult` VALUES ('87', '102', '鼓风机', '0', '轴承振动');
INSERT INTO `backwardandresult` VALUES ('88', '103', '鼓风机', '0', '轴承发热');
INSERT INTO `backwardandresult` VALUES ('89', '104', '鼓风机', '0', '噪音大');
INSERT INTO `backwardandresult` VALUES ('90', '105', '空压机', '0', '油压降低');
INSERT INTO `backwardandresult` VALUES ('91', '106', '空压机', '0', '排气量显著降低');
INSERT INTO `backwardandresult` VALUES ('92', '107', '空压机', '0', '排气温度过高');
INSERT INTO `backwardandresult` VALUES ('93', '108', '空压机', '0', '一级排气压力高');
INSERT INTO `backwardandresult` VALUES ('94', '109', '空压机', '0', '一级排气压力低');
INSERT INTO `backwardandresult` VALUES ('95', '110', '空压机', '0', '二级排气压力达不到规定值');
INSERT INTO `backwardandresult` VALUES ('96', '111', '臭氧机', '0', '消防水池冒水');
INSERT INTO `backwardandresult` VALUES ('97', '112', '臭氧机', '0', '进水压力过低');
INSERT INTO `backwardandresult` VALUES ('98', '113', '臭氧机', '0', '进气压力过高');
INSERT INTO `backwardandresult` VALUES ('99', '114', '臭氧机', '0', '水压过低');
INSERT INTO `backwardandresult` VALUES ('100', '115', '臭氧机', '0', '臭氧发生器电路故障');

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
