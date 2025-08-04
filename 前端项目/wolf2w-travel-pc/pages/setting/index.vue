<template>
  <div class="setting">
    <div class="userinfo-editor-box">
        <div class="editor-content-box" v-if="userInfo">          
          <div class="editor-list">
            <client-only>
              <el-form :model="userInfo" label-width="120px">
                <el-form-item label="名号">
                  <el-input v-model="userInfo.nickname" minlength="3" maxlength="15" />
                </el-form-item>            
              
                <el-form-item label="性别">
                  <el-radio-group v-model="sex">
                    <el-radio label="男" />
                    <el-radio label="女" />
                    <el-radio label="保密" />
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="居住城市">
                  <el-input v-model="userInfo.city" maxlength="15" />
                </el-form-item> 
                <el-form-item label="出生日期">
                  <el-date-picker v-model="userInfo.birthday" type="date" placeholder="请选择" style="width: 100%" value-format="YYYY-MM-DD" />
                </el-form-item> 

                <el-form-item label="个人简介">
                  <el-input 
                  class="profile-input" 
                  v-model="userInfo.info" 
                  type="textarea" 
                  placeholder="年轻的旅行是一辈子的财富..."
                  :rows="5"
                  resize="none"
                  />
                </el-form-item>
              </el-form>
            </client-only>

              <div class="submit-btn">
                <el-button type="primary" @click="onSubmit">保存</el-button>
              </div>
          </div>          
          
        </div>
      </div>
  </div>
</template>

<script setup lang="ts">
import {modifyUser} from '@/composables/api/setting'
import { ElMessage } from 'element-plus';
definePageMeta({
    layout:'setting'
});

const userInfo=reactive({
  nickname:'',
  city:'',
  info:'',
  gender:0,
  birthday:''
});

const sex=ref('男');

const onSubmit=()=>{
  //console.log(userInfo);
  switch(sex.value){
    case '男':
    userInfo.gender=1;
    break;
    case '女':
    userInfo.gender=2;
    break;
    case '保密':
    userInfo.gender=0;
    break;
  }
  
  modifyUser(userInfo).then((res)=>{
    //console.log(res); 
    ElMessage.success('修改用户成功');   
  })
}
onMounted(()=>{
    const info=JSON.parse(localStorage.getItem('userInfo'));
    //console.log(userInfo.value);
    userInfo.nickname=info.nickname;
    userInfo.birthday=info.birthday;
    userInfo.info=info.info;    
    userInfo.gender=info.gender;
    userInfo.city=info.city;

    if(info.gender==1){
      sex.value='男';
    }else if(info.gender==2){
      sex.value='女'
    }else{
      sex.value='保密'
    }
})
</script>

<style scoped lang="scss">
.setting{
    width: 740px;
}

.editor-list{
    width: 490px;

    .el-input{
        width: 220px;
        // height: 30px;
    }

    .submit-btn{
      width: 110px;
      height: 35px;
      margin: 10px auto;
    }

    .submit-btn>.el-button{
      width: 100%;
      height: 100%;
    }
}


</style>