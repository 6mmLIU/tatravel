<template>
  <div class="footprint-body">
    <div class="MAvatar clearfix _j_hide_user_head mfw-acc-hide">
      <div class="MAvaImg flt1">
        <img width="120" height="120" alt="" src="https://p1-q.mafengwo.net/s12/M00/35/6C/wKgED1uqIpCARLIhAAAZUeRPlFM676.png?imageMogr2%2Fthumbnail%2F%21200x200r%2Fgravity%2FCenter%2Fcrop%2F%21200x200%2Fquality%2F90">
      </div>
      <div class="MAvaEasyWord flt1">
        <span class="MAvaName">带TA游用户(阿坝)</span>
        <span class="MAvaLevel">Lv.2</span>
      </div>
    </div>
      <div class="footprint-left">
        <div id="_j_mddnav">
          <div class="line-nav" id="_j_navlistcnt" style="margin-right: -20px; padding-right: 20px; max-height: 857px; position: relative; overflow-y: hidden;">
            <dl class="nav-group _j_timeline nav-sort" v-for="(item, ide) in timeData" :key="ide" :class="Tide == ide ? 'on' : ''" @click="Tide = ide">
              <dt><a><strong>{{ item }}</strong><i></i></a></dt>
            </dl>

            <div class="_j_timeline_subnav hide">
            </div>
            <div class="_j_country_subnav">
            </div>

          </div>
          <div class="scrollbar" style="position: absolute; right: 0px; top: 0px; width: 4px; height: 100px; background-color: rgb(214, 214, 214); border-radius: 10px; cursor: pointer; z-index: -1; opacity: 0; display: none;"></div></div>
      </div>

      <div class="line-main" id="tips">
        <div class="_j_profile">
          <div class="profile">
            <div class="stats">
              走过<b>0</b>国家，到过<b>0</b>城市，留下<b>0</b>足迹
            </div>
            <dl class="badge-info">
              <dt><span>共收集</span><br>城市勋章</dt>
              <dd class="first">
                <span class="badge star1-0" data-japp="city_level_dialog" data-jappconf="path"></span>
                <span class="num">我想获得</span>
              </dd>
              <dd>
                <span class="badge star2-0" data-japp="city_level_dialog" data-jappconf="path"></span>
                <span class="num">我想获得</span>
              </dd>
              <dd>
                <span class="badge star3-0" data-japp="city_level_dialog" data-jappconf="path"></span>
                <span class="num">我想获得</span>
              </dd>
              <dd>
                <span class="badge star4-0" data-japp="city_level_dialog" data-jappconf="path"></span>
                <span class="num">我想获得</span>
              </dd>
              <dd>
                <span class="badge star5-0" data-japp="city_level_dialog" data-jappconf="path"></span>
                <span class="num">我想获得</span>
              </dd>
            </dl>
          </div>

        </div>

        <div id="_j_countrylistwrap">
          <div class="_j_countrylist"></div>
          <div class="loading _j_loadmore" style="display: none;">
            <i></i><br>正在加载更多足迹...
          </div>
        </div>

      </div>
  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'personal'
})
const timeData = ref(['按时间排序', '按国家排序'])
const Tide = ref(0)
</script>

<style scoped lang="scss">

.MAvatar {
  position: absolute;
  left: 30px;
  top: -140px;
  display: flex;
  flex-direction: row;
  align-items: center;
  .MAvaImg {
    width: 120px;
    height: 120px;
    border-radius:50%;
    overflow: hidden;
    margin-right:10px;
  }
  .MAvaName {
    color: #fff;
    font-size: 16px;
    line-height: 24px;
    margin-top: 16px;
  }
  .MAvaEasyWord {
    margin-top: -7px;
  }
  .MAvaLevel {
    font-size: 16px;
    color: #ea3c1a;
  }
}
.footprint-body {
  position: relative;
  display: flex;
  flex-direction: row;
  .footprint-left {
    flex:1;
    padding-top:210px;
    box-sizing: border-box;
    .line-nav {
      width: 188px;
      margin-left: -50px;
      text-align: right;
      .nav-group {
        padding-right: 24px;
        margin-left: -20px;
        _white-space: nowrap;
        color: #666;
        dt {
          position: relative;
          margin: 15px 0;
          font-size: 16px;
          line-height: 28px;
          _width: 108px;
          a {
            color:#666;
          }
          strong {
            font-weight: normal;
          }
          i {
            position: absolute;
            right: -31px;
            top: 10px;
            width: 8px;
            height: 8px;
            background: #ccc;
            border: 2px solid #fff;
            border-radius: 50%;
          }
        }
        &.on {
          dt {
            a {
              color: #ff8a00;
            }
            i {
              background: #ff8a00;
            }
          }
        }
        &:hover {
          a {
            color: #ff8a00;
          }
        }
      }
    }
  }
}
.line-main {
  width: 810px;
  padding: 20px 0 20px 30px;
  border-left: 2px solid #d6d6d6;
  min-height: 600px;

  .profile {
    margin: 0 0 20px;
    padding: 20px 30px;
    background: #fff;
    border: 1px solid #e2e2e2;

    .stats {
      font-size: 16px;
      b {
        margin: 0 4px;
        font-size: 28px;
        color: #444;
        font-weight: bold;
        vertical-align: middle;
      }
    }

    .badge-info {
      margin-top: 15px;
      margin-right: -30px;
      display: flex;
      flex-direction: row;
      color:#666;
      dt {
        width: 70px;
        padding-top: 10px;
        overflow: hidden;
        font-size: 16px;
        line-height: 18px;
        white-space: nowrap;

        span {
          font-size: 22px;
          line-height: 22px;
        }
      }

      dd {
        width: 136px;
        position: relative;
        text-align: center;

        &:before {
          content: "";
          position: absolute;
          left: 0;
          top: 4px;
          width: 1px;
          height: 63px;
          background-color: #d9d9d9;
          overflow: hidden;
        }

        .badge {
          display: block;
          margin: 0 auto 5px;
          cursor: pointer;
          width: 70px;
          height: 66px;
          background: url(	https://css.mafengwo.net/images/path/v2/badge-star5.png) no-repeat;
          overflow: hidden;

          &.star1-0 {
            background-position: -320px -220px;
            &:hover {
              background-position: -320px -140px;
            }
          }
          &.star2-0 {
            background-position: -240px -220px;
            &:hover {
              background-position: -240px -140px;
            }
          }
          &.star3-0 {
            background-position: -160px -220px;
            &:hover {
              background-position: -160px -140px;
            }
          }
          &.star4-0 {
            background-position: -80px -220px;
            &:hover {
              background-position: -80px -140px;
            }
          }
          &.star5-0 {
            background-position: 0 -220px;
            &:hover {
              background-position: 0 -140px;
            }
          }
        }

        .num {
          display: inline-block;
          margin-top: 1px;
          height: 28px;
          line-height: 28px;
          font-size: 12px;
          padding: 0 20px;
          background-color: #efefef;
          -webkit-border-radius: 14px;
          -moz-border-radius: 14px;
          -o-border-radius: 14px;
          -ms-border-radius: 14px;
          border-radius: 14px;
        }
        &.first:before  {
           width:0;
        }
      }
    }
  }
}
</style>