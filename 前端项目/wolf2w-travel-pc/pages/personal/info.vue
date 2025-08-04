<template>
  <div class="personalCenter-body">
    <div class="center clearfix">
      <div class="side_bar flt1">
        <div class="MAvatar">
          <div class="MAvaImg hasAva">
            <img :src="userInfo ? userInfo.headImgUrl : '/assets/images/personal/userImg.png'" height="120" width="120"
              alt="带TA游用户">
            <a href="/setting/avatar/" class="MAvaUp mfw-acc-hide">
              <i class="Mphoto mfw-acc-hide"></i></a>
          </div>
          <div class="MAvaName">{{ userInfo ? userInfo.nickname : '带TA游用户' }}</div>

          <div class="its_tags mfw-acc-hide">
            <a href="/home/vip_show.php" target="_blank" title="VIP"><i class="vip"></i></a>
            <a href="/rudder/info.php" target="_blank" title="分舵"><i class="duo"></i>
            </a><a href="/qa/expert_apply.php?type=1" target="_blank" title="指路人"><i class="zhiluren"></i></a>
          </div>

          <div class="MAvaInfo clearfix MAvaMyInfo mfw-acc-hide">
            <span class="MAvaLevel flt1">等级：<a href="/rank/lv.php" title="Lv.2"
                target="_blank">Lv.{{ userInfo ? userInfo.level : 2 }}</a></span>
            <span class="MAvaPlace flt1" title="阿坝">现居：{{ userInfo ? userInfo.city : '阿坝' }}</span> <span class="MAvaSet"><i
                class="el-icon el-icon-s-tools"></i></span>
          </div>
          <div id="_j_profilearea" class="MAvaProfile mfw-acc-hide">
            <div v-if="userInfo && !userInfo.info">
              <a role="button" class="addBtn _j_showintrobox" v-show="!proEditorShow" @click="addBtnClick">填写个人简介</a>
              <div class="MAvaInput hide _j_inputarea" v-show="proEditorShow">
                <el-input type="textarea" :rows="4" placeholder="例：摄影师/旅居澳洲/潜水爱好者" v-model="userMsg"
                  resize="none"></el-input>
                <el-button type="info" @click="saveBtnClick">保存</el-button>
              </div>
            </div>
            <div v-else-if="userInfo">
              <a href="javascript:;" class="userinfo-info" v-show="!proEditorShow"
                @click="addBtnClick">{{ userInfo.info }}</a>
              <div class="MAvaInput hide _j_inputarea" v-show="proEditorShow">
                <el-input type="textarea" :rows="4" placeholder="例：摄影师/旅居澳洲/潜水爱好者" v-model="userMsg"
                  resize="none"></el-input>
                <el-button type="info" @click="saveBtnClick">保存</el-button>
              </div>
            </div>
          </div>
          <div class="MAvaMore clearfix mfw-acc-hide">
            <div class="MAvaNums">
              <strong><a href="/friend/follow?type=我的关注" target="_blank">{{ followNum }}</a></strong>
              <p>关注</p>
            </div>
            <div class="MAvaNums">
              <strong><a href="/friend/follow?type=我的粉丝" target="_blank">{{ fansNum }}</a></strong>
              <p>粉丝</p>
            </div>
            <div class="MAvaNums last">
              <strong><a href="/mall/" target="_blank">0</a></strong>
              <p>蜂蜜</p>
            </div>
          </div>
        </div>


        <div class="MHonor mfw-acc-hide">
          <div class="MHonTitle">我获得的特权</div>
          <div class="MHonDetail" id="_j_privicnt">
            <div class="MHonList">
              <ul class="clearfix" id="_j_privi_listcnt">
                <li>
                  <a href="/user/lv.php" target="_blank"><i class="_j_priviitem i2"
                      data-description="Lv1.特权：好友上限"></i></a>
                  <a href="/user/lv.php" target="_blank"><i class="_j_priviitem i1"
                      data-description="Lv1.特权：攻略下载"></i></a>
                </li>
              </ul>
            </div>
            <span class="MHonDescription" id="_j_privi_tip" style="display: none;"></span>
            <div class="MHonBtn"><span class="MPrev2 _j_prev disabled"></span><span class="MNext2 _j_next"></span></div>
          </div>
        </div>

        <div class="MUsers mfw-acc-hide">
          <div class="MUsersTitle">我的关注</div>
          <div class="MUsersDetail" id="_j_followcnt">
            <div class="MUsersAtom">
              <ul class="clearfix _j_followlist">
                <li v-for="(item, index) in followList" :key="index" @click="showFollowMessage">
                  <a href="javascript:;">
                    <img :src="item.headImgUrl" height="48" width="48">
                  </a>
                  <p><a href="javascript:;">{{ item.userName }}</a></p>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="MGuestbook mfw-acc-hide" id="_j_msgboard_wrap">
          <div class="MGuestTitle">留言板
            <div class="MCloseFunction _j_msgboard_closer">
              <el-switch v-model="msgSwitch" active-color="#13ce66" inactive-color="#ccc">
              </el-switch>
            </div>
          </div>
          <div class="MGuestInput">
            <el-input type="textarea" :rows="4" placeholder="说点什么..." v-model="MGuestMsg" resize="none"></el-input>
            <a role="button" class="MGuestBtn" title="留言" id="_j_msgboard_submit">留言</a>
          </div>
          <div class="MGuestList">
            <ul class="_j_msgboard_list">

            </ul>
          </div>
        </div>

      </div>
      <div class="content flt2">
        <div class="common_block main_links mfw-acc-hide">
          <ul class="clearfix">
            <li><a href="/note/form" target="_blank"><i class="write_note"></i><span>写游记</span></a></li>
            <li><a href="/wenda/" target="_blank"><i class="ask_expert"></i><span>问达人</span></a></li>
            <li><a href="/path/" target="_blank"><i class="add_footprint"></i><span>添加足迹</span></a></li>
            <li class="last"><a href="/together/" target="_blank"><i class="invite_friends"></i><span>发布结伴</span></a></li>
          </ul>
          <div class="open_corner open_corner_tips">
            <a role="button" id="_j_profile_setting"><span><i></i></span></a>
          </div>
        </div>

        <div class="common_block personal_info mfw-acc-hide" id="_j_taskwrap">
          <div class="personal_tips">
            <p><strong>{{ userInfo ? userInfo.nickname : '带TA游用户' }}</strong>，这里是你的【窝】！</p>
            <p>是记录你的旅行记忆，结交各路豪杰的地盘儿。现在开启带TA游旅程！</p>
          </div>
          <div class="personal_list clearfix">
            <ul>
              <li>
                <div class="personal_ico"><i class="ico_info"></i></div>
                <div class="personal_word">
                  <p>做一个有“脸面”的人<br>上传头像，完善资料！<br></p>
                </div>
                <div class="personal_btn">
                  <a role="button" class="_j_task_profile" title="完善个人资料" @click="showEditorPanel">完善个人资料</a>
                </div>
              </li>
              <li>
                <div class="personal_ico"><i class="ico_stroll"></i></div>
                <div class="personal_word">
                  <p>这儿潜伏着哪些旅行大神？<br>他们都怎么玩儿？</p>
                </div>
                <div class="personal_btn">
                  <a role="button" class="_j_task_focus_talent" title="逛逛达人">逛逛达人</a>
                </div>
              </li>
              <li>
                <div class="personal_ico"><i class="ico_daka"></i></div>
                <div class="personal_word">
                  <p>带TA游会员升级有礼包。<br>第一步，从打卡开始。</p>
                </div>
                <div class="personal_btn">
                  <a role="button" class="_j_task_daka" title="打卡赚取蜂蜜">打卡赚取蜂蜜</a>
                </div>
              </li>
            </ul>
          </div>
        </div>

        <div id="pagelet-block-75ffcba39279720b165c1dc659ec6698" class="pagelet-block" data-api=":home:pagelet:feedApi"
          data-params="{&quot;target_id&quot;:&quot;35811028&quot;}" data-async="1" data-controller="">

        </div>

        <div class="common_block my_notes">
          <div class="common_title clearfix">
            <h2>我的游记</h2>
          </div>
          <div class="notes_default_v2" v-if="travelsList.length == 0">
            <div class="notes_dcon">
            </div>
            <a href="/note/form" title="写游记" class="btn_write"><i></i>写游记</a>
          </div>

          <div class="travels-list-box" v-else>
            <PersonalTravelsItem v-for="(item, i) in travelsList" :key="item.id" :travelsItem="item"></PersonalTravelsItem>

            <div class="page-box">
              <el-pagination class="page" layout="prev, pager, next" background :page-size="10" :total="travelsTotal"
                v-model:current-page="curPage" @current-change="currentChange" />
            </div>
          </div>

          <div class="more_notes">
            <a class="btn_deleted mfw-acc-hide" href="/u/note/delete.html"><i></i>已删除游记</a>
          </div>

        </div>

        <div class="common_block my_notes mfw-acc-hide">
          <div class="common_title clearfix">
            <h2>我的回答</h2>
          </div>
          <div class="notes_default ask_default" v-if="answerList.length == 0">
            <i class="ico_notes"></i>
            <div class="notes_default_detail">
              <p>带TA游问答是一个所有人帮所有人的平台，<br>用你的旅行经验，去帮助其他蜂蜂。</p>
            </div>
          </div>

          <div v-else class="answer-list">
            <personal-answer text="条回答" componentName="我的回答" :length="answerTotal" :pageSize="answerSize"
              @currentChange="currentChangeAnswer">
              <div class="wd-item-box" v-for="(wditem, i) in answerList" :key="i">
                <a class="wd-item-title" :href="`/questions/details/${wditem.id}`">
                  <i class="address-icon"></i>
                  <span class="address">{{ wditem.authorName ? wditem.authorName : '中国' }}</span>
                  <span class="item-title">{{ wditem.title }}</span>
                </a>
                <div class="wd-item-content" v-html="wditem.answerContent">
                </div>
                <div class="wd-meta">
                  <div class="wd-meta-left">
                    <i class="meta-icon">顶</i>
                    <span class="meta-liketotal">{{ wditem.likeTotal ? wditem.likeTotal : 0 }}</span>
                  </div>
                  <div class="wd-meta-rigtht">
                    <span class="create-time">{{ wditem.createTime }}</span>
                  </div>
                </div>
              </div>
            </personal-answer>
          </div>
        </div>

        <div class="common_block my_notes mfw-acc-hide">
          <div class="common_title clearfix">
            <h2>我的点评</h2>
          </div>
          <div class="notes_default dp_default">
            <i class="ico_notes"></i>
            <div class="notes_default_detail">
              <p>点评，不仅是旅途记忆，<br>更是帮助他人的宝贵财富。</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="userinfo-editor" v-show="editorPanelShow">
      <div class="mask"></div>
      <div class="userinfo-editor-box">
        <div class="editor-content-box" v-if="userInfo">
          <div class="editor-avatar">
            <img :src="userInfo.headImgUrl" class="avatar-img" width="120" height="120">
            <div class="upload-avatar">
              <div class="avatar-name">
                {{ userInfo.nickname }}
                <strong>Lv.{{ userInfo.level }}</strong>
              </div>
              <el-upload ref="upload" class="upload-demo" action="/api/common/upload" :show-file-list="false" :limit="1"
                :on-success="headSuccess">
                <template #trigger>
                  <el-button type="primary" class="upload-btn">上传头像</el-button>
                  <span class="upload-des">支持jpg、png、jpeg、bmp，图片大小5M以内</span>
                </template>
              </el-upload>
            </div>
          </div>
          <div class="editor-list">
            <el-form :model="userInfo" label-width="120px">
              <el-form-item label="名号">
                <el-input v-model="userInfo.nickname" />
              </el-form-item>

              <el-form-item label="性别">
                <el-radio-group v-model="userInfo.sex">
                  <el-radio label="男" />
                  <el-radio label="女" />
                  <el-radio label="保密" />
                </el-radio-group>
              </el-form-item>
              <el-form-item label="签名档">
                <el-input v-model="userInfo.selfsign" type="textarea" placeholder="年轻的旅行是一辈子的财富..." resize="none" />
              </el-form-item>
            </el-form>
          </div>

          <div class="submit-btn">
            <el-button type="primary" @click="onSubmit">提交</el-button>
          </div>
        </div>
        <a href="javascript:;" class="editor-close">
          <i @click="closeEditorPanel"></i>
        </a>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { getMeRegios } from '@/composables/api/note'
//xxxxx
import { getMeAnswer } from '@/composables/api/questions'
import { getFollow, getFans } from '@/composables/api/friend';
// import { flatHooks } from 'hookable';
import { questionNum } from '~~/composables/globaldata';
import { setCurrentPageList } from '~~/composables/globalmethods';
import { modifyUser } from '@/composables/api/setting'
import { ElMessage } from 'element-plus';


definePageMeta({
  layout: 'personal'
})

const qNum = questionNum();
//const currentPageList=ref([]);
//我的回答数据
const answerList = ref([]);
const answerPage = ref(1);
const answerTotal = ref(0);
const answerSize = ref(0);

//xxxxxx


const msgSwitch = ref(false)

//console.log(msgSwitch.value);

const userMsg = ref('')
const MGuestMsg = ref('')
const GzData = reactive(['足迹君', 'Swing_窝', '超级小包子', '好名字', 'MRd', '带TA游玩法君'])
const userInfo = ref();

const proEditorShow = ref(false);

//游记
const travelsList = ref([]);
//const curTravels=ref([]);
const curPage = ref(1);
const travelsTotal = ref(0);




//显示用户信息面板
const editorPanelShow = ref(false);

//关注与粉丝
const followList = ref([]);
const followNum = ref(0);//关注数量
const fansNum = ref(0);//粉丝数量

const getFollowData = () => {
  getFollow().then((res) => {
    followList.value = res.data.records;
    followNum.value = res.data.total;
  })
  getFans().then((res) => {
    fansNum.value = res.data.total;
  })
}
//获取用户信息
const getUserInfo = () => {
  if (localStorage.getItem('userInfo')) {
    userInfo.value = JSON.parse(localStorage.getItem('userInfo'));
    userMsg.value = userInfo.value.info;
    if (userInfo.value.gender == 2) {
      userInfo.value.sex = '女';
    } else if (userInfo.value.gender == 1) {
      userInfo.value.sex = '男';
    } else {
      userInfo.value.sex = '保密';
    }
  }

}

const getTravels = (page) => {
  getMeRegios({ currentPage: page, pageSize: 10 }).then((res) => {
   //console.log(res);
    travelsList.value = res.data.list;
    travelsTotal.value = res.data.total;
  }).catch((msg) => {
    //console.log(msg);
    if (msg.code == 500) {
      navigateTo('/login');
    }
  })
}
//设置当前页数据
const currentChange = (page) => {
  getTravels(page);
}

const addBtnClick = () => {
  proEditorShow.value = true;
}

const saveBtnClick = () => {
  proEditorShow.value = false;

  userInfo.value.info = userMsg.value;

  modifyUser({ info: userMsg.value }).then((res) => {
    localStorage.setItem('userInfo', JSON.stringify(res.data));
  })
}


const getAnswer = (page) => {
  getMeAnswer({ current: page, size: 10 }).then((res) => {
    answerList.value = res.data.records;
    qNum.value = res.data.total;
    answerTotal.value = res.data.total;
    answerSize.value = res.data.size;

    console.log(answerList.value);
  });
}

const currentChangeAnswer = (page) => {
  //currentPageList.value=setCurrentPageList(page,answerData.destinationDoubts);
  getAnswer(page);
}
//显示编辑面板
const showEditorPanel = () => {
  editorPanelShow.value = true;
}
//关闭编辑面板
const closeEditorPanel = () => {
  editorPanelShow.value = false;
}
//修改用户信息
const onSubmit = () => {

  switch (userInfo.value.sex) {
    case '男':
      userInfo.value.gender = 1;
      break;
    case '女':
      userInfo.value.gender = 2;
      break;
    case '保密':
      userInfo.value.gender = 0;
      break;
  }
  modifyUser(userInfo.value).then((res) => {
    //console.log(res);
    if (res.code == 200) {
      localStorage.setItem('userInfo', JSON.stringify(res.data));
      ElMessage.success('修改用户成功！');
      editorPanelShow.value = false;
    }
  })

}
//图片上传成功回调
const headSuccess = (e, file, filelist) => {
  if (e.code == 200) {
    userInfo.value.headImgUrl = e.data;
    // console.log(userInfo.value.headImgUrl);


    // modifyUser({headImgUrl:e.data}).then((res)=>{
    //   //console.log(res);
    //   if(res.code==200){
    //     //localStorage.setItem('userInfo',JSON.stringify(res.data));

    //   }
    // })
  }
}

const showFollowMessage = () => {
  ElMessage.warning('敬请期待！');
}


onMounted(() => {
  getUserInfo();

  nextTick(() => {
    getTravels(curPage.value);
    getAnswer(answerPage.value);
    getFollowData();
  })
})

</script>

<style scoped lang="scss">
.personalCenter-body {
  background: #efefef;
}

.center {
  width: 980px;
  margin: 0 auto;
  position: relative;
}

.clearfix:after {
  content: '';
  clear: both;
  height: 0;
  overflow: hidden;
  display: block;
}

.attention ._j_followed {
  display: none
}

._j_focused ._j_followed {
  display: inline-block
}

._j_focused ._j_follow {
  display: none
}

.MProfile pre {
  white-space: pre-wrap;
  word-break: break-word;
  word-wrap: break-word;
}

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

  .MAvaInfo {
    padding: 0 15px;
    margin-top: 16px;
    line-height: 16px;

    span {
      padding: 0 10px 0 7px;
      display: inline-block;
      position: relative;
    }

    .MAvaSet {
      padding: 0 0 0 5px;
      position: relative;
      top: -1px;
      display: inline-block;

      a {
        width: 17px;
        height: 17px;
        background-image: url(/images/home_new2015/ico_sprite_v8.png);
        background-position: -108px -146px;
        display: inline-block;
        vertical-align: middle;
      }
    }
  }

  .MAvaProfile {
    margin-top: 20px;
    padding: 0 20px;

    .addBtn {
      line-height: 30px;
      border-radius: 3px;
      color: #666;
      background-color: #efefef;
      display: block;
      text-align: center;
      transition: background-color .3s ease-out 0s;
      -webkit-transition: background-color .3s ease-out 0s;

      &:hover {
        background-color: #ff8a00;
        color: #fff;
      }
    }

    .userinfo-info {
      display: block;
      text-align: left;
      color: #666;
    }

    .el-button {
      width: 100%;
      margin-top: 10px;
      outline: none;
      border: 0;

      &:hover {
        background-color: #ff8a00;
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

  .MHonor {
    padding: 18px 0 25px;
    background-color: #f6f6f6;
  }

  .MUsers {
    padding: 45px 30px 0;
    text-align: center;
    font-size: 14px;

    .MUsersTitle {
      font-size: 16px;
      color: #444;
    }

    .MUsersDetail {
      margin-top: 18px;
      overflow: hidden;

      p a {
        line-height: 16px;
        height: 16px;
        display: block;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        margin-top: 10px;
        color: #ff7200;
        font-size: 12px;
      }
    }

    .MUsersAtom {
      width: 1000px;
      overflow: hidden;
      *zoom: 1;
    }

    ul {
      width: 240px;
      float: left;
    }

    li {
      width: 52px;
      float: left;
      margin-right: 4px;
      margin-bottom: 20px;
    }

    img {
      border-radius: 48px;
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

.flt1 {
  float: left;
}

.flt2 {
  float: right;
}

.content {
  width: 682px;
  margin-top: 18px;

  .main_links {
    padding: 20px 0 17px;
    position: relative;

    .open_corner {
      width: 40px;
      height: 40px;
      position: absolute;
      right: 0;
      top: 0;
    }

    li {
      float: left;
      width: 25%;
      position: relative;
      text-align: center;

      i {
        width: 45px;
        height: 46px;
        background-image: url(assets/images/personal/home_sprite_v15.png);
        display: inline-block;
        position: relative;
      }

      .write_note {
        background-position: -210px -425px;
      }

      .ask_expert {
        width: 53px;
        background-position: -260px -427px;
      }

      .add_footprint {
        width: 56px;
        height: 49px;
        background-position: -317px -422px;
      }

      .invite_friends {
        height: 47px;
        background-position: -379px -424px;
      }

      span {
        color: #999;
        font-size: 16px;
        margin-top: 6px;
        display: block;
      }
    }
  }

  .common_block {
    margin-bottom: 18px;
    background-color: #fff;
    border: #e2e2e2 1px solid;
    box-shadow: 0 0 2px rgb(0 0 0 / 5%);

    h2 {
      font-size: 20px;
      color: #444;
      font-weight: normal;
      position: relative;
      top: 4px;
      display: inline;
    }
  }

  .personal_info {
    border: 0;
    background-color: #f5dc52;
    box-shadow: 2px 3px 0 #dfca58;
    padding: 28px 30px 30px;
    margin-bottom: 30px;

    .personal_tips {
      font-size: 14px;
      color: #333;
      line-height: 30px;

      strong {
        font-size: 18px;
        color: #ff7200;
        font-weight: normal;
      }
    }

    .personal_list {
      margin-top: 22px;
      overflow: hidden;
      *zoom: 1;

      ul {
        width: 630px;

        li {
          width: 168px;
          margin-right: 10px;
          padding: 0 16px 30px;
          background-color: #fff;
          float: left;
          text-align: center;

          .personal_ico {
            height: 105px;
            line-height: 105px;
            text-align: center;

            i {
              width: 59px;
              height: 71px;
              line-height: 0;
              display: inline-block;
              background-image: url(assets/images/personal/default_sprite_v6.png);
              background-position: -1px -256px;
              vertical-align: middle;
            }
          }

          .personal_word {
            margin-top: 2px;
            font-size: 14px;
            line-height: 24px;
            height: 72px;
          }

          .personal_btn {
            margin-top: 15px;

            a {
              width: 124px;
              background-color: #f1744f;
              font-size: 14px;
              display: inline-block;
              color: #fff;
              line-height: 36px;
              border-radius: 36px;
            }
          }
        }
      }
    }
  }

  .my_notes {
    padding-bottom: 30px;

    .common_title {
      padding: 25px 30px;
      line-height: 30px;
      position: relative;
    }

    .notes_default_v2 {
      padding-bottom: 40px;
      position: relative;

      .btn_write {
        display: block;
        width: 140px;
        height: 40px;
        border-radius: 4px;
        background-color: #ff9e00;
        position: absolute;
        right: 30px;
        top: -61px;
        font-size: 16px;
        color: #fff;
        text-align: center;
        line-height: 40px;

        i {
          display: inline-block;
          width: 18px;
          height: 18px;
          background: url(assets/images/personal/home_sprite_v15.png) -228px -325px no-repeat;
          margin-right: 5px;
          vertical-align: middle;
        }
      }

      .notes_dcon {
        width: 100%;
        height: 320px;
        background: url(http://css.mafengwo.net/images/home_new2015/noyj_v2.jpg) no-repeat;
      }
    }

    .more_notes {
      text-align: center;
      margin-top: 10px;
      position: relative;
      height: 38px;

      a {
        font-size: 18px;
        color: #999;
      }

      .btn_deleted {
        position: absolute;
        left: 34px;
        top: 15px;
        font-size: 14px;
        line-height: 19px;

        i {
          float: left;
          margin: 2px 5px 0 0;
          width: 17px;
          height: 17px;
          background-image: url(http://css.mafengwo.net/images/home_new2015/ico_sprite_v8.png);
          background-position: -50px -215px;
        }
      }
    }
  }

  .notes_default {
    padding: 5px 0 50px 130px;
    position: relative;

    i {
      width: 208px;
      height: 157px;
      background-image: url(assets/images/personal/default_sprite_v6.png);
      background-position: -5px -68px;
      display: block;
    }

    .notes_default_detail {
      position: absolute;
      top: 75px;
      font-size: 16px;
      color: #999;
      line-height: 25px;
      left: 140px;
      width: 220px;
    }
  }

  .ask_default {
    padding-left: 365px;

    i {
      width: 176px;
      height: 183px;
      background-position: -227px -65px;
    }
  }

  .dp_default {
    padding-left: 145px;
    padding-top: 0;

    i {
      width: 199px;
      height: 177px;
      background-position: -409px -66px;
    }

    .notes_default_detail {
      left: 325px;
      top: 90px;
    }
  }
}

.answer-list {
  padding: 0 25px;
}

.wd-item-box {
  padding: 20px 30px 20px 0;

  .wd-item-title {
    display: flex;
    align-items: center;

    .address-icon {
      width: 14px;
      height: 16px;
      background-image: url(../../assets/images/personal/ask_v2_sprite3.png);
      background-repeat: no-repeat;
      background-position: -100px -40px;
    }

    .address {
      font-size: 20px;
      color: #192885;
      margin: 0 10px 0 5px;
    }

    .item-title {
      font-size: 20px;
      color: #333;

      &:hover {
        color: #192885;
      }
    }

  }

  .wd-item-content {
    padding: 20px 0;
    font-size: 14px;
    color: #555;
  }

  .wd-meta {
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #999;

    .wd-meta-left {
      display: flex;
      align-items: center;

      .meta-icon {
        width: 37px;
        height: 33px;
        background-image: url(../../assets/images/personal/ico_sprite_v8.png);
        background-position: 0 -90px;
        text-align: center;
        line-height: 33px;
        color: #fff;
        font-style: normal;
        margin-right: 5px;
      }
    }

    // .wd-meta-right{
    //   .comment-des{
    //     margin-right: 5px;
    //   }
    // }
  }
}

.userinfo-editor {
  position: fixed;
  width: 100%;
  height: 100vh;
  left: 0;
  top: 0;
  z-index: 999;

  .mask {
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
  }

  .userinfo-editor-box {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 580px;
    height: 480px;
    background-color: #fff;
    border-radius: 5px;

    .editor-content-box {
      padding: 40px 90px 30px;

      .upload-btn {
        height: 23px;
        outline: none;
        border: 0;
        margin-right: 5px;

        &:hover {
          background-color: #ff8a00;
        }
      }

      .upload-des {
        color: #555;
      }

      .submit-btn {
        width: 115px;
        height: 38px;
        margin: 0 auto;

        .el-button {
          border: 0;
          outline: none;
          width: 100%;
          height: 100%;

          &:hover {
            background-color: #ff8a00;
          }
        }
      }
    }

    .editor-avatar {
      display: flex;
      align-items: center;

      .avatar-img {
        border-radius: 50%;
        margin-right: 30px;
      }

      .avatar-name {
        font-size: 18px;
        color: #ff7200;
        font-weight: 600;
        margin-bottom: 13px;

        strong {
          color: #ea3c1a;
          // font-size: 20px;
          font-weight: 600;
        }
      }
    }



    .editor-close {
      position: absolute;
      top: 10px;
      right: 0;
      width: 36px;
      height: 26px;
      background: url(/assets/images/popctn_bg2.png) no-repeat 0 -280px;

      i {
        display: block;
        margin: 2px;
        width: 22px;
        height: 22px;
        background: url(/assets/images/popctn_bg2.png) no-repeat -40px -280px;
        transition: transform 0.5s;
        transform: rotate(0);

        &:hover {
          transform: rotate(180deg);
        }
      }
    }
  }
}</style>