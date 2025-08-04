<template>
  <div class="main-continer">
    <div class="slider-container">
      <div  class="slider-list">
        <div class="slider-item">
          <img class="slider-img" :src="currentSlider?currentSlider.coverUrl:''" />
          <div class="slider-desc">
            <div class="date"><span class="day">{{formattedDay}}</span>/{{formattedDate}}</div>
            <h3>{{ currentSlider?currentSlider.title:'' }}</h3>
          </div>
        </div>
      </div>
      <div class="slider-nav">
        <div v-for="(item, index) in sliderList" :key="'slider'+item.id" class="slider-nav-item" :class="{ 'slider-nav-item-active': currentSlider.id === item.id }" @click.stop="changeSlider(item, index)">
          <img class="slider-nav-img" :src="item.coverUrl" />
        </div>
      </div>
      <div class="search-container" >
        <el-radio-group v-model="searchType">
          <el-radio :label="-1" >全部</el-radio>
          <el-radio :label="4" >问答</el-radio>
          <el-radio :label="1" >攻略</el-radio>
          <el-radio :label="2">游记</el-radio>
          <el-radio :label="3" >找人</el-radio>
        </el-radio-group>
        <div class="search-wrap">
          <input v-model="searchVal" class="search-input" placeholder="搜目的地/攻略/游记/用户" />
          <div class="search-btn" @click="search">
            <el-icon :size="25" color="white"><Search /></el-icon>
          </div>
        </div>
      </div>
    </div>
    <div class="content-container">
      <div class="sales-entrys-container">
        <a href="/local-tour" target="_blank" class="sales-entrys-item entrys-bg-localdeals">
          <div class="sales-entrys-title">当地游</div>
          <div class="sales-entrys-subtitle">最地道的玩法体验</div>
        </a>
        <a href="/independent-travel" target="_blank" class="sales-entrys-item entrys-bg-sales">
          <div class="sales-entrys-title">自由行</div>
          <div class="sales-entrys-subtitle">旅行就要更自在</div>
        </a>
        <a href="/group-tour" target="_blank" class="sales-entrys-item entrys-bg-group">
          <div class="sales-entrys-title">跟团游</div>
          <div class="sales-entrys-subtitle">行程透明省心游</div>
        </a>
        <a href="/ticket" target="_blank" class="sales-entrys-item entrys-bg-flight">
          <div class="sales-entrys-title">机票</div>
          <div class="sales-entrys-subtitle">特惠一折起</div>
        </a>
        <a href="/hotel" target="_blank" class="sales-entrys-item entrys-bg-hotel">
          <div class="sales-entrys-title">订酒店</div>
          <div class="sales-entrys-subtitle">一键全网比价</div>
        </a>
        <a href="/visa" target="_blank" class="sales-entrys-item entrys-bg-visa">
          <div class="sales-entrys-title">签证</div>
          <div class="sales-entrys-subtitle">出签率高服务佳</div>
        </a>
        <a href="/liner" target="_blank" class="sales-entrys-item entrys-bg-ship">
          <div class="sales-entrys-title">邮轮</div>
          <div class="sales-entrys-subtitle">移动的海上城堡</div>
        </a>
      </div>
      <div class="wrap-container">
        <div class="wrap-left">
          <div class="safety-prevention">
            <a class="safety-prevention-link">
              <img src="../assets/images/safety-prevention.png" width="218" height="31" />
            </a>
          </div>
          <div class="traveller-container">
            <div class="traveller-header">
              <h2 class="traveller-title">旅行家专栏</h2>
              <a class="hd-right">专栏首页</a>
            </div>
            <div class="traveller-content">
              <div class="traveller-content-item">
                <img src="https://n1-q.mafengwo.net/s13/M00/FB/B9/wKgEaVycpr6Ae-TXAAC_Ffkpk0s50.jpeg" height="140" width="260" />
                <h3>漫山岛</h3>
                <p>漫山岛在第二条路上，满眼都是天赋，却偏爱挥霍青山绿水，用自己的方式过小日子，即便强行拖它起来，也得不到结果。</p>
              </div>
            </div>
          </div>
          <div class="traveller-container">
            <div class="traveller-header">
              <h2 class="traveller-title">旅游攻略推荐</h2>
              <a class="hd-right">更多</a>
            </div>
            <div class="traveller-content">
              <div class="traveller-content-item">
                <img src="https://n1-q.mafengwo.net/s13/M00/FB/B9/wKgEaVycpr6Ae-TXAAC_Ffkpk0s50.jpeg" height="140" width="260" />
                <h3>尼亚加拉三日游，现成路线在此。</h3>
              </div>
            </div>
          </div>
          <div class="traveller-container">
            <div class="traveller-header">
              <h2 class="traveller-title">加入带TA游</h2>
              <a class="hd-right">了解详情></a>
            </div>
            <div class="traveller-content">
              <div class="traveller-content-item">
                <img src="https://n1-q.mafengwo.net/s13/M00/FB/B9/wKgEaVycpr6Ae-TXAAC_Ffkpk0s50.jpeg" height="140" width="260" />
              </div>
            </div>
          </div>
          <div class="news-container">
            <div class="news-title">带TA游旅游网最新资讯</div>
            <ul class="news-list">
              <li class="news-item">
                04月07日
                <a href="https://baijiahao.baidu.com/s?id=1663280885894494273&amp;wfr=spider&amp;for=pc" target="_blank" rel="nofollow"> 带TA游“云旅游”直播的攻与守 </a>
              </li>
              <li class="news-item">
                04月07日
                <a href="https://baijiahao.baidu.com/s?id=1663280885894494273&amp;wfr=spider&amp;for=pc" target="_blank" rel="nofollow"> 带TA游“云旅游”直播的攻与守 </a>
              </li>
              <li class="news-item">
                04月07日
                <a href="https://baijiahao.baidu.com/s?id=1663280885894494273&amp;wfr=spider&amp;for=pc" target="_blank" rel="nofollow"> 带TA游“云旅游”直播的攻与守 </a>
              </li>
              <li class="news-item">
                04月07日
                <a href="https://baijiahao.baidu.com/s?id=1663280885894494273&amp;wfr=spider&amp;for=pc" target="_blank" rel="nofollow"> 带TA游“云旅游”直播的攻与守 </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="wrap-right">
          <el-tabs v-model="tabActive" class="travelnotes-tabs" @tab-click="changeTab">
            <el-tab-pane label="热门游记" name="viewnum">
              <div class="travelnotes-list">
                <NuxtLink v-for="item in hottestList" :key="'hottest'+item.id" :to="'/note/details/' + item.id" target="_blank" class="travelnotes-item">
                  <img class="travelnotes-item-img" :src="item.coverUrl" />
                  <div class="travelnotes-info">
                    <h3 class="travelnotes-info-title">{{ item.title }}</h3>
                    <p class="travelnotes-info-desc">{{ item.summary }}</p>
                    <div class="travelnotes-extra">
                      <div class="travelnotes-extra-left">
                        <div class="travelnotes-extra-place">
                          <i></i>
                          {{ item.destName }}，by
                        </div>
                        <div  class="travelnotes-extra-user">
                          <img :src="item.author?item.author.headImgUrl:''" />
                          {{ item.author.nickname }}
                        </div>
                        <div class="travelnotes-extra-nums">
                          <i></i>
                          {{ item.viewnum }}/{{ item.favornum?item.favornum:0 }}
                        </div>
                      </div>
                      <div class="travelnotes-extra-right">
                        <div class="travelnotes-extra-ding">
                          {{ item.thumbsupnum }}
                          <i class="ding-btn"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </NuxtLink>
              </div>
              <div class="page-container">
                <el-pagination class="page" background layout="total, prev, pager, next" :page-size="10" :current-page="hottestParams.currentPage" :total="hottestTotal" @current-change="hottestCurrentChange" />
              </div>
            </el-tab-pane>
            <el-tab-pane label="最新发表" name="create_time">
              <div class="travelnotes-list">
                <NuxtLink v-for="item in newestList" :key="'newst'+item.id" :to="'/note/details/' + item.id" target="_blank" class="travelnotes-item">
                  <img class="travelnotes-item-img" :src="item.coverUrl" />
                  <div class="travelnotes-info">
                    <h3 class="travelnotes-info-title">{{ item.title }}</h3>
                    <p class="travelnotes-info-desc">{{ item.summary }}</p>
                    <div class="travelnotes-extra">
                      <div class="travelnotes-extra-left">
                        <div class="travelnotes-extra-place">
                          <i></i>
                          {{ item.destName }}，by
                        </div>
                        <div class="travelnotes-extra-user">
                          <img :src="item.author?item.author.headImgUrl:''" />
                          {{ item.author?item.author.nickname:'' }}
                        </div>
                        <div class="travelnotes-extra-nums">
                          <i></i>
                          {{ item.viewnum }}/{{ item.favornum?item.favornum:0 }}
                        </div>
                      </div>
                      <div class="travelnotes-extra-right">
                        <div class="travelnotes-extra-ding">
                          {{ item.thumbsupnum }}
                          <i class="ding-btn"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </NuxtLink>
              </div>
              <div class="page-container">
                <el-pagination class="page" background layout="total, prev, pager, next" :page-size="10" :current-page="newestParams.currentPage" :total="newestTotal" @current-change="newestCurrentChange" />
              </div>
            </el-tab-pane>
          </el-tabs>
          <div class="tn-write">
            <NuxtLink to="/note/form" class="btn-add"><i></i>写游记</NuxtLink>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref,watchEffect  } from 'vue'
import { bannerTravel, noteList } from '@/composables/api/home'


//日期
const formattedDate = ref('');
const formattedDay = ref();
const now = new Date();
const year = now.getFullYear();
const month = now.toLocaleString('default', { month: 'short' });
const day = now.getDate();
formattedDate.value = `${month}.${year}`;
formattedDay.value = day;

let playTimer = null
const sliderList = ref([])
let currentSliderIndex = 0
const currentSlider = ref()
const searchType = ref(-1) // 搜索类型
const searchVal = ref('') // 搜索值
const tabActive = ref('viewnum') // tab选中值
const hottestParams = ref({
  orderBy: 'viewnum',
  currentPage: 1
})
const newestParams = ref({
  orderBy: 'create_time',
  currentPage: 1
})
const hottestTotal = ref(0)
const newestTotal = ref(0)
const hottestList = ref([])
const newestList = ref([])

onMounted(() => {
  autoPlay()
  nextTick(() => {
    getBannerTravel()
    getTravelList(hottestParams)
  })
})


// 热门游记与最新游记数据切换
function  changeTab (item) {
 // console.log(item);

  if (item.paneName === 'create_time') {
    getTravelList(newestParams)
  } else {
    getTravelList(hottestParams)
  }
}
// 通过类型(游记)查询banner
function getBannerTravel() {
  bannerTravel()
    .then(res => {
      sliderList.value = res.data
      currentSlider.value = sliderList.value[0]
    })
    .catch(err => {
      console.log(err)
    })
}

// 游记列表
function getTravelList(params) {

  noteList(params.value)
    .then(res => {
      if (params.value.orderBy === 'create_time') {
        newestList.value = res.data.records
        newestTotal.value = res.data.total
      } else {
        hottestList.value = res.data.records
        hottestTotal.value = res.data.total

      }
    })
    .catch(err => {
      console.log(err)
    })
}

function hottestCurrentChange(val: number) {
  hottestParams.value.currentPage = val
  getTravelList(hottestParams)
}

function newestCurrentChange(val: number) {
  newestParams.value.currentPage = val
  getTravelList(newestParams)
}

// 自动轮播banner
function autoPlay() {
  let playTimer = setInterval(() => {
    currentSliderIndex++
    currentSliderIndex = currentSliderIndex >= sliderList.value.length ? 0 : currentSliderIndex
    currentSlider.value = sliderList.value[currentSliderIndex]
  }, 5000)
}

// 切换banner
function changeSlider(item, index: number) {
  currentSlider.value = item
  currentSliderIndex = index
}

function search() {
  if (searchVal.value) {
    return navigateTo({
      path: '/search',
      query: {
        type: searchType.value,
        keyword: searchVal.value
      }
    })
  }
}
</script>
<style lang="scss" scoped>
:root {
  --el-color-primary: write;
}

.main-continer {
  position: relative;
  .slider-container {
    position: relative;
    height: 450px;
    overflow: hidden;
    background-color: #f1f4f5;
    .slider-list {
      width: 100%;
      height: 100%;
      .slider-item {
        position: relative;
        width: 100%;
        height: 100%;
        .slider-img {
          width: 100%;
          margin: 0 !important;
        }
        .slider-desc {
          position: absolute;
          top: 25px;
          left: 50%;
          margin-left: -500px;
          color: #fff;
          font-size: 26px;
          text-shadow: 0 1px 3px rgb(0 0 0 / 90%);
          text-align: left;
          min-width: 1000px;
          .date {
            position: relative;
            width: 180px;
            font-size: 24px;
            overflow: hidden;
            .day {
              font-size: 38px;
            }
          }
          h3 {
            font-size: 26px;
            font-weight: normal;
          }
        }
      }
    }
    .slider-nav {
      position: absolute;
      right: 40px;
      top: 45%;
      margin-top: -166px;
      width: 110px;
      z-index: 2;
      .slider-nav-item {
        width: 100px;
        height: 62px;
        margin-bottom: 6px;
        cursor: pointer;
        &.slider-nav-item-active {
          border: 2px solid #192885;
          box-sizing: border-box;
        }
        .slider-nav-img {
          width: 100%;
          height: 100%;
        }
      }
    }
    .search-container {
      position: absolute;
      bottom: 45px;
      left: 50%;
      width: 632px;
      padding: 15px;
      margin-left: -320px;
      background-color: rgba(0, 0, 0, 0.6);
      border-radius: 4px;
      box-sizing: border-box;
      z-index: 5;

      .search-wrap {
        display: flex;
        align-items: center;
        justify-content: space-between;
        .search-input {
          width: 504px;
          height: 46px;
          border: 0 none;
          padding: 0 21px;
          margin: 0;
          line-height: 46px;
          font-size: 16px;
          color: #666;
          border-radius: 4px;
          background-color: #fff;
        }
        .search-btn {
          width: 50px;
          height: 46px;
          line-height: 60px;
          cursor: pointer;
          border-radius: 4px;
          text-align: center;
          background-color: #192885;
        }
      }
    }
  }
  .content-container {
    width: 1000px;
    padding-top: 20px;
    margin: 0 auto;
    .sales-entrys-container {
      width: 100%;
      margin-bottom: 19px;
      font-size: 0;
      white-space: nowrap;
      .sales-entrys-item {
        display: inline-block;
        width: 128px;
        height: 47px;
        margin-left: 8px;
        padding-top: 8px;
        padding-left: 7px;
        display: inline-block;
        border: 0.5px solid #e5e5e5;
        border-radius: 3px;
        font-family: PingFangSC-Semibold;
        background-image: url('../assets/images/sales-entrys.png');
        background-repeat: no-repeat;
        background-size: 104px auto;
        background-position-x: 59px;
        cursor: pointer;
        &:first-child {
          margin-left: 0;
        }
        &.entrys-bg-localdeals {
          background-position-y: -129px;
        }
        &.entrys-bg-sales {
          background-position-y: -651px;
        }
        &.entrys-bg-group {
          background-position-y: -24px;
        }
        &.entrys-bg-flight {
          background-position-y: -441px;
        }
        &.entrys-bg-hotel {
          background-position-y: -546px;
        }
        &.entrys-bg-visa {
          background-position-y: -335px;
        }
        &.entrys-bg-ship {
          background-position-y: -233px;
        }
        .sales-entrys-title {
          display: inline-block;
          height: 22px;
          font-size: 16px;
          font-weight: 600;
          line-height: 22px;
          font-family: PingFangSC-Semibold;
          color: #333;
        }
        .sales-entrys-subtitle {
          height: 16px;
          padding-top: 1px;
          font-size: 11px;
          font-weight: 400;
          line-height: 16px;
          font-family: PingFangSC-Regular;
          color: #9d9d9d;
        }
      }
    }
    .wrap-container {
      display: flex;
      justify-content: space-between;
      .wrap-left {
        flex: 0 0 260px;
        .safety-prevention {
          margin-bottom: 20px;
          cursor: pointer;
          .safety-prevention-link {
            display: block;
            margin-top: 5px;
          }
        }
        .traveller-container {
          margin-bottom: 30px;
          .traveller-header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            height: 35px;
            line-height: 35px;
            margin-bottom: 12px;
            .traveller-title {
              font-size: 18px;
              color: #333;
              font-weight: normal;
            }
            .hd-right {
              font-size: 12px;
              color: #999;
              cursor: pointer;
              &:hover {
                outline: 0;
                text-decoration: underline;
              }
            }
          }
          .traveller-content {
            .traveller-content-item {
              .traveller-image {
                height: 140px;
                overflow: hidden;
              }
              h3 {
                margin: 10px 0 5px;
                width: 260px;
                height: 26px;
                font-size: 16px;
                color: #333;
                font-weight: normal;
                line-height: 26px;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
              }
              p {
                height: 60px;
                line-height: 20px;
                font-size: 14px;
                color: #333;
                overflow: hidden;
              }
            }
          }
        }
        .news-container {
          margin-bottom: 30px;
          .news-title {
            height: 35px;
            line-height: 35px;
            margin-bottom: 12px;
            font-size: 18px;
            color: #333;
            font-weight: normal;
          }
          .news-list {
            .news-item {
              height: 30px;
              width: 260px;
              line-height: 30px;
              overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
              position: relative;
              a {
                margin-left: 5px;
                color: #666;
                &:hover {
                  outline: 0;
                  text-decoration: underline;
                }
              }
            }
          }
        }
      }
      .wrap-right {
        position: relative;
        flex: 0 0 718px;
        .travelnotes-tabs {
          .travelnotes-list {
            .travelnotes-item {
              display: flex;
              justify-content: space-between;
              padding: 15px;
              height: 150px;
              cursor: pointer;
              &:hover {
                background-color: #f8f8f8;
                padding: 15px;
                .travelnotes-info-title {
                  color: #192885 !important;
                }
              }
              .travelnotes-item-img {
                position: relative;
                width: 220px;
                height: 150px;
              }
              .travelnotes-info {
                width: 455px;
                height: 150px;
                .travelnotes-info-title {
                  margin-bottom: 10px;
                  font-size: 18px;
                  line-height: 26px;
                  width: 420px;
                  height: 26px;
                  display: block;
                  color: #333;
                  overflow: hidden;
                  white-space: nowrap;
                  text-overflow: ellipsis;
                }
                .travelnotes-info-desc {
                  display: -webkit-box;
                  overflow: hidden;
                  text-overflow: ellipsis;
                  -webkit-line-clamp: 3;
                  -webkit-box-orient: vertical;
                  word-break: break-all;
                  height: 60px;
                  line-height: 20px;
                  font-size: 14px;
                  color: #666;
                }
                .travelnotes-extra {
                  display: flex;
                  align-items: center;
                  height: 33px;
                  line-height: 33px;
                  margin-top: 20px;
                  overflow: hidden;
                  font-size: 12px;
                  .travelnotes-extra-left {
                    flex: 1;
                    .travelnotes-extra-place {
                      display: inline-flex;
                      margin-right: 5px;
                      i {
                        display: inline-block;
                        margin: 8px 5px 0 0;
                        width: 14px;
                        height: 16px;
                        background-image: url(../assets/images/index-sprites8-v2@2x.png);
                        background-size: 200px;
                        background-position: 0 -50px !important;
                        overflow: hidden;
                      }
                    }
                    .travelnotes-extra-user {
                      display: inline-flex;
                      align-items: center;
                      margin-right: 10px;
                      color: #192885;
                      cursor: pointer;
                      img {
                        margin-right: 5px;
                        width: 16px;
                        height: 16px;
                        overflow: hidden;
                        border-radius: 50%;
                        vertical-align: -3px;
                      }
                    }
                    .travelnotes-extra-nums {
                      display: inline-flex;
                      font-size: 14px;
                      color: #999;
                      i {
                        display: inline-block;
                        margin: 10px 5px 0 0;
                        width: 18px;
                        height: 14px;
                        background-image: url(../assets/images/index-sprites8-v2@2x.png);
                        background-size: 200px;
                        background-position: -30px -50px !important;
                      }
                    }
                  }
                  .travelnotes-extra-right {
                    flex: 0 0 auto;
                    .travelnotes-extra-ding {
                      display: flex;
                      align-items: center;
                      color: #192885;
                      font-size: 14px;
                      .ding-btn {
                        display: inline-block;
                        margin-left: 8px;
                        width: 38px;
                        height: 33px;
                        background-image: url(../assets/images/index-sprites8-v2@2x.png);
                        background-size: 200px;
                        background-position: -60px 0 !important;
                        overflow: hidden;
                      }
                    }
                  }
                }
              }
            }
          }
          .page-container {
            margin-top: 15px;
            text-align: right;
            .page {
              display: inline-flex;
            }
          }
        }
        .tn-write {
          position: absolute;
          top: 0px;
          right: 0px;
          cursor: pointer;
          z-index: 999;
          .btn-add {
            display: inline-block;
            width: 140px;
            height: 36px;
            line-height: 36px;
            background-color: #192885;
            font-size: 16px;
            color: #fff;
            text-align: center;
            border-radius: 4px;
            i {
              display: inline-block;
              margin-right: 5px;
              width: 18px;
              height: 17px;
              background-position: 0 0;
              overflow: hidden;
              vertical-align: -3px;
              background-image: url(../assets/images/index-sprites8-v2@2x.png);
              background-size: 200px;
            }
          }
        }
      }
    }
  }
}
</style>
<style>
.travelnotes-tabs .el-tabs__item {
  font-size: 18px;
  font-weight: normal;
}
.el-radio {
  color: #fff;
}
</style>
