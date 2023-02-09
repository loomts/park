<template>
  <div
    id="main"
    style="background-color: white; display: absoulte; margin: 10px">
  
    <center style="height: 200px">
      <!--title-->
      <center>
        <div style="width=: 100%">
          <h1
            style="
              text-align: center;
              transition: 2s;
              letter-spacing: 10px;
              font-family: 'alimama';
        margin-top: 0px;
              color: #000;"
            class="key"
          >
            销售状况
          </h1>
        </div>
      </center>
      <!--数据-->
      <div
        style="
          width: 90%;
          height: 180px;
          margin-top: -20px;
          background-color: #F7F7F7;
          box-shadow: 0px 10px 15px -3px rgba(0, 0, 0, 0.1),
            0px 10px 15px -3px rgba(0, 0, 0, 0.1);
          border-radius: 20px;
        "
      >
        <div class="data">
          <div style="margin-top: 5px; margin-bottom: 5px">
            <!--装文字的-->
            <center>
              <span class="data1">今日销售额</span>
              <br />
              <span class="data2">134,425</span>
              <br />
              <span class="data3">园区全部商店总营业</span>
            </center>
          </div>
        </div>
        <div class="data">
          <div style="margin-top: 5px; margin-bottom: 5px">
            <center>
              <span class="data1">昨日销售额</span>
              <br />
              <span class="data2">112,480</span>
              <br />
              <span class="data3">园区全部商店总营业</span>
            </center>
          </div>
        </div>
        <div class="data">
          <div style="margin-top: 5px; margin-bottom: 5px">
            <center>
              <span class="data1">环比增长率</span>
              <br />
              <span class="data2">19.51%</span>
              <br />
              <span class="data3">昨日营业额相对今日营业额增长率</span>
            </center>
          </div>
        </div>
      </div>
    </center>

    <!-- 1  -->
    <div style="width: 100%">
      <el-container style="margin-top: 0px; width: 100%">
        <div
          id="BarChart1"
          style="
            margin: 10px;
      margin-left: 4%;
            width: 60%;
            height: 480px;
      background-color: #F7F7F7;
            box-shadow: 0px 10px 15px -3px rgba(0, 0, 0, 0.1),
              0px 10px 15px -3px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
          "
        ></div>
        <div
          id="AgeRange"
          style="
            margin: 10px;
      margin-left:4%;
            width: 30%;
            height: 480px;
      background-color: #F7F7F7;
            box-shadow: 0px 10px 15px -3px rgba(0, 0, 0, 0.1),
              0px 10px 15px -3px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
          "
        ></div>
      </el-container>
    </div>

    <!-- 2  -->
    <div style="width: 100%">
      <el-container style="margin-top: 20px; width: 100%">
        <div
          id="LinerChart1"
          style="
            margin: 10px;
      margin-left: 4%;
            width: 46%;
            height: 400px;
      background-color: #F7F7F7;
            box-shadow: 0px 10px 15px -3px rgba(0, 0, 0, 0.1),
              0px 10px 15px -3px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
          "
        ></div>
        <div
          id="piechart1"
          style="
            margin: 10px;
      margin-left: 4%;
            width: 46%;
            height: 400px;
      background-color: #F7F7F7;
            box-shadow: 0px 10px 15px -3px rgba(0, 0, 0, 0.1),
              0px 10px 15px -3px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
          "
        ></div>
      </el-container>
    </div>
  </div>
</template>
<script>
  var man =
    'M512 88m-88 0a88 88 0 1 0 176 0 88 88 0 1 0-176 0Z" p-id="12619" fill="#5B9BD5"></path><path d="M744.9 619.6c-21.3 5.7-43.3-6.9-49-28.3l-64.1-239c-1.2-4.5-7.9-3.6-7.9 1V1008c0 8.8-7.2 16-16 16h-64c-8.8 0-16-7.2-16-16V640c0-8.8-7.2-16-16-16s-16 7.2-16 16v368c0 8.8-7.2 16-16 16h-64c-8.8 0-16-7.2-16-16V353.3c0-4.7-6.7-5.6-7.9-1l-64.1 239c-5.7 21.3-27.7 34-49 28.3-21.3-5.7-34-27.6-28.3-49l69.5-260C339 240.7 402.4 192 474.8 192h74.3c72.5 0 135.9 48.7 154.6 118.7l69.5 260c5.7 21.3-6.9 43.2-28.3 48.9z'

  export default {
    name: 'Analyse',
    data() {
      return {
        src: '',
      }
    },
    mounted() {
      this.drawLiner()  //左下角
      this.PieChart1()  //右下角
      this.BarChart1()  //左上角
      this.AgeRange()
      this.ballChart()
    },
    methods: {
     /**********上面：进度球**************/
   drawLiner() {
     let ballChart = this.$echarts.init(
       document.getElementById('ballChart')
     )
      ballChart.setOption({
          // backgroundColor: "#050038",
          title: {
            text: `总完成`,
            left: "center",
            top: "100",
            textStyle: {
              fontWeight: "normal",
              fontSize: 20,
              color: "rgb(0,0,0)"
            },
            subtext: `${this.progress.num}%`, //副标题
            subtextStyle: {
              fontWeight: "bold",
              fontSize: 40,
              color: "rgb(0,0,0)"
            }
          },
   
          series: [
            {
              type: "liquidFill", // 图表类型
              radius: "80%",
              center: ["50%", "50%"],
              data: [
                this.progress.num / 100,
                this.progress.num / 100,
                this.progress.num / 100
              ], // data个数代表波浪数
              backgroundStyle: {
                borderWidth: 1,
                color: "#F4F9FF"
              },
              label: {
                normal: {
                  show: false, //不显示label  用副标题代替了
                  formatter: (0.5 * 100).toFixed(0) + "%",
                  textStyle: {
                    fontSize: 38,
                    color: "black"
                  }
                }
              },
              color: [  //color一定要是个数组 ，每一项对应一个波浪，可以给每个波浪单独配置颜色
                {
                  type: "linear",
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 1,
                      color: "rgba(255,255,255,1)"
                    },
                    {
                      offset: 0,
                      color: "rgba(103,205,251,1)"
                    }
                  ],
                  globalCoord: false
                },
                {
                  type: "linear",
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 1,
                      color: "rgba(187,248,252,0.5)"
                    },
                    {
                      offset: 0,
                      color: "rgba(30,134,245,1)"
                    }
                  ],
                  globalCoord: false
                },
                {
                  type: "linear",
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 1,
                      color: "rgba(180,251,255,0.66)"
                    },
                    {
                      offset: 0,
                      color: "rgba(128,122,254,0.66)"
                    }
                  ],
                  globalCoord: false
                }
              ],
              outline: {
                show: false
              }
            },
            //外层线
            {
              type: "pie",
              center: ["50%", "50%"],
              radius: ["92%", "93%"], //外层线粗细
              hoverAnimation: false,
              data: [
                {
                  name: "",
                  value: 100,
                  labelLine: {
                    show: false
                  },
                  itemStyle: {
                    color: "#67CDFB"
                  },
                  emphasis: {
                    labelLine: {
                      show: false
                    },
                    itemStyle: {
                      // color: "#5886f0"
                    }
                  }
                }
              ]
            },
            //进度线
            {
              type: "pie",
              center: ["50%", "50%"],
              radius: ["90%", "95%"], //进度线粗细
              hoverAnimation: false,
              data: [
                {
                  name: "",
                  value: this.progress.num, //进度
                  labelLine: {
                    show: false
                  },
                  itemStyle: {
                    color: {
                      type: "linear",
                      x: 0,
                      y: 0,
                      x2: 1,
                      y2: 2,
                      colorStops: [
                        // !! 在此添加渐变过程色 !!
                        { offset: 0, color: "#33E2ED" },
                        { offset: 1, color: "#807AFE" }
                      ]
                    }
                  },
                  emphasis: {
                    labelLine: {
                      show: false
                    },
                    itemStyle: {
                      // color: "#5886f0"
                    }
                  }
                },
                {
                  //画剩余的刻度圆环
                  name: "",
                  value: 100 - this.progress.num,
                  itemStyle: {
                    color: "rgba(0,0,0,0)"
                  },
                  label: {
                    show: false
                  },
                  labelLine: {
                    show: false
                  },
                  emphasis: {
                    labelLine: {
                      show: false
                    },
                    itemStyle: {
                      color: "#050038"
                    }
                  }
                }
              ]
            }
          ]
        });   
   },
   
   
   
    /**********各月销售额--左下角**************/
      drawLiner() {
        let LinerChart1 = this.$echarts.init(
          document.getElementById('LinerChart1')
        )
        LinerChart1.setOption({
          title: {
            text: '各月总销售额',
      left: '3%',
      top: '5%',
      textStyle: {
        //标题颜色
        color: '#000',
        fontFamily:'SourceHanSans-Bold',
        fontWeight:'bold',
        fontSize: 28,
        height: 150,
      },
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月'],
            axisLabel: {
              //下面的函数让x轴文字纵向显示
              show: true,
              textStyle: {
                color: '#333333',
              },
            },
          },
          yAxis: {
            type: 'value', //不管是横坐标还是纵坐标，我们要是想调整坐标轴的label的文字颜色，就要设置axisLabel参数
            axisLabel: {
              show: true,
              textStyle: {
                color: '#333333',
              },
            },
          },
          series: [
            {
              //纵坐标值。
              data: [220, 120, 220, 330, 300, 290, 190, 370, 410],
              type: 'line',
              //填充颜色设置
              areaStyle: {
                color: {
                  type: 'linear',
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 0,
                      color: 'red', // 0% 处的颜色
                    },
                    {
                      offset: 1,
                      color: 'yellow', // 100% 处的颜色
                    },
                  ],
                  global: false, // 缺省为 false
                },
              },
            },
          ],
          grid: [
            {
              containLabel: true, //grid 区域是否包含坐标轴的刻度标签
        bottom: '10%',
        height: '250px',
            },
          ],
        })
      },

      /***************右下角--总营业额构成********************/
      PieChart1() {
        let piechart1 = this.$echarts.init(document.getElementById('piechart1'))
        piechart1.setOption({
          title: {
            text: '总营业额构成',
            left: '3%',
      top: '5%',
            textStyle: {
              //标题颜色
              color: '#000',
        fontFamily:'SourceHanSans-Bold',
        fontWeight:'bold',
        fontSize: 28,
            },
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)',
          },
          toolbox: {
            show: true,
            feature: {
              mark: { show: true },
              dataView: { show: true, readOnly: false },
              restore: { show: true },
              saveAsImage: { show: true },
            },
          },
          series: [
            {
              //这个颜色是饼状图每一块内容的label颜色
              label: {
                normal: {
                  textStyle: {
                    color: '#333333',
                    fontSize: 16,
                  },
                },
              },
              radius: '60%', //饼图的半径大小
              center: ['50%', '60%'], //饼图的位置
              name: '销售额',
              type: 'pie',
              data: [
                { value: 1048, name: '奇奇蒂蒂淘淘铺' },
                { value: 1529, name: '迪士尼乐享家' },
                { value: 365, name: '达布隆集市' },
                { value: 484, name: '艾尔玩具店' },
                { value: 254, name: '大熊百货' },
                { value: 193, name: '老车站商店' },
                { value: 523, name: '美妙记忆屋' },
                { value: 745, name: '米奇商店' },
              ],
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)',
                },
              },
            },
          ],
        })
      },

      /*左上角----消费类型*/
      BarChart1() {
        let barchart1 = this.$echarts.init(document.getElementById('BarChart1'))
        barchart1.setOption({
          title: {
            text: '消费类型',
      left: '3%',
      top: '5%',
      textStyle: {
        //标题颜色
        color: '#000',
        fontFamily:'SourceHanSans-Bold',
        fontWeight:'bold',
        fontSize: 28,
        height: 150,
      },
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow',
            },
          },

          // legend: {
          //   data: ['消费人数'],
          //   left: 'right',
          //   textStyle: {
          //     //图例文字的样式
          //     color: '#333333',
          //     fontSize: 16,
          //   },
          // },
          grid: {
      bottom: '10%',
      height: '350',
            containLabel: true,
          },
          xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01],
            axisLabel: {
              //下面的函数让x轴文字纵向显示
              show: true,
              textStyle: {
                color: '#333333',
              },
            },
          },
          yAxis: {
            type: 'category',
            data: [
              '纪念品',
              '小吃',
              '美妆护肤',
              '迪士尼乐拍通',
              '玩具',
              '礼服、头饰',
              '扭蛋机',
            ],
            axisLabel: {
              //下面的函数让x轴文字纵向显示
              show: true,
              textStyle: {
                color: '#333333',
              },
            },
          },
          series: [
            {
              name: '消费人数',
              type: 'pictorialBar',
              symbolRepeat: 'fixed',
              // symbolMargin: '5%',
              symbol: 'roundRect',
              // 宽度-高度
              symbolSize: [3, 6],
              // 间隙
              symbolMargin: '10%',

              barWidth: '30%',
              symbolOffset: ['200%', '-30%'],
              itemStyle: {
                normal: {
                  color: '#5B9BD5',
                },
              },
              z: -11,
              symbolRepeat: true,
              symbolSize: ['40%', '120%'],
              data: [],
              barGap: 50,
              barCategoryGap: 0,
              animationEasing: 'elasticOut',

              data: [160, 110, 12, 42, 50, 20, 70],
              label: {
                textStyle: {
                  color: '#333333',
                },
              },
            },
          ],
        })
      },

      /*左上角第一个图：年龄分布图*/
      AgeRange() {
        let agerange = this.$echarts.init(document.getElementById('AgeRange'))
        agerange.setOption({
          title: {
            text: '消费者年龄分布统计图',
            left: '3%',
            top: '5%',
            textStyle: {
              //标题颜色
              color: '#000',
              fontFamily:'SourceHanSans-Bold',
              fontWeight:'bold',
              fontSize: 28,
              height: 150,
            },
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'none',
            },
            formatter: function (params) {
              return params[0].name + '：' + params[0].value + '%'
            },
          },
          xAxis: {
            data: ['少儿', '青年', '中年', '老年'],
            axisTick: { show: false },
            axisLine: { show: false },
            axisLabel: {
              textStyle: {
                color: '#444444',
                fontSize: 16,
              },
            },
          },
          yAxis: {
            splitLine: { show: false },
            axisTick: { show: false },
            axisLine: { show: false },
            axisLabel: { show: false },
          },
          color: ['#ED7D31', '#70AD47', '#8EC7F4', '#CDCBEC'],
          series: [
            {
              name: 'hill',
              type: 'pictorialBar',
              barCategoryGap: '0%',
              // symbol: 'path://M0,10 L10,10 L5,0 L0,10 z',
              symbol: 'path://path://M10 600 Q 95 0 180 600',
              label: {
                normal: {
                  show: true,
                  position: 'top',
                  formatter: '{c}%',
                },
              },
              itemStyle: {
                normal: {
                  opacity: 0.5,
                  color: function (params) {
                    var colorList = [
                      '#89DA4F',
                      '#FCC828',
                      '#8EC7F4',
                      '#CDCBEC',
                      '#14B961',
                      '#E3E3E3',
                    ]
                    return colorList[params.dataIndex]
                  },
                },
                emphasis: {
                  opacity: 1,
                },
              },
              data: [33, 42, 19, 6],
            },
          ],
        })
      },

    },
  }
</script>

<style scopted></style>

<style scoped>
  .container3 {
    margin-right: 10px;
  }

  .title1 {
    /* background-color: #ffff43; */
    border-radius: 5px;
    font-family: 幼圆;
    width: 120px;
    height: 20px;
  }
  .sycm ul {
    margin-left: -0.5rem;
    margin-right: -0.5rem;
    padding: 5px 0;
    list-style: none;
  }
  .sycm li {
    float: left;
    width: 33.33%;
    text-align: center;
    position: relative;
  }
  .sycm li:before {
    position: absolute;
    content: '';
    height: 30%;
    width: 1px;
    background: rgba(255, 255, 255, 0.1);
    right: 0;
    top: 15%;
  }
  .sycm li:last-child:before {
    width: 0;
  }

  .sycm li h2 {
    font-size: 35px;
    color: #ffc000;
  }
  .sycm li span {
    font-size: 25px;
    color: #4472c4;
    font-weight: bold;
  }

  .clearfix:after,
  .clearfix:before {
    display: table;
    content: ' ';
  }
  .clearfix:after {
    clear: both;
  }

  .key {
    opacity: 0;
  font-family: 'AlimamaShuHeiTi-Bold';
    animation: keynum 0.5s linear forwards;
  }
  @keyframes keynum {
    0% {
      opacity: 0;
      /* transform:rotateY(90deg); */
      font-size: 30px;
      font-family: '苹方';
      color: #999999;
      filter: blur(1);
    }
    100% {
      opacity: 1;
      /* transform: rotateY(0deg); */
      font-size: 60px;
      color: #555555;
      font-family: 'AlimamaShuHeiTi-Bold';
      filter: blur(0);
    }
  }
  .data {
    width: 30%;
    height: 200px;
    display: inline;
    float: left;
    margin: 1%;
  }
  .data1 {
    font-family: 'SourceHanSans-Bold';
    font-size: 24px;
    line-height: 30px;
    color: #000;
    font-weight: bold;
    text-align: center;
  }
  .data2 {
    font-family: 'YouSheBiaoTiHei-2';
    font-size: 50px;
    line-height: 75px;
    color: #007AFF;
    letter-spacing: 5px;
    text-align: center;
  }
  .data3 {
    font-family: 'SourceHanSans-Normal';
    font-size: 16px;
    color: #333333;
    line-height: 30px;
    text-align: center;
  }

/* 字体：阿里妈妈*/
@font-face {
    font-family: AlimamaShuHeiTi-Bold;
    src: url('./AlimamaShuHeiTi-Bold.otf');
  }

/* 字体:思源黑体-粗体 */
@font-face {
    font-family: SourceHanSans-Bold;
    src: url('./SourceHanSans-Bold.otf');
  }
 
/* 字体:优设标题黑 */
@font-face {
    font-family: YouSheBiaoTiHei-2;
    src: url('./YouSheBiaoTiHei-2.ttf');
  }

/* 字体:思源黑体 */
@font-face {
    font-family: SourceHanSans-Normal;
    src: url('./SourceHanSans-Normal.otf');
  }
  
  
</style>
