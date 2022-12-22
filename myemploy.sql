/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : myemploy

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 23/12/2022 00:23:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, 'D3');
INSERT INTO `dept` VALUES (2, 'D2');
INSERT INTO `dept` VALUES (3, 'D1');
INSERT INTO `dept` VALUES (4, 'D4');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DeptID` int NOT NULL,
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 1, 'E4', '1991-01-12');
INSERT INTO `employee` VALUES (2, 2, 'E6', '1991-01-13');
INSERT INTO `employee` VALUES (3, 1, 'E3', '1991-01-14');
INSERT INTO `employee` VALUES (4, 2, 'E2', '1991-01-15');
INSERT INTO `employee` VALUES (5, 2, 'E1', '1991-01-16');
INSERT INTO `employee` VALUES (6, 4, 'E5', '1991-01-17');

SET FOREIGN_KEY_CHECKS = 1;
