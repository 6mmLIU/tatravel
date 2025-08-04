<template>
  <div class="travels-item">
    <div class="travels-item-img">
        <img :src="travelsItem.coverUrl">        
    </div>
    <div class="travels-title-box">
        <h3 class="travels-title">
           <nuxt-link :to="`/note/details/${travelsItem.id}`"> {{ travelsItem.title }}</nuxt-link>
        </h3>
        <div class="travels-thumbsup-box">
            <span class="thumbsup-num">{{ travelsItem.thumbsupnum?travelsItem.thumbsupnum:0 }}</span>
            <button class="thumbsup-btn">顶</button>
        </div>
    </div>
    <div class="travels-info-box">
        <div class="view-box">
            <i class="view-icon"></i>
            <span class="view-num">0/{{ travelsItem.viewnum?travelsItem.viewnum:0 }}</span>
        </div>
        <div class="favor-box">
            <i class="favor-icon"></i>
            <span class="favor-num">{{ travelsItem.favornum?travelsItem.favornum:0 }}</span>
        </div>
        <div class="add-time">
            {{ travelsItem.travelTime }}
        </div>
    </div>
  </div>
</template>

<script setup>
const props= defineProps(['travelsItem']);
// console.log(props.travelsItem);
</script>

<style scoped>
.travels-item{
    width: 680px;
    padding-bottom: 40px;
}

.travels-item-img{
    height: 400px;
}

.travels-item-img>img{
    width: 100%;
    height: 100%;
}

.travels-title-box{
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px 30px 10px;
}

.travels-title{
    font-size:18px;
    line-height: 24px;
    color: #ff8a00;
    font-weight: 700;
}

.thumbsup-num{
    color:#ff8a00;
    margin-right: 5px;
}

.thumbsup-btn{
    width: 37px;
    height: 33px;
    background-image:url(../../assets/images/personal/ico_sprite_v8.png);
    background-position: 0 -90px;
    text-align: center;
    line-height: 33px;
    color: #fff;
    border: 0;
    outline: none;
    background-color: transparent;
    font-size: 18px;
}

.travels-info-box{
    display: flex;
    align-items: center;
    padding-left: 30px;
    color: #999;
    font-size: 14px;
}
 
.view-box,.favor-box{
    margin-right: 10px;
    display: flex;
    align-items: center;
    
} 

.view-icon,.favor-icon{
    width: 18px;
    height: 16px;
    background-image:url(../../assets/images/personal/ico_sprite_v8.png);
    margin-right: 3px;
}

.view-icon{
    background-position: 0 -124px;
}
.favor-icon{
    background-position: -42px -124px;
}
</style>