<template>
  <baidu-map class="map" :center="{lng: 121.6675, lat: 31.1488}" :zoom="18" :scroll-wheel-zoom="true">
    <bml-heatmap :data="heartData" :max="100" :radius="20">
    </bml-heatmap>
    <bm-marker :position="{lng: 121.669562, lat: 31.146555}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="入口" :labelStyle="{color: 'black', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
    <bm-marker :position="{lng: 121.663719, lat: 31.147644}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="明日世界" :labelStyle="{color: 'black', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
    <bm-marker :position="{lng: 121.663231, lat: 31.149708}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="迪士尼.皮克斯玩具总动员" :labelStyle="{color: 'black', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
    <bm-marker :position="{lng: 121.666337, lat: 31.150738}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="梦幻世界" :labelStyle="{color: 'black', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
    <bm-marker :position="{lng: 121.669354, lat: 31.151372}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="宝藏湾" :labelStyle="{color: 'black', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
    <bm-marker :position="{lng: 121.666965, lat: 31.148937}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="奇想花园" :labelStyle="{color: 'black', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
    <bm-marker :position="{lng: 121.669473, lat: 31.14947}" :dragging="true" animation="BMAP_ANIMATION_BOUNCE">
      <bm-label content="探险岛" :labelStyle="{color: 'black', fontSize : '24px'}" :offset="{width: -35, height: 30}"/>
    </bm-marker>
    <bm-polyline :path="polylinePath" stroke-color="blue" :stroke-opacity="0.5" :stroke-weight="2" :editing="true" @lineupdate="updatePolylinePath"></bm-polyline>
  </baidu-map>
</template>


<script>
import {BmlHeatmap} from 'vue-baidu-map'

export default {
  data () {
    return {
      polylinePath: [
        {lng: 121.669473, lat: 31.14947},
        {lng: 121.666965, lat: 31.150738},
        {lng: 121.663231, lat: 31.146555}
      ],
      heartData: [
        {lng: 121.669473, lat: 31.14947, count: 50},
        {lng: 121.666965, lat: 31.150738, count: 51},
        {lng: 121.663231, lat: 31.146555, count: 15}
        // ...此处添加更多的数据集
      ]
    }
  },
  methods: {
    updatePolylinePath (e) {
      this.polylinePath = e.target.getPath()
    },
    addPolylinePoint () {
      this.polylinePath.push({lng: 121.404, lat: 31.915})
    }
  },
  components: {
    BmlHeatmap
  }
}
</script>
<style>
.map {
  width: auto;
  height: 600px;
}
</style>