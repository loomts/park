package model

import "github.com/zeromicro/go-zero/core/stores/sqlx"

var _ TouristCarProvinceModel = (*customTouristCarProvinceModel)(nil)

type (
	// TouristCarProvinceModel is an interface to be customized, add more methods here,
	// and implement the added methods in customTouristCarProvinceModel.
	TouristCarProvinceModel interface {
		touristCarProvinceModel
	}

	customTouristCarProvinceModel struct {
		*defaultTouristCarProvinceModel
	}
)

// NewTouristCarProvinceModel returns a model for the database table.
func NewTouristCarProvinceModel(conn sqlx.SqlConn) TouristCarProvinceModel {
	return &customTouristCarProvinceModel{
		defaultTouristCarProvinceModel: newTouristCarProvinceModel(conn),
	}
}
