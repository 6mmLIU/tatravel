package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaQuestion;
import cn.wolfcode.wolf2w.business.api.domain.dto.QuestionCreateDTO;
import cn.wolfcode.wolf2w.business.service.DestinationDoubtService;
import cn.wolfcode.wolf2w.business.service.ITaQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DestinationDoubtServiceImpl implements DestinationDoubtService {
    private final ITaQuestionService questionService;

    @Override
    public Long create(QuestionCreateDTO dto, Long userId) {
        // 这里可以做：参数兜底、目的地/用户快照、风控等，然后委托
        return questionService.create(dto, userId);
    }
}
