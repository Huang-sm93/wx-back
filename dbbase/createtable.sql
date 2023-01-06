/* 请确认以下SQL符合您的变更需求，务必确认无误后再提交执行 */

CREATE TABLE `wx_user` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                           `name` varchar(20) CHARACTER SET gb2312 NOT NULL,
                           `last_login` date NULL,
                           `sex` varchar(1) NOT NULL DEFAULT 'M' COMMENT '性别 男M 女W 默认值M',
                           `enabled_flag` varchar(1) NOT NULL DEFAULT 'Y' COMMENT '有效标识',
                           PRIMARY KEY (`id`,`sex`,`enabled_flag`)
) ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
COMMENT='微信用户表';
