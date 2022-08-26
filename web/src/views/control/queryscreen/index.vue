<template>
  <baidu-map
    class="map"
    :center="{ lng: 121.6675, lat: 31.1488 }"
    :zoom="18"
    :scroll-wheel-zoom="true"
  >
    <bm-polyline
      :path="polylinePath"
      stroke-color="blue"
      :stroke-opacity="0.5"
      :stroke-weight="2"
      :editing="false"
    ></bm-polyline>
    <!-- <bml-curve-line :points="arcPoints" :editing="true"></bml-curve-line> -->
    <bml-curve-line :points="arcPoints" :editing="false"></bml-curve-line>
    <bml-curve-line :points="arcPoints1" :editing="false"></bml-curve-line>
    <bml-curve-line :points="arcPoints2" :editing="false"></bml-curve-line>
    <bml-heatmap :data="heartData" :max="300" :radius="60"></bml-heatmap>
    <!-- <bm-label
      content="我爱北京天安门"
      :position="{ lng: 116.404, lat: 39.915 }"
      :labelStyle="{ color: 'red', fontSize: '24px' }"
      title="Hover me"
    /> -->

    <bm-marker
      :position="{ lng: 121.669562, lat: 31.146555 }"
      :dragging="true"
      animation="BMAP_ANIMATION_BOUNCE"
    >
      <bm-label
        content="入口"
        :label-style="{ color: 'black', fontSize: '24px' }"
        :offset="{ width: -35, height: 30 }"
      />
    </bm-marker>
    <bm-marker
      :position="{ lng: 121.663719, lat: 31.147644 }"
      :dragging="true"
      animation="BMAP_ANIMATION_BOUNCE"
    >
      <bm-label
        content="明日世界"
        :label-style="{ color: 'black', fontSize: '24px' }"
        :offset="{ width: -35, height: 30 }"
      />
    </bm-marker>
    <bm-marker
      :position="{ lng: 121.663231, lat: 31.149708 }"
      :dragging="true"
      animation="BMAP_ANIMATION_BOUNCE"
    >
      <bm-label
        content="迪士尼.皮克斯玩具总动员"
        :label-style="{ color: 'black', fontSize: '24px' }"
        :offset="{ width: -35, height: 30 }"
      />
    </bm-marker>
    <bm-marker
      :position="{ lng: 121.666337, lat: 31.150738 }"
      :dragging="true"
      animation="BMAP_ANIMATION_BOUNCE"
    >
      <bm-label
        content="梦幻世界"
        :label-style="{ color: 'black', fontSize: '24px' }"
        :offset="{ width: -35, height: 30 }"
      />
    </bm-marker>
    <bm-marker
      :position="{ lng: 121.669354, lat: 31.151372 }"
      :dragging="true"
      animation="BMAP_ANIMATION_BOUNCE"
    >
      <bm-label
        content="宝藏湾"
        :label-style="{ color: 'black', fontSize: '24px' }"
        :offset="{ width: -35, height: 30 }"
      />
    </bm-marker>
    <bm-marker
      :position="{ lng: 121.666965, lat: 31.148937 }"
      :dragging="true"
      animation="BMAP_ANIMATION_BOUNCE"
    >
      <bm-label
        content="奇想花园"
        :label-style="{ color: 'black', fontSize: '24px' }"
        :offset="{ width: -35, height: 30 }"
      />
    </bm-marker>
    <bm-marker
      :position="{ lng: 121.669473, lat: 31.14947 }"
      :dragging="true"
      animation="BMAP_ANIMATION_BOUNCE"
    >
      <bm-label
        content="探险岛"
        :label-style="{ color: 'black', fontSize: '24px' }"
        :offset="{ width: -35, height: 30 }"
      />
    </bm-marker>
    <!-- <bm-view class="map"></bm-view>
    <bm-walking
      start="迪士尼梦幻世界"
      end="迪士尼·皮克斯玩具总动员"
      :auto-viewport="true"
      location="上海"
    ></bm-walking> -->
  </baidu-map>
</template>

<script>
import { BmlHeatmap, BmlCurveLine } from 'vue-baidu-map'

export default {
  components: {
    BmlHeatmap,
    BmlCurveLine,
  },
  data() {
    return {
      polylinePath: [
        { lng: 121.667027, lat: 31.148817 },
        { lng: 121.66629, lat: 31.148254 },
        { lng: 121.664107, lat: 31.148385 },
        { lng: 121.663703, lat: 31.147597 },
        { lng: 121.663818, lat: 31.149092 },
        { lng: 121.66331, lat: 31.149625 },
        { lng: 121.664114, lat: 31.150259 },
        { lng: 121.66486, lat: 31.151314 },
        { lng: 121.666225, lat: 31.150908 },
        { lng: 121.667941, lat: 31.150595 },
        { lng: 121.668111, lat: 31.15126 },
        { lng: 121.669454, lat: 31.15141 },
        { lng: 121.670231, lat: 31.150703 },
        { lng: 121.669486, lat: 31.149355 },
        { lng: 121.668511, lat: 31.149726 },
        { lng: 121.66795, lat: 31.149231 },
        { lng: 121.667027, lat: 31.148817 },
      ],
      arcPoints: [
        { lng: 121.66629, lat: 31.148254 },
        { lng: 121.66614, lat: 31.149652 },
        { lng: 121.66795, lat: 31.149231 },
        { lng: 121.667846, lat: 31.148123 },
        { lng: 121.66629, lat: 31.148254 },
      ],
      arcPoints1:[
        // {lng:}
      ],
      heartData: [
        // { lng: 121.667034, lat: 31.148808, count: 40 },
        // { lng: 121.663665, lat: 31.147549, count: 60 },
        // { lng: 121.668408, lat: 31.151335, count: 70 },
        // { lng: 121.663243, lat: 31.149693, count: 300 },
        // { lng: 121.666127, lat: 31.149635, count: 300 },
        // { lng: 121.669513, lat: 31.149366, count: 270 },
        // { lng: 121.665073, lat: 31.14947, count: 230 },
        // { lng: 121.666965, lat: 31.150738, count: 120 },
        // { lng: 121.663231, lat: 31.146555, count: 135 },
        // ...此处添加更多的数据集
      ],
    }
  },
}

/**
 * 转换弧度
 * @param d
 * @returns {number}
 */
function getRad(d) {
  var PI = Math.PI
  return (d * PI) / 180.0
}

/**
 * 根据经纬度计算两点间距离
 * @param lng1
 * @param lat1
 * @param lng2
 * @param lat2
 * @returns {number|*}
 * @constructor
 */
function distance(lng1, lat1, lng2, lat2) {
  var f = getRad((lat1 + lat2) / 2)
  var g = getRad((lat1 - lat2) / 2)
  var l = getRad((lng1 - lng2) / 2)
  var sg = Math.sin(g)
  var sl = Math.sin(l)
  var sf = Math.sin(f)
  var s, c, w, r, d, h1, h2
  var a = 6378137.0 //The Radius of eath in meter.
  var fl = 1 / 298.257
  sg = sg * sg
  sl = sl * sl
  sf = sf * sf
  s = sg * (1 - sl) + (1 - sf) * sl
  c = (1 - sg) * (1 - sl) + sf * sl
  w = Math.atan(Math.sqrt(s / c))
  r = Math.sqrt(s * c) / w
  d = 2 * w * a
  h1 = (3 * r - 1) / 2 / c
  h2 = (3 * r + 1) / 2 / s
  s = d * (1 + fl * (h1 * sf * (1 - sg) - h2 * (1 - sf) * sg))
  if (s >= 1000 && s <= 99000) {
    var kilometer = s / 1000
    s = kilometer.toFixed(1) + 'km'
  } else if (s > 99000) {
    s = '>99km'
  } else {
    s = Math.round(s) + 'm'
  }
  // s = s/1000;
  // s = s.toFixed(2);//指定小数点后的位数。
  return s
}
</script>
<style>
.map {
  width: auto;
  height: 800px;
}
</style>
