import request, { fetch } from '@/utils/request'

// 通过类型(游记)查询banner
export function bannerTravel() {
  return request.get('/adv/banners/travel')
}

// 游记列表
export function noteList(params) {
  return request.get('/note/notes/query', params)
}
