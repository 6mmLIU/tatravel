package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.TaQuestion;
import cn.sixmm.sixsixsix.business.api.domain.dto.QuestionCreateDTO;
import cn.sixmm.sixsixsix.business.query.TaQuestionQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 问答-问题Service接口
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
public interface ITaQuestionService extends IService<TaQuestion>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<TaQuestion> queryPage(TaQuestionQuery qo);

    Long create(QuestionCreateDTO dto, Long userId);
}
