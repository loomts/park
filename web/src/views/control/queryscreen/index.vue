<template>
  <baidu-map
    class="map"
    :center="{ lng: 121.6675, lat: 31.1488 }"
    :zoom="19"
    :scroll-wheel-zoom="true"
  >
    <bm-polyline
      :path="polylinePath"
      stroke-color="blue"
      :stroke-opacity="0.5"
      :stroke-weight="2"
      :editing="true"
    ></bm-polyline>
    <bml-heatmap :data="heartData" :max="300" :radius="60"></bml-heatmap>
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
    <bm-view class="map"></bm-view>
    <bm-walking
      start="迪士尼梦幻世界"
      end="迪士尼·皮克斯玩具总动员"
      :auto-viewport="true"
      location="上海"
    ></bm-walking>
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
        polylinePath: [
          { lng: 121.667027, lat: 31.148817 },
          { lng: 121.66629, lat: 31.148254 },
          { lng: 121.664107, lat: 31.148385 },
          { lng: 121.663703, lat: 31.147597 },
          { lng: 121.663689, lat: 31.149096 },
          { lng: 121.663276, lat: 31.149633 },
          { lng: 121.664084, lat: 31.150282 },
          { lng: 121.664875, lat: 31.151055 },
          { lng: 121.664875, lat: 31.151055 },
        ],
        heartData: [
          { lng: 121.667034, lat: 31.148808, count: 40 },
          { lng: 121.663665, lat: 31.147549, count: 60 },
          { lng: 121.668408, lat: 31.151335, count: 70 },
          { lng: 121.663243, lat: 31.149693, count: 300 },
          { lng: 121.666127, lat: 31.149635, count: 300 },
          { lng: 121.669513, lat: 31.149366, count: 270 },
          { lng: 121.665073, lat: 31.14947, count: 230 },
          { lng: 121.666965, lat: 31.150738, count: 120 },
          { lng: 121.663231, lat: 31.146555, count: 135 },
          // ...此处添加更多的数据集
        ],
      }
    },
  }
</script>
<style>
  .map {
    width: auto;
    height: 800px;
  }
</style>
