<template>
  <div class="setting-avatar">
    <div v-if="userInfo">
      <div class="avatar-img-box">
        <img :src="userInfo.headImgUrl" alt="" width="120" height="120">
      </div>
      <el-upload
        ref="upload"
        class="upload-demo"
        action="/api/file/upload"
        :show-file-list="false"
        :on-success="headSuccess"
        :limit="1"
      >
        <template #trigger>
          <el-button type="primary" class="upload-btn">上传头像</el-button>
          <span class="upload-des">支持jpg、png、jpeg、bmp，图片大小5M以内</span>
        </template>
      </el-upload>
    </div>
  </div>
</template>

<script setup lang="ts">
import {modifyUser} from '@/composables/api/setting'
import { ElMessage } from 'element-plus';
definePageMeta({
    layout:'setting'
})

const userInfo=ref(null);

const headSuccess=(e,file,filelist)=>{
  console.log(e);
  
  if(e.code==200){
    userInfo.value.headImgUrl=e.data.url;

    modifyUser({headImgUrl:e.data.url}).then((res)=>{
      //console.log(res);
      if(res.code==200){
        localStorage.setItem('userInfo',JSON.stringify(res.data));
        ElMessage.success('更新头像成功');
      }
    })
  }  
}


onMounted(()=>{
  userInfo.value=JSON.parse(localStorage.getItem('userInfo'));
  console.log(userInfo.value);
  
})
</script>

<style scoped lang="scss">
.avatar-img-box{
  background-color: #c0c4cc;
  margin-bottom: 20px;
  width: 120px;
  height: 120px;
}

.upload-btn{
  height: 35px;
  outline: none;
  border: 0;
  margin-right: 10px;

  &:hover{            
    background-color: #ff8a00 !important;
  }
}
</style>