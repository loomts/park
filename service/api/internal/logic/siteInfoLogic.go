package logic

import (
	"context"
	"errors"
	"service/model"

	"service/api/internal/svc"
	"service/api/internal/types"

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

func (l *SiteInfoLogic) SiteInfo() (resp *[]types.SiteInfoResp, err error) {
	siteInfoLogic, err := l.svcCtx.SiteInfoModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if siteInfoLogic == nil {
		return nil, errors.New("游客流量数据不存在")
	}
	siteInfoLogicResps := make([]types.SiteInfoResp, 0)
	for _, v := range *siteInfoLogic {
		siteInfoLogicResps = append(siteInfoLogicResps, types.SiteInfoResp{
			Id:           v.Id,
			Date:         v.Date.String(),
			RevisitRate:  v.RevisitRate,
			SiteHealth:   v.SiteHealth,
			RfHealth:     v.RfHealth,
			DeviceHealth: v.DeviceHealth,
			Flow:         v.Flow,
		})
	}
	return &siteInfoLogicResps, err
}
