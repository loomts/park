package model

import "github.com/zeromicro/go-zero/core/stores/sqlx"

var _ TouristFlowModel = (*customTouristFlowModel)(nil)

type (
	// TouristFlowModel is an interface to be customized, add more methods here,
	// and implement the added methods in customTouristFlowModel.
	TouristFlowModel interface {
		touristFlowModel
	}

	customTouristFlowModel struct {
		*defaultTouristFlowModel
	}
)

// NewTouristFlowModel returns a model for the database table.
func NewTouristFlowModel(conn sqlx.SqlConn) TouristFlowModel {
	return &customTouristFlowModel{
		defaultTouristFlowModel: newTouristFlowModel(conn),
	}
}
