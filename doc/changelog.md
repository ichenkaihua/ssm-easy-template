# 修改日志
* 2015-12-24 --v2.0
    * 集成 flyway到gradle中，用于数据库迁移
    * 修改 数据库配置全部读取`src/main/resources/db-mysql.properties`
    * 集成 `mybatis generator`在gradle中，用于生成mybatis mapper等java类
    * 更新 mybatis分页插件(`com.github.pagehelper:pagehelper`)到`4.0.0`版本
    * 更新 mybatis通用插件(`tk.mybatis:mapper:3.3.1`)到`3.3.1` 版本
    * 更新 删除`BseService`,`servervice`和`mapper`并不是一一对等的
    * 添加 `HomController`首页映射至`WEB-INF/index.jsp`