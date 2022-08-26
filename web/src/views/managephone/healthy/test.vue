<template>
  <div class="chrtt">
    <div id="picture" style="width: 100%; height: 400px"></div>
  </div>
</template>

<script>
  import * as echarts from 'echarts'
  export default {
    name: 'HealthyEcharts',
    data() {
      return {
        option: {
          color: ['#67F9D8', '#FFE434', '#56A3F1', '#FF917C'],
          title: {
            text: 'Customized Radar Chart',
          },
          legend: {},
          radar: [
            {
              indicator: [
                { text: 'Indicator1' },
                { text: 'Indicator2' },
                { text: 'Indicator3' },
                { text: 'Indicator4' },
                { text: 'Indicator5' },
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
                  value: [100, 100, 100, 100, 100],
                  // name: 'Data B',
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
        },
      }
    },
    created() {
      this.initEcharts()
    },
    mounted() {},
    methods: {
      initEcharts() {
        console.log(1)
        console.log(this.option.series[0].data[0].value[0])
        const setEchartWH = {
          width: 800,
          height: 400,
        }
        var that = this
        let newPromise = new Promise((resolve, reject) => {
          resolve()
        })
        newPromise.then(() => {
          var myChart = echarts.init(
            document.getElementById('picture'),
            null,
            setEchartWH
          )
          myChart.resize({
            width: this.width,
            height: this.height,
          })
          myChart.setOption(this.option)
        })
      },
    },
  }
</script>
<style lang="scss" scoped>
  #picture {
    margin-left: 200px;
    height: 600px;
    width: 800px;
  }
</style>
