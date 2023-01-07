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
	logErrFieldNames          = builder.RawFieldNames(&LogErr{})
	logErrRows                = strings.Join(logErrFieldNames, ",")
	logErrRowsExpectAutoSet   = strings.Join(stringx.Remove(logErrFieldNames, "`id`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), ",")
	logErrRowsWithPlaceHolder = strings.Join(stringx.Remove(logErrFieldNames, "`id`", "`updated_at`", "`update_time`", "`create_at`", "`created_at`", "`create_time`", "`update_at`"), "=?,") + "=?"
)

type (
	logErrModel interface {
		Insert(ctx context.Context, data *LogErr) (sql.Result, error)
		FindOne(ctx context.Context, id int64) (*LogErr, error)
		Update(ctx context.Context, data *LogErr) error
		Delete(ctx context.Context, id int64) error
		QueryAll(ctx context.Context) (*[]LogErr, error)
	}

	defaultLogErrModel struct {
		conn  sqlx.SqlConn
		table string
	}

	LogErr struct {
		Id       int64     `db:"id"`
		Priority int64     `db:"priority"` // 优先级(1~9)
		Date     time.Time `db:"date"`     // 日期
		Location string    `db:"location"` // 发生地点
		Siteid   int64     `db:"siteid"`   // 站点id
		Cause    string    `db:"cause"`    // 异常原因
	}
)

func newLogErrModel(conn sqlx.SqlConn) *defaultLogErrModel {
	return &defaultLogErrModel{
		conn:  conn,
		table: "`log_err`",
	}
}

func (m *defaultLogErrModel) Delete(ctx context.Context, id int64) error {
	query := fmt.Sprintf("delete from %s where `id` = ?", m.table)
	_, err := m.conn.ExecCtx(ctx, query, id)
	return err
}

func (m *defaultLogErrModel) FindOne(ctx context.Context, id int64) (*LogErr, error) {
	query := fmt.Sprintf("select %s from %s where `id` = ? limit 1", logErrRows, m.table)
	var resp LogErr
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

func (m *defaultLogErrModel) Insert(ctx context.Context, data *LogErr) (sql.Result, error) {
	query := fmt.Sprintf("insert into %s (%s) values (?, ?, ?, ?, ?)", m.table, logErrRowsExpectAutoSet)
	ret, err := m.conn.ExecCtx(ctx, query, data.Priority, data.Date, data.Location, data.Siteid, data.Cause)
	return ret, err
}

func (m *defaultLogErrModel) Update(ctx context.Context, data *LogErr) error {
	query := fmt.Sprintf("update %s set %s where `id` = ?", m.table, logErrRowsWithPlaceHolder)
	_, err := m.conn.ExecCtx(ctx, query, data.Priority, data.Date, data.Location, data.Siteid, data.Cause, data.Id)
	return err
}

func (m *defaultLogErrModel) tableName() string {
	return m.table
}

func (m *defaultLogErrModel) QueryAll(ctx context.Context) (*[]LogErr, error) {
	query := fmt.Sprintf("select * from %s", m.table)
	resp := make([]LogErr, 0)
	err := m.conn.QueryRowsCtx(ctx, &resp, query)
	return &resp, err
}
