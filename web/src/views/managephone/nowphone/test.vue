<template>
  <div class="test">
    <el-row>
      <el-col>
        <el-form :inline="true" label-width="80px" @submit.native.prevent>
          <el-form-item label="设备名称">
            <el-input v-model="queryForm.title"></el-input>
          </el-form-item>
          <el-form-item label-width="0">
            <el-button native-type="submit" type="primary" @click="queryData">
              搜索
            </el-button>
          </el-form-item>
        </el-form>
      </el-col>

      <el-col v-for="(item, index) in querydata" :key="index">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>
              <div class="top">
                <vab-icon
                  class="topImg"
                  :icon="['fas', 'user-circle']"
                ></vab-icon>
                <span class="toptext1">User</span>
                <span class="mac">设备名称:</span>
                <sapn class="nowmac">{{ item.name }}</sapn>
              </div>
            </span>
          </div>
          <div class="block1">
            <div class="circle1"></div>
            <div class="text1">上行速率</div>
            <div class="text11">{{ item.upwardSpeed }}</div>
            <div class="text12">Kb/s</div>
            <div class="hr1"><hr /></div>
          </div>
          <div class="block2">
            <div class="circle2"></div>
            <div class="text2">下行速率</div>
            <div class="text21">{{ item.downwardSpeed }}</div>
            <div class="text22">Kb/s</div>
            <div class="hr2"><hr /></div>
          </div>
          <div class="block3">
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
          </div>
        </el-card>
      </el-col>
      <el-col :span="24">
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
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import { getPhoneUser, queryPhoneUser } from '@/api/phoneuser'

  export default {
    name: 'Nowphone',
    data() {
      return {
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
    width: 1200px;
  }
  .topImg {
    width: 25px;
    height: 25px;
    margin-left: 10px;
  }
  .toptext1 {
    font-size: 25px;
    padding-left: 10px;
  }
  .use {
    margin-top: 5px;
    margin-left: 35px;
  }
  .user {
    font-size: 20px;
  }
  .nowmac {
    padding-left: 10px;
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
    border: 1px solid red;
    border-radius: 50%;
    background-color: red;
    margin-top: -20px;
  }
  .text1 {
    font-size: 15px;
    color: red;
    text-align: left;
    margin-top: -16px;
    margin-left: 25px;
  }
  .block1 {
    margin-top: 10px;
    height: 100px;
    width: 200px;
    // border: 1px solid orange;
  }
  .text11 {
    font-size: 30px;
    margin-top: 10px;
    color: red;
  }
  .text12 {
    font-size: 30px;
    text-align: left;
    margin-top: 5px;
    color: gray;
    // margin-top: 5px;
  }
  .hr1 {
    margin-top: -8px;
  }
  .block2 {
    margin-top: -100px;
    margin-left: 230px;
    height: 100px;
    width: 200px;
    // border: 1px solid orange;
  }
  .circle2 {
    width: 15px;
    height: 15px;
    border: 1px solid orange;
    border-radius: 50%;
    background-color: orange;
    margin-top: -20px;
  }
  .text2 {
    font-size: 15px;
    color: orange;
    text-align: left;
    margin-top: -16px;
    margin-left: 25px;
  }
  .text21 {
    font-size: 30px;
    margin-top: 10px;
    color: orange;
  }
  .text22 {
    font-size: 30px;
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
    border: 1px solid pink;
    border-radius: 50%;
    background-color: pink;
    margin-top: -20px;
  }
  .text3 {
    font-size: 15px;
    color: pink;
    text-align: left;
    margin-top: -16px;
    margin-left: 25px;
  }
  .text31 {
    font-size: 30px;
    margin-top: 10px;
    color: pink;
  }
  .text32 {
    font-size: 30px;
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
    border: 1px solid green;
    border-radius: 50%;
    background-color: green;
    margin-top: -20px;
  }
  .text4 {
    font-size: 15px;
    color: green;
    text-align: left;
    margin-top: -16px;
    margin-left: 25px;
  }
  .text41 {
    font-size: 30px;
    margin-top: 10px;
    color: green;
  }
  .text42 {
    font-size: 30px;
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
    border: 1px solid purple;
    border-radius: 50%;
    background-color: purple;
    margin-top: -20px;
  }
  .text5 {
    font-size: 15px;
    color: purple;
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
    font-size: 30px;
    text-align: left;
    margin-top: 5px;
    color: gray;
  }
  .hr5 {
    margin-top: -8px;
  }
</style>
