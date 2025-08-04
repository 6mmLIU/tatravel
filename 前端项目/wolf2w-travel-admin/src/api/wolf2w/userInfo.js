import request from '@/utils/request'

// 查询前台用户列表
export function listUserInfo(query) {
  return request({
    url: '/member/admin/userInfos/list',
    method: 'get',
    params: query
  })
}

// 查询前台用户详细
export function getUserInfo(id) {
  return request({
    url: '/member/admin/userInfos/' + id,
    method: 'get'
  })
}

// 新增前台用户
export function addUserInfo(data) {
  return request({
    url: '/member/admin/userInfos',
    method: 'post',
    data: data
  })
}

// 修改前台用户
export function updateUserInfo(data) {
  return request({
    url: '/member/admin/userInfos',
    method: 'put',
    data: data
  })
}

// 删除前台用户
export function delUserInfo(id) {
  return request({
    url: '/member/admin/userInfos/' + id,
    method: 'delete'
  })
}
