<template>
  <div class="page-container">
    <div class="container clearfix">
      <!--sousuo start-->
      <div class="brand-bar clearfix">
        <div class="bb-hd">
          <div class="bb-title">
            <a href="http://www.mafengwo.cn/sales/" style="text-decoration: none"><i class="icon-fh"></i>自由行</a>
          </div>
        </div>
        <div class="bb-hd">
          <div class="search-panel">
            <!---签证和当地游不需要出发地--->
            <div class="depart" data-depart="1">
              <div class="trigger" data-btn-depart="1">
                <i class="i-arr"></i>
                <strong id="mddFromXl" data-depart-station="1" data-mddid="10133" data-area="Other"> 武汉 </strong>出发
              </div>
              <div class="depart-panel" data-tab-wrap="1">
                <div class="dp-hot">
                  <p>热门出发地</p>
                  <ul class="clearfix" data-view-group="dept" data-search-group="from">
                    <li><a data-hot-depart-item="1" data-mddid="0" data-mddname="全国出发" data-area="Other" data-pinyin="" data-pinyinbrief="" href="javascript:void(0);"> 全国 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10065" data-mddname="北京" data-area="BJ" data-pinyin="beijing" data-pinyinbrief="bj" href="javascript:void(0);"> 北京 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10320" data-mddname="天津" data-area="BJ" data-pinyin="tianjin" data-pinyinbrief="tj" href="javascript:void(0);"> 天津 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10099" data-mddname="上海" data-area="SH" data-pinyin="shanghai" data-pinyinbrief="sh" href="javascript:void(0);"> 上海 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10156" data-mddname="杭州" data-area="SH" data-pinyin="hangzhou" data-pinyinbrief="hz" href="javascript:void(0);"> 杭州 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10088" data-mddname="广州" data-area="GZ" data-pinyin="guangzhou" data-pinyinbrief="gz" href="javascript:void(0);"> 广州 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10198" data-mddname="深圳" data-area="GZ" data-pinyin="shenzhen" data-pinyinbrief="sz" href="javascript:void(0);"> 深圳 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10035" data-mddname="成都" data-area="Other" data-pinyin="chengdu" data-pinyinbrief="cd" href="javascript:void(0);"> 成都 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10208" data-mddname="重庆" data-area="Other" data-pinyin="chongqing" data-pinyinbrief="cq" href="javascript:void(0);"> 重庆 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10807" data-mddname="昆明" data-area="Other" data-pinyin="kunming" data-pinyinbrief="km" href="javascript:void(0);"> 昆明 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10133" data-mddname="武汉" data-area="Other" data-pinyin="wuhan" data-pinyinbrief="wh" href="javascript:void(0);"> 武汉 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10195" data-mddname="西安" data-area="Other" data-pinyin="xian" data-pinyinbrief="xa" href="javascript:void(0);"> 西安 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10189" data-mddname="香港" data-area="Other" data-pinyin="xianggang" data-pinyinbrief="xg" href="javascript:void(0);"> 香港 </a></li>
                    <li><a data-hot-depart-item="1" data-mddid="10206" data-mddname="澳门" data-area="Other" data-pinyin="aomen" data-pinyinbrief="am" href="javascript:void(0);"> 澳门 </a></li>
                  </ul>
                </div>
                <div class="dp-search">
                  <input type="text" data-ipt-search-depart="1" placeholder="搜索城市（支持汉字、首字母查询 )" />
                  <p data-depart-result="0" style="display: none">未找到结果</p>
                  <ul data-depart-result="1" class="clearfix" style="display: none"></ul>
                </div>
                <div class="letter-tab">
                  <ul class="clearfix">
                    <li class="on" data-city-tab="0"><a href="javascript:void(0);">ABCDEF</a></li>
                    <li data-city-tab="1"><a href="javascript:void(0);">GHJKLM</a></li>
                    <li data-city-tab="2"><a href="javascript:void(0);">NPQRS</a></li>
                    <li data-city-tab="3"><a href="javascript:void(0);">TWXYZ</a></li>
                  </ul>
                </div>
                <div data-city-panel="0" class="letter-content">
                  <div class="letter-item clearfix">
                    <span class="letter">A</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10206" data-mddid="10206" data-mddname="澳门" data-area="GZ" data-pinyin="aomen" data-pinyinbrief="am" href="javascript:void(0);">澳门</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">B</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li class="on">
                        <a data-depart-item="1" data-v="10065" data-mddid="10065" data-mddname="北京" data-area="BJ" data-pinyin="beijing" data-pinyinbrief="bj" href="javascript:void(0);">北京</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11574" data-mddid="11574" data-mddname="包头" data-area="Other" data-pinyin="baotou" data-pinyinbrief="bt" href="javascript:void(0);">包头</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10796" data-mddid="10796" data-mddname="北海" data-area="Other" data-pinyin="beihai" data-pinyinbrief="bh" href="javascript:void(0);">北海</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">C</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10035" data-mddid="10035" data-mddname="成都" data-area="Other" data-pinyin="chengdu" data-pinyinbrief="cd" href="javascript:void(0);">成都</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10466" data-mddid="10466" data-mddname="长沙" data-area="Other" data-pinyin="changsha" data-pinyinbrief="cs" href="javascript:void(0);">长沙</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11247" data-mddid="11247" data-mddname="长春" data-area="Other" data-pinyin="changchun" data-pinyinbrief="cc" href="javascript:void(0);">长春</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10208" data-mddid="10208" data-mddname="重庆" data-area="Other" data-pinyin="chongqing" data-pinyinbrief="cq" href="javascript:void(0);">重庆</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10802" data-mddid="10802" data-mddname="常州" data-area="Other" data-pinyin="changzhou" data-pinyinbrief="cz" href="javascript:void(0);">常州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="14401" data-mddid="14401" data-mddname="长治" data-area="Other" data-pinyin="changzhi" data-pinyinbrief="cz" href="javascript:void(0);">长治</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10792" data-mddid="10792" data-mddname="郴州" data-area="Other" data-pinyin="chenzhou" data-pinyinbrief="cz" href="javascript:void(0);">郴州</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">D</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10301" data-mddid="10301" data-mddname="大连" data-area="Other" data-pinyin="dalian" data-pinyinbrief="dl" href="javascript:void(0);">大连</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="12334" data-mddid="12334" data-mddname="东莞" data-area="GZ" data-pinyin="dongguan" data-pinyinbrief="dg" href="javascript:void(0);">东莞</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10487" data-mddid="10487" data-mddname="大理" data-area="Other" data-pinyin="dali" data-pinyinbrief="dl" href="javascript:void(0);">大理</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="16215" data-mddid="16215" data-mddname="东北" data-area="Other" data-pinyin="dongbei" data-pinyinbrief="db" href="javascript:void(0);">东北</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11241" data-mddid="11241" data-mddname="大同" data-area="Other" data-pinyin="datong" data-pinyinbrief="dt" href="javascript:void(0);">大同</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item last-child clearfix">
                    <span class="letter">F</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="11498" data-mddid="11498" data-mddname="福州" data-area="Other" data-pinyin="fuzhou" data-pinyinbrief="fz" href="javascript:void(0);">福州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="13394" data-mddid="13394" data-mddname="佛山" data-area="GZ" data-pinyin="foshan" data-pinyinbrief="fs" href="javascript:void(0);">佛山</a>
                      </li>
                    </ul>
                  </div>
                </div>
                <div data-city-panel="1" class="letter-content" style="display: none">
                  <div class="letter-item clearfix">
                    <span class="letter">G</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li class="on">
                        <a data-depart-item="1" data-v="10088" data-mddid="10088" data-mddname="广州" data-area="GZ" data-pinyin="guangzhou" data-pinyinbrief="gz" href="javascript:void(0);">广州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11239" data-mddid="11239" data-mddname="贵阳" data-area="Other" data-pinyin="guiyang" data-pinyinbrief="gy" href="javascript:void(0);">贵阳</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10095" data-mddid="10095" data-mddname="桂林" data-area="Other" data-pinyin="guilin" data-pinyinbrief="gl" href="javascript:void(0);">桂林</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11609" data-mddid="11609" data-mddname="赣州" data-area="Other" data-pinyin="ganzhou" data-pinyinbrief="gz" href="javascript:void(0);">赣州</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">H</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10156" data-mddid="10156" data-mddname="杭州" data-area="SH" data-pinyin="hangzhou" data-pinyinbrief="hz" href="javascript:void(0);">杭州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10068" data-mddid="10068" data-mddname="哈尔滨" data-area="Other" data-pinyin="haerbin" data-pinyinbrief="heb" href="javascript:void(0);">哈尔滨</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10793" data-mddid="10793" data-mddname="合肥" data-area="Other" data-pinyin="hefei" data-pinyinbrief="hf" href="javascript:void(0);">合肥</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10513" data-mddid="10513" data-mddname="海口" data-area="Other" data-pinyin="haikou" data-pinyinbrief="hk" href="javascript:void(0);">海口</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11415" data-mddid="11415" data-mddname="呼和浩特" data-area="Other" data-pinyin="huhehaote" data-pinyinbrief="hhht" href="javascript:void(0);">呼和浩特</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11732" data-mddid="11732" data-mddname="邯郸" data-area="Other" data-pinyin="handan" data-pinyinbrief="hd" href="javascript:void(0);">邯郸</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10440" data-mddid="10440" data-mddname="黄山" data-area="Other" data-pinyin="huangshan" data-pinyinbrief="hs" href="javascript:void(0);">黄山</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11475" data-mddid="11475" data-mddname="惠州" data-area="Other" data-pinyin="huizhou" data-pinyinbrief="hz" href="javascript:void(0);">惠州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10414" data-mddid="10414" data-mddname="海拉尔" data-area="Other" data-pinyin="hailaer" data-pinyinbrief="hle" href="javascript:void(0);">海拉尔</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">J</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10575" data-mddid="10575" data-mddname="济南" data-area="Other" data-pinyin="jinan" data-pinyinbrief="jn" href="javascript:void(0);">济南</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11681" data-mddid="11681" data-mddname="嘉兴" data-area="SH" data-pinyin="jiaxing" data-pinyinbrief="jx" href="javascript:void(0);">嘉兴</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="14191" data-mddid="14191" data-mddname="揭阳" data-area="GZ" data-pinyin="jieyang" data-pinyinbrief="jy" href="javascript:void(0);">揭阳</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10136" data-mddid="10136" data-mddname="九寨沟" data-area="Other" data-pinyin="jiuzhaigou" data-pinyinbrief="jzg" href="javascript:void(0);">九寨沟</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">K</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10807" data-mddid="10807" data-mddname="昆明" data-area="Other" data-pinyin="kunming" data-pinyinbrief="km" href="javascript:void(0);">昆明</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">L</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10783" data-mddid="10783" data-mddname="兰州" data-area="Other" data-pinyin="lanzhou" data-pinyinbrief="lz" href="javascript:void(0);">兰州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10094" data-mddid="10094" data-mddname="洛阳" data-area="Other" data-pinyin="luoyang" data-pinyinbrief="ly" href="javascript:void(0);">洛阳</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11624" data-mddid="11624" data-mddname="龙岩" data-area="Other" data-pinyin="longyan" data-pinyinbrief="ly" href="javascript:void(0);">龙岩</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="29359" data-mddid="29359" data-mddname="吕梁" data-area="Other" data-pinyin="lvliang" data-pinyinbrief="ll" href="javascript:void(0);">吕梁</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10804" data-mddid="10804" data-mddname="连云港" data-area="Other" data-pinyin="lianyungang" data-pinyinbrief="lyg" href="javascript:void(0);">连云港</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10186" data-mddid="10186" data-mddname="丽江" data-area="Other" data-pinyin="lijiang" data-pinyinbrief="lj" href="javascript:void(0);">丽江</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10442" data-mddid="10442" data-mddname="拉萨" data-area="Other" data-pinyin="lasa" data-pinyinbrief="ls" href="javascript:void(0);">拉萨</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item last-child clearfix">
                    <span class="letter">M</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="13663" data-mddid="13663" data-mddname="绵阳" data-area="Other" data-pinyin="mianyang" data-pinyinbrief="my" href="javascript:void(0);">绵阳</a>
                      </li>
                    </ul>
                  </div>
                </div>
                <div data-city-panel="2" class="letter-content" style="display: none">
                  <div class="letter-item clearfix">
                    <span class="letter">N</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10684" data-mddid="10684" data-mddname="南京" data-area="Other" data-pinyin="nanjing" data-pinyinbrief="nj" href="javascript:void(0);">南京</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10308" data-mddid="10308" data-mddname="南宁" data-area="Other" data-pinyin="nanning" data-pinyinbrief="nn" href="javascript:void(0);">南宁</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10129" data-mddid="10129" data-mddname="宁波" data-area="SH" data-pinyin="ningbo" data-pinyinbrief="nb" href="javascript:void(0);">宁波</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11754" data-mddid="11754" data-mddname="南昌" data-area="Other" data-pinyin="nanchang" data-pinyinbrief="nc" href="javascript:void(0);">南昌</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="12013" data-mddid="12013" data-mddname="南平" data-area="Other" data-pinyin="nanping" data-pinyinbrief="np" href="javascript:void(0);">南平</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="12681" data-mddid="12681" data-mddname="宁德" data-area="Other" data-pinyin="ningde" data-pinyinbrief="nd" href="javascript:void(0);">宁德</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="64084" data-mddid="64084" data-mddname="南沙群岛" data-area="Other" data-pinyin="nanshaqundao" data-pinyinbrief="nsqd" href="javascript:void(0);">南沙群岛</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11558" data-mddid="11558" data-mddname="南通" data-area="Other" data-pinyin="nantong" data-pinyinbrief="nt" href="javascript:void(0);">南通</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">P</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="11784" data-mddid="11784" data-mddname="莆田" data-area="Other" data-pinyin="putian" data-pinyinbrief="pt" href="javascript:void(0);">莆田</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="12038" data-mddid="12038" data-mddname="攀枝花" data-area="Other" data-pinyin="panzhihua" data-pinyinbrief="pzh" href="javascript:void(0);">攀枝花</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">Q</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10444" data-mddid="10444" data-mddname="青岛" data-area="Other" data-pinyin="qingdao" data-pinyinbrief="qd" href="javascript:void(0);">青岛</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11246" data-mddid="11246" data-mddname="泉州" data-area="Other" data-pinyin="quanzhou" data-pinyinbrief="qz" href="javascript:void(0);">泉州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11499" data-mddid="11499" data-mddname="秦皇岛" data-area="Other" data-pinyin="qinhuangdao" data-pinyinbrief="qhd" href="javascript:void(0);">秦皇岛</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item last-child clearfix">
                    <span class="letter">S</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10198" data-mddid="10198" data-mddname="深圳" data-area="GZ" data-pinyin="shenzhen" data-pinyinbrief="sz" href="javascript:void(0);">深圳</a>
                      </li>
                      <li class="on">
                        <a data-depart-item="1" data-v="10099" data-mddid="10099" data-mddname="上海" data-area="SH" data-pinyin="shanghai" data-pinyinbrief="sh" href="javascript:void(0);">上海</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10075" data-mddid="10075" data-mddname="沈阳" data-area="Other" data-pinyin="shenyang" data-pinyinbrief="sy" href="javascript:void(0);">沈阳</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11830" data-mddid="11830" data-mddname="石家庄" data-area="Other" data-pinyin="shijiazhuang" data-pinyinbrief="sjz" href="javascript:void(0);">石家庄</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10030" data-mddid="10030" data-mddname="三亚" data-area="Other" data-pinyin="sanya" data-pinyinbrief="sy" href="javascript:void(0);">三亚</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="13063" data-mddid="13063" data-mddname="汕头" data-area="SZ" data-pinyin="shantou" data-pinyinbrief="st" href="javascript:void(0);">汕头</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="14844" data-mddid="14844" data-mddname="三明" data-area="Other" data-pinyin="sanming" data-pinyinbrief="sm" href="javascript:void(0);">三明</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10207" data-mddid="10207" data-mddname="苏州" data-area="Other" data-pinyin="suzhou" data-pinyinbrief="sz" href="javascript:void(0);">苏州</a>
                      </li>
                    </ul>
                  </div>
                </div>
                <div data-city-panel="3" class="letter-content" style="display: none">
                  <div class="letter-item clearfix">
                    <span class="letter">T</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="11240" data-mddid="11240" data-mddname="太原" data-area="Other" data-pinyin="taiyuan" data-pinyinbrief="ty" href="javascript:void(0);">太原</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10320" data-mddid="10320" data-mddname="天津" data-area="BJ" data-pinyin="tianjin" data-pinyinbrief="tj" href="javascript:void(0);">天津</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11781" data-mddid="11781" data-mddname="唐山" data-area="Other" data-pinyin="tangshan" data-pinyinbrief="ts" href="javascript:void(0);">唐山</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">W</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10133" data-mddid="10133" data-mddname="武汉" data-area="Other" data-pinyin="wuhan" data-pinyinbrief="wh" href="javascript:void(0);">武汉</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11688" data-mddid="11688" data-mddname="温州" data-area="SH" data-pinyin="wenzhou" data-pinyinbrief="wz" href="javascript:void(0);">温州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10218" data-mddid="10218" data-mddname="乌鲁木齐" data-area="Other" data-pinyin="wulumuqi" data-pinyinbrief="wlmq" href="javascript:void(0);">乌鲁木齐</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10140" data-mddid="10140" data-mddname="无锡" data-area="Other" data-pinyin="wuxi" data-pinyinbrief="wx" href="javascript:void(0);">无锡</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10256" data-mddid="10256" data-mddname="威海" data-area="Other" data-pinyin="weihai" data-pinyinbrief="wh" href="javascript:void(0);">威海</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11707" data-mddid="11707" data-mddname="潍坊" data-area="Other" data-pinyin="weifang" data-pinyinbrief="wf" href="javascript:void(0);">潍坊</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10434" data-mddid="10434" data-mddname="乌镇" data-area="Other" data-pinyin="wuzhen" data-pinyinbrief="wz" href="javascript:void(0);">乌镇</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">X</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10195" data-mddid="10195" data-mddname="西安" data-area="Other" data-pinyin="xian" data-pinyinbrief="xa" href="javascript:void(0);">西安</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10189" data-mddid="10189" data-mddname="香港" data-area="GZ" data-pinyin="xianggang" data-pinyinbrief="xg" href="javascript:void(0);">香港</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10132" data-mddid="10132" data-mddname="厦门" data-area="Other" data-pinyin="xiamen" data-pinyinbrief="xm" href="javascript:void(0);">厦门</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11431" data-mddid="11431" data-mddname="徐州" data-area="Other" data-pinyin="xuzhou" data-pinyinbrief="xz" href="javascript:void(0);">徐州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10800" data-mddid="10800" data-mddname="西宁" data-area="Other" data-pinyin="xining" data-pinyinbrief="xn" href="javascript:void(0);">西宁</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11630" data-mddid="11630" data-mddname="西昌" data-area="Other" data-pinyin="xichang" data-pinyinbrief="xc" href="javascript:void(0);">西昌</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item clearfix">
                    <span class="letter">Y</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="11243" data-mddid="11243" data-mddname="烟台" data-area="Other" data-pinyin="yantai" data-pinyinbrief="yt" href="javascript:void(0);">烟台</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10490" data-mddid="10490" data-mddname="宜昌" data-area="Other" data-pinyin="yichang" data-pinyinbrief="yc" href="javascript:void(0);">宜昌</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10771" data-mddid="10771" data-mddname="银川" data-area="Other" data-pinyin="yinchuan" data-pinyinbrief="yc" href="javascript:void(0);">银川</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="13738" data-mddid="13738" data-mddname="运城" data-area="Other" data-pinyin="yuncheng" data-pinyinbrief="yc" href="javascript:void(0);">运城</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11349" data-mddid="11349" data-mddname="延安" data-area="Other" data-pinyin="yanan" data-pinyinbrief="ya" href="javascript:void(0);">延安</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11508" data-mddid="11508" data-mddname="延吉" data-area="Other" data-pinyin="yanji" data-pinyinbrief="yj" href="javascript:void(0);">延吉</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10128" data-mddid="10128" data-mddname="扬州" data-area="Other" data-pinyin="yangzhou" data-pinyinbrief="yz" href="javascript:void(0);">扬州</a>
                      </li>
                    </ul>
                  </div>
                  <div class="letter-item last-child clearfix">
                    <span class="letter">Z</span>
                    <ul data-view-group="dept" data-search-group="from">
                      <li>
                        <a data-depart-item="1" data-v="10794" data-mddid="10794" data-mddname="郑州" data-area="Other" data-pinyin="zhengzhou" data-pinyinbrief="zz" href="javascript:void(0);">郑州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10269" data-mddid="10269" data-mddname="珠海" data-area="GZ" data-pinyin="zhuhai" data-pinyinbrief="zh" href="javascript:void(0);">珠海</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10790" data-mddid="10790" data-mddname="漳州" data-area="Other" data-pinyin="zhangzhou" data-pinyinbrief="zz" href="javascript:void(0);">漳州</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="10514" data-mddid="10514" data-mddname="中山" data-area="GZ" data-pinyin="zhongshan" data-pinyinbrief="zs" href="javascript:void(0);">中山</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="11505" data-mddid="11505" data-mddname="舟山" data-area="SH" data-pinyin="zhoushan" data-pinyinbrief="zs" href="javascript:void(0);">舟山</a>
                      </li>
                      <li>
                        <a data-depart-item="1" data-v="12475" data-mddid="12475" data-mddname="湛江" data-area="GZ" data-pinyin="zhanjiang" data-pinyinbrief="zj" href="javascript:void(0);">湛江</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="search-main" data-search="1">
              <div class="clearfix">
                <input id="ipt_keyword" data-new-search-depart="1" class="search-input" type="text" placeholder="请输入目的地 / 产品名称" />
                <a id="btn_keyword" data-mes-t="按钮" class="search-button" href="javascript:;"><i></i></a>
              </div>
              <div class="city-panel" style="display: none" data-btn-depart2="1">
                <h4>国内</h4>
                <ul>
                  <li>
                    <span class="label">热门</span>

                    <a data-list-search-mdd-station="1" data-mddid="10030" data-mddname="三亚" data-area="Other" href="javascript:void(0);">三亚 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10132" data-mddname="厦门" data-area="Other" href="javascript:void(0);">厦门 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10035" data-mddname="成都" data-area="Other" href="javascript:void(0);">成都 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10208" data-mddname="重庆" data-area="Other" href="javascript:void(0);">重庆 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10095" data-mddname="桂林" data-area="Other" href="javascript:void(0);">桂林 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10186" data-mddname="丽江" data-area="Other" href="javascript:void(0);">丽江 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10195" data-mddname="西安" data-area="Other" href="javascript:void(0);">西安 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10156" data-mddname="杭州" data-area="Other" href="javascript:void(0);">杭州 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10442" data-mddname="拉萨" data-area="Other" href="javascript:void(0);">拉萨 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10796" data-mddname="北海" data-area="Other" href="javascript:void(0);">北海 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10136" data-mddname="九寨沟" data-area="Other" href="javascript:void(0);">九寨沟 </a>
                  </li>
                </ul>
                <h4>出境</h4>
                <ul>
                  <li>
                    <span class="label">日本</span>

                    <a data-list-search-mdd-station="1" data-mddid="10222" data-mddname="东京" data-area="Other" href="javascript:void(0);">东京 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10765" data-mddname="大阪" data-area="Other" href="javascript:void(0);">大阪 </a>
                    <a data-list-search-mdd-station="1" data-mddid="11041" data-mddname="冲绳" data-area="Other" href="javascript:void(0);">冲绳 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10746" data-mddname="北海道" data-area="Other" href="javascript:void(0);">北海道 </a>
                    <a data-list-search-mdd-station="1" data-mddid="11043" data-mddname="名古屋" data-area="Other" href="javascript:void(0);">名古屋 </a>
                    <a data-list-search-mdd-station="1" data-mddid="15297" data-mddname="福冈" data-area="Other" href="javascript:void(0);">福冈 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10769" data-mddname="札幌" data-area="Other" href="javascript:void(0);">札幌 </a>
                  </li>
                  <li>
                    <span class="label">泰国</span>

                    <a data-list-search-mdd-station="1" data-mddid="11045" data-mddname="曼谷" data-area="Other" href="javascript:void(0);">曼谷 </a>
                    <a data-list-search-mdd-station="1" data-mddid="11047" data-mddname="普吉岛" data-area="Other" href="javascript:void(0);">普吉岛 </a>
                    <a data-list-search-mdd-station="1" data-mddid="15284" data-mddname="清迈" data-area="Other" href="javascript:void(0);">清迈 </a>
                    <a data-list-search-mdd-station="1" data-mddid="14210" data-mddname="苏梅岛" data-area="Other" href="javascript:void(0);">苏梅岛 </a>
                    <a data-list-search-mdd-station="1" data-mddid="16980" data-mddname="甲米" data-area="Other" href="javascript:void(0);">甲米 </a>
                  </li>
                  <li>
                    <span class="label">海岛</span>

                    <a data-list-search-mdd-station="1" data-mddid="10460" data-mddname="巴厘岛" data-area="Other" href="javascript:void(0);">巴厘岛 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10101" data-mddname="马尔代夫" data-area="Other" href="javascript:void(0);">马尔代夫 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10077" data-mddname="塞班岛" data-area="Other" href="javascript:void(0);">塞班岛 </a>
                    <a data-list-search-mdd-station="1" data-mddid="16102" data-mddname="芽庄" data-area="Other" href="javascript:void(0);">芽庄 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10737" data-mddname="长滩岛" data-area="Other" href="javascript:void(0);">长滩岛 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10760" data-mddname="沙巴" data-area="Other" href="javascript:void(0);">沙巴 </a>
                    <a data-list-search-mdd-station="1" data-mddid="11761" data-mddname="毛里求斯" data-area="Other" href="javascript:void(0);">毛里求斯 </a>
                    <a data-list-search-mdd-station="1" data-mddid="16827" data-mddname="塞舌尔" data-area="Other" href="javascript:void(0);">塞舌尔 </a>
                    <a data-list-search-mdd-station="1" data-mddid="22478" data-mddname="留尼汪" data-area="Other" href="javascript:void(0);">留尼汪 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10927" data-mddname="夏威夷" data-area="Other" href="javascript:void(0);">夏威夷 </a>
                    <a data-list-search-mdd-station="1" data-mddid="19016" data-mddname="关岛" data-area="Other" href="javascript:void(0);">关岛 </a>
                  </li>
                  <li>
                    <span class="label">亚洲</span>

                    <a data-list-search-mdd-station="1" data-mddid="10097" data-mddname="马来西亚" data-area="Other" href="javascript:void(0);">马来西亚 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10180" data-mddname="越南" data-area="Other" href="javascript:void(0);">越南 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10406" data-mddname="吴哥窟" data-area="Other" href="javascript:void(0);">吴哥窟 </a>
                    <a data-list-search-mdd-station="1" data-mddid="11214" data-mddname="迪拜" data-area="Other" href="javascript:void(0);">迪拜 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10069" data-mddname="尼泊尔" data-area="Other" href="javascript:void(0);">尼泊尔 </a>
                  </li>
                  <li>
                    <span class="label">欧美</span>

                    <a data-list-search-mdd-station="1" data-mddid="10062" data-mddname="美国" data-area="Other" href="javascript:void(0);">美国 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10926" data-mddname="洛杉矶" data-area="Other" href="javascript:void(0);">洛杉矶 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10742" data-mddname="旧金山" data-area="Other" href="javascript:void(0);">旧金山 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10171" data-mddname="法国" data-area="Other" href="javascript:void(0);">法国 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10300" data-mddname="俄罗斯" data-area="Other" href="javascript:void(0);">俄罗斯 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10063" data-mddname="罗马" data-area="Other" href="javascript:void(0);">罗马 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10176" data-mddname="德国" data-area="Other" href="javascript:void(0);">德国 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10122" data-mddname="英国" data-area="Other" href="javascript:void(0);">英国 </a>
                    <a data-list-search-mdd-station="1" data-mddid="14635" data-mddname="贝加尔湖" data-area="Other" href="javascript:void(0);">贝加尔湖 </a>
                  </li>
                  <li>
                    <span class="label">大洋洲</span>

                    <a data-list-search-mdd-station="1" data-mddid="10202" data-mddname="澳大利亚" data-area="Other" href="javascript:void(0);">澳大利亚 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10855" data-mddname="悉尼" data-area="Other" href="javascript:void(0);">悉尼 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10544" data-mddname="新西兰" data-area="Other" href="javascript:void(0);">新西兰 </a>
                    <a data-list-search-mdd-station="1" data-mddid="11044" data-mddname="斐济" data-area="Other" href="javascript:void(0);">斐济 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10344" data-mddname="大溪地" data-area="Other" href="javascript:void(0);">大溪地 </a>
                  </li>
                  <li>
                    <span class="label">港澳台</span>

                    <a data-list-search-mdd-station="1" data-mddid="10189" data-mddname="香港" data-area="Other" href="javascript:void(0);">香港 </a>
                    <a data-list-search-mdd-station="1" data-mddid="10206" data-mddname="澳门" data-area="Other" href="javascript:void(0);">澳门 </a>
                    <a data-list-search-mdd-station="1" data-mddid="12684" data-mddname="台湾" data-area="Other" href="javascript:void(0);">台湾 </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--sousuo end-->

      <!----filter start----->
      <form id="formFilter">
        <div class="filter-panel">
          <div id="saleType" class="filter-hd clearfix" data-type="1">
            <a id="saleType0" data-v="0" data-type-filter="1" href="javascript:void(0);">全部</a>
            <a id="saleType5" data-v="5" class="cur" data-type-filter="1" href="javascript:void(0);">邮轮</a>
          </div>

          <div id="filter" class="filter-bd clearfix" data-filter="1">
            <dl class="row" data-view-group="relatedMdd" data-search-group="s_dept_time" style="display: block">
              <dt>出发日期：</dt>
              <dd class="clearfix">
                <ul class="filter-nav">
                  <li><input id="all_s_dept_time" type="checkbox" name="s_dept_time[]" value="all" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="all" data-chose-name="不限" class="u-radio" checked />不限</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202209" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202209" data-chose-name="9月" class="u-radio" />9月</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202210" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202210" data-chose-name="10月" class="u-radio" />10月</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202211" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202211" data-chose-name="11月" class="u-radio" />11月</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202212" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202212" data-chose-name="12月" class="u-radio" />12月</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202301" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202301" data-chose-name="2023年1月" class="u-radio" />2023年1月</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202302" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202302" data-chose-name="2月" class="u-radio" />2月</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202303" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202303" data-chose-name="3月" class="u-radio" />3月</li>
                  <li><input id="s_dept_time" type="checkbox" name="s_dept_time[]" value="202304" data-filter-list="1" data-filter-name="s_dept_time" data-filter-value="202304" data-chose-name="4月" class="u-radio" />4月</li>
                </ul>
                <a class="toggle" role="button" data-type-filter-show-more="1" href="javascript:void(0);" style="display: none">更多</a>
              </dd>
            </dl>
            <dl class="row" data-view-group="relatedMdd" data-search-group="price" style="display: block">
              <dt>价格区间：</dt>
              <dd class="clearfix">
                <ul class="filter-nav">
                  <li><input id="all_price" type="checkbox" name="price[]" value="all" data-filter-list="1" data-filter-name="price" data-filter-value="all" data-chose-name="不限" class="u-radio" checked />不限</li>
                  <li><input id="price" type="checkbox" name="price[]" value="5280:6180" data-filter-list="1" data-filter-name="price" data-filter-value="5280:6180" data-chose-name="5280-6180" class="u-radio" />5280-6180</li>
                  <li><input id="price" type="checkbox" name="price[]" value="6180:142800" data-filter-list="1" data-filter-name="price" data-filter-value="6180:142800" data-chose-name="6180-142800" class="u-radio" />6180-142800</li>
                </ul>
                <a class="toggle" role="button" data-type-filter-show-more="1" href="javascript:void(0);" style="display: none">更多</a>
              </dd>
            </dl>
            <dl class="row" data-view-group="relatedMdd" data-search-group="trip_days" style="display: block">
              <dt>行程天数：</dt>
              <dd class="clearfix">
                <ul class="filter-nav">
                  <li><input id="all_trip_days" type="checkbox" name="trip_days[]" value="all" data-filter-list="1" data-filter-name="trip_days" data-filter-value="all" data-chose-name="不限" class="u-radio" checked />不限</li>
                  <li><input id="trip_days" type="checkbox" name="trip_days[]" value="4:4" data-filter-list="1" data-filter-name="trip_days" data-filter-value="4:4" data-chose-name="4天" class="u-radio" />4天</li>
                  <li><input id="trip_days" type="checkbox" name="trip_days[]" value="10:10" data-filter-list="1" data-filter-name="trip_days" data-filter-value="10:10" data-chose-name="10天" class="u-radio" />10天</li>
                </ul>
                <a class="toggle" role="button" data-type-filter-show-more="1" href="javascript:void(0);" style="display: none">更多</a>
              </dd>
            </dl>
            <dl class="row" data-view-group="relatedMdd" data-search-group="tag_group[12515]" style="display: block">
              <dt>邮轮公司：</dt>
              <dd class="clearfix">
                <ul class="filter-nav">
                  <li><input id="all_tag_group[12515]" type="checkbox" name="tag_group[12515][]" value="all" data-filter-list="1" data-filter-name="tag_group[12515]" data-filter-value="all" data-chose-name="不限" class="u-radio" checked />不限</li>
                  <li><input id="tag_group[12515]" type="checkbox" name="tag_group[12515][]" value="80262" data-filter-list="1" data-filter-name="tag_group[12515]" data-filter-value="80262" data-chose-name="南极二十一世纪" class="u-radio" />南极二十一世纪</li>
                </ul>
                <a class="toggle" role="button" data-type-filter-show-more="1" href="javascript:void(0);" style="display: none">更多</a>
              </dd>
            </dl>
            <dl class="row" data-view-group="relatedMdd" data-search-group="tag_group[12521]" style="display: block">
              <dt>出发港口：</dt>
              <dd class="clearfix">
                <ul class="filter-nav">
                  <li><input id="all_tag_group[12521]" type="checkbox" name="tag_group[12521][]" value="all" data-filter-list="1" data-filter-name="tag_group[12521]" data-filter-value="all" data-chose-name="不限" class="u-radio" checked />不限</li>
                  <li><input id="tag_group[12521]" type="checkbox" name="tag_group[12521][]" value="21614" data-filter-list="1" data-filter-name="tag_group[12521]" data-filter-value="21614" data-chose-name="蓬塔阿雷纳斯" class="u-radio" />蓬塔阿雷纳斯</li>
                </ul>
                <a class="toggle" role="button" data-type-filter-show-more="1" href="javascript:void(0);" style="display: none">更多</a>
              </dd>
            </dl>
            <dl class="row" data-view-group="relatedMdd" data-search-group="tag_group[12518]" style="display: none">
              <dt>邮轮航线：</dt>
              <dd class="clearfix">
                <ul class="filter-nav">
                  <li><input id="all_tag_group[12518]" type="checkbox" name="tag_group[12518][]" value="all" data-filter-list="1" data-filter-name="tag_group[12518]" data-filter-value="all" data-chose-name="不限" class="u-radio" checked />不限</li>
                  <li><input id="tag_group[12518]" type="checkbox" name="tag_group[12518][]" value="1514" data-filter-list="1" data-filter-name="tag_group[12518]" data-filter-value="1514" data-chose-name="极地" class="u-radio" />极地</li>
                </ul>
                <a class="toggle" role="button" data-type-filter-show-more="1" href="javascript:void(0);" style="display: none">更多</a>
              </dd>
            </dl>
            <dl class="row" data-view-group="relatedMdd" data-search-group="tag_group[12524]" style="display: none">
              <dt>邮轮名称：</dt>
              <dd class="clearfix">
                <ul class="filter-nav">
                  <li><input id="all_tag_group[12524]" type="checkbox" name="tag_group[12524][]" value="all" data-filter-list="1" data-filter-name="tag_group[12524]" data-filter-value="all" data-chose-name="不限" class="u-radio" checked />不限</li>
                  <li><input id="tag_group[12524]" type="checkbox" name="tag_group[12524][]" value="80333" data-filter-list="1" data-filter-name="tag_group[12524]" data-filter-value="80333" data-chose-name="麦哲伦探索号" class="u-radio" />麦哲伦探索号</li>
                </ul>
                <a class="toggle" role="button" data-type-filter-show-more="1" href="javascript:void(0);" style="display: none">更多</a>
              </dd>
            </dl>
          </div>
          <div class="filter-toggle" style="" data-show-more="1">
            <a href="javascript:void(0);"
              ><span>显示更多选项<i class="icon-arrDown"></i></span
            ></a>
          </div>
          <div class="filter-toggle" style="display: none" data-hide-hide="1">
            <a href="javascript:void(0);"
              ><span>收起<i class="icon-arrUp"></i></span
            ></a>
          </div>
        </div>
      </form>
      <!----filter end----->
      <dl class="row-selected clearfix" data-stick="1" style="display: none">
        <dt>您已选择：</dt>
        <dd id="chose"></dd>
        <a class="clean" data-clear-all-chose="1" href="javascript:void(0);">全部清除</a>
      </dl>

      <div class="sales-content">
        <div class="sort-bar">
          <ul>
            <li class="sort-item">
              <a class="active" data-sort="smart" data-sort-type="desc" data-sort-active="smart" href="javascript:void(0);">综合排序</a>
            </li>
            <li class="sort-item">
              <a data-sort="sold_num" data-sort-type="desc" data-sort-active="sold_num" href="javascript:void(0);">近期销量优先</a>
            </li>
            <li class="sort-item sort-price">
              <div class="price-trigger">
                <a href="javascript:void(0);" data-sort-active="price">价格<i></i></a>
              </div>
              <ul class="drop-list hide">
                <li><a data-sort="price" data-sort-type="asc" href="javascript:void(0);">价格从低到高</a></li>
                <li><a data-sort="price" data-sort-type="desc" href="javascript:void(0);">价格从高到低</a></li>
              </ul>
            </li>
          </ul>
        </div>
        <div class="not-found" data-notfound="1">
          <i></i>
          <p>暂无此类自由行产品 再逛逛其他的～</p>
          <a href="javascript:void(0);" data-clear-all-chose="1">清空筛选条件</a>
        </div>
        <div class="m-recommend hide" data-notfound="2" style="display: block">
          <div class="hd">更多自由行产品供你选择</div>
          <ul class="sales-cards clearfix">
            <li class="item">
              <a href="/sales/5280180.html" target="_blank">
                <div class="image"><img src="https://sales.mafengwo.net/mfs/s17/M00/80/A7/CoUBXl--MVqAOcUUAASxCoQPc5Y62.jpeg?imageMogr2%2Fthumbnail%2F%21318x178r%2Fgravity%2FCenter%2Fcrop%2F%21318x178%2Fquality%2F100" height="178" width="318" /></div>
                <div class="caption">
                  <h3>热门酒店特惠活动-三亚湾皇冠假日酒店1-4晚套餐（自助早餐+VIP行政礼遇/下午茶+玩乐礼包+接送机+游艇出海+精美旅拍+自驾 三亚湾酒店）</h3>
                  <div class="clearfix">
                    <span class="price"><em>¥</em><strong>630</strong>起</span>
                  </div>
                </div>
              </a>
            </li>
            <li class="item">
              <a href="/sales/9660982.html" target="_blank">
                <div class="image"><img src="https://sales.mafengwo.net/img/5d/1f/58ccd4b34c12e00fb5e6e76413770fde.jpeg?imageMogr2%2Fthumbnail%2F%21318x178r%2Fgravity%2FCenter%2Fcrop%2F%21318x178%2Fquality%2F100" height="178" width="318" /></div>
                <div class="caption">
                  <h3>丽江玉湖全程骑马+轻徒步+干河坝野奢一日游【1人1马畅爽野骑+户外野奢露营午餐+下午茶】</h3>
                  <div class="clearfix">
                    <span class="price"><em>¥</em><strong>680</strong>起</span>
                  </div>
                </div>
              </a>
            </li>
            <li class="item">
              <a href="/sales/9404111.html" target="_blank">
                <div class="image"><img src="https://sales.mafengwo.net/img/eb/a6/938936c925275275ca1745a54d6dbf1b.jpeg?imageMogr2%2Fthumbnail%2F%21318x178r%2Fgravity%2FCenter%2Fcrop%2F%21318x178%2Fquality%2F100" height="178" width="318" /></div>
                <div class="caption">
                  <h3>重庆大圆祥私家博物馆探秘一日游（清代学霸的老宅·近30年的秘藏+含有机简餐+着汉服随心拍+卯榫文化解析+可选翰林山庄珍馐私房菜）</h3>
                  <div class="clearfix">
                    <span class="price"><em>¥</em><strong>168</strong>起</span>
                  </div>
                </div>
              </a>
            </li>
            <li class="item">
              <a href="/sales/9096643.html" target="_blank">
                <div class="image"><img src="https://sales.mafengwo.net/mfs/s18/M00/85/E7/CoUBYGDlR5mASC_0AAxpTlehoj437.jpeg?imageMogr2%2Fthumbnail%2F%21318x178r%2Fgravity%2FCenter%2Fcrop%2F%21318x178%2Fquality%2F100" height="178" width="318" /></div>
                <div class="caption">
                  <h3>【轻奢网红露营】游侠客 安吉露营2日游·含森林晚宴（星级营地标准+皮划艇SUP桨板无限畅玩+星空电影+石膏画拓印+甜蜜下午茶+网红秋千）</h3>
                  <div class="clearfix">
                    <span class="price"><em>¥</em><strong>899</strong>起</span>
                  </div>
                </div>
              </a>
            </li>
            <li class="item">
              <a href="/sales/9641790.html" target="_blank">
                <div class="image"><img src="https://sales.mafengwo.net/mfs/s16/M00/8C/6B/CoUBUmEw8BOAdt1kACBMAPQCcoM052.png?imageMogr2%2Fthumbnail%2F%21318x178r%2Fgravity%2FCenter%2Fcrop%2F%21318x178%2Fquality%2F100" height="178" width="318" /></div>
                <div class="caption">
                  <h3>私家定制团 / 云南5日深度定制游（畅玩玉龙雪山+印象丽江+打卡洱海网红拍照点+大理吉普车旅拍）</h3>
                  <div class="clearfix">
                    <span class="price"><em>¥</em><strong>1600</strong>起</span>
                  </div>
                </div>
              </a>
            </li>
            <li class="item">
              <a href="/sales/9074335.html" target="_blank">
                <div class="image"><img src="https://sales.mafengwo.net/img/b8/de/a100950869d3ac85d0c34f9d605e01b3.jpeg?imageMogr2%2Fthumbnail%2F%21318x178r%2Fgravity%2FCenter%2Fcrop%2F%21318x178%2Fquality%2F100" height="178" width="318" /></div>
                <div class="caption">
                  <h3>【天地·嵩山】河南原创线路·郑州始发·主题深度一日游·观星台+中岳庙+少林寺（精致12人团/禅意素斋/世界遗产）</h3>
                  <div class="clearfix">
                    <span class="price"><em>¥</em><strong>2690</strong>起</span>
                  </div>
                </div>
              </a>
            </li>
          </ul>
        </div>
        <div id="listContent" class="list-wrap" data-list="1" style="display: block"></div>
        <div id="list_pagination" align="right" class="m-pagination"></div>
      </div>
      <div class="sales-side">
        <div class="m-hotsale">
          <h3 class="hd">本周热卖</h3>
          <ul></ul>
        </div>

        <div id="visa_recommend" class="m-hotsale" style="display: none">
          <h3 class="hd">相关签证</h3>
          <ul>
            <li>
              <a href="/sales/.html" target="_blank">
                <span class="image"><img src="" height="70" width="100" /></span>
                <div title="" class="title"></div>
                <span class="price">￥</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts"></script>
<style lang="scss" scoped>
.page-container {
  .container {
    width: 1000px;
    margin: 0 auto;
    .brand-bar {
      height: 40px;
      padding: 15px 0;
      background: url(../../assets/images/brand-fh-bg.jpg) no-repeat;
      line-height: 40px;
      .bb-hd {
        float: left;
        width: 185px;
        .bb-title {
          float: left;
          font-size: 24px;
          color: #000;
          a {
            color: #333;
            text-decoration: none;
            i[class^='icon'] {
              float: left;
              margin: 2px 10px 0 0;
              width: 28px;
              height: 32px;
              background: url(../../assets/images//global-icon4.png) no-repeat 0 0;
            }
            i.icon-fh {
              background-position: -70px 0;
              overflow: hidden;
            }
          }
        }
        .search-panel {
          width: 660px;
          height: 30px;
          background-color: #192885;
          border-radius: 3px;
          padding: 5px;
          overflow: hidden;
          .depart {
            float: left;
            display: inline;
            position: static;
            z-index: 2;
            width: 115px;
            height: 30px;
            background-color: #fff;
            border-radius: 2px;
            margin: 0 28px 0 0;
            z-index: 5;
            .trigger {
              height: 30px;
              line-height: 30px;
              padding: 0 8px;
              font-size: 12px;
              color: #333;
              cursor: pointer;
              border: 0 none;
              margin: 0;
              position: relative;
              .i-arr {
                position: absolute;
                right: -22px;
                top: 12px;
                margin: 0;
                width: 16px;
                height: 4px;
                background: url(../../assets/images/global-icon4.png) no-repeat -70px -170px;
                overflow: hidden;
              }
              strong {
                margin-right: 5px;
                font-size: 16px;
                font-weight: normal;
              }
            }
            .depart-panel {
              position: absolute;
              margin-top: 14px;
              width: 344px;
              padding: 15px 20px;
              border: 1px solid #192885;
              background-color: #fff;
              font-size: 14px;
              line-height: 30px;
              display: none;
              border-radius: 3px;
              box-shadow: 0 0 3px rgb(255 157 0 / 80%);
              z-index: 20;
              .dp-hot {
                border-bottom: 1px solid #efefef;
                margin: 0 -20px 15px;
                padding: 0 20px 6px;
                p {
                  color: #999;
                }
                ul {
                  margin-right: -15px;
                  li {
                    float: left;
                    display: inline;
                    margin-right: 15px;
                    a {
                      color: #333;
                      &:hover {
                        color: #192885;
                      }
                    }
                  }
                }
              }
              .dp-search {
                margin-bottom: 20px;
                input {
                  width: 312px;
                  border: 1px px solid #dfdfdf;
                  border-radius: 2px;
                  height: 34px;
                  line-height: 34px;
                  padding: 0 15px;
                  color: #666;
                }
                p {
                  margin-top: 10px;
                  line-height: 14px;
                }
                ul {
                  margin-right: -15px;
                }
              }
              .letter-tab {
                margin: 5px 0;
                line-height: 20px;
                .letter-item {
                  margin: 0 -20px;
                  padding: 8px 20px 8px 50px;
                  border-bottom: 1px solid #efefef;
                  &.last-child {
                    border-bottom: 0 none;
                    padding-bottom: 0;
                  }
                  .letter {
                    float: left;
                    margin-left: -28px;
                    font-size: 18px;
                    font-weight: bold;
                    color: #192885;
                  }
                  ul {
                    margin-right: -15px;
                    li {
                      float: left;
                      display: inline;
                      margin-right: 15px;
                      a {
                        color: #333;
                      }
                    }
                  }
                }
              }
            }
          }
          .search-main {
            overflow: hidden;
            .search-input {
              float: left;
              width: 404px;
              height: 20px;
              overflow: hidden;
              line-height: 20px;
              border: 0 none;
              border-radius: 2px;
              padding: 5px 12px;
              font-size: 16px;
              -webkit-transition: border 0.2s ease-in 0s;
              transition: border 0.2s ease-in 0s;
              color: #333;
            }
            .search-button {
              float: left;
              width: 94px;
              height: 40px;
              background-color: #192885;
              text-align: center;
              border-radius: 0 4px 4px 0;
              margin: -5px -5px -5px 0;
              i {
                display: inline-block;
                margin-top: 8px;
                width: 23px;
                height: 23px;
                background: url(../../assets/images/global-icon4.png) no-repeat -70px -60px;
                overflow: hidden;
                vertical-align: top;
              }
            }
            .city-panel {
              position: absolute;
              margin-top: 14px;
              width: 440px;
              padding: 20px 25px;
              border: 1px solid #192885;
              background-color: #fff;
              font-size: 12px;
              line-height: 26px;
              display: none;
              border-radius: 3px;
              box-shadow: 0 0 3px rgb(255 157 0 / 80%);
              z-index: 20;
              h4 {
                margin-bottom: 5px;
                font-size: 14px;
                color: #192885;
                line-height: 16px;
              }
              ul + h4 {
                margin-top: 15px;
              }
              li {
                padding-left: 50px;
                .label {
                  float: left;
                  width: 50px;
                  margin-left: -50px;
                  font-weight: bold;
                  color: #333;
                }
                a {
                  display: inline-block;
                  color: #333;
                }
                .label ~ a {
                  margin-right: 12px;
                }
              }
            }
          }
        }
      }
    }
    .filter-panel {
      border: 1px solid #e5e5e5;
      margin-bottom: 12px;
      .filter-hd {
        border-bottom: 1px solid #e5e5e5;
        background-color: #f4f4f4;
        line-height: 39px;
        font-size: 14px;
        a {
          margin-top: -1px;
          height: 39px;
          float: left;
          padding: 3px 10px 0;
          color: #333;
          &:hover {
            outline: 0;
            text-decoration: underline;
          }
          &.cur {
            padding: 0 10px;
            border-top: 3px solid #192885;
            font-weight: bold;
            background-color: #fff;
            font-size: 16px;
            &:hover {
              text-decoration: none;
            }
          }
        }
      }
      .filter-bd {
        padding: 0 12px;
        .row {
          padding: 8px 0 8px 80px;
          line-height: 24px;
          dt {
            float: left;
            margin-left: -80px;
            display: inline;
          }
          .filter-nav {
            float: left;
            width: 850px;
            color: #333;
            overflow: hidden;
            li {
              float: left;
              display: inline;
              margin-right: 30px;
              cursor: pointer;
              .u-radio {
                float: left;
                width: 16px;
                height: 16px;
                border: 1px solid #e5e5e5;
                border-radius: 3px;
                margin: 3px 5px 0 0;
              }
            }
          }
          .toggle {
            float: right;
            padding-right: 8px;
            background-color: transparent;
            text-decoration: none;
            color: #192885;
            cursor: pointer;
          }
        }
      }
    }
    .sales-content {
      float: left;
      width: 700px;
      margin-bottom: 30px;
      .sort-bar .sort-item a,
      .sort-bar .price-trigger a,
      .sort-bar .trigger a {
        display: inline-block;
        border-bottom: 0;
        padding: 1px 20px;
        line-height: 42px;
        color: #333;
      }
      .sort-bar .price-trigger i,
      .sort-bar .trigger i {
        display: inline-block;
        margin-left: 5px;
        width: 9px;
        height: 5px;
        background: url(../../assets/images/sales-list-sprites7.png) no-repeat -30px -45px;
        overflow: hidden;
        vertical-align: middle;
      }
      .sort-bar {
        height: 43px;
        border-bottom: 1px solid #e9e9e9;
        .sort-item {
          float: left;
          .active {
            padding: 0 19px;
            background-color: #fff;
            border: 1px solid #e9e9e9;
            color: #192885;
            border-bottom-color: #fff;
          }
          a:hover {
            color: #192885;
            text-decoration: none;
          }
        }
        .drop-list {
          position: absolute;
          left: 0;
          z-index: 2;
          margin-top: -1px;
          width: 120px;
          border: 1px solid #e4e4e4;
          background-color: #fff;
          padding: 0 19px;
          line-height: 42px;
          a {
            padding: 0;
          }
        }
      }
      .not-found {
        padding: 65px 0;
        font-size: 20px;
        text-align: center;
        i {
          display: inline-block;
          width: 45px;
          height: 39px;
          background: url(../../assets/images/logo-gray.png) no-repeat;
          overflow: hidden;
        }
        p {
          margin: 15px 0;
        }
        a {
          display: inline-block;
          width: 150px;
          height: 40px;
          line-height: 40px;
          background-color: #192885;
          color: #fff;
          font-size: 14px;
          border-radius: 3px;
          &:hover {
            text-decoration: none;
            background-color: #ffa800;
          }
        }
      }
      .m-recommend {
        .hd {
          margin: 0 20px 20px;
          font-size: 18px;
          color: #333;
          border-bottom: 2px solid #e4e4e4;
          line-height: 40px;
        }
        .sales-cards {
          li {
            float: left;
            width: 320px;
            display: inline;
            margin: 0 0 20px 20px;
            a {
              display: block;
              height: 282px;
              border: 1px solid #e8e8e8;
              background-color: #fff;
              &:hover {
                text-decoration: none;
                background-color: #f8f8f8;
              }
              .image {
                height: 178px;
                overflow: hidden;
              }
              .caption {
                padding: 5px 12px;
                h3 {
                  height: 48px;
                  margin-bottom: 15px;
                  font-weight: normal;
                  font-size: 14px;
                  color: #000;
                  line-height: 24px;
                  overflow: hidden;
                }
                .price {
                  float: right;
                  font-size: 14px;
                  color: #666;
                  em {
                    font-style: normal;
                    font-size: 16px;
                    color: #192885;
                  }
                  strong {
                    font-weight: normal;
                    font-size: 22px;
                    color: #192885;
                  }
                }
              }
            }
          }
        }
      }
      .list-wrap {
        .item {
          display: block;
          padding: 20px 0;
          color: #666;
          &:hover {
            text-decoration: none;
            background-color: #f9f9f9;
            padding: 20px;
            margin: 0 -20px;
            h3 {
              text-decoration: underline;
            }
            .btn {
              background-color: #192885 !important;
              color: #fff !important;
            }
          }
          .image {
            float: left;
            display: inline;
            margin-right: 20px;
            width: 200px;
            height: 150px;
            overflow: hidden;
            position: relative;
            .mark-type {
              position: absolute;
              left: 0;
              top: 0;
              padding: 1px;
              line-height: 18px;
              font-size: 12px;
              &.type-10 {
                background-color: #12bcc4;
                color: #12bcc4;
              }
              strong {
                float: left;
                padding: 0 10px;
                color: #fff;
                font-weight: normal;
              }
              span {
                float: left;
                padding: 0 8px;
                background-color: #fff;
              }
            }
          }
          .detail {
            float: right;
            width: 480px;
            .info {
              height: 120px;
              overflow: hidden;
              p {
                line-height: 20px;
                .t {
                  margin-right: 20px;
                }
              }
              h3 {
                margin: 5px 0;
                font-weight: bold;
                font-size: 18px;
                color: #333;
                line-height: 24px;
                max-height: 48px;
                overflow: hidden;
              }
              .s-tag {
                margin-bottom: 5px;
                span {
                  display: inline-block;
                  border: 1px solid;
                  color: #3aaeff;
                  line-height: 14px;
                  padding: 0 3px;
                }
              }
            }
            .extra {
              height: 30px;
              line-height: 30px;
              font-size: 0;
              .action {
                float: right;
                width: 100px;
                height: 30px;
                position: relative;
                .btn {
                  display: inline-block;
                  width: 98px;
                  height: 28px;
                  border: 1px solid #192885;
                  text-align: center;
                  font-size: 16px;
                  border-radius: 2px;
                  color: #192885;
                  line-height: 28px;
                }
                .promo-tag {
                  position: absolute;
                  right: 0;
                  bottom: 35px;
                }
              }
              .price {
                margin-right: 5px;
                color: #192885;
                font-size: 14px;
                b {
                  font-size: 18px;
                }
                strong {
                  font-size: 28px;
                }
              }
              .promo-txt {
                display: inline-block;
                height: 16px;
                line-height: 16px;
                font-size: 12px;
                margin-right: 4px;
                em {
                  display: inline-block;
                  height: 16px;
                  margin-right: 5px;
                  font-style: normal;
                  background-color: #ff4b37;
                  color: #fff;
                  line-height: 16px;
                  padding: 0 2px;
                  position: relative;
                  top: -1px;
                }
              }
              .discount-tag {
                display: inline-block;
                height: 16px;
                padding: 0 4px;
                margin-right: 4px;
                font-size: 12px;
                line-height: 16px;
                color: #ff4a26;
                border: 1px solid #ff4a26;
                border-radius: 1px;
                box-sizing: border-box;
              }
            }
          }
        }
      }
      .m-pagination {
        padding: 20px 5px;
        line-height: 24px;
        text-align: right;
        font-size: 12px;
        color: #999;
        .pg-current {
          display: inline-block;
          margin-right: 5px;
          background-color: #192885;
          padding: 0 7px;
          border-radius: 4px;
          color: #fff;
          vertical-align: middle;
        }
        .pi {
          display: inline-block;
          margin-right: 1px;
          margin-left: 1px;
          padding: 0 7px;
          border: 0 none;
          background: 0;
          border-radius: 4px;
          color: #666;
          vertical-align: middle;
        }
        .pg-next {
          display: inline-block;
          margin-right: 5px;
          background-color: #192885;
          padding: 0 5px;
          border-radius: 4px;
          color: #fff;
          vertical-align: middle;
        }
      }
    }
    .sales-side {
      float: right;
      width: 260px;
      .m-hotsale {
        margin-bottom: 30px;
        .hd {
          margin-bottom: 18px;
          font-size: 18px;
          color: #333;
          font-weight: normal;
        }
        li {
          margin-bottom: 20px;
          a {
            display: block;
            padding-left: 110px;
            height: 70px;
            overflow: hidden;
            font-size: 14px;
            line-height: 20px;
            color: #333;
            .image {
              float: left;
              margin-left: -110px;
              width: 100px;
              height: 70px;
              overflow: hidden;
            }
            .title {
              height: 40px;
              margin-bottom: 12px;
            }
            .price {
              color: #192885;
            }
          }
        }
      }
    }
  }
  .hide {
    display: none;
  }
}
</style>
