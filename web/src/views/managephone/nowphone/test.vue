<template>
  <div class="test">
    <el-row>
      <el-col :span="20" style="margin: 50px;width:1465px">
        <el-card class="card" shadow="always">
          <div slot="header">
            <span style="font-size: 20px; color: #909399">设备名称</span>
          </div>
          <div>
            <el-input
              v-model="queryForm.title"
              placeholder="输入设备名称，支持模糊查询"
              clearable
            ></el-input>
          </div>
          <div style="margin: 20px; float: right">
            <el-button native-type="submit" type="primary" @click="queryData">
              搜索
            </el-button>
          </div>
        </el-card>
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
                <br />
                <!-- <span class="mac">设备名称:</span> -->
                <sapn class="nowmac">{{ item.name }}</sapn>
              </div>
            </span>
          </div>
          <div class="block1">
            <div class="circle1"></div>
            <div class="text1">上行速率</div>
            <div class="text11">
              {{ item.upwardSpeed }}
              <span class="text12">Kb/s</span>
            </div>
            <br />
            <div class="hr1"><hr /></div>
          </div>
          <div class="block2">
            <div class="circle2"></div>
            <div class="text2">下行速率</div>
            <div class="text21">
              {{ item.downwardSpeed }}
              <span class="text22">Kb/s</span>
            </div>
            <br />
            <div class="hr2"><hr /></div>
          </div>
          <div class="block3">
            <div class="circle3"></div>
            <div class="text3">流量</div>
            <div class="text31">
              {{ item.traffic }}
              <span class="text32">Bps</span>
            </div>
            <br />
            <div class="hr3"><hr /></div>
          </div>
          <div class="block4">
            <div class="circle4"></div>
            <div class="text4">cpu占有率</div>
            <div class="text41">
              {{ item.cpuRate }}
              <span class="text42">%</span>
            </div>
            <br />
            <div class="hr4"><hr /></div>
          </div>
          <div class="block5">
            <div class="circle5"></div>
            <div class="text5">经纬度</div>
            <div class="text51">
              ({{ item.gisLon }}, {{ item.gisLat }})
              <span class="text52">度</span>
            </div>
            <br />
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
  import * as allApi from '../../../../api.js'
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
      async getNowUser(queryForm) {
        var startNo = (queryForm.pageNo - 1) * queryForm.pageSize
        var endNo = startNo + queryForm.pageSize
        let data = []
        var jsonObj = await allApi.getDeviceDetailByName(queryForm.title)
        for (var i = startNo; i < jsonObj.length && i < endNo; i++) {
          data.push({
            name: jsonObj[i].name,
            gisLon: jsonObj[i].gisLon,
            gisLat: jsonObj[i].gisLat,
            traffic: jsonObj[i].traffic,
            upwardSpeed: jsonObj[i].upwardSpeed,
            downwardSpeed: jsonObj[i].downwardSpeed,
            cpuRate: jsonObj[i].cpuRate,
          })
        }
        return [data, jsonObj.length]
      },
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
        var res = await this.getNowUser(this.queryForm)
        this.querydata = res[0]
        this.total = res[1]
      },
    },
  }
</script>
<style lang="scss" scoped>
  .test {
    font-family: 'Georgia', 'Lucida Sans', 'sans-serif', 'Lucida Grande',
      'Lucida Sans';
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
    margin-left: 100px;
    margin-top: 20px;
    width: 1360px;
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
    font-size: 15px;
    text-align: left;
    margin-top: -16px;
    margin-left: 25px;
    color: #565454;
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
    // color: red;
  }
  .text12 {
    font-family: 'Lucida Sans';
    font-size: 20px;
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
    font-family: 'Lucida Sans';
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
    font-family: 'Lucida Sans';
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
    font-family: 'Lucida Sans';
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
    width: 400px;
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
