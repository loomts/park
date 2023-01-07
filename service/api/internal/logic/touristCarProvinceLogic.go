package logic

import (
	"context"
	"errors"
	"service/model"

	"service/api/internal/svc"
	"service/api/internal/types"

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

func (l *TouristCarProvinceLogic) TouristCarProvince() (resp *[]types.TouristCarProvinceResp, err error) {
	touristCarProvince, err := l.svcCtx.TouristCarProvinceModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if touristCarProvince == nil {
		return nil, errors.New("游客流量数据不存在")
	}
	touristCarProvinceResps := make([]types.TouristCarProvinceResp, 0)
	for _, v := range *touristCarProvince {
		touristCarProvinceResps = append(touristCarProvinceResps, types.TouristCarProvinceResp{
			Id:       v.Id,
			Province: v.Province,
			Date:     v.Date.String(),
			FlowNum:  v.FlowNum,
			CarNum:   v.CarNum,
		})
	}
	return &touristCarProvinceResps, err
}
