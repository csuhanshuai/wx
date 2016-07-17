/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : weixin

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-09-07 11:56:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `basetbl_authority_resources`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_authority_resources
-- ----------------------------
INSERT INTO `basetbl_authority_resources` VALUES ('', '0', '', '权限资源根目录', '', '权限资源', '1', 'root', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('2c9481c23045c560013045d3a8280007', '0', '', '系统管理', '', '系统管理', '70', 'root-7', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('2c9481c23045c560013045dbb4930039', '1', '/system/systemmgmt/authorityresources/toResourcesManage.kq', '权限管理', '', '权限管理', '3', 'root-7-1', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('2c9481c23045e0f0013045f216d6002a', '0', '/system/systemmgmt/organiz/toOrganizStructManage.kq', '组织结构', '', '组织结构', '1', 'root-7-2', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('2c9481c23045e0f0013045f24872002b', '1', '/system/systemmgmt/authorityRole/queryRoleList.kq', '角色管理', '', '角色管理', '2', 'root-7-3', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('2c9481c23045e0f0013045f2bbc5002c', '1', '/system/systemmgmt/systemuser/querySystemUserList.kq', '帐户管理', '', '帐户管理', '4', 'root-7-4', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('2c9481c23045e0f0013045f3c1030035', '1', '/system/systemmgmt/systemconfig/querySystemKeyValue.kq?key=config.system.keywordfilter', '关键字过滤', '', '关键字过滤', '5', 'root-7-13', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('402847544636419101463648fda60001', '0', 'null', '微官网', '', '权限资源', '4', 'root-12', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40284754463641910146364997630002', '0', 'null', '微会员', '', '权限资源', '5', 'root-13', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('402847544636419101463651f2d20003', '1', '/zj/getZhaopin.kq', '招聘管理', '', '权限资源', '5', 'root-12-1', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('402847544636419101463652b6800005', '1', '/zj/getAlbum.kq', '微相册管理', '', '权限资源', '4', 'root-12-2', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('4028475446364191014636570add0006', '1', '/zj/queryBaseInfo.kq', '基本信息管理', '', '基本信息管理', '1', 'root-12-3', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40284754463641910146365816d00007', '1', '/zj/queryScrollPictures.kq', '幻灯片设置', '', '权限资源', '3', 'root-12-4', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('402847544636419101463659569e0008', '1', '/zj/queryPictureTexts.kq', '栏目设置', '', '', '2', 'root-12-5', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('402881834637ea8c014637edb49a0001', '1', '/zj/getRetailstore.kq', '门店信息', '', '', '6', 'root-12-6', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288183464333170146433b9d040001', '1', '/zj/getMembercard.kq', '卡片管理', '', '', '1', 'root-13-1', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288183464333170146433c0f170002', '1', '/zj/getMember.kq', '会员管理', '', '会员管理', '2', 'root-13-2', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288183464333170146433d216c0003', '0', 'null', '营销活动', '', '权限资源', '6', 'root-14', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288183464333170146433d89f40004', '1', '/zj/getCoupon.kq', '优惠券', '', '优惠券', '3', 'root-14-1', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288183464333170146433dea250005', '0', 'null', '营业管理', '', '权限资源', '7', 'root-15', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288183464333170146433e67930006', '1', '/zj/getConsumptionForward.kq', '消费记录', '', '权限资源', '1', 'root-15-1', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288185462452810146245d4b710002', '0', 'null', '微商城', '', '', '4', 'root-11', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288185462452810146245deddd0003', '1', '/mallmanage/tomallconf.kq?type=initmall', '基础设置', '', '基础设置', '1', 'root-11-1', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288185462452810146245e4fc30004', '1', '/mallmanage/tonavset.kq?type=navset', '导航设置', '', '', '2', 'root-11-2', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288185462452810146245fbb1b0005', '1', '/mallmanage/queryProductType.kq?type=ptypemanage', '商品分类', '', '', '3', 'root-11-3', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288185462452810146246048b20006', '1', '/mallmanage/queryProduct.kq?type=pmanage', '商品管理', '', '', '4', 'root-11-4', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('402881e446ed97ed0146ed999d5e0001', '1', '/zj/exchangeForward.kq', '兑奖管理', null, '兑奖管理', '3', 'root-15-2', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('402881e446ed97ed0146ed9a2e460002', '1', '/zj/inpayForward.kq', '充值管理', null, '充值管理', '2', 'root-15-3', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c84b8dbb0001', '0', 'null', '基本设置', '', '权限资源', '1', 'root-8', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c856457f0004', '1', '/queryAttentionMsg.kq?type=firstAttention', '首次关注回复', '', '权限资源', '1', 'root-8-1', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c85754520005', '1', '/queryCustomReplay.kq?type=keyReplay', '智能回复', '', '权限资源', '1', 'root-8-2', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c857a7590006', '1', '/queryMenu.kq', '自定义菜单', '', '', '3', 'root-8-3', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c858a6cc0007', '1', '/wxbinding.kq?type=binding', '公众账号绑定', '', '权限资源', '1', 'root-8-4', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c858f2810008', '1', '/myweixin.kq?type=auth', '授权管理', '', '', '5', 'root-8-5', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c85933d60009', '0', 'null', '素材管理', '', '权限资源', '2', 'root-10', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c859f38b000a', '1', '/ptMessage.kq?type=ptMessage', '图文消息', '', '权限资源', '1', 'root-10-1', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c85a43ce000b', '1', '/queryLink.kq?type=customUrl', '自定义URL管理', '', '', '2', 'root-10-2', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40288ae443c81a720143c85af469000c', '1', '/querysysLink.kq?type=systemUrl', '系统URL查询', '', '权限资源', '1', 'root-10-3', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40289df546d724950146d72712310001', '1', '/zj/getGift.kq', '礼品管理', null, '礼品管理', '12', 'root-14-11', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('40289df547f1360f0147f23da4000001', '1', 'null', 'aaaa', null, 'aaa', '2', 'root-16-3', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('40289df547f1360f0147f2477eef0002', '1', '/system/systemmgmt/organiz/toOrganizStructManage.kq', 'aaaavvvvvv', null, 'aaaavvvvvv', '1', 'root-7-2-1', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff808081308cb66b01308df768af03a8', '1', '/system/systemmgmt/systemconfig/queryUseSystemConfigList.kq', '系统配置', '', '系统配置', '19', 'root-7-18', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff808081465f3b3001465f51c3520002', '1', '/turentableManage/toTurentableConfig.kq', '大转盘', '', '权限资源', '1', 'root-14-2', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff808081465f3b3001465f523f750003', '1', '/cardManage/queryConfigList.kq', '刮刮卡', '', '刮刮卡', '2', 'root-14-3', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146862312014686290c470001', '1', '/zj/getIntegralrule.kq', '积分规则', '', '积分规则', '3', 'root-13-3', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff808081468623120146862953530002', '1', '/zj/getMemberlevel.kq', '等级管理', '', '等级管理', '4', 'root-13-4', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff8080814686231201468629c7d80004', '1', '/zj/getMembernotice.kq', '公告管理', '', '公告管理', '6', 'root-13-6', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff808081468623120146862a88340005', '1', '/zj/getActivities.kq', '活动发布', '', '活动发布', '4', 'root-14-4', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff808081468623120146862ad4060006', '1', '/zj/getIntegralexchange.kq', '积分兑换', '', '积分兑换', '5', 'root-14-5', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146a415770146a41ed8a80001', '1', '/zj/getSalespromotion.kq', '促销活动', '', '促销活动', '6', 'root-14-6', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146a8e5980146a8ef14e70001', '1', '/zj/getActivities.kq?type=1', '活动报名', '', '活动报名', '7', 'root-14-7', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146a8e5980146a8ef625c0002', '0', 'null', '微现场', '', '微现场', '9', 'root-16', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146a8e5980146a8f0269e0003', '1', '/zjdiaoyan/getDiaoyanList.kq', '微调研', '', '微调研', '1', 'root-16-1', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146a8e5980146a8f094850004', '1', '/zj/getSignin.kq', '微签到', '', '微签到', '2', 'root-16-2', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146b4aa1f0146b4b1eaa00002', '1', 'null', '刮刮卡', '', '刮刮卡', '10', 'root-17', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146b4aa1f0146b4b244c40003', '1', '/cardManage/queryConfigList.kq', '配置管理', '', '配置管理', '1', 'root-17-1', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146b4aa1f0146b4b286070004', '1', '/cardManage/queryPrizeConfigList.kq', '奖项管理', '', '奖项管理', '2', 'root-17-2', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146b4aa1f0146b4b2b8f60005', '1', '/cardManage/queryEmployeeList.kq', '兑奖管理', '', '兑奖管理', '3', 'root-17-3', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146b91a4d0146b922e9bb0002', '1', '/articleManage/queryArticles.kq', '文章管理', '', '权限资源', '3', 'root-10-4', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146bee4e90146befa2e060002', '1', 'null', '摇一摇', '', '摇一摇', '11', 'root-18', '0');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146bee4e90146befa82130003', '1', '/zj/wobble/getPrize.kq', '奖项管理', '', '奖项管理', '1', 'root-18-1', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146bee4e90146befacaac0004', '1', '/zj/getActivities.kq?type=2', '中奖信息', '', '中奖信息', '2', 'root-18-2', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146bf315f0146c1b168530010', '1', '/articleManage/queryProductType.kq', '文章分类', '', '文章分类', '4', 'root-10-5', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146bf315f0146c1d678850012', '1', '/mallmanage/queryLabel.kq?type=plabelmanage', '商品标签', '', '商品标签', '5', 'root-11-5', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146bf315f0146c1d6bfab0013', '1', '/mallmanage/queryOrder.kq?type=omanage', '订单管理', '', '订单管理', '6', 'root-11-6', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146c942070146c949cac3000f', '1', '/zj/wobble/getPrize.kq', '摇一摇', '', '摇一摇', '8', 'root-14-8', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146c942070146c94a50240010', '1', '/zjdiaoyan/getDiaoyanList.kq', '微调研', '', '微调研', '9', 'root-14-9', '1');
INSERT INTO `basetbl_authority_resources` VALUES ('ff80808146c942070146c94ab3a30011', '1', '/zj/getSignin.kq', '微签到', '', '微签到', '11', 'root-14-10', '1');

-- ----------------------------
-- Table structure for `basetbl_authority_role`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_authority_role
-- ----------------------------
INSERT INTO `basetbl_authority_role` VALUES ('2c9481ab30db755e0130db79949f0002', '', '系统管理员', '2011-06-29 20:57:04', '系统管理员');
INSERT INTO `basetbl_authority_role` VALUES ('40288183464333170146433f39cc0007', '', '', '2014-05-28 22:32:35', '营业员');
INSERT INTO `basetbl_authority_role` VALUES ('40288ae845df5fe30145df63f5550003', '', '用于微信管理每个不同商家请创建不同的微信管理员', '2014-05-09 13:10:41', '微信业务管理员');

-- ----------------------------
-- Table structure for `basetbl_authority_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `basetbl_authority_role_menu`;
CREATE TABLE `basetbl_authority_role_menu` (
  `role_id` varchar(32) NOT NULL,
  `menu_id` varchar(32) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`),
  KEY `FKC0E9119A6BC1CA69` (`menu_id`),
  KEY `FKC0E9119AFEDD303C` (`role_id`),
  CONSTRAINT `FKC0E9119A6BC1CA69` FOREIGN KEY (`menu_id`) REFERENCES `basetbl_authority_resources` (`id`),
  CONSTRAINT `FKC0E9119AFEDD303C` FOREIGN KEY (`role_id`) REFERENCES `basetbl_authority_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basetbl_authority_role_menu
-- ----------------------------
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', '2c9481c23045c560013045d3a8280007');
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', '2c9481c23045c560013045dbb4930039');
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', '2c9481c23045e0f0013045f216d6002a');
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', '2c9481c23045e0f0013045f24872002b');
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', '2c9481c23045e0f0013045f2bbc5002c');
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', '2c9481c23045e0f0013045f3c1030035');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '402847544636419101463648fda60001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40284754463641910146364997630002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '402847544636419101463651f2d20003');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '402847544636419101463652b6800005');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '4028475446364191014636570add0006');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40284754463641910146365816d00007');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '402847544636419101463659569e0008');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '402881834637ea8c014637edb49a0001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288183464333170146433b9d040001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288183464333170146433c0f170002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288183464333170146433d216c0003');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288183464333170146433d89f40004');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288183464333170146433f39cc0007', '40288183464333170146433dea250005');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288183464333170146433dea250005');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288183464333170146433f39cc0007', '40288183464333170146433e67930006');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288183464333170146433e67930006');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288185462452810146245d4b710002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288185462452810146245deddd0003');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288185462452810146245e4fc30004');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288185462452810146245fbb1b0005');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288185462452810146246048b20006');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '402881e446ed97ed0146ed999d5e0001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '402881e446ed97ed0146ed9a2e460002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c84b8dbb0001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c856457f0004');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c85754520005');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c857a7590006');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c858a6cc0007');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c858f2810008');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c85933d60009');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c859f38b000a');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c85a43ce000b');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40288ae443c81a720143c85af469000c');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', '40289df546d724950146d72712310001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', '40289df547f1360f0147f2477eef0002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('2c9481ab30db755e0130db79949f0002', 'ff808081308cb66b01308df768af03a8');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff808081465f3b3001465f51c3520002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff808081465f3b3001465f523f750003');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146862312014686290c470001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff808081468623120146862953530002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff8080814686231201468629c7d80004');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff808081468623120146862a88340005');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff808081468623120146862ad4060006');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146a415770146a41ed8a80001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146a8e5980146a8ef14e70001');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146a8e5980146a8ef625c0002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146a8e5980146a8f0269e0003');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146a8e5980146a8f094850004');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146b4aa1f0146b4b1eaa00002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146b4aa1f0146b4b244c40003');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146b4aa1f0146b4b286070004');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146b4aa1f0146b4b2b8f60005');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146b91a4d0146b922e9bb0002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146bee4e90146befa2e060002');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146bee4e90146befa82130003');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146bee4e90146befacaac0004');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146bf315f0146c1b168530010');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146bf315f0146c1d678850012');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146bf315f0146c1d6bfab0013');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146c942070146c949cac3000f');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146c942070146c94a50240010');
INSERT INTO `basetbl_authority_role_menu` VALUES ('40288ae845df5fe30145df63f5550003', 'ff80808146c942070146c94ab3a30011');

-- ----------------------------
-- Table structure for `basetbl_ecsystem_systemlog`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_ecsystem_systemlog
-- ----------------------------

-- ----------------------------
-- Table structure for `basetbl_organiz_struct`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_organiz_struct
-- ----------------------------
INSERT INTO `basetbl_organiz_struct` VALUES ('40288ae845df5fe30145df6092420001', '0', null, '1', '0', '13996120192595285061006', '', null, 'root');

-- ----------------------------
-- Table structure for `basetbl_systemlink`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_systemlink
-- ----------------------------
INSERT INTO `basetbl_systemlink` VALUES ('1', '20140528', '40288ae845df5fe30145df6522c30004', '微招聘', 'http://localhost:8080/wxzj/zj/zjminweb/getZhaopinList.kq', '2', 'http://localhost:8080/wxzj/zj/zjminweb/getZhaopinList.kq');
INSERT INTO `basetbl_systemlink` VALUES ('10', '20140619', '40288ae845df5fe30145df6522c30004', '活动', 'http://localhost:8080/wxzj/zj/zjminweb/getActivitiesList.kq', '2', 'http://localhost:8080/wxzj/zj/zjminweb/getActivitiesList.kq');
INSERT INTO `basetbl_systemlink` VALUES ('11', '20140619', '40288ae845df5fe30145df6522c30004', '刮刮卡', 'http://localhost:8080/wxzj/card/zjminweb/toMain.kq', '2', 'http://localhost:8080/wxzj/card/zjminweb/toMain.kq');
INSERT INTO `basetbl_systemlink` VALUES ('12', '20140620', '40288ae845df5fe30145df6522c30004', '微调研', 'http://localhost:8080/wxzj/zjdiaoyan/zjminweb/getDiaoyanListByCondtion.kq', '2', 'http://localhost:8080/wxzj/zjdiaoyan/zjminweb/getDiaoyanListByCondtion.kq');
INSERT INTO `basetbl_systemlink` VALUES ('13', '20140620', '40288ae845df5fe30145df6522c30004', '活动报名', 'http://localhost:8080/wxzj/zjhuodong/zjminweb/addForward.kq', '2', 'http://localhost:8080/wxzj/zjhuodong/zjminweb/addForward.kq');
INSERT INTO `basetbl_systemlink` VALUES ('14', '20140621', '40288ae845df5fe30145df6522c30004', '摇一摇', 'http://localhost:8080/wxzj/zj/zjminweb/getWobble.kq', '2', 'http://localhost:8080/wxzj/zj/zjminweb/getWobble.kq');
INSERT INTO `basetbl_systemlink` VALUES ('2', '20140528', '40288ae845df5fe30145df6522c30004', '微相册', 'http://localhost:8080/wxzj/zj/zjminweb/getAlbumList.kq', '2', 'http://localhost:8080/wxzj/zj/zjminweb/getAlbumList.kq');
INSERT INTO `basetbl_systemlink` VALUES ('3', '20140528', '40288ae845df5fe30145df6522c30004', '微门店', 'http://localhost:8080/wxzj/zj/zjminweb/getRetailstoreList.kq', '2', 'http://localhost:8080/wxzj/zj/zjminweb/getRetailstoreList.kq');
INSERT INTO `basetbl_systemlink` VALUES ('4', '20140528', '40288ae845df5fe30145df6522c30004', '微会员', 'http://localhost:8080/wxzj/zj/zjminweb/getMember.kq', '2', 'http://localhost:8080/wxzj/zj/zjminweb/getMember.kq');
INSERT INTO `basetbl_systemlink` VALUES ('5', '20140528', '40288ae845df5fe30145df6522c30004', '微商城', 'http://localhost:8080/wxzj/zjmall/index.kq', '2', 'http://localhost:8080/wxzj/zjmall/index.kq');
INSERT INTO `basetbl_systemlink` VALUES ('6', '20140528', '40288ae845df5fe30145df6522c30004', '微官网', 'http://localhost:8080/wxzj/zj/zjminweb/minweb_index.kq', '2', 'http://localhost:8080/wxzj/zj/zjminweb/minweb_index.kq');
INSERT INTO `basetbl_systemlink` VALUES ('7', '20140529', '40288ae845df5fe30145df6522c30004', '微社区', 'http://wx.wsq.qq.com/248464937', '2', 'http://wx.wsq.qq.com/248464937');
INSERT INTO `basetbl_systemlink` VALUES ('8', '20140603', '40288ae845df5fe30145df6522c30004', '大转盘', 'http://localhost:8080/wxzj/turentable/toTurentable.kq', '2', 'http://localhost:8080/wxzj/turentable/toTurentable.kq');
INSERT INTO `basetbl_systemlink` VALUES ('9', '20140619', '40288ae845df5fe30145df6522c30004', '商品展示', 'http://localhost:8080/wxzj/zjmall/mlist.kq', '2', 'http://localhost:8080/wxzj/zjmall/mlist.kq');

-- ----------------------------
-- Table structure for `basetbl_systemmgt_config`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_systemmgt_config
-- ----------------------------
INSERT INTO `basetbl_systemmgt_config` VALUES ('40288126462d8ea701462d93adf60001', '现有商城模板数量', '1', 'skincount', '现有商城模板数量', '3');
INSERT INTO `basetbl_systemmgt_config` VALUES ('40288126462d8ea701462d9476cb0002', '商城模板图片路径', '1', 'skinimgurl', '商城模板图片路径', 'images/app/zjmall/skin/');
INSERT INTO `basetbl_systemmgt_config` VALUES ('40288ae845df5fe30145df6105ff0002', 'config.system.keywordfilter', '1', 'config.system.keywordfilter', 'config.system.keywordfilter', 'config.system.keywordfilter');

-- ----------------------------
-- Table structure for `basetbl_systemmgt_email`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_systemmgt_email
-- ----------------------------

-- ----------------------------
-- Table structure for `basetbl_systemmgt_group`
-- ----------------------------
DROP TABLE IF EXISTS `basetbl_systemmgt_group`;
CREATE TABLE `basetbl_systemmgt_group` (
  `id` varchar(32) NOT NULL,
  `group_name` varchar(100) DEFAULT NULL,
  `no` varchar(40) DEFAULT NULL,
  `supplierid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basetbl_systemmgt_group
-- ----------------------------

-- ----------------------------
-- Table structure for `basetbl_systemmgt_user`
-- ---------------------------

-- ----------------------------
-- Records of basetbl_systemmgt_user
-- ----------------------------
INSERT INTO `basetbl_systemmgt_user` VALUES ('4028880d2f81b335012f81bf1e300001', '', '2826266352@qq.com', '0', 'admin', 'f379eaf3c831b04de153469d1bec345e', '88888888', '', null, '奇新科技', '13091646201958651116330', '2826266352', '0', '1', '', '18676366166', '超级管理员');
INSERT INTO `basetbl_systemmgt_user` VALUES ('40288ae845df5fe30145df6522c30004', null, '0@0.com', null, 'wxadmin', 'f379eaf3c831b04de153469d1bec345e', '00000000', '', null, null, '', '10000000', '0', '1', '-1', '13800000000', 'IBM');
INSERT INTO `basetbl_systemmgt_user` VALUES ('4028bbf14640b411014640b69d830004', null, '', null, 'saleadmin', 'f379eaf3c831b04de153469d1bec345e', '', '', null, '', '', '', '1', '1', '-1', '', '营业员');

-- ----------------------------
-- Table structure for `basetbl_systemmgt_user_group`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_systemmgt_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for `basetbl_systemmgt_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `basetbl_systemmgt_user_role`;
CREATE TABLE `basetbl_systemmgt_user_role` (
  `uid` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`uid`),
  KEY `FKD37EEC46D511F7A` (`uid`),
  KEY `FKD37EEC4FEDD303C` (`role_id`),
  CONSTRAINT `FKD37EEC46D511F7A` FOREIGN KEY (`uid`) REFERENCES `basetbl_systemmgt_user` (`id`),
  CONSTRAINT `FKD37EEC4FEDD303C` FOREIGN KEY (`role_id`) REFERENCES `basetbl_authority_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basetbl_systemmgt_user_role
-- ----------------------------
INSERT INTO `basetbl_systemmgt_user_role` VALUES ('4028880d2f81b335012f81bf1e300001', '2c9481ab30db755e0130db79949f0002');
INSERT INTO `basetbl_systemmgt_user_role` VALUES ('40288ae845df5fe30145df6522c30004', '40288ae845df5fe30145df63f5550003');
INSERT INTO `basetbl_systemmgt_user_role` VALUES ('4028bbf14640b411014640b69d830004', '4028bbf14640b411014640b5d9420003');

-- ----------------------------
-- Table structure for `basetbl_systemmg_area`
-- ----------------------------
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

-- ----------------------------
-- Records of basetbl_systemmg_area
-- ----------------------------

-- ----------------------------
-- Table structure for `wxtbl_alipay_rechargelog`
-- ----------------------------
DROP TABLE IF EXISTS `wxtbl_alipay_rechargelog`;
CREATE TABLE `wxtbl_alipay_rechargelog` (
  `id` varchar(32) NOT NULL,
  `buyer_email` varchar(255) DEFAULT NULL,
  `buyer_id` varchar(255) DEFAULT NULL,
  `exter_invoke_ip` varchar(255) DEFAULT NULL,
  `gmt_close` varchar(255) DEFAULT NULL,
  `gmt_payment` varchar(255) DEFAULT NULL,
  `notify_id` varchar(255) DEFAULT NULL,
  `notify_time` varchar(255) DEFAULT NULL,
  `notify_type` varchar(255) DEFAULT NULL,
  `out_trade_no` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `total_fee` double DEFAULT NULL,
  `total_fee_alipay` double DEFAULT NULL,
  `trade_no` varchar(255) DEFAULT NULL,
  `trade_status` varchar(255) DEFAULT NULL,
  `order_name` varchar(255) DEFAULT NULL,
  `recharge_log_id` varchar(255) DEFAULT NULL,
  `service_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxtbl_alipay_rechargelog
-- ----------------------------
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e632640146e6383b710001', null, null, null, null, null, null, null, null, '11121112', null, '10', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e632640146e6388eef0002', null, null, null, null, null, null, null, null, '11121112', null, '10', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e632640146e638f1c30003', null, null, null, null, null, null, null, null, '11121112', null, '10', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e632640146e63905950004', null, null, null, null, null, null, null, null, '11121112', null, '1', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e632640146e6391c8d0005', null, null, null, null, null, null, null, null, '11121112', null, '10', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e632640146e6392f4a0006', null, null, null, null, null, null, null, null, '111211122', null, '1', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e65bc80146e665dcb90006', null, null, null, null, null, null, null, null, 'IkkS033B_', null, '100', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e65bc80146e6680cd6000c', null, null, null, null, null, null, null, null, 'fW4EtsgK_', null, '100', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e68ddf0146e69073830004', null, null, null, null, null, null, null, null, 'EFE6UNwI_', null, '100', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e698e70146e6997a2e0001', null, null, null, null, null, null, null, null, '11121112', null, '10', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e698e70146e69a21940002', null, null, null, null, null, null, null, null, '11121112', null, '10', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e698e70146e69a35cb0003', null, null, null, null, null, null, null, null, '111', null, '10', null, null, null, '1', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e69f970146e6a0b3ec0001', null, null, null, null, null, null, null, null, '11121112', null, '10', null, null, null, '1', null, 'create_direct_pay_by_user');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e70a550146e70c03360001', null, null, null, null, null, null, null, null, 'fW4EtsgK', null, '100', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e70a550146e70e0cfa0002', null, null, null, null, null, null, null, null, 'fW4EtsgK', null, '100', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e70a550146e70e27590003', null, null, null, null, null, null, null, null, 'fW4EtsgK', null, '100', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e70a550146e70f7e8d0007', null, null, null, null, null, null, null, null, 'IBj5T1xg_', null, '100', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e70a550146e72c48b30018', null, null, null, null, null, null, null, null, 'p9spZvf5_bniF9tFs_', null, '200', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('402881e546e70a550146e7301b4d0020', null, null, null, null, null, null, null, null, 'kat8fFBj_4IBsPebw_', null, '290', null, null, null, '40288ae845df5fe30145df6522c30004', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('40289df546f5de8d0146f63d3039001d', null, null, null, null, null, null, null, null, 'owvng5gD_', null, '100', null, null, null, 'å¥åº·è­æ¯yalasoo168ç²æ²¹è¶', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('40289df546f5de8d0146f64013a90021', null, null, null, null, null, null, null, null, '3omVituA_', null, '100', null, null, null, 'å¥åº·è­æ¯yalasoo168ç²æ²¹è¶', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('40289df546f5de8d0146f642f05d0022', null, null, null, null, null, null, null, null, '3omVituA', null, '100', null, null, null, 'å¥åº·è­æ¯yalasoo168ç²æ²¹è¶', null, 'alipay.wap.trade.create.direct');
INSERT INTO `wxtbl_alipay_rechargelog` VALUES ('40289df5470e6d2801470ea7e8040003', null, null, null, null, null, null, null, null, '3omVituA', null, '100', null, null, null, 'å¥åº·è­æ¯yalasoo168ç²æ²¹è¶', null, 'alipay.wap.trade.create.direct');

-- ----------------------------
-- Table structure for `wxtbl_article`
-- ----------------------------
DROP TABLE IF EXISTS `wxtbl_article`;
CREATE TABLE `wxtbl_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` varchar(255) NOT NULL,
  `content` longtext NOT NULL,
  `date` varchar(255) NOT NULL,
  `systemlinkid` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxtbl_article
-- ----------------------------

-- ----------------------------
-- Table structure for `wxtbl_article_type`
-- ----------------------------
DROP TABLE IF EXISTS `wxtbl_article_type`;
CREATE TABLE `wxtbl_article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addtime` varchar(30) DEFAULT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  `typename` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxtbl_article_type
-- ----------------------------

-- ----------------------------
-- Table structure for `wxtbl_attention_msg`
-- ----------------------------
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

-- ----------------------------
-- Records of wxtbl_attention_msg
-- ----------------------------
INSERT INTO `wxtbl_attention_msg` VALUES ('40288ae845df5fe30145df6c7fb60005', '2014-05-09', '40288ae845df5fe30145df6522c30004', '', '1', '', '1');

-- ----------------------------
-- Table structure for `wxtbl_customlink`
-- ----------------------------
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

-- ----------------------------
-- Records of wxtbl_customlink
-- ----------------------------
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462ce6cd01462cf0808f0001', '2014-05-24 14:34:57', '40288ae845df5fe30145df6522c30004', 'fdsa', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f37740001', '2014-05-24 17:28:19', '40288ae845df5fe30145df6522c30004', 'fdsa', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f421e0002', '2014-05-24 17:28:21', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f4ea30003', '2014-05-24 17:28:24', '40288ae845df5fe30145df6522c30004', 'fdasfds', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f58c70004', '2014-05-24 17:28:27', '40288ae845df5fe30145df6522c30004', 'fdsa', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f634f0005', '2014-05-24 17:28:30', '40288ae845df5fe30145df6522c30004', 'fdsaf', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f6dd70006', '2014-05-24 17:28:32', '40288ae845df5fe30145df6522c30004', 'fdsa', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f76fe0007', '2014-05-24 17:28:35', '40288ae845df5fe30145df6522c30004', 'fdsa', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f80b20008', '2014-05-24 17:28:37', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f8a320009', '2014-05-24 17:28:40', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8f9538000a', '2014-05-24 17:28:43', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8faa79000b', '2014-05-24 17:28:48', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8fb47c000c', '2014-05-24 17:28:51', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdas');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8fbcbe000d', '2014-05-24 17:28:53', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8fc637000e', '2014-05-24 17:28:55', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('4028811e462d8e8401462d8ffc16000f', '2014-05-24 17:29:09', '40288ae845df5fe30145df6522c30004', 'fdas', '1', 'fdsa');
INSERT INTO `wxtbl_customlink` VALUES ('402881e44631e75c014631fdc4fc0001', '2014-05-25 14:07:33', '40288ae845df5fe30145df6522c30004', 'fdsa', '1', 'fd');

-- ----------------------------
-- Table structure for `wxtbl_custommenu`
-- ----------------------------
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

-- ----------------------------
-- Records of wxtbl_custommenu
-- ----------------------------
INSERT INTO `wxtbl_custommenu` VALUES ('40288ae845df5fe30145df7fc5640017', '2014-05-09 13:41:03', '40288ae845df5fe30145df6522c30004', '', '1399614063972', '功能', '', '40288ae845df5fe30145df7f68e30016', '1', 'click', '');
INSERT INTO `wxtbl_custommenu` VALUES ('40288ae845df96520145df9894ba0004', '2014-05-09 14:08:09', '40288ae845df5fe30145df6522c30004', '', '1399615689913', 'asdf', '40288ae845df5fe30145df7b03f5000a', '40288ae845df96520145df9826730002', '2', 'click', '');

-- ----------------------------
-- Table structure for `wxtbl_custom_replay`
-- ----------------------------
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

-- ----------------------------
-- Records of wxtbl_custom_replay
-- ----------------------------

-- ----------------------------
-- Table structure for `wxtbl_msg_picturetext`
-- ----------------------------
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

-- ----------------------------
-- Records of wxtbl_msg_picturetext
-- ----------------------------
INSERT INTO `wxtbl_msg_picturetext` VALUES ('402881e446326af90146326b923c0002', '40288ae845df5fe30145df6522c30004', 'fff', '${BasePath}/upload/msgimages///40288ae845df5fe30145df6522c30004//120140525160720.png', 'aaaa', 'fdas', '402881e446326af90146326b92150001');
INSERT INTO `wxtbl_msg_picturetext` VALUES ('402881e446327a9d014632804f3d0002', '40288ae845df5fe30145df6522c30004', null, '${BasePath}/upload/msgimages///40288ae845df5fe30145df6522c30004//120140525163006.png', null, '402881e4463230f90146323188360001', '402881e446327a9d014632804f240001');
INSERT INTO `wxtbl_msg_picturetext` VALUES ('4028bbf14647bafb014647c484b40003', '40288ae845df5fe30145df6522c30004', '', '', '', '', '4028bbf14647bafb014647c4847d0002');

-- ----------------------------
-- Table structure for `wxtbl_secret`
-- ----------------------------
DROP TABLE IF EXISTS `wxtbl_secret`;
CREATE TABLE `wxtbl_secret` (
  `appid` varchar(100) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  `appsecret` varchar(100) DEFAULT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  `isadvanced` varchar(8) DEFAULT NULL,
  `partner_key` varchar(64) DEFAULT NULL,
  `partnerid` varchar(32) DEFAULT NULL,
  `pay_app_key` varchar(132) DEFAULT NULL,
  PRIMARY KEY (`appid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxtbl_secret
-- ----------------------------
INSERT INTO `wxtbl_secret` VALUES ('', '2014-05-25 22:23:45', '', '40288ae845df5fe30145df6522c30004', null, null, null, null);
INSERT INTO `wxtbl_secret` VALUES ('fd', '2014-05-25 22:23:52', '', '40288ae845df5fe30145df6522c30004', null, null, null, null);

-- ----------------------------
-- Table structure for `wxtbl_userlocation`
-- ----------------------------
DROP TABLE IF EXISTS `wxtbl_userlocation`;
CREATE TABLE `wxtbl_userlocation` (
  `openid` varchar(50) NOT NULL,
  `latitude` varchar(32) DEFAULT NULL,
  `longitude` varchar(32) DEFAULT NULL,
  `precisionx` varchar(32) DEFAULT NULL,
  `updatetime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxtbl_userlocation
-- ----------------------------

-- ----------------------------
-- Table structure for `wxtbl_wechatwall`
-- ----------------------------
DROP TABLE IF EXISTS `wxtbl_wechatwall`;
CREATE TABLE `wxtbl_wechatwall` (
  `id` varchar(32) NOT NULL,
  `gamenumber` varchar(32) DEFAULT NULL,
  `isreg` varchar(3) DEFAULT NULL,
  `msgtxg` varchar(255) DEFAULT NULL,
  `openid` varchar(50) DEFAULT NULL,
  `updatetime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wxtbl_wechatwall
-- ----------------------------

-- ----------------------------
-- Table structure for `wxtbl_wxmessages`
-- ----------------------------
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

-- ----------------------------
-- Records of wxtbl_wxmessages
-- ----------------------------
INSERT INTO `wxtbl_wxmessages` VALUES ('402881e446326af90146326b92150001', '2014/05/25', null, '40288ae845df5fe30145df6522c30004', null, '2');
INSERT INTO `wxtbl_wxmessages` VALUES ('402881e446327a9d014632804f240001', '2014/05/25', null, '40288ae845df5fe30145df6522c30004', null, '2');
INSERT INTO `wxtbl_wxmessages` VALUES ('4028bbf14647bafb014647c4847d0002', '2014/05/29', null, '40288ae845df5fe30145df6522c30004', null, '2');

-- ----------------------------
-- Table structure for `zjtbl_dzp_activity_info`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_dzp_activity_info`;
CREATE TABLE `zjtbl_dzp_activity_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  `prompt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_dzp_activity_info
-- ----------------------------
INSERT INTO `zjtbl_dzp_activity_info` VALUES ('1', '                亲，请点击进入大转盘抽奖活动页面，祝您好运哦！                                ', '               亲，你无抽奖资格!                                                            ');

-- ----------------------------
-- Table structure for `zjtbl_dzp_award`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_dzp_award`;
CREATE TABLE `zjtbl_dzp_award` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_prize` int(11) NOT NULL,
  `max` int(11) NOT NULL,
  `min` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `prompt` varchar(255) DEFAULT NULL,
  `v` int(11) NOT NULL,
  `giftid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_dzp_award
-- ----------------------------
INSERT INTO `zjtbl_dzp_award` VALUES ('1', '0', '35', '1', '五等奖', '0', '五等奖', '10', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('2', '1', '71', '37', '八等奖', '0', '八等奖', '0', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('3', '0', '107', '73', '二等奖', '0', '二等奖', '0', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('4', '1', '143', '109', '鼓励奖', '0', '鼓励奖', '0', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('5', '1', '179', '145', '参与奖', '0', '参与奖', '0', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('6', '0', '215', '181', '六等奖', '0', '六等奖', '0', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('7', '1', '251', '217', '一等奖', '0', '一等奖', '90', '40289df546d752c60146d769973d0001');
INSERT INTO `zjtbl_dzp_award` VALUES ('8', '0', '287', '253', '七等奖', '0', '七等奖', '0', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('9', '1', '323', '289', '四等奖', '0', '四等奖', '0', null);
INSERT INTO `zjtbl_dzp_award` VALUES ('10', '1', '359', '325', '三等奖', '0', '三等奖', '0', null);

-- ----------------------------
-- Table structure for `zjtbl_dzp_customer`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_dzp_customer`;
CREATE TABLE `zjtbl_dzp_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `activitiesid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_dzp_customer
-- ----------------------------
INSERT INTO `zjtbl_dzp_customer` VALUES ('2', '', '', 'java工程师', '1234', '1', '075582010008', '402881e446ed64c00146ed6711400001');
INSERT INTO `zjtbl_dzp_customer` VALUES ('3', '', '', 'java工程师', '1234', '1', '075582010008', '402881e446ed64c00146ed6711400001');
INSERT INTO `zjtbl_dzp_customer` VALUES ('4', '', '', 'java工程师', '1234', '1', '075582010008', '402881e446ed64c00146ed6711400001');
INSERT INTO `zjtbl_dzp_customer` VALUES ('5', '', '', 'java工程师', '1234', '1', '075582010008', '402881e446ed64c00146ed6711400001');

-- ----------------------------
-- Table structure for `zjtbl_dzp_winners`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_dzp_winners`;
CREATE TABLE `zjtbl_dzp_winners` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `award` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `ticket` int(11) DEFAULT NULL,
  `activitiesid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_dzp_winners
-- ----------------------------
INSERT INTO `zjtbl_dzp_winners` VALUES ('3', '一等奖', '', '', 'java工程师', '1234', '075582010008', '1', '402881e446ed64c00146ed6711400001');
INSERT INTO `zjtbl_dzp_winners` VALUES ('4', '一等奖', '', '', 'java工程师', '1234', '075582010008', '1', '402881e446ed64c00146ed6711400001');

-- ----------------------------
-- Table structure for `zjtbl_mall_cart`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_cart`;
CREATE TABLE `zjtbl_mall_cart` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(50) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_cart
-- ----------------------------
INSERT INTO `zjtbl_mall_cart` VALUES ('402881e64b0d2489014b0d3091980001', '20150121', '2', 'tL42c1Tz', '1234');

-- ----------------------------
-- Table structure for `zjtbl_mall_label`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_label`;
CREATE TABLE `zjtbl_mall_label` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_label
-- ----------------------------
INSERT INTO `zjtbl_mall_label` VALUES ('402881e446c23ccc0146c240d9600001', '商品标签', '2014-06-22 14:26:08');
INSERT INTO `zjtbl_mall_label` VALUES ('402881e446c23ccc0146c242472f0002', '反反复复', '2014-06-22 14:27:41');

-- ----------------------------
-- Table structure for `zjtbl_mall_mallconf`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_mallconf`;
CREATE TABLE `zjtbl_mall_mallconf` (
  `id` varchar(32) NOT NULL,
  `cstel` varchar(20) DEFAULT NULL,
  `mallname` varchar(50) DEFAULT NULL,
  `skinid` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `footword` varchar(64) DEFAULT NULL,
  `outtimeset` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_mallconf
-- ----------------------------
INSERT INTO `zjtbl_mall_mallconf` VALUES ('40288ae845df5fe30145df6522c30004', '', '微商城', '1', '1', '2014-05-30 10:13:10', 'http://localhost:8080/wxzj/zjmall/index.kq', '', '10');

-- ----------------------------
-- Table structure for `zjtbl_mall_navset`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_navset`;
CREATE TABLE `zjtbl_mall_navset` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(32) NOT NULL,
  `navindex` int(11) DEFAULT NULL,
  `setkey` varchar(128) DEFAULT NULL,
  `setvalue` varchar(128) DEFAULT NULL,
  `skinid` int(11) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_navset
-- ----------------------------
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341d9a70001', '40288ae845df5fe30145df6522c30004', '0', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140530101900.gif', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=0', '1', '2014-06-07 16:46:47');
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341e26b0002', '40288ae845df5fe30145df6522c30004', '1', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140530102001.jpg', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=9NsZzHNe', '1', '2014-06-03 10:45:57');
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341eb120003', '40288ae845df5fe30145df6522c30004', '2', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140602213343.jpg', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=9NsZzHNe', '1', '2014-06-03 10:46:06');
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341f1840004', '40288ae845df5fe30145df6522c30004', '3', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140602213409.jpg', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=9NsZzHNe', '1', '2014-06-03 10:45:53');
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341f1890005', '40288ae845df5fe30145df6522c30004', '4', '特价', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=9NsZzHNe', '1', '2014-06-03 10:46:11');
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341f1a00006', '40288ae845df5fe30145df6522c30004', '5', '新品上市', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=9NsZzHNe', '1', '2014-06-03 10:46:16');
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341f1c40007', '40288ae845df5fe30145df6522c30004', '6', '促销', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=9NsZzHNe', '1', '2014-06-03 10:46:20');
INSERT INTO `zjtbl_mall_navset` VALUES ('4028818443a3413c0143a341f1ca0008', '40288ae845df5fe30145df6522c30004', '7', '全部', 'http://localhost:8080/wxzj/zjmall/mlist.kq?bid=40288ae845df5fe30145df6522c30004&qtype=9NsZzHNe', '1', '2014-06-03 10:46:24');

-- ----------------------------
-- Table structure for `zjtbl_mall_order`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_order`;
CREATE TABLE `zjtbl_mall_order` (
  `id` varchar(32) NOT NULL,
  `expcompany` varchar(100) DEFAULT NULL,
  `expnum` varchar(50) DEFAULT NULL,
  `ordertime` varchar(50) DEFAULT NULL,
  `paytype` varchar(20) DEFAULT NULL,
  `phonenum` varchar(15) DEFAULT NULL,
  `postnum` varchar(8) DEFAULT NULL,
  `receiveaddr` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `totalmoney` float DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  `coupon_money` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_order
-- ----------------------------
INSERT INTO `zjtbl_mall_order` VALUES ('3omVituA', null, null, '2014-07-02 16:44:02.0', '2', '075582010008', null, '广东省深圳市龙岗区中心围', 'java工程师', '0', '100', '1234', '0');
INSERT INTO `zjtbl_mall_order` VALUES ('4IBsPebw', 'fff', 'fff', '2014-06-29 18:33:41.0', null, '075582010008', null, '广东省深圳市龙岗区中心围', 'java工程师', '0', null, '1234', null);
INSERT INTO `zjtbl_mall_order` VALUES ('kat8fFBj', '', '', '2014-06-29 18:33:41.0', null, '075582010008', null, '广东省深圳市龙岗区中心围', 'java工程师', '2', null, '1234', null);
INSERT INTO `zjtbl_mall_order` VALUES ('m442VQ8L', null, null, '2014-06-29 16:50:39.0', '1', '075582010008', null, '请选择请选择请选择广东省深圳市龙岗区中心围', 'java工程师', '3', '100', '1234', '0');
INSERT INTO `zjtbl_mall_order` VALUES ('owvng5gD', null, null, '2014-07-02 16:42:21.0', '2', '075582010008', null, '广东省深圳市龙岗区中心围', 'java工程师', '0', '100', '1234', '0');
INSERT INTO `zjtbl_mall_order` VALUES ('u9Cqye0X', null, null, '2014-06-29 18:28:58.0', '1', '075582010008', null, '广东省深圳市龙岗区中心围', 'java工程师', '3', '100', '1234', '0');
INSERT INTO `zjtbl_mall_order` VALUES ('y6uFMIua', null, null, '2014-06-29 18:28:58.0', '1', '075582010008', null, '广东省深圳市龙岗区中心围', 'java工程师', '2', '100', '1234', '0');

-- ----------------------------
-- Table structure for `zjtbl_mall_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_order_detail`;
CREATE TABLE `zjtbl_mall_order_detail` (
  `id` varchar(32) NOT NULL,
  `buynum` int(11) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `orderid` varchar(32) DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `ptitle` varchar(60) DEFAULT NULL,
  `totalmoney` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_order_detail
-- ----------------------------
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e65bc80146e667d9e4000b', '1', null, 'fW4EtsgK', 'SwLxsGHW', 'test1', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e68ddf0146e6905bcc0003', '1', null, 'EFE6UNwI', 'tL42c1Tz', '沐姬美足片', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e6d0eb0146e6d1ac9c0005', '1', null, 'm442VQ8L', 'R3vrmzmH', '新款', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e70a550146e70f72690006', '1', null, 'IBj5T1xg', 'ivgMJtx5', '健康芭比yalasoo168甲油胶', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e70a550146e72bb11c0010', '1', null, 'u9Cqye0X', 'qfsBtsE3', '水纹胶123荧光绿', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e70a550146e72bb11d0011', '1', null, 'y6uFMIua', 'ivgMJtx5', '健康芭比yalasoo168甲油胶', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e70a550146e72c41320016', '1', null, 'p9spZvf5', 'qfsBtsE3', '水纹胶123荧光绿', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e70a550146e72c41330017', '1', null, 'bniF9tFs', 'ivgMJtx5', '健康芭比yalasoo168甲油胶', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e70a550146e73002f3001e', '1', null, 'kat8fFBj', 'qfsBtsE3', '水纹胶123荧光绿', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('402881e546e70a550146e73002f4001f', '2', null, '4IBsPebw', 'ivgMJtx5', '健康芭比yalasoo168甲油胶', '200');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('40289df546f5de8d0146f63d28c7001c', '1', null, 'owvng5gD', 'ivgMJtx5', '健康芭比yalasoo168甲油胶', '100');
INSERT INTO `zjtbl_mall_order_detail` VALUES ('40289df546f5de8d0146f63eb2aa0020', '1', null, '3omVituA', 'ivgMJtx5', '健康芭比yalasoo168甲油胶', '100');

-- ----------------------------
-- Table structure for `zjtbl_mall_paytype`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_paytype`;
CREATE TABLE `zjtbl_mall_paytype` (
  `id` varchar(2) NOT NULL,
  `issupport` varchar(2) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_paytype
-- ----------------------------
INSERT INTO `zjtbl_mall_paytype` VALUES ('1', '1', '余额支付');
INSERT INTO `zjtbl_mall_paytype` VALUES ('2', '1', '支付宝');

-- ----------------------------
-- Table structure for `zjtbl_mall_product`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_product`;
CREATE TABLE `zjtbl_mall_product` (
  `id` varchar(8) NOT NULL,
  `description` longtext,
  `fristimgh` int(11) DEFAULT NULL,
  `fristimgw` int(11) DEFAULT NULL,
  `imgcount` varchar(5) DEFAULT NULL,
  `imgpath` varchar(150) DEFAULT NULL,
  `isshow` varchar(5) DEFAULT NULL,
  `lastupdate` varchar(20) DEFAULT NULL,
  `opric` varchar(30) DEFAULT NULL,
  `pid` varchar(8) DEFAULT NULL,
  `pleft` int(11) DEFAULT NULL,
  `pric` varchar(30) DEFAULT NULL,
  `ptitle` varchar(60) DEFAULT NULL,
  `ptop` int(11) DEFAULT NULL,
  `ptype` varchar(8) DEFAULT NULL,
  `remark` longtext,
  `status` varchar(5) DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL,
  `category` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_product
-- ----------------------------
INSERT INTO `zjtbl_mall_product` VALUES ('ivgMJtx5', '优质正品 进口光疗 促销价12ml新品热销', '39', '52', '1', 'upload/msgimages//20140629120003/1.jpg', '0', '20140629', '100', 'P800888', null, '50', '健康芭比yalasoo168甲油胶', null, '9NsZzHNe', '优质正品 进口光疗 促销价12ml新品热销', '1', '40288ae845df5fe30145df6522c30004', '2');
INSERT INTO `zjtbl_mall_product` VALUES ('qfsBtsE3', '蓝梦庄园甲油胶 光疗美甲可卸 时尚指甲光疗环保', '307', '410', '1', 'upload/msgimages//20140629112302/1.jpg', '1', '20140629', '100', 'P800888', null, '50', '水纹胶123荧光绿', null, '9NsZzHNe', '蓝梦庄园甲油胶 光疗美甲可卸 时尚指甲光疗环保', '1', '40288ae845df5fe30145df6522c30004', '1');
INSERT INTO `zjtbl_mall_product` VALUES ('R3vrmzmH', 'Nothing', '356', '474', '1', 'upload/msgimages//20140629113946/1.jpg', '0', '20140629', '100', 'P800888', null, '1', '新款', null, '59wgjBDs', 'Nothing', '1', '40288ae845df5fe30145df6522c30004', '1');
INSERT INTO `zjtbl_mall_product` VALUES ('SwLxsGHW', 'test', '219', '293', '1', 'upload/msgimages//20140623213137/1.jpg', '0', '20140623', '100', 'P800888', null, '1', 'test1', null, '9NsZzHNe', 'test', '1', '40288ae845df5fe30145df6522c30004', '1');
INSERT INTO `zjtbl_mall_product` VALUES ('tL42c1Tz', '沐姬美足片有天然抗菌消毒作用，彻底清洁皮肤及指甲，同时滋润及软化皮肤和甲边，并能祛除足部异味，促进血液循环，补充营养，消除疲劳，令足部肌肤柔嫩、白皙、光滑。泡腾片的溶解方式迎合客人的趣味性，对皮肤无刺激。', '450', '600', '3', 'upload/msgimages///20140603105220//1.jpg', '0', '20140603', '100', 'P800888', null, '50', '沐姬美足片', null, '9NsZzHNe', '沐姬美足片有天然抗菌消毒作用，彻底清洁皮肤及指甲，同时滋润及软化皮肤和甲边，并能祛除足部异味，促进血液循环，补充营养，消除疲劳，令足部肌肤柔嫩、白皙、光滑。泡腾片的溶解方式迎合客人的趣味性，对皮肤无刺激。', '1', '40288ae845df5fe30145df6522c30004', null);
INSERT INTO `zjtbl_mall_product` VALUES ('yHDdCsj7', 'bluesky037甲油胶时尚潮流米兰达装扮美甲', '39', '52', '1', 'upload/msgimages//20140629113328/1.jpg', '0', '20140629', '100', 'P800888', null, '50', '可卸免洗 免底胶 免封层bluesky037甲油', null, '9NsZzHNe', 'bluesky037甲油胶时尚潮流米兰达装扮美甲', '1', '40288ae845df5fe30145df6522c30004', '1');

-- ----------------------------
-- Table structure for `zjtbl_mall_producttype`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_producttype`;
CREATE TABLE `zjtbl_mall_producttype` (
  `id` varchar(8) NOT NULL,
  `addtime` varchar(30) DEFAULT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  `istay` varchar(8) DEFAULT NULL,
  `typename` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_producttype
-- ----------------------------
INSERT INTO `zjtbl_mall_producttype` VALUES ('59wgjBDs', '2014-06-24 20:24:35', '40288ae845df5fe30145df6522c30004', '1', '光疗产品');
INSERT INTO `zjtbl_mall_producttype` VALUES ('9NsZzHNe', '2014-06-03 10:08:00', '40288ae845df5fe30145df6522c30004', '1', '美甲产品');
INSERT INTO `zjtbl_mall_producttype` VALUES ('N40rHYZl', '2014-07-07 11:08:43', '40288ae845df5fe30145df6522c30004', '1', '全部');

-- ----------------------------
-- Table structure for `zjtbl_mall_prolabelrelation`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_prolabelrelation`;
CREATE TABLE `zjtbl_mall_prolabelrelation` (
  `id` varchar(32) NOT NULL,
  `labelid` varchar(32) DEFAULT NULL,
  `productid` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_prolabelrelation
-- ----------------------------
INSERT INTO `zjtbl_mall_prolabelrelation` VALUES ('402881e446c8f5900146c8f696c40001', '402881e446c23ccc0146c240d9600001', 'SwLxsGHW');
INSERT INTO `zjtbl_mall_prolabelrelation` VALUES ('402881e446c8f5900146c8f69bb60002', '402881e446c23ccc0146c242472f0002', 'tL42c1Tz');
INSERT INTO `zjtbl_mall_prolabelrelation` VALUES ('402881e546e5b3c50146e5b5138a0001', '402881e446c23ccc0146c240d9600001', 'R3vrmzmH');
INSERT INTO `zjtbl_mall_prolabelrelation` VALUES ('402881e546e70a550146e72a7da30008', '402881e446c23ccc0146c242472f0002', 'ivgMJtx5');
INSERT INTO `zjtbl_mall_prolabelrelation` VALUES ('402881e546e70a550146e72ab0070009', '402881e446c23ccc0146c240d9600001', 'qfsBtsE3');

-- ----------------------------
-- Table structure for `zjtbl_mall_propitem`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_propitem`;
CREATE TABLE `zjtbl_mall_propitem` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(32) DEFAULT NULL,
  `propname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_propitem
-- ----------------------------

-- ----------------------------
-- Table structure for `zjtbl_mall_propkey`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_propkey`;
CREATE TABLE `zjtbl_mall_propkey` (
  `id` varchar(32) NOT NULL,
  `keyname` varchar(32) DEFAULT NULL,
  `keyvalue` varchar(32) DEFAULT NULL,
  `prid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK436BD3026C9183F` (`prid`),
  CONSTRAINT `FK436BD3026C9183F` FOREIGN KEY (`prid`) REFERENCES `zjtbl_mall_propitem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_propkey
-- ----------------------------

-- ----------------------------
-- Table structure for `zjtbl_mall_skin`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_mall_skin`;
CREATE TABLE `zjtbl_mall_skin` (
  `id` varchar(32) NOT NULL,
  `defaultkey` varchar(128) DEFAULT NULL,
  `defaultvalue` varchar(128) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `navindex` int(11) DEFAULT NULL,
  `settype` int(11) DEFAULT NULL,
  `skinid` int(11) DEFAULT NULL,
  `skinname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_mall_skin
-- ----------------------------
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a334e2c10001', 'http://localhost/zj/images/app/zjmall/logo.gif', 'www.baidu.com', 'Logo图片(建议尺寸：175像素 * 45像素)', '0', '1', '1', '默认风\n格');
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a335f5200002', 'http://localhost/zj/images/app/zjmall/skin/1/bdgg1.jpg', 'mlist.kq?qtype=', '幻灯1图片（建议尺寸：640像素 * 425像素）', '1', '1', '1', '默认风格');
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a33647910003', 'http://localhost/zj/images/app/zjmall/skin/1/bdgg2.jpg', 'mlist.kq?qtype=', '幻灯2图片（建议尺寸：640像素 * 425像素）', '2', '1', '1', '默认风\n格');
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a3367bb60004', 'http://localhost/zj/images/app/zjmall/skin/1/bdgg1.jpg', 'mlist.kq?qtype=', '幻灯3图片（建议尺寸：640像素 * 425像素）', '3', '1', '1', '默认风格');
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a336c1550005', '新品', 'mlist.kq?qtype=', '分类导航1', '4', '2', '1', '默认风格');
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a3370b270006', '全部', 'mlist.kq?qtype=', '分类导航1', '5', '2', '1', '默认风格');
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a33760990007', '导航', 'mlist.kq?qtype=', '分类导航1', '6', '2', '1', '默认风格');
INSERT INTO `zjtbl_mall_skin` VALUES ('4028818443a32d320143a337a1710008', '导航', 'mlist.kq?qtype=', '分类导航1', '7', '2', '1', '默认风格');

-- ----------------------------
-- Table structure for `zjtbl_minweb_activities`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_activities`;
CREATE TABLE `zjtbl_minweb_activities` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` longtext NOT NULL,
  `endtime` datetime NOT NULL,
  `name` varchar(32) NOT NULL,
  `photourl` longtext NOT NULL,
  `starttime` datetime NOT NULL,
  `url` longtext NOT NULL,
  `type` varchar(32) DEFAULT NULL,
  `memberlevelid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_activities
-- ----------------------------
INSERT INTO `zjtbl_minweb_activities` VALUES ('402881e446ed64c00146ed6711400001', '40288ae845df5fe30145df6522c30004', '大转盘抽奖啦！', '2014-07-10 00:00:00', '大转盘', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140630233117.jpg', '2014-06-24 00:00:00', 'http://localhost:8080/wxzj/turentable/toTurentable.kq', '4', '1');
INSERT INTO `zjtbl_minweb_activities` VALUES ('402881e546e3182f0146e3244ecc0005', '40288ae845df5fe30145df6522c30004', '摇一摇活动，抽奖啦！', '2014-07-10 00:00:00', '摇一摇活动', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140628234206.jpg', '2014-06-27 00:00:00', 'http://localhost:8080/wxzj/zj/zjminweb/getWobble.kq', '2', '2');
INSERT INTO `zjtbl_minweb_activities` VALUES ('402881e546e3353c0146e33db0140004', '40288ae845df5fe30145df6522c30004', '刮刮卡活动参与抽奖！！！！', '2014-07-11 00:00:00', '刮刮卡活动', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140629000948.jpg', '2014-06-16 00:00:00', 'http://localhost:8080/wxzj/card/zjminweb/toMain.kq', '3', '1');

-- ----------------------------
-- Table structure for `zjtbl_minweb_album`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_album`;
CREATE TABLE `zjtbl_minweb_album` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_album
-- ----------------------------
INSERT INTO `zjtbl_minweb_album` VALUES ('402881e8465d8d1b01465d8db9e30001', '40288ae845df5fe30145df6522c30004', 'åå¦å¸', 'åå¦å¸');

-- ----------------------------
-- Table structure for `zjtbl_minweb_baoming`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_baoming`;
CREATE TABLE `zjtbl_minweb_baoming` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `mobile` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `activitiesid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_baoming
-- ----------------------------
INSERT INTO `zjtbl_minweb_baoming` VALUES ('402881e446c2c8a10146c2c97f370001', '40288ae845df5fe30145df6522c30004,', '13632849134', '丁丁', '402881e546b9351e0146b9472d680001');
INSERT INTO `zjtbl_minweb_baoming` VALUES ('40289df546b8bd270146b8c5eaf90004', '40288ae845df5fe30145df6522c30004', '13632845654', '丁丁', null);
INSERT INTO `zjtbl_minweb_baoming` VALUES ('40289df546b8bd270146b8c6c8130005', '40288ae845df5fe30145df6522c30004', '13632845654', '丁丁', null);

-- ----------------------------
-- Table structure for `zjtbl_minweb_card_config`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_card_config`;
CREATE TABLE `zjtbl_minweb_card_config` (
  `id` varchar(32) NOT NULL,
  `illustrate` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_card_config
-- ----------------------------
INSERT INTO `zjtbl_minweb_card_config` VALUES ('1', '背景图片，尺寸为499*360', '/images/card/gameImg/logo.png', 'background', '1');
INSERT INTO `zjtbl_minweb_card_config` VALUES ('2', '初始次数', '1', 'number', '2');
INSERT INTO `zjtbl_minweb_card_config` VALUES ('3', '活动说明', '1、刮开涂层就有机会获得巨额电信红包\r\n2、分享活动，和朋友一起玩。马上分享\r\n3、每个微信账号仅有5次领取红包的机会', 'activityExplain', '2');
INSERT INTO `zjtbl_minweb_card_config` VALUES ('4', '奖品设置 ', '一等奖：300元；10%中奖概率\r\n二等奖：200元；80%中奖概率\r\n三等奖：100元；10%中奖概率', 'prize', '2');
INSERT INTO `zjtbl_minweb_card_config` VALUES ('5', '活动时间', '2014-6-12----2014-6-30', 'time', '2');
INSERT INTO `zjtbl_minweb_card_config` VALUES ('6', '过期时间', '2014-6-30', 'expiredTime', '2');

-- ----------------------------
-- Table structure for `zjtbl_minweb_card_prizeconfig`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_card_prizeconfig`;
CREATE TABLE `zjtbl_minweb_card_prizeconfig` (
  `id` varchar(32) NOT NULL,
  `isprize` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `v` int(11) DEFAULT NULL,
  `giftid` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_card_prizeconfig
-- ----------------------------
INSERT INTO `zjtbl_minweb_card_prizeconfig` VALUES ('1', '1', '一等奖', '/ggk/1.png', '20', '40289df546d752c60146d769973d0001', '0');
INSERT INTO `zjtbl_minweb_card_prizeconfig` VALUES ('2', '2', '二等奖', '/ggk/2.png', '10', null, '0');
INSERT INTO `zjtbl_minweb_card_prizeconfig` VALUES ('3', '2', '三等奖', '/ggk/3.png', '0', null, '0');
INSERT INTO `zjtbl_minweb_card_prizeconfig` VALUES ('4', '2', '再接再厉哦', '/ggk/4.png', '0', null, '0');

-- ----------------------------
-- Table structure for `zjtbl_minweb_card_prizerecord`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_card_prizerecord`;
CREATE TABLE `zjtbl_minweb_card_prizerecord` (
  `id` varchar(32) NOT NULL,
  `isprizes` int(11) DEFAULT NULL,
  `isreg` int(11) DEFAULT NULL,
  `mobilephone` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `prizename` varchar(255) DEFAULT NULL,
  `activitiesid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_card_prizerecord
-- ----------------------------
INSERT INTO `zjtbl_minweb_card_prizerecord` VALUES ('402881e446ed76c70146ed7c0c1f0001', '1', '1', '136433423432', '丁丁', '0', '1234', '一等奖', '402881e546e3353c0146e33db0140004');

-- ----------------------------
-- Table structure for `zjtbl_minweb_consumption`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_consumption`;
CREATE TABLE `zjtbl_minweb_consumption` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `intime` varchar(32) DEFAULT NULL,
  `memberid` varchar(32) DEFAULT NULL,
  `money` varchar(32) DEFAULT NULL,
  `reasons` longtext,
  `status` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `balance` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_consumption
-- ----------------------------
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e446ec7ccb0146ec8040110001', '40288ae845df5fe30145df6522c30004', '2014-06-30 19:19:26.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '8884.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e446ec7ccb0146ec8236b50003', '40288ae845df5fe30145df6522c30004', '2014-06-30 19:21:35.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '8874.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e446ec7ccb0146ec837d800005', '40288ae845df5fe30145df6522c30004', '2014-06-30 19:22:58.0', '402881e8465d1e7a01465d22f8e70001', '10', '充值', '0', '1', '8884.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e3182f0146e318c7560002', '40288ae845df5fe30145df6522c30004', '2014-06-28 23:29:50.0', '402881e8465d1e7a01465d22f8e70001', '300.0', '商城消费', '0', '0', '9500.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e3542f0146e35effcc0001', '40288ae845df5fe30145df6522c30004', '2014-06-29 00:46:32.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '9490.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e3542f0146e35f518a0003', '40288ae845df5fe30145df6522c30004', '2014-06-29 00:46:53.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '9480.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e3542f0146e35f66280005', '40288ae845df5fe30145df6522c30004', '2014-06-29 00:46:58.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '9470.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e3542f0146e35f7af60007', '40288ae845df5fe30145df6522c30004', '2014-06-29 00:47:03.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '9460.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e36a270146e36ac3480001', '40288ae845df5fe30145df6522c30004', '2014-06-29 00:59:23.0', '402881e8465d1e7a01465d22f8e70001', '12', '线下消费', '0', '0', '9448.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e36a270146e36c9a960003', '40288ae845df5fe30145df6522c30004', '2014-06-29 01:01:23.0', '402881e8465d1e7a01465d22f8e70001', '12', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e36e0c0146e36e8cc70001', '40288ae845df5fe30145df6522c30004', '2014-06-29 01:03:31.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '9426.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e36e0c0146e36e9ac70003', '40288ae845df5fe30145df6522c30004', '2014-06-29 01:03:35.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '9416.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e36e0c0146e36ea3c10005', '40288ae845df5fe30145df6522c30004', '2014-06-29 01:03:37.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '9406.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e36e0c0146e36edde80007', '40288ae845df5fe30145df6522c30004', '2014-06-29 01:03:52.0', '402881e8465d1e7a01465d22f8e70001', '100', '线下消费', '0', '0', '9306.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e375160146e37595cd0001', '40288ae845df5fe30145df6522c30004', '2014-06-29 01:11:12.0', '402881e8465d1e7a01465d22f8e70001', '12', '线下消费', '0', '0', '9294.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e6592b0146e659f8bf0003', '40288ae845df5fe30145df6522c30004', '2014-06-29 14:39:54.0', '402881e8465d1e7a01465d22f8e70001', '100.0', '商城消费', '0', '0', '9194.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e6d0eb0146e6d1ac8f0003', '40288ae845df5fe30145df6522c30004', '2014-06-29 16:50:39.0', '402881e8465d1e7a01465d22f8e70001', '100.0', '商城消费', '0', '0', '9094.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('402881e546e70a550146e72bb110000e', '40288ae845df5fe30145df6522c30004', '2014-06-29 18:28:58.0', '402881e8465d1e7a01465d22f8e70001', '200.0', '商城消费', '0', '0', '8894.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('40289df547378c13014737ad56af0004', '40288ae845df5fe30145df6522c30004', '2014-07-15 09:40:12.0', '402881e8465d1e7a01465d22f8e70001', '100', '充值', '0', '1', '50.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('40289df547378c13014737b18e220005', '40288ae845df5fe30145df6522c30004', '2014-07-15 09:44:48.0', '402881e8465d1e7a01465d22f8e70001', '100', '线下消费', '0', '0', '0.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('40289df54737b4b8014737b555220001', '40288ae845df5fe30145df6522c30004', '2014-07-15 09:48:56.0', '402881e8465d1e7a01465d22f8e70001', '50', '线下消费', '0', '0', '-50.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('40289df54737b4b8014737b7501f0003', '40288ae845df5fe30145df6522c30004', '2014-07-15 09:51:06.0', '402881e8465d1e7a01465d22f8e70001', '100', '充值', '0', '1', '50.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('40289df547382b980147382c2da70001', '40288ae845df5fe30145df6522c30004', '2014-07-15 11:58:45.0', '402881e8465d1e7a01465d22f8e70001', '50', '线下消费', '0', '0', '0.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('4028f18346c27d070146c284ce7f0003', '40288ae845df5fe30145df6522c30004', '2014-06-22 03:40:22', 'ff808081466c16970146749625140003', '20.0', '线上消费，用户下订单选择余额支付成功', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('8a80801246e20be50146e20c887b0001', '40288ae845df5fe30145df6522c30004', '2014-06-28 18:36:50.0', '402881e8465d1e7a01465d22f8e70001', '10', '线下消费', '0', '0', '10020.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('8a80801246e20be50146e20d2c7d0003', '40288ae845df5fe30145df6522c30004', '2014-06-28 18:37:32.0', '402881e8465d1e7a01465d22f8e70001', '20', '线下消费', '0', '0', '10000.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('8a80801246e2ad290146e2bb95d80004', '40288ae845df5fe30145df6522c30004', '2014-06-28 21:48:02.0', '402881e8465d1e7a01465d22f8e70001', '200.0', '商城消费', '0', '0', '9800.0');
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146a415770146a421e8740005', '40288ae845df5fe30145df6522c30004', '2014-06-16 06:03:44', 'ff808081465d39b701465d3a467c0001', '50', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146a415770146a4229db80006', '40288ae845df5fe30145df6522c30004', '2014-06-16 06:04:30', 'ff808081465d39b701465d3a467c0001', '100', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146a415770146a42307950007', '40288ae845df5fe30145df6522c30004', '2014-06-16 06:04:57', 'ff808081465d39b701465d3a467c0001', '100', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146bf315f0146bf489d3a0006', '40288ae845df5fe30145df6522c30004', '2014-06-22 12:35:45', 'ff808081465d39b701465d3a467c0001', '50', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146c263110146c27273380019', '40288ae845df5fe30145df6522c30004', '2014-06-22 03:20:19', 'ff808081466c16970146749625140003', '1000', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146c28f2b0146c2af6f4e0005', '40288ae845df5fe30145df6522c30004', '2014-06-22 04:26:55', 'ff808081465d39b701465d3a467c0001', '10.0', '线上消费，用户下订单选择余额支付成功', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146c2e5e60146c306dc020005', '40288ae845df5fe30145df6522c30004', '2014-06-22 06:02:25', 'ff808081465d39b701465d3a467c0001', '10.0', '线上消费，用户下订单选择余额支付成功', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146c32fb80146c331a4940002', '40288ae845df5fe30145df6522c30004', '2014-06-22 06:49:09', 'ff808081465d39b701465d3a467c0001', '10.0', '商城消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146c9694e0146c970a5570001', '40288ae845df5fe30145df6522c30004', '2014-06-23 11:55:41', 'ff80808146c3b0190146c7dff5d1002a', '1000', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146cb82a30146cbc39fed0001', '40288ae845df5fe30145df6522c30004', '2014-06-24 10:45:33', 'ff808081465d39b701465d3a467c0001', '10', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146cb82a30146cd2633e10004', '40288ae845df5fe30145df6522c30004', '2014-06-24 05:12:51', 'ff80808146a8e5980146ae36c00c0009', '5000000', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e055070146e06793270014', '40288ae845df5fe30145df6522c30004', '2014-06-28 10:57:02', 'ff80808146c3b0190146c7dff5d1002a', '20.0', '商城消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e079aa0146e082b6b60004', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:26:41', 'ff808081465d39b701465d3a467c0001', '10', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e079aa0146e084fb250006', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:29:09', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e08c64180001', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:37:15', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e08cca220003', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:37:41', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e08f1f930005', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:40:14', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e08f2cfb0007', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:40:18', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e08f6c9d0009', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:40:34', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e08ffb41000b', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:41:10', 'ff808081465d39b701465d3a467c0001', '10', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e0902c65000c', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:41:23', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e091d57f000e', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:43:12', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e091fc4a0010', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:43:22', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e0940c040012', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:45:37', 'ff808081465d39b701465d3a467c0001', '1', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e08bcb0146e094341f0013', '40288ae845df5fe30145df6522c30004', '2014-06-28 11:45:47', 'ff808081465d39b701465d3a467c0001', '1', '线下消费', '0', '0', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e128700146e12c28fe0004', '40288ae845df5fe30145df6522c30004', '2014-06-28 00:00:00.0', 'ff80808146c3b0190146c7dbc06e0028', '1000', '充值', '0', '1', null);
INSERT INTO `zjtbl_minweb_consumption` VALUES ('ff80808146e160360146e1610f910002', '40288ae845df5fe30145df6522c30004', '2014-06-28 00:00:00.0', 'ff80808146c3b0190146c7dbc06e0028', '10.0', '商城消费', '0', '0', null);

-- ----------------------------
-- Table structure for `zjtbl_minweb_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_coupon`;
CREATE TABLE `zjtbl_minweb_coupon` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `islimit` varchar(10) DEFAULT NULL,
  `money` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `usablerange` float DEFAULT NULL,
  `validityend` datetime DEFAULT NULL,
  `validitystart` datetime DEFAULT NULL,
  `memberlevelid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_coupon
-- ----------------------------
INSERT INTO `zjtbl_minweb_coupon` VALUES ('402881e446cdecc50146ce08cac40001', '40288ae845df5fe30145df6522c30004', null, '10', '商城满100优惠10', '0', '38', '1', '100', '2014-07-11 00:00:00', '2014-06-04 00:00:00', null);
INSERT INTO `zjtbl_minweb_coupon` VALUES ('40289df546dc9bae0146dca748930001', '40288ae845df5fe30145df6522c30004', '1', '10', '商城满50送10', '0', '36', '0', '50', '2014-06-30 00:00:00', '2014-06-12 00:00:00', '1');
INSERT INTO `zjtbl_minweb_coupon` VALUES ('40289df546dce5a30146dce724840002', '40288ae845df5fe30145df6522c30004', null, '100', '商城满500优惠100', '0', '49', '0', '500', '2014-07-02 00:00:00', '2014-06-17 00:00:00', '4');

-- ----------------------------
-- Table structure for `zjtbl_minweb_couponrecord`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_couponrecord`;
CREATE TABLE `zjtbl_minweb_couponrecord` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `consumptionid` varchar(32) DEFAULT NULL,
  `couponid` varchar(32) DEFAULT NULL,
  `isreceive` varchar(32) DEFAULT NULL,
  `isuse` varchar(32) DEFAULT NULL,
  `memberid` varchar(32) DEFAULT NULL,
  `receivetime` varchar(32) DEFAULT NULL,
  `usertime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_couponrecord
-- ----------------------------
INSERT INTO `zjtbl_minweb_couponrecord` VALUES ('402881e546e53cb50146e54450da0001', '40288ae845df5fe30145df6522c30004', null, '40289df546dc9bae0146dca748930001', '1', '1', '402881e8465d1e7a01465d22f8e70001', '2014-06-29 09:36:38', '2014-06-29 18:33:41');
INSERT INTO `zjtbl_minweb_couponrecord` VALUES ('402881e546e70a550146e72e38720019', '40288ae845df5fe30145df6522c30004', null, '40289df546dc9bae0146dca748930001', '1', '0', '402881e8465d1e7a01465d22f8e70001', '2014-06-29 18:31:44', null);

-- ----------------------------
-- Table structure for `zjtbl_minweb_diaoyan`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_diaoyan`;
CREATE TABLE `zjtbl_minweb_diaoyan` (
  `id` varchar(32) NOT NULL,
  `active_end_time` varchar(32) DEFAULT NULL,
  `active_name` varchar(100) DEFAULT NULL,
  `active_start_time` varchar(32) DEFAULT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `img_path` varchar(100) DEFAULT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `open_id` varchar(100) DEFAULT NULL,
  `operation_time` varchar(32) DEFAULT NULL,
  `relation_active` varchar(32) DEFAULT NULL,
  `remark` longtext,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_diaoyan
-- ----------------------------

-- ----------------------------
-- Table structure for `zjtbl_minweb_diaoyanuser`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_diaoyanuser`;
CREATE TABLE `zjtbl_minweb_diaoyanuser` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `relation_title_id` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_diaoyanuser
-- ----------------------------

-- ----------------------------
-- Table structure for `zjtbl_minweb_gift`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_gift`;
CREATE TABLE `zjtbl_minweb_gift` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` longtext NOT NULL,
  `intime` datetime DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_gift
-- ----------------------------
INSERT INTO `zjtbl_minweb_gift` VALUES ('40289df546d72d780146d72e22e00001', '40288ae845df5fe30145df6522c30004', '<p>iphone 5S!!!</p>\r\n', '2014-06-26 00:00:00', 'iphone 5S', '5', '1');
INSERT INTO `zjtbl_minweb_gift` VALUES ('40289df546d752c60146d769973d0001', '40288ae845df5fe30145df6522c30004', '<p>ipad mini2!!!!</p>\r\n', '2014-06-26 00:00:00', 'ipad mini2', '80', '0');

-- ----------------------------
-- Table structure for `zjtbl_minweb_index_model`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_index_model`;
CREATE TABLE `zjtbl_minweb_index_model` (
  `id` varchar(32) NOT NULL,
  `bizid` longtext,
  `name` longtext,
  `type` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_index_model
-- ----------------------------
INSERT INTO `zjtbl_minweb_index_model` VALUES ('1', '123456', 'aaaa', '1', '1');

-- ----------------------------
-- Table structure for `zjtbl_minweb_integral`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_integral`;
CREATE TABLE `zjtbl_minweb_integral` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` varchar(10) DEFAULT NULL,
  `intime` datetime NOT NULL,
  `memberid` varchar(32) NOT NULL,
  `score` varchar(32) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_integral
-- ----------------------------
INSERT INTO `zjtbl_minweb_integral` VALUES ('40287dd44f8d2acf014f8d3429fe0002', '40288ae845df5fe30145df6522c30004', '签到领取', '2015-09-02 16:37:30', '40287dd44f8d2acf014f8d3382450001', '10', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ec7ccb0146ec80403b0002', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-06-30 19:19:26', '402881e8465d1e7a01465d22f8e70001', '0', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ec7ccb0146ec8236ca0004', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-06-30 19:21:35', '402881e8465d1e7a01465d22f8e70001', '0', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ec7ccb0146ec8a441d0007', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 19:30:22', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed398d0146ed3c5e5b0001', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 22:44:55', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed3f330146ed4263780001', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 22:51:29', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed3f330146ed42e9b80003', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 22:52:03', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed3f330146ed4352da0005', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 22:52:30', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed64c00146ed68baa40003', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 23:33:22', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed64c00146ed6baeba0006', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 23:36:35', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed72f40146ed73921a0001', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-06-30 23:45:12', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed83840146ed857eaf0001', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-07-01 00:04:47', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e446ed97ed0146eda6fdd70004', '40288ae845df5fe30145df6522c30004', '积分兑换活动', '2014-07-01 00:41:22', '402881e8465d1e7a01465d22f8e70001', '10', '1');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e546e521a30146e521f28e0001', '40288ae845df5fe30145df6522c30004', '签到领取', '2014-06-29 08:59:05', '402881e8465d1e7a01465d22f8e70001', '10', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e546e6592b0146e659f8c70004', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-06-29 14:39:54', '402881e8465d1e7a01465d22f8e70001', '8', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e546e6d0eb0146e6d1ac980004', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-06-29 16:50:39', '402881e8465d1e7a01465d22f8e70001', '8', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e546e70a550146e72bb117000f', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-06-29 18:28:58', '402881e8465d1e7a01465d22f8e70001', '16', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('402881e64b0d2489014b0d3407af0002', '40288ae845df5fe30145df6522c30004', '签到领取', '2015-01-21 23:54:48', '402881e8465d1e7a01465d22f8e70001', '10', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('40289df546f64e7c0146f64f27ad0001', '40288ae845df5fe30145df6522c30004', '签到领取', '2014-07-02 17:02:01', '402881e8465d1e7a01465d22f8e70001', '10', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('40289df5470eb36301470ebd25530002', '40288ae845df5fe30145df6522c30004', '签到领取', '2014-07-07 10:53:02', '402881e8465d1e7a01465d22f8e70001', '10', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('40289df547378c13014737b18e360006', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-07-15 09:44:48', '402881e8465d1e7a01465d22f8e70001', '8', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('40289df54737b4b8014737b555b60002', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-07-15 09:48:56', '402881e8465d1e7a01465d22f8e70001', '4', '0');
INSERT INTO `zjtbl_minweb_integral` VALUES ('40289df547382b980147382c2dfa0002', '40288ae845df5fe30145df6522c30004', '消费获取', '2014-07-15 11:58:45', '402881e8465d1e7a01465d22f8e70001', '4', '0');

-- ----------------------------
-- Table structure for `zjtbl_minweb_integralexchange`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_integralexchange`;
CREATE TABLE `zjtbl_minweb_integralexchange` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `couponid` varchar(32) DEFAULT NULL,
  `description` longtext NOT NULL,
  `intime` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `score` varchar(32) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `type` varchar(10) NOT NULL,
  `validity` datetime DEFAULT NULL,
  `imgurl` longtext,
  `islimit` varchar(10) DEFAULT NULL,
  `activitiesid` varchar(32) DEFAULT NULL,
  `giftid` varchar(32) DEFAULT NULL,
  `memberlevelid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_integralexchange
-- ----------------------------
INSERT INTO `zjtbl_minweb_integralexchange` VALUES ('402881e446ec7ccb0146ec8a1a5e0006', '40288ae845df5fe30145df6522c30004', null, '<p>积分兑换ipad mini2</p>\r\n', '2014-06-30 19:30:12', '积分兑换ipad mini2', '10', '0', '0', '2014-07-11 00:00:00', '/integralexchange/20140630193012183.png', '1', null, '40289df546d752c60146d769973d0001', '1');
INSERT INTO `zjtbl_minweb_integralexchange` VALUES ('402881e446ed64c00146ed689fc60002', '40288ae845df5fe30145df6522c30004', null, '<p>10积分兑换大转盘</p>\r\n', '2014-06-30 23:33:15', '10积分兑换大转盘', '10', '6', '-1', '2014-07-10 00:00:00', '/integralexchange/20140630233315333.png', '1', '402881e446ed64c00146ed6711400001', '', '1');
INSERT INTO `zjtbl_minweb_integralexchange` VALUES ('402881e446ed97ed0146eda6e62c0003', '40288ae845df5fe30145df6522c30004', null, '<p>积分兑换ipad mini2</p>\r\n', '2014-07-01 00:41:16', '积分兑换ipad mini2', '10', '9', '0', '2014-08-01 00:00:00', '/integralexchange/20140701004116569.png', '1', null, '40289df546d752c60146d769973d0001', '1');
INSERT INTO `zjtbl_minweb_integralexchange` VALUES ('402881e546e3182f0146e325a7ec0006', '40288ae845df5fe30145df6522c30004', null, '<p>10积分摇一摇活动兑换！！赶紧参与吧~</p>\r\n', '2014-06-28 23:43:54', '10积分摇一摇活动兑换', '10', '4', '3', '2014-07-04 00:00:00', '/integralexchange/20140628234354347.png', '1', '402881e546e3182f0146e3244ecc0005', '', '2');
INSERT INTO `zjtbl_minweb_integralexchange` VALUES ('402881e546e3353c0146e33ff5070006', '40288ae845df5fe30145df6522c30004', null, '<p>20刮刮卡活动</p>\r\n', '2014-06-29 00:12:38', '20刮刮卡活动', '20', '44', '2', '2014-07-10 00:00:00', '/integralexchange/20140629001238022.png', '1', '402881e546e3353c0146e33db0140004', '', '2');

-- ----------------------------
-- Table structure for `zjtbl_minweb_integralexchangerecord`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_integralexchangerecord`;
CREATE TABLE `zjtbl_minweb_integralexchangerecord` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `integralexchangeid` varchar(32) DEFAULT NULL,
  `isreceive` varchar(32) DEFAULT NULL,
  `isuse` varchar(32) DEFAULT NULL,
  `memberid` varchar(32) DEFAULT NULL,
  `receivetime` varchar(32) DEFAULT NULL,
  `usertime` varchar(32) DEFAULT NULL,
  `activitiesid` varchar(255) DEFAULT NULL,
  `giftid` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_integralexchangerecord
-- ----------------------------
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e2a0ba0146e2a18e9b0002', '40288ae845df5fe30145df6522c30004', 'ff80808146e243cd0146e26c3c900007', '1', '1', 'ff80808146cb82a30146cd3bb65d0009', '2014-06-28 21:19:37', '2014-06-28 21:19:37', '402881e546e3182f0146e3244ecc0005', '40289df546d752c60146d769973d0001', '3');
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e2a3dd0146e2a9122e0005', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2a862ed0003', '1', '1', 'ff808081465db0bb01465f34bc160006', '2014-06-28 21:27:49', '2014-06-28 21:27:49', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e2a3dd0146e2a9610a0008', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2a76dd90002', '1', '1', 'ff808081465db0bb01465f34bc160006', '2014-06-28 21:28:09', '2014-06-28 21:28:09', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e2a3dd0146e2ab72200019', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '0', 'ff808081465db0bb01465f34bc160006', '2014-06-28 21:30:25', '', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e2a3dd0146e2ab84e9001b', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '0', 'ff808081465db0bb01465f34bc160006', '2014-06-28 21:30:29', '', '402881e446ed64c00146ed6711400001', '40289df546d752c60146d769973d0001', '1');
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e2a3dd0146e2ab9e7d001d', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '0', 'ff808081465db0bb01465f34bc160006', '2014-06-28 21:30:36', '', '402881e546e3353c0146e33db0140004', '40289df546d752c60146d769973d0001', '2');
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e2b2e90146e2b4cfca0002', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '0', 'ff80808146cb82a30146cd3bb65d0009', '2014-06-28 21:40:38', '', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e55ae80146e5635a4b0005', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '1', 'ff80808146e37ed10146e38d5ff20007', '2014-06-29 10:10:32', '2014-06-29 10:10:32', '402881e446ed64c00146ed6711400001', '40289df546d752c60146d769973d0001', '1');
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e55ae80146e56644260009', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '1', 'ff80808146e37ed10146e38d5ff20007', '2014-06-29 10:13:43', '2014-06-29 10:13:43', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e55ae80146e5673b0c000b', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2a76dd90002', '1', '1', 'ff80808146e37ed10146e38d5ff20007', '2014-06-29 10:14:46', '2014-06-29 10:14:46', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e7150d0146e7c836540017', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '1', 'ff80808146cb82a30146cd3bb65d0009', '2014-06-29 21:19:56', '2014-06-29 21:19:56', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e7150d0146e7cab02a001a', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '1', 'ff808081465db0bb01465f34bc160006', '2014-06-29 21:22:38', '2014-06-29 21:22:38', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e7150d0146eb9713740025', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '1', 'ff80808146cb82a30146cd3bb65d0009', '2014-06-30 15:04:45', '2014-06-30 15:04:45', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e7150d0146eb97246d0027', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2a862ed0003', '1', '1', 'ff80808146cb82a30146cd3bb65d0009', '2014-06-30 15:04:49', '2014-06-30 15:04:49', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146e7150d0146eb97371b0029', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2a76dd90002', '1', '1', 'ff80808146cb82a30146cd3bb65d0009', '2014-06-30 15:04:54', '2014-06-30 15:04:54', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146ecaa6c0146ecf5adec0004', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2a76dd90002', '1', '1', 'ff80808146c3b0190146c7dff5d1002a', '2014-06-30 21:27:42', '2014-06-30 21:27:42', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146ecaa6c0146ecf5c84e0006', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2a862ed0003', '1', '1', 'ff80808146c3b0190146c7dff5d1002a', '2014-06-30 21:27:49', '2014-06-30 21:27:49', null, null, null);
INSERT INTO `zjtbl_minweb_integralexchangerecord` VALUES ('ff80808146ecaa6c0146ecf5e34f0009', '40288ae845df5fe30145df6522c30004', 'ff80808146e2a3dd0146e2ab0e3e0013', '1', '1', 'ff80808146c3b0190146c7dff5d1002a', '2014-06-30 21:27:55', '2014-06-30 21:27:56', null, null, null);

-- ----------------------------
-- Table structure for `zjtbl_minweb_integralrule`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_integralrule`;
CREATE TABLE `zjtbl_minweb_integralrule` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `integralproportion` varchar(32) NOT NULL,
  `moneyproportion` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_integralrule
-- ----------------------------
INSERT INTO `zjtbl_minweb_integralrule` VALUES ('402881e5466beb4101466beb9cb60001', '40288ae845df5fe30145df6522c30004', '1', '12');

-- ----------------------------
-- Table structure for `zjtbl_minweb_member`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_member`;
CREATE TABLE `zjtbl_minweb_member` (
  `id` varchar(32) NOT NULL,
  `addr_area` varchar(32) DEFAULT NULL,
  `addr_city` varchar(32) DEFAULT NULL,
  `addr_prov` varchar(32) DEFAULT NULL,
  `address` longtext,
  `balance` varchar(32) DEFAULT NULL,
  `birthday` varchar(32) DEFAULT NULL,
  `bizid` varchar(255) NOT NULL,
  `cardno` varchar(10) NOT NULL,
  `integral` varchar(32) DEFAULT NULL,
  `intime` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `openid` varchar(255) NOT NULL,
  `qq` varchar(32) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `telephone` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_member
-- ----------------------------
INSERT INTO `zjtbl_minweb_member` VALUES ('40287dd44f8d2acf014f8d3382450001', '411524', '411500', '410000', 'fdsfa', '0', '1970-1-1', '40288ae845df5fe30145df6522c30004', '800014', '10', '2015-09-02 04:36:47', 'dhf', '40288ae845df5fe30145df6522c30004', '3432432', '1', '1', '13643243243');
INSERT INTO `zjtbl_minweb_member` VALUES ('402881e8465d1e7a01465d22f8e70001', '440307', '440300', '440000', '', '0.0', '1987-5-6', '40288ae845df5fe30145df6522c30004', '800013', '26', '2014-06-02 11:11:51', 'java工程师', '1234', '', '0', '1', '075582010008');

-- ----------------------------
-- Table structure for `zjtbl_minweb_membercard`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_membercard`;
CREATE TABLE `zjtbl_minweb_membercard` (
  `id` varchar(32) NOT NULL,
  `bgurl` longtext,
  `bizid` varchar(255) DEFAULT NULL,
  `cardnoinit` varchar(32) DEFAULT NULL,
  `logourl` longtext,
  `name` varchar(32) DEFAULT NULL,
  `namecolor` varchar(10) DEFAULT NULL,
  `numbercolor` varchar(10) DEFAULT NULL,
  `shopaddress` longtext,
  `shopdescription` longtext NOT NULL,
  `shopname` longtext,
  `shoptelephone` varchar(32) DEFAULT NULL,
  `latitude` varchar(32) DEFAULT NULL,
  `longitude` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_membercard
-- ----------------------------
INSERT INTO `zjtbl_minweb_membercard` VALUES ('1', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120150902163326.png', '40288ae845df5fe30145df6522c30004', '800014', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120150902163332.png', '花儿精品店', '#c4beaf', '#e1ebf2', '深圳福田本元大厦', '商家介绍，需要添加相关说明，一定要添加，记得要添加喔：）\r\n商家介绍，需要添加相关说明，一定要添加，记得要添加喔：）\r\n商家介绍，需要添加相关说明，一定要添加，记得要添加喔：）\r\n商家介绍，需要添加相关说明，一定要添加，记得要添加喔：）\r\n商家介绍，需要添加相关说明，一定要添加，记得要添加喔：）', '花儿精品店', '0755-88308939', '22.564107', '113.937666');

-- ----------------------------
-- Table structure for `zjtbl_minweb_memberlevel`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_memberlevel`;
CREATE TABLE `zjtbl_minweb_memberlevel` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` varchar(32) DEFAULT NULL,
  `integralend` varchar(32) DEFAULT NULL,
  `integralstart` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_memberlevel
-- ----------------------------
INSERT INTO `zjtbl_minweb_memberlevel` VALUES ('1', '40288ae845df5fe30145df6522c30004', '普通会员', '100', '0', '普通会员', '1');
INSERT INTO `zjtbl_minweb_memberlevel` VALUES ('2', '40288ae845df5fe30145df6522c30004', '银卡会员', '500', '101', '银卡会员', '2');
INSERT INTO `zjtbl_minweb_memberlevel` VALUES ('3', '40288ae845df5fe30145df6522c30004', '金卡会员', '1500', '501', '金卡会员', '3');
INSERT INTO `zjtbl_minweb_memberlevel` VALUES ('4', '40288ae845df5fe30145df6522c30004', '钻石会员', '<', '1501', '钻石会员', '4');

-- ----------------------------
-- Table structure for `zjtbl_minweb_membernotice`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_membernotice`;
CREATE TABLE `zjtbl_minweb_membernotice` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` longtext NOT NULL,
  `intime` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_membernotice
-- ----------------------------
INSERT INTO `zjtbl_minweb_membernotice` VALUES ('402881e5467f1cab01467f2239600002', '40288ae845df5fe30145df6522c30004', '<p>j 婆婆有i偶个</p>\r\n\r\n<p>吗</p>\r\n', '2014-06-09 13:38:07', 'oui看');

-- ----------------------------
-- Table structure for `zjtbl_minweb_pagebaseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_pagebaseinfo`;
CREATE TABLE `zjtbl_minweb_pagebaseinfo` (
  `id` varchar(32) NOT NULL,
  `background_url` longtext,
  `bizid` longtext,
  `developer` longtext,
  `dvl_url` longtext,
  `footer` longtext,
  `modelid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_pagebaseinfo
-- ----------------------------
INSERT INTO `zjtbl_minweb_pagebaseinfo` VALUES ('1', 'images/app/zjminweb/background_def.jpg', '40288ae845df5fe30145df6522c30004', '商家广告位（商家口号）', 'http://103.245.209.72/zj/zj/zjminweb/getRetailstoreList.kq', '版权所有 @ 2012-2014', '1');

-- ----------------------------
-- Table structure for `zjtbl_minweb_photo`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_photo`;
CREATE TABLE `zjtbl_minweb_photo` (
  `id` varchar(32) NOT NULL,
  `almid` varchar(255) DEFAULT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `iscovers` varchar(1) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_photo
-- ----------------------------
INSERT INTO `zjtbl_minweb_photo` VALUES ('40289df5470e6d2801470e7b22300001', '402881e8465d8d1b01465d8db9e30001', '40288ae845df5fe30145df6522c30004', '', '0', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140707094055.jpg');
INSERT INTO `zjtbl_minweb_photo` VALUES ('40289df5470e6d2801470e7b58040002', '402881e8465d8d1b01465d8db9e30001', '40288ae845df5fe30145df6522c30004', '', '1', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140707094107.png');

-- ----------------------------
-- Table structure for `zjtbl_minweb_picturetext`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_picturetext`;
CREATE TABLE `zjtbl_minweb_picturetext` (
  `id` varchar(32) NOT NULL,
  `bizid` longtext,
  `description` longtext,
  `picurl` longtext,
  `title` varchar(100) DEFAULT NULL,
  `url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_picturetext
-- ----------------------------
INSERT INTO `zjtbl_minweb_picturetext` VALUES ('40289df546b1b8800146b1e43b030007', '40288ae845df5fe30145df6522c30004', '推荐产品', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140530000921.jpg', '商品展示', 'http://103.245.209.72/zj/zjmall/mlist.kq');
INSERT INTO `zjtbl_minweb_picturetext` VALUES ('40289df546b1b8800146b1e43b150008', '40288ae845df5fe30145df6522c30004', '招聘信息', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140530001000.jpg', '招聘信息', 'http://103.245.209.72/zj/zj/zjminweb/getZhaopinList.kq');
INSERT INTO `zjtbl_minweb_picturetext` VALUES ('40289df546b1b8800146b1e43b170009', '40288ae845df5fe30145df6522c30004', '会员通道', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140530001005.jpg', '会员通道', 'http://103.245.209.72/zj/zj/zjminweb/getMember.kq');
INSERT INTO `zjtbl_minweb_picturetext` VALUES ('40289df546b1b8800146b1e43b19000a', '40288ae845df5fe30145df6522c30004', '微相册', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140530001011.jpg', '微相册', 'http://103.245.209.72/zj/zj/zjminweb/getAlbumList.kq');
INSERT INTO `zjtbl_minweb_picturetext` VALUES ('40289df546b1b8800146b1e43b1a000b', '40288ae845df5fe30145df6522c30004', '交流互动', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140530001015.jpg', '微社区', 'http://wx.wsq.qq.com/248464937');
INSERT INTO `zjtbl_minweb_picturetext` VALUES ('40289df546b1b8800146b1e43b1c000c', '40288ae845df5fe30145df6522c30004', '门店导航', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140531194541.jpg', '微门店', 'http://103.245.209.72/zj/zj/zjminweb/getRetailstoreList.kq');

-- ----------------------------
-- Table structure for `zjtbl_minweb_retailstore`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_retailstore`;
CREATE TABLE `zjtbl_minweb_retailstore` (
  `id` varchar(32) NOT NULL,
  `address` longtext,
  `bizid` varchar(255) DEFAULT NULL,
  `description` longtext,
  `latitude` varchar(32) DEFAULT NULL,
  `longitude` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_retailstore
-- ----------------------------
INSERT INTO `zjtbl_minweb_retailstore` VALUES ('402881e44654f9e9014654fd6d720001', '佛山市南海区fsl佛山照明(上边村东南)', '40288ae845df5fe30145df6522c30004', '专业美甲', '23.071537', '113.080088', '专业美甲', '13855555555', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140602123212.jpg');

-- ----------------------------
-- Table structure for `zjtbl_minweb_salespromotion`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_salespromotion`;
CREATE TABLE `zjtbl_minweb_salespromotion` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `money` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `usablerange` bigint(20) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_salespromotion
-- ----------------------------
INSERT INTO `zjtbl_minweb_salespromotion` VALUES ('402881e546a3e8d40146a3ed17f10002', '40288ae845df5fe30145df6522c30004', '2014-07-01 00:00:00', '20', '充值100送20', '2014-06-03 00:00:00', '1', '0', '100', null);
INSERT INTO `zjtbl_minweb_salespromotion` VALUES ('402881e546a3e8d40146a3edc4180003', '40288ae845df5fe30145df6522c30004', '2014-07-02 00:00:00', '50', '充值200送50', '2014-06-04 00:00:00', '0', '0', '200', null);

-- ----------------------------
-- Table structure for `zjtbl_minweb_scorllpic`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_scorllpic`;
CREATE TABLE `zjtbl_minweb_scorllpic` (
  `id` varchar(32) NOT NULL,
  `bizid` longtext,
  `picurl` longtext,
  `url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_scorllpic
-- ----------------------------
INSERT INTO `zjtbl_minweb_scorllpic` VALUES ('40289df546b1b8800146b1f64dce000d', '40288ae845df5fe30145df6522c30004', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140531194712.jpg', 'http://103.245.209.72/zj/zj/zjminweb/getAlbumList.kq');
INSERT INTO `zjtbl_minweb_scorllpic` VALUES ('40289df546b1b8800146b1f64dd1000e', '40288ae845df5fe30145df6522c30004', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140531194701.jpg', 'http://103.245.209.72/zj/zj/zjminweb/getRetailstoreList.kq');
INSERT INTO `zjtbl_minweb_scorllpic` VALUES ('40289df546b1b8800146b1f64dd5000f', '40288ae845df5fe30145df6522c30004', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140531194711.jpg', 'http://103.245.209.72/zj/zjmall/index.kq');
INSERT INTO `zjtbl_minweb_scorllpic` VALUES ('40289df546b1b8800146b1f64dd70010', '40288ae845df5fe30145df6522c30004', 'upload/msgimages///40288ae845df5fe30145df6522c30004//120140531194723.jpg', 'http://103.245.209.72/zj/zjmall/mlist.kq');

-- ----------------------------
-- Table structure for `zjtbl_minweb_signin`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_signin`;
CREATE TABLE `zjtbl_minweb_signin` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` longtext NOT NULL,
  `intime` datetime DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `path` longtext,
  `status` varchar(10) DEFAULT NULL,
  `url` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_signin
-- ----------------------------
INSERT INTO `zjtbl_minweb_signin` VALUES ('40289df546a8a48f0146a8b7dde30001', '40288ae845df5fe30145df6522c30004', '<p>签到会议</p>\r\n', '2014-06-17 15:25:53', '签到会议', 'signin\\20140617152553394.png', '0', 'http://localhost:8080/weixin//zj/zjminweb/addSigninrecordForward.kq?bid=40288ae845df5fe30145df6522c30004&signinid=40289df546a8a48f0146a8b7dde30001');

-- ----------------------------
-- Table structure for `zjtbl_minweb_signinrecord`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_signinrecord`;
CREATE TABLE `zjtbl_minweb_signinrecord` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `signinid` varchar(32) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_signinrecord
-- ----------------------------
INSERT INTO `zjtbl_minweb_signinrecord` VALUES ('40289df546a8a48f0146a8b9d5830002', '40288ae845df5fe30145df6522c30004', '2014-06-17 15:28:09', 'ä¸ä¸', '40289df546a8a48f0146a8b7dde30001', '13434343434');
INSERT INTO `zjtbl_minweb_signinrecord` VALUES ('40289df546a8c69f0146a8c726550001', '40288ae845df5fe30145df6522c30004', '2014-06-17 15:42:42', '签到会议', '40289df546a8a48f0146a8b7dde30001', '13443434343');

-- ----------------------------
-- Table structure for `zjtbl_minweb_titleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_titleinfo`;
CREATE TABLE `zjtbl_minweb_titleinfo` (
  `id` varchar(32) NOT NULL,
  `anwser_max_num` varchar(2) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `question_name` varchar(100) NOT NULL,
  `relation_diaoyan_id` varchar(255) DEFAULT NULL,
  `selecta` varchar(16) NOT NULL,
  `selectb` varchar(16) NOT NULL,
  `selectc` varchar(16) DEFAULT NULL,
  `selectd` varchar(16) DEFAULT NULL,
  `selecte` varchar(16) DEFAULT NULL,
  `selectf` varchar(16) DEFAULT NULL,
  `selectg` varchar(16) DEFAULT NULL,
  `selecth` varchar(16) DEFAULT NULL,
  `selecti` varchar(16) DEFAULT NULL,
  `selectj` varchar(16) DEFAULT NULL,
  `result_str` varchar(255) DEFAULT NULL,
  `select_aid` varchar(255) DEFAULT NULL,
  `select_ap` varchar(255) DEFAULT NULL,
  `select_atimes` varchar(255) DEFAULT NULL,
  `select_bid` varchar(255) DEFAULT NULL,
  `select_bp` varchar(255) DEFAULT NULL,
  `select_btimes` varchar(255) DEFAULT NULL,
  `select_cid` varchar(255) DEFAULT NULL,
  `select_cp` varchar(255) DEFAULT NULL,
  `select_ctimes` varchar(255) DEFAULT NULL,
  `select_did` varchar(255) DEFAULT NULL,
  `select_dp` varchar(255) DEFAULT NULL,
  `select_dtimes` varchar(255) DEFAULT NULL,
  `select_eid` varchar(255) DEFAULT NULL,
  `select_ep` varchar(255) DEFAULT NULL,
  `select_etimes` varchar(255) DEFAULT NULL,
  `select_fid` varchar(255) DEFAULT NULL,
  `select_fp` varchar(255) DEFAULT NULL,
  `select_ftimes` varchar(255) DEFAULT NULL,
  `select_gid` varchar(255) DEFAULT NULL,
  `select_gp` varchar(255) DEFAULT NULL,
  `select_gtimes` varchar(255) DEFAULT NULL,
  `select_hid` varchar(255) DEFAULT NULL,
  `select_hp` varchar(255) DEFAULT NULL,
  `select_htimes` varchar(255) DEFAULT NULL,
  `select_iid` varchar(255) DEFAULT NULL,
  `select_ip` varchar(255) DEFAULT NULL,
  `select_itimes` varchar(255) DEFAULT NULL,
  `select_jid` varchar(255) DEFAULT NULL,
  `select_jp` varchar(255) DEFAULT NULL,
  `select_jtimes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_titleinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `zjtbl_minweb_titleitems`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_titleitems`;
CREATE TABLE `zjtbl_minweb_titleitems` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `select_name` varchar(255) DEFAULT NULL,
  `selected_times` varchar(255) DEFAULT NULL,
  `title_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_titleitems
-- ----------------------------

-- ----------------------------
-- Table structure for `zjtbl_minweb_wobble_config`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_wobble_config`;
CREATE TABLE `zjtbl_minweb_wobble_config` (
  `id` varchar(32) NOT NULL,
  `illustrate` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_wobble_config
-- ----------------------------
INSERT INTO `zjtbl_minweb_wobble_config` VALUES ('40289df546d2b6d60146d2b7d9ef0001', '初始可抽奖次数', '1', 'number', '2');

-- ----------------------------
-- Table structure for `zjtbl_minweb_wobble_prize`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_wobble_prize`;
CREATE TABLE `zjtbl_minweb_wobble_prize` (
  `id` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isprize` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `v` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `giftid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_wobble_prize
-- ----------------------------
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('1', '40288ae845df5fe30145df6522c30004', '一等奖中奖提示信息', '1', '一等奖', '90', '8', '40289df546d752c60146d769973d0001');
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('2', '40288ae845df5fe30145df6522c30004', '二等奖中奖提示信息', '0', '二等奖', '9', '0', '');
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('3', '40288ae845df5fe30145df6522c30004', '三等奖中奖提示信息', '0', '三等奖', '1', '0', '');
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('4', '40288ae845df5fe30145df6522c30004', '', '0', '', '0', '0', '');
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('5', '40288ae845df5fe30145df6522c30004', '', '0', '', '0', '0', '');
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('6', '40288ae845df5fe30145df6522c30004', '', '0', '', '0', '0', '');
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('7', '40288ae845df5fe30145df6522c30004', '', '0', '', '0', '0', '');
INSERT INTO `zjtbl_minweb_wobble_prize` VALUES ('8', '40288ae845df5fe30145df6522c30004', '', '0', '', '0', '0', '');

-- ----------------------------
-- Table structure for `zjtbl_minweb_wobble_prizerecord`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_wobble_prizerecord`;
CREATE TABLE `zjtbl_minweb_wobble_prizerecord` (
  `id` varchar(32) NOT NULL,
  `activitiesid` varchar(255) DEFAULT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `isprizes` int(11) DEFAULT NULL,
  `isreg` int(11) DEFAULT NULL,
  `mobilephone` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `prizeid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_wobble_prizerecord
-- ----------------------------
INSERT INTO `zjtbl_minweb_wobble_prizerecord` VALUES ('402881e446ed3f330146ed491d690009', '402881e546e3182f0146e3244ecc0005', '40288ae845df5fe30145df6522c30004', '1', '1', null, null, '0', '1234', '1');

-- ----------------------------
-- Table structure for `zjtbl_minweb_zhaopin`
-- ----------------------------
DROP TABLE IF EXISTS `zjtbl_minweb_zhaopin`;
CREATE TABLE `zjtbl_minweb_zhaopin` (
  `id` varchar(32) NOT NULL,
  `age` varchar(32) NOT NULL,
  `bizid` varchar(255) DEFAULT NULL,
  `description` longtext NOT NULL,
  `education` varchar(10) NOT NULL,
  `endtime` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `numbers` varchar(100) NOT NULL,
  `pay` varchar(100) NOT NULL,
  `sex` varchar(32) NOT NULL,
  `workingnum` varchar(100) NOT NULL,
  `workingplace` varchar(100) NOT NULL,
  `workingtype` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zjtbl_minweb_zhaopin
-- ----------------------------
INSERT INTO `zjtbl_minweb_zhaopin` VALUES ('402881e446515c1d01465165ee390001', '20Ã¤Â»Â¥Ã¤Â¸Â', '40288ae845df5fe30145df6522c30004', '<div>\r\n<div>1&atilde;&Acirc;Â&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&ccedil;&Acirc;Â&micro;&aring;&shy;&Acirc;Â&auml;&frac14;&Acirc;Â&auml;&cedil;&Acirc;Â&ccedil;&Acirc;Â&Acirc;Â1&aring;&sup1;&acute;&auml;&raquo;&yen;&auml;&cedil;&Acirc;Â&eacute;&Acirc;Â&Acirc;Â&egrave;&acute;&shy;&ccedil;&raquo;&Acirc;Â&eacute;&ordf;&Acirc;Â&iuml;&frac14;&Acirc;Â<br />\r\n2&atilde;&Acirc;Â&Acirc;Â&aring;&macr;&sup1;&ccedil;&Acirc;Â&micro;&aring;&shy;&Acirc;Â&aring;&Acirc;Â&Acirc;Â&aring;&Acirc;Â&uml;&auml;&raquo;&para;&atilde;&Acirc;Â&Acirc;Â&auml;&ordm;&Acirc;Â&eacute;&Acirc;Â&Acirc;Â&auml;&raquo;&para;&atilde;&Acirc;Â&Acirc;Â&aring;&iexcl;&Acirc;Â&egrave;&Acirc;Â&para;&auml;&raquo;&para;&ccedil;&shy;&Acirc;Â&aring;&Acirc;Â&ordm;&ccedil;&iexcl;&Acirc;Â&ccedil;&Acirc;Â&yen;&egrave;&macr;&Acirc;Â&iuml;&frac14;&Acirc;Â<br />\r\n3&atilde;&Acirc;Â&Acirc;Â&ccedil;&Acirc;Â&Acirc;Â&ccedil;&raquo;&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&auml;&frac12;&Acirc;Â&ccedil;&Acirc;Â&micro;&egrave;&Acirc;Â&Acirc;Â&iuml;&frac14;&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&aelig;&Acirc;Â&iexcl;Office2003&aring;&Acirc;Â&Acirc;Â&aring;&Acirc;Â&not;&egrave;&frac12;&macr;&auml;&raquo;&para;;<br />\r\n4&atilde;&Acirc;Â&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&aring;&shy;&Acirc;Â&aring;&Acirc;Â&Acirc;Â&auml;&frac12;&Acirc;Â&egrave;&Acirc;Â&frac12;&aring;&Acirc;Â&Acirc;Â&aring;&frac14;&ordm;&iuml;&frac14;&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&egrave;&frac34;&Acirc;Â&aring;&frac14;&ordm;&ccedil;&Acirc;Â&Acirc;Â&aring;&middot;&yen;&auml;&frac12;&Acirc;Â&ccedil;&raquo;&Acirc;Â&ccedil;&raquo;&Acirc;Â&egrave;&Acirc;Â&frac12;&aring;&Acirc;Â&Acirc;Â&iuml;&frac14;&Acirc;Â&ccedil;&Acirc;Â&not;&ccedil;&laquo;&Acirc;Â&aring;&middot;&yen;&auml;&frac12;&Acirc;Â&egrave;&Acirc;Â&frac12;&aring;&Acirc;Â&Acirc;Â&aring;&frac14;&ordm;&iuml;&frac14;&Acirc;Â<br />\r\n5&atilde;&Acirc;Â&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&egrave;&frac34;&Acirc;Â&aring;&frac14;&ordm;&ccedil;&Acirc;Â&Acirc;Â&egrave;&acute;&pound;&auml;&raquo;&raquo;&aring;&iquest;&Acirc;Â&aring;&Acirc;Â&Acirc;Â&egrave;&Acirc;Â&macr;&aring;&yen;&frac12;&ccedil;&Acirc;Â&Acirc;Â&egrave;&Acirc;Â&Acirc;Â&auml;&cedil;&Acirc;Â&ccedil;&acute;&nbsp;&egrave;&acute;&uml;.<br />\r\n6&atilde;&Acirc;Â&Acirc;Â&aelig;&Acirc;Â&sect;&aelig;&nbsp;&frac14;&aring;&frac14;&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&iuml;&frac14;&Acirc;Â&aelig;&Acirc;Â&reg;&eacute;&Acirc;Â&Acirc;Â&egrave;&macr;&Acirc;Â&aelig;&nbsp;&Acirc;Â&aring;&Acirc;Â&Acirc;Â&iuml;&frac14;&Acirc;Â&egrave;&Acirc;Â&frac12;&egrave;&frac34;&Acirc;Â&aring;&yen;&frac12;&ccedil;&Acirc;Â&Acirc;Â&aring;&curren;&Acirc;Â&ccedil;&Acirc;Â&Acirc;Â&auml;&cedil;&Acirc;Â&auml;&raquo;&Acirc;Â&auml;&ordm;&ordm;&ccedil;&Acirc;Â&Acirc;Â&aring;&Acirc;Â&sup3;&ccedil;&sup3;&raquo;<br />\r\n7&atilde;&Acirc;Â&Acirc;Â&auml;&cedil;&ordm;&auml;&ordm;&ordm;&egrave;&macr;&Acirc;Â&aring;&reg;&Acirc;Â&iuml;&frac14;&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&auml;&raquo;&Acirc;Â&aring;&reg;&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&iuml;&frac14;&Acirc;Â&aelig;&Acirc;Â&Acirc;Â&aring;&Acirc;Â&cent;&eacute;&Acirc;Â&Acirc;Â&aring;&Acirc;Â&Acirc;Â&auml;&frac12;&Acirc;Â&ccedil;&sup2;&frac34;&ccedil;&yen;&Acirc;Â&atilde;&Acirc;Â&Acirc;Â&nbsp;</div>\r\n\r\n<div>&aring;&Acirc;Â&Acirc;Â&aring;&Acirc;Â&Acirc;Â&aring;&curren;&Acirc;Â&aring;&curren;&Acirc;Â&aring;&Acirc;Â&Acirc;Â&aring;&Acirc;Â&Acirc;Â&aring;&curren;&Acirc;Â&aring;&curren;&Acirc;Âfff wewe&auml;&ordm;&ordm;&auml;&ordm;&ordm;&auml;&ordm;&ordm;&auml;&ordm;&ordm;</div>\r\n</div>\r\n', '1', '2014-06-07', 'javaå·¥ç¨å¸', '5ÃÂ¤ÃÂºÃÂºÃÂ¤ÃÂ»ÃÂ¥ÃÂ¤ÃÂ¸ÃÂ', '3000~10000', '1', '2ÃÂ¥ÃÂ¹ÃÂ´ÃÂ¤ÃÂ»ÃÂ¥ÃÂ¤ÃÂ¸ÃÂ', 'Ã¥Â¹Â¿Ã¤Â¸ÂÃ¦Â·Â±Ã¥ÂÂ³', '1');

-- ----------------------------
-- Table structure for `zxtbl_mall_user`
-- ----------------------------
DROP TABLE IF EXISTS `zxtbl_mall_user`;
CREATE TABLE `zxtbl_mall_user` (
  `id` varchar(32) NOT NULL,
  `addtime` varchar(64) DEFAULT NULL,
  `bid` varchar(32) DEFAULT NULL,
  `extid` varchar(128) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `mail` varchar(96) DEFAULT NULL,
  `pwd` varchar(64) DEFAULT NULL,
  `status` varchar(16) DEFAULT NULL,
  `uname` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zxtbl_mall_user
-- ----------------------------
