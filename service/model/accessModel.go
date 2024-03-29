package model

import "github.com/zeromicro/go-zero/core/stores/sqlx"

var _ AccessModel = (*customAccessModel)(nil)

type (
	// AccessModel is an interface to be customized, add more methods here,
	// and implement the added methods in customAccessModel.
	AccessModel interface {
		accessModel
	}

	customAccessModel struct {
		*defaultAccessModel
	}
)

// NewAccessModel returns a model for the database table.
func NewAccessModel(conn sqlx.SqlConn) AccessModel {
	return &customAccessModel{
		defaultAccessModel: newAccessModel(conn),
	}
}
