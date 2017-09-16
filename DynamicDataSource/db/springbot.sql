/*
Navicat MySQL Data Transfer

Source Server         : 开发机
Source Server Version : 50553
Source Host           : 192.168.1.2:3306
Source Database       : springbot

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-11-08 15:04:07
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
) ENGINE=InnoDB AUTO_INCREMENT=1440 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_api_log
-- ----------------------------
INSERT INTO `t_api_log` VALUES ('1439', '20161111', 'param:{password=[Ljava.lang.String;@4a86882d}', '200', 'returns', 'http://localhost:2222/error', '2016-11-08 10:49:05', '2016-11-08 10:48:40');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '会员ID',
  `USER_EMAIL` varchar(256) DEFAULT NULL COMMENT '注册邮箱',
  `USER_PASSWD` varchar(50) NOT NULL COMMENT '用户密码 : mysql的passwd函数变换',
  `BIRTHDAY` date NOT NULL COMMENT '生日',
  `GENDER` tinyint(4) NOT NULL COMMENT '性别 : 1：男, 2：女',
  `JOB` char(3) DEFAULT NULL COMMENT '职业',
  `NICK_NAME` varchar(128) DEFAULT NULL COMMENT '昵称',
  `MOBILE` varchar(20) NOT NULL COMMENT '手机',
  `PROVINCE` char(3) DEFAULT NULL COMMENT '所在省市',
  `DISTRICT` char(3) DEFAULT NULL COMMENT '所在区县',
  `ADDRESS` varchar(128) DEFAULT NULL COMMENT '详细地址',
  `device_type` tinyint(4) DEFAULT NULL COMMENT '3 android 4 iso',
  `TOKEN` varchar(256) NOT NULL COMMENT 'token',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建日期',
  `UPDATE_DATE` datetime NOT NULL COMMENT '更新日期',
  `LAST_LOGIN_DATE` datetime NOT NULL COMMENT '最近登录日期',
  `DEL_FLG` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除区分 : 0:未删除 1:删除',
  PRIMARY KEY (`USER_ID`),
  KEY `T_USER_MOBILE` (`MOBILE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53682 DEFAULT CHARSET=utf8 COMMENT='会员情报表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '', 'e10adc3949ba59abbe56e057f20f883e', '1987-02-27', '1', '', '小明22', '11111111111', '003', '013', '测试地址1吧', null, '54C3A9AB8A0140A6B86383087DB15F97', '2014-12-19 23:59:14', '2015-11-03 15:17:46', '2015-11-03 15:16:25', '0');
INSERT INTO `t_user` VALUES ('2', '', '30f6613dde9903dd5e80cf5284324d9d', '1985-12-01', '1', '', '6', '22222222222', '002', '002', 'njkl', null, '4890A8D2989845E19BB7B60E07503071', '2014-07-18 01:19:04', '2014-12-18 22:39:45', '2014-12-18 22:39:45', '0');
INSERT INTO `t_user` VALUES ('3', '', '30f6613dde9903dd5e80cf5284324d9d', '1986-01-01', '1', '', '', '33333333333', '001', '001', '', null, 'D95343A2500341CC89187112EAB455E9', '2014-07-18 01:20:50', '2014-09-23 15:13:39', '2014-08-27 11:15:13', '1');
INSERT INTO `t_user` VALUES ('4', '', '30f6613dde9903dd5e80cf5284324d9d', '1985-01-01', '1', '', 'miss', '44444444444', '002', '013', 'xxxxx', null, 'F957EBD06654417A9FFF8A15492434D1', '2014-07-24 17:23:54', '2014-12-18 11:14:02', '2014-12-18 11:14:02', '0');
INSERT INTO `t_user` VALUES ('5', '', 'c2d283aec05aaf06fdab5110acbb05d5', '1983-03-01', '1', '', 'shkali', '55555555555', '002', '005', '', null, '162470130A4F4150B93F698D21B2B45F', '2014-07-24 19:06:16', '2014-11-29 12:49:04', '2014-11-29 12:49:04', '0');
