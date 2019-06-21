# <center>斗鱼热度排行统计程序

![img](https://github.com/FuckerDeng/douyuZhuBoHotRank/blob/master/imgs/douyuZhuBoHotRank.gif)
### 程序运行
```
1、下载可执行jar包：
-下载项目根目录的jar包：douyuZhuBoHotRank-*.0-SNAPSHOT.jar

2、新建配置文件目录：
-在jar包的同级目录新建config目录，并把项目config目录中的
config.properties、mysql.sql、mybatis.xml文件拷贝到新建的目录

3、配置房间号：
-在config.properties中，可以根据自己的需要改动要爬取天数，如果为-999，则会一直运行，除非结束进程

4、数据库建表：
-在自己的数据库（mysql）中，创建数据库douyu，然后执行项目config目录下的sql文件

5、给程序配置数据库
-配置表mybatis.xml中username和password配置成自己数据库的
-如果是远程数据库，可以根据需要更改数据库的url

6、window机器上的话，直接打开控制台，输入
    java -jar dyDanmuByNetty-1.0-SNAPSHOT.jar
即可

7、linux下的话，如果要后台运行，可以执行以下命令：
    nohup java -jar dyDanmuByNetty-1.0-SNAPSHOT.jar 2>&1 &
如果想结束，则先执行 ps -ef | grep java  找到刚才的java程序进程号，直接执行命令 kill 进程号 结束程序

```

----
#### =本程序采用jsoup进行网页爬取并分析数据，禁止商业用途，禁止恶意爬虫增加斗鱼服务器压力
#### =程序产生的日志都放在log目录下，每小时分一个日志文件
#### =程序统计到一定天数后可以分析数据库数据，对斗鱼热度值较高的主播进行排名，对主播认读变化情况进行统计分析等
### 如果程序有报错或者有更好的功能方案，欢迎与我联系，844537819@qq.com
