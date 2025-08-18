package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.StrategyTheme;
import cn.sixmm.sixsixsix.business.query.StrategyThemeQuery;
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
