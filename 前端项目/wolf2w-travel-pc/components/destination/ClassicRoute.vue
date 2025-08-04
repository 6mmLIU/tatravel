<template>
  <div class="common-container">
    <div>
      <h2 class="r-title" style="text-align: left">广州19条经典线路</h2>
    </div>
    <div class="line-cards">
      <h3>
        <a data-t="路线标题" href="/mdd/route/10065_138922.html" target="_blank"><span class="num">1</span>探寻白河之美</a>
      </h3>
      <div class="map"></div>
      <dl class="info">
        <dt>
          <a data-t="线路百分比" href="/mdd/route/10065_138922.html" target="_blank" style="color: #333; text-decoration: none">
            <span>28%</span>初次访问广州的蜂蜂会选择这条线路
          </a>
        </dt>
        <dd>
          <a data-t="路线详情" href="/mdd/route/10065_138922.html" target="_blank" style="color: #333; text-decoration: none">
            <span>白河湾</span>
            <span class="arrow">→</span><span>神堂峪</span> <span class="arrow">→</span><span>顶秀美泉小镇</span>
          </a>
          <a data-t="查看路线" class="btn-view" href="/mdd/route/10065_138922.html" target="_blank">查看&gt;</a>
        </dd>
      </dl>
    </div>
    <div class="line-cards line-cards-right">
      <h3>
        <a data-t="路线标题" href="/mdd/route/10065_138922.html" target="_blank"><span class="num">1</span>探寻白河之美</a>
      </h3>
      <div class="map"></div>
      <dl class="info">
        <dt>
          <a data-t="线路百分比" href="/mdd/route/10065_138922.html" target="_blank" style="color: #333; text-decoration: none">
            <span>28%</span>初次访问广州的蜂蜂会选择这条线路
          </a>
        </dt>
        <dd>
          <a data-t="路线详情" href="/mdd/route/10065_138922.html" target="_blank" style="color: #333; text-decoration: none">
            <span>白河湾</span>
            <span class="arrow">→</span><span>神堂峪</span> <span class="arrow">→</span><span>顶秀美泉小镇</span>
          </a>
          <a data-t="查看路线" class="btn-view" href="/mdd/route/10065_138922.html" target="_blank">查看&gt;</a>
        </dd>
      </dl>
    </div>
    <div class="line-all">
      <a data-t="查看全部路线" href="/mdd/route/10065.html" target="_blank">
        <span class="icon"><i class="i-blue"></i><i class="i-orange"></i></span>查看全部 <span class="num">19条</span> 经典线路&gt;
      </a>
    </div>
  </div>
</template>
<script setup lang="ts"></script>
<style lang="scss" scoped>
.common-container {
  width: 1000px;
  margin: 0 auto;
  .r-title {
    margin-bottom: 35px;
    text-align: left;
    font-size: 26px;
    color: #333;
    font-weight: normal;
    line-height: 30px;
  }
  .line-cards {
    float: left;
    display: inline;
    margin-right: 18px;
    width: 488px;
    height: 370px;
    border: 1px solid #e6e6e6;
    box-shadow: 0 0 3px rgb(224 224 224 / 75%);
    color: #333;
    &.line-cards-right {
      margin-right: 0;
    }
    h3 {
      height: 30px;
      margin: 15px 20px;
      line-height: 30px;
      font-size: 20px;
      font-weight: normal;
      a {
        color: #333;
      }
      .num {
        float: left;
        margin-right: 15px;
        width: 22px;
        height: 24px;
        background-color: #192885;
        color: #fff;
        text-align: center;
        position: relative;
        line-height: 26px;
        &:after {
          content: '';
          position: absolute;
          left: 0;
          bottom: -7px;
          border-left: 11px solid #192885;
          border-right: 11px solid #192885;
          border-bottom: 7px dashed transparent;
          overflow: hidden;
          line-height: 0;
        }
      }
    }
    .map {
      height: 180px;
      overflow: hidden;
    }
    .info {
      padding: 0 20px;
      dt {
        margin: 10px 0;
        font-size: 16px;
        line-height: 30px;
        span {
          margin-right: 12px;
          float: left;
          font-size: 28px;
          color: #192885;
        }
      }
      dd {
        border-top: 1px dashed #ddd;
        padding-top: 15px;
        font-size: 14px;
        line-height: 24px;
        height: 48px;
        overflow: hidden;
        position: relative;
      }
      .arrow {
        margin: 0 10px;
        display: inline-block;
        width: 14px;
        height: 10px;
        background: url(../../assets/images/line-details-sprites2.png) no-repeat -80px 0;
        overflow: hidden;
        line-height: 100px;
      }
    }
    .btn-view {
      position: absolute;
      bottom: 0;
      right: 0;
      background-color: #fff;
      padding-left: 18px;
      color: #643718;
    }
  }
  .line-all {
    clear: both;
    padding-top: 30px;
    text-align: right;
    a {
      display: inline-block;
      font-size: 18px;
      color: #333;
    }
    .icon {
      float: left;
      margin: 4px 10px 0 0;
      width: 25px;
      height: 25px;
      background-color: #fff;
      border: 1px solid #909090;
      border-radius: 1px;
    }
    .num {
      font-size: 24px;
      color: #192885;
    }
    .i-blue {
      display: block;
      height: 14px;
      background-color: #7fc8ed;
    }
    .i-orange {
      display: block;
      height: 5px;
      background-color: #192885;
    }
  }
}
</style>
