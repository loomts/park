package logic

import (
	"context"

	"github.com/loomts/EP1/service/api/internal/svc"
	"github.com/loomts/EP1/service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type UserHandleLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewUserHandleLogic(ctx context.Context, svcCtx *svc.ServiceContext) *UserHandleLogic {
	return &UserHandleLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *UserHandleLogic) UserHandle() (resp *types.UserResp, err error) {
	// todo: add your logic here and delete this line

	return
}
