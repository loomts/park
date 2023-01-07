package logic

import (
	"context"
	"errors"
	"service/api/internal/svc"
	"service/api/internal/types"
	"service/model"

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

func (l *WechatLogic) Wechat() (resp *[]types.WechatResp, err error) {
	wechats, err := l.svcCtx.WechatModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if wechats == nil {
		return nil, errors.New("微信关注记录不存在")
	}
	wechatResps := make([]types.WechatResp, 0)
	for _, v := range *wechats {
		wechatResps = append(wechatResps, types.WechatResp{
			Date: v.Date.String(),
			Num:  v.Num,
		})
	}
	return &wechatResps, err
}
