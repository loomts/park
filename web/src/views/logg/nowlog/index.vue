<template>
  <div id="whole">
    <!-- 人流预警 -->
    <div class="warning" style="margin-left: 60px">
      <span>人 流 预 警</span>
    </div>
    <center style="margin-top: 20px">
      <el-container class="cot">
        <el-main>
          <el-table
            :data="tableData_1"
            :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }"
          >
            <el-table-column
              prop="date"
              label="日期"
              width="160"
            ></el-table-column>

            <el-table-column
              prop="time"
              label="时间"
              width="160"
            ></el-table-column>

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

            <el-table-column
              prop="state"
              label="当前状态"
              width="200"
            ></el-table-column>

            <!-- <el-table-column 
			  prop="check" 
			  label="具体详情" 
			  width="50">
              <template slot-scope="scope">
                <a :href="scope.row.url" target="_blank">{{ scope.row.url }}</a>
              </template>
            </el-table-column> -->
          </el-table>
        </el-main>
      </el-container>
    </center>

    <!-- 到点消毒 -->
    <div class="disinfect" style="margin-left: 60px; margin-top: 50px">
      <!-- <vab-colorful-icon icon-class="expired" /> -->
      <span>消 毒 信 息</span>
    </div>
    <center style="margin-top: 20px; margin-bottom: 100px">
      <el-container class="cot">
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
