<template>
  <div>
    <div
      id="bottomLeftChart"
      style="
        width: 1160px;
        height: 500px;
        padding-left: 30px;
        margin-top: 25px;
        border-top: dashed white 1px;
        padding-top: 30px;
      "
    ></div>
  </div>
</template>
<script type="text/javascript">
  import echartMixins from '@/utils/resizeMixins'
  import * as allApi from '../../../../api.js'
  export default {
    mixins: [echartMixins],
    data() {
      return {
        chart: null,
      }
    },
    mounted() {
      this.draw()
    },
    destroyed() {
      window.onresize = null
    },
    methods: {
      async getHistFlowData() {
        let list = []
        var jsonObj = await allApi.getHistFlow()
        for (var i = 0; i < jsonObj.length && list.length < 50; i++) {
          if (jsonObj[i].humanFlow < 50000) list.push(jsonObj[i].humanFlow)
        }
        return list
      },
      async getNowFlowData() {
        let list = []
        var jsonObj = await allApi.getHistFlow()
        for (var i = 51; i < jsonObj.length && list.length < 50; i++) {
          if (jsonObj[i].humanFlow > 10000 && jsonObj[i].humanFlow < 60000)
            list.push(jsonObj[i].humanFlow - 15000)
        }
        return list
      },
      async draw() {
        // 基于准备好的dom，初始化echarts实例
        this.chart = this.$echarts.init(
          document.getElementById('bottomLeftChart')
        )
        //  ----------------------------------------------------------------
        let category = [
          '01分',
          '02分',
          '03分',
          '04分',
          '05分',
          '06分',
          '07分',
          '08分',
          '09分',
          '10分',
          '11分',
          '12分',
          '13分',
          '14分',
          '15分',
          '16分',
          '17分',
          '18分',
          '19分',
          '20分',
          '21分',
          '22分',
          '23分',
          '24分',
          '25分',
          '26分',
          '27分',
          '28分',
          '29分',
          '30分',
          '31分',
          '32分',
          '33分',
          '34分',
          '35分',
        ]
        let lineData = await this.getHistFlowData()
        let barData = await this.getNowFlowData()
        let rateData = []
        for (let i = 0; i < 35; i++) {
          let rate = barData[i] / lineData[i]
          rateData[i] = rate.toFixed(2)
        }
        let option = {
          title: {
            text: '',
            x: 'center',
            y: 0,
            textStyle: {
              color: '#B4B4B4',
              fontSize: 16,
              fontWeight: 'normal',
            },
          },
          tooltip: {
            trigger: 'axis',
            backgroundColor: 'rgba(255,255,255,0.1)',
            axisPointer: {
              type: 'shadow',
              label: {
                show: true,
                backgroundColor: '#7B7DDC',
              },
            },
          },
          legend: {
            data: ['当前人流量', '截至目前总人流量', '承载率'],
            textStyle: {
              color: '#B4B4B4',
            },
            top: '0%',
          },
          grid: {
            x: '8%',
            width: '88%',
            y: '4%',
          },
          xAxis: {
            data: category,
            axisLine: {
              lineStyle: {
                color: '#B4B4B4',
              },
            },
            axisTick: {
              show: false,
            },
          },
          yAxis: [
            {
              splitLine: { show: false },
              axisLine: {
                lineStyle: {
                  color: '#B4B4B4',
                },
              },

              axisLabel: {
                formatter: '{value} ',
              },
            },
            {
              splitLine: { show: false },
              axisLine: {
                lineStyle: {
                  color: '#B4B4B4',
                },
              },
              axisLabel: {
                formatter: '{value} ',
              },
            },
          ],
          series: [
            {
              name: '承载率',
              type: 'line',
              smooth: true,
              showAllSymbol: true,
              symbol: 'emptyCircle',
              symbolSize: 8,
              yAxisIndex: 1,
              itemStyle: {
                normal: {
                  color: '#F02FC2',
                },
              },
              data: rateData,
            },

            {
              name: '当前人流量',
              type: 'bar',
              barWidth: 10,
              itemStyle: {
                normal: {
                  barBorderRadius: 5,
                  color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                    { offset: 0, color: '#956FD4' },
                    { offset: 1, color: '#3EACE5' },
                  ]),
                },
              },
              data: barData,
            },

            {
              name: '截至目前总人流量',
              type: 'bar',
              barGap: '-100%',
              barWidth: 10,
              itemStyle: {
                normal: {
                  barBorderRadius: 5,
                  color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                    { offset: 0, color: 'rgba(156,107,211,0.8)' },
                    { offset: 0.2, color: 'rgba(156,107,211,0.5)' },
                    { offset: 1, color: 'rgba(156,107,211,0.2)' },
                  ]),
                },
              },
              z: -12,

              data: lineData,
            },
          ],
        }
        this.chart.setOption(option)
      },
    },
  }
</script>
<style lang="scss" scoped></style>
