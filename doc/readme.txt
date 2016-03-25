
参考飞飞狐的文档：http://www.cnblogs.com/xiefeifeihu/archive/2012/08/01/2618087.html

20150814-1139 更新
1. 所属用包：akka-actor、 akka-remote、 akka-kernel。（已提供包在项目的 doc/lib/ 的目录下）
   用到的maven资源库：
        <repository>
            <id>typesafe-releases</id>
            <url>http://repo.typesafe.com/typesafe/releases</url>
        </repository>

2. akka启动时用到的配置文件：在 src\main\resources\application.conf
   配置文件中，server: 节点是服务器端的配置。要修改为相应的ip
               client: 节点是客户端器端的配置。修改为相应的ip，或改为127.0.0.1

3. 在 src\main\java\client\ClientApp.java 中，修改客户端调用的ip：
   如：
   system.actorFor("akka://serName@10.68.14.43:8888/user/serverActorName").tell("hello,3q I'm client ",client);
   的ip改为服务器端的ip。

4. 运行服务器端：src\main\java\server\ServerMain.java
   运行运行客户端：src\main\java\client\ClientMain.java

   客户端给服务器端发消息；服务器端接收消息，把消息打印显示。

=====================================================================================================

2015-12-30-1128 更新
5. pom.xml 加入 <build> 节点，配置项目构建的资源目录、项目编译插件、项目打包插件（配置项目jar包存放目录）、
   项目依懒包插件(配置项目依懒jar包存放目录)、源代码包插件等等。

6. 在ide上运行,要配置 Program arguments参数：  "serName" "10.68.14.139" "8888" "serverActorName"  "{'a':'123'}"

7.1 打包之后运行，服务端:
    (注意：指定classPath路径，依懒包路径配置文件路径时，linux环境下一定要加双引号,window环境可以省略双引号；依懒包使用通配符只支持 * 不支持 *.jar 或 *.zip)
    释：java  -cp  "依懒包路径,linux以冒号、window以分号 间隔"  main函数类路径以点间隔  [main函数参数列表，多个参数以空格分隔]

    运行命令：E:\baoWang\baoWangProjects\study_demo\akkaRemote_demo20150814-1139\target\target>java -cp "./lib/*;./dependency/*;./config/*" server.ServerMain
    显示以下：
    serverActor.pathakka://serName/user/serverActorName
    --------------服务端启动---------------


7.2 打开一个cmd命令行,客户端:
    运行命令：E:\baoWang\baoWangProjects\study_demo\akkaRemote_demo20150814-1139\target\target>java -cp "./lib/*;./dependency/*;./config/*" client.ClientMain "serName" "10.68.14.139" "8888" "serverActorName" '{"key1":"value1"}'

    显示以下：
       第0个参数serName
       第1个参数10.68.14.139
       第2个参数8888
       第3个参数serverActorName
       第4个参数'{key1:value1}'
       --------------发消息到服务端---------------
       收到服务器端发回来的消息：服务端已收到消息: '{key1:value1}'


















