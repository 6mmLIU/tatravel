package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswer;
import cn.wolfcode.wolf2w.business.api.domain.dto.AnswerDTO;
import cn.wolfcode.wolf2w.business.api.domain.dto.QuestionCreateDTO;
import cn.wolfcode.wolf2w.business.service.DestinationDoubtService;
import cn.wolfcode.wolf2w.business.service.ITaAnswerService;
import cn.wolfcode.wolf2w.business.service.ITaQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DestinationDoubtServiceImpl implements DestinationDoubtService {
    private final ITaQuestionService questionService;
    private final ITaAnswerService taAnswerService;

    @Override
    public Long create(QuestionCreateDTO dto, Long userId) {
        // 这里可以做：参数兜底、目的地/用户快照、风控等，然后委托
        return questionService.create(dto, userId);
    }

    @Override
    public Long createAnswer(AnswerDTO dto, Long userId) {
        TaAnswer answer = new TaAnswer();
        answer.setQuestionId(dto.getQuestionId());
        answer.setAuthorId(userId);
        answer.setContent(dto.getContent());
        answer.setLikeNum(0L);
        answer.setCollectNum(0L);
        answer.setCommentNum(0L);
        answer.setStatus(0L);
        answer.setCreateTime(new Date());
        answer.setUpdateTime(new Date());
        taAnswerService.save(answer);
        return answer.getId();
    }
}
