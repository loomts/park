<template>
  <div>
    <div>
      <span
        style="
          font-size: 20px;
          color: #909399;
          margin: 50px;
          line-height: 100px;
        "
      >
        防控查询
      </span>
    </div>

    <!--  <div id="map" ref="map" class="map"></div> -->
    <!-- </div> -->

    <el-row :gutter="20">
      <!--  <div v-show="show"> -->
      <el-col :span="20" style="margin: 50px">
        <el-card class="card" shadow="always">
          <div slot="header">
            <span style="font-size: 20px; color: #909399">IP查询</span>
          </div>
          <div>
            <el-input
              v-model="input"
              placeholder="输入查询用户的IP地址"
              clearable
            ></el-input>
            <!-- <el-input v-model="input" placeholder="输入查询用户的IP地址"></el-input> -->
          </div>
          <div style="margin: 20px; float: right">
            <el-button
              native-type="submit"
              type="primary"
              size="medium"
              icon="el-icon-search"
              @click="queryIP"
            >
              搜索
            </el-button>
          </div>
        </el-card>
      </el-col>

      <div v-show="show3">
        <!-- 导航栏模块 -->
        <el-col :span="20" style="margin: 50px; margin-bottom: 0px">
          <el-button @click="goAnchor('map')">感染者路径一览</el-button>
          <el-button @click="goAnchor('User_22')">感染者路径信息</el-button>
          <el-button @click="goAnchor('User_65')">密接者信息</el-button>
          <!-- <el-button  @click="goAnchor('User_97') ">密接者3</el-button>
          <el-button  @click="goAnchor('User_97') ">密接者4</el-button>
          <el-button  @click="goAnchor('User_97') ">密接者5</el-button>
          <el-button  @click="goAnchor('User_97') ">密接者6</el-button>   -->
          <el-button
            type="primary"
            size="medium"
            style="margin-left: 20px"
            @click="show3 = !show3"
          >
            重置
          </el-button>
          <!-- <el-button  @click=" ">密接者3</el-button> -->
          <!-- <el-button type="primary" size="medium" @click="show = !show">重置
            </el-button> -->
        </el-col>

        <el-col :span="20" style="margin: 50px">
          <el-card class="card" :visible.sync="center">
            <div>
              <div id="map" ref="map" class="map"></div>
            </div>
            <!-- <img src="@/assets/way.png" style="width: 1260px; height: 800px" /> -->
          </el-card>
        </el-col>

        <el-col :span="20" style="margin: 30px">
          <div class="block">
            <el-timeline>
              <div slot="header">
                <span style="font-size: 20px; color: #909399">密接者记录</span>
              </div>
              <el-timeline-item
                id="User_22"
                timestamp="感染者路径信息"
                placement="top"
              >
                <el-card>
                  <div>
                    <el-table :data="tableData" style="width: 100%">
                      <el-table-column
                        prop="address"
                        label="到达地点"
                        height="30"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="time"
                        label="到达时间"
                        width="180"
                        height="30"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="way"
                        label="途经路径"
                        width="300"
                        height="30"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="long"
                        label="停留时长"
                        align="center"
                        height="30"
                      ></el-table-column>
                      <el-table-column
                        prop="tag"
                        label="密接者数量"
                        width="90"
                        :filter-method="filterTag"
                        filter-placement="bottom-end"
                        align="center"
                        height="30"
                      >
                        <div slot-scope="scope">
                          <el-tag
                            :type="scope.row.tag >= 200 ? 'danger' : 'primary'"
                            disable-transitions
                          >
                            {{ scope.row.tag }}
                          </el-tag>
                        </div>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-card>
              </el-timeline-item>
              <el-timeline-item
                id="User_65"
                timestamp="密接者信息"
                placement="top"
              >
                <el-card>
                  <div>
                    <el-table :data="tableData2" style="width: 100%">
                      <el-table-column
                        prop="way"
                        label="IP地址"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="long"
                        label="用户ID"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="time"
                        label="接触时间"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="address"
                        label="接触位置"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="tag"
                        label="接触距离"
                        width="180"
                        :filter-method="filterTag"
                        filter-placement="bottom-end"
                        align="center"
                      >
                        <div slot-scope="scope">
                          <el-tag
                            :type="scope.row.tag <= 5 ? 'danger' : 'primary'"
                            disable-transitions
                          >
                            {{ scope.row.tag }}
                          </el-tag>
                        </div>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-card>
              </el-timeline-item>

              <!-- <el-timeline-item timestamp="User_97" placement="top" id="User_97">
                <el-card>
                  <div>
                    <el-table :data="tableData2" style="width: 100%">
                      <el-table-column
                        prop="way"
                        label="IP地址"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="time"
                        label="接触时间"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="address"
                        label="接触位置"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="long"
                        label="接触时长"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="tag"
                        label="接触距离"
                        width="180"
                        :filter-method="filterTag"
                        filter-placement="bottom-end"
                        align="center"
                      >
                        <div slot-scope="scope">
                          <el-tag
                            :type="
                              scope.row.tag <= 5 ? 'primary' : 'success'
                            "
                            disable-transitions
                          >
                            {{ scope.row.tag }}
                          </el-tag>
                        </div>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-card>
              </el-timeline-item> -->
            </el-timeline>
          </div>
        </el-col>
      </div>
    </el-row>
  </div>
</template>

<script
  type="text/javascript"
  src="http://api.map.baidu.com/api?v=3.0&ak=zIqWyMZvUlRW8IMU9djlFeTBhGytYp1Q"
></script>
<script>
  /* eslint-disable */
  import * as echarts from 'echarts'
  import { dependencies, devDependencies } from '../../../../package.json'
  import { getList } from '@/api/changeLog'
  import { getNoticeList } from '@/api/notice'
  require('echarts/extension/bmap/bmap')

  export default {
    // name: "Map",
    data() {
      return {
        chart: '',
        bmap: {}, //定义一个当前的bmap
        mapStyle: {
          styleJson: [
            {
              featureType: 'land',
              elementType: 'geometry',
              stylers: {
                color: '#081734',
              },
            },
            {
              featureType: 'building',
              elementType: 'geometry',
              stylers: {
                color: '#04406F',
              },
            },
            {
              featureType: 'building',
              elementType: 'labels',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'highway',
              elementType: 'geometry',
              stylers: {
                color: '#015B99',
              },
            },
            {
              featureType: 'highway',
              elementType: 'labels',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'arterial',
              elementType: 'geometry',
              stylers: {
                color: '#003051',
              },
            },
            {
              featureType: 'arterial',
              elementType: 'labels',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'green',
              elementType: 'geometry',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'water',
              elementType: 'geometry',
              stylers: {
                color: '#044161',
              },
            },
            {
              featureType: 'subway',
              elementType: 'geometry.stroke',
              stylers: {
                color: '#003051',
              },
            },
            {
              featureType: 'subway',
              elementType: 'labels',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'railway',
              elementType: 'geometry',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'railway',
              elementType: 'labels',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'all',
              elementType: 'labels.text.stroke',
              stylers: {
                color: '#313131',
              },
            },
            {
              featureType: 'all',
              elementType: 'labels.text.fill',
              stylers: {
                color: '#FFFFFF',
              },
            },
            {
              featureType: 'manmade',
              elementType: 'geometry',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'manmade',
              elementType: 'labels',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'local',
              elementType: 'geometry',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'local',
              elementType: 'labels',
              stylers: {
                visibility: 'off',
              },
            },
            {
              featureType: 'subway',
              elementType: 'geometry',
              stylers: {
                lightness: -65,
              },
            },
            {
              featureType: 'railway',
              elementType: 'all',
              stylers: {
                lightness: -40,
              },
            },
            {
              featureType: 'boundary',
              elementType: 'geometry',
              stylers: {
                color: '#8b8787',
                weight: '1',
                lightness: -29,
              },
            },
          ],
        },
        geoCoordMap: [
          {
            name: '米奇大街',
            value: [121.668006, 31.147929],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
          {
            name: '探险岛',
            value: [121.669479, 31.149412],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
          {
            name: '宝藏湾',
            value: [121.669354, 31.151372],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
          {
            name: '明日世界',
            value: [121.663712, 31.147558],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
          {
            name: '梦幻世界',
            value: [121.666337, 31.150738],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
          {
            name: '迪士尼·皮克斯玩具总动员',
            value: [121.661448, 31.150927],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
          {
            name: '上海迪士尼乐园酒店',
            value: [121.672557, 31.141867],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
          {
            name: '玩具总动员酒店',
            value: [121.659886, 31.145592],
            tooltip: {
              formatter: '时间:8:30am<br/>出发地:玩具总动员酒店',
            },
          },
        ],
        line: [
          {
            fromName: '上海迪士尼乐园酒店',
            toName: '玩具总动员酒店',
            coords: [
              [121.672557, 31.141867],
              [121.659886, 31.145592],
            ],
          },
          {
            fromName: '玩具总动员酒店',
            toName: '迪士尼·皮克斯玩具总动员',
            coords: [
              [121.659886, 31.145592],
              [121.661448, 31.150927],
            ],
          },
          {
            fromName: '迪士尼·皮克斯玩具总动员',
            toName: '梦幻世界',
            coords: [
              [121.661448, 31.150927],
              [121.666337, 31.150738],
            ],
          },
          {
            fromName: '梦幻世界',
            toName: '明日世界',
            coords: [
              [121.666337, 31.150738],
              [121.663712, 31.147558],
            ],
          },
          {
            fromName: '明日世界',
            toName: '宝藏湾',
            coords: [
              [121.663712, 31.147558],
              [121.669354, 31.151372],
            ],
          },
          {
            fromName: '宝藏湾',
            toName: '探险岛',
            coords: [
              [121.669354, 31.151372],
              [121.669479, 31.149412],
            ],
          },
          {
            fromName: '探险岛',
            toName: '米奇大街',
            coords: [
              [121.669479, 31.149412],
              [121.668006, 31.147929],
            ],
          },
          {
            fromName: '米奇大街',
            toName: '上海迪士尼乐园酒店',
            coords: [
              [121.668006, 31.147929],
              [121.672557, 31.141867],
            ],
          },
        ],
        // COLORS:["red", "yellow", "pink", "#900"]

        show3: false,
        timer: 0,
        input: '',
        updateTime: process.env.VUE_APP_UPDATE_TIME,
        nodeEnv: process.env.NODE_ENV,
        dependencies: dependencies,
        devDependencies: devDependencies,
        tableData: [
          {
            way: '——上海迪士尼乐园酒店',
            time: '08:50:34',
            address: '上海迪士尼乐园酒店',
            long: '50min',
            tag: '121',
          },
          {
            way: '上海迪士尼乐园酒店——玩具总动员酒店',
            time: '09:45:32',
            address: '玩具总动员酒店',
            long: '22min',
            tag: '98',
          },
          {
            way: '玩具总动员酒店——迪士尼·皮克斯玩具总动员',
            time: '10:12:27',
            address: '迪士尼·皮克斯玩具总动员',
            long: '43min',
            tag: '372',
          },
          {
            way: '迪士尼·皮克斯玩具总动员——梦幻世界',
            time: '12:50:34',
            address: '梦幻世界',
            long: '23min',
            tag: '393',
          },
          {
            way: '梦幻世界——明日世界',
            time: '13:10:55',
            address: '明日世界',
            long: '22min',
            tag: '246',
          },
          {
            way: '明日世界——宝藏湾',
            time: '14:00:27',
            address: '宝藏湾',
            long: '43min',
            tag: '371',
          },
          ,
          {
            way: '宝藏湾——探险岛',
            time: '14:43:34',
            address: '探险岛',
            long: '35min',
            tag: '431',
          },
          {
            way: '探险岛——米奇大街',
            time: '15:30:55',
            address: '米奇大街',
            long: '22min',
            tag: '258',
          },
          {
            way: '米奇大街——上海迪士尼乐园酒店',
            time: '16:00:27',
            address: '上海迪士尼乐园酒店',
            long: '72min',
            tag: '209',
          },
        ],
        tableData1: [
          {
            way: '192.168.2.105',
            time: '10:50:58',
            address: '梦幻世界',
            long: 'User_06',
            tag: '20.14',
          },
          {
            way: '192.168.1.108',
            time: '10:50:58',
            address: '梦幻世界',
            long: 'User_02',
            tag: '27.11',
          },
          {
            way: '192.168.2.35',
            time: '10:50:58',
            address: '梦幻世界',
            long: 'User_43',
            tag: '24.34',
          },
          {
            way: '192.168.2.105',
            time: '10:50:58',
            address: '梦幻世界',
            long: 'User_06',
            tag: '21.89',
          },
          {
            way: '192.168.2.35',
            time: '11:22:55',
            address: '梦幻世界',
            long: 'User_43',
            tag: '10.00',
          },
          {
            way: '192.168.2.105',
            time: '10:50:58',
            address: '梦幻世界',
            long: 'User_06',
            tag: '5.14',
          },
          {
            way: '192.168.2.105',
            time: '10:50:58',
            address: '梦幻世界',
            long: 'User_06',
            tag: '3.15',
          },
          {
            way: '192.168.2.105',
            time: '10:50:58',
            address: '梦幻世界',
            long: 'User_06',
            tag: '6.19',
          },
          {
            way: '192.168.3.141',
            time: '11:44:27',
            address: '梦幻世界',
            long: 'User_14',
            tag: '3.24',
          },
          {
            way: '192.168.2.105',
            time: '12:50:34',
            address: '探险岛',
            long: 'User_06',
            tag: '18.00',
          },
          {
            way: '192.168.2.105',
            time: '13:45:55',
            address: '宝藏湾',
            long: 'User_06',
            tag: '28.64',
          },
          {
            way: '192.168.2.105',
            time: '14:32:27',
            address: '奇想花园',
            long: 'User_06',
            tag: '10.25',
          },
        ],
        tableData2: [],
        // tableData2: [
        //     {
        //       way: '192.168.2.105',
        //       time: '10:50:34',
        //       address: '园区入口',
        //       long: '50min',
        //       tag: '2.34',
        //     },
        //     {
        //       way: '192.168.2.105',
        //       time: '11:45:32',
        //       address: '奇想花园',
        //       long: '22min',
        //       tag: '8.89',
        //     },
        //     {
        //       way: '192.168.2.105',
        //       time: '12:50:34',
        //       address: '梦幻世界',
        //       long: '23min',
        //       tag: '200.63',
        //     },
        //     {
        //       way: '192.168.2.105',
        //       time: '14:10:55',
        //       address: '皮克斯玩具总动员',
        //       long: '22min',
        //       tag: '70.11',
        //     },
        //     {
        //       way: '192.168.2.105',
        //       time: '15:00:27',
        //       address: '明日世界',
        //       long: '43min',
        //       tag: '20.34',
        //     },
        //     ,
        //     {
        //       way: '192.168.2.105',
        //       time: '16:43:34',
        //       address: '明日世界',
        //       long: '35min',
        //       tag: '35.60',
        //     },
        //     {
        //       way: '192.168.2.105',
        //       time: '17:30:55',
        //       address: '奇想花园',
        //       long: '22min',
        //       tag: '10.11',
        //     },
        // ],
      }
    },
    mounted() {
      this.$nextTick(() => {
        this.loadBMap('zIqWyMZvUlRW8IMU9djlFeTBhGytYp1Q').then(() => {
          this.initMap()
          this.goAnchor()
        })
      })
    },
    methods: {
      queryIP() {
        this.show3 = !this.show3
        if (this.show3 == true) {
          this.tableData2 = []
          for (var i = 0; i < this.tableData1.length; i++) {
            if (this.input == '' || this.input == this.tableData1[i].way) {
              this.tableData2.push(this.tableData1[i])
            }
          }
        }
      },
      loadBMap(ak) {
        return new Promise(function (resolve, reject) {
          if (typeof BMap !== 'cd wundefined') {
            resolve(BMap)
            return true
          }
          window.onBMapCallback = function () {
            resolve(BMap)
          }
          let script = document.createElement('script')
          script.type = 'text/javascript'
          script.src =
            'http://api.map.baidu.com/api?v=2.0&ak=' +
            ak +
            '&__ec_v__=20190126&callback=onBMapCallback'
          script.onerror = reject
          document.head.appendChild(script)
        })
      },
      // 页面锚点:锚点定位+滚动条滚动 效果实现
      goAnchor(idNum) {
        document.querySelector('#' + idNum).scrollIntoView(false)
      },
      initMap() {
        this.chart = this.$echarts.init(this.$refs.map)
        //初始化echarts
        this.chart.setOption({
          animation: true,
          legend: {
            orient: 'vertical',
            top: 10,
            left: 10,
            // data: linesData.map(v => v.name),
            textStyle: {
              color: '#FFFFFF',
            },
            selectedMode: 'multiple',
          },
          bmap: {
            // 加载 bmap 组件
            center: [121.654287, 31.154914], //沪芦高速
            zoom: 16,
            roam: true,
            label: {
              show: true,
            },
            mapStyle: this.mapStyle,
          },
          // visualMap: {
          //   type: "piecewise",
          //   inverse: true,
          //   top: 10,
          //   left: 10,
          //   pieces: [
          //     {
          //       value: 0,
          //       color: this.COLORS[0]
          //     },
          //     {
          //       value: 1,
          //       color: this.COLORS[1]
          //     },
          //     {
          //       value: 2,
          //       color: this.COLORS[2]
          //     },
          //     {
          //       value: 3,
          //       color: this.COLORS[3]
          //     }
          //   ],
          //   borderColor: "#ccc",
          //   borderWidth: 2,
          //   backgroundColor: "#eee",
          //   dimension: 2,
          //   inRange: {
          //     color: this.COLORS,
          //     opacity: 0.7
          //   }
          // },
          tooltip: {
            show: true,
            trigger: 'item',
            hideDelay: 4000,
            formatter: function (d) {
              var tool = '经度：' + d.value[0] + '<br/>'
              tool += '纬度：' + d.value[1]
              console.log(tool)
              return tool
            },
          },
          series: [
            {
              name: '地点',
              type: 'effectScatter',
              coordinateSystem: 'bmap',
              polyline: true,
              data: this.geoCoordMap,
              silent: true,
              label: {
                normal: {
                  show: true,
                  position: 'right',
                  formatter: '{b}',
                  color: 'yellow',
                },
              },
              symbolSize: 10,
              showEffectOn: 'render',
              itemStyle: {
                normal: {
                  color: 'red',
                },
              },
              progressiveThreshold: 100,
              progressive: 400,
            },
            {
              name: '轨迹路线',
              type: 'lines',
              coordinateSystem: 'bmap',
              silent: true, // 图形不响应和触发鼠标事件
              polyline: false,
              lineStyle: { color: 'red', width: '2' },
              z: 15,
              data: this.line,
              effect: {
                show: true,
                period: 3, //轨迹移动的实体指向速度，值越小速度越快
                trailLength: 0.5, //特效尾迹长度[0,1]值越大，尾迹越长重
                color: 'yellow',
                symbol:
                  'path://M30.9,53.2C16.8,53.2,5.3,41.7,5.3,27.6S16.8,2,30.9,2C45,2,56.4,13.5,56.4,27.6S45,53.2,30.9,53.2z M30.9,3.5C17.6,3.5,6.8,14.4,6.8,27.6c0,13.3,10.8,24.1,24.101,24.1C44.2,51.7,55,40.9,55,27.6C54.9,14.4,44.1,3.5,30.9,3.5z M36.9,35.8c0,0.601-0.4,1-0.9,1h-1.3c-0.5,0-0.9-0.399-0.9-1V19.5c0-0.6,0.4-1,0.9-1H36c0.5,0,0.9,0.4,0.9,1V35.8z M27.8,35.8 c0,0.601-0.4,1-0.9,1h-1.3c-0.5,0-0.9-0.399-0.9-1V19.5c0-0.6,0.4-1,0.9-1H27c0.5,0,0.9,0.4,0.9,1L27.8,35.8L27.8,35.8z', //轨迹移动的实体
                symbolSize: 15, //图标大小
              },
            },
          ],
        })
        this.bmap = this.chart.getModel().getComponent('bmap').getBMap()
        this.bmap.addControl(
          new BMap.ScaleControl({ anchor: BMAP_ANCHOR_BOTTOM_RIGHT })
        ) // 在左下角显示比例尺控件
        this.bmap.addEventListener('click', function (e) {
          alert(e.point.lng + ',' + e.point.lat)
        })
      },
    },
  }
</script>

<style lang="scss" scoped>
  .map {
    width: 2500px;
    height: 800px;
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
      .el-card__hearder {
        color: gray;
        font-size: 20px;
        font-weight: bold;
      }
      .el-card__body {
        .echarts {
          width: 100%;
          height: 1500px;
        }
      }
    }

    .card {
      height: 1000px;
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
  }
</style>
