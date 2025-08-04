<template>
    <div class="follow">
        <div class="friend-content-header">
            <div class="header-left">
                <span class="friend-name">我的关注</span>
                <span class="friend-num">{{ friendNum }}</span>
            </div>

            <div class="header-right">
                <el-input v-model="searchStr" placeholder="查找朋友" />
                <a href="javascript:;" class="search-icon"></a>
            </div>
        </div>

        <div class="follow-list-box" v-if="followData.length">
            <div class="follow-item" v-for="(item, index) in followData">
                <div class="follow-headimg-box">
                    <img :src="item.headImgUrl" />
                </div>
                <div class="follow-name-box">
                    <a href="javascript:;">{{ item.userName }}</a>
                    <i :style="{ backgroundPosition: `${item.sex == '男' ? '-20px 0' : '0 0'}` }"></i>
                </div>
                <div class="follow-info-box">
                    <a href="javascript:;" class="travels-info">
                        <b>{{ item.travelTotal }}</b>
                        <span>游记</span>
                    </a>
                    <a href="javascript:;" class="fans-info">
                        <b>{{ item.followerTotal }}</b>
                        <span>粉丝</span>
                    </a>
                    <a href="javascript:;" class="travels-info">
                        <b>0</b>
                        <span>足迹</span>
                    </a>
                </div>
                <div class="follow-btn-box">
                    <a href="javascript:;" :class="`follow-btn ${item.isfollow ? '' : 'follow-active-btn'}`"
                        @click="setFollow(index)">
                        <span>{{ item.isfollow ? '已关注' : '关注' }}</span>
                        <i>取消关注</i>
                    </a>
                    <a href="javascript:;" class="message-btn">
                        发私信
                    </a>
                </div>
            </div>
        </div>
        <div v-else class="follow-null">
            <p>没有搜索到此用户</p>
        </div>
    </div>
</template>

<script setup lang="ts">
import { getFollow, getFans, followOperate } from '~~/composables/api/friend';
import {ElMessage} from 'element-plus'
definePageMeta({
    layout: 'friend'
})
const route = useRoute();
const friendNum = ref(0);
const searchStr = ref('');
const followData = ref([]);

const setFollow = (index) => {

    followOperate(followData.value[index].userId).then((res) => {
        console.log(res);
        if(res.code==200){
            ElMessage.success(res.data.statusDesc);
        }
    })

    followData.value[index].isfollow = !followData.value[index].isfollow;
}

const getFirends = () => {
    //console.log(route.query.type);
    if (route.query.type == '我的关注') {
        getFollow().then((res) => {
            followData.value = res.data.records;
            followData.value.forEach((item) => {
                item.isfollow = true;
                switch (item.gender) {
                    case 0:
                        item.sex = '保密';
                        break;
                    case 1:
                        item.sex = '男';
                        break;
                    case 2:
                        item.sex = '女';
                        break;
                }
            });

            friendNum.value = res.data.total;

        })
    } else if (route.query.type == '我的粉丝') {
        getFans().then((res) => {
            //console.log(res);
            followData.value = res.data.records;

            followData.value.forEach((item) => {
                item.isfollow = item.followEachOther;
                switch (item.gender) {
                    case 0:
                        item.sex = '保密';
                        break;
                    case 1:
                        item.sex = '男';
                        break;
                    case 2:
                        item.sex = '女';
                        break;
                }
            });
            friendNum.value = res.data.total;
        })
    }
}

watch(route, async ({ fullPath }) => {
    getFirends();
})

onMounted(() => {
    nextTick(() => {
        //console.log(route.query);
        getFirends();
    })
});
</script>

<style scoped lang="scss">
.friend-content-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 20px;

    .header-left {
        display: flex;
        align-items: center;
        color: #666;

        .friend-name {
            font-size: 18px;
            margin-right: 5px;
        }

        .friend-num {
            font-size: 16px;
            font-weight: 700;
        }
    }

    .header-right {
        width: 230px;
        height: 35px;
        position: relative;

        .search-icon {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            width: 17px;
            height: 16px;
            background: url(/assets/images/icon_sprites2.png) no-repeat -40px 0;
        }
    }
}

.follow-list-box {
    display: flex;
    flex-wrap: wrap;

    .follow-item {
        width: 230px;
        margin-right: 25px;
        box-sizing: border-box;
        border: 1px solid #ececec;
        padding: 20px 15px 15px;

        &:nth-child(3n) {
            margin-right: 0;
        }

        .follow-headimg-box {
            width: 90px;
            height: 90px;
            border: 1px solid #ececec;
            padding: 2px;
            border-radius: 50%;
            overflow: hidden;
            margin: 0 auto;

            img {
                width: 90px;
                height: 90px;
                border-radius: 50%;
            }
        }

        .follow-name-box {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 20px 0;

            a {
                font-size: 18px;
                color: #666;
                margin-right: 5px;
            }

            i {
                width: 20px;
                height: 20px;
                background-image: url(/assets/images/icon_sprites2.png);
                background-repeat: no-repeat;
            }
        }

        .follow-info-box {
            display: flex;
            align-items: center;
            height: 35px;

            a {
                color: #666;
                display: flex;
                flex-direction: column;
                align-items: center;

                b {
                    font-size: 18px;
                    font-weight: 700;
                }

                span {
                    font-size: 14px;
                }
            }

            .travels-info {
                flex: 1;
                text-align: center;
                height: 100%;

            }

            .fans-info {
                width: 100px;
                height: 100%;
                border-left: 1px solid #ececec;
                border-right: 1px solid #ececec;
            }

        }

        .follow-btn-box {
            display: flex;
            justify-content: center;
            margin-top: 20px;

            a {
                width: 75px;
                height: 25px;
                line-height: 27px;
                text-align: center;
                border-radius: 3px;

            }

            .message-btn {
                border: 1px solid #192885;
                color: #192885;
            }

            .follow-btn {
                border: 1px solid #999;
                background-color: #999;
                color: #fff;
                margin-right: 10px;

                i {
                    display: none;
                }

                &:hover {
                    border: 1px solid #192885;
                    color: #192885;
                    background-color: #fff;

                    span {
                        display: none;
                    }

                    i {
                        display: block;
                        font-style: normal;
                    }
                }
            }


            .follow-active-btn,
            .message-btn:hover {
                border: 1px solid #192885;
                background-color: #192885;
                color: #fff;
            }

            .follow-active-btn:hover {
                border: 1px solid #192885;
                background-color: #ff8a00;
                color: #fff;

                span {
                    display: block;
                }

                i {
                    display: none;

                }
            }
        }
    }
}

.follow-null {
    padding: 240px 0 80px;
    text-align: center;
    font-size: 16px;
    background: url(/assets/images/null_gz.gif) no-repeat center 100px #fff;

    p {
        color: #999;
        line-height: 36px;
        padding: 10px 0;
    }
}
</style>


<!-- const followData=reactive([
    {
        id:'follow001',
        headImgUrl:'/assets/images/follow/1.png',
        nikeName:'游记总编辑',
        travelsNum:50,
        fans:9441691,
        footPrint:0,
        isfollow:true,
        sex:'男'
    },
    {
        id:'follow002',
        headImgUrl:'/assets/images/follow/2.jpeg',
        nikeName:'带TA游问答君',
        travelsNum:32,
        fans:18664621,
        footPrint:0,
        isfollow:true,
        sex:'男'
    },
    {
        id:'follow003',
        headImgUrl:'/assets/images/follow/3.jpeg',
        nikeName:'带TA游视频君',
        travelsNum:5,
        fans:19707172,
        footPrint:0,
        isfollow:true,
        sex:'女'
    },
    {
        id:'follow004',
        headImgUrl:'/assets/images/follow/4.jpeg',
        nikeName:'带TA游玩法君',
        travelsNum:1,
        fans:37933032,
        footPrint:0,
        isfollow:true,
        sex:'女'
    },
    {
        id:'follow005',
        headImgUrl:'/assets/images/follow/5.jpeg',
        nikeName:'马小蜂',
        travelsNum:9,
        fans:43175867,
        footPrint:0,
        isfollow:true,
        sex:'女'
    },
    {
        id:'follow006',
        headImgUrl:'/assets/images/follow/6.jpeg',
        nikeName:'小蜂',
        travelsNum:19,
        fans:48817718,
        footPrint:0,
        isfollow:true,
        sex:'女'
    },
    {
        id:'follow007',
        headImgUrl:'/assets/images/follow/7.jpeg',
        nikeName:'小蚂',
        travelsNum:18,
        fans:50214022,
        footPrint:0,
        isfollow:true,
        sex:'女'
    },
    {
        id:'follow008',
        headImgUrl:'/assets/images/follow/8.jpeg',
        nikeName:'蜂窝机器人',
        travelsNum:9,
        fans:51270489,
        footPrint:0,
        isfollow:true,
        sex:'女'
    }
    
]); -->