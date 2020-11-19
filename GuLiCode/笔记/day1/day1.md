DAY 1
---
### Zookeeper的安装和使用
1. 上传并解压：tar -zxvf zook###
2. 设置zookeeper的默认配置:zoo.cfg
3. 开启zookeeper: ./zkServer.sh start /等命令 
### 常用命令:
链接命令行客户端:
- 本地客户端 ./zkCli.sh 
- 异地客户端 ./zkCli.sh -server -port 
- 查看子节点:ls /xxxx
- 创建节点：create /xxx "xxx" (K-V结构)
- 获取节点数据:get /xxx
- 节点状态：stat /xxxx
- 修改节点数据: set /xxx "xxx"
- 删除节点： delete /xxx (删除的节点不能有子节点)，rmr /xxx 可以删带子节点的

### Znode数据模型
节点组成：节点内容节点状态子节点
节点类型：永久节点临时节点永久序列化节点临时序列化节点
节点属性：创建事务id创建时间更新事务id更新时间子节点版本号数据版本号访问控制符是否临时节点数据长度子节点数量
监听：
注册监听：1s/1s2 stat get
触发监听：create set delete子节点链接状态
特点
1.一次性触发
2.触发事件是异步的
3.监听节点及子节点

### Dubbo(基于长连接)
rpc：远程过程调用
http：
优势：简单，性能高，长连接稳定性ok

入门Demo：
1. 搭建注册中心
2. 搭建监控中心：前后端分离
   - 前端:dubbo-admin-ui(vue+node.js)
   - - npm intall /npm start
   - 后端:dubbo-admin-server(springboot)
   - - 改配置(配置zookeeper注册中心地址)
   - - 打包:mvn clear mvn package
   - - 启动：切换到target目录 java -jar xxx.jar
3. 创建服务提供方
   - 引入依赖：dubbo的springboot启动器、dubbo整合zookeeper依赖 zookeeper客户端依赖
   - 添加配置：
   - 在启动类加注解：@EnableDubbo
   - 代码编写
   - - service：实现类上加上dubbo的@Service注解
   - - mapper
   - - pojo：使用lombok
4. 创建服务消费方
   - 引入依赖：同上
   - 添加配置：
   - 在启动类加注解：@EnableDubbo
   - 代码编写
   - 需要service和pojo
   - controller:不使用Autowired而是Reference(dubbo)

**注意项:**
1. 所有的pojo对象必须需要先实现序列化接口
2. 所有启动项必须先启动生产方，在启动消费方

服务提供方(service实现，mapper接口)
服务消费方(controller，service)
接口工程(pojo实体类，service接口)