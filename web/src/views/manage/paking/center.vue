<template>
  <div id="center">
    <div class="up">
      <div
        v-for="item in titleItem"
        :key="item.title"
        class="bg-color-black item"
      >
        <p class="ml-3 colorBlue fw-b">{{ item.title }}</p>
        <div>
          <dv-digital-flop
            :config="item.number"
            style="width: 125px; height: 62.5px"
          />
        </div>
      </div>
    </div>
    <div class="down">
      <div class="ranking bg-color-black">
        <span style="color: #5cd9e8">
          <icon name="align-left"></icon>
        </span>
        <span class="fs-xl text mx-2 mb-1">年度负责人组件达标榜</span>
        <dv-scroll-ranking-board :config="ranking" style="height: 275px" />
      </div>
      <div class="percent">
        <div class="item bg-color-black">
          <span>今日任务通过率</span>
          <centerChart
            :id="rate[0].id"
            :tips="rate[0].tips"
            :color-obj="rate[0].colorData"
          />
        </div>
        <div class="item bg-color-black">
          <span>今日任务达标率</span>
          <centerChart
            :id="rate[1].id"
            :tips="rate[1].tips"
            :color-obj="rate[1].colorData"
          />
        </div>
        <div class="water">
          <dv-water-level-pond :config="water" style="height: 150px" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import centerChart from '@/components/echart/center/centerChartRate'

  export default {
    components: {
      // centerChart,
      // centerChart1,
      // centerChart2
    },
    data() {
      return {
        titleItem: [
          {
            title: '今年累计任务建次数',
            number: {
              number: [120],
              toFixed: 1,
              content: '{nt}',
            },
          },
          {
            title: '本月累计任务次数',
            number: {
              number: [18],
              toFixed: 1,
              content: '{nt}',
            },
          },
          {
            title: '今日累计任务次数',
            number: {
              number: [2],
              toFixed: 1,
              content: '{nt}',
            },
          },
          {
            title: '今年失败任务次数',
            number: {
              number: [14],
              toFixed: 1,
              content: '{nt}',
            },
          },
          {
            title: '今年成功任务次数',
            number: {
              number: [106],
              toFixed: 1,
              content: '{nt}',
            },
          },
          {
            title: '今年达标任务个数',
            number: {
              number: [100],
              toFixed: 1,
              content: '{nt}',
            },
          },
        ],
        ranking: {
          data: [
            {
              name: '周口',
              value: 55,
            },
            {
              name: '南阳',
              value: 120,
            },
            {
              name: '西峡',
              value: 78,
            },
            {
              name: '驻马店',
              value: 66,
            },
            {
              name: '新乡',
              value: 80,
            },
            {
              name: '新乡',
              value: 80,
            },
            {
              name: '新乡',
              value: 80,
            },
            {
              name: '新乡',
              value: 80,
            },
          ],
          waitTime: 4000,
          carousel: 'page',
          unit: '份',
        },
        water: {
          data: [24, 45],
          shape: 'roundRect',
          formatter: '{value}%',
          waveNum: 3,
        },
        // 通过率和达标率的组件复用数据
        rate: [
          {
            id: 'centerRate1',
            tips: 60,
            colorData: {
              textStyle: '#3fc0fb',
              series: {
                color: ['#00bcd44a', 'transparent'],
                dataColor: {
                  normal: '#03a9f4',
                  shadowColor: '#97e2f5',
                },
              },
            },
          },
          {
            id: 'centerRate2',
            tips: 40,
            colorData: {
              textStyle: '#67e0e3',
              series: {
                color: ['#faf3a378', 'transparent'],
                dataColor: {
                  normal: '#ff9800',
                  shadowColor: '#fcebad',
                },
              },
            },
          },
        ],
      }
    },
  }
</script>

<style lang="scss" scoped>
  #center {
    display: flex;
    flex-direction: column;
    .up {
      width: 100%;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-around;
      .item {
        border-radius: 0.0625rem;
        padding-top: 20px;
        margin-top: 10px;
        width: 32%;
        height: 87.5px;
      }
    }
    .down {
      padding: 7px 5px;
      padding-bottom: 0;
      width: 100%;
      display: flex;
      height: 318.75px;
      justify-content: space-between;
      .bg-color-black {
        border-radius: 6.25px;
      }
      .ranking {
        padding: 12.5px;
        width: 59%;
      }
      .percent {
        width: 40%;
        display: flex;
        flex-wrap: wrap;
        .item {
          width: 50%;
          height: 150px;
          span {
            margin-top: 8.75px;
            display: flex;
            justify-content: center;
          }
        }
        .water {
          width: 100%;
        }
      }
    }
  }
</style>
