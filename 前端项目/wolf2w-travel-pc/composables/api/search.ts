import request, { fetch } from '@/utils/request'

// 通过类型(游记)查询banner
export function searchList(params) {
  return request.get('/search/search', params)
}
