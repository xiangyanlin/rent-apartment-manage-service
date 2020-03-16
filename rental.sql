/*
 Navicat Premium Data Transfer

 Source Server         : xiangyanlin
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : rental

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 16/03/2020 23:14:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '合约编号',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合约状态',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业地址',
  `house_id` int(10) NULL DEFAULT NULL COMMENT '房源编号',
  `owner_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主姓名',
  `tenant_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租客姓名',
  `start_time` datetime NULL DEFAULT NULL COMMENT '签约日期',
  `end_time` datetime NULL DEFAULT NULL COMMENT '到期日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '1', '湖南长沙', 3, '张三', '李四', '2020-01-01 23:02:51', '2021-01-01 23:03:01');

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
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑类型',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `property_company` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业公司',
  `developers` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开发商',
  `created` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1006 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '楼盘表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of estate
-- ----------------------------
INSERT INTO `estate` VALUES (1001, '中远两湾城', '上海市', '上海市', '普陀区', '远景路97弄', '2001', '塔楼/板楼', '1.5', '上海中远物业管理发展有限公司', '上海万业企业股份有限公司', '2018-11-06 23:00:20', '2018-11-06 23:00:23');
INSERT INTO `estate` VALUES (1002, '上海康城', '上海市', '上海市', '闵行区', '莘松路958弄', '2001', '塔楼/板楼', '1.5', '盛孚物业', '闵行房地产', '2018-11-06 23:02:30', '2018-11-27 23:02:33');
INSERT INTO `estate` VALUES (1003, '保利西子湾', '上海市', '上海市', '松江区', '广富林路1188弄', '2008', '塔楼/板楼', '1.75', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-06 23:04:22', '2018-11-06 23:04:25');
INSERT INTO `estate` VALUES (1004, '万科城市花园', '上海市', '上海市', '松江区', '广富林路1188弄', '2002', '塔楼/板楼', '1.5', '上海保利物业管理', '上海城乾房地产开发有限公司', '2018-11-13 16:43:40', '2018-11-13 16:43:42');
INSERT INTO `estate` VALUES (1005, '上海阳城', '上海市', '上海市', '闵行区', '罗锦路888弄', '2002', '塔楼/板楼', '1.5', '上海莲阳物业管理有限公司', '上海莲城房地产开发有限公司', '2018-11-06 23:23:52', '2018-11-06 23:23:55');

-- ----------------------------
-- Table structure for house_resources
-- ----------------------------
DROP TABLE IF EXISTS `house_resources`;
CREATE TABLE `house_resources`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源标题',
  `estate_id` int(10) NULL DEFAULT NULL COMMENT '楼盘id',
  `building_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼号（栋）',
  `building_unit` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元号',
  `building_floor_num` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `used` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋用处1住宅，2商住两用',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋状态1待租，3租出',
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
  `pic` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片，最多5张',
  `house_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `time` int(4) NULL DEFAULT NULL COMMENT '看房时间，1-上午，2-中午，3-下午，4-晚上，5-全天',
  `property_cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业费',
  `created` datetime NULL DEFAULT NULL,
  `updated` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房源表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of house_resources
-- ----------------------------
INSERT INTO `house_resources` VALUES (1, '测试修改页面', 1, '1', '1', '1', NULL, NULL, 2000, 1, 1, '1', '120', '1', '1', '1', 1, '1', 'http://127.0.0.1:8080/common/getImage?filename=/images/2020/03/14/2020031410471657904864.jpg', '1', '1', '1', 1, '1', '2020-03-05 14:54:08', '2020-03-05 14:54:11');
INSERT INTO `house_resources` VALUES (2, '东方曼哈顿 3室2厅 16000 元', 1005, '2', '1', '1', NULL, NULL, 1111, 1, NULL, ' 1室1厅1卫1厨1阳台', '2', '2', '1/2', '南', NULL, '1,2,3,8,9', NULL, '这个经纪人很懒，没写核心卖 点', '张 三', '11111111111', 1, '11', NULL, '2020-03-15 22:50:51');
INSERT INTO `house_resources` VALUES (5, '凌海明珠', 1002, '4', '2', '526', NULL, NULL, 4000, 1, 2, '3室2厅1卫1厨2阳台', '120', '100', '5/12', '南', 1, '1,2,3', NULL, '好', '李四', '13122226666', 2, '1', NULL, NULL);
INSERT INTO `house_resources` VALUES (6, '天堂湾', 1003, '4', '1', '633', NULL, NULL, 3500, 1, 1, '4室3厅2卫2厨3阳台', '200', '180', '6/20', '南', 1, '1,2,3,8,7,5,4,6', '', '设备齐全，带车库', '李元霸', '13144445555', 5, '5', NULL, NULL);
INSERT INTO `house_resources` VALUES (7, '修改时间2', 1005, '10', '5', '101', NULL, NULL, 4000, 1, 1, '3室2厅1卫1厨2阳台', '120', '100', '10/1', '南', 1, '1,2,3', '', '111', '赵云', '13144445555', 1, '11', NULL, '2020-03-15 22:35:59');
INSERT INTO `house_resources` VALUES (8, '修改时间问题1', 1002, '1', '1', '11', NULL, NULL, 1000, 1, 1, '1室1厅1卫1厨1阳台', '100', '100', '1/10', '南', 1, '1,2,3,7', '', '111', '1', '13627441292', 1, '1', NULL, '2020-03-15 14:23:57');
INSERT INTO `house_resources` VALUES (9, '11', 1002, '1', '1', '11', NULL, NULL, 1000, 1, 1, '1室1厅1卫1厨1阳台', '100', '100', '1/10', '南', 1, '1,2,3,7', '', '111', '1', '13627441292', 1, '1', NULL, NULL);
INSERT INTO `house_resources` VALUES (10, '111', 1002, '5', '5', '5', NULL, NULL, 5000, 1, 1, '1室1厅1卫1厨1阳台', '100', '100', '1/1', '南', 1, '1,2,3', '', '111', '111', '1111', 1, '1', NULL, NULL);
INSERT INTO `house_resources` VALUES (11, '测试图片上传', 1001, '3', '3', '3', NULL, NULL, 3000, 1, 1, '3室3厅3卫3厨3阳台', '130', '100', '3/10', '南', 1, '1,2,3', 'http://127.0.0.1:8080/common/getImage?filename=/images/2020/03/08/2020030808090373704632.jpg', '图片', '哈哈', '18774062479', 1, '1', NULL, NULL);
INSERT INTO `house_resources` VALUES (12, 'hello', 1001, '1', '1', '1', NULL, NULL, 1, 1, 1, '4室3厅2卫2厨3阳台', '180', '150', '4/20', '南', 1, '1,2,3,5,6', 'http://127.0.0.1:8080/common/getImage?filename=/images/2020/03/11/2020031107290742307462.jpg,http://127.0.0.1:8080/common/getImage?filename=/images/2020/03/11/2020031107291325104751.jpg', '很大，设施齐全', '张三', '18774062479', 1, '5', NULL, NULL);
INSERT INTO `house_resources` VALUES (13, '测试分页', 1001, '12', '1', '101', NULL, NULL, 1000, 1, 1, '1室1厅1卫11厨1阳台', '110', '95', '1/10', '南', 1, '1,2,3', '', '测试分页', '张三', '13627441292', 1, '5', NULL, NULL);
INSERT INTO `house_resources` VALUES (14, '111', 1002, '111', '111', '11', NULL, NULL, 11, 1, 1, '1室1厅1卫1厨1阳台', '100', '100', '1/1', '南', 1, '1,2,3', '', '1001', '张三', '18774062479', 1, '100', NULL, NULL);
INSERT INTO `house_resources` VALUES (15, '测试新增bug', 1002, '1', '1', '1', NULL, NULL, 3000, 1, 1, '2室2厅2卫1厨2阳台', '80', '80', '5/10', '南', 1, '1,2,3', '', '111', '张三', '18774062479', 1, '5', NULL, NULL);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资讯编号',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯内容',
  `read_num` int(10) NULL DEFAULT NULL COMMENT '阅读量',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (1, '房价上涨', '上涨了0.7个百分点', 65241, '2020-03-15 23:09:28');

-- ----------------------------
-- Table structure for rent_record
-- ----------------------------
DROP TABLE IF EXISTS `rent_record`;
CREATE TABLE `rent_record`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `house_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源名称',
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
INSERT INTO `rent_record` VALUES (1, '凌海明珠', 3, 1, 1, 1, '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `real_name` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `id_card` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `profession` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `education` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `role` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1管理员，2租客，3房东',
  `house_num` int(10) NULL DEFAULT NULL COMMENT '房源数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', '123456', 'test1@baomidou.com', NULL, NULL, NULL, '', NULL, NULL, '1', NULL);
INSERT INTO `user` VALUES (2, 'Jack', '123456', 'test2@baomidou.com', NULL, NULL, NULL, '', NULL, NULL, '2', NULL);
INSERT INTO `user` VALUES (3, 'Tom', '123456', 'test3@baomidou.com', NULL, NULL, NULL, '', NULL, NULL, '2', NULL);
INSERT INTO `user` VALUES (4, 'Sandy', '123456', 'test4@baomidou.com', NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `user` VALUES (5, 'Billie', '123456', 'test5@baomidou.com', NULL, NULL, NULL, NULL, NULL, NULL, '3', NULL);

-- ----------------------------
-- Table structure for vist_request
-- ----------------------------
DROP TABLE IF EXISTS `vist_request`;
CREATE TABLE `vist_request`  (
  `id` int(10) NOT NULL COMMENT '请求编号',
  `tenant_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租客姓名',
  `mobile` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租客电话',
  `village` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源小区名',
  `reuest_time` datetime NULL DEFAULT NULL COMMENT '请求时间',
  `vist_time` datetime NULL DEFAULT NULL COMMENT '看房时间',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vist_request
-- ----------------------------
INSERT INTO `vist_request` VALUES (1, '租客1', '3355', '天堂港小区', '2020-03-02 18:59:32', '2020-03-04 18:59:36', '1');

SET FOREIGN_KEY_CHECKS = 1;
