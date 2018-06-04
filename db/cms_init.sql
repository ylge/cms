
DROP TABLE IF EXISTS `sys_company`;

CREATE TABLE `sys_company` (
  `company_id` int(8) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '公司代码',
  `name` varchar(20) DEFAULT NULL COMMENT '公司名称',
  `short_name` varchar(10) DEFAULT NULL COMMENT '公司简称',
  `parent_code` varchar(50) DEFAULT NULL COMMENT '上级代码',
  `logo` varchar(50) DEFAULT NULL COMMENT '公司LOGO',
  `comment` varchar(300) DEFAULT NULL COMMENT '公司介绍',
  `address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `city_code` varchar(10) DEFAULT NULL COMMENT '城市代码',
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `create_by` int(8) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `update_by` int(8) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `department_id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `company_id` int(8) DEFAULT NULL COMMENT '公司代码',
  `code` varchar(50) DEFAULT NULL COMMENT '部门编号',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `parent_code` varchar(50) DEFAULT NULL COMMENT '上级代码',
  `comment` varchar(200) DEFAULT NULL COMMENT '部门描述',
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  `create_time` datetime DEFAULT NULL,
  `create_by` int(8) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` int(8) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `index_department_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET= utf8;


DROP TABLE IF EXISTS `sys_department_user`;

CREATE TABLE `sys_department_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_id` int(8) DEFAULT NULL COMMENT '部门编码',
  `user_id` int(8) DEFAULT NULL COMMENT '用户号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET= utf8;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '0', '0', '状态', null);
INSERT INTO `sys_dict` VALUES ('2', '0', '1', '启用', null);
INSERT INTO `sys_dict` VALUES ('3', '1', '1', '禁用', null);
INSERT INTO `sys_dict` VALUES ('bootstrap-select', '0', '0', '性别', null);
INSERT INTO `sys_dict` VALUES ('5', '1', 'bootstrap-select', '男', null);
INSERT INTO `sys_dict` VALUES ('6', '2', 'bootstrap-select', '女', null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `is_menu` int(11) DEFAULT NULL COMMENT '是否是菜单',
  `level` int(11) DEFAULT NULL COMMENT '菜单层级',
  `sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(8) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(8) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `FK_CODE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_menu` VALUES (0, '', '系统根目录', '', '1', '0', '1', '1', NULL, '2018-05-03 18:31:54',NULL, NULL,NULL);
INSERT INTO `sys_menu` VALUES (1, 0, '系统设置', 'system', '1', '1', '10', '1', '', '2018-05-04 09:47:06', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 'system/user/list', '1', '2', '1', '1', '', '2018-05-04 09:53:21', NULL, '2018-05-07 18:18:39', NULL);
INSERT INTO `sys_menu` VALUES (3, 2, '用户添加', 'system/user/add', '0', '3', '1', '1', '', '2018-05-04 10:57:54', NULL, '2018-05-08 11:02:55', NULL);
INSERT INTO `sys_menu` VALUES (4, 2, '用户修改', 'system/user/edit', '0', '3', '1', '1', '', '2018-05-07 11:15:23', NULL, '2018-05-07 16:57:52', NULL);
INSERT INTO `sys_menu` VALUES (5, 2, '用户查看', 'system/user/View', '0', '3', '2', '1', '', '2018-05-07 16:21:12', NULL);
INSERT INTO `sys_menu` VALUES (6, 2, '用户删除', 'system/user/delete', '0', '3', 'bootstrap-select', '1', '', '2018-05-07 16:21:52', NULL, NULL,  NULL);
INSERT INTO `sys_menu` VALUES (7, 1, '角色管理', 'system/role/list', '1', '2', '2', '1', '', '2018-05-07 16:27:47', NULL, '2018-05-08 10:34:56', NULL);
INSERT INTO `sys_menu` VALUES (8, 7, '角色添加', 'system/role/add', '0', '3', '1', '1', '', '2018-05-07 16:30:31', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (9, 7, '角色编辑', 'system/role/edit', '0', '3', '2', '1', '', '2018-05-07 16:31:08', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (10, 7,'角色删除', 'system/role/delete', '0', '3', '2', '1', '', '2018-05-07 16:31:40', NULL, '2018-05-07 16:37:24', NULL);
INSERT INTO `sys_menu` VALUES (11, 7, '角色配权', 'system/role/permission', '0', '3', '3', '1', '', '2018-05-07 16:32:18', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (12, 1, '菜单管理', 'system/menu/list', '1', '2', '2', '1', '', '2018-05-07 16:34:58', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (13, 12, '菜单添加', 'system/menu/add', '0', '3', '1', '1', '', '2018-05-07 16:35:36', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (14, 12, '菜单编辑', 'system/menu/edit', '0', '3', '2', '1', '', '2018-05-07 16:36:08', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (15, 12, '菜单删除', 'system/menu/delete', '0', '3', '2', '1', '', '2018-05-07 16:36:50', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序列',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '操作人ID',
  `user_name` varchar(255) DEFAULT NULL COMMENT '操作人姓名',
  `class_name` varchar(255) DEFAULT NULL COMMENT '被操作类',
  `method` varchar(255) DEFAULT NULL COMMENT '方法',
  `args` varchar(255) DEFAULT NULL COMMENT '参数',
  `origin_data` text COMMENT '原始数据',
  `new_data` text COMMENT '新数据',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '2', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '3', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', 'bootstrap-select', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '5', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '6', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '7', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '8', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '9', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '10', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '11', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '12', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '13', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '14', '2018-05-08 11:31:39');
INSERT INTO `sys_role_menu` VALUES ('1', '15', '2018-05-08 11:31:39');


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `value` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `unique_role_name` (`name`),
  UNIQUE KEY `unique_role_value` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'super', null, '2017-06-20 15:08:45', null, '1');
INSERT INTO `sys_role` VALUES ('2', '管理员', 'admin', null, '2017-06-20 15:07:13', '2017-06-26 12:46:09', '1');


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `username` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT '盐',
  `name` varchar(45) DEFAULT NULL COMMENT '用户姓名',
  `merchant_id` varchar(45) DEFAULT NULL COMMENT '商家用户id',
  `phone` varchar(45) DEFAULT NULL COMMENT'手机号码',
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `create_by` int(8) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `update_by` int(8) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, 'super', 'a5322b1321d2c849e22fa3f62bf87d6b', 'u2w3z', '超级管理员', '2017-06-22 14:26:09', '1', null, null, '1', '2017-06-20 15:12:16', '2017-09-12 14:39:48');
INSERT INTO `sys_user` VALUES ('2', null, 'admin', '439b9b33eb18d644f3b57e182f45b86a', 'bycca', '管理员', null, '1', null, null, '1', '2017-06-26 17:31:41', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', '2017-09-11 13:02:45', null);

