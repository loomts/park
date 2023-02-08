// Code generated by goctl. DO NOT EDIT.

package model

import (
	"context"
	"database/sql"
	"fmt"
	"strings"

	"github.com/zeromicro/go-zero/core/stores/builder"
	"github.com/zeromicro/go-zero/core/stores/sqlc"
	"github.com/zeromicro/go-zero/core/stores/sqlx"
	"github.com/zeromicro/go-zero/core/stringx"
)

var (
	parkingLotFieldNames          = builder.RawFieldNames(&ParkingLot{})
	parkingLotRows                = strings.Join(parkingLotFieldNames, ",")
	parkingLotRowsExpectAutoSet   = strings.Join(stringx.Remove(parkingLotFieldNames, "`id`", "`create_time`", "`update_at`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`"), ",")
	parkingLotRowsWithPlaceHolder = strings.Join(stringx.Remove(parkingLotFieldNames, "`id`", "`create_time`", "`update_at`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`"), "=?,") + "=?"
)

type (
	parkingLotModel interface {
		Insert(ctx context.Context, data *ParkingLot) (sql.Result, error)
		FindOne(ctx context.Context, id int64) (*ParkingLot, error)
		Update(ctx context.Context, data *ParkingLot) error
		Delete(ctx context.Context, id int64) error
	}

	defaultParkingLotModel struct {
		conn  sqlx.SqlConn
		table string
	}

	ParkingLot struct {
		Id       int64  `db:"id"`
		Name     string `db:"name"`     // 停车场名字
		Duration int64  `db:"duration"` // 停车时间（小时）
		Num      int64  `db:"num"`      // 泊车数
	}
)

func newParkingLotModel(conn sqlx.SqlConn) *defaultParkingLotModel {
	return &defaultParkingLotModel{
		conn:  conn,
		table: "`parking_lot`",
	}
}

func (m *defaultParkingLotModel) Delete(ctx context.Context, id int64) error {
	query := fmt.Sprintf("delete from %s where `id` = ?", m.table)
	_, err := m.conn.ExecCtx(ctx, query, id)
	return err
}

func (m *defaultParkingLotModel) FindOne(ctx context.Context, id int64) (*ParkingLot, error) {
	query := fmt.Sprintf("select %s from %s where `id` = ? limit 1", parkingLotRows, m.table)
	var resp ParkingLot
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

func (m *defaultParkingLotModel) Insert(ctx context.Context, data *ParkingLot) (sql.Result, error) {
	query := fmt.Sprintf("insert into %s (%s) values (?, ?, ?)", m.table, parkingLotRowsExpectAutoSet)
	ret, err := m.conn.ExecCtx(ctx, query, data.Name, data.Duration, data.Num)
	return ret, err
}

func (m *defaultParkingLotModel) Update(ctx context.Context, data *ParkingLot) error {
	query := fmt.Sprintf("update %s set %s where `id` = ?", m.table, parkingLotRowsWithPlaceHolder)
	_, err := m.conn.ExecCtx(ctx, query, data.Name, data.Duration, data.Num, data.Id)
	return err
}

func (m *defaultParkingLotModel) tableName() string {
	return m.table
}
