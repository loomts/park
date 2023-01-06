package logic

import (
	"context"

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

func (l *ParkingLotLogic) ParkingLot() (resp *types.ParkingLotResp, err error) {
	// todo: add your logic here and delete this line

	return
}
