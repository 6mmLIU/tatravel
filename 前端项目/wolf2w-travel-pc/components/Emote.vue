<template>
    <div class="chatIcon">
        <el-popover popper-class="biaoqing" placement="top" :width="400" trigger="click">
            <template #reference>
                <el-button class="emotionSelect">
                    <a id="_j_replyfacetrigger" role="button" class="expression" title="选择表情"></a>
                </el-button>
            </template>
            <div class="emotionList">
                <a href="javascript:void(0);" @click="getEmo(index)" v-for="(item, index) in emoteList" :key="index"
                    class="emotionItem">{{ item }}</a>
            </div>
        </el-popover>
    </div>
</template>
<script setup>
import { emoteData } from '~~/composables/globaldata';

const emits = defineEmits(['changeEmote']);

const emoteList = ref([]);
const emojiItem = ref(null);

const getEmo = (index) => {
    emojiItem.value = index;
    emits('changeEmote',index)
}

onMounted(() => {
    emoteData.forEach(item => {
        emoteList.value.push(item.char);
    })
})
// export default {
//     mounted() {
//         for (let i in appData) {
//             this.faceList.push(appData[i].char);
//         }
//     },
//     data() {
//         return {
//             faceList: [],
//             emojiItem: null,
//         };
//     },
//     methods: {
//         getEmo(index) {
//             this.emojiItem = index;
//             this.$emit("changeText")
//         }
//     }
// }
</script>
<style scoped lang="scss">
.emotionSelect {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.emotionSelect img {
    width: 14px;
    height: 14px;
}

.chatIcon {
    // padding: 0 10px;
    font-size: 25px;
}

.emotionList {
    display: flex;
    flex-wrap: wrap;
    padding: 5px;
}

.emotionItem {
    width: 10%;
    font-size: 20px;
    text-align: center;
}

/*包含以下四种的链接*/
.emotionItem {
    text-decoration: none;
}

/*正常的未被访问过的链接*/
.emotionItem:link {
    text-decoration: none;
}

/*已经访问过的链接*/
.emotionItem:visited {
    text-decoration: none;
}

/*鼠标划过(停留)的链接*/
.emotionItem:hover {
    text-decoration: none;
}

/* 正在点击的链接*/
.emotionItem:active {
    text-decoration: none;
}

.expression {
    display: block;
    width: 30px;
    height: 30px;
    background: url(../assets/images/sprite_2x_v2.png) no-repeat -30px -870px;
    background-size: 120px auto;
    &:hover {
        background-position: -30px -840px;
    }
}

</style>