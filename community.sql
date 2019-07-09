/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : community

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 09/07/2019 15:42:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_essay
-- ----------------------------
DROP TABLE IF EXISTS `blog_essay`;
CREATE TABLE `blog_essay`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章信息表',
  `user_id` int(11) UNSIGNED NOT NULL COMMENT '用户唯一Id',
  `essay_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '文章标题',
  `essay_content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '文章内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `pub_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `pub_state` tinyint(1) NULL DEFAULT NULL COMMENT '文章状态：0 未发布、1 已发布',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_essay_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_essay_tag`;
CREATE TABLE `blog_essay_tag`  (
  `essay_id` int(11) UNSIGNED NOT NULL COMMENT '文章ID',
  `tag_id` int(11) UNSIGNED NOT NULL COMMENT '标签ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章&标签关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章标签表',
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '标签名',
  `tag_type` tinyint(2) NULL DEFAULT NULL COMMENT '标签类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_address
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_address`;
CREATE TABLE `sys_user_address`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NOT NULL COMMENT '用户唯一ID',
  `province` int(10) NULL DEFAULT NULL COMMENT '省份Code',
  `city_code` int(10) NULL DEFAULT NULL COMMENT '城市Code',
  `district` int(10) NULL DEFAULT NULL COMMENT '区域Code',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '具体的详细地址',
  `modity_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户地址' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_auths
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_auths`;
CREATE TABLE `sys_user_auths`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户信息表',
  `user_id` int(11) UNSIGNED NOT NULL COMMENT '用户唯一ID',
  `identity_type` tinyint(2) NULL DEFAULT NULL COMMENT '登录类型：',
  `identifier` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '登录标识：账号、手机号、微信号等',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '密码凭证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户登录授权信息（一个用户可对应多个授权信息）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_auths
-- ----------------------------
INSERT INTO `sys_user_auths` VALUES (1, 1, 1, 'admin', '03934b80d3277df0e6972eaef5fedd21');

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '用户昵称',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '真实姓名',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别：0 女、1 男',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `user_img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `identity_card_type` tinyint(1) NULL DEFAULT NULL COMMENT '证件类型：1 身份证、2 军官证、3 驾驶证',
  `identity_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '证件号码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '联系方式：手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '邮箱',
  `synopsis` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '简介',
  `login_state` tinyint(1) NULL DEFAULT NULL COMMENT '登录状态：0 未登录、1 在线',
  `register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `last_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES (1, '张韦', '', NULL, NULL, NULL, NULL, NULL, '', '', '', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login_log`;
CREATE TABLE `sys_user_login_log`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '用户唯一Id',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '登录ip',
  `login_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '登录地点',
  `login_state` tinyint(1) NULL DEFAULT 0 COMMENT '是否登录成功：0 失败、1 成功',
  `identity_type` tinyint(2) NULL DEFAULT NULL COMMENT '登录方式：',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户登录记录' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
