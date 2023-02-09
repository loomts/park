<template>
  <div class="chrtt">
    <div v-for="(item, index) in picturedata" :key="index" class="picturetable">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>站点id：{{ item.id }}</span>
        </div>
        <div :id="'Access' + index" class="pic"></div>
      </el-card>
    </div>
  </div>
</template>

<script>
// type SiteInfoResp struct {
// 	Id int64 `json:"id"`
// 	Date string `json:"date"` // 日期
// 	RevisitRate int64 `json:"revisit_rate"` // 重复访问率（%）
// 	SiteHealth int64 `json:"site_health"` // 站点健康度
// 	RfHealth int64 `json:"rf_health"` // 射频健康度
// 	DeviceHealth int64 `json:"device_health"` // 设备健康度
// 	Flow int64 `json:"flow"` // 当日站点流量
// }
  import * as echarts from 'echarts'
  import axios from 'axios'

  export default {
    name: 'HealthyEcharts',
    data() {
      return {
        picturedata: [],
      }
    },
    created() {
        var that = this
        axios.get('api/siteInfo')
          .then(function (response) {
            console.log(response.data)
            that.picturedata = response.data;
          })
          .catch(function (error) {
            console.log(error);
          });
          clearTimeout(this.timer)
          this.timer = setTimeout(() => {
            console.log(that.picturedata)
            that.Access()
          }, 2000)
    },
    mounted() {},
    methods: {
    
      Access() {
        console.log(this.picturedata.length)
        for (let i = 0; i < this.picturedata.length; i++) {
          let newPromise = new Promise((resolve, reject) => {
            resolve()
          })
          newPromise.then(() => {
            let chartDom = document.getElementById('Access' + i)
            var myChart = echarts.init(chartDom)
            var that = this.picturedata
            var option = {
              color: ['#67F9D8', '#FFE434', '#56A3F1', '#FF917C'],
              title: {
                // text: 'Customized Radar Chart',
              },
              legend: {},
              radar: [
                {
                  indicator: [
                    { text: '设备健康度' },
                    { text: '射频健康度' },
                    { text: '站点健康度' },
                    { text: '人流量' },
                    { text: '重复访问率(%)' },
                  ],
                  center: ['50%', '50%'],
                  radius: 120,
                  startAngle: 90,
                  splitNumber: 4,
                  shape: 'circle',
                  axisName: {
                    formatter: '【{value}】',
                    color: '#428BD4',
                  },
                  splitArea: {
                    areaStyle: {
                      color: ['#FFFFFF', '#FFFFFF', '#FFFFFF', '#FFFFFF'],
                      shadowColor: 'rgba(0, 0, 0, 0.2)',
                      shadowBlur: 10,
                    },
                  },
                  axisLine: {
                    lineStyle: {
                      color: 'rgba(211, 253, 250, 0.8)',
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: 'rgba(211, 253, 250, 0.8)',
                    },
                  },
                },
              ],
              series: [
                {
                  type: 'radar',
                  emphasis: {
                    lineStyle: {
                      width: 4,
                    },
                  },
                  data: [
                    {
                      //value: [100, 100, 100, 100, 100],
                      
                      value: [that[i].device_health, that[i].rf_health, that[i].site_health, that[i].flow, that[i].revisit_rate],
                      label: {
                        show: true,
                        formatter: function (params) {
                          return params.value
                        },
                      },
                      areaStyle: {
                        color: 'rgba(255, 228, 52, 0.6)',
                      },
                    },
                  ],
                },
              ],
            }

            option && myChart.setOption(option)
          })
        }
      },
      initEcharts() {},
    },
  }
</script>
<style lang="scss" scoped>
  .clearfix {
    text-align: center;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
    //padding: 0px -100px px 0px;
    //margin: 0px 0px 0px -300px;
  }
  .box-card {
    //margin: 10px 0px 10px 0px;
    //padding: 0px 0px 0px 0px;
    //display: inline-block;
    width: 700px;
    height: 400px;
    margin-top: 15px;
  }
  .picturetable {
    //margin: 10px 100px 10px 0px;
    padding: 30px 350px 10px 50px;
    display: inline-block;
    height: 400px;
    width: 400px;
    //margin-left: 120px;
  }
  .pic {
    // margin-top: 100px;
    height: 300px;
    //width: 10px;
  }
</style>
