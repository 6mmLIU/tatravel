package cn.wolfcode.wolf2w.business.api.domain.dto;

import lombok.Data;

@Data
public class AnswerDTO {
    private Long questionId;
    private String content;
}
