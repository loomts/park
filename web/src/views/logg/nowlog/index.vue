<template>
  <div id="whole">
    <!-- 人流预警 -->
    <template>
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="异常管理" name="first">
          <div
            class="disinfect2"
            style="margin-left: 130px; margin-top: 50px; margin-bottom: 20px"
          >
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>园 区 异 常</span>
          </div>
          <center style="margin-top: 20px; margin-bottom: 100px">
            <el-container class="cot" style="width: 1000px">
              <el-main>
                <el-table
                  :data="tableData_1"
                  :header-cell-style="{
                    background: '#DCD6F7',
                    color: '#ffffff',
                  }"
                >
                  <el-table-column
                    prop="priority"
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
                    prop="reason"
                    label="异常原因"
                    width="180"
                  ></el-table-column>
                </el-table>
              </el-main>
            </el-container>
          </center>
        </el-tab-pane>

        <el-tab-pane label="消毒信息" name="second">
          <!-- 到点消毒 -->
          <div
            class="disinfect"
            style="margin-left: 130px; margin-top: 50px; margin-bottom: 20px"
          >
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>消 毒 信 息</span>
          </div>
          <center style="margin-top: 20px; margin-bottom: 100px">
            <el-container class="cot" style="width: 1000px">
              <el-main>
                <el-table
                  :data="tableData_2"
                  :header-cell-style="{
                    background: '#DCD6F7',
                    color: '#ffffff',
                  }"
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
          <div
            class="warning"
            style="margin-left: 130px; margin-top: 50px; margin-bottom: 20px"
          >
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>人 流 预 警</span>
          </div>
          <center style="margin-top: 20px; margin-bottom: 100px">
            <el-container class="cot" style="width: 1100px">
              <el-main>
                <el-table
                  :data="tableData_3"
                  :header-cell-style="{
                    background: '#DCD6F7',
                    color: '#ffffff',
                  }"
                >
                  <el-table-column
                    prop="priority"
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
                    prop="number"
                    label="瞬时设备接入数"
                    width="180"
                  ></el-table-column>

                  <el-table-column
                    prop="reason"
                    label="预警原因"
                    width="180"
                  ></el-table-column>
                </el-table>
              </el-main>
            </el-container>
          </center>
        </el-tab-pane>

        <el-tab-pane label="AP故障" name="fourth">
          <div
            class="disinfect1"
            style="margin-left: 130px; margin-top: 50px; margin-bottom: 20px"
          >
            <!-- <vab-colorful-icon icon-class="expired" /> -->
            <span>A P 故 障</span>
          </div>
          <center style="margin-top: 20px; margin-bottom: 100px">
            <el-container class="cot" style="width: 1100px">
              <el-main>
                <el-table
                  :data="tableData_4"
                  :header-cell-style="{
                    background: '#DCD6F7',
                    color: '#ffffff',
                  }"
                >
                  <el-table-column
                    prop="priority"
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
                    prop="way"
                    label="问题类型"
                    width="200"
                  ></el-table-column>

                  <el-table-column
                    prop="id"
                    label="设备ID"
                    width="180"
                  ></el-table-column>

                  <el-table-column
                    prop="area"
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
      const item_1 = [
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '06:22',
          place: '探险岛',
          way: '3281',
          reason: '人群过密',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '09:22',
          place: '明日世界',
          way: '6341',
          reason: '人群过密',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '09:25',
          place: '梦幻世界',
          way: '1201',
          reason: '小范围聚集',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '12:22',
          place: '梦幻世界',
          way: '5287',
          reason: '人群过密',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '19:22',
          place: '奇想花园',
          way: '6701',
          reason: '小范围聚集',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '06:22',
          place: '探险岛',
          way: '3281',
          reason: '人群过密',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '09:22',
          place: '明日世界',
          way: '6341',
          reason: '人群过密',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '09:25',
          place: '梦幻世界',
          way: '1201',
          reason: '小范围聚集',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '12:22',
          place: '梦幻世界',
          way: '5287',
          reason: '人群过密',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '19:22',
          place: '奇想花园',
          way: '6701',
          reason: '小范围聚集',
        },
      ]
      const item_2 = [
        {
          date: '2022-07-02',
          time: '...',
          place: '探险岛',
          way: '...',
          people: '...',
          result: '尚未完成！',
        },
        {
          date: '2022-07-02',
          time: '17:45',
          place: '明日世界',
          way: '喷洒',
          people: '小张',
          result: '消毒完成',
        },
        {
          date: '2022-07-02',
          time: '17:42',
          place: '奇想花园',
          way: '喷洒',
          people: '小黄',
          result: '消毒完成',
        },
        {
          date: '2022-07-02',
          time: '17:37',
          place: '梦幻世界',
          way: '喷洒',
          people: '小甘',
          result: '消毒完成',
        },
        {
          date: '2022-07-02',
          time: '17:30',
          place: '皮克斯玩具总动员',
          way: '喷洒',
          people: '小郑',
          result: '消毒完成',
        },
        {
          date: '2022-07-02',
          time: '17:30',
          place: '宝藏湾',
          way: '喷洒',
          people: '小陆',
          result: '消毒完成',
        },
      ]
      const item_3 = [
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '16:45',
          place: '接入耗时过久',
          number: 'User327',
          reason: '奇想花园',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '14:42',
          place: '接入耗时过久',
          number: 'User109',
          reason: '奇想花园',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '13:32',
          place: '漫游达标率过低',
          number: 'User531',
          reason: '明日世界',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '10:51',
          place: 'AP上传速率出现异常',
          number: 'User017',
          reason: '探险岛',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '10:05',
          place: '接入耗时过久',
          number: 'User629',
          reason: '奇想花园',
        },
      ]
      const item_4 = [
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '17:45',
          way: '探险岛',
          id: '距离不当',
          area: '疑似盗窃',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '16:45',
          way: '探险岛',
          id: '距离不当',
          area: '疑似盗窃',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '13:22',
          way: '明日世界',
          id: '设备故障',
          area: '极速光轮操纵按键失灵',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '12:41',
          way: '梦幻世界',
          id: '设备故障',
          area: '晶彩奇航受雨暂停营业',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '10:45',
          way: 'P3停车场',
          id: '设备故障',
          area: '升降杆损坏',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '10:25',
          way: '奇想花园',
          id: '游客纠纷',
          area: '游客出现争吵',
        },
      ]

      return {
        tableData_1: item_1,
        tableData_2: item_2,
        tableData_3: item_3,
        tableData_4: item_4,
        activeName: 'first',
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
