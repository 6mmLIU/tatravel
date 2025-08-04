import config from './config'
import { _AsyncData } from 'nuxt/dist/app/composables/asyncData'
import { ElMessage } from 'element-plus'


// 指定后端返回的基本数据类型
export interface ResponseConfig {
  code: number
  status: number
  data: any
  msg: string
}

let isLogin=false; 

export const fetch = (url: string, options?: any): Promise<any> => {
  //const { $router,$route } = useNuxtApp()
  
  let reqUrl='';
  // const baseUrl = '/api'
  if(/^\/mallapi/.test(url)){
    reqUrl=url;    
  }else{
   // console.log(url);
    reqUrl = config.baseUrl + url 
  }
  
  // rc.5开始需要传一个唯一的key
  const key = random() + '_' + url
  let headers = {}
  if(options.headers){
    headers=options.headers; 
  }

  if (localStorage.getItem('token')) {
    headers['token'] = localStorage.getItem('token')
    headers['x-authorization'] = localStorage.getItem('token')
    headers['Authorization']=localStorage.getItem('token');
  }
  
  return new Promise((resolve, reject) => {
    useFetch(reqUrl, { ...options, headers, key })
      .then(({ data, error }: _AsyncData<any, any>) => {
        const $router=useRouter();
        if (error.value) {
          reject(error.value) 
          return
        }
        const res = data.value
        
        if (!res) {
          console.log(res);
          reject(res)
        } else {  
          if (res.code === 200) {
            resolve(res)
          } else {
            const path= $router.currentRoute.value.path;
            reject(res)
           
            if (res.code === 401) {
             if(!isLogin){
              ElMessage.error(res.msg)
              isLogin=true;

              setTimeout(()=>{
                isLogin=false;
              },1000)
              if(path=='/note/form'||path=='/questions/publish'){
                //location.href='/login';
                window.open('/login');
              }else{
                $router.replace('/login');
              }
             }
            }else if(res.code===500){
              if(res.msg=="未提供token"){
                ElMessage.error('未登录，请登录');
              }else{
                ElMessage.error(res.msg);
              }
            }
          }
        }
      })
      .catch((err: any) => {
        console.log(err);
        
        reject(err)
      })
  })
}

export default new (class request {
  get(url: string, params?: any): Promise<any> {
    return fetch(url, { method: 'get', params })
  }

  post(url: string, body?: any): Promise<any> {
    return fetch(url, { method: 'post', body })
  }

  put(url: string, body?: any): Promise<any> {
    return fetch(url, { method: 'put', body })
  }

  delete(url: string, body?: any): Promise<any> {
    return fetch(url, { method: 'delete', body })
  }
})()

function random() {
  let Num = ''
  for (let i = 0; i < 6; i++) {
    Num += Math.floor(Math.random() * 10)
  }
  return Num
}
