/**
 * @author https://gitee.com/chu1204505056/vue-admin-better （不想保留author可删除）
 * @description router全局配置，如有必要可分文件抽离，其中asyncRoutes只有在intelligence模式下才会用到，vip文档中已提供路由的基础图标与小清新图标的配置方案，请仔细阅读
 */

import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/layouts'
import EmptyLayout from '@/layouts/EmptyLayout'
import { publicPath, routerMode } from '@/config'

Vue.use(VueRouter)
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true,
  },
  {
    path: '/register',
    component: () => import('@/views/register/index'),
    hidden: true,
  },
  {
    path: '/401',
    name: '401',
    component: () => import('@/views/401'),
    hidden: true,
  },
  {
    path: '/404',
    name: '404',
    component: () => import('@/views/404'),
    hidden: true,
  },
]

export const asyncRoutes = [
  {
    path: '/',
    component: Layout,
    redirect: '/index',
    children: [
      {
        path: 'index',
        name: 'Index',
        component: () => import('@/views/index/index'),
        meta: {
          title: '首页',
          icon: 'home',
          affix: true,
        },
      },
    ],
  },
  /* {
    path: "/test",
    component: Layout,
    redirect: "noRedirect",
    children: [
      {
        path: "test",
        name: "Test",
        component: () => import("@/views/test/index"),
        meta: {
          title: "test",
          icon: "marker",
          permissions: ["admin"],
        },
      },
    ],
  }, */

  {
    path: '/manage',
    component: Layout,
    redirect: 'noRedirect',
    name: 'Manage',
    alwaysShow: true,
    meta: { title: '园区情况总览', icon: 'box-open' },
    children: [
      {
        path: 'nowpeople',
        name: 'Nowpeople',
        component: () => import('@/views/manage/nowpeople/index'),
        meta: { title: '实时人流量', permissions: ['admin'] },
      },
      {
        path: 'lastpeople',
        name: 'Lastpeople',
        component: () => import('@/views/manage/lastpeople/index'),
        meta: { title: '历史人流量', permissions: ['admin'] },
      },
      {
        path: 'hotgraph',
        name: 'Hotgraph',
        component: () => import('@/views/vab/verify/index'),
        meta: { title: '热点图', permissions: ['admin'] },
      },
      {
        path: 'managework',
        name: 'Managework',
        component: () => import('@/views/vab/verify/index'),
        meta: { title: '园区基础设施', permissions: ['admin'] },
      },
      {
        path: 'manageparking',
        name: 'Manageparking',
        component: () => import('@/views/manage/manageparking/index'),
        meta: { title: '智能车位系统', permissions: ['admin'] },
      },
    ],
  },

  {
    path: '/managephone',
    component: Layout,
    redirect: 'noRedirect',
    name: 'Managephone',
    alwaysShow: true,
    meta: { title: '无线设备管理', icon: 'box-open' },
    children: [
      {
        path: 'healthy',
        name: 'Healthy',
        component: () => import('@/views/managephone/healthy/index'),
        meta: { title: '健康评测', permissions: ['admin'] },
      },
      {
        path: 'nowphone',
        name: 'Nowphone',
        component: () => import('@/views/managephone/nowphone/test'),
        meta: { title: '设备详情', permissions: ['admin'] },
      },
    ],
  },

  {
    path: '/control',
    component: Layout,
    redirect: 'noRedirect',
    name: 'Control',
    alwaysShow: true,
    meta: { title: '疫情防控', icon: 'box-open' },
    children: [
      {
        path: 'queryway',
        name: 'Queryway',
        component: () => import('@/views/control/queryway/index'),
        meta: { title: '查询路径', permissions: ['admin'] },
      },
      {
        path: 'querycontact',
        name: 'Querycontact',
        component: () => import('@/views/mall/goodsList/index'),
        meta: { title: '密接查询', permissions: ['admin'] },
      },
    ],
  },

  {
    path: '/monitor',
    component: Layout,
    redirect: 'noRedirect',
    name: 'Monitor',
    alwaysShow: true,
    meta: { title: '重要场所监控', icon: 'box-open' },
    children: [],
  },

  {
    path: '/logg',
    component: Layout,
    redirect: 'noRedirect',
    name: 'Logg',
    alwaysShow: true,
    meta: { title: '日志', icon: 'box-open' },
    children: [
      {
        path: 'nowlog',
        name: 'Nowlog',
        component: () => import('@/views/logg/nowlog/index'),
        meta: { title: '日志', permissions: ['admin'] },
      },
    ],
  },

  // {
  //   path: '/vab',
  //   component: Layout,
  //   redirect: 'noRedirect',
  //   name: 'Vab',
  //   alwaysShow: false,
  //   meta: { title: '组件', icon: 'box-open' },
  //   children: [
  //     {
  //       path: 'icon',
  //       component: EmptyLayout,
  //       redirect: 'noRedirect',
  //       name: 'Icon',
  //       meta: {
  //         title: '图标',
  //         permissions: ['admin'],
  //       },
  //       children: [
  //         {
  //           path: 'awesomeIcon',
  //           name: 'AwesomeIcon',
  //           component: () => import('@/views/vab/icon/index'),
  //           meta: { title: '常规图标' },
  //         },
  //         {
  //           path: 'colorfulIcon',
  //           name: 'ColorfulIcon',
  //           component: () => import('@/views/vab/icon/colorfulIcon'),
  //           meta: { title: '多彩图标' },
  //         },
  //       ],
  //     },

  //     {
  //       path: 'map',
  //       component: () => import('@/views/vab/map/index'),
  //       name: 'Map',
  //       meta: {
  //         title: '地图',
  //         permissions: ['admin'],
  //       },
  //     },

  //     {
  //       path: 'webSocket',
  //       name: 'WebSocket',
  //       component: () => import('@/views/vab/webSocket/index'),
  //       meta: { title: 'webSocket', permissions: ['admin'] },
  //     },

  //     {
  //       path: 'element',
  //       name: 'Element',
  //       component: () => import('@/views/vab/element/index'),
  //       meta: { title: '常用组件', permissions: ['admin'] },
  //     },

  //     {
  //       path: 'verify',
  //       name: 'Verify',
  //       component: () => import('@/views/vab/verify/index'),
  //       meta: { title: '验证码', permissions: ['admin'] },
  //     },

  //     {
  //       path: 'loading',
  //       name: 'Loading',
  //       component: () => import('@/views/vab/loading/index'),
  //       meta: { title: 'loading', permissions: ['admin'] },
  //     },

  //     {
  //       path: 'upload',
  //       name: 'Upload',
  //       component: () => import('@/views/vab/upload/index'),
  //       meta: { title: '上传', permissions: ['admin'] },
  //     },
  //     {
  //       path: 'log',
  //       name: 'Log',
  //       component: () => import('@/views/vab/errorLog/index'),
  //       meta: { title: '错误日志模拟', permissions: ['admin'] },
  //     },
  //   ],
  // },

  {
    path: '*',
    redirect: '/404',
    hidden: true,
  },
]

const router = new VueRouter({
  base: publicPath,
  mode: routerMode,
  scrollBehavior: () => ({
    y: 0,
  }),
  routes: constantRoutes,
})

export function resetRouter() {
  location.reload()
}

export default router
