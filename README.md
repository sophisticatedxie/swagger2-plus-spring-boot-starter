# swagger2-plus-spring-boot-starter
![输入图片说明](https://img.shields.io/badge/license-Apache--2.0-blue "在这里输入图片标题") ![输入图片说明](https://img.shields.io/badge/maven-1.0.0-green "在这里输入图片标题") ![输入图片说明](https://img.shields.io/badge/Prs-welcome-red "在这里输入图片标题")
#### 介绍
这个项目一开始的时候主要是迎合前后端分离的狂潮，后端api文档新贵swagger2的诞生和它的UI进阶版knife4j， 为了方便它和springboot项目更进一步的简单集成而萌发的一个想法，目前knife4j的作者也已经推出了knife4j的springboot插件包，感谢开源，感谢swagger。

#### 软件架构
标准的以maven构建的springboot工程，java版本为1.8，springboot2.3.1.


#### 安装教程

1. 前往maven repo [maven中央仓库](https://search.maven.org/)搜索 sophisticatedxie 
2.  maven玩家写法如下:
```java
<dependency>
  <groupId>com.github.sophisticatedxie</groupId>
  <artifactId>swagger2-plus-spring-boot-starter</artifactId>
  <version>1.0.0.RELEASE</version>
</dependency>
```

gradle 玩家写法如下自行在仓库搜索对应写法。

3.  项目重新reimport,建议使用阿里云maven镜像，下载速度较快。

#### 使用说明

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

  只需如此,如果之前你的项目就是使用swagger开发，那么恭喜你，无需改变以往的开发模式，swagger2-plus如同Mybatis-plus一般，只做增强，不做修改。
  
  项目启动之后访问 /doc.html 即可进入api文档界面，提供了在线调试、参数设置等多种调试方式，和全新的UI界面，管理接口更加方便， 尽情享受前后端分离带来的愉悦吧~

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 鸣谢

感谢swagger2和knife4j团队对本项目提供的巨大的底层帮助， 本项目意在更快速进行接口生成和配置，屏蔽了swagger2的底层配置，采用注解式驱动结合springboot自动装配特点，至于技术深挖，
always thanks for swagger develop team.
