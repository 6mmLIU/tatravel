<template>
  <div class="travel-body clearfix">
    <div class="note_side flt1">
      <div class="MAvatar">
        <div class="MAvaImg hasAva">
          <img :src="userInfo?userInfo.headImgUrl:'https://p1-q.mafengwo.net/s12/M00/35/98/wKgED1uqIreAU9QZAAAXHQMBZ74008.png?imageMogr2%2Fthumbnail%2F%21200x200r%2Fgravity%2FCenter%2Fcrop%2F%21200x200%2Fquality%2F90'" height="120" width="120" alt="带TA游用户">
          <a href="/setting/avatar/" class="MAvaUp mfw-acc-hide">
            <i class="Mphoto mfw-acc-hide"></i>
          </a>
        </div>
        <div class="MAvaName">{{userInfo?userInfo.nickname:'带TA游用户'}}</div>

        <div class="its_tags mfw-acc-hide">
          <a href="/home/vip_show.php" target="_blank" title="VIP"><i class="vip"></i></a>
          <a href="/rudder/info.php" target="_blank" title="分舵"><i class="duo"></i>
          </a><a href="/qa/expert_apply.php?type=1" target="_blank" title="指路人"><i class="zhiluren"></i></a>
        </div>
        <div class="MAvaInfo clearfix MAvaMyInfo mfw-acc-hide">
          <span class="MAvaLevel flt1">等级：<a href="/rank/lv.php" title="Lv.2" target="_blank">Lv.{{userInfo?userInfo.level:2}}</a></span>
          <span class="MAvaPlace flt1" title="阿坝">现居：{{userInfo?userInfo.city:'阿坝'}}</span>        <span class="MAvaSet"><a title="设置" href="/setting/" target="_blank"></a></span>
        </div>
      </div>
      <div class="MUsers">
        <div class="MUsersTitle">最新访客</div>
        <div class="MUsersDetail">
          <div class="MUsersAtom">
            <ul class="clearfix">
            </ul>
          </div>

        </div>
        <div class="MUsersBehavior">
          <span>累计访问<i>0</i></span><span>今日<i>0</i></span>
        </div>
      </div>

    </div>
    <div class="content flt2">
      <div class="common_block my_notes">
        <div class="common_title clearfix">
          <div class="MAvaMore clearfix">
            <div class="MAvaNums">
              <strong>{{travelsData.travelsNum}}</strong>
              <p>游记</p>
            </div>
            <div class="MAvaNums">
              <strong>0</strong>
              <p>回复</p>
            </div>
            <div class="MAvaNums last">
              <strong>0</strong>
              <p>阅读</p>
            </div>
          </div>
        </div>
        <div id="article_list">
          <div class="notes_default_v2" v-if="travelsData.travelsList.length==0">
            <div class="notes_dcon">
            </div>
            <a href="/note/form" title="写游记" class="btn_write"><i></i>写游记</a>
          </div>
          <div class="travels-list-box" v-else>
            <PersonalTravelsItem 
            v-for="(item,i) in travelsData.travelsList"
            :key="item.id"
            :travelsItem="item"
            ></PersonalTravelsItem>

            <div class="page-box">
              <el-pagination
                class="page"
                layout="prev, pager, next"              
                :page-size="10"
                :total="travelsData.travelsNum"
                v-model:current-page="travelsData.currentPage"
                @current-change="currentChange"
              />
            </div>
          </div>
        </div>

        <div align="right" class="m-pagination _j_pager_content">

        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
// import { onMounted } from 'vue';
import {getMeRegios} from '@/composables/api/note'
definePageMeta({
  layout: 'personal'
})

const userInfo=ref();

const travelsData=reactive({
  travelsNum:0,
  travelsList:[],
  currentPage:1
})

const getTravels=(page)=>{
  getMeRegios({currentPage:page,pageSize:10}).then((res)=>{
    travelsData.travelsNum=res.data.total;
    travelsData.travelsList=res.data.list;
  }).catch((msg)=>{
    //console.log(msg);
    if(msg.code==500){
      navigateTo('/login')
    }
  })
}

const currentChange=(page)=>{
  console.log(page);
  
  getTravels(page);
}
//分页数组
onMounted(()=>{ 
  userInfo.value=JSON.parse(localStorage.getItem('userInfo'));
  nextTick(()=>{
    getTravels(travelsData.currentPage);
  })
})
</script>

<style scoped lang="scss">
.travel-body {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  .MAvatar {
    text-align: center;
    font-size: 14px;
    .MAvaImg {
      width: 120px;
      height: 70px;
      position: relative;
      margin: 0 auto;
      img {
        position: relative;
        top: -50px;
        z-index: 20;
        border-radius: 120px;
      }
      img {
        border: 0;
        vertical-align: middle;
      }
      .MAvaUp {
        width: 120px;
        height: 120px;
        position: absolute;
        left: 0;
        top: -50px;
        z-index: 20;
        border-radius: 120px;
      }
    }
    .MAvaName {
      font-size: 22px;
      line-height: 24px;
      margin-top: 16px;
    }
    .its_tags {
      margin: 10px 0;
      text-align: center;
      i {
        width: 40px;
        height: 20px;
        display: inline-block;
        background-image: url(assets/images/personal/home_sprite_v15.png);
        background-position: 0 -460px;
        margin-right: 3px;
      }
      .duo {
        width: 30px;
        background-position: -41px -460px;
      }
      .zhiluren {
        width: 38px;
        background-position: -72px -460px;
      }
    }
  }
}
.MUsers {
  padding: 45px 30px 0;
  text-align: center;
  font-size: 14px;
}
.note_side {
  width: 280px;
  background-color: #ffffff;
  box-shadow: 0 0 2px rgb(0 0 0 / 5%);
  position: relative;
  z-index: 10;
  padding-bottom: 55px;
  margin-top: 18px;
  border: #e2e2e2 1px solid;
  .MUsersDetail {
    margin-top: 28px;
    overflow: hidden;
  }
  .MUsers {
    padding-top: 35px;
    .MUsersTitle {
      font-size: 16px;
      color: #444;
    }
    .MUsersBehavior {
      margin-top: 20px;
      padding-bottom: 6px;
      color: #999;
     span {
        margin: 0 10px;
       i {
         color: #ff8a00;
       }
      }
    }
  }
}
.content {
  width: 682px;
  margin-top: 18px;
  margin-left:16px;
  .my_notes {
    padding-bottom: 30px;
    .common_title {
      padding: 25px 30px;
      line-height: 30px;
      position: relative;
      .MAvaMore {
        width: 432px;
        margin: 0 auto;
        border: none;
        display: flex;
        flex-direction: row;
        align-items: center;
        .MAvaNums {
          padding: 5px 0 0;
          line-height: 26px;
          width: 33%;
          text-align: center;
          position: relative;
          strong {
            font-size: 20px;
            color: #444;
            font-family: Arial;
          }
          p {
            color: #999;
          }
          &:after {
            content: '';
            width: 1px;
            position: absolute;
            right: 0;
            top: 0;
            bottom: 0;
            background-color: #e2e2e2;
          }
          &:last-child:after{
            width:0;
          }
        }
      }
    }
    .notes_default_v2 {
      padding-bottom: 40px;
      position: relative;
     .notes_dcon {
        width: 100%;
        height: 320px;
        background: url(assets/images/personal/noyj_v2.jpg) no-repeat;
      }
      .btn_write {
        display: block;
        width: 140px;
        height: 40px;
        border-radius: 4px;
        background-color: #ff9e00;
        position: absolute;
        right: 30px;
        top: -61px;
        font-size: 16px;
        color: #fff;
        text-align: center;
        line-height: 40px;
        i {
          display: inline-block;
          width: 18px;
          height: 18px;
          background: url(assets/images/personal/home_sprite_v15.png) -228px -325px no-repeat;
          margin-right: 5px;
          vertical-align: middle;
        }
      }
    }
  }
  .common_block {
    margin-bottom: 18px;
    background-color: #ffffff;
    border: #e2e2e2 1px solid;
    box-shadow: 0 0 2px rgb(0 0 0 / 5%);
  }

  .page-box{
    display: flex;
    justify-content: flex-end;
    padding-right: 20px;
  }
}
</style>