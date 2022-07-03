## 后端

### TODO LIST

- [x] 获取api的函数
- [x] 生成和整理数据，扔给前端(数据还剩下路径没造，明天（今天）早上思考一下咋弄:)
- [x] sql~>api处理后的数据和注册登录
- [ ] 地图等比，弄几个坐标

获取华为API的函数在 \API

造的数据在 \conv\src\main\out\

### 数据约束

- /conv/src/main/out/deviceDetail.out

  ```
  name：设备名
  gisLon：经度
  gisLat：纬度
  traffic：流量
  upwardSpeed：上行速率
  downwardSpeed：下行速率
  cpuRate：cpu占有率
  ```

- /conv/src/main/out/deviceWlan.out 查询设备1h内的上行流量、下行流量

  ```
  deviceId：设备ID
  deviceName：设备名
  upTraffic：上行流量
  downTraffic：下行流量
  unit：流量单位
  ```

- /conv/src/main/out/sitesWlan.out  查询站点的上行速率、下行速率

  ```
  timestamp：时间戳
  unit：单位
  uplinkRate：上行速率
  downlinkRate：下行速率
  ```

- /conv/src/main/out/siteHealth.out 

  ```
  siteId：站点id
  deviceHealth：设备健康度
  radioHealth：射频健康度
  siteHealth：站点健康度
  ```

- /conv/src/main/out/histFlow.out 历史人流量 168条，以h为单位，24*7
- /conv/src/main/out/nowFlow.out 目前人流量 3600条，以s为单位，3600s，动态演示
- /conv/src/main/out/sitesFlow.out 站点人流量 6条，2022-07-02 13:00:00这一时刻6个景点的人数（想要加多点也可以叫我加）

这三个参数是一样的，时间默认从2022-07-02 13:00:00开始。

```
humanFlow:人流量
reVisitedRate:重复访问率
stamp:时间戳（可以搜时间戳转换工具将其转换成正常的时间）
```

- /conv/src/main/out/siteUserNumber.out

```
exprWorse、exprBad、exprGood、exprBetter：体验差、体验一般、体验良好、体验佳的用户（终端）数
oneHour、oneToTwoHour、twoToFourHour、fourToSixHour、sixToEightHour、eightHour：此时在线一小时以内、一小时到两小时、两小时到四小时、四小时到六小时、六小时到八小时、八小时的用户（终端）数
```



