<template>
  <div>
    <div id="centreLeft1Chart" style="width: 325px; height: 275px"></div>
  </div>
</template>

<script>
  import echartMixins from '@/utils/resizeMixins'

  export default {
    mixins: [echartMixins],
    data() {
      return {
        chart: null,
      }
    },
    mounted() {
      this.draw()
    },
    destroyed() {
      window.onresize = null
    },
    methods: {
      draw() {
        // 基于准备好的dom，初始化echarts实例
        this.chart = this.$echarts.init(
          document.getElementById('centreLeft1Chart')
        )
        //  ----------------------------------------------------------------

        this.chart.setOption({
          color: [
            '#37a2da',
            '#32c5e9',
            '#9fe6b8',
            '#ffdb5c',
            '#ff9f7f',
            '#fb7293',
            '#e7bcf3',
            '#8378ea',
          ],
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)',
          },
          toolbox: {
            show: true,
          },
          calculable: true,
          legend: {
            orient: 'horizontal',
            icon: 'circle',
            bottom: 0,
            x: 'center',
            data: ['宝藏湾', '明日世界', '奇想花园', '探险岛', '梦幻世界'],
            textStyle: {
              color: '#fff',
            },
          },
          series: [
            {
              name: '人流量统计表',
              type: 'pie',
              radius: [10, 60],
              roseType: 'area',
              center: ['50%', '40%'],
              data: [
                { value: 10, name: '宝藏湾' },
                { value: 5, name: '明日世界' },
                { value: 20, name: '奇想花园' },
                { value: 25, name: '探险岛' },
                { value: 30, name: '梦幻世界' },
                // { value: 35, name: 'rose6' },
              ],
            },
          ],
        })
      },
    },
  }
</script>

<style lang="scss" scoped></style>
