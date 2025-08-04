package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.StrategyTheme;
import cn.wolfcode.wolf2w.business.mapper.StrategyThemeMapper;
import cn.wolfcode.wolf2w.business.query.StrategyThemeQuery;
import cn.wolfcode.wolf2w.business.service.IStrategyThemeService;
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
