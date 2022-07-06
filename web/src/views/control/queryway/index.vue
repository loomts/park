<template>
  <div>
    <div>
      <span
        style="
          font-size: 30px;
          color: #909399;
          margin: 50px;
          line-height: 100px;
        "
      >
        行程记录
      </span>
    </div>
    <el-row :gutter="20">
      <el-col :span="20" style="margin: 50px">
        <el-card class="card" shadow="always">
          <div slot="header">
            <span style="font-size: 20px; color: #909399">MAC查询</span>
          </div>
          <div>
            <el-input
              v-model="input"
              placeholder="输入查询用户的MAC地址"
              clearable
            ></el-input>
            <!-- <el-input v-model="input" placeholder="输入查询用户的MAC地址"></el-input> -->
          </div>
          <div style="margin: 20px; float: right">
            <el-button
              type="primary"
              size="medium"
              icon="el-icon-search"
              @click="show3 = !show3"
            >
              搜索
            </el-button>
          </div>
        </el-card>
      </el-col>

      <div v-show="show3">
        <el-col :span="20" style="margin: 50px">
          <el-card class="card" shadow="always">
            <img
              src="@/assets/way.png"
              style="width: 1260px; height: 800px"
            />
          </el-card>
        </el-col>

        <el-col :span="20" style="margin: 30px">
          <div class="block">
            <el-timeline>
              <div slot="header">
                <span style="font-size: 20px; color: #909399">行程记录</span>
              </div>
              <el-timeline-item timestamp="2022/6/30" placement="top">
                <el-card>
                  <div>
                    <el-table :data="tableData" style="width: 100%">
                      <el-table-column
                        prop="way"
                        label="MAC地址"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="time"
                        label="接入时间"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="address"
                        label="接入位置"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="long"
                        label="接入时长"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="tag"
                        label="设备接入状态"
                        width="180"
                        :filter-method="filterTag"
                        filter-placement="bottom-end"
                        align="center"
                      >
                        <div slot-scope="scope">
                          <el-tag
                            :type="
                              scope.row.tag === '优秀' ? 'primary' : 'success'
                            "
                            disable-transitions
                          >
                            {{ scope.row.tag }}
                          </el-tag>
                        </div>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-card>
              </el-timeline-item>
              <el-timeline-item timestamp="2021/12/25" placement="top">
                <el-card>
                  <div>
                    <el-table :data="tableData1" style="width: 100%">
                      <el-table-column
                        prop="way"
                        label="MAC地址"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="time"
                        label="接入时间"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="address"
                        label="接入位置"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="long"
                        label="接入时长"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="tag"
                        label="设备接入状态"
                        width="180"
                        :filter-method="filterTag"
                        filter-placement="bottom-end"
                        align="center"
                      >
                        <div slot-scope="scope">
                          <el-tag
                            :type="
                              scope.row.tag === '优秀' ? 'primary' : 'success'
                            "
                            disable-transitions
                          >
                            {{ scope.row.tag }}
                          </el-tag>
                        </div>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-card>
              </el-timeline-item>
              <el-timeline-item timestamp="2021/5/31" placement="top">
                <el-card>
                  <div>
                    <el-table :data="tableData2" style="width: 100%">
                      <el-table-column
                        prop="way"
                        label="MAC地址"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="time"
                        label="接入时间"
                        width="180"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="address"
                        label="接入位置"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="long"
                        label="接入时长"
                        align="center"
                      ></el-table-column>
                      <el-table-column
                        prop="tag"
                        label="设备接入状态"
                        width="180"
                        :filter-method="filterTag"
                        filter-placement="bottom-end"
                        align="center"
                      >
                        <div slot-scope="scope">
                          <el-tag
                            :type="
                              scope.row.tag === '优秀' ? 'primary' : 'success'
                            "
                            disable-transitions
                          >
                            {{ scope.row.tag }}
                          </el-tag>
                        </div>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-card>
              </el-timeline-item>
            </el-timeline>
          </div>
        </el-col>
      </div>
    </el-row>
  </div>
</template>

<script>
// import VabChart from '@/plugins/echarts'
import * as echarts from 'echarts'
import { dependencies, devDependencies } from '../../../../package.json'
import { getList } from '@/api/changeLog'
import { getNoticeList } from '@/api/notice'

export default {
  name: 'Queryway',
  components: {
    // VabChart,
  },

  data() {
    return {
      show3: false,
      timer: 0,
      input: '',
      updateTime: process.env.VUE_APP_UPDATE_TIME,
      nodeEnv: process.env.NODE_ENV,
      dependencies: dependencies,
      devDependencies: devDependencies,
      tableData: [
        {
          way: '80-30-49-31-FA-65',
          time: '08:50:34',
          address: '园区入口',
          long: '50min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '09:45:32',
          address: '奇想花园',
          long: '22min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '10:12:27',
          address: '皮克斯玩具总动员',
          long: '43min',
          tag: '一般',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '12:50:34',
          address: '皮克斯玩具总动员',
          long: '23min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '13:10:55',
          address: '皮克斯玩具总动员',
          long: '22min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '14:00:27',
          address: '奇想花园',
          long: '43min',
          tag: '一般',
        },
        ,
        {
          way: '80-30-49-31-FA-65',
          time: '14:43:34',
          address: '探险岛',
          long: '35min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '15:30:55',
          address: '探险岛',
          long: '22min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '16:00:27',
          address: '奇想花园',
          long: '72min',
          tag: '一般',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '18:10:58',
          address: '奇想花园',
          long: '32min',
          tag: '优秀',
        },
      ],
      tableData1: [
        {
          way: '80-30-49-31-FA-65',
          time: '10:50:58',
          address: '园区入口',
          long: '32min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '11:22:55',
          address: '奇想花园',
          long: '22min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '11:44:27',
          address: '探险岛',
          long: '43min',
          tag: '一般',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '12:50:34',
          address: '探险岛',
          long: '50min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '13:45:55',
          address: '宝藏湾',
          long: '22min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '14:32:27',
          address: '奇想花园',
          long: '43min',
          tag: '一般',
        },
      ],
      tableData2: [
        {
          way: '80-30-49-31-FA-65',
          time: '10:50:34',
          address: '园区入口',
          long: '50min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '11:45:32',
          address: '奇想花园',
          long: '22min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '12:50:34',
          address: '梦幻世界',
          long: '23min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '14:10:55',
          address: '皮克斯玩具总动员',
          long: '22min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '15:00:27',
          address: '明日世界',
          long: '43min',
          tag: '一般',
        },
        ,
        {
          way: '80-30-49-31-FA-65',
          time: '16:43:34',
          address: '明日世界',
          long: '35min',
          tag: '优秀',
        },
        {
          way: '80-30-49-31-FA-65',
          time: '17:30:55',
          address: '奇想花园',
          long: '22min',
          tag: '优秀',
        },
      ],
    }
  },
  created() {
    // this.fetchData()
  },
  beforeDestroy() {
    // clearInterval(this.timer)
  },
  mounted() {
    // let base = +new Date(2020, 1, 1)
    // let oneDay = 24 * 3600 * 1000
    // let date = []

    // let data = [Math.random() * 1500]
    // let now = new Date(base)

    // const addData = (shift) => {
    //   now = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/')
    //   date.push(now)
    //   data.push(this.$baseLodash.random(20000, 60000))

    //   if (shift) {
    //     date.shift()
    //     data.shift()
    //   }

    //   now = new Date(+new Date(now) + oneDay)
    // }

    // // for (let i = 1; i < 6; i++) {
    // //   addData()
    // // }
    // addData(true)
    // this.fwl.xAxis[0].data = date
    // this.fwl.series[0].data = data
    // this.timer = setInterval(() => {
    //   addData(true)
    //   this.fwl.xAxis[0].data = date
    //   this.fwl.series[0].data = data
    // }, 3000)
  },
  methods: {},
}
</script>
<style lang="scss" scoped>
.index-container {
  padding: 0 !important;
  margin: 0 !important;
  background: #f5f7f8 !important;

  ::v-deep {
    .el-alert {
      padding: $base-padding;

      &--info.is-light {
        min-height: 82px;
        padding: $base-padding;
        margin-bottom: 15px;
        color: #909399;
        background-color: $base-color-white;
        border: 1px solid #ebeef5;
      }
    }

    .el-card__body {
      .echarts {
        width: 100%;
        height: 115px;
      }
    }
  }

  .card {
    ::v-deep {
      .el-card__body {
        .echarts {
          width: 100%;
          height: 305px;
        }
      }
    }
  }
  .image1 {
    width: 30%;
    display: block;
  }

  .bottom {
    padding-top: 20px;
    margin-top: 5px;
    color: #595959;
    text-align: left;
    border-top: 1px solid $base-border-color;
  }

  .table {
    width: 100%;
    color: #666;
    border-collapse: collapse;
    background-color: #fff;

    td {
      position: relative;
      min-height: 20px;
      padding: 9px 15px;
      font-size: 14px;
      line-height: 20px;
      border: 1px solid #e6e6e6;

      &:nth-child(odd) {
        width: 20%;
        text-align: right;
        background-color: #f7f7f7;
      }
    }
  }

  .icon-panel {
    height: 117px;
    text-align: center;
    cursor: pointer;

    svg {
      font-size: 40px;
    }

    p {
      margin-top: 10px;
    }
  }

  .bottom-btn {
    button {
      margin: 5px 10px 15px 0;
    }
  }
}
</style>
