<template>
  <div id="main5" ref="main5" style="width: 380px; height: 300px"></div>
</template>

<script>
  import * as echarts from 'echarts'
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
        var myChart = echarts.init(this.$refs.main5)

        let base = +new Date(2010, 9, 3)
        let oneDay = 24 * 3600 * 1000
        let data = [[base, Math.random() * 300]]
        for (let i = 1; i < 4300; i++) {
          let now = new Date((base += oneDay))
          data.push([
            +now,
            Math.round((Math.random() - 0.5) * 20 + data[i - 1][1]),
          ])
        }
        var option = {
          tooltip: {
            trigger: 'axis',
            position: function (pt) {
              return [pt[0], '10%']
            },
          },
          title: {
            left: 'center',
            // text: 'Large Ara Chart'
          },
          toolbox: {
            feature: {
              dataZoom: {
                yAxisIndex: 'none',
              },
              restore: {},
              saveAsImage: {},
            },
          },
          xAxis: {
            type: 'time',
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
            boundaryGap: false,
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
            boundaryGap: [0, '100%'],
          },
          dataZoom: [
            {
              type: 'inside',
              start: 0,
              end: 20,
            },
            {
              start: 0,
              end: 20,
            },
          ],
          series: [
            {
              // name: 'Fake Data',
              type: 'line',
              smooth: true,
              symbol: 'none',
              areaStyle: {},
              data: data,
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

<style lang="scss" scoped></style>
