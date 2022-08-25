<template>
  <div>
    <div>
      <span
        style="
          font-size: 27px;
          color: gray; /*#909399*/
          margin: 25px;
          font-weight: bold;
          margin-top: 40px;
          line-height: 100px;
        "
      >
        智慧车位管理
      </span>
    </div>

    <el-row :gutter="20">
      <div>
        <!-- 顶部四个标签 -->
      </div>
      <el-col :span="20" style="margin-left: 80px">
        <el-card
          class="card"
          shadow="always"
          style="
            width: 22%;
            height: 115px;
            margin-left: -10px;
            display: inline-block;
            float: left;
          "
        >
          <div class="topBox">
            <span
              style="
                font-size: 23px;
                display: inline-block;
                float: left;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              异常
              <br />
              状态
            </span>
            <div id="topLeft" class="topImg"><img src="./allert.png" /></div>
            <span
              style="
                font-size: 8px;
                color: gray /*#ff8b8b*/;
                margin-left: 28px;
                font-weight: bold;
              "
            >
              车位损坏x3
            </span>
          </div>
        </el-card>
        <el-card
          class="card"
          shadow="always"
          style="
            width: 22%;
            height: 115px;
            margin-left: 35px;
            display: inline-block;
            float: left;
          "
        >
          <div class="topBox">
            <span
              style="
                font-size: 23px;
                display: inline-block;
                float: left;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              今日
              <br />
              营收
            </span>
            <div id="topLeft" class="topImg"><img src="./wallet.png" /></div>
            <span
              style="
                font-size: 8px;
                color: gray /*#ff8b8b*/;
                margin-left: 28px;
                font-weight: bold;
              "
            >
              合计：5.4w
            </span>
          </div>
        </el-card>
        <el-card
          class="card"
          shadow="always"
          style="
            width: 22%;
            height: 115px;
            margin-left: 35px;
            display: inline-block;
            float: left;
          "
        >
          <div class="topBox">
            <span
              style="
                font-size: 23px;
                display: inline-block;
                float: left;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              空闲
              <br />
              车位
            </span>
            <div id="topLeft" class="topImg">
              <img src="./parkinglot.png" />
            </div>
            <span
              style="
                font-size: 8px;
                color: gray /*#ff8b8b*/;
                margin-left: 28px;
                font-weight: bold;
              "
            >
              合计：445
            </span>
          </div>
        </el-card>
        <el-card
          class="card"
          shadow="always"
          style="
            width: 22%;
            height: 115px;
            margin-left: 45px;
            display: inline-block;
            float: left;
          "
        >
          <div class="topBox">
            <span
              style="
                font-size: 23px;
                display: inline-block;
                float: left;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              实况
              <br />
              查询
            </span>
            <div id="topLeft" class="topImg"><img src="./collect.png" /></div>
            <span
              style="
                font-size: 8px;
                color: gray /*#ff8b8b*/;
                margin-left: 28px;
                font-weight: bold;
              "
            >
              点击查询
            </span>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <!-- 停车场情况 三个标签 -->
    <el-row :gutter="20">
      <el-col :span="20" style="margin-left: 80px">
        <el-card
          class="card"
          shadow="always"
          style="
            display: 'inline';
            float: left;
            width: 30%;
            height: 335px;
            margin-left: 22px;
          "
        >
          <div>
            <span
              style="
                font-size: 25px;
                display: block;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              停车场P1
            </span>
            <span style="font-size: 18px; color: #909399">具体情况</span>
            <div
              id="Chart1"
              :style="{
                width: '100%',
                height: '240px',
                border: '0px solid black',
                margin: '0px 0px',
              }"
            ></div>
          </div>
        </el-card>
        <el-card
          class="card"
          shadow="always"
          style="
            display: 'inline';
            float: left;
            width: 30%;
            height: 335px;
            margin-left: 21px;
          "
        >
          <div>
            <span
              style="
                font-size: 25px;
                display: block;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              停车场P2
            </span>
            <span style="font-size: 18px; color: #909399; margin: 0px 0px">
              具体情况
            </span>
            <div
              id="Chart2"
              style="
                width: 100%;
                height: 215px;
                border-width: 0px;
                border-style: solid;
                margin: 0px 0px;
                padding: 0px 0px;
                border-color: gainsboro;
                border-radius: 8px;
              "
            ></div>
          </div>
        </el-card>
        <el-card
          class="card"
          shadow="always"
          style="
            display: 'inline';
            float: left;
            width: 30%;
            height: 335px;
            margin-left: 15px;
          "
        >
          <div>
            <span
              style="
                font-size: 25px;
                display: block;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              停车场P3
            </span>
            <span style="font-size: 18px; color: #909399">具体情况</span>
            <div
              id="Chart3"
              :style="{
                width: '100%',
                height: '240px',
                border: '0px solid black',
                margin: '0px 0px',
              }"
            ></div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 大图表 -->
    <el-row :gutter="20">
      <el-col :span="20" style="margin-left: 40px; margin-top: 20px">
        <el-card
          class="card"
          shadow="always"
          style="
            display: 'inline';
            float: left;
            width: 100%;
            height: 435px;
            margin-left: 40px;
          "
        >
          <div>
            <div
              id="Chart4"
              style="
                width: 100%;
                height: 215px;
                border-width: 0px;
                border-style: solid;
                margin: 0px 0px;
                padding: 0px 0px;
                border-color: gainsboro;
                border-radius: 8px;
              "
            ></div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 最底部两个标签 -->
    <el-row :gutter="20">
      <el-col :span="20" style="margin-left: 40px">
        <el-card
          class="card"
          shadow="always"
          style="
            display: 'inline';
            float: left;
            width: 37%;
            height: 365px;
            margin-left: 12px;
            margin-top: 10px;
          "
        >
          <div>
            <div
              id="Chart5"
              :style="{
                width: '100%',
                height: '150px',
                border: '0px solid black',
                margin: '0px 0px',
              }"
              style="margin-bottom: 5px; border-bottom: 1px solid #909399"
            ></div>
            <el-divider></el-divider>
            <div
              id="Chart6"
              :style="{
                width: '100%',
                height: '150px',
                border: '0px solid black',
                margin: '15px 0px',
              }"
            ></div>
          </div>
        </el-card>
        <el-card
          class="card"
          shadow="always"
          style="
            display: 'inline';
            float: left;
            width: 595px;
            height: 395px;
            margin-left: 31px;
          "
        >
          <div>
            <span
              style="
                font-size: 20px;
                display: block;
                margin: 10px 0px;
                font-weight: bold;
                color: #909399;
              "
            >
              进出车次统计
            </span>
          </div>

          <el-table :data="tableData" style="width: 100%">
            <el-table-column
              prop="province"
              label="来源地"
              width="270"
              align="center"
            ></el-table-column>
            <el-table-column
              prop="collect"
              label="车辆数"
              width="270"
              align="center"
            ></el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [
          {
            province: '上海',
            collect: '898',
          },
          {
            province: '南京',
            collect: '792',
          },
          {
            province: '武汉',
            collect: '545',
          },
          {
            province: '合肥',
            collect: '443',
          },
          {
            province: '杭州',
            collect: '314',
          },
          {
            province: '南昌',
            collect: '252',
          },
          {
            province: '其他',
            collect: '234',
          },
        ],
      }
    },

    mounted() {
      this.drawLine1()
      this.setLine()
      this.drawIt()
      this.drawLeft()
      // this.drawRight()
    },

    methods: {
      drawLine1() {
        const Chart1 = this.$echarts.init(document.getElementById('Chart1'))
        const Chart2 = this.$echarts.init(document.getElementById('Chart2'))
        const Chart3 = this.$echarts.init(document.getElementById('Chart3'))
        Chart1.setOption({
          series: [
            {
              type: 'gauge',
              startAngle: 180,
              endAngle: 0,
              min: 0,
              max: 415,
              splitNumber: 5,
              itemStyle: {
                color: '#FF8B8B',
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
                fontSize: 8,
              },
              title: {
                show: false,
              },
              detail: {
                backgroundColor: '#fff',
                borderColor: '#999',
                borderWidth: 0,
                width: '80%',
                lineHeight: 40,
                height: 70,
                borderRadius: 8,
                offsetCenter: [0, '55%'],
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
        Chart2.setOption({
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
                fontSize: 8,
              },
              title: {
                show: false,
              },
              detail: {
                backgroundColor: '#fff',
                borderColor: '#999',
                borderWidth: 0,
                width: '80%',
                lineHeight: 40,
                height: 70,
                borderRadius: 8,
                offsetCenter: [0, '65%'],
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
                  value: 295,
                },
              ],
            },
          ],
        })
        Chart3.setOption({
          series: [
            {
              type: 'gauge',
              startAngle: 180,
              endAngle: 0,
              min: 0,
              max: 165,
              splitNumber: 5,
              itemStyle: {
                color: '#B4E197',
                shadowColor: 'rgba(0,138,255,0.25)',
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
                fontSize: 8,
              },
              title: {
                show: false,
              },
              detail: {
                backgroundColor: '#fff',
                borderColor: '#999',
                borderWidth: 0,
                width: '80%',
                lineHeight: 40,
                height: 70,
                borderRadius: 8,
                offsetCenter: [0, '55%'],
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
                  value: 13,
                },
              ],
            },
          ],
        })
      },
      setLine() {
        //const Chart4 = this.$echarts.init(document.getElementById('Chart4'))
        var Chart4 = this.$echarts.init(
          document.getElementById('Chart4'),
          null,
          {
            width: 1000,
            height: 430,
          }
        )
        var option
        const axisData = [
          '10:00',
          '11:00',
          '12:00',
          '13:00',
          '14:00',
          '15:00',
          '16:00',
          '17:00',
          '18:00',
          '19:00',
          '20:00',
          '21:00',
          '22:00',
        ]
        const data = [
          0, 3503, 3216, 5148, 9218, 12643, 13921, 11198, 9820, 8764, 7740,
          6500, 1530,
        ]
        // = axisData.map(function (item, i) {
        //   return
        //   //return Math.round(Math.random() * 1000 * (i + 1));
        // });
        const links = data.map(function (item, i) {
          return {
            source: i,
            target: i + 1,
          }
        })
        links.pop()
        option = {
          title: {
            text: '今日收费情况 >> 每小时',
          },
          tooltip: {},
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: axisData,
          },
          yAxis: {
            type: 'value',
          },
          series: [
            {
              type: 'graph',
              layout: 'none',
              coordinateSystem: 'cartesian2d',
              symbolSize: 40,
              label: {
                show: true,
              },
              edgeSymbol: ['circle', 'arrow'],
              edgeSymbolSize: [4, 10],
              data: data,
              links: links,
              lineStyle: {
                color: '#2f4554',
              },
            },
          ],
        }
        // var app = {};

        // var chartDom = document.getElementById('main');
        // const Chart4 = this.$echarts.init(document.getElementById('Chart4'))
        // var option;

        // const categories = (function () {
        //   let now = new Date();
        //   let res = [];
        //   let len = 10;
        //   while (len--) {
        //     res.unshift(now.toLocaleTimeString().replace(/^\D*/, ''));
        //     now = new Date(+now + 12000);
        //   }
        //   return res;
        // })();
        // const categories2 = (function () {
        //   let res = [];
        //   let len = 10;
        //   while (len--) {
        //     res.push(10 - len - 1);
        //   }
        //   return res;
        // })();
        // const data = (function () {
        //   let res = [];
        //   let len = 10;
        //   while (len--) {
        //     res.push(Math.round(Math.random() * 1000));
        //   }
        //   return res;
        // })();
        // const data2 = (function () {
        //   let res = [];
        //   let len = 0;
        //   while (len < 10) {
        //     res.push(+(Math.random() * 10 + 5).toFixed(1));
        //     len++;
        //   }
        //   return res;
        // })();
        // option = {
        //   title: {
        //     text: '景区车位收费情况 2022/7/31',
        //     textStyle:{
        //       color: '#909399',
        //       fontSize: 17,
        //       margin: 0
        //     },
        //   },
        //   tooltip: {
        //     trigger: 'axis',
        //     axisPointer: {
        //       type: 'cross',
        //       label: {
        //         backgroundColor: '#283b56'
        //       }
        //     }
        //   },
        //   legend: {},
        //   toolbox: {
        //     show: true,
        //     feature: {
        //       dataView: { readOnly: false },
        //       restore: {},
        //       saveAsImage: {}
        //     }
        //   },
        //   dataZoom: {
        //     show: false,
        //     start: 0,
        //     end: 100
        //   },
        //   xAxis: [
        //     {
        //       type: 'category',
        //       boundaryGap: true,
        //       data: categories
        //     },
        //     {
        //       type: 'category',
        //       boundaryGap: true,
        //       data: categories2
        //     }
        //   ],
        //   yAxis: [
        //     {
        //       type: 'value',
        //       scale: true,
        //       name: 'Price(appraisement)',
        //       max: 30,
        //       min: 0,
        //       boundaryGap: [0.2, 0.2]
        //     },
        //     {
        //       type: 'value',
        //       scale: true,
        //       name: 'Total Price(during 1 minute)',
        //       max: 1200,
        //       min: 0,
        //       boundaryGap: [0.2, 0.2]
        //     }
        //   ],
        //   series: [
        //     {
        //       name: '车数',
        //       type: 'bar',
        //       xAxisIndex: 1,
        //       yAxisIndex: 1,
        //       data: data
        //     },
        //     {
        //       name: '费用/车辆',
        //       type: 'line',
        //       data: data2
        //     }
        //   ]
        // };
        // app.count = 11;
        // setInterval(function () {
        //   let axisData = new Date().toLocaleTimeString().replace(/^\D*/, '');
        //   data.shift();
        //   data.push(Math.round(Math.random() * 1000));
        //   data2.shift();
        //   data2.push(+(Math.random() * 10 + 5).toFixed(1));
        //   categories.shift();
        //   categories.push(axisData);
        //   categories2.shift();
        //   categories2.push(app.count++);
        //   Chart4.setOption({
        //     xAxis: [
        //       {
        //         data: categories
        //       },
        //       {
        //         data: categories2
        //       }
        //     ],
        //     series: [
        //       {
        //         data: data
        //       },
        //       {
        //         data: data2
        //       }
        //     ]
        //   });
        // }, 2100);

        option && Chart4.setOption(option)
      },
      drawIt() {
        const Chart5 = this.$echarts.init(document.getElementById('Chart5'))

        var option

        option = {
          title: {
            text: '驿停车辆统计',
            textStyle: {
              color: '#909399',
              fontSize: 13,
            },
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              // Use axis to trigger tooltip
              type: 'shadow', // 'shadow' as default; can also be 'line' or 'shadow'
            },
          },
          legend: { top: 20 },
          grid: {
            left: '2%',
            right: '4%',
            bottom: '13%',
            top: '30%',
            containLabel: true,
          },
          xAxis: {
            type: 'value',
          },
          yAxis: {
            type: 'category',
            data: ['22/7/31'],
          },
          series: [
            {
              name: '今日新增',

              type: 'bar',
              stack: 'total',
              label: {
                show: true,
              },
              emphasis: {
                focus: 'series',
              },
              data: [529],
            },
            {
              name: '历史统计',
              type: 'bar',
              stack: 'total',
              label: {
                show: true,
              },
              emphasis: {
                focus: 'series',
              },
              data: [1271],
            },
          ],
        }

        option && Chart5.setOption(option)
      },
      drawLeft() {
        const Chart6 = this.$echarts.init(document.getElementById('Chart6'))

        var option

        option = {
          title: {
            text: '微信关注人数',
            textStyle: {
              color: '#909399',
              fontSize: 13,
            },
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              // Use axis to trigger tooltip
              type: 'shadow', // 'shadow' as default; can also be 'line' or 'shadow'
            },
          },
          legend: { top: 20 },
          grid: {
            left: '2%',
            right: '4%',
            bottom: '13%',
            top: '30%',
            containLabel: true,
          },
          xAxis: {
            type: 'value',
          },
          yAxis: {
            type: 'category',
            data: ['22/7/31'],
          },
          series: [
            {
              name: '今日新增',

              type: 'bar',
              stack: 'total',
              label: {
                show: true,
              },
              emphasis: {
                focus: 'series',
              },
              data: [418],
            },
            {
              name: '历史统计',
              type: 'bar',
              stack: 'total',
              label: {
                show: true,
              },
              emphasis: {
                focus: 'series',
              },
              data: [1082],
            },
          ],
        }

        option && Chart6.setOption(option)
      },
      // drawRight(){
      //   const Chart7 = this.$echarts.init(document.getElementById('Chart7'))
      //   var option;

      //   option = {
      //     title:{
      //       text: '进出车辆统计',
      //       left: 'left',
      //       textStyle:{
      //         color: '#909399',
      //         fontSize: 13,
      //         margin: 0
      //       }
      //     },
      //     tooltip: {
      //       trigger: 'axis',
      //       axisPointer: {
      //         // Use axis to trigger tooltip
      //         type: 'shadow' // 'shadow' as default; can also be 'line' or 'shadow'
      //       }
      //     },
      //     legend: {top:30},
      //     grid: {
      //       left: '3%',
      //       right: '4%',
      //       bottom: '3%',
      //       containLabel: true
      //     },
      //     xAxis: {
      //       type: 'value'
      //     },
      //     yAxis: {
      //       type: 'category',
      //       data: ['其他', '南昌', '杭州', '合肥', '武汉', '南京', '上海']
      //     },
      //     series: [
      //       {
      //         name: '今日新增',
      //         type: 'bar',
      //         stack: 'total',
      //         label: {
      //           show: true
      //         },
      //         emphasis: {
      //           focus: 'series'
      //         },
      //         data: [320, 302, 301, 334, 390, 330, 320]
      //       },
      //       {
      //         name: '停留超3小时',
      //         type: 'bar',
      //         stack: 'total',
      //         label: {
      //           show: true
      //         },
      //         emphasis: {
      //           focus: 'series'
      //         },
      //         data: [120, 132, 101, 134, 90, 230, 210]
      //       },
      //       {
      //         name: '尚在场',
      //         type: 'bar',
      //         stack: 'total',
      //         label: {
      //           show: true
      //         },
      //         emphasis: {
      //           focus: 'series'
      //         },
      //         data: [220, 182, 191, 234, 290, 330, 310]
      //       },
      //       {
      //         name: '已离开',
      //         type: 'bar',
      //         stack: 'total',
      //         label: {
      //           show: true
      //         },
      //         emphasis: {
      //           focus: 'series'
      //         },
      //         data: [150, 212, 201, 154, 190, 330, 410]
      //       },
      //       {
      //         name: '历史累计',
      //         type: 'bar',
      //         stack: 'total',
      //         label: {
      //           show: true
      //         },
      //         emphasis: {
      //           focus: 'series'
      //         },
      //         data: [820, 832, 901, 934, 1290, 1330, 1320]
      //       }
      //     ]
      //   };

      //   option && Chart7.setOption(option);

      // }
    },
  }
</script>

<style lang="scss" scoped>
  .topBox {
    width: 100%;
    height: 85px;
    display: inline-block;
    float: left;
    margin-left: 25px;
    border: 0px solid;
  }

  .topImg {
    padding-left: 80px;
    padding-top: 5px;
    border: 0px solid;
  }

  .fontLeft {
    font-size: 20px;
    display: inline-block;
    float: left;
    margin: 10px 10px;
    color: #909399;
  }

  .fontRight {
    font-size: 20px;
    display: inline-block;
    float: right;
    margin: 10px 10px;
    color: #909399;
  }

  .index-container {
    padding: 0 !important;
    margin: 0 !important;
    background: #f5f7f8 !important;

    ::v-deep {
      .el-alert {
        padding: $base-padding;

        &--info.is-light {
          min-height: 82px;
          padding: $base-padding;
          margin-bottom: 15px;
          color: #909399;
          background-color: $base-color-white;
          border: 1px solid #ebeef5;
        }
      }

      .el-card__body {
        .echarts {
          width: 100%;
          height: 1500px;
        }
      }
    }

    .card {
      ::v-deep {
        .el-card__body {
          .echarts {
            width: 100%;
            height: 1500px;
          }
        }
      }
    }
    .image1 {
      width: 30%;
      display: block;
    }

    .bottom {
      padding-top: 20px;
      margin-top: 5px;
      color: #595959;
      text-align: left;
      border-top: 1px solid $base-border-color;
    }

    .table {
      width: 100%;
      color: #666;
      border-collapse: collapse;
      background-color: #fff;

      td {
        position: relative;
        min-height: 20px;
        padding: 9px 15px;
        font-size: 14px;
        line-height: 20px;
        border: 1px solid #e6e6e6;

        &:nth-child(odd) {
          width: 20%;
          text-align: right;
          background-color: #f7f7f7;
        }
      }
    }

    .icon-panel {
      height: 117px;
      text-align: center;
      cursor: pointer;

      svg {
        font-size: 40px;
      }

      p {
        margin-top: 10px;
      }
    }

    .bottom-btn {
      button {
        margin: 5px 10px 15px 0;
      }
    }
    .el-divider--horizontal {
      margin: 26px 15px !important;

      .el-divider__text {
        color: gray;
        font-size: 25px;
      }
    }
  }
</style>
