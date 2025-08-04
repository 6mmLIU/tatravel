//import { defineNuxtConfig } from 'nuxt'

// https://v3.nuxtjs.org/api/configuration/nuxt.config
export default defineNuxtConfig({
  // build: { transpile: ['element-plus'] },
  css: ['element-plus/dist/index.css', 'normalize.css', '@/assets/css/index.scss'],
  vite: {
    resolve: {
      dedupe: ['vue']
    },

  },
  nitro: {
    devProxy: {
      '/api2/': {
        target: 'http://127.0.0.1:9000', //这里是接口地址
        changeOrigin: true,
        //rewrite:path=>path.replace(/^\/api/,'/gateway')
      },
      '/api': {
        //target: 'http://xue.cnkdl.cn:23686', //这里是接口地址
        target: 'http://127.0.0.1:9000', //这里是接口地址
        changeOrigin: true
      }
    }
  }
})
