package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.TaAnswerCollect;
import cn.sixmm.sixsixsix.business.query.TaAnswerCollectQuery;
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
