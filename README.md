# 通用模块


### 组织结构
```
common-starter
├── sql -- 静态资源：sql脚本
├── common-center -- 工具类及通用代码
├── auth-center -- 权限中心
├── resource-center -- 资源服务中心 资源服务例子
```

#### 后端技术

| 技术                 | 说明                | 官网                                                 |
| -------------------- | ------------------- | ---------------------------------------------------- |
| SpringBoot           | 容器+MVC框架        | https://spring.io/projects/spring-boot               |
| SpringSecurity       | 认证和授权框架      | https://spring.io/projects/spring-security           |
| MyBatis              | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisGenerator     | 数据层代码生成      | http://www.mybatis.org/generator/index.html          |
| PageHelper           | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper       |
| Swagger-UI           | 文档生产工具        | https://github.com/swagger-api/swagger-ui            |
| Hibernator-Validator | 验证框架            | http://hibernate.org/validator                       |
| Druid                | 数据库连接池        | https://github.com/alibaba/druid                     |
| JWT                  | JWT登录支持         | https://github.com/jwtk/jjwt                         |
| Lombok               | 简化对象封装工具    | https://github.com/rzwitserloot/lombok               |


### 开发工具
| 工具          | 说明                | 官网                                            |
| ------------- | ------------------- | ----------------------------------------------- |
| IDEA          | 开发IDE             | https://www.jetbrains.com/idea/download         |
| Navicat       | 数据库连接工具      | http://www.formysql.com/xiazai.html             |
| Postman       | API接口调试工具      | https://www.postman.com/                        |


### 开发环境
| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 8.0.19 | https://www.mysql.com/                                       |


### 测试
启动后台，登陆接口 http://localhost:8111/admin/login
```$xslt
Content-Type application/json
{
    "username":"admin",
    "password":"123456"
}
```
