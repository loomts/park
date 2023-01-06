package handler

import (
	"net/http"

	"github.com/loomts/EP1/service/api/internal/logic"
	"github.com/loomts/EP1/service/api/internal/svc"
	"github.com/zeromicro/go-zero/rest/httpx"
)

func siteInfoHandler(svcCtx *svc.ServiceContext) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		l := logic.NewSiteInfoLogic(r.Context(), svcCtx)
		resp, err := l.SiteInfo()
		if err != nil {
			httpx.ErrorCtx(r.Context(), w, err)
		} else {
			httpx.OkJsonCtx(r.Context(), w, resp)
		}
	}
}
