package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.Region;
import cn.sixmm.sixsixsix.business.query.RegionQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区域Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
public interface IRegionService extends IService<Region>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<Region> queryPage(RegionQuery qo);

    List<Region> queryRegion(Long ishot);
}
