<template>
  <div
    id="centreLeft1"
    style="
      margin-top: 20px;
      margin-left: 115px;
      height: 350px;
      width: 350px;
      border: solid white 1px;
    "
  >
    <div class="bg-color-black">
      <div class="d-flex pt-2 pl-2">
        <span style="color: #5cd9e8">
          <icon name="chart-bar"></icon>
        </span>
        <div class="d-flex">
          <span
            class="fs-xl text mx-2"
            style="margin-bottom: 30px; font-size: 18px"
          >
            人群流通情况
          </span>
          <dv-decoration-3
            style="width: 250px; height: 125px; position: relative; top: 3.75px"
          />
        </div>
      </div>
      <div class="d-flex jc-center">
        <centreLeft1Chart />
      </div>
      <!-- 4个主要的数据 -->
      <div class="bottom-data">
        <div v-for="(item, index) in numberData" :key="index" class="item-box">
          <div class="d-flex">
            <span class="coin">￥</span>
            <dv-digital-flop
              :config="item.number"
              style="width: 250px; height: 62.5px"
            />
          </div>
          <p class="text" style="text-align: center">
            {{ item.text }}
            <span class="colorYellow">(人)</span>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import centreLeft1Chart from '@/components/echart/centerLeft2/centreLeft1Chart'
  export default {
    components: {
      centreLeft1Chart,
    },
    // data() {
    //   return {
    //     config: {
    //       lineWidth: 30,
    //       activeRadius: '80%',
    //       radius: '75%',
    //       activeTimeGap: 2000,
    //       data: [
    //         {
    //           name: '明日世界',
    //           value: 55,
    //         },
    //         {
    //           name: '梦幻世界',
    //           value: 120,
    //         },
    //         {
    //           name: '奇想花园',
    //           value: 78,
    //         },
    //         {
    //           name: '宝藏湾',
    //           value: 66,
    //         },
    //         {
    //           name: '探险岛',
    //           value: 80,
    //         },
    //       ],
    //     },
    //     numberData: [
    //       {
    //         number: {
    //           number: [15],
    //           toFixed: 1,
    //           content: '{nt}',
    //         },
    //         text: '当前人数',
    //       },
    //       {
    //         number: {
    //           number: [1144],
    //           toFixed: 1,
    //           content: '{nt}',
    //         },
    //         text: '截至目前总共到达人数',
    //       },
    //       {
    //         number: {
    //           number: [361],
    //           toFixed: 1,
    //           content: '{nt}',
    //         },
    //         text: '正在离开',
    //       },
    //       {
    //         number: {
    //           number: [157],
    //           toFixed: 1,
    //           content: '{nt}',
    //         },
    //         text: '预计将到',
    //       },
    //     ],
    //   }
    // },
    // mounted() {
    //   this.changeTiming()
    // },
    // methods: {
    //   changeTiming() {
    //     setInterval(() => {
    //       this.changeNumber()
    //     }, 3000)
    //   },
    //   changeNumber() {
    //     this.numberData.forEach((item, index) => {
    //       item.number.number[0] += ++index
    //       item.number = { ...item.number }
    //     })
    //   },
    // },
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
      height: 481.25px;
      border-radius: 12.5px;
    }
    .text {
      color: #c3cbde;
    }
    .chart-box {
      margin-top: 20px;
      width: 212.5px;
      height: 212.5px;
      .active-ring-name {
        padding-top: 12.5px;
      }
    }

    .bottom-data {
      .item-box {
        float: right;
        position: relative;
        width: 50%;
        color: #d3d6dd;
        // 金币
        .coin {
          position: absolute;
          left: 10px;
          top: 21.25px;
          font-size: 25px;
          color: #ffc107;
        }
        .colorYellow {
          color: yellowgreen;
        }
      }
    }
  }
</style>
