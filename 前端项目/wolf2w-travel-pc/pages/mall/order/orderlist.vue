<template>
  <div class="order">
    <div class="order-content">
      <div class="list-title">
        我的订单
      </div>
      <div class="order-list-box">
        <div class="list-content">
          <div class="order-list-header">
          <div class="order-num-box">订单号</div>
          <div class="order-info-box">商品信息</div>
          <div class="order-goods-count">数量</div>
          <div class="order-user-name">收货人</div>
          <div class="order-total-price">金额</div>
          <div class="order-status">订单状态</div>
          <div class="order-des">备注</div>
        </div>
        <ul class="order-list">
          <li class="order-item" v-for="item in orderListData" :key="'orderitem' + item.id">
            <div class="order-num-box">
              <nuxt-link class="order-link" :to="{ path: '/mall/order/detail', query: { 'out_trade_no': item.orderNo } }">{{ item.orderNo
              }}</nuxt-link>
            </div>
            <div class="order-info-box order-info-detail">
              <img class="product-img" :src="item.productImg" alt="">
              <span class="product-name">{{ item.productName }}</span>
            </div>
            <div class="order-goods-count">1</div>
            <div class="order-user-name">叩丁狼</div>
            <div class="order-total-price">
              <div class="price-box" v-if="item.status == 0">
                <span>￥{{ item.productPrice }}</span>/
                <span>{{ item.integral }}积分</span>
              </div>
              <div class="price-box" v-else-if="item.payType == 0">
                <span>￥{{ item.productPrice }}</span>
              </div>
              <div class="price-box" v-else-if="item.payType == 1">
                <span>{{ item.integral }}积分</span>
              </div>
            </div>
            <div class="order-status">
              <span v-if="item.status === 0">未付款</span>
              <span v-else-if="item.status === 1">已付款</span>
              <span v-else-if="item.status === 2">手动取消订单</span>
              <span v-else-if="item.status === 3">超时取消订单</span>
              <span v-else-if="item.status === 4">已退款</span>
            </div>
            <div class="order-des"></div>
          </li>
        </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { getOrderList } from '~~/composables/api/mall';

definePageMeta({
  layout: 'mall'
});

const orderListData = ref([]);
function getOrderListdData() {
  getOrderList().then((res) => {
    console.log(res);
    orderListData.value = res.data;
  })
}


onMounted(() => {
  nextTick(()=>{
    getOrderListdData();
  })
})
</script>

<style scoped>
.order{
  background-color: #f5f5f5;
}
.order-content {
  width: 1050px;
  margin: 0 auto;
  padding: 30px 0;
  font-size: 14px;
}

.list-title{
  height: 55px;
  line-height: 55px;
  padding-left: 20px;
  background-color: #fff;
  font-weight: 700;
  margin-bottom: 20px;
}
.order-list-box{  
  padding:20px;
  background-color: #fff;
}

.list-content{
  border: 1px solid #ececec;
}
.order-list-header{
  display: flex;
  height: 45px;
  background-color: #f5f5f5;
  line-height: 45px;
  text-align: center;
}

.order-num-box{  
  width: 160px;
 
}

.order-info-box{
  width: 380px;
 
}

.order-goods-count{
  width: 50px;
  
}

.order-user-name,.order-total-price,.order-status{
  width: 120px;
}

.order-des{
  width: 45px;
}

.order-item{
  display: flex;
  height: 95px;
  border-top: 1px solid #ececec;
  /* align-items: center; */
  text-align: center;
}

.order-item>div{
  height: 100%;
  line-height: 95px;
  border-right: 1px solid #ececec;
}

.order-item>div:last-child{
  border-right: 0;
}

.order-item>.order-info-detail{
  display: flex;
  align-items: center;
  line-height: 0;
  padding-left: 15px;
  box-sizing: border-box;
}

.product-img{
  width:60px;
  height: 60px;
  margin-right: 10px;
}

.product-name{
  height: 40px;
  line-height: 20px;
  overflow: hidden;
  padding-right: 10px;
  text-align: left;
  font-size: 13px;
}

</style>