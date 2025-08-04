<template>
  <div class="blog-container">
    <div class="blog-left">
      <el-tabs v-model="tabActive" class="blog-tabs" @tab-change="tabClick">
        <el-tab-pane label="最新游记" name="first">
          <div class="newest-header">
            <ClientOnly>
              <el-form :inline="true" :model="newestForm" size="small">
                <el-form-item label="出发时间" class="form-item">
                  <el-select v-model="newestForm.travelTimeType" placeholder="请选择">
                    <el-option label="不限" value="-1" />
                    <el-option label="1-2月" value="1" />
                    <el-option label="3-4月" value="2" />
                    <el-option label="5-6月" value="3" />
                    <el-option label="7-8月" value="4" />
                    <el-option label="9-10月" value="5" />
                    <el-option label="11-12月" value="6" />
                  </el-select>
                </el-form-item>
                <el-form-item label="人均花费" class="form-item">
                  <el-select v-model="newestForm.consumeType" placeholder="请选择">
                    <el-option label="不限" value="-1" />
                    <el-option label="1-999" value="1" />
                    <el-option label="1K-6K" value="2" />
                    <el-option label="6K-20K" value="3" />
                    <el-option label="20K以上" value="4" />
                  </el-select>
                </el-form-item>
                <el-form-item label="出行天数" class="form-item">
                  <el-select v-model="newestForm.dayType" placeholder="请选择">
                    <el-option label="不限" value="-1" />
                    <el-option label="3天以下" value="1" />
                    <el-option label="4-7天" value="2" />
                    <el-option label="8-14天" value="3" />
                    <el-option label="15天以上" value="4" />
                  </el-select>
                </el-form-item>
              </el-form>
            </ClientOnly>
            <div class="tn-write">
              <NuxtLink to="/note/form" class="btn-add"><i></i>写游记</NuxtLink>
            </div>
          </div>
          <div class="travelnotes-list">
            <NuxtLink v-for="item in newBlogList" :key="item.id" :to="'/note/details/' + item.id" target="_blank"
              class="travelnotes-item">
              <img class="travelnotes-item-img" :src="item.coverUrl" />
              <div class="travelnotes-info">
                <h3 class="travelnotes-info-title">{{ item.title }}</h3>
                <p class="travelnotes-info-desc">{{ item.summary }}</p>
                <div class="travelnotes-extra">
                  <div class="travelnotes-extra-left">
                    <div class="travelnotes-extra-place">
                      <i></i>
                      {{ item.destName }}，by
                    </div>
                    <div class="travelnotes-extra-user">
                      <img v-if="item.author" :src="item.author.headImgUrl" />
                      <img v-else src="" alt="" />
                      {{ item.author == null ? ' ' : item.author.nickname }}
                    </div>
                    <div class="travelnotes-extra-nums">
                      <i></i>
                      {{ item.viewnum }}/{{ item.favornum ? item.favornum : 0 }}
                    </div>
                  </div>
                  <div class="travelnotes-extra-right">
                    <div class="travelnotes-extra-ding">
                      {{ item.thumbsupnum }}
                      <i class="ding-btn"></i>
                    </div>
                  </div>
                </div>
              </div>
            </NuxtLink>
          </div>
          <div v-if="newBlogList.length > 0" class="page-container">
            <el-pagination class="page" background layout="total, prev, pager, next" :total="newBlogTotal"
              @current-change="firstChangeHandle" />
          </div>
        </el-tab-pane>
        <el-tab-pane label="最热游记" name="second">
          <div class="newest-header">
            <ClientOnly>
              <el-form :inline="true" :model="hottestForm" size="small">
                <el-form-item label="出发时间" class="form-item">
                  <el-select v-model="hottestForm.travelTimeType" placeholder="请选择">
                    <el-option label="不限" value="-1" />
                    <el-option label="1-2月" value="1" />
                    <el-option label="3-4月" value="2" />
                    <el-option label="5-6月" value="3" />
                    <el-option label="7-8月" value="4" />
                    <el-option label="9-10月" value="5" />
                    <el-option label="11-12月" value="6" />
                  </el-select>
                </el-form-item>
                <el-form-item label="人均花费" class="form-item">
                  <el-select v-model="hottestForm.consumeType" placeholder="请选择">
                    <el-option label="不限" value="-1" />
                    <el-option label="1-999" value="1" />
                    <el-option label="1K-6K" value="2" />
                    <el-option label="6K-20K" value="3" />
                    <el-option label="20K以上" value="4" />
                  </el-select>
                </el-form-item>
                <el-form-item label="出行天数" class="form-item">
                  <el-select v-model="hottestForm.dayType" placeholder="请选择">
                    <el-option label="不限" value="-1" />
                    <el-option label="3天以下" value="1" />
                    <el-option label="4-7天" value="2" />
                    <el-option label="8-14天" value="3" />
                    <el-option label="15天以上" value="4" />
                  </el-select>
                </el-form-item>
              </el-form>
            </ClientOnly>
            <div class="tn-write">
              <NuxtLink to="/note/form" class="btn-add"><i></i>写游记</NuxtLink>
            </div>
          </div>
          <div class="travelnotes-list">
            <NuxtLink v-for="item in hotBlogList" :key="item.id" :to="'/note/details/' + item.id" target="_blank"
              class="travelnotes-item">
              <img class="travelnotes-item-img" :src="item.coverUrl" />
              <div class="travelnotes-info">
                <h3 class="travelnotes-info-title">{{ item.title }}</h3>
                <p class="travelnotes-info-desc">{{ item.summary }}</p>
                <div class="travelnotes-extra">
                  <div class="travelnotes-extra-left">
                    <div class="travelnotes-extra-place">
                      <i></i>
                      {{ item.destName }}，by
                    </div>
                    <div class="travelnotes-extra-user">
                      <img v-if="item.author" :src="item.author.headImgUrl" />
                      <img v-else src="" alt="" />
                      {{ item.author == null ? ' ' : item.author.nickname }}
                    </div>
                    <div class="travelnotes-extra-nums">
                      <i></i>
                      {{ item.viewnum }}/{{ item.favornum ? item.favornum : 0 }}
                    </div>
                  </div>
                  <div class="travelnotes-extra-right">
                    <div class="travelnotes-extra-ding">
                      {{ item.thumbsupnum }}
                      <i class="ding-btn"></i>
                    </div>
                  </div>
                </div>
              </div>
            </NuxtLink>
          </div>
          <div v-if="hotBlogList.length > 0" class="page-container">
            <el-pagination class="page" background layout="total, prev, pager, next" :total="hotBlogTotal"
              @current-change="secondChangeHandle" />
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="blog-right">
      <div class="dynamic-container">
        <div class="dynamic-header">
          <i></i>
          <h2>旅游攻略</h2>
        </div>
        <ul class="strategy-list">
          <li class="strategy-item">
            <em class="strategy-num">1</em>
            <p class="strategy-place">北海道</p>
            <p class="strategy-desc">在皑皑白雪中泡温泉在皑皑白雪中泡温泉</p>
          </li>
          <li class="strategy-item">
            <em class="strategy-num">2</em>
            <p class="strategy-place">北海道</p>
            <p class="strategy-desc">在皑皑白雪中泡温泉在皑皑白雪中泡温泉</p>
          </li>
          <li class="strategy-item">
            <em class="strategy-num">3</em>
            <p class="strategy-place">北海道</p>
            <p class="strategy-desc">在皑皑白雪中泡温泉在皑皑白雪中泡温泉</p>
          </li>
          <li class="strategy-item">
            <em class="strategy-num">4</em>
            <p class="strategy-place">北海道</p>
            <p class="strategy-desc">在皑皑白雪中泡温泉在皑皑白雪中泡温泉</p>
          </li>
          <li class="strategy-item">
            <em class="strategy-num">5</em>
            <p class="strategy-place">北海道</p>
            <p class="strategy-desc">在皑皑白雪中泡温泉在皑皑白雪中泡温泉</p>
          </li>
        </ul>
      </div>
      <div class="dynamic-container">
        <div class="dynamic-header">
          <i></i>
          <h2>最新游记动态</h2>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { watch } from 'vue'
import type { TabsPaneContext } from 'element-plus'
import { getTravelsQuery } from '../../composables/api/note'

const tabActive = ref('first') // tab选中值
let newBlogList = ref([]) //最新日志列表
const hotBlogList = ref([]) //最新日志列表
const newBlogTotal = ref(0)
const hotBlogTotal = ref(0)

const newestForm = reactive({
  orderBy: 'viewnum',
  travelTimeType: '-1',
  consumeType: '-1',
  dayType: '-1',
  currentPage: 1,
  orderType: 1
})

const hottestForm = reactive({
  orderBy: 'create_time',
  travelTimeType: '-1',
  consumeType: '-1',
  dayType: '-1',
  currentPage: 1,
  orderType: 2
})

// tab切换
function tabClick(tabname) {
  switch (tabname) {
    case "first":
      getNewList();
      break;
    case "second":
      getHotList();
      break;
  }
}
//获取最新游记
const getNewList = async () => {
  const res = await getTravelsQuery(newestForm)
  newBlogList.value = res.data.records
  //console.log(newBlogList.value)

  newBlogTotal.value = res.data.total
}
watch(
  () => newestForm,
  () => {
    nextTick(() => {
      getNewList()
    })
  },
  {
    immediate: true,
    deep: true
  }
)
//获取最热游记
const getHotList = async () => {
  const res = await getTravelsQuery(hottestForm)
  hotBlogList.value = res.data.records
  hotBlogTotal.value = res.data.total
}
watch(
  () => hottestForm,
  () => {
    nextTick(() => {
      getHotList()
    })
  },
  {
    immediate: true,
    deep: true
  }
)
const firstChangeHandle = event => {
  newestForm.currentPage = event
}
const secondChangeHandle = event => {
  hottestForm.currentPage = event
}


onMounted(() => {
  nextTick(() => {
    getNewList();
  });
})
</script>

<style lang="scss" scoped>
.blog-container {
  position: relative;
  display: flex;
  justify-content: space-between;
  width: 1100px;
  margin: 0 auto;
  padding-top: 20px;

  .blog-left {
    flex: 0 0 720px;

    .form-item {
      width: 160px;
      margin-right: 5px;
    }

    .newest-header {
      position: relative;

      .tn-write {
        position: absolute;
        top: 0px;
        right: 0px;
        cursor: pointer;

        .btn-add {
          display: inline-block;
          width: 140px;
          height: 36px;
          line-height: 36px;
          background-color: #192885;
          font-size: 16px;
          color: #fff;
          text-align: center;
          border-radius: 4px;

          i {
            display: inline-block;
            margin-right: 5px;
            width: 18px;
            height: 17px;
            background-position: 0 0;
            overflow: hidden;
            vertical-align: -3px;
            background-image: url(../../_nuxt/assets/images/index-sprites8-v2@2x.png);
            background-size: 200px;
          }
        }
      }
    }

    .travelnotes-list {
      .travelnotes-item {
        display: flex;
        // justify-content: space-between;
        padding: 15px 0px;
        height: 150px;
        cursor: pointer;
        border-bottom: 1px dashed #cecece;

        &:hover {
          .travelnotes-info-title {
            color: #192885 !important;
          }
        }

        .travelnotes-item-img {
          width: 220px;
          height: 150px;
        }

        .travelnotes-info {
          width: 500px;
          height: 150px;
          padding-left: 15px;

          .travelnotes-info-title {
            margin-bottom: 10px;
            font-size: 18px;
            line-height: 26px;
            width: 420px;
            height: 26px;
            display: block;
            color: #333;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }

          .travelnotes-info-desc {
            line-height: 20px;
            font-size: 14px;
            color: #666;
            height: 60px;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
          }

          .travelnotes-extra {
            display: flex;
            align-items: center;
            height: 33px;
            line-height: 33px;
            margin-top: 20px;
            overflow: hidden;
            font-size: 12px;

            .travelnotes-extra-left {
              flex: 1;

              .travelnotes-extra-place {
                display: inline-flex;
                margin-right: 5px;

                i {
                  display: inline-block;
                  margin: 8px 5px 0 0;
                  width: 14px;
                  height: 16px;
                  background-image: url(../_nuxt/assets/images/index-sprites8-v2@2x.png);
                  background-size: 200px;
                  background-position: 0 -50px !important;
                  overflow: hidden;
                }
              }

              .travelnotes-extra-user {
                display: inline-flex;
                align-items: center;
                margin-right: 10px;
                color: #192885;
                cursor: pointer;

                img {
                  margin-right: 5px;
                  width: 16px;
                  height: 16px;
                  overflow: hidden;
                  border-radius: 50%;
                  vertical-align: -3px;
                }
              }

              .travelnotes-extra-nums {
                display: inline-flex;
                font-size: 14px;
                color: #999;

                i {
                  display: inline-block;
                  margin: 10px 5px 0 0;
                  width: 18px;
                  height: 14px;
                  background-image: url(../_nuxt/assets/images/index-sprites8-v2@2x.png);
                  background-size: 200px;
                  background-position: -30px -50px !important;
                }
              }
            }

            .travelnotes-extra-right {
              flex: 0 0 auto;

              .travelnotes-extra-ding {
                display: flex;
                align-items: center;
                color: #192885;
                font-size: 14px;

                .ding-btn {
                  display: inline-block;
                  margin-left: 8px;
                  width: 38px;
                  height: 33px;
                  background-image: url(../_nuxt/assets/images/index-sprites8-v2@2x.png);
                  background-size: 200px;
                  background-position: -60px 0 !important;
                  overflow: hidden;
                }
              }
            }
          }
        }
      }
    }

    .page-container {
      margin-top: 15px;
      text-align: right;

      .page {
        display: inline-flex;
      }
    }
  }

  .blog-right {
    flex: 0 0 260px;
    margin-top: 5px;

    .dynamic-container {
      .dynamic-header {
        display: flex;
        align-items: center;
        margin-top: 20px;
        height: 30px;
        margin-bottom: 12px;
        font-size: 16px;
        color: #666;
        line-height: 30px;

        i {
          display: inline-block;
          margin-right: 10px;
          width: 19px;
          height: 18px;
          background: url(../../assets/images/poi-listBg10.png) no-repeat -110px -125px;
          overflow: hidden;
        }

        h2 {
          font-weight: normal;
          font-size: 16px;
        }
      }

      .strategy-list {
        .strategy-item {
          display: flex;
          align-items: center;
          height: 30px;
          overflow: hidden;
          cursor: pointer;

          &:nth-child(-n + 3) {
            .strategy-num {
              color: #ffa800;
            }

            .strategy-place {
              color: #ffa800;
            }
          }

          .strategy-num {
            flex: 0 0 auto;
            width: 30px;
            font-size: 20px;
            font-family: Letter Gothic Std, Verdana, Geneva, sans-serif;
            color: #aaa;
            font-weight: bold;
          }

          .strategy-place {
            flex: 0 0 auto;
            padding: 0 15px;
            font-size: 14px;
            font-weight: normal;
            color: #666;
          }

          .strategy-desc {
            flex: 1;
            font-size: 12px;
            color: #999;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }
        }
      }
    }
  }
}
</style>
<style>
.blog-container .el-tabs__item {
  font-size: 18px;
  font-weight: normal;
}
</style>
