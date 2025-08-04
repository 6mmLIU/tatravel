<template>
    <div class="layout-container">
    <div class="layout-header">
      <Header />
    </div>
    <div class="layout-main">
        <div class="friend">
            <div class="friend-aside">
                <nuxt-link 
                v-for="(item,index) in asideList" 
                :class="`aside-item ${asideIndex==index?'aside-active-item':''}`" 
                :to="{path:item.path,query:{type:item.text}}"
                @click="asideIndex=index"
                >
                    <i :style="{backgroundPosition:asideIndex==index?item.activepos:item.normalpos}"></i>
                    <span>{{ item.text }}</span>
                </nuxt-link>
            </div>
            <div class="friend-content">                
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
        {id:'aside001',text:'我的关注',path:'/friend/follow',normalpos:'0 0',activepos:'-24px 0'},
        {id:'aside002',text:'我的粉丝',path:'/friend/follow',normalpos:'0 -24px',activepos:'-24px -24px'}
    ];

    const asideIndex=ref(0);

    const route=useRoute();

    onMounted(()=>{
         document.body.style.margin='0';

         if(route.query.type=='我的粉丝'){
            asideIndex.value=1
         }
         
    });
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
      
      .friend{
        width: 1000px;
        margin: 0 auto;
        padding-top: 20px;

        display: flex;

        .friend-aside{
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
                    width: 24px;
                    height: 24px;
                    background-image: url(/assets/images/icon_left.png);
                    margin-right: 10px;
                }
            }

            .aside-active-item{
                background-color: #ffa800;
                color: #fff;
                border-radius: 5px;
                &:hover{
                    background-color: #ffa800;
                }
            }
        }

        .friend-content{            
            width: 780px;
            min-height: 480px;
            padding-left: 40px;
            box-sizing: border-box;

            .friend-content-header{
              display: flex;
              align-items: center;
              justify-content: space-between;
              margin-bottom: 20px;
                .header-left{
                    display: flex;
                    align-items: center;
                    color: #666;
                    .friend-name{
                        font-size: 18px;
                        margin-right: 5px;
                    }

                    .friend-num{
                        font-size: 16px;
                        font-weight: 700;
                    }
                }

                .header-right{
                    width: 230px;
                    height: 35px;
                    position: relative;

                    .search-icon{
                        position: absolute;
                        top: 50%;
                        right: 10px;
                        transform: translateY(-50%);
                        width: 17px;
                        height: 16px;
                        background:url(/assets/images/icon_sprites2.png) no-repeat -40px 0;
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