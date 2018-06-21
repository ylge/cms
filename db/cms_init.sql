/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.19 : Database - ehu_cms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ehu_cms` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ehu_cms`;

/*Table structure for table `sys_company` */

DROP TABLE IF EXISTS `sys_company`;

CREATE TABLE `sys_company` (
  `company_id` int(8) NOT NULL AUTO_INCREMENT,
  `code` varchar(15) DEFAULT NULL COMMENT '公司编码',
  `name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `short_name` varchar(10) DEFAULT NULL COMMENT '公司简称',
  `parent_code` varchar(50) DEFAULT NULL COMMENT '上级代码',
  `logo` varchar(50) DEFAULT NULL COMMENT '公司LOGO',
  `comment` varchar(300) DEFAULT NULL COMMENT '公司介绍',
  `address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `city_code` varchar(10) DEFAULT NULL COMMENT '城市代码',
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改日期',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sys_company` */

/*Table structure for table `sys_department` */

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `department_id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `company_id` int(8) DEFAULT NULL COMMENT '公司代码',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司代码',
  `code` varchar(50) DEFAULT NULL COMMENT '部门编号',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `parent_code` varchar(50) DEFAULT NULL COMMENT '上级代码',
  `comment` varchar(200) DEFAULT NULL COMMENT '部门描述',
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `index_department_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_department` */

/*Table structure for table `sys_department_user` */

DROP TABLE IF EXISTS `sys_department_user`;

CREATE TABLE `sys_department_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_id` int(8) DEFAULT NULL COMMENT '部门编码',
  `user_id` int(8) DEFAULT NULL COMMENT '用户号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_department_user` */

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`num`,`pid`,`name`,`tips`) values
(1,0,0,'状态',NULL);
insert  into `sys_dict`(`id`,`num`,`pid`,`name`,`tips`) values
(2,0,1,'启用',NULL);
insert  into `sys_dict`(`id`,`num`,`pid`,`name`,`tips`) values
(3,1,1,'禁用',NULL);
insert  into `sys_dict`(`id`,`num`,`pid`,`name`,`tips`) values
(4,0,0,'性别',NULL);
insert  into `sys_dict`(`id`,`num`,`pid`,`name`,`tips`) values
(5,1,4,'男',NULL);
insert  into `sys_dict`(`id`,`num`,`pid`,`name`,`tips`) values
(6,2,4,'女',NULL);

/*Table structure for table `sys_menu` */

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
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(1,0,'系统根目录','root',0,0,1,1,NULL,'2018-05-03 18:31:54','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(2,1,'系统设置','system',1,1,1,1,'fa-gear','2018-05-04 09:47:06','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(3,2,'用户管理','system/user/list',1,2,4,1,'','2018-05-04 09:53:21','admin','2018-06-04 15:01:05','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(4,3,'用户添加','system/user/add',0,3,2,1,'','2018-05-04 10:57:54','admin','2018-06-07 16:03:22','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(5,3,'用户修改','system/user/edit',0,3,3,1,'','2018-05-07 11:15:23','admin','2018-06-07 16:03:25','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(6,3,'用户查看','system/user/View',0,3,1,1,'','2018-05-07 16:21:12','admin','2018-06-07 16:03:20','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(7,3,'用户删除','system/user/delete',0,3,4,1,'','2018-05-07 16:21:52','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(8,2,'角色管理','system/role/list',1,2,5,1,'','2018-05-07 16:27:47','admin','2018-06-04 15:01:13','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(9,8,'角色添加','system/role/add',0,3,1,1,'','2018-05-07 16:30:31','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(10,8,'角色编辑','system/role/edit',0,3,3,1,'','2018-05-07 16:31:08','admin','2018-06-07 16:03:43','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(11,8,'角色删除','system/role/delete',0,3,2,1,'','2018-05-07 16:31:40','admin','2018-05-07 16:37:24',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(12,8,'角色配权','system/role/grant',0,3,4,1,'','2018-05-07 16:32:18','admin','2018-06-12 12:37:09','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(13,2,'菜单管理','system/menu/list',1,2,1,1,'','2018-05-07 16:34:58','admin','2018-06-04 14:51:31','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(14,13,'菜单添加','system/menu/add',0,3,1,1,'','2018-05-07 16:35:36','admin','2018-06-07 16:09:10','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(15,13,'菜单编辑','system/menu/edit',0,3,2,1,'','2018-05-07 16:36:08','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(16,13,'菜单删除','system/menu/delete',0,3,3,1,'','2018-05-07 16:36:50','admin','2018-06-07 16:00:47','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(17,2,'公司管理','system/company/list',1,2,2,1,'','2018-05-17 18:18:43','admin','2018-06-04 14:51:39','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(18,17,'公司添加','system/company/add',0,3,1,1,'','2018-05-22 16:25:54','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(19,17,'公司编辑','system/company/edit',0,3,2,1,'','2018-05-23 09:51:04','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(20,17,'公司删除','system/company/delete',0,3,3,1,'','2018-05-23 16:38:49','admin','2018-05-08 11:02:55',NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(21,2,'部门管理','system/department/list',1,2,3,1,'','2018-06-04 14:57:43','管理员',NULL,NULL);
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(22,21,'部门新增','system/department/add',0,3,1,1,'','2018-06-04 14:58:24','管理员','2018-06-09 16:38:39','管理员');
insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`is_menu`,`level`,`sort`,`status`,`icon`,`create_time`,`create_by`,`update_time`,`update_by`) values
(23,21,'部门编辑','system/department/edit',0,3,2,1,'','2018-06-04 14:59:01','管理员','2018-06-09 16:38:51','管理员');

/*Table structure for table `sys_notice` */

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

/*Data for the table `sys_notice` */

/*Table structure for table `sys_operation_log` */

DROP TABLE IF EXISTS `sys_operation_log`;

CREATE TABLE `sys_operation_log` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT,
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

/*Data for the table `sys_operation_log` */

/*Table structure for table `sys_role` */

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`name`,`value`,`remark`,`create_time`,`update_time`,`status`) values
(1,'超级管理员','admin','admin','2017-06-20 15:08:45','2018-06-20 17:23:24',1);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,1,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,2,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,3,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,4,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,5,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,6,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,7,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,8,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,9,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,10,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,11,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,12,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,13,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,14,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,15,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,16,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,17,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,18,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,19,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,21,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,34,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,35,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,36,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,22,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,45,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,55,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,57,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,58,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,59,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,60,'2018-06-20 17:23:24');
insert  into `sys_role_menu`(`role_id`,`menu_id`,`create_time`) values
(1,61,'2018-06-20 17:23:24');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `username` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT '盐',
  `name` varchar(45) DEFAULT NULL COMMENT '用户姓名',
  `merchant_id` varchar(45) DEFAULT NULL COMMENT '商家用户id',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号码',
  `status` int(1) DEFAULT '1' COMMENT '是否有效 0 无效 1 有效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改日期',
  `update_by` datetime DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`avatar`,`username`,`password`,`salt`,`name`,`merchant_id`,`phone`,`status`,`create_time`,`create_by`,`update_time`,`update_by`) values
(1,NULL,'admin','a5322b1321d2c849e22fa3f62bf87d6b','u2w3z','管理员','1','1352400201',1,'2018-05-13 20:09:54','1','2017-06-26 17:31:41',NULL);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`create_time`,`create_by`) values
(1,1,1,'2017-09-11 13:02:45',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
