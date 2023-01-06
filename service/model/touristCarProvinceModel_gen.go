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
	touristCarProvinceFieldNames          = builder.RawFieldNames(&TouristCarProvince{})
	touristCarProvinceRows                = strings.Join(touristCarProvinceFieldNames, ",")
	touristCarProvinceRowsExpectAutoSet   = strings.Join(stringx.Remove(touristCarProvinceFieldNames, "`id`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), ",")
	touristCarProvinceRowsWithPlaceHolder = strings.Join(stringx.Remove(touristCarProvinceFieldNames, "`id`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), "=?,") + "=?"

	cacheTouristCarProvinceIdPrefix = "cache:touristCarProvince:id:"
)

type (
	touristCarProvinceModel interface {
		Insert(ctx context.Context, data *TouristCarProvince) (sql.Result, error)
		FindOne(ctx context.Context, id int64) (*TouristCarProvince, error)
		Update(ctx context.Context, data *TouristCarProvince) error
		Delete(ctx context.Context, id int64) error
	}

	defaultTouristCarProvinceModel struct {
		sqlc.CachedConn
		table string
	}

	TouristCarProvince struct {
		Id       int64     `db:"id"`
		Province string    `db:"province"` // 省份
		Date     time.Time `db:"date"`     // 日期
		FlowNum  int64     `db:"flow_num"` // 人流数量
		CarNum   int64     `db:"car_num"`  // 车辆数
	}
)

func newTouristCarProvinceModel(conn sqlx.SqlConn, c cache.CacheConf) *defaultTouristCarProvinceModel {
	return &defaultTouristCarProvinceModel{
		CachedConn: sqlc.NewConn(conn, c),
		table:      "`tourist_car_province`",
	}
}

func (m *defaultTouristCarProvinceModel) Delete(ctx context.Context, id int64) error {
	touristCarProvinceIdKey := fmt.Sprintf("%s%v", cacheTouristCarProvinceIdPrefix, id)
	_, err := m.ExecCtx(ctx, func(ctx context.Context, conn sqlx.SqlConn) (result sql.Result, err error) {
		query := fmt.Sprintf("delete from %s where `id` = ?", m.table)
		return conn.ExecCtx(ctx, query, id)
	}, touristCarProvinceIdKey)
	return err
}

func (m *defaultTouristCarProvinceModel) FindOne(ctx context.Context, id int64) (*TouristCarProvince, error) {
	touristCarProvinceIdKey := fmt.Sprintf("%s%v", cacheTouristCarProvinceIdPrefix, id)
	var resp TouristCarProvince
	err := m.QueryRowCtx(ctx, &resp, touristCarProvinceIdKey, func(ctx context.Context, conn sqlx.SqlConn, v interface{}) error {
		query := fmt.Sprintf("select %s from %s where `id` = ? limit 1", touristCarProvinceRows, m.table)
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

func (m *defaultTouristCarProvinceModel) Insert(ctx context.Context, data *TouristCarProvince) (sql.Result, error) {
	touristCarProvinceIdKey := fmt.Sprintf("%s%v", cacheTouristCarProvinceIdPrefix, data.Id)
	ret, err := m.ExecCtx(ctx, func(ctx context.Context, conn sqlx.SqlConn) (result sql.Result, err error) {
		query := fmt.Sprintf("insert into %s (%s) values (?, ?, ?, ?)", m.table, touristCarProvinceRowsExpectAutoSet)
		return conn.ExecCtx(ctx, query, data.Province, data.Date, data.FlowNum, data.CarNum)
	}, touristCarProvinceIdKey)
	return ret, err
}

func (m *defaultTouristCarProvinceModel) Update(ctx context.Context, data *TouristCarProvince) error {
	touristCarProvinceIdKey := fmt.Sprintf("%s%v", cacheTouristCarProvinceIdPrefix, data.Id)
	_, err := m.ExecCtx(ctx, func(ctx context.Context, conn sqlx.SqlConn) (result sql.Result, err error) {
		query := fmt.Sprintf("update %s set %s where `id` = ?", m.table, touristCarProvinceRowsWithPlaceHolder)
		return conn.ExecCtx(ctx, query, data.Province, data.Date, data.FlowNum, data.CarNum, data.Id)
	}, touristCarProvinceIdKey)
	return err
}

func (m *defaultTouristCarProvinceModel) formatPrimary(primary interface{}) string {
	return fmt.Sprintf("%s%v", cacheTouristCarProvinceIdPrefix, primary)
}

func (m *defaultTouristCarProvinceModel) queryPrimary(ctx context.Context, conn sqlx.SqlConn, v, primary interface{}) error {
	query := fmt.Sprintf("select %s from %s where `id` = ? limit 1", touristCarProvinceRows, m.table)
	return conn.QueryRowCtx(ctx, v, query, primary)
}

func (m *defaultTouristCarProvinceModel) tableName() string {
	return m.table
}
