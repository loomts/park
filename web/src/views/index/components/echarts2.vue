<template>
  <div id = "park">
    <!-- <button @click="change" data-id="1">1</button>
      <button @click="change" data-id="2">2</button>
      <button @click="change" data-id="3">23</button> -->

    <el-tabs :tab-position="tabPosition" style="height: 380px; stretch: true">
      <el-tab-pane label="地下停车场1">
        <div id="main21" ref="main21" style="width: 400px; height: 300px"></div>
      </el-tab-pane>
      <el-tab-pane label="地下停车场2">
        <div id="main22" ref="main22" style="width: 400px; height: 300px"></div>
      </el-tab-pane>
      <el-tab-pane label="地下停车场3" >
        <div id="main23" ref="main23" style="width: 400px; height: 300px"></div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import * as echarts from 'echarts'
  export default {
    name: 'Echart1',
    data() {
      return {
        tab: 1,
        tabPosition: 'left',
      }
    },
    created() {
      setTimeout(() => {
        this.init()
        this.init2()
        this.init3()
      }, 1000)
      // this.init()
      // this.init2()
    },
    mounted() {},
    methods: {
      change: function (e) {
        var tabid = e.target.dataset.id
        this.tab = tabid
      },
      init3() {
        var myChart = echarts.init(this.$refs.main23)
        var option = {
          tooltip: {
            show: true,
            trigger: 'item',
            formatter: '{a}<br/>{b}: {c} ({d}%)',
          },
          legend: {
            top: '5%',
            textStyle: {
              //图例文字的样式
              // color: '#fff',
              fontSize: 16,
            },
            left: 'center',
          },
          series: [
            {
              name: '停车位占用情况',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              label: {
                show: false,
                position: 'center',
                // color:  '#fff'
              },

              emphasis: {
                label: {
                  // color:  '#fff' ,
                  show: true,
                  fontSize: '20',
                  fontWeight: 'bold',
                },
              },
              labelLine: {
                show: false,
              },
              data: [
                { value: 10, name: '空闲' },
                { value: 735, name: '2小时' },
                { value: 580, name: '4小时' },
                { value: 48, name: '>4小时' },
                // { value: 300, name: '>3小时' }
              ],
            },
          ],
        }

        myChart.setOption(option)
        window.addEventListener('resize', function () {
          myChart.resize()
        })
      },
      init2() {
        var myChart = echarts.init(this.$refs.main22)
        var option = {
          tooltip: {
            show: true,
            trigger: 'item',
            formatter: '{a}<br/>{b}:{c} ({d}%)',
          },
          legend: {
            top: '5%',
            left: 'center',
            textStyle: {
              //图例文字的样式
              color: '#fff',
              fontSize: 16,
            },
          },
          series: [
            {
              name: '停车位占用情况',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              label: {
                show: false,
                position: 'center',
                textStyle: {
                  //图例文字的样式
                  color: '#fff',
                  fontSize: 16,
                },
              },
              emphasis: {
                label: {
                  show: true,
                  fontSize: '20',
                  fontWeight: 'bold',
                },
              },
              labelLine: {
                show: false,
              },
              data: [
                { value: 1048, name: '空闲' },
                { value: 102, name: '2小时' },
                { value: 53, name: '4小时' },
                { value: 44, name: '>4小时' },
                // { value: 300, name: '>3小时' }
              ],
            },
          ],
        }

        myChart.setOption(option)
        window.addEventListener('resize', function () {
          myChart.resize()
        })
      },
      init() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(this.$refs.main21)
        var option = {
          tooltip: {
            show: true,
            trigger: 'item',
            // formatter: '{a}<br/>{b}:{c} ({d}%)'
            formatter: '{b}:{c} ({d}%)',
          },
          legend: {
            top: '5%',
            left: 'center',
            textStyle: {
              //图例文字的样式
              color: '#fff',
              fontSize: 16,
            },
          },
          series: [
            {
              name: '停车位占用情况',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              label: {
                show: false,
                position: 'center',
              },
              emphasis: {
                label: {
                  // color:white,
                  show: true,
                  fontSize: '20',
                  fontWeight: 'bold',
                },
              },
              labelLine: {
                show: false,
              },
              data: [
                { value: 1048, name: '空闲' },
                { value: 735, name: '2小时' },
                { value: 580, name: '4小时' },
                { value: 484, name: '>4小时' },
                // { value: 300, name: '>3小时' }
              ],
            },
          ],
        }

        myChart.setOption(option)
        window.addEventListener('resize', function () {
          myChart.resize()
        })
      },
    },
  }
</script>

<style >

  #park  el-tabs el-tab-pane div {
    margin-left: -200px;
  }

  #park .labelcolor {
    color: white;
    font-size: 16px;
    height: 50px;
    line-height: 50px;
    display: inline-block;
  }

  #park .el-tabs__item  {
    height: 50px;
    color: white !important;
    font-size: 15px;
  }
  #park .el-tabs__item.is-active  {
    height: 50px;
    color: blue !important;
    font-size: 15px;
  }
  #park .notices {
    color: #c0c4cc;
    font-size: 14px;
    height: 100px;
    line-height: 100px;
    display: inline-block;
  }
  #park #main21 {
    margin-top: 40px;
    margin-left: -10px;
  }
  #park #main22 {
    margin-top: 40px;
    margin-left: -10px;
  }
  #park #main23 {
    margin-top: 40px;
    margin-left: -10px;
  }
</style>
