import request, { fetch } from '@/utils/request'

// 修改用户
// export function login(body) {
//   return request.post('/users/login', body)
// }
export function modifyUser(body) {
  //console.log(body);
  
  return fetch('/system/users', { method: 'put', body })
}
