/*
 Navicat Premium Data Transfer

 Source Server         : xiangyanlin
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : rental

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 25/04/2020 23:43:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '合约编号',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合约状态1待签约，2履约中，3已结束，4已逾期',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业地址',
  `house_id` int(10) NULL DEFAULT NULL COMMENT '房源编号',
  `owner_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主姓名',
  `tenant_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租客姓名',
  `start_time` date NULL DEFAULT NULL COMMENT '签约日期',
  `end_time` date NULL DEFAULT NULL COMMENT '到期日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '3', '湖南长沙', 3, '张三', '李四', '2020-01-01', '2020-03-18');

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '字典编号',
  `dict_type_id` int(10) NULL DEFAULT NULL COMMENT '字典类型编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典名',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `sort` int(20) NULL DEFAULT NULL COMMENT '字典排序号',
  `is_default` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否默认值，0不是，1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES (1, 1, '男', '1', 0, '1');
INSERT INTO `dict` VALUES (2, 1, '女', '2', 1, '0');
INSERT INTO `dict` VALUES (3, 1, '未知', '0', 2, '0');
INSERT INTO `dict` VALUES (4, 4, '未认证', '0', 0, '1');
INSERT INTO `dict` VALUES (5, 4, '已认证', '1', 1, '0');
INSERT INTO `dict` VALUES (7, 3, '大专以下', '1', NULL, '0');
INSERT INTO `dict` VALUES (8, 3, '大专', '2', NULL, '0');
INSERT INTO `dict` VALUES (9, 3, '本科', '3', NULL, '1');
INSERT INTO `dict` VALUES (10, 3, '研究生', '4', NULL, '0');
INSERT INTO `dict` VALUES (11, 3, '研究生以上', '5', NULL, '0');

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '字典类型编号',
  `dict_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类型名',
  `dict_type_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类型描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_type
-- ----------------------------
INSERT INTO `dict_type` VALUES (1, '性别', '性别');
INSERT INTO `dict_type` VALUES (2, '角色', '用户角色');
INSERT INTO `dict_type` VALUES (3, '学历', '用户学历');
INSERT INTO `dict_type` VALUES (4, '认证', '用户实名认证');

-- ----------------------------
-- Table structure for estate
-- ----------------------------
DROP TABLE IF EXISTS `estate`;
CREATE TABLE `estate`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼盘名称',
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在省',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在市',
  `area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体地址',
  `year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑年代',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑类型1塔楼，2板楼',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `property_company` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业公司',
  `developers` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开发商',
  `created` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  `updated` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1010 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '楼盘表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of estate
-- ----------------------------
INSERT INTO `estate` VALUES (1001, '中远两湾城', '上海市', '上海市', '普陀区', '上海市上海市普陀区上海市上海市普陀区远景路97弄', '2000', '1', '1.5', '上海中远物业管理发展有限公司', '上海万业企业股份有限公司', '2018-11-06 23:00:20.000000', '2018-11-06 23:00:23.000000');
INSERT INTO `estate` VALUES (1002, '上海康城', '上海市', '上海市', '闵行区', '莘松路958弄', '2001', '1', '1.5', '盛孚物业', '闵行房地产', '2018-11-06 23:02:30.000000', '2018-11-27 23:02:33.000000');
INSERT INTO `estate` VALUES (1003, '保利西子湾', '上海市', '上海市', '松江区', '广富林路1188弄', '2008', '2', '1.75', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-06 23:04:22.000000', '2018-11-06 23:04:25.000000');
INSERT INTO `estate` VALUES (1004, '万科城市花园', '上海市', '上海市', '松江区', '广富林路1188弄', '2002', '2', '1.5', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-13 16:43:40.000000', '2018-11-13 16:43:42.000000');
INSERT INTO `estate` VALUES (1005, '上海阳城', '上海市', '上海市', '闵行区', '罗锦路888弄', '2002', '1', '1.5', '上海莲阳物业管理有限公司', '上海莲城房地产开发有限公司', '2018-11-06 23:23:52.000000', '2018-11-06 23:23:55.000000');
INSERT INTO `estate` VALUES (1006, '乐山十一村', '上海市', '上海市', '普陀区', '远景路97弄', '2001', '2', '1.5', '上海中远物业管理发展有限公司', '上海万业企业股份有限公司', '2018-11-06 23:00:20.000000', '2018-11-06 23:00:23.000000');
INSERT INTO `estate` VALUES (1007, '韦斯特花园', '湖南省', '张家界市', '永定区', '高铁站旁', '2019', '1', '5', '测试新增', '测试新增', '2020-04-18 21:53:14.440000', '2020-04-18 21:53:14.440000');

-- ----------------------------
-- Table structure for house_resources
-- ----------------------------
DROP TABLE IF EXISTS `house_resources`;
CREATE TABLE `house_resources`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源标题',
  `owner_id` int(10) NULL DEFAULT NULL COMMENT '房东编号',
  `estate_id` int(10) NULL DEFAULT NULL COMMENT '楼盘id',
  `building_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼号（栋）',
  `building_unit` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元号',
  `building_floor_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `used` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋用处1住宅，2商住两用',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋状态0待审核，1待租，2租出',
  `rent` int(10) NULL DEFAULT NULL COMMENT '租金',
  `rent_method` int(4) NULL DEFAULT NULL COMMENT '租赁方式，1-整租，2-合租',
  `payment_method` int(4) NULL DEFAULT NULL COMMENT '支付方式，1-付一押一，2-付三押一，3-付六押一，4-年付押一，5-其它',
  `house_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户型，如：2室1厅1卫',
  `covered_area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑面积',
  `use_area` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用面积',
  `floor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼层，如：8/26',
  `orientation` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '朝向：东、南、西、北',
  `decoration` int(4) NULL DEFAULT NULL COMMENT '装修，1-精装，2-简装，3-毛坯',
  `facilities` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配套设施， 如：1,2,3',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片，最多5张',
  `house_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `time` int(4) NULL DEFAULT NULL COMMENT '看房时间，1-上午，2-中午，3-下午，4-晚上，5-全天',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房源表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of house_resources
-- ----------------------------
INSERT INTO `house_resources` VALUES (2, '东方曼哈顿 3室2厅 16000 元', 4, 1005, '2', '1', '1', '1', '1', 1111, 1, NULL, ' 1室1厅1卫1厨1阳台', '200', '2', '1/2', '南', NULL, '1,2,3,8,9', '/images/2020/04/03/2020040301030440607986.jpg,/images/2020/04/03/2020040301030860001359.jpg,/images/2020/04/03/2020040301031231505514.jpg,/images/2020/04/03/2020040301031618008001.jpg,/images/2020/04/03/2020040301031945401321.jpg', '这个经纪人很懒，没写核心卖 点', '张 三', '11111111111', 1, '11', NULL, '2020-04-03 13:03:21');
INSERT INTO `house_resources` VALUES (5, '凌海明珠', 5, 1002, '4', '2', '526', '2', '1', 4000, 1, 2, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,3', '/images/2020/04/03/2020040301072735306079.png,/images/2020/04/03/2020040301073121508071.jpg,/images/2020/04/03/2020040301073500603333.jpg,/images/2020/04/03/2020040301074093703005.jpg,/images/2020/04/03/2020040301074686909346.jpg', '好', '李四', '13122226666', 2, '1', NULL, '2020-04-03 13:07:48');
INSERT INTO `house_resources` VALUES (6, '天堂湾', 4, 1003, '4', '1', '633', '2', '1', 3500, 1, 1, '4室3厅2卫2厨3阳台', '200', '180', '6/20', '南', 1, '1,2,3,8,7,5,4,6', '/images/2020/04/03/2020040301083499802121.jpg,/images/2020/04/03/2020040301084018201672.jpg,/images/2020/04/03/2020040301084778608648.jpg,/images/2020/04/03/2020040301085304209064.jpg,/images/2020/04/03/2020040301085955608826.jpg', '设备齐全，带车库', '李元霸', '13144445555', 5, '5', NULL, '2020-04-03 13:09:01');
INSERT INTO `house_resources` VALUES (17, '峥嵘岁月', 4, 1002, '1', '1', '1', '1', '1', 1000, 1, 2, '1室1厅1卫1厨1阳台', '100', '92', '6/12', '南', 1, '1,2,3', '/images/2020/04/03/2020040301094711507383.jpg,/images/2020/04/03/202004030109538350376.jpg,/images/2020/04/03/2020040301100065709627.jpg,/images/2020/04/03/2020040301100691603734.jpg,/images/2020/04/03/2020040301101775602394.jpg', '11', '张三', '18774062479', 5, '5', '2020-03-18 20:13:06', '2020-04-03 13:10:21');
INSERT INTO `house_resources` VALUES (18, '整租·乐山十一村 2室1厅 ', 5, 1002, '4', '2', '526', '1', '1', 6000, 1, 2, '2室1厅1卫1厨1阳台', '80', '70', '5/12', '南', 1, '1,2,3,6,7', '/images/2020/04/03/2020040301142973901258.jpg,/images/2020/04/03/2020040301143364506145.jpg,/images/2020/04/03/2020040301143690303981.jpg,/images/2020/04/03/2020040301144075405744.jpg,/images/2020/04/03/2020040301144479302801.jpg', '位置好，交通便利啊，价格实惠', '李四', '13122226666', 5, '5', '2020-04-03 13:14:56', '2020-04-03 13:15:24');
INSERT INTO `house_resources` VALUES (19, '整租·打浦路1000弄 ', 5, 1005, '3', '2', '526', '1', '1', 7000, 1, 1, '3室1厅1卫1厨1阳台', '120', '100', '5/12', '南', 1, '1,2,3,4,5,6,7', '/images/2020/04/03/2020040301173072709898.jpg,/images/2020/04/03/2020040301173405304742.jpg,/images/2020/04/03/2020040301173857904733.jpg,/images/2020/04/03/202004030117424220192.jpg,/images/2020/04/03/2020040301174573602327.jpg', '面积广，价格好。值得组', '李四', '13122226666', 1, '3', '2020-04-03 13:17:53', NULL);
INSERT INTO `house_resources` VALUES (20, '整租·梅陇一百村 ', 5, 1002, '4', '6', '526', '1', '1', 8000, 1, 1, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,3,4,5,6,7', '/images/2020/04/03/2020040301173405304742.jpg,/images/2020/04/03/2020040301173072709898.jpg,/images/2020/04/03/2020040301173857904733.jpg,/images/2020/04/03/202004030117424220192.jpg,/images/2020/04/03/2020040301174573602327.jpg', '物美价廉，好', '李四', '13122226666', 1, '1', '2020-04-03 13:26:52', NULL);
INSERT INTO `house_resources` VALUES (21, '整租·梅陇一百零-村 ', 5, 1002, '1', '1', '526', '1', '1', 8000, 1, 4, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,4,6,7', '/images/2020/04/03/2020040301285324807936.jpg,/images/2020/04/03/2020040301285668603141.jpg,/images/2020/04/03/2020040301290049806878.jpg,/images/2020/04/03/2020040301290395805852.jpg,/images/2020/04/03/2020040301290784706432.jpg', '物美价廉，好得很', '李四', '13122226666', 1, '1', '2020-04-03 13:29:09', NULL);
INSERT INTO `house_resources` VALUES (22, '整租·万龙小区 ', 4, 1005, '1', '1', '526', '1', '1', 8000, 1, 4, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,4,6,7', '/images/2020/04/03/2020040301285668603141.jpg,/images/2020/04/03/2020040301290049806878.jpg,/images/2020/04/03/2020040301290395805852.jpg,/images/2020/04/03/2020040301290784706432.jpg,/images/2020/04/03/2020040301293790608938.jpg', '物美价廉，好得很', '李四', '13122226666', 1, '1', '2020-04-03 13:30:20', NULL);
INSERT INTO `house_resources` VALUES (23, '整租·新何三百村 ', 4, 1005, '1', '1', '526', '1', '1', 8000, 1, 4, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,4,6,7', '/images/2020/04/03/2020040301290049806878.jpg,/images/2020/04/03/2020040301290784706432.jpg,/images/2020/04/03/2020040301293790608938.jpg,/images/2020/04/03/2020040301304306302773.jpg,/images/2020/04/03/2020040301304720408126.jpg', '物美价廉，好得很', '李四', '13122226666', 1, '1', '2020-04-03 13:31:26', NULL);
INSERT INTO `house_resources` VALUES (24, '整租·新何三百村 ', 4, 1005, '1', '1', '526', '1', '1', 8000, 1, 4, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,4,6,7', '/images/2020/04/03/2020040301030860001359.jpg,/images/2020/04/03/2020040301030440607986.jpg,/images/2020/04/03/2020040301031231505514.jpg,/images/2020/04/03/2020040301031618008001.jpg,/images/2020/04/03/2020040301031945401321.jpg', '物美价廉，好得很', '李四', '13122226666', 1, '1', '2020-04-03 13:32:46', NULL);
INSERT INTO `house_resources` VALUES (25, '整租·美好家园', 5, 1005, '1', '1', '526', '1', '1', 8000, 1, 4, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,4,6,7', '/images/2020/04/03/2020040301031945401321.jpg,/images/2020/04/03/2020040301030860001359.jpg,/images/2020/04/03/2020040301030440607986.jpg,/images/2020/04/03/2020040301031231505514.jpg,/images/2020/04/03/2020040301031618008001.jpg', '物美价廉，好得很', '李四', '13122226666', 1, '1', '2020-04-03 13:34:32', NULL);
INSERT INTO `house_resources` VALUES (26, 'test', NULL, 1002, '1', '1', '1', '1', '1', 1, 1, 1, '3室2厅2卫2厨2阳台', '2000', '100', '6/2', '南', 1, '1,2,3', '', '111', '张三', '18774062479', 1, '5', '2020-04-06 16:07:54', NULL);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资讯编号',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯标题',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯简介',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯内容',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯图片',
  `read_num` int(10) NULL DEFAULT NULL COMMENT '阅读量',
  `publish_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (1, '房价上涨', '上涨了0.7个百分点', '3月，70个大中城市新房、二手房房价环比上涨数量均大幅增加。新房方面，38个城市房价上涨，较2月增加17城；二手房方面，二手房房价上涨城市增加至32个，较2月增加18城。', NULL, 65241, '2020-03-15 23:09:28', NULL);
INSERT INTO `information` VALUES (2, '房价继续上涨了', '又上涨了0.4个百分点', '中原地产首席分析师张大伟认为，在多方面因素刺激下，包括深圳、杭州等在内的多个城市房价出现了恢复，成为房价上涨的领先城市。', NULL, 65241, '2020-03-15 23:09:28', NULL);

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions`  (
  `id` int(11) NOT NULL COMMENT '问答编号',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问答标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问答内容',
  `publisher` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布者',
  `read_num` int(10) NULL DEFAULT NULL COMMENT '阅读量',
  `reply_num` int(10) NULL DEFAULT NULL COMMENT '回复量',
  `publish_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES (1, '交通位置', '房子所处交通位置方便吗', '大红', 125, 11, '2019-12-03 22:30:47');

-- ----------------------------
-- Table structure for rent_record
-- ----------------------------
DROP TABLE IF EXISTS `rent_record`;
CREATE TABLE `rent_record`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `house_id` int(10) NULL DEFAULT NULL COMMENT '房源id',
  `tenan_id` int(10) NULL DEFAULT NULL COMMENT '租客id',
  `ower_id` int(10) NULL DEFAULT NULL COMMENT '房东id',
  `contract_id` int(10) NULL DEFAULT NULL COMMENT '合同id',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租房状态1，已确认2，待确认3，待付款',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rent_record
-- ----------------------------
INSERT INTO `rent_record` VALUES (1, 5, 2, 5, 1, '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别0未知，1男性，2女性',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `id_card` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `profession` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `education` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历1大专以下，2大专，3本科，4研究生，5研究生以上',
  `role` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1管理员，2租客，3房东',
  `house_num` int(10) NULL DEFAULT NULL COMMENT '房源数量',
  `identify` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0未认证，1已认证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', '123456', NULL, 'test1@baomidou.com', '13627441292', '1', 'Jone', '13226519910506112x', '工人', '1', '1', 0, '1');
INSERT INTO `user` VALUES (2, 'Jack', '123456', '', 'test2@baomidou.com', '13611112222', '1', 'Jack', '132265199101026522', '工人', '2', '2', 0, '1');
INSERT INTO `user` VALUES (3, 'Tom', '123456', NULL, 'test3@baomidou.com', '13122223333', '1', 'Tom', '631265199101026522', '文员', '3', '2', 0, '1');
INSERT INTO `user` VALUES (4, 'Sandy', '123456', NULL, 'test4@baomidou.com', '13233334444', '2', 'Sandy', '631265199101026533', '教师', '4', '3', 4, '1');
INSERT INTO `user` VALUES (5, 'Billie', '123456', NULL, 'test5@baomidou.com', '13455556666', '1', 'Billie', '631265199101026514', '研究员', '5', '3', 9, '1');
INSERT INTO `user` VALUES (6, 'admin', '123456', '/images/2020/04/09/2020040911204753004770.jpg', '2356150341@qq.com', '13627441292', '2', '张三', '49025419950356251x', '管理员', '5', '1', NULL, '1');
INSERT INTO `user` VALUES (7, 'test', '123456', NULL, '2356150341@qq.com', '13627441292', NULL, NULL, NULL, NULL, NULL, '2', NULL, '0');
INSERT INTO `user` VALUES (8, 'tiaozhuan', '123456', NULL, '0341@qq.com', '13627441292', NULL, NULL, NULL, NULL, NULL, '2', NULL, '0');

-- ----------------------------
-- Table structure for vist_request
-- ----------------------------
DROP TABLE IF EXISTS `vist_request`;
CREATE TABLE `vist_request`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '请求编号',
  `tenant_id` int(10) NULL DEFAULT NULL COMMENT '租客编号',
  `owner_id` int(11) NULL DEFAULT NULL COMMENT '房东编号',
  `estate_id` int(10) NULL DEFAULT NULL COMMENT '楼盘编号',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `request_time` datetime(0) NULL DEFAULT NULL COMMENT '请求时间',
  `vist_time` datetime(0) NULL DEFAULT NULL COMMENT '看房时间',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求状态,1已完成,2待确认,3待看房,4已取消,5已拒绝',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vist_request
-- ----------------------------
INSERT INTO `vist_request` VALUES (9, 2, 4, 1005, '真心想租，要求去看下房', '2020-04-06 22:02:39', '2020-04-08 22:02:21', '4');
INSERT INTO `vist_request` VALUES (10, 2, 5, 1002, '房子真不错，希望看房', '2020-04-12 22:43:10', '2020-04-15 08:00:00', '1');
INSERT INTO `vist_request` VALUES (11, 3, 5, 1002, '我要看房', '2020-04-15 23:20:44', '2020-04-17 23:20:27', '5');

SET FOREIGN_KEY_CHECKS = 1;
