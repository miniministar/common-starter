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

### 部署说明
1. pom依赖
```java
  <!--通用模块-->
    <dependency>
        <groupId>com.kaopudian</groupId>
        <artifactId>common-core</artifactId>
        <version>${kpd-common.version}</version>
    </dependency>
    <!--安全模块-->
    <dependency>
        <groupId>com.kaopudian</groupId>
        <artifactId>auth-security</artifactId>
        <version>${kpd-common.version}</version>
    </dependency>
```

2. yml配置
```$xslt
# 项目相关配置
project-config:
  # 名称
  name: xxx
  # 版本
  version: 1.0.0
  # 版权年份
  copyrightYear: 2021
  # 实例演示开关
  demoEnabled: true
  # 文件路径 示例（ Windows配置C:/uploadPath，Linux配置 /home/uploadPath）
  profile: /uploadPath
  # 获取ip地址开关
  addressEnabled: false
  # 验证码类型 math 数组计算 char 字符验证
  captchaType: math

spring:
  application:
    name: zhanyigeli-api
  profiles:
    active: dev #默认为开发环境
  servlet:
    multipart:
      enabled: true #开启文件上传
      max-file-size: 1024MB #限制文件上传大小为10M
  jackson:
    time-zone: GMT+8
    date-format: yyyy-MM-dd HH:mm:ss

mybatis:
  mapper-locations:
    - classpath:dao/*.xml
    - classpath*:com/**/mapper/*.xml

securityconfig:
  #安全认证
  auth:
    #jwt加密盐值
    jwtSalt: PytMg@abc
    # 请求头 - token
    requestHeader: Authorization
    # token过期时间（分钟）
    tokenExpireTime: 120
    # 用户默认密码
    defaultPwd: 123456
    #    # 密码加密 盐值
    #    salt: PytMg
    #    # 密码相关 通过SHA1对密码进行编码
    #    hashIterations: 1
    # 用户选择保存登录状态对应token过期时间（天）, 暂时未实现
    saveLoginTime: 7
    # 限制用户登陆错误次数（次）, 暂时未实现
    loginTimeLimit: 10
    # 错误超过次数后多少分钟后才能继续登录（分钟）, 暂时未实现
    loginAfterTime: 10
    ignoreUrls:
      - "/swagger-ui.html"
      - "/swagger-resources/**"
      - "/swagger/**"
      - "/webjars/springfox-swagger-ui/**"
      - "/**/v2/api-docs"
      - "/**/*.js"
      - "/**/*.css"
      - "/**/*.png"
      - "/**/*.ico"
      - "/actuator/**"
      - "/druid/**"
      - "/login"
      - "/socket/**"
```
3. 项目结构

   启动类必须扫描到com.kaopudian包

   ![image](https://github.com/miniministar/common-starter/blob/master/resources/images/image-20210207143008149.png)


### 测试
启动后台，登陆接口 http://localhost:8111/login
```$xslt
Content-Type application/json
{
    "username":"admin",
    "password":"123456"
}
```
