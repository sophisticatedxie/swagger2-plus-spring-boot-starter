# swagger2-plus-spring-boot-starter
![输入图片说明](https://img.shields.io/badge/license-Apache--2.0-blue "在这里输入图片标题") ![输入图片说明](https://img.shields.io/badge/maven-1.0.0-green "在这里输入图片标题") ![输入图片说明](https://img.shields.io/badge/Prs-welcome-red "在这里输入图片标题")


## 一、开发前阅读

##  更新日志

##v1.0.1(时间: 2020-11-17)
##新特性

1.支持springboot多环境启用swagger

2.解决无group导致原先接口rest接口请求报错

3.更换了UI界面，更为简洁美观



##v1.0.0(时间: 2020-5-10)
##新特性

1.初代swagger自动装配

2.注解和配置文件双方式




## 1.涉及技术
>springboot
>
>swagger2
>
>knife4j
>
>vue


------------

## 2.安装使用

2.1 前往maven repo [maven中央仓库](https://search.maven.org/)搜索 sophisticatedxie 

maven玩家的pom写法:
```maven
<dependency>
  <groupId>com.github.sophisticatedxie</groupId>
  <artifactId>swagger2-plus-spring-boot-starter</artifactId>
  <version>1.0.0.RELEASE</version>
</dependency>

```
重新导入依赖即可。

gradle 玩家写法如下自行在仓库搜索对应写法。

## 3.涉及包结构

```javascript
 |-swagger2-plus-spring-boot-starter                   
	|-com.github.sophisticatedxie      权限模块
	 |-annotations  启动注解 
         |-autoconfig  自动装配
         |-swagger      配置类
```

## 4.已完成/待完成
4.1 已完成


| 任务 | 完成时间 | 存在缺陷 |
| ------ | ------ | ------ |
|基本框架搭建 | 2020/4/3 | 无 |
| swagger2初代starter | 2020/5/3  | 无 |
| 使用knife4j增强UI    |  2020/6/3  | 无   |
| 支持springboot多环境    |  2020/11/17  | 无   |
| 支持微服务多分组    |  2020/11/17  | 无   |

4.2 未完成

| 任务 | 预计开始 | 预计完成 |
| ------ | ------ | ------ |
| 国际化 | |  |
| 移动端自适应UI | |  |


## 5.使用说明
### 5.1 主应用类注解
 springboot主应用启动类上加上注解@EnableApiDocument,配上关于你项目的信息即可，如下:
 ```java
 @SpringBootApplication
 @EnableApiDocument(title = "后台管理系统api文档",description = "swagger2-plus",groupName = "front",version = "1.0",profiles={"dev","test"})
 public class SecurityApplication {
     public static void main(String[] args){
         SpringApplication.run(SecurityApplication.class,args);
     }
 
 }
 ```
EnableApiDocument几个参数说明:

active: 布尔值  true 开启swagger  false 不开启

title：api文档标题

description：文档描述

basePackages： 扫描包路径(不写默认从主应用启动类及其子孙包)

groupName:分组名称

version:版本号

termsOfServiceUrl： 项目生产环境或者实际地址

profiles：字符串数组,如{"dev","test"},则只有当你的springboot应用为dev或者test环境时才会开启api文档

 ### 5.2 效果展示
 
 ![``_H3_8VD__WR6ADC8VLQ_I.png](https://i.loli.net/2020/11/17/czlJ6RWMLgpIyHY.png)
 
 
 ![主页](https://i.loli.net/2020/11/17/abPFyOqLIoJgnBN.png)
 
 ![调试](https://i.loli.net/2020/11/17/XiKPLQM8OhH79xV.png)
