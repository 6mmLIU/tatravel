<template>
  <div class="register-container">
    <div class="register-box">
      <div class="account-box clearfix">
        <div class="account-box-left">
          <div class="account-form">
            <el-form ref="formRef" :model="form" class="form" :rules="rules" label-width="0px" :inline="false" size="normal">
              <el-form-item prop="nickname">
                <el-input v-model.trim="form.nickname" size="large" placeholder="您的昵称"></el-input>
              </el-form-item>
              <el-form-item prop="phone">
                <el-input v-model.trim="form.username" size="large" placeholder="您的手机号"></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input v-model.trim="form.password" size="large" type="password" placeholder="您的密码"></el-input>
              </el-form-item>
              <el-form-item prop="rpassword">
                <el-input v-model.trim="form.rpassword" size="large" type="password" placeholder="确认密码"></el-input>
              </el-form-item>
              <el-form-item prop="webVerifyCode">
                <div class="verify-code">
                  <el-input v-model.trim="form.code" size="large" placeholder="图形验证码"></el-input>
                  <img class="code-img" :src="'data:image/jpeg;base64,'+verifyCodeObj.img" @click="getCodeImg()" />
                </div>
              </el-form-item>
               <el-form-item prop="verifyCode">
                <div class="verify-code">
                  <el-input v-model.trim="form.verifyCode" size="large" placeholder="手机验证码"></el-input>
                  <div class="send-code" @click="getSetInterval()">{{ isShowSend ? '发送验证码' : timeNum + 'S' }}</div>
                </div>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" size="large" style="width: 100%" @click="onSubmit(formRef)">立即注册</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
        <div class="account-box-right">
          <a class="download" href="https://www.mafengwo.cn/app/intro/gonglve.php" target="_blank"></a>
        </div>
      </div>
      <div class="bottom-link">已经注册?<a href="/login">马上登录</a></div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { getCurrentInstance } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { register, sendVerifyCode } from '@/composables/api/register'
import {getVerifyCode} from '@/composables/api/login'
const { $message } = getCurrentInstance().appContext.config.globalProperties
const router = useRouter()

definePageMeta({
  layout: false
})

const uuid = ref()

onMounted(() => {
  document.body.style.margin = '0';
  nextTick(()=>{
    getCodeImg()
  })
})

const form = reactive({
  nickname: null,
  username: null,
  code: null,
  verifyCode: null,
  password: null,
  rpassword: null,
  uuid: null,
  type:'PC'
})

const verifyCodeObj=reactive({
  img:'',
  uuid:''
})

const rules = reactive<FormRules>({
  nickname: [{ required: true, message: '请输入昵称', trigger: 'blur' }],
  username: [{ required: true, message: '请输入手机号', trigger: 'blur' }],
  code: [{ required: true, message: '请输入验证码', trigger: 'blur' }],
  verifyCode: [{ required: true, message: '请输入验证码', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码，5-16位', min: 5, max: 16, trigger: 'blur' }],
  rpassword: [{ required: true, message: '请输入密码，5-16位', min: 5, max: 16, trigger: 'blur' }]
})

const formRef = ref<FormInstance>()
const onSubmit = function (formEl: FormInstance | undefined) {
  formEl.validate(async valid => {
    if (valid) {
      try {
        form.uuid = verifyCodeObj.uuid


        let param = {
          nickname: form.nickname,
          username: form.username,
          code: form.code,
          verifyCode: form.verifyCode,
          password: form.password,
          rpassword: form.rpassword,
          uuid: form.uuid ,
          type:'PC'
        };


        await register(param)
        $message.success('注册成功！')
        router.push('/login')
      } catch (e) {
        console.log(e)
      }
    } else {
      return false
    }
  })
}

const timeNum = ref(10)
const countDown = ref()
const isShowSend = ref(true)

async function getSetInterval() {
  if (isShowSend.value) {
    isShowSend.value = false
    const res= await sendVerifyCode({ phone: form.username })

    countDown.value = setInterval(() => {
      setTimeout(() => {
        if (timeNum.value > 1 && timeNum.value <= 10) {
          timeNum.value--
        } else {
          isShowSend.value = true
          clearInterval(countDown.value)
          countDown.value = null
          timeNum.value = 10
        }
      }, 0)
    }, 1000)
  }
}
function getCodeImg() {
  uuid.value = random()

  getVerifyCode({uuid:uuid.value}).then((res)=>{
    verifyCodeObj.img=res.data.img
    verifyCodeObj.uuid=res.data.uuid
  })
}
function random() {
  let Num = ''
  for (var i = 0; i < 6; i++) {
    Num += Math.floor(Math.random() * 10)
  }
  return Num
}
</script>
<style lang="scss" scoped>
.register-container {
  position: relative;
  width: 100%;
  height: 100%;
  background: url(https://images.mafengwo.net/images/signup/wallpaper/11.jpg) no-repeat center center;
  background-size: cover;
  .register-box {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 740px;
    .account-box {
      width: 650px;
      height: 434px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 3px 3px rgb(0 0 0 / 40%);
      display: flex;
      justify-content: space-between;
      align-items: center;
      .account-box-left {
        position: relative;
        width: 400px;
        // height: 434px;
        // float: left;
        box-sizing: border-box;
        padding: 0 40px;
        .account-form {
          position: relative;
          display: flex;
          flex-direction: column;
          justify-content: center;
          box-sizing: border-box;
          .form {
            margin-top: 20px;
            .verify-code {
              display: flex;
              justify-content: space-between;
              width: 100%;
              .code-img {
                box-sizing: border-box;
                width: 80px;
                height: 40px;
                margin-left: 20px;
                border: 1px solid #f2a644;
                object-fit: cover;
                vertical-align: top;
                border-radius: 5px;
                cursor: pointer;
              }
              .send-code {
                height: 40px;
                width: 145px;
                margin-left: 20px;
                line-height: 40px;
                text-align: center;
                cursor: pointer;
                background-color: #f2a644;
                border: none;
                border-radius: 5px;
                box-sizing: border-box;
                color: #fff;
              }
            }
          }
        }
      }
      .account-box-right {
        // float: right;
        width: 200px;
        height: 434px;
        box-sizing: border-box;
        background: url(../../assets/images/logo_v.png) no-repeat center;
        background-size: 80%;
        border-radius: 0 8px 8px 0;
        position: relative;
        .download {
          position: absolute;
          bottom: 15px;
          right: 12px;
          width: 30px;
          height: 30px;
          cursor: pointer;
        }
      }
    }
    .bottom-link {
      width: 140px;
      margin: 10px auto;
      background-color: #000;
      border-radius: 15px;
      background-color: rgba(0, 0, 0, 0.4);
      text-align: center;
      font-size: 12px;
      color: #fff;
      padding: 4px 0;
      text-shadow: 1px 1px 1px rgb(0 0 0 / 40%);
      a {
        color: #ffa800;
        margin-left: 6px;
      }
    }
  }
}
</style>
