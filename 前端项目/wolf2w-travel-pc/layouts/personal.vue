<template>
  <div class="layout-container">
    <div class="layout-header">
      <Header />
    </div>
    <div class="layout-main">
      <div class="layout-banners"></div>
      <div class="tags_bar second_tags_bar">
        <div class="center clearfix">
          <ul class="flt2">
            <li class="mfw-acc-hide" v-for="(item, index) in navList" :key="index">
              <nuxtLink class="tags_link"
                        :class="navActive === index ? 'tags-link-active' : ''"
                        :to="{name: item.linkName}"
                        :title="item.name"
                         @click="getNavLink(index, item.name)">
                    {{item.name}}
              </nuxtLink>
            </li>
            <li class="more mfw-acc-hide ">
              <span class="tags_link" role="button" title="更多" style="cursor:default">更多<i class="MDownMore"></i></span>
              <div class="tags_more_list">
                <ul>
                  <li data-cs-t="go_to_activity"><a href="/indexactivity/index.php" title="我的活动" data-cs-p="activity"><el-icon :size="20"><football /></el-icon><span>我的活动</span></a></li>
                  <li><a href="/home/g/my.php" title="我的小组"><el-icon :size="20"><user /></el-icon><span>我的小组</span></a></li>
                  <li><a href="/plan/fav.php" title="我的收藏"><el-icon :size="20"><collection /></el-icon><span>我的收藏</span></a></li>
                  <li><a href="/order_center/" title="我的订单"><el-icon :size="20"><document /></el-icon><span>我的订单</span></a></li>
                  <li><a href="/sales/coupon.php" title="我的优惠券"><el-icon :size="20"><ticket /></el-icon><span>我的优惠券</span></a></li>
                  <li><a href="/mall/my_exchange.php" title="我的兑换"><el-icon :size="20"><set-up /></el-icon><span>我的兑换</span></a></li>
                  <li><a href="/flight/passengers.php" title="常用信息"><el-icon :size="20"><bell /></el-icon><span>常用信息</span></a></li>
                </ul>
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="layout-personal">
        <div v-if="navName !== '我的问答'">
          <NuxtPage />
        </div>
        <div v-else>
          <div class="answer-personal">
              <div class="side_bar flt1">
                <div class="MAvatar">
                  <div class="MAvaImg hasAva">
                    <img :src="userInfo?userInfo.headImgUrl:'https://p1-q.mafengwo.net/s12/M00/35/B7/wKgED1uqIs-AMYTwAAAX-VIKIo0071.png?imageMogr2%2Fthumbnail%2F%21120x120r%2Fgravity%2FCenter%2Fcrop%2F%21120x120%2Fquality%2F90'" height="120" width="120" alt="带TA游用户"><a href="/setting/avatar/" class="MAvaUp"><i class="Mphoto"></i></a>
                  </div>
                  <div class="MAvaName">{{userInfo?userInfo.nickname:'带TA游用户'}}
                  </div>
                  <div class="its_tags">
                    <a href="/home/vip_show.php" target="_blank" title="VIP"><i class="vip"></i></a>
                    <a href="/rudder/info.php" target="_blank" title="分舵"><i class="duo"></i>
                    </a><a href="/qa/expert_apply.php?type=1" target="_blank" title="指路人"><i class="zhiluren"></i></a>
                  </div>
                  <div class="MAvaInfo clearfix MAvaMyInfo">
                    <span class="MAvaLevel flt1">等级：<a href="/rank/lv.php" title="Lv.2" target="_blank">Lv.{{userInfo?userInfo.level:2}}</a></span>
                    <span class="MAvaPlace flt1" title="阿坝">现居：{{userInfo?userInfo.city:'阿坝'}}</span>            <span class="MAvaSet"><a title="设置" href="/setting/" target="_blank"></a></span>
                  </div>
                  <div class="MAvaMore clearfix">
                    <div class="MAvaNums">
                      <strong><a href="/friend/follow?type=我的关注" target="_blank">{{followNum}}</a></strong>
                      <p>关注</p>
                    </div>
                    <div class="MAvaNums">
                      <strong><a href="/friend/follow?type=我的粉丝" target="_blank">{{fansNum}}</a></strong>
                      <p>粉丝</p>
                    </div>
                    <div class="MAvaNums last">
                      <strong><a href="/mall/" target="_blank">0</a></strong>
                      <p>蜂蜜</p>
                    </div>
                  </div>
                </div>

                <div class="MWendaMod">
                  <h3>我的问答荣誉</h3>
                  <ul class="wendaHonor">
                    <li><a class="zlr" href="javascript:;" ><i></i>带TA游指路人</a></li>
                    <li><a class="mdd-zlr" href="javascript:;" ><i></i>目的地指路人</a></li>
                    <li><a class="goldmaster" href="javascript:;" ><i></i>金牌大师</a></li>
                  </ul>
                </div>
                <div class="MGuestbook mfw-acc-hide" id="_j_msgboard_wrap">
                  <div class="MGuestTitle">留言板
                    <div class="MCloseFunction _j_msgboard_closer">
                      <el-switch
                          v-model="msgSwitch"
                          active-color="#13ce66"
                          inactive-color="#ccc">
                      </el-switch>
                    </div>
                  </div>
                  <div class="MGuestInput">
                    <el-input  type="textarea" :rows="4" placeholder="说点什么..."  v-model="MGuestMsg" resize="none"></el-input>
                    <a role="button" class="MGuestBtn" title="留言" id="_j_msgboard_submit">留言</a>
                  </div>
                  <div class="MGuestList">
                    <ul class="_j_msgboard_list">

                    </ul>
                  </div>
                </div>
              </div>
              <div class="content flt2">
                <div class="achievement clearfix">
                  <ul>
                    <li><a><strong>{{qNum}}</strong><div>内容数</div></a></li>
                    <li v-show="answerNavActive==0||answerNavActive==1">
                      <strong class="goldmedal">0</strong><div>采纳数量</div>
                    </li>
                    <li v-show="answerNavActive==0||answerNavActive==1"><strong>0%</strong><div>采纳率</div></li>
                  </ul>
                  <a class="btn" href="/questions/publish">我要提问</a>
                </div>
                <div class="wd-main">
                  <div class="wd-navbar clearfix">
                    <ul class="wd-nav _j_qa_nav">
                      <li v-for="(answer, ide) in answerNavList" :key="ide" :class="answerNavActive === ide ? 'tags-link-active' : ''">
                        <nuxt-link :to="{name: answer.linkName}" @click="getAnswerNavLink(ide, answer.name)">
                        {{ answer.name }}
                        </nuxt-link>
                      </li>
                    </ul>
                  </div>
                  <NuxtPage />
                </div>
              </div>
          </div>
        </div>
      </div>
    </div>
    <div class="layout-footer">
      <Footer />
    </div>
  </div>
</template>
<script setup lang="ts">
import { questionNum } from "~/composables/globaldata";
import { getFollow,getFans } from "~~/composables/api/friend";

const msgSwitch=ref(false);
const MGuestMsg=ref('');

const navActive = ref()
const navName = ref('')

const qNum=questionNum();
const navList = reactive([
    {name: '我的窝', linkName: 'personal-info'},
    {name: '我的游记', linkName: 'personal-travels'},
    {name: '我的问答', linkName: 'personal-answer'},
    {name: '我的足迹', linkName: 'personal-footprint'},
    {name: '我的点评', linkName: 'personal-comment'},
    {name: '我的结伴', linkName: 'personal-companion'}
])

const userInfo=ref();

function getNavLink (index, name) {
  navActive.value = index
  navName.value = name
}
// 我的问答模块tab选项值
const answerNavActive = ref(0)
const answerNavList = reactive([
  {name: '我的回答', linkName: 'personal-answer'},
  {name: '我的提问', linkName: 'personal-question'},
  // {name: '我来解答', linkName: 'personal-solution'},
  {name: '关注问题', linkName: 'personal-care'},
  {name: '收藏回答', linkName: 'personal-collect'},
  {name: '草稿箱', linkName: 'personal-draft'}
])
//关注与粉丝
const followList=ref([]);
const followNum=ref(0);//关注数量
const fansNum=ref(0);//粉丝数量

function getAnswerNavLink (index, name) {
  answerNavActive.value = index
}

const getFollowData=()=>{
  getFollow().then((res)=>{
    //console.log(res); 
    followList.value=res.data.records;
    followNum.value=res.data.total;    
  })

  getFans().then((res)=>{
    fansNum.value= res.data.total;
  })
}
onMounted(() => { // 判断当前是否为我的问答模块
  document.body.style.margin='0';
  userInfo.value=JSON.parse(localStorage.getItem('userInfo'));
  
  answerNavList.forEach((el, ide) => {
    if (useRoute().name === el.linkName) {
      navName.value = '我的问答'
      navActive.value = 2
      answerNavActive.value = ide
    }
  })
  navList.forEach((ele, index) => {
    useRoute().name === ele.linkName ? navActive.value = index : ''
  })

  nextTick(()=>{
    getFollowData();
  })
})


</script>

<style lang="scss" scoped>
.layout-personal {
  width:980px;
  margin:0 auto;
}
.layout-container {
  position: relative;
  width: 100%;
  height: 100%;
  background: #efefef;
  .layout-main {
    width: 100%;
    /* height: 100%; */
    padding: 0;
    background: #efefef;
    .layout-banners {
      width:100%;
      height:260px;
      background-color:#006488;
      background-image: url("/assets/images/personal/banner_ask.gif");
      background-size: 980px 100%;
      background-repeat: no-repeat;
      background-position: center 0;
    }
  }
}
// nav样式
.tags_bar {
  height: 58px;
  width:100%;
  background-color: #fff;
  background-color: rgba(255,255,255,0.95);
  border-bottom: #d6d6d6 1px solid;
  box-shadow: 0 2px 5px rgb(0 0 0 / 12%);
  margin-top:-58px;
  .center {
    width:980px;
    margin:0 auto;
  }
  ul {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-end;
    //float: right;
    li {
      //float: left;
      height: 48px;
      z-index: 10;
      .tags_link {
        display: block;
        margin-left: 12px;
        margin-top: 10px;
        padding: 0 15px;
        font-size: 18px;
        line-height: 45px;
        color: #444;
        border-radius: 5px 5px 0 0;
        border-bottom:3px solid #fff;
        z-index: 1;
        &:hover {
          color:#ff8a00;
        }
      }
      &.more{
        position: relative;
        cursor: pointer;
        ul {
          display: block;
        }
        .tags_link {
          height: 46px;
          margin-left: 10px;
          padding-left: 18px;
          border: #ffffff 1px solid;
          border: rgba(255, 255, 255, 0) 1px solid;
          border-bottom: none;
          z-index: 12;
          position: relative;
        }
        .MUpMore {
          width: 12px;
          height: 7px;
          display: inline-block;
          background-image: url(	https://css.mafengwo.net/images/home_new2015/ico_sprite_v8.png);
          background-position: -93px -60px;
          margin-left: 5px;
          vertical-align: middle;
        }
        .tags_more_list {
          position: absolute;
          right: 0;
          top: 56px;
          width: 140px;
          padding: 18px 0 22px;
          border: #d6d6d6 1px solid;
          background-color: #ffffff;
          border-radius: 10px 0 10px 10px;
          box-shadow: 2px 2px 3px rgb(144 144 144 / 40%);
          z-index: 10;
          display: none;
          ul {
            float: right;
            li {
              float: left;
              position: relative;
              z-index: 10;
              a {
                height: 38px;
                line-height: 38px;
                padding: 0 20px;
                font-size: 14px;
                color: #666;
                margin: 0 0 2px;
                width: 100px;
                display: flex;
                flex-direction: row;
                align-items: center;
                span {
                  padding-left:10px;
                  box-sizing: border-box;
                }
                //i {
                //  width: 16px;
                //  height: 17px;
                //  display: inline-block;
                //  font-size: 30px;
                //  //background-image: url(https://css.mafengwo.net/images/home_new2015/home_sprite_v15.png);
                //  //background-position: -347px -139px;
                //  margin-right: 8px;
                //}
                &:hover {
                  background-color: #ffa800;
                  color: #fff;
                  text-decoration: none;
                }
              }
            }
          }
        }
        &:hover {
          .tags_link {
            background-color: #ffffff;
            border-color: #d6d6d6;
            color: #444;
          }
          .tags_more_list {
            display: block;
          }
        }
      }
    }
  }
}
// 我的问答布局页面统一样式
.answer-personal {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  .side_bar {
    width: 280px;
    background-color: #fff;
    box-shadow: 0 0 2px rgb(0 0 0 / 5%);
    position: relative;
    border-top-style: none;
    z-index: 10;
    padding-bottom: 55px;
    .MAvatar {
      text-align: center;
      font-size: 14px;
      .MAvaImg {
        width: 120px;
        height: 70px;
        position: relative;
        margin: 0 auto;
        img {
          position: relative;
          top: -50px;
          z-index: 20;
          border-radius: 120px;
        }
        img {
          border: 0;
          vertical-align: middle;
        }
        .MAvaUp {
          width: 120px;
          height: 120px;
          position: absolute;
          left: 0;
          top: -50px;
          z-index: 20;
          border-radius: 120px;
        }
      }
      .MAvaName {
        font-size: 22px;
        line-height: 24px;
        margin-top: 16px;
      }
      .its_tags {
        margin: 10px 0;
        text-align: center;
        i {
          width: 40px;
          height: 20px;
          display: inline-block;
          background-image: url(assets/images/personal/home_sprite_v15.png);
          background-position: 0 -460px;
          margin-right: 3px;
        }
        .duo {
          width: 30px;
          background-position: -41px -460px;
        }
        .zhiluren {
          width: 38px;
          background-position: -72px -460px;
        }
      }
    }
    .MAvaMore {
      margin-top: 20px;
      border-top: #e2e2e2 1px solid;
      border-bottom: #e2e2e2 1px solid;
      .MAvaNums {
        position: relative;
        width: 33%;
        float: left;
        padding: 10px 0;
        text-align: center;
        line-height: 20px;
        strong {
          font-size: 20px;
          color: #444;
          font-family: Arial;
        }
        p {
          font-size: 14px;
        }
        &:after {
          content: '';
          width: 1px;
          position: absolute;
          right: 0;
          top: 0;
          bottom: 0;
          background-color: #e2e2e2;
        }
      }
      .last:after {
        display: none;
      }
    }
    .MWendaMod {
      border-top: 1px solid #e5e5e5;
      border-bottom: 1px solid #e5e5e5;
      padding: 25px 33px;
      margin: -1px 0;
      h3 {
        margin-bottom: 2px;
        line-height: 26px;
        color: #999;
        font-size: 16px;
        font-weight: normal;
      }
      li {
        margin-top: 10px;
        line-height: 26px;
        font-size: 14px;
        a {
          display: block;
          color: #666;
          i {
            display: inline-block;
            float: left;
            margin-right: 12px;
            width: 40px;
            height: 26px;
            background: url(	https://css.mafengwo.net/images/home_new2015/ask_v2_sprite3.png) no-repeat 0 0;
          }
          &.mdd-zlr i {
            background-position: 0 -30px;
          }
          &.goldmaster i {
            background-position: 0 -60px;
          }
        }
      }
    }
    .MGuestbook {
      padding: 45px 15px 0;
      font-size: 14px;
      .MGuestTitle {
        font-size: 16px;
        text-align: center;
        position: relative;
      }
      .MCloseFunction {
        position: absolute;
        right: 0;
        top: -7px;
        cursor: pointer;
      }
      .MGuestInput {
        margin-top: 16px;
        .MGuestBtn {
          line-height: 30px;
          border-radius: 3px;
          color: #fff;
          background-color: #ccc;
          margin-top: 10px;
          display: block;
          text-align: center;
          transition: background-color .3s ease-out 0s;
          -webkit-transition: background-color .3s ease-out 0s;
        }
      }
    }
  }
  .content {
    width: 682px;
    margin-top: 18px;
    .achievement {
      padding: 40px 30px;
      border: 1px solid #d9d9d9;
      background-color: #fff;
      margin-bottom: 10px;
      display: flex;
      ul {
        // float: left;
        // width: 100%;
        flex: 1;
        text-align: center;
        font-size: 14px;
        color: #999;
        line-height: 16px;
        display: flex;
        justify-content: center;
        li {
          // float: left;
          width: 150px;
          height: 52px;
          a {
            display: block;
            color: #999;
          }
          strong {
            margin: -3px 0 10px;
            display: block;
            font-size: 30px;
            color: #333;
            line-height: 30px;
          }
          &li+li {
            border-left: 1px solid #d9d9d9;
          }
          .goldmedal {
            color: #192885;
            font-weight: bold;
            i {

              display: inline-block;
              margin-right: 5px;
              width: 17px;
              height: 22px;
              background: url(https://css.mafengwo.net/images/home_new2015/ask_v2_sprite3.png) no-repeat -80px -60px;
              overflow: hidden;
              vertical-align: -1px;
              *vertical-align: middle;
            }
          }
        }
      }
      .btn {
        // float: right;
        margin-top: 5px;
        width: 140px;
        height: 40px;
        background-color: #192885;
        border-radius: 4px;
        text-align: center;
        line-height: 40px;
        color: #fff;
        font-size: 16px;
      }
    }
    .wd-main {
      border: 1px solid #d9d9d9;
      background-color: #fff;
      padding: 0 30px;
      margin-bottom: 20px;
      .wd-navbar {
        margin: 0 -30px 7px;
        padding: 0 30px;
        border-bottom: 1px solid #e5e5e5;
        *zoom: 1;
        .wd-nav {
          float: left;
          li {
            float: left;
            display: inline;
            margin-right: 18px;
            a {
              display: inline-block;
              padding: 20px 12px;
              line-height: 30px;
              font-size: 16px;
              color: #666;
              border-bottom: 3px solid transparent;
              white-space: nowrap;
            }
          }
        }
      }
    }
  }
}
.tags-link-active {
  border-bottom:3px solid #ff8a00 !important;
}
</style>
