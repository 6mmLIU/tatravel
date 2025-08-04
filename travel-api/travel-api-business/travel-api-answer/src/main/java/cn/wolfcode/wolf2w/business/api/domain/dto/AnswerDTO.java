package cn.wolfcode.wolf2w.business.api.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * DTO for answer creation or update.
 */
@Data
public class AnswerDTO {
    /** Question identifier. */
    @NotNull(message = "问题ID不能为空")
    private Long questionId;

    /** Answer content. */
    @NotBlank(message = "内容不能为空")
    private String content;

    /** Whether the answer is a draft. */
    private Boolean draft;
}
