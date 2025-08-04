<template>
  <div class="common-container">
    <h2 class="r-title">
      酒店精选
      <span>来的游客 大多会关注：</span>
      <a data-change="btn" class="change" href="javascript:void(0);" data-mes-g="1-0-1" data-mes-t="换一换" data-mddid="10065">
        <i></i>换一换
      </a>
    </h2>
    <div class="local-pro">
      <ul class="clearfix">
        <li data-id="19359">
          <a href="/hotel/feature/10065/19359/" target="_blank" title="老北京四合院">
            <img
              src="https://p1-q.mafengwo.net/s9/M00/AA/8E/wKgBs1fONyuAF494AAHnNMdwOss10.jpeg?imageMogr2%2Fthumbnail%2F%21310x310r%2Fgravity%2FCenter%2Fcrop%2F%21310x310%2Fquality%2F100"
            />
            <div class="img-bag">
              <h2>老北京四合院</h2>
              <p>想在皇城根儿脚下体验地道京味儿，选择一家四合院酒店住上几晚是再好不过的了。以下酒店在休息同时...</p>
            </div>
          </a>
        </li>
        <li data-id="36298">
          <a href="/hotel/feature/10065/36298/" target="_blank" title="环影畅玩">
            <img
              src="https://p1-q.mafengwo.net/s16/M00/21/C8/CoUBUmEsRzyANaQ-AAO8hcvPYSE11.jpeg?imageMogr2%2Fthumbnail%2F%21310x310r%2Fgravity%2FCenter%2Fcrop%2F%21310x310%2Fquality%2F100"
            />
            <div class="img-bag">
              <h2>环影畅玩</h2>
              <p>霍格沃兹喊你入学啦！住在这里到环球影城超方便~</p>
            </div>
          </a>
        </li>
        <li data-id="35313">
          <a href="/hotel/feature/10065/35313/" target="_blank" title="天安门舒心住">
            <img
              src="https://p1-q.mafengwo.net/s11/M00/57/A7/wKgBEFr0d1-AWySQAAGnmaVRsUo04.jpeg?imageMogr2%2Fthumbnail%2F%21310x310r%2Fgravity%2FCenter%2Fcrop%2F%21310x310%2Fquality%2F100"
            />
            <div class="img-bag">
              <h2>天安门舒心住</h2>
              <p>四九城，京城的人间烟火</p>
            </div>
          </a>
        </li>
      </ul>
    </div>
    <div class="r-more"><a href="/hotel/10065/" target="_blank">查看该地区全部酒店</a></div>
  </div>
</template>
<script setup lang="ts"></script>
<style lang="scss" scoped>
.common-container {
  width: 1000px;
  margin: 0 auto;
  .r-title {
    margin-bottom: 30px;
    text-align: left;
    font-size: 26px;
    color: #333;
    font-weight: normal;
    line-height: 30px;
    span {
      color: #666;
      font-size: 16px;
      font-weight: normal;
      margin-left: 15px;
    }
    .change {
      float: right;
      font-size: 12px;
      color: #999;
      text-decoration: none;
      background-color: transparent;
      i {
        width: 14px;
        height: 14px;
        background: url(../../assets/images/change.png) no-repeat;
        display: inline-block;
        margin-right: 4px;
        vertical-align: middle;
      }
    }
  }
  ul {
    margin-right: -40px;
    li {
      width: 310px;
      height: 311px;
      float: left;
      position: relative;
      margin: 0 35px 0 0;
      overflow: hidden;
      .img-bag {
        background: rgba(0, 0, 0, 0.25);
        width: 100%;
        height: 100%;
        position: absolute;
        left: 0;
        top: 0;
        text-align: center;
        h2 {
          margin-top: 60px;
          padding: 12px 3px;
          color: #fff;
          font-size: 22px;
          display: inline-block;
          text-shadow: #000 0 1px 0;
          position: relative;
          &:before {
            content: '';
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 2px;
            background: #fff;
          }
          &:after {
            content: '';
            position: absolute;
            left: 0;
            bottom: 1px;
            width: 100%;
            height: 2px;
            background: #fff;
          }
        }
        p {
          font-size: 14px;
          color: #fff;
          line-height: 22px;
          width: 230px;
          margin: 45px auto 0 auto;
          padding: 0;
          text-shadow: #000 0 1px 0;
          text-overflow: clip;
          white-space: normal;
        }
      }
    }
  }
  .r-more {
    clear: both;
    margin-top: 25px;
    text-align: center;
    a {
      display: inline-block;
      border: 1px solid #192885;
      border-radius: 4px;
      font-size: 14px;
      line-height: 40px;
      padding: 0 42px;
      color: #192885;
      &:hover {
        text-decoration: none;
        background-color: #192885;
        color: #fff;
      }
    }
  }
}
</style>
