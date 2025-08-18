package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.TaAnswerLike;
import cn.sixmm.sixsixsix.business.query.TaAnswerLikeQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 问答-回答点赞Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
public interface ITaAnswerLikeService extends IService<TaAnswerLike>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<TaAnswerLike> queryPage(TaAnswerLikeQuery qo);
}
