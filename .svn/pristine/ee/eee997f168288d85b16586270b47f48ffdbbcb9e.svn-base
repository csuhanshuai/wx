/*
SQLyog Ultimate v8.32 
MySQL - 5.5.32 : Database - zydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `basetbl_authority_resources` */

DROP TABLE IF EXISTS `basetbl_authority_resources`;

CREATE TABLE `basetbl_authority_resources` (
  `id` varchar(32) NOT NULL,
  `isleaf` varchar(1) DEFAULT NULL,
  `memu_url` longtext,
  `menu_name` varchar(50) DEFAULT NULL,
  `no` varchar(40) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `structure` varchar(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_authority_resources` */

insert  into `basetbl_authority_resources`(`id`,`isleaf`,`memu_url`,`menu_name`,`no`,`remark`,`sort`,`structure`,`type`) values ('','0',NULL,'权限资源根目录',NULL,'权限资源',1,'root','0'),('2c9481c23045c560013045d3a8280007','0','','系统管理',NULL,'系统管理',70,'root-7','0'),('2c9481c23045c560013045dbb4930039','1','/system/systemmgmt/authorityresources/toResourcesManage.kq','权限管理',NULL,'权限管理',3,'root-7-1','0'),('2c9481c23045e0f0013045f216d6002a','1','/system/systemmgmt/organiz/toOrganizStructManage.kq','组织结构',NULL,'组织结构',1,'root-7-2','0'),('2c9481c23045e0f0013045f24872002b','1','/system/systemmgmt/authorityRole/queryRoleList.kq','角色管理',NULL,'角色管理',2,'root-7-3','0'),('2c9481c23045e0f0013045f2bbc5002c','1','/system/systemmgmt/systemuser/querySystemUserList.kq','帐户管理',NULL,'帐户管理',4,'root-7-4','0'),('2c9481c23045e0f0013045f3c1030035','1','/system/systemmgmt/systemconfig/querySystemKeyValue.kq?key=config.system.keywordfilter','关键字过滤',NULL,'关键字过滤',13,'root-7-13','0'),('40288ae443c81a720143c84b8dbb0001','0','null','基本设置',NULL,'权限资源',1,'root-8','0'),('40288ae443c81a720143c856457f0004','1','/queryAttentionMsg.kq?type=firstAttention','首次关注回复',NULL,'权限资源',1,'root-8-1','1'),('40288ae443c81a720143c85754520005','1','/queryCustomReplay.kq?type=keyReplay','智能回复',NULL,'权限资源',1,'root-8-2','1'),('40288ae443c81a720143c857a7590006','1','/queryMenu.kq','自定义菜单',NULL,'',3,'root-8-3','1'),('40288ae443c81a720143c858a6cc0007','1','/wxbinding.kq?type=binding','公众账号绑定',NULL,'权限资源',1,'root-8-4','1'),('40288ae443c81a720143c858f2810008','1','/myweixin.kq?type=auth','授权管理',NULL,'',5,'root-8-5','1'),('40288ae443c81a720143c85933d60009','0','null','素材管理',NULL,'权限资源',2,'root-10','0'),('40288ae443c81a720143c859f38b000a','1','/ptMessage.kq?type=ptMessage','图文消息',NULL,'权限资源',1,'root-10-1','1'),('40288ae443c81a720143c85a43ce000b','1','/queryLink.kq?type=customUrl','自定义URL管理',NULL,'',2,'root-10-2','1'),('40288ae443c81a720143c85af469000c','1','/querysysLink.kq?type=systemUrl','系统URL查询',NULL,'权限资源',1,'root-10-3','1'),('ff808081308cb66b01308df768af03a8','1','/system/systemmgmt/systemconfig/queryUseSystemConfigList.kq','系统配置',NULL,'系统配置',19,'root-7-18','0');

/*Table structure for table `basetbl_authority_role` */

DROP TABLE IF EXISTS `basetbl_authority_role`;

CREATE TABLE `basetbl_authority_role` (
  `id` varchar(32) NOT NULL,
  `no` varchar(40) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `role_createdate` datetime DEFAULT NULL,
  `role_name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_authority_role` */

insert  into `basetbl_authority_role`(`id`,`no`,`remark`,`role_createdate`,`role_name`) values ('2c9481ab30db755e0130db79949f0002',NULL,'系统管理员','2011-06-29 20:57:04','系统管理员'),('40288ae845df5fe30145df63f5550003',NULL,'用于微信管理\r\n每个不同商家请创建不同的微信管理员','2014-05-09 13:10:41','IBM微信业务管理员');

/*Table structure for table `basetbl_authority_role_menu` */

DROP TABLE IF EXISTS `basetbl_authority_role_menu`;

CREATE TABLE `basetbl_authority_role_menu` (
  `role_id` varchar(32) NOT NULL,
  `menu_id` varchar(32) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`),
  KEY `FKC0E9119A6BC1CA69` (`menu_id`),
  KEY `FKC0E9119AFEDD303C` (`role_id`),
  CONSTRAINT `FKC0E9119AFEDD303C` FOREIGN KEY (`role_id`) REFERENCES `basetbl_authority_role` (`id`),
  CONSTRAINT `FKC0E9119A6BC1CA69` FOREIGN KEY (`menu_id`) REFERENCES `basetbl_authority_resources` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_authority_role_menu` */

insert  into `basetbl_authority_role_menu`(`role_id`,`menu_id`) values ('2c9481ab30db755e0130db79949f0002','2c9481c23045c560013045d3a8280007'),('2c9481ab30db755e0130db79949f0002','2c9481c23045c560013045dbb4930039'),('2c9481ab30db755e0130db79949f0002','2c9481c23045e0f0013045f216d6002a'),('2c9481ab30db755e0130db79949f0002','2c9481c23045e0f0013045f24872002b'),('2c9481ab30db755e0130db79949f0002','2c9481c23045e0f0013045f2bbc5002c'),('2c9481ab30db755e0130db79949f0002','2c9481c23045e0f0013045f3c1030035'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c84b8dbb0001'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c856457f0004'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c85754520005'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c857a7590006'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c858a6cc0007'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c858f2810008'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c85933d60009'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c859f38b000a'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c85a43ce000b'),('40288ae845df5fe30145df63f5550003','40288ae443c81a720143c85af469000c'),('2c9481ab30db755e0130db79949f0002','ff808081308cb66b01308df768af03a8');

/*Table structure for table `basetbl_ecsystem_systemlog` */

DROP TABLE IF EXISTS `basetbl_ecsystem_systemlog`;

CREATE TABLE `basetbl_ecsystem_systemlog` (
  `id` varchar(32) NOT NULL,
  `classname` varchar(50) DEFAULT NULL,
  `code_module` varchar(50) DEFAULT NULL,
  `log_type` varchar(20) DEFAULT NULL,
  `logtime` datetime DEFAULT NULL,
  `message` longtext,
  `remark` varchar(200) DEFAULT NULL,
  `userid` varchar(32) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_ecsystem_systemlog` */

/*Table structure for table `basetbl_organiz_struct` */

DROP TABLE IF EXISTS `basetbl_organiz_struct`;

CREATE TABLE `basetbl_organiz_struct` (
  `id` varchar(32) NOT NULL,
  `child` int(11) DEFAULT NULL,
  `ec_ind` varchar(2) DEFAULT NULL,
  `isleaf` varchar(1) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `no` varchar(40) DEFAULT NULL,
  `org_name` varchar(150) DEFAULT NULL,
  `remark` longtext,
  `struct` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_organiz_struct` */

insert  into `basetbl_organiz_struct`(`id`,`child`,`ec_ind`,`isleaf`,`level`,`no`,`org_name`,`remark`,`struct`) values ('40288ae845df5fe30145df6092420001',0,NULL,'1',0,'13996120192595285061006','',NULL,'root');

/*Table structure for table `basetbl_systemlink` */

DROP TABLE IF EXISTS `basetbl_systemlink`;

CREATE TABLE `basetbl_systemlink` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  `linkname` varchar(100) DEFAULT NULL,
  `showpage` longtext,
  `type` varchar(10) DEFAULT NULL,
  `url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemlink` */

/*Table structure for table `basetbl_systemmg_area` */

DROP TABLE IF EXISTS `basetbl_systemmg_area`;

CREATE TABLE `basetbl_systemmg_area` (
  `id` varchar(32) NOT NULL,
  `child` int(11) DEFAULT NULL,
  `isleaf` varchar(1) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `no` varchar(40) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemmg_area` */

/*Table structure for table `basetbl_systemmgt_config` */

DROP TABLE IF EXISTS `basetbl_systemmgt_config`;

CREATE TABLE `basetbl_systemmgt_config` (
  `id` varchar(32) NOT NULL,
  `config_name` varchar(255) DEFAULT NULL,
  `delete_flag` varchar(255) DEFAULT NULL,
  `config_key` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `config_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemmgt_config` */

insert  into `basetbl_systemmgt_config`(`id`,`config_name`,`delete_flag`,`config_key`,`remark`,`config_value`) values ('40288ae845df5fe30145df6105ff0002','config.system.keywordfilter','1','config.system.keywordfilter','config.system.keywordfilter','config.system.keywordfilter');

/*Table structure for table `basetbl_systemmgt_email` */

DROP TABLE IF EXISTS `basetbl_systemmgt_email`;

CREATE TABLE `basetbl_systemmgt_email` (
  `id` varchar(32) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `receive_email` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `send_time` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemmgt_email` */

/*Table structure for table `basetbl_systemmgt_group` */

DROP TABLE IF EXISTS `basetbl_systemmgt_group`;

CREATE TABLE `basetbl_systemmgt_group` (
  `id` varchar(32) NOT NULL,
  `group_name` varchar(100) DEFAULT NULL,
  `no` varchar(40) DEFAULT NULL,
  `supplierid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemmgt_group` */

/*Table structure for table `basetbl_systemmgt_user` */

DROP TABLE IF EXISTS `basetbl_systemmgt_user`;

CREATE TABLE `basetbl_systemmgt_user` (
  `id` varchar(32) NOT NULL,
  `category` varchar(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `level` varchar(1) DEFAULT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `login_password` varchar(50) DEFAULT NULL,
  `mobile_phone` varchar(15) DEFAULT NULL,
  `msn_num` varchar(50) DEFAULT NULL,
  `no` varchar(40) DEFAULT NULL,
  `organiz_name` varchar(255) DEFAULT NULL,
  `organiz_no` varchar(255) DEFAULT NULL,
  `qq_num` varchar(50) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `supplier_code` varchar(32) DEFAULT NULL,
  `tel_phone` varchar(25) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemmgt_user` */

insert  into `basetbl_systemmgt_user`(`id`,`category`,`email`,`level`,`login_name`,`login_password`,`mobile_phone`,`msn_num`,`no`,`organiz_name`,`organiz_no`,`qq_num`,`sex`,`state`,`supplier_code`,`tel_phone`,`username`) values ('4028880d2f81b335012f81bf1e300001','','2826266352@qq.com','0','admin','a60a2f0db2dbc6ccab3e97913afbf3f2','88888888','',NULL,'奇新科技','13091646201958651116330','2826266352','0','1','','18676366166','超级管理员'),('40288ae845df5fe30145df6522c30004',NULL,'0@0.com',NULL,'wxadmin','f379eaf3c831b04de153469d1bec345e','00000000','',NULL,NULL,'','10000000','0','1','-1','13800000000','IBM');

/*Table structure for table `basetbl_systemmgt_user_group` */

DROP TABLE IF EXISTS `basetbl_systemmgt_user_group`;

CREATE TABLE `basetbl_systemmgt_user_group` (
  `id` varchar(32) NOT NULL,
  `gid` varchar(32) DEFAULT NULL,
  `userid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK992C51F1A05995C2` (`gid`),
  KEY `FK992C51F13B7A8D50` (`userid`),
  CONSTRAINT `FK992C51F13B7A8D50` FOREIGN KEY (`userid`) REFERENCES `basetbl_systemmgt_user` (`id`),
  CONSTRAINT `FK992C51F1A05995C2` FOREIGN KEY (`gid`) REFERENCES `basetbl_systemmgt_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemmgt_user_group` */

/*Table structure for table `basetbl_systemmgt_user_role` */

DROP TABLE IF EXISTS `basetbl_systemmgt_user_role`;

CREATE TABLE `basetbl_systemmgt_user_role` (
  `uid` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`uid`),
  KEY `FKD37EEC46D511F7A` (`uid`),
  KEY `FKD37EEC4FEDD303C` (`role_id`),
  CONSTRAINT `FKD37EEC4FEDD303C` FOREIGN KEY (`role_id`) REFERENCES `basetbl_authority_role` (`id`),
  CONSTRAINT `FKD37EEC46D511F7A` FOREIGN KEY (`uid`) REFERENCES `basetbl_systemmgt_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `basetbl_systemmgt_user_role` */

insert  into `basetbl_systemmgt_user_role`(`uid`,`role_id`) values ('4028880d2f81b335012f81bf1e300001','2c9481ab30db755e0130db79949f0002'),('40288ae845df5fe30145df6522c30004','40288ae845df5fe30145df63f5550003');

/*Table structure for table `wxtbl_attention_msg` */

DROP TABLE IF EXISTS `wxtbl_attention_msg`;

CREATE TABLE `wxtbl_attention_msg` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `msgid` varchar(255) DEFAULT NULL,
  `open_any_key` varchar(255) DEFAULT NULL,
  `replay` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_attention_msg` */

insert  into `wxtbl_attention_msg`(`id`,`addtime`,`bizid`,`msgid`,`open_any_key`,`replay`,`type`) values ('40288ae845df5fe30145df6c7fb60005','2014-05-09','40288ae845df5fe30145df6522c30004','','1','你好，欢迎关注我们','1');

/*Table structure for table `wxtbl_custom_replay` */

DROP TABLE IF EXISTS `wxtbl_custom_replay`;

CREATE TABLE `wxtbl_custom_replay` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `msgid` varchar(255) DEFAULT NULL,
  `patten` varchar(255) DEFAULT NULL,
  `replay` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKA26BC4F37FD377D3` (`msgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_custom_replay` */

/*Table structure for table `wxtbl_customlink` */

DROP TABLE IF EXISTS `wxtbl_customlink`;

CREATE TABLE `wxtbl_customlink` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  `linkname` varchar(100) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_customlink` */

/*Table structure for table `wxtbl_custommenu` */

DROP TABLE IF EXISTS `wxtbl_custommenu`;

CREATE TABLE `wxtbl_custommenu` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  `content` longtext,
  `thekey` varchar(50) DEFAULT NULL,
  `menuname` varchar(30) DEFAULT NULL,
  `msgid` varchar(32) DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `replaytype` varchar(4) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKC1E464927FD377D3` (`msgid`),
  KEY `FKC1E46492E27E7B0B` (`id`),
  KEY `FKC1E46492E2801F7B` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_custommenu` */

insert  into `wxtbl_custommenu`(`id`,`addtime`,`bizid`,`content`,`thekey`,`menuname`,`msgid`,`pid`,`replaytype`,`type`,`url`) values ('40288ae845df5fe30145df7fc5640017','2014-05-09 13:41:03','40288ae845df5fe30145df6522c30004','','1399614063972','功能','','40288ae845df5fe30145df7f68e30016','1','click',''),('40288ae845df96520145df9894ba0004','2014-05-09 14:08:09','40288ae845df5fe30145df6522c30004','','1399615689913','asdf','40288ae845df5fe30145df7b03f5000a','40288ae845df96520145df9826730002','2','click','');

/*Table structure for table `wxtbl_msg_picturetext` */

DROP TABLE IF EXISTS `wxtbl_msg_picturetext`;

CREATE TABLE `wxtbl_msg_picturetext` (
  `id` varchar(32) NOT NULL,
  `bizid` longtext,
  `description` longtext,
  `picurl` longtext,
  `title` varchar(100) DEFAULT NULL,
  `url` longtext,
  `msgid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKDBB4346B7FD377D3` (`msgid`),
  CONSTRAINT `FKDBB4346B7FD377D3` FOREIGN KEY (`msgid`) REFERENCES `wxtbl_wxmessages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_msg_picturetext` */

/*Table structure for table `wxtbl_secret` */

DROP TABLE IF EXISTS `wxtbl_secret`;

CREATE TABLE `wxtbl_secret` (
  `appid` varchar(100) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  `appsecret` varchar(100) DEFAULT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`appid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_secret` */

/*Table structure for table `wxtbl_userlocation` */

DROP TABLE IF EXISTS `wxtbl_userlocation`;

CREATE TABLE `wxtbl_userlocation` (
  `openid` varchar(50) NOT NULL,
  `latitude` varchar(32) DEFAULT NULL,
  `longitude` varchar(32) DEFAULT NULL,
  `precisionx` varchar(32) DEFAULT NULL,
  `updatetime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_userlocation` */

/*Table structure for table `wxtbl_wxmessages` */

DROP TABLE IF EXISTS `wxtbl_wxmessages`;

CREATE TABLE `wxtbl_wxmessages` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  `answer` longtext,
  `bizid` varchar(32) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wxtbl_wxmessages` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
