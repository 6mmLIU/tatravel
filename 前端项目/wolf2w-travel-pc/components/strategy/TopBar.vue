<template>
  <div class="strategy-top-bar">
    <div class="bar-left">
      <div class="gonglve-nav">
        <div class="nav-item">
          <div class="nav-title">
            <h3>海外攻略推荐排行</h3>
            <b class="gn-arrow"></b>
          </div>
          <div class="nav-panel rank-panel">
            <ol>
              <li v-for="(item, index) in rankList1" :key="item.id">
                <em class="rank-num">{{ index + 1 }}</em>
                <strong>
                  <a :href="`/destination/details/${item.destId}`" target="_blank">{{ item.destName }}</a>
                </strong>
                <a :href="`/strategy/article/${item.strategyId}`" target="_blank">{{ item.strategyTitle }}</a>
              </li>
            </ol>
          </div>
        </div>
        <div class="nav-item">
          <div class="nav-title">
            <h3>国内攻略推荐排行</h3>
            <b class="gn-arrow"></b>
          </div>
          <div class="nav-panel rank-panel">
            <ol>
              <li v-for="(item, index) in rankList2" :key="item.id">
                <em class="rank-num">{{ index + 1 }}</em>
                <strong>
                  <a :href="`/destination/details/${item.destId}`" target="_blank">{{ item.destName }}</a>
                </strong>
                <a :href="`/strategy/article/${item.strategyId}`" target="_blank">{{ item.strategyTitle }}</a>
              </li>
            </ol>
          </div>
        </div>
        <div class="nav-item">
          <div class="nav-title">
            <h3>热门攻略推荐排行</h3>
            <b class="gn-arrow"></b>
          </div>
          <div class="nav-panel rank-panel">
            <ol>
              <li v-for="(item, index) in rankList3" :key="item.id">
                <em class="rank-num">{{ index + 1 }}</em>
                <strong>
                  <a :href="`/destination/details/${item.destId}`" target="_blank">{{ item.destName }}</a>
                </strong>
                <a :href="`/strategy/article/${item.strategyId}`" target="_blank">{{ item.strategyTitle }}</a>
              </li>
            </ol>
          </div>
        </div>
        <div class="nav-item">
          <div class="nav-title">
            <h3>主题推荐</h3>
            <b class="gn-arrow"></b>
          </div>
          <div class="nav-panel category-panel">
            <dl class="clearfix" v-for="item in themeList" :key="item.themeName">
              <dt>{{item.themeName}}</dt>
              <dd><a :title="d.name" href="javascript:void(0)" v-for="d in item.dests" :key="d.id">{{d.name}}&nbsp;&nbsp;&nbsp;&nbsp;</a></dd>
            </dl>
            
          </div>
        </div>
      </div>
      <div class="input_like">
        <div>
          <span></span>
          <input id="search_word" type="text" placeholder="请输入想去的地方，如:香港" />
          <div class="clear"></div>
        </div>
        <div id="search_result" class="search_resu" style="display: none"></div>
      </div>
      <div class="app_d">
        <h3>
          <a href="http://imfw.cn/l/654850" target="_blank">
            <img src="~/assets/images/logo_gonglve_v6.png" alt="" width="50" height="50" />
          </a>
        </h3>
        <div class="domn_in">
          <h4>
            <a href="http://imfw.cn/l/654850" target="_blank">
              带TA游自由行APP下载
              <div style="margin-left: 25px">
                <img src="https://p3-q.mafengwo.net/s12/M00/17/80/wKgED1vb_fqAeZq0AAAxwHmnAuc675.png" style="position: absolute; z-index: 99; width: 130px; display: none" />
              </div>
            </a>
          </h4>
          <p>
            <a style="cursor: auto">iPhone版</a>
            <span>|</span>
            <a style="cursor: auto">Android版</a>
            <span>|</span>
            <a style="cursor: auto">iPad版</a>
          </p>
          <div class="clear"></div>
        </div>
        <div class="clear"></div>
      </div>
    </div>
    <div class="bar-right">
      <el-carousel height="340px" v-if="bannerList.length!=0">
        <el-carousel-item v-for="item in bannerList" :key="item.id">
          <img class="bar-item" :src="item.coverUrl"/>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>
<script setup lang="ts">
import { bannerStrategy, strategtRank ,themeStrategy} from '@/composables/api/strategy'
const bannerList = ref([])
const rankList1 = ref([])
const rankList2 = ref([])
const rankList3 = ref([])
const themeList = ref([])

onMounted(() => {
  nextTick(() => {
    getBannerStrategy()
    getStrategtRank(1)
    getStrategtRank(2)
    getStrategtRank(3)
    getStrategyTheme()
  })
})

// 通过类型(攻略)查询banner
function getBannerStrategy() {
  bannerStrategy()
    .then(res => {
      bannerList.value = res.data
    })
    .catch(err => {
      console.log(err)
    })
}

// 海外/国内/热门-攻略推荐排行
function getStrategtRank(type) {
  strategtRank({ type })
    .then(res => {
      if (type === 1) {
        rankList1.value = res.data
      } else if (type === 2) {
        rankList2.value = res.data
      } else if (type === 3) {
        rankList3.value = res.data
      }
    })
    .catch(err => {
      console.log(err)
    })
}

// 主题
function getStrategyTheme() {
  themeStrategy()
    .then(res => {
      themeList.value = res.data
    })
    .catch(err => {
      console.log(err)
    })
}

</script>
<style lang="scss" scoped>
.strategy-top-bar {
  display: flex;
  justify-content: space-between;
  height: 340px;
  margin: 10px 0 15px;
  .bar-left {
    width: 260px;
    .gonglve-nav {
      position: relative;
      border: 1px solid #ddd;
      border-bottom: 0;
      box-shadow: 0 0.5px 2px rgb(0 0 0 / 10%);
      z-index: 10;
      .nav-item {
        &:hover {
          .nav-title {
            margin-right: -1px;
            color: #ff8a00;
          }
          .nav-panel {
            display: block;
          }
        }
        .nav-title {
          position: relative;
          z-index: 2;
          height: 40px;
          padding: 0 15px;
          border-bottom: 1px solid #ddd;
          background-color: #fff;
          line-height: 40px;
          font-size: 14px;
          color: #666;
          cursor: default;
          h3 {
            font-size: 14px;
            font-weight: normal;
          }
          .gn-arrow {
            position: absolute;
            right: 15px;
            top: 15px;
            width: 6px;
            height: 10px;
            background: url(../../assets/images/new-gl-icon6@2x.png) no-repeat -20px -40px;
            background-size: 60px auto;
            overflow: hidden;
          }
        }
        .nav-panel {
          display: none;
          position: absolute;
          left: 258px;
          top: -1px;
          width: 350px;
          height: 338px;
          border: 1px solid #ddd;
          background-color: #fff;
          box-shadow: 0 3px 2px rgb(0 0 0 / 10%);
        }
        .rank-panel {
          ol {
            position: absolute;
            z-index: 2;
            padding: 15px 10px;
            width: 260px;
            line-height: 30px;
            li {
              height: 30px;
              overflow: hidden;
              &:nth-child(-n + 3) {
                .rank-num {
                  color: #ffa800;
                }
                strong a {
                  color: #ffa800;
                }
              }
              .rank-num {
                float: left;
                width: 30px;
                font-size: 20px;
                font-family: Letter Gothic Std, Verdana, Geneva, sans-serif;
                text-align: right;
                color: #aaa;
                font-weight: bold;
              }
              strong {
                padding: 0 15px;
                font-size: 14px;
                font-weight: normal;
                color: #666;
              }
              a {
                color: #666;
                &:hover {
                  color: #ffa800;
                  text-decoration: underline;
                }
              }
            }
          }
        }
        .category-panel {
          width: 490px;
          padding: 10px 0;
          height: 318px;
          dl {
            margin: 0 0 0 20px;
            padding-left: 60px;
            border: 0;
            font-size: 12px;
            width: auto;
            height: auto;
            line-height: 20px;
            dt {
              float: left;
              display: inline;
              width: 60px;
              height: 20px;
              background: none;
              margin: 5px 0 5px -60px;
              font-weight: bold;
              white-space: nowrap;
              overflow: hidden;
              line-height: 20px;
              font-size: 12px;
              cursor: default;
              color: #666;
              font-weight: bold;
            }
            dd {
              display: inline;
              position: static;
              border: 0;
              width: auto;
              padding: 0;
              float: left;
              margin: 5px 15px 5px 0;
              height: 20px;
              overflow: hidden;
              white-space: nowrap;
              line-height: 20px;
            }
            a {
              color: #666;
              &:hover {
                color: #ffa800;
                text-decoration: underline;
              }
            }
          }
        }
      }
    }
    .input_like {
      position: relative;
      z-index: 10;
      height: 40px;
      margin-top: 10px;
      border: 2px #ffa800 solid;
      span {
        float: left;
        height: 27px;
        width: 29px;
        background: url(../../assets/images/new-gl-icon6@2x.png) -20px -60px no-repeat;
        background-size: 60px auto;
        margin-top: 7px;
        margin-left: 8px;
      }
      input {
        height: 30px;
        line-height: normal;
        float: left;
        width: 206px;
        padding: 3px 0px;
        border: 0px;
        font-size: 12px;
        color: #888888;
        margin-left: 8px;
        margin-top: 2px;
        outline: none;
        font-family: 'Microsoft Yahei', Tahoma, Arial, Helvetica, STHeiti;
      }
    }
    .app_d {
      border-bottom: 1px #e3e3e3 solid;
      height: 50px;
      overflow: hidden;
      padding-bottom: 14px;
      margin-top: 15px;
      h3 {
        float: left;
        height: 50px;
        width: 50px;
        overflow: hidden;
      }
      .domn_in {
        float: left;
        width: 180px;
        margin-left: 18px;
        display: inline;
        h4 {
          font-size: 16px;
          color: #414141;
          line-height: 18px;
          font-weight: normal;
          margin-top: 5px;
        }
        p {
          margin-top: 8px;
          a {
            float: left;
            color: #666;
            line-height: 14px;
          }
          span {
            float: left;
            color: #d8d8d8;
            height: 12px;
            width: 2px;
            line-height: 14px;
            padding: 0px 5px;
            overflow: hidden;
          }
        }
      }
    }
  }
  .bar-right {
    position: relative;
    width: 700px;
    height: 340px;
    overflow: hidden;
    .bar-item {
      width: 100%;
      height: 100%;
    }
  }
}
</style>
