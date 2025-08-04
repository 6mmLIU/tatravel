import request from '@/utils/request'

// 查询攻略主题列表
export function listStrategyTheme(query) {
  return request({
    url: '/strategy/admin/strategyThemes/list',
    method: 'get',
    params: query
  })
}

// 查询攻略主题列表
export function themeListAll() {
  return request({
    url: '/strategy/admin/strategyThemes/listAll',
    method: 'get'
  })
}

// 查询攻略主题详细
export function getStrategyTheme(id) {
  return request({
    url: '/strategy/admin/strategyThemes/' + id,
    method: 'get'
  })
}

// 新增攻略主题
export function addStrategyTheme(data) {
  return request({
    url: '/strategy/admin/strategyThemes',
    method: 'post',
    data: data
  })
}

// 修改攻略主题
export function updateStrategyTheme(data) {
  return request({
    url: '/strategy/admin/strategyThemes',
    method: 'put',
    data: data
  })
}

// 删除攻略主题
export function delStrategyTheme(id) {
  return request({
    url: '/strategy/admin/strategyThemes/' + id,
    method: 'delete'
  })
}
