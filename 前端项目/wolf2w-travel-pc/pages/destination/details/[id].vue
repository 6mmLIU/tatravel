<template>
  <div class="details-container">
    <div class="row row-placeTop row-bg">
      <div class="wrapper">
        <div class="extra mfw-acc-hide">
          <div class="action">
            <a class="btn-collect" href="javascript:void(0)">
              <i class="icon"></i>
              收藏
            </a>
            <a class="btn-been" href="javascript:void(0)"><i class="icon"></i>去过</a>
          </div>
        </div>
        <div class="crumb">
          <div class="item"><a href="/destination" target="_blank">目的地</a><em>&gt;</em></div>

          <div v-for="item in toastsList" :key="item.id" class="item">
            <div class="drop">
              <span class="hd">
                <a :href="'/destination/details/' + item.id" target="_blank">{{ item.name }}</a>
              </span>
            </div>
            <em>&gt;</em>
          </div>
          
          <div class="item cur" v-if="toastsList.length">
            <strong>{{ toastsList[toastsList.length - 1].name }}旅游攻略</strong>
          </div>
        </div>
        <div class="title" v-if="toastsList.length">
          <h1>{{ toastsList[toastsList.length - 1].name }}</h1>
          <br />
          <span class="en">{{ toastsList[toastsList.length - 1].english }}</span>
        </div>
        <div class="place-navbar mfw-acc-hide" style="border-top: 0">
          <div class="navbar-con">
            <ul class="navbar clearfix navbar-first-level-warper">
              <li class="navbar-overview city-guide" @mouseenter="showOverview()">
                <a class="navbar-btn" :href="'/destination/survey/' + destId" data-cs-p="概况"> <i class="navbar-icon"></i><span>概况</span> </a>
              </li>
              <li class="navbar-line">
                <a class="navbar-btn" href="" data-cs-p="行程线路"> <i class="navbar-icon"></i><span>行程线路</span> </a>
              </li>
              <li class="navbar-scenic">
                <a class="navbar-btn" href="" data-cs-p="景点"> <i class="navbar-icon"></i><span>景点</span> </a>
              </li>
              <li class="navbar-hotels">
                <a class="navbar-btn" href="" data-cs-p="酒店"> <i class="navbar-icon"></i><span>酒店</span> </a>
              </li>
              <li class="navbar-flight">
                <a class="navbar-btn" href="" target="_blank" data-cs-p="机票"> <i class="navbar-icon"></i><span>机票</span> </a>
              </li>
              <li class="navbar-local navbar-dropdown">
                <a class="navbar-btn" href="" target="_blank" data-cs-p="当地玩乐">
                  <i class="navbar-icon"></i>
                  <span> 当地玩乐 </span>
                  <em class="drop-corner"></em>
                  <b class="d12"></b>
                </a>
                <div class="navbar-dropmenu hide">
                  <ul class="navbar-sub clearfix">
                    <li>
                      <a href="" target="_blank" data-cs-p="旅游服务">旅游服务</a>
                    </li>
                    <li>
                      <a href="" target="_blank" data-cs-p="景点门票">景点门票</a>
                    </li>
                    <li>
                      <a href="" target="_blank" data-cs-p="当地体验">当地体验</a>
                    </li>
                    <li>
                      <a href="" target="_blank" data-cs-p="酒店套餐">酒店套餐</a>
                    </li>
                    <li>
                      <a href="" target="_blank" data-cs-p="一日游">一日游</a>
                    </li>
                    <li>
                      <a href="" target="_blank" data-cs-p="多日游">多日游</a>
                    </li>
                    <li class="special"><b class="d12"></b><a href="" target="_blank">专区</a></li>
                  </ul>
                </div>
              </li>
              <li class="navbar-sales navbar-dropdown">
                <a class="navbar-btn" href="/sales/0-0-M10065-0-0-0-0-0.html" target="_blank" data-cs-p="旅游度假">
                  <i class="navbar-icon"></i>
                  <span> 旅游度假 </span>
                  <em class="drop-corner"></em>
                  <b class="d12"></b>
                </a>
                <div class="navbar-dropmenu hide">
                  <ul class="navbar-sub clearfix">
                    <li>
                      <a href="/sales/0-0-M10065-0-0-0-0-0.html" target="_blank" data-cs-p="自由行">自由行</a>
                    </li>
                    <li>
                      <a href="/sales/0-0-M10065-0-0-0-0-0.html?group=4" target="_blank" data-cs-p="跟团游">跟团游</a>
                    </li>
                    <li>
                      <a href="/sales/0-0-10065-28-0-0-0-0.html" target="_blank" data-cs-p="自由行定制">自由行定制</a>
                    </li>
                    <li>
                      <a href="/sales/0-0-10065-32-0-0-0-0.html?group=4" target="_blank" data-cs-p="私家团">私家团</a>
                    </li>
                    <li>
                      <a href="/sales/0-0-10065-36-0-0-0-0.html?group=4" target="_blank" data-cs-p="半自助游">半自助游</a>
                    </li>
                    <li class="special"><b class="d12"></b><a href="" target="_blank">专区</a></li>
                  </ul>
                </div>
              </li>
              <li class="navbar-community navbar-dropdown">
                <a class="navbar-btn">
                  <i class="navbar-icon"></i>
                  <span> 社区 </span>
                  <em class="drop-corner"></em>
                  <b class="d12"></b>
                </a>
                <div class="navbar-dropmenu hide">
                  <ul class="navbar-sub clearfix">
                    <li>
                      <a href="/yj/10065/" data-cs-p="游记">游记</a>
                    </li>
                    <li>
                      <a href="/xc/10065/" data-cs-p="行程">行程</a>
                    </li>
                    <li>
                      <a href="/wenda/area-10065.html?sFrom=mdd" data-cs-p="问答">问答</a>
                    </li>
                    <li>
                      <a href="/gonglve/mdd-10065.html" target="_blank" data-cs-p="攻略">攻略</a>
                    </li>
                    <li class="special"><b class="d12"></b><a href="" target="_blank">专区</a></li>
                  </ul>
                </div>
              </li>
              <li class="navbar-food navbar-dropdown">
                <a class="navbar-btn">
                  <i class="navbar-icon"></i>
                  <span> 餐饮 </span>
                  <em class="drop-corner"></em>
                  <b class="d12"></b>
                </a>
                <div class="navbar-dropmenu hide">
                  <ul class="navbar-sub clearfix">
                    <li>
                      <a href="/cy/10065/gonglve.html" data-cs-p="餐饮">餐饮</a>
                    </li>
                    <li>
                      <a href="/gw/10065/gonglve.html" data-cs-p="购物">购物</a>
                    </li>
                    <li>
                      <a href="/yl/10065/gonglve.html" data-cs-p="娱乐">娱乐</a>
                    </li>
                    <li class="special"><b class="d12"></b><a href="" target="_blank">专区</a></li>
                  </ul>
                </div>
              </li>
              <li class="navbar-maps navbar-last">
                <a class="navbar-btn" href="" target="_blank" data-cs-p="地图">
                  <i class="navbar-icon"></i><span>地图</span>

                  <i class="i-hot">new</i>
                </a>
              </li>
            </ul>
            <div v-show="overviewState" class="overview-drop" data-cs-p="概况菜单" style="max-height: 520px; overflow: auto" @mouseleave="hideOverview()">
              <div class="drop-bd">
                <dl v-for="item in catalogsList" :key="item.id" class="clearfix">
                  <dt>
                    <a :href="'/destination/survey/' + destId" target="_blank">{{ item.name }}</a>
                  </dt>
                  <dd>
                    <a v-for="(item2, index) in item.strategies" :key="item2.id" :href="'/strategy/article/' + item2.id" target="_blank"> {{ item2.title }}<span v-if="index < item.strategies.length">|</span> </a>
                  </dd>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row clearfix">
      <destination-classic-route />
    </div>
    <div class="row row-bg clearfix">
      <destination-travel-ranking />
    </div>
    <div class="row clearfix">
      <destination-independent-travel :destid="destId" />
    </div>
    <div class="row row-bg clearfix">
      <destination-hotel-selection />
    </div>
    <div class="row clearfix">
      <destination-travel-mall />
    </div>
    <div class="row row-bg clearfix">
      <destination-questions />
    </div>
    <div class="row clearfix">
      <destination-strategy-download />
    </div>
    <div class="row row-bg clearfix">
      <destination-travels :destid="destId" />
    </div>
    <div class="row clearfix">
      <destination-periphery />
    </div>
  </div>
</template>
<script setup lang="ts">
import { catalogs, toasts } from '@/composables/api/destination'
const route = useRoute()
const destId = route.params.id.toString()
const overviewState = ref(false)
const catalogsList = ref([])
const toastsList = ref([])

onMounted(() => {
  nextTick(() => {
    getToasts()
    getCatalogs()
  })
})

function showOverview() {
  overviewState.value = true
}
function hideOverview() {
  overviewState.value = false
}
function getCatalogs() {
  catalogs({ destId: destId })
    .then(res => {
      catalogsList.value = res.data
    })
    .catch(err => {
      console.log(err)
    })
}
function getToasts() {
  toasts({ destId: destId })
    .then(res => {
      toastsList.value = res.data
    })
    .catch(err => {
      console.log(err)
    })
}
</script>
<style lang="scss" scoped>
.details-container {
  position: relative;
  .wrapper {
    width: 1000px;
    margin: 0 auto;
  }
  .row {
    padding: 40px 0;
    min-width: 980px;
    border-bottom: 1px solid #e4e4e4;
  }
  .row-bg {
    background-color: #fafafa;
  }
  .row-placeTop {
    padding: 0;
    background-color: #fafafa;
    .extra {
      float: right;
      padding-top: 10px;
      text-align: right;
      position: relative;
      z-index: 2;
    }
    .action {
      margin-top: 25px;
      .btn-collect {
        display: inline-block;
        height: 30px;
        margin-left: 20px;
        color: #333;
        line-height: 15px;
        vertical-align: top;
        line-height: 30px;
        font-size: 14px;
        &:hover .icon {
          background-position: -260px 0;
        }
      }
      .btn-been {
        display: inline-block;
        height: 30px;
        margin-left: 20px;
        color: #333;
        line-height: 15px;
        vertical-align: top;
        line-height: 30px;
        font-size: 14px;
        .icon {
          background-position: -230px -30px;
        }
        &:hover .icon {
          background-position: -260px -30px;
        }
      }
      .icon {
        float: left;
        margin-right: 10px;
        width: 30px;
        height: 30px;
        background: url(../../../assets/images/poiV3-sprite6.png) no-repeat -230px 0;
        overflow: hidden;
      }
    }
    .crumb {
      width: 1000px;
      font: 12px Arial, 'Microsoft Yahei', '\5FAE\8F6F\96C5\9ED1', Tahoma, Helvetica, STHeiti, 'Hiragino Sans GB';
      height: 20px;
      padding: 15px 0;
      color: #666;
      line-height: 20px;
      margin: 0 auto;
      .item {
        float: left;
        &:hover {
          .drop {
            .hd {
              a {
                background-color: #ff7000;
                color: #fff;
              }
              i {
                border-top-color: #fff;
              }
            }
            .bd {
              display: block;
            }
          }
        }
        em {
          margin: 0 6px;
          color: #999;
          font-family: 'simsun';
          font-style: normal;
        }
        .drop {
          float: left;
          .hd {
            height: 20px;
            a {
              display: block;
              height: 20px;
              padding: 0 13px 0 5px;
            }
            i {
              position: absolute;
              margin: 8px 0 0 3px;
              width: 0;
              height: 0;
              border-top: 3px solid #ff7000;
              border-left: 3px dashed transparent;
              border-right: 3px dashed transparent;
              overflow: hidden;
              font-size: 0;
            }
          }
          .bd {
            position: absolute;
            display: none;
            margin: 5px 0 0 -10px;
            z-index: 20;
            padding: 10px 0 8px 7px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            .arrow {
              position: absolute;
              left: 20px;
              top: -6px;
              width: 0;
              height: 0;
              border-bottom: 6px solid #e5e5e5;
              border-left: 6px dashed transparent;
              border-right: 6px dashed transparent;
              font-size: 0;
              b {
                position: absolute;
                left: -6px;
                top: 2px;
                width: 0;
                height: 0;
                border-bottom: 6px solid #fff;
                border-left: 6px dashed transparent;
                border-right: 9px dashed transparent;
                font-size: 0;
                overflow: hidden;
              }
            }
          }
          .col {
            float: left;
            width: 145px;
          }
          h3 {
            padding-left: 7px;
            color: #333;
            font-weight: bold;
          }
          li {
            float: left;
            display: inline;
            width: 137px;
            margin: 4px 8px 0 0;
            height: 21px;
            line-height: 20px;
            overflow: hidden;
            a {
              display: block;
              height: 21px;
              padding: 0 7px;
              color: #333;
              &:hover {
                background-color: #fff1d7;
                color: #ff7000;
                text-decoration: none;
              }
            }
          }
          .more {
            clear: both;
            padding: 10px 20px 0 0;
            text-align: right;
            a {
              color: #ff7000;
            }
          }
        }
        a {
          color: #666;
          font-size: 12px;
        }
      }
    }
    .title {
      margin: 0 0 20px;
      h1 {
        display: inline;
        margin-right: 15px;
        font-weight: normal;
        font-size: 40px;
        color: #333;
      }
      .num-photo {
        color: #999;
        font-size: 14px;
        em {
          font-style: normal;
          color: #192885;
        }
      }
      .en {
        font-size: 20px;
        color: #999;
      }
    }
    .place-navbar {
      height: 75px;
      margin-bottom: 0;
      border-bottom: 0;
      z-index: 1001;
      .navbar-con {
        width: 1000px;
        margin: 0 auto;
        .overview-drop {
          position: absolute;
          margin-top: 7px;
          z-index: 1001;
          width: 798px;
          border: 1px solid #e5e5e5;
          background-color: #fff;
          box-shadow: 0 3px 0 rgb(0 0 0 / 20%);
          .drop-bd {
            padding: 30px 50px;
            dl {
              padding-left: 125px;
              line-height: 36px;
            }
            dt {
              float: left;
              display: inline;
              margin: 0 0 0 -125px;
              width: 96px;
              color: #654939;
              font-size: 16px;
              height: 36px;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
              a {
                color: #333;
                &:hover {
                  outline: 0;
                  text-decoration: underline;
                }
              }
            }
            dd {
              font-size: 14px;
              color: #333;
              a {
                float: none;
                height: auto;
                color: #333;
                &:hover {
                  outline: 0;
                  text-decoration: underline;
                }
              }
              span {
                display: inline-block;
                width: 1px;
                height: 10px;
                margin: 0 13px;
                background-color: #ddd;
                vertical-align: middle;
                overflow: hidden;
                line-height: 100px;
              }
            }
          }
        }
      }
      li[class|='navbar'] {
        float: left;
        display: inline;
        margin-right: 18px;
        font-size: 16px;
        line-height: 32px;
        &:hover {
          .hide {
            display: block;
          }
        }
      }
      .hide {
        display: none;
      }
      .active {
        .navbar-btn {
          text-decoration: none;
          color: #333;
          border-bottom: 3px solid;
          padding-bottom: 20px;
        }
      }
      .navbar-btn {
        display: block;
        height: 32px;
        padding: 20px 0 23px;
        color: #666;
        font-size: 14px;
        line-height: 32px;
        position: relative;
        &:hover {
          text-decoration: none;
          color: #333;
          border-bottom: 3px solid;
          padding-bottom: 20px;
        }
      }
      .navbar-overview .navbar-btn:hover,
      .navbar-overview.active .navbar-btn {
        border-color: #aea181;
      }
      .navbar-line .navbar-btn:hover,
      .navbar-line.active .navbar-btn {
        border-color: #74b9f3;
      }
      .navbar-scenic .navbar-btn:hover,
      .navbar-scenic.active .navbar-btn {
        border-color: #4dc854;
      }
      .navbar-hotels .navbar-btn:hover,
      .navbar-hotels.active .navbar-btn {
        border-color: #0a89e4;
      }
      .navbar-flight .navbar-btn:hover,
      .navbar-flight.active .navbar-btn {
        border-color: #0a89e4;
      }
      .navbar-local .navbar-btn:hover,
      .navbar-local.active .navbar-btn {
        border-color: #bada25;
      }
      .navbar-sales .navbar-btn:hover,
      .navbar-sales.active .navbar-btn {
        border-color: #e7788e;
      }
      .navbar-community .navbar-btn:hover,
      .navbar-community.active .navbar-btn {
        border-color: #192885;
      }
      .navbar-food .navbar-btn:hover,
      .navbar-food.active .navbar-btn {
        border-color: #f07d6c;
      }
      .navbar-maps .navbar-btn:hover,
      .navbar-maps.active .navbar-btn {
        border-color: #63c799;
      }
      .drop-corner {
        display: inline-block;
        margin-left: 5px;
        width: 0;
        height: 0;
        border-width: 3px;
        border-color: transparent #666 #666 transparent;
        border-style: dashed solid solid dashed;
        overflow: hidden;
      }
      .i-hot {
        position: absolute;
        height: 14px;
        background-color: #f46240;
        color: #fff;
        font-size: 12px;
        line-height: 14px;
        padding: 0 4px 0 3px;
        font-style: normal;
        white-space: nowrap;
        margin: 0;
        right: -24px;
        top: 13px;
        &::after {
          content: '';
          position: absolute;
          left: -7px;
          top: 0;
          width: 0;
          height: 0;
          border-right: 7px solid #f46240;
          border-top: 7px solid transparent;
          border-bottom: 7px dashed transparent;
          overflow: hidden;
          line-height: 0;
        }
      }
      .navbar-dropmenu {
        position: absolute;
        padding: 30px;
        border: 1px solid #e5e5e5;
        background-color: #fff;
        background-color: rgba(255, 255, 255, 0.95);
        overflow: hidden;
        line-height: 40px;
        z-index: 2000;
        ul {
          width: 245px;
          li {
            float: left;
            width: 90px;
            padding-left: 22px;
            a {
              color: #666;
              &:hover {
                outline: 0;
                text-decoration: underline;
                color: #192885;
              }
            }
            .special {
              display: none;
            }
          }
        }
      }
      .navbar-icon {
        float: left;
        width: 32px;
        height: 32px;
        margin-right: 6px;
        background: url(../../../assets/images/icon-place-nav6.png) no-repeat;
        overflow: hidden;
      }
      .navbar-overview .navbar-icon {
        background-position: 0 0;
      }
      .navbar-line .navbar-icon {
        background-position: 0 -40px;
      }
      .navbar-scenic .navbar-icon {
        background-position: 0 -320px;
      }
      .navbar-hotels .navbar-icon {
        background-position: 0 -120px;
      }
      .navbar-flight .navbar-icon {
        background: url(https://p3-q.mafengwo.net/s13/M00/34/CC/wKgEaVy32LKAK8RHAAAF8WtcgSw031.png) no-repeat;
        background-size: contain;
      }
      .navbar-local .navbar-icon {
        background-position: 0 -200px;
      }
      .navbar-sales .navbar-icon {
        background-position: 0 -160px;
      }
      .navbar-community .navbar-icon {
        background-position: 0 -240px;
      }
      .navbar-food .navbar-icon {
        background-position: 0 -360px;
      }
      .navbar-maps .navbar-icon {
        background-position: 0 -400px;
      }
    }
  }
}
</style>
