<template>
  <div id="main" ref="main" style="width: 350px; height: 350px"></div>
</template>

<script>
  import * as echarts from 'echarts'
  // import { htmlWhitespaceSensitivity } from '../../../../prettier.config'
  export default {
    name: 'Echart1',
    data() {
      return {}
    },
    created() {
      setTimeout(() => {
        this.init()
      }, 1000)
        // this.init()
    },
    mounted() {},
    methods: {
      init() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(this.$refs.main)

        var option = {
          xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            axisLine: {
              lineStyle: {
                type: 'solid',
                color: '#fff', //左边线的颜色
                width: '2', //坐标线的宽度
              },
            },
            axisLabel: {
              textStyle: {
                color: '#fff', //坐标值得具体的颜色
              },
            },
          },
          yAxis: {
            type: 'value',
            axisLine: {
              lineStyle: {
                type: 'solid',
                color: '#fff', //左边线的颜色
                width: '2', //坐标线的宽度
              },
            },
            axisLabel: {
              textStyle: {
                color: '#fff', //坐标值得具体的颜色
              },
            },
          },
          series: [
            {
              data: [120, 200, 150, 80, 70, 110, 130],
              type: 'bar',
              label: {
                show: true,
                // position: 'up',
                // valueAnimation:true
              },
              showBackground: true,
              backgroundStyle: {
                color: 'rgba(180, 180, 180, 0.2)',
              },
            },
          ],
        }

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option)
        window.addEventListener('resize', function () {
          myChart.resize()
        })
      },
    },
  }
</script>

<style lang="scss" scoped>
  #main {
    // width:30%;
    // height: 30%;
    padding-left: 40px;
    padding-top: 4px;
  }
</style>
