/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : jpa-w

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-11-10 14:21:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `order_name` varchar(64) NOT NULL,
  `order_number` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', 'orderName', '370224a7-49c1-467e-9b5f-9111ad01bd20', '2017-11-09 12:04:49', '2017-11-09 12:04:49');
INSERT INTO `t_order` VALUES ('2', '1', 'orderName', '268ff7b3-617a-40c0-8665-4fd7fcb05ab7', '2017-11-09 12:06:36', '2017-11-09 12:06:36');
INSERT INTO `t_order` VALUES ('3', '2', 'orderName', '04d6c5c4-1730-496d-b263-594fe7f6b419', '2017-11-09 12:06:36', '2017-11-09 12:06:36');
INSERT INTO `t_order` VALUES ('4', '3', 'orderName', 'dab9154d-bc4c-47dc-9e1c-52ab5f3c4304', '2017-11-09 12:06:36', '2017-11-09 12:06:36');
INSERT INTO `t_order` VALUES ('5', '4', 'orderName', 'fc125fc6-9676-470a-aeae-99dd48b75bfc', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('6', '5', 'orderName', '398b7ae1-35fd-44f1-ad50-60c9742b3426', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('7', '6', 'orderName', 'ce654759-4bf2-4d61-bfb5-4b3b3ffd5a48', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('8', '7', 'orderName', '77c13a43-ee20-45dd-9a81-e5b8ea689621', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('9', '8', 'orderName', 'bbbbecbe-5cf2-451a-b719-5bf21d3c237e', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('10', '9', 'orderName', '02e26d1f-f1e0-469c-8db0-b51d694714e7', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('11', '10', 'orderName', '5fddd46e-5b9a-47a5-b8d9-4c461da2e976', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('12', '11', 'orderName', '934be7e2-9ee4-412d-be6e-e1b4a07c5eaa', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('13', '12', 'orderName', 'b7b13294-e4b7-4bc4-a0f8-7dc7f627bf3e', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('14', '13', 'orderName', '59ace648-5163-4add-b420-a6c2699b7ce7', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('15', '14', 'orderName', '6ee0b8b0-c107-4d08-843c-a1dfee37a7d4', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('16', '15', 'orderName', 'c0cfaf1b-6551-40c7-b37d-5354a30a3605', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('17', '16', 'orderName', '95b506fb-45ee-4a7c-88e2-1bbb725b9029', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('18', '17', 'orderName', 'dcce61ff-7468-49ac-b093-63f8df523f7a', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('19', '18', 'orderName', '4f7c9efd-7fa4-4de4-afec-a123e7b1370e', '2017-11-09 12:06:37', '2017-11-09 12:06:37');
INSERT INTO `t_order` VALUES ('20', '19', 'orderName', '5654dfc0-fafd-4639-84c9-62dee0e86c13', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('21', '20', 'orderName', 'c6316fd3-d0f2-4c0b-aaf9-82cf565e5f37', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('22', '21', 'orderName', 'efc010aa-b672-4c1d-bd6e-b1fa30294a19', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('23', '22', 'orderName', '2a4851a4-c474-4f45-a091-c299fd03f185', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('24', '23', 'orderName', 'db2718c2-3435-435f-85ab-23ab4494d70e', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('25', '24', 'orderName', '84bbfa9c-ea36-497b-b312-bb658e3645d6', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('26', '25', 'orderName', '7600e222-de3b-4bda-a67e-9c83458dd5cc', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('27', '26', 'orderName', 'cad48987-382c-4f0c-b481-a96297aede87', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('28', '27', 'orderName', '81caa39f-bb77-4288-a1c5-636399924942', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('29', '28', 'orderName', '33b8e02f-e051-48df-89d5-a8ddc884e4c3', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('30', '29', 'orderName', 'd2e0c584-f300-4f51-865f-9aca4c3024f8', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('31', '30', 'orderName', '3d6e1249-dd90-46b2-ac0a-e8ae80ec8472', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('32', '31', 'orderName', 'a72395ae-7d7a-4af3-9a02-2203cf125dbb', '2017-11-09 12:06:38', '2017-11-09 12:06:38');
INSERT INTO `t_order` VALUES ('33', '32', 'orderName', '6b3edd41-02a0-4765-8dc7-0e78cbe10524', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('34', '33', 'orderName', 'c17b2a70-5795-410f-bba6-e439d7b8c3a4', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('35', '34', 'orderName', 'd39f11cf-517b-47ab-a13a-2deb76555bbf', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('36', '35', 'orderName', '85dba1d8-01e2-481d-9368-930b63b2e4f2', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('37', '36', 'orderName', '6115bf7b-c867-4d21-a5bb-b3fe1ae8f45d', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('38', '37', 'orderName', '77f2d996-c46d-443e-8884-a1b9c451d3e4', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('39', '38', 'orderName', 'd125b00b-2e69-4988-9e7f-2998272d5adc', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('40', '39', 'orderName', '5bb21d21-a96f-4626-95fa-17ca0b2edfeb', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('41', '40', 'orderName', '89b174d9-6dd5-4d49-b362-4e3176cc46c1', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('42', '41', 'orderName', '30db74c9-469f-4040-ad15-f3447bab01fb', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('43', '42', 'orderName', 'c844c635-66da-4321-9e77-9b8ddf3f0439', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('44', '43', 'orderName', '89373105-1d2f-4137-a0bb-827414c93261', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('45', '44', 'orderName', 'f6de6387-83bb-483a-9dd7-6f4083c2212e', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('46', '45', 'orderName', 'ab96bf68-4cf5-4e8c-8b30-1e55fa77b2d4', '2017-11-09 12:06:39', '2017-11-09 12:06:39');
INSERT INTO `t_order` VALUES ('47', '46', 'orderName', '215c86d9-ae16-493d-b50c-398974b1e0b2', '2017-11-09 12:06:40', '2017-11-09 12:06:40');
INSERT INTO `t_order` VALUES ('48', '47', 'orderName', '3611485b-4792-4b1e-a51b-ba89748d8a3e', '2017-11-09 12:06:40', '2017-11-09 12:06:40');
INSERT INTO `t_order` VALUES ('49', '48', 'orderName', 'ca9871f2-d881-4d16-8a9a-69792cb81c33', '2017-11-09 12:06:40', '2017-11-09 12:06:40');
INSERT INTO `t_order` VALUES ('50', '49', 'orderName', 'f33d50dc-c96b-4b66-a3a1-f3d2beb695ad', '2017-11-09 12:06:40', '2017-11-09 12:06:40');
INSERT INTO `t_order` VALUES ('51', '1', 'orderName1', '3d9e866f-9d0e-49e7-838a-6b2e7995c0bd', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('52', '2', 'orderName2', 'f97aa58e-c2da-4cf9-921b-5e7acaf29efc', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('53', '3', 'orderName3', '8f7ff97e-f2b5-4152-ab6e-f59bfe7f1838', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('54', '4', 'orderName4', 'd08ad000-d53d-4640-89fe-96b866781f73', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('55', '5', 'orderName5', '0dc07b45-6160-4a12-b7b0-1e0528e7381d', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('56', '6', 'orderName6', 'dda0504a-17bf-46c6-8897-bed8246fd6bc', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('57', '7', 'orderName7', 'bca1d522-657a-4b9e-9740-f8e3a945e327', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('58', '8', 'orderName8', '754a6eff-6683-48ef-8c69-5be60903f760', '2017-11-09 12:07:10', '2017-11-09 12:07:10');
INSERT INTO `t_order` VALUES ('59', '9', 'orderName9', '97832327-5668-4256-b7e9-1061041109dc', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('60', '10', 'orderName10', '8bfec28c-d8c7-4870-a204-04400579a411', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('61', '11', 'orderName11', '18284ad6-552d-402e-8f6c-39dc2f03cd80', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('62', '12', 'orderName12', '45b56e40-7ece-45f3-8491-fd4e200e771e', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('63', '13', 'orderName13', '3f6c4367-4aaf-4b14-854a-a0c3a5a1ecc9', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('64', '14', 'orderName14', 'b41faeed-69ff-4330-b4f1-25ff6f831335', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('65', '15', 'orderName15', '057ad1e5-fe4b-41ac-a73c-26e0378218fd', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('66', '16', 'orderName16', 'b94ada95-c383-4966-9647-71ca79adc6c8', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('67', '17', 'orderName17', 'bc7ebac7-0879-4369-816f-d66ec36cc88a', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('68', '18', 'orderName18', '33dde1f2-6c64-48ca-a1e9-e55b3322e78c', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('69', '19', 'orderName19', '16a185ba-0518-45f9-8100-9f4a7de023c8', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('70', '20', 'orderName20', '11cdf292-a912-4ec7-8ca7-bdb877906e6e', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('71', '21', 'orderName21', '240a5b6d-3200-463e-8c38-1dc604b2a96b', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('72', '22', 'orderName22', '2da66a41-4c51-4bd7-af12-85a710c64e61', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('73', '23', 'orderName23', 'c99aafab-4d46-4098-bdbb-a8d5c6df6290', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('74', '24', 'orderName24', '97d458b3-0f19-4897-aa6e-10d434bc76bc', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('75', '25', 'orderName25', '16f5ebc3-eede-408b-9933-20acc3a23e29', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('76', '26', 'orderName26', 'cc662010-418f-459e-9c71-fc7ac807571e', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('77', '27', 'orderName27', '8fa89708-4841-4305-8dec-5b00dd612b94', '2017-11-09 12:07:11', '2017-11-09 12:07:11');
INSERT INTO `t_order` VALUES ('78', '28', 'orderName28', 'c47164f6-5cb5-4e14-bc78-3ea807ccca14', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('79', '29', 'orderName29', 'dd16167c-8152-4233-ae41-3f960cced30a', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('80', '30', 'orderName30', 'd885078f-7d12-4971-90d8-b98163c12b14', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('81', '31', 'orderName31', '95779580-7a9f-4437-b9a9-53f5301c8a69', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('82', '32', 'orderName32', '68f8af59-5337-475e-ba0b-39ea30786f77', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('83', '33', 'orderName33', '3f795eb1-acfb-47e1-b34a-4cf2fa007f75', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('84', '34', 'orderName34', '143bda73-492d-4cef-be13-b1e1fbbd5854', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('85', '35', 'orderName35', 'b67308dd-ca39-4cda-8747-4c2dfb23edde', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('86', '36', 'orderName36', '673c3078-614b-4d9a-a87b-9743f04213db', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('87', '37', 'orderName37', '1b7f5daf-b92c-41a6-8da5-1df287c7040c', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('88', '38', 'orderName38', '5da4eb4a-e39d-481f-9b3f-c44825f824ce', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('89', '39', 'orderName39', '0dccfa53-bd04-4ff4-8e3d-c02d27ca1be6', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('90', '40', 'orderName40', '9ae4672f-4b0d-4414-82de-d30cad0345cd', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('91', '41', 'orderName41', 'e3039d3e-c8ed-4418-b2f7-d77b572758ee', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('92', '42', 'orderName42', '67c921b1-df85-4051-b3f6-38ae214756ad', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('93', '43', 'orderName43', 'f8d4b212-e1f3-4f9e-ac5f-2949a30b0594', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('94', '44', 'orderName44', 'c78ecc58-4112-4636-ad18-062e0d7c644a', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('95', '45', 'orderName45', 'ada37166-d9d2-4dae-af81-ddce6a4f8ec1', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('96', '46', 'orderName46', 'd9ed26c8-b314-4b8a-83b4-4a331ed7e213', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('97', '47', 'orderName47', 'e2517ef4-5d40-4464-b610-0594d8aab6c6', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('98', '48', 'orderName48', '74a72701-dafa-45e6-8015-3441a9d1c542', '2017-11-09 12:07:12', '2017-11-09 12:07:12');
INSERT INTO `t_order` VALUES ('99', '49', 'orderName49', '0c110acc-3dff-42a2-9ae9-f2b1b471d8ff', '2017-11-09 12:07:12', '2017-11-09 12:07:12');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'user0', '96e79218965eb72c92a549dd5a330112', 'nickname0', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('2', 'user1', '96e79218965eb72c92a549dd5a330112', 'nickname1', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('3', 'user2', '96e79218965eb72c92a549dd5a330112', '被修改了咯', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('4', 'user3', '96e79218965eb72c92a549dd5a330112', 'nickname3', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('5', 'user4', '96e79218965eb72c92a549dd5a330112', 'nickname4', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('6', 'user5', '96e79218965eb72c92a549dd5a330112', 'nickname5', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('7', 'user6', '96e79218965eb72c92a549dd5a330112', 'nickname6', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('8', 'user7', '96e79218965eb72c92a549dd5a330112', 'nickname7', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('9', 'user8', '96e79218965eb72c92a549dd5a330112', 'nickname8', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('10', 'user9', '96e79218965eb72c92a549dd5a330112', 'nickname9', '2017-11-09 11:48:06', '2017-11-09 11:48:06');
INSERT INTO `t_user` VALUES ('11', 'user10', '96e79218965eb72c92a549dd5a330112', 'nickname10', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('12', 'user11', '96e79218965eb72c92a549dd5a330112', 'nickname11', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('13', 'user12', '96e79218965eb72c92a549dd5a330112', 'nickname12', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('14', 'user13', '96e79218965eb72c92a549dd5a330112', 'nickname13', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('15', 'user14', '96e79218965eb72c92a549dd5a330112', 'nickname14', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('16', 'user15', '96e79218965eb72c92a549dd5a330112', 'nickname15', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('17', 'user16', '96e79218965eb72c92a549dd5a330112', 'nickname16', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('18', 'user17', '96e79218965eb72c92a549dd5a330112', 'nickname17', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('19', 'user18', '96e79218965eb72c92a549dd5a330112', 'nickname18', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('20', 'user19', '96e79218965eb72c92a549dd5a330112', 'nickname19', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('21', 'user20', '96e79218965eb72c92a549dd5a330112', 'nickname20', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('22', 'user21', '96e79218965eb72c92a549dd5a330112', 'nickname21', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('23', 'user22', '96e79218965eb72c92a549dd5a330112', 'nickname22', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('24', 'user23', '96e79218965eb72c92a549dd5a330112', 'nickname23', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('25', 'user24', '96e79218965eb72c92a549dd5a330112', 'nickname24', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('26', 'user25', '96e79218965eb72c92a549dd5a330112', 'nickname25', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('27', 'user26', '96e79218965eb72c92a549dd5a330112', 'nickname26', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('28', 'user27', '96e79218965eb72c92a549dd5a330112', 'nickname27', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('29', 'user28', '96e79218965eb72c92a549dd5a330112', 'nickname28', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('30', 'user29', '96e79218965eb72c92a549dd5a330112', 'nickname29', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('31', 'user30', '96e79218965eb72c92a549dd5a330112', 'nickname30', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('32', 'user31', '96e79218965eb72c92a549dd5a330112', 'nickname31', '2017-11-09 11:48:07', '2017-11-09 11:48:07');
INSERT INTO `t_user` VALUES ('33', 'user32', '96e79218965eb72c92a549dd5a330112', 'nickname32', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('34', 'user33', '96e79218965eb72c92a549dd5a330112', 'nickname33', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('35', 'user34', '96e79218965eb72c92a549dd5a330112', 'nickname34', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('36', 'user35', '96e79218965eb72c92a549dd5a330112', 'nickname35', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('37', 'user36', '96e79218965eb72c92a549dd5a330112', 'nickname36', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('38', 'user37', '96e79218965eb72c92a549dd5a330112', 'nickname37', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('39', 'user38', '96e79218965eb72c92a549dd5a330112', 'nickname38', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('40', 'user39', '96e79218965eb72c92a549dd5a330112', 'nickname39', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('41', 'user40', '96e79218965eb72c92a549dd5a330112', 'nickname40', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('42', 'user41', '96e79218965eb72c92a549dd5a330112', 'nickname41', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('43', 'user42', '96e79218965eb72c92a549dd5a330112', 'nickname42', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('44', 'user43', '96e79218965eb72c92a549dd5a330112', 'nickname43', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('45', 'user44', '96e79218965eb72c92a549dd5a330112', 'nickname44', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('46', 'user45', '96e79218965eb72c92a549dd5a330112', 'nickname45', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('47', 'user46', '96e79218965eb72c92a549dd5a330112', 'nickname46', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('48', 'user47', '96e79218965eb72c92a549dd5a330112', 'nickname47', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('49', 'user48', '96e79218965eb72c92a549dd5a330112', 'nickname48', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
INSERT INTO `t_user` VALUES ('50', 'user49', '96e79218965eb72c92a549dd5a330112', 'nickname49', '2017-11-09 11:48:08', '2017-11-09 11:48:08');
