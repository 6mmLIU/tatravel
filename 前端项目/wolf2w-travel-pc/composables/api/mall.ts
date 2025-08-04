import request, { fetch } from '@/utils/request'
//获取秒杀列表
export function getCurrentSeckillList(params){
   return fetch('/seckill/seckillProduct/queryByTime', { method: 'get', params })
}
//获取商品详情
export function getCommodityDetail(params){
   return fetch('/seckill/seckillProduct/find',{method:'get',params})
}

//获取订单详情
export function getOrderDetail(params){
   return fetch('/seckill/order/find',{method:'get',params})
}

//秒杀
export function setOrderDoSeckill(body){
   return fetch(`/seckill/order/doSeckill?time=${body.time}&seckillId=${body.seckillId}`,{method:'post',headers: {'content-type': 'application/x-www-form-urlencoded'}})
}

//积分支付
export function setOrderIntegralPay(body){
   return fetch(`/seckill/orderPay/pay?orderNo=${body.orderNo}&type=${body.type}`,{method:'post',headers:{'content-type': 'application/x-www-form-urlencoded'},body})
}

//退款

export function setOrderRefund(orderNo){
   return fetch(`/seckill/orderPay/refund?orderNo=${orderNo}`,{method:'post'});
}

//订单列表
export function getOrderList(){
   return fetch('/seckill/order/list',{method:'get'});
}