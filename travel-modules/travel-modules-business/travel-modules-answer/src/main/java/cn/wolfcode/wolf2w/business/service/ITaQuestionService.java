package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.TaQuestion;
import cn.wolfcode.wolf2w.business.api.domain.dto.QuestionCreateDTO;
import cn.wolfcode.wolf2w.business.query.TaQuestionQuery;
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
