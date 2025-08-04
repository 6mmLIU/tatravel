package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaQuestion;
import cn.wolfcode.wolf2w.business.api.domain.dto.QuestionCreateDTO;
import cn.wolfcode.wolf2w.business.mapper.TaQuestionMapper;
import cn.wolfcode.wolf2w.business.query.TaQuestionQuery;
import cn.wolfcode.wolf2w.business.service.ITaQuestionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 问答-问题Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Service
@Transactional
public class TaQuestionServiceImpl extends ServiceImpl<TaQuestionMapper, TaQuestion> implements ITaQuestionService {

    @Override
    public IPage<TaQuestion> queryPage(TaQuestionQuery qo) {
        IPage<TaQuestion> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    @Transactional
    public Long create(QuestionCreateDTO dto, Long userId) {
        TaQuestion q = new TaQuestion();
        q.setAuthorId(userId);
        q.setDestId(dto.getDestId());
        q.setTitle(dto.getTitle());
        q.setDetailDoubt(dto.getContent());

        q.setIsDraft(Boolean.TRUE.equals(dto.getDraft()) ? 1 : 0);
        q.setStatus(0);
        q.setViewNum(0L);
        q.setAnswerCount(0L);
        q.setAttentionCount(0L);
        q.setCreateTime(LocalDateTime.now());
        q.setUpdateTime(LocalDateTime.now());

        this.save(q);      // 或 baseMapper.insert(q)
        return q.getId();
    }
}
