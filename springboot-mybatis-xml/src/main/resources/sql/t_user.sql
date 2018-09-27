-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(128) DEFAULT '' COMMENT '密码',
  `name` varchar(16) DEFAULT '' COMMENT '名字',
  `phone` varchar(32) DEFAULT '' COMMENT '联系电话',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态 1:正常 2:禁用',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'zxc12321312313', '123456', '系统管理员', '13912345678', 1, '2017-12-12 09:46:12', '2018-09-27 18:28:38');
INSERT INTO `t_user` VALUES (3, 'abcd', 'aaa', '小明', '123456789', 1, '2018-09-27 14:56:18', '2018-09-27 14:56:18');
INSERT INTO `t_user` VALUES (4, 'zxc12321312313', '2323', '中国', '11111', 0, '2018-09-27 14:59:46', '2018-09-27 18:28:08');
INSERT INTO `t_user` VALUES (5, '123', '2323', '中国', '11111', 0, '2018-09-27 15:51:13', '2018-09-27 15:51:13');
COMMIT;