import request, { fetch } from '@/utils/request'

// 登录方法
// export function login(body) {
//   return request.post('/users/login', body)
// }
// export function login(params) {
//   return fetch('/users/login', { method: 'post', params })
// }

export function login(body) {
  //return fetch('/mallapi/auth/login', { method: 'post', params,headers: {'Content-Type': 'application/json'}})
  return request.post('/auth/login', body)

}

export function getVerifyCode(params){
  return fetch(`/code`,{method:'get',params});
}

export function getUserInfo(){
  return fetch('/member/userInfos/getByToken',{method:'get'});
}