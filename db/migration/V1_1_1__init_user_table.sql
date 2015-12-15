CREATE TABLE `user` (
  `id`                    int(11) NOT NULL AUTO_INCREMENT,
  `name`                  char(40) DEFAULT NULL,
  `password`              char(50) DEFAULT NULL,
 CONSTRAINT PRIMARY KEY (`id`)
) ;

INSERT INTO `user` VALUES (1,'chenkaihua','chenkaihua');
INSERT INTO `user` VALUES   (2,'test_user','test');
INSERT INTO `user` VALUES (3,'陈开华','mypassword');
INSERT INTO `user` VALUES (6,'myname','mypass');
INSERT INTO `user` VALUES (7,'chenhua','chss');


