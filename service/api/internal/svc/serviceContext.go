package svc

import (
	"github.com/loomts/EP1/service/api/internal/config"
	"github.com/loomts/EP1/service/model"
	"github.com/zeromicro/go-zero/core/stores/sqlx"
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
}

func NewServiceContext(c config.Config) *ServiceContext {
	return &ServiceContext{
		Config:                  c,
		AccessModel:             model.NewAccessModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
		IncomeModel:             model.NewIncomeModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
		ParkingLotModel:         model.NewParkingLotModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
		SiteInfoModel:           model.NewSiteInfoModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
		TouristCarProvinceModel: model.NewTouristCarProvinceModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
		TouristFlowModel:        model.NewTouristFlowModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
		UserModel:               model.NewUserModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
		WechatModel:             model.NewWechatModel(sqlx.NewMysql(c.Mysql.DataSource), c.CacheRedis),
	}
}
