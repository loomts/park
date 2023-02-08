package logic

import (
	"context"
	"errors"
	"service/model"

	"service/api/internal/svc"
	"service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type DeviceInfoLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewDeviceInfoLogic(ctx context.Context, svcCtx *svc.ServiceContext) *DeviceInfoLogic {
	return &DeviceInfoLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *DeviceInfoLogic) DeviceInfo() (resp *[]types.DeviceInfoResp, err error) {
	deviceInfo, err := l.svcCtx.DeviceInfoModel.QueryAll(l.ctx)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if deviceInfo == nil {
		return nil, errors.New("游客流量数据不存在")
	}
	deviceInfoResp := make([]types.DeviceInfoResp, 0)
	for _, v := range *deviceInfo {
		deviceInfoResp = append(deviceInfoResp, types.DeviceInfoResp{
			Id:           v.Id,
			UplinkRate:   v.UplinkRate,
			DownlinkRate: v.DownlinkRate,
			Flow:         v.Flow,
			CpuRate:      v.CpuRate,
			Longitude:    v.Longitude,
			Latitude:     v.Latitude,
		})
	}
	return &deviceInfoResp, err
}
