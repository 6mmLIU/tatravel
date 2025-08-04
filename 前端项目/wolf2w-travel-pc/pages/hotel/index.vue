<template>
  <div class="page-container">
    <div class="hotel-main">
      <div class="h-title">订酒店</div>
      <div class="clearfix date-warp">
        <div class="add-travle">
          <input id="_j_search_input" type="text" placeholder="出行目的地" autocomplete="off" />
          <div id="_j_search_shortcut_mdds" class="not-cont" style="display: none">
            <ul>
              <li class="clearfix">
                <h2>中国</h2>
                <p>
                  <a href="javascript:;" data-id="10819" data-name="台北">台北</a><a href="javascript:;" data-id="10189" data-name="香港">香港</a><a href="javascript:;" data-id="10065" data-name="北京">北京</a><a href="javascript:;" data-id="10156" data-name="杭州">杭州</a
                  ><a href="javascript:;" data-id="10099" data-name="上海">上海</a><a href="javascript:;" data-id="10035" data-name="成都">成都</a><a href="javascript:;" data-id="21434" data-name="垦丁">垦丁</a><a href="javascript:;" data-id="15325" data-name="花莲">花莲</a
                  ><a href="javascript:;" data-id="10208" data-name="重庆">重庆</a><a href="javascript:;" data-id="10132" data-name="厦门">厦门</a><a href="javascript:;" data-id="10487" data-name="大理">大理</a><a href="javascript:;" data-id="10030" data-name="三亚">三亚</a>
                </p>
              </li>
              <li class="clearfix">
                <h2>亚洲</h2>
                <p>
                  <a href="javascript:;" data-id="10222" data-name="东京">东京</a><a href="javascript:;" data-id="10765" data-name="大阪">大阪</a><a href="javascript:;" data-id="11042" data-name="京都">京都</a><a href="javascript:;" data-id="11045" data-name="曼谷">曼谷</a
                  ><a href="javascript:;" data-id="15284" data-name="清迈">清迈</a><a href="javascript:;" data-id="11047" data-name="普吉岛">普吉岛</a><a href="javascript:;" data-id="10130" data-name="首尔">首尔</a><a href="javascript:;" data-id="10754" data-name="新加坡">新加坡</a
                  ><a href="javascript:;" data-id="16980" data-name="甲米">甲米</a><a href="javascript:;" data-id="11046" data-name="芭提雅">芭提雅</a><a href="javascript:;" data-id="11049" data-name="吉隆坡">吉隆坡</a><a href="javascript:;" data-id="14210" data-name="苏梅岛">苏梅岛</a>
                </p>
              </li>
              <li class="clearfix">
                <h2>欧洲</h2>
                <p>
                  <a href="javascript:;" data-id="10573" data-name="巴黎">巴黎</a><a href="javascript:;" data-id="11124" data-name="伦敦">伦敦</a><a href="javascript:;" data-id="10063" data-name="罗马">罗马</a><a href="javascript:;" data-id="11087" data-name="佛罗伦萨">佛罗伦萨</a
                  ><a href="javascript:;" data-id="10102" data-name="巴塞罗那">巴塞罗那</a><a href="javascript:;" data-id="11100" data-name="阿姆斯特丹">阿姆斯特丹</a><a href="javascript:;" data-id="11081" data-name="慕尼黑">慕尼黑</a><a href="javascript:;" data-id="10755" data-name="柏林">柏林</a
                  ><a href="javascript:;" data-id="11159" data-name="斯德哥尔摩">斯德哥尔摩</a><a href="javascript:;" data-id="16095" data-name="圣托里尼">圣托里尼</a><a href="javascript:;" data-id="10761" data-name="布拉格">布拉格</a
                  ><a href="javascript:;" data-id="11091" data-name="维也纳">维也纳</a>
                </p>
              </li>
              <li class="clearfix">
                <h2>北美</h2>
                <p>
                  <a href="javascript:;" data-id="10579" data-name="纽约">纽约</a><a href="javascript:;" data-id="10926" data-name="洛杉矶">洛杉矶</a><a href="javascript:;" data-id="10923" data-name="拉斯维加斯">拉斯维加斯</a><a href="javascript:;" data-id="10742" data-name="旧金山">旧金山</a
                  ><a href="javascript:;" data-id="10077" data-name="塞班岛">塞班岛</a><a href="javascript:;" data-id="10959" data-name="黄石国家公园">黄石国家公园</a>
                </p>
              </li>
              <li class="clearfix">
                <h2>大洋洲</h2>
                <p>
                  <a href="javascript:;" data-id="10855" data-name="悉尼">悉尼</a><a href="javascript:;" data-id="10856" data-name="墨尔本">墨尔本</a><a href="javascript:;" data-id="30164" data-name="大洋路">大洋路</a><a href="javascript:;" data-id="17339" data-name="黄金海岸">黄金海岸</a
                  ><a href="javascript:;" data-id="10885" data-name="皇后镇">皇后镇</a><a href="javascript:;" data-id="15920" data-name="基督城">基督城</a>
                </p>
              </li>
            </ul>
          </div>
          <div id="_j_search_suggest" class="search-suggest-panel search-suggest-hotel" style="display: none"></div>
        </div>
        <div id="_j_check_in_date" class="stay-time _j_booking_date_item">
          <span>入住日期</span>
          <input id="dp1663324686444" type="text" placeholder="入住日期" class="hasDatepicker" />
          <i></i>
        </div>
        <div id="_j_check_out_date" class="leave-time _j_booking_date_item">
          <span>离店日期</span>
          <input id="dp1663324686445" type="text" placeholder="离店日期" class="hasDatepicker" />
          <i></i>
        </div>
        <div id="_j_booking_number_guests" class="hs-item hs-item-people number-guests-picker">
          <span>人数未定</span>
          <i class="icon-person"></i>
        </div>
        <div id="_j_search_btn" class="btn-search"><i></i></div>
      </div>
      <div class="h-notice clearfix">
        <ul>
          <li>
            <i class="notice01"></i>
            <div class="flt1">
              <h2>住宿攻略</h2>
              <p>区域攻略到特色主题，应有尽有</p>
            </div>
          </li>
          <li>
            <i class="notice02"></i>
            <div class="flt1">
              <h2>专享价格</h2>
              <p>多平台价格对比，天天专享特惠</p>
            </div>
          </li>
          <li>
            <i class="notice03"></i>
            <div class="flt1">
              <h2>真实点评</h2>
              <p>超过100万真实用户点评和游记</p>
            </div>
          </li>
        </ul>
      </div>

      <div id="_j_features" class="h-theme">
        <div class="h-title" style="margin-top: 50px">主题住宿</div>
        <div class="tab-theme">
          <div class="themeList clearfix _j_tab_trigger">
            <a href="javascript:;" data-id="0" :class="{ on: currentTheme === 0 }" @click="changeTheme(0)">童话小镇</a>
            <a href="javascript:;" data-id="1" :class="{ on: currentTheme === 1 }" @click="changeTheme(1)">亲子之选</a>
            <a href="javascript:;" data-id="2" :class="{ on: currentTheme === 2 }" @click="changeTheme(2)">超值酒店</a>
            <a href="javascript:;" data-id="3" :class="{ on: currentTheme === 3 }" @click="changeTheme(3)">浪漫花海</a>
            <a href="javascript:;" data-id="4" :class="{ on: currentTheme === 4 }" @click="changeTheme(4)">朝拜历史</a>
            <a href="javascript:;" data-id="5" :class="{ on: currentTheme === 5 }" @click="changeTheme(5)">潜水胜地</a>
          </div>
          <div class="_j_tab_content">
            <ul class="clearfix" data-id="0" v-show="currentTheme === 0">
              <li>
                <div class="fc-item">
                  <a href="/hotel/26987/" target="_blank" data-type="mdd" data-name="罗滕堡">
                    <div class="pic">
                      <img width="318" height="240" style="width: 318px; height: 240px" src="https://p1-q.mafengwo.net/s9/M00/35/A7/wKgBs1dL8-yAYZOiAArqT3HkVGo63.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" class="img-show" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>罗滕堡</h2>
                      <p class="caption">德国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/15439/" target="_blank" data-type="mdd" data-name="海德堡">
                    <div class="pic">
                      <img width="318" height="240" style="width: 318px; height: 240px" src="https://p1-q.mafengwo.net/s8/M00/96/DF/wKgBpVUQ4FOAehHbAAjSL1DazdY86.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" class="img-show" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>海德堡</h2>
                      <p class="caption">德国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/18705/" target="_blank" data-type="mdd" data-name="哈尔施塔特">
                    <div class="pic">
                      <img width="318" height="240" style="width: 318px; height: 240px" src="https://p1-q.mafengwo.net/s9/M00/35/A7/wKgBs1dL8-yAbZrYAF1Dvvu7biQ77.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" class="img-show" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>哈尔施塔特</h2>
                      <p class="caption">奥地利</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/16428/" target="_blank" data-type="mdd" data-name="五渔村">
                    <div class="pic">
                      <img width="318" height="240" style="width: 318px; height: 240px" src="https://p1-q.mafengwo.net/s9/M00/35/A6/wKgBs1dL8-yAQIoWAA1hQYXOS0w96.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" class="img-show" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>五渔村</h2>
                      <p class="caption">意大利</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/16099/" target="_blank" data-type="mdd" data-name="羊角村">
                    <div class="pic">
                      <img width="318" height="240" style="width: 318px; height: 240px" src="https://p1-q.mafengwo.net/s9/M00/35/A6/wKgBs1dL8-yAbMg0AAPe7eypPSg41.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" class="img-show" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>羊角村</h2>
                      <p class="caption">荷兰</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/11112/" target="_blank" data-type="mdd" data-name="因特拉肯">
                    <div class="pic">
                      <img width="318" height="240" style="width: 318px; height: 240px" src="https://p1-q.mafengwo.net/s9/M00/35/A6/wKgBs1dL8-yAR-LXAAXexFq2AHI55.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" class="img-show" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>因特拉肯</h2>
                      <p class="caption">瑞士</p>
                    </div>
                  </a>
                </div>
              </li>
            </ul>
            <ul class="clearfix" data-id="1" v-show="currentTheme === 1">
              <li>
                <div class="fc-item">
                  <a href="/hotel/17392/" target="_blank" data-type="mdd" data-name="狗骨岛">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/35/FB/wKgBs1dL9IuAALwPAAJQtfhUH0w07.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>狗骨岛</h2>
                      <p class="caption">泰国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10030/#feature=35025" target="_blank" data-type="feature" data-name="三亚">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/85/63/wKgBs1dSnJCAI9xnAAktH6opmzI42.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>三亚</h2>
                      <p class="caption">中国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10765/#feature=35025" target="_blank" data-type="feature" data-name="大阪">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s8/M00/CE/AE/wKgBpVYPfxCAbmAgACVmVsv_nM455.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>大阪</h2>
                      <p class="caption">日本</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/14210/" target="_blank" data-type="mdd" data-name="苏梅岛">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/35/FB/wKgBs1dL9IuAGK6JAANBrENLW2052.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>苏梅岛</h2>
                      <p class="caption">泰国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10885/" target="_blank" data-type="mdd" data-name="皇后镇">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/35/FA/wKgBs1dL9IuAFbBNAAn120USquo06.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>皇后镇</h2>
                      <p class="caption">新西兰</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/19036/" target="_blank" data-type="mdd" data-name="大堡礁">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/35/FA/wKgBs1dL9IuAV8rXAFrJyv-1p4c46.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>大堡礁</h2>
                      <p class="caption">澳大利亚</p>
                    </div>
                  </a>
                </div>
              </li>
            </ul>
            <ul class="clearfix" data-id="2" v-show="currentTheme === 2">
              <li>
                <div class="fc-item">
                  <a href="/hotel/10077/#feature=25890" target="_blank" data-type="feature" data-name="塞班岛">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/5E/78/wKgBZ1mC9HWAbTMdAADNqTBp4GM25.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>塞班岛</h2>
                      <p class="caption">美国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10189/#feature=25890" target="_blank" data-type="feature" data-name="香港">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/5E/7B/wKgBZ1mC9HaACEOcAAH5DnGoh5g52.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>香港</h2>
                      <p class="caption">中国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10573/#feature=25890" target="_blank" data-type="feature" data-name="巴黎">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/5E/79/wKgBZ1mC9HWAVdYoAADp1HMpUFg70.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>巴黎</h2>
                      <p class="caption">法国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10579/#feature=25890" target="_blank" data-type="feature" data-name="纽约">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/5E/7A/wKgBZ1mC9HWAYdUuAAH_rq3CGXg48.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>纽约</h2>
                      <p class="caption">美国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10222/#feature=25890" target="_blank" data-type="feature" data-name="东京">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/5E/77/wKgBZ1mC9HWAD_AVAAFcnsJmPEs01.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>东京</h2>
                      <p class="caption">日本</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10754/#feature=25890" target="_blank" data-type="feature" data-name="新加坡">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/5E/7A/wKgBZ1mC9HWAOHkPAAGO762PFwQ56.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>新加坡</h2>
                      <p class="caption">新加坡</p>
                    </div>
                  </a>
                </div>
              </li>
            </ul>
            <ul class="clearfix" data-id="3" v-show="currentTheme === 3">
              <li>
                <div class="fc-item">
                  <a href="/hotel/10747/" target="_blank" data-type="mdd" data-name="富士山">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/51/B4/wKgBZ1jLu5WAR-ezABxIarXxVhg42.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>富士山</h2>
                      <p class="caption">日本</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/16283/" target="_blank" data-type="mdd" data-name="奈良">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/52/05/wKgBZ1jLvEGACICOABuulIYZhuQ06.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>奈良</h2>
                      <p class="caption">日本</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/11100/" target="_blank" data-type="mdd" data-name="阿姆斯特丹">
                    <div class="pic">
                      <img src="https://b1-q.mafengwo.net/s7/M00/55/A4/wKgB6lQC95mAQFNMAFO-6RdKryY46.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>阿姆斯特丹</h2>
                      <p class="caption">荷兰</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/11106/" target="_blank" data-type="mdd" data-name="布鲁塞尔">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/52/05/wKgBZ1jLvEGALatTABFdXHEc3vE85.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>布鲁塞尔</h2>
                      <p class="caption">比利时</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10814/" target="_blank" data-type="mdd" data-name="林芝">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/52/05/wKgBZ1jLvEGAH2IlABhOTwykidA02.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>林芝</h2>
                      <p class="caption">中国</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10808/" target="_blank" data-type="mdd" data-name="罗平">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/52/04/wKgBZ1jLvECARBBhAB4nWrWz_nU23.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>罗平</h2>
                      <p class="caption">中国</p>
                    </div>
                  </a>
                </div>
              </li>
            </ul>
            <ul class="clearfix" data-id="4" v-show="currentTheme === 4">
              <li>
                <div class="fc-item">
                  <a href="/hotel/area_7503.html" target="_blank" data-type="area" data-name="暹粒吴哥窟">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/36/99/wKgBs1dL9YaAAYFtAAKJWRdj1Jc42.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>暹粒吴哥窟</h2>
                      <p class="caption">柬埔寨</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/11833/" target="_blank" data-type="mdd" data-name="耶路撒冷">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/36/97/wKgBs1dL9YWAOyWHAAnSy3jE73o54.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>耶路撒冷</h2>
                      <p class="caption">以色列</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/18034/" target="_blank" data-type="mdd" data-name="阿格拉">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/36/98/wKgBs1dL9YaAUTPvAAIBjYQZJSo48.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>阿格拉</h2>
                      <p class="caption">印度</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/11367/" target="_blank" data-type="mdd" data-name="开罗">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/36/98/wKgBs1dL9YaAO1apADncAXUNkdQ03.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>开罗</h2>
                      <p class="caption">埃及</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/area_6075.html" target="_blank" data-type="area" data-name="雅典卫城山">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/36/97/wKgBs1dL9YWAB558AASy_6bJG7s49.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>雅典卫城山</h2>
                      <p class="caption">希腊</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10063/" target="_blank" data-type="mdd" data-name="罗马">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s9/M00/36/98/wKgBs1dL9YaAbtjTAAqwm34stUU35.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>罗马</h2>
                      <p class="caption">意大利</p>
                    </div>
                  </a>
                </div>
              </li>
            </ul>
            <ul class="clearfix" data-id="5" v-show="currentTheme === 5">
              <li>
                <div class="fc-item">
                  <a href="/hotel/28411/" target="_blank" data-type="mdd" data-name="仙本那">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/2B/69/wKgBZ1mNaUGATfaKAAY-tv5C_cs48.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>仙本那</h2>
                      <p class="caption">马来西亚</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10101/" target="_blank" data-type="mdd" data-name="马尔代夫">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/2B/6B/wKgBZ1mNaUGAAsBfAAEsAZ_t8hA02.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>马尔代夫</h2>
                      <p class="caption">马尔代夫</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/area_46246.html" target="_blank" data-type="area" data-name="涛岛">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/E1/5B/wKgBZ1kq3eeAVhybABcvV4bB-kk12.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>涛岛</h2>
                      <p class="caption">阁拍岩</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10460/" target="_blank" data-type="mdd" data-name="巴厘岛">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s7/M00/81/03/wKgB6lPQoUWANqc1AA1KQCkePmc37.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>巴厘岛</h2>
                      <p class="caption">印度尼西亚</p>
                    </div>
                  </a>
                </div>
              </li>
              <li>
                <div class="fc-item">
                  <a href="/hotel/10927/" target="_blank" data-type="mdd" data-name="夏威夷">
                    <div class="pic">
                      <img src="https://p1-q.mafengwo.net/s10/M00/2B/6A/wKgBZ1mNaUGAKEpEAAHCdmv28AI74.jpeg?imageMogr2%2Fthumbnail%2F%21636x480r%2Fgravity%2FCenter%2Fcrop%2F%21636x480%2Fquality%2F90" width="318" height="240" style="width: 318px; height: 240px" />
                    </div>
                    <div class="bag-opa"></div>
                    <span class="shadow"></span>
                    <div class="info">
                      <h2>夏威夷</h2>
                      <p class="caption">美国</p>
                    </div>
                  </a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div id="_j_sales" class="h-favorablle">
        <div class="h-title">特价酒店</div>
        <div class="tab-fav">
          <div class="favList clearfix _j_tab_trigger">
            <a href="javascript:;" data-id="0" :class="{ on: currentHotel === 0 }" @click="changeHotel(0)">曼谷</a>
            <a href="javascript:;" data-id="1" :class="{ on: currentHotel === 1 }" @click="changeHotel(1)">台北</a>
            <a href="javascript:;" data-id="2" :class="{ on: currentHotel === 2 }" @click="changeHotel(2)">东京</a>
            <a href="javascript:;" data-id="3" :class="{ on: currentHotel === 3 }" @click="changeHotel(3)">香港</a>
            <a href="javascript:;" data-id="4" :class="{ on: currentHotel === 4 }" @click="changeHotel(4)">首尔</a>
            <a href="javascript:;" data-id="5" :class="{ on: currentHotel === 5 }" @click="changeHotel(5)">新加坡</a>
          </div>
          <div class="tab-con _j_tab_content">
            <ul class="clearfix" data-id="0" v-show="currentHotel === 0">
              <li data-id="84968" data-mddid="3879275" data-youyu-id="8062" data-ota-id="5">
                <a href="/hotel/84968.html" target="_blank" data-type="hotel" data-name="曼谷威客3號酒店（原曼谷勝利紀念碑全季酒店 - SHA Plus"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/97/56/wKgBEFsjNU6ADk6NAAIXJnPqJIM73.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>曼谷威客3號酒店（原曼谷勝利紀念碑全季酒店 - SHA Plus</p>
                    <p class="eng">VIC 3 Bangkok - SHA Plus</p>
                  </div></a
                >
              </li>
              <li data-id="84734" data-mddid="3879259" data-youyu-id="9722" data-ota-id="5">
                <a href="/hotel/84734.html" target="_blank" data-type="hotel" data-name="穰南帝景酒店 - SHA Plus Certified">
                  <div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/7D/D8/wKgBEFsY872AdeVPAAIR_MMohbg08.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>穰南帝景酒店 - SHA Plus Certified</p>
                    <p class="eng">Royal View Resort - Rang Nam</p>
                  </div></a
                >
              </li>
              <li data-id="85517" data-mddid="3879275" data-youyu-id="8107" data-ota-id="5">
                <a href="/hotel/85517.html" target="_blank" data-type="hotel" data-name="璀璨专享服务公寓">
                  <div class="pic">
                    <img src="https://p1-q.mafengwo.net/s7/M00/3F/78/wKgB6lR0t0iAfpAdAANZ56tPKao53.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>璀璨专享服务公寓</p>
                    <p class="eng">Abloom Exclusive Serviced Apartments</p>
                  </div></a
                >
              </li>
              <li data-id="18629" data-mddid="3879327" data-youyu-id="9623" data-ota-id="5">
                <a href="/hotel/18629.html" target="_blank" data-type="hotel" data-name="曼谷安纳塔拉暹逻酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/DE/AC/wKgBZ1mINF6ADiZKAAMQRMi1Wy411.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.7分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>曼谷安纳塔拉暹逻酒店</p>
                    <p class="eng">Anantara Siam Bangkok Hotel - SHA Extra Plus Certified</p>
                  </div></a
                >
              </li>
              <li data-id="14777" data-mddid="3879259" data-youyu-id="9695" data-ota-id="5">
                <a href="/hotel/14777.html" target="_blank" data-type="hotel" data-name="彩虹云霄酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s9/M00/1E/47/wKgBs1hJJ1OANkS8AAevVMGRJoE36.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">7.7分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>彩虹云霄酒店</p>
                    <p class="eng">Baiyoke Sky Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="85040" data-mddid="3879327" data-youyu-id="6556" data-ota-id="5">
                <a href="/hotel/85040.html" target="_blank" data-type="hotel" data-name="曼谷利特酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/B2/49/wKgBZ1nvaZGAR7RKAAKXZ1MPtvU52.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.7分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>曼谷利特酒店</p>
                    <p class="eng">LiT BANGKOK Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="85439" data-mddid="3879259" data-youyu-id="6488" data-ota-id="5">
                <a href="/hotel/85439.html" target="_blank" data-type="hotel" data-name="暹罗四季酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/22/75/wKgBEFsg2XmAG8zXAF50lnItD1A79.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.3分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>暹罗四季酒店</p>
                    <p class="eng">Seasons Siam Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="84626" data-mddid="3879223" data-youyu-id="9612" data-ota-id="5">
                <a href="/hotel/84626.html" target="_blank" data-type="hotel" data-name="曼谷廊曼机场阿玛瑞酒店 - SHA Plus"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s6/M00/93/D3/wKgB4lMDU3iAMLEGAAJejjVcGGU69.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" class="img-show" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.1分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>曼谷廊曼机场阿玛瑞酒店 - SHA Plus</p>
                    <p class="eng">Amari Don Muang Airport Bangkok - SHA Plus</p>
                  </div></a
                >
              </li>
            </ul>
            <ul class="clearfix" data-id="1" v-show="currentHotel === 1">
              <li data-id="92450" data-mddid="173597" data-youyu-id="6691" data-ota-id="5">
                <a href="/hotel/92450.html" target="_blank" data-type="hotel" data-name="台北凯撒大饭店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s8/M00/2F/B7/wKgBpVVdFUaAbWTfAADg6E338DI93.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>台北凯撒大饭店</p>
                    <p class="eng">Caesar Park Hotel Taipei</p>
                  </div></a
                >
              </li>
              <li data-id="92636" data-mddid="173603" data-youyu-id="11663" data-ota-id="5">
                <a href="/hotel/92636.html" target="_blank" data-type="hotel" data-name="台北大师商旅"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/62/AF/wKgBZ1n27yCALeTjAAHbXAuSYEc29.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>台北大师商旅</p>
                    <p class="eng">Master Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="92582" data-mddid="173597" data-youyu-id="11721" data-ota-id="5">
                <a href="/hotel/92582.html" target="_blank" data-type="hotel" data-name="台北帅客旅店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/87/E0/wKgBZ1mMhHWAA2RDAArXrdKFAhw93.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>台北帅客旅店</p>
                    <p class="eng">Saual Keh Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="92492" data-mddid="173597" data-youyu-id="6742" data-ota-id="5">
                <a href="/hotel/92492.html" target="_blank" data-type="hotel" data-name="台北君品酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/5A/13/wKgBZ1n25jOAOLTQAAPmEiuCYc439.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">9.0分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>台北君品酒店</p>
                    <p class="eng">Palais de Chine Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="92564" data-mddid="173600" data-youyu-id="11569" data-ota-id="5">
                <a href="/hotel/92564.html" target="_blank" data-type="hotel" data-name="台北二十轮旅店西门町馆"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s6/M00/C6/FB/wKgB4lMYBBSADTDLAAHznk7MmSU50.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>台北二十轮旅店西门町馆</p>
                    <p class="eng">SWIIO Hotel Ximending</p>
                  </div></a
                >
              </li>
              <li data-id="92710" data-mddid="173603" data-youyu-id="6709" data-ota-id="5">
                <a href="/hotel/92710.html" target="_blank" data-type="hotel" data-name="台北皇家季节酒店-南西馆"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s7/M00/2A/F7/wKgB6lR0oqiAZZzfAAGCjyiijks07.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.3分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>台北皇家季节酒店-南西馆</p>
                    <p class="eng">Royal Seasons Hotel Taipei Nanjing W</p>
                  </div></a
                >
              </li>
              <li data-id="92670" data-mddid="173600" data-youyu-id="183754" data-ota-id="5">
                <a href="/hotel/92670.html" target="_blank" data-type="hotel" data-name="台北一乐园大饭店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/75/7D/wKgBZ1mMpLCAbRdZAADLhfZ9gLg25.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">7.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>台北一乐园大饭店</p>
                    <p class="eng">Onetel Taipei</p>
                  </div></a
                >
              </li>
              <li data-id="92663" data-mddid="173609" data-youyu-id="6712" data-ota-id="5">
                <a href="/hotel/92663.html" target="_blank" data-type="hotel" data-name="ILLUME 茹曦酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/D3/03/wKgBZ1mMjmSAAskfAAGmCRARpeU19.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">7.7分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>ILLUME 茹曦酒店</p>
                    <p class="eng">ILLUME TAIPEI</p>
                  </div></a
                >
              </li>
            </ul>
            <ul class="clearfix" data-id="2" v-show="currentHotel === 2">
              <li data-id="87536" data-mddid="171764" data-youyu-id="28646" data-ota-id="5">
                <a href="/hotel/87536.html" target="_blank" data-type="hotel" data-name="东京湾希尔顿酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s12/M00/12/A0/wKgED1vqhMyASzdPAAU_YEqcstw00.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>东京湾希尔顿酒店</p>
                    <p class="eng">Hilton Tokyo Bay</p>
                  </div></a
                >
              </li>
              <li data-id="13372" data-mddid="170519" data-youyu-id="6240" data-ota-id="5">
                <a href="/hotel/13372.html" target="_blank" data-type="hotel" data-name="东京京王广场酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/4B/44/wKgBEFs8PuuAIum3ABSNvuw3sLk44.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.6分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>东京京王广场酒店</p>
                    <p class="eng">Keio Plaza Hotel Tokyo</p>
                  </div></a
                >
              </li>
              <li data-id="87470" data-mddid="170519" data-youyu-id="6283" data-ota-id="5">
                <a href="/hotel/87470.html" target="_blank" data-type="hotel" data-name="日晖新宿酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s7/M00/F9/17/wKgB6lR0gkmAMrY3AAEyTu8Pk9873.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>日晖新宿酒店</p>
                    <p class="eng">Hotel Sunlite Shinjuku</p>
                  </div></a
                >
              </li>
              <li data-id="6517814" data-mddid="171764" data-youyu-id="28645" data-ota-id="5">
                <a href="/hotel/6517814.html" target="_blank" data-type="hotel" data-name="东京湾喜来登大酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s7/M00/8D/9B/wKgB6lR1KVOAWyObAAJkMc8GP4k55.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>东京湾喜来登大酒店</p>
                    <p class="eng">Sheraton Grande Tokyo Bay Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="87398" data-mddid="170519" data-youyu-id="6261" data-ota-id="5">
                <a href="/hotel/87398.html" target="_blank" data-type="hotel" data-name="东新宿E酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s6/M00/9D/00/wKgB4lMOLh-ACrryAAGLga3xZes52.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>东新宿E酒店</p>
                    <p class="eng">E Hotel Higashi Shinjuku</p>
                  </div></a
                >
              </li>
              <li data-id="87143" data-mddid="170519" data-youyu-id="6257" data-ota-id="5">
                <a href="/hotel/87143.html" target="_blank" data-type="hotel" data-name="馨乐庭中央东京新宿区酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s9/M00/D3/43/wKgBs1aKTiiAc-LDAAGR5PqxWak08.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>馨乐庭中央东京新宿区酒店</p>
                    <p class="eng">Citadines Central Shinjuku Tokyo</p>
                  </div></a
                >
              </li>
              <li data-id="7042449" data-mddid="170519" data-youyu-id="6344" data-ota-id="5">
                <a href="/hotel/7042449.html" target="_blank" data-type="hotel" data-name="东京新宿馨乐庭酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/FF/7B/wKgBEFq7eaOAVLnsAAEyFcMydlA54.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.2分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>东京新宿馨乐庭酒店</p>
                    <p class="eng">Citadines Shinjuku Tokyo</p>
                  </div></a
                >
              </li>
              <li data-id="87237" data-mddid="170507" data-youyu-id="6256" data-ota-id="5">
                <a href="/hotel/87237.html" target="_blank" data-type="hotel" data-name="新宿灿路都广场大饭店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/BB/3D/wKgBZ1mIciOAOp5cAAFnbGyc7wY43.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">9.0分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新宿灿路都广场大饭店</p>
                    <p class="eng">Hotel Sunroute Plaza Shinjuku</p>
                  </div></a
                >
              </li>
            </ul>
            <ul class="clearfix" data-id="3" v-show="currentHotel === 3">
              <li data-id="486" data-mddid="145963" data-youyu-id="4254" data-ota-id="5">
                <a href="/hotel/486.html" target="_blank" data-type="hotel" data-name="迪士尼好莱坞酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/85/AC/wKgBEFsjKzSAebR0AAlBxLIIJy805.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.9分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>迪士尼好莱坞酒店</p>
                    <p class="eng">Disney's Hollywood Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="12300" data-mddid="145963" data-youyu-id="4267" data-ota-id="5">
                <a href="/hotel/12300.html" target="_blank" data-type="hotel" data-name="香港迪士尼乐园酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/F1/98/wKgBEFuGPJeANF7GACoinAy2U-I20.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>香港迪士尼乐园酒店</p>
                    <p class="eng">Hong Kong Disneyland Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="36303" data-mddid="145973" data-youyu-id="4332" data-ota-id="5">
                <a href="/hotel/36303.html" target="_blank" data-type="hotel" data-name="香港憙酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s6/M00/F1/EB/wKgB4lMQIXSAeIzHAAFHkc2g-wI33.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>香港憙酒店</p>
                    <p class="eng">Xi Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="9851" data-mddid="145973" data-youyu-id="2644" data-ota-id="5">
                <a href="/hotel/9851.html" target="_blank" data-type="hotel" data-name="香港英格兰豪华客栈"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s2/M00/0C/61/wKgBpU42hhbH2j-2AAHiXRKD6Ts40.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">6.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>香港英格兰豪华客栈</p>
                    <p class="eng">UK Hostel</p>
                  </div></a
                >
              </li>
              <li data-id="13919" data-mddid="145970" data-youyu-id="8816" data-ota-id="5">
                <a href="/hotel/13919.html" target="_blank" data-type="hotel" data-name="香港珀丽酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/CB/56/wKgBZ1mIMTqAP-DoAAHuhx7bH9M15.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>香港珀丽酒店</p>
                    <p class="eng">Rosedale Hotel Hong Kong</p>
                  </div></a
                >
              </li>
              <li data-id="92837" data-mddid="246364" data-youyu-id="4364" data-ota-id="5">
                <a href="/hotel/92837.html" target="_blank" data-type="hotel" data-name="红茶馆酒店-土瓜湾邮轮码头店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s6/M00/E4/EB/wKgB4lMYGh-AEjAqAACcymmkrLQ77.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">7.7分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>红茶馆酒店-土瓜湾邮轮码头店</p>
                    <p class="eng">Bridal Tea House To Kwa Wan Cruise Terminal Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="92715" data-mddid="145970" data-youyu-id="8824" data-ota-id="5">
                <a href="/hotel/92715.html" target="_blank" data-type="hotel" data-name="香港J Plus 精品酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s6/M00/44/54/wKgB4lMOCWaAdgfuAAFsA5qjRjQ41.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>香港J Plus 精品酒店</p>
                    <p class="eng">J Plus Hotel by YOO</p>
                  </div></a
                >
              </li>
              <li data-id="36273" data-mddid="145973" data-youyu-id="2621" data-ota-id="5">
                <a href="/hotel/36273.html" target="_blank" data-type="hotel" data-name="香港Casa酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s7/M00/CC/B9/wKgB6lRzHXuAf04rAAG4uw43hLA66.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>香港Casa酒店</p>
                    <p class="eng">Casa Hotel</p>
                  </div></a
                >
              </li>
            </ul>
            <ul class="clearfix" data-id="4" v-show="currentHotel === 4">
              <li data-id="6478205" data-mddid="3878655" data-youyu-id="2870" data-ota-id="5">
                <a href="/hotel/6478205.html" target="_blank" data-type="hotel" data-name="中央明洞空中公園酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s9/M00/41/B6/wKgBs1Zv7XWAc79kAAIzMeLYaXc67.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">9.0分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>中央明洞空中公園酒店</p>
                    <p class="eng">Hotel Skypark Central Myeongdong</p>
                  </div></a
                >
              </li>
              <li data-id="91887" data-mddid="3878655" data-youyu-id="2932" data-ota-id="5">
                <a href="/hotel/91887.html" target="_blank" data-type="hotel" data-name="明洞维斯廷住宅酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s12/M00/AB/0A/wKgED1ukoPSAWLytABCX-6-8X0A72.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.1分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>明洞维斯廷住宅酒店</p>
                    <p class="eng">Vestin Residence Myeongdong</p>
                  </div></a
                >
              </li>
              <li data-id="91663" data-mddid="3878655" data-youyu-id="2876" data-ota-id="5">
                <a href="/hotel/91663.html" target="_blank" data-type="hotel" data-name="空中花园酒店明洞1号店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/C7/50/wKgBZ1mMjKOAUUMqAAHcxPQNWeg96.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>空中花园酒店明洞1号店</p>
                    <p class="eng">Hotel Skypark Myeongdong 1</p>
                  </div></a
                >
              </li>
              <li data-id="8328445" data-mddid="3878655" data-youyu-id="2843" data-ota-id="5">
                <a href="/hotel/8328445.html" target="_blank" data-type="hotel" data-name="天空花园酒店东大门1号店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/B0/A4/wKgBZ1ngelyADHJxAAMwDwj0Q2o71.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.7分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>天空花园酒店东大门1号店</p>
                    <p class="eng">Hotel Skypark Dongdaemun I</p>
                  </div></a
                >
              </li>
              <li data-id="8384441" data-mddid="3878655" data-youyu-id="1370" data-ota-id="5">
                <a href="/hotel/8384441.html" target="_blank" data-type="hotel" data-name="首尔东大门大使宜必思快捷酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/C4/05/wKgBZ1onZr6APWVDAAGb4QRKL3809.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>首尔东大门大使宜必思快捷酒店</p>
                    <p class="eng">ibis Budget Ambassador Seoul Dongdaemun</p>
                  </div></a
                >
              </li>
              <li data-id="6477807" data-mddid="3878703" data-youyu-id="2872" data-ota-id="5">
                <a href="/hotel/6477807.html" target="_blank" data-type="hotel" data-name="宜必思仁寺洞大使酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/72/96/wKgBZ1mIpiSAcRypAAJznF3r1pw22.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.7分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>宜必思仁寺洞大使酒店</p>
                    <p class="eng">ibis Ambassador Insadong</p>
                  </div></a
                >
              </li>
              <li data-id="91933" data-mddid="3878655" data-youyu-id="2826" data-ota-id="5">
                <a href="/hotel/91933.html" target="_blank" data-type="hotel" data-name="太平洋酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/05/DF/wKgBZ1n8M9aAa7NCAAj_s7HNmPc28.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>太平洋酒店</p>
                    <p class="eng">Pacific Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="190698" data-mddid="3878655" data-youyu-id="2815" data-ota-id="5">
                <a href="/hotel/190698.html" target="_blank" data-type="hotel" data-name="首尔大使铂尔曼酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/D3/5E/wKgBZ1mIjUaADUfhAAILSJ5dVy467.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.8分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>首尔大使铂尔曼酒店</p>
                    <p class="eng">The Ambassador Seoul - A Pullman Hotel</p>
                  </div></a
                >
              </li>
            </ul>
            <ul class="clearfix" data-id="5" v-show="currentHotel === 5">
              <li data-id="83446" data-mddid="3879171" data-youyu-id="7093" data-ota-id="5">
                <a href="/hotel/83446.html" target="_blank" data-type="hotel" data-name="新加坡港湾彩鸿酒店 (Staycation Approved)"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/C8/BA/wKgBEFspGeuANDAHAALdVhlP6tM95.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.6分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新加坡港湾彩鸿酒店 (Staycation Approved)</p>
                    <p class="eng">Travelodge Harbourfront Singapore</p>
                  </div></a
                >
              </li>
              <li data-id="22114" data-mddid="3879171" data-youyu-id="250232" data-ota-id="5">
                <a href="/hotel/22114.html" target="_blank" data-type="hotel" data-name="新加坡滨海湾金沙大酒店"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/99/F2/wKgBEFt2MyOAMIxMAAHUpWQ4bGg00.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.2分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新加坡滨海湾金沙大酒店</p>
                    <p class="eng">Marina Bay Sands</p>
                  </div></a
                >
              </li>
              <li data-id="8385997" data-mddid="3879171" data-youyu-id="7177" data-ota-id="5">
                <a href="/hotel/8385997.html" target="_blank" data-type="hotel" data-name="Hotel Clover 33 Jalan Sultan (SG Clean)"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s12/M00/F0/F4/wKgED1upjeKACHbQAAWA6Wrl0o086.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.2分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>Hotel Clover 33 Jalan Sultan (SG Clean)</p>
                    <p class="eng">Hotel Clover 33 Jalan Sultan (SG Clean)</p>
                  </div></a
                >
              </li>
              <li data-id="7317996" data-mddid="3879171" data-youyu-id="7035" data-ota-id="5">
                <a href="/hotel/7317996.html" target="_blank" data-type="hotel" data-name="新加坡克拉码头智选假日酒店(SG Clean)"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s10/M00/9F/A2/wKgBZ1mVHxCAUVxiAAGoHXo59oQ64.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.6分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新加坡克拉码头智选假日酒店(SG Clean)</p>
                    <p class="eng">Holiday Inn Express Singapore Clarke Quay, an IHG Hotel</p>
                  </div></a
                >
              </li>
              <li data-id="83493" data-mddid="3879171" data-youyu-id="11979" data-ota-id="5">
                <a href="/hotel/83493.html" target="_blank" data-type="hotel" data-name="新加坡飞龙酒店-玫瑰(SG Clean) (Staycation Approved)"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s9/M00/C1/C9/wKgBs1aAKnWAU-6_AAEMxfUuTi406.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.4分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新加坡飞龙酒店-玫瑰(SG Clean) (Staycation Approved)</p>
                    <p class="eng">Fragrance Hotel - Rose</p>
                  </div></a
                >
              </li>
              <li data-id="83321" data-mddid="3879195" data-youyu-id="11975" data-ota-id="5">
                <a href="/hotel/83321.html" target="_blank" data-type="hotel" data-name="新加坡宜必思快捷店-西海岸(SG Clean) (Staycation Approved)"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s9/M00/BC/7F/wKgBs1c0P9uAfBSuAAHfFXiBKg883.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.6分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新加坡宜必思快捷店-西海岸(SG Clean) (Staycation Approved)</p>
                    <p class="eng">Ibis Budget Singapore West Coast</p>
                  </div></a
                >
              </li>
              <li data-id="10945" data-mddid="3879195" data-youyu-id="7046" data-ota-id="5">
                <a href="/hotel/10945.html" target="_blank" data-type="hotel" data-name="新加坡香格里拉圣淘沙度假村 (Staycation Approved)"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s12/M00/BB/93/wKgED1uM2viABNk3AAMifUjf8Gw05.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.6分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新加坡香格里拉圣淘沙度假村 (Staycation Approved)</p>
                    <p class="eng">Shangri-La Rasa Sentosa, Singapore</p>
                  </div></a
                >
              </li>
              <li data-id="83315" data-mddid="3879171" data-youyu-id="7117" data-ota-id="5">
                <a href="/hotel/83315.html" target="_blank" data-type="hotel" data-name="新加坡丽思卡尔顿美年酒店 (Staycation Approved)"
                  ><div class="pic">
                    <img src="https://p1-q.mafengwo.net/s11/M00/5F/9A/wKgBEFsH3HiAPDkvAAHcjuXYm0w69.jpeg?imageMogr2%2Fthumbnail%2F%21480x480r%2Fgravity%2FCenter%2Fcrop%2F%21480x480%2Fquality%2F90" />
                  </div>
                  <div class="bag-opa"></div>
                  <div class="fraction">8.5分</div>
                  <div class="info">
                    <div class="prize"></div>
                    <p>新加坡丽思卡尔顿美年酒店 (Staycation Approved)</p>
                    <p class="eng">The Ritz-Carlton, Millenia Singapore</p>
                  </div></a
                >
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
const currentTheme = ref(0)
const currentHotel = ref(0)

function changeTheme(val) {
  currentTheme.value = val
}

function changeHotel(val) {
  currentHotel.value = val
}
</script>
<style lang="scss" scoped>
.page-container {
  .hotel-main {
    position: relative;
    z-index: 5;
    width: 1000px;
    margin: 0 auto;
    padding-top: 60px;
    .h-title {
      font-size: 24px;
      color: #333;
      line-height: 30px;
    }
    .date-warp {
      height: 47px;
      margin: 40px 0 70px 0;
      position: relative;
      z-index: 9;
      .add-travle {
        height: 45px;
        width: 352px;
        position: relative;
        float: left;
        margin-right: 10px;
        input {
          width: 340px;
          height: 45px;
          border: 1px solid #999;
          font-size: 16px;
          color: #666;
          border-radius: 4px;
          padding: 0 0 0 10px;
        }
        .not-cont {
          width: 725px;
          padding: 25px 10px 0 10px;
          border: 1px solid #c6c6c6;
          border-radius: 4px;
          box-shadow: 1px 1px 3px rgb(0 0 0 / 10%);
          background: #fff;
          z-index: 10;
          ul li {
            margin-bottom: 10px;
            h2 {
              font-size: 14px;
              color: #666;
              font-weight: bold;
              width: 70px;
              padding-left: 10px;
              float: left;
            }
            p {
              float: left;
              width: 645px;
              a {
                display: inline-block;
                margin-bottom: 15px;
                font-size: 14px;
                width: 107px;
                color: #666;
                &:hover {
                  color: #ff8a00;
                  text-decoration: none;
                }
              }
            }
          }
        }
      }
      .stay-time,
      .leave-time {
        position: relative;
        float: left;
        height: 47px;
        margin-right: 10px;
        cursor: pointer;
        span {
          display: block;
          width: 170px;
          height: 45px;
          line-height: 45px;
          border: 1px solid #999;
          border-radius: 4px;
          font-size: 16px;
          color: #666;
          padding: 0 0 0 15px;
        }
        input {
          position: absolute;
          bottom: 0;
          left: 0;
          z-index: -1;
          visibility: hidden;
          padding: 0;
          border: 0;
          width: 100%;
        }
        i {
          display: block;
          width: 16px;
          height: 16px;
          position: absolute;
          right: 11px;
          top: 15px;
          background: url(../../assets/images/hotel-list-icon.png) no-repeat;
          background-size: 100px 100px;
          background-position: 0 -51px;
          cursor: pointer;
          overflow: hidden;
        }
      }
      .hs-item {
        height: 47px;
        position: relative;
        float: left;
        margin-right: 10px;
        & > span {
          font-size: 16px;
          color: #666;
          display: block;
          height: 45px;
          line-height: 45px;
          padding: 0 12px;
          border: 1px solid #999;
          border-radius: 4px;
          width: 159px;
          cursor: pointer;
        }
        .icon-person {
          display: inline-block;
          position: absolute;
          top: 15px;
          right: 10px;
          width: 15px;
          height: 16px;
          background: url(../../assets/images/hotel-detail-icon8.png);
          background-size: 400px auto;
          background-position: -70px -140px !important;
          vertical-align: middle;
          overflow: hidden;
        }
      }
      .btn-search {
        width: 46px;
        height: 46px;
        line-height: 46px;
        background: #ffa800;
        float: left;
        border-radius: 5px;
        cursor: pointer;
        text-align: center;
        i {
          display: inline-block;
          width: 24px;
          height: 24px;
          vertical-align: middle;
          background: url(../../assets/images/hotel-list-icon.png) no-repeat;
          background-size: 100px 100px;
          background-position: -24px -51px;
        }
      }
    }
    .h-notice {
      ul {
        li {
          float: left;
          width: 333px;
          i {
            display: block;
            float: left;
            margin-right: 13px;
            background: url(../../assets/images/hotel-sprites1.png) no-repeat;
            background-size: 150px 42px;
            &.notice01 {
              width: 35px;
              height: 42px;
              background-position: 0 0;
            }
            &.notice02 {
              width: 43px;
              height: 42px;
              background-position: -47px 0;
              margin-left: 40px;
            }
            &.notice03 {
              width: 44px;
              height: 42px;
              background-position: -100px 0;
              margin-left: 80px;
            }
          }
          h2 {
            font-size: 18px;
            color: #666;
            line-height: 18px;
            font-weight: normal;
          }
          p {
            font-size: 14px;
            color: #666;
            margin-top: 5px;
          }
        }
      }
    }
    .h-theme {
      padding-bottom: 100px;
      .themeList {
        border-bottom: 1px solid #e4e4e4;
        a {
          display: block;
          text-decoration: none;
          float: left;
          width: 166px;
          width: 16.66%;
          color: #666;
          text-align: center;
          height: 50px;
          line-height: 50px;
          font-size: 18px;
          &.on {
            color: #ff8a00;
            border-bottom: 3px solid #ff8a00;
            margin-bottom: -2px;
          }
        }
      }
      .tab-theme ul {
        width: 1023px;
        li {
          width: 318px;
          height: 240px;
          float: left;
          margin: 20px 23px 0 0;
          position: relative;
          .pic {
            width: 318px;
            height: 240px;
            overflow: hidden;
          }
          .bag-opa {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            background: #000;
            opacity: 0.2;
            z-index: 2;
          }
          .info {
            text-align: center;
            position: absolute;
            z-index: 3;
            left: 0;
            top: 50%;
            width: 100%;
            margin-top: -30px;
            h2 {
              font-size: 30px;
              color: #fff;
              font-weight: normal;
              text-shadow: 2px 2px 2px rgb(0 0 0 / 80%);
            }
            p {
              font-size: 18px;
              color: #fff;
              text-shadow: 2px 2px 2px rgb(0 0 0 / 80%);
            }
          }
        }
        .fc-item {
          position: relative;
          -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
          will-change: transform;
          &::after {
            position: absolute;
            top: 100%;
            left: 0;
            z-index: -1;
            display: block;
            content: '';
            height: 22px;
            width: 100%;
            background: url(../../assets/images/floating-card-shadow.png) no-repeat;
            background-size: 100%;
          }
          img {
            width: 318px;
            height: 240px;
            min-height: 240px;
          }
          .shadow {
            content: '';
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            height: auto;
            width: 100%;
            background-image: linear-gradient(45deg, rgba(0, 0, 0, 0.4), transparent 40%);
            z-index: 1;
            -webkit-backface-visibility: hidden;
            backface-visibility: hidden;
          }
          .info {
            pointer-events: none;
            -webkit-transform: translateZ(100px) scale(0.9);
            transform: translateZ(100px) scale(0.9);
          }
        }
      }
      ._j_tab_content .img-show {
        opacity: 1;
      }

      ._j_tab_content img {
        -webkit-transition: opacity ease-in 1s;
        -moz-transition: opacity ease-in 1s;
        transition: opacity ease-in 1s;
      }
    }
    .h-favorablle {
      padding-bottom: 100px;
      .tab-fav {
        .favList {
          border-bottom: 1px solid #e4e4e4;
          width: 1000px;
          margin: 0 auto;
          a {
            display: block;
            text-decoration: none;
            float: left;
            width: 166px;
            width: 16.66%;
            color: #666;
            text-align: center;
            height: 50px;
            line-height: 50px;
            font-size: 18px;
            &.on {
              color: #ff8a00;
              border-bottom: 3px solid #ff8a00;
              margin-bottom: -2px;
            }
          }
        }
        ul {
          width: 1012px;
          padding-top: 20px;
          li {
            width: 240px;
            height: 240px;
            overflow: hidden;
            float: left;
            margin: 0 13px 13px 0;
            position: relative;
            img {
              width: 240px;
              height: 240px;
            }
            .bag-opa {
              width: 100%;
              height: 100%;
              position: absolute;
              left: 0;
              top: 0;
              background: #000;
              opacity: 0.2;
              z-index: 2;
            }
            .fraction {
              width: 55px;
              height: 25px;
              font-size: 18px;
              color: #fff;
              background: rgba(0, 0, 0, 0.5);
              position: absolute;
              left: 13px;
              top: 13px;
              text-align: center;
              line-height: 25px;
              border-radius: 4px;
              z-index: 5;
            }
            .info {
              position: absolute;
              z-index: 3;
              left: 13px;
              bottom: 13px;
              width: 220px;
              margin-top: -30px;
              color: #fff;
              p {
                font-size: 14px;
                &.eng {
                  font-size: 12px;
                }
              }
            }
          }
        }
      }
    }
    .h-title {
      font-size: 24px;
      color: #333;
      line-height: 30px;
      text-align: center;
      margin: 100px 0 25px 0;
    }
  }
  .flt1 {
    float: left;
  }
}
</style>
