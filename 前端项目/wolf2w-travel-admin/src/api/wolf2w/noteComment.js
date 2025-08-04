import request from '@/utils/request'

// 查询游记评论列表
export function listNoteComment(query) {
  return request({
    url: '/note/admin/noteComments/list',
    method: 'get',
    params: query
  })
}

// 查询游记评论详细
export function getNoteComment(id) {
  return request({
    url: '/note/admin/noteComments/' + id,
    method: 'get'
  })
}

// 新增游记评论
export function addNoteComment(data) {
  return request({
    url: '/note/admin/noteComments',
    method: 'post',
    data: data
  })
}

// 修改游记评论
export function updateNoteComment(data) {
  return request({
    url: '/note/admin/noteComments',
    method: 'put',
    data: data
  })
}

// 删除游记评论
export function delNoteComment(id) {
  return request({
    url: '/note/admin/noteComments/' + id,
    method: 'delete'
  })
}
