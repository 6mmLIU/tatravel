<template>
  <div class="comment-body">
    <div class="MAvatar clearfix _j_hide_user_head mfw-acc-hide">
      <div class="MAvaImg flt1">
        <img width="120" height="120" alt="" src="https://p1-q.mafengwo.net/s12/M00/35/6C/wKgED1uqIpCARLIhAAAZUeRPlFM676.png?imageMogr2%2Fthumbnail%2F%21200x200r%2Fgravity%2FCenter%2Fcrop%2F%21200x200%2Fquality%2F90">
      </div>
      <div class="MAvaEasyWord flt1">
        <span class="MAvaName">带TA游用户(阿坝)</span>
        <span class="MAvaLevel">Lv.2</span>
      </div>
    </div>
    <div class="line-nav line-time" style="margin-top:210px" id="_j_sidenav">
      <dl class="nav-group nav-sort _j_navitem on" data-sort="1">
        <dt><a><strong>按时间排序</strong><i></i></a></dt>
      </dl>
    </div>
    <div class="line-main">
      <div class="reviews-nums pad_left" id="_j_topfilter">
        <ul class="clearfix">
          <li class="num-gold _j_filter" data-filter="2">
            <a role="button">
              <i class="icon-gold"></i><b>0</b><br>金牌点评<span class="split"></span>
            </a>
          </li>
          <li class="num-wengs _j_filter" data-filter="4">
            <a role="button">
              <b>0</b><br>笔记点评<span class="split"></span>
            </a>
          </li>
          <li class="num-reviews _j_filter on" data-filter="0">
            <a role="button">
              <b>0</b><br>点评<span class="split"></span>
            </a>
          </li>
        </ul>
        <div class="btn_review"><a href="/path/search_poi/index" target="_blank">写点评</a></div>
      </div>

      <div class="reviews-list">
        <div id="_j_poilist">
          <div class="no_data">
            <img src="http://css.mafengwo.net/images/home_new2015/no_num.png" height="139" width="156" alt="">
            <p>这里的世界静悄悄</p>
          </div>

        </div>

      </div>

    </div>
  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'personal'
})
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
.comment-body {
  display: flex;
  flex-direction: row;
  position: relative;
}
.line-nav {
  width: 188px;
  margin-left: -50px;
  text-align: right;
  *zoom: 1;
  .nav-group {
    padding-right: 24px;
    margin-left: -20px;
    _white-space: nowrap;
    color: #666;
  }
  dt {
    position: relative;
    margin: 15px 0;
    font-size: 16px;
    line-height: 28px;
    _width: 108px;
    i {
      right: -32px;
      top: 8px;
      *top: 2px;
      width: 14px;
      height: 14px;
      background: #ff8a00;
      position: absolute;
      border-radius: 50%;
      border:2px solid #fff;
    }
    a {
      color: #ff8a00;
      font-weight: normal;
    }
  }
}
.line-main {
  width: 810px;
  padding: 20px 0 20px 30px;
  border-left: 2px solid #d6d6d6;
  min-height: 600px;
  .reviews-nums {
    position: relative;
    z-index: 9;
    background-color: #fff;
    border: 1px solid #e2e2e2;
    margin-bottom: 20px;
    padding: 24px 24px 24px 84px;
    li {
      float: left;
      width: 170px;
      height: 62px;
      text-align: center;
      font-size: 14px;
      color: #999;
      position: relative;
      &.num-gold {
          position: relative;
        }
      a {
        display: block;
        text-decoration: none;
        color: #666;
        cursor: pointer;
        position: relative;
        z-index: 1;
      }
      .icon-gold {
        display: inline-block;
        margin-right: 5px;
        width: 30px;
        height: 30px;
        background: url(	https://css.mafengwo.net/images/path/v2/path-sprite27.png) no-repeat -390px -290px;
        overflow: hidden;
        vertical-align: -4px;
        *vertical-align: -2px;
      }
      b {
        font-size: 30px;
        font-weight: bold;
        color: #666;
        line-height: 40px;
      }
      .split {
        content: '';
        position: absolute;
        left: 0;
        top: 0;
        display: inline-block;
        width: 1px;
        height: 62px;
        background-color: #d9d9d9;
        overflow: hidden;
      }
      &.on{
        a,b {
          color: #ff8a00;
        }
      }
      &:first-child .split {
        width:0;
      }
    }
    .btn_review {
      a {
        position: absolute;
        display: block;
        z-index: 1;
        right: 20px;
        top: 35px;
        width: 110px;
        height: 40px;
        line-height: 40px;
        text-align: center;
        background: #ffa900;
        color: #FFF;
        border-radius: 4px;
        font-size: 16px;
      }
    }
  }
  .reviews-list {
    border: 1px solid #e2e2e2;
    background-color: #fff;
    .no_data {
      margin-top: 0;
      padding: 160px 0;
    }
    .no_data {
      text-align: center;
      font-size: 16px;
      color: #d3d3d3;
      margin-top: 80px;
      padding-bottom: 120px;
      p {
        margin-top: 16px;
      }
    }
  }
  .pad_left {
    padding: 24px 24px 24px 0;
    position: relative;

  }
}
</style>