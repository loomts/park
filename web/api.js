export function hello() {
  return request({
    url: '/hello',
    method: 'get',
  })
}
export function getDeviceDetail() {
  return request({
    url: '/deviceDetail',
    method: 'get',
  })
}
export function getDeviceTraffic() {
  return request({
    url: '/deviceTraffic',
    method: 'get',
  })
}
export function getHistFlow() {
  return request({
    url: '/histFlow',
    method: 'get',
  })
}
export function getNowFlow() {
  return request({
    url: '/nowFlow',
    method: 'get',
  })
}
export function getSitesFlow() {
  return request({
    url: '/sitesFlow',
    method: 'get',
  })
}
export function getSitesHealth() {
  return request({
    url: '/sitesHealth',
    method: 'get',
  })
}
export function getSitesUserNumber() {
  return request({
    url: '/sitesUserNumber',
    method: 'get',
  })
}
export function getSitesWlan() {
  return request({
    url: '/sitesWlan',
    method: 'get',
  })
}
