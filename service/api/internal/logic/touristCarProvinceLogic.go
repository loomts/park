package logic

import (
	"context"

	"github.com/loomts/EP1/service/api/internal/svc"
	"github.com/loomts/EP1/service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type TouristCarProvinceLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewTouristCarProvinceLogic(ctx context.Context, svcCtx *svc.ServiceContext) *TouristCarProvinceLogic {
	return &TouristCarProvinceLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *TouristCarProvinceLogic) TouristCarProvince() (resp *types.TouristCarProvinceResp, err error) {
	// todo: add your logic here and delete this line

	return
}
