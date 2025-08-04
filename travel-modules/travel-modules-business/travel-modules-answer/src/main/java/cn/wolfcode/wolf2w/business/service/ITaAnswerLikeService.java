package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswerLike;
import cn.wolfcode.wolf2w.business.query.TaAnswerLikeQuery;
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
