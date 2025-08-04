import request from '@/utils/request'

// 查询目的地列表
export function listDestination(query) {
  return request({
    url: '/dest/admin/destinations/list',
    method: 'get',
    params: query
  })
}

export function listAll() {
  return request({
    url: '/dest/admin/destinations/all',
    method: 'get'
  })
}
export function listByRid (id) {
  return request({
    url: '/dest/admin/destinations/listByRid',
    method: 'get',
    params:id
  })
}
// 查询目的地吐司
export function queryToasts(param) {
  return request({
    url: '/dest/admin/destinations/toasts',
    method: 'get',
    params: param
  })
}

// 查询目的地详细
export function getDestination(id) {
  return request({
    url: '/dest/admin/destinations/' + id,
    method: 'get'
  })
}

// 新增目的地
export function addDestination(data) {
  return request({
    url: '/dest/admin/destinations',
    method: 'post',
    data: data
  })
}

// 修改目的地
export function updateDestination(data) {
  return request({
    url: '/dest/admin/destinations',
    method: 'put',
    data: data
  })
}

// 删除目的地
export function delDestination(id) {
  return request({
    url: '/dest/admin/destinations/' + id,
    method: 'delete'
  })
}
