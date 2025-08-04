<template>
  <div v-if="detailData" class="details-container clearfix">
    <div class="crumb">
      <a href="/">首页</a> &gt; <a :href="'/destination/details/' + detailData.destId">{{ detailData.destName }}</a> &gt;
      <em>自由行攻略</em>
    </div>
    <div class="local-con clearfix">
      <div class="sideL">
        <div class="l-topic">
          <h1>{{ detailData.title }}</h1>
          <div class="sub-tit">
            <span class="time" style="margin-left: 20px">
              <em v-if="statisticalData">阅读 {{ statisticalData.viewnum }}</em>
            </span>
            <span class="time">自由行攻略<em> 2019-03-19 </em> </span>
          </div>

          <div class="user_list">
            <div class="clearfix">
              <div class="author">
                <a href="javascript:;" target="_blank">
                  <img
                    src="https://p1-q.mafengwo.net/s13/M00/F0/A8/wKgEaVx97qeADs8wAADBwr2ZDjw848.png?imageMogr2%2Fthumbnail%2F%21120x120r%2Fgravity%2FCenter%2Fcrop%2F%21120x120%2Fquality%2F90"
                    alt="" width="90" height="90" />
                </a>
              </div>
              <div class="info">
                <div class="in-t">
                  <a href="/u/75448029.html" target="_blank">
                    <span class="name">叩丁狼官方</span>
                  </a>
                  <span class="rz"><i></i>带TA游攻略作者</span>
                </div>
                <p>人有欢乐，也有苦衷。所谓的完美，其实只是来源于我们的心灵。人生不能重新来过，每个人也不可能重复站在同一个路口。但请不要害怕选择，因为选择没有绝对的好与坏，每种选择都会为你带来一种不一样的感受和别样的精彩。
                </p>
              </div>
              <div class="contact user-home">
                <a href="/u/75448029.html" target="_blank">
                  <i></i>
                  <p>TA的窝</p>
                </a>
              </div>
            </div>
          </div>
        </div>
        <div class="content" v-html="detailData.content.content"></div>
        <div class="copyRight m_t_20">
          <p>本文著作权归 @外滩The bund 所有，任何形式转载请联系作者。©2022 带TA游自由行</p>
        </div>
        <div class="l-comment mfw-acc-hide">
          <div class="clearfix com-form">
            <div class="img">
              <img
                :src="userInfo ? userInfo.headImgUrl : 'https://p1-q.mafengwo.net/s12/M00/35/98/wKgED1uqIreAU9QZAAAXHQMBZ74008.png?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F100'" />
            </div>
            <div class="fm-tare user-log">
              <textarea v-model="commentContent" class="_j_comment_content" ref="myInput" placeholder="说点什么吧..."></textarea>
              <button type="button" class="gotoLogin" @click="addComment">评论</button>
            </div>
          </div>
          <div class="com-box">
            <h2>
              评论（<span class="_comment_num">{{ commentTotal }}</span>）
            </h2>
            <ul id="comments">
              <li v-for="item in commentData" :key="item.id" class="clearfix comment_item">
                <div class="img">
                  <img :src="item.user.headImgUrl" />
                </div>
                <div class="info">
                  <h3>
                    {{ item.user.nickname }}<span>LV.{{ item.user.level }}</span>
                  </h3>
                  <h4>{{ item.createTime }}</h4>
                  <div class="com-cont" v-html="item.content"></div>
                  <div class="rep-del">
                    {{item.thumbnum?item.thumbnum + '  ':''}}
                    <a href="javascript:;" class="btn-comment-like _j_like_comment_btn " @click="thumbComment(item.id)"  :class="item.thumbupidsList.includes(userInfo.id)?'liked':'like'">
                      <span class="_j_comment_like_num">{{ item.thumbupnum }}</span>
                    </a>
                  </div>
                </div>
              </li>
              <div class="page-container">
                <el-pagination class="page" background layout="total, prev, pager, next" :page-size="10"
                  :current-page="commentParams.currentPage" :total="commentTotal"
                  @current-change="commentCurrentChange" />
              </div>
            </ul>
          </div>
        </div>
      </div>
      <div class="sideR">
        <div class="side_inner">
          <div v-if="statisticalData" class="bar-sar clearfix">
            <a href="javascript:;" class="_j_goto_comment" title="评论" @click="()=>{this.$refs.myInput.focus();}"><i class="i01"></i><em>{{ statisticalData.replynum}}</em></a>
            <div class="bs_collect">
              <a href="javascript:void(0);" title="收藏" class="bs_btn btn-collect" @click="strategyFavor">
                <i class="collect_icon i02 " :class="{'on-i02':isFavor}"></i>
                <em class="favorite_num">{{ statisticalData.favornum }}</em>
              </a>
            </div>
            <div class="bs_share"  @mouseover="()=>{displayValue='block'}" @click="()=>{displayValue='none'}">
              <a href="javascript:;" title="分享" class="btn-share bs_btn"><i class="i03"></i><em>{{
                statisticalData.sharenum }}</em></a>
            </div>
            <a href="javascript:;" class="_j_like_btn" title="点赞" style="display: none"><i class="i04"></i><em
                class="like_num">{{ statisticalData.thumbsupnum }}</em></a>
            <a href="javascript:;" class="_j_support_btn" title="顶" @click="strategyThumbup">
              <i class="i05"></i><em class="support_num">{{ statisticalData.thumbsupnum }}</em>
            </a>
          </div>
          <div class="bs_pop clearfix" :style="{ display: displayValue }"    ref="shareDiv">
              <a title="分享到新浪微博" rel="nofollow" role="button" class="sina" data-japp="sns_share"
                  data-jappfedata="" data-key="wb" data-title="盘点 | 广州周边好玩的地方有哪些？"
                  data-content="盘点 | 广州周边好玩的地方有哪些？"
                  data-pic="http://b4-q.mafengwo.net/s13/M00/7F/2D/wKgEaVyLhXKABFf5AAI6AbEkm0o40.jpeg?imageView2%2F2%2Fw%2F640%2Fh%2F360%2Fq%2F90"
                  data-url="http://www.mafengwo.cn/gonglve/ziyouxing/1775.html"></a>
              <a title="分享到QQ空间" rel="nofollow" role="button" class="zone" data-japp="sns_share"
                  data-jappfedata="" data-key="qz" data-title="盘点 | 广州周边好玩的地方有哪些？"
                  data-content="盘点 | 广州周边好玩的地方有哪些？"
                  data-pic="http://b4-q.mafengwo.net/s13/M00/7F/2D/wKgEaVyLhXKABFf5AAI6AbEkm0o40.jpeg?imageView2%2F2%2Fw%2F640%2Fh%2F360%2Fq%2F90"
                  data-url="http://www.mafengwo.cn/gonglve/ziyouxing/1775.html"></a>
              <a title="分享到微信" rel="nofollow" role="button" class="weixin" data-japp="weixin_dialog_share"
                  data-jappfedata=""
                  data-wx_qr="http://www.mafengwo.cn/qrcode.php?text=https%3A%2F%2Fm.mafengwo.cn%2Fgonglve%2Fziyouxing%2F1775.html&amp;size=150&amp;eclevel=H&amp;logo=&amp;__stk__=d3c9fd1d23b028a45ec5b71a30324cb9_391fafc14c22754068d1543e8cfc5d04"
                  data-detail="1775"></a>
          </div>
        </div>
      </div>
      <div class="relate_pro">
        <p class="title">更多广州攻略</p>
        <a class="pro_more" href="/gonglve/ziyouxing/mdd_10222/">查看更多&gt;</a>
        <ul class="bd clearfix">
          <li>
            <a target="_blank" title="《冰雪奇缘2》上映期间广州限定咖啡厅举行盛大活动" href="/gonglve/ziyouxing/317576.html">
              <div class="img">
                <img
                  src="https://p1-q.mafengwo.net/s15/M00/32/4A/CoUBGV3r0QSAYJkuAAJxULdDCKs67.jpeg?imageMogr2%2Fthumbnail%2F%21300x166r%2Fgravity%2FCenter%2Fcrop%2F%21300x166%2Fquality%2F100"
                  alt="" />
              </div>
              <div class="info">
                <h3>《冰雪奇缘2》上映期间广州限定咖啡厅举行盛大活动</h3>
                <div class="sub">
                  <p>▋《冰雪奇缘》电影与料理的创意结合</p>
                  <p>冰雪奇缘 OH MY CAFE</p>
                </div>
              </div>
            </a>
          </li>
          <li>
            <a target="_blank" title="广州周边避暑胜地轻井泽，一日游路线推荐，含交通攻略" href="/gonglve/ziyouxing/107678.html">
              <div class="img">
                <img
                  src="https://p1-q.mafengwo.net/s11/M00/61/B8/wKgBEFsOXDyAZu02ABKDfONfttQ50.jpeg?imageMogr2%2Fthumbnail%2F%21300x166r%2Fgravity%2FCenter%2Fcrop%2F%21300x166%2Fquality%2F100"
                  alt="" />
              </div>
              <div class="info">
                <h3>广州周边避暑胜地轻井泽，一日游路线推荐，含交通攻略</h3>
                <div class="sub">
                  <p>一、轻井泽有什么</p>
                  <p>二、骑车观光线路推荐</p>
                </div>
              </div>
            </a>
          </li>
          <li>
            <a target="_blank" title="广州成田机场交通懒人攻略 前往银座/新宿/上野等地" href="/gonglve/ziyouxing/302892.html">
              <div class="img">
                <img
                  src="https://p1-q.mafengwo.net/s15/M00/4A/FD/CoUBGV2VqquAf1BZAALo3BXzdJ405.jpeg?imageMogr2%2Fthumbnail%2F%21300x166r%2Fgravity%2FCenter%2Fcrop%2F%21300x166%2Fquality%2F100"
                  alt="" />
              </div>
              <div class="info">
                <h3>广州成田机场交通懒人攻略 前往银座/新宿/上野等地</h3>
                <div class="sub">
                  <p>机场航站楼之间的交通</p>
                  <p>成田机场主要交通工具</p>
                </div>
              </div>
            </a>
          </li>
          <li>
            <a target="_blank" title="日本交通超详细攻略（西瓜卡、JR pass、周游券）" href="/gonglve/ziyouxing/127.html">
              <div class="img">
                <img
                  src="https://p1-q.mafengwo.net/s9/M00/90/7F/wKgBs1bmNmeANvtSABH5wwojVlA24.jpeg?imageMogr2%2Fthumbnail%2F%21300x166r%2Fgravity%2FCenter%2Fcrop%2F%21300x166%2Fquality%2F100"
                  alt="" />
              </div>
              <div class="info">
                <h3>日本交通超详细攻略（西瓜卡、JR pass、周游券）</h3>
                <div class="sub">
                  <p>出发前，一定要买好！日本铁路周游券（JR PASS）</p>
                  <p>轻松搞定 广州市内交通</p>
                </div>
              </div>
            </a>
          </li>
          <li>
            <a target="_blank" title="江户秋夜会 | 与古人同游日式庭园" href="/gonglve/ziyouxing/320116.html">
              <div class="img">
                <img
                  src="https://p1-q.mafengwo.net/s15/M00/3F/75/CoUBGV4AGwaAb67GAAKe0l741R052.jpeg?imageMogr2%2Fthumbnail%2F%21300x166r%2Fgravity%2FCenter%2Fcrop%2F%21300x166%2Fquality%2F100"
                  alt="" />
              </div>
              <div class="info">
                <h3>江户秋夜会 | 与古人同游日式庭园</h3>
                <div class="sub">
                  <p>⇢🍹⇠</p>
                  <p>关于秋赏红叶的“豆知识”</p>
                </div>
              </div>
            </a>
          </li>
          <li>
            <a target="_blank" title="广州老街谷根千，带你一秒穿越回昭和时代逛吃逛吃" href="/gonglve/ziyouxing/81918.html">
              <div class="img">
                <img
                  src="https://p1-q.mafengwo.net/s11/M00/22/4A/wKgBEFrSALGAA3s9AALM_NIAAuk79.jpeg?imageMogr2%2Fthumbnail%2F%21300x166r%2Fgravity%2FCenter%2Fcrop%2F%21300x166%2Fquality%2F100"
                  alt="" />
              </div>
              <div class="info">
                <h3>广州老街谷根千，带你一秒穿越回昭和时代逛吃逛吃</h3>
                <div class="sub">
                  <p>&ZeroWidthSpace;一、谷中</p>
                  <p>1.谷中银座商店街</p>
                </div>
              </div>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { strategyDetails, statisVo, commentAdd, commentList, commentThumb, favor, thumbup,viewnumIncr,replynumIncr,isUserFavor } from '@/composables/api/strategy'
import { ElMessage } from 'element-plus'
const route = useRoute()
// console.log(route.params)
const id = route.params.id // 攻略Id
const isFavor = ref(false)
const detailData = ref() //攻略详情
const statisticalData = ref() // 统计数据
const commentContent = ref() // 评论内容
const commentData = ref([])
const commentTotal = ref(0)
const displayValue = ref('none')
const commentParams = ref({
  currentPage: 1,
  strategyId: id
})

const userInfo = ref();

// 攻略详情
const getDetail = async () => {
  const res = await strategyDetails({ id })
  detailData.value = res.data
  detailData.value.content.content = detailData.value.content.content/* .replace(/src="\/images/g, 'src="http://192.168.113.236:84/images') */
}
// 攻略文章统计数据
const getStatisVo = async ()=> {
  const res = await statisVo({ sid: id })
  statisticalData.value = res.data
}
// 评论列表
const getCommentList = async ()=> {
  const ret = await commentList(commentParams.value)
  commentData.value = ret.data.records
  commentTotal.value = ret.data.total
}



//阅读数+1
function strategyViewnumIncr(){
  viewnumIncr({sid:id}).then(resp=>{
    statisticalData.value = resp.data
  })
}
//回复数+1
function strategyReplynumIncr(){
  replynumIncr({sid:id}).then(resp=>{
    statisticalData.value = resp.data
  })
}

function showAlert(){
  alert(1)
}


// 攻略收藏
function strategyFavor() {
  favor({ sid: id})
    .then(res => {
      if (!res.data.result) {
        ElMessage({
          message: '取消收藏成功',
          type: 'success'
        })
      } else {
        ElMessage({
          message: '收藏成功',
          type: 'success'
        })
      }

      isFavor.value = res.data.result
      statisticalData.value = res.data
    })
    .catch(err => {
      console.log(err)
    })
}

//收藏回显
function  strategyUserFavor(uid){
   isUserFavor({sid:id, uid:uid}).then(res=>{
      isFavor.value = res.data
   })
}


// 攻略-顶一下
function strategyThumbup() {
  thumbup({ sid: id})
    .then(res => {
      if (res.data.result) {
        ElMessage({
          message: '顶成功啦',
          type: 'success'
        })
      } else {
        ElMessage({
          message: '今天已经顶过了',
          type: 'success'
        })
      }
      statisticalData.value = res.data
    })
    .catch(err => {
      console.log(err)
    })
}

// 新增评论
function addComment() {
  let params = {
    content: commentContent.value,
    strategyId: id,
    strategyTitle: detailData.value.title
  }
  commentAdd(params)
    .then(res => {
      if (res.code == 200) {
        commentContent.value = '',
        ElMessage({
          message: '评论成功',
          type: 'success'
        })
        strategyReplynumIncr()
        getCommentList();
      }
    })
    .catch(err => {
      console.log(err)
    })
}

// 评论点赞
function thumbComment(id) {
  commentThumb({ cid: id })
    .then(res => {

      ElMessage({
        message: res.data?'点赞成功':'取消点赞',
        type: 'success'
      })
      getCommentList()

    })
    .catch(err => {
      console.log(err)
    })
}



function commentCurrentChange(val: number) {
  commentParams.value.currentPage = val
  getCommentList()
}



onMounted(() => {
  userInfo.value = localStorage.getItem('userInfo') ? JSON.parse(localStorage.getItem('userInfo')) : null;

  nextTick(() => {
     getDetail()
     strategyViewnumIncr()
     getCommentList()
     strategyUserFavor(userInfo.value.id);
  })
})
</script>
<style lang="scss" scoped>


.details-container {
  width: 1000px;
  margin: 0 auto;

  .crumb {
    margin: 15px 0 20px;
    font-size: 14px;
    color: #333;
    line-height: 20px;

    a {
      color: #333;

      &:hover {
        outline: 0;
        text-decoration: underline;
      }
    }

    em {
      color: #192885;
      font-style: normal;
    }
  }

  .local-con {
    margin-top: 20px;

    .sideL {
      width: 680px;
      float: left;

      .l-topic {
        h1 {
          font-size: 30px;
          color: #333;
          line-height: 40px;
          padding-bottom: 16px;
          border-bottom: 1px solid #e5e5e5;
          word-wrap: break-word;
        }

        .sub-tit {
          color: #333;
          font-size: 14px;
          padding: 13px 0 0;
          margin-bottom: 35px;
          overflow: hidden;

          .time {
            margin-left: 20px;
            float: right;
            color: #999;

            em {
              font-style: normal;
              margin-left: 10px;
            }
          }
        }

        .user_list {
          padding: 16px 0 0 0;
          color: #333;
          border: 1px solid #e5e5e5;
          margin: 25px 0 35px;

          .author {
            width: 90px;
            height: 90px;
            margin-left: 15px;
            float: left;
            border-radius: 50%;
            overflow: hidden;
          }

          .info {
            width: 440px;
            float: left;
            padding-left: 22px;

            .in-t {
              color: #333;
              line-height: 20px;

              .name {
                font-size: 16px;
              }
            }

            p {
              font-size: 14px;
              line-height: 20px;
              height: 40px;
              overflow: hidden;
              margin: 6px 0 8px 0;
              color: #333;
            }
          }

          .rz {
            display: inline-block;
            margin-left: 12px;
            padding: 0 5px 0 13px;
            line-height: 14px;
            border: 1px solid #192885;
            color: #f2912e;
            font-size: 12px;
            border-radius: 2px;
            vertical-align: top;
            white-space: nowrap;

            i {
              position: absolute;
              margin: -4px 0 0 -24px;
              display: inline-block;
              width: 22px;
              height: 22px;
              background: url(../../../assets/images/list_sprites4.png) no-repeat -100px -40px;
              background-size: 210px auto;
              overflow: hidden;
            }
          }

          .contact {
            width: 110px;
            height: 96px;
            border-left: 1px solid #e5e5e5;
            float: left;
            text-align: center;

            i {
              width: 32px;
              height: 32px;
              background: url(../../../assets/images/list_sprites4.png) no-repeat 0 -61px;
              background-size: 210px auto;
              display: block;
              margin: 18px auto 0;
            }

            p {
              font-size: 14px;
              padding: 12px 0;
              color: #333;
            }
          }
        }
      }

      .copyRight {
        width: 680px;
        padding-top: 45px;
        background: url(../../../assets/images/copyright.png) no-repeat center center;
        overflow: hidden;

        p {
          background-color: #fff;
          text-align: center;
          line-height: 20px;
          color: #d1d1d1;
          font-size: 12px;
        }
      }

      .m_t_20 {
        margin-top: 20px;
      }

      .l-comment {
        margin-top: 85px;

        .com-form {
          .img {
            overflow: hidden;
            width: 48px;
            height: 48px;
            border-radius: 50%;
            float: left;

            img {
              width: 100%;
              display: block;
            }
          }

          .fm-tare {
            float: right;
            width: 615px;
            position: relative;

            textarea {
              height: 55px;
              width: 585px;
              padding: 14px;
              border: 1px solid #e5e5e5;
              resize: none;
              outline: 0;
              border-radius: 5px;
              float: right;
              font-size: 14px;
              color: #666;
            }

            button {
              width: 114px;
              height: 30px;
              background: #192885;
              color: #fff;
              border: 0;
              outline: 0;
              cursor: pointer;
              display: block;
              float: right;
              margin: 20px 0;
              border-radius: 5px;
              font-size: 16px;
              text-align: center;
              padding: 0;
              line-height: 30px;
            }
          }
        }

        .com-box {
          border-top: 1px solid #e5e5e5;

          h2 {
            font-size: 24px;
            color: #333;
            font-weight: normal;
            line-height: 24px;
            margin: 36px 0;
          }

          li {
            border-bottom: 1px solid #e5e5e5;
            padding: 30px 0;

            .img {
              overflow: hidden;
              width: 48px;
              height: 48px;
              border-radius: 50%;
              float: left;

              img {
                width: 100%;
                display: block;
              }
            }

            .info {
              float: left;
              margin-left: 16px;
              width: 615px;
              position: relative;

              h3 {
                font-size: 18px;
                color: #333;
                font-weight: normal;
                line-height: 28px;

                span {
                  color: #eb5443;
                  font-size: 12px;
                  font-weight: bold;
                  margin-left: 10px;
                }
              }

              h4 {
                font-size: 12px;
                color: #999;
                font-weight: normal;
                line-height: 14px;
              }

              .com-cont {
                font-size: 14px;
                color: #666;
                line-height: 28px;
                margin-top: 8px;
              }

              .rep-del {
                position: absolute;
                right: 0;
                top: 20px;

                a {
                  color: #333;
                  font-size: 12px;
                  line-height: 12px;
                  text-decoration: none;
                }

                .btn-comment-like:after {
                  content: '';
                  display: inline-block;
                  width: 16px;
                  height: 16px;
                  background: url(../../../assets/images/icon_like.png) no-repeat;
                  background-size: 100%;
                  vertical-align: text-bottom;
                }

                .btn-comment-like.liked:after {
                  content: '';
                  display: inline-block;
                  width: 16px;
                  height: 16px;
                  background: url(../../../assets/images/icon_liked.png) no-repeat;
                  background-size: 100%;
                  vertical-align: text-bottom;
                }
              }
            }
          }

          .page-container {
            padding: 20px 5px;
            text-align: right;

            .page {
              display: inline-flex;
            }
          }
        }
      }

      .content {
        line-height: 28px;
        font-size: 14px;
        color: #444;
        margin-bottom: 20px;
        text-align: justify;
        word-break: break-word;
      }
    }

    .sideR {
      position: relative;
      width: 275px;
      float: right;
      padding-top: 5px;

      .side_inner {
        background-color: #fff;

        .bar-sar {
          margin-bottom: 10px;

          a {
            float: left;
            display: block;
            width: 68px;
            height: 70px;
            text-align: center;
            text-decoration: none;
            color: #333;

            i {
              display: block;
              width: 25px;
              height: 24px;
              margin: 0 auto 10px auto;
              background: url(../../../assets/images/list_sprites01.png) no-repeat;

              &.i01 {
                background-position: 0 0;
              }

              &.i02 {

                background-position: -68px 0;
              }
               &.on-i02 {
                background: url(../../../assets/images/list_sprites02.png) no-repeat;
                background-position: -68px 0;
              }

              &.i03 {
                background-position: -136px 0;
              }

              &.i05 {
                background: url(../../../assets/images/icon_support.png) no-repeat;
                background-size: 100%;
              }
            }
            i .on-i02 {
              display: block;
              width: 25px;
              height: 24px;
              margin: 0 auto 10px auto;
              background: url(../../../assets/images/list_sprites02.png) no-repeat;

              &.i02 {
                background-position: -68px 0;
              }

            }
            em {
              font-style: normal;
              font-size: 16px;
              color: #333;
            }
          }
        }
      }
    }

    .relate_pro {
      padding-bottom: 100px;
      clear: both;

      .title {
        font-size: 24px;
        color: #333;
        line-height: 55px;
        height: 55px;
        position: relative;
      }

      .pro_more {
        float: right;
        font-size: 14px;
        color: #192885;
        margin-top: -55px;
        position: relative;
        line-height: 55px;

        &:hover {
          outline: 0;
          text-decoration: underline;
          color: #ff8a00;
        }
      }

      .bd {
        margin-right: -50px;

        li {
          float: left;
          display: inline;
          margin: 0 50px 50px 0;
          width: 300px;
          height: 228px;
          position: relative;
          overflow: hidden;

          &:hover {
            box-shadow: 0 0 15px rgb(0 0 0 / 8%);

            .info {
              height: 80px;

              .sub {
                height: 40px;
              }
            }
          }

          a {
            display: block;
            color: #666;
          }

          .img {
            height: 166px;
            overflow: hidden;
          }

          .info {
            position: absolute;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            padding: 10px;
            height: 40px;
            line-height: 20px;
            -webkit-transition: all 0.2s linear 0.1s;
            transition: all 0.2s linear 0.1s;

            h3 {
              margin-bottom: 5px;
              height: 40px;
              font-size: 16px;
              color: #333;
              overflow: hidden;
            }

            .sub {
              height: 0;
              overflow: hidden;
              -webkit-transition: all 0.2s linear 0.1s;
              transition: all 0.2s linear 0.1s;

              p {
                height: 20px;
                padding: 0;
                overflow: hidden;
                font-size: 14px;
                line-height: 20px;

                &:before {
                  content: '';
                  float: left;
                  margin: 4px 7px 0 0;
                  width: 3px;
                  height: 12px;
                  background-color: #192885;
                }
              }
            }
          }
        }
      }
    }
  }
}

.bs_pop {
    width: 132px;
    padding: 8px 10px;
    background-color: #fff;
    border-radius: 6px;
    box-shadow: 0 1px 4px rgba(0, 0, 0, .3);
    position: absolute;
    right: 0;
    top: 100%;
    z-index: 10;
    display: none;
}

.bs_pop {
    top: 70px;
}

.bs_pop a {
    width: 36px;
    height: 36px;
    display: inline-block;
    margin: 0 12px 0 0;
    background: #d84c4c url(../../../assets/images/sprite_v33.png) -295px -569px no-repeat;
    line-height: 200px;
    overflow: hidden;
    float: left;
    border-radius: 5px;
}

.bs_pop a.zone {
    background-color: #3f8bc0;
    background-position: -331px -569px;
}

.bs_pop a.weixin {
    margin-right: 0;
    background-color: #73a64f;
    background-position: -367px -569px;
}

</style>
