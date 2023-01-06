package logic

import (
	"context"

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

func (l *IncomeLogic) Income() (resp *types.IncomeResp, err error) {
	// todo: add your logic here and delete this line

	return
}
