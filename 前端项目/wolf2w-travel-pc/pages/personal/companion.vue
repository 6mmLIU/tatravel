<template>
  <div class="row row-bg">
    <div class="MAvatar clearfix _j_hide_user_head mfw-acc-hide">
      <div class="MAvaImg flt1">
        <img width="120" height="120" alt="" src="https://p1-q.mafengwo.net/s12/M00/35/6C/wKgED1uqIpCARLIhAAAZUeRPlFM676.png?imageMogr2%2Fthumbnail%2F%21200x200r%2Fgravity%2FCenter%2Fcrop%2F%21200x200%2Fquality%2F90">
      </div>
      <div class="MAvaEasyWord flt1">
        <span class="MAvaName">带TA游用户(阿坝)</span>
        <span class="MAvaLevel">Lv.2</span>
      </div>
    </div>
    <div class="wrapper mod-mylist">
      <div class="hd">
        <span><a class="_j_care_add" :class="tabIde === ide ? 'on' : ''" v-for="(tab, ide) in tabData" :key="ide" @click="tabIde = ide">{{ tab }} <em></em></a></span>
      </div>
      <div class="bd">
        <table>
          <thead>
          <tr>
            <td class="event">计划名称</td>
            <td class="departure">出发地</td>
            <td class="destination">目的地</td>
            <td class="date">出发时间</td>
            <td class="date">发布时间</td>
          </tr>
          </thead>
          <tbody class="_j_tbody"></tbody>
          <tbody><tr class="_j_hide">
            <td class="td-empty" colspan="5">
              <div class="icon-empty"></div>
            </td>
          </tr>
          </tbody></table>
      </div>
      <div class="post_pagin" id="smallpager"></div>
    </div>
    <div class="wrapper mod-recommend">
      <h3 class="mod-title">更多靠谱的结伴计划</h3>
      <div class="bd together-list">
        <ul class="clearfix">
          <li class="item">
            <a href="/together/detail/1417604.html">
              <div class="image">
                <img src="https://p1-q.mafengwo.net/s17/M00/D0/E6/CoUBXl_rB3-AOURzAAHfcJmmq-489.jpeg?imageMogr2%2Fthumbnail%2F%21200x130r%2Fgravity%2FCenter%2Fcrop%2F%21200x130%2Fquality%2F100" style="width: 200px;height: 130px;">
                <div class="after"><b>-1871</b>天后</div>
                <hr>
              </div>
              <div class="desc">“个人描述”

                本人90后文艺小女纸一枚，也是二货女汉子一只...</div>
              <div class="user clearfix">
								<span class="avatar"><img src="https://p1-q.mafengwo.net/s14/M00/43/1C/wKgE2l1CV7mAA7mJAAB7z_SRkDM96.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90">
								<i class="male"></i></span>
                <span class="name">Lemon.(湘潭)  </span>
                <span class="level">LV.10</span>
              </div>
              <div class="attention"><i class="icon-arrow"></i>已有<b>77</b>人关注</div>
            </a>
          </li>
          <li class="item">
            <a href="/together/detail/1423034.html">
              <div class="image">
                <img src="https://p1-q.mafengwo.net/s9/M00/D6/48/wKgBs1fHmDOAFuPuABgy_gdW4GA40.jpeg?imageMogr2%2Fthumbnail%2F%21200x130r%2Fgravity%2FCenter%2Fcrop%2F%21200x130%2Fquality%2F100" style="width: 200px;height: 130px;">
                <div class="after"><b>-2008</b>天后</div>
                <hr>
              </div>
              <div class="desc">2017年3月24日上海出发，4月6日奥克兰返回，打算自驾行摄，游...</div>
              <div class="user clearfix">
								<span class="avatar"><img src="https://p1-q.mafengwo.net/s5/M00/3B/C7/wKgB3FF4kMWAQM3lAAEOTyu5bog03.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90">
								<i class="female"></i></span>
                <span class="name">Grieftermi(天朝)  </span>
                <span class="level">LV.9</span>
              </div>
              <div class="attention"><i class="icon-arrow"></i>已有<b>32</b>人关注</div>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'personal'
})
const tabData = ref(['我关注的','我参加的'])
const tabIde = ref(0)
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
.row-bg {
  background-color: #efefef;
  position: relative;
}
.row, .row-bg, .row-bg2 {
  padding: 40px 0 50px;
}
.mod-mylist {
  width: 978px;
  padding: 20px 0;
  margin-bottom: 45px;
  background-color: #fff;
  border: 1px solid #e2e2e2;
  position: relative;
  .hd {
    margin-bottom: 20px;
    padding: 0 20px;
    font-size: 18px;
    //span {
    //  margin-right: 20px;
    //}
    a {
      color: #666;
      margin-right: 20px;
    }
    em {
      font-style: normal;
      font-size: 36px;
      color: #444;
      vertical-align: baseline;
    }
    .on {
      color:#ff8a00;
    }
  }
  table {
    width: 100%;
    border-spacing: 0;
    border-collapse: collapse;
    border-top: 1px solid #d5d5d5;
    thead {
      height: 40px;
    }
    td {
      font-size: 14px;
      color: #666;
      line-height: 40px;
      border-bottom: 1px solid #eaeaea;
      text-align: center;
    }
    .event {
      width: 450px;
      text-align: left;
      padding-left: 20px;
    }
    .td-empty {
      border: 0;
    }
    tbody{
      td {
        padding: 20px 0;
        vertical-align: top;
      }
      .icon-empty {
        margin: 50px 0;
        height: 240px;
        background: url(	https://css.mafengwo.net/images/together/v2/icon-empty.png) no-repeat center top;
        position: relative;
      }
    }
  }
}
.wrapper {
  padding: 0;
  width: 980px;
  margin: 0 auto;
}
.mod-recommend {
  padding: 30px 30px 40px;
  background-color: #fff;
  width: 920px;
  .mod-title {
    font-size: 18px;
    font-weight: normal;
  }
  ul {
    margin: 0 -30px 0 -10px;
    position: relative;
    .item {
      width: 220px;
      float: left;
      display: inline;
      margin-right: 20px;
      a {
        display: block;
        padding: 50px 0 46px;
        border-bottom: 1px solid #d5d5d5;
        padding-top: 30px;
        margin: 0 10px;
        .image {
          position: relative;
          padding-bottom: 30px;
          margin-bottom: 35px;
          width: 200px;
          .after {
            position: absolute;
            right: -3px;
            bottom: -3px;
            width: 72px;
            height: 41px;
            padding-top: 20px;
            background: url(	https://css.mafengwo.net/images/together/v2/sprites5.png) no-repeat -80px 0;
            overflow: hidden;
            text-align: center;
            color: #999;
            b {
              color: #409f97;
              font-size: 24px;
              font-weight: bold;
              vertical-align: baseline;
            }
          }
          hr {
            position: absolute;
            left: 0;
            bottom: 0;
            width: 118px;
            height: 1px;
            margin: 0;
            padding: 0;
            border: 0;
            border-top: 1px solid #d5d5d5;
            overflow: hidden;
          }
        }
        .desc {
          margin-bottom: 25px;
          height: 48px;
          font-size: 14px;
          color: #666;
          line-height: 24px;
          overflow: hidden;
        }
        .user {
          margin: 25px 0;
          padding-left: 63px;
          line-height: 20px;
          .avatar {
            float: left;
            margin: -3px 0 0 -63px;
            width: 48px;
            height: 48px;
            position: relative;
            img {
              border-radius: 50%;
            }
            i {
              position: absolute;
              right: -6px;
              bottom: -3px;
            }
          }
          .name {
            display: block;
            width: 130px;
            height: 20px;
            text-overflow: ellipsis;
            white-space: nowrap;
            font-size: 14px;
            color: #ff7200;
            overflow: hidden;
          }
          .level {
            font-weight: bold;
            color: #ea3c1a;
            font-family: Verdana;
          }
        }
        .attention {
          line-height: 38px;
          font-size: 14px;
          color: #666;
          .icon-arrow {
            float: right;
            width: 38px;
            height: 38px;
            background: url(https://css.mafengwo.net/images/together/v2/sprites5.png) no-repeat 0 -80px;
            b {
              padding: 0 5px;
              font-size: 28px;
              vertical-align: -4px;
              *vertical-align: middle;
            }
          }
        }
      }
    }
  }
}
</style>