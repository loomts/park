<template>
  <div id="main4" style="width: 500px; height: 450px"></div>
</template>

<script>
  import * as echarts from 'echarts'
  export default {
    name: 'Echart1',
    data() {
      return {
        seriesData: [[]],
      }
    },
    created() {
      setTimeout(() => {
        this.init()
      }, 100),
        this.init()
    },
    mounted() {},
    methods: {
      init() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main4'))

        function randomData() {
          now = new Date(+now + oneDay)
          value = value + Math.random() * 21 - 10
          return {
            name: now.toString(),
            value: [
              [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
              Math.round(value),
            ],
          }
        }
        let data = []
        let now = new Date(2018, 9, 1)
        let oneDay = 24 * 3600 * 1000
        let value = Math.random() * 1000
        for (var i = 0; i < 400; i++) {
          data.push(randomData())
        }
        var option = {
          title: {
            // text: 'Dynamic Data & Time Axis'
          },
          tooltip: {
            trigger: 'axis',
            formatter: function (params) {
              params = params[0]
              var date = new Date(params.name)
              return (
                date.getDate() +
                '/' +
                (date.getMonth() + 1) +
                '/' +
                date.getFullYear() +
                ' : ' +
                params.value[1]
              )
            },
            axisPointer: {
              animation: false,
            },
          },
          xAxis: {
            type: 'time',
            splitLine: {
              show: false,
            },
          },
          yAxis: {
            type: 'value',
            boundaryGap: [0, '100%'],
            splitLine: {
              show: false,
            },
          },
          series: [
            {
              name: 'Fake Data',
              type: 'line',
              showSymbol: false,
              data: data,
            },
          ],
        }
        setInterval(function () {
          for (var i = 0; i < 2; i++) {
            data.shift()
            data.push(randomData())
          }
          myChart.setOption({
            series: [
              {
                data: data,
              },
            ],
          })
        }, 1000)
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
