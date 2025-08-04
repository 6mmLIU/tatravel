package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.StrategyTheme;
import cn.wolfcode.wolf2w.business.query.StrategyThemeQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 攻略主题Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IStrategyThemeService extends IService<StrategyTheme>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<StrategyTheme> queryPage(StrategyThemeQuery qo);
}
