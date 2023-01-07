package logic

import (
	"context"
	"errors"
	"service/model"

	"service/api/internal/svc"
	"service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type TouristFlowLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewTouristFlowLogic(ctx context.Context, svcCtx *svc.ServiceContext) *TouristFlowLogic {
	return &TouristFlowLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *TouristFlowLogic) TouristFlow() (resp *[]types.TouristFlowResp, err error) {
	touristFlows, err := l.svcCtx.TouristFlowModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if touristFlows == nil {
		return nil, errors.New("游客流量数据不存在")
	}
	touristFlowsResps := make([]types.TouristFlowResp, 0)
	for _, v := range *touristFlows {
		touristFlowsResps = append(touristFlowsResps, types.TouristFlowResp{
			Id:       v.Id,
			Location: v.Location,
			Date:     v.Date.String(),
			Num:      v.Num,
		})
	}
	return &touristFlowsResps, err
}
