<template>
 <div> 
  <personal-answer 
  text="条回答" 
  componentName="我的回答" 
  :length="total"
  :pageSize="pageSize"
  @currentChange="switchPage"
  >
    <div class="wd-item-box" v-for="(wditem,i) in answerData.destinationDoubts" :key="i">
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
            <!-- <span class="comment-num">{{ wditem.commentNum?wditem.commentNum:0 }}</span>
            <span class="comment-des">评论</span> -->
            <span class="create-time">{{ wditem.createTime }}</span>
          </div>
        </div>
    </div>
  </personal-answer>
  
 </div>

</template>

<script setup lang="ts">
import {getMeAnswer} from '@/composables/api/questions'
import { questionNum } from '~~/composables/globaldata';
//import { setCurrentPageList } from '~~/composables/globalmethods';
const qNum=questionNum();

const total=ref(0);
const pageSize=ref(0);

definePageMeta({
  layout: 'personal'
});

const answerData=reactive({
  destinationDoubts:[]
});

onMounted(()=>{
  nextTick(()=>{    
    switchPage(1);
  })
})

const switchPage=(page)=>{
  getMeAnswer({current:page,size:10}).then((res)=>{
      answerData.destinationDoubts=res.data.records;
      qNum.value=res.data.total;
      total.value=res.data.total;
      pageSize.value=res.data.size;
  });
}

// const currentChange=(page)=>{
//   currentPageList.value=setCurrentPageList(page,answerData.destinationDoubts);
// }
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
        .meta-icon{
          width: 37px;
          height: 33px;
          background-image:url(../../assets/images/personal/ico_sprite_v8.png);
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
</style>