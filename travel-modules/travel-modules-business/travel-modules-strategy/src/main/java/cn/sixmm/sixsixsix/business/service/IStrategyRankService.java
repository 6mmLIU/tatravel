package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.StrategyRank;
import cn.sixmm.sixsixsix.business.query.StrategyRankQuery;
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
