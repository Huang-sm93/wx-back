/* 请确认以下SQL符合您的变更需求，务必确认无误后再提交执行 */

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
  `phone_number` varchar(20) NOT NULL COMMENT '手机号',
  `birthday` date DEFAULT NULL,
  `sex` varchar(1) NOT NULL DEFAULT 'M' COMMENT '性别 男M 女W 默认值M',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `enabled_flag` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效标识',
  `last_login` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户表';


-- my_account.user_account definition
CREATE TABLE `user_account` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT 'id',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `enabled_flag` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户账本';