<template>
  <div class="common-container">
    <div class="navbar clearfix">
      <ul class="tn-nav">
        <li class="active"><a href="javascript:void(0)">广州游记</a></li>
        <!-- <li><a href="javascript:void(0)">广州推荐行程</a></li> -->
      </ul>
    </div>
    <div>
      <ClientOnly>
        <el-form :inline="true" :model="travelsForm" size="small">
          <el-form-item label="类型" class="form-item">
            <el-select v-model="travelsForm.orderBy" placeholder="请选择">
              <el-option label="最热游记" value="viewnum" />
              <el-option label="最新游记" value="create_time" />
            </el-select>
          </el-form-item>
          <el-form-item label="出发时间" class="form-item">
            <el-select v-model="travelsForm.travelTimeType" placeholder="请选择">
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
            <el-select v-model="travelsForm.consumeType" placeholder="请选择">
              <el-option label="不限" value="-1" />
              <el-option label="1-999" value="1" />
              <el-option label="1K-6K" value="2" />
              <el-option label="6K-20K" value="3" />
              <el-option label="20K以上" value="4" />
            </el-select>
          </el-form-item>
          <el-form-item label="出行天数" class="form-item">
            <el-select v-model="travelsForm.dayType" placeholder="请选择">
              <el-option label="不限" value="-1" />
              <el-option label="3天以下" value="1" />
              <el-option label="4-7天" value="2" />
              <el-option label="8-14天" value="3" />
              <el-option label="15天以上" value="4" />
            </el-select>
          </el-form-item>
        </el-form>
      </ClientOnly>
      <div class="tn-list">
        <div v-for="item in travelsList" :key="item.id" class="tn-item clearfix">
          <div class="tn-image">
            <a :href="'/note/details/' + item.id" target="_blank">
              <img class="lazy" width="220" height="150" :src="item.coverUrl" style="display: inline" />
            </a>
          </div>
          <div class="tn-wrapper">
            <dl>
              <dt>
                <a :href="'/note/details/' + item.id" class="title-link" target="_blank">{{ item.title }}</a>
              </dt>
              <dd>
                <a :href="'/note/details/' + item.id" target="_blank">{{ item.summary }}</a>
              </dd>
            </dl>
            <div class="tn-extra">
              <span class="tn-ding">
                <a class="btn-ding" href="javascript:"></a>
                <em>{{ item.thumbsupnum }}</em>
              </span>

              <span class="tn-user" v-if="item.author">
                <a href="javascript:" rel="nofollow"> <img :src="item.author.headImgUrl" />{{ item.author.nickname }}</a>
              </span>
              <span class="tn-nums"><i></i>{{ item.viewnum }}/{{ item.favornum }}</span>
            </div>
          </div>
        </div>
      </div>
      <div class="page-container">
        <el-pagination class="page" background layout="total, prev, pager, next" :page-size="10" :current-page="travelsForm.currentPage" :total="travelsTotal" @current-change="currentChange" />
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { defineProps } from 'vue'
import { getTravelsQuery } from '@/composables/api/note'
const props = defineProps({
  destid: {
    type: String,
    default: ''
  }
})
const travelsForm = reactive({
  destId: props.destid,
  currentPage: 1,
  orderBy: 'viewnum',
  travelTimeType: '-1',
  consumeType: '-1',
  dayType: '-1'
})

const travelsList = ref([])
const travelsTotal = ref(0)

// 游记列表
function getTravelsList() {
  getTravelsQuery(travelsForm)
    .then(res => {
      travelsList.value = res.data.records
      travelsTotal.value = res.data.total
    })
    .catch(err => {
      console.log(err)
    })
}

function currentChange(val: number) {
  travelsForm.currentPage = val
}

watch(
  () => travelsForm,
  () => {
    nextTick(() => {
      getTravelsList()
    })
  },
  {
    immediate: true,
    deep: true
  }
)
</script>
<style lang="scss" scoped>
.common-container {
  width: 1000px;
  margin: 0 auto;
  .navbar {
    margin-bottom: 20px;
    height: 36px;
    line-height: 36px;
    font-size: 16px;
    .tn-nav {
      float: left;
      li {
        float: left;
        display: inline;
        margin-right: 28px;
        a {
          font-size: 16px;
          color: #666;
        }
        &.active a {
          font-size: 18px;
          color: #333;
        }
      }
    }
  }
  .form-item {
    width: 160px;
    margin-right: 5px;
  }
  .tn-list {
    .tn-item {
      padding: 15px 0;
      height: 150px;
      &:hover {
        background-color: #f8f8f8;
        padding: 15px;
        margin: 0 -15px;
        .tn-wrapper dl dt a {
          color: #192885;
          text-decoration: none;
        }
      }
      .tn-image {
        float: left;
        width: 220px;
        height: 150px;
        overflow: hidden;
        position: relative;
      }
      .tn-wrapper {
        float: right;
        width: 758px;
        height: 150px;
        dl {
          height: 117px;
          dt {
            height: 26px;
            margin-bottom: 10px;
            font-size: 18px;
            line-height: 26px;
            a {
              width: 420px;
              height: 26px;
              display: block;
              color: #333;
              overflow: hidden;
              white-space: nowrap;
              text-overflow: ellipsis;
            }
          }
          dd {
            height: 60px;
            line-height: 20px;
            font-size: 14px;
            overflow: hidden;
            a {
              font-size: 14px;
              color: #666;
            }
          }
        }
        .tn-extra {
          height: 33px;
          overflow: hidden;
          line-height: 33px;
          span {
            display: inline-block;
          }
          .tn-ding {
            float: right;
            color: #192885;
            font-size: 14px;
            text-align: right;
            em {
              font-style: normal;
            }
          }
          .btn-ding {
            display: inline-block;
            float: right;
            margin-left: 8px;
            width: 38px;
            height: 33px;
            background: url(../../assets/images/index-sprites3.png) no-repeat;
            background-position: -60px 0 !important;
            overflow: hidden;
          }
          .tn-user {
            margin-right: 10px;
            img {
              margin-right: 5px;
              width: 16px;
              height: 16px;
              overflow: hidden;
              border-radius: 50%;
              vertical-align: -3px;
            }
          }
          .tn-nums {
            font-size: 14px;
            color: #999;
            i {
              float: left;
              margin: 10px 5px 0 0;
              width: 18px;
              height: 14px;
              background: url(../../assets/images/index-sprites3.png) no-repeat;
              background-position: -30px -50px !important;
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
</style>
