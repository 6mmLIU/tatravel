<template>
  <div class="destination-container">
    <div class="banner-container">
      <a class="bg-img">
        <img src="https://p1-q.mafengwo.net/s15/M00/0F/5F/CoUBGV28HDuALpzxABR490kDN0M39.jpeg" />
      </a>
      <div class="place-search-panel">
        <h2>Don't fear the unknown</h2>
        <div class="search-panel">
          <input v-model="searchVal" class="search-input" placeholder="我想去..." />
          <div class="search-btn">
            <el-icon :size="25" color="white">
              <Search />
            </el-icon>
          </div>
        </div>
        <div class="place-search-hot">
          <a href="javascript:;">首尔</a>
          <a href="javascript:;">澳门</a>
          <a href="javascript:;">巴厘岛</a>
          <a href="javascript:;">长沙</a>
          <a href="javascript:;">清迈</a>
        </div>
      </div>
      <div class="show-info">
        <a class="show-name">
          <h2>成都 | 独具风情的蜀都蓉城，咫尺天堂的人间烟火</h2>
        </a>
        <p class="location">关于泰国普吉岛，这个多面风情的岛屿，常年位于境外旅游热搜榜前列，第一次去的人，容易被它的热带海岛风情和高性价比吸引到想再二刷；第N次去的人，更是因为每次都能发现普吉的新玩法，让人想再多宠幸一遍。</p>
        <a class="show-links">阅读全文</a>
      </div>
    </div>
    <div class="wrap-container">
      <div class="hot-container">
        <div class="hot-list">
          <h2 class="page-title">热门目的地</h2>
          <div class="nav-list">
            <div class="nav-item" :class="{ 'nav-item-active': hotNavId === -1 }" @mouseover="hoverHot(-1)">
              <div class="nav-item-name">国内</div>
              <span class="divide">|</span>
            </div>
            <div v-for="(item, index) in hotNav" :key="item.value" class="nav-item" :class="{ 'nav-item-active': hotNavId === item.id }" @mouseover="hoverHot(item.id)">
              <div class="nav-item-name">{{ item.name }}</div>
              <span v-if="index !== hotNav.length - 1" class="divide">|</span>
            </div>
          </div>
          <div class="hot-city">
            <div v-for="item in hotItem" :key="item.id" class="hot-city-item">
              <div class="province">
                <a :href="`/destination/details/${item.id}`" target="_blank" class="province-title">{{ item.name }}</a>
              </div>
              <div class="city-list">
                <a v-for="valueItem in item.children" :key="valueItem.id" :href="`/destination/details/${valueItem.id}`" class="city" target="_blank">
                  {{ valueItem.name }}
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <GlobalData />
    </div>
  </div>
</template>
<script setup lang="ts">
import GlobalData from '../../components/GlobalData.vue'
import { getRegions, searchRegions } from '../../composables/api/destination'
const searchVal = ref('') // 搜索值
const hotNav = ref([]) // 热门目的地nav
const hotItem = ref([])
const hotNavId = ref(1) // 当前的nav
function hoverHot(id: number) {
  if (id !== hotNavId.value) {
    hotNavId.value = id
    getHotItem(id)
  }
}
//获取热门导航一级菜单
const getHotNav = async () => {
  let res = await getRegions({ ishot: hotNavId.value })
  hotNav.value = res.data
  hotNavId.value = -1
}
//获取热门导航二级菜单
const getHotItem = async id => {
  let regionId = id
  let res = await searchRegions({ regionId })
  hotItem.value = res.data
}
onMounted(() => {
  nextTick(() => {
    getHotNav()
    getHotItem(-1)
  })
})
</script>
<style lang="scss" scoped>
.destination-container {
  position: relative;

  .banner-container {
    position: relative;
    height: 500px;

    .bg-img {
      position: absolute;
      top: 0px;
      left: 0px;
      z-index: 10;
      width: 100%;
      height: 100%;
      overflow: hidden;

      img {
        margin: -200px 0 0;
        width: 100%;
        min-height: 500px;
        height: auto;
      }
    }

    .place-search-panel {
      position: absolute;
      z-index: 20;
      left: 50%;
      top: 50%;
      margin: -71px 0 0 -500px;
      width: 400px;
      padding: 15px;
      background-color: rgba(0, 0, 0, 0.4);
      border-radius: 4px;

      h2 {
        font-size: 20px;
        color: #fff;
        margin-bottom: 15px;
        font-weight: normal;
        line-height: 1;
        font-family: 'Microsoft Yahei';
      }

      .search-panel {
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 46px;

        .search-input {
          width: 308px;
          height: 46px;
          margin: 0 6px 0 0;
          padding: 0 20px;
          background-color: #fff;
          border: 0 none;
          line-height: 46px;
          font-size: 18px;
          color: #111;
          border-radius: 4px;
        }

        .search-btn {
          width: 45px;
          height: 46px;
          line-height: 60px;
          cursor: pointer;
          background-color: #192885;
          border-radius: 4px;
          text-align: center;
        }
      }

      .place-search-hot {
        font-size: 14px;
        margin-top: 15px;
        line-height: 16px;

        a {
          margin-right: 10px;
          color: #fff;

          &:hover {
            outline: 0;
            text-decoration: underline;
          }
        }
      }
    }

    .show-info {
      position: absolute;
      right: 5%;
      top: 50%;
      z-index: 20;
      width: 535px;
      margin-top: -120px;
      padding-right: 30px;
      text-shadow: 0 2px 3px rgb(0 0 0 / 50%);
      color: #fff;
      font-size: 16px;
      line-height: 1.8;
      white-space: normal;
      text-align: left;
      border-right: 7px solid #fff;

      .show-name {
        position: static;
        top: 45px;
        right: 175px;
        margin: 10px 0;
        font-size: 40px;
        color: #fff;
        line-height: 1.3;
        text-align: left;
        cursor: pointer;

        &:hover {
          color: #192885;
        }

        h2 {
          font-size: 30px;
          font-weight: normal;
          line-height: inherit;
        }
      }

      .location {
        position: static;
        top: 130px;
        right: 140px;
        font-size: 18px;
      }

      .show-links {
        position: static;
        top: 160px;
        display: inline-block;
        margin-top: 10px;
        cursor: pointer;
        color: #fff;
        text-decoration: underline;
        font-size: 18px;

        &:hover {
          color: #192885;
        }
      }
    }
  }

  .wrap-container {
    width: 1000px;
    margin: 0 auto;
    padding-top: 40px;

    .hot-container {
      position: relative;

      .hot-list {
        width: 1000px;
        margin: 20px auto;

        .page-title {
          margin-bottom: 25px;
          text-align: center;
          font-size: 26px;
          font-weight: normal;
          color: #333;
          line-height: 26px;
        }

        .nav-list {
          margin: 0px 0 30px;
          text-align: center;
          font-size: 18px;
          color: #eee;
          line-height: 22px;

          .nav-item {
            display: inline-block;
            vertical-align: top;
            cursor: pointer;

            &.nav-item-active {
              padding-bottom: 12px;
              border-bottom: 3px solid #192885;

              .nav-item-name {
                color: #192885;
              }
            }

            .nav-item-name {
              color: #333;
              display: inline-block;
              margin: 0 25px;
              vertical-align: top;
            }

            .divide {
              display: inline-block;
              margin-top: 3px;
              width: 1px;
              height: 15px;
              background-color: #eee;
              overflow: hidden;
              line-height: 100px;
              vertical-align: top;
            }
          }
        }

        .hot-city {
          display: flex;
          flex-wrap: wrap;
          justify-content: space-between;
          margin-top: 20px;

          .hot-city-item {
            display: inline-flex;
            width: 450px;
            padding: 20px 0px;
            border-bottom: 1px dashed #eee;
          }

          .province {
            .province-title {
              display: inline-block;
              text-align: left;
              width: 100px;
              font-size: 18px;
              color: #333;
              text-decoration: underline;

              &:hover {
                color: #192885;
              }
            }
          }

          .city-list {
            line-height: 24px;

            .city {
              margin-right: 10px;
              font-size: 14px;
              color: #666;

              &:hover {
                color: #192885;
              }
            }
          }
        }
      }
    }
  }
}
</style>
