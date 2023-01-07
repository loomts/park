# RUN

1. 用mysql建`database EP1`
2. 导入 /service/mysql/EP1.sql
3. 改 src/main/java/database/Conn.java 的mysql账号密码
4. 开 /service/app/src/main/java/service/controller.java 的服务
5. `cd web`
6. `npm i` || `npx -p npm@6 npm install --legacy-peer-deps`
7. `npm run lint --fix`
8. `npm run serve`
### 1. "获取接入详情"

1. route definition

- Url: /api/access
- Method: GET
- Request: `-`
- Response: `accessResp`

2. request definition



3. response definition



```golang
type AccessResp struct {
	Id int64 `json:"id"`
	Location string `json:"location"` // 接入地点
	Date string `json:"date"` // 接入日期
	Num int64 `json:"num"` // 接入数量
}
```

### 2. "获取日收入详情"

1. route definition

- Url: /api/income
- Method: GET
- Request: `-`
- Response: `incomeResp`

2. request definition



3. response definition



```golang
type IncomeResp struct {
	Id int64 `json:"id"`
	Type string `json:"type"` // 收入类型
	Date string `json:"date"` // 日期
	Num int64 `json:"num"` // 当天收入
}
```

### 3. "获取停车详情"

1. route definition

- Url: /api/parkingLot
- Method: GET
- Request: `-`
- Response: `parkingLotResp`

2. request definition



3. response definition



```golang
type ParkingLotResp struct {
	Id int64 `json:"id"`
	Name string `json:"name"` // 停车场名字
	Duration int64 `json:"duration"` // 停车时间（小时）
	Num int64 `json:"num"` // 泊车数
}
```

### 4. "获取站点详情"

1. route definition

- Url: /api/siteInfo
- Method: GET
- Request: `-`
- Response: `siteInfoResp`

2. request definition



3. response definition



```golang
type SiteInfoResp struct {
	Id int64 `json:"id"`
	Date string `json:"date"` // 日期
	RevisitRate int64 `json:"revisit_rate"` // 重复访问率（%）
	SiteHealth int64 `json:"site_health"` // 站点健康度
	RfHealth int64 `json:"rf_health"` // 射频健康度
	DeviceHealth int64 `json:"device_health"` // 设备健康度
	Flow int64 `json:"flow"` // 当日站点流量
}
```

### 5. "获取客流量详情"

1. route definition

- Url: /api/touristFlow
- Method: GET
- Request: `-`
- Response: `touristFlowResp`

2. request definition



3. response definition



```golang
type TouristFlowResp struct {
	Id int64 `json:"id"`
	Location string `json:"location"` // 园区地点
	Date string `json:"date"` // 时间
	Num int64 `json:"num"` // 游客数量
}
```

### 6. "获取游客与车辆来源省份"

1. route definition

- Url: /api/touristCarProvince
- Method: GET
- Request: `-`
- Response: `touristCarProvinceResp`

2. request definition



3. response definition



```golang
type TouristCarProvinceResp struct {
	Id int64 `json:"id"`
	Province string `json:"province"` // 省份
	Date string `json:"date"` // 日期
	FlowNum int64 `json:"flow_num"` // 人流数量
	CarNum int64 `json:"car_num"` // 车辆数
}
```

### 7. "获取用户详情"

1. route definition

- Url: /api/user
- Method: POST
- Request: `userReq`
- Response: `userResp`

2. request definition



```golang
type UserReq struct {
	Id int64 `json:"id"` // 用户id
}
```


3. response definition



```golang
type UserResp struct {
	Id int64 `json:"id"` // 用户id
	Username string `json:"username"` // 用户名
}
```

### 8. "获取微信关注详情"

1. route definition

- Url: /api/wechat
- Method: GET
- Request: `-`
- Response: `wechatResp`

2. request definition



3. response definition



```golang
type WechatResp struct {
	Date string `json:"date"` // 日期
	Num int64 `json:"num"` // 微信关注数量
}
```


