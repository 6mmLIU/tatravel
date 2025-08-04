<template>
  <div class="common-container">
    <h2 class="r-title">攻略下载</h2>
    <div class="gl-slide" style="">
      <div class="gl-slide-con" style="width: 1055px; margin: 0px auto">
        <ul class="gl-list">
          <li>
            <a class="gl-cover" href="/gonglve/mdd-10065.html" target="_blank">
              <img
                src="https://p1-q.mafengwo.net/s8/M00/C9/AE/wKgBpVXr_jeAfCkPAAtJANc8s6g17.jpeg?imageView2%2F2%2Fw%2F156%2Fh%2F220%2Fq%2F90"
                height="220"
                width="156"
              />
            </a>
            <a class="btn download-pdf" href="/gonglve/mdd-10065.html" target="_blank">下载PDF版本</a>
            <span>文件大小 6.19 MB</span>
            <a class="btn download-jpg" href="/gonglve/mdd-10065.html" target="_blank">下载JPG版本</a>
            <span>文件大小 28.58 MB</span>
          </li>
          <li>
            <a class="gl-cover" href="/gonglve/zt-758.html" target="_blank">
              <img
                src="https://p1-q.mafengwo.net/s9/M00/0D/FC/wKgBs1fGRueAFDjtAAUqq4ss__Q57.jpeg?imageView2%2F2%2Fw%2F156%2Fh%2F220%2Fq%2F90"
                height="220"
                width="156"
              />
            </a>
            <a class="btn download-pdf" href="/gonglve/zt-758.html" target="_blank">下载PDF版本</a>
            <span>文件大小 6.84 MB</span>
            <a class="btn download-jpg" href="/gonglve/zt-758.html" target="_blank">下载JPG版本</a>
            <span>文件大小 2.76 MB</span>
          </li>
          <li>
            <a class="gl-cover" href="/gonglve/mdd-10495.html" target="_blank">
              <img
                src="https://p1-q.mafengwo.net/s5/M00/BE/C9/wKgB3FHn2feAYBJmAARLDnjSNeU82.jpeg?imageView2%2F2%2Fw%2F156%2Fh%2F220%2Fq%2F90"
                height="220"
                width="156"
              />
            </a>
            <a class="btn download-pdf" href="/gonglve/mdd-10495.html" target="_blank">下载PDF版本</a>
            <span>文件大小 1.05 MB</span>
            <a class="btn download-jpg" href="/gonglve/mdd-10495.html" target="_blank">下载JPG版本</a>
            <span>文件大小 2.53 MB</span>
          </li>
          <li>
            <a class="gl-cover" href="/gonglve/mdd-10588.html" target="_blank">
              <img
                src="https://p1-q.mafengwo.net/s8/M00/9A/54/wKgBpVYXZs2AJVmZAAt8XoQc4qA99.jpeg?imageView2%2F2%2Fw%2F156%2Fh%2F220%2Fq%2F90"
                height="220"
                width="156"
              />
            </a>
            <a class="btn download-pdf" href="/gonglve/mdd-10588.html" target="_blank">下载PDF版本</a>
            <span>文件大小 12.53 MB</span>
            <a class="btn download-jpg" href="/gonglve/mdd-10588.html" target="_blank">下载JPG版本</a>
            <span>文件大小 9.84 MB</span>
          </li>
          <li style="margin-right: 0">
            <a class="gl-cover" href="/gonglve/zt-301.html" target="_blank">
              <img
                src="https://p1-q.mafengwo.net/s5/M00/81/B4/wKgB21BEQxuqM0zLAAPlFQxxf8w90.jpeg?imageView2%2F2%2Fw%2F156%2Fh%2F220%2Fq%2F90"
                height="220"
                width="156"
              />
            </a>
            <a class="btn download-pdf" href="/gonglve/zt-301.html" target="_blank">下载PDF版本</a>
            <span>文件大小 2.84 MB</span>
            <a class="btn download-jpg" href="/gonglve/zt-301.html" target="_blank">下载JPG版本</a>
            <span>文件大小 10.94 MB</span>
          </li>
        </ul>
      </div>
      <a class="btn-slide btn-slide-left" href="javascript:void(0)" style="display: none"></a>
      <a class="btn-slide btn-slide-right" href="javascript:void(0)" style="display: none"></a>
    </div>
  </div>
</template>
<script setup lang="ts"></script>
<style lang="scss" scoped>
.common-container {
  width: 1000px;
  margin: 0 auto;
  .r-title {
    margin-bottom: 40px;
    font-size: 26px;
    color: #333;
    font-weight: normal;
    line-height: 24px;
    text-align: center;
  }
  .gl-slide {
    width: 1000px;
    position: relative;
    .gl-slide-con {
      width: 1000px;
      height: 385px;
      position: relative;
      overflow: hidden;
      .gl-list {
        position: absolute;
        left: 0;
        top: 0;
        height: 385px;
        text-align: center;
        overflow: hidden;
        li {
          float: left;
          width: 156px;
          display: inline;
          margin-right: 55px;
          .gl-cover {
            display: block;
            margin-bottom: 20px;
          }
          .btn {
            display: inline-block;
            width: 110px;
            height: 40px;
            line-height: 40px;
            text-align: center;
            font-size: 14px;
            color: #fff;
            border-radius: 3px;
          }
          .download-pdf {
            background-color: #92bf48;
          }
          .download-jpg {
            background-color: #5dcfef;
          }
          .btn + span {
            display: block;
            height: 30px;
            line-height: 26px;
          }
        }
      }
    }
  }
}
</style>
