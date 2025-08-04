<template>
  <div class="common-container clearfix">
    <div class="crumb">
      <div class="item"><a href="/destination">目的地</a><em>&gt;</em></div>
      <div v-for="item in toastsList" :key="item.id" class="item">
        <a :href="'/destination/details/' + item.id">{{ item.name }}</a
        ><em>&gt;</em>
      </div>
      <div v-if="toastsList.length" class="item cur">
        <strong>{{ toastsList[toastsList.length - 1].name }}概况</strong>
      </div>
    </div>
    <div class="wiki-aside">
      <ul class="wiki-nav">
        <li v-for="item in catalogsList" :key="item.id" :class="{ on: currentCatalogs.id === item.id }" @click="changeTab(item)">
          <a class="catalog">{{ item.name }}</a>
        </li>
      </ul>
    </div>
    <div v-if="currentCatalogs" class="wiki-cont">
      <div class="wiki-title clearfix">
        <h1 class="h1">{{ currentCatalogs.name }}</h1>
      </div>
      <div>
        <a v-for="item2 in currentCatalogs.strategies" :key="item2.id" :href="'/strategy/article/' + item2.id" target="_blank">{{ item2.title }} &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</a>
      </div>
      <br />
      <!-- <div><h2>北京逛故宫全技能Get！</h2></div> -->
      <div class="wiki-cont" v-html="currentCatalogsContent"></div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { catalogs, catalogsContent, toasts } from '@/composables/api/destination'
const route = useRoute()
const destId = route.params.id.toString()
const catalogsList = ref([])
const toastsList = ref([])
const currentCatalogs = ref(null)
const currentCatalogsContent = ref(null)

onMounted(() => {
  nextTick(() => {
    getToasts()
    getCatalogs()
  })
})

function changeTab(catalogs) {
  currentCatalogs.value = catalogs
  getCatalogsContent()
}
function getToasts() {
  toasts({ destId: destId })
    .then(res => {
      toastsList.value = res.data
    })
    .catch(err => {
      console.log(err)
    })
}
function getCatalogs() {
  catalogs({ destId: destId })
    .then(res => {
      catalogsList.value = res.data
      currentCatalogs.value = catalogsList.value.length ? catalogsList.value[0] : null
      getCatalogsContent()
    })
    .catch(err => {
      console.log(err)
    })
}

function getCatalogsContent() {
  catalogsContent({ id: currentCatalogs.value.id })
    .then(res => {
      currentCatalogsContent.value = res.data.content/* .replace(/src="\/images/g, 'src="http://192.168.113.236:84/images') */
    })
    .catch(err => {
      console.log(err)
    })
}
</script>
<style lang="scss" scoped>
.common-container {
  width: 1000px;
  margin: 0 auto;
  .crumb {
    width: 1000px;
    font: 12px Arial, 'Microsoft Yahei', '\5FAE\8F6F\96C5\9ED1', Tahoma, Helvetica, STHeiti, 'Hiragino Sans GB';
    height: 20px;
    padding: 15px 0;
    color: #666;
    line-height: 20px;
    margin: 0 auto;
    .item {
      float: left;
      &.cur {
        color: #ff7000;
      }
      a {
        text-decoration: none;
        cursor: pointer;
        color: #666;
        font-size: 12px;
      }
      em {
        margin: 0 6px;
        color: #999;
        font-family: 'simsun';
        font-style: normal;
      }
    }
  }
  .wiki-aside {
    float: left;
    width: 250px;
    .wiki-nav {
      line-height: 20px;
      font-size: 18px;
      color: #333;
      li {
        padding: 20px 10px;
        border-bottom: 1px solid #f1f1f1;
        a {
          display: block;
          height: 20px;
          width: 210px;
          padding-left: 20px;
          color: #333;
          white-space: nowrap;
          overflow: hidden;
          text-overflow: ellipsis;
        }
        &.on a {
          color: #192885;
          &:before {
            content: '';
            float: left;
            margin-left: -21px;
            width: 3px;
            height: 20px;
            background-color: #192885;
          }
        }
      }
    }
  }
  .wiki-cont {
    float: right;
    width: 690px;
    padding-top: 10px;
    .wiki-title {
      margin-bottom: 30px;
      height: 50px;
      line-height: 50px;
      position: relative;
      &:before {
        content: '';
        position: absolute;
        left: 0;
        bottom: -2px;
        width: 24px;
        height: 3px;
        background-color: #666;
      }
      .h1 {
        float: left;
        font-size: 24px;
        font-weight: normal;
        color: #333;
      }
    }
    a {
      text-decoration: none;
      color: #192885;
      cursor: pointer;
    }
  }
}
</style>
