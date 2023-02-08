package svc

import (
	"github.com/zeromicro/go-zero/core/stores/sqlx"
	"service/api/internal/config"
	"service/model"
)

type ServiceContext struct {
	Config                  config.Config
	AccessModel             model.AccessModel
	IncomeModel             model.IncomeModel
	ParkingLotModel         model.ParkingLotModel
	SiteInfoModel           model.SiteInfoModel
	TouristCarProvinceModel model.TouristCarProvinceModel
	TouristFlowModel        model.TouristFlowModel
	UserModel               model.UserModel
	WechatModel             model.WechatModel
	DeviceInfoModel         model.DeviceInfoModel
}

func NewServiceContext(c config.Config) *ServiceContext {
	return &ServiceContext{
		Config:                  c,
		AccessModel:             model.NewAccessModel(sqlx.NewMysql(c.Mysql.DataSource)),
		IncomeModel:             model.NewIncomeModel(sqlx.NewMysql(c.Mysql.DataSource)),
		ParkingLotModel:         model.NewParkingLotModel(sqlx.NewMysql(c.Mysql.DataSource)),
		SiteInfoModel:           model.NewSiteInfoModel(sqlx.NewMysql(c.Mysql.DataSource)),
		TouristCarProvinceModel: model.NewTouristCarProvinceModel(sqlx.NewMysql(c.Mysql.DataSource)),
		TouristFlowModel:        model.NewTouristFlowModel(sqlx.NewMysql(c.Mysql.DataSource)),
		UserModel:               model.NewUserModel(sqlx.NewMysql(c.Mysql.DataSource)),
		WechatModel:             model.NewWechatModel(sqlx.NewMysql(c.Mysql.DataSource)),
		DeviceInfoModel:         model.NewDeviceInfoModel(sqlx.NewMysql(c.Mysql.DataSource)),
	}
}
