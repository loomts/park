<template>
  <div>
    <div id="myChart2" :style="{ width: '100%', height: '530px' }" />
    <div id="myChart3" :style="{ width: '100%', height: '530px' }" />
    <div id="myChart4" :style="{ width: '100%', height: '600px' }" />
    <div id="myChart" :style="{ width: '100%', height: '1000px' }" />
    <!-- <img src="D:/桌面（D盘）/c4/vue_c4/src/assets/pakingLot.jpeg" /> -->
  </div>
</template>
<script>
  export default {
    mounted() {
      this.drawLine()
    },

    methods: {
      drawLine() {
        // 基于准备好的dom，初始化echarts实例
        const myChart = this.$echarts.init(document.getElementById('myChart'))
        const myChart2 = this.$echarts.init(document.getElementById('myChart2'))
        const myChart3 = this.$echarts.init(document.getElementById('myChart3'))
        const myChart4 = this.$echarts.init(document.getElementById('myChart4'))
        const seriesLabel = { show: true }
        myChart.setOption({
          //官网实例代码
          title: {
            text: '各停车场空车位情况 2022年7月2日',
          },

          legend: {},
          tooltip: {
            trigger: 'axis',
            showContent: false,
          },
          dataset: {
            source: [
              [
                'product',
                '10:00',
                '11:00',
                '12:00',
                '13:00',
                '14:00',
                '15:00',
                '16:00',
              ],
              ['P1', 381, 155, 101, 154, 123, 155, 165],
              ['P2', 329, 145, 102, 202, 161, 161, 172],
              ['P3', 200, 53, 23, 111, 63, 89, 87],
              ['P4', 132, 43, 12, 52, 51, 66, 54],
            ],
          },
          xAxis: { type: 'category' },
          yAxis: { gridIndex: 0 },
          grid: { top: '55%' },
          series: [
            {
              type: 'line',
              smooth: true,
              seriesLayoutBy: 'row',
              emphasis: { focus: 'series' },
            },
            {
              type: 'line',
              smooth: true,
              seriesLayoutBy: 'row',
              emphasis: { focus: 'series' },
            },
            {
              type: 'line',
              smooth: true,
              seriesLayoutBy: 'row',
              emphasis: { focus: 'series' },
            },
            {
              type: 'line',
              smooth: true,
              seriesLayoutBy: 'row',
              emphasis: { focus: 'series' },
            },
            {
              type: 'pie',
              id: 'pie',
              radius: '30%',
              center: ['50%', '25%'],
              emphasis: {
                focus: 'self',
              },
              label: {
                formatter: '{b}: {@10:00} ({d}%)',
              },
              encode: {
                itemName: 'product',
                value: '10:00',
                tooltip: '10:00',
              },
            },
          ],
        })

        myChart2.setOption({
          title: {
            text: '停车场P1当前车位使用情况 2022年7月2日',
          },
          series: [
            {
              type: 'gauge',
              startAngle: 180,
              endAngle: 0,
              min: 0,
              max: 415,
              splitNumber: 5,
              itemStyle: {
                color: '#58D9F9',
                shadowColor: 'rgba(0,138,255,0.45)',
                shadowBlur: 10,
                shadowOffsetX: 2,
                shadowOffsetY: 2,
              },
              progress: {
                show: true,
                roundCap: true,
                width: 18,
              },
              pointer: {
                icon: 'path://M2090.36389,615.30999 L2090.36389,615.30999 C2091.48372,615.30999 2092.40383,616.194028 2092.44859,617.312956 L2096.90698,728.755929 C2097.05155,732.369577 2094.2393,735.416212 2090.62566,735.56078 C2090.53845,735.564269 2090.45117,735.566014 2090.36389,735.566014 L2090.36389,735.566014 C2086.74736,735.566014 2083.81557,732.63423 2083.81557,729.017692 C2083.81557,728.930412 2083.81732,728.84314 2083.82081,728.755929 L2088.2792,617.312956 C2088.32396,616.194028 2089.24407,615.30999 2090.36389,615.30999 Z',
                length: '75%',
                width: 16,
                offsetCenter: [0, '5%'],
              },
              axisLine: {
                roundCap: true,
                lineStyle: {
                  width: 18,
                },
              },
              axisTick: {
                splitNumber: 2,
                lineStyle: {
                  width: 2,
                  color: '#999',
                },
              },
              splitLine: {
                length: 12,
                lineStyle: {
                  width: 3,
                  color: '#999',
                },
              },
              axisLabel: {
                distance: 30,
                color: '#999',
                fontSize: 20,
              },
              title: {
                show: false,
              },
              detail: {
                backgroundColor: '#fff',
                borderColor: '#999',
                borderWidth: 2,
                width: '60%',
                lineHeight: 40,
                height: 70,
                borderRadius: 8,
                offsetCenter: [0, '35%'],
                valueAnimation: true,
                formatter: function (value) {
                  return (
                    '{value|' +
                    value.toFixed(0) +
                    '}{unit|个车位已使用\n( 165 个车位未使用)}'
                  )
                },
                rich: {
                  value: {
                    fontSize: 30,
                    fontWeight: 'bolder',
                    color: '#777',
                  },
                  unit: {
                    fontSize: 14,
                    color: '#999',
                    padding: [0, 0, -5, 10],
                  },
                },
              },
              data: [
                {
                  value: 250,
                },
              ],
            },
          ],
        })
        myChart3.setOption({
          title: {
            text: '停车场P2当前车位使用情况 2022年7月2日',
          },
          series: [
            {
              type: 'gauge',
              startAngle: 180,
              endAngle: 0,
              min: 0,
              max: 414,
              splitNumber: 6,
              itemStyle: {
                color: '#58D9F9',
                shadowColor: 'rgba(0,138,255,0.45)',
                shadowBlur: 10,
                shadowOffsetX: 2,
                shadowOffsetY: 2,
              },
              progress: {
                show: true,
                roundCap: true,
                width: 18,
              },
              pointer: {
                icon: 'path://M2090.36389,615.30999 L2090.36389,615.30999 C2091.48372,615.30999 2092.40383,616.194028 2092.44859,617.312956 L2096.90698,728.755929 C2097.05155,732.369577 2094.2393,735.416212 2090.62566,735.56078 C2090.53845,735.564269 2090.45117,735.566014 2090.36389,735.566014 L2090.36389,735.566014 C2086.74736,735.566014 2083.81557,732.63423 2083.81557,729.017692 C2083.81557,728.930412 2083.81732,728.84314 2083.82081,728.755929 L2088.2792,617.312956 C2088.32396,616.194028 2089.24407,615.30999 2090.36389,615.30999 Z',
                length: '75%',
                width: 16,
                offsetCenter: [0, '5%'],
              },
              axisLine: {
                roundCap: true,
                lineStyle: {
                  width: 18,
                },
              },
              axisTick: {
                splitNumber: 2,
                lineStyle: {
                  width: 2,
                  color: '#999',
                },
              },
              splitLine: {
                length: 12,
                lineStyle: {
                  width: 3,
                  color: '#999',
                },
              },
              axisLabel: {
                distance: 30,
                color: '#999',
                fontSize: 20,
              },
              title: {
                show: false,
              },
              detail: {
                backgroundColor: '#fff',
                borderColor: '#999',
                borderWidth: 2,
                width: '60%',
                lineHeight: 40,
                height: 70,
                borderRadius: 8,
                offsetCenter: [0, '35%'],
                valueAnimation: true,
                formatter: function (value) {
                  return (
                    '{value|' +
                    value.toFixed(0) +
                    '}{unit|个车位已使用\n( 169 个车位未使用)}'
                  )
                },
                rich: {
                  value: {
                    fontSize: 30,
                    fontWeight: 'bolder',
                    color: '#777',
                  },
                  unit: {
                    fontSize: 14,
                    color: '#999',
                    padding: [0, 0, -5, 10],
                  },
                },
              },
              data: [
                {
                  value: 245,
                },
              ],
            },
          ],
        })
        myChart4.setOption({
          title: {
            text: '停车场P3当前车位使用情况 2022年7月2日',
          },
          series: [
            {
              type: 'gauge',
              startAngle: 180,
              endAngle: 0,
              min: 0,
              max: 165,
              splitNumber: 5,
              itemStyle: {
                color: '#58D9F9',
                shadowColor: 'rgba(0,138,255,0.45)',
                shadowBlur: 10,
                shadowOffsetX: 2,
                shadowOffsetY: 2,
              },
              progress: {
                show: true,
                roundCap: true,
                width: 18,
              },
              pointer: {
                icon: 'path://M2090.36389,615.30999 L2090.36389,615.30999 C2091.48372,615.30999 2092.40383,616.194028 2092.44859,617.312956 L2096.90698,728.755929 C2097.05155,732.369577 2094.2393,735.416212 2090.62566,735.56078 C2090.53845,735.564269 2090.45117,735.566014 2090.36389,735.566014 L2090.36389,735.566014 C2086.74736,735.566014 2083.81557,732.63423 2083.81557,729.017692 C2083.81557,728.930412 2083.81732,728.84314 2083.82081,728.755929 L2088.2792,617.312956 C2088.32396,616.194028 2089.24407,615.30999 2090.36389,615.30999 Z',
                length: '75%',
                width: 16,
                offsetCenter: [0, '5%'],
              },
              axisLine: {
                roundCap: true,
                lineStyle: {
                  width: 18,
                },
              },
              axisTick: {
                splitNumber: 2,
                lineStyle: {
                  width: 2,
                  color: '#999',
                },
              },
              splitLine: {
                length: 12,
                lineStyle: {
                  width: 3,
                  color: '#999',
                },
              },
              axisLabel: {
                distance: 30,
                color: '#999',
                fontSize: 20,
              },
              title: {
                show: false,
              },
              detail: {
                backgroundColor: '#fff',
                borderColor: '#999',
                borderWidth: 2,
                width: '60%',
                lineHeight: 40,
                height: 70,
                borderRadius: 8,
                offsetCenter: [0, '35%'],
                valueAnimation: true,
                formatter: function (value) {
                  return (
                    '{value|' +
                    value.toFixed(0) +
                    '}{unit|个车位已使用\n( 54 个车位未使用)}'
                  )
                },
                rich: {
                  value: {
                    fontSize: 30,
                    fontWeight: 'bolder',
                    color: '#777',
                  },
                  unit: {
                    fontSize: 14,
                    color: '#999',
                    padding: [0, 0, -5, 10],
                  },
                },
              },
              data: [
                {
                  value: 111,
                },
              ],
            },
          ],
        })
        /*
        myChart3.setOption({
          //官网实例代码

          title: {
            text: '当前车位使用情况 2022年7月2日',
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow',
            },
          },
          legend: {
            data: ['未使用', '已使用', '总量'],
          },
          grid: {
            left: 100,
          },
          toolbox: {
            show: true,
            feature: {
              saveAsImage: {},
            },
          },
          xAxis: {
            type: 'value',
            name: '个',
            axisLabel: {
              formatter: '{value}',
            },
          },
          yAxis: {
            type: 'category',
            inverse: true,
            data: ['停车场P1', '停车场P2', '停车场P3', '停车场P4'],
            axisLabel: {
              formatter: function (value) {
                return '{value|' + value + '}'
              },
              margin: 20,

              rich: {
                value: {
                  lineHeight: 30,
                  align: 'center',
                },
                停车场P1: {
                  height: 40,
                  align: 'center',
                },
                停车场P2: {
                  height: 40,
                  align: 'center',
                },
                停车场P3: {
                  height: 40,
                  align: 'center',
                },
                停车场P4: {
                  height: 40,
                  align: 'center',
                },
              },
            },
          },
          series: [
            {
              name: '未使用',
              type: 'bar',
              data: [165, 172, 87, 54],
              label: seriesLabel,
              markPoint: {
                symbolSize: 1,
                symbolOffset: [0, '50%'],
                label: {
                  formatter: '{a|{a}\n}{b|{b} }{c|{c}}',
                  backgroundColor: 'rgb(242,242,242)',
                  borderColor: '#aaa',
                  borderWidth: 1,
                  borderRadius: 4,
                  padding: [4, 10],
                  lineHeight: 26,
                  position: 'right',
                  distance: 20,
                  rich: {
                    a: {
                      align: 'center',
                      color: '#fff',
                      fontSize: 18,
                      textShadowBlur: 2,
                      textShadowColor: '#000',
                      textShadowOffsetX: 0,
                      textShadowOffsetY: 1,
                      textBorderColor: '#333',
                      textBorderWidth: 2,
                    },
                    b: {
                      color: '#333',
                    },
                    c: {
                      color: '#ff8811',
                      textBorderColor: '#000',
                      textBorderWidth: 1,
                      fontSize: 22,
                    },
                  },
                },
              },
            },
            {
              name: '已使用',
              type: 'bar',
              label: seriesLabel,
              data: [250, 245, 205, 111],
            },
            {
              name: '总量',
              type: 'bar',
              label: seriesLabel,
              data: [415, 417, 292, 165],
            },
          ],
        })*/
      },
    },
  }
</script>
