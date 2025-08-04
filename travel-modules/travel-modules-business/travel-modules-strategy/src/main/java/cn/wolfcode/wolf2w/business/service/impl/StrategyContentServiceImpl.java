package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.StrategyContent;
import cn.wolfcode.wolf2w.business.mapper.StrategyContentMapper;
import cn.wolfcode.wolf2w.business.query.StrategyContentQuery;
import cn.wolfcode.wolf2w.business.service.IStrategyContentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 攻略内容Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class StrategyContentServiceImpl extends ServiceImpl<StrategyContentMapper,StrategyContent> implements IStrategyContentService {

    @Override
    public IPage<StrategyContent> queryPage(StrategyContentQuery qo) {
        IPage<StrategyContent> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }
}
