<template>
  <div class="v-fpc-index-bg">
    <div class="v-flightpc-container">
      <div class="m-title"><span class="flight-icon"></span><span>国内机票</span></div>
      <div class="index-top">
        <div class="v-com-index-form">
          <div class="radio-trip-type">
            <div class="single-trip">
              <div class="swich-icon"></div>
              <div class="swich-test">单程</div>
            </div>
            <div class="round-trip"><span class="swich-icon radioActive"></span><span class="swich-test">往返</span></div>
          </div>
          <div class="search-city">
            <div class="depCity">
              <div class="city-title">出发城市</div>
              <div class="city">
                <input type="text" placeholder="中文/拼音/简拼" />
                <div style="display: none">
                  <div class="v-com-select-city">
                    <div class="city-select">
                      <div class="history">
                        <div class="history-title">搜索历史：</div>
                        <div class="history-content">上海-北京</div>
                      </div>
                      <!---->
                      <ul class="filter-tabar clearfix">
                        <li class="selectactive">国内热门</li>
                        <li class="">ABCDE</li>
                        <li class="">FGHJ</li>
                        <li class="">KLMNP</li>
                        <li class="">QRSTW</li>
                        <li class="">XYZ</li>
                        <li class="">国际港澳台</li>
                      </ul>
                      <div class="city-content">
                        <ul class="clearfix scope">
                          <!---->
                          <div class="city-group">
                            <li>北京</li>
                            <li>上海</li>
                            <li>广州</li>
                            <li>成都</li>
                            <li>重庆</li>
                            <li>西安</li>
                            <li>昆明</li>
                            <li>深圳</li>
                            <li>杭州</li>
                            <li>厦门</li>
                            <li>长沙</li>
                            <li>海口</li>
                            <li>武汉</li>
                            <li>乌鲁木齐</li>
                            <li>郑州</li>
                            <li>三亚</li>
                            <li>贵阳</li>
                            <li>南京</li>
                            <li>青岛</li>
                            <li>哈尔滨</li>
                          </div>
                        </ul>
                      </div>
                    </div>
                    <div class="city-overlay" style="display: none">
                      <div class="city-container">
                        <div class="pop-ctn">
                          <div class="close-btn"><i></i></div>
                          <div class="pop-title">目前仅手机上支持「国际机票」</div>
                          <div class="pop-text">可打开带TA游旅游APP，或扫码预订</div>
                          <div class="pop-qr"><img width="40%" src="https://p3-q.mafengwo.net/s14/M00/6D/18/wKgE2l0INeCAA09MAAATkxovbeA310.png" /></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="search-content" style="display: none"><ul class="search-list"></ul></div>
                </div>
              </div>
            </div>
            <div class="switch"><span>换</span></div>
            <div class="arrCity">
              <div class="city-title">到达城市</div>
              <div class="city">
                <input type="text" placeholder="中文/拼音/简拼" />
                <div style="display: none">
                  <div class="v-com-select-city">
                    <div class="city-select">
                      <!----><!---->
                      <ul class="filter-tabar clearfix">
                        <li class="selectactive">国内热门</li>
                        <li class="">ABCDE</li>
                        <li class="">FGHJ</li>
                        <li class="">KLMNP</li>
                        <li class="">QRSTW</li>
                        <li class="">XYZ</li>
                        <li class="">国际港澳台</li>
                      </ul>
                      <div class="city-content">
                        <ul class="clearfix scope">
                          <!---->
                          <div class="city-group">
                            <li>北京</li>
                            <li>上海</li>
                            <li>广州</li>
                            <li>成都</li>
                            <li>重庆</li>
                            <li>西安</li>
                            <li>昆明</li>
                            <li>深圳</li>
                            <li>杭州</li>
                            <li>厦门</li>
                            <li>长沙</li>
                            <li>海口</li>
                            <li>武汉</li>
                            <li>乌鲁木齐</li>
                            <li>郑州</li>
                            <li>三亚</li>
                            <li>贵阳</li>
                            <li>南京</li>
                            <li>青岛</li>
                            <li>哈尔滨</li>
                          </div>
                        </ul>
                      </div>
                    </div>
                    <div class="city-overlay" style="display: none">
                      <div class="city-container">
                        <div class="pop-ctn">
                          <div class="close-btn"><i></i></div>
                          <div class="pop-title">目前仅手机上支持「国际机票」</div>
                          <div class="pop-text">可打开带TA游旅游APP，或扫码预订</div>
                          <div class="pop-qr"><img width="40%" src="https://p3-q.mafengwo.net/s14/M00/6D/18/wKgE2l0INeCAA09MAAATkxovbeA310.png" /></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="search-content" style="display: none"><ul class="search-list"></ul></div>
                </div>
              </div>
            </div>
            <div class="flightpc-start-time">
              <div class="flightpc-start-time-title">出发日期</div>
              <div class="flightpc-start-time-calendar"><i class="icon-calendar"></i><input type="text" readonly placeholder="yyyy-mm-dd" /><!----></div>
            </div>
            <div class="flightpc-end-time">
              <div class="flightpc-end-time-title">返回日期</div>
              <div class="flightpc-end-time-calendar"><i class="icon-calendar"></i><input type="text" readonly placeholder="yyyy-mm-dd" /><!----></div>
            </div>
            <div class="flightpc-children">
              <div class="flightpc-children-btn"></div>
              <div class="flightpc-children-test">
                携带儿童
                <span>(2-12岁)</span>
              </div>
              <div class="flightpc-children-icon">
                <div class="flightpc-children-desc">
                  <div class="fpc-children-desc-title">儿童票购票说明</div>
                  <div class="fpc-children-desc-h">儿童票(2-12岁，按乘机当天的实际年龄计算)</div>
                  <div class="fpc-children-desc-p">1. 2岁(含)-12岁(不含)请购买儿童票。票价为成人全价票的50%，不收取机场建设费，燃油费收取成人的50%。暂不支持儿童购买成人折扣票。</div>
                  <div class="fpc-children-desc-p">2. 购买儿童票时需同时购买成人票，一个成人最多携带两名儿童。已购买完成人票想要再补订儿童票时，请直接联系相应航空公司。</div>
                  <div class="fpc-children-desc-p">3. 购买儿童票时可选择证件类型为身份证(填写户口本上登记的身份证号)，乘机时可用户口本登机。</div>
                  <div class="fpc-children-desc-p">4. 在新增联系人时正常录入乘机人姓名和证件号码即可，系统会根据出生日期和乘机日期自动判断所选乘客是否为儿童，并计算相应的票价。</div>
                </div>
              </div>
            </div>
            <div class="flightpc-index-search"><span class="flightpc-index-search-icon"></span><span class="flightpc-index-search-text">搜索</span></div>
          </div>
          <div class="search-massage" style="display: none">
            <div class="massage-container">
              <div class="massage-icon"></div>
              <div class="massage-text"></div>
              <div class="massage-btn">确定</div>
            </div>
          </div>
        </div>
        <div class="fpc-banner">
          <div class="v-banner">
            <div class="swiper-wrapper">
              <div class="swiper-slide">
                <div><img src="https://sales.mafengwo.net/img/85/b4/3d21c20b52233e2e6de679e770c80a55.jpeg" width="100%" height="auto" /></div>
              </div>
            </div>
            <!----><!---->
            <div class="swiper-pagination"></div>
          </div>
        </div>
      </div>
      <div class="flightpc-index-service">
        <div class="flightpc-s1"><i></i>100%航协认证</div>
        <div class="flightpc-s2"><i></i>出行保证</div>
        <div class="flightpc-s3">
          <i></i><span> 7x24小时服务<br /><strong>4006345678转2</strong></span>
        </div>
      </div>
      <div class="m-title"><span class="ticket-icon"></span><span>特价机票</span></div>
      <div class="v-com-lpcticket">
        <div class="figure">
          <div class="figure-item">
            <img src="http://p1-q.mafengwo.net/s16/M00/05/86/CoUBUl_ZydWAFJLPAAVNFTCqozw74.jpeg?imageMogr2%2Fthumbnail%2F%21750x563r%2Fgravity%2FCenter%2Fcrop%2F%21750x563%2Fquality%2F90" height="140" width="225" />
            <div class="figure-title"><span>广州</span> - <span>北京</span><span class="figure-price">￥463</span></div>
          </div>
          <div class="figure-item left">
            <img src="http://p1-q.mafengwo.net/s17/M00/09/94/CoUBXl_prceAZt8wAADBP3p_3pk30.jpeg?imageMogr2%2Fthumbnail%2F%21750x563r%2Fgravity%2FCenter%2Fcrop%2F%21750x563%2Fquality%2F90" height="140" width="225" />
            <div class="figure-title"><span>广州</span> - <span>天津</span><span class="figure-price">￥564</span></div>
          </div>
          <div class="figure-item left">
            <img src="http://p1-q.mafengwo.net/s17/M00/09/80/CoUBXl_pra-AME3tAACw-fA6xTA83.jpeg?imageMogr2%2Fthumbnail%2F%21750x563r%2Fgravity%2FCenter%2Fcrop%2F%21750x563%2Fquality%2F90" height="140" width="225" />
            <div class="figure-title"><span>广州</span> - <span>太原</span><span class="figure-price">￥321</span></div>
          </div>
          <div class="figure-item left">
            <img src="http://p1-q.mafengwo.net/s10/M00/19/4B/wKgBZ1oKib6AAo31AA-I-8Jp9-A49.jpeg?imageMogr2%2Fthumbnail%2F%21750x563r%2Fgravity%2FCenter%2Fcrop%2F%21750x563%2Fquality%2F90" height="140" width="225" />
            <div class="figure-title"><span>广州</span> - <span>大连</span><span class="figure-price">￥424</span></div>
          </div>
        </div>
        <div class="place-nav">
          <div class="nav-item" :class="{ checktab: currentTab === 0 }" @click="changeTab(0)">上海</div>
          <div class="nav-item" :class="{ checktab: currentTab === 1 }" @click="changeTab(1)">北京</div>
          <div class="nav-item" :class="{ checktab: currentTab === 2 }" @click="changeTab(2)">成都</div>
          <div class="nav-item" :class="{ checktab: currentTab === 3 }" @click="changeTab(3)">广州</div>
          <div class="nav-item" :class="{ checktab: currentTab === 4 }" @click="changeTab(4)">重庆</div>
          <div class="nav-item" :class="{ checktab: currentTab === 5 }" @click="changeTab(5)">西安</div>
          <div class="nav-item" :class="{ checktab: currentTab === 6 }" @click="changeTab(6)">昆明</div>
          <div class="nav-item" :class="{ checktab: currentTab === 7 }" @click="changeTab(7)">杭州</div>
          <div class="nav-item" :class="{ checktab: currentTab === 8 }" @click="changeTab(8)">深圳</div>
          <div class="nav-item" :class="{ checktab: currentTab === 9 }" @click="changeTab(9)">三亚</div>
          <div class="nav-item" :class="{ checktab: currentTab === 10 }" @click="changeTab(10)">厦门</div>
          <div class="nav-item" :class="{ checktab: currentTab === 11 }" @click="changeTab(11)">南京</div>
        </div>
        <div class="hotline">
          <div class="hot-item">
            <div><span class="line">南京-北京</span><span class="type">特价</span><span class="price">￥635</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-太原</span><span class="type">特价</span><span class="price">￥268</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-沈阳</span><span class="type">特价</span><span class="price">￥239</span></div>
          </div>
          <div class="hot-item">
            <div><span class="line">南京-长春</span><span class="type">特价</span><span class="price">￥339</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-哈尔滨</span><span class="type">特价</span><span class="price">￥439</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-呼和浩特</span><span class="type">特价</span><span class="price">￥309</span></div>
          </div>
          <div class="hot-item">
            <div><span class="line">南京-厦门</span><span class="type">特价</span><span class="price">￥306</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-青岛</span><span class="type">特价</span><span class="price">￥263</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-郑州</span><span class="type">特价</span><span class="price">￥434</span></div>
          </div>
          <div class="hot-item">
            <div><span class="line">南京-广州</span><span class="type">特价</span><span class="price">￥293</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-深圳</span><span class="type">特价</span><span class="price">￥230</span></div>
          </div>
          <div class="hot-item leftline">
            <div><span class="line">南京-珠海</span><span class="type">特价</span><span class="price">￥560</span></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
const currentTab = ref(0)

function changeTab(val) {
  currentTab.value = val
}
</script>
<style lang="scss" scoped>
.v-fpc-index-bg {
  width: 100%;
  height: 100%;
  background-color: #fff;
  .v-flightpc-container {
    width: 1000px;
    margin: 0 auto;
    .m-title {
      padding: 15px 0;
      margin: 0 20px;
      line-height: 30px;
      font-size: 18px;
      .flight-icon {
        width: 24px;
      }
    }
    .m-title .flight-icon,
    .m-title .ticket-icon {
      height: 24px;
      display: inline-block;
      background: url(https://b2-q.mafengwo.net/s14/M00/80/C2/wKgE2l0do-GAczUGAAAaNUcOHfo497.png) 0 0 no-repeat;
      background-size: auto;
      vertical-align: middle;
      margin-right: 12px;
    }
    .index-top {
      margin-bottom: 10px;
      height: 350px;
      .v-com-index-form {
        margin-bottom: 15px;
        padding: 19px 20px 18px;
        width: 320px;
        background: #fff;
        border: 2px solid #192885;
        display: inline-block;
        .radio-trip-type {
          margin-bottom: 20px;
          margin-left: 67px;
          .swich-icon {
            cursor: pointer;
            display: inline-block;
            vertical-align: top;
            width: 14px;
            height: 14px;
            background: #fff;
            border-radius: 32px;
            border: 1px solid #e5e5e5;
            margin-right: 8px;
          }
          .radioActive {
            width: 6px;
            height: 6px;
            background: #fff;
            border-radius: 12px;
            border: 5px solid #192885;
          }
          .swich-test {
            display: inline-block;
            vertical-align: top;
            line-height: 16px;
            font-size: 16px;
            font-family: PingFangSC-Regular;
            font-weight: 400;
            color: #717376;
            margin-right: 30px;
          }
        }
        .search-city {
          width: 320px;
          .city-title {
            display: inline-block;
            font-size: 14px;
            font-family: PingFangSC-Regular;
            font-weight: 400;
            color: #717376;
            line-height: 18px;
            margin-right: 10px;
          }
          .city {
            display: inline-block;
            position: relative;
            input {
              display: block;
              width: 190px;
              height: 18px;
              border: 1px solid #e5e5e5;
              padding: 9px 15px;
              line-height: 20px;
              font-size: 14px;
              color: #666;
            }
          }
          .v-com-select-city {
            position: absolute;
            left: 0;
            z-index: 12;
            .city-select {
              margin-bottom: 15px;
              padding: 10px;
              width: 500px;
              background-color: #fff;
              border: 1px solid #e5e5e5;
              margin-top: -1px;
              font-size: 12px;
              .history {
                line-height: 20px;
                margin-bottom: 5px;
                .history-title {
                  display: inline-block;
                  vertical-align: middle;
                }
                .history-content {
                  display: inline-block;
                  vertical-align: middle;
                  margin-right: 20px;
                  cursor: pointer;
                }
              }
              .filter-tabar {
                margin-bottom: 5px;
                line-height: 30px;
                overflow: hidden;
                li {
                  background-color: #f6f6f6;
                  cursor: pointer;
                  display: inline-block;
                  width: 69px;
                  border-right: 1px solid #fff;
                  text-align: center;
                  color: #666;
                }
                .selectactive {
                  background-color: #192885;
                  color: #fff;
                }
              }
            }
            .city-content {
              max-height: 500px;
              overflow-y: auto;
              overflow-x: hidden;
              padding: 10px 13px 0;
              .scope .city-group {
                overflow: hidden;
                li {
                  cursor: pointer;
                  text-indent: 0;
                  width: 68px;
                  line-height: 30px;
                  font-size: 14px;
                  float: left;
                  height: 30px;
                  text-indent: 8px;
                  overflow: hidden;
                  &:hover {
                    color: #192885;
                  }
                }
              }
            }
          }
          .switch {
            float: right;
            margin: -2px -3px 0 0;
            text-align: center;
            line-height: 20px;
            cursor: pointer;
            position: relative;
            span {
              display: block;
              width: 21px;
              height: 21px;
              background-color: #cecece;
              border-radius: 2px;
              color: #fff;
            }
          }
          .switch:after,
          .switch:before {
            content: '';
            position: absolute;
            width: 19px;
            height: 15px;
            left: -9px;
            border-right: 1px solid #e5e5e5;
          }
          .switch:before {
            border-top: 1px solid #e5e5e5;
            top: -19px;
          }
          .switch:after {
            border-bottom: 1px solid #e5e5e5;
            top: 19px;
          }
          .arrCity {
            margin-top: 10px;
          }
          .flightpc-end-time,
          .flightpc-start-time {
            margin-top: 10px;
          }
          .flightpc-end-time .flightpc-end-time-title,
          .flightpc-end-time .flightpc-start-time-title,
          .flightpc-start-time .flightpc-end-time-title,
          .flightpc-start-time .flightpc-start-time-title {
            display: inline-block;
            font-size: 14px;
            font-family: PingFangSC-Regular;
            font-weight: 400;
            color: #717376;
            line-height: 40px;
            margin-right: 10px;
          }
          .flightpc-end-time .flightpc-end-time-calendar,
          .flightpc-end-time .flightpc-start-time-calendar,
          .flightpc-start-time .flightpc-end-time-calendar,
          .flightpc-start-time .flightpc-start-time-calendar {
            display: inline-block;
            position: absolute;
          }
          .flightpc-end-time .flightpc-end-time-calendar input,
          .flightpc-end-time .flightpc-start-time-calendar input,
          .flightpc-start-time .flightpc-end-time-calendar input,
          .flightpc-start-time .flightpc-start-time-calendar input {
            display: block;
            width: 190px;
            height: 18px;
            border: 1px solid #e5e5e5;
            padding: 9px 15px;
            line-height: 18px;
            font-size: 14px;
            color: #666;
          }
          .flightpc-end-time .flightpc-end-time-calendar .icon-calendar,
          .flightpc-end-time .flightpc-start-time-calendar .icon-calendar,
          .flightpc-start-time .flightpc-end-time-calendar .icon-calendar,
          .flightpc-start-time .flightpc-start-time-calendar .icon-calendar {
            position: absolute;
            width: 20px;
            height: 20px;
            top: 11px;
            right: 11px;
            display: inline-block;
            background: url(https://b2-q.mafengwo.net/s14/M00/80/C2/wKgE2l0do-GAczUGAAAaNUcOHfo497.png) -60px -30px no-repeat;
            background-size: auto;
            vertical-align: middle;
            cursor: pointer;
            pointer-events: none;
          }
          .flightpc-children {
            height: 16px;
            width: 100%;
            margin: 14px 0;
            .flightpc-children-btn {
              margin-left: 67px;
              display: inline-block;
              vertical-align: middle;
              width: 14px;
              height: 14px;
              border-radius: 14px;
              background: #fff;
              border: 1px solid #e5e5e5;
            }
            .flightpc-children-test {
              display: inline-block;
              vertical-align: middle;
              font-size: 12px;
              font-family: PingFangSC-Light;
              font-weight: 300;
              line-height: 16px;
              margin-left: 8px;
              color: #242629;
            }
            .flightpc-children-icon {
              margin-top: 1px;
              margin-left: 8px;
              display: inline-block;
              vertical-align: middle;
              width: 14px;
              height: 14px;
              background-image: url(https://p1-q.mafengwo.net/s14/M00/A9/BC/wKgE2l0lkt2AHBFrAAACA5pPOCI472.png);
              background-size: 100% 100%;
              position: relative;
              &:hover {
                .flightpc-children-desc {
                  display: block;
                }
              }
              .flightpc-children-desc {
                display: none;
                position: absolute;
                left: -91px;
                top: 20px;
                width: 496px;
                height: auto;
                padding: 12px;
                background: #fff;
                -webkit-box-shadow: 0 1px 5px 1px rgb(0 0 0 / 12%);
                box-shadow: 0 1px 5px 1px rgb(0 0 0 / 12%);
                z-index: 100;
                border-radius: 4px;
                .fpc-children-desc-title {
                  font-size: 14px;
                  font-family: PingFangSC-Semibold;
                  font-weight: 600;
                  color: #21272e;
                  width: 100%;
                  text-align: center;
                }
                .fpc-children-desc-h {
                  margin-top: 15px;
                  font-size: 12px;
                  font-family: PingFangSC-Semibold;
                  font-weight: 600;
                  color: #21272e;
                  line-height: 17px;
                }
                .fpc-children-desc-p {
                  font-size: 12px;
                  font-family: PingFangSC-Regular;
                  font-weight: 400;
                  color: #21272e;
                  line-height: 17px;
                }
              }
            }
          }
          .flightpc-index-search {
            cursor: pointer;
            margin-top: 15px;
            margin-left: 67px;
            width: 222px;
            height: 40px;
            background: #192885;
            border-radius: 1px;
            .flightpc-index-search-icon {
              margin-left: 77px;
              margin-top: 8px;
              display: inline-block;
              vertical-align: middle;
              width: 24px;
              height: 24px;
              background-image: url(https://n4-q.mafengwo.net/s14/M00/CB/5A/wKgE2l0kC4yAWAmgAAADgtoCHuM122.png);
              background-size: 100% 100%;
            }
            .flightpc-index-search-text {
              margin-left: 5px;
              display: inline-block;
              vertical-align: middle;
              margin-top: 8px;
              font-size: 18px;
              font-family: PingFangSC-Regular;
              font-weight: 400;
              color: #fff;
              line-height: 25px;
            }
          }
        }
        .radio-trip-type .round-trip,
        .radio-trip-type .single-trip {
          display: inline-block;
          height: 16px;
          line-height: 16px;
          font-size: 0;
        }
      }
      .fpc-banner {
        float: right;
        width: 620px;
        height: 350px;
        position: relative;
        z-index: 5;
        .v-banner {
          position: relative;
          min-height: 1px;
          height: 100%;
          overflow: hidden;
          .swiper-wrapper {
            position: relative;
            width: 100%;
            height: 100%;
            z-index: 1;
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-transition-property: -webkit-transform;
            transition-property: -webkit-transform;
            -o-transition-property: transform;
            transition-property: transform;
            transition-property: transform, -webkit-transform;
            -webkit-box-sizing: content-box;
            transform: translate3d(0, 0, 0);
            box-sizing: content-box;
            .swiper-slide {
              -webkit-flex-shrink: 0;
              -ms-flex-negative: 0;
              flex-shrink: 0;
              width: 100%;
              height: 100%;
              position: relative;
              -webkit-transition-property: -webkit-transform;
              transition-property: -webkit-transform;
              -o-transition-property: transform;
              transition-property: transform;
              transition-property: transform, -webkit-transform;
            }
          }
          .swiper-pagination {
            position: absolute;
            text-align: center;
            -webkit-transition: 0.3s opacity;
            -o-transition: 0.3s opacity;
            transition: 0.3s opacity;
            -webkit-transform: translate3d(0, 0, 0);
            transform: translate3d(0, 0, 0);
            z-index: 10;
          }
        }
      }
    }
    .flightpc-index-service {
      margin-top: 10px;
      width: 998px;
      border: 1px solid #e5e5e5;
      background-color: #f6f6f6;
      height: 58px;
      text-align: center;
      font-size: 16px;
      .flightpc-s1 {
        display: inline-block;
        padding: 10px 0;
        width: 300px;
        line-height: 38px;
        position: relative;
        i {
          display: inline-block;
          background: url(https://b2-q.mafengwo.net/s14/M00/80/C2/wKgE2l0do-GAczUGAAAaNUcOHfo497.png) 0 -90px no-repeat;
          background-size: auto;
          vertical-align: middle;
          width: 40px;
          height: 34px;
          margin-right: 15px;
        }
      }
      .flightpc-s2 {
        display: inline-block;
        padding: 10px 0;
        width: 300px;
        line-height: 38px;
        position: relative;
        &:before {
          content: '';
          position: absolute;
          left: 0;
          top: 15px;
          width: 1px;
          height: 28px;
          background-color: #d1d1d1;
        }
        i {
          display: inline-block;
          background: url(https://b2-q.mafengwo.net/s14/M00/80/C2/wKgE2l0do-GAczUGAAAaNUcOHfo497.png) 0 -90px no-repeat;
          background-size: auto;
          background-position: -60px -90px;
          vertical-align: middle;
          width: 34px;
          height: 34px;
          margin-right: 15px;
        }
      }
      .flightpc-s3 {
        display: inline-block;
        padding: 10px 0;
        width: 300px;
        position: relative;
        i {
          display: inline-block;
          background: url(https://b2-q.mafengwo.net/s14/M00/80/C2/wKgE2l0do-GAczUGAAAaNUcOHfo497.png) 0 -90px no-repeat;
          background-position: -120px -90px;
          background-size: auto;
          vertical-align: middle;
          width: 34px;
          height: 34px;
          margin-right: 15px;
        }
        &:before {
          content: '';
          position: absolute;
          left: 0;
          top: 15px;
          width: 1px;
          height: 28px;
          background-color: #d1d1d1;
        }
        span {
          display: inline-block;
          vertical-align: middle;
          line-height: 19px;
          strong {
            color: #192885;
            font-weight: norma;
            font-size: 14px;
            line-height: 16px;
          }
        }
      }
    }
    .m-title {
      padding: 15px 0;
      margin: 0 20px;
      line-height: 30px;
      font-size: 18px;
      .ticket-icon {
        height: 24px;
        width: 26px;
        display: inline-block;
        background: url(https://b2-q.mafengwo.net/s14/M00/80/C2/wKgE2l0do-GAczUGAAAaNUcOHfo497.png) 0 0 no-repeat;
        background-position: -30px 0;
        background-size: auto;
        vertical-align: middle;
        margin-right: 12px;
      }
    }
    .v-com-lpcticket {
      height: auto;
      background-color: #fff;
      border: 1px solid #e5e5e5;
      padding: 20px 19px;
      margin-bottom: 30px;
      .figure {
        width: 100%;
        margin-bottom: 10px;
        .figure-item {
          cursor: pointer;
          display: inline-block;
          width: 225px;
          height: 140px;
          position: relative;
          overflow: hidden;
          .figure-title {
            position: absolute;
            left: 0;
            right: 0;
            bottom: 0;
            line-height: 30px;
            color: #fff;
            padding: 0 15px;
            font-size: 16px;
            background-color: #000;
            background-color: rgba(0, 0, 0, 0.6);
          }
          .figure-price {
            float: right;
          }
        }
        .left {
          margin-left: 20px;
        }
      }
      .place-nav {
        height: 40px;
        background-color: #f6f6f6;
        line-height: 40px;
        font-size: 14px;
        margin-bottom: 20px;
        .nav-item {
          cursor: pointer;
          float: left;
          margin: 0 5px 0 18px;
          padding: 0 10px;
          color: #666;
          position: relative;
          &.checktab {
            background-color: #192885;
            color: #fff;
            &:after {
              content: '';
              position: absolute;
              border-top: 4px solid #192885;
              border-left: 4px dashed transparent;
              border-right: 4px dashed transparent;
              overflow: hidden;
              line-height: 0;
              font-size: 0;
              bottom: -4px;
              left: 50%;
              margin-left: -4px;
            }
          }
        }
      }
      .hotline {
        height: auto;
        margin: 0 -15px;
        .hot-item {
          cursor: pointer;
          display: inline-block;
          height: 28px;
          width: 270px;
          padding: 5px 30px 5px 25px;
          line-height: 28px;
          .line {
            display: inline-block;
            width: 125px;
          }
          .type {
            display: inline-block;
            width: 45px;
          }
          .price {
            float: right;
            font-size: 20px;
            color: #192885;
          }
        }
        .leftline {
          border-left: 1px solid #e5e5e5;
        }
      }
    }
  }
}
</style>
