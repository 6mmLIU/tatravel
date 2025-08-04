package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswer;
import cn.wolfcode.wolf2w.business.query.TaAnswerQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 问答-回答Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
public interface ITaAnswerService extends IService<TaAnswer>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<TaAnswer> queryPage(TaAnswerQuery qo);
}
