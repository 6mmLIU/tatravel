package cn.sixmm.sixsixsix.business.api.domain.dto;

import lombok.Data;

@Data
public class QuestionCreateDTO {
    private String title;
    private String content;
    private Long destId;
    private Boolean draft;
}
