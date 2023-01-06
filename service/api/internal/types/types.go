// Code generated by goctl. DO NOT EDIT.
package types

type Request struct {
	Name string `path:"name=you|me"`
}

type AccessResp struct {
	Id       int64  `json:"id"`
	Location string `json:"location"` // 接入地点
	Date     string `json:"date"`     // 接入日期
	Num      int64  `json:"num"`      // 接入数量
}

type IncomeResp struct {
	Id   int64  `json:"id"`
	Type string `json:"type"` // 收入类型
	Date string `json:"date"` // 日期
	Num  int64  `json:"num"`  // 当天收入
}

type ParkingLotResp struct {
	Id       int64  `json:"id"`
	Name     string `json:"name"`     // 停车场名字
	Duration int64  `json:"duration"` // 停车时间（小时）
	Num      int64  `json:"num"`      // 泊车数
}

type SiteInfoResp struct {
	Id           int64  `json:"id"`
	Date         string `json:"date"`          // 日期
	RevisitRate  int64  `json:"revisit_rate"`  // 重复访问率（%）
	SiteHealth   int64  `json:"site_health"`   // 站点健康度
	RfHealth     int64  `json:"rf_health"`     // 射频健康度
	DeviceHealth int64  `json:"device_health"` // 设备健康度
	Flow         int64  `json:"flow"`          // 当日站点流量
}

type TouristFlowResp struct {
	Id       int64  `json:"id"`
	Location string `json:"location"` // 园区地点
	Date     string `json:"date"`     // 时间
	Num      int64  `json:"num"`      // 游客数量
}

type TouristCarProvinceResp struct {
	Id       int64  `json:"id"`
	Province string `json:"province"` // 省份
	Date     string `json:"date"`     // 日期
	FlowNum  int64  `json:"flow_num"` // 人流数量
	CarNum   int64  `json:"car_num"`  // 车辆数
}

type UserResp struct {
	Username string `json:"username"` // 用户名
	Password string `json:"password"` // 密码
}

type WechatResp struct {
	Date string `json:"date"` // 日期
	Num  int64  `json:"num"`  // 微信关注数量
}
