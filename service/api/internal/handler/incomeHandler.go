package handler

import (
	"net/http"

	"github.com/zeromicro/go-zero/rest/httpx"
	"service/api/internal/logic"
	"service/api/internal/svc"
)

func incomeHandler(svcCtx *svc.ServiceContext) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		l := logic.NewIncomeLogic(r.Context(), svcCtx)
		resp, err := l.Income()
		if err != nil {
			httpx.ErrorCtx(r.Context(), w, err)
		} else {
			httpx.OkJsonCtx(r.Context(), w, resp)
		}
	}
}
