<template>
  <div class="test">
    <el-row>
      <div>
        <span
          style="
            font-size: 30px;
            color: #909399;
            margin: 50px;
            line-height: 100px;
          "
        >
          密接查询
        </span>
      </div>

      <!-- <el-row :gutter="20"> -->
      <el-col :span="20" style="margin: 50px">
        <el-card class="card" shadow="always">
          <div slot="header">
            <span style="font-size: 20px; color: #909399">Mac查询</span>
          </div>
          <div>
            <el-input
              v-model="input"
              placeholder="阳性患者MAC地址"
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
      <el-col v-for="(item, index) in querydata" :key="index">
        <el-card class="box-card" v-show="index<8">
          <div slot="header" class="clearfix">
            <span>
              <div class="top">
                <vab-icon
                  class="topImg"
                  :icon="['fas', 'user-circle']"
                ></vab-icon>
                <span class="toptext1">密接者{{index+1}}</span>
                <br />
                <!-- <span class="mac">设备名称:</span> -->
                <!-- <sapn class="nowmac">{{ item.name }}</sapn> -->
              </div>
            </span>
          </div>
          <div class="block1">
            <div class="circle1"></div>
            <div class="text1">IP地址</div>
            <div class="text11">{{ item.deviceIp }}</div>
            <!-- <div class="text12">Kb/s</div> -->
            <!-- <div class="hr1"><hr /></div> -->
          </div>
          <div class="block2">
            <div class="circle2"></div>
            <div class="text2">Mac地址</div>
            <div class="text21">{{ item.mac }}</div>
            <!-- <div class="text22">Kb/s</div> -->
            <!-- <div class="hr2"><hr /></div> -->
          </div>
          <!-- <div class="block3">
            <div class="circle3"></div>
            <div class="text3">流量</div>
            <div class="text31">{{ item.traffic }}</div>
            <div class="text32">Bps</div>
            <div class="hr3"><hr /></div>
          </div>
          <div class="block4">
            <div class="circle4"></div>
            <div class="text4">cpu占有率</div>
            <div class="text41">{{ item.cpuRate }}</div>
            <div class="text42">%</div>
            <div class="hr4"><hr /></div>
          </div>
          <div class="block5">
            <div class="circle5"></div>
            <div class="text5">经纬度</div>
            <div class="text51">({{ item.gisLon }}, {{ item.gisLat }})</div>
            <div class="text52">度</div>
            <div class="hr5"><hr /></div>
          </div> -->
        </el-card>
      </el-col>
  </div>
      <!-- <el-col :span="24">
        <el-pagination
          :background="background"
          :current-page="queryForm.pageNo"
          :page-size="queryForm.pageSize"
          :page-sizes="[72, 144, 216, 288]"
          :layout="layout"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        ></el-pagination>
      </el-col> -->
    </el-row>
  </div>
</template>

<script>
import { getPhoneUser, queryPhoneUser } from '@/api/phoneuser'
import center from '../../manage/paking/center.vue'

export default {
  components: { center },
  name: 'Nowphone',
  data() {
    return {
      show3 : false,
      layout: 'total, sizes, prev, pager, next, jumper',
      total: 0,
      background: true,
      height: 0,
      selectRows: '',
      elementLoadingText: '正在加载...',
      querydata: [],
      queryForm: {
        pageNo: 1,
        pageSize: 72,
        title: '',
      },
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    handleSizeChange(val) {
      this.queryForm.pageSize = val
      this.fetchData()
    },
    handleCurrentChange(val) {
      this.queryForm.pageNo = val
      this.fetchData()
    },
    queryData() {
      this.queryForm.pageNo = 1
      this.fetchData()
    },
    async fetchData() {
      const { data, totalCount } = await getPhoneUser(this.queryForm)
      this.querydata = data
      this.total = totalCount
      // console.log(this.querydata[0].name)
    },
  },
}
</script>
<style lang="scss" scoped>
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
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: '';
}
.clearfix:after {
  clear: both;
}

.box-card {
  // height: 200px;
  // margin: 0 auto;
  margin-left: 100px;
  margin-top: 20px;
  width: 1200px;
}
.topImg {
  width: 25px;
  height: 25px;
  margin-left: 10px;
}
.toptext1 {
  font-size: 15px;
  padding-left: 10px;
}
.use {
  margin-top: 5px;
  margin-left: 35px;
  font-size: 20px;
}
.user {
  font-size: 20px;
}
.nowmac {
  margin-top: 30px;
  padding-left: 30px;
  font-size: 20px;
}
.mac {
  font-size: 20px;
  padding-left: 10px;
  // color: blue;
}
// .block {
//   height: 200px;
//   width: 700px;
//   // border: 1px solid red;
// }
.circle1 {
  width: 15px;
  height: 15px;
  border: 1px solid #f0ebe3;
  border-radius: 50%;
  background-color: #f0ebe3;
  margin-top: -20px;
}
.text1 {
  font-family: '微软雅黑';
  font-size: 15px;
  // color: red;
  text-align: left;
  margin-top: -16px;
  margin-left: 25px;
  color: #565454;
}
.block1 {
  margin-left: 100px;
  margin-top: 50px;
  height: 100px;
  width: 200px;
  // border: 1px solid orange;
}
.text11 {
  font-size: 30px;
  margin-top: 10px;
  // color: red;
}
.text12 {
  font-size: 20px;
  text-align: left;
  margin-top: 5px;
  color: gray;
  // margin-top: 5px;
}
.hr1 {
  margin-top: -8px;
  // border: 0.05px solid black;
}
.block2 {
  margin-top: -100px;
  margin-left: 600px;
  height: 100px;
  width: 200px;
  // border: 1px solid orange;
}
.circle2 {
  width: 15px;
  height: 15px;
  border: 1px solid #a0d995;
  border-radius: 50%;
  background-color: #a0d995;
  margin-top: -20px;
}
.text2 {
  font-size: 15px;
  // color: orange;
  text-align: left;
  margin-top: -16px;
  margin-left: 25px;
}
.text21 {
  font-size: 30px;
  margin-top: 10px;
  // color: orange;
}
.text22 {
  font-size: 20px;
  text-align: left;
  margin-top: 5px;
  color: gray;
}
.hr2 {
  margin-top: -8px;
}
.block3 {
  margin-top: -100px;
  margin-left: 460px;
  height: 100px;
  width: 200px;
  // border: 1px solid pink;
}
.circle3 {
  width: 15px;
  height: 15px;
  border: 1px solid #fcbad3;
  border-radius: 50%;
  background-color: #fcbad3;
  margin-top: -20px;
}
.text3 {
  font-size: 15px;
  // color: pink;
  text-align: left;
  margin-top: -16px;
  margin-left: 25px;
}
.text31 {
  font-size: 30px;
  margin-top: 10px;
  // color: pink;
}
.text32 {
  font-size: 20px;
  text-align: left;
  margin-top: 5px;
  color: gray;
}
.hr3 {
  margin-top: -8px;
}
.block4 {
  margin-top: -100px;
  margin-left: 690px;
  height: 100px;
  width: 200px;
  // border: 1px solid green;
}
.circle4 {
  width: 15px;
  height: 15px;
  border: 1px solid #ffffd2;
  border-radius: 50%;
  background-color: #ffffd2;
  margin-top: -20px;
}
.text4 {
  font-size: 15px;
  // color: green;
  text-align: left;
  margin-top: -16px;
  margin-left: 25px;
}
.text41 {
  font-size: 30px;
  margin-top: 10px;
  // color: green;
}
.text42 {
  font-size: 20px;
  text-align: left;
  margin-top: 5px;
  color: gray;
}
.hr4 {
  margin-top: -8px;
}
.block5 {
  margin-top: -100px;
  margin-left: 920px;
  height: 100px;
  width: 200px;
}
.circle5 {
  width: 15px;
  height: 15px;
  border: 1px solid #aa96da;
  border-radius: 50%;
  background-color: #aa96da;
  margin-top: -20px;
}
.text5 {
  font-size: 15px;
  // color: purple;
  text-align: left;
  margin-top: -16px;
  margin-left: 25px;
}
.text51 {
  font-size: 30px;
  margin-top: 10px;
  color: pruple;
}
.text52 {
  font-size: 20px;
  text-align: left;
  margin-top: 5px;
  color: gray;
}
.hr5 {
  margin-top: -8px;
}
</style>
