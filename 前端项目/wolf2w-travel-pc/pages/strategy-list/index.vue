<template>
  <div class="strategy-container">
    <strategy-top-bar />
    <div class="nav-container">
      <div id="list" class="gl_nav">
        <a href="/strategy">全部旅游攻略导航</a>
        <span>&gt;</span>
        <strong>北京</strong>
        <div class="clear"></div>
      </div>
      <div class="gl_wrap">
        <h3><a href="/gonglve/mdd-cn-0-0-1.html#list">国内攻略</a></h3>
        <ol style="height: 28px">
          <li v-for="item in conditionList2" :key="item.id">
            <a>{{ item.name }}({{ item.count }})</a>
          </li>
        </ol>
        <div class="clear"></div>
      </div>
      <div class="gl_wrap">
        <h3><a href="/gonglve/mdd-fo-0-0-1.html#list">国外攻略</a></h3>
        <ol>
          <li v-for="item in conditionList1" :key="item.id">
            <a>{{ item.name }}({{ item.count }})</a>
          </li>
        </ol>
        <div class="clear"></div>
      </div>
      <div class="gl_wrap">
        <h3><a href="/gonglve/zt-1000-0-0-0.html#list">主题攻略</a></h3>
        <ol style="height: 28px">
          <li v-for="item in conditionList3" :key="item.id">
            <a>{{ item.name }}({{ item.count }})</a>
          </li>
        </ol>
        <div class="clear"></div>
      </div>
      <div class="p_upw">
        <div class="uptime_p">
          <a href="" class="upt_on">本月最受欢迎</a>
          <span>|</span>
          <a href="">下载人气</a>
          <span>|</span>
          <a href="/gonglve/mdd-bj-1-0-1.html#list">更新时间</a>
          <div class="clear"></div>
        </div>
        <div class="mfw_de">
          <p>
            带TA游旅游攻略已覆盖全球 <a href="/gonglve/mdd-cn-0-0-0.html#list"><span>516</span></a> 个地区 <a href="/gonglve/zt-1000-0-0-0.html#list"><span>240</span></a> 个品类。已有<span> 443046978 </span>位蜂蜂的旅行从这里开始
          </p>
        </div>
        <div class="clear"></div>
      </div>
      <div class="gonglve_wrap">
        <div class="gl_fw">
          <div class="gl_cw">
            <div class="gl_list">
              <a href="/strategy/details/1" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/strategy/details/1" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/strategy/details/1" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/gonglve/zt-579.html" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/gonglve/zt-579.html" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/gonglve/zt-579.html" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="clear"></div>
          </div>
        </div>
        <div class="gl_fw">
          <div class="gl_cw">
            <div class="gl_list">
              <a href="/gonglve/zt-579.html" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/gonglve/zt-579.html" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/gonglve/zt-579.html" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="gl_list">
              <a href="/gonglve/zt-579.html" title="青藏线自驾" target="_blank">
                <img src="https://p1-q.mafengwo.net/s7/M00/B5/EC/wKgB6lOyj1WAPQE6AANxJ0Sotp058.jpeg?imageMogr2%2Fthumbnail%2F%21130x184r%2Fgravity%2FCenter%2Fcrop%2F%21130x184%2Fquality%2F90" alt="青藏线自驾" />
              </a>
              <div class="update_time">更新时间：2014-09-01</div>
              <div class="down_cout">
                <span></span>
                <p>157538人下载</p>
              </div>
            </div>
            <div class="clear"></div>
          </div>
        </div>
        <div class="show_more">
          <a id="pager" href="javascript:void(0);" rel="mdd-14383-0-0">显示更多</a>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { strategtCondition } from '@/composables/api/strategy'

const conditionList1 = ref([])
const conditionList2 = ref([])
const conditionList3 = ref([])

onMounted(() => {
  nextTick(() => {
    getStrategtCondition(1)
    getStrategtCondition(2)
    getStrategtCondition(3)
  })
})

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
</script>

<style lang="scss" scoped>
.strategy-container {
  position: relative;
  width: 1000px;
  margin: 15px auto 0;
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
