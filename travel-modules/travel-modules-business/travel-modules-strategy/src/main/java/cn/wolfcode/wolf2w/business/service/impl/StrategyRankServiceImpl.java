package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.StrategyRank;
import cn.wolfcode.wolf2w.business.mapper.StrategyRankMapper;
import cn.wolfcode.wolf2w.business.query.StrategyRankQuery;
import cn.wolfcode.wolf2w.business.service.IStrategyRankService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 攻略排行Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class StrategyRankServiceImpl extends ServiceImpl<StrategyRankMapper,StrategyRank> implements IStrategyRankService {

    @Override
    public IPage<StrategyRank> queryPage(StrategyRankQuery qo) {
        IPage<StrategyRank> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    public List<StrategyRank> queryRankByPage(long type) {
        return query().eq("type",type)
                .inSql("statis_time","select MAX(statis_time) from ta_strategy_rank")
                .list();
    }
}
