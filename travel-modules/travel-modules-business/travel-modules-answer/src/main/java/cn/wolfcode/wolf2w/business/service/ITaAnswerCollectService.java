package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswerCollect;
import cn.wolfcode.wolf2w.business.query.TaAnswerCollectQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 问答-回答收藏关系Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
public interface ITaAnswerCollectService extends IService<TaAnswerCollect>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<TaAnswerCollect> queryPage(TaAnswerCollectQuery qo);
}
