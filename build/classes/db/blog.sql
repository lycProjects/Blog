/*
 Navicat Premium Data Transfer

 Source Server         : lycc
 Source Server Type    : MySQL
 Source Server Version : 50022
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50022
 File Encoding         : 65001

 Date: 28/12/2018 16:16:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_table
-- ----------------------------
DROP TABLE IF EXISTS `blog_table`;
CREATE TABLE `blog_table`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag` int(11) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NULL DEFAULT NULL,
  `readnum` int(11) NULL DEFAULT NULL,
  `good` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_table
-- ----------------------------
INSERT INTO `blog_table` VALUES (2, '890', 3, 'ghjkl', '2018-12-28 01:28:51', 1, 0, 0, 1);
INSERT INTO `blog_table` VALUES (3, 'asdfasdfas', 6, 'asdfasf', '2018-12-27 12:41:23', 1, 0, 0, 1);
INSERT INTO `blog_table` VALUES (4, 'pinads', 5, '减0', '2018-12-28 01:28:47', 1, 0, 0, 1);
INSERT INTO `blog_table` VALUES (8, '89', 4, 'ghjkl', '2018-12-28 11:46:49', 1, 0, 0, 1);
INSERT INTO `blog_table` VALUES (10, '勇', 7, '你好', '2018-12-27 14:58:58', 1, 0, 0, 1);
INSERT INTO `blog_table` VALUES (11, 'za', 1, 'asfdsafsdafsaf', '2018-12-28 11:06:02', 3, 0, 0, 2);
INSERT INTO `blog_table` VALUES (26, 'fdsafsda', 1, 'fdsafa', '2018-12-28 10:26:07', 1, 0, 0, 2);
INSERT INTO `blog_table` VALUES (28, '李勇超', 1, '你好', '2018-12-28 11:58:04', 2, 0, 0, 1);
INSERT INTO `blog_table` VALUES (33, '89', 1, 'qweq', '2018-12-28 11:11:23', 2, 0, 2, 2);
INSERT INTO `blog_table` VALUES (34, '弹窗', 1, 'hello world', '2018-12-28 11:28:34', 3, 0, 8, 8);
INSERT INTO `blog_table` VALUES (36, '李', 1, 'sd', '2018-12-28 11:56:55', 1, 0, 1, 1);

-- ----------------------------
-- Table structure for tag_table
-- ----------------------------
DROP TABLE IF EXISTS `tag_table`;
CREATE TABLE `tag_table`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tag_table
-- ----------------------------
INSERT INTO `tag_table` VALUES (1, '热门', 1);
INSERT INTO `tag_table` VALUES (2, '娱乐', 1);
INSERT INTO `tag_table` VALUES (3, '科技', 1);
INSERT INTO `tag_table` VALUES (4, '历史', 1);
INSERT INTO `tag_table` VALUES (5, '军事', 1);
INSERT INTO `tag_table` VALUES (6, '电影', 1);
INSERT INTO `tag_table` VALUES (7, '体育', 1);

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `pwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(26) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES (1, 'li', '202cb962ac59075b964b07152d234b70', NULL, NULL);
INSERT INTO `user_table` VALUES (2, 'liyongchao', '202cb962ac59075b964b07152d234b70', NULL, NULL);
INSERT INTO `user_table` VALUES (3, '黄洪', '202cb962ac59075b964b07152d234b70', '老黄', 'lao.com');
INSERT INTO `user_table` VALUES (7, 'a', '202cb962ac59075b964b07152d234b70', 'asd', '1214744492@qq.com');
INSERT INTO `user_table` VALUES (8, 'ccc', '202cb962ac59075b964b07152d234b70', 'chen', '1214744492@qq.com');
INSERT INTO `user_table` VALUES (9, '小凤', '202cb962ac59075b964b07152d234b70', 'ljhljk', '1214744492@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
