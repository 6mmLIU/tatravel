<template>
  <div class="login-container">
    <div class="login-box">
      <div class="account-box clearfix">
        <div class="account-box-left">
          <div class="account-tabs clearfix">
            <div class="account-tab-item" :class="{ active: tabIndex === 1 }" @click="changeTab(1)">扫码登录</div>
            <div class="account-tab-item" :class="{ active: tabIndex === 2 }" @click="changeTab(2)">密码登录</div>
          </div>
          <div class="tab-content">
            <div v-show="tabIndex === 1" class="tab-content-item">
              <div class="qrcode-container">
                <p class="qrcode-tip">
                  打开
                  <a class="qrcode_tip_high" href="https://www.mafengwo.cn/app/intro/gonglve.php" target="_blank">带TA游APP</a>
                  -V9.3.38及以上版本扫描二维码，<br />免输入，更快更安全。
                </p>
                <div class="qrcode-photo">
                  <img src="https://p1-q.mafengwo.net/s19/M00/7E/20/CoNHgWMEbvYimjenAAAECmzrv3I.png?imageMogr2%2Fthumbnail%2F%21150x150r%2Fquality%2F90" alt="" />
                </div>
              </div>
            </div>
            <div v-show="tabIndex === 2" class="tab-content-item">
              <div class="account-form">
                <el-form ref="formRef" :model="form" class="form" :rules="rules" label-width="0px" :inline="false" size="normal">
                  <el-form-item prop="username">
                    <el-input v-model.trim="form.username" size="large" placeholder="您的手机号"></el-input>
                  </el-form-item>
                  <el-form-item prop="password">
                    <el-input v-model.trim="form.password" size="large" type="password" placeholder="请输入登录密码"></el-input>
                  </el-form-item>
                  <el-form-item prop="webVerifyCode">
                    <div class="verify-code">
                      <el-input v-model.trim="form.code" size="large" placeholder="请输入验证码"></el-input>
                      <img class="code-img" :src="'data:image/jpeg;base64,'+verifyCodeObj.img" @click="getCodeImg()" />
                    </div>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" size="large" style="width: 100%" @click="onSubmit(formRef)">登录</el-button>
                  </el-form-item>
                </el-form>
              </div>
            </div>
          </div>
        </div>
        <div class="account-box-right">
          <a class="download" href="javascript:;"></a>
        </div>
      </div>
      <div class="bottom-link">还没有账号?<a href="/register">马上注册</a></div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { getCurrentInstance } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { login,getVerifyCode } from '@/composables/api/login'

//import {getVerCode} from '@/composables/api/note'
const { $message } = getCurrentInstance().appContext.config.globalProperties
const router = useRouter()

definePageMeta({
  layout: false
})

const uuid = ref()

onMounted(() => {
  document.body.style.margin='0';
  nextTick(() => {
    getCodeImg();
  })
})

const tabIndex = ref(2)
const form = reactive({
  username: '13700000000',
  password: '111111',
  code: null,
  type:'PC',
  uuid: null
})

const verifyCodeObj=reactive({
  img:'',
  uuid:''
})

const rules = reactive<FormRules>({
  username: [{ required: true, message: '请输入账号名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码，4-16位', min: 4, max: 16, trigger: 'blur' }],
  code: [{ required: true, message: '请输入验证码', trigger: 'blur' }]
})

const formRef = ref<FormInstance>()
const onSubmit = async function (formEl: FormInstance | undefined) {
  formEl.validate(async valid => {
    if (valid) {
      try {
        //form.uuid = uuid.value
        
        form.uuid=verifyCodeObj.uuid;

        let param = {
           username:form.username,
           password:form.password,
           code:form.code,
           type:form.type,
           uuid:form.uuid

        }
        const res = await login(param)

        localStorage.setItem('token', res.data['access_token']);
        $message.success('登录成功！')
        router.push('/')
      } catch (err) {
        console.log(err)
      }
    } else {
      return false
    }
  })
}
function changeTab(tab: number) {
  tabIndex.value = tab
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
.login-container {
  position: relative;
  width: 100%;
  height: 100%;
  background: url(https://images.mafengwo.net/images/signup/wallpaper/11.jpg) no-repeat center center;
  background-size: cover;
  .login-box {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 650px;
    .account-box {
      width: 650px;
      height: 434px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 3px 3px rgb(0 0 0 / 40%);
      display: flex;
      justify-content: space-between;
      // align-items: center;
      .account-box-left {
        position: relative;
        width: 400px;
        // height: 434px;
        // float: left;
        box-sizing: border-box;
        padding: 20px 40px;
        .account-tabs {
          display: flex;
          padding: 0 40px;
          border-bottom: 1px solid #f6f7f9;
          .account-tab-item {
            flex: 1;
            text-align: center;
            font-size: 18px;
            font-family: PingFangSC-Regular, PingFang SC;
            font-weight: 400;
            color: rgba(113, 115, 118, 1);
            line-height: 25px;
            padding: 40px 0 12px;
            position: relative;
            cursor: pointer;
            &.active:after {
              content: '';
              position: absolute;
              left: 50%;
              bottom: 0;
              margin-left: -25px;
              width: 50px;
              height: 4px;
              background: rgba(255, 149, 0, 1);
              border-radius: 3px;
            }
          }
        }
        .tab-content {
          .tab-content-item {
            .qrcode-container {
              margin-top: 50px;
              .qrcode-tip {
                font-size: 14px;
                font-weight: 500;
                color: #717376;
                line-height: 20px;
                .qrcode-tip-high {
                  color: #4d97ff;
                  cursor: pointer;
                }
              }
              .qrcode-photo {
                margin: 10px auto 0;
                position: relative;
                width: 150px;
                height: 150px;
                img {
                  width: 150px;
                  height: 150px;
                }
              }
            }
            .account-form {
              position: relative;
              display: flex;
              flex-direction: column;
              justify-content: center;
              box-sizing: border-box;
              .form {
                margin-top: 50px;
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
                }
              }
            }
          }
        }
      }
      .account-box-right {
        float: right;
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
