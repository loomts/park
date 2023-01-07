package model

import "github.com/zeromicro/go-zero/core/stores/sqlx"

var _ ParkingLotModel = (*customParkingLotModel)(nil)

type (
	// ParkingLotModel is an interface to be customized, add more methods here,
	// and implement the added methods in customParkingLotModel.
	ParkingLotModel interface {
		parkingLotModel
	}

	customParkingLotModel struct {
		*defaultParkingLotModel
	}
)

// NewParkingLotModel returns a model for the database table.
func NewParkingLotModel(conn sqlx.SqlConn) ParkingLotModel {
	return &customParkingLotModel{
		defaultParkingLotModel: newParkingLotModel(conn),
	}
}
