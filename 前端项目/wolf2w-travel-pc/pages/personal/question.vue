<template>
  <personal-answer text="个问题" :length="total" :pageSize="pageSize" @currentChange="switchPage">
    <div class="wd-item-box" v-for="(wditem, i) in questionData.destinationDoubts" :key="i">
      <a class="wd-item-title" :href="`/questions/details/${wditem.id}`">
        <i class="address-icon"></i>
        <span class="address">{{ wditem.destinationName ? wditem.destinationName : '中国' }}</span>
        <span class="item-title">{{ wditem.title }}</span>
      </a>
      <div class="wd-item-content" v-html="wditem.answerContent">
      </div>
      <div class="wd-meta">

        <div class="wd-meta-rigtht">
          <span class="comment-num">{{ wditem.commentNum ? wditem.commentNum : 0 }}</span>
          <span class="comment-des">评论</span>
          <span class="create-time">{{ wditem.createTime }}</span>
          <span class="sx">|</span>
          <span class="plase-cn">请采纳</span>
        </div>
      </div>
    </div>
  </personal-answer>
</template>

<script setup lang="ts">
import { getMeQuestions } from '~~/composables/api/questions';
import { questionNum } from '~~/composables/globaldata';
const qNum = questionNum();
const currentPageList = ref([]);

const total = ref(0);
const pageSize = ref(0);
definePageMeta({
  layout: 'personal'
})

const questionData = reactive({
  destinationDoubts: []
})

onMounted(() => {
  nextTick(() => {
    switchPage(1);
  })
})

const switchPage = (page) => {
  getMeQuestions({ current: page, size: 10 }).then((res) => {

    questionData.destinationDoubts = res.data.records;
    qNum.value = res.data.total;
    total.value = res.data.total;
    pageSize.value = res.data.size;
  });
}
</script>

<style scoped lang="scss">
.wd-total {
  margin: 15px 0 5px;
  line-height: 24px;
  font-size: 14px;
  color: #999;
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
    justify-content: flex-end;
    align-items: center;
    color: #999;

  }

  .sx {
    padding: 0 7px;
  }

  .plase-cn {
    color: #192885;
  }

  .comment-des {
    margin-right: 3px;
  }
}
</style>