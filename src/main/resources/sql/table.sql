CREATE TABLE `tbl_encrypt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `phone_assist` varchar(64) DEFAULT NULL COMMENT '手机号码辅助查询列',
  `phone_encrypt` varchar(100) DEFAULT NULL COMMENT '手机号码加密',
  `idcard` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `idcard_assist` varchar(64) DEFAULT NULL COMMENT '身份证号码辅助查询列',
  `idcard_encrypt` varchar(100) DEFAULT NULL COMMENT '身份证号码加密',
  `img` varchar(200) DEFAULT NULL COMMENT '图片',
  `education` tinyint(11) DEFAULT NULL COMMENT '学历：1小学，2初中，3高中，4本科，5研究生',
  `enterprise` varchar(64) DEFAULT NULL COMMENT '就职企业',
  `height` int(11) DEFAULT NULL COMMENT '身高(cm)',
  `weight` int(11) DEFAULT NULL COMMENT '体重(kg)',
  `nation` int(11) DEFAULT NULL COMMENT '民族：1汉族，2少数民族',
  `country` int(11) DEFAULT NULL COMMENT '国家：1中国，2外国',
  `is_del` tinyint(4) DEFAULT '0' COMMENT '是否已删除：0否，1是',
  PRIMARY KEY (`id`)
);


CREATE TABLE `tbl0` (
  `id` bigint(64) DEFAULT NULL COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `description` varchar(32) DEFAULT NULL COMMENT '描述'
);


CREATE TABLE `tbl1` (
  `id` bigint(64) DEFAULT NULL COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `description` varchar(32) DEFAULT NULL COMMENT '描述'
);

