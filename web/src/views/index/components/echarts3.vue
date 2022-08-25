<template>
  <!-- 具备一个宽高的dom -->
  <div
    ref="main"
    style="height: 600px; width: 50%; overflow: hidden"
    @dblclick="revertMap"
  ></div>
</template>

<script>
  // 导入echarts
  import * as echarts from 'echarts'
  // 中国地图
  import chianJson from '@/assets/map/china.json'
  // 导入echarts主题
  require('@/theme/shine')
  // axios
  import axios from 'axios'
  // 各省份对应的矢量数据地址
  import { getProvinceMapInfo } from '@/utils/map-utils'
  export default {
    name: 'ChinaMap',
    data() {
      return {
        chart: '',
      }
    },
    mounted() {
      this.$nextTick(() => {
        this.initChart()
        window.addEventListener('resize', this.screenAdapter)
        this.screenAdapter()
      })
    },
    methods: {
      initChart() {
        // init第一个参数 ref定义的的，第二个参数主题
        this.chart = echarts.init(this.$refs.main, 'shine')
        echarts.registerMap('chain', chianJson)
        this.chart.setOption({
          title: {
            text: '游客来源地',
            left: 20,
            top: 20,
          },
          geo: {
            type: 'map', // 类型
            map: 'chain',
            top: '5%', // 距离顶部
            bottom: '5%', // 距离底部
            itemStyle: {
              // 地图区域的样式。
              areaColor: '#2E72BF', // 地图整体区域的颜色
              borderColor: '#333', //地图边界线的颜色
            },
          },
          // 自定义提示框的内容
          tooltip: {
            trigger: 'item',
            // 自定义提示框的内容
            formatter(params) {
              return (
                '<div>' + params.data.name
                // " <br> " +
                // params.seriesName +
                // "</div>"
              )
            },
          },
          // 散点图
          series: [
            {
              type: 'effectScatter', //特效散点图
              rippleEffect: {
                // 涟漪效果
                scale: 5,
                brushType: 'stroke',
              },
              coordinateSystem: 'geo', // 使用坐标
              // name: "一线城市",
              data: [
                { name: '北京', value: [116.46, 39.92] },
                { name: '上海', value: [121.48, 31.22] },
                { name: '广州', value: [113.23, 23.16] },
                { name: '深圳', value: [114.07, 22.62] },
                { name: '鄂尔多斯', value: [109.781327, 39.608266] },
                { name: '舟山', value: [122.207216, 29.985295] },
                { name: '张家口', value: [114.87, 40.82] },
                { name: '盐城', value: [120.13, 33.38] },
                { name: '赤峰', value: [118.87, 42.28] },
                { name: '青岛', value: [120.33, 36.07] },
                { name: '乳山', value: [121.52, 36.89] },
                { name: '金昌', value: [102.188043, 38.520089] },
                { name: '泉州', value: [118.58, 24.93] },
                { name: '莱西', value: [120.53, 36.86] },
                { name: '日照', value: [119.46, 35.42] },
                { name: '胶南', value: [119.97, 35.88] },
                { name: '南通', value: [121.05, 32.08] },
                { name: '拉萨', value: [91.11, 29.97] },
                { name: '云浮', value: [112.02, 22.93] },
                { name: '梅州', value: [116.1, 24.55] },
                { name: '文登', value: [122.05, 37.2] },
                { name: '上海', value: [121.48, 31.22] },
                { name: '威海', value: [122.1, 37.5] },
                { name: '承德', value: [117.93, 40.97] },
                { name: '厦门', value: [118.1, 24.46] },
                { name: '汕尾', value: [115.375279, 22.786211] },
                { name: '潮州', value: [116.63, 23.68] },
                { name: '丹东', value: [124.37, 40.13] },
                { name: '太仓', value: [121.1, 31.45] },
                { name: '曲靖', value: [103.79, 25.51] },
                { name: '烟台', value: [121.39, 37.52] },
                { name: '福州', value: [119.3, 26.08] },
                { name: '即墨', value: [120.45, 36.38] },
                { name: '抚顺', value: [123.97, 41.97] },
                { name: '玉溪', value: [102.52, 24.35] },
                { name: '阳泉', value: [113.57, 37.85] },
                { name: '莱州', value: [119.942327, 37.177017] },
                { name: '湖州', value: [120.1, 30.86] },
                { name: '汕头', value: [116.69, 23.39] },
                { name: '昆山', value: [120.95, 31.39] },
                { name: '宁波', value: [121.56, 29.86] },
                { name: '湛江', value: [110.359377, 21.270708] },
                { name: '揭阳', value: [116.35, 23.55] },
                { name: '荣成', value: [122.41, 37.16] },
                { name: '连云港', value: [119.16, 34.59] },
                { name: '葫芦岛', value: [120.836932, 40.711052] },
                { name: '常熟', value: [120.74, 31.64] },
                { name: '东莞', value: [113.75, 23.04] },
                { name: '河源', value: [114.68, 23.73] },
                { name: '淮安', value: [119.15, 33.5] },
                { name: '泰州', value: [119.9, 32.49] },
                { name: '南宁', value: [108.33, 22.84] },
                { name: '营口', value: [122.18, 40.65] },
                { name: '惠州', value: [114.4, 23.09] },
                { name: '江阴', value: [120.26, 31.91] },
                { name: '蓬莱', value: [120.75, 37.8] },
                { name: '韶关', value: [113.62, 24.84] },
                { name: '广州', value: [113.23, 23.16] },
                { name: '延安', value: [109.47, 36.6] },
                { name: '太原', value: [112.53, 37.87] },
                { name: '清远', value: [113.01, 23.7] },
                { name: '中山', value: [113.38, 22.52] },
                { name: '昆明', value: [102.73, 25.04] },
                { name: '寿光', value: [118.73, 36.86] },
                { name: '盘锦', value: [122.070714, 41.119997] },
                { name: '长治', value: [113.08, 36.18] },
                { name: '深圳', value: [114.07, 22.62] },
                { name: '珠海', value: [113.52, 22.3] },
                { name: '宿迁', value: [118.3, 33.96] },
                { name: '咸阳', value: [108.72, 34.36] },
                { name: '铜川', value: [109.11, 35.09] },
                { name: '平度', value: [119.97, 36.77] },
                { name: '佛山', value: [113.11, 23.05] },
                { name: '海口', value: [110.35, 20.02] },
                { name: '江门', value: [113.06, 22.61] },
                { name: '章丘', value: [117.53, 36.72] },
                { name: '肇庆', value: [112.44, 23.05] },
                { name: '大连', value: [121.62, 38.92] },
                { name: '临汾', value: [111.5, 36.08] },
                { name: '吴江', value: [120.63, 31.16] },
                { name: '石嘴山', value: [106.39, 39.04] },
                { name: '沈阳', value: [123.38, 41.8] },
                { name: '苏州', value: [120.62, 31.32] },
                { name: '茂名', value: [110.88, 21.68] },
                { name: '嘉兴', value: [120.76, 30.77] },
                { name: '长春', value: [125.35, 43.88] },
                { name: '胶州', value: [120.03336, 36.264622] },
                { name: '银川', value: [106.27, 38.47] },
                { name: '张家港', value: [120.555821, 31.875428] },
                { name: '三门峡', value: [111.19, 34.76] },
                { name: '锦州', value: [121.15, 41.13] },
                { name: '南昌', value: [115.89, 28.68] },
                { name: '柳州', value: [109.4, 24.33] },
                { name: '三亚', value: [109.511909, 18.252847] },
                { name: '自贡', value: [104.778442, 29.33903] },
                { name: '吉林', value: [126.57, 43.87] },
                { name: '阳江', value: [111.95, 21.85] },
                { name: '泸州', value: [105.39, 28.91] },
                { name: '西宁', value: [101.74, 36.56] },
                { name: '宜宾', value: [104.56, 29.77] },
                { name: '呼和浩特', value: [111.65, 40.82] },
                { name: '成都', value: [104.06, 30.67] },
                { name: '大同', value: [113.3, 40.12] },
                { name: '镇江', value: [119.44, 32.2] },
                { name: '桂林', value: [110.28, 25.29] },
                { name: '张家界', value: [110.479191, 29.117096] },
                { name: '宜兴', value: [119.82, 31.36] },
                { name: '北海', value: [109.12, 21.49] },
                { name: '西安', value: [108.95, 34.27] },
                { name: '金坛', value: [119.56, 31.74] },
                { name: '东营', value: [118.49, 37.46] },
                { name: '牡丹江', value: [129.58, 44.6] },
                { name: '遵义', value: [106.9, 27.7] },
                { name: '绍兴', value: [120.58, 30.01] },
                { name: '扬州', value: [119.42, 32.39] },
                { name: '常州', value: [119.95, 31.79] },
                { name: '潍坊', value: [119.1, 36.62] },
                { name: '重庆', value: [106.54, 29.59] },
                { name: '台州', value: [121.420757, 28.656386] },
                { name: '南京', value: [118.78, 32.04] },
                { name: '滨州', value: [118.03, 37.36] },
                { name: '贵阳', value: [106.71, 26.57] },
                { name: '无锡', value: [120.29, 31.59] },
                { name: '本溪', value: [123.73, 41.3] },
                { name: '克拉玛依', value: [84.77, 45.59] },
                { name: '渭南', value: [109.5, 34.52] },
                { name: '马鞍山', value: [118.48, 31.56] },
                { name: '宝鸡', value: [107.15, 34.38] },
                { name: '焦作', value: [113.21, 35.24] },
                { name: '句容', value: [119.16, 31.95] },
                { name: '北京', value: [116.46, 39.92] },
                { name: '徐州', value: [117.2, 34.26] },
                { name: '衡水', value: [115.72, 37.72] },
                { name: '包头', value: [110, 40.58] },
                { name: '绵阳', value: [104.73, 31.48] },
                { name: '乌鲁木齐', value: [87.68, 43.77] },
                { name: '枣庄', value: [117.57, 34.86] },
                { name: '杭州', value: [120.19, 30.26] },
                { name: '淄博', value: [118.05, 36.78] },
                { name: '鞍山', value: [122.85, 41.12] },
                { name: '溧阳', value: [119.48, 31.43] },
                { name: '库尔勒', value: [86.06, 41.68] },
                { name: '安阳', value: [114.35, 36.1] },
                { name: '开封', value: [114.35, 34.79] },
                { name: '济南', value: [117, 36.65] },
                { name: '德阳', value: [104.37, 31.13] },
                { name: '温州', value: [120.65, 28.01] },
                { name: '九江', value: [115.97, 29.71] },
                { name: '邯郸', value: [114.47, 36.6] },
                { name: '临安', value: [119.72, 30.23] },
                { name: '兰州', value: [103.73, 36.03] },
                { name: '沧州', value: [116.83, 38.33] },
                { name: '临沂', value: [118.35, 35.05] },
                { name: '南充', value: [106.110698, 30.837793] },
                { name: '天津', value: [117.2, 39.13] },
                { name: '富阳', value: [119.95, 30.07] },
                { name: '泰安', value: [117.13, 36.18] },
                { name: '诸暨', value: [120.23, 29.71] },
                { name: '郑州', value: [113.65, 34.76] },
                { name: '哈尔滨', value: [126.63, 45.75] },
                { name: '聊城', value: [115.97, 36.45] },
                { name: '芜湖', value: [118.38, 31.33] },
                { name: '唐山', value: [118.02, 39.63] },
                { name: '平顶山', value: [113.29, 33.75] },
                { name: '邢台', value: [114.48, 37.05] },
                { name: '德州', value: [116.29, 37.45] },
                { name: '济宁', value: [116.59, 35.38] },
                { name: '荆州', value: [112.239741, 30.335165] },
                { name: '宜昌', value: [111.3, 30.7] },
                { name: '义乌', value: [120.06, 29.32] },
                { name: '丽水', value: [119.92, 28.45] },
                { name: '洛阳', value: [112.44, 34.7] },
                { name: '秦皇岛', value: [119.57, 39.95] },
                { name: '株洲', value: [113.16, 27.83] },
                { name: '莱芜', value: [117.67, 36.19] },
                { name: '常德', value: [111.69, 29.05] },
                { name: '保定', value: [115.48, 38.85] },
                { name: '湘潭', value: [112.91, 27.87] },
                { name: '金华', value: [119.64, 29.12] },
                { name: '岳阳', value: [113.09, 29.37] },
                { name: '长沙', value: [113, 28.21] },
                { name: '衢州', value: [118.88, 28.97] },
                { name: '廊坊', value: [116.7, 39.53] },
                { name: '菏泽', value: [115.480656, 35.23375] },
                { name: '合肥', value: [117.27, 31.86] },
                { name: '武汉', value: [114.31, 30.52] },
              ],
            },
            // {
            //   type: 'effectScatter',  //特效散点图
            //   rippleEffect: { // 涟漪效果
            //     scale: 5,
            //     brushType: 'stroke'
            //   },
            //   coordinateSystem: 'geo', // 使用坐标
            //   name: "二线城市",
            //   data: [
            //     {name: "南京", value: [118.78, 32.04]},
            //     {name: "杭州", value: [120.19, 30.26]},
            //     {name: "成都", value: [104.06, 30.67]},
            //     {name: "武汉", value: [114.31, 30.52]},
            //   ]
            // },
            // {
            //   type: 'effectScatter',  //特效散点图
            //   rippleEffect: { // 涟漪效果
            //     scale: 5,
            //     brushType: 'stroke'
            //   },
            //   coordinateSystem: 'geo', // 使用坐标
            //   name: "三线城市",
            //   data: [
            //     {name: "拉萨", value: [91.11, 29.97]},
            //     {name: "乌鲁木齐", value: [87.68, 43.77]},
            //     {name: "西宁", value: [101.74, 36.56]},
            //     {name: "兰州", value: [103.73, 36.03]},
            //   ]
            // },
          ],
          // legend: { // 图例组件
          //   left: '5%',
          //   bottom: '5%',
          //   orient: 'vertical', // 竖着排列
          //   data: ['一线城市', '二线城市', '三线城市']
          // },
        })
        this.chart.on('click', async (arg) => {
          const provinceInfo = getProvinceMapInfo(arg.name)
          console.log('provinceInfo', provinceInfo)
          // 如果存在key执行下面内容
          if (provinceInfo.key !== undefined) {
            // 获取static下面的json数据
            const res = await axios.get(
              'http://localhost:9528' + provinceInfo.path
            )
            echarts.registerMap(provinceInfo.key, res.data)
            const changeOption = {
              geo: {
                map: provinceInfo.key,
              },
            }
            this.chart.setOption(changeOption)
          }
        })
      },
      // 当浏览器的大小发生变化的时候，会调用此方法来完成适配
      screenAdapter() {
        // 获取自适应大小
        const titleFontSize = (this.$refs.main.offsetWidth / 100) * 3.6
        console.log('titleFontSize', titleFontSize)
        // 自适应配置
        const adapterOption = {
          title: {
            textStyle: {
              fontSize: titleFontSize, // 自适应字体大小
            },
          },
          legend: {
            // 图例组件
            itemWidth: titleFontSize / 2,
            itemHeight: titleFontSize / 2,
            itemGap: titleFontSize / 2,
            textStyle: {
              fontSize: titleFontSize / 2, // 自适应字体大小
            },
          },
        }
        this.chart.setOption(adapterOption)
        // 自适应
        this.chart.resize()
      },
      // 回退
      revertMap() {
        const revertOption = {
          geo: {
            map: 'chain',
          },
        }
        this.chart.setOption(revertOption)
      },
    },
  }
</script>

<style lang="scss" scoped>
  .dashboard-container {
    height: 100%;
    width: 100%;
  }
</style>
