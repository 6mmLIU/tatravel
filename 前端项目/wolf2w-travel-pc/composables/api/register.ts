import request,{ fetch} from '@/utils/request'

// 发送手机验证码
export function sendVerifyCode(params) {
  return fetch('/message/sms/sendVerifyCode', { method: 'post', params })
}

// 注册方法
export function register(body) {
  //return fetch('/auth/register', { method: 'post', params })
  return request.post('/auth/register', body)
}
