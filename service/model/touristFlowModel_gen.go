// Code generated by goctl. DO NOT EDIT.

package model

import (
	"context"
	"database/sql"
	"fmt"
	"strings"
	"time"

	"github.com/zeromicro/go-zero/core/stores/builder"
	"github.com/zeromicro/go-zero/core/stores/cache"
	"github.com/zeromicro/go-zero/core/stores/sqlc"
	"github.com/zeromicro/go-zero/core/stores/sqlx"
	"github.com/zeromicro/go-zero/core/stringx"
)

var (
	touristFlowFieldNames          = builder.RawFieldNames(&TouristFlow{})
	touristFlowRows                = strings.Join(touristFlowFieldNames, ",")
	touristFlowRowsExpectAutoSet   = strings.Join(stringx.Remove(touristFlowFieldNames, "`id`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), ",")
	touristFlowRowsWithPlaceHolder = strings.Join(stringx.Remove(touristFlowFieldNames, "`id`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), "=?,") + "=?"

	cacheTouristFlowIdPrefix = "cache:touristFlow:id:"
)

type (
	touristFlowModel interface {
		Insert(ctx context.Context, data *TouristFlow) (sql.Result, error)
		FindOne(ctx context.Context, id int64) (*TouristFlow, error)
		Update(ctx context.Context, data *TouristFlow) error
		Delete(ctx context.Context, id int64) error
	}

	defaultTouristFlowModel struct {
		sqlc.CachedConn
		table string
	}

	TouristFlow struct {
		Id       int64     `db:"id"`
		Location string    `db:"location"` // 园区地点
		Date     time.Time `db:"date"`     // 时间
		Num      int64     `db:"num"`      // 游客数量
	}
)

func newTouristFlowModel(conn sqlx.SqlConn, c cache.CacheConf) *defaultTouristFlowModel {
	return &defaultTouristFlowModel{
		CachedConn: sqlc.NewConn(conn, c),
		table:      "`tourist_flow`",
	}
}

func (m *defaultTouristFlowModel) Delete(ctx context.Context, id int64) error {
	touristFlowIdKey := fmt.Sprintf("%s%v", cacheTouristFlowIdPrefix, id)
	_, err := m.ExecCtx(ctx, func(ctx context.Context, conn sqlx.SqlConn) (result sql.Result, err error) {
		query := fmt.Sprintf("delete from %s where `id` = ?", m.table)
		return conn.ExecCtx(ctx, query, id)
	}, touristFlowIdKey)
	return err
}

func (m *defaultTouristFlowModel) FindOne(ctx context.Context, id int64) (*TouristFlow, error) {
	touristFlowIdKey := fmt.Sprintf("%s%v", cacheTouristFlowIdPrefix, id)
	var resp TouristFlow
	err := m.QueryRowCtx(ctx, &resp, touristFlowIdKey, func(ctx context.Context, conn sqlx.SqlConn, v interface{}) error {
		query := fmt.Sprintf("select %s from %s where `id` = ? limit 1", touristFlowRows, m.table)
		return conn.QueryRowCtx(ctx, v, query, id)
	})
	switch err {
	case nil:
		return &resp, nil
	case sqlc.ErrNotFound:
		return nil, ErrNotFound
	default:
		return nil, err
	}
}

func (m *defaultTouristFlowModel) Insert(ctx context.Context, data *TouristFlow) (sql.Result, error) {
	touristFlowIdKey := fmt.Sprintf("%s%v", cacheTouristFlowIdPrefix, data.Id)
	ret, err := m.ExecCtx(ctx, func(ctx context.Context, conn sqlx.SqlConn) (result sql.Result, err error) {
		query := fmt.Sprintf("insert into %s (%s) values (?, ?, ?)", m.table, touristFlowRowsExpectAutoSet)
		return conn.ExecCtx(ctx, query, data.Location, data.Date, data.Num)
	}, touristFlowIdKey)
	return ret, err
}

func (m *defaultTouristFlowModel) Update(ctx context.Context, data *TouristFlow) error {
	touristFlowIdKey := fmt.Sprintf("%s%v", cacheTouristFlowIdPrefix, data.Id)
	_, err := m.ExecCtx(ctx, func(ctx context.Context, conn sqlx.SqlConn) (result sql.Result, err error) {
		query := fmt.Sprintf("update %s set %s where `id` = ?", m.table, touristFlowRowsWithPlaceHolder)
		return conn.ExecCtx(ctx, query, data.Location, data.Date, data.Num, data.Id)
	}, touristFlowIdKey)
	return err
}

func (m *defaultTouristFlowModel) formatPrimary(primary interface{}) string {
	return fmt.Sprintf("%s%v", cacheTouristFlowIdPrefix, primary)
}

func (m *defaultTouristFlowModel) queryPrimary(ctx context.Context, conn sqlx.SqlConn, v, primary interface{}) error {
	query := fmt.Sprintf("select %s from %s where `id` = ? limit 1", touristFlowRows, m.table)
	return conn.QueryRowCtx(ctx, v, query, primary)
}

func (m *defaultTouristFlowModel) tableName() string {
	return m.table
}
