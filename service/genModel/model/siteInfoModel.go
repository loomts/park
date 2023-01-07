package model

import "github.com/zeromicro/go-zero/core/stores/sqlx"

var _ SiteInfoModel = (*customSiteInfoModel)(nil)

type (
	// SiteInfoModel is an interface to be customized, add more methods here,
	// and implement the added methods in customSiteInfoModel.
	SiteInfoModel interface {
		siteInfoModel
	}

	customSiteInfoModel struct {
		*defaultSiteInfoModel
	}
)

// NewSiteInfoModel returns a model for the database table.
func NewSiteInfoModel(conn sqlx.SqlConn) SiteInfoModel {
	return &customSiteInfoModel{
		defaultSiteInfoModel: newSiteInfoModel(conn),
	}
}
