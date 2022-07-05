<template>
  <div id="centreLeft1">
    <div class="bg-color-black">
      <div class="d-flex pt-2 pl-2">
        <span style="color: #5cd9e8">
          <icon name="chart-pie"></icon>
        </span>
        <div class="d-flex">
          <span class="fs-xl text mx-2">雷达图</span>
          <dv-decoration-1
            style="width: 125px; height: 125px; position: relative; top: 3.75px"
          />
        </div>
      </div>
      <div class="d-flex jc-center">
        <centreLeft2Chart />
      </div>
    </div>
  </div>
</template>

<script>
  import centreLeft2Chart from '@/components/echart/centerLeft2/centreLeft2Chart'
  export default {
    components: {
      centreLeft2Chart,
    },
    data() {
      return {}
    },
    mounted() {},
    methods: {},
  }
</script>

<style lang="scss">
  #centreLeft1 {
    padding: 20px;
    height: 400px;
    width: 450px;
    min-width: 37.5px;
    border-radius: 6.25px;
    .bg-color-black {
      height: 48.125px;
      border-radius: 1.25px;
    }
    .text {
      color: #c3cbde;
    }
    .chart-box {
      margin-top: 20px;
      width: 215px;
      height: 215px;
      .active-ring-name {
        padding-top: 12.55px;
      }
    }
  }
</style>
