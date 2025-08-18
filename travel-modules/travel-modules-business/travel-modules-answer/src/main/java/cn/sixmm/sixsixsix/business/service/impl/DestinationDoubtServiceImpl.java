package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.domain.TaAnswer;
import cn.sixmm.sixsixsix.business.api.domain.dto.AnswerDTO;
import cn.sixmm.sixsixsix.business.api.domain.dto.QuestionCreateDTO;
import cn.sixmm.sixsixsix.business.service.DestinationDoubtService;
import cn.sixmm.sixsixsix.business.service.ITaAnswerService;
import cn.sixmm.sixsixsix.business.service.ITaQuestionService;
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
