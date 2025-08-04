import request from '@/utils/request'

// 查询攻略分类列表
export function listStrategyCatalog(query) {
  return request({
    url: '/strategy/admin/strategyCatalogs/list',
    method: 'get',
    params: query
  })
}

// 查询攻略分类详细
export function getStrategyCatalog(id) {
  return request({
    url: '/strategy/admin/strategyCatalogs/' + id,
    method: 'get'
  })
}

// 新增攻略分类
export function addStrategyCatalog(data) {
  return request({
    url: '/strategy/admin/strategyCatalogs',
    method: 'post',
    data: data
  })
}

// 修改攻略分类
export function updateStrategyCatalog(data) {
  return request({
    url: '/strategy/admin/strategyCatalogs',
    method: 'put',
    data: data
  })
}

// 删除攻略分类
export function delStrategyCatalog(id) {
  return request({
    url: '/strategy/admin/strategyCatalogs/' + id,
    method: 'delete'
  })
}
// 分组列表
export function groupList() {
  return request({
    url: '/strategy/admin/strategyCatalogs/groupList',
    method: 'get'
  })
}
