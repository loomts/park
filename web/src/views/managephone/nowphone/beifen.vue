<template>
  <div class="test">
    <el-container>
      <el-header>
        <div class="top">
          <vab-icon class="topImg" :icon="['fas', 'user-circle']"></vab-icon>
          <span class="toptext1">User1</span>
        </div>
      </el-header>
      <el-header>
        <div class="use">
          <sapn class="user">普通用户</sapn>
          <span class="mac">MAC:</span>
          <sapn class="nowmac">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</sapn>
        </div>
      </el-header>
      <el-main>
        <div class="block1">
          <div class="circle1"></div>
          <div class="text1">平均速率</div>
          <div class="text11">1645</div>
          <div class="text12">Mbps</div>
          <div class="hr"><hr /></div>
        </div>
        <div class="block2">
          <div class="circle2"></div>
          <div class="text2">时延</div>
          <div class="text21">33</div>
          <div class="text12">MS</div>
          <div class="hr"><hr /></div>
        </div>
        <div class="block3">
          <div class="circle3"></div>
          <div class="text3">接入次数</div>
          <div class="text31">1</div>
          <div class="text12">次</div>
          <div class="hr"><hr /></div>
        </div>
        <div class="block4">
          <div class="circle4"></div>
          <div class="text4">活跃时间</div>
          <div class="text41">976</div>
          <div class="text12">S</div>
          <div class="hr"><hr /></div>
        </div>
        <div class="block5">
          <div class="circle5"></div>
          <div class="text5">位置</div>
          <div class="text51">XX</div>
          <div class="text12">XX</div>
          <div class="hr"><hr /></div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import { getPhoneUser } from '@/api/phoneuser'

  export default {
    name: 'Nowphone',
    data() {
      return {
        copyText: '',
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
      // handleSizeChange(val) {
      //   this.queryForm.pageSize = val
      //   this.fetchData()
      // },
      // handleCurrentChange(val) {
      //   this.queryForm.pageNo = val
      //   this.fetchData()
      // },
      // queryData() {
      //   this.queryForm.pageNo = 1
      //   this.fetchData()
      // },
      async fetchData() {
        const { data, totalCount } = await getPhoneUser(this.queryForm)
        this.querydata = data
        this.total = totalCount
        console.log(this.querydata)
      },
    },
  }
</script>
<style lang="scss" scoped>
  .el-header {
    background-color: #b3c0d1;
    color: #333;
    text-align: center;
    line-height: 60px;
    height: 100px;
  }

  .el-main {
    background-color: #e9eef3;
    color: #333;
    text-align: center;
    line-height: 160px;
    height: 300px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .topImg {
    width: 30px;
    height: 30px;
    margin-left: 10px;
  }
  .toptext1 {
    font-size: 30px;
    padding-left: 10px;
  }
  .use {
    margin-top: 10px;
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
    color: blue;
  }
  .block {
    height: 200px;
    width: 800px;
    // border: 1px solid red;
  }
  .circle1 {
    width: 20px;
    height: 20px;
    border: 1px solid red;
    border-radius: 50%;
    background-color: red;
  }
  .text1 {
    font-size: 20px;
    color: red;
    text-align: left;
    margin-top: -90px;
    margin-left: 30px;
  }
  .block1 {
    margin-top: 10px;
    height: 100px;
    width: 200px;
    // border: 1px solid orange;
  }
  .text11 {
    font-size: 60px;
    margin-top: -80px;
    color: red;
  }
  .text12 {
    font-size: 40px;
    text-align: left;
    margin-top: -80px;
    color: gray;
    // margin-top: 5px;
  }
  .hr {
    margin-top: -75px;
  }
  .block2 {
    margin-top: -100px;
    margin-left: 300px;
    height: 100px;
    width: 200px;
    // border: 1px solid orange;
  }
  .circle2 {
    width: 20px;
    height: 20px;
    border: 1px solid orange;
    border-radius: 50%;
    background-color: orange;
  }
  .text2 {
    font-size: 20px;
    color: orange;
    text-align: left;
    margin-top: -90px;
    margin-left: 30px;
  }
  .text21 {
    font-size: 60px;
    margin-top: -80px;
    color: orange;
  }
  .block3 {
    margin-top: -100px;
    margin-left: 600px;
    height: 100px;
    width: 200px;
    // border: 1px solid pink;
  }
  .circle3 {
    width: 20px;
    height: 20px;
    border: 1px solid pink;
    border-radius: 50%;
    background-color: pink;
  }
  .text3 {
    font-size: 20px;
    color: pink;
    text-align: left;
    margin-top: -90px;
    margin-left: 30px;
  }
  .text31 {
    font-size: 60px;
    margin-top: -80px;
    color: pink;
  }
  .block4 {
    margin-top: -100px;
    margin-left: 900px;
    height: 100px;
    width: 200px;
    // border: 1px solid green;
  }
  .circle4 {
    width: 20px;
    height: 20px;
    border: 1px solid green;
    border-radius: 50%;
    background-color: green;
  }
  .text4 {
    font-size: 20px;
    color: green;
    text-align: left;
    margin-top: -90px;
    margin-left: 30px;
  }
  .text41 {
    font-size: 60px;
    margin-top: -80px;
    color: green;
  }
  .block5 {
    margin-top: -100px;
    margin-left: 1200px;
    height: 100px;
    width: 200px;
  }
  .circle5 {
    width: 20px;
    height: 20px;
    border: 1px solid purple;
    border-radius: 50%;
    background-color: purple;
  }
  .text5 {
    font-size: 20px;
    color: purple;
    text-align: left;
    margin-top: -90px;
    margin-left: 30px;
  }
  .text51 {
    font-size: 60px;
    margin-top: -80px;
    color: purple;
  }
</style>
