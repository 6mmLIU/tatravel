package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import cn.wolfcode.wolf2w.business.query.StrategyQuery;
import cn.wolfcode.wolf2w.business.vo.CatalogVO;
import cn.wolfcode.wolf2w.business.vo.ThemeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 攻略Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IStrategyService extends IService<Strategy>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<Strategy> queryPage(StrategyQuery qo);

    List<CatalogVO> queryCatalogVO(Long destId);

    List<Strategy> queryViewnumTop3(Long destId);

    int saveStrategy(Strategy strategy);

    void statisRank();

    List<ThemeVO> queryTheme();

    void statisCondition();

    Map viewnumIncrease(Long sid);

    Map favor(Long sid, Long userId);


    Map thumbsup(Long sid, Long userId);

    boolean isUserFavor(Long uid, Long sid);

    Map replynumIncr(Long sid);

    void statisHashPersistence();
}
