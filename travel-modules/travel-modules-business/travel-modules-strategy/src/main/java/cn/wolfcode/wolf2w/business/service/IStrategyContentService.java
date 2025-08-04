package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.StrategyContent;
import cn.wolfcode.wolf2w.business.query.StrategyContentQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 攻略内容Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IStrategyContentService extends IService<StrategyContent>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<StrategyContent> queryPage(StrategyContentQuery qo);
}
