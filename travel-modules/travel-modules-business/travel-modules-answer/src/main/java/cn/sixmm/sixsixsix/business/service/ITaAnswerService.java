package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.TaAnswer;
import cn.sixmm.sixsixsix.business.api.domain.dto.AnswerDTO;
import cn.sixmm.sixsixsix.business.query.TaAnswerQuery;
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

    Long create(AnswerDTO dto, Long userId);
}
