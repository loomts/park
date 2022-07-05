<template>
  <div id="index">
    <dv-full-screen-container class="bg">
      <dv-loading v-if="loading">Loading...</dv-loading>
      <div v-else class="host-body">
        <div class="d-flex jc-center">
          <dv-decoration-10 style="width: 33.3%; height: 62.5px" />
          <div class="d-flex jc-center">
            <dv-decoration-8
              :color="['#568aea', '#000000']"
              style="width: 250px; height: 6.25px"
            />
            <!-- <div class="title">
              <span class="title-text">数据显示</span>
              <dv-decoration-6
                class="title-bototm"
                :reverse="true"
                :color="['#50e3c2', '#67a1e5']"
                style="width: 312.5px; height: 100px"
              />
            </div> -->
            <dv-decoration-8
              :reverse="true"
              :color="['#568aea', '#000000']"
              style="width: 250px; height: 62.5px"
            />
          </div>
          <dv-decoration-10
            style="width: 33.3%; height: 62.5px; transform: rotateY(180deg)"
          />
        </div>

        <!-- 第二行 -->
        <div class="d-flex jc-between px-2">
          <!-- <div class="d-flex" style="width: 40%">
            <div
              class="react-right ml-4"
              style="width: 625px; text-align: left; background-color: #0f1325"
            >
              <span class="react-before"></span>
                 <span class="text">数据分析1</span>
            </div>
            <div class="react-right ml-3" style="background-color: #0f1325">
              <span class="text colorBlue">数据分析2</span>
            </div>
          </div> -->
          <!-- <div style="width: 40%" class="d-flex">
            <div class="react-left bg-color-blue mr-3">
                <span class="text fw-b">vue-big-screen</span>
            </div>
            <div
              class="react-left mr-4"
              style="width: 625px; background-color: #0f1325; text-align: right"
            >
              <span class="react-after"></span>
              <span class="text">2022年07月04日 周一 12:00</span>
            </div>
          </div> -->
        </div>

        <!-- 第四行数据 -->
        <div class="bototm-box">
          <dv-border-box-13>
            <bottomLeft />
          </dv-border-box-13>
          <dv-border-box-12>
            <div>
              <centerRight2 />
            </div>
            <!-- <bottomRight /> -->
          </dv-border-box-12>
        </div>

        <div class="body-box">
          <!-- 第三行数据 -->
          <div class="content-box">
            <div>
              <dv-border-box-12>
                <centerLeft1 />
              </dv-border-box-12>
            </div>
            <!-- <div>
              <dv-border-box-12>
                <centerLeft2 />
              </dv-border-box-12>
            </div> -->
            <!-- 中间 -->
            <!-- <div>
              <center />
            </div> -->
            <!-- 中间 -->
            <div>
              <bottomRight />
            </div>
            <!-- <div>
              <dv-border-box-13>
                <centerRight1 />
              </dv-border-box-13>
            </div> -->
          </div>
        </div>
      </div>
    </dv-full-screen-container>
  </div>
</template>

<script>
  import centerLeft1 from '../paking/centerLeft1'
  // import centerLeft2 from './paking/centerLeft2'
  // import centerRight1 from './paking/centerRight1'
  // import centerRight2 from './paking/centerRight2'
  // import center from './paking/center'
  import bottomLeft from '../paking/bottomLeft'
  import bottomRight from '../paking/bottomRight'
  export default {
    components: {
      centerLeft1,
      // centerLeft2,
      // centerRight1,
      // centerRight2,
      // center,
      bottomLeft,
      bottomRight,
    },
    data() {
      return {
        loading: true,
      }
    },
    mounted() {
      this.cancelLoading()
    },
    methods: {
      cancelLoading() {
        setTimeout(() => {
          this.loading = false
        }, 500)
      },
    },
  }
</script>

<style lang="scss">
  @import '../../../assets/scss/index.scss';
</style>
