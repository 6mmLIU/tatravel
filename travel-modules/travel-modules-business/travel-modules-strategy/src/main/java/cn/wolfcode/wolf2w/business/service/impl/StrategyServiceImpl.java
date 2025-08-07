package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.RemoteDestinationService;
import cn.wolfcode.wolf2w.business.api.domain.*;
import cn.wolfcode.wolf2w.business.mapper.StrategyCatalogMapper;
import cn.wolfcode.wolf2w.business.mapper.StrategyContentMapper;
import cn.wolfcode.wolf2w.business.mapper.StrategyMapper;
import cn.wolfcode.wolf2w.business.mapper.StrategyThemeMapper;
import cn.wolfcode.wolf2w.business.query.StrategyQuery;
import cn.wolfcode.wolf2w.business.service.IStrategyConditionService;
import cn.wolfcode.wolf2w.business.service.IStrategyRankService;
import cn.wolfcode.wolf2w.business.service.IStrategyService;
import cn.wolfcode.wolf2w.business.util.DateUtil;
import cn.wolfcode.wolf2w.business.vo.CatalogVO;
import cn.wolfcode.wolf2w.business.vo.ThemeVO;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.rabbit.config.TravelRabbitConfig;
import cn.wolfcode.wolf2w.common.redis.service.RedisService;
import cn.wolfcode.wolf2w.common.redis.util.RedisKeys;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 攻略Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Slf4j
@Service
@Transactional
public class StrategyServiceImpl extends ServiceImpl<StrategyMapper, cn.wolfcode.wolf2w.business.api.domain.Strategy> implements IStrategyService {

    @Autowired
    private StrategyCatalogMapper strategyCatalogMapper;
    @Autowired
    private StrategyThemeMapper themeMapper;
    @Autowired
    private StrategyCatalogMapper catalogMapper;
    @Autowired
    private StrategyContentMapper contentMapper;
    @Autowired
    private RemoteDestinationService remoteDestinationService;
    @Autowired
    private IStrategyRankService strategyRankService;
    @Autowired
    private IStrategyConditionService strategyConditionService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private TravelRabbitConfig travelRabbitConfig;

    @Override
    public IPage<cn.wolfcode.wolf2w.business.api.domain.Strategy> queryPage(StrategyQuery qo) {
        IPage<cn.wolfcode.wolf2w.business.api.domain.Strategy> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        LambdaQueryWrapper<cn.wolfcode.wolf2w.business.api.domain.Strategy> qw = new LambdaQueryWrapper<>();
        if (qo.getType() != null) {
            if (qo.getType() == 1 || qo.getType() == 2) {
                qw.eq(cn.wolfcode.wolf2w.business.api.domain.Strategy::getDestId, qo.getRefid());
            } else if (qo.getType() == 3) {
                qw.eq(cn.wolfcode.wolf2w.business.api.domain.Strategy::getThemeId, qo.getRefid());
            }
        }
        return baseMapper.selectPage(page, qw);
    }

    @Override
    public List<CatalogVO> queryCatalogVO(Long destId) {
        LambdaQueryWrapper<cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog> qw = new LambdaQueryWrapper<>();
        qw.eq(cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog::getDestId, destId);
        List<cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog> list = strategyCatalogMapper.selectList(qw);
        List<CatalogVO> vos = new ArrayList<>();
        for (cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog strategyCatalog : list) {
            CatalogVO vo = new CatalogVO();
            vo.setId(strategyCatalog.getId());
            vo.setName(strategyCatalog.getName());
            List<cn.wolfcode.wolf2w.business.api.domain.Strategy> strategies = lambdaQuery()
                    .eq(cn.wolfcode.wolf2w.business.api.domain.Strategy::getCatalogId, strategyCatalog.getId())
                    .list();
            vo.setStrategies(strategies);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<cn.wolfcode.wolf2w.business.api.domain.Strategy> queryViewnumTop3(Long destId) {
        return lambdaQuery()
                .eq(cn.wolfcode.wolf2w.business.api.domain.Strategy::getDestId, destId)
                .orderByDesc(cn.wolfcode.wolf2w.business.api.domain.Strategy::getViewnum)
                .last("limit 3")
                .list();
    }

    @Override
    public int saveStrategy(cn.wolfcode.wolf2w.business.api.domain.Strategy strategy) {
        cn.wolfcode.wolf2w.business.api.domain.StrategyTheme theme = themeMapper.selectById(strategy.getThemeId());
        strategy.setThemeName(theme.getName());

        cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog catalog = catalogMapper.selectById(strategy.getCatalogId());
        strategy.setCatalogName(catalog.getName());
        strategy.setDestId(catalog.getDestId());
        strategy.setDestName(catalog.getDestName());
        strategy.setCreateTime(new Date());

        // TODO feign调用，判断国内/国外
        R<Long> ret = remoteDestinationService.isAbroad(catalog.getDestId(), SecurityConstants.INNER);
        strategy.setIsabroad(0L);
        strategy.setViewnum(0L);
        strategy.setFavornum(0L);
        strategy.setSharenum(0L);
        strategy.setReplynum(0L);
        strategy.setThumbsupnum(0L);

        baseMapper.insert(strategy);

        Long id = strategy.getId();
        String strategyContent = strategy.getContent().getContent();
        StrategyContent content = new StrategyContent();
        content.setId(id);
        content.setContent(strategyContent);
        String message = JSON.toJSONString(strategy);
        amqpTemplate.convertAndSend(TravelRabbitConfig.STRATEGY_EXCHANGE_NAME, TravelRabbitConfig.STRATEGY_ROUTING_KEY, message);
        int insert=contentMapper.insert(content);
        return insert;

        //发送消息到队列,消息内容就是攻略对象
    }


    @Override
    public void statisRank() {
        log.info(">>> StrategyServiceImpl.statisRank() 被调用了！");
        Date now = new Date();
        saveRank(now, 1);
        saveRank(now, 2);
        saveRank(now, 3);
        log.info("<<< statisRank 结束");
    }

    @Override
    public List<ThemeVO> queryTheme() {
        QueryWrapper<cn.wolfcode.wolf2w.business.api.domain.Strategy> qw = new QueryWrapper<>();
        qw.groupBy("theme_name");
        qw.select("theme_name themeName, GROUP_CONCAT(DISTINCT dest_id) ids, GROUP_CONCAT(DISTINCT dest_name) names");
        List<Map<String, Object>> list = baseMapper.selectMaps(qw);
        List<ThemeVO> vos = new ArrayList<>();
        for (Map<String, Object> map : list) {
            String themeName = (String) map.get("themeName");
            String ids = (String) map.get("ids");
            String names = (String) map.get("names");
            String[] idarr = ids.split(",");
            String[] namearr = names.split(",");
            List<Destination> dests = new ArrayList<>();
            for (int i = 0; i < idarr.length; i++) {
                Long id = Long.valueOf(idarr[i]);
                String name = namearr[i];
                Destination dest = new Destination();
                dest.setId(id);
                dest.setName(name);
                dests.add(dest);
            }
            ThemeVO vo = new ThemeVO(themeName, dests);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public void statisCondition() {
        Date now = new Date();
        List<StrategyCondition> conditionList = new ArrayList<>();
        QueryWrapper<cn.wolfcode.wolf2w.business.api.domain.Strategy> qw = new QueryWrapper<>();

        // 国外
        qw.eq("isabroad", 1)
                .groupBy("dest_id", "dest_name")
                .select("dest_id AS id", "dest_name AS name", "COUNT(1) AS count");
        List<Map<String, Object>> abroadList = baseMapper.selectMaps(qw);

        // 国内
        qw.clear();
        qw.eq("isabroad", 0)
                .groupBy("dest_id", "dest_name")
                .select("dest_id AS id", "dest_name AS name", "COUNT(1) AS count");
        List<Map<String, Object>> chinaList = baseMapper.selectMaps(qw);

        // 主题
        qw.clear();
        qw.groupBy("theme_id", "theme_name")
                .select("theme_id AS id", "theme_name AS name", "COUNT(1) AS count");
        List<Map<String, Object>> themeList = baseMapper.selectMaps(qw);

        addToConditionList(abroadList, now, conditionList, 1L);
        addToConditionList(chinaList, now, conditionList, 2L);
        addToConditionList(themeList, now, conditionList, 3L);

        strategyConditionService.saveBatch(conditionList);
    }

    @Override
    public Map viewnumIncrease(Long sid) {
        String key = strategyHashInit(sid);
        //如果有,不需要做任何事
        //阅读量+1
        redisService.incrementCacheMapValue(key, "viewnum", 1);
        //到redis中查询key对应的value并返回
        return redisService.getCacheMap(key);
    }

    @Override
    public Map favor(Long sid, Long userId) {
        String key = RedisKeys.STRATEGY_USER_FAVOR.join(userId.toString());
        if (!redisService.hasKey(key)) {
            Set<Long> sids = new HashSet<>();
            sids.add(-1l);
            redisService.setCacheSet(key, sids);
        }
        String hashKey = RedisKeys.STRATEGY_STATUS_HASH.join(sid.toString());
        boolean result = false;
        if (redisService.isCacheSetContains(key, sid)) {
            //已经收藏
            //收藏数-1
            redisService.incrementCacheMapValue(hashKey, "favornum", -1);
            //从集合中移除收藏标志
            redisService.deleteCacheSetValue(key, sid);
        } else {
            //未收藏
            //收藏数+1
            redisService.incrementCacheMapValue(hashKey, "favornum", +1);
            //在集合中加入收藏标志
            redisService.addCacheSetValue(key, sid);
            result = true;
        }
        Map<String, Object> cacheMap = redisService.getCacheMap(hashKey);
        cacheMap.put("result", result);
        return cacheMap;
    }

    @Override
    public Map thumbsup(Long sid, Long userId) {
        String key = RedisKeys.STRATEGY_USER_THUMBSUP.join(sid.toString(), userId.toString());
        if (!redisService.hasKey(key)) {
            Date now = new Date();
            Date endDate = DateUtil.getEndDate(now);
            long time = DateUtil.getDateBetween(now, endDate);
            redisService.setCacheObject(key, 0, time == 0 ? 2 : time, TimeUnit.SECONDS);
        }
        Long ret = redisService.incrementCacheObjectValue(key, 1);
        String hashkey = RedisKeys.STRATEGY_STATUS_HASH.join(sid.toString());
        //要求每天能点5个赞
        if (ret > 5) {
            //点赞失败
            Map<String, Object> cacheMap = redisService.getCacheMap(hashkey);
            cacheMap.put("result", false);
            return cacheMap;
        } else {
            //点赞成功
            redisService.incrementCacheMapValue(hashkey, "thumbsupnum", 1);
            Map<String, Object> cacheMap = redisService.getCacheMap(hashkey);
            cacheMap.put("result", true);
            return cacheMap;
        }
    }

    @Override
    public boolean isUserFavor(Long uid, Long sid) {
        String key = RedisKeys.STRATEGY_USER_FAVOR.join(uid.toString());
        return redisService.isCacheSetContains(key, sid);
    }

    @Override
    public Map replynumIncr(Long sid) {
        String key = strategyHashInit(sid);
        redisService.incrementCacheMapValue(key, "replynum", 1);
        return redisService.getCacheMap(key);
    }

    @Override
    public void statisHashPersistence() {
        //查询redis中所有的统计数据(前缀为strate_statis_hash的参数)
        String strategyStatusKey = RedisKeys.STRATEGY_STATUS_HASH.join("*");
        Collection<String> keys = redisService.keys(strategyStatusKey);
        //将查找到的统计数据更新到攻略表中
        if (keys != null && keys.size() > 0) {
            for (String key : keys) {
                Map<String, Object> cacheMap = redisService.getCacheMap(key);
                lambdaUpdate().eq(Strategy::getId, cacheMap.get("id"))
                        .set(Strategy::getReplynum, cacheMap.get("replynum"))
                        .set(Strategy::getViewnum, cacheMap.get("viewnum"))
                        .set(Strategy::getFavornum, cacheMap.get("favornum"))
                        .set(Strategy::getSharenum, cacheMap.get("sharenum"))
                        .set(Strategy::getThumbsupnum, cacheMap.get("thumbsupnum"))
                        .update();
            }
        }

    }

    private String strategyHashInit(Long sid) {
        //拼接key
        String key = RedisKeys.STRATEGY_STATUS_HASH.join(sid.toString());
        //判断redis中是否有这个key,如果没有,创建value,将key-value存储到redis
        if (!redisService.hasKey(key)) {
            //到mysql中查询当前sid对应的攻略数据,得到统计数字
            Strategy strategy = baseMapper.selectById(sid);
            Map map = new HashMap();
            map.put("id", strategy.getId());
            map.put("viewnum", Integer.valueOf(strategy.getViewnum().toString()));
            map.put("replynum", Integer.valueOf(strategy.getReplynum().toString()));
            map.put("favornum", Integer.valueOf(strategy.getFavornum().toString()));
            map.put("sharenum", Integer.valueOf(strategy.getSharenum().toString()));
            map.put("thumbsupnum", Integer.valueOf(strategy.getThumbsupnum().toString()));
            redisService.setCacheMap(key, map);
        }
        return key;
    }

    private static void addToConditionList(List<Map<String, Object>> list,
                                           Date now,
                                           List<StrategyCondition> conditionList,
                                           long type) {
        for (Map<String, Object> map : list) {
            Number idNum = (Number) map.get("id");
            Number cntNum = (Number) map.get("count");
            String nameStr = (String) map.get("name");

            long refid = idNum == null ? 0L : idNum.longValue();
            long count = cntNum == null ? 0L : cntNum.longValue();

            StrategyCondition condition = new StrategyCondition();
            condition.setRefid(refid);
            condition.setType(type);
            condition.setName(nameStr);
            condition.setCount(count);
            condition.setStatisTime(now);
            conditionList.add(condition);
        }
    }

    /**
     * 统计排行榜
     * <p>
     * type 含义请按你业务自己决定（下面按照你实体注释：1国外 2国内 3热门）
     */
    private void saveRank(Date now, long type) {
        List<cn.wolfcode.wolf2w.business.api.domain.Strategy> list;
        if (type == 1) {
            list = lambdaQuery().eq(cn.wolfcode.wolf2w.business.api.domain.Strategy::getIsabroad, 1)
                    .orderByDesc(cn.wolfcode.wolf2w.business.api.domain.Strategy::getViewnum)
                    .last("limit 10").list();
        } else if (type == 2) {
            list = lambdaQuery().eq(cn.wolfcode.wolf2w.business.api.domain.Strategy::getIsabroad, 0)
                    .orderByDesc(cn.wolfcode.wolf2w.business.api.domain.Strategy::getViewnum)
                    .last("limit 10").list();
        } else {
            list = lambdaQuery().orderByDesc(cn.wolfcode.wolf2w.business.api.domain.Strategy::getViewnum)
                    .last("limit 10").list();
        }

        if (list == null || list.isEmpty()) {
            log.warn("type={} 没有统计数据，跳过插入", type);
            return;
        }

        List<StrategyRank> ranks = list.stream().map(strategy -> {
            StrategyRank rank = new StrategyRank();
            rank.setStrategyId(strategy.getId());
            rank.setStrategyTitle(strategy.getTitle());
            rank.setDestId(strategy.getDestId());
            rank.setDestName(strategy.getDestName());
            rank.setType(type);
            rank.setStatisnum(strategy.getViewnum());
            rank.setStatisTime(now);
            return rank;
        }).collect(Collectors.toList());

        log.info("type={} listSize={} readyToInsert={}", type, list.size(), ranks.size());
        strategyRankService.saveBatch(ranks);
    }
}
