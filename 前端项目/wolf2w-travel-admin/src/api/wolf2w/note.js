import request from '@/utils/request'

// 查询旅游日记列表
export function listNote(query) {
  return request({
    url: '/note/admin/notes/list',
    method: 'get',
    params: query
  })
}

// 查询旅游日记详细
export function getNote(id) {
  return request({
    url: '/note/admin/notes/' + id,
    method: 'get'
  })
}

// 查询旅游日记详细
export function getNoteContent(id) {
  return request({
    url: '/note/admin/notes/content/' + id,
    method: 'get'
  })
}

// 新增旅游日记
export function addNote(data) {
  return request({
    url: '/note/admin/notes',
    method: 'post',
    data: data
  })
}

// 修改旅游日记
export function updateNote(data) {
  return request({
    url: '/note/admin/notes',
    method: 'put',
    data: data
  })
}
export function noteAudit(data) {
  return request({
    url: '/note/admin/notes/audit',
    method: 'post',
    data: data
  })
}

// 删除旅游日记
export function delNote(id) {
  return request({
    url: '/note/admin/notes/' + id,
    method: 'delete'
  })
}
