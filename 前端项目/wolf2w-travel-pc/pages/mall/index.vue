<template>
    <div class="seckill-body">
        <div class="seckill-content" :style="{paddingTop:isFixed?'95px':0}">
            <div :class="`seckill-classify ${isFixed?'seckill-classify-fixed':''}`">
                <div class="seckill-list">
                    <div class="seckill-menu">
                        <span class="seckill-menu-text seckill-menu-active">叩丁秒杀</span>
                        <span class="seckill-menu-text">每日特价</span>
                        <span class="seckill-menu-text">大牌闪购</span>
                        <span class="seckill-menu-text">品类秒杀</span>
                    </div>
                </div>
            </div>
            <div class="seckill-container">
                <div class="seckill-bg"></div>
                <div :class="`seckill-tab ${isTabFixed?'seckill-tab-fixed':''}`" id="seckillTab">
                    <div v-for="(item, i) in tabData"
                        :class="`seckill-tab-list ${i === tabIndex ? 'seckill-tab-list-active' : ''}`"
                        :comStatus='item.status' @click="selectTabData(i)">
                        <div :class="`seckill-tab-list-data  ${i === tabIndex ? 'seckill-tab-active' : ''}`">
                            <div class="seckill-time">
                                {{ item.time }}
                            </div>
                            <div class="seckill-change" id="seckillChange">
                                <div class="seckill-tip">
                                    <div v-if="item.status === 1">
                                        <div v-if="i === tabIndex">
                                            <p class="tip-text">{{ item.tipText }}</p>
                                            <p class="tip-time">
                                                <span class="text">{{ item.text }}</span>
                                                <span class="timeArray">{{ item.hourse }}：{{ item.miute }}：{{ item.sen
                                                }}</span>
                                            </p>
                                        </div>
                                        <button v-else type="button" class="startBtn">{{ item.tipText }}</button>
                                    </div>
                                    <div v-else-if="item.status === 0">
                                        <div v-if="i === tabIndex">
                                            <p class="tip-text">{{ item.tipText }}</p>
                                            <p class="tip-time">
                                                <span class="text">{{ item.text }}</span>
                                                <span class="timeArray">{{ item.hourse }}：{{ item.miute }}：{{ item.sen
                                                }}</span>
                                            </p>
                                        </div>
                                        <button v-else type="button" class="startBtn">{{ item.tipText }}</button>
                                    </div>

                                    <div v-else>
                                        <button type="button" class="startBtn">已结束</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="seckill-commodity" :style="{paddingTop:isTabFixed?'68px':0}">
                    <ul class="flow-default current-list" id="currentCommodity">
                        <li class="commodity-data" v-for="(item, i) in commodityList">
                            <div class="commodity-data-flex">
                                <div class="commodityImg">
                                    <img :src="item.productImg" class="moreGood-img">
                                </div>
                                <div class="textParent">
                                    <p class="commodity-text">
                                        {{ item.productTitle }}
                                    </p>
                                    <div class="seckill-tag">
                                        <p class="seckill-tag-text">
                                            {{ item.productDetail }}
                                        </p>
                                    </div>
                                </div>
                                <div class="seckill-operation">
                                    <div class="seckill-good-cur">
                                        <div class="seckill-money-num">
                                            <div class="seckill-money-status">
                                                <h2 class="seckill-number"><span class="seckill-num">￥</span>
                                                    {{ item.seckillPrice }}
                                                </h2>
                                                <span class="old-number">￥<del>
                                                        {{ item.productPrice }}
                                                    </del></span>
                                            </div>
                                            <div class="seckill-shop-number">
                                                <div class="seckill-start-status">
                                                    <span class="comeback-num">已售{{ item.currentCount *
                                                        100
                                                        / item.stockCount }}</span>
                                                    <div class="shop-number-status"><i class="current-progress"
                                                            :style="{ width: item.currentCount * 100 / item.stockCount }"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- :to="{path:``,query:{id:item.id,time:item.time}}" -->
                                        <a v-if="item.time==curTime" href="javascript:;" class="operation-button" @click="seckillBtnClick(item,'立即抢购')">立即抢购</a>
                                        <a v-else-if="item.time<curTime" href="javascript:;" class="operation-button end-btn" @click="seckillBtnClick(item,'已结束')">已结束</a>
                                        <a v-else href="javascript:;" class="operation-button end-btn" @click="seckillBtnClick(item,'即将开始')">即将开始</a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ElMessage } from 'element-plus';
// import { fa } from 'element-plus/es/locale';
// import { flatHooks } from 'hookable';
import { getCurrentSeckillList } from '~~/composables/api/mall';

definePageMeta({
    layout: 'mall'
});

let timeStart;
let currentSet;
let times = []
const timeArray = [10, 12, 14]
const tabData = reactive([{
    time: timeArray[0] + ':00', // 当前时间
    val: timeArray[0],
    hourse: '00',
    miute: '00',
    sen: '00',
    status: 1, // 状态1为秒杀活动已开始
    tipText: '',
    text: '',
    comstatus: 0
}, {
    time: timeArray[1] + ':00', // 当前时间
    val: timeArray[1],
    hourse: '00',
    miute: '00',
    sen: '00',
    status: 0, // 状态1为秒杀活动已开始
    tipText: '',
    text: '',
    comstatus: 0
}, {
    time: timeArray[2] + ':00', // 当前时间
    val: timeArray[2],
    hourse: '00',
    miute: '00',
    sen: '00',
    status: 0, // 状态1为秒杀活动已开始
    tipText: '',
    text: '',
    comstatus: 0
}]);

const tabIndex = ref(0);

const commodityList = ref([]);
const curTime=ref(10);

const userInfo = ref(null);
const isFixed=ref(false);
const isTabFixed=ref(false);
//初始化tab面板
function initTab() {
    timeStart = setInterval(() => {
        let endCount=0;
        //遍历tab数据
        for (var i = 0; i < tabData.length; i++) {

            if (initTimes(timeArray[i]).length > 0) {
                tabData[i].hourse = initTimes(timeArray[i])[0]
                tabData[i].miute = initTimes(timeArray[i])[1]
                tabData[i].sen = initTimes(timeArray[i])[2]
                tabData[i].tipText = '即将开始'
                tabData[i].text = '距开始'
                tabData[i].comstatus = 0

            } else { // 如果大于当前时间则数据为空 提示活动已结束 
                //console.log(initTimes(16));
                const curTimeArr = initTimes(timeArray[i + 1]).length > 0 ? initTimes(timeArray[i + 1]) : (i == timeArray.length - 1) ? initTimes(16) : [];
                if (curTimeArr.length > 0) {
                    tabData[i].tipText = '正在秒杀'
                    tabData[i].text = '距结束'
                    tabData[i].comstatus = 1
                    tabData[i].hourse = curTimeArr[0];
                    tabData[i].miute = curTimeArr[1];
                    tabData[i].sen = curTimeArr[2];
                    if (curTimeArr[0] == '00' && curTimeArr[1] == '00' && curTimeArr[2] == '00') {
                        tabIndex.value = ++tabIndex.value;
                        curTime.value=tabIndex.value==timeArray.length?timeArray[tabIndex.value]+2:timeArray[tabIndex.value];
                        if(tabIndex.value<timeArray.length){
                            getSeckillData(timeArray[tabIndex.value]);
                        }else{
                            clearInterval(timeStart);
                        }
                    }

                } else {
                    tabData[i].tipText = '已结束'
                    tabData[i].text = ''
                    tabData[i].comstatus = 2    
                    
                    endCount++;
                    //console.log('endCount:'+endCount);
                    if(endCount==timeArray.length){
                        curTime.value=timeArray[timeArray.length-1]+2;
                        clearInterval(timeStart);
                    }
                    
                }
            }
        }
    }, 1000)

    initCurrentActive();
    // getUserInfo();
}

// 时间倒计时处理函数
function initTimes(houres) {
    var currentData = new Date().setHours(houres, 0, 0, 0);
    var curTime = new Date();
    var residue = currentData - curTime
    if (residue > 0) { // 如果当前时间为还未开始则进行回填至计算
        var hs = parseInt(residue / 1000 / 60 / 60 % 24)
        var ms = parseInt(residue / 1000 / 60 % 60)
        var ss = parseInt(residue / 1000 % 60)
        var h = hs < 10 && hs >= 0 ? ('0' + hs) : hs
        var m = ms < 10 && ms >= 0 ? ('0' + ms) : ms
        var s = ss < 10 && ss >= 0 ? ('0' + ss) : ss
        times = [h, m, s]
    } else { // 活动时间已经过去结束的进行中文提示活动结束
        times = []
    }
    return times
}

function selectTabData(i) {
    console.log('当前场次：'+timeArray[tabIndex.value]);
    tabIndex.value = i;
    getSeckillData(timeArray[tabIndex.value]);
}
//
function initCurrentActive() {
    const date = new Date();
    const h = date.getHours();
    for (let i = 0; i < timeArray.length; i++) {
        if (timeArray[i + 1]) {
            if (h >= timeArray[i] && h < timeArray[i + 1]) {
                tabIndex.value = i;
                break;
            }
        } else {
            if (h >= timeArray[i]) {
                tabIndex.value = i;
                break;
            }
        }

    }
}

const test=ref([]);

function getSeckillData(curTime) {
    
    getCurrentSeckillList({ time: curTime }).then((res) => {
        // console.log(res);
        //commodityList.value=res.data;
        commodityList.value=res.data;
    })
}

function seckillBtnClick(item,infoStr){
    //`/mall/commoditydetail?id=${item.id}&time=${item.time}&curTime=${curTime}`
    if(infoStr=='已结束'){
        ElMessage.warning('秒杀已结束，请到其它场次！');
    }else if(infoStr=='即将开始'){
        ElMessage.warning('秒杀未开始，请稍候！');
    }else{
        // console.log(item);
        navigateTo({
            path:'/mall/commoditydetail',
            query:{
                id:item.id,
                time:item.time,
                curTime:curTime.value
            }
        });
    }
}

function scorllControl(){
    let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
    //console.log(scrollTop);
    if(scrollTop>=60){
        isFixed.value=true;
    }else{
        isFixed.value=false;
    }

    if(scrollTop>=160){
        isTabFixed.value=true;
    }else{
        isTabFixed.value=false;
    }
}

onMounted(() => {
    initTab();
    setTimeout(() => {
        getSeckillData(timeArray[tabIndex.value]);

        const h=new Date().getHours();
        curTime.value=h>=10&&h<16?timeArray[tabIndex.value]:h;
    }, 20);

    window.addEventListener('scroll',scorllControl);
});

onUnmounted(()=>{
    window.removeEventListener('scroll',scorllControl);
})
</script>

<style scoped>
.seckill-classify {
    width: 100%;
    padding-top: 20px;
    box-sizing: border-box;
    background: #fff;
    border-bottom: 2px solid #e01222;
    transition: all 1s ease;
}

.seckill-classify-fixed{
    position: fixed;
    top: 0;
    z-index: 999;

}
.seckill-classify-active {
    position: fixed;
    left: 0;
    top: 0;
    z-index: 9;
    transition: all 1s ease;
}

.seckill-classify-active {
    position: fixed;
    left: 0;
    top: 0;
    z-index: 9;
    transition: all 1s ease;
}

.seckill-list {
    height: 44px;
    width: 1200px;
    margin: 0 auto;
}

.seckill-menu {
    width: 100%;
    display: flex;
    flex-direction: row;
}

.seckill-menu-text {
    /*float: left;*/
    font-size: 20px;
    line-height: 44px;
    padding: 0 12px;
    color: #333;
    font-weight: 700;
}

.seckill-menu-active {
    color: #fff;
    background: #e01222;
}

/* 列表内容样式 */
.seckill-content {
    background: rgba(246, 246, 246, 1);
}

.seckill-container {
    width: 100%;
    background-image: url("../../assets/images/mall/bg.png");
    background-size: 1516px 274px;
    background-position: center top;
    padding-top: 90px;
    box-sizing: border-box;
    background-repeat: no-repeat;
    position: relative;
}

.seckill-bg {
    width: 556px;
    height: 65px;
    background-position: center;
    background-size: 556px 65px;
    position: absolute;
    left: 50%;
    margin-left: -278px;
    top: 20px;
    background-image: url("../../assets/images/mall/header_textV2.png");
}

.seckill-tab {
    width: 1200px;
    height: 60px;
    /* padding: 0 60px; */
    /* box-sizing: border-box; */
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    /* transition: all ease 1.5s; */
}

.seckill-tab-fixed{
    position: fixed;
    top: 65px;
    left: 50%;
    z-index: 999;
    transform: translateX(-50%);
}
.seckill-tab-array-active {
    position: fixed;
    left: 50%;
    margin-left: -600px;
    top: 66px;
    z-index: 9;
}

.seckill-tab-list {
    /*width: 320px;*/
    flex: 1;
    /*margin-left:-60px;*/
    cursor: pointer;
    /*padding:0 60px;*/
    /*box-sizing: border-box;*/
    /*background:#fff;*/
    position: relative;
    padding: 0 5px 0 0;
    box-sizing: border-box;
}

.seckill-tab-list:last-child {
    padding: 0;
}

.seckill-tab-list-data {
    width: 100%;
    /*padding:11px 0;*/
    /*margin:0 60px;*/
    height: 60px;
    justify-content: center;
    box-sizing: border-box;
    display: flex;
    flex-direction: row;
    align-items: center;
    /*position: relative;*/
    background: #fff;
}

/*.seckill-tab-list:before {*/
/*display: block;*/
/*content: "";*/
/*width: 0;*/
/*height: 0;*/
/*border-style: solid;*/
/*border-width: 0 0 60px 60px;*/
/*border-color: transparent transparent #fff;*/
/*position: absolute;*/
/*left: 0;*/
/*top: 0;*/
/*zoom: 1;*/
/*}*/
/*.seckill-tab-list:after {*/
/*display: block;*/
/*content: "";*/
/*width: 0;*/
/*height: 0;*/
/*border-style: solid;*/
/*border-width: 60px 60px 0 0;*/
/*border-color: #fff transparent transparent;*/
/*position: absolute;*/
/*right: 0;*/
/*top: 0;*/
/*zoom: 1;*/
/*}*/
/*.seckill-tab-list-active:before {*/
/*border-color: transparent transparent red;*/
/*}*/
/*.seckill-tab-list-active:after {*/
/*border-color: red transparent transparent;*/
/*}*/
.seckill-tab-active {
    background: #e01222;
    /*margin: 0 60px;*/
}

.seckill-tab-active .seckill-time {
    color: #fff;
    font-size: 20px;
}

.seckill-time {
    font-weight: bold;
    font-size: 14px;
    color: #000;
}

.seckill-tip {
    padding-left: 10px;
    box-sizing: border-box;
}

.tip-text,
.tip-time {
    font-size: 14px;
    color: #fff;
}

.tip-time-1 {
    font-size: 14px;
    color: #666;
}

.startBtn {
    border: 1px solid #666;
    padding: 0 14px;
    vertical-align: middle;
    height: 26px;
    line-height: 25px;
    color: #666;
    -moz-border-radius: 22px;
    border-radius: 22px;
    font-size: 12px;
    background: #fff;
    display: inline-block;
}

.seckill-commodity {
    width: 1200px;
    margin: 0 auto;
}

/*  列表样式  */
.current-list {
    zoom: 1;
    font-size: 0;
}

.commodity-data {
    width: 292px;
    margin-top: 10px;
    /* padding-bottom: 32px; */
    /* box-sizing: border-box; */
    position: relative;
    /* float: left; */
    /* display: flex; */
    /* flex-direction: column; */
    /* justify-content: center; */
    /* align-items: center; */
    display: inline-block;
    /* padding-right: 16px; */
    /* box-sizing: border-box; */
    /* background: #fff; */
    margin-right: 10px;
    cursor: pointer;
    transition: all .8s ease;
}

.commodity-data:nth-of-type(4n) {
    margin-right: 0;
}

.commodity-data-flex {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    /* align-items: center; */
    width: 284px;
    height: 440px;
    padding-bottom: 10px;
    box-sizing: border-box;
    background: #fff;
}

.commodityImg {
    position: relative;
    width: 100%;
    height: 270px;
    display: flex;
    flex-direction: column;
    -webkit-print-color-adjust: exact;
    justify-content: center;
}

.commodity-data-flex .moreGood-img {
    width: auto;
    height: 200px;
    margin: 0 auto;
    display: block;
    transition: all ease .8s;
}

.commodity-data-flex .moreGood-img:hover {
    transform: translateY(-20px);
}

.textParent {
    /*height: 88px;*/
    /*display: flex;*/
    /*flex-direction: row;*/
    /*align-items: center;*/
    padding: 0 15px 10px;
    box-sizing: border-box;
    border-bottom: 1px solid #ececec;
}

.commodity-text {
    font-size: 14px;
    font-weight: normal;
    font-stretch: normal;
    line-height: 23px;
    height: 46px;
    letter-spacing: 0px;
    color: #333333;
    margin: 10px 0 8px;
    box-sizing: border-box;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    line-clamp: 2;
    -webkit-box-orient: vertical;
}

.seckill-tag {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.seckill-tag-text {
    font-size: 14px;
    height: 21px;
    line-height: 21px;
    color: #e01222;
    text-align: left;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    padding-left: 5px;
    box-sizing: border-box;
}

.seckill-operation {
    padding: 10px 0 10px 15px;
    box-sizing: border-box;
    height: 91px;
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
}

.operation-tip {
    padding: 0 8px;
    height: 16px;
    line-height: 16px;
    background-color: #e6e6e6;
    font-size: 10px;
    color: #999;
    -moz-border-radius: 2px;
    border-radius: 2px;
    width: fit-content;
}

.seckill-good-cur {
    display: flex;
    flex-direction: row;
    align-items: center;
    padding-top: 10px;
    box-sizing: border-box;
}

.seckill-money-num {
    flex: 1;
}

.seckill-money-status {}

.seckill-number {
    font-size: 24px;
    color: #e01222;
    font-family: arial;
    margin-right: 2px;
    line-height: 1;
    display: inline-block;
    min-width: 50px;
}

.seckill-num {
    font-size: 14px;
}

.old-number {
    font-size: 12px;
    color: #999;
}

.seckill-shop-number {
    display: block;
    margin-top: 5px;
}

.comeback-num {
    font-size: 12px;
    color: #999;
}

.shop-number-status {
    width: 88px;
    height: 8px;
    background: #e6e6e6;
    display: inline-block;
    position: relative;
    overflow: hidden;
    margin-left: 5px;
    -moz-border-radius: 8px;
    border-radius: 8px;
}

.current-progress {
    background: #df0021;
    position: absolute;
    left: 0;
    top: 0;
    height: 8px;
    -moz-border-radius: 8px 0 0 8px;
    border-radius: 8px 0 0 8px;
}

.operation-button {
    color: #fff;
    height: 40px;
    line-height: 40px;
    font-size: 16px;
    display: block;
    margin: auto 0;
    width: 80px;
    text-align: center;
    background: #df0021;
    cursor: pointer;
}

.operation-button:hover,
.operation-button:focus {
    color: #fff;
}

.end-btn{
    background-color: #333333;
}

.operation-await-button {
    background: #333;
}

.await-text {
    color: #999;
    font-size: 12px;
}

/*  登录页状态  */
.userLogin {
    display: none;
    transition: all ease 1s;
}
</style>