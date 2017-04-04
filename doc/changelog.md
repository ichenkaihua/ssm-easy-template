# 修改日志

* 2017-4-4 --v3.0
    * 更新`spring`版本到最新`4.3.7.release`
    * 更新`mysql-connector-java`版本到`6.0.6`
    * 更新一系列依赖到最新版本
    
* 2016-5-15 --v2.2
    * 集成 `spring-fox`, `swagger2`,自动生产restApi文档，开启应用即可浏览
    * 集成 `asciidoctor`,一键生成restApi的`html`和`pdf`格式文档
    * 集成 `rest-assured`，并提供demo，结合`spring-mvc-test`框架使用，测试rest接口更简单


* 2016-4-18 --v2.1
    * 添加 gradle切换开发环境功能
    * 更新`spring`版本到最新`4.2.5.release`
    * 更新`mybatis`到`1.3.0`版本
    * 更新`tomcat-jdbc`到`8.0.33`版本
    * 其他依赖更新到新版
    * 更新`flydb`插件到`4.0`版本

* 2015-12-24 --v2.0
    * 集成 flyway到gradle中，用于数据库迁移
    * 修改 数据库配置全部读取`src/main/resources/db-mysql.properties`
    * 集成 `mybatis generator`在gradle中，用于生成mybatis mapper等java类
    * 更新 mybatis分页插件(`com.github.pagehelper:pagehelper`)到`4.0.0`版本
    * 更新 mybatis通用插件(`tk.mybatis:mapper:3.3.1`)到`3.3.1` 版本
    * 更新 删除`BseService`,`servervice`和`mapper`并不是一一对等的
    * 添加 `HomController`首页映射至`WEB-INF/index.jsp`
    
