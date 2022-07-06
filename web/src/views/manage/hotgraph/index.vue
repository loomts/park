<!-- 热力图 -->
<template>
  <div class="maps">
      <div class="hotPic" id="heatmap">
        <img :src="backgroundImgUrl"/>
      </div>
    </div>
</template>
 
<script>
const Heatmap = window.h337
export default {
  // import * as Heatmap from '@/views/manage/hotgraph/heatmap.js'
  data() {
    return {
      backgroundImgUrl: require('@/assets/disney.png'),
      points: [],       // 热力图数据存放数组
      cavWidth: null,    //获取宽度
      cavHeight: null,    //获取高度
    }
  },
  components: {},
 created(){
    this.initValue()
  },
  mounted(){
    this.getRectValue()
    this.initHotPic()
    this.progressDom = document.getElementsByClassName('progress_list')
    var _this = this
    window.onresize = () => {
      return (() => {
        _this.cavWidth = document.getElementById("heatmap").clientWidth;
        _this.cavHeight = document.getElementById("heatmap").clientHeight;
      })()
    }
  },
  watch:{
    cavWidth:{
      handler(curVal, oldVal) {
        var _this = this;
        _this.cavWidth = curVal;
        if (oldVal != 0 && oldVal!=null) {
          for (var i = 0; i < this.points.length; i++) {
            this.points[i].x = Number((this.points[i].x * curVal / oldVal).toFixed(0));
          }
          _this.initHotPic();
        }
        // console.log("宽=" + curVal, oldVal);
      },
    },
    cavHeight:{
      handler(curVal, oldVal) {
        var _this = this;
        _this.cavHeight = curVal;
        if (oldVal != 0 && oldVal!=null) {
          for (var i = 0; i < this.points.length; i++) {
            this.points[i].y = Number((this.points[i].y * curVal / oldVal).toFixed(0));
            console.log(this.points[i].y)
          }
          _this.initHotPic();
        }
        // console.log("高=" + curVal, oldVal);
      },
    }
  },
  computed: {},
  methods:{
    // 删除之前的热力图
    deleteHotMap(){
      var heatmapBox = document.getElementById("heatmap");
      if(heatmapBox.children.length>1){
        var oldCanvas = heatmapBox.children[1];
        heatmapBox.removeChild(oldCanvas);
      }
    },
    // 初始化热力图
    initHotPic(){
      this.deleteHotMap()
      let self = this
      var heatmapInstance = Heatmap.create({
        container: document.getElementById('heatmap'),
        gradient: {//渐变颜色
          "0": "rgba(255,255,255,1)",//value为0的颜色
          "0.3": "#82ff6d",//value为500的颜色
          "0.8": "#f3ff6d",//value为1000的颜色
          "1": "#ff6d6d",//value为2000的颜色
        },
        // radius: 10,
        maxOpacity: 1,
        minOpacity: 0,
        blur: .75,
        radius:80, //半径
        // opacity:0.5, //透明
        // maxOpacity, //热图中最大值具有的最大不透明度
        // minOpacity, //热图中最小值的最小不透明度
        // onExtremaChange, //传递回调以接收极值更改更新
        // blur, //将应用于所有数据点的模糊因子。模糊因子越高，渐变将越平滑
        // xField, //数据点中x坐标的属性名称
        // yField, //数据点中y坐标的属性名称
        // valueField //数据点中y坐标的属性名称
      })

      var max = 0

      // var width = 600

      // var height = 400
      var data = {
        max: 100,     //数据对比(max和min进行数据对比，从而展示热力颜色)
        min:0,
        data: self.points

      }
      heatmapInstance.setData(data)
    },
    // 初始化获取宽高(考虑到后期的适配，获取父级元素的宽高)
    getRectValue(){
      this.cavWidth = document.getElementById("heatmap").clientWidth;
      this.cavHeight = document.getElementById("heatmap").clientHeight;
      console.log(this.cavWidth,this.cavHeight)
    },
    // 初始化获取数据（模拟的展示数据）
    initValue(){
      var len = 20
      while (len--) {
        // max = Math.max(max, val)
        var point = {
          x: 500,
          y: 300,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 500,
          y: 350,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 200,
          y: 500,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 150,
          y: 500,
          value: 4
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 150,
          y: 550,
          value: 10
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 180,
          y: 590,
          value: 4
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 180,
          y: 500,
          value: 4
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 700,
          y: 550,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 450,
          y: 950,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
   
        // max = Math.max(max, val)
        var point = {
          x: 450,
          y: 1000,
          value: 4
        }
        this.points.push(point)
      }

      len = 20;
      while (len--) {
        var point = {
          x: 850,
          y: 800,
          value: 100
        }
        this.points.push(point)
      }

      len = 20;
      while (len--) {
        var point = {
          x: 800,
          y: 800,
          value: 100
        }
        this.points.push(point)
      }

      len = 20;
      while (len--) {
        var point = {
          x: 800,
          y: 700,
          value: 100
        }
        this.points.push(point)
      }

      len = 20;
      while (len--) {
        var point = {
          x: 1000,
          y: 700,
          value: 4
        }
        this.points.push(point)
      }

       len = 20;
      while (len--) {
        var point = {
          x: 1050,
          y: 550,
          value: 4
        }
        this.points.push(point)
      }

      len = 20;
      while (len--) {
        var point = {
          x: 1250,
          y: 150,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
        var point = {
          x: 1460,
          y: 150,
          value: 4
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
        var point = {
          x: 1300,
          y: 150,
          value: 5
        }
        this.points.push(point)
      }
      
      len = 20;
      while (len--) {
        var point = {
          x: 1500,
          y: 560,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
        var point = {
          x: 1500,
          y: 600,
          value: 100
        }
        this.points.push(point)
      }
      len = 20;
      while (len--) {
        var point = {
          x: 1400,
          y: 600,
          value: 4
        }
        this.points.push(point)
      }
    },
    
}
};
</script>
 
<style scoped lang="scss">
</style>