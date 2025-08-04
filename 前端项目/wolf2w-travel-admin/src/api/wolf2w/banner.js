import request from '@/utils/request'

// 查询文章推荐列表
export function listBanner(query) {
  return request({
    url: '/adv/admin/banners/list',
    method: 'get',
    params: query
  })
}

// 查询文章推荐详细
export function getBanner(id) {
  return request({
    url: '/adv/admin/banners/' + id,
    method: 'get'
  })
}

// 新增文章推荐
export function addBanner(data) {
  return request({
    url: '/adv/admin/banners',
    method: 'post',
    data: data
  })
}

// 修改文章推荐
export function updateBanner(data) {
  return request({
    url: '/adv/admin/banners',
    method: 'put',
    data: data
  })
}

// 删除文章推荐
export function delBanner(id) {
  return request({
    url: '/adv/admin/banners/' + id,
    method: 'delete'
  })
}
