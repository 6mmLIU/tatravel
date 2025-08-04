<template>
<div class="component-answer">
  <div class="wd-dropdown _j_cange_type_dropdown" v-if="componentName === '我的回答'">
    <div class="trigger _j_change_type_div">
      <i class="i-down"></i>
      <span class="_j_change_text value">全部回答</span>
    </div>
    <!-- <ul class="dropdown-menu _j_change_type_ul hide" v-show="isDownShow">
      <li class="_j_change_flag" data-flag="0" @click="dropDownItemClick(0)">全部回答</li>
      <li class="_j_change_flag" data-flag="1" @click="dropDownItemClick(1)">金牌回答</li>
      <li class="_j_change_flag" data-flag="2" @click="dropDownItemClick(2)">题主采纳</li>
    </ul> -->
  </div>
  <div class="wd-total">共有<span class="_j_total_item">{{length}}</span>{{ text }}</div>
  <div class="wd-list _j_qa_list">
    <div class="no_data" v-if="length==0">
      <img src="http://css.mafengwo.net/images/home_new2015/no_num.png" height="139" width="156" alt="">
      <p>这里的世界静悄悄</p>
    </div>
    <div class="wd-list-box" v-else>
      <slot></slot>
    </div>
    <div class="page-box">
      <el-pagination
        class="page"
        background
        layout="prev, pager, next"              
        :page-size="pageSize"
        :total="length"
        v-model:current-page="currentPage"
        @current-change="currentChange"
      />
      </div>
    <!-- 渲染我的回答列表-->
    <!-- <div class="wd-list-box" v-else>
      <div class="wd-item-box" v-for="(wditem,i) in destinationDoubts" :key="i">
        <a class="wd-item-title" :href="`/questions/details/${wditem.id}`">
          <i  class="address-icon"></i>
          <span class="address">{{ wditem.authorName?wditem.authorName:'中国' }}</span>
          <span class="item-title">{{ wditem.title }}</span>
        </a>
        <div class="wd-item-content" v-html="wditem.answerContent">
        </div>
        <div class="wd-meta">
          <div class="wd-meta-left">
            <i class="meta-icon">顶</i>
            <span class="meta-liketotal">{{ wditem.likeTotal?wditem.likeTotal:0 }}</span>
          </div>
          <div class="wd-meta-rigtht">
            <span class="comment-num">{{ wditem.commentNum?wditem.commentNum:0 }}</span>
            <span class="comment-des">评论</span>
            <span class="create-time">{{ wditem.createTime }}</span>
          </div>
        </div>
      </div>
    </div>  -->
  </div>
</div>
</template>

<script setup lang="ts">
// import { comment } from 'postcss';
const currentPage=ref(1);

const props = defineProps({
    componentName:String,
    text:String,
    length:Number,
    pageSize:Number
  }
)
const emits=defineEmits(['currentChange'])
const currentChange=()=>{
  emits('currentChange',currentPage.value)
}


</script>

<style scoped lang="scss">
.wd-dropdown {
  float: right;
  display: inline;
  width: 112px;
  font-size: 14px;
  color: #666;
  .trigger {
    border: 1px solid #e5e5e5;
    border-radius: 4px;
    background-color: #fff;
    padding: 0 10px;
    line-height: 26px;
    cursor: pointer;
    color: #999;
    .i-down {
      float: right;
      margin-top: 10px;
      width: 13px;
      height: 8px;
      background: url(	https://css.mafengwo.net/images/home_new2015/ask_v2_sprite3.png) no-repeat -120px -40px;
    }
    .value {
      color: #666;
    }
  }
  .dropdown-menu {
    position: absolute;
    margin-top: 4px;
    border: 1px solid #e5e5e5;
    width: 110px;
    background-color: #fff;
    box-shadow: 2px 2px 2px rgb(0 0 0 / 10%);
    line-height: 36px;
    text-align: center;
    z-index: 10;
    max-height: 400px;
    overflow: auto;
    li {
      cursor: pointer;
    }
  }
  // .hide {
  //   display: none;
  // }
}
.wd-total {
  margin: 15px 0 5px;
  line-height: 24px;
  font-size: 14px;
  color: #999;
}
.wd-list {
  border-top: 1px solid #e5e5e5;
  margin: 0 -30px 0 0;
  .no_data {
    text-align: center;
    font-size: 16px;
    color: #d3d3d3;
    margin-top: 80px;
    padding-bottom: 120px;
    p {
      margin-top: 16px;
    }
  }
}

.page-box{
  display: flex;
  justify-content: flex-end;
  padding: 10px 0;
}
</style>