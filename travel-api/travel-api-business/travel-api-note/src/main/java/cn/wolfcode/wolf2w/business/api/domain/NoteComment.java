package cn.wolfcode.wolf2w.business.api.domain;

import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 游记评论对象 ta_note_comment
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_note_comment")
public class NoteComment implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 游记id
     */
    @Excel(name = "游记id")
    private Long noteId;

    /**
     * 游记标题
     */
    @Excel(name = "游记标题")
    private String noteTitle;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 评论内容
     */
    @Excel(name = "评论内容")
    private String content;

    /**
     * 评论类型
     */
    @Excel(name = "评论类型")
    private String type;

    /**
     * 评论状态
     */
    @Excel(name = "评论状态")
    private String status;

    /**
     * 关联id
     */
    @Excel(name = "关联id")
    private Long refId;

    private Date createTime;
    @TableField(exist = false)
    private UserInfo user;
    @TableField(exist = false)
    private NoteComment refComment;
}
