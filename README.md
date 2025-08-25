<p align="center">
  <img alt="logo" src="https://oscimg.oschina.net/oscnet/up-b99b286755aef70355a7084753f89cdb7c9.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">TaTravel 旅行平台</h1>
<h4 align="center">基于 RuoYi-Cloud 的微服务旅行平台，提供攻略、游记、目的地等业务模块</h4>

## 平台简介

TaTravel 在 RuoYi-Cloud 开源项目基础上扩展，适用于旅游业务的分布式微服务系统。核心技术栈包括 Vue3 + Element Plus + Vite 前端、Spring Boot、Spring Cloud Alibaba 后端，并使用 Nacos、Redis、Elasticsearch 等组件。

项目目前包含以下特色功能：

- **全文检索**：整合攻略、游记、用户、目的地等多业务域的跨领域搜索，支持高亮展示。
- **高并发统计**：利用 Redis 哈希及原子操作实现浏览量、评论量等实时统计。
- **JWT 认证**：基于 `JwtUtils + TokenService` 的统一身份认证，支持网关过滤与会话管理。

更详细的设计说明见 [describe.md](describe.md)。

## 系统模块

```
com.tatravel
├── 前端项目             // Vue 前端
├── travel-gateway        // 网关模块 [8080]
├── travel-auth           // 认证中心 [9200]
├── travel-api            // 接口模块
│       └── travel-api-system                          // 系统接口
├── travel-common         // 通用模块
│       ├── travel-common-core                         // 核心模块
│       ├── travel-common-datascope                    // 权限范围
│       ├── travel-common-datasource                   // 多数据源
│       ├── travel-common-log                          // 日志记录
│       ├── travel-common-redis                        // 缓存服务
│       ├── travel-common-seata                        // 分布式事务
│       └── travel-common-security                     // 安全模块
├── travel-modules        // 业务模块
│       ├── travel-modules-system                      // 系统模块 [9201]
│       ├── travel-modules-gen                         // 代码生成 [9202]
│       ├── travel-modules-job                         // 定时任务 [9203]
│       ├── travel-modules-file                        // 文件服务 [9300]
│       ├── travel-modules-member                      // 会员模块
│       └── travel-modules-business                    // 业务服务
│            ├── travel-modules-answer                 // 问答服务
│            ├── travel-modules-canal                  // Canal 同步
│            ├── travel-modules-destination            // 目的地服务
│            ├── travel-modules-dev                    // 开发用模块
│            ├── travel-modules-message                // 消息服务
│            ├── travel-modules-note                   // 游记服务
│            ├── travel-modules-search                 // 搜索服务
│            └── travel-modules-strategy               // 攻略服务
├── travel-visual         // 图形化管理模块
│       └── travel-visual-monitor                      // 监控中心 [9100]
├── pom.xml               // 公共依赖
```

## 运行环境

- JDK 1.8+
- Maven 3.6+
- Redis、MySQL、Nacos、Elasticsearch 等中间件

## 主要功能

1. 用户、权限、字典、配置等基础功能继承自 RuoYi。
2. 旅游攻略、游记、问答、目的地等业务功能模块。
3. Elasticsearch 全文搜索支持多业务域高亮查询。
4. Redis 统计浏览、评论、点赞等高并发数据并定期持久化。
5. Gateway + JWT + Redis 组成的统一认证鉴权体系。

## 文档

- [项目业务说明](describe.md)
