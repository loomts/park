// Code generated by goctl. DO NOT EDIT.

package model

import (
	"context"
	"database/sql"
	"fmt"
	"strings"
	"time"

	"github.com/zeromicro/go-zero/core/stores/builder"
	"github.com/zeromicro/go-zero/core/stores/sqlc"
	"github.com/zeromicro/go-zero/core/stores/sqlx"
	"github.com/zeromicro/go-zero/core/stringx"
)

var (
	siteInfoFieldNames          = builder.RawFieldNames(&SiteInfo{})
	siteInfoRows                = strings.Join(siteInfoFieldNames, ",")
	siteInfoRowsExpectAutoSet   = strings.Join(stringx.Remove(siteInfoFieldNames, "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), ",")
	siteInfoRowsWithPlaceHolder = strings.Join(stringx.Remove(siteInfoFieldNames, "`id`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), "=?,") + "=?"
)

type (
	siteInfoModel interface {
		Insert(ctx context.Context, data *SiteInfo) (sql.Result, error)
		FindOne(ctx context.Context, id int64) (*SiteInfo, error)
		Update(ctx context.Context, data *SiteInfo) error
		Delete(ctx context.Context, id int64) error
	}

	defaultSiteInfoModel struct {
		conn  sqlx.SqlConn
		table string
	}

	SiteInfo struct {
		Id           int64     `db:"id"`
		Date         time.Time `db:"date"`          // 日期
		RevisitRate  int64     `db:"revisit_rate"`  // 重复访问率（%）
		SiteHealth   int64     `db:"site_health"`   // 站点健康度
		RfHealth     int64     `db:"rf_health"`     // 射频健康度
		DeviceHealth int64     `db:"device_health"` // 设备健康度
		Flow         int64     `db:"flow"`          // 当日站点流量
	}
)

func newSiteInfoModel(conn sqlx.SqlConn) *defaultSiteInfoModel {
	return &defaultSiteInfoModel{
		conn:  conn,
		table: "`site_info`",
	}
}

func (m *defaultSiteInfoModel) Delete(ctx context.Context, id int64) error {
	query := fmt.Sprintf("delete from %s where `id` = ?", m.table)
	_, err := m.conn.ExecCtx(ctx, query, id)
	return err
}

func (m *defaultSiteInfoModel) FindOne(ctx context.Context, id int64) (*SiteInfo, error) {
	query := fmt.Sprintf("select %s from %s where `id` = ? limit 1", siteInfoRows, m.table)
	var resp SiteInfo
	err := m.conn.QueryRowCtx(ctx, &resp, query, id)
	switch err {
	case nil:
		return &resp, nil
	case sqlc.ErrNotFound:
		return nil, ErrNotFound
	default:
		return nil, err
	}
}

func (m *defaultSiteInfoModel) Insert(ctx context.Context, data *SiteInfo) (sql.Result, error) {
	query := fmt.Sprintf("insert into %s (%s) values (?, ?, ?, ?, ?, ?, ?)", m.table, siteInfoRowsExpectAutoSet)
	ret, err := m.conn.ExecCtx(ctx, query, data.Id, data.Date, data.RevisitRate, data.SiteHealth, data.RfHealth, data.DeviceHealth, data.Flow)
	return ret, err
}

func (m *defaultSiteInfoModel) Update(ctx context.Context, data *SiteInfo) error {
	query := fmt.Sprintf("update %s set %s where `id` = ?", m.table, siteInfoRowsWithPlaceHolder)
	_, err := m.conn.ExecCtx(ctx, query, data.Date, data.RevisitRate, data.SiteHealth, data.RfHealth, data.DeviceHealth, data.Flow, data.Id)
	return err
}

func (m *defaultSiteInfoModel) tableName() string {
	return m.table
}
