<template>
 <div class="solution-body">
   <div class="wd-dropdown _j_cange_type_dropdown">
     <div class="trigger _j_change_type_div" @click="changeDropDown">
       <i class="i-down"></i>
       <span class="_j_change_text value">向我推荐</span>
     </div>
     <ul class="dropdown-menu _j_change_type_ul hide" v-if="dropDown">
       <li class="_j_change_flag" data-flag="0">向我推荐</li>
       <li class="_j_change_flag" data-flag="1">向我求助</li>
     </ul>
   </div>
   <div class="wd-total">共有<span class="_j_total_item">0个</span>问题</div>
   <div class="wd-list _j_qa_list">
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="16352266">忽略</a>
       <a href="/wenda/detail-16352266.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-16352266.html" target="_blank"><span class="label-mdd"><i></i></span>在日本当地旅拍，有哪些手到擒来的日系风拍摄技巧？</a></div>
       <div class="wd-detail">下周就要去日本旅拍了，要去东京和大阪，想拍拍时尚可爱风的日系照，大家有哪些实用的拍摄小技巧没，求带TA游的大神分享。</div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">15回答</span>
           <span class="meta-item meta-time">2019-03-11 15:48</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="17867121">忽略</a>
       <a href="/wenda/detail-17867121.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-17867121.html" target="_blank"><span class="label-mdd"><i></i></span>你经历过的最奇葩最悲催的旅行是哪一次？</a></div>
       <div class="wd-detail">我经历过的最惨的一次旅行应该是高中毕业跟同学去青岛玩，跟团游，全程坐大巴。嗯，风景不是重点，重点是我晕车… 这次旅行是我人生中最严重的一次晕车，我从上车就开始吐，真实的吐…坐在第一排，抱着垃圾桶…真的很对不起跟我坐在车内的游客。味道实在很...</div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">79回答</span>
           <span class="meta-item meta-time">2019-06-06 11:38</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="10217381">忽略</a>
       <a href="/wenda/detail-10217381.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-10217381.html" target="_blank"><span class="label-mdd"><i></i></span>人均100块钱，能在全球吃到怎样的午餐？</a></div>
       <div class="wd-detail">如果人均只100块钱，能在全球吃到什么样午餐？</div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">65回答</span>
           <span class="meta-item meta-time">2017-10-11 16:18</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="19966413">忽略</a>
       <a href="/wenda/detail-19966413.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-19966413.html" target="_blank"><span class="label-mdd"><i></i></span>旅行三年后，如何回归正常的工作生活？你有啥建议？</a></div>
       <div class="wd-detail">好朋友当时是裸辞的，有一笔存款，辞职后就直接去旅行了。一路没有奢侈游，就是看世界！有时候打工赚点钱。现在回国安定后一时半会不知道自己该咋办？心态也还在路上，很难一下扭转过来！旅行三年后，如何回归正常的工作生活？你有啥建议？</div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">108回答</span>
           <span class="meta-item meta-time">2019-11-05 15:36</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="22474421">忽略</a>
       <a href="/wenda/detail-22474421.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-22474421.html" target="_blank"><span class="label-mdd"><i></i></span>和男友妈妈适合去哪里玩</a></div>
       <div class="wd-detail">五月份想和男友妈妈一起出去玩，不知道哪些地方适合
         想要近一点(成都周边），男友妈妈易晕车</div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">98回答</span>
           <span class="meta-item meta-time">2021-05-01 21:13</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="22499210">忽略</a>
       <a href="/wenda/detail-22499210.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-22499210.html" target="_blank"><span class="label-mdd"><i></i></span>八月約歐洲自駕游..... 地點隨意...</a></div>
       <div class="wd-detail"></div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">52回答</span>
           <span class="meta-item meta-time">2021-05-08 11:08</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="14905869">忽略</a>
       <a href="/wenda/detail-14905869.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-14905869.html" target="_blank"><span class="label-mdd"><i></i></span>旅途中，“人在囧途”是一种怎样尴尬的极致体验？</a></div>
       <div class="wd-detail">旅途中，你有没有遇到过特别囧、特别尴尬的事情？就是360度囧，囧到你都想说：卧槽！这是什么操作？？还有这种操作？？的囧比如我有朋友，出去旅行，拍了5000张照片后，相机存储卡掉进大街上的下水道，被冲走了。。。。还有丢行李的，还有定宾馆结果没定成...</div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">100回答</span>
           <span class="meta-item meta-time">2018-12-24 16:04</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="17536089">忽略</a>
       <a href="/wenda/detail-17536089.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-17536089.html" target="_blank"><span class="label-mdd"><i></i></span>他真是怕不知醒吗？还是另有企图？你会如何反应？</a></div>
       <div class="wd-detail">男女初相识，约好一起凌晨爬山，本来各住一个房间，夜里男生来电，说不知醒，要求搬过来和女生同住以便凌晨一起出发。他真是怕不知醒吗？还是另有企图？你会如何反应？</div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">98回答</span>
           <span class="meta-item meta-time">2019-05-14 16:39</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="22127233">忽略</a>
       <a href="/wenda/detail-22127233.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-22127233.html" target="_blank"><span class="label-mdd"><i></i></span>想问一下，新年大家是不是都出不来玩呀，我看抖音在刷各省政策，还有一些大学直接开学不放假。今年是不是过年又是寒冬。。。</a></div>
       <div class="wd-detail"></div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">11回答</span>
           <span class="meta-item meta-time">2021-01-06 14:19</span>
         </div>
       </div>
     </div>
     <div class="wd-item">
       <a class="wd-btn-ignore _j_del_solution_answer" data-qid="18151498">忽略</a>
       <a href="/wenda/detail-18151498.html#answer" target="_blank" class="wd-btn-answer">回答</a>
       <div class="wd-title"><a href="/wenda/detail-18151498.html" target="_blank"><span class="label-mdd"><i></i></span>垃圾分类逼疯上海人？旅行时你到过哪些地方这方面做得特别好？</a></div>
       <div class="wd-detail"></div>
       <div class="wd-meta">
         <div class="meta-pull">
           <span class="meta-item meta-commit">39回答</span>
           <span class="meta-item meta-time">2019-06-25 17:27</span>
         </div>
       </div>
     </div>

   </div>
 </div>
</template>

<script setup lang="ts">
const dropDown = ref(false)
 definePageMeta({
   layout: 'personal'
 })
function changeDropDown () {
  dropDown.value = !dropDown.value
  console.log(dropDown.value, '===')
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
  .hide {
    display: none;
  }
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
  .wd-item {
    border-bottom: 1px solid #e5e5e5;
    padding: 20px 30px 20px 0;
    .wd-btn-ignore {
      float: right;
      margin: 3px 0 0 10px;
      font-size: 12px;
      line-height: 30px;
      color: #999;
    }
    .wd-btn-answer {
      float: right;
      margin: 3px 0 0 10px;
      width: 90px;
      height: 30px;
      background-color: #192885;
      border-radius: 4px;
      text-align: center;
      line-height: 30px;
      color: #fff;
      font-size: 16px;
    }
    .wd-title {
      margin-bottom: 8px;
      font-size: 20px;
      line-height: 36px;
       a {
        color: #333;
      }
      .label-mdd {
        display: inline-block;
        margin-right: 10px;
        font-size: 20px;
        color: #192885;
        i {
          float: left;
          display: inline-block;
          margin: 9px 5px 0 0;
          width: 14px;
          height: 16px;
          background: url(	https://css.mafengwo.net/images/home_new2015/ask_v2_sprite3.png) no-repeat -100px -40px;
        }
      }
    }
    .wd-detail {
      margin-bottom: 20px;
      line-height: 24px;
      font-size: 14px;
      *zoom: 1;
      &:after {
        content: '';
        clear: both;
        display: table;
        height: 0;
        overflow: hidden;
      }
    }
    .wd-meta {
      font-size: 12px;
      color: #999;
      line-height: 20px;
      *zoom: 1;
      .meta-pull {
        float: right;
        margin-right: -5px;
        .meta-item {
          display: inline-block;
          margin-right: 5px;
          vertical-align: middle;
        }
      }
      &:after {
        content: '';
        clear: both;
        display: table;
        overflow: hidden;
        height: 0;
      }
    }
  }
}
</style>