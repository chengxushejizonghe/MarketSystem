/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : market

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 18/06/2021 23:44:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `balance` double(50, 2) NULL DEFAULT NULL,
  `realName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creationTime` datetime(6) NULL DEFAULT CURRENT_TIMESTAMP(6),
  `contactPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'lbwnb', '123456', 0.00, '张三', '2021-06-11 13:51:31.516806', '1232548154', 'asc@qq.com', 0);
INSERT INTO `customer` VALUES (2, 'javaT', '123654', 0.00, '李白', '2021-06-18 23:23:30.486229', '37215005', 'qw@gmail.com', 0);
INSERT INTO `customer` VALUES (3, 'wu', '321654', 150.00, '无', '2021-06-17 09:50:21.544515', '5465168', 'a6s54c@a3s5c4.com', 1);
INSERT INTO `customer` VALUES (4, 'zzzz', '3356', 10.00, '李四', '2021-06-17 16:40:35.357762', '13823878923', 'acs546@gmail.com', 0);

-- ----------------------------
-- Table structure for inventorymanager
-- ----------------------------
DROP TABLE IF EXISTS `inventorymanager`;
CREATE TABLE `inventorymanager`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventorymanager
-- ----------------------------
INSERT INTO `inventorymanager` VALUES (1, 'iadmin', '1234');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `productName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double(10, 2) NOT NULL,
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productionDate` datetime(6) NULL DEFAULT NULL,
  `quantity` int(0) NULL DEFAULT 0,
  `salesVolume` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'apple', 2.10, 'fruit', '2021-06-11 13:53:30.000000', 30, 0);
INSERT INTO `product` VALUES (2, 'orange', 1.30, 'fruit', '2021-06-19 23:24:30.000000', 20, 0);

-- ----------------------------
-- Table structure for usersmanager
-- ----------------------------
DROP TABLE IF EXISTS `usersmanager`;
CREATE TABLE `usersmanager`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usersmanager
-- ----------------------------
INSERT INTO `usersmanager` VALUES (1, 'admin', '123456');
INSERT INTO `usersmanager` VALUES (2, 'admin2', '123321');

SET FOREIGN_KEY_CHECKS = 1;
