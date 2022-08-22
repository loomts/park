<template>
  <div class="chrtt">
    <div v-for="(item, index) in picturedata" :key="index" class="picturetable">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>站点id：{{ item.siteId }}</span>
        </div>
        <div :id="'Access' + index" class="pic"></div>
      </el-card>
    </div>
  </div>
</template>

<script>
  import * as echarts from 'echarts'
  import * as allApi from '../../../../api.js'
  async function getData(){
    let data = []
    let listId = []
    var jsonObj = await allApi.getSitesFlow()
    for (var i = 0; i < jsonObj.length ; i++) {
        listId.push(jsonObj[i].siteId)
    }
    for (var i = 0; i < listId.length ; i++) {
        var Healthy = []
        var nowId = listId[i]
        var siteSFlowObj = await allApi.getSitesHealthById(nowId)
        Healthy.push(siteSFlowObj[0].deviceHealth)
        Healthy.push(siteSFlowObj[0].radioHealth)
        Healthy.push(siteSFlowObj[0].siteHealth)
        var siteSFlowObj = await allApi.getSitesFlowById(nowId)
        Healthy.push(siteSFlowObj[0].humanFlow)
        Healthy.push(siteSFlowObj[0].reVisitedRate)
        data.push({
          siteId: nowId,
          Healthy: Healthy,
        })
    }
    return data;
  }
  export default {
    name: 'HealthyEcharts',
    data() {
      return {
        picturedata: [],
      }
    },
    created() {
      this.fetchData()
      setTimeout(() => {
        this.Access()
      }, 500),
        this.Access()
    },
    mounted() {
    },
    methods: {
      async fetchData() {
        this.picturedata = await getData()
      },
      Access() {
        for (let i = 0; i < 6; i++) {
          let newPromise = new Promise((resolve, reject) => {
            resolve()
          })
          newPromise.then(() => {
            let chartDom = document.getElementById('Access' + i)
            var myChart = echarts.init(chartDom)
            var that = this
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
                      value: that.picturedata[i].Healthy,
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
      initEcharts() {
      },
    },
  }
</script>
<style lang="scss" scoped>
  .clearfix {
    text-align: center;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
  }
  .box-card {
    width: 800px;
    height: 400px;
    margin-top: 15px;
  }
  .picturetable {
    height: 400px;
    width: 800px;
    margin-left: 220px;
  }
  .pic {
    // margin-top: 100px;
    height: 300px;
  }
</style>
