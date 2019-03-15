# Spring Boot 与 Laravel Mix 的组合

此项目包含以下内容：

- Spring Boot 后端
    - Spring Data
    - Spring Data REST
    - H2
    - Swagger
    - SpringFox
- Larvel Mix 前端
    - Bootstrap 4
    - Vue 2
    
开发项目需要以下环境准备：

- Microsoft Windows/Fedora 或等价操作系统
- JDK 11+
- Node JS 10+
- 你喜欢的Java IDE
    
## 环境准备

Windows系统用户执行以下操作：

**安装相关软件**

```powershell
choco install maven
choco install openjdk
# 或者 choco install jdk11
choco install nodejs
```

Fedora用户执行以下操作：

```bash
sudo dnf install nodejs java-11-openjdk-devel maven
```

## 启动项目

执行以下操作：

```powershell
npm install
npm run dev
mvn spring-boot:run
```

或在IDE中完成。

访问 http://127.0.0.1:5273 查看页面。

访问 http://127.0.0.1:5273/swagger-ui.html 查看 Swagger 页面。

## 其他

## REST API 文档

```powershell
mvn clean package
```

打开项目目录下的`target/asciidoc/html/index.html` 查看。

## 覆盖率

```powershell
mvn clean package
```

打开项目目录下的`target/site/jacoco/index.html` 查看。

# TODO

- 增加 Vue 案例。