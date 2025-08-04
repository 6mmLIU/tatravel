package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswerComment;
import cn.wolfcode.wolf2w.business.query.TaAnswerCommentQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 问答-回答评论Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
public interface ITaAnswerCommentService extends IService<TaAnswerComment>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<TaAnswerComment> queryPage(TaAnswerCommentQuery qo);
}
