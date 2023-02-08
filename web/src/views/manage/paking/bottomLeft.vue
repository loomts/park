<template>
  <div id="bottomLeft" style="width: 96%;">
    <div class="bg-color-black">
      <div class="d-flex pt-2 pl-2">
        <span style="color: #000000">
          <icon name="chart-bar"></icon>
        </span>
        <div class="d-flex">
          <span
            class="fs-xl text mx-2"
            style="
              font-size: 25px;
              /*text-align: center;*/
              margin-left: 470px;
              margin-top: 0px;
              color: #000000;
            "
          >
            <span style="border:0px solid black; margin-left: 60px;margin-top: 30px;">人流量统计</span> <span style="border:0px solid black; margin-left: 62%; font-size: 23px;margin-top: 30px;">·2022年7月5日</span>
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
  *{
    font-family: AlimamaShuHeiTi-Bold;
  }
  @font-face {
    font-family: AlimamaShuHeiTi-Bold;
    src: url('./AlimamaShuHeiTi-Bold.otf');
  }
  #bottomLeft {
    padding-left: 0px;
    padding-top: 40px;
    padding-bottom: 0px;
    margin-left:2%;
    margin-top:3%;
    height: 650px;
    width: 900px;
    min-width: 375px;
    border-radius: 12.25px;
    box-shadow:0 2px 5px 5px gray;
    .bg-color-white {
      height: 600px;
      border-radius: 12.5px;
    }
    .text {
      color: #000000;
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
