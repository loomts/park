数据约束

- src/main/out/histFlow.out
  历史人流量 168条，以h为单位，24*7
- src/main/out/nowFlow.out
  目前人流量 3600条，以s为单位，3600s，动态演示
- src/main/out/sitesFlow.out
  站点人流量 6条，2022-07-02 13:00:00这一时刻6个景点的人数（想要加多点也可以叫我加）

这三个参数是一样的，时间默认从2022-07-02 13:00:00开始。

`humanFlow:人流量`

`reVisitedRate:重复访问率` 

`stamp:时间戳（可以搜时间戳转换工具将其转换成正常的时间）`


name：设备名；gisLon：经度；gisLat：纬度；traffic：流量；upwardSpeed：上行速率；downwardSpeed：下行速率；cpuRate：cpu占有率
siteId：站点id；deviceHealth：设备健康度；radioHealth：射频健康度；siteHealth：站点健康度
exprWorse、exprBad、exprGood、exprBetter：体验差、体验一般、体验良好、体验佳的用户（终端）数；oneHour、oneToTwoHour、twoToFourHour、fourToSixHour、sixToEightHour、eightHour此时在线一小时以内、一小时到两小时、两小时到四小时、四小时到六小时、六小时到八小时、八小时的用户（终端）数；

mysql建表命令：createMysqlTable.txt
mysql插入数据命令：InsertData.txt