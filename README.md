# ssm-easy-template
[TOC]

1.[组成](#组成)
2.
3.
## 介绍
**ssm-easy-template** 是一个j2ee项目快速开发脚手架，集成了最常用的框架,适用于`restfull` 架构风格`web service`接口开发。

####组成
#####主要框架
* **Spring**: 不多说，貌似j2ee离不开他了。
* **SpringMVC**: 与spring无缝集成，简单灵活，支持restful风格。
* **Mybatis** :个人认为比hibernate好控制，毕竟是自己写的sql语句。
* **Shiro**: apache的权限管理框架，扩展性好，使用简单，个人认为比`Spring-Security`框架容易入手。

#####工具框架
* **Spring-Test** :包括了常用单元测试、集成测试、web测试，`src/test/java`下有几个简单的测试类。使用测试框架的好处就是节省时间，无需启动server就能测试程序。
* **Mybatis-PageHelper** :mybatis的分页排序插件，由国人开发，用起来非常方便，[Mybatis-PageHelperp][2]项目主页。
* **MyBatis通用Mapper3** 也是有上面作者开发，极其方便的使用MyBatis单表的增删改查，如果是单表操作，基本不用写mapper文件,[MyBatis通用Mapper3][3]项目主页。

####开发工具
#####IDE
eclipse确实强大，但 [Intellij IDEA][1] 更智能，强烈推荐 **IDEA**
#####依赖管理工具
`maven`可能更容易上手，但我更喜欢`gradle`的简洁


## 使用
## 关于我
  [1]:https://www.jetbrains.com/idea/
 [2]: https://github.com/pagehelper/Mybatis-PageHelper
[3]:https://github.com/abel533/Mapper