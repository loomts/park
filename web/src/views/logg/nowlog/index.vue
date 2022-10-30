<template>
  <div id="whole" style="font-family: 'SourceHanSans-Normal';">
    <!-- 人流预警 -->
    <template>
      <el-tabs v-model="activeName" @tab-click="handleClick" style="margin-left:20px;margin-top: -20px;">
        <el-tab-pane label="异常管理" name="first">
<!--          <el-tag type="danger" effect="light" class="disinfect2">
            <span>园 区 异 常</span>
          </el-tag> -->
          <!-- </div> -->
          <center style="margin-top: 20px; margin-bottom: 100px;">
            <el-container class="cot" style="width: 95%;">
              <el-main>
                <el-table
                  :data="tableData_1"
          stripe
                  :header-cell-style="{
                    color:'#ffc000',
          background: '#FAFAFA',
          fontFamily: 'AlimamaShuHeiTi-Bold',
          borderBottom: '2px solid rgba(192,80,77,0.5)'
                  }"
                >
                  <el-table-column
                    prop="priority"
                    label="处理优先级"
                    width="100"
          :filter-method="filterTag"
          align="center"
                  >
          <div slot-scope="scope">
                          <el-tag
                            :type="scope.row.priority == 'P1' ? 'danger' : 'primary'"
                            disable-transitions
                          >
                            {{ scope.row.priority }}
                          </el-tag>
                        </div>
          </el-table-column>

                  <el-table-column
                    prop="date"
                    label="日期"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="time"
                    label="时间"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="place"
                    label="发生地点"
                    width="180"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="way"
                    label="事件类型"
                    width="180"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="reason"
                    label="异常原因"
                    width="180"
          align="center"
                  >
          <div slot-scope="scope">
                <el-tag
                  :type="scope.row.reason == '人群过密' ? 'danger' : 'primary'"
                  disable-transitions
                >
                  {{ scope.row.reason }}
                </el-tag>
              </div>
          </el-table-column>
                </el-table>
              </el-main>
            </el-container>
          </center>
        </el-tab-pane>

        <el-tab-pane label="消毒信息" name="second">
          <!-- 到点消毒 -->
          <!-- <el-tag type="" effect="light" class="disinfect">
            <span>消 毒 信 息</span>
          </el-tag> -->
          <center style="margin-top: 20px; margin-bottom: 100px;">
            <el-container class="cot" style="width: 95%">
              <el-main>
                <el-table
                  :data="tableData_2"
                  stripe
                  :header-cell-style="{
                    background: '#FAFAFA',
                    fontFamily: 'AlimamaShuHeiTi-Bold',
          borderBottom: '2px solid rgba(255,192,0,0.5)'
                  }"
                >
                  <el-table-column
                    prop="date"
                    label="日期"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="time"
                    label="时间"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="place"
                    label="消毒地点"
                    width="180"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="way"
                    label="消毒方式"
                    width="180"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="people"
                    label="操作人员"
                    width="180"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="result"
                    label="操作结果"
                    width="100"
          align="center"
                  >
          <div slot-scope="scope">
                <el-tag
                  :type="scope.row.result == '尚未完成！' ? 'danger' : 'primary'"
                  disable-transitions
                >
                  {{ scope.row.result }}
                </el-tag>
              </div>
          
          </el-table-column>
                </el-table>
              </el-main>
            </el-container>
          </center>
        </el-tab-pane>

        <el-tab-pane label="人流预警" name="third">
<!--          <el-tag type="info" effect="light" class="disinfect">
            <span>人 流 预 警</span>
          </el-tag> -->
          <center style="margin-top: 20px; margin-bottom: 100px">
            <el-container class="cot" style="width: 95%">
              <el-main>
                <el-table
                  :data="tableData_3"
                  stripe
                  :header-cell-style="{
                    background: '#FAFAFA',
                    borderBottom: '2px solid rgba(68,114,196,0.5)',
          fontFamily: 'AlimamaShuHeiTi-Bold',
                  }"
                  style="font-size: 30px"
                >
                  <el-table-column
                    prop="priority"
                    label="处理优先级"
                    width="180"
          align="center"
                  >
          <div slot-scope="scope">
                <el-tag
                  :type="scope.row.priority == 'P1' ? 'danger' : 'primary'"
                  disable-transitions
                >
                  {{ scope.row.priority }}
                </el-tag>
              </div>
          </el-table-column>

                  <el-table-column
                    prop="date"
                    label="日期"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="time"
                    label="时间"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="place"
                    label="地点"
          align="center"
                    width="180"
                  ></el-table-column>

                  <el-table-column
                    prop="number"
                    label="瞬时设备接入数"
          align="center"
                    width="180"
                  ></el-table-column>

                  <el-table-column
                    prop="reason"
                    label="预警原因"
          align="center"
                    width="180"
                  ></el-table-column>
                </el-table>
              </el-main>
            </el-container>
          </center>
        </el-tab-pane>

        <el-tab-pane label="AP故障" name="fourth">
<!--          <el-tag type="warning" effect="light" class="disinfect1">
            <span>A P 故 障</span>
          </el-tag> -->
          <center style="margin-top: 20px; margin-bottom: 100px">
            <el-container class="cot" style="width: 95%">
              <el-main>
                <el-table
                  :data="tableData_4"
                  stripe
                  :header-cell-style="{
                    background: '#FAFAFA',
                    borderBottom: '2px solid rgba(112,173,71,0.5)',
          fontFamily: 'AlimamaShuHeiTi-Bold',
                  }"
                  style="font-size: 30px"
                >
                  <el-table-column
                    prop="priority"
                    label="处理优先级"
          align="center"
                    width="180"
                  >
          <div slot-scope="scope">
                <el-tag
                  :type="scope.row.priority == 'P1' ? 'danger' : 'primary'"
                  disable-transitions
                >
                  {{ scope.row.priority }}
                </el-tag>
              </div>
          </el-table-column>

                  <el-table-column
                    prop="date"
                    label="日期"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="time"
                    label="时间"
                    width="150"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="way"
                    label="地点"
                    width="200"
          align="center"
                  ></el-table-column>

                  <el-table-column
                    prop="type"
                    label="问题类型"
                    width="180"
          align="center"
                  >
          <div slot-scope="scope">
                <el-tag
                  :type="scope.row.type == '设备故障' ? 'danger' : 'secondary'"
                  disable-transitions
                >
                  {{ scope.row.type }}
                </el-tag>
              </div>
          </el-table-column>

                  <el-table-column
                    prop="reason"
                    label="具体情况"
                    width="180"
          align="center"
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
          place: '奇想花园',
          number: 'User327',
          reason: '接入耗时过久',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '14:42',
          place: '奇想花园',
          number: 'User109',
          reason: '接入耗时过久',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '13:32',
          reason: '漫游达标率过低',
          number: 'User531',
          place: '明日世界',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '10:51',
          reason: 'AP上传速率出现异常',
          number: 'User017',
          place: '探险岛',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '10:05',
          reason: '接入耗时过久',
          number: 'User629',
          place: '奇想花园',
        },
      ]
      const item_4 = [
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '17:45',
          way: '探险岛',
          type: '距离不当',
          reason: '疑似盗窃',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '16:45',
          way: '探险岛',
          type: '距离不当',
          reason: '疑似盗窃',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '13:22',
          way: '明日世界',
          type: '设备故障',
          reason: '极速光轮操纵按键失灵',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '12:41',
          way: '梦幻世界',
          type: '设备故障',
          reason: '晶彩奇航受雨暂停营业',
        },
        {
          priority: 'P2',
          date: '2022-07-02',
          time: '10:45',
          way: 'P3停车场',
          type: '设备故障',
          reason: '升降杆损坏',
        },
        {
          priority: 'P1',
          date: '2022-07-02',
          time: '10:25',
          way: '奇想花园',
          type: '游客纠纷',
          reason: '游客出现争吵',
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
  .disinfect {
    margin-left: 80px;
    margin-top: 50px;
    margin-bottom: 20px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    font-weight: 500;
    padding: 1% 2% 2.5%;
    font-size: 22px;
    border-radius: 20px;
  }
  .disinfect1 {
    margin-left: 80px;
    margin-top: 50px;
    margin-bottom: 20px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    font-weight: 500;
    padding: 1% 2% 2.5%;
    font-size: 22px;
    border-radius: 20px;
  }
  .disinfect2 {
    margin-left: 80px;
    margin-top: 50px;
    margin-bottom: 20px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    transition: all 0.15s ease;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    font-weight: 500;
    padding: 1% 2% 2.5%;
    font-size: 22px;
    border-radius: 20px;
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

<style scopted>
  /* 字体：阿里妈妈*/
  @font-face {
      font-family: AlimamaShuHeiTi-Bold;
      src: url('./AlimamaShuHeiTi-Bold.otf');
    }
  
  /* 字体:思源黑体 */
  @font-face {
      font-family: SourceHanSans-Normal;
      src: url('./SourceHanSans-Normal.otf');
    }
</style>



