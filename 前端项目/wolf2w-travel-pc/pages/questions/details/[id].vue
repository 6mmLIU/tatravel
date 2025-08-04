<template>
  <div class="details-container clearfix" v-if="detailData">
    <div class="col-main">
      <div class="crumb"><a href="/wenda/" target="_blank">带TA游问答</a> &gt; <span>{{ detailData.title }}</span></div>
      <div id="_js_askDetail" class="q-detail">
        <!-- 问题详情 -->
        <div class="q-content">
          <div class="q-title">
            <a href="/wenda/area-10065.html" target="_blank" class="location"><i></i>{{ detailData.destinationName }}</a>
            <h1>{{ detailData.title }}</h1>
          </div>
          <div class="q-desc" v-html="detailData.detailDoubt ? detailData.detailDoubt : '如题'">

          </div>
          <div class="q-info1 clearfix">
            <div class="q-tags fl">
              <a class="a-tag" href="/wenda/tag-1325.html" target="_blank">安全</a>
              <a class="a-tag" href="/wenda/area-10065.html" target="_blank">{{ detailData.destinationName }}</a>
              <a class="a-tag" href="/wenda/tag-3881.html" target="_blank">行程规划</a>
            </div>
            <div class="pub-bar fr">
              <a href="/wenda/u/69957992/answer.html" class="photo" target="_blank"> <img :src="detailData.headImgUrl"
                  width="16" height="16" /></a>
              <a class="name" href="/wenda/u/69957992/answer.html" target="_blank">{{ detailData.authorName }}</a>
              <span class="time"><i class="ico_phone"></i><span>{{ detailData.createTime }}</span></span>
            </div>
          </div>
        </div>

        <div class="q-operate clearfix">
          <div class="fl">
            <!-- 问题分享 -->
            <div class="q-share cate-share">
              <a class="_js_showShare"><i class="q-share-icon"></i>分享</a>
              <div class="share-pop _j_share_pop hide clearfix"
                :data-title="detailData.detailDoubt ? detailData.detailDoubt.title : ''" data-qid="23792326">
                <a title="分享到新浪微博" class="sina _j_do_share" data-site="wb"></a>
                <a title="分享到QQ空间" class="zone _j_do_share" data-site="qz"></a>
                <a title="分享到微信" class="weixin _j_do_share_wx" data-site="wx"></a>
              </div>
            </div>
            <!-- 邀请回答 -->
            <div class="seek-help _j_tip_box">
              <a class="_j_seek_help_new">邀请蜂蜂回答</a>
            </div>
            <!-- 举报 -->
            <div class="admin_hide tip-off">
              <a data-japp="report" data-refer="http://www.mafengwo.cn/wenda/detail-23792326.html" data-refer-uid="0"
                data-app="qa.question" data-busi-id="qid:23792326">举报</a>
            </div>
          </div>
          <div class="fr">
            <span class="atten-num">{{ detailData.viewNum ? detailData.viewNum : 0 }}浏览</span>
            <span class="atten-num"><span class="_j_same_num">{{ detailData.count ? detailData.count : 0
            }}</span>人关注</span>
            <!-- v-if="!(curUserInfo&&curUserInfo.id===detailData.authorId)" -->
            <a class="btn-atten _j_same_question" :class="detailData.isAttention ? 'btn-atten-active' : ''" rel="nofollow"
              data-status="1" @click="setAnswerAttention"><span>{{ detailData.isAttention ? '取消关注' : '关注' }}</span></a>

            <a class="btn-answer _j_btn_goanswer" rel="nofollow" @click="toPageBottom">回答</a>
          </div>
        </div>

        <!-- 修改问题内容 -->

        <!-- 邀请回答 -->
        <div id="pagelet-block-67a20a03f78384b24c2d51175fe23d43" class="pagelet-block"
          data-api=":qa:pagelet:InviteUserAnswer" data-params='{"mddid":10065,"qid":23792326,"anum":220,"flag":0}'
          data-async="1" data-controller="/js/qa/InviteUserAnswer">
          <div id="_js_invite_wrap" class="q-invite hide _js_q_related_block" data-qid="23792326" data-mddid="10065">
            <b class="arrow"><i></i></b>
            <div class="invite-search clearfix">
              <div class="i-tit">邀请达人解答，更加快速精准地获得答案！</div>
              <div class="i-search-box">
                <div class="i-search">
                  <input id="_js_search_friend_input" type="text" value="邀请好友回答问题" class="i-ipt" />
                  <input id="_js_search_friend_btn" type="button" value="" class="i-btn" />
                </div>
                <div id="_j_seek_help_new_suggestul" class="i-search-sel hide" style="display: none"></div>
                <span id="_js_invite_loading" class="ajax_loading hide">
                  <i class="i1"></i>
                  <i class="i2"></i>
                  <i class="i3"></i>
                </span>
              </div>
              <div class="i-rest">
                <div class="i-rest-awatar _js_ava_list"></div>
                <p><strong class="_js_invited_num">0</strong>人被邀请，还可邀请<span class="_js_can_invite_num">10</span>人</p>
              </div>
            </div>

            <div class="invite-list">
              <ul id="_js_invite_list">
                <li class="hide _js_inviter_item _js_user61722409" style="display: list-item">
                  <div class="i-awatar">
                    <a href="/wenda/u/61722409/answer.html" title="bg1acr" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s8/M00/AB/01/wKgBpVUkiO6ANdHvAABcKuCtFAU84.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="bg1acr" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/qa/expert_apply.php?type=1" class="identity i-guide" target="_blank"><i>指路人</i></a>
                    <a href="/qa/expert_apply.php?type=1&amp;flag=1" class="identity i-place"
                      target="_blank"><i>目的地指路人</i></a>
                    <a href="/wenda/u/61722409/answer.html" class="name" target="_blank">bg1acr</a>
                    <a href="/rank/lv.php?uid=61722409" class="level" target="_blank">LV.44</a>
                    <span>既然不可能说走就走，那就做一次蓄...</span>
                  </div>
                  <div class="i-intro">
                    回答过&nbsp;2332&nbsp;个<strong>北京</strong>问题&nbsp;&nbsp;&nbsp;金牌回答&nbsp;205&nbsp;&nbsp;&nbsp;采纳率36%</div>
                  <a class="i-btn _js_inviting" data-uid="61722409">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user17399092" style="display: list-item">
                  <div class="i-awatar">
                    <a href="/wenda/u/17399092/answer.html" title="skyfifa" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s10/M00/98/D4/wKgBZ1jqJEeAUjO8AAqf157_1xo16.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="skyfifa" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/17399092/answer.html" class="name" target="_blank">skyfifa</a>
                    <a href="/rank/lv.php?uid=17399092" class="level" target="_blank">LV.16</a>
                    <span>行摄江湖，把碎片成为自己的记忆</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;0&nbsp;个<strong>北京</strong>问题</div>
                  <a class="i-btn _js_inviting" data-uid="17399092">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user88180820" style="display: list-item">
                  <div class="i-awatar">
                    <a href="/wenda/u/88180820/answer.html" title="爱谦的小水果" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s19/M00/42/C6/CoNFv2KIqitWThysAAB8jIDanR4.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="爱谦的小水果" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/88180820/answer.html" class="name" target="_blank">爱谦的小水果</a>
                    <a href="/rank/lv.php?uid=88180820" class="level" target="_blank">LV.45</a>
                    <span>一个很喜欢很喜欢很喜欢薛之谦的小...</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;596&nbsp;个<strong>北京</strong>问题</div>
                  <a class="i-btn _js_inviting" data-uid="88180820">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user40741128" style="display: list-item">
                  <div class="i-awatar">
                    <a href="/wenda/u/40741128/answer.html" title="咖喱圆圈圈" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s19/M00/2E/7C/CoNCvmL66kU5u4kIAACaWxLR4o4.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="咖喱圆圈圈" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/qa/expert_apply.php?type=1&amp;flag=1" class="identity i-place"
                      target="_blank"><i>目的地指路人</i></a>
                    <a href="/wenda/u/40741128/answer.html" class="name" target="_blank">咖喱圆圈圈</a>
                    <a href="/rank/lv.php?uid=40741128" class="level" target="_blank">LV.35</a>
                    <span>喜欢安排好一切再出发 也喜欢一切...</span>
                  </div>
                  <div class="i-intro">
                    回答过&nbsp;348&nbsp;个<strong>北京</strong>问题&nbsp;&nbsp;&nbsp;金牌回答&nbsp;7&nbsp;&nbsp;&nbsp;采纳率19%</div>
                  <a class="i-btn _js_inviting" data-uid="40741128">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user33056144" style="display: list-item">
                  <div class="i-awatar">
                    <a href="/wenda/u/33056144/answer.html" title="欢小欢" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s12/M00/FC/51/wKgED1xJE5eABIbXAAwaQ-kcJfk11.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="欢小欢" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/33056144/answer.html" class="name" target="_blank">欢小欢</a>
                    <a href="/rank/lv.php?uid=33056144" class="level" target="_blank">LV.45</a>
                    <span>欢小欢</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;365&nbsp;个<strong>北京</strong>问题</div>
                  <a class="i-btn _js_inviting" data-uid="33056144">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user19143224">
                  <div class="i-awatar">
                    <a href="/wenda/u/19143224/answer.html" title="布格子蘑菇" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s13/M00/23/5B/wKgEaVyW_CmAPVeXAAhtjWeqEuI60.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="布格子蘑菇" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/qa/expert_apply.php?type=1&amp;flag=1" class="identity i-place"
                      target="_blank"><i>目的地指路人</i></a>
                    <a href="/wenda/u/19143224/answer.html" class="name" target="_blank">布格子蘑菇</a>
                    <a href="/rank/lv.php?uid=19143224" class="level" target="_blank">LV.33</a>
                    <span>如果世界是一本书，旅行就是最好的...</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;360&nbsp;个<strong>北京</strong>问题&nbsp;&nbsp;采纳率30%</div>
                  <a class="i-btn _js_inviting" data-uid="19143224">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user54860062">
                  <div class="i-awatar">
                    <a href="/wenda/u/54860062/answer.html" title="zq" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s12/M00/50/1D/wKgED1ub3VCAJogTAAAIro_37Fc12.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="zq" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/54860062/answer.html" class="name" target="_blank">zq</a>
                    <a href="/rank/lv.php?uid=54860062" class="level" target="_blank">LV.45</a>
                    <span>旅行让生活更美好</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;443&nbsp;个<strong>北京</strong>问题</div>
                  <a class="i-btn _js_inviting" data-uid="54860062">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user61543860">
                  <div class="i-awatar">
                    <a href="/wenda/u/61543860/answer.html" title="Danny仔" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s15/M00/FF/CB/CoUBGV30-ViASvvyAAHE1ig3z9s60.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="Danny仔" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/61543860/answer.html" class="name" target="_blank">Danny仔</a>
                    <a href="/rank/lv.php?uid=61543860" class="level" target="_blank">LV.30</a>
                    <span>你曾是少年</span>
                  </div>
                  <div class="i-intro">
                    回答过&nbsp;1&nbsp;个<strong>北京</strong>问题<span>|</span>写过&nbsp;1&nbsp;篇蜂首/宝藏<strong>北京</strong>游记</div>
                  <a class="i-btn _js_inviting" data-uid="61543860">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user52243168">
                  <div class="i-awatar">
                    <a href="/wenda/u/52243168/answer.html" title="渔夫" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s8/M00/C1/1C/wKgBpVYXmzSAH3d_AAJxQe2iy1Q21.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="渔夫" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/qa/expert_apply.php?type=1&amp;flag=1" class="identity i-place"
                      target="_blank"><i>目的地指路人</i></a>
                    <a href="/wenda/u/52243168/answer.html" class="name" target="_blank">渔夫</a>
                    <a href="/rank/lv.php?uid=52243168" class="level" target="_blank">LV.30</a>
                    <span></span>
                  </div>
                  <div class="i-intro">回答过&nbsp;1058&nbsp;个<strong>北京</strong>问题&nbsp;&nbsp;采纳率17%</div>
                  <a class="i-btn _js_inviting" data-uid="52243168">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user80150850">
                  <div class="i-awatar">
                    <a href="/wenda/u/80150850/answer.html" title="静猫猫" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s7/M00/18/04/wKgB6lT64GqADHS_AAGJNo7YnEc55.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="静猫猫" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/80150850/answer.html" class="name" target="_blank">静猫猫</a>
                    <a href="/rank/lv.php?uid=80150850" class="level" target="_blank">LV.34</a>
                    <span>跟着心去行走</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;332&nbsp;个<strong>北京</strong>问题&nbsp;&nbsp;采纳率8%</div>
                  <a class="i-btn _js_inviting" data-uid="80150850">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user53294848">
                  <div class="i-awatar">
                    <a href="/wenda/u/53294848/answer.html" title="梦苏杭" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s17/M00/3B/F5/CoUBXl-ffISAAdPyAAT7eZWQwxo08.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="梦苏杭" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/53294848/answer.html" class="name" target="_blank">梦苏杭</a>
                    <a href="/rank/lv.php?uid=53294848" class="level" target="_blank">LV.18</a>
                    <span>专业北京地接</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;385&nbsp;个<strong>北京</strong>问题</div>
                  <a class="i-btn _js_inviting" data-uid="53294848">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user39758761">
                  <div class="i-awatar">
                    <a href="/wenda/u/39758761/answer.html" title="圣心一颗" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s10/M00/94/CB/wKgBZ1hvcquAdeHeAA4hYwh-cTU31.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="圣心一颗" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/wenda/u/39758761/answer.html" class="name" target="_blank">圣心一颗</a>
                    <a href="/rank/lv.php?uid=39758761" class="level" target="_blank">LV.45</a>
                    <span>人之为善 一颗圣心</span>
                  </div>
                  <div class="i-intro">回答过&nbsp;318&nbsp;个<strong>北京</strong>问题&nbsp;&nbsp;采纳率3%</div>
                  <a class="i-btn _js_inviting" data-uid="39758761">邀请回答</a>
                </li>
                <li class="hide _js_inviter_item _js_user64539615">
                  <div class="i-awatar">
                    <a href="/wenda/u/64539615/answer.html" title="刀刀" target="_blank">
                      <img
                        src="https://p1-q.mafengwo.net/s11/M00/33/7D/wKgBEFppZ32AbJ_2AACRAo2-aO457.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90"
                        alt="刀刀" class="_js_user_ava" />
                    </a>
                  </div>
                  <div class="i-info">
                    <a href="/qa/expert_apply.php?type=1&amp;flag=1" class="identity i-place"
                      target="_blank"><i>目的地指路人</i></a>
                    <a href="/wenda/u/64539615/answer.html" class="name" target="_blank">刀刀</a>
                    <a href="/rank/lv.php?uid=64539615" class="level" target="_blank">LV.45</a>
                    <span>人生最好的旅行，就是在陌生的地方...</span>
                  </div>
                  <div class="i-intro">
                    回答过&nbsp;34&nbsp;个<strong>北京</strong>问题&nbsp;&nbsp;采纳率32%<span>|</span>写过&nbsp;3&nbsp;篇蜂首/宝藏<strong>北京</strong>游记
                  </div>
                  <a class="i-btn _js_inviting" data-uid="64539615">邀请回答</a>
                </li>
              </ul>
              <a id="_js_show_more_inviter" class="invite-more">点击加载更多达人...</a>
            </div>
          </div>
        </div>

        <div class="qa-bar-wrap _j_qaBar hide" style="display: none">
          <div class="qa-bar-content">
            <div class="q-operate">
              <span class="atten-num">6082浏览</span>
              <span class="atten-num"><span class="_j_same_num">0</span>人关注</span>

              <a class="btn-atten _j_same_question" rel="nofollow" data-status="1"><span>关注</span></a>

              <a class="btn-answer _j_btn_goanswer" rel="nofollow">回答</a>
            </div>
            <div class="q-title">
              <a href="/wenda/area-10065.html" target="_blank" class="location"><i></i>北京</a>
              <h1>求一个小众 便宜 不网红 安全的小城旅游 求推荐！！！</h1>
            </div>
          </div>
        </div>
      </div>
      <div class="answer-wrap">
        <div class="hd"><span id="_j_anum">{{detailData.answerList? detailData.answerList.length:0 }}</span>个回答</div>
        <div class="bd _j_pager_box">
          <ul class="answer-list">
            <li class="answer-item clearfix _j_answer_item _js_answer23794231" data-aid="23794231"
              v-for="(answerItem, i) in detailData.answerList" :key="i">
              <div class="answer-side _js_answerAva">
                <a class="btn-ding _js_zan"><i></i><span data-real_num="0">0</span></a>
              </div>

              <div class="answer-content _js_answer_content">
                <div class="answer-info clearfix">
                  <div class="user-bar fl">
                    <a class="_j_filter_click avatar" href="/wenda/u/87543753/answer.html" target="_blank"><img
                        :src="answerItem.headImgUrl" width="48" height="48" class="photo" /></a>
                    <a class="name" href="/wenda/u/87543753/answer.html" target="_blank">{{ answerItem.authorName }}</a>
                    <a class="level" href="/rank/lv.php?uid=87543753" target="_blank" rel="nofollow">Level.{{
                      answerItem.level }}</a>
                    <!-- <a class="identity i-guide" href="/qa/expert_apply.php?type=1" target="_blank">指路人</a>  -->
                  </div>
                </div>

                <div class="_j_long_answer_item" v-html="answerItem.answerContent">
                </div>
              </div>
              <!-- 问答版权名片 -->
              <div class="a-operate _js_operate clearfix">
                <div class="fl">
                  <!-- 问题分享 -->
                  <div class="q-share cate-share">
                    <a class="_js_showShare"><i class="q-share-icon"></i>分享</a>
                    <div class="share-pop _j_share_pop hide clearfix" :data-title="detailData.title" data-qid="23792326"
                      data-aid="23794231">
                      <a title="分享到新浪微博" class="sina _j_do_share" data-site="wb"
                        :data-username="answerItem.authorName"></a>
                      <a title="分享到QQ空间" class="zone _j_do_share" data-site="qz"
                        :data-username="answerItem.authorName"></a>
                      <a title="分享到微信" class="weixin _j_do_share_wx" data-site="wx"
                        :data-username="answerItem.authorName"></a>
                    </div>
                  </div>
                  <div class="cmt-toggle">
                    <a class="_js_slideComment" data-cnum="0" data-default_words="添加评论"
                      @click="showAddComment(answerItem)"><i></i><span>添加评论</span></a>
                  </div>
                  <div class="collect">
                    <a class="_j_collect_answer" :class="answerItem.isCollect? 'collect-active' : ''"
                      @click="setAnswerCollect(answerItem)">
                      <i></i>收藏
                    </a>
                  </div>
                  <div class="pub-time">
                    <span>发布于 {{ answerItem.createTime }}</span>
                  </div>
                  <div class="tip-off">
                    <a data-japp="report" data-refer="http://www.mafengwo.cn/wenda/detail-23792326.html#answer23794231"
                      data-refer-uid="87543753" data-app="qa.answer" data-busi-id="aid:23794231">举报</a>
                  </div>
                </div>
              </div>
              <!-- 问题回复 -->
              <div class="comment-wrap _js_comments is_foldup_detail" v-show="answerItem.isShowComment">
                <b class="arrow"><i></i></b>
                <div class="_js_comment_list"></div>
                <div class="comment-page _js_comment_pagination hide" data-comment_total="0"></div>
                <div class="comment-add clearfix _j_word">
                  <textarea class="_j_content _j_word_check" v-model="answerItem.comment"></textarea>
                  <span class="word-count"><span class="_j_word_num">0</span>/<span class="_j_max_num">600</span> 字</span>
                  <input class="btn-comment _j_publish_comment" type="button" value="回复"
                    @click="replyComment(answerItem)" />
                </div>
              </div>
            </li>
          </ul>
        </div>

        <div class="answer-add clearfix">
          <a name="answer"></a>
          <div class="aa-hd">
            <a class="aa-avatar" href="/wenda/u/36990279/answer.html">
              <img :src="curUserInfo ? curUserInfo.headImgUrl : '/assets/images/pp48.gif'" width="48" height="48"
                class="photo" />
            </a>
            <a class="aa-name">{{ curUserInfo ? curUserInfo.nickname : '未登录' }}</a>
          </div>
          <div class="editor-outer _j_editorOuter _js_editorWrap _js_forFixTitle">
            <div class="editor-scroll">
              <div class="question-title">{{ detailData.title }}</div>
              <div class="answer-editor">
                <ClientOnly>
                  <TEditor ref="editor" v-model="formState.contents" />
                </ClientOnly>
              </div>
              <div class="aa-ft">
                <input class="btn-comment _j_submit_answer_btn" @click="sendAnswer" type="button" value="提交回答" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-side">
      <div class="btn-question">
        <a href="/questions/publish" class="btn-ask btn-ask2" target="_blank">我要提问</a>
      </div>
      <div id="qa_relation_question_pagelet" class="pagelet-block" data-api=":qa:pagelet:RelationQuestionApi"
        data-params='{"qid":23792326}' data-async="1" data-controller="">
        <div class="related-qt">
          <div class="tit">相关问题</div>
          <ul class="bd">
            <li><a href="/wenda/detail-23573503.html" titile="你喜欢网红景点还是小众景点？">你喜欢网红景点还是小众景点？</a> <span>422 回答</span></li>
            <li><a href="/wenda/detail-18636713.html" titile="我想找一个北京交通便利，价格便宜的旅店，求推荐？">我想找一个北京交通便利，价格便宜的旅店，求推荐？</a>
              <span>21 回答</span>
            </li>
            <li><a href="/wenda/detail-22982212.html" titile="我想找一个净化心灵的地方">我想找一个净化心灵的地方</a> <span>51 回答</span></li>
            <li><a href="/wenda/detail-23548508.html" titile="如果出行目的地是低风险地区，你愿意出行去玩吗？">如果出行目的地是低风险地区，你愿意出行去玩吗？</a>
              <span>796 回答</span>
            </li>
            <li><a href="/wenda/detail-23786189.html" titile="求泰国清迈5天4晚自由行攻略">求泰国清迈5天4晚自由行攻略</a> <span>14 回答</span></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { answer, getQuestionDetail, setAnswerCollectPost, setAnswerAttentionPost, setAnswerAttentionUnFocus, setAnswerCollectUnCollect } from '@/composables/api/questions';
import { ElMessage } from 'element-plus';
import { getFollow, followOperate } from '~~/composables/api/friend';

const { $message } = getCurrentInstance().appContext.config.globalProperties;//导入message模块
const formState = reactive({ contents: '' });
const route = useRoute();
const router = useRouter();
//详情数据
const detailData = ref(null);
//console.log(route.params.id);
const curUserInfo = ref(null);
const attentionText = ref('关注');

const sendAnswer = () => {
  //判断用户是否登录，如果没有登录跳转到登录界面
  if (!localStorage.getItem('token')) {
    $message.error('请先登录');
    router.push('/login');
    return;
  }
  //判断当前登录用户是否是作者，如果是，禁止发布  
  if (curUserInfo.value && curUserInfo.value.id == detailData.value.authorId) {
    $message.error('不能回答自己提出的问题');
    return
  }

  if (formState.contents.length < 5) {
    $message.error('输入的长度不够！');
    return;
  }

  answer({
    questionId: route.params.id,
    answerContent: formState.contents
  }).then((res) => {
    ElMessage.success('提交回答成功')
    formState.contents = '';
    getDetail();
  })
}

onMounted(() => {
  nextTick(() => {
    getDetail();
  })
  curUserInfo.value = JSON.parse(localStorage.getItem('userInfo'));
});
//获取详情数据
function getDetail() {
  getQuestionDetail(route.params.id).then((res) => {
    console.log(res);    
    detailData.value = res.data;
    console.log(detailData.value);
    
    if (detailData.value.answerList) {
      detailData.value.answerList.forEach(item => {
        item.isShowComment = false;
        item.comment = '';
      })
    }
  })
}

const toPageBottom = () => {
  //得到可视高度
  const clientHeight = document.documentElement.clientHeight;
  const height = document.documentElement.scrollHeight;
  document.documentElement.scrollTop = height - clientHeight - 400;
}

const setAnswerCollect = (item) => {
  if (item.isCollect) {
    item.isCollect = false;
  } else {
    item.isCollect = true;
  }
  
  if (!item.isCollect) {
    setAnswerCollectUnCollect({ type: item.isCollect, destinationId: item.id }).then((res)=>{
      ElMessage.success('取消收藏问题成功');
    })
  } else {
    //收藏问题
    setAnswerCollectPost({ type: item.isCollect, destinationId: item.id }).then((res) => {
      ElMessage.success('收藏问题成功');
    });
  }

}

//关注问题
const setAnswerAttention = () => {
  if (curUserInfo.value.id != detailData.value.authorId) {
    detailData.value.isAttention = !detailData.value.isAttention
    const type = detailData.value.isAttention ? 1 : 0;
    if (detailData.value.isAttention) {
      setAnswerAttentionPost({ type, destinationId: detailData.value.id }).then((res) => {
        ElMessage.success('关注问题成功！');
      });
    } else {
      setAnswerAttentionUnFocus({ type, destinationId: detailData.value.id }).then((res) => {
        ElMessage.success('取消关注问题成功！');
      });
    }


  } else {
    ElMessage.error('不能关注自己')
  }
}
//回复回签
const replyComment = (item) => {
  //console.log(item.comment);
  console.log(item.id);

  // answer({
  //   questionId:item.id,
  //   answerContent:item.comment
  // }).then((res)=>{
  //   //alert('提交问题成功')
  //   ElMessage.success('回复成功');
  //   getDetail();    
  // })
}
//显示与隐藏回复面板
const showAddComment = (item) => {
  item.isShowComment = !item.isShowComment;
}

</script>
<style lang="scss" scoped>
.details-container {
  position: relative;
  width: 1000px;
  margin: 0 auto;
  font-size: 14px;
  line-height: 24px;
  color: #666;

  .col-main {
    width: 700px;
    float: left;
    margin-bottom: 80px;

    .crumb {
      height: 24px;
      padding: 25px 0 18px;
      overflow: hidden;

      a {
        color: #192885;
        text-decoration: none;
        cursor: pointer;
      }
    }

    .q-detail {
      margin-top: 24px;

      .q-content {
        margin-bottom: 20px;

        .q-title {
          line-height: 30px;

          .location {
            display: inline-block;
            font-size: 18px;
            color: #192885;
            margin-right: 8px;

            i {
              float: left;
              width: 14px;
              height: 16px;
              margin: 7px 6px 0 0;
              background: url(../../../assets/images/mfwask-2016sprite-2x_v9.png) no-repeat;
              background-size: 50px auto;
              background-position: 0 -274px;
            }
          }

          h1 {
            display: inline;
            font-size: 18px;
            color: #333;

            a {
              color: #333;

              &:hover {
                color: #192885;
                text-decoration: none;
              }
            }
          }
        }

        .q-desc {
          margin-top: 10px;
        }

        .q-info1 {
          margin-top: 16px;

          .q-tags {
            width: 560px;

            a {
              display: block;
              float: left;
              margin: 0 10px 5px 0;
              padding: 0 15px;
              background-color: #f6f6f6;
              border: 1px solid #e5e5e5;
              border-radius: 10px;
              font-size: 12px;
              line-height: 20px;
              color: #666;
              white-space: nowrap;

              &:hover {
                background-color: #ffa800;
                border-color: #ffa800;
                color: #fff;
                text-decoration: none;
              }
            }
          }

          .pub-bar {
            line-height: 22px;

            a {
              color: #666;
              font-size: 12px;
            }

            .photo img {
              width: 16px;
              height: 16px;
              border-radius: 50%;
              margin-right: 6px;
            }

            .name {
              margin-right: 10px;
              font-size: 12px;
            }

            .time {
              font-size: 12px;

              .ico_phone {
                width: 12px;
                height: 16px;
                background: url(../../../assets/images/mfw-ask-sprite20.png) no-repeat -100px -100px;
                background-size: 182px 550px;
                display: inline-block;
                margin-right: 6px;
                vertical-align: middle;
                position: relative;
                top: -1px;
              }
            }
          }
        }
      }

      .q-operate {
        padding-top: 18px;
        height: 36px;
        border-top: 1px solid #e5e5e5;

        .fl {
          padding-top: 6px;

          a {
            color: #999;
          }
        }

        .q-share {
          padding-left: 0;
          position: relative;
          display: inline-block;
          font-size: 12px;
          line-height: 14px;
          float: left;
          border-right: 1px solid #e5e5e5;
          padding: 0 10px;
          margin-top: 5px;
          color: #999;

          .q-share-icon {
            display: block;
            width: 13px;
            height: 14px;
            float: left;
            margin-right: 3px;
            background: url(../../../assets/images/mfwask-2016sprite-2x_v9.png) no-repeat;
            background-position: 0 -453px;
            background-size: 50px auto;
          }

          .share-pop {
            width: 132px;
            padding: 8px 10px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            border-radius: 6px;
            position: absolute;
            left: 99%;
            top: -20px;
            z-index: 10;

            a {
              width: 36px;
              height: 36px;
              display: inline-block;
              margin: 0 12px 0 0;
              background: #d84c4c url(../../../assets/images/sprite_v31.png) -295px -569px no-repeat;
              line-height: 200px;
              overflow: hidden;
              float: left;
              border-radius: 5px;

              &.zone {
                background-color: #3f8bc0;
                background-position: -331px -569px;
              }

              &.weixin {
                margin-right: 0;
                background-color: #73a64f;
                background-position: -367px -569px;
              }
            }
          }
        }

        .seek-help {
          position: relative;
          display: inline-block;
          font-size: 12px;
          line-height: 14px;
          float: left;
          border-right: 1px solid #e5e5e5;
          padding: 0 10px;
          margin-top: 5px;
          color: #999;
        }

        .tip-off {
          border-right: 0;
          display: none;
        }

        .atten-num {
          font-size: 12px;
          color: #999;
          margin-right: 10px;
        }

        .btn-atten {
          display: inline-block;
          padding: 0 18px;
          height: 34px;
          border: 1px solid #192885;
          border-radius: 4px;
          font-size: 16px;
          line-height: 34px;
          text-align: center;
          color: #192885;
          position: relative;
        }

        .btn-atten-active {
          border: 1px solid #ccc;
          color: #ccc;
        }

        .btn-answer {
          display: inline-block;
          margin-left: 16px;
          padding: 0 30px;
          height: 36px;
          background-color: #192885;
          border-radius: 4px;
          font-size: 16px;
          line-height: 36px;
          text-align: center;
          color: #fff;
        }
      }
    }

    .answer-wrap {
      margin-top: 20px;

      .hd {
        padding-bottom: 5px;
        border-bottom: 1px solid #e5e5e5;
        color: #333;

        a {
          color: #192885;
          text-decoration: none;
          cursor: pointer;
        }
      }

      .answer-item {
        padding: 20px 0;
        border-bottom: 0;

        .answer-side {
          width: 53px;
          float: left;
          margin: 0 0 0 -65px;
          position: relative;
          text-align: center;
          border: 1px solid #e0e0e0;
          border-radius: 3px;
          padding: 10px 0;
          box-shadow: 0 3px 1px rgb(0 0 0 / 8%), inset 0 -5px 3px rgb(0 0 0 / 6%);

          .btn-ding {
            display: block;
            font-size: 15px;
            line-height: 16px;
            color: #192885;
            text-align: center;

            i {
              display: block;
              width: 37px;
              height: 33px;
              background: url(../../../assets/images/ding.png) no-repeat;
              margin: 0 auto 10px;
            }
          }
        }

        .answer-content {
          word-break: break-all;
          font-size: 16px;
          color: #444;
          line-height: 32px;

          .answer-info {
            height: 48px;
            margin-bottom: 12px;
            display: table;
            width: 100%;
            vertical-align: middle;

            .user-bar {
              float: none;
              height: 48px;
              padding-left: 58px;
              line-height: 20px;
              display: table-cell;
              vertical-align: middle;
              position: relative;

              .avatar {
                margin-right: 10px;
                display: inline-block;
                width: 48px;
                height: 48px;
                border-radius: 50%;
                overflow: hidden;
                vertical-align: middle;
                position: absolute;
                left: 0;
                top: 0;
              }

              .name {
                margin-right: 5px;
              }

              .level {
                font-size: 12px;
                color: #ef523d;
                margin-right: 5px;
              }

              .identity {
                width: 100%;
                height: 20px;
                margin-top: 9px;
                margin-bottom: 12px;

                a.i-guide {
                  display: inline-block;
                  height: 18px;
                  margin-right: 4px;
                  padding: 0 4px 0 20px;
                  border-width: 1px;
                  border-style: solid;
                  border-radius: 10px;
                  font-size: 12px;
                  line-height: 18px;
                  color: #fff;
                  position: relative;
                  background: url(../../../assets/images//mfwask-2016sprite-2x_v6.png) no-repeat;
                  background-size: 50px;
                  border-color: #4fb3a8;
                  background-color: #70c2b9;
                  background-position: 4px -517px;
                  padding-left: 26px;
                }
              }
            }
          }

          .content {}

          .answer-foldup {
            line-height: 25px;
            font-size: 14px;
            word-break: break-all;

            .img {
              float: left;
              margin-right: 10px;
              width: 150px;
              height: 100px;
              background-size: cover;
            }

            p {
              word-break: break-all;
            }
          }
        }

        .a-operate {
          margin-top: 14px;
          height: 24px;
          position: relative;

          a {
            color: #999;

            &:hover {
              color: #ff8a00;
              text-decoration: underline;
            }
          }

          .q-share {
            padding-left: 0;
            position: relative;
            display: inline-block;
            font-size: 12px;
            line-height: 14px;
            float: left;
            border-right: 1px solid #e5e5e5;
            padding: 0 10px;
            margin-top: 5px;
            color: #999;

            .q-share-icon {
              display: block;
              width: 13px;
              height: 14px;
              float: left;
              margin-right: 3px;
              background: url(../../../assets/images/mfwask-2016sprite-2x_v9.png) no-repeat;
              background-position: 0 -453px;
              background-size: 50px auto;
            }
          }

          .cmt-toggle {
            display: inline-block;
            font-size: 12px;
            line-height: 14px;
            float: left;
            border-right: 1px solid #e5e5e5;
            padding: 0 10px;
            margin-top: 5px;
            color: #999;

            i {
              display: block;
              width: 14px;
              height: 14px;
              float: left;
              margin-right: 5px;
              background: url(../../../assets/images/mfwask-2016sprite-2x_v9.png) no-repeat;
              background-position: 0 -467px;
              background-size: 50px auto;
            }
          }

          .collect {
            display: inline-block;
            font-size: 12px;
            line-height: 14px;
            float: left;
            border-right: 1px solid #e5e5e5;
            padding: 0 10px;
            margin-top: 5px;

            i {
              display: inline-block;
              width: 13px;
              height: 12px;
              background: url(../../../assets/images/sc_03.png) no-repeat;
              background-size: 13px 12px;
              vertical-align: middle;
              margin-top: -2px;
              margin-right: 3px;
            }

            .collect-active {
              color: #192885;

              i {
                background: url(../../../assets/images/sc_03_1.png) no-repeat;
                background-size: 13px 12px;
              }
            }
          }

          .pub-time {
            display: inline-block;
            font-size: 12px;
            line-height: 14px;
            float: left;
            border-right: 1px solid #e5e5e5;
            padding: 0 10px;
            margin-top: 5px;
            color: #999;
          }

          .tip-off {
            border-right: 0;
            display: none;
          }
        }

        .comment-wrap {
          margin-top: 14px;
          border: 1px solid #e5e5e5;
          position: relative;

          .arrow {
            width: 0;
            height: 0;
            border-left: 6px solid transparent;
            border-right: 6px solid transparent;
            border-bottom: 6px solid #e5e5e5;
            position: absolute;
            left: 95px;
            top: -6px;

            i {
              width: 0;
              height: 0;
              border-left: 6px solid transparent;
              border-right: 6px solid transparent;
              border-bottom: 6px solid #fff;
              position: absolute;
              left: -6px;
              top: 1px;
            }
          }

          .comment-page {
            font-size: 12px;
            line-height: 24px;
            border-top: 1px solid #e5e5e5;
            border-bottom: 1px solid #e5e5e5;
            text-align: center;
            margin-top: -1px;
            padding: 9px 0;
          }

          .comment-add {
            padding: 15px;
            background-color: #f6f6f6;

            textarea {
              width: 656px;
              height: 60px;
              padding: 2px 5px;
              background-color: #fff;
              border: 1px solid #e5e5e5;
              border-radius: 4px;
              resize: none;
              font-size: 12px;
              line-height: 20px;
              margin-bottom: 9px;
            }

            .word-count {
              float: left;
              font-size: 12px;
              line-height: 36px;
              color: #999;
            }

            .btn-comment {
              float: right;
              width: 90px;
              height: 36px;
              background-color: #192885;
              border-radius: 4px;
              font-size: 16px;
              text-align: center;
              line-height: 36px;
              color: #fff;
              padding: 0;
              border: 0;

              &:hover {
                background-color: #ff8a00;
                text-decoration: none;
              }
            }
          }
        }
      }
    }

    ._j_pager {
      .ft {
        margin: 20px 0;

        .answer-more {
          width: 100%;
          height: 40px;
          border-radius: 4px;
          line-height: 40px;
          text-align: center;

          a {
            display: block;
            width: 100%;
            height: 100%;
            background-color: #efefef;
            color: #666;

            &:hover {
              background-color: #fff5e5;
              color: #192885;
              text-decoration: none;

              i {
                background-position: 0 -347px;
              }
            }

            i {
              display: inline-block;
              width: 10px;
              height: 10px;
              background: url(../../../assets/images/mfwask-2016sprite-2x_v3.png) no-repeat;
              background-position: 0 -329px;
              background-size: 50px 400px;
              margin-left: 6px;
            }
          }
        }

        .answer-loading {
          width: 100%;
          height: 40px;
          border-radius: 4px;
          line-height: 40px;
          text-align: center;
          background-color: #fff5e5;
          color: #192885;

          i {
            display: inline-block;
            width: 22px;
            height: 4px;
            background: url(../../../assets/images/mfwask-2016loading.gif) no-repeat;
            margin-left: 6px;
          }
        }
      }
    }

    .answer-add {
      margin: 36px 0 10px;

      a {
        color: #192885;
        text-decoration: none;
        cursor: pointer;
      }

      .aa-hd {
        height: 48px;
        margin-bottom: 20px;
        display: flex;
        align-items: center;

        .aa-avatar {
          float: left;
          width: 48px;
          height: 48px;
          margin-right: 10px;

        }

        .aa-name {
          line-height: 26px;
          font-size: 18px;
        }
      }

      .aa-ft {
        margin-top: 10px;
        height: 40px;
        line-height: 40px;

        .btn-comment {
          float: right;
          width: 120px;
          height: 40px;
          background-color: #192885;
          border-radius: 4px;
          font-size: 16px;
          text-align: center;
          line-height: 40px;
          color: #fff;
          padding: 0;
          border: 0;
          cursor: pointer;

          &:hover {
            background-color: #ff8a00;
            text-decoration: none;
          }
        }
      }
    }
  }

  .col-side {
    width: 260px;
    float: right;
    margin: 66px 0 120px;

    .btn-question a {
      display: block;
      width: 260px;
      height: 46px;
      background-color: #192885;
      border-radius: 4px;
      font-size: 16px;
      text-align: center;
      line-height: 46px;
      color: #fff;

      &:hover {
        background-color: #ff8a00;
        text-decoration: none;
        color: #fff;
      }
    }

    .related-qt {
      margin-top: 24px;

      .tit {
        margin-bottom: 12px;
        font-size: 16px;
      }

      li {
        margin-bottom: 10px;

        a {
          font-size: 13px;
          color: #192885;
          text-decoration: none;
          cursor: pointer;

          &:hover {
            color: #ff8a00;
            text-decoration: underline;
          }
        }

        span {
          color: #999;
        }
      }
    }
  }

  .fl {
    float: left;
  }

  .fr {
    float: right;
  }

  .hide {
    display: none;
  }
}</style>
