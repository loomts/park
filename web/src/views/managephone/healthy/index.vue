<template>
  <div class="chrtt">
    <div>
      <el-card class="box-card" style="width:45%;margin: 20px;float:left" >
        <div slot="header" class="clearfix">
          <div>
           站点1
          </div>
          <div>
              <div id="myChart" :style="{ width: '430px', height: '300px',margin:'30px'}"></div>
          </div>
        </div>
      </el-card>
      <el-card class="box-card" style="width:45%;margin: 20px;float: right;" >
        <div slot="header" class="clearfix">
          <div>
            站点2
          </div>
          <div>
              <div id="myChart2" :style="{ width: '430px', height: '300px',margin:'30px'}"></div>
          </div>
        </div>
      </el-card>
    </div>
    
    <div>
      <el-card class="box-card" style="width:45%;margin: 20px;float: left;" >
        <div slot="header" class="clearfix">
          <div>
            站点3
          </div>
          <div>
              <div id="myChart3" :style="{ width: '430px', height: '300px',margin:'30px' }"></div>
          </div>
        </div>
      </el-card>
      <el-card class="box-card" style="width:45%;margin: 20px;float: right;" >
        <div slot="header" class="clearfix">
          <div>
            站点4
          </div>
          <div>
              <div id="myChart1" :style="{ width: '430px', height: '300px',margin:'30px' }"></div>
          </div>
        </div>
      </el-card>
    </div>

    <div>
      <el-card class="box-card" style="width:45%;margin: 20px ;float: left;" >
        <div slot="header" class="clearfix">
          <div >
            站点5
          </div>
          <div>
              <div id="myChart4" :style="{ width: '430px', height: '300px',margin:'30px' }"></div>
          </div>
        </div>
      </el-card>
      <el-card class="box-card" style="width:45%;margin: 20px ;float: right;" >
        <div slot="header" class="clearfix">
          <div>
            站点6
          </div>
          <div>
              <div id="myChart6" :style="{ width: '430px', height: '300px',margin:'30px' }"></div>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>
 
<script>
export default {
  name: 'Radar',
  data() {
    return {}
  },
  mounted() {
    this.drawLine()
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById('myChart'))
      let myChart1 = this.$echarts.init(document.getElementById('myChart1'))
      let myChart2 = this.$echarts.init(document.getElementById('myChart2'))
      let myChart3 = this.$echarts.init(document.getElementById('myChart3'))
      let myChart4 = this.$echarts.init(document.getElementById('myChart4'))
      let myChart6 = this.$echarts.init(document.getElementById('myChart6'))
    
      let dataMax = [
        { name: '设备健康度', max: '100' },
        { name: '射频健康度', max: '100' },
        { name: '站点健康度', max: '100' },
        { name: '人流量', max: '10000' },
        { name: '重复访问率（%）', max: '100' },
      ]
      let option = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [90, 100, 100, 8256, 26],
              },
              // {
              //   name: '苹果手机',
              //   value: [70, 80, 88, 62, 98],
              // },
            ],
          },
        ],
      }
      let option1 = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [80, 60, 70, 7456, 36],
              },
              // {
              //   name: '苹果手机',
              //   value: [70, 80, 88, 62, 98],
              // },
            ],
          },
        ],
      }

      let option2 = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [93, 70, 80, 6687, 40],
              },
             
            ],
          },
        ],
      }
      let option3 = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [77, 83, 68, 7687, 22],
              },
             
            ],
          },
        ],
      }
      // 绘制图表
      myChart.setOption(option)
     myChart1.setOption(option1)
     myChart2.setOption(option2)
     myChart3.setOption(option3)
     myChart4.setOption(option1)
     myChart6.setOption(option3)
    },
  },
}
</script>
<style>
  *{
    font-family: AlimamaShuHeiTi-Bold;
  }
  @font-face {
    font-family: AlimamaShuHeiTi-Bold;
    src: url('./AlimamaShuHeiTi-Bold.otf');
  }
  
</style>

<!-- <template>
  <div class="chrtt">
    <div>
      <el-card class="box-card" style="width:45%;margin-top: 20px;margin:2% ;float: left;" >
        <div slot="header" class="clearfix">
          <div>
           站点1
          </div>
          <div>
              <div id="myChart" :style="{ width: '600px', height: '400px' }" style="border:1px solid black;"></div>
          </div>
        </div>
      </el-card>
      <el-card class="box-card" style="width:45%;margin-top: 20px;margin:2% ;float: right;" >
        <div slot="header" class="clearfix">
          <div>
            站点2
          </div>
          <div>
              <div id="myChart2" :style="{ width: '600px', height: '400px' }"></div>
          </div>
        </div>
      </el-card>
    </div>
    
    <div>
      <el-card class="box-card" style="width:45%;margin-top: 20px;margin:2% ;float: left;" >
        <div slot="header" class="clearfix">
          <div>
            站点3
          </div>
          <div>
              <div id="myChart3" :style="{ width: '600px', height: '400px' }"></div>
          </div>
        </div>
      </el-card>
      <el-card class="box-card" style="width:45%;margin-top: 20px;margin:2% ;float: right;" >
        <div slot="header" class="clearfix">
          <div>
            站点4
          </div>
          <div>
              <div id="myChart1" :style="{ width: '600px', height: '400px' }"></div>
          </div>
        </div>
      </el-card>
    </div>

    <div>
      <el-card class="box-card" style="width:45%;margin-top: 20px;margin:2% ;float: left;" >
        <div slot="header" class="clearfix">
          <div >
            站点5
          </div>
          <div>
              <div id="myChart4" :style="{ width: '600px', height: '400px' }"></div>
          </div>
        </div>
      </el-card>
      <el-card class="box-card" style="width:45%;margin-top: 20px;margin:2% ;float: right;" >
        <div slot="header" class="clearfix">
          <div>
            站点6
          </div>
          <div>
              <div id="myChart6" :style="{ width: '600px', height: '400px' }"></div>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>
 
<script>
export default {
  name: 'Radar',
  data() {
    return {}
  },
  mounted() {
    this.drawLine()
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById('myChart'))
      let myChart1 = this.$echarts.init(document.getElementById('myChart1'))
      let myChart2 = this.$echarts.init(document.getElementById('myChart2'))
      let myChart3 = this.$echarts.init(document.getElementById('myChart3'))
      let myChart4 = this.$echarts.init(document.getElementById('myChart4'))
      let myChart6 = this.$echarts.init(document.getElementById('myChart6'))
    
      let dataMax = [
        { name: '设备健康度', max: '100' },
        { name: '射频健康度', max: '100' },
        { name: '站点健康度', max: '100' },
        { name: '人流量', max: '10000' },
        { name: '重复访问率（%）', max: '100' },
      ]
      let option = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [90, 100, 100, 8256, 26],
              },
              // {
              //   name: '苹果手机',
              //   value: [70, 80, 88, 62, 98],
              // },
            ],
          },
        ],
      }
      let option1 = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [80, 60, 70, 7456, 36],
              },
              // {
              //   name: '苹果手机',
              //   value: [70, 80, 88, 62, 98],
              // },
            ],
          },
        ],
      }

      let option2 = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [93, 70, 80, 6687, 40],
              },
             
            ],
          },
        ],
      }
      let option3 = {
        //配置维度的最大值
        radar: {
          name: {
            show: true,
            color: 'blue',
          },
          //   雷达图的指示器，用来指定雷达图中的多个变量（维度）
          indicator: dataMax,
          shape: 'circle', //对雷达图形设置成一个圆形,可选 circle:圆形,polygon:多角形(默认)
        },
        series: [
          {
            type: 'radar',
            label: {
              show: true, //显示数值
            },
            areaStyle: {}, //每个雷达图形成一个阴影的面积
            data: [
              {
                name: '华为手机',
                value: [77, 83, 68, 7687, 22],
              },
             
            ],
          },
        ],
      }
      // 绘制图表
     myChart.setOption(option)
     myChart1.setOption(option1)
     myChart2.setOption(option2)
     myChart3.setOption(option3)
     myChart4.setOption(option1)
     myChart6.setOption(option3)
    },
  },
}
</script>
<style></style>

<style lang="scss">
  *{
    font-family: AlimamaShuHeiTi-Bold;
  }
  @font-face {
    font-family: AlimamaShuHeiTi-Bold;
    src: url('./AlimamaShuHeiTi-Bold.otf');
  }
  .box-card {
    //margin: 10px 0px 10px 0px;
    //padding: 0px 0px 0px 0px;
    //display: inline-block;
    width: 700px;
    height: 500px;
    margin-top: 15px;
  }
  </style>
 -->
<!-- <template>
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
  async function getData() {
    let data = []
    let listId = []
    var jsonObj = await allApi.getSitesFlow()
    for (var i = 0; i < jsonObj.length; i++) {
      listId.push(jsonObj[i].siteId)
    }
    for (var i = 0; i < listId.length; i++) {
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
    return data
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
    mounted() {},
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
 -->