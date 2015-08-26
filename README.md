# ssm-easy-template

## 介绍
**Ssm-Easy-Template** 是一个J2Ee项目快速开发脚手架，集成了最常用的框架,适用于`Restfull` 架构风格`Web Service`接口开发。

####组成
#####主要框架
* **Spring**: 不多说，貌似J2Ee离不开他了。
* **Springmvc**: 与Spring无缝集成，简单灵活，支持Restful风格。
* **Mybatis** :个人认为比Hibernate好控制，毕竟是自己写的Sql语句。
* **Shiro**: Apache的权限管理框架，扩展性好，使用简单，个人认为比`Spring-Security`框架容易入手。
* **tomcat连接池** : 稳定，性能好。
* **sf4j** ：支持多种日志系统，使用的是log4j。

#####工具框架
* **Spring-Test** :包括了常用单元测试、集成测试、Web测试，`Src/Test/Java`下有几个简单的测试类。使用测试框架的好处就是节省时间，无需启动Server就能测试程序。
* **Mybatis-Pagehelper** :Mybatis的分页排序插件，由国人开发，用起来非常方便，[Mybatis-Pagehelperp][2]项目主页。
* **Mybatis通用Mapper3** 也是有上面作者开发，极其方便的使用Mybatis单表的增删改查，如果是单表操作，基本不用写Mapper文件,[Mybatis通用Mapper3][3]项目主页。
* **Spring-Mail**： 可修改`/src/main/resource/mail-config.properties`配置文件，这个配置文件配置的是主邮箱。
* **commons fileupload**:`spring mvc`中集成了`appache-commons-fileupload`上传组件。上传处理更便捷。


####开发工具
#####IDE
Eclipse确实强大，但 [Intellij Idea][1] 更智能，强烈推荐 **Idea**
#####依赖管理工具
`Maven`可能更容易上手，但我更喜欢`Gradle`的简洁

## 使用
####下载
`Download Zip`或者`git clone`
``` shell
	git clone https://www.github.com/ichenkaihua/ssm-easy-template.git
```
####导入
建议使用IDEA，如果使用eclipse，请搜索gradle的eclipse插件用法
####修改
*  **数据库修改**，修改`src/main/resource/jdbc-mysql.properties`和`/src/main/resource/generatorConfig.xml`前者程序运行时读取，后者是为了使用mybatis Generator，将会根据数据库的表生成实体类和mappr。具体请看[Mybatis通用Mapper3][3]介绍
*  **根据数据库表生成model和mapper**。修改好数据库后，打开 `/sr/test/java/MybatisGenerator`右键-->Run MybatisGenerotor,之后可以看到`com.github.ichenkaihua.model`包和`com.github.ichenkaihua.mapper`包下就生成了数据库表对应的实体类和mapper，`src/main/resource/mybatis_mapper`资源文件夹下生成了XxxMapper.xml映射文件。
* **写通用逻辑** 一般一个模块都是`controlle`r+`service`+`mapper`，其中`service`已经有了`IService`接口和`BaseService`抽象类封装，常用单表操作只需继承`BaseService`就已经实现，具体请看`com.github.ichenkaihua.service.impl.Userservice`实现。对于`mapper`包下类，由于使用了[Mybatis通用Mapper3][3]插件，单表操作无需我们写接口，涉及多表联合时，需要在相应mapper类下写接口，然后在`/resource/mybatis_mapper/XxxMapper.xml`写映射实现。具体请查阅Mybatis官方文档

####部署
`Tomcat`或者`Jetty`都行，只需要配置 IDEA的 `run config`
## 关于我
**博客链接**:[陈开华的博客][3]

**Email**: admin@chenkaihua.com
  [1]:https://www.jetbrains.com/idea/
 [2]: https://github.com/pagehelper/Mybatis-PageHelper
[3]:https://github.com/abel533/Mapper
[4]:http://www.chenkaihua.com