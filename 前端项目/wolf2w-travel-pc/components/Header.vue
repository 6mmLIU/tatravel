<template>
  <div class="header-container">
    <div class="header-wrap">
      <div class="header-logo">
        <a class="logo" title="带TA游自由行" href="/" />
      </div>
      <div class="header-nav">
        <a :href="item.url" class="nav-item " :class="navIde === index ? 'nav-item-active' : ''"
          v-for="(item, index) in navList" :key="'nav' + index">{{ item.name }}</a>
      </div>
      <div class="header-login" v-show="!userStatus">
        <a href="/login" class="nav-item">登录</a>
        <span class="split">|</span>
        <a href="/register" class="nav-item">注册</a>
      </div>
      <div v-show="userStatus" class="header-user">
        <div class="info-down">
          <ClientOnly>
            <el-dropdown>
              <span class="el-dropdown-link">
                <div class="dropdown-link-content">
                  <el-icon :size="20" class="el-icon--left">
                    <Bell />
                  </el-icon>消息
                  <el-icon class="el-icon--right">
                    <CaretBottom />
                  </el-icon>
                </div>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>好友动态</el-dropdown-item>
                  <el-dropdown-item>私信</el-dropdown-item>
                  <el-dropdown-item>小组消息</el-dropdown-item>
                  <el-dropdown-item>系统通知</el-dropdown-item>
                  <el-dropdown-item>问答消息</el-dropdown-item>
                  <el-dropdown-item>回复消息</el-dropdown-item>
                  <el-dropdown-item>喜欢与收藏</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </ClientOnly>
        </div>
        <div class="user-down">
          <ClientOnly>
            <el-dropdown>
              <span class="el-dropdown-link">
                <div class="dropdown-link-content">
                  <a href="/personal/info" target="_blank"><el-avatar :src="headImg" /></a>
                  <el-icon class="el-icon--right">
                    <CaretBottom />
                  </el-icon>
                </div>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item :icon="House"><a class="me-link" href="/personal/info" target="_blank">我的窝</a>
                  </el-dropdown-item>
                  <el-dropdown-item :icon="Calendar"><a class="me-link" href="/personal/travels"
                      target="_blank">我的游记</a></el-dropdown-item>
                  <el-dropdown-item :icon="Edit"><a class="me-link" href="/note/form"
                      target="_blank">写游记</a></el-dropdown-item>
                  <el-dropdown-item :icon="ChatDotSquare"><a class="me-link" href="/personal/answer"
                      target="_blank">我的问答</a></el-dropdown-item>
                  <el-dropdown-item :icon="Tools"><a class="me-link" href="/setting"
                      target="_blank">设置</a></el-dropdown-item>
                  <el-dropdown-item :icon="SwitchButton" @click="signOutBtnClick">退出</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </ClientOnly>
        </div>
      </div>
    </div>
    <div class="shadow"></div>
  </div>
</template>
<script setup lang="ts">
import { House, Edit, Calendar, Guide, ChatDotSquare, User, Collection, MapLocation, Tickets, CreditCard, Memo, Tools, SwitchButton } from '@element-plus/icons-vue'
import { navigateTo, useRoute } from "#app";
import { getUserInfo } from '~~/composables/api/login'
const userStatus = ref(false)
const navIde = ref(-1)
const navList = reactive([{
  name: '首页', url: '/'
}, {
  name: '目的地', url: '/destination'
}, {
  name: '旅游攻略', url: '/strategy'
}, {
  name: '旅游日记', url: '/note'
}, {
  name: '问答', url: '/questions'
}, {
  name: '机票', url: '/ticket'
}, {
  name: '订酒店', url: '/hotel'
}, {
  name: '商城', url: '/mall'
}]);

const headImg = ref('/_nuxt/assets/logo.png');
onMounted(() => {
  const token = localStorage.getItem('token');
  userStatus.value = token ? true : false;

  //const userInfo=localStorage.getItem('userInfo');

  setTimeout(() => {
    if (token) {
      getUserInfo().then((res) => {
        const userInfo = res.data;
        headImg.value = userInfo ? userInfo.headImgUrl : '';
        localStorage.setItem('userInfo', JSON.stringify(userInfo));
      })
    }
  }, 20);


  navList.forEach((ele, ide) => {
    if (useRoute().path.startsWith(ele.url)) {
      navIde.value = ide;
    }
  });
})

const signOutBtnClick = () => {
  localStorage.removeItem('token');
  localStorage.removeItem('userInfo');
  navigateTo('/login');
}
</script>
<style lang="scss" scoped>
.header-container {
  position: relative;
  height: 68px;
  background-color: #fff;
  position: relative;
  z-index: 90;

  .header-wrap {
    display: flex;
    align-items: center;
    position: relative;
    width: 1200px;
    height: 68px;
    margin: 0 auto;
    overflow: hidden;
    z-index: 2;

    .header-logo {
      flex: 0 0 auto;
      // padding: 16px 0 13px;
      width: 136px;
      // height: 39px;
      height: 100%;

      .logo {
        display: block;
        // height: 39px;
        height:100%;
        background: url(../assets/images/logo.png) no-repeat center;
        background-size: 100%;
      }
    }

    .header-nav {
      flex: 1;
      display: flex;
      padding: 0px 25px;

      .nav-item {
        flex: 0 0 auto;
        padding: 0 16px;
        line-height: 68px;
        box-sizing: border-box;
        font-size: 16px;
        color: #333;

        &:hover {
          height: 68px;
          // color: #192885;
          // border-bottom: 3px solid #192885;
          color: #192885;
          border-bottom: 3px solid #192885;
        }

        &.nav-item-active {
          // background-color: #192885;
          background-color: #192885;
          color: #fff !important;
          text-decoration: none;
        }
      }
    }

    .header-user {
      flex: 0 0 auto;
      display: flex;
      align-items: center;

      .info-down {
        margin-right: 20px;
      }

      .dropdown-link-content {
        display: flex;
        align-items: center;
      }
    }

    .header-login {
      flex: 0 0 auto;

      a {
        font-size: 14px;
      }

      .split {
        display: inline-block;
        margin: 0 10px;
        width: 1px;
        height: 14px;
        background-color: #c9c9c9;
        overflow: hidden;
        vertical-align: -2px;
        *vertical-align: middle;
      }
    }
  }

  .shadow {
    position: absolute;
    left: 0;
    bottom: -2px;
    right: 0;
    width: 100%;
    height: 2px;
    border-top: 1px solid #d6d6d6;
    background-color: rgba(0, 0, 0, 0.06);
    filter: progid:DXImageTransform.Microsoft.gradient(enabled='true', startColorstr='#11000000', endColorstr='#11000000');
    overflow: hidden;
  }
}

.me-link {
  color: #555;
}

.me-link:hover {
  color: #192885;
}
</style>
