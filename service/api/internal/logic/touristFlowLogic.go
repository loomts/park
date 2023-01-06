package logic

import (
	"context"

	"github.com/loomts/EP1/service/api/internal/svc"
	"github.com/loomts/EP1/service/api/internal/types"

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

func (l *TouristFlowLogic) TouristFlow() (resp *types.TouristFlowResp, err error) {
	// todo: add your logic here and delete this line

	return
}
