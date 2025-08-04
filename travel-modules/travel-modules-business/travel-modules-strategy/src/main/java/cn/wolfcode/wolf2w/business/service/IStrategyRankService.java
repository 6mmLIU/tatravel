package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.StrategyRank;
import cn.wolfcode.wolf2w.business.query.StrategyRankQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 攻略排行Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IStrategyRankService extends IService<StrategyRank>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<StrategyRank> queryPage(StrategyRankQuery qo);

    List<StrategyRank> queryRankByPage(long type);
}
