<template>
  <div
    id="bottomRight"
    style="
      border: solid black 1px; 
      height: 430px; 
      width: 80%;
      margin-left:120px;
      margin-top: 40px;
      box-shadow:0 2px 5px 5px gray;
      border-radius: 12.25px;
      "

  >
    <div class="bg-color-black">
      <div class="d-flex pt-2 pl-2">
        <span style="color: #000000">
          <icon name="chart-area"></icon>
        </span>
        <div class="d-flex">
          <span class="fs-xl text mx-2"
            style="
              color: #000000;
            "
          >
            人群趋向图
          </span>
          <div class="decoration2">
            <dv-decoration-2
              :reverse="true"
              style="width: 50px; height: 480px"
            />
          </div>
        </div>
      </div>
      <div>
        <bottomRightChart />
      </div>
    </div>
  </div>
</template>

<script>
  import bottomRightChart from '@/components/echart/bottom/bottomRightChart'
  export default {
    components: {
      bottomRightChart,
    },
    data() {
      return {}
    },
    mounted() {},
    methods: {},
  }
</script>

<style lang="scss">
  #bottomRight {
    padding: 20px 20px 0;
    height: 650px;
    margin-left: 40px;
    min-width: 37.5px;
    border-radius: 6.25px;
    .bg-color-black {
      height: 618.75px;
      border-radius: 12.5px;
    }
    .text {
      color: #c3cbde;
      font-size: 18px;
      margin-left: 40px;
    } //下滑线动态
    .decoration2 {
      position: absolute;
      right: 12.5px;
    }
    .chart-box {
      margin-top: 20px;
      width: 212.5px;
      height: 212.5px;
      .active-ring-name {
        padding-top: 12.5px;
      }
    }
  }
</style>
