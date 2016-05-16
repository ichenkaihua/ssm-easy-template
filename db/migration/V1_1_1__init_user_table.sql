CREATE TABLE `user` (
  `id`                    int(11) NOT NULL AUTO_INCREMENT                     COMMENT '用户id,自增长',
  `name`                  char(40) DEFAULT NULL                               COMMENT '用户名',
  `password`              char(50) DEFAULT NULL                               COMMENT '密码',
 CONSTRAINT PRIMARY KEY (`id`)
) COMMENT '用户表';

INSERT INTO `user` VALUES (1,'chenkaihua','chenkaihua');
INSERT INTO `user` VALUES   (2,'test_user','test');
INSERT INTO `user` VALUES (3,'陈开华','mypassword');
INSERT INTO `user` VALUES (6,'myname','mypass');
INSERT INTO `user` VALUES (7,'chenhua','chss');


