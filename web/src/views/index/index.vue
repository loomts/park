<template>
  <div class="index-container">
    <!-- 在img标签中可以直接使用backgroundImgUrl变量作为图片路径 -->
    <img :src="backgroundImgUrl" class="indeximg" />
    <!-- 在style中要把backgroundImgUrl变量拼接到url()中，才能正常引入图片 -->
    <!-- <div :style="{ backgroundImage: `url{{backgroundImgUrl}}` }"></div> -->
  </div>
</template>

<script>
  // 在vue组件中定义此变量，组件创建成功后该变量值为'/static/img/login-bg.df6a3174.png'
  // import VabChart from '@/plugins/echarts'
  // import { dependencies, devDependencies } from '../../../package.json'
  // import { getList } from '@/api/changeLog'
  // import { getNoticeList } from '@/api/notice'
  // import { getRepos, getStargazers } from '@/api/github'
  // import Plan from './components/Plan'
  // import VersionInformation from './components/VersionInformation'

  export default {
    name: 'Index',
    components: {
      // VabChart,
    },
    data() {
      return {
        backgroundImgUrl: require('@/assets/bg.png'),
      }
    },
    created() {},
    beforeDestroy() {},
    mounted() {},
    methods: {},
  }
</script>
<style lang="scss" scoped>
  .indeximg {
    width: 1600px;
    height: 900px;
  }
  .index-container {
    padding: 0 !important;
    margin: 0 !important;
    background: #f5f7f8 !important;

    ::v-deep {
      .el-alert {
        padding: $base-padding;

        &--info.is-light {
          min-height: 82px;
          padding: $base-padding;
          margin-bottom: 15px;
          color: #909399;
          background-color: $base-color-white;
          border: 1px solid #ebeef5;
        }
      }

      .el-card__body {
        .echarts {
          width: 100%;
          height: 115px;
        }
      }
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

    .bottom {
      padding-top: 20px;
      margin-top: 5px;
      color: #595959;
      text-align: left;
      border-top: 1px solid $base-border-color;
    }

    .table {
      width: 100%;
      color: #666;
      border-collapse: collapse;
      background-color: #fff;

      td {
        position: relative;
        min-height: 20px;
        padding: 9px 15px;
        font-size: 14px;
        line-height: 20px;
        border: 1px solid #e6e6e6;

        &:nth-child(odd) {
          width: 20%;
          text-align: right;
          background-color: #f7f7f7;
        }
      }
    }

    .icon-panel {
      height: 117px;
      text-align: center;
      cursor: pointer;

      svg {
        font-size: 40px;
      }

      p {
        margin-top: 10px;
      }
    }

    .bottom-btn {
      button {
        margin: 5px 10px 15px 0;
      }
    }
  }
</style>
