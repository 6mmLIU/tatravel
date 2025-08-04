<template>
  <div class="layout-container">
    <div class="layout-main">
      <div class="seckill-body">
        <div class="my-order-header">
          <div class="seckill-top">
            <div class="seckill-welcome">
              <div class="welcome-content">
                <div class="seckill-text">
                  <span class="wel-text">欢迎来到叩丁严选</span>
                  <a href="/" class="wel-link">回到带TA游</a>
                </div>
                <ul class="seckill-ul">
                  <li v-if="userInfo" class="seckill-li userInfo">
                    <a href="javascript:;" class="user-name">
                      <img class="user-headimg" :src="userInfo.headImgUrl" alt="">
                    </a>
                  </li>
                  <li v-if="userInfo" class="seckill-li userInfo">
                    <nuxt-link to="/personal/info" target="_blank"  class="user-name">
                      <label>用户名: </label>
                      <span id="nickName">{{ userInfo.nickname }}</span>
                    </nuxt-link>
                  </li>
                  <li v-if="userInfo" class="seckill-li userInfo">
                    <a :href="linkData.path" class="user-name">{{linkData.text}}</a>
                  </li>
                  <li v-else class="seckill-li loginBtn">
                    <nuxt-link to="/login" target="_blank" class="shopping-content user-change-login">登录</nuxt-link>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <NuxtPage />
      </div>
    </div>
    <div class="layout-footer">
      <Footer />
    </div>
  </div>
</template>
<script lang="ts" setup>

const userInfo = ref(null);
const route=useRoute();
const linkData=reactive({
  path:'/mall/order/detail',
  text:'我的订单'
});
//获取用户信息
function getUserInfo() {
  const str = localStorage.getItem('userInfo');
  if (str) {
    userInfo.value = JSON.parse(str);
  }
}



onMounted(() => {
  document.body.style.margin = '0';
  getUserInfo();
});

onUpdated(()=>{
  //console.log(route.path);
  if(route.path=='/mall'){
    linkData.path='/mall/order/orderlist';
    linkData.text='我的订单';
  }else if(route.path=='/mall/order/orderlist'||route.path=='/mall/order/detail'){
    linkData.path='/mall';
    linkData.text='回到商城';
  }
})
</script>
  
<style lang="scss" scoped>
.layout-container {
  position: relative;
  width: 100%;
  height: 100%;

  .layout-main {
    width: 100%;
    /* height: 100%; */
    padding: 0;
  }
}

.seckill-welcome {
    height: 40px;
    background: #242b39;
}

.welcome-content {
    width: 1200px;
    margin: 0 auto;
    display: flex;
    height: 40px;
    flex-direction: row;
    align-items: center;
}

.seckill-text {
    font-size: 14px;
    font-weight: normal;
    font-stretch: normal;
    line-height: 23px;
    letter-spacing: 0px;
    color: #fffefe;
    flex: 1;
}

.wel-text{
  margin-right: 10px;
}

.wel-link{
  font-size: 12px;
  color: #ccc;
}

.seckill-ul {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 0;
}

.seckill-li {
    margin-right: 20px;
}

.seckill-li a:last-child{
  color: #ccc;
}

.seckill-li label,.seckill-li span {
    font-size: 14px;
    font-weight: normal;
    font-stretch: normal;
    line-height: 22px;
    letter-spacing: 0px;
    color: #fffefe;
    margin: 0;
    cursor: pointer;
}

.shopping-content {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    width: 124px;
    height: 40px;
    background-color: #0a328e;
    cursor: pointer;
    color: #fff;
}

.seckill-nav {
    padding-top: 12px;
    height: 99px;
    background: #fff;
    box-sizing: border-box;
}

.user-headimg{
    width: 25px;
    height: 25px;
    border-radius: 50%;
}

.nav-content {
    display: flex;
    flex-direction: row;
    align-items: center;
    width: 1200px;
    margin: 0 auto;
}

.nav-logo {
    width: 151px;
    height: 72px;
    background-image: url(../../assets/images/mall_logo.png);
    background-size: 100% 100%;
    background-position: center;
}

.nav-select {
    flex: 1;
    padding: 30px 98px 0 68px;
    box-sizing: border-box;
}

.nav-list {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 0;
}

.nav-text {
    padding-left: 53px;
}

.nav-text:first-child {
    padding: 0;
}

.nav-text a {
    font-size: 16px;
    font-weight: normal;
    letter-spacing: 0px;
    color: #242b39;
}

.nav-text a:hover,
.nav-text a:focus {
    color: #0a328e;
}

.nav-search {
    width: 264px;
    height: 40px;
    padding-top: 25px;
    box-sizing: border-box;
    display: flex;
    flex-direction: row;
    align-items: center;
}

.input-content {
    width: 214px;
    height: 40px;
    /* line-height: 40px; */
    padding-left: 19px;
    box-sizing: border-box;
    border-radius: 20px 0 0 20px;
    border: solid 1px #dedede;
}

.search-input {
    width: 100%;
    font-size: 14px;
    line-height: 38px;
    padding-right: 19px;
    box-sizing: border-box;
}

.search-img {
    width: 50px;
    height: 40px;
    background-color: #0a328e;
    text-align: center;
    line-height: 42px;
    background-image: url(../../assets/images/mall_search.png);
    background-size: 17px 17px;
    background-position: center;
    background-repeat: no-repeat;
    cursor: pointer;
    border-radius: 0px 20px 20px 0px;
}

</style>
  