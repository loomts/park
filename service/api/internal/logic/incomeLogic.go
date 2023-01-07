package logic

import (
	"context"
	"errors"
	"service/model"

	"service/api/internal/svc"
	"service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type IncomeLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewIncomeLogic(ctx context.Context, svcCtx *svc.ServiceContext) *IncomeLogic {
	return &IncomeLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *IncomeLogic) Income() (resp *[]types.IncomeResp, err error) {
	income, err := l.svcCtx.IncomeModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if income == nil {
		return nil, errors.New("游客流量数据不存在")
	}
	incomeResps := make([]types.IncomeResp, 0)
	for _, v := range *income {
		incomeResps = append(incomeResps, types.IncomeResp{
			Id:   v.Id,
			Date: v.Date.String(),
			Type: v.Type,
			Num:  v.Num,
		})
	}
	return &incomeResps, err
}
