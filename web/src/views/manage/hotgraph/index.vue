<!-- 热力图 -->
<template>
  <!-- :center表示定位, 可使用如“广州市海珠区”的地区字符串，
			也可以使用对象如 {lng: 116.404, lat: 39.915} 表示经纬度->lng-longitude; lat-latitude
		 :zoom表示缩放等级；
		 :scroll-wheel-zoom表示允许鼠标滚轮缩放 -->
  <baidu-map
    class="map"
    :center="{ lng: 121.668543, lat: 31.148081 }"
    :zoom="18"
    :scroll-wheel-zoom="true"
    style="width: auto; height: 600px"
  >
    <!-- 全景 -->
    <bm-panorama></bm-panorama>
    <!-- 地图类型 -->
    <bm-map-type
      :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']"
      anchor="BMAP_ANCHOR_TOP_LEFT"
    ></bm-map-type>
    <!-- :max表示权重最大值；:radius表示热力图半径；:gradient表示热力图渐变区间，
    	其中 key 表示插值的位置，取值范围 0 ~ 1，value 为颜色值。 -->
    <bml-heatmap
      :data="data"
      :max="100"
      :radius="20"
      :gradient="{
        0.5: 'rgb(0, 110, 255)',
        0.8: 'rgb(15, 255, 31)',
        0.9: 'rgb(225, 75, 0)',
      }"
    ></bml-heatmap>

    <bm-marker
      v-for="(item, index) of markers"
      :key="index"
      :position="{ lng: item.lng, lat: item.lat }"
      :icon="{
        url: require('@/assets/location.png'),
        size: { width: 22, height: 32 },
      }"
      animation="BMAP_ANIMATION_BOUNCE"
      @click="lookDetail(item)"
    >
      <bm-info-window
        :title="item.name"
        :position="{ lng: item.lng, lat: item.lat }"
        :show="item.showFlag"
        @close="infoWindowClose(item)"
        @open="infoWindowOpen(item)"
      ></bm-info-window>
    </bm-marker>
  </baidu-map>
</template>

<script>
  import { BmlHeatmap } from 'vue-baidu-map'

  export default {
    components: {
      BmlHeatmap,
    },
    data() {
      return {
        data: [
          // 热力图的点数据，lng：点的经度 lat: 点的纬度 count：点的热力程度

          /*明日世界*/
          { lng: 121.663733326, lat: 31.147599152, count: 95 },
          { lng: 121.663733121, lat: 31.147599645, count: 153 },
          { lng: 121.663733567, lat: 31.150699317, count: 79 },
          { lng: 121.663733429, lat: 31.151999403, count: 46 },
          { lng: 121.663733159, lat: 31.152399842, count: 25 },
          { lng: 121.663733753, lat: 31.147599295, count: 123 },

          /*皮克斯玩具总动员*/
          { lng: 121.661656582, lat: 31.150754782, count: 359 },
          { lng: 121.661957216, lat: 31.15105557, count: 76 },
          { lng: 121.661356544, lat: 31.150855497, count: 125 },
          { lng: 121.661957244, lat: 31.151056119, count: 64 },
          { lng: 121.66175663, lat: 31.15085624, count: 97 },
          { lng: 121.66155598, lat: 31.150954968, count: 16 },

          /*米奇大街*/
          { lng: 121.668693712, lat: 31.14785658, count: 125 },
          { lng: 121.668247885, lat: 31.14771721, count: 72 },
          { lng: 121.668854569, lat: 31.147867656, count: 89 },
          { lng: 121.668575888, lat: 31.14774487, count: 56 },
          { lng: 121.668106665, lat: 31.1478018, count: 259 },
          { lng: 121.668535314, lat: 31.14830085, count: 159 },

          /*探险岛*/
          { lng: 121.669658442, lat: 31.149800436, count: 179 },
          { lng: 121.669413934, lat: 31.149424209, count: 11 },
          { lng: 121.669652364, lat: 31.149516201, count: 162 },
          { lng: 121.669674506, lat: 31.149564706, count: 108 },
          { lng: 121.669683762, lat: 31.149840598, count: 36 },
          { lng: 121.669826189, lat: 31.149985596, count: 39 },

          /*奇幻城堡:121.666109,31.14975*/
          { lng: 121.666122847, lat: 31.14975845, count: 23 },
          { lng: 121.666052796, lat: 31.149337046, count: 88 },
          { lng: 121.666108466, lat: 31.149880201, count: 40 },
          { lng: 121.666231725, lat: 31.149795888, count: 69 },
          { lng: 121.666076518, lat: 31.149554186, count: 115 },
          { lng: 121.666113117, lat: 31.149523601, count: 54 },

          /*七个小矮人:121.666037,31.150971*/
          { lng: 121.666175292, lat: 31.151396576, count: 127 },
          { lng: 121.66693213, lat: 31.151871744, count: 34 },
          { lng: 121.666579303, lat: 31.151533951, count: 95 },
          { lng: 121.666286172, lat: 31.151882123, count: 71 },
          { lng: 121.666645955, lat: 31.151215866, count: 159 },
          { lng: 121.666803883, lat: 31.151368183, count: 29 },

          /*星愿湖:121.67202,31.146351*/
          { lng: 121.672486574, lat: 31.146389548, count: 7 },
          { lng: 121.67261379, lat: 31.146568303, count: 18 },
          { lng: 121.672928391, lat: 31.146976983, count: 22 },
          { lng: 121.672517952, lat: 31.14681583, count: 11 },
          { lng: 121.672727951, lat: 31.14680312, count: 60 },
          { lng: 121.672189408, lat: 31.146882452, count: 32 },

          /*迪士尼小镇&迪士尼大剧院:121.667528,31.146181*/
          { lng: 121.667951956, lat: 31.146173484, count: 5 },
          { lng: 121.667658641, lat: 31.146745885, count: 28 },
          { lng: 121.667456119, lat: 31.146307154, count: 53 },
          { lng: 121.66783258, lat: 31.146181411, count: 45 },
          { lng: 121.667384388, lat: 31.146994101, count: 38 },
          { lng: 121.667528134, lat: 31.146181926, count: 120 },
          { lng: 121.667486799, lat: 31.147925926, count: 150 },
          { lng: 121.667712509, lat: 31.146956516, count: 41 },
          { lng: 121.667882343, lat: 31.146248166, count: 17 },
          { lng: 121.66791612, lat: 31.146309289, count: 51 },
        ],
        markers: [
          // 明日世界
          {
            lng: 121.663723,
            lat: 31.147619,
            name:
              '<center style="color:#0187FB;font-weight:bold">明日世界</center><center>' +
              '当前客流量：216</center>',
            showFlag: false,
          },

          // 皮克斯玩具总动员
          {
            lng: 121.661468,
            lat: 31.150798,
            name:
              '<center style="color:#0187FB;font-weight:bold">皮克斯玩具总动员</center><center>' +
              '当前客流量：317</center>',
            showFlag: false,
          },

          // 七个小矮人矿山过山车
          {
            lng: 121.666072,
            lat: 31.151196,
            name:
              '<center style="color:#0187FB;font-weight:bold">七个小矮人矿山过山车</center><center>' +
              '当前客流量：190</center>',
            showFlag: false,
          },

          // 奇幻童话城堡
          {
            lng: 121.666149,
            lat: 31.149799,
            name:
              '<center style="color:#0187FB;font-weight:bold">奇幻童话城堡</center><center>' +
              '当前客流量：190</center>',
            showFlag: false,
          },

          // 探险岛
          {
            lng: 121.669468,
            lat: 31.149405,
            name:
              '<center style="color:#0187FB;font-weight:bold">探险岛</center><center>' +
              '当前客流量：225</center>',
            showFlag: false,
          },

          // 米奇大街
          {
            lng: 121.668022,
            lat: 31.147972,
            name:
              '<center style="color:#0187FB;font-weight:bold">米奇大街</center><center>' +
              '当前客流量：142</center>',
            showFlag: false,
          },

          // 华特迪士尼大剧院
          {
            lng: 121.667451,
            lat: 31.147053,
            name:
              '<center style="color:#0187FB;font-weight:bold">华特迪士尼大剧院</center><center>' +
              '当前客流量：142</center>',
            showFlag: false,
          },

          // 迪士尼小镇
          {
            lng: 121.667519,
            lat: 31.146149,
            name:
              '<center style="color:#0187FB;font-weight:bold">迪士尼小镇</center><center>' +
              '当前客流量：189</center>',
            showFlag: false,
          },

          // 星愿湖
          {
            lng: 121.671992,
            lat: 31.146349,
            name:
              '<center style="color:#0187FB;font-weight:bold">星愿湖</center><center>' +
              '当前客流量：87</center>',
            showFlag: false,
          },
        ],
      }
    },

    methods: {
      // 点击点坐标赋值
      lookDetail(marker) {
        marker.showFlag = true
        this.infoWindow.info = marker
      },
      // 关闭弹窗
      infoWindowClose(marker) {
        marker.showFlag = false
      },
      // 打开弹窗
      infoWindowOpen(marker) {
        marker.showFlag = true
      },
    },
  }
</script>

<style scoped>
  ::v-deep .BMap_cpyCtrl {
    display: none;
  }
  ::v-deep .anchorBL {
    display: none;
  }
</style>
