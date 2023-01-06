package logic

import (
	"context"

	"github.com/loomts/EP1/service/api/internal/svc"
	"github.com/loomts/EP1/service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type SiteInfoLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewSiteInfoLogic(ctx context.Context, svcCtx *svc.ServiceContext) *SiteInfoLogic {
	return &SiteInfoLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *SiteInfoLogic) SiteInfo() (resp *types.SiteInfoResp, err error) {
	// todo: add your logic here and delete this line

	return
}
