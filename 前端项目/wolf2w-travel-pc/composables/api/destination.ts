import request, { fetch } from '@/utils/request'

// 热门目的地(一级菜单)
export function getRegions(params) {

  console.log(params);  
  return fetch('/dest/destinations/regions', { method: 'get', params })
}

// 添加新目的地的二级列表
export function searchRegions(params) {
  return fetch('/dest/destinations/search', { method: 'get', params })
}

// 页面当前介绍位置(面包屑)(导航栏下面的)
export function  toasts(params) {
  return  fetch('/dest/destinations/toasts', { method: 'get', params })
}

// 热门目的地攻略前3
export function viewnnumTop3(params) {
  return fetch('/strategy/strategies/viewnnumTop3', { method: 'get', params })
}

// 目的地 概要
export function catalogs(params) {
  return fetch('/strategy/strategies/catalogList', { method: 'get', params })
}

// 目的地 概要-内容
export function catalogsContent(params) {
  return fetch('/strategy/strategies/content', { method: 'get', params })
}
