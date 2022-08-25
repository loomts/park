<template>
  <div>
    <!-- <button @click="change" data-id="1">1</button>
      <button @click="change" data-id="2">2</button>
      <button @click="change" data-id="3">23</button> -->

    <el-tabs :tab-position="tabPosition" style="height: 380px; stretch: true">
      <el-tab-pane label="地下停车场1">
        <div id="main21" style="width: 400px; height: 300px"></div>
      </el-tab-pane>
      <el-tab-pane label="地下停车场2">
        <div id="main22" style="width: 400px; height: 300px"></div>
      </el-tab-pane>
      <el-tab-pane label="地下停车场3">
        <div id="main23" style="width: 400px; height: 300px"></div>
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
      }, 100)
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
        var myChart = echarts.init(document.getElementById('main23'))
        var option = {
          tooltip: {
            show: true,
            trigger: 'item',
            formatter: '{a}<br/>{b}:{c} ({d}%)',
          },
          legend: {
            top: '5%',
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
        var myChart = echarts.init(document.getElementById('main22'))
        var option = {
          tooltip: {
            show: true,
            trigger: 'item',
            formatter: '{a}<br/>{b}:{c} ({d}%)',
          },
          legend: {
            top: '5%',
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
        var myChart = echarts.init(document.getElementById('main21'))
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

<style lang="scss">
  // button {
  //   border: none;
  //   padding: 15px 30px;
  //   font-size: 16px;
  //   font-family: Arial, 微软雅黑;
  //   color: white;
  //   background: #447aa8;
  //   border-radius: 3px;
  // }
  //  el-tabs{
  // padding-top: 100px;
  // }
  el-tabs el-tab-pane div {
    margin-left: -200px;
  }
</style>
