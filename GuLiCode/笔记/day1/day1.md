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
