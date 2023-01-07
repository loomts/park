package logic

import (
	"context"
	"errors"
	"service/model"

	"service/api/internal/svc"
	"service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type ParkingLotLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewParkingLotLogic(ctx context.Context, svcCtx *svc.ServiceContext) *ParkingLotLogic {
	return &ParkingLotLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *ParkingLotLogic) ParkingLot() (resp *[]types.ParkingLotResp, err error) {
	parkingLog, err := l.svcCtx.ParkingLotModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if parkingLog == nil {
		return nil, errors.New("游客流量数据不存在")
	}
	parkingLogResps := make([]types.ParkingLotResp, 0)
	for _, v := range *parkingLog {
		parkingLogResps = append(parkingLogResps, types.ParkingLotResp{
			Id:       v.Id,
			Name:     v.Name,
			Duration: v.Duration,
			Num:      v.Num,
		})
	}
	return &parkingLogResps, err
}
