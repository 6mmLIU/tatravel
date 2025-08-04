import request, { fetch } from '@/utils/request'

// 通过类型(攻略)查询banner  已对接
export function bannerStrategy() {
  return request.get('/adv/banners/strategy')
}

// 海外/国内/热门-攻略推荐排行
export function strategtRank(params) {
  ///strategy/strategies/rank
  return request.get('/strategy/strategyRanks/rank', params)
}
// 主题攻略推荐排行
export function themeStrategy() {
  ///strategy/strategies/rank
  return request.get('/strategy/strategyRanks/theme')
}

// 全部旅游(国内/国外/主题)攻略导航 
export function strategtCondition(params) {
  return request.get('/strategy/strategyConditions/condition', params)
}

// 攻略文章列表 已对接
export function strategyList(params) {
  return request.get('/strategy/strategies/query', params)
}

// 攻略文章详情 已对接
export function strategyDetails(params) {
  return request.get(`/strategy/strategies/detail/${params.id}`, params)
}

// 当前攻略文章详情-收藏数/点赞数等等统计数据  已对接
export function statisVo(params) {
  return request.get('/strategy/strategies/stat', params)
}
// 当前攻略文章详情-阅读数+1 已对接
export function viewnumIncr(params) {
  return fetch(`/strategy/strategies/viewnumIncr`, { method: 'post', params })
}
// 当前攻略文章详情-评论数+1 已对接
export function replynumIncr(params) {
  return fetch(`/strategy/strategies/replynumIncr`, { method: 'post', params })
}


// 当前攻略文章详情-评论列表 已对接
export function commentList(params) {
  return request.get('/strategy/strategyComments/query', params)
}

// 当前攻略文章详情-新增评论 已对接
export function commentAdd(params) {
  console.log(params);
  return fetch('/strategy/strategyComments/add', { method: 'post', params })
}



// 当前攻略文章详情-评论点赞 已对接
export function commentThumb(params) {
  return fetch(`/strategy/strategyComments/thumbsup`, { method: 'post', params })
}

// 当前攻略文章详情-收藏 已对接
export function favor(params) {
  return fetch(`/strategy/strategies/favor`, { method: 'post', params })
}

// 当前攻略文章详情-顶一下 已对接
export function thumbup(params) {  
  return fetch(`/strategy/strategies/thumbsup`, { method: 'post', params })
}

// 当前攻略文章详情-收藏回显
export function isUserFavor(params) {
  return fetch(`/strategy/strategies/isUserFavor`, { method: 'get', params })
}