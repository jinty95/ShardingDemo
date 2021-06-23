CREATE TABLE `tbl_user` (
  `euser_id` varchar(64) NOT NULL COMMENT '企业用户ID',
  `enterprise_id` varchar(64) NOT NULL COMMENT '企业ID',
  `department_id` varchar(64) DEFAULT NULL COMMENT '部门ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `mobile` varchar(30) NOT NULL COMMENT '手机',
  `mobile_encrypt` varchar(64) DEFAULT NULL COMMENT '手机(加密)',
  `area_code` varchar(10) DEFAULT '+86' COMMENT '用于存储手机的国际区号',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `gender` tinyint(1) DEFAULT '0' COMMENT '性别:0未知，1男，2女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `identityCard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `politics` varchar(30) DEFAULT NULL COMMENT '政治面貌',
  `position` varchar(100) DEFAULT NULL COMMENT '职位',
  `employee_no` varchar(100) DEFAULT NULL COMMENT '员工号',
  `create_user_id` varchar(64) NOT NULL COMMENT '创建用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user_id` varchar(64) NOT NULL COMMENT '更新用户ID',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`enterprise_id`,`euser_id`),
  UNIQUE KEY `unique_euser` (`enterprise_id`,`user_id`) USING BTREE,
  KEY `euser_id` (`euser_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `employee_no` (`enterprise_id`,`employee_no`) USING BTREE,
  KEY `mobile` (`enterprise_id`,`mobile`)
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


/*
  tbl_user表 mobile字段 存量数据加密(MySQL5.6以上支持AES加密)
*/
UPDATE tbl_user
SET mobile_encrypt = TO_BASE64(AES_ENCRYPT(mobile,FROM_BASE64('eoyiq5vCJKfzZDvER5mNBQ==')))
WHERE mobile_encrypt IS NULL;

