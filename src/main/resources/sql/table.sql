/*
    分片0
*/
CREATE TABLE `tbl0` (
  `id` bigint(64) DEFAULT NULL COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `description` varchar(32) DEFAULT NULL COMMENT '描述'
);


/*
    分片1
*/
CREATE TABLE `tbl1` (
  `id` bigint(64) DEFAULT NULL COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `description` varchar(32) DEFAULT NULL COMMENT '描述'
);


/*
    用户表
*/
CREATE TABLE `tbl_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `mobile` varchar(30) NOT NULL COMMENT '手机号码',
  `mobile_encrypt` varchar(64) DEFAULT NULL COMMENT '手机号码(加密)',
  `area_code` varchar(10) DEFAULT '+86' COMMENT '手机国际区号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `gender` tinyint(1) DEFAULT '0' COMMENT '性别:0未知，1男，2女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `id_card_encrypt` varchar(64) DEFAULT NULL COMMENT '身份证号码(加密)',
  `enterprise_id` bigint(20) NOT NULL COMMENT '用户所属企业ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
);


/*
    企业表
*/
CREATE TABLE `tbl_enterprise` (
   `enterprise_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业ID',
   `enterprise_name` varchar(64) NOT NULL COMMENT '企业名称',
   `contact` varchar(20) NOT NULL COMMENT '联系人',
   `contact_mobile` varchar(20) NOT NULL COMMENT '联系人手机号码',
   `contact_mobile_encrypt` varchar(64) NULL COMMENT '联系人手机号码(加密)',
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`enterprise_id`)
);


/*
    存量数据加密处理
*/
UPDATE tbl_user SET mobile_encrypt = TO_BASE64(AES_ENCRYPT(mobile,FROM_BASE64('eoyiq5vCJKfzZDvER5mNBQ=='))) WHERE mobile_encrypt IS NULL;
UPDATE tbl_user SET id_card_encrypt = TO_BASE64(AES_ENCRYPT(id_card,FROM_BASE64('eoyiq5vCJKfzZDvER5mNBQ=='))) WHERE id_card_encrypt IS NULL;
UPDATE tbl_enterprise SET contact_mobile_encrypt = TO_BASE64(AES_ENCRYPT(contact_mobile,FROM_BASE64('eoyiq5vCJKfzZDvER5mNBQ=='))) WHERE contact_mobile_encrypt IS NULL;

