<template>
  <div class="strategy-container">
    <strategy-top-bar />
    <div class="gonglve-wrap clearfix">
      <div class="cont-main">
        <div class="nav-container">
              <div id="list" class="gl_nav">
                <a href="/strategy">全部旅游攻略导航</a>
                <div class="clear"></div>
              </div>
              <div class="gl_wrap">
                <h3><a href="#">国内攻略</a></h3>
                <ol style="height: 28px">
                  <li v-for="item in conditionList2" :key="item.id" @click="search(item.id,item.refid,2)" >
                    <a :style="actId==item.id?dynamicStyles:''">{{ item.name }}({{ item.count }})</a>
                  </li>
                </ol>
                <div class="clear"></div>
              </div>
              <div class="gl_wrap">
                <h3><a href="#">国外攻略</a></h3>
                <ol>
                  <li v-for="item in conditionList1" :key="item.id" @click="search(item.id,item.refid,1)">
                    <a :style="actId==item.id?dynamicStyles:''">{{ item.name }}({{ item.count }})</a>
                  </li>
                </ol>
                <div class="clear"></div>
              </div>
              <div class="gl_wrap">
                <h3><a href="#">主题攻略</a></h3>
                <ol style="height: 28px">
                  <li v-for="item in conditionList3" :key="item.id" @click="search(item.id,item.refid,3)">
                    <a :style="actId==item.id?dynamicStyles:''">{{ item.name }}({{ item.count }})</a>
                  </li>
                </ol>
                <div class="clear"></div>
              </div>
        </div>

        
        <div class="gl-post">
          <div>
            <div v-for="item in strategyData" :key="'banner'+item.id" class="feed-item">
              <NuxtLink :to="'/strategy/article/' + item.id" target="_blank">
                <div class="bar clearfix">
                  <span class="stat" @click.prevent.stop="strategyThumbup(item.id)">
                    <span class="num">{{ item.thumbsupnum }}</span> 蜂蜂顶<i class="icon-hand"></i>
                  </span>
                  <span class="type"><i class="icon-line"></i>来自 <strong>攻略</strong></span>
                </div>
                <div class="title">{{ item.title }}</div>
                <dl class="art clearfix">
                  <dt>
                    <img :src="item.coverUrl" style="width: 220px" />
                  </dt>
                  <dd>
                    <div class="info">
                      {{ item.summary }}
                    </div>
                    <div class="ext-r">
                      <!-- <span class="author">
                        <img
                          src="https://p1-q.mafengwo.net/s9/M00/C4/C9/wKgBs1abqvKAW5J8ABArtHm0A_411.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        />
                        彪標
                      </span> -->
                      <span class="nums">{{ item.viewnum }}浏览，{{ item.replynum }}评论</span>
                    </div>
                  </dd>
                </dl>
              </NuxtLink>
              <div class="hr"></div>
            </div>
            <a v-if="strategyData.length < strategyDataTotal" rel="nofollow" class="_j_page_loader" @click="loadMore"> <span>加载更多</span><i></i> </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { strategyList, strategtCondition, thumbup } from '@/composables/api/strategy'
import { ElMessage } from 'element-plus'

const conditionList1 = ref([])
const conditionList2 = ref([])
const conditionList3 = ref([])
const currentDrop = ref(0)
const strategyParams = reactive({
  orderBy: 'viewnum',
  currentPage: 1,
  refid:null,
  type:null
})

const actId = ref(-1)

const dynamicStyles = ref({
  color: '#fff',
  background: '#ffa800',
});



const strategyDataTotal = ref(0)
const strategyData = ref([])

onMounted(() => {
  nextTick(() => {
    getStrategtCondition(1)
    getStrategtCondition(2)
    getStrategtCondition(3)
    getStrategyList()
  })
})

//条件选择
function search(id, refid, type){
   strategyParams.currentPage = 1
   actId.value = id
   strategyParams.refid = refid
   strategyParams.type = type
  getStrategyList();
}


// 全部旅游(国内/国外/主题)攻略导航
function getStrategtCondition(type) {
  strategtCondition({ type })
    .then(res => {
      if (type === 1) {
        conditionList1.value = res.data
      } else if (type === 2) {
        conditionList2.value = res.data
      } else if (type === 3) {
        conditionList3.value = res.data
      }
    })
    .catch(err => {
      console.log(err)
    })
}


// 攻略-顶一下
function strategyThumbup(id) {
  thumbup({ sid: id,type:1 })
    .then(res => {
      if (res.data) {
        ElMessage({
          message: '顶成功啦',
          type: 'success'
        })

        getStrategyList();
      } else {
        ElMessage({
          message: '今天已经顶过了',
          type: 'success'
        })
      }
    })
    .catch(err => {
      console.log(err)
    })
}

// 攻略列表
function getStrategyList() {
   strategyList(strategyParams)
    .then(res => {
      strategyParams.currentPage === 1 ? (strategyData.value = res.data.records) : (strategyData.value = strategyData.value.concat(res.data.records))
      strategyDataTotal.value = res.data.total
    })
    .catch(err => {
      console.log(err)
    })
}

function loadMore() {
  strategyParams.currentPage++
  getStrategyList()
}

function changeDrop(drop: number) {
  if (currentDrop.value === drop) {
    currentDrop.value = 0
  } else {
    currentDrop.value = drop
  }
}
</script>

<style lang="scss" scoped>
.strategy-container {
  position: relative;
  width: 1000px;
  margin: 15px auto 0;
  .gonglve-wrap {
    margin-top: 15px;
    padding-bottom: 20px;
    .sidebar {
      float: left;
      width: 160px;
      .side-hd {
        height: 50px;
        font-size: 16px;
        color: #333;
        border-bottom: 1px solid #eee;
        line-height: 48px;
      }
      .nav-drop {
        margin-bottom: 10px;
        height: 45px;
        line-height: 25px;
        color: #333;
        border-bottom: 1px solid #eee;
        .drop-item {
          float: left;
          width: 40px;
          font-size: 14px;
          & + .drop-item {
            margin-left: 20px;
            &:before {
              content: '';
              position: absolute;
              margin: 16px 0 0 -10px;
              width: 1px;
              height: 13px;
              background-color: #eee;
            }
          }
          &.drop-open {
            .trigger {
              color: #192885;
              border-bottom: 3px solid #192885;
              i {
                border-top-color: #192885;
              }
            }
            .drop-pop {
              display: block;
              z-index: 1;
            }
          }
          .trigger {
            padding: 10px 0;
            height: 22px;
            cursor: pointer;
            i {
              float: right;
              margin-top: 10px;
              border-top: 4px solid #999;
              border-left: 4px dashed transparent;
              border-right: 4px dashed transparent;
              font-size: 0;
              overflow: hidden;
            }
          }
          .drop-pop {
            position: absolute;
            margin-top: 10px;
            width: 410px;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            line-height: 30px;
            display: none;
            .inner {
              overflow: hidden;
              ul {
                margin-left: -15px;
                li {
                  float: left;
                  margin: 0 15px;
                  &:before {
                    content: '';
                    float: left;
                    margin: 8px 0 0 -15px;
                    width: 1px;
                    height: 13px;
                    background-color: #eee;
                  }
                  a {
                    color: #333;
                    &:hover {
                      color: #ffa800;
                      text-decoration: underline;
                    }
                  }
                }
              }
            }
          }
        }
      }
      .rank {
        li {
          padding: 15px 0;
          & + li {
            border-top: 1px solid #f7f7f7;
            line-height: 24px;
          }
          .num {
            float: left;
            margin-right: 10px;
            font-size: 18px;
            color: #192885;
          }
          a {
            color: #333;
            font-size: 14px;
            &:hover {
              color: #ffa800;
              text-decoration: underline;
            }
          }
        }
        .gl_list {
          width: 130px;
          margin-right: 40px;
          float: none;
          a {
            color: #333;
            font-size: 14px;
            img {
              width: 100%;
              height: 100%;
            }
          }
          .time {
            margin: 5px 0;
            text-align: center;
          }
          .down_cout {
            height: 24px;
            width: 130px;
            background: #ebebeb;
            border-radius: 30px;
            margin-top: 5px;
            position: relative;
            span {
              display: block;
              position: absolute;
              top: 0px;
              left: 0px;
              height: 24px;
              width: 24px;
              background: url(../../assets/images/new-gl-icon6@2x.png) -20px -90px no-repeat;
              background-size: 60px auto;
            }
            p {
              line-height: 24px;
              color: #666;
              padding-left: 30px;
            }
          }
        }
      }
    }
    .cont-main {
      float: right;
      margin-bottom: 20px;
      .hd {
        height: 50px;
        border-bottom: 1px solid #eee;
        line-height: 48px;
        h3 {
          float: left;
          font-weight: normal;
          font-size: 20px;
          color: #333;
        }
      }
      .feed-item {
        padding: 20px 0;
        font-size: 14px;
        line-height: 24px;
        &:hover {
          background-color: #f8f8f8;
          padding: 21px 15px 20px;
          margin: -1px -15px 0;
          .title {
            color: #192885;
          }
        }
        a {
          display: block;
        }
        .stat {
          float: right;
          padding: 0 15px;
          line-height: 30px;
          border: 1px solid #192885;
          border-radius: 15px;
          font-size: 14px;
          background-color: #fff;
          color: #666;
          .num {
            color: #192885;
          }
          .icon-hand {
            display: inline-block;
            margin-left: 10px;
            width: 15px;
            height: 15px;
            background: url(../../assets/images/new-gl-icon6@2x.png) no-repeat -40px -40px;
            background-size: 60px auto;
            overflow: hidden;
            vertical-align: -2px;
          }
          .icon-card {
            display: inline-block;
            margin-left: 10px;
            width: 16px;
            height: 15px;
            background: url(../../assets/images/new-gl-icon6@2x.png) no-repeat -20px -116px;
            background-size: 60px auto;
            overflow: hidden;
            vertical-align: -2px;
          }
        }
        .type {
          float: left;
          display: inline-block;
          line-height: 20px;
          font-size: 12px;
          color: #666;
          i {
            float: left;
            margin-right: 10px;
            width: 20px;
            height: 20px;
            background: url(../../assets/images/new-gl-icon6@2x.png) no-repeat 0 0;
            background-size: 60px auto;
            overflow: hidden;
          }
          .icon-line {
            background-position: 0 -40px;
          }
          strong {
            font-weight: normal;
            color: #192885;
          }
        }
        .title {
          margin-bottom: 15px;
          font-size: 20px;
          color: #333;
        }
        .art {
          dt {
            float: left;
            width: 220px;
            display: inline;
            margin-right: 20px;
          }
          dd {
            overflow: hidden;
          }
          .info {
            height: 102px;
            padding-top: 10px;
            margin-bottom: 16px;
            color: #666;
          }
          .ext-r {
            float: right;
            color: #999;
            line-height: 22px;
            font-size: 12px;
          }
        }
        .author {
          display: inline-block;
          margin-right: 10px;
          font-size: 12px;
          color: #192885;
          img {
            margin-right: 5px;
            width: 16px;
            height: 16px;
            border-radius: 50%;
            overflow: hidden;
            vertical-align: middle;
          }
        }
      }
      .hr {
        margin-top: 20px;
        height: 1px;
        background-color: #e5e5e5;
        overflow: hidden;
      }
      ._j_page_loader {
        background-color: #fff5e5;
        border-radius: 4px;
        color: #666;
        display: block;
        height: 40px;
        line-height: 40px;
        text-align: center;
        width: 100%;
        i {
          background: rgba(0, 0, 0, 0) url(../../assets/images/mfwask-2016sprite_v3.png) no-repeat scroll 0 -592px;
          display: inline-block;
          height: 10px;
          margin-left: 6px;
          width: 10px;
        }
      }
      .hr + a,
      ._j_page_loader {
        margin-top: 10px;
      }
    }
  }
    .nav-container {
    position: relative;
    .gl_nav {
      line-height: 16px;
      color: #666666;
      margin-top: 35px;
      margin-bottom: 15px;
      a {
        float: left;
        font-size: 16px;
        color: #ffa801;
      }
      span {
        float: left;
        font-size: 18px;
        margin-left: 12px;
      }
      strong {
        float: left;
        font-size: 16px;
        font-weight: normal;
        margin-left: 12px;
      }
    }
    .gl_wrap {
      border-bottom: 1px #e3e3e3 solid;
      width: 980px;
      padding-bottom: 8px;
      margin-top: 5px;
      overflow: hidden;
      h3 {
        float: left;
        font-size: 14px;
        color: #333;
        line-height: 16px;
        margin-top: 7px;
        a {
          color: #333;
          &:hover {
            color: #ffa801;
            text-decoration: underline;
          }
        }
      }
      ol {
        float: left;
        width: 790px;
        margin-left: 8px;
        height: 28px;
        display: inline;
        overflow: hidden;
        li {
          float: left;
          height: 22px;
          margin-left: 5px;
          margin-top: 5px;
          display: inline;
          white-space: nowrap;
          a {
            display: block;
            float: left;
            height: 22px;
            line-height: 22px;
            color: #666;
            padding: 0px 8px;
            &:hover {
              color: #fff;
              background: #ffa800;
              text-decoration: none;
            }
          }
        }
      }
      span {
        float: left;
        width: 42px;
        height: 16px;
        margin-left: 10px;
        margin-top: 7px;
        a {
          display: block;
          width: 42px;
          height: 16px;
          background: url(../../assets/images/ms.png) 0px 0px no-repeat;
          text-indent: -10000px;
          overflow: hidden;
          &:hover {
            background: url(../../assets/images/ms.png) -43px 0px no-repeat;
          }
          &.sp_toggle {
            background: url(../../assets/images/ms.png) 0px -17px no-repeat;
          }
        }
      }
    }
    .p_upw {
      margin-top: 30px;
      .uptime_p {
        float: left;
        margin-top: 5px;
        a {
          float: left;
          font-size: 14px;
          color: #666;
          line-height: 16px;
          padding-bottom: 4px;
          &.upt_on {
            color: #ffa800;
            border-bottom: 2px #ffa800 solid;
          }
        }
        span {
          float: left;
          color: #d8d8d8;
          padding: 0px 12px;
        }
      }
      .mfw_de {
        float: right;
        height: 28px;
        line-height: 28px;
        padding: 0px 28px;
        background: #f1f1f1;
        border-radius: 30px;
      }
    }
    .gonglve_wrap {
      margin-top: 15px;
      padding-bottom: 20px;
      .gl_fw {
        border-bottom: 1px #e4e4e4 dotted;
        width: 980px;
        overflow: hidden;
        padding-bottom: 25px;
        margin-top: 25px;
        .gl_cw {
          width: 1020px;
          .gl_list {
            width: 130px;
            float: left;
            margin-right: 40px;
            a {
              display: block;
              height: 184px;
              width: 130px;
              overflow: hidden;
            }
            .update_time {
              margin-top: 5px;
              text-align: center;
              font-size: 10px;
            }
            .down_cout {
              height: 24px;
              width: 130px;
              background: #ebebeb;
              border-radius: 30px;
              margin-top: 5px;
              position: relative;
              span {
                display: block;
                position: absolute;
                top: 0px;
                left: 0px;
                height: 24px;
                width: 24px;
                background: url(../../assets/images/new-gl-icon6@2x.png) -20px -90px no-repeat;
                background-size: 60px auto;
              }
              p {
                line-height: 24px;
                color: #666;
                padding-left: 30px;
              }
            }
          }
        }
      }
      .show_more {
        border-bottom: 1px #e4e4e4 dotted;
        height: 35px;
        text-align: center;
        line-height: 35px;
        a {
          color: #ff8903;
          &:hover {
            outline: 0;
            text-decoration: underline;
          }
        }
      }
    }
  }
}
</style>
