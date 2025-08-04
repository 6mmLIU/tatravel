<template>
  <div v-if="detailData" class="details-container">
    <div class="set_index">
      <div class="set_bg _j_load_cover" :style="{ zIndex: 1, backgroundImage: `url(${detailData.coverUrl})`, opacity: 1 }"></div>
      <div class="_j_titlebg">
        <div class="title_bg"></div>
        <div class="view_info">
          <div class="vi_con">
            <h1 class="headtext lh80" style="white-space: nowrap; overflow-wrap: normal">{{ detailData.title }}</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="view_title clearfix">
      <div class="pagelet-block">
        <div class="vt_center">
          <div class="ding _j_ding_father mfw-acc-hide" @click="setTop">
            <a rel="nofollow" class="up_act" title="顶">顶</a>
            <div class="num _j_up_num">{{ detailData.thumbsupnum }}</div>
          </div>
          <div class="person">
            <a href="javascript:;" class="per_pic">
              <img width="120" height="120" :src="detailData.author.headImgUrl" alt="" />
            </a>
            <strong
              ><a href="/u/46381190.html" target="_blank" class="per_name" :title="detailData.author.nickname">{{ detailData.author.nickname }}</a></strong
            >
            <a href="/u/46381190.html" target="_blank" class="per_grade" title="LV.45">LV.{{ detailData.author.level }}</a>
            <a href="javascript:void(0);" class="per_attention mfw-acc-hide" @click="attentionBtnClick(detailData)">
              <img v-if="!detailData.isFollow" src="http://images.mafengwo.net/images/home/tweet/btn_sfollow.gif" width="38" height="13" border="0" title="关注TA" />
            </a>
            <div class="vc_time">
              <span class="time">{{ formatTime(detailData.updateTime, 'YYYY-MM-DD HH:mm:ss') }}</span>
              <span><i class="ico_view"></i>{{ detailData.viewnum }}/{{ detailData.favornum?detailData.favornum:0 }}</span>
            </div>
          </div>

          <div class="bar_share _j_share_father _j_top_share_group mfw-acc-hide">
            <div class="bs_share">
              <a href="javascript:void(0);" rel="nofollow" title="分享" class="bs_btn"
                ><i></i><span>{{ detailData.sharenum }}</span
                ><strong>分享</strong></a
              >
              <div class="bs_pop clearfix">
                <a title="分享到新浪微博" rel="nofollow" role="button" class="sina"></a>
                <a title="分享到QQ空间" rel="nofollow" role="button" class="zone"></a>
                <a title="分享到微信" rel="nofollow" role="button" class="weixin"></a>
              </div>
            </div>
            <div class="bs_collect">
              <a href="javascript:void(0);" @click="setCollect" rel="nofollow" title="收藏" class="bs_btn _j_do_fav bs_un_btn" v-if="!collectStatus">
                <i></i>
                <span>{{ detailData.favornum ? detailData.favornum : 0}}</span>
                <strong>收藏</strong>
              </a>
              <a href="javascript:void(0);" @click="setUnCollect" rel="nofollow" title="取消收藏" class="bs_btn _j_do_fav" v-else>
                <i></i>
                <span>{{ detailData.favornum ? detailData.favornum : 0}}</span>
                <strong>取消收藏</strong>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="view clearfix">
      <div class="view_con">
        <div class="travel_directory">
          <div class="tarvel_dir_list clearfix">
            <ul>
              <li class="time">出发时间<span>/</span>{{ formatTime(detailData.travelTime, 'YYYY-MM-DD') }}<i></i></li>
              <li class="day">出行天数<span>/</span>{{ detailData.day }}天</li>
              <li class="people">人物<span>/</span>{{ detailData.personDisplay }}</li>
              <li class="cost">人均费用<span>/</span>{{ detailData.avgConsume }}RMB</li>
            </ul>
          </div>
        </div>
        <div class="vc_article" v-html="detailData.content.content"></div>
        <div v-if="commentsList" class="note-reply">
          <div v-for="(item, index) in commentsList" :key="item.id" class="mfw-cmt-wrap">
            <div class="mfw-cmt">
              <div class="mcmt-info">
                <div class="mcmt-photo">
                  <a href="/u/34226623.html" target="_blank" >
                    <img :src="item.user?item.user.headImgUrl:''" width="48" height="48" :alt="item.user?item.user.nickname:''" />
                  </a>
                </div>
                <div class="mcmt-user">
                  <a href="/u/34226623.html" target="_blank" class="name">{{ item.user?item.user.nickname:'' }}</a>
                  <a href="/user/lv.php" class="level">LV.{{ item.user?item.user.level:'' }}</a>
                  <!-- <a href="javascript:void(0);" class="per_attention hide" data-japp="following" data-uid="34226623" data-follow_class="hide" @click="attentionBtnClick(item)" >
                    <img src="http://images.mafengwo.net/images/home/tweet/btn_sfollow.gif" width="38" height="13" border="0" title="关注TA" />
                  </a> -->
                </div>
                <div class="mcmt-other">
                  <span class="floor">{{(currentPage-1)*10+index + 1 }}F</span>
                </div>
              </div>
              <div class="mcmt-con-wrap clearfix">
                <div class="mcmt-con">
                  <div v-if="item.refComment" class="mcmt-quote">
                    <p>引用 {{ item.refComment.user.nickname }} 发表于 {{ formatTime(item.refComment.createTime, 'YYYY-MM-DD') }} 的回复：</p>
                    <p>{{ item.refComment.content }}</p>
                  </div>
                  <div class="mcmt-word">
                    <p>{{ item.content }}</p>
                  </div>
                </div>
              </div>
              <div class="mcmt-bot">
                <div class="time">{{ formatTime(item.createTime, 'YYYY-MM-DD') }}</div>
                <div class="option">
                  <a role="button" class="reply-report">举报</a>
                  <a role="button" class="_j_reply" @click="setAsk(item)">回复</a>
                </div>
              </div>
            </div>
          </div>
          <div class="page-box">
              <el-pagination
              class="page"
              layout="prev, pager, next"
              :page-size="10"
              :page-count="(total/10)%1==0?(total/10):Math.floor(total/10)+1"
              v-model:current-page="currentPage"
              @current-change="currentChange"
            />
          </div>
        </div>
        <div class="mcmt-reply-wrap" v-if="mcmtStatus">
          <div class="mcmt-tab">
            <ul>
              <li class="on" data-mode="article">回复游记<i></i></li>
            </ul>
          </div>
          <div class="mcmt-tab-con">
            <div class="photo-con">
              <a v-if="userInfo" href="/u/36990279.html" target="_blank" title="Casey">
                <img  :src="userInfo.headImgUrl" alt="Casey" />
              </a>
              <a v-else href="/login" target="_blank" title="Casey">
                未登录
              </a>
            </div>
            <div class="reply-con clearfix">
              <dl>
                <dt>
                  <div class="reply-choice">
                    <Emote @changeEmote="changeEmote"></Emote>
                  </div>
                </dt>
                <dd>
                  <div class="reply-text">
                    <el-input
                        type="textarea"
                        :rows="10"
                        :resize="false"
                        :placeholder="'回复' + plaName + ':'"
                        v-model="forms.content">
                    </el-input>
                  </div>
                </dd>
              </dl>
              <div class="reply-submit" @click="submitReply">
                <a role="button" class="_j_publish_reply" title="发表回复">发表回复</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="view_side">
        <div class="relations">
          <div>
            <div class="notes_gonglve">
              <div class="side_title">相关攻略</div>
              <el-carousel class="notes-list" indicator-position="outside" height="160px">
                <el-carousel-item  v-for="n in strategies" :key="n.id" style="background: #f00">
                  <a class="notes-item" href="/gonglve/ziyouxing/242434.html?cid=1010608" target="_blank">
                    <img :src="n.coverUrl" />
                    <span><i></i>{{n.viewnum}}</span>
                    <h3>{{n.title}}</h3>
                  </a>
                </el-carousel-item>
              </el-carousel>
            </div>
            <div class="notes_gonglve">
              <div class="side_title">相关游记</div>
              <el-carousel class="notes-list" indicator-position="outside" height="160px">
                <el-carousel-item v-for="n in notes" :key="n.id" style="background: #f00">
                  <a class="notes-item" href="/gonglve/ziyouxing/242434.html?cid=1010608" target="_blank" >
                    <img :src="n.coverUrl" />
                    <span><i></i>{{n.viewnum}}</span>
                    <h3>{{n.title}}</h3>
                  </a>
                </el-carousel-item>
              </el-carousel>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import moment from 'moment'
import {
  getTravelsDetail,
  getCommentsList,
  setTopApi,
  collect,
  uncollect,
  commentAdd,
  strategyViewnnumTop3,
  travelViewnnumTop3
} from '../../../composables/api/note'
import {ElMessage} from "element-plus";
import {followOperate} from '@/composables/api/friend'
import { emoteData } from '~~/composables/globaldata';


const route = useRoute()
// console.log(route.params)
const id = route.params.id //游记Id
const detailData = ref() //游记详情
const commentsList = ref() //评论列表
const collectStatus = ref() // 收藏操作
const plaName = ref('') // 回复人员昵称
const mcmtStatus = ref(true)
const strategies = ref()  //攻略点击量前三
const notes = ref()       //攻略点击量前三
const forms = reactive({
  noteId: '', // 游记id
  noteTitle: '', // 游记标题
  userId: '', // 用户id
  state: '', // 状态 0:正常 1:禁用
  type: 0, // 评论类型 0:普通评论 1:评论的评论
  content: '', //  内容
  refId: '', // 关联评论
})

const total=ref(0);
const currentPage=ref(1);

const userInfo=ref(null);

const setAsk = function (item) { // 获取回复的人员信息
  // mcmtStatus.value = true
  plaName.value = item.user.nickname
  forms.noteId = item.noteId
  forms.noteTitle = item.noteTitle
  forms.userId = item.userId
  forms.state = item.state
  forms.type = 1
  forms.refId = item.id
}
//获取详情
const getDetail = async () => {
  try {
    const res = await getTravelsDetail({ id })
    detailData.value = res.data
    detailData.value.content.content = detailData.value.content.content/* .replace(/src="\/images/g, 'src="http://192.168.113.236:84/images') */
    collectStatus.value = detailData.value.favorFlag // 获取收藏状态值
    const ret1 =  await strategyViewnnumTop3({destId:detailData.value.destId})
    const ret2 = await travelViewnnumTop3({destId:detailData.value.destId})
    strategies.value = ret1.data;
    notes.value = ret2.data;
  } catch (error) {
    console.log(error);
  }
}
//获取评论列表
const getCommentsData = async () => {
  getCommentsList({ noteId: id }).then((res)=>{
    commentsList.value = res.data.records
    total.value=res.data.total;
  })

}

//格式化日期时间
const formatTime = (time, type) => {
  return moment(time).format(type)
}
// 顶
const setTop = function () {
  setTopApi(id).then((res) => {
    if(res.code==200){
      ElMessage.success('顶成功了！');
    }
    getDetail()
    getCommentsData()
  })
}
// 收藏
const setCollect = function (name) {
  collect(id).then((res) => {
    if(res.code==200){
      ElMessage.success('收藏成功');
    }
    getDetail()
    getCommentsData()
  })
}
// 取消收藏
const setUnCollect = function (name) {
  uncollect(id).then((res) => {
    ElMessage.success('取消收藏成功');
    getDetail()
    getCommentsData()
  })
}


// 用于标记是否需要执行 submitReply 函数
let executeSubmitReply = false;



// 发表评论回复
const submitReply = function () {
  forms.noteId = detailData.value.id
  forms.noteTitle = detailData.value.title
  forms.userId = detailData.value.author.id
  forms.state = detailData.value.author.state
  forms.type = 0

  let param = {
    noteId : detailData.value.id,
    noteTitle : detailData.value.title,
    refId : forms.refId,
    content : forms.content
  }


  commentAdd(param).then((res) => {

    if (res.code === 200) {  ElMessage.success('评论成功！') }

    forms.content='';

    getCommentsData()
  })
}

const currentChange=async ()=>{
  const res = await getCommentsList({ noteId: id ,currentPage:currentPage.value});

  commentsList.value = res.data.records
  total.value=res.data.total;
}

const attentionBtnClick=(item)=>{
  //console.log(item);
  const id=item.authorId||item.userId

 if(userInfo){
  if(userInfo.value.id==id){
    ElMessage.warning('不能关注自己哟！');
    return;
  }
  followOperate(id).then((res)=>{
    if(detailData.value.isFollow){
      ElMessage.error('取消关注成功');
      if(item.authorId){
        detailData.value.isFollow=false;
      }

    }else{
      ElMessage.success('关注成功');
      if(item.authorId){
        detailData.value.isFollow=true;
      }
    }
  })
 }

}

//选择表情
const changeEmote=(index)=>{
  forms.content+=emoteData[index].char;
}


//吐司
const queryToasts = async (param) => {
  alert(2)

}
//相关攻略
const queryViewnumTop3Strategy = async () => {
  getCommentsList({ noteId: id }).then((res)=>{
    commentsList.value = res.data.records
    total.value=res.data.total;
  })
}

//相关游记
const queryViewnumTop3Note = async () => {
  getCommentsList({ noteId: id }).then((res)=>{
    commentsList.value = res.data.records
    total.value=res.data.total;
  })
}

onMounted(() => {
  userInfo.value=JSON.parse(localStorage.getItem('userInfo'));

  nextTick(() => {
    getDetail()
    getCommentsData()


  })
})
</script>
<style lang="scss" scoped>
.details-container {
  position: relative;

  .set_index {
    height: 480px;
    background: url(../../../assets/images/page_bg.jpg) center 0 no-repeat;
    background-size: cover;
    position: relative;

    .set_bg {
      width: 100%;
      height: 100%;
      position: absolute;
      left: 0;
      top: 0;
      z-index: 0;
      background-position: center 0;
      background-repeat: no-repeat;
      background-size: cover;
      overflow: hidden;
    }

    .title_bg {
      height: 119px;
      background: url(../../../assets/images/title_bg.png) 0 bottom repeat-x;
      position: absolute;
      left: 0;
      right: 0;
      bottom: 0;
      z-index: 1;
      opacity: 0.5;
      filter: alpha(opacity=50);
    }

    .view_info {
      width: 100%;
      height: 90px px;
      position: absolute;
      left: 0;
      bottom: 0;
      z-index: 15;

      .vi_con {
        width: 830px;
        padding: 0 0 10px 150px;
        margin: 0 auto;
        position: relative;
        z-index: 2;
        color: #fff;
        font-size: 14px;
        font-weight: bold;

        h1 {
          width: 710px;
          height: 80px;
          font-size: 26px;
          line-height: 38px;
          overflow: hidden;

          &.lh80 {
            line-height: 80px;
          }
        }
      }
    }
  }

  .view_title {
    height: 80px;
    border-bottom: 1px solid #d7d7d7;
    box-shadow: 0 2px 0 rgb(0 0 0 / 5%);
    position: relative;
    z-index: 16;

    .vt_center {
      width: 1000px;
      margin: 0 auto;

      .ding {
        position: absolute;
        right: 50%;
        top: -77px;
        width: 70px;
        margin-right: -475px;
        text-align: center;
        color: #fff;
        z-index: 4;

        a {
          width: 37px;
          height: 33px;
          display: inline-block;
          margin-bottom: 5px;
          text-align: center;
          line-height: 32px;
          background: url(../../../assets/images/sprite_v35.png) -293px -236px no-repeat;
          font-size: 18px;
          color: #fff;
          text-shadow: 1px 0 1px #fcaf54;
        }

        .num {
          font-size: 14px;
          font-weight: bold;
          font-family: Verdana, Arial, Helvetica, STHeiti;
        }
      }

      .person {
        width: 480px;
        padding: 20px 0 0 150px;
        float: left;
        position: relative;

        a {
          display: inline-block;
          margin-right: 5px;

          &.per_pic {
            width: 120px;
            height: 120px;
            position: absolute;
            top: -80px;
            left: 0;
            z-index: 88;

            img {
              border-radius: 50%;
            }
          }

          &.per_name {
            color: #ff7200;
            font-size: 14px;
            font-weight: normal;
          }

          &.per_grade {
            color: #ea3c1a;
            font-family: Verdana, Arial, Helvetica, STHeiti;
            font-size: 10px;
            font-weight: bold;
            text-decoration: none;
          }
        }

        .vc_time {
          color: #acacac;
          display: inline;
          margin-left: 10px;

          span {
            display: inline-block;
            font-family: Verdana, Arial, Helvetica, STHeiti;
            margin-right: 10px;

            i {
              width: 18px;
              height: 14px;
              display: inline-block;
              background: url(../../../assets/images/sprite_v35.png) -51px -327px no-repeat;
              margin-right: 4px;
              vertical-align: -2px;
            }
          }
        }
      }

      .bar_share {
        float: right;
        width: 245px;

        .bs_share {
          position: relative;
          z-index: 10;
          float: right;
          width: 120px;
          height: 65px;
          padding-top: 15px;
          text-align: center;
          border-left: 1px solid #e8e8e6;
          border-right: 1px solid #e8e8e6;

          &:hover {
            .bs_pop {
              display: block;
            }
          }

          .bs_pop {
            display: none;
            width: 132px;
            padding: 8px 10px;
            background-color: #fff;
            border-radius: 6px;
            box-shadow: 0 1px 4px rgb(0 0 0 / 30%);
            position: absolute;
            right: 0;
            top: 100%;
            z-index: 10;

            a {
              width: 36px;
              height: 36px;
              display: inline-block;
              margin: 0 12px 0 0;
              background: #d84c4c url(../../../assets/images/sprite_v35.png) -295px -569px no-repeat;
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

        .bs_collect {
          float: right;
          width: 120px;
          height: 65px;
          padding-top: 15px;
          text-align: center;
          border-left: 1px solid #e8e8e6;

          .bs_btn {
            i {
              background-position: -30px 0;
            }
          }
          .bs_un_btn {
            i {
              background-position: 0 0;
            }
          }
        }

        .bs_btn {
          display: block;
          line-height: 24px;
          font-size: 14px;
          color: #666;
          width: auto;
          position: relative;
          z-index: 1;

          i {
            display: block;
            width: 25px;
            height: 24px;
            margin: 0 auto 7px;
            background: url(../../../assets/images/notes-share-collect@2x.png) no-repeat;
            background-size: 100px auto;
            background-position: -60px 0;
          }

          span {
            display: inline-block;
            width: auto;
            margin-right:5px;
          }

          strong {
            display: inline-block;
            font-weight: normal;
          }
        }
      }
    }
  }

  .view {
    position: relative;
    width: 1000px;
    margin: 40px auto 20px;

    .view_con {
      width: 680px;
      float: left;

      .vc_article {
        line-height: 28px;
        font-size: 15px;
        color: #444;
        margin-bottom: 20px;
        text-align: justify;
        word-break: break-word;
      }

      .travel_directory {
        border: 1px dashed #d7d7d7;
        padding-bottom: 18px;
        width: 100%;
        margin-bottom: 30px;
        border-radius: 4px;
        position: relative;

        .tarvel_dir_list {
          margin-left: 20px;

          ul {
            width: 100%;

            li {
              width: 170px;
              margin-top: 18px;
              float: left;
              display: inline;
              font-size: 14px;
              height: 22px;
              line-height: 22px;
              color: #666;
              padding-left: 5%;
              background: url(../../../assets/images/151204sprite2.png) no-repeat;
              background-size: 44px 88px;
              cursor: pointer;

              &.time {
                background-position: -22px 0;
              }

              &.day {
                background-position: -22px -22px;
              }

              &.people {
                background-position: -22px -44px;
              }

              &.cost {
                background-position: -22px -66px;
              }

              span {
                color: #192885;
                margin: 0 5px;
              }
            }
          }
        }
      }

      .note-reply {
        .mfw-cmt-wrap {
          width: 680px;
          margin: 60px auto;

          .mfw-cmt {
            width: 100%;
            font-size: 12px;
            line-height: 20px;
            margin-bottom: 24px;

            .mcmt-info {
              width: 100%;
              height: 48px;
              line-height: 48px;
              background-color: #f6f6f6;
              border-top-left-radius: 24px;
              border-bottom-left-radius: 24px;

              .mcmt-photo {
                width: 48px;
                height: 48px;
                border-radius: 50%;
                float: left;
                margin-right: 20px;
                position: relative;

                img {
                  display: block;
                  width: 100%;
                  height: 100%;
                  border-radius: 50%;
                }
              }

              .mcmt-user {
                float: left;

                .name {
                  color: #ff8a00;
                  margin-right: 6px;
                }

                .level {
                  color: #ef523d;
                  margin-right: 6px;
                }
              }

              .mcmt-other {
                float: right;
                padding-right: 10px;

                .floor {
                  font-size: 12px;
                  color: #999;
                }
              }
            }

            .mcmt-con-wrap {
              padding-left: 68px;
              margin-top: 12px;
              position: relative;

              .mcmt-con {
                width: 486px;
                float: left;

                .mcmt-quote {
                  color: #999;

                  p {
                    margin: 5px 0;
                  }
                }
              }
            }

            .mcmt-bot {
              padding-left: 68px;
              height: 24px;
              line-height: 24px;
              color: #999;
              margin-top: 16px;

              .time {
                float: left;
                margin-right: 12px;
              }

              .option {
                float: right;
                padding-right: 5px;

                &:hover {
                  display: block;
                }

                .reply-report {
                  display: none;
                  color: #999;
                }

                a {
                  margin: 0 5px;
                  cursor: pointer;
                }
              }
            }
          }
        }
      }

      .mcmt-reply-wrap {
        margin-top: 30px;
        margin-bottom: 50px;

        .mcmt-tab {
          height: 44px;
          line-height: 44px;
          border-bottom: 1px solid #e4e4e4;
          margin-left: 68px;
          margin-bottom: 20px;

          li {
            float: left;
            position: relative;
            width: 180px;
            text-align: center;
            color: #333;
            font-size: 16px;
            cursor: pointer;

            &.on {
              color: #192885;

              i {
                display: block;
              }
            }

            i {
              display: none;
              width: 100%;
              height: 3px;
              background-color: #192885;
              position: absolute;
              left: 0;
              bottom: -2px;
            }
          }
        }

        .mcmt-tab-con {
          padding-left: 68px;
          position: relative;

          .photo-con {
            width: 48px;
            height: 48px;
            position: absolute;
            top: 0;
            left: 0;

            img {
              display: block;
              width: 100%;
              height: 100%;
              border-radius: 50%;
            }
          }

          .reply-con {
            dl {
              border: 1px solid #e5e5e5;

              dt {
                height: 36px;
                padding: 12px 6px 12px 28px;
                background: #f6f6f6;
                border-bottom: 1px solid #e5e5e5;
                position: relative;

                .reply-choice {
                  width: 242px;
                  height: 30px;
                  padding: 3px 0;
                  position: relative;

                  & > a {
                    display: block;
                    float: left;
                    width: 30px;
                    height: 30px;
                    margin-right: 28px;
                    background: url(../../../assets/images/sprite_2x_v2.png) no-repeat;
                    background-size: 120px auto;

                    &.expression {
                      background-position: -30px -870px;

                      &:hover {
                        background-position: -30px -840px;
                      }
                    }
                  }
                }
              }

              .reply-text {
                padding: 5px;

                textarea {
                  outline: 0;
                  border: 0;
                  padding: 0;
                  width: 600px;
                  height: 180px;
                  resize: none;
                  color: #666;
                  line-height: 22px;
                }
              }
            }

            .reply-submit {
              float: right;
              margin-top: 20px;

              a {
                display: block;
                width: 160px;
                height: 40px;
                background-color: #192885;
                border-radius: 4px;
                font-size: 18px;
                line-height: 40px;
                text-align: center;
                color: #fff;
              }
            }
          }
        }
      }
    }

    .view_side {
      width: 240px;
      float: right;

      .slide-right-container {
        position: relative;

        .relation_mdd {
          margin-bottom: 12px;
          font-size: 14px;

          a {
            color: #ff8a00;
          }
        }

        .its_others {
          margin-bottom: 20px;
          font-size: 14px;

          .mdd_info {
            width: 240px;
            position: relative;
            height: 160px;
            overflow: hidden;

            strong {
              position: absolute;
              left: 10px;
              right: 10px;
              color: #fff;
              font-size: 36px;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
              z-index: 1;
              bottom: 12px;
              font-weight: normal;
            }
          }
        }
      }

      .notes_gonglve {
        margin-top: 15px;

        .side_title {
          margin-bottom: 15px;
          font-size: 16px;
          line-height: 1;
        }

        .notes-list {
          .notes-item {
            position: relative;
            display: block;
            width: 240px;
            height: 160px;

            img {
              width: 100%;
              height: 100%;
            }

            span {
              position: absolute;
              left: 5px;
              top: 10px;
              font-size: 12px;
              color: #fff;
              font-family: 'Microsoft Yahei';

              i {
                display: inline-block;
                margin-right: 5px;
                width: 21px;
                height: 16px;
                background: url(../../../assets/images/icon-view-white.png) no-repeat 0 0;
                vertical-align: middle;
              }
            }

            h3 {
              position: absolute;
              left: 0px;
              bottom: 18px;
              width: 240px;
              padding: 0px 7px;
              box-sizing: border-box;
              font-size: 16px;
              color: #fff;
              line-height: 20px;
            }
          }
        }
      }
    }
  }
}

.page-box{
  display: flex;
  justify-content: flex-end;
}
</style>
