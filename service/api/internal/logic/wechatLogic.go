package logic

import (
	"context"

	"github.com/loomts/EP1/service/api/internal/svc"
	"github.com/loomts/EP1/service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type WechatLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewWechatLogic(ctx context.Context, svcCtx *svc.ServiceContext) *WechatLogic {
	return &WechatLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *WechatLogic) Wechat() (resp *types.WechatResp, err error) {
	// todo: add your logic here and delete this line
	
	return
}
