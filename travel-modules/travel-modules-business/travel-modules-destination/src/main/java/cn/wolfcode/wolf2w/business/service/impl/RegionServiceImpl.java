package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.Region;
import cn.wolfcode.wolf2w.business.mapper.RegionMapper;
import cn.wolfcode.wolf2w.business.query.RegionQuery;
import cn.wolfcode.wolf2w.business.service.IRegionService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区域Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class RegionServiceImpl extends ServiceImpl<RegionMapper,Region> implements IRegionService {

    @Override
    public IPage<Region> queryPage(RegionQuery qo) {
        IPage<Region> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    public List<Region> queryRegion(Long ishot) {

        return lambdaQuery().eq(Region::getIshot,ishot).orderByAsc(Region::getSeq).list();
    }
}
