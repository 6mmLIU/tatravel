<template>
    <div class="layout-container">
    <div class="layout-header">
      <Header />
    </div>
    <div class="layout-main">
        <div class="setting">
            <div class="setting-aside">
                <nuxt-link 
                v-for="(item,index) in asideList" 
                :to="item.path" :class="`aside-item ${asideIndex==index?'aside-active-item':''}`" 
                @click="switchPage(index)"
                >
                    <i :style="{backgroundPosition:asideIndex==index?item.activepos:item.normalpos}"></i>
                    <span>{{ item.text }}</span>
                </nuxt-link>
            </div>
            <div class="setting-content">
                <div class="setting-content-header">
                  <strong>{{settingName}}</strong>
                  <span class="mfw-acc-hide">
                    资料完善度
                    <div class="progress">
                      <div class="num">60%</div>
                      <div class="on"></div>
                    </div>
                  </span>
                </div>
                <NuxtPage />
            </div>
        </div>
    </div>
    <div class="layout-footer">
      <Footer />
    </div>
  </div>
  </template>
  
  <script setup lang="ts">
    
    const asideList=[
        {id:'aside001',text:'我的信息',path:'/setting',normalpos:'0 0',activepos:'-22px 0'},
        {id:'aside002',text:'我的头像',path:'/setting/avatar',normalpos:'0 -22px',activepos:'-22px -22px'}
    ];

    const asideIndex=ref(0);

    const settingName=ref('我的信息');

    const switchPage=(index)=>{
      asideIndex.value=index;
      switch(index){
        case 0:
        settingName.value='我的信息';
        break;
        case 1:
        settingName.value='我的头像';
        break;
      }
    }

    onMounted(()=>{
      document.body.style.margin='0';
        if(!localStorage.getItem('userInfo')){
            navigateTo('/login')
        }
    })
  </script>
  
  <style scoped lang="scss">
  .layout-personal {
    width:980px;
    margin:0 auto;
  }
  .layout-container {
    position: relative;
    width: 100%;
    height: 100%;
    background: #fff;
    .layout-main {
      width: 100%;
      padding: 0;
      
      .setting{
        width: 1000px;
        margin: 0 auto;
        padding-top: 20px;

        display: flex;

        .setting-aside{
            display: flex;
            flex-direction: column;
            
            .aside-item{
                width: 220px;
                height: 45px;
                display: flex;
                align-items: center;
                font-size: 14px;
                box-sizing: border-box;
                padding-left: 20px;
                color: #666;
                margin-bottom: 10px;
                &:hover{
                  background-color: #f0f0f0;
                }
                i{
                    width: 22px;
                    height: 22px;
                    background-image: url(/assets/images/i_left4.png);
                    margin-right: 10px;
                }
            }

            .aside-active-item{
                background-color: #ffa800;
                color: #fff;
                border-radius: 5px;
            }
        }

        .setting-content{            
            width: 780px;
            min-height: 480px;
            padding-left: 40px;
            box-sizing: border-box;

            .setting-content-header{
              display: flex;
              align-items: flex-end;
              margin-bottom: 20px;
              padding-bottom: 18px;
              border-bottom: 1px solid #ececec;

              strong{
                font-size: 24px;
                margin-right: 15px;
              }

              .mfw-acc-hide{
                display: flex;
                align-items: center;
                font-size: 15px;
                color: #666;
                .progress{
                  width: 110px;
                  height: 16px;
                  background-color: #bddf7d;
                  margin-left: 10px;
                  position: relative;

                  .num{
                    font-size: 13px;
                    line-height: 16px;
                    text-align: right;
                    margin-right: 3px;
                    color: #fff;
                    
                  }

                  .on{
                    width: 60%;
                    background-color: #add75c;
                    height: 100%;

                    position: absolute;
                    z-index: 10;
                    left: 0;
                    top: 0;
                  }
                }
              }
            }
        }
      }
    }
  }

  .tags-link-active {
     border-bottom:3px solid #ff8a00 !important;
  }
  </style>