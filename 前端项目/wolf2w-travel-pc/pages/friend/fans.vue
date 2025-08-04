<template>
  <div>
    <div class="friend-content-header">
        <div class="header-left">
            <span class="friend-name">我的粉丝</span>
            <span class="friend-num">{{friendNum}}</span>
        </div>
                  
        <div class="header-right">
            <el-input v-model="searchStr" placeholder="查找朋友" />
            <a href="javascript:;" class="search-icon"></a>
        </div>
    </div>

  </div>
</template>

<script setup>
definePageMeta({
    layout:'friend'
})

const friendNum=ref(0);
const searchStr=ref('');
</script>

<style scoped lang="scss">
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
</style>