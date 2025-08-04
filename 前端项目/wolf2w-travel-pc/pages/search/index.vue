<template>
  <div class="mfw-search-main">

      <div class="search-container" >
        <div class="search-wrap">
          <input v-model="searchVal" class="search-input" placeholder="搜目的地/攻略/游记/用户" />
          <div class="search-btn" @click="changeTab(searchType)">
            <el-icon :size="25" color="white"><Search /></el-icon>
          </div>
        </div>
      </div>

    <div class="s-nav">
      <div class="wid">
        <div class="nav-list clearfix">
          <a href="javascript:;" class="_j_search_link" :class="{ on: searchType === '-1' }"
            @click="changeTab('-1')">全部</a>
          <a href="javascript:;" class="_j_search_link" :class="{ on: searchType === '4' }"
            @click="changeTab('4')">问答</a>
          <a href="javascript:;" class="_j_search_link" :class="{ on: searchType === '1' }"
            @click="changeTab('1')">攻略</a>
          <a href="javascript:;" class="_j_search_link" :class="{ on: searchType === '2' }"
            @click="changeTab('2')">游记</a>
          <a href="javascript:;" class="_j_search_link" :class="{ on: searchType === '3' }"
            @click="changeTab('3')">找人</a>
        </div>
      </div>
    </div>
    <div class="wid clearfix">
      <div class="ser-nums">
        <div class="sr-nums">
          <p class="ser-result-primary">以下是为您找到的“{{ searchVal }}”相关结果{{ total }}条</p>
        </div>
      </div>
      <div id="_j_search_result_left" class="flt1 ser-lt">
        <div v-if="destsList" class="_j_search_section">
          <div class="att-list">
            <ul>
              <li v-for="item in destsList" :key="item.id">
                <div class="clearfix">
                  <div class="flt1">
                    <a href="javascript:;" target="_blank" class="_j_search_link"><img
                        :src="item.coverUrl" style="width: 150px; height: 90px" /></a>
                  </div>
                  <div class="ct-text">
                    <h3>
                      <a :href="`/destination/details/${item.id}`" target="_blank" class="_j_search_link" v-html="item.name"></a>
                    </h3>
                    <p class="seg-desc" v-html="item.info"></p>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div v-if="strategysList && searchType !== '1'" class="heg30"></div>
        <div v-if="strategysList && strategysList.length > 0" class="_j_search_section">
          <div class="att-list">
            <div v-if="searchType !== '1'" class="clearfix ser-title">
              <h2><a href="javascript:;" target="_blank" data-index="1" class="_j_search_link">攻略</a></h2>
              <a href="javascript:;" @click="changeTab('1')" data-index="1" class="_j_search_link">查看更多攻略 &gt;&gt;</a>
            </div>
            <ul>
              <li>
                <div class="clearfix">
                  <div v-for="item in strategysList" :key="item.id">
                    <div class="flt1">
                      <a href="javascript:;" target="_blank" class="_j_search_link"><img
                          :src="item.coverUrl" style="width: 150px; height: 90px" /></a>
                    </div>
                    <div class="ct-text">
                      <h3>
                        <a :href="`/strategy/article/${item.id}`" target="_blank" class="_j_search_link" v-html="item.title"></a>
                      </h3>
                      <p class="seg-desc" v-html="item.summary"></p>
                      <ul class="seg-info-list clearfix">
                        <li>
                          <a href="javascript:;" target="_blank" class="_j_search_link">{{ item.destName }}</a>
                        </li>
                        <li>浏览({{ item.viewnum }})</li>
                        <li>评论({{ item.replynum }})</li>
                        <li>{{ formatTime(item.createTime, 'YYYY-MM-DD hh:mm:ss') }}</li>
                      </ul>
                    </div>
                  </div>
                </div>
              </li>
            </ul>

            <div class="page-box" v-if="searchType == '1'">
              <el-pagination class="page" background layout="prev, pager, next" :page-size="5"
                :page-count="(total / 5) % 1 == 0 ? (total / 5) + 1 : Math.floor(total / 5) + 1" v-model:current-page="currentPage"
                @current-change="currentChange" />
            </div>
          </div>
        </div>
        <div v-if="travelsList && searchType !== '2'" class="heg30"></div>
        <div v-if="travelsList && travelsList.length > 0" class="travel-notes _j_search_section">
          <div v-if="searchType !== '2'" class="clearfix ser-title">
            <h2><a href="javascript:;" target="_blank" class="_j_search_link">游记</a></h2>
            <a href="javascript:;" class="_j_search_link" @click="changeTab('2')">查看更多游记 &gt;&gt;</a>
          </div>
          <ul>
            <li v-for="item in travelsList" :key="item.id">
              <!-- <p class="clearfix">
                <a :href="`/note/details/${item.id}`" target="_blank" class="_j_search_link" v-html="item.title"></a>
                <span class="seg-info">{{ formatTime(item.createTime, 'YYYY-MM-DD hh:mm:ss') }}</span> <span class="seg-info">{{ item.author.nickname }}</span> <span class="seg-info">浏览({{ item.viewnum }})</span> <span class="seg-info">回复({{ item.replynum }})</span>
              </p> -->

              <div class="flt1">
                <a href="javascript:;" target="_blank" class="_j_search_link"><img :src="item.coverUrl"
                    style="width: 150px; height: 90px" /></a>
              </div>
              <div class="ct-text">
                <h3>
                  <a :href="`/note/details/${item.id}`" target="_blank" class="_j_search_link" :style="{color:'#333'}" v-html="item.title"></a>
                </h3>
                <p class="seg-desc" v-html="item.summary"></p>
                <ul class="seg-info-list clearfix">
                  <li>
                    <a href="javascript:;" target="_blank" class="_j_search_link">{{ item.destName }}</a>
                  </li>
                  <li>浏览({{ item.viewnum }})</li>
                  <li>评论({{ item.replynum }})</li>
                  <li>{{ formatTime(item.createTime, 'YYYY-MM-DD hh:mm:ss') }}</li>
                </ul>
              </div>
            </li>
          </ul>

          <div class="page-box" v-if="searchType == '2'">
            <el-pagination class="page" background layout="prev, pager, next" :page-size="5"
              :page-count="(total / 5) % 1 == 0 ? (total / 5) + 1 : Math.floor(total / 5) + 1" v-model:current-page="currentPage"
              @current-change="currentChange" />
          </div>
        </div>
        <div v-if="userList && searchType !== '3'" class="heg30"></div>
        <div v-if="userList && userList.length > 0" class="_j_search_section">
          <div v-if="searchType !== '3'" class="clearfix ser-title">
            <h2><a href="javascript:;" data-index="3" class="_j_search_link">用户</a></h2>
            <a href="javascript:;" data-index="3" class="_j_search_link" @click="changeTab('3')">更多用户 &gt;&gt;</a>
          </div>
          <ul class="user-list-row">
            <li v-for="item in userList" :key="item.id">
              <div class="btns">
                <a href="javascript:;" :class="`btn-follow _j_user_follow ${item.isFocus ? 'follow-disable' : ''}`"
                  @click="setFollow(item)"><i v-if="!item.isFocus"></i>{{ item.isFocus ? '取消关注' : '关注' }}</a> <a
                  href="javascript:;" class="btn-msg _j_user_letter">私信</a>
              </div>
              <span class="avatar"><a href="javascript:;" target="_blank" class="_j_search_link"><img
                    :src="item.headImgUrl" :title="item.nickname" style="width: 45px; height: 45px" /></a></span>
              <div class="base">
                <span class="name">
                  <a href="javascript:;" target="_blank" class="_j_search_link">
                    <span v-html="item.nickname"></span> - <span><span v-html="item.city"></span></span></a></span>
                <a href="javascript:;" class="grade">LV.{{ item.level }}</a>
              </div>
              <div class="nums"><a href="javascript:;" target="_blank" class="_j_search_link">游记：0</a> <a
                  href="javascript:;" target="_blank" class="_j_search_link">粉丝：0</a> <a href="javascript:;"
                  target="_blank" class="_j_search_link">回复：0</a></div>
            </li>
          </ul>

          <div class="page-box" v-if="searchType == '3'">
            <el-pagination class="page" background layout="prev, pager, next" :page-size="5"
              :page-count="(total / 5) % 1 == 0 ? (total / 5) : Math.floor(total / 5) + 1" v-model:current-page="currentPage"
              @current-change="currentChange" />
          </div>
        </div>

        <div v-if="questionList && searchType !== '4'" class="heg30"></div>
        <div v-if="questionList && questionList.length > 0" class="_j_search_section">
          <div v-if="searchType !== '4'" class="clearfix ser-title">
            <h2><a href="javascript:;" data-index="3" class="_j_search_link">问答</a></h2>
            <a href="javascript:;" data-index="3" class="_j_search_link" @click="changeTab('4')">更多问答 &gt;&gt;</a>
          </div>
          <ul class="question-list-row" v-if="questionList">
            <li v-for="item in questionList" :key="item.id" class="question-item">
              <a class="question-item-title" :href="`/questions/details/${item.id}`" target="_blank" v-html="item.title"></a>
              <div class="answer-content" v-if="item.content"
                v-html="item.content">
              </div>
              <ul class="question-info-list">
                <li>{{ route.query.keyword }}</li>
                <li>{{ item.answerList ? item.answerList.length : 0 }}回答</li>
              </ul>
            </li>
          </ul>

          <div class="page-box" v-if="searchType == '4'">
            <el-pagination class="page" background layout="prev, pager, next" :page-size="5"
              :page-count="(total / 5) % 1 == 0 ? (total / 5) : Math.floor(total / 5) + 1" v-model:current-page="currentPage"
              @current-change="currentChange" />
          </div>
        </div>
      </div>
      <div class="flt1 ser-rt">
        <div data-category="poi" class="_j_search_section">
          <div class="clearfix ser-title">
            <h2><a href="javascript:;" target="_blank" class="_j_search_link">广州相关景点</a></h2>
          </div>
          <div class="hot-att">
            <ul class="clearfix">
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://n1-q.mafengwo.net/s9/M00/ED/76/wKgBs1gl2CWAbUytABAWJaKdmGA57.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">xxxx旅游度假区</a></p>
              </li>
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://p1-q.mafengwo.net/s11/M00/CE/1D/wKgBEFtr-IaAS0GtAFG11wwxAa051.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">xxxx塔</a></p>
              </li>
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://p2-q.mafengwo.net/s10/M00/A0/51/wKgBZ1m1GOaARk_EADxTppCJcxM97.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">沙面岛</a></p>
              </li>
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://b3-q.mafengwo.net/s7/M00/C7/AD/wKgB6lR5opGAGEHlAD25BlYH-ko88.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">石室圣心大教堂</a></p>
              </li>
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://b2-q.mafengwo.net/s6/M00/C3/9D/wKgB4lNfwpSAKyXyAEkj1i6lSVY39.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">xxx野生动物世界</a></p>
              </li>
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://p3-q.mafengwo.net/s7/M00/C8/5C/wKgB6lR5o4KAc7l-AEk0iSpwfGg16.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">xxx公园</a></p>
              </li>
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://b4-q.mafengwo.net/s11/M00/A7/76/wKgBEFrbyiKAKSn0AAaqOqFhpEo01.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">xxx步行街</a></p>
              </li>
              <li>
                <a href="javascript:;" target="_blank" class="_j_search_link"><img
                    src="http://b2-q.mafengwo.net/s11/M00/4A/AD/wKgBEFs-PPmAIUaUAA1AsJQA6qs30.jpeg?imageMogr2%2Fthumbnail%2F%21180x180r%2Fgravity%2FCenter%2Fcrop%2F%21180x180%2Fquality%2F90"
                    style="width: 90px; height: 90px" /></a>
                <p><a href="javascript:;" target="_blank" class="_j_search_link">xx欢乐世界</a></p>
              </li>
            </ul>
          </div>
        </div>
        <div class="s-hr"></div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import moment from 'moment'
import { searchList } from '@/composables/api/search'
import { followOperate, getFollow } from '@/composables/api/friend'
import { ElMessage } from 'element-plus';
import { fa } from 'element-plus/es/locale';

const route = useRoute()
const searchType = ref(route.query.type) // 搜索类型
const searchVal = ref(route.query.keyword) // 搜索值
const total = ref(0) // 搜索总数
const userList = ref(null)
const travelsList = ref(null)
const strategysList = ref(null)
const destsList = ref(null)

const questionList = ref(null);

const currentPage = ref(1);

onMounted(() => {
  nextTick(() => {
    getSearchContent(1, 5)
  })
})

//格式化日期时间
const formatTime = (time, type) => {
  return moment(time).format(type)
}

function changeTab(type) {
  searchType.value = type;
  console.log(type);

  currentPage.value = 1;
  getSearchContent(currentPage.value, 5)
}

function getSearchContent(currentPage, pageSize) {
  searchList({ type: searchType.value, keyword: searchVal.value, currentPage, pageSize })
    .then(res => {
      //console.log(res);
      
      if (searchType.value === '-1') {
        userList.value = res.data.users
        getFollowList(userList.value);
        travelsList.value = res.data.notes
        strategysList.value = res.data.strategies
        destsList.value = res.data.dests
        questionList.value = null
        total.value = res.data.total
      } else if (searchType.value === '0') {
        userList.value = res.data.users
        travelsList.value = res.data.notes
        strategysList.value = res.data.strategies
        destsList.value = [res.data.dest]
        total.value = res.data.total
      } else if (searchType.value === '1') {
        userList.value = null
        travelsList.value = null
        destsList.value = null
        questionList.value = null
        strategysList.value = res.data.content
        total.value = res.data.totalElements
      } else if (searchType.value === '2') {
        userList.value = null
        strategysList.value = null
        destsList.value = null
        questionList.value = null
        travelsList.value = res.data.content

        total.value = res.data.totalElements
      } else if (searchType.value === '3') {
        travelsList.value = null
        strategysList.value = null
        destsList.value = null
        questionList.value = null
        userList.value = res.data.content
        console.log(userList.value);
       // getFollowList(userList.value);
        total.value = res.data.totalElements
      } else if (searchType.value === '4') {
        userList.value = null
        travelsList.value = null
        destsList.value = null
        strategysList.value = null
        questionList.value = res.data.content
        total.value = res.data.totalElements

      }
    })
    .catch(err => {
      console.log(err)
    })
}

const getFollowList = (list) => {
  // getFollow().then((res) => {
  //   if(res.data){
  //     res.data.records.forEach((record) => {
  //     list.forEach((item) => {
  //       if (item.id == record.userId) {
  //         item.isfollow = true;
  //       }
  //     })
  //   })
  //   }

  // })
}

const currentChange = () => {
  // console.log(currentPage);
  getSearchContent(currentPage.value, 5)
}

const setFollow = (item) => {
  //console.log(item);

  if (localStorage.getItem('userInfo')) {//判断用户是否存在，如果存在
    const userInfo = JSON.parse(localStorage.getItem('userInfo'));
    if (userInfo.id == item.id) {
      ElMessage.warning('不能关注自己哟！');
    } else {
      followOperate(item.id).then((res) => {
        if (res.data.statusDesc == '关注成功') {
          ElMessage.success('关注用户成功！');
        } else if (res.data.statusDesc == '取消关注成功') {
          ElMessage.success('取消关注成功！');
        }
       // getFollowList(userList.value);
       getSearchContent(currentPage.value,5);
      })
    }
  } else {//如果不存在
    navigateTo('/login')
  }



  // item.isfollow=!item.isfollow;
}
</script>
<style lang="scss" scoped>



.mfw-search-main {
  font-size: 13px;

  .s-nav {
    height: 50px;
    background: #fafafa;

    .wid {
      width: 985px;
      padding-left: 125px;
      padding-bottom: 60px;

      .nav-list {
        line-height: 38px;
        padding-top: 10px;

        a {
          float: left;
          height: 37px;
          font-size: 14px;
          color: #333;
          padding: 0 10px;
          margin-right: 10px;

          &.on {
            border-bottom: 3px solid #ff7000;
            color: #ff7000;
          }

          &:hover {
            text-decoration: none;
            color: #ff7000;
          }
        }
      }
    }
  }

  .wid {
    width: 985px;
    padding-left: 125px;
    padding-bottom: 60px;

    .ser-nums {
      color: #666;
      margin: 20px 0;

      .ser-result-primary {
        font-size: 12px;
        color: #999;
      }
    }

    .ser-lt {
      width: 600px;
      overflow: hidden;

      .att-list {
        a {
          color: #333;
          font-size: 14px;
        }

        &>ul>li {
          margin-top: 30px;

          &:first-child {
            margin-top: 10px;
          }
        }
      }

      .ct-text {
        padding-left: 160px;

        h3 {
          margin-bottom: 8px;
          line-height: 18px;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;

          a {
            font-size: 18px;
          }
        }

        .seg-desc {
          max-height: 40px;
          margin-bottom: 4px;
          overflow: hidden;
          font-size: 13px;
          color: #333;
          line-height: 20px;
        }

        .seg-info-list {
          font-size: 12px;
          color: #999;

          li {
            float: left;
            margin: 0;
            margin-right: 8px;
            height: 20px;

            a {
              font-size: 12px;
              color: #999;
            }
          }
        }
      }

      .ser-title {
        border-bottom: 1px solid #e5e5e5;
        margin-bottom: 10px;

        a {
          float: right;
          font-size: 14px;
          color: #1493e3;

          &:hover {
            color: #ff7000;
          }
        }

        h2 {
          float: left;
          font-size: 18px;
          line-height: 30px;
          font-weight: bold;
          color: #333;

          a {
            font-size: 18px;
            line-height: 30px;
            font-weight: bold;
            color: #333 !important;
          }
        }
      }

      .travel-notes ul {
        margin-top: 10px;

        li {
          // height: 24px;
          // overflow: hidden;
          // line-height: 24px;
          margin-bottom: 5px;

          p a {
            margin-right: 8px;
            color: #333;
            font-size: 13px;
            width: 300px;
            float: left;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }

          .seg-info {
            float: left;
            display: inline-block;
            margin-right: 8px;
            font-size: 12px;
            color: #999;
          }
        }
      }

      .user-list-row {
        li {
          font-size: 14px;
          position: relative;
          margin-top: 40px;

          &:first-child {
            margin-top: 0px;
          }
        }

        .btns {
          float: right;
          padding-top: 7px;

          a {
            display: inline-block;
            float: left;
            margin-left: 10px;
            border: 1px solid #ffa800;
            padding: 0 18px;
            line-height: 24px;
            font-size: 14px;
            color: #ff8a00;
            border-radius: 3px;
          }

          .btn-follow {
            background-color: #ffa800;
            color: #fff;

            i {
              display: inline-block;
              margin-right: 5px;
              width: 8px;
              height: 8px;
              background: url(../../assets/images/carte.png) no-repeat -60px 0;
              overflow: hidden;
              vertical-align: middle;
            }
          }

          .follow-disable {
            background-color: #999;
            color: #fff;
            border: 1px solid #999;
          }
        }

        .avatar {
          display: inline-block;
          width: 45px;
          height: 45px;
          border-radius: 50%;
          overflow: hidden;
          vertical-align: middle;
        }

        .base {
          position: absolute;
          top: 0;
          left: 60px;

          .name {
            margin-left: 5px;

            a {
              font-size: 14px;
              color: #111;
            }
          }
        }

        .grade {
          color: #ff7000;
        }

        .nums {
          position: absolute;
          top: 25px;
          left: 60px;

          a {
            margin-left: 5px;
            color: #999;
          }
        }
      }
    }

    .heg30 {
      height: 40px;
      width: 100%;
    }

    .ser-rt {
      width: 300px;
      padding: 15px;
      border: 1px solid #f4f4f4;
      box-shadow: 0 0 7px rgb(0 0 0 / 7%);
      float: right;
      overflow: hidden;
      border-radius: 2px;

      .ser-title {
        border-bottom: 0 none;
        margin-bottom: 10px;

        h2 {
          float: left;
          font-size: 14px;
          line-height: 30px;
          font-weight: bold;
          color: #333;

          a {
            font-size: 18px;
            line-height: 30px;
            font-weight: bold;
            color: #333 !important;
          }
        }
      }

      .hot-att {
        ul {
          width: 320px;

          li {
            float: left;
            margin: 10px 10px 0 0;
            text-align: center;

            p {
              width: 90px;
              height: 40px;
              overflow: hidden;
              text-overflow: ellipsis;
              display: -webkit-box;
              -webkit-box-orient: vertical;
              -webkit-line-clamp: 2;

              a {
                color: #333;
                font-size: 13px;
                line-height: 20px;

                &:hover {
                  color: #ff7000;
                }
              }
            }
          }
        }
      }

      .s-hr {
        width: 100%;
        margin: 15px 0;
        padding: 0;
        border-top: 1px solid #e5e5e5;
        height: 0;
        clear: both;
      }
    }
  }

  .flt1 {
    float: left;
  }

  .search-container {
      bottom: 45px;
      left: 50%;
      width: 632px;
      padding: 10px;
      margin-left: 110px;
      border-radius: 4px;
     
      box-sizing: border-box;
      z-index: 5;

      .search-wrap {
        display: flex;
        align-items: center;
        justify-content: space-between;
        .search-input {
          width: 504px;
          height: 40px;
          border: 0 none;
          padding: 0 21px;
          margin: 0;
          border: 2px solid #000;
          line-height: 46px;
          font-size: 16px;
          color: #666;
          border-radius: 4px;
          background-color: #fff;
        }
        .search-btn {
          width: 50px;
          height: 40px;
          line-height: 60px;
          cursor: pointer;
          border-radius: 4px;
          text-align: center;
          background-color: #192885;
        }
      }
    }



}

.page-box {
  display: flex;
  justify-content: flex-end;
}

.question-list-row {

  .question-item {
    margin-bottom: 25px;

    .question-item-title {
      font-size: 18px;
      color: #333;
      margin-bottom: 5px;
      white-space: nowrap;
      text-overflow: ellipsis;
      overflow: hidden;
    }

    .answer-content {
      max-height: 40px;
      line-height: 20px;
      margin-top: 5px;
      overflow: hidden;
    }

    .question-info-list {
      display: flex;
      margin-top: 10px;
      color: #999;

      li {
        margin-right: 8px;
      }
    }

  }
}
</style>
