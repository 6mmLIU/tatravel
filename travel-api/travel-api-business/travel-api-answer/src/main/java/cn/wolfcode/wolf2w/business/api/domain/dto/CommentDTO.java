package cn.wolfcode.wolf2w.business.api.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentDTO {
    /** 回答ID */
    @NotNull(message = "回答ID不能为空")
    private Long answerId;

    /** 评论内容 */
    @NotBlank(message = "评论内容不能为空")
    private String content;

    /** 父评论ID（用于回复评论） */
    private Long parentId;
}
