package model

import (
	"github.com/zeromicro/go-zero/core/stores/cache"
	"github.com/zeromicro/go-zero/core/stores/sqlx"
)

var _ IncomeModel = (*customIncomeModel)(nil)

type (
	// IncomeModel is an interface to be customized, add more methods here,
	// and implement the added methods in customIncomeModel.
	IncomeModel interface {
		incomeModel
	}

	customIncomeModel struct {
		*defaultIncomeModel
	}
)

// NewIncomeModel returns a model for the database table.
func NewIncomeModel(conn sqlx.SqlConn, c cache.CacheConf) IncomeModel {
	return &customIncomeModel{
		defaultIncomeModel: newIncomeModel(conn, c),
	}
}
