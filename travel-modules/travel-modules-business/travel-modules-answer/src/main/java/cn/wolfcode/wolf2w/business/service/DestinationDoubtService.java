package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.dto.AnswerDTO;
import cn.wolfcode.wolf2w.business.api.domain.dto.QuestionCreateDTO;

public interface DestinationDoubtService {
  Long create(QuestionCreateDTO dto, Long userId);

  Long createAnswer(AnswerDTO dto, Long userId);
}
