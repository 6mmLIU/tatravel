package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.Banner;
import cn.wolfcode.wolf2w.business.query.BannerQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 文章推荐Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IBannerService extends IService<Banner>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<Banner> queryPage(BannerQuery qo);

    List<Banner> queryByType(int i);
}
