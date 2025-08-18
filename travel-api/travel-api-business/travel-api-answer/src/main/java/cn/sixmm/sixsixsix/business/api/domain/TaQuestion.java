package cn.sixmm.sixsixsix.business.api.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("ta_question")
public class TaQuestion implements Serializable {
    // 主键策略按你选：AUTO(自增) 或 ASSIGN_ID(雪花)
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("dest_id")
    private Long destId;

    private String destName;

    @TableField("author_id")
    private Long authorId;

    private String authorName;
    private String headImgUrl;

    @TableField("title")
    private String title;

    @TableField("detail_doubt")
    private String detailDoubt;

    @TableField("is_draft")
    private Integer isDraft;       // 0/1

    private Long viewNum;
    private Long answerCount;
    private Long attentionCount;

    private Integer status;        // 0正常 1禁用 2删除

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    // ⚠ 删掉重复语义字段，避免再次被拼进 SQL
    // @TableField(exist = false) private Long userId;
    // @TableField(exist = false) private Integer state;
}
