import request from '@/utils/request'

// 查询攻略管理列表
export function listStrategy(query) {
  return request({
    url: '/strategy/admin/strategys/list',
    method: 'get',
    params: query
  })
}

// 查询攻略管理详细
export function getStrategy(id) {
  return request({
    url: '/strategy/admin/strategys/' + id,
    method: 'get'
  })
}

// 新增攻略管理
export function addStrategy(data) {
  return request({
    url: '/strategy/admin/strategys',
    method: 'post',
    params: data
  })
}

// 修改攻略管理
export function updateStrategy(data) {
  return request({
    url: '/strategy/admin/strategys',
    method: 'put',
    params: data
  })
}

// 删除攻略管理
export function delStrategy(id) {
  return request({
    url: '/strategy/admin/strategys/' + id,
    method: 'delete'
  })
}
