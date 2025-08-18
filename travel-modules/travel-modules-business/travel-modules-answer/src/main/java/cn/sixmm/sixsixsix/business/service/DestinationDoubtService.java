package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.dto.AnswerDTO;
import cn.sixmm.sixsixsix.business.api.domain.dto.QuestionCreateDTO;


public interface DestinationDoubtService {
  Long create(QuestionCreateDTO dto, Long userId);
  Long createAnswer(AnswerDTO dto, Long userId);

}
