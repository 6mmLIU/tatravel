<template>
  <div class="main-container">
    <div class="wrapper wrapper-new clearfix">
      <div class="col-main">
        <div class="newcate-wrap _j_qa_list">
          <div class="hd">
            <ul class="cate-tab">
              <li class="_j_change_type" :class="{ on: currentTab === '0' }" @click="changeTab('0')">
                <a> 热门问题 </a>
              </li>
              <li class="_j_change_type" :class="{ on: currentTab === '1' }" @click="changeTab('1')">
                <a> 最新问题 </a>
              </li>
              <li class="_j_change_type" :class="{ on: currentTab === '2' }" @click="changeTab('2')">
                <a> 待回答问题 </a>
              </li>
            </ul>
          </div>
          <div class="bd newcate-bd">
            <ul class="_j_pager_box">
              <li v-for="item in questionsData" :key="item.id" class="item clearfix">
                <div class="title">
                  <a :href="`/questions/details/${item.id}`" target="_blank">{{ item.title }}</a>
                </div>
                <div class="container">
                  <div class="avatar">
                    <a :href="`/questions/details/${item.id}`" target="_blank" class="_j_filter_click">
                      <img class="_j_filter_click" :src="item.headImgUrl" />
                    </a>
                  </div>
                  <div class="user-info">
                    <a class="name _j_filter_click" href="javascript:;" >{{item.authorName}}</a>
                    <a class="level _j_filter_click" href="javascript:;" rel="nofollow">LV.{{item.level}}</a>
                  </div>
                  <div class="identity">
                    <a class="i-guide _j_filter_click" href="" target="_blank">指路人</a>
                  </div>
                  <div class="desc clearfix">
                    <a :href="`/questions/details/${item.id}`" target="_blank" style="color: #666">
                      <img src="https://note.mafengwo.net/img/ea/1f/eb7d0fd63f7feebdc0b6a17d4f34af3c.jpeg?imageMogr2%2Fthumbnail%2F%21140x105r%2Fgravity%2FCenter%2Fcrop%2F%21140x105%2Fquality%2F90" width="150" height="100" />
                      <p>{{ item.detailDoubt }}</p>
                    </a>
                  </div>
                  <div class="tags">
                    <a v-for="item2 in item.labelList" :key="item2" class="a-tag _j_filter_click" href="">{{ item2 }}</a>
                  </div>
                  <div class="operate">
                    <div class="zan"><i></i>0</div>
                    <div class="mdd">
                      <a href="" class="_j_filter_click" target="_blank"><i class="_j_filter_click"></i>{{ item.destinationName }}</a>
                    </div>
                    <div class="cate-share">
                      <a class="_js_showShare _j_filter_click">分享</a>
                      <div
                        class="cate-share-pop _j_share_pop hide clearfix"
                        data-title="求一个小众 便宜 不网红 安全的小城旅游 求推荐！！！"
                        data-qid="23792326"
                        data-aid="23794231"
                        data-anum="207"
                        data-content="五个回答，威海、长岛、梅州、锦州、柳州。你提出的推荐需求是，小众、便宜、不网红、安全、小城。我觉得威海、长岛一定不是小众，梅州、锦州、柳州也不是小城。很多人都有自己的见解，我说说我心中的小众、便宜、不网红、安全，还是小城的地方-正定！如果你不知..."
                      >
                        <a title="分享到新浪微博" class="sina _j_do_share _j_filter_click" data-site="wb" data-username="大愿尊者"></a>
                        <a title="分享到QQ空间" class="zone _j_do_share _j_filter_click" data-site="qz" data-username="大愿尊者"></a>
                        <a title="分享到微信" class="weixin _j_do_share_wx _j_filter_click" data-site="wx" data-username="大愿尊者"></a>
                      </div>
                    </div>
                    <a href="" target="_blank" style="text-decoration: none">
                      <span class="reply">评论 (0)</span>
                    </a>
                    <span class="date"><i></i>发布于20小时前</span>
                  </div>
                </div>
              </li>
            </ul>
          </div>
          <div class="_j_pager">
            <div class="ft ft_load_btn">
              <div v-if="questionsData.length < questionsDataTotal" class="answer-more _j_add_more_button" @click="loadMore">
                <a>加载更多<i></i></a>
              </div>
            </div>
            <div class="ft ft_loading _j_add_loading_button hide">
              <div class="answer-loading">正在加载<i></i></div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-side">
        <div class="i-ask">
          <NuxtLink to="/questions/publish" class="btn-ask btn-ask2"><i></i>我要提问</NuxtLink>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { questionsList } from '@/composables/api/questions'
const currentTab = ref('0')
const questionsParams = reactive({
  current: 1,
  size: 10
})
const questionsDataTotal = ref(0)
const questionsData = ref([])

onMounted(() => {
  nextTick(() => {
    getQuestionsList()
  })
})

function changeTab(tab) {
  currentTab.value = tab
}

// 攻略列表
function getQuestionsList() {
  
  questionsList(questionsParams)
    .then(res => {
      console.log(questionsParams);
      console.log(res);   

      questionsParams.current === 1 ? (questionsData.value = res.data.records) : (questionsData.value = questionsData.value.concat(res.data.records))
      questionsDataTotal.value = res.data.total;
    })
    .catch(err => {
      console.log(err)
    })
}

function loadMore() {
  questionsParams.current++
  getQuestionsList()
}
</script>
<style lang="scss" scoped>
.main-container {
  position: relative;
  padding-top: 30px;
  .wrapper {
    width: 980px;
    margin: 0 auto;
    .col-main {
      float: left;
      width: 685px;
      .newcate-wrap {
        font-size: 14px;
        margin-bottom: 100px;
        .hd {
          margin-bottom: 10px;
          height: 32px;
          line-height: 32px;
          ul {
            float: left;
            li {
              float: left;
              display: inline;
              &.on {
                a {
                  background-color: #192885;
                  color: #fff;
                }
              }
              a {
                display: block;
                padding: 0 5px;
                font-size: 16px;
                color: #666;
                padding: 0 20px;
                border-radius: 3px;
              }
            }
          }
        }
        .newcate-bd {
          clear: both;
          margin-bottom: 20px;
          li {
            padding: 15px 0;
            border-bottom: 1px solid #e5e5e5;
            cursor: pointer;
            .title {
              font-size: 18px;
              line-height: 30px;
              color: #333;
              margin-bottom: 12px;
              a {
                color: #333;
                &:hover {
                  color: #192885;
                }
              }
            }
            .container {
              padding-left: 60px;
              position: relative;
              .avatar {
                width: 48px;
                height: 48px;
                border-radius: 50%;
                border: 1px solid #e5e5e5;
                overflow: hidden;
                position: absolute;
                left: 0;
                top: 0;
                img {
                  width: 100%;
                  height: 100%;
                  border-radius: 50%;
                }
              }
              .user-info {
                width: 100%;
                height: 18px;
                line-height: 18px;
                margin-bottom: 6px;
                .name {
                  margin-right: 5px;
                }
                .level {
                  color: #d20000 !important;
                  font-size: 10px;
                  font-family: Verdana;
                  font-weight: bold;
                }
              }
              .identity {
                width: 100%;
                height: 20px;
                margin-top: 9px;
                margin-bottom: 12px;
                a.i-guide {
                  display: inline-block;
                  height: 18px;
                  margin-right: 4px;
                  padding: 0 4px 0 20px;
                  border-width: 1px;
                  border-style: solid;
                  border-radius: 10px;
                  font-size: 12px;
                  line-height: 18px;
                  color: #fff;
                  position: relative;
                  background: url(../../assets/images//mfwask-2016sprite-2x_v6.png) no-repeat;
                  background-size: 50px;
                  border-color: #4fb3a8;
                  background-color: #70c2b9;
                  background-position: 4px -517px;
                  padding-left: 26px;
                }
              }
              .desc {
                line-height: 24px;
                color: #666;
                img {
                  width: 150px;
                  height: 100px;
                  float: left;
                  margin-right: 16px;
                }
                p {
                  padding-top: 2px;
                  overflow: hidden;
                }
              }
              .tags {
                height: 22px;
                margin-top: 14px;
                a {
                  display: block;
                  float: left;
                  margin: 3px 5px 0 0;
                  padding: 0 15px;
                  background-color: #f6f6f6;
                  border: 1px solid #e5e5e5;
                  border-radius: 10px;
                  font-size: 12px;
                  line-height: 20px;
                  color: #666;
                  white-space: nowrap;
                  &:hover {
                    background-color: #192885;
                    border-color: #192885;
                    color: #fff;
                    text-decoration: none;
                  }
                }
              }
              .operate {
                width: 100%;
                height: 16px;
                margin-top: 16px;
                position: relative;
                font-size: 12px;
                line-height: 16px;
                text-align: right;
                color: #999;
                .zan {
                  float: left;
                  i {
                    float: left;
                    display: inline-block;
                    width: 30px;
                    height: 26px;
                    background: url(../../assets/images/like30x26@2x.png) no-repeat;
                    background-size: 30px auto;
                    overflow: hidden;
                    margin-right: 9px;
                    margin-top: -5px;
                    margin-bottom: -5px;
                  }
                }
                .mdd {
                  display: inline-block;
                  padding-right: 7px;
                  color: #192885;
                  a {
                    color: #192885;
                    i {
                      width: 10px;
                      height: 12px;
                      background: url(../../assets/images/icon-mdd-2x.png) no-repeat;
                      background-size: 100% 100%;
                      display: inline-block;
                      margin-right: 6px;
                      vertical-align: middle;
                      position: relative;
                      top: -1px;
                    }
                  }
                }
                .cate-share {
                  display: inline-block;
                  padding: 0 10px;
                  position: relative;
                  border-left: 1px solid #e5e5e5;
                  a {
                    color: #999;
                  }
                  .cate-share-pop {
                    width: 132px;
                    padding: 8px 10px;
                    background-color: #fff;
                    border: 1px solid #e5e5e5;
                    border-radius: 6px;
                    position: absolute;
                    left: 100%;
                    top: -20px;
                    z-index: 10;
                    a {
                      width: 36px;
                      height: 36px;
                      display: inline-block;
                      margin: 0 12px 0 0;
                      background: #d84c4c url(../../assets/images/sprite_v31.png) -295px -569px no-repeat;
                      line-height: 200px;
                      overflow: hidden;
                      float: left;
                      border-radius: 5px;
                      &.zone {
                        background-color: #3f8bc0;
                        background-position: -331px -569px;
                      }
                      &.weixin {
                        margin-right: 0;
                        background-color: #73a64f;
                        background-position: -367px -569px;
                      }
                    }
                  }
                }
                a {
                  color: #999;
                }
                span {
                  display: inline-block;
                  border-left: 1px solid #e5e5e5;
                  padding: 0 7px 0 10px;
                }
                .date {
                  padding-right: 0;
                  i {
                    width: 12px;
                    height: 16px;
                    background: url(../../assets/images/mfw-ask-sprite20.png) no-repeat -100px -100px;
                    background-size: 182px 550px;
                    display: inline-block;
                    margin-right: 6px;
                    vertical-align: middle;
                    position: relative;
                    top: -1px;
                  }
                }
              }
            }
          }
        }
        ._j_pager {
          .ft {
            margin: 20px 0;
            .answer-more {
              width: 100%;
              height: 40px;
              border-radius: 4px;
              line-height: 40px;
              text-align: center;
              a {
                display: block;
                width: 100%;
                height: 100%;
                background-color: #efefef;
                color: #666;
                &:hover {
                  background-color: #fff5e5;
                  color: #192885;
                  text-decoration: none;
                  i {
                    background-position: 0 -347px;
                  }
                }
                i {
                  display: inline-block;
                  width: 10px;
                  height: 10px;
                  background: url(../../assets/images/mfwask-2016sprite-2x_v3.png) no-repeat;
                  background-position: 0 -329px;
                  background-size: 50px 400px;
                  margin-left: 6px;
                }
              }
            }
            .answer-loading {
              width: 100%;
              height: 40px;
              border-radius: 4px;
              line-height: 40px;
              text-align: center;
              background-color: #fff5e5;
              color: #192885;
              i {
                display: inline-block;
                width: 22px;
                height: 4px;
                background: url(../../assets/images/mfwask-2016loading.gif) no-repeat;
                margin-left: 6px;
              }
            }
          }
        }
      }
    }
    .col-side {
      float: right;
      width: 260px;
      .i-ask {
        margin-bottom: 30px;
        .btn-ask {
          display: block;
          border-radius: 4px;
          margin-top: 73px;
          height: 46px;
          background-color: #f4f4f4;
          line-height: 46px;
          color: #ff8a00;
          font-size: 16px;
          text-align: center;
          overflow: hidden;
          &.btn-ask2 {
            background-color: #192885;
            text-decoration: none;
            color: #fff;
            i {
              background-position: -30px 0;
            }
          }
          i {
            display: inline-block;
            margin: 0 9px 0 0;
            width: 15px;
            height: 15px;
            background: url(../../assets/images/mfw-ask-sprite19.png) no-repeat -30px -15px;
            overflow: hidden;
            vertical-align: -2px;
          }
        }
      }
    }
  }
  .hide {
    display: none;
  }
}
</style>
