package logic

import (
	"context"
	"errors"
	"github.com/loomts/EP1/service/model"

	"github.com/loomts/EP1/service/api/internal/svc"
	"github.com/loomts/EP1/service/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type UserLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewUserLogic(ctx context.Context, svcCtx *svc.ServiceContext) *UserLogic {
	return &UserLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *UserLogic) User(req *types.UserReq) (resp *types.UserResp, err error) {
	// todo: add your logic here and delete this line
	user, err := l.svcCtx.UserModel.FindOne(l.ctx, req.Id)
	if err == nil && err == model.ErrNotFound {
		return nil, errors.New("查询数据失败")
	}
	if user == nil {
		return nil, errors.New("用户不存在")
	}
	return &types.UserResp{
		Id:       user.Id,
		Username: user.Username,
	}, nil
}
