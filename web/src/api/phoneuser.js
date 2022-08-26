import request from '@/utils/request'

export function getPhoneUser(data) {
  return request({
    url: '/phoneuser/getList',
    method: 'post',
    data,
  })
}

export function queryPhoneUser(data) {
  return request({
    url: '/phoneuser/queryUser',
    type: 'post',
    data,
  })
}
