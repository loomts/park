import request from '@/utils/request'

export function getList(data) {
  return request({
    url: '/healthy/getList',
    method: 'post',
    data,
  })
}
