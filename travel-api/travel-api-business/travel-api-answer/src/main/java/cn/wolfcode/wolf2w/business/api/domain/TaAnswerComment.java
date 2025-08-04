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
 * 问答-回答评论对象 ta_answer_comment
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Data
@TableName("ta_answer_comment")
public class TaAnswerComment implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * $column.columnComment
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long answerId;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    /**
     * 父评论id(二级评论)
     */
    @Excel(name = "父评论id(二级评论)")
    private Long parentId;

    /**
     * 0正常 1删除/隐藏
     */
    @Excel(name = "0正常 1删除/隐藏")
    private Long status;
    private Date createTime;

}
