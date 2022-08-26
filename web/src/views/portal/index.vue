<template>
  <div id="whole">
    <!-- 人流预警 -->
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="认证旅客" name="first">
        <div
          class="disinfect"
          style="margin-left: 130px; margin-top: 50px; margin-bottom: 20px"
        >
          <span>认 证 旅 客</span>
        </div>
        <center style="margin-top: 20px; margin-bottom: 100px">
          <el-container class="cot" style="width: 1000px">
            <el-main>
              <el-table
                :data="tableData_1"
                :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }"
              >
                <el-table-column
                  prop="id"
                  label="序号"
                  width="100"
                ></el-table-column>

                <el-table-column
                  prop="IPAddress"
                  label="IP地址"
                  width="210"
                ></el-table-column>

                <el-table-column
                  prop="userGroup"
                  label="用户组"
                  width="230"
                ></el-table-column>

                <el-table-column
                  prop="ifPortal"
                  label="是否认证"
                  width="200"
                ></el-table-column>

                <el-table-column
                  prop="visitTime"
                  label="访问时间"
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
      </el-tab-pane>
      <el-tab-pane label="未认证旅客" name="second">
        <div
          class="warning"
          style="margin-left: 130px; margin-top: 50px; margin-bottom: 20px"
        >
          <!-- <vab-colorful-icon icon-class="expired" /> -->
          <span>未 认 证 旅 客</span>
        </div>
        <center style="margin-top: 20px; margin-bottom: 100px">
          <el-container class="cot" style="width: 1000px">
            <el-main>
              <el-table
                :data="tableData_2"
                :header-cell-style="{ background: '#DCD6F7', color: '#ffffff' }"
              >
                <el-table-column
                  prop="id"
                  label="序号"
                  width="100"
                ></el-table-column>

                <el-table-column
                  prop="IPAddress"
                  label="IP地址"
                  width="210"
                ></el-table-column>

                <el-table-column
                  prop="userGroup"
                  label="用户组"
                  width="230"
                ></el-table-column>

                <el-table-column
                  prop="ifPortal"
                  label="是否认证"
                  width="200"
                ></el-table-column>

                <el-table-column
                  prop="visitTime"
                  label="访问时间"
                  width="200"
                ></el-table-column>
              </el-table>
            </el-main>
          </el-container>
        </center>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import * as allApi from '../../../api.js'
  export default {
    data() {
      const item_1 = [
        {
          id: '1',
          IPAddress: '192.168.2.105',
          userGroup: '无线组——华为手机',
          ifPortal: '已认证',
          visitTime: '2022-07-02 20:27:30',
        },
        {
          id: '2',
          IPAddress: '192.168.1.108',
          userGroup: 'R&D——BRUSE电脑',
          ifPortal: '已认证',
          visitTime: '2022-07-02 19:16:07',
        },
        {
          id: '3',
          IPAddress: '192.168.2.35',
          userGroup: '无线组——iPhone',
          ifPortal: '已认证',
          visitTime: '2022-07-02 19:03:52',
        },
        {
          id: '4',
          IPAddress: '192.168.3.141',
          userGroup: '无线组——华为手机',
          ifPortal: '已认证',
          visitTime: '2022-07-02 18:55:48',
        },
        {
          id: '5',
          IPAddress: '192.168.1.33',
          userGroup: '无线组——荣耀手机',
          ifPortal: '已认证',
          visitTime: '2022-07-02 18:47:03',
        },
        {
          id: '6',
          IPAddress: '192.168.3.76',
          userGroup: 'R&D——BRUSE电脑',
          ifPortal: '已认证',
          visitTime: '2022-07-02 18:44:27',
        },
        {
          id: '7',
          IPAddress: '192.168.3.9',
          userGroup: '无线组——小米手机',
          ifPortal: '已认证',
          visitTime: '2022-07-02 18:42:11',
        },
        {
          id: '8',
          IPAddress: '192.168.2.104',
          userGroup: '无线组——OPPO手机',
          ifPortal: '已认证',
          visitTime: '2022-07-02 18:31:09',
        },
      ]
      const item_2 = [
        {
          id: '1',
          IPAddress: '192.168.2.45',
          userGroup: '无线组——iPhone',
          ifPortal: '未认证',
          visitTime: '2022-07-02 21:15:58',
        },
        {
          id: '2',
          IPAddress: '192.168.3.103',
          userGroup: '无线组——OPPO手机',
          ifPortal: '未认证',
          visitTime: '2022-07-02 19:56:03',
        },
        {
          id: '3',
          IPAddress: '192.168.1.48',
          userGroup: '无线组——iPhone',
          ifPortal: '未认证',
          visitTime: '2022-07-02 19:48:01',
        },
        {
          id: '4',
          IPAddress: '192.168.2.61',
          userGroup: '无线组——华为手机',
          ifPortal: '未认证',
          visitTime: '2022-07-02 18:37:27',
        },
        {
          id: '5',
          IPAddress: '192.168.3.84',
          userGroup: 'R&D——Tina电脑',
          ifPortal: '未认证',
          visitTime: '2022-07-02 18:20:18',
        },
        {
          id: '6',
          IPAddress: '192.168.1.15',
          userGroup: 'R&D——BRUSE电脑',
          ifPortal: '未认证',
          visitTime: '2022-07-02 18:15:29',
        },
        {
          id: '7',
          IPAddress: '192.168.2.17',
          userGroup: '无线组——小米手机',
          ifPortal: '未认证',
          visitTime: '2022-07-02 18:13:52',
        },
        {
          id: '8',
          IPAddress: '192.168.1.88',
          userGroup: '无线组——华为手机',
          ifPortal: '未认证',
          visitTime: '2022-07-02 18:11:35',
        },
      ]

      return {
        tableData_1: item_1,
        tableData_2: item_2,
        activeName: 'first',
      }
    },
    methods: {
      async getData() {
        let list = []
        var jsonObj = await allApi.getUnportalTraveller()
        for (var i = 0; i < jsonObj.length && list.length < 50; i++) {
          if (jsonObj[i].humanFlow < 50000) list.push(jsonObj[i].humanFlow)
        }
        return list
      },
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
