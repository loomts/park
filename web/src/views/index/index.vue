<template>
  <div class="index-container">
     <!-- <div class="canvas" style="opacity: .2"> -->
        <!-- <iframe frameborder="0" src="js/index.html" style="width: 100%; height: 100%"></iframe> -->
         <!-- frameborder属性：不设置边框，如果是vue2.x版本，那么可以使用src属性  -->
<!-- <iframe style="width: 100%; height: 100%;" id="tempHtml" ref="tempHtml" frameborder="0"></iframe> -->

    <!-- </div> -->
    <!-- 在img标签中可以直接使用backgroundImgUrl变量作为图片路径 -->
    <!-- <img :src="backgroundImgUrl" class="indeximg" /> -->
    <!-- 在style中要把backgroundImgUrl变量拼接到url()中，才能正常引入图片 -->
    <!-- <div :style="{ backgroundImage: `url{{backgroundImgUrl}}` }"></div> -->
    <div class="title">园区总览</div>

    <div class="boxall" style="height:465px">
        <div class="alltitle1">游客数量</div>
        <echarts4Vue class="echart1"></echarts4Vue>
    </div>

    <!-- <div></div> -->
    <div class="boxall" style="height:465px">
        <div class="alltitle2">停车场使用情况</div>
        <echarts2Vue class="echart2"></echarts2Vue>
    </div>

      <div class="boxtitle">
        <!-- <span class="shouru1">2022年总收入情况</span><br/><span class="shouru2">147766320</span> -->
          <div class="bar">
                    <div class="barbox">
                        <ul class="clearfix">
                            <li class="pulll_left counter">12581189</li>
                            <li class="pulll_left counter">3912410</li>
                        </ul>
                    </div>
                    <div class="barbox2">
                        <ul class="clearfix">
                            <li class="pulll_left">2022年总收入情况 </li>
                            <li class="pulll_left">2022年总支出情况</li>
                        </ul>
                    </div>
                </div>
      </div>

    <div class="boxall3" style="height:700px, width: 700px;">
        
        <echarts3Vue class="echart3"></echarts3Vue>
      </div>

  
    <div class="boxall4" style="height:380px;">
        <div class="alltitle4">收益情况</div>
        <echarts1Vue class="echart4"></echarts1Vue>
      </div>

    <div class="boxall5" style="height:380px;">
        <div class="alltitle5">流量使用情况</div>
        <echarts5Vue class="echart5"></echarts5Vue>
      </div>
  </div>

  
</template>

<script>
  // 在vue组件中定义此变量，组件创建成功后该变量值为'/static/img/login-bg.df6a3174.png'
  // import VabChart from '@/plugins/echarts'
  // import { dependencies, devDependencies } from '../../../package.json
  // import Plan from './components/Plan'
  // import VersionInformation from './components/VersionInformation'
     import echarts1Vue from './components/echarts1.vue';
     import echarts2Vue from './components/echarts2.vue';
     import echarts3Vue from './components/echarts3.vue';
     import echarts4Vue from './components/echarts4.vue';
     import echarts5Vue from './components/echarts5.vue';
  export default {
    name: 'Index',
    components: {
      // VabChart,
      echarts1Vue,
      echarts2Vue,
      echarts3Vue,
      echarts4Vue,
      echarts5Vue
    },
    data() {
      return {
        
      }
    },
    created() {
      //  document.getElementById('tempHtml').contentDocument.documentElement.innerHTML = this.ifeData
    },
    beforeDestroy() {},
    mounted() {},
    methods: {},
  }
</script>

<style lang="scss" scoped>
.boxall5 {
  width:25%;
    // border: 1px solid rgba(25,186,139,.17); 
    padding:0.2rem .4rem .15rem;  
    background: rgba(255,255,255,.04) url('../../assets/line2.jpg');
    background-size: 100% auto; 
    position: relative;
     margin-bottom: .15rem; 
    z-index: 10;
    margin-top: -650px;
    margin-left: 1180px;
    float: left;
}
.alltitle5 {
  font-size: 26px;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';  
      text-align: center;
    padding-top: 15px;
}
.alltitle1 {
  font-size: 26px;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';  
      text-align: center;
    // padding-left: 100px;
    padding-top: 15px;
}
.echart2 {
  margin-top: -80px;
}
.alltitle2 {
  font-size: 26px;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';  
      text-align: center;
    // padding-left: 100px;
    padding-top: 30px;
}
.echart5 {
  
  padding-left: 12px;
}
  .echart4 {
    padding-left: 5px; 
  }
  .alltitle4 {
    font-size: 26px;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';  
      text-align: center;
    padding-top: 15px;
  }
  .boxall4 {
      width:25%;
    // border: 1px solid rgba(25,186,139,.17); 
    padding:0.2rem .4rem .15rem;  
    background: rgba(255,255,255,.04) url('../../assets/line2.jpg');
    background-size: 100% auto; 
    position: relative;
     margin-bottom: .15rem; 
    z-index: 10;
    margin-top: -1120px;
    margin-left: 1180px;
    float: left;
  
  }

  li{ list-style-type:none;}
  .clearfix:after, .clearfix:before {
	display: table;
	content: " "
}
 .clearfix:after {
	clear: both
}
.pulll_left{float:left; font-size: 60px;}
.pulll_right{float:right;}
.bar{
  // background:rgba(101,132,226,.1);
  background: cadetblue; 
padding: .15rem;}
.barbox li,.barbox2 li{ width:50%; text-align: center; position: relative; z-index: 100;}
.barbox:before,
.barbox:after{ position:absolute; width: .3rem; height: .1rem; content: ""; }
.barbox:before{border-left: 2px solid #02a6b5;left: 0;border-top: 2px solid #02a6b5; }
.barbox:after{border-right: 2px solid #02a6b5; right: 0; bottom: 0;border-bottom: 2px solid #02a6b5; }

.barbox li:first-child:before{ position:absolute; content: ""; height:50%; width: 1px; 
background: rgba(255,255,255,.2); 
right: 0; top: 25%;}

.barbox{  border: 1px solid rgba(25,186,139,.17); position: relative;}
.barbox li{ font-size: 40px; color: #ffeb7b; padding: .05rem 0;  font-family:electronicFont; font-weight: bold;}
.barbox2 li{ font-size: 20px; color:rgba(255,255,255,.7); padding-top: .1rem;}


  .boxall3 {
    width:100%;
    margin-top: 170px; 
    float: left;
  }
  .boxtitle{
    height: 600px;
    width: 580px;
    margin-top: -850px;
    margin-left: 560px;
    // background:rgba(255,255,255,.04) url('../../assets/line3.jpg');
    float: left;
  }


  .boxall {
    width:31%;
    // border: 1px solid rgba(25,186,139,.17); 
    padding:0.2rem .4rem .15rem;  
    background: rgba(255,255,255,.04) url('../../assets/line2.jpg');
    background-size: 100% auto; 
    position: relative;
     margin-bottom: .15rem; 
    z-index: 10;
    margin-top: 10px;
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
    padding-left:100px;
    padding-top:20px;
    font-size: 26px;
    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB',
      'Microsoft YaHei', '微软雅黑';
  }
  .echart3 {
    margin-left: 500px;
    margin-top: -780px;
  }
  .title{
    margin-left: 700px;
    font-size: 60px;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    // margin-top: -1050px;
  }

  //   .boxtitle {
  //     border: 8px inset #2CD5FF;
  //     // padding-top: 10%;
  // }
  // .shouru1 {
  //   text-align: center;
  //   font-size: 20px;
  //   font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  // }
  // .shouru2 {
  //   padding-left: 50px;
  //   padding-top: 100px;
  //   text-align: center;
  //   color: blue;
  //   font-size: 30px;
  //   font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  // }
  // span {
  //   padding-top: 100px;
  // }
</style>
