import request, { fetch } from '@/utils/request'

// 游记分页列表-旅游日志
export function getTravelsQuery(params) {
  return fetch('/note/notes/query', { method: 'get', params })
}
//日志详情
export function getTravelsDetail(params) {
  return fetch(`/note/notes/detail/${params.id}`, { method: 'get'})
}
//评论列表
export function getCommentsList(params) {
  return fetch('/note/noteComments/query', { method: 'get', params })
}

// 游记-新增
export function travelsAdd(body) {
  return request.post('/note/notes/add', body)
}
// 游记详情-顶
export function setTopApi(id) {
  return request.post(`/note/notes/star/${id}`)
}
// 游记详情-收藏
export function collect(id) {
  return request.post(`/note/notes/collect/${id}`)
}
// 游记详情-取消收藏
export function uncollect(id) {
  return request.post(`/note/notes/uncollect/${id}`)
}
// 游记详情-发表评论
export function commentAdd(body) {
  return request.post(`/note/noteComments/add`, body)
}
// 写游记-目的地
export function setRegios() {
  return request.get('/note/destinations/regions', {ishot: 1})
}
//请求我的游记数据
export function getMeRegios(params){
  return fetch('/note/travels/user/query', { method: 'get', params })
}
//写游记-所有目的地
export function setAllRegios() {
  return request.get('/dest/destinations/list')
}

export function getVerCode(){
  return request.get('/users/getVerifyCode?uuid=123456');
}


// 热门目的地攻略前3
export function strategyViewnnumTop3(params) {
  return fetch('/strategy/strategies/viewnnumTop3', { method: 'get', params })
}


// 热门目的地游记前3
export function travelViewnnumTop3(params) {
  return fetch('/note/notes/viewnnumTop3', { method: 'get', params })
}

