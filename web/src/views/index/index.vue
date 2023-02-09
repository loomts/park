<template>
  <div id="index-container">
    <!-- <div class="canvas" style="opacity: .2"> -->
    <!-- <iframe frameborder="0" src="js/index.html" style="width: 100%; height: 100%"></iframe> -->
    <!-- frameborder属性：不设置边框，如果是vue2.x版本，那么可以使用src属性  -->
    <!-- <iframe style="width: 100%; height: 100%;" id="tempHtml" ref="tempHtml" frameborder="0"></iframe> -->

    <!-- </div> -->
    <!-- 在img标签中可以直接使用backgroundImgUrl变量作为图片路径 -->
    <!-- <img :src="backgroundImgUrl" class="indeximg" /> -->
    <!-- 在style中要把backgroundImgUrl变量拼接到url()中，才能正常引入图片 -->
    <!-- <div :style="{ backgroundImage: `url{{backgroundImgUrl}}` }"></div> -->
    <!-- <div class="title">园区总览</div> -->

    <div class="boxall" style="height: 475px;width:500px">
      <div class="alltitle1">游客数量</div>
      <echarts4Vue class="echart1"></echarts4Vue>
      <div class="foot1"></div>
    </div>

    <!-- <div></div> -->
    <div class="boxall2" style="height: 470px;width:500px">
      <div class="alltitle2">停车场使用情况</div>
      <echarts2Vue class="echart2"></echarts2Vue>
      <div class="foot2"></div>
    </div>

    <div class="boxtitle">
      <!-- <span class="shouru1">2022年总收入情况</span><br/><span class="shouru2">147766320</span> -->
      <div class="bar">
        <div class="barbox">
          <ul class="clearfix">
            <li class="pulll_left counter">125811</li>
            <li class="pulll_left counter">39124</li>
          </ul>
        </div>
        <div class="barbox2">
          <ul class="clearfix">
            <li class="pulll_left">今日收入情况</li>
            <li class="pulll_left">今日游客数量</li>
          </ul>
        </div>
      </div>
      <div class="foot"></div>
    </div>

    <div class="boxall3" style="height:700px, width: 700px;">
      <echarts3Vue class="echart3"></echarts3Vue>
      <div class="foot3"></div>
    </div>

    <div class="boxall4" style="height: 400px">
      <div class="alltitle4">上周收益情况</div>
      <echarts1Vue class="echart4"></echarts1Vue>
      <div class="foot4"></div>
    </div>

    <!-- :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }" -->
    <div class="boxall5" style="height: 370px;width:1050px">
      <div class="alltitle5">站点健康度</div>
      <echarts5Vue class="echart5"></echarts5Vue>

      <img :src="backgroundImgUrl" class="indeximg" />
      <!-- <div class="cot">
          <el-table
            :data="tableData_1"
            :cell-style="CellStyle"
      :header-cell-style="{
        background: '#04155f',
        color: '#606266',
        // fontWeight: '600',
        // fontSize: '14px',
      }"
    
          >

            <el-table-column
            
              prop="time"
              label="时间"
              width="160"
            >
            </el-table-column>

            <el-table-column
              prop="address"
              label="地点"
              width="200"
            ></el-table-column>

            <el-table-column
              prop="count"
              label="瞬时设备接入数"
              width="250"
            ></el-table-column>


          </el-table>
      </div> -->
      <div class="foot5"></div>
    </div>
  </div>
</template>

<script>
  // 在vue组件中定义此变量，组件创建成功后该变量值为'/static/img/login-bg.df6a3174.png'
  // import VabChart from '@/plugins/echarts'
  // import { dependencies, devDependencies } from '../../../package.json
  // import Plan from './components/Plan'
  // import VersionInformation from './components/VersionInformation'
  import echarts1Vue from './components/echarts1.vue'
  import echarts2Vue from './components/echarts2.vue'
  import echarts3Vue from './components/echarts3.vue'
  import echarts4Vue from './components/echarts4.vue'
  import echarts5Vue from './components/echarts5.vue'
  export default {
    name: 'Index',
    components: {
      echarts1Vue,
      echarts2Vue,
      echarts3Vue,
      echarts4Vue,
      echarts5Vue,
    },
    data() {
      const item_1 = {
        time: '06:22',
        address: '探险岛',
        count: '2514',
      }
      return {
        backgroundImgUrl: require('@/assets/imgbg.png'),
        tableData_1: [
          {
            time: '06:22',
            address: '探险岛',
            count: '2514',
          },
          {
            time: '06:22',
            address: '探险岛',
            count: '2514',
          },
          {
            time: '06:22',
            address: '探险岛',
            count: '2514',
          },
          {
            time: '06:22',
            address: '探险岛',
            count: '2514',
          },
          {
            time: '06:22',
            address: '探险岛',
            count: '2514',
          },
        ],
      }
    },

    methods: {
      //  cellStyle(row, column, rowIndex, columnIndex) {
      //     console.log(rowIndex)
      //     if (row.colunm.label === "地点") return 'color : red'
      //   }
    },
  }
</script>


<style lang="scss" scoped>
  .indeximg {
    // width: 650px;
    float: left;
    margin-left: 450px;
    margin-top: -255px;
  }
  .cell {
    // background-color: #02a6b5,
    color: #fff;
  }

  .el-table,
  .el-table__expanded-cell {
    background-color: transparent;
    color: white;
  }
  .cot {
    background-color: #04155f;
    background: #04155f;
    color: white;
  }
  el-table-column {
    background-color: #04155f;
    color: white;
  }
  .el-table th,
  .el-table tr {
    background-color: #04155f;
    color: white;
  }

  .boxall li,
  .boxall li {
    width: 50%;
    text-align: center;
    position: relative;
    z-index: 100;
  }
  .boxall:before,
  .boxall:after {
    position: absolute;
    width: 0.3rem;
    height: 0.1rem;
    content: '';
  }
  .boxall:before {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .boxall:after {
    position: absolute;
    top: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .foot1:before {
    position: absolute;
    bottom: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .foot1:after {
    position: absolute;
    bottom: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .boxall {
    border: 2rem solid #02a6b5;
  }
  .boxall li:first-child:before {
    position: absolute;
    content: '';
    height: 50%;
    width: 1px;
    background: rgba(255, 255, 255, 0.2);
    right: 0;
    top: 25%;
  }

  .boxall {
    border: 1px solid rgba(25, 186, 139, 0.7);
    position: relative;
  }
  .boxall li {
    font-size: 40px;
    color: #ffeb7b;
    padding: 0.05rem 0;
    font-family: electronicFont;
    font-weight: bold;
  }
  .boxall li {
    font-size: 20px;
    color: rgba(255, 255, 255, 0.7);
    padding-top: 0.1rem;
  }

  //2
  .boxall2 li,
  .boxall2 li {
    width: 50%;
    text-align: center;
    position: relative;
    z-index: 100;
  }
  .boxall2:before,
  .boxall2:after {
    position: absolute;
    width: 0.3rem;
    height: 0.1rem;
    content: '';
  }
  .boxall2:before {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .boxall2:after {
    position: absolute;
    top: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .foot2:before {
    position: absolute;
    bottom: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .foot2:after {
    position: absolute;
    bottom: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .boxall2 {
    border: 2rem solid #02a6b5;
  }
  .boxall2 li:first-child:before {
    position: absolute;
    content: '';
    height: 50%;
    width: 1px;
    background: rgba(255, 255, 255, 0.2);
    right: 0;
    top: 25%;
  }

  .boxall2 {
    border: 1px solid rgba(25, 186, 139, 0.7);
    position: relative;
  }
  .boxall2 li {
    font-size: 40px;
    color: #ffeb7b;
    padding: 0.05rem 0;
    font-family: electronicFont;
    font-weight: bold;
  }
  .boxall2 li {
    font-size: 20px;
    color: rgba(255, 255, 255, 0.7);
    padding-top: 0.1rem;
  }

  // 4
  .boxall4 li,
  .boxall4 li {
    width: 50%;
    text-align: center;
    position: relative;
    z-index: 100;
  }
  .boxall4:before,
  .boxall4:after {
    position: absolute;
    width: 0.3rem;
    height: 0.1rem;
    content: '';
  }
  .boxall4:before {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .boxall4:after {
    position: absolute;
    top: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .foot4:before {
    position: absolute;
    bottom: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .foot4:after {
    position: absolute;
    bottom: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .boxall4 {
    border: 2rem solid #02a6b5;
  }
  .boxall4 li:first-child:before {
    position: absolute;
    content: '';
    height: 50%;
    width: 1px;
    background: rgba(255, 255, 255, 0.2);
    right: 0;
    top: 25%;
  }

  .boxall4 {
    border: 1px solid rgba(25, 186, 139, 0.7);
    position: relative;
  }
  .boxall4 li {
    font-size: 40px;
    color: #ffeb7b;
    padding: 0.05rem 0;
    font-family: electronicFont;
    font-weight: bold;
  }
  .boxall4 li {
    font-size: 20px;
    color: rgba(255, 255, 255, 0.7);
    padding-top: 0.1rem;
  }

  // 5
  .boxall5 li,
  .boxall5 li {
    width: 50%;
    text-align: center;
    position: relative;
    z-index: 100;
  }
  .boxall5:before,
  .boxall5:after {
    position: absolute;
    width: 0.3rem;
    height: 0.1rem;
    content: '';
  }
  .boxall5:before {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .boxall5:after {
    position: absolute;
    top: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-top: 2px solid #02a6b5;
    content: '';
  }
  .foot5:before {
    position: absolute;
    bottom: 0px;
    right: 0px;
    width: 10px;
    height: 10px;
    border-right: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .foot5:after {
    position: absolute;
    bottom: 0px;
    left: 0px;
    width: 10px;
    height: 10px;
    border-left: 2px solid #02a6b5;
    border-bottom: 2px solid #02a6b5;
    content: '';
  }
  .boxall5 {
    border: 2rem solid #02a6b5;
  }
  .boxall5 li:first-child:before {
    position: absolute;
    content: '';
    height: 50%;
    width: 1px;
    background: rgba(255, 255, 255, 0.2);
    right: 0;
    top: 25%;
  }

  .boxall5 {
    border: 1px solid rgba(25, 186, 139, 0.7);
    position: relative;
  }
  .boxall5 li {
    font-size: 40px;
    color: #ffeb7b;
    padding: 0.05rem 0;
    font-family: electronicFont;
    font-weight: bold;
  }
  .boxall5 li {
    font-size: 20px;
    color: rgba(255, 255, 255, 0.7);
    padding-top: 0.1rem;
  }

  .cot {
    // background-color: transparent;
    // background: rgb(123, 255, 255);
    // width: 350px;
    margin-top: -280px;
    margin-left: 380px;
    // z-index: 20;
    font-family: 'Georgia', 'Lucida Sans', '微软雅黑', 'sans-serif',
      'Lucida Grande', 'Lucida Sans';
    // color: black;
  }

  .cot .el-table--fit {
    padding: 20px;
  }
  .cot .el-table,
  .el-table__expanded-cell {
    background-color: transparent;
  }

  .cot .el-table tr {
    background-color: transparent !important;
  }
  .cot .el-table--enable-row-transition .el-table__body td,
  .el-table .cell {
    background-color: transparent;
  }
  .el-table::before {
    //去除底部白线
    left: 0;
    bottom: 0;
    width: 100%;
    height: 0px;
  }

  .boxall6 {
    // width:35%;
    // // border: 1px solid rgba(25,186,139,.17);
    // padding:0.2rem .4rem .15rem;
    // background: rgba(255,255,255,.04) url('../../assets/line2.jpg');
    // background-size: 100% auto;
    // position: relative;
    //  margin-bottom: .15rem;
    // z-index: 10;
    margin-left: 700px;
    margin-top: -400px;
    float: left;
  }
  #index-container {
    // background: 		#04155f;
    // top:0;
    // left: 0;
    // position: fixed;
    background: rgb(4, 20, 93);
    width: 100%;
    height: 100%;
    float: left;
  }
  .boxall5 {
    width: 75%;
    // border: 1px solid rgba(25,186,139,.17);
    padding: 0.2rem 0.4rem 0.15rem;
    // background: rgba(255,255,255,.04) url('../../assets/line2.jpg');
    background-size: 100% auto;
    position: relative;
    margin-bottom: 0.15rem;
    z-index: 10;
    margin-top: -540px;
    margin-left: 540px;
    float: left;
  }
  .alltitle5 {
    font-size: 26px;
    color: white;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
    text-align: center;
    padding-top: 40px;
  }
  .alltitle1 {
    font-size: 26px;
    color: white;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
    text-align: center;
    // padding-left: 100px;
    padding-top: 25px;
  }
  .echart2 {
    margin-top: -80px;
    position: relative;
  }
  .alltitle2 {
    font-size: 26px;
    color: white;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
    text-align: center;
    // padding-left: 100px;
    padding-top: 30px;
  }
  .echart5 {
    margin-top: -20px;
    padding-left: 30px;
  }
  .echart4 {
    padding-left: 5px;
  }
  .alltitle4 {
    font-size: 26px;
    color: white;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
    text-align: center;
    padding-top: 15px;
  }
  .boxall4 {
    width: 25%;
    // border: 1px solid rgba(25,186,139,.17);
    padding: 0.2rem 0.4rem 0.15rem;
    // background: rgba(255,255,255,.04) url('../../assets/line2.jpg');
    background-size: 100% auto;
    position: relative;
    margin-bottom: 0.15rem;
    z-index: 10;
    margin-top: -1120px;
    margin-left: 1300px;
    float: left;
  }

  li {
    list-style-type: none;
  }
  .clearfix:after,
  .clearfix:before {
    display: table;
    content: ' ';
  }
  .clearfix:after {
    clear: both;
  }
  .pulll_left {
    float: left;
    font-size: 60px;
  }
  .pulll_right {
    float: right;
  }
  .bar {
    background: rgba(101, 132, 226, 0.1);
    // background: cadetblue;
    padding: 0.15rem;
  }
  .barbox li,
  .barbox2 li {
    width: 50%;
    text-align: center;
    position: relative;
    z-index: 100;
  }
  .barbox:before,
  .barbox:after {
    position: absolute;
    width: 0.3rem;
    height: 0.1rem;
    content: '';
  }
  .barbox:before {
    border-left: 2px solid #02a6b5;
    left: 0;
    border-top: 2px solid #02a6b5;
  }
  .barbox:after {
    border-right: 2px solid #02a6b5;
    right: 0;
    bottom: 0;
    border-bottom: 2px solid #02a6b5;
  }

  .barbox li:first-child:before {
    position: absolute;
    content: '';
    height: 50%;
    width: 1px;
    background: rgba(255, 255, 255, 0.2);
    right: 0;
    top: 25%;
  }

  .barbox {
    border: 1px solid rgba(25, 186, 139, 0.17);
    position: relative;
  }
  .barbox li {
    font-size: 40px;
    color: #ffeb7b;
    padding: 0.05rem 0;
    font-family: electronicFont;
    font-weight: bold;
  }
  .barbox2 li {
    font-size: 20px;
    color: rgba(255, 255, 255, 0.7);
    padding-top: 0.1rem;
  }

  // .foot:before{position: absolute;
  //   bottom: 0px;
  //   right: 0px;
  //   width: 10px;
  //   height: 10px;
  //   border-right: 2px solid #02a6b5;
  //   border-bottom: 2px solid #02a6b5;
  //   content: ""; }
  // .foot:after{position: absolute;
  //   bottom: 0px;
  //   left: 0px;
  //   width: 10px;
  //   height: 10px;
  //   border-left: 2px solid #02a6b5;
  //   border-bottom: 2px solid #02a6b5;
  //   content: ""; }

  .boxall3 {
    width: 100%;
    margin-top: 170px;
    float: left;
  }
  .boxtitle {
    height: 600px;
    width: 580px;
    margin-top: -950px;
    margin-left: 590px;
    // background:rgba(255,255,255,.04) url('../../assets/line3.jpg');
    float: left;
  }
  .boxall2 {
    width: 31%;
    // border: 1px solid rgba(25,186,139,.17);
    padding: 0.2rem 0.4rem 0.15rem;

    // background: rgba(255,255,255,.04) url('../../assets/nline1.png');
    background-size: 100% auto;
    position: relative;
    margin-bottom: 0.15rem;
    z-index: 10;
    margin-top: 10px;
    margin-left: 5px;
    margin-top: 20px;
    // padding-bottom: -10px;
    // float: left;
  }

  .boxall {
    width: 31%;
    // border: 1px solid rgba(25,186,139,.17);
    padding: 0.2rem 0.4rem 0.15rem;
    // background: rgba(255,255,255,.04) url('../../assets/nline1.png');
    background-size: 100% auto;
    position: relative;
    margin-bottom: 0.15rem;
    z-index: 10;
    margin-top: 20px;
    margin-left: 5px;
  }
  .echart2 {
    padding-top: 100px;
    margin-left: 10px;
    // height: 10%;
  }
  .alltitle {
    width: 80px;
    height: 1px;
    // text-align: center;
    padding-left: 100px;
    padding-top: 20px;
    font-size: 26px;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
  }
  .echart3 {
    margin-left: 500px;
    margin-top: -980px;
  }
  .title {
    margin-left: 700px;
    font-size: 60px;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
    // margin-top: -1050px;
  }

  //   .boxtitle {
  //     border: 8px inset #2CD5FF;
  //     // padding-top: 10%;
  // }
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
    width: 480px;
  }
</style>
