package model

import "github.com/zeromicro/go-zero/core/stores/sqlx"

var _ WechatModel = (*customWechatModel)(nil)

type (
	// WechatModel is an interface to be customized, add more methods here,
	// and implement the added methods in customWechatModel.
	WechatModel interface {
		wechatModel
	}

	customWechatModel struct {
		*defaultWechatModel
	}
)

// NewWechatModel returns a model for the database table.
func NewWechatModel(conn sqlx.SqlConn) WechatModel {
	return &customWechatModel{
		defaultWechatModel: newWechatModel(conn),
	}
}
