<template>
  <div id="whole">
    <!-- 人流预警 -->
  <template>
    <el-tabs v-model="activeName" @tab-click="handleClick">

          <el-tab-pane label="异常管理" name="first">
          <div class="disinfect2" style="margin-left: 130px; margin-top: 50px;margin-bottom: 20px;">
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>园 区 异 常</span>
          </div>
        <center style="margin-top: 20px; margin-bottom: 100px">
          <el-container class="cot"  style="width:1000px">
            <el-main>
              <el-table
                :data="tableData_2"
                :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }"
              >
              <el-table-column
                  prop="people"
                  label="处理优先级"
                  width="100"
                 
                ></el-table-column>

                <el-table-column
                  prop="date"
                  label="日期"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="time"
                  label="时间"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="place"
                  label="发生地点"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="way"
                  label="事件类型"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="people"
                  label="异常原因"
                  width="180"
                ></el-table-column>

              </el-table>
            </el-main>
          </el-container>
        </center>
      </el-tab-pane>

      <el-tab-pane label="消毒信息" name="second">  <!-- 到点消毒 -->
          <div class="disinfect" style="margin-left: 130px; margin-top: 50px;margin-bottom: 20px;">
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>消 毒 信 息</span>
          </div>
        <center style="margin-top: 20px; margin-bottom: 100px">
          <el-container class="cot"  style="width:1000px">
            <el-main>
              <el-table
                :data="tableData_2"
                :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }"
              >
                <el-table-column
                  prop="date"
                  label="日期"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="time"
                  label="时间"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="place"
                  label="消毒地点"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="way"
                  label="消毒方式"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="people"
                  label="操作人员"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="result"
                  label="操作结果"
                  width="100"
                ></el-table-column>
              </el-table>
            </el-main>
          </el-container>
        </center>
      </el-tab-pane>
      
      <el-tab-pane label="人流预警" name="third">
    
        <div class="warning" style="margin-left: 130px; margin-top: 50px;margin-bottom: 20px;">
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>人 流 预 警</span>
          </div>
        <center style="margin-top: 20px; margin-bottom: 100px">
          <el-container class="cot" style="width:1100px">
            <el-main>
              <el-table
                :data="tableData_2"
                :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }"
              >
               <el-table-column
                  prop="people"
                  label="处理优先级"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="date"
                  label="日期"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="time"
                  label="时间"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="place"
                  label="地点"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="way"
                  label="瞬时设备接入数"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="people"
                  label="预警原因"
                  width="180"
                ></el-table-column>

              
              </el-table>
            </el-main>
          </el-container>
        </center>

      </el-tab-pane>


      <el-tab-pane label="AP故障" name="fourth">
            <div class="disinfect1" style="margin-left: 130px; margin-top: 50px;margin-bottom: 20px;">
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>A P 故 障</span>
          </div>
        <center style="margin-top: 20px; margin-bottom: 100px">
          <el-container class="cot"  style="width:1100px">
            <el-main>
              <el-table
                :data="tableData_2"
                :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }"
              >
              <el-table-column
                  prop="people"
                  label="处理优先级"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="date"
                  label="日期"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="time"
                  label="时间"
                  width="150"
                ></el-table-column>

                <el-table-column
                  prop="place"
                  label="问题类型"
                  width="200"
                ></el-table-column>

                <el-table-column
                  prop="way"
                  label="设备ID"
                  width="180"
                ></el-table-column>

                <el-table-column
                  prop="people"
                  label="站点区域"
                  width="180"
                ></el-table-column>


               
              </el-table>
            </el-main>
          </el-container>
        </center>
      </el-tab-pane>


    </el-tabs>
</template>

    

  
  </div>
</template>

<script>
  export default {
    data() {
      const item_1 = {
        date: '2022-07-02',
        time: '06:22',
        address: '探险岛',
        count: '2514',
        state: '人流适中',
      }
      const item_2 = {
        date: '2022-07-02',
        time: '06:22',
        place: '探险岛',
        way: '喷洒',
        people: '张三、李四',
        result: '已消毒',
      }

      return {
        tableData_1: Array(8).fill(item_1),
        tableData_2: Array(8).fill(item_2),
         activeName: 'first'
      }
    },
  }
   
</script>

<style>
  #whole {
    font-family: 'Georgia', 'Lucida Sans', '微软雅黑', 'sans-serif',
      'Lucida Grande', 'Lucida Sans';
    margin-top: 30px;
  }
  .warning {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #f3b2b2;
    color: rgb(0, 0, 0) ed;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    margin: 0;
    font-weight: 500;
    /* -moz-user-select: none; */
    /*    -webkit-user-select: none; */
    /* -ms-user-select: none; */
    padding: 12px 30px;
    font-size: 16px;
    border-radius: 50px;
  }
  .disinfect {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #dcedc1;
    color: #000000;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    margin: 0;
    font-weight: 500;
    /* -moz-user-select: none; */
    /* -webkit-user-select: none; */
    /* -ms-user-select: none; */
    padding: 12px 30px;
    font-size: 16px;
    border-radius: 50px;
  }
  .disinfect1 {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #c1e0ed;
    color: #000000;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    margin: 0;
    font-weight: 500;
    /* -moz-user-select: none; */
    /* -webkit-user-select: none; */
    /* -ms-user-select: none; */
    padding: 12px 30px;
    font-size: 16px;
    border-radius: 50px;
  }
  .disinfect2 {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #c186ee;
    color: #000000;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    margin: 0;
    font-weight: 500;
    /* -moz-user-select: none; */
    /* -webkit-user-select: none; */
    /* -ms-user-select: none; */
    padding: 12px 30px;
    font-size: 16px;
    border-radius: 50px;
  }
  .open {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #e6a23c;
    color: #ededed;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    margin: 0;
    font-weight: 500;
    /* -moz-user-select: none; */
    /* -webkit-user-select: none; */
    /* -ms-user-select: none; */
    padding: 12px 30px;
    font-size: 16px;
    border-radius: 50px;
  }
  .el-header {
    background-color: #b3c0d1;
    line-height: 60px;
  }
  .cot {
    border-radius: 10px 10px 10px 10px;
    border-top: 1px solid #dedede;
    border-left: 1px solid #dedede;
    border-bottom: 1px solid #dedede;
    width: 90%;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    border: 1px solid #eee;
  }
</style>
