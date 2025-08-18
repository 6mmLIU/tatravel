package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.TaQuestionAttention;
import cn.sixmm.sixsixsix.business.query.TaQuestionAttentionQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 问答-问题关注关系Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
public interface ITaQuestionAttentionService extends IService<TaQuestionAttention>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<TaQuestionAttention> queryPage(TaQuestionAttentionQuery qo);
}
