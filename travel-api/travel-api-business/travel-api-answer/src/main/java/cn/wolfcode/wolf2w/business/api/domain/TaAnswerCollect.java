package cn.wolfcode.wolf2w.business.api.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.wolfcode.wolf2w.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * 问答-回答收藏关系对象 ta_answer_collect
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Data
@TableName("ta_answer_collect")
public class TaAnswerCollect implements Serializable {
    private static final long serialVersionUID = 1L;
    /** $column.columnComment */
    private Long answerId;

    /** $column.columnComment */
    private Long userId;
    private Date createTime;

}
