<template>
  <personal-answer 
  text="个关注" 
  :length="total"
  :pageSize="pageSize"
  @currentChange="switchPage"
  >
    <div class="wd-item-box" v-for="(wditem,i) in careData.destinationDoubts" :key="i">
        <a class="wd-item-title" :href="`/questions/details/${wditem.id}`">
          <i  class="address-icon"></i>
          <span class="address">{{ wditem.authorName?wditem.authorName:'中国' }}</span>
          <span class="item-title">{{ wditem.title }}</span>
        </a>
        <div class="wd-item-content" v-html="wditem.answerContent">
        </div>
        <div class="wd-meta">
          <div class="wd-meta-left">
            <img class="head-img" :src="wditem.userInfo.headImgUrl" alt="头像">
            <span class="nick-name">{{ wditem.userInfo.nickname }}</span>
          </div>
          <div class="wd-meta-rigtht">
            <span class="comment-num">{{ wditem.comment?wditem.comment:0 }}</span>
            <span class="comment-des">回答</span>
            <span class="create-time">{{ wditem.createTime }}</span>
          </div>
        </div>
    </div>
  </personal-answer>
</template>

<script setup lang="ts">
import { getMeFllow } from '~~/composables/api/questions';
import { questionNum } from '~~/composables/globaldata';
const qNum=questionNum();

const total=ref(0);
const pageSize=ref(0);

definePageMeta({
  layout: 'personal'
}) 

const careData=reactive({
  destinationDoubts:[]
});
onMounted(()=>{
  nextTick(()=>{
    switchPage(1);
  })
});
//切换页码
const switchPage=(page)=>{    
  getMeFllow({current:page,size:10}).then((res)=>{      
      careData.destinationDoubts=res.data.records;
      qNum.value=res.data.total;
      total.value=res.data.total;
      pageSize.value=res.data.size;
    })
}
</script>

<style scoped lang="scss">
.wd-item-box{
    padding: 20px 30px 20px 0;

    .wd-item-title{
      display: flex;
      align-items: center;
      .address-icon{
        width: 14px;
        height: 16px;
        background-image: url(../../assets/images/personal/ask_v2_sprite3.png);
        background-repeat: no-repeat;
        background-position: -100px -40px;
      }

      .address{
        font-size: 20px;
        color: #192885;
        margin: 0 10px 0 5px;
      }

      .item-title{
        font-size: 20px;
        color: #333;

        &:hover{
          color: #192885;
        }
      }

    }

    .wd-item-content{
      padding: 20px 0;
      font-size: 14px;
      color: #555;
    }

    .wd-meta{
      display: flex;
      justify-content: space-between;
      align-items: center;
      color: #999;

      .wd-meta-left{
        display: flex;
        align-items: center;
        
        .head-img{
          width: 16px;
          height: 16px;
          border-radius: 50%;
          margin-right: 3px;
          overflow: hidden;
        }
      }

      .comment-des{
        margin-right: 5px;
      }
    }
  }
</style>