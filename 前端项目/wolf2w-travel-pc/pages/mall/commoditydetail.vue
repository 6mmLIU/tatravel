<template>
    <div class="commodityDetails">
        <div class="commodityDetails-container">
            <div class="container-top">
                <div class="container-top-left">
                    <div class="currentImg">
                        <img id="productImg" :src="commodityImgs.length > 0 ? commodityImgs[curImgIndex].imgurl : ''" alt=""
                            class="big-img-data">
                    </div>
                    <ul class="commodity-ul">
                        <li :class="`commodity-li ${i == curImgIndex ? 'commodity-li-active' : ''}`"
                            v-for="(item, i) in commodityImgs" :key="item.id" @mouseenter="switchCommodityImg(i)">
                            <img :src="item.imgurl" alt="">
                        </li>
                    </ul>
                </div>
                <div class="container-top-right" id="commodityMsg" v-if="commodityDetail">
                    <div class="container-title">
                        {{ commodityDetail.productName }}
                    </div>
                    <div class="container-subtitle" :title="`${commodityDetail.productTitle}查看`">
                        <p class="subtitle-text">
                            {{ commodityDetail.productDetail }}<span>查看> </span>
                        </p>
                    </div>
                    <div class="container-body">
                        <div class="container-body-title">
                            <div class="title-text">
                                <i></i>
                                <span>叩丁秒杀</span>
                            </div>
                            <div class="title-time">
                                <span class="last-time-text">{{curTime==commodityDetail.time?'距离结束':curTime>commodityDetail.time?`已结束`:'距开始'}}</span>
                                <div class="current-last-time">
                                    <span>{{commodityDetail.time<curTime?'00':h}}</span> ： <span>{{commodityDetail.time<curTime?'00':m}}</span> ： <span>{{commodityDetail.time<curTime?'00':s}}</span>
                                </div>
                            </div>
                        </div>
                        <div class="container-body-content">
                            <div class="container-body-summany">
                                <label class="container-label">秒 杀 价</label>
                                <div class="container-content price-content">
                                    <div class="container-content-left">
                                        <h2 class="price"><span>￥</span>
                                            {{ commodityDetail.time==curTime?commodityDetail.seckillPrice:commodityDetail.productPrice }} / {{ commodityDetail.integral }}积分
                                        </h2>
                                        <span class="delOldNum" v-show="commodityDetail.time==curTime">[<del>￥{{ commodityDetail.productPrice }}</del>]</span>
                                        <span class="tipMsg">降价通知</span>
                                    </div>
                                    <div class="container-number">
                                        <p class="number-cur">累计评价<a class="number-value"> 500+</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="container-body-summany">
                                <label class="container-label">秒杀进度</label>
                                <div class="container-content">
                                    <span class="priceProgress"><i class="progressNum"
                                            :style="{ width: `${(commodityDetail.stockCount - commodityDetail.currentCount) * 100 / commodityDetail.stockCount}px` }"></i></span>
                                    <span class="progressText">{{ (commodityDetail.stockCount -
                                        commodityDetail.currentCount) * 100
                                        / commodityDetail.stockCount }}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container-main">
                        <div class="container-blank">
                            <div class="blank-top">
                                <button class="btn" @click="buyBtnClick">立即抢购</button>
                            </div>
                            <div class="blank-text">
                                温馨提示 ·不支持7天无理由退货</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-bottom">
                <ul class="container-ul">
                    <li class="trigger trigger-active">商品介绍</li>
                    <li class="trigger">规格与包装</li>
                    <li class="trigger">质检报告</li>
                    <li class="trigger">售后保障</li>
                    <li class="trigger">商品评价<s>(500+)</s></li>
                    <li class="trigger">本店好评商品</li>
                </ul>
                <div class="container-commodity-message">
                    <p class="commodity-name">品牌： <span>六桂福（LUK KWAI FOOK）</span></p>
                    <ul class="commodity-bottom-ul">
                        <li class="commodity-bottom-li">
                            <span class="li-label">商品名称： </span>
                            <p class="li-text"> 六桂福黄金项链</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">商品编号： </span>
                            <p class="li-text"> 100007432825</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">商品毛重： </span>
                            <p class="li-text"> 150.00g</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">商品产地： </span>
                            <p class="li-text"> 中国大陆</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">适用人群： </span>
                            <p class="li-text"> 女</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">款式： </span>
                            <p class="li-text"> 其他</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">克重： </span>
                            <p class="li-text"> 2.1-5克</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">用途： </span>
                            <p class="li-text"> 自戴，婚庆，馈赠，生日礼物</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">规格： </span>
                            <p class="li-text"> 42cm</p>
                        </li>
                        <li class="commodity-bottom-li">
                            <span class="li-label">上市时间： </span>
                            <p class="li-text"> 往季</p>
                        </li>
                    </ul>
                </div>
                <div class="commodity-image-array">
                    <img src="../../../assets/images/mall/details-img1.jpg" alt="">
                    <img src="../../../assets/images/mall/details-img2.jpg" alt="">
                    <img src="../../../assets/images/mall/fdetails-img3.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { log } from 'console';
import { ElMessage } from 'element-plus';
import { getCommodityDetail,setOrderDoSeckill } from '~~/composables/api/mall';
import {initTimes} from '~~/composables/globalmethods'
import createSocket  from '~~/utils/socket';
definePageMeta({
    layout: 'mall'
});

const commodityImgs = ref([
    // { id: 'cimg01', imgurl: 'http://www.wolfcode.cn//upload/images/product_images/20200629/14580253-f2c9-469b-a27e-9ebda835ad39.png' },
    // { id: 'cimg02', imgurl: 'http://www.wolfcode.cn//upload/images/product_images/20200629/44cb466a-1190-4b7f-92ad-31c0ace3dfd6.png' },
    // { id: 'cimg03', imgurl: 'http://www.wolfcode.cn//upload/images/product_images/20200629/44cb466a-1190-4b7f-92ad-31c0ace3dfd6.png' },
    // { id: 'cimg04', imgurl: 'http://www.wolfcode.cn//upload/images/product_images/20200629/ece60fae-0f71-4659-a2c4-996145df8c97.png' }
]);
const curImgIndex = ref(0);
const commodityDetail = ref(null);
const route = useRoute();
const curTime=ref();

const h=ref('0');
const m=ref('0');
const s=ref('0');
let timer;

function switchCommodityImg(i) {
    curImgIndex.value = i;
}

function buyBtnClick(){
    setOrderDoSeckill({time:route.query.time,seckillId:route.query.id}).then((res)=>{
        console.log(res);
        const token=localStorage.getItem('token');
        if(res.code==200&&token){
            ElMessage.success(res.data);

            createSocket(token);
        }
        
    }).catch((err)=>{
        console.log(err);
        if(err.code==500202){
            ElMessage.error(err.msg);
        }else if(err.code==-1){
            ElMessage.error('抢购失败，非当前场次');
        }
    })
}

function setEndTime(time){
   
    timer=setInterval(()=>{

        const curTimeArr=initTimes(time+2);
        h.value=curTime.value==commodityDetail.value.time?curTimeArr[0]:'0'+(curTimeArr[0]-2);
        m.value=curTimeArr[1];
        s.value=curTimeArr[2];

        if(h.value=='00'&&m.value=='00'&&s.value=='00'){
            clearInterval(timer);
        }
    },1000);
}

onMounted(() => {
    nextTick(() => {  
        curTime.value=route.query.curTime; 
        console.log(route.query.time);
             
        getCommodityDetail({ time: route.query.time, seckillId: route.query.id }).then((res) => {
           console.log(res);
            commodityDetail.value = res.data;
           // console.log(res);
            
            setEndTime(res.data.time);
            for (let i = 0; i < 4; i++) {
                commodityImgs.value.push({
                    id: 'cimg01', imgurl: res.data.productImg
                })
            }
        })
    })
})

</script>

<style scoped>
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

.seckill-ul {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 0;
}

.seckill-li {
    margin-right: 20px;
}

.seckill-li label,
.seckill-li span {
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
    background-image: url(../image/logo.png);
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
    background-image: url(../image/search.png);
    background-size: 17px 17px;
    background-position: center;
    background-repeat: no-repeat;
    cursor: pointer;
    border-radius: 0px 20px 20px 0px;
}

.seckill-classify {
    width: 100%;
    padding-top: 20px;
    box-sizing: border-box;
    background: #fff;
    border-bottom: 2px solid #e01222;
    transition: all 1s ease;
}

.seckill-classify-active {
    position: fixed;
    left: 0;
    top: 0;
    z-index: 9;
    transition: all 1s ease;
}

.commodityDetails-container {
    width: 1200px;
    margin: 0 auto;
    padding: 15px 0;
    box-sizing: border-box;
}

.container-top {
    display: flex;
    flex-direction: row;
    align-items: flex-start;
}


.currentImg {
    width: 350px;
    height: 350px;
    overflow: hidden;
}

.big-img-data {
    width: 100%;
    display: block;
}

.commodity-ul {
    padding-top: 21px;
    box-sizing: border-box;
    display: flex;
    align-items: center;
}

.commodity-li {
    margin-right: 10px;
    width: 80px;
    height: 80px;
    cursor: pointer;
    background-color: #efefef;
    opacity: 0.4;
}

.commodity-li-active {
    opacity: 1;
}

.commodity-li img {
    width: 100%;
    display: block;
}

.container-top-right {
    padding: 0 15px;
    box-sizing: border-box;
    width: 590px;
}

.container-title {
    font-size: 20px;
    color: #666;
    font-weight: bold;
}

.container-subtitle {
    padding: 10px 0;
    box-sizing: border-box;
}

.subtitle-text {
    font-size: 12px;
    color: red;
}

.subtitle-text span {
    color: #5e69ad;
    text-decoration: underline;
}

.container-body {}

.container-body-title {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    padding: 5px 10px;
    box-sizing: border-box;
    background: #fe0851;
}

.title-text {
    display: flex;
    flex-direction: row;
    align-items: center;
    font-size: 14px;
    color: #fff;
    text-align: left;
}

.title-text i {
    background-image: url(../../assets/images/mall/sprite.png);
    background-position: -20px 0;
    width: 20px;
    height: 20px;
    margin-right: 5px;

}

.title-time {
    flex: 1;
    color: #fff;
    font-size: 12px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-end;
}

.current-last-time {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.current-last-time span {
    width: 25px;
    height: 25px;
    border-radius: 3px;
    background: #333;
    font-size: 12px;
    color: #fff;
    line-height: 25px;
    text-align: center;
}

.last-time-text {
    padding-right: 10px;
    box-sizing: border-box;
}

.container-body-content {
    padding: 10px;
    box-sizing: border-box;
    background: #efefef;
    background-image: url("../../assets/images/mall/price-bg.png");
    background-position: left top;

}

.container-body-summany {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.container-label {
    line-height: 22px;
    font-size: 14px;
    font-family: simsun;
    color: #999;
    width: 60px;
    text-align: left;
}

.price-content {
    flex: 1;
    display: flex;
    flex-direction: row;
    align-items: center;
}

.container-content {
    padding-left: 15px;
    box-sizing: border-box;
    flex: 1;
}

.container-content-left {
    flex: 1;
    display: flex;
    flex-direction: row;
    align-items: center;
    /*padding-left:15px;*/
    /*box-sizing: border-box;*/
}

.price {
    font-size: 22px;
    color: #e4393c;
}

.price span {
    font-size: 12px;
    padding-right: 10px;
    box-sizing: border-box;
}

.delOldNum {
    font-size: 12px;
    color: #999;
    padding-left: 10px;
    box-sizing: border-box;
}

.tipMsg {
    font-size: 12px;
    color: #005aa0;
}

.container-number {
    padding: 0 15px;
    box-sizing: border-box;
    border-left: 1px solid #ececec;
}

.number-cur {
    color: #999;
    font-size: 14px;
}

.number-value {
    font-size: 14px;
    color: #005ea7;
}

.btn {
    height: 46px;
    line-height: 46px;
    padding: 0 26px;
    font-size: 18px;
    font-family: "microsoft yahei";
    font-weight: bold;
    color: #fff;
    cursor: pointer;
    background: #df3033;
    outline: none;
    border: 0;
}

.blank-text {
    color: #999;
    font-size: 12px;
    padding: 15px 0;
    box-sizing: border-box;
}

/* 详情底部信息 */
.container-bottom {
    width: 1200px;
    margin: 0 auto;
    padding: 15px 0;
    box-sizing: border-box;
}

.container-ul {
    display: flex;
    width: 100%;
    background: #efefef;
    flex-direction: row;
    align-items: center;
    border: 1px solid #eee;
    border-bottom: 1px solid #e4393c;
}

.trigger {
    padding: 10px 25px;
    font-size: 14px;
    color: #666;
    cursor: pointer;
}

.trigger:hover {
    color: red;
}

.trigger-active:hover {
    color: #fff;
}

.container-commodity-message {
    padding: 20px 30px;
    box-sizing: border-box;
    border-bottom: 1px solid #ddd;
}

.commodity-name {
    font-size: 12px;
    color: #666;
}

.commodity-name span {
    font-size: 12px;
    color: #5e69ad;
}

.trigger-active {
    background: red;
    color: #fff;
}

.commodity-bottom-ul {
    padding: 20px 0 0;
    box-sizing: border-box;
}

.commodity-bottom-li {
    display: inline-block;
    vertical-align: middle;
    width: 200px;
    /* padding-left: 45px; */
    padding-bottom: 10px;
    box-sizing: border-box;
}

.commodity-bottom-li .li-label,
.commodity-bottom-li .li-text {
    font-size: 12px;
    color: #666;
    display: inline-block;
}

.commodity-image-array {
    padding: 15px 0;
    box-sizing: border-box;
    text-align: center;
}

.container-blank {
    padding: 20px 0;
    box-sizing: border-box;
}

.priceProgress {
    width: 300px;
    height: 8px;
    border-radius: 10px;
    background: #ddd;
    display: inline-block;
}

.progressNum {
    background: red;
    width: 60%;
    display: block;
    height: 8px;
    border-radius: inherit;
}

.progressText {
    padding-left: 10px;
    box-sizing: border-box;
    color: red;
    font-size: 12px;
    display: inline-block;
}

/*  登录页状态  */
.userLogin {
    display: none;
}
</style>