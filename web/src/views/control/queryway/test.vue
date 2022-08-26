<template>
  <div id="mapcontainer"></div>
</template>

<script>
  // import VabChart from '@/plugins/echarts'
  import * as echarts from 'echarts'

  export default {
    name: 'Queryway',

    data() {
      return {}
    },
    created() {},

    mounted() {},
    methods: {},
  }
</script>
<style lang="scss" scoped>
  #mapcontainer {
    position: absolute;
    top: 40px;
    left: 0;
    width: 100%;
    height: 94%;
    .canvas {
      height: 100%;
    }
  }
</style>
