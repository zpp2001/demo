/*
 Navicat Premium Data Transfer

 Source Server         : connection
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : information

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 24/03/2023 13:38:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `class_ibfk1`(`project_id`) USING BTREE,
  CONSTRAINT `class_ibfk1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1662173125', 'HttpSecurity', '1667529593');
INSERT INTO `class` VALUES ('1663095256', 'Thymeleaf', '1667529593');
INSERT INTO `class` VALUES ('1664196173', 'LoginController', '1667529593');
INSERT INTO `class` VALUES ('1664576195', 'SecurityConfiguration', '1667529593');
INSERT INTO `class` VALUES ('1664902634', 'RegistrationController', '1667529593');
INSERT INTO `class` VALUES ('1664914013', 'Model', '1667529593');
INSERT INTO `class` VALUES ('1665476822', 'UserDetails', '1667529593');
INSERT INTO `class` VALUES ('1666499879', 'User', '1667529593');
INSERT INTO `class` VALUES ('1667238018', 'AuthenticationManagerBuilder', '1667529593');
INSERT INTO `class` VALUES ('7555554465', 'UserMapper', '7551307878');
INSERT INTO `class` VALUES ('7557357884', 'UserLoginService', '7551307878');
INSERT INTO `class` VALUES ('7559634964', 'UserLoginServiceImpl', '7551307878');
INSERT INTO `class` VALUES ('9421479215', 'UserLoginServiceImpl', '9429662998');
INSERT INTO `class` VALUES ('9428302380', 'UserLoginService', '9429662998');

-- ----------------------------
-- Table structure for classattribute
-- ----------------------------
DROP TABLE IF EXISTS `classattribute`;
CREATE TABLE `classattribute`  (
  `id` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `classattribute_ibfk1`(`class_id`) USING BTREE,
  CONSTRAINT `classattribute_ibfk1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classattribute
-- ----------------------------
INSERT INTO `classattribute` VALUES (0, 'id', 'Long', 'private', '1666499879');
INSERT INTO `classattribute` VALUES (1, 'username', 'String', 'private', '1666499879');
INSERT INTO `classattribute` VALUES (2, 'password', 'String', 'private', '1666499879');
INSERT INTO `classattribute` VALUES (0, 'userRepository', 'UserRepository', 'private', '1664576195');
INSERT INTO `classattribute` VALUES (0, 'userMapper', 'UserMapper', 'private', '9421479215');
INSERT INTO `classattribute` VALUES (0, 'userMapper', 'UserMapper', 'private', '7559634964');

-- ----------------------------
-- Table structure for classmethod
-- ----------------------------
DROP TABLE IF EXISTS `classmethod`;
CREATE TABLE `classmethod`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `return_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `classmethod_ibfk`(`class_id`) USING BTREE,
  CONSTRAINT `classmethod_ibfk` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classmethod
-- ----------------------------
INSERT INTO `classmethod` VALUES ('1661793749', 'showRegistrationForm', NULL, 'public', '1664902634', 'Model model');
INSERT INTO `classmethod` VALUES ('1661804027', 'showLoginForm', NULL, 'public', '1664196173', '');
INSERT INTO `classmethod` VALUES ('1664647868', 'configure', NULL, 'public', '1664576195', 'HttpSecurity http');
INSERT INTO `classmethod` VALUES ('1666185007', 'configure', NULL, 'public', '1664576195', 'AuthenticationManagerBuilder auth');
INSERT INTO `classmethod` VALUES ('1668190811', 'registerUser', NULL, 'public', '1664902634', 'BindingResult bindingResult');
INSERT INTO `classmethod` VALUES ('7551346140', 'userLogin', 'User', 'public', '7557357884', '');
INSERT INTO `classmethod` VALUES ('7551517804', 'getAdminUserInfoByPage', 'List<User>', 'public', '7555554465', 'int name');
INSERT INTO `classmethod` VALUES ('7553524407', 'deleteByUsername', 'int', 'public', '7555554465', 'String username');
INSERT INTO `classmethod` VALUES ('7554157633', 'getAdminUserInfo', NULL, 'public', '7555554465', '');
INSERT INTO `classmethod` VALUES ('7554400072', 'getUserByUsername', NULL, 'public', '7555554465', 'String input');
INSERT INTO `classmethod` VALUES ('7556252847', 'userLogin', 'User', 'public', '7559634964', 'String password');
INSERT INTO `classmethod` VALUES ('7557707103', 'save', 'int', 'public', '7555554465', 'User user');
INSERT INTO `classmethod` VALUES ('7558794035', 'update', 'int', 'public', '7555554465', 'User user');
INSERT INTO `classmethod` VALUES ('7559693266', 'getUserByUsernamePassword', 'User', 'public', '7555554465', 'String password');
INSERT INTO `classmethod` VALUES ('9421864580', 'userLogin', 'User', 'public', '9421479215', 'String password');
INSERT INTO `classmethod` VALUES ('9429680735', 'userLogin', 'User', 'public', '9428302380', '');

-- ----------------------------
-- Table structure for classrelationship
-- ----------------------------
DROP TABLE IF EXISTS `classrelationship`;
CREATE TABLE `classrelationship`  (
  `id` int(11) NOT NULL,
  `from_class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `relationship` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `from_class_ibfk2`(`from_class_id`) USING BTREE,
  INDEX `class_to_ibfk2`(`to_class_id`) USING BTREE,
  CONSTRAINT `class_to_ibfk2` FOREIGN KEY (`to_class_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `from_class_ibfk2` FOREIGN KEY (`from_class_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for enum
-- ----------------------------
DROP TABLE IF EXISTS `enum`;
CREATE TABLE `enum`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `enum_ibfk1`(`project_id`) USING BTREE,
  CONSTRAINT `enum_ibfk1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for interface
-- ----------------------------
DROP TABLE IF EXISTS `interface`;
CREATE TABLE `interface`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `interface_ibfk1`(`project_id`) USING BTREE,
  CONSTRAINT `interface_ibfk1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interface
-- ----------------------------
INSERT INTO `interface` VALUES ('1664792170', 'UserRepository', '1667529593');
INSERT INTO `interface` VALUES ('1666055328', 'SecurityService', '1667529593');
INSERT INTO `interface` VALUES ('7555558698', 'UserMapper', '7551606856');
INSERT INTO `interface` VALUES ('9423721610', 'UserMapper', '9429662998');

-- ----------------------------
-- Table structure for methodcode
-- ----------------------------
DROP TABLE IF EXISTS `methodcode`;
CREATE TABLE `methodcode`  (
  `id` int(11) NULL DEFAULT NULL,
  `code` blob NULL,
  `method_id` int(11) NULL DEFAULT NULL,
  INDEX `method_id`(`method_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1667529593', 'haha');
INSERT INTO `project` VALUES ('7551307878', 'login2');
INSERT INTO `project` VALUES ('7551606856', 'login1');
INSERT INTO `project` VALUES ('9429662998', 'login');

SET FOREIGN_KEY_CHECKS = 1;
