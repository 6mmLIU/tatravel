package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.Banner;
import cn.wolfcode.wolf2w.business.mapper.BannerMapper;
import cn.wolfcode.wolf2w.business.query.BannerQuery;
import cn.wolfcode.wolf2w.business.service.IBannerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文章推荐Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Override
    public IPage<Banner> queryPage(BannerQuery qo) {
        IPage<Banner> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    public List<Banner> queryByType(int i) {
        return lambdaQuery().eq(Banner::getType, i)
                .orderByAsc(Banner::getSeq)
                .list();
    }
}
