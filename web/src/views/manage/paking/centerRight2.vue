<template>
  <div id="centreRight2">
    <div class="bg-color-black">
      <div class="d-flex pt-2 pl-2">
        <span style="color: #5cd9e8">
          <icon name="align-left"></icon>
        </span>
        <span class="fs-xl text mx-2">24h内人流量雷达图</span>
      </div>
      <div class="d-flex jc-center body-box" style="margin-top: 0">
        <!-- <dv-capsule-chart :config="config" style="width: 100%; height: 200px" /> -->
        <!-- ---------------------------------------- -->
        <centreRight2Chart1></centreRight2Chart1>
      </div>
    </div>
  </div>
</template>

<script>
  import centreRight2Chart1 from '@/components/echart/centreRight2/centreRight2Chart1'

  export default {
    components: { centreRight2Chart1 },
    // data() {
    //   return {
    //     config: {
    //       data: [
    //         {
    //           name: '南阳',
    //           value: 167,
    //         },
    //         {
    //           name: '周口',
    //           value: 67,
    //         },
    //         {
    //           name: '漯河',
    //           value: 123,
    //         },
    //         {
    //           name: '郑州',
    //           value: 55,
    //         },
    //         {
    //           name: '西峡',
    //           value: 98,
    //         },
    //       ],
    //     },
    //   }
    // },
    mounted() {},
    methods: {},
  }
</script>

<style lang="scss">
  #centreRight2 {
    padding: 6.25px;
    height: 500px;
    min-width: 37.5px;
    border-radius: 6.25px;
    .bg-color-black {
      padding: 6.25px;
      height: 506.25px;
      border-radius: 12.5px;
    }
    .text {
      color: #c3cbde;
    }
    .body-box {
      border-radius: 12.5px;
      overflow: hidden;
    }
  }
</style>
