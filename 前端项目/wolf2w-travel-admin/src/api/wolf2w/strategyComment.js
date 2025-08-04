import request from '@/utils/request'

// 查询攻略评论列表
export function listStrategyComment(query) {
  return request({
    url: '/strategy/admin/strategyComments/list',
    method: 'get',
    params: query
  })
}

// 查询攻略评论详细
export function getStrategyComment(id) {
  return request({
    url: '/strategy/admin/strategyComments/' + id,
    method: 'get'
  })
}

// 新增攻略评论
export function addStrategyComment(data) {
  return request({
    url: '/strategy/admin/strategyComments',
    method: 'post',
    data: data
  })
}

// 修改攻略评论
export function updateStrategyComment(data) {
  return request({
    url: '/strategy/admin/strategyComments',
    method: 'put',
    data: data
  })
}

// 删除攻略评论
export function delStrategyComment(id) {
  return request({
    url: '/strategy/admin/strategyComments/' + id,
    method: 'delete'
  })
}
