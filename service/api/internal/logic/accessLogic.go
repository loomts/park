package logic

import (
	"context"
	"errors"
	"service/model"

	"service/api/internal/svc"
	"service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type AccessLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewAccessLogic(ctx context.Context, svcCtx *svc.ServiceContext) *AccessLogic {
	return &AccessLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *AccessLogic) Access() (resp *[]types.AccessResp, err error) {
	access, err := l.svcCtx.AccessModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if access == nil {
		return nil, errors.New("游客流量数据不存在")
	}
	accessResps := make([]types.AccessResp, 0)
	for _, v := range *access {
		accessResps = append(accessResps, types.AccessResp{
			Id:       v.Id,
			Date:     v.Date.String(),
			Location: v.Location,
			Num:      v.Num,
		})
	}
	return &accessResps, err
}
