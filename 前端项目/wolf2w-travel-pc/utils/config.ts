let baseUrl = ''
if (process.env.NODE_ENV === 'development') {
  // 开发环境
  baseUrl = '/api'
  //baseUrl='/gateway/gateway'
} else {
  // 生产环境
  //baseUrl = 'http://xue.cnkdl.cn:23686/api'
  baseUrl = 'http://127.0.0.1:9000'
}

export default { baseUrl }
