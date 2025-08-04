<template>
    <!--  我的订单列表  -->
    <div class="order">
        <div class="paymentPage-body">
            <div class="paymentPage-content" id="orderListData" v-if="orderData">
                <div class="paymentPage-prices">
                    <div class="price-image"><img :src="orderData.productImg" width="80" height="100" alt=""></div>
                    <div class="price-data">
                        <div class="price-title">
                            <h2>
                                {{ orderData.productName }}
                            </h2>
                        </div>
                        <div class="price-num"><span>￥</span>
                            {{ orderData.seckillPrice }}/
                        </div>
                        <div class="price-num"> {{ orderData.integral }}<span>积分</span>
                        </div>
                    </div>
                </div>
                <div class="paymentPage-buy-message">
                    <div class="buy-message-content" v-if="orderData">
                        <div class="buy-message-title">
                            <label>下单时间</label>
                            <span>{{ orderData.createDate }}</span>
                        </div>
                        <div class="buy-message-title">
                            <label>订单状态</label>
                            <span v-if="orderData.status === 0">未付款</span>
                            <span v-else-if="orderData.status === 1">已付款</span>
                            <span v-else-if="orderData.status === 2">手动取消订单</span>
                            <span v-else-if="orderData.status === 3">超时取消订单</span>
                            <span v-else-if="orderData.status === 4">已退款</span>
                        </div>
                        <div v-if="orderData.status === 1 || orderData.status === 4" class="buy-message-title">
                            <label>支付类型</label>
                            <span v-if="orderData.payType === 0">在线支付</span>
                            <span v-else>积分支付</span>
                        </div>
                        <div class="buy-message-title">
                            <label>收货人</label>
                            <span>叩丁狼</span>
                        </div>
                        <div class="buy-message-title">
                            <label>收货地址</label>
                            <span>广州市棠下天河区叩丁狼</span>
                        </div>
                    </div>
                </div>
                <div v-if="orderData.status === 0" class="paymentPage-select">
                    <p class="select-title">选择支付方式</p>
                    <div class="message-wxStyle" v-for="(item, i) in payTypeList" :key="item.id">
                        <p class="select-name">{{ item.payText }}</p>
                        <div :class="`checkBtn ${i == payTypeIndex ? 'checkBtnActive' : ''}`" value="0"
                            @click="changePayType(i)">
                            <div class="checkBtnRadios" :style="{ display: i == payTypeIndex ? 'block' : '' }"></div>
                        </div>
                    </div>

                </div>
                <div class="message-btn-array" v-if="orderData.status === 0">
                    <div class="message-select-btn"><span class="btn-text" @click="startPayMent">立即支付</span></div>
                    <div class="message-select-btn message-delete-btn"><span class="btn-text">取消订单</span></div>
                </div>
                <div v-if="orderData.status === 1" class="btn-box">
                    <div  class="message-select-btn message-delete-btn">
                        <span class="btn-text" @click="orderRefoundBtn">申请退款</span>
                    </div>

                    <div  class="message-select-btn message-delete-btn btn-order-list">
                        <a href="/mall/order/orderlist" class="btn-text">我的订单</a>
                    </div>
                </div>


                
            </div>
        </div>
        <div id="pay" v-if="payHtml" v-html="payHtml"></div>
    </div>
</template>

<script lang="ts" setup>
import { ElMessage } from 'element-plus';
import { getOrderDetail, setOrderIntegralPay, setOrderRefund } from '~~/composables/api/mall';

definePageMeta({
    layout: 'mall'
});

const payTypeList = [
    { id: 'pay001', payText: '在线支付' },
    { id: 'pay002', payText: '积分支付' }
]
const payTypeIndex = ref(0);
const router = useRouter();

const orderData = ref(null);
const payHtml = ref(null);
function getOrderList() {
    const route = useRoute();
    getOrderDetail({ orderNo: route.query['out_trade_no'] }).then((res) => {
       // console.log(res);
        if (res.code == 200) {
            orderData.value = res.data;
        }
    })
}

function changePayType(i) {
    payTypeIndex.value = i;


}

function startPayMent() {
    console.log(orderData.value.orderNo);

    setOrderIntegralPay({
        orderNo: orderData.value.orderNo,
        type: payTypeIndex.value
    }).then((res) => {
        if (res.code == 200) {
            if (payTypeIndex.value == 0) {
                console.log(res);
                payHtml.value = res.data;
                setTimeout(() => {
                    console.log(document.forms[0]);
                    document.forms[0].submit();
                }, 100)

            } else if (payTypeIndex.value == 1) {
                getOrderList();
            }
        }
    })

}

function orderRefoundBtn() {
    setOrderRefund(orderData.value.orderNo).then((res) => {
        if (res.code == 200) {
            ElMessage.success('支付成功！！');
            getOrderList();
        }
    })
}

onMounted(() => {
    setTimeout(() => {
        getOrderList();
    }, 20);
})
</script>

<style scoped>
.paymentPage-body {
    background: #fff;
    margin: 20px auto;
    width: 1200px;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    overflow: hidden;
    position: relative;
    padding-bottom: 20px;
    box-sizing: border-box;
}

.paymentPage-content {
    width: 100%;
    flex: 1;
    background: #fff;
    overflow-y: auto;
}

.paymentPage-body img {
    width: 100%;
    display: block;
}

.paymentPage-prices {
    width: 100%;
    height: 300px;
    padding: 15px;
    box-sizing: border-box;
    background-color: #ffffff;
    display: flex;
    flex-direction: row;
    align-items: center;
}

.price-image {
    width: auto;
    height: 250px;
    display: block;
}

.price-data {
    padding-left: 48px;
    padding-right: 48px;
    box-sizing: border-box;
}

.price-title h2 {
    font-family: SourceHanSansSC-Medium;
    font-size: 24px;
    font-weight: bold;
    font-stretch: normal;
    line-height: 30px;
    letter-spacing: 1px;
    color: #333333;
}

.price-num {
    font-family: Arial-BoldMT;
    font-size: 34px;
    font-weight: bold;
    color: #efc126;
    line-height: 35px;
    padding-top: 100px;
    display: inline-block;
    vertical-align: middle;
}

.price-num span {
    font-family: SourceHanSansSC-Bold;
    font-size: 24px;
    font-weight: normal;
    font-stretch: normal;
    letter-spacing: 1px;
    color: #efc126;
}

.paymentPage-buy-message {
    padding: 10px 0;
    background: #f0f0f0;
    box-sizing: border-box;
}

.buy-message-content {
    padding: 15px;
    box-sizing: border-box;
    background: #fff;
}

.buy-message-title {
    padding-bottom: 15px;
    box-sizing: border-box;
}

.buy-message-title label {
    width: 120px;
    color: #999;
    font-size: 14px;
    padding-right: 10px;
    box-sizing: border-box;
}

.buy-message-title span {
    color: #666;
    font-size: 14px;
}

/*.buy-message-title h2{*/
/*font-family: SourceHanSansCN-Normal;*/
/*font-size: 30px;*/
/*font-weight: normal;*/
/*font-stretch: normal;*/
/*line-height: 45px;*/
/*color: #333333;*/
/*}*/
/*.buy-message-title p{*/
/*font-family: SourceHanSansCN-Normal;*/
/*font-size: 24px;*/
/*font-weight: normal;*/
/*font-stretch: normal;*/
/*line-height: 45px;*/
/*color: #999999;*/
/*}*/
/*.buy-message-data {*/
/*height:77px;*/
/*margin-bottom:22px;*/
/*width:100%;*/
/*border-bottom:1px solid #d4d4d4;*/
/*display: flex;*/
/*flex-direction: row;*/
/*align-items: center;*/
/*}*/
/*.label {*/
/*width:1px;*/
/*font-family: ArialMT;*/
/*font-size: 30px;*/
/*font-weight: normal;*/
/*letter-spacing: 0px;*/
/*color: #333333;*/
/*}*/
/*.buy-input {*/
/*width:100%;*/
/*flex:1;*/
/*padding-left:48px;*/
/*box-sizing: border-box;*/
/*}*/
/*.buy-input input{*/
/*width:100%;*/
/*border:none;*/
/*}*/
/*.buy-input input::placeholder {*/
/*font-family: SourceHanSansCN-Normal;*/
/*font-size: 30px;*/
/*font-weight: normal;*/
/*font-stretch: normal;*/
/*color: #cccccc;*/
/*}*/
.buy-code {
    padding: 10px 20px;
    /* height: .6px; */
    text-align: center;
    /* line-height: .56px; */
    box-sizing: border-box;
    border: 2px solid #d4d4d4;
    border-radius: 15px;
    background: #fff;
    font-size: 30px;
    font-family: SourceHanSansCN-Normal;
    color: #666;
}

.paymentPage-select {
    padding: 15px;
    padding-bottom: 0;
    box-sizing: border-box;
    background: #fff;
}

.select-title {
    font-family: SourceHanSansCN-Normal;
    font-size: 18px;
    font-weight: bold;
    font-stretch: normal;
    line-height: 40px;
    color: #333333;
}

.message-wxStyle {
    padding: 10px 0;
    box-sizing: border-box;
    display: flex;
    flex-direction: row;
    align-items: center;
}

.wx-image {
    width: 70px;
    height: 70px;
    display: block;
}

.select-name {
    flex: 1;
    font-family: SourceHanSansCN-Normal;
    font-size: 16px;
    font-weight: bold;
    font-stretch: normal;
    color: #666;
}

.btn-box{
    display: flex;
    justify-content: center;
}

.message-select-btn {
    width: 200px;
    height: 60px;
    background-image: linear-gradient(0deg, #6717cd 0%, #2646b0 100%), linear-gradient(#efc126, #efc126);
    background-blend-mode: normal, normal;
    border-radius: 10px;
    text-align: center;
    line-height: 60px;
    font-family: SourceHanSansSC-Bold;
    font-size: 22px;
    font-weight: bold;
    font-stretch: normal;
    letter-spacing: 0px;
    color: #ffffff;
    /* margin: 0 auto; */
    cursor: pointer;
}

.message-delete-btn {
    background-image: none;
    background: #999;
    color: #fff;
}

.message-btn-array {
    display: flex;
    align-items: center;
    justify-content: center;
}

.message-btn-array .message-select-btn {
    margin-left: 10px;
    margin-right: 0;
    box-sizing: border-box;
}

.message-delete-btn .btn-text {
    color: #fff;
}

.btn-text {
    font-family: Arial-BoldMT;
    font-size: 24px;
    font-weight: bold;
    color: #efc126;
    padding-right: 15px;
    box-sizing: border-box;
}

.btn-order-list {
    background-color: #efc126;
    margin-left: 20px;
}

/*.btn-text span {*/
/*font-family: SourceHanSansSC-Bold;*/
/*font-size: 24px;*/
/*font-weight: bold;*/
/*font-stretch: normal;*/
/*color: #efc126;*/
/*}*/
/* 单选按钮选择框 */
.checkBtn {
    width: 20px;
    height: 20px;
    border-radius: 50%;
    border: 2px solid #e7e7e7;
    display: block;
    position: relative;
    cursor: pointer;
}

.checkBtnActive {
    border: 2px solid #0a328e;
}

.activeCheckBtn {
    /*border: 0.02px solid #efc126;*/
}

.checkBtnRadios {
    position: absolute;
    background: #0a328e;
    /* background-image: url(../../assets/image/trillPage/select.png); */
    /* background-size: 100% 100%; */
    /* background-repeat: no-repeat; */
    /* background-position: center; */
    left: 10%;
    top: 10%;
    clear: both;
    width: 80%;
    height: 80%;
    border-radius: 50%;
    cursor: pointer;
    display: none;
}

.message-select-active {
    background: #efefef;
    color: #999;
}

.layui-layer-dialog .layui-layer-btn .layui-layer-btn0 {
    border-color: #2646b0;
    background-color: #2646b0;
    color: #fff;
}

/*  登录页状态  */
.userLogin {
    display: none;
}

#pay {
    height: 200px;
}
</style>