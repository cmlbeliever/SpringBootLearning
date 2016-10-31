/*
Navicat MySQL Data Transfer

Source Server         : 开发机
Source Server Version : 50553
Source Host           : 192.168.1.2:3306
Source Database       : springbot

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-10-31 17:41:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_api_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_api_log`;
CREATE TABLE `t_api_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `call_day` int(8) NOT NULL,
  `PARAMETERS` mediumtext,
  `RETURN_STATUS_CODE` int(11) DEFAULT NULL,
  `RETURNS` mediumtext,
  `API_URL` varchar(255) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1290 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_api_log
-- ----------------------------
INSERT INTO `t_api_log` VALUES ('1247', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addReadOnlyLog', '2016-10-27 10:42:02', '2016-10-27 10:42:02');
INSERT INTO `t_api_log` VALUES ('1248', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addReadOnlyLog', '2016-10-27 10:43:50', '2016-10-27 10:43:50');
INSERT INTO `t_api_log` VALUES ('1249', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addReadOnlyLog', '2016-10-27 10:44:16', '2016-10-27 10:44:16');
INSERT INTO `t_api_log` VALUES ('1250', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 10:44:45', '2016-10-27 10:44:45');
INSERT INTO `t_api_log` VALUES ('1251', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 10:44:45', '2016-10-27 10:44:45');
INSERT INTO `t_api_log` VALUES ('1252', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 10:46:12', '2016-10-27 10:46:12');
INSERT INTO `t_api_log` VALUES ('1253', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 10:46:12', '2016-10-27 10:46:12');
INSERT INTO `t_api_log` VALUES ('1254', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addReadOnlyLog', '2016-10-27 10:46:22', '2016-10-27 10:46:22');
INSERT INTO `t_api_log` VALUES ('1255', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/error', '2016-10-27 10:46:23', '2016-10-27 10:46:23');
INSERT INTO `t_api_log` VALUES ('1256', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:15:28', '2016-10-27 11:15:28');
INSERT INTO `t_api_log` VALUES ('1257', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:15:28', '2016-10-27 11:15:28');
INSERT INTO `t_api_log` VALUES ('1258', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:16:28', '2016-10-27 11:16:28');
INSERT INTO `t_api_log` VALUES ('1259', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:16:28', '2016-10-27 11:16:28');
INSERT INTO `t_api_log` VALUES ('1260', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:17:10', '2016-10-27 11:17:10');
INSERT INTO `t_api_log` VALUES ('1261', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:17:10', '2016-10-27 11:17:10');
INSERT INTO `t_api_log` VALUES ('1262', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:23:46', '2016-10-27 11:23:46');
INSERT INTO `t_api_log` VALUES ('1263', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 11:23:46', '2016-10-27 11:23:46');
INSERT INTO `t_api_log` VALUES ('1264', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 12:20:41', '2016-10-27 12:20:41');
INSERT INTO `t_api_log` VALUES ('1265', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 12:20:41', '2016-10-27 12:20:41');
INSERT INTO `t_api_log` VALUES ('1266', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 12:38:29', '2016-10-27 12:38:22');
INSERT INTO `t_api_log` VALUES ('1267', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 12:38:29', '2016-10-27 12:38:22');
INSERT INTO `t_api_log` VALUES ('1268', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 14:48:35', '2016-10-27 14:48:27');
INSERT INTO `t_api_log` VALUES ('1269', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-27 14:48:35', '2016-10-27 14:48:27');
INSERT INTO `t_api_log` VALUES ('1270', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:37:58', '2016-10-31 17:37:46');
INSERT INTO `t_api_log` VALUES ('1271', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:37:58', '2016-10-31 17:37:46');
INSERT INTO `t_api_log` VALUES ('1272', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:00', '2016-10-31 17:37:47');
INSERT INTO `t_api_log` VALUES ('1273', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:00', '2016-10-31 17:37:47');
INSERT INTO `t_api_log` VALUES ('1274', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:01', '2016-10-31 17:37:48');
INSERT INTO `t_api_log` VALUES ('1275', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:01', '2016-10-31 17:37:48');
INSERT INTO `t_api_log` VALUES ('1276', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:01', '2016-10-31 17:37:49');
INSERT INTO `t_api_log` VALUES ('1277', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:01', '2016-10-31 17:37:49');
INSERT INTO `t_api_log` VALUES ('1278', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:02', '2016-10-31 17:37:49');
INSERT INTO `t_api_log` VALUES ('1279', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:02', '2016-10-31 17:37:49');
INSERT INTO `t_api_log` VALUES ('1280', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:02', '2016-10-31 17:37:49');
INSERT INTO `t_api_log` VALUES ('1281', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:02', '2016-10-31 17:37:49');
INSERT INTO `t_api_log` VALUES ('1282', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:02', '2016-10-31 17:37:50');
INSERT INTO `t_api_log` VALUES ('1283', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:02', '2016-10-31 17:37:50');
INSERT INTO `t_api_log` VALUES ('1284', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:03', '2016-10-31 17:37:50');
INSERT INTO `t_api_log` VALUES ('1285', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:03', '2016-10-31 17:37:50');
INSERT INTO `t_api_log` VALUES ('1286', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:03', '2016-10-31 17:37:50');
INSERT INTO `t_api_log` VALUES ('1287', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:03', '2016-10-31 17:37:50');
INSERT INTO `t_api_log` VALUES ('1288', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:04', '2016-10-31 17:37:51');
INSERT INTO `t_api_log` VALUES ('1289', '20161111', 'param:{}', '200', 'returns', 'http://localhost:2222/addLog', '2016-10-31 17:38:04', '2016-10-31 17:37:51');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '会员ID',
  `USER_EMAIL` varchar(256) DEFAULT NULL COMMENT '注册邮箱',
  `USER_PASSWD` varchar(50) NOT NULL COMMENT '用户密码 : mysql的passwd函数变换',
  `AUTH_CODE` char(6) DEFAULT NULL COMMENT '手机验证码',
  `AUTH_CODE_GET_TIME` datetime DEFAULT NULL COMMENT '验证码取得时间',
  `BARCODE` char(13) NOT NULL DEFAULT '0' COMMENT '会员条形码',
  `BIRTHDAY` date NOT NULL COMMENT '生日',
  `GENDER` tinyint(4) NOT NULL COMMENT '性别 : 1：男, 2：女',
  `JOB` char(3) DEFAULT NULL COMMENT '职业',
  `NICK_NAME` varchar(128) DEFAULT NULL COMMENT '昵称',
  `MOBILE` varchar(20) NOT NULL COMMENT '手机',
  `PROVINCE` char(3) DEFAULT NULL COMMENT '所在省市',
  `DISTRICT` char(3) DEFAULT NULL COMMENT '所在区县',
  `ADDRESS` varchar(128) DEFAULT NULL COMMENT '详细地址',
  `device_type` tinyint(4) DEFAULT NULL COMMENT '3 android 4 iso',
  `DAY_COUPON_UPPER_LIMIT` int(11) DEFAULT '10' COMMENT '每日接收优惠券上限',
  `TOKEN` varchar(256) NOT NULL COMMENT 'token',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建日期',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新日期',
  `LAST_LOGIN_DATE` datetime NOT NULL COMMENT '最近登录日期',
  `DEL_FLG` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除区分 : 0:未删除 1:删除',
  `PROTOCOL_AGREE_FLG` tinyint(4) DEFAULT '0' COMMENT '0 还没同意，1 同意',
  `push_channel_id` varchar(256) DEFAULT NULL,
  `push_user_id` varchar(256) DEFAULT NULL,
  `loc` tinyint(4) DEFAULT NULL COMMENT '1 上海  2 北京',
  `current_loc` tinyint(4) DEFAULT NULL COMMENT '1 上海  2 北京',
  PRIMARY KEY (`USER_ID`),
  KEY `T_USER_MOBILE` (`MOBILE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53682 DEFAULT CHARSET=utf8 COMMENT='会员情报表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '', '30f6613dde9903dd5e80cf5284324d9d', '', null, '1900000000019', '1987-02-27', '1', '', '小明22', '3232', '003', '013', '测试地址1吧', null, '10', 'C78CE23552BC46328959C8C0AE391886', '2014-12-19 23:59:14', '2015-11-03 15:17:46', '2015-11-03 15:16:25', '0', '0', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('2', '', '30f6613dde9903dd5e80cf5284324d9d', '', null, '1900000000026', '1985-12-01', '1', '', '6', '15221963935', '002', '002', 'njkl', null, '10', '4890A8D2989845E19BB7B60E07503071', '2014-07-18 01:19:04', '2014-12-18 22:39:45', '2014-12-18 22:39:45', '0', '0', null, null, '3', null);
INSERT INTO `t_user` VALUES ('3', '', '30f6613dde9903dd5e80cf5284324d9d', '838580', '2014-08-27 10:43:20', '1900000000033', '1986-01-01', '1', '', '', '13901785655', '001', '001', '', null, '99', 'D95343A2500341CC89187112EAB455E9', '2014-07-18 01:20:50', '2014-09-23 15:13:39', '2014-08-27 11:15:13', '1', '0', null, null, '3', null);
INSERT INTO `t_user` VALUES ('4', '', '30f6613dde9903dd5e80cf5284324d9d', '', null, '1900000000040', '1985-01-01', '1', '', 'miss', '18516118455', '002', '013', '金牛大厦', null, '10', 'F957EBD06654417A9FFF8A15492434D1', '2014-07-24 17:23:54', '2014-12-18 11:14:02', '2014-12-18 11:14:02', '0', '0', null, null, '3', null);
INSERT INTO `t_user` VALUES ('5', '', 'c2d283aec05aaf06fdab5110acbb05d5', '', null, '1900000000057', '1983-03-01', '1', '', 'shkali', '18701878729', '002', '005', '', null, '10', '162470130A4F4150B93F698D21B2B45F', '2014-07-24 19:06:16', '2014-11-29 12:49:04', '2014-11-29 12:49:04', '0', '0', null, null, '1', null);
