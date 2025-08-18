package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.StrategyComment;
import cn.sixmm.sixsixsix.business.query.StrategyCommentQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 攻略评论Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IStrategyCommentService extends IService<StrategyComment>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<StrategyComment> queryPage(StrategyCommentQuery qo);

    void add(StrategyComment comment);

}
