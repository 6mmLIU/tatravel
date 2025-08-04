<template>
    <div class="main-container">
      <div class="wrapper">
        <div class="qt-container clearfix">
          <!-- 提问主要内容 -->
          <div class="qt-main">
            <!-- 面包屑导航 -->
            <div class="crumb"><a href="/questions">旅游问答</a> &gt; <span>我要提问</span></div>
  
            <!-- 问题标题 -->
            <div class="qt-tit">
              <h5>问题标题</h5>
              <div class="qt-con">
                <input v-model="formState.title" type="text" placeholder="标题不小于10字哦" class="_j_title" />
                <span class="count"><span class="_j_title_num">0</span>/80 字</span>
                <span class="_j_min_num hide">10</span>
                <span class="error err-tips _j_title_error hide"></span>
              </div>
            </div>
  
            <!-- 问题详细内容 -->
            <div id="_qa_detail" class="qt-details">
              <h5><a id="_j_show_content" title="添加问答内容" class="icon"></a>问题详细内容</h5>
              <ClientOnly><TEditor ref="editor" v-model="formState.contents" v-if="TeditorStatus" /></ClientOnly>
            </div>
  
            <!-- 选择目的地 -->
            <div id="_qa_mdd" class="qt-mdd _qa_block">
              <h5>选择目的地</h5>
              <div id="_qa_select_mdds" class="qt-con _qa_select">
                <input ref="destname" type="text" v-model="curDesData.destName" placeholder="" class="_j_mdd" @focus="setSelectDestinationShow(true)" @keyup="searchDest"/>
                <ul class="mdds_search_list _j_mdd_option _qa_mdds_search_list hide"></ul>
                <div class="qt-mdd-option _j_mdd_list_div" :style="{display:isDestination?'block':'none'}">
                  <div class="tabs">
                    <ul class="_j_mdd_tap_ul">
                      <li class="_j_mdd_tap" :class="curDesData.typeNum==1?'on':''" data-id="_qa_hot" @click="getCurDesList('热门',1)"><a>热门</a></li>
                      <li class="_j_mdd_tap" :class="curDesData.typeNum==2?'on':''" data-id="_qa_china" @click="getCurDesList('国内',2)"><a>国内</a></li>
                      <li class="_j_mdd_tap" :class="curDesData.typeNum==3?'on':''" data-id="_qa_international" @click="getCurDesList('国际',3)"><a>国际</a></li>
                    </ul>
                    <div class="location hide _qa_mddselect_position" style="display: none"><a data-id=""></a><span>&gt;</span><a data-id=""></a><span>&gt;</span><span class="_qa_loc3"></span></div>
                  </div>
  
                  <div style="position: relative; height: 170px">
                    <div id="_qa_select_mdds_list" class="qt-place" style="position: relative; overflow-y: hidden">
                      <h6>{{curDesData.desTitle}}</h6>
                      <div class="qt-place-item">
                        <el-scrollbar height="148px">
                          <ul class="clearfix">
                            <li v-for="(desItem,i) in curDesData.curDesList" :key="desItem.id" @click="selectDestination(desItem)"><a data-areaid="17341" class="dest-name">{{desItem.name}}</a></li>                       
                          </ul>
                      </el-scrollbar>
                      </div>
                    </div>
                    <div style="position: absolute; top: 0px; right: 0px; padding: 1px; opacity: 0; display: none; height: 106.25px"><div style="width: 5px; height: 100%; background: #ccc; border-radius: 10px"></div></div>
                  </div>
  
                  <div class="ajax_loading hide _qa_ajax_loading">
                    <i class="i1"></i>
                    <i class="i2"></i>
                    <i class="i3"></i>
                  </div>
                  <button class="close-btn" @click="hideDestPanel">x</button>
                </div>
                <!-- 搜索输入框 -->
                <div class="dest-search-box" :style="{display:displayPanel}">
                  <el-scrollbar height="230px">
                    <ul>
                      <li v-for="(desItem,i) in curDesData.searchList" :key="desItem.id" @click="searchSelectDestination(desItem)"><a data-areaid="17341">{{desItem.name}}</a></li>
                    </ul>
                  </el-scrollbar>
                  <button class="close-btn" @click="displayPanel='none'">x</button>
                </div>
                <div class="qt-error"><span class="_j_mdd_error">请选择目的地！</span></div>
              </div>
            </div>
  
            <div id="_qa_interest" class="qt-interest _qa_block">
              <h5>选择兴趣标签</h5>
              <div class="qt-con _j_interest_list">
                <dl class="interest-description">
                  <dt><i></i><span>什么是兴趣标签</span></dt>
                  <dd>兴趣标签是一个问题的类型，它有助于为你的问题匹配擅长该类问题的蜂蜂回答。目前仅开放了以下几个话题，更多类型我们会逐步开放。</dd>
                </dl>
                <div class="interest-tags"></div>
              </div>
            </div>
  
            <!-- 通知 -->
            <!-- <div class="qt-notice">
              <div class="checkbox _j_anonymous"></div>
              <p>匿名提问（其他用户将不会在你的窝里看到这个问题）</p>
            </div>-->
            <div id="_qa_notice" class="qt-notice _qa_block"  >
              <div class="checkbox _j_mobile" :class="isdraft?'active':''" @click="isdraft=!isdraft"></div>
              <p>存为草稿</p>
            </div> 
  
            <!-- 发布按钮 -->
            <div class="publish_question">
              <a class="qt-post-btn _j_publish" title="发布问题" @click="publishQuestion">{{isdraft?'存为草稿':'发布问题'}}</a>
            </div>
          </div>
  
          <!-- 提问侧边栏 -->
          <div class="qt-sider">
            <div class="qts-tit">提问的正确姿势</div>
            <div class="qts-con">
              <p>1.问题要【具体】【真实】【诚恳】，问题较多，需全面阐述时，可以添加问题补充。结伴/交易/与旅行无关的提问将被删除。</p>
              <p>2.给问题添加目的地，并打上正确的标签将有助于更快地获得回答。</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  <script setup lang="ts">
  import { getDraftDetail, updateQuestion,getAnswerDestList } from '@/composables/api/questions'
  import { ElMessage } from 'element-plus'
  
  // import { fa } from 'element-plus/es/locale';
  const formState = reactive({ title: '', contents: '',isDraft:0,destId:0 })
  const router=useRouter();
  const route=useRoute();
  //是否显示目的地面板
  const isDestination=ref(false);
  //用于切换目的列表显示
  const curDesData=reactive({
    desTitle:'热门',
    curDesList:[],
    typeNum:1,
    destName:'',
    searchList:[]
  })
  
  const displayPanel=ref('none');
  
  const isdraft=ref(false);
  const TeditorStatus=ref(false);

  const detailData=ref(null);
  // const getContent = (v: string) => {
  //   formState.contents = v
  // }
  function publishQuestion() {
    formState.isDraft=isdraft.value?1:0;
    const body={
      id:detailData.value.id,
      title:formState.title,
      detailDoubt:formState.contents,
      destId:formState.destId,
      isDraft:formState.isDraft
    }

    updateQuestion(body)
      .then(res => {
        console.log(res)
        ElMessage({
          message: '发布成功',
          type: 'success'
        });
        router.push('/personal/question');
      })
      .catch(err => {
        console.log(err)
      })
  }
  
  onMounted(()=>{
    // getGlobalDestinations().then((res)=>{
    //   console.log(res);
    // });
    setTimeout(() => {
      TeditorStatus.value = true
    }, 200)
  
    nextTick(()=>{
    //   if(!localStorage.getItem('token')){
    //     ElMessage.error('请先登录');
    //     navigateTo('/login');
    //   }
      getDetail();
      getCurDesList('热门',1);
    })
  })
  

  const setSelectDestinationShow=(isShow)=>{
    isDestination.value=isShow; 
  }
  //获取当前选择的目的地
  const getCurDesList=(desType,num)=>{
    curDesData.typeNum=num;
    let type=2;
    
    switch(desType){
      case '热门':
      type=2;
      break;
      case '国内':
      type=-1;
      break;
      case '国际':
      type=1;
      break;
    }
  
    getAnswerDestList({type,name:''}).then((res)=>{
        curDesData.curDesList=res.data;
    })
  }
  //选择目的地
  const selectDestination=(destItem)=>{
    if(destItem.children.length==0){
      formState.destId=destItem.id; //配置ID
      curDesData.destName=destItem.name;//配置目的地名字
      setSelectDestinationShow(false);//隐藏面板
    }else{
      curDesData.curDesList=destItem.children;
    }
  }
  
  let timeout;
  const searchDest=(e)=>{
    displayPanel.value='block';
    
    clearTimeout(timeout);
    timeout=setTimeout(()=>{
        if(curDesData.destName!=''){
          getAnswerDestList({type:0,name:curDesData.destName}).then((res)=>{
          console.log(res.data);      
          curDesData.searchList=res.data;
        })
      }
    },200)
  }
  
  const hideDestPanel=()=>{
    setSelectDestinationShow(false);
  }
  
  const searchSelectDestination=(destItem)=>{
      formState.destId=destItem.id; //配置ID
      curDesData.destName=destItem.name;//配置目的地名字
      setSelectDestinationShow(false);//隐藏面板
      displayPanel.value='none'
  }

  //获取详情数据
function getDetail(){
  //console.log('id='+route.params.id);
  
  getDraftDetail(route.params.id).then((res)=>{
    console.log(res);
    
    detailData.value=res.data; 
    //console.log(detailData.value);
    formState.title=detailData.value.title;
    formState.contents=detailData.value.answerContent?detailData.value.answerContent:'';
    formState.destId=detailData.value.destId;

    curDesData.destName=detailData.value.destinationName;
    //console.log(res.data);
    //getQuestionFollow();
  })
}

  </script>
  <style lang="scss" scoped>
  .main-container {
    position: relative;
    .wrapper {
      font-size: 14px;
      line-height: 24px;
      color: #666; 
      .qt-container {
        width: 1000px;
        margin: 0 auto;
        padding-bottom: 80px;
        .qt-main {
          width: 660px;
          float: left;
          h5 {
            height: 30px;
            font-size: 16px;
            font-weight: normal;
            line-height: 30px;
            color: #333;
          }
          .crumb {
            height: 24px;
            padding: 25px 0 27px;
            a {
              background-color: transparent;
              text-decoration: none;
              color: #192885;
              cursor: pointer;
            }
          }
          .qt-tit {
            margin-bottom: 24px;
            input {
              display: block;
              width: 628px;
              height: 30px;
              padding: 6px 15px;
              border: 1px solid #e5e5e5;
              color: #999;
              margin-top: 8px;
              margin-bottom: 4px;
              font-size: 14px;
              -webkit-transition: all 0.2s;
              transition: all 0.2s;
            }
            .count {
              padding-right: 12px;
              color: #999;
            }
            .error {
              font-size: 12px;
              color: #ef523d;
            }
          }
          .qt-details {
            margin-bottom: 24px;
            h5 .icon {
              display: block;
              float: left;
              width: 28px;
              height: 28px;
              margin: 1px 10px 0 0;
              background-position: 0 0;
              transition: transform 0.5s;
              background: url(../../../assets/images/mfwask-qt-2x_v2.png) no-repeat;
              background-size: 28px;
              &.active {
                transform: rotate3d(0, 0, 1, 45deg);
                background-position: 0 -28px;
              }
            }
          }
          .qt-mdd {
            .qt-con {
              width: 100%;
              height: 34px;
              margin-top: 8px;
              margin-bottom: 30px;
              position: relative;
              input {
                display: block;
                width: 618px;
                height: 32px;
                padding: 0 20px;
                border: 1px solid #e5e5e5;
                color: #999;
                font-size: 14px;
                z-index: 6;
                -webkit-transition: all 0.2s;
                transition: all 0.2s;
              }
              .mdds_search_list {
                position: absolute;
                left: 0;
                right: 0;
                top: 33px;
                max-height: 255px;
                z-index: 10;
                border: 1px solid #e5e5e5;
                background-color: #fff;
                overflow-y: auto;
              }
              .dest-search-box{
                width: 638px;
                padding: 10px;
                border: 1px solid #e5e5e5;
                background-color: #fff;
                box-shadow: 1px 1px 2px #e5e5e5;
                position: absolute;
                left: 0;
                top: 33px;
                z-index: 12;
                // position: relative;
              }
  
              .close-btn{
                position: absolute;
                top: 10px;
                right: 10px;
                outline: none;
                border: 0;
                background-color: #fff;
              }
              .qt-mdd-option {
                width: 638px;
                padding: 10px;
                border: 1px solid #e5e5e5;
                background-color: #fff;
                box-shadow: 1px 1px 2px #e5e5e5;
                position: absolute;
                left: 0;
                top: 33px;
                z-index: 12;
                display: none;
                // position: relative;
                .tabs {
                  height: 34px;
                  margin-bottom: 15px;
                  line-height: 34px;
                  ul {
                    float: left;
                    li {
                      float: left;
                      width: 66px;
                      margin-right: 12px;
                      text-align: center;
                      &.on {
                        a {
                          background-color: #ffa800;
                          text-decoration: none;
                        }
                      }
                      a {
                        display: block;
                        background-color: #999;
                        border-radius: 2px;
                        font-size: 16px;
                        color: #fff;
                      }
                    }
                  }
                  .location {
                    color: #999;
                    a {
                      color: #999;
                    }
                    span {
                      padding: 0 8px;
                    }
                    ._qa_loc3 {
                      padding: 0;
                    }
                  }
                }
                .qt-place {
                  width: 100%;
                  position: relative;
                  height: 170px;
                  li {
                    float: left;
                    width: 124px;
                    height: 24px;
                    display: inline;
                    margin-bottom: 10px;
                    line-height: 24px;
                    a {
                      display: block;
                      padding: 0 10px;
                      color: #999;
                      overflow: hidden;
                      text-overflow: ellipsis;
                      white-space: nowrap;
                      &:hover {
                        outline: 0;
                        text-decoration: underline;
                      }
                    }
                  }
                }
              }
  
              .qt-error {
                height: 32px;
                font-size: 12px;
                line-height: 32px;
                color: #ef523d;
                span {
                  display: none;
                }
              }
            }
          }
          .qt-interest {
            margin-bottom: 32px;
            .interest-description {
              margin-top: 14px;
              padding: 20px;
              background-color: #f6f6f6;
              border-radius: 4px;
              font-size: 12px;
              dt {
                color: #333;
                i {
                  display: inline-block;
                  vertical-align: middle;
                  width: 16px;
                  height: 16px;
                  background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAANlBMVEWZmZmZmZmVlZWYmJiZmZmZmZmSkpJHcEyZmZmWlpb////t7e2fn5+tra329vbf39/Nzc26uroeXXK6AAAACnRSTlP/iQxXyJoHAOsh4/UatgAAAPRJREFUOMuNU1sChCAIpEwTzUf3v+ySKVK5285PKaMzIMDKmJVeLIBdtJr7LrQf1BRssBpvBDPBDZORBFzggQU7AS0MYLERxvHKIILh+7fso4spsIopBPYXojuR2elBQD5P8ZiSJ8be9pAIui2yc/74JudS29MrzOyQjhb1QBexzxkUmyaFrUiRBm8qYAUI4bS/V6lTAx41PHLJvZ5gB3G/9WLB7/gTXuQ4umMXKdbw1WSWBk+TWi7ptfx+IWhRqCGUKHXx4Ptj11KvUuOo8iUJLZ+7Erwk4KVhShZRSky3lns0tvmvad/b/n1w3kfvfXi/j/8HDCUMVKzDAWoAAAAASUVORK5CYII=)
                    0 0 no-repeat;
                  margin-right: 4px;
                  background-size: 100%;
                }
                span {
                  display: inline-block;
                  vertical-align: middle;
                }
              }
              dd {
                line-height: 18px;
                color: #999;
                margin-top: 8px;
              }
            }
            .interest-tags {
              margin-top: 20px;
            }
          }
          .qt-notice {
            height: 24px;
            margin-bottom: 4px;
            .checkbox {
              display: block;
              float: left;
              width: 14px;
              height: 14px;
              border-radius: 3px;
              border: 1px solid #192885;
              margin-top: 4px;
              margin-right: 8px;
              cursor: pointer;
              &.active {
                background: #192885 url(../../../assets/images/gou.png) 0 -14px no-repeat;
                background-size: 14px auto;
              }
            }
            p {
              color: #999;
            }
          }
          .qt-post-btn {
            display: inline-block;
            width: 152px;
            height: 40px;
            background-color: #192885;
            border-radius: 4px;
            font-size: 16px;
            color: #fff;
            text-align: center;
            line-height: 40px;
            margin-top: 16px;
            &:hover {
              background-color: #ff8a00;
              color: #fff;
              text-decoration: none;
            }
          }
        }
        .qt-sider {
          width: 252px;
          padding-top: 82px;
          padding-right: 28px;
          float: right;
          .qts-tit {
            font-size: 18px;
            line-height: 30px;
            margin-bottom: 20px;
          }
          p {
            margin-bottom: 24px;
            color: #999;
          }
        }
      }
    }
    .hide {
      display: none;
    }
  
    ._j_mdd{
      outline: none;
    }
  }
  </style>
  