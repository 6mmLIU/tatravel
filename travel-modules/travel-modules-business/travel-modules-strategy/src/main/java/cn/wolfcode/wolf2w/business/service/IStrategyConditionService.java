package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.StrategyCondition;
import cn.wolfcode.wolf2w.business.query.StrategyConditionQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 攻略条件Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IStrategyConditionService extends IService<StrategyCondition>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<StrategyCondition> queryPage(StrategyConditionQuery qo);

    List<StrategyCondition> queryConditionByType(long type);
}
