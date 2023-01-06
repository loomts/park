package config

import (
	"github.com/zeromicro/go-zero/core/stores/cache"
	"github.com/zeromicro/go-zero/core/stores/redis"
	"github.com/zeromicro/go-zero/rest"
)

type Config struct {
	rest.RestConf
	Mysql struct {
		DataSource string // mysql链接地址，满足 $user:$password@tcp($ip:$port)/$db?$queries 格式即可
	}
	CacheRedis cache.CacheConf // redis缓存
}
type CacheConf struct {
	ClusterConf []cache.NodeConf

	NodeConf struct {
		redis.RedisConf
		Weight int `json:",default=100"` // 权重
	}
}
type RedisConf struct {
	Host string // redis地址
	Type string `json:",default=node,options=node|cluster"` // redis类型
	Pass string `json:",optional"`                          // redis密码
}
