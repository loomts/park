<template>
  <div id="bottomLeft" style="width: 856px">
    <div class="bg-color-black">
      <div class="d-flex pt-2 pl-2">
        <span style="color: #5cd9e8">
          <icon name="chart-bar"></icon>
        </span>
        <div class="d-flex">
          <span
            class="fs-xl text mx-2"
            style="
              font-size: 25px;
              text-align: center;
              margin-left: 470px;
              margin-top: 0px;
            "
          >
            人流量统计 2022年7月5日
          </span>
        </div>
      </div>
      <div>
        <bottomLeftChart />
      </div>
    </div>
  </div>
</template>

<script>
  import bottomLeftChart from '@/components/echart/bottom/bottomLeftChart'
  export default {
    components: {
      bottomLeftChart,
    },
    data() {
      return {}
    },
    mounted() {},
    methods: {},
  }
</script>

<style lang="scss">
  #bottomLeft {
    padding-left: 0px;
    padding-top: 20px;
    padding-bottom: 0px;
    height: 650px;
    width: 870px;
    min-width: 375px;
    border-radius: 12.25px;
    .bg-color-white {
      height: 600px;
      border-radius: 12.5px;
    }
    .text {
      color: #c3cbde;
      font-size: 18px;
    }
    .chart-box {
      margin-top: 20px;
      width: 250px;
      height: 250px;
      .active-ring-name {
        padding-top: 12.5px;
      }
    }
  }
</style>
