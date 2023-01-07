package model

import "github.com/zeromicro/go-zero/core/stores/sqlx"

var _ LogErrModel = (*customLogErrModel)(nil)

type (
	// LogErrModel is an interface to be customized, add more methods here,
	// and implement the added methods in customLogErrModel.
	LogErrModel interface {
		logErrModel
	}

	customLogErrModel struct {
		*defaultLogErrModel
	}
)

// NewLogErrModel returns a model for the database table.
func NewLogErrModel(conn sqlx.SqlConn) LogErrModel {
	return &customLogErrModel{
		defaultLogErrModel: newLogErrModel(conn),
	}
}
