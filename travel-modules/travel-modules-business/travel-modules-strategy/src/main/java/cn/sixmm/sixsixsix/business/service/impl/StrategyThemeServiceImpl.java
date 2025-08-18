package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.domain.StrategyTheme;
import cn.sixmm.sixsixsix.business.mapper.StrategyThemeMapper;
import cn.sixmm.sixsixsix.business.query.StrategyThemeQuery;
import cn.sixmm.sixsixsix.business.service.IStrategyThemeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 攻略主题Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class StrategyThemeServiceImpl extends ServiceImpl<StrategyThemeMapper,StrategyTheme> implements IStrategyThemeService {

    @Override
    public IPage<StrategyTheme> queryPage(StrategyThemeQuery qo) {
        IPage<StrategyTheme> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }
}
