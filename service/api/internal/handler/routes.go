// Code generated by goctl. DO NOT EDIT.
package handler

import (
	"net/http"

	"github.com/loomts/EP1/service/api/internal/svc"

	"github.com/zeromicro/go-zero/rest"
)

func RegisterHandlers(server *rest.Server, serverCtx *svc.ServiceContext) {
	server.AddRoutes(
		[]rest.Route{
			{
				Method:  http.MethodGet,
				Path:    "/access",
				Handler: accessHandler(serverCtx),
			},
			{
				Method:  http.MethodGet,
				Path:    "/income",
				Handler: incomeHandler(serverCtx),
			},
			{
				Method:  http.MethodGet,
				Path:    "/parkingLot",
				Handler: parkingLotHandler(serverCtx),
			},
			{
				Method:  http.MethodGet,
				Path:    "/siteInfo",
				Handler: siteInfoHandler(serverCtx),
			},
			{
				Method:  http.MethodGet,
				Path:    "/touristFlow",
				Handler: touristFlowHandler(serverCtx),
			},
			{
				Method:  http.MethodGet,
				Path:    "/touristCarProvince",
				Handler: touristCarProvinceHandler(serverCtx),
			},
			{
				Method:  http.MethodPost,
				Path:    "/user",
				Handler: userHandler(serverCtx),
			},
			{
				Method:  http.MethodGet,
				Path:    "/wechat",
				Handler: wechatHandler(serverCtx),
			},
		},
		rest.WithPrefix("/api"),
	)
}
