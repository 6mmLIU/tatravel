<template>
  <div class="common-container">
    <h2 class="r-title">自由行攻略</h2>
    <div class="local-pro">
      <ul class="clearfix">
        <li v-for="item in viewList" :key="item.id">
          <a class="img" :href="'/strategy/article/' + item.id" target="_blank">
            <img :src="item.coverUrl" width="320" height="170" />
            <!-- <span class="mark">7人体验过</span> -->
          </a>
          <a class="title" :href="'/strategy/article/' + item.id" target="_blank">{{ item.title }}</a>
          <p>{{ item.summary }}</p>
          <div class="more">
            <a class="a-link" :href="'/strategy/article/' + item.id" target="_blank"><i class="icon-link"></i>查看详情</a>
          </div>
        </li>
      </ul>
    </div>
    <div class="r-more"><a href="/strategy" target="_blank">查看全部</a></div>
  </div>
</template>
<script setup lang="ts">
import { defineProps } from 'vue'
import { viewnnumTop3 } from '@/composables/api/destination'
const props = defineProps({
  destid: {
    type: String,
    default: ''
  }
})

const viewList = ref([])

onMounted(() => {
  nextTick(() => {
    getViewnnumTop3()
  })
})

function getViewnnumTop3() {
  viewnnumTop3({ destId: props.destid })
    .then(res => {
      viewList.value = res.data
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
  .r-title {
    margin-bottom: 30px;
    text-align: left;
    font-size: 26px;
    color: #333;
    font-weight: normal;
    line-height: 30px;
  }
  ul {
    margin-right: -40px;
    li {
      float: left;
      width: 310px;
      display: inline;
      margin-right: 35px;
      .img {
        display: block;
        margin-bottom: 10px;
        height: 170px;
        overflow: hidden;
        position: relative;
        .mark {
          position: absolute;
          left: 0;
          top: 10px;
          height: 30px;
          padding: 0 10px;
          background-color: #ff6262;
          line-height: 30px;
          color: #fff;
          &:after {
            content: '';
            position: absolute;
            top: 0;
            right: -10px;
            border-top: 15px solid #ff6262;
            border-right: 10px dashed transparent;
            border-bottom: 15px solid #ff6262;
          }
        }
      }
      .title {
        margin-bottom: 5px;
        display: block;
        width: 320px;
        height: 28px;
        line-height: 28px;
        font-size: 18px;
        color: #000;
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
        &:hover {
          color: #192885;
        }
      }
      p {
        padding-left: 12px;
        font-size: 14px;
        color: #666;
        line-height: 20px;
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
        &:before {
          content: '';
          float: left;
          margin: 5px 0 0 -12px;
          display: inline-block;
          width: 2px;
          height: 10px;
          background-color: #192885;
        }
      }
      .more {
        margin-top: 15px;
        border-top: 1px dashed #192885;
        padding-top: 15px;
        text-align: center;
        font-size: 14px;
        line-height: 20px;
        .a-link {
          display: inline-block;
          font-size: 14px;
          position: relative;
          padding-right: 15px;
          color: #192885 !important;
          &:hover {
            outline: 0;
            text-decoration: underline;
            color: #192885;
          }
          .icon-link {
            position: absolute;
            right: 0;
            top: 4px;
            display: inline-block;
            width: 13px;
            height: 13px;
            background: url(../../assets/images/place-sprite8.png) no-repeat -45px 0;
            overflow: hidden;
          }
        }
      }
    }
  }
  .r-more {
    clear: both;
    margin-top: 25px;
    text-align: center;
    a {
      display: inline-block;
      border: 1px solid #192885;
      border-radius: 4px;
      font-size: 14px;
      line-height: 40px;
      padding: 0 42px;
      color: #192885;
      &:hover {
        text-decoration: none;
        background-color: #192885;
        color: #fff;
      }
    }
  }
}
</style>
