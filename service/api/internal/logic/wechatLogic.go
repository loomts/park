package logic

import (
	"context"
	"service/api/internal/svc"
	"service/api/internal/types"

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

func (l *WechatLogic) Wechat() (resp []*types.WechatResp, err error) {
	// todo: add your logic here and delete this line
	wechats, err := l.svcCtx.WechatModel.QueryAll(l.ctx)
	var wechatResps []*types.WechatResp
	for _, v := range *wechats {
		wechatResps = append(wechatResps, &types.WechatResp{
			Date: v.Date.String(),
			Num:  v.Num,
		})
	}
	return wechatResps, err
}
