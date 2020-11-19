/*
Navicat MySQL Data Transfer

Source Server         : 39.106.220.19
Source Server Version : 80012
Source Host           : 39.106.220.19:3306
Source Database       : satellite

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-11-19 09:45:10
*/

create Database if not EXISTS example_db default character set utf8;
use example_db;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc_api
-- ----------------------------
DROP TABLE IF EXISTS `doc_api`;
CREATE TABLE `doc_api` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `api_name` varchar(255) DEFAULT NULL COMMENT '接口名称',
  `api_type_id` bigint(20) DEFAULT NULL COMMENT '分组id',
  `api_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分组名称',
  `remark` varchar(2000) DEFAULT NULL COMMENT '描述',
  `url` varchar(255) DEFAULT NULL COMMENT '接口地址',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方式',
  `protocol` varchar(255) DEFAULT NULL COMMENT '协议',
  `request_hearders` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求参数头',
  `request_parameters` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '请求参数',
  `response_code` varchar(2000) DEFAULT NULL COMMENT '响应状态',
  `response_parameters` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '响应参数',
  `response_example` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '响应示例',
  `status` int(11) DEFAULT NULL COMMENT '状态(1启用 0停用)',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口表';

-- ----------------------------
-- Records of doc_api
-- ----------------------------

-- ----------------------------
-- Table structure for doc_api_log
-- ----------------------------
DROP TABLE IF EXISTS `doc_api_log`;
CREATE TABLE `doc_api_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `api_id` bigint(20) DEFAULT NULL COMMENT '接口id',
  `api_name` varchar(255) DEFAULT NULL COMMENT '接口名称',
  `url` varchar(255) DEFAULT NULL COMMENT '接口地址',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方式',
  `request_hearders` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求参数头',
  `request_parameters` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `response_code` varchar(255) DEFAULT NULL COMMENT '响应状态',
  `response_parameters` longtext COMMENT '响应参数',
  `oper_user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `oper_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `oper_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调用ip',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '操作地点',
  `oper_browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '浏览器类型',
  `oper_os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '操作系统',
  `start_time` datetime DEFAULT NULL COMMENT '用户姓名',
  `end_time` datetime DEFAULT NULL COMMENT '用户姓名',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `status` int(11) DEFAULT NULL COMMENT '状态(1成功 0失败)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口日志表';

-- ----------------------------
-- Records of doc_api_log
-- ----------------------------

-- ----------------------------
-- Table structure for doc_api_type
-- ----------------------------
DROP TABLE IF EXISTS `doc_api_type`;
CREATE TABLE `doc_api_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上级分组id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分组名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口分组表';

-- ----------------------------
-- Records of doc_api_type
-- ----------------------------

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) DEFAULT '' COMMENT '用户账号',
  `user_real_name` varchar(100) DEFAULT NULL COMMENT '用户',
  `ip_addr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` int(11) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父级ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单路径',
  `css` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单图标样式',
  `sort` int(11) DEFAULT '0' COMMENT '菜单排序',
  `type` int(11) DEFAULT '1' COMMENT '类型 1 菜单 2 按钮 3 目录',
  `is_menu` int(11) DEFAULT NULL COMMENT '是否菜单 1 是 2 不是',
  `hidden` int(11) DEFAULT NULL COMMENT '是否隐藏,0 false 1 true',
  `level` int(11) DEFAULT NULL COMMENT '菜单级数',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '用户权限中心', 'layout', 'system', 'layui-icon-set', '15', '3', '1', '0', null, '2020-10-30 15:10:52', '2020-11-02 14:36:49');
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', 'pages/systemManage/user', 'user', 'layui-icon-friends', '1', '1', '1', '0', null, '2020-10-30 15:10:52', '2020-11-17 11:20:01');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'pages/systemManage/role', 'role', 'layui-icon-friends', '3', '1', '1', '0', null, '2020-10-30 15:10:52', '2020-11-17 11:20:50');
INSERT INTO `sys_menu` VALUES ('5', '1', '权限管理', 'pages/systemManage/auth', 'auth', 'layui-icon-password', '2', '1', '1', '0', null, '2020-10-30 15:10:52', '2020-11-17 11:20:06');
INSERT INTO `sys_menu` VALUES ('112', '0', '电力系统监控', 'pages/dataMonitor/main', 'dataMonitor', null, '3', '3', null, null, null, '2020-11-17 10:44:31', '2020-11-17 10:52:43');
INSERT INTO `sys_menu` VALUES ('114', '112', '地图展示', 'pages/dataMonitor/dataMonitorMap', 'dataMonitorMap', null, '1', '1', null, null, '1', '2020-11-17 11:11:33', '2020-11-17 11:23:19');
INSERT INTO `sys_menu` VALUES ('115', '1', '分组管理', 'pages/systemManage/group', 'auth', null, '4', '1', null, null, '1', '2020-11-17 11:19:32', '2020-11-17 11:21:14');
INSERT INTO `sys_menu` VALUES ('116', '112', '列表展示', 'pages/dataMonitor/dataMonitorList', 'dataMonitorList', null, '2', '1', null, null, '1', '2020-11-17 11:32:23', '2020-11-17 15:45:10');
INSERT INTO `sys_menu` VALUES ('117', '112', '报警查询', 'pages/dataMonitor/dataMonitorAlarm', 'dataMonitorAlarm', null, '3', '1', null, null, '1', '2020-11-17 11:32:52', '2020-11-17 11:32:55');
INSERT INTO `sys_menu` VALUES ('118', '112', '实时数据', 'pages/dataMonitor/realTimeData', 'realTimeData/:deviceTypeId/:deviceId', null, '4', '1', null, null, '1', '2020-11-17 11:35:13', '2020-11-17 11:35:17');
INSERT INTO `sys_menu` VALUES ('119', '112', '历史曲线', 'pages/dataMonitor/dataCurve', 'dataCurve/:deviceTypeId/:deviceId', null, '5', '1', null, null, '1', '2020-11-17 11:36:19', '2020-11-17 15:45:48');
INSERT INTO `sys_menu` VALUES ('120', '112', '历史数据', 'pages/dataMonitor/historyData', 'historyData/:deviceTypeId/:deviceId', null, '6', '1', null, null, '1', '2020-11-17 11:36:47', '2020-11-17 11:41:43');
INSERT INTO `sys_menu` VALUES ('121', '112', '系统报表', 'pages/dataMonitor/systemTable', 'systemTable/:deviceTypeId/:deviceId', null, '7', '1', null, null, '1', '2020-11-17 11:37:22', '2020-11-17 15:46:09');
INSERT INTO `sys_menu` VALUES ('122', '112', '信息推送', 'pages/dataMonitor/informationPush', 'informationPush/:deviceTypeId/:deviceId', null, '8', '1', null, null, '1', '2020-11-17 11:37:47', '2020-11-17 11:41:52');
INSERT INTO `sys_menu` VALUES ('123', '112', '视频监控', 'pages/dataMonitor/dataMonitorVideo', 'dataMonitorVideo/:deviceTypeId/:deviceId', null, '9', '1', null, null, '1', '2020-11-17 11:38:25', '2020-11-17 15:46:25');
INSERT INTO `sys_menu` VALUES ('124', '112', '报警查询', 'pages/dataMonitor/deviceAlarm', 'deviceAlarm/:deviceTypeId/:deviceId', null, '10', '1', null, null, '1', '2020-11-17 11:38:59', '2020-11-17 15:46:38');
INSERT INTO `sys_menu` VALUES ('125', '0', '应用系统中心', 'layout', 'application', null, '5', '3', null, null, null, '2020-11-17 15:56:08', '2020-11-17 16:10:31');
INSERT INTO `sys_menu` VALUES ('126', '125', '应用系统管理', 'pages/application/applicationManage', 'manage', null, '1', '1', null, null, '1', '2020-11-17 15:56:42', '2020-11-17 16:08:33');
INSERT INTO `sys_menu` VALUES ('127', '0', '数据交互中心', 'layout', 'dataInteractive', null, '6', '3', null, null, null, '2020-11-17 15:57:41', '2020-11-17 16:11:23');
INSERT INTO `sys_menu` VALUES ('128', '127', '数据接口管理', 'pages/dataInteractive/collectionData', 'collectionData', null, '1', '1', null, null, '1', '2020-11-17 15:58:02', '2020-11-17 16:06:53');
INSERT INTO `sys_menu` VALUES ('129', '0', '数据报警中心', 'layout', 'dataAlarm', null, '8', '3', null, null, null, '2020-11-17 15:58:50', '2020-11-17 16:11:41');
INSERT INTO `sys_menu` VALUES ('130', '129', '数据报警中心', 'views/pages/dataAlarm', 'dataAlarmIndex', null, '1', '1', null, null, '1', '2020-11-17 15:59:16', '2020-11-17 16:08:59');
INSERT INTO `sys_menu` VALUES ('131', '0', '公告管理中心', 'layout', 'announcement', null, '13', '3', null, null, null, '2020-11-17 16:00:13', '2020-11-17 16:12:33');
INSERT INTO `sys_menu` VALUES ('132', '131', '公告管理中心', 'pages/announcement', 'announcementIndex', null, '1', '1', null, null, '1', '2020-11-17 16:00:37', '2020-11-17 16:00:51');
INSERT INTO `sys_menu` VALUES ('133', '0', '日志管理中心', 'layout', 'logMagage', null, '14', '3', null, null, null, '2020-11-17 16:01:20', '2020-11-17 16:14:49');
INSERT INTO `sys_menu` VALUES ('134', '133', '系统日志查询', 'pages/logMagage/systemLog', 'systemLog', null, '1', '1', null, null, '1', '2020-11-17 16:01:46', '2020-11-17 16:08:43');
INSERT INTO `sys_menu` VALUES ('135', '0', '数据管理中心', 'layout', 'dataManage', null, '7', '3', null, null, null, '2020-11-17 16:02:56', '2020-11-17 16:11:31');
INSERT INTO `sys_menu` VALUES ('136', '135', '设备管理', 'pages/dataManage/deviceManage', 'deviceManage', null, '1', '1', null, null, '1', '2020-11-17 16:03:19', '2020-11-17 16:04:31');
INSERT INTO `sys_menu` VALUES ('137', '135', '设备类型管理', 'pages/dataManage/deviceType', 'deviceType', null, '2', '1', null, null, '1', '2020-11-17 16:03:43', '2020-11-17 16:04:21');
INSERT INTO `sys_menu` VALUES ('138', '135', '传感管理', 'pages/dataManage/sensingManage', 'sensingManage', null, '3', '1', null, null, '1', '2020-11-17 16:04:11', '2020-11-17 16:05:10');
INSERT INTO `sys_menu` VALUES ('139', '135', '传感类型管理', 'pages/dataManage/sensingType', 'sensingType', null, '4', '1', null, null, '1', '2020-11-17 16:04:53', '2020-11-17 16:05:17');
INSERT INTO `sys_menu` VALUES ('140', '135', '报警管理', 'pages/dataManage/triggerManage', 'triggerManage', null, '5', '1', null, null, '1', '2020-11-17 16:05:58', '2020-11-18 17:04:28');
INSERT INTO `sys_menu` VALUES ('141', '135', '运维人员管理', 'pages/dataManage/operationPerson', 'operationPerson', null, '6', '1', null, null, '1', '2020-11-17 16:06:20', '2020-11-18 17:04:32');
INSERT INTO `sys_menu` VALUES ('142', '135', '摄像头管理', 'pages/dataManage/camera', 'camera', null, '7', '1', null, null, '1', '2020-11-17 16:06:40', '2020-11-18 17:04:36');
INSERT INTO `sys_menu` VALUES ('143', '133', '操作日志查询', 'pages/logMagage/operationLog', 'operationLog', null, '2', '1', null, null, '1', '2020-11-17 16:15:54', '2020-11-18 17:04:53');
INSERT INTO `sys_menu` VALUES ('144', '133', '运行日志查询', 'pages/logMagage/workingLog', 'workingLog', null, '3', '1', null, null, '1', '2020-11-17 16:16:11', '2020-11-18 17:04:57');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(255) NOT NULL COMMENT '公告标题',
  `notice_type` int(11) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longtext COMMENT '公告内容',
  `status` int(11) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `tags` int(11) DEFAULT NULL COMMENT '标签，1一般，2紧急，3其他',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('1', '云平台成功上线了', '2', '6\n65+', '0', '', '', null, null, '2020-11-17 18:10:09', '2020-11-17 18:10:09');
INSERT INTO `sys_notice` VALUES ('2', '3554345', '1', '63536', '0', '', '', null, null, '2020-11-17 18:21:18', '2020-11-17 18:21:18');
INSERT INTO `sys_notice` VALUES ('3', '3554345', '1', '63536', '0', '', '', null, null, '2020-11-17 18:21:18', '2020-11-17 18:21:18');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(11) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除 4授权 5导出）',
  `method_name` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(11) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户）',
  `username` varchar(100) DEFAULT '' COMMENT '操作账号',
  `user_real_name` varchar(100) DEFAULT '' COMMENT '操作人姓名',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(5000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(5000) DEFAULT '' COMMENT '返回参数',
  `status` int(11) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(5000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限标识',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限名称',
  `uri` varchar(255) DEFAULT NULL COMMENT '前端资源路径',
  `type` int(11) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission` (`permission`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'permission:post/permissions', '保存权限标识', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('2', 'permission:put/permissions', '修改权限标识', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('3', 'permission:delete/permissions/{id}', '删除权限标识', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('4', 'permission:get/permissions', '查询权限标识', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('5', '/permissions/{roleId}/permissions', '查看角色权限', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('6', '/permissions/granted', '角色分配权限', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('7', 'role:post/roles', '添加角色', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('8', 'role:put/roles', '修改角色', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('9', 'role:delete/roles/{id}', '删除角色', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('10', 'role:post/roles/{id}/permissions', '给角色分配权限', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('11', 'role:get/roles', '查询角色', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('12', 'role:get/roles/{id}/permissions', '获取角色的权限', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('13', 'user:post/users/{id}/roles', '给用户分配角色', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('14', 'user:post/users/{id}/resetPassword', '用户重置密码', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('15', 'user:get/users', '用户查询', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('16', 'user:put/users/me', '修改用户', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('17', 'user:get/users/{id}/roles', '获取用户的角色', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('18', 'user:post/users/saveOrUpdate', '新增用户', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('19', 'user:post/users/exportUser', '导出用户', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('20', 'user:get/users/updateEnabled', '用户状态修改', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('21', 'user:put/users/password', '修改密码', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('22', 'menu:get/menus/all', '查询菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('23', 'menu:post/menus/granted', '给角色分配菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('24', 'menu:get/menus/tree', '树形显示', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('25', 'menu:get/menus/{roleId}/menus', '获取角色的菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('26', 'menu:post/menus', '添加菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('27', 'menu:put/menus', '修改菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('28', 'menu:delete/menus/{id}', '删除菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('29', 'menu:get/menus/current', '当前用户菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('30', 'menu:get/menus/findAlls', '所有菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('31', 'client:post/clients', '保存应用', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('32', 'client:get/clients', '应用列表', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('33', 'client:get/clients/{id}', '根据id获取应用', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('34', 'client:delete/clients', '删除应用', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('35', 'p1', '查询所有服务', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('36', 'service:get/service/findOnes', '服务树', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('37', 'menu:get/menus/findOnes', '获取菜单以及顶层菜单', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('38', 'permission:get/permissions/{roleId}/permissions', '根据roleId获取权限', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('39', 'file:query', '获取文件列表', null, null, '2020-10-30 15:10:30', null);
INSERT INTO `sys_permission` VALUES ('40', 'file:del', '删除文件', null, null, '2020-10-30 15:10:30', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色code',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ADMIN', '管理员', null, '2020-10-30 15:10:14', null);
INSERT INTO `sys_role` VALUES ('3', '002', '普通用户', null, '2020-10-30 15:10:14', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单关系表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('89', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('90', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('92', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('91', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('78', '1', '112');
INSERT INTO `sys_role_menu` VALUES ('79', '1', '114');
INSERT INTO `sys_role_menu` VALUES ('93', '1', '115');
INSERT INTO `sys_role_menu` VALUES ('80', '1', '116');
INSERT INTO `sys_role_menu` VALUES ('81', '1', '117');
INSERT INTO `sys_role_menu` VALUES ('82', '1', '118');
INSERT INTO `sys_role_menu` VALUES ('83', '1', '119');
INSERT INTO `sys_role_menu` VALUES ('84', '1', '120');
INSERT INTO `sys_role_menu` VALUES ('85', '1', '121');
INSERT INTO `sys_role_menu` VALUES ('86', '1', '122');
INSERT INTO `sys_role_menu` VALUES ('87', '1', '123');
INSERT INTO `sys_role_menu` VALUES ('88', '1', '124');
INSERT INTO `sys_role_menu` VALUES ('72', '3', '1');
INSERT INTO `sys_role_menu` VALUES ('73', '3', '2');
INSERT INTO `sys_role_menu` VALUES ('75', '3', '3');
INSERT INTO `sys_role_menu` VALUES ('74', '3', '5');
INSERT INTO `sys_role_menu` VALUES ('77', '3', '112');
INSERT INTO `sys_role_menu` VALUES ('76', '3', '115');
INSERT INTO `sys_role_menu` VALUES ('67', '3', '120');
INSERT INTO `sys_role_menu` VALUES ('68', '3', '121');
INSERT INTO `sys_role_menu` VALUES ('69', '3', '122');
INSERT INTO `sys_role_menu` VALUES ('70', '3', '123');
INSERT INTO `sys_role_menu` VALUES ('71', '3', '124');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色和权限关系表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '1', '3');
INSERT INTO `sys_role_permission` VALUES ('4', '1', '4');
INSERT INTO `sys_role_permission` VALUES ('5', '1', '5');
INSERT INTO `sys_role_permission` VALUES ('6', '1', '6');
INSERT INTO `sys_role_permission` VALUES ('7', '1', '7');
INSERT INTO `sys_role_permission` VALUES ('8', '1', '8');
INSERT INTO `sys_role_permission` VALUES ('9', '1', '9');
INSERT INTO `sys_role_permission` VALUES ('10', '1', '10');
INSERT INTO `sys_role_permission` VALUES ('11', '1', '11');
INSERT INTO `sys_role_permission` VALUES ('12', '1', '12');
INSERT INTO `sys_role_permission` VALUES ('13', '1', '13');
INSERT INTO `sys_role_permission` VALUES ('14', '1', '14');
INSERT INTO `sys_role_permission` VALUES ('15', '1', '15');
INSERT INTO `sys_role_permission` VALUES ('16', '1', '16');
INSERT INTO `sys_role_permission` VALUES ('17', '1', '17');
INSERT INTO `sys_role_permission` VALUES ('18', '1', '18');
INSERT INTO `sys_role_permission` VALUES ('19', '1', '19');
INSERT INTO `sys_role_permission` VALUES ('20', '1', '20');
INSERT INTO `sys_role_permission` VALUES ('21', '1', '21');
INSERT INTO `sys_role_permission` VALUES ('22', '1', '22');
INSERT INTO `sys_role_permission` VALUES ('23', '1', '23');
INSERT INTO `sys_role_permission` VALUES ('24', '1', '24');
INSERT INTO `sys_role_permission` VALUES ('25', '1', '25');
INSERT INTO `sys_role_permission` VALUES ('26', '1', '26');
INSERT INTO `sys_role_permission` VALUES ('27', '1', '27');
INSERT INTO `sys_role_permission` VALUES ('28', '1', '29');
INSERT INTO `sys_role_permission` VALUES ('29', '1', '30');
INSERT INTO `sys_role_permission` VALUES ('30', '1', '31');
INSERT INTO `sys_role_permission` VALUES ('31', '1', '32');
INSERT INTO `sys_role_permission` VALUES ('32', '1', '33');
INSERT INTO `sys_role_permission` VALUES ('33', '1', '34');
INSERT INTO `sys_role_permission` VALUES ('34', '1', '35');
INSERT INTO `sys_role_permission` VALUES ('35', '1', '36');
INSERT INTO `sys_role_permission` VALUES ('36', '1', '37');
INSERT INTO `sys_role_permission` VALUES ('37', '1', '38');
INSERT INTO `sys_role_permission` VALUES ('38', '1', '39');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('19', '1', '1');
INSERT INTO `sys_role_user` VALUES ('21', '2', '3');
INSERT INTO `sys_role_user` VALUES ('17', '3', '1');
INSERT INTO `sys_role_user` VALUES ('13', '6', '1');
INSERT INTO `sys_role_user` VALUES ('14', '6', '3');
INSERT INTO `sys_role_user` VALUES ('18', '7', '1');
INSERT INTO `sys_role_user` VALUES ('22', '10', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '昵称',
  `fullname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `head_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别（0男，1女）',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用（1启用，0停用）',
  `user_type_id` bigint(20) DEFAULT NULL COMMENT '用户分组id',
  `type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户分组',
  `token` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$kS2cBuoa7Q8N36Y6SQ6kcOD.LIZMGXxhpqf4WaPOLbfeinN3iTjXi', '管理员', '管理员', null, '13106975706', '1', '1', '8', '技术部门', null, '2020-10-30 15:09:35', '2020-11-17 12:11:49');
INSERT INTO `sys_user` VALUES ('2', 'test', '$2a$10$kS2cBuoa7Q8N36Y6SQ6kcOD.LIZMGXxhpqf4WaPOLbfeinN3iTjXi', '测试用户', '测试用户', null, null, null, '1', '9', '财务部门', null, '2020-10-30 15:09:35', '2020-11-17 12:11:49');
INSERT INTO `sys_user` VALUES ('11', 'test1', '$2a$10$6DQc2AzitucrZcmW6K9./.OCdonBgGy4ZjYPRBb5Q3SdZu8SVdOG2', '测试用户1', 'string', 'string', 'string', '1', '1', '0', 'string', 'string', '2020-11-18 10:33:28', '2020-11-18 11:17:42');

-- ----------------------------
-- Table structure for sys_user_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_type`;
CREATE TABLE `sys_user_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户类型',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户分组表';

-- ----------------------------
-- Records of sys_user_type
-- ----------------------------
INSERT INTO `sys_user_type` VALUES ('8', '技术部门', null, '2020-11-17 10:24:19', null);
INSERT INTO `sys_user_type` VALUES ('9', '财务部门', null, '2020-11-17 10:24:29', null);
